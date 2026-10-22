package com.android.server.backup.fullbackup;

import android.app.backup.IFullBackupRestoreObserver;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.AppWidgetBackupBridge;
import com.android.server.backup.BackupManagerService;
import com.android.server.backup.BackupPasswordManager;
import com.android.server.backup.BackupRestoreTask;
import com.android.server.backup.KeyValueAdbBackupEngine;
import com.android.server.backup.OperationStorage;
import com.android.server.backup.UserBackupManagerService;
import com.android.server.backup.utils.BackupEligibilityRules;
import com.android.server.backup.utils.BackupManagerMonitorEventSender;
import com.android.server.backup.utils.PasswordUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.compress.utils.CharsetNames;

/* JADX INFO: loaded from: classes.dex */
public class PerformAdbBackupTask extends FullBackupTask implements BackupRestoreTask {
    private final boolean mAllApps;
    private final BackupEligibilityRules mBackupEligibilityRules;
    private final boolean mCompress;
    private final int mCurrentOpToken;
    private final String mCurrentPassword;
    private PackageInfo mCurrentTarget;
    private final boolean mDoWidgets;
    private final String mEncryptPassword;
    private final boolean mIncludeApks;
    private final boolean mIncludeObbs;
    private final boolean mIncludeShared;
    private final boolean mIncludeSystem;
    private final boolean mKeyValue;
    private final AtomicBoolean mLatch;
    private final OperationStorage mOperationStorage;
    private final ParcelFileDescriptor mOutputFile;
    private final ArrayList<String> mPackages;
    private final UserBackupManagerService mUserBackupManagerService;

    public PerformAdbBackupTask(UserBackupManagerService backupManagerService, OperationStorage operationStorage, ParcelFileDescriptor fd, IFullBackupRestoreObserver observer, boolean includeApks, boolean includeObbs, boolean includeShared, boolean doWidgets, String curPassword, String encryptPassword, boolean doAllApps, boolean doSystem, boolean doCompress, boolean doKeyValue, String[] packages, AtomicBoolean latch, BackupEligibilityRules backupEligibilityRules) {
        super(observer);
        this.mUserBackupManagerService = backupManagerService;
        this.mOperationStorage = operationStorage;
        this.mCurrentOpToken = backupManagerService.generateRandomIntegerToken();
        this.mLatch = latch;
        this.mOutputFile = fd;
        this.mIncludeApks = includeApks;
        this.mIncludeObbs = includeObbs;
        this.mIncludeShared = includeShared;
        this.mDoWidgets = doWidgets;
        this.mAllApps = doAllApps;
        this.mIncludeSystem = doSystem;
        if (packages != null) goto L5;
        ArrayList<String> r14 = new ArrayList();
    L6:
        this.mPackages = r14;
        this.mCurrentPassword = curPassword;
        if (encryptPassword != null) goto L9;
    L12:
        this.mEncryptPassword = curPassword;
    L13:
        this.mCompress = doCompress;
        this.mKeyValue = doKeyValue;
        this.mBackupEligibilityRules = backupEligibilityRules;
        return;
    L9:
        if ("".equals(encryptPassword) == true) goto L12;
        this.mEncryptPassword = encryptPassword;
        goto L13
    L5:
        r14 = new ArrayList(Arrays.asList(packages));
        goto L6
    }

    private void addPackagesToSet(TreeMap<String, PackageInfo> set, List<String> pkgNames) {
        Iterator<String> r0 = pkgNames.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        String pkgName = r0.next();
        if (set.containsKey(pkgName) == true) goto L4;
        PackageInfo info = this.mUserBackupManagerService.getPackageManager().getPackageInfo(pkgName, 134217728);     // Catch: PackageManager.NameNotFoundException -> L9
        set.put(pkgName, info);     // Catch: PackageManager.NameNotFoundException -> L9
    L10:
        Slog.w(BackupManagerService.TAG, "Unknown package " + pkgName + ", skipping");
        goto L4
    }

    private OutputStream emitAesBackupHeader(StringBuilder headerbuf, OutputStream ofstream) throws Exception {
        byte[] newUserSalt = this.mUserBackupManagerService.randomBytes(512);
        SecretKey userKey = PasswordUtils.buildPasswordKey(BackupPasswordManager.PBKDF_CURRENT, this.mEncryptPassword, newUserSalt, 10000);
        byte[] encryptionKey = new byte[32];
        this.mUserBackupManagerService.getRng().nextBytes(encryptionKey);
        byte[] checksumSalt = this.mUserBackupManagerService.randomBytes(512);
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec encryptionKeySpec = new SecretKeySpec(encryptionKey, "AES");
        c.init(1, encryptionKeySpec);
        OutputStream finalOutput = new CipherOutputStream(ofstream, c);
        headerbuf.append(PasswordUtils.ENCRYPTION_ALGORITHM_NAME);
        headerbuf.append('\n');
        headerbuf.append(PasswordUtils.byteArrayToHex(newUserSalt));
        headerbuf.append('\n');
        headerbuf.append(PasswordUtils.byteArrayToHex(checksumSalt));
        headerbuf.append('\n');
        headerbuf.append(10000);
        headerbuf.append('\n');
        Cipher mkC = Cipher.getInstance("AES/CBC/PKCS5Padding");
        mkC.init(1, userKey);
        headerbuf.append(PasswordUtils.byteArrayToHex(mkC.getIV()));
        headerbuf.append('\n');
        byte[] IV = c.getIV();
        byte[] mk = encryptionKeySpec.getEncoded();
        byte[] checksum = PasswordUtils.makeKeyChecksum(BackupPasswordManager.PBKDF_CURRENT, encryptionKeySpec.getEncoded(), checksumSalt, 10000);
        ByteArrayOutputStream blob = new ByteArrayOutputStream(((IV.length + mk.length) + checksum.length) + 3);
        DataOutputStream mkOut = new DataOutputStream(blob);
        mkOut.writeByte(IV.length);
        mkOut.write(IV);
        mkOut.writeByte(mk.length);
        mkOut.write(mk);
        mkOut.writeByte(checksum.length);
        mkOut.write(checksum);
        mkOut.flush();
        byte[] encryptedMk = mkC.doFinal(blob.toByteArray());
        headerbuf.append(PasswordUtils.byteArrayToHex(encryptedMk));
        headerbuf.append('\n');
        return finalOutput;
    }

    private void finalizeBackup(OutputStream out) {
        byte[] eof = new byte[1024];     // Catch: IOException -> L5
        out.write(eof);     // Catch: IOException -> L5
        return;
    L6:
        Slog.w(BackupManagerService.TAG, "Error attempting to finalize backup stream");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        if (this.mKeyValue == false) goto L5;
        String r0 = ", including key-value backups";
    L6:
        String r13 = r0;
        Slog.i(BackupManagerService.TAG, "--- Performing adb backup" + r13 + " ---");
        TreeMap<String, PackageInfo> r1 = new TreeMap();
        FullBackupObbConnection r2 = new FullBackupObbConnection(this.mUserBackupManagerService);
        r2.establish();
        sendStartBackup();
        PackageManager r3 = this.mUserBackupManagerService.getPackageManager();
        boolean r14 = true;
        if (this.mAllApps == false) goto L18;
        List<PackageInfo> r4 = r3.getInstalledPackages(134217728);
        int r5 = 0;
    L10:
        if (r5 >= r4.size()) goto L18;
        PackageInfo r6 = r4.get(r5);
        if (this.mIncludeSystem == false) goto L14;
    L15:
        r1.put(r6.packageName, r6);
    L16:
        r5 = r5 + 1;
        goto L10
    L14:
        if ((r6.applicationInfo.flags & 1) != 0) goto L16;
    L18:
        if (this.mDoWidgets == false) goto L23;
        List<String> r7 = AppWidgetBackupBridge.getWidgetParticipants(0);
        if (r7 == null) goto L23;
        addPackagesToSet(r1, r7);
    L23:
        if (this.mPackages == null) goto L25;
        addPackagesToSet(r1, this.mPackages);
    L25:
        ArrayList r8 = new ArrayList();
        Iterator<Map.Entry<String, PackageInfo>> r16 = r1.entrySet().iterator();
    L27:
        if (r16.hasNext() == false) goto L38;
        PackageInfo r9 = r16.next().getValue();
        if (this.mBackupEligibilityRules.appIsEligibleForBackup(r9.applicationInfo) == false) goto L36;
        if (this.mBackupEligibilityRules.appIsStopped(r9.applicationInfo) == true) goto L36;
        if (this.mBackupEligibilityRules.appIsKeyValueOnly(r9) == false) goto L27;
        r16.remove();
        Slog.i(BackupManagerService.TAG, "Package " + r9.packageName + " is key-value.");
        r8.add(r9);
    L36:
        r16.remove();
        Slog.i(BackupManagerService.TAG, "Package " + r9.packageName + " is not eligible for backup, removing.");
        goto L27
    L38:
        ArrayList r10 = new ArrayList(r1.values());
        FileOutputStream r11 = new FileOutputStream(this.mOutputFile.getFileDescriptor());
        OutputStream r12 = null;
    L232:
        th = move-exception;
        Throwable r15 = th;
        boolean r17 = r13;
    L277:
        if (r12 != null) goto L321;
    L281:
        this.mOutputFile.close();     // Catch: IOException -> L279
    L284:
        AtomicBoolean r18 = this.mLatch;
        monitor-enter(r18);
        this.mLatch.set(r17);     // Catch: Throwable -> L290
        this.mLatch.notifyAll();     // Catch: Throwable -> L290
        monitor-exit(r18);     // Catch: Throwable -> L290
        sendEndBackup();
        r2.tearDown();
        Slog.d(BackupManagerService.TAG, "Full backup pass complete.");
        this.mUserBackupManagerService.getWakeLock().release();
        throw r15;
    L290:
        th = move-exception;
        throw th;
    L279:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, "IO error closing adb backup file: " + e.getMessage());
        goto L284
    L321:
        r12.flush();     // Catch: IOException -> L279
        r12.close();     // Catch: IOException -> L279
    L210:
        th = move-exception;
        r17 = 1;
        r15 = th;
    L238:
        e = e;
        r14 = true;
    L243:
        Slog.e(BackupManagerService.TAG, "Internal exception during full backup", e);     // Catch: Throwable -> L232
        if (r12 != null) goto L310;
    L248:
        this.mOutputFile.close();     // Catch: IOException -> L246
    L251:
        AtomicBoolean r19 = this.mLatch;
        monitor-enter(r19);
        this.mLatch.set(r14);     // Catch: Throwable -> L256
        this.mLatch.notifyAll();     // Catch: Throwable -> L256
        monitor-exit(r19);     // Catch: Throwable -> L256
    L255:
        sendEndBackup();
        r2.tearDown();
        Slog.d(BackupManagerService.TAG, "Full backup pass complete.");
        this.mUserBackupManagerService.getWakeLock().release();
        return;
    L256:
        th = move-exception;
        throw th;
    L246:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, "IO error closing adb backup file: " + e.getMessage());
        goto L251
    L310:
        r12.flush();     // Catch: IOException -> L246
        r12.close();     // Catch: IOException -> L246
        goto L248
    L40:
        if (this.mEncryptPassword != null) goto L297;
    L50:
        boolean r20 = false;
    L51:
        boolean r110 = r20;
        OutputStream r111 = r11;
        if (this.mUserBackupManagerService.backupPasswordMatches(this.mCurrentPassword) == true) goto L71;
        Slog.w(BackupManagerService.TAG, "Backup password mismatch; aborting");     // Catch: Throwable -> L44 Exception -> L46 RemoteException -> L48
        if (0 != 0) goto L295;
    L59:
        this.mOutputFile.close();     // Catch: IOException -> L57
    L62:
        AtomicBoolean r21 = this.mLatch;
        monitor-enter(r21);
        this.mLatch.set(true);     // Catch: Throwable -> L68
        this.mLatch.notifyAll();     // Catch: Throwable -> L68
        monitor-exit(r21);     // Catch: Throwable -> L68
        sendEndBackup();
        r2.tearDown();
        Slog.d(BackupManagerService.TAG, "Full backup pass complete.");
        this.mUserBackupManagerService.getWakeLock().release();
        return;
    L68:
        th = move-exception;
        throw th;
    L57:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, "IO error closing adb backup file: " + e.getMessage());
        goto L62
    L295:
        r12.flush();     // Catch: IOException -> L57
        r12.close();     // Catch: IOException -> L57
        goto L59
    L46:
        e = e;
        r14 = true;
    L49:
        r14 = true;
    L260:
        Slog.e(BackupManagerService.TAG, "App died during full backup");     // Catch: Throwable -> L232
        if (r12 != null) goto L302;
    L265:
        this.mOutputFile.close();     // Catch: IOException -> L263
    L268:
        AtomicBoolean r22 = this.mLatch;
        monitor-enter(r22);
        this.mLatch.set(r14);     // Catch: Throwable -> L274
        this.mLatch.notifyAll();     // Catch: Throwable -> L274
        monitor-exit(r22);     // Catch: Throwable -> L274
    L274:
        th = move-exception;
        throw th;
    L263:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, "IO error closing adb backup file: " + e.getMessage());
        goto L268
    L302:
        r12.flush();     // Catch: IOException -> L263
        r12.close();     // Catch: IOException -> L263
        goto L265
    L71:
        StringBuilder r112 = new StringBuilder(1024);     // Catch: Throwable -> L210 Exception -> L238 RemoteException -> L240
        r112.append(UserBackupManagerService.BACKUP_FILE_HEADER_MAGIC);     // Catch: Throwable -> L210 Exception -> L238 RemoteException -> L240
        r112.append(5);     // Catch: Throwable -> L210 Exception -> L238 RemoteException -> L240
        if (this.mCompress == false) goto L75;
        String r23 = "\n1\n";
    L76:
        r112.append(r23);     // Catch: Throwable -> L210 Exception -> L238 RemoteException -> L240
        if (r110 == false) goto L312;
    L80:
        e = e;
    L325:
        Slog.e(BackupManagerService.TAG, "Unable to emit archive header", e);     // Catch: Throwable -> L232 Exception -> L234 RemoteException -> L236
        if (0 != 0) goto L308;
    L220:
        this.mOutputFile.close();     // Catch: IOException -> L218
    L223:
        AtomicBoolean r24 = this.mLatch;
        monitor-enter(r24);
        this.mLatch.set(true);     // Catch: Throwable -> L229
        this.mLatch.notifyAll();     // Catch: Throwable -> L229
        monitor-exit(r24);     // Catch: Throwable -> L229
        sendEndBackup();
        r2.tearDown();
        Slog.d(BackupManagerService.TAG, "Full backup pass complete.");
        this.mUserBackupManagerService.getWakeLock().release();
        return;
    L229:
        th = move-exception;
        throw th;
    L218:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, "IO error closing adb backup file: " + e.getMessage());
        goto L223
    L308:
        r12.flush();     // Catch: IOException -> L218
        r12.close();     // Catch: IOException -> L218
        goto L220
    L234:
        e = e;
        goto L243
    L79:
        r111 = emitAesBackupHeader(r112, r111);     // Catch: Throwable -> L44 Exception -> L80
    L83:
        r11.write(r112.toString().getBytes(CharsetNames.UTF_8));     // Catch: Throwable -> L210 Exception -> L212
        if (this.mCompress == false) goto L87;
        OutputStream r113 = new DeflaterOutputStream(r111, new Deflater(9), true);     // Catch: Throwable -> L44 Exception -> L80
    L88:
        OutputStream r25 = r113;
    L168:
        e = e;
        r14 = r14;
        r12 = r25;
    L166:
        th = move-exception;
        r17 = r14;
        r15 = th;
        r12 = r25;
        goto L277
    L90:
        if (this.mIncludeShared == true) goto L293;
    L101:
        int r26 = r10.size();     // Catch: Throwable -> L166 Exception -> L168 RemoteException -> L170
        int r27 = 0;
        r13 = r13;
    L102:
        if (r27 >= r26) goto L172;
        PackageInfo r28 = (PackageInfo) r10.get(r27);     // Catch: Throwable -> L166 Exception -> L168 RemoteException -> L170
        goto L171
    L344:
        Slog.i(BackupManagerService.TAG, "--- Performing full backup for package " + r28.packageName + " ---");     // Catch: Throwable -> L160 Exception -> L162 RemoteException -> L164
        boolean r29 = r28.packageName.equals(UserBackupManagerService.SHARED_BACKUP_AGENT_PACKAGE);     // Catch: Throwable -> L160 Exception -> L162 RemoteException -> L164
        int r30 = r26;
        PackageManager r114 = r3;
        ArrayList r115 = r10;
        StringBuilder r210 = r112;
        goto L153
    L346:
        goto L147
    L338:
        int r31 = r27;
        ArrayList r211 = r8;
        FileOutputStream r212 = r11;
        String r213 = r13;
        r17 = 1;
        r14 = true;
        r14 = true;
        OutputStream r32 = r25;
        FullBackupEngine r33 = new FullBackupEngine(this.mUserBackupManagerService, r32, null, r28, this.mIncludeApks, this, Long.MAX_VALUE, this.mCurrentOpToken, 0, this.mBackupEligibilityRules, new BackupManagerMonitorEventSender(null));     // Catch: Throwable -> L117 Exception -> L119 RemoteException -> L121
        if (r29 == false) goto L123;
        String r34 = "Shared storage";
    L124:
        sendOnBackupPackage(r34);     // Catch: Throwable -> L117 Exception -> L119 RemoteException -> L121
        this.mCurrentTarget = r28;     // Catch: Throwable -> L117 Exception -> L119 RemoteException -> L121
        r33.backupOnePackage();     // Catch: Throwable -> L117 Exception -> L119 RemoteException -> L121
        if (this.mIncludeObbs == false) goto L132;
        if (r29 == true) goto L132;
        if (r2.backupObbs(r28, r32) == true) goto L132;
        throw new RuntimeException("Failure writing OBB stack for " + r28);     // Catch: Throwable -> L117 Exception -> L119 RemoteException -> L121
    L132:
        r27 = r31 + 1;
        r25 = r32;
        r14 = true;
        r3 = r114;
        r13 = r213;
        r8 = r211;
        r10 = r115;
        r11 = r212;
        r112 = r210;
        r26 = r30;
        goto L102
    L123:
        r34 = r28.packageName;     // Catch: Throwable -> L117 Exception -> L119 RemoteException -> L121
    L119:
        e = e;
        r12 = r32;
    L117:
        th = move-exception;
        r15 = th;
        r12 = r32;
    L122:
        r12 = r32;
        goto L260
    L136:
        e = e;
        r14 = true;
    L138:
        r12 = r25;
    L133:
        th = th;
        boolean r116 = true;
    L135:
        r15 = th;
        r12 = r25;
        r17 = r116;
    L140:
        r14 = true;
    L141:
        r12 = r25;
    L144:
        e = e;
        r14 = r14;
    L142:
        th = th;
        r116 = r14;
    L147:
        r14 = r14;
    L150:
        e = e;
        r14 = r14;
        r12 = r25;
    L148:
        th = move-exception;
        r17 = r14;
        r15 = th;
        r12 = r25;
    L153:
        r14 = r14;
        r12 = r25;
        goto L260
    L156:
        e = e;
        r14 = r14;
        r12 = r25;
    L154:
        th = move-exception;
        r17 = r14;
        r15 = th;
        r12 = r25;
    L159:
        r14 = r14;
        r12 = r25;
        goto L260
    L162:
        e = e;
        r14 = r14;
        r12 = r25;
    L160:
        th = move-exception;
        r17 = r14;
        r15 = th;
        r12 = r25;
    L165:
        r14 = r14;
        r12 = r25;
        goto L260
    L172:
        ArrayList r214 = r8;
        r14 = r14;
        OutputStream r35 = r25;
    L184:
        e = e;
        r12 = r35;
    L182:
        th = move-exception;
        r15 = th;
        r12 = r35;
        r17 = r14;
        goto L277
    L174:
        if (this.mKeyValue == false) goto L194;
        Iterator r36 = r214.iterator();     // Catch: Throwable -> L182 Exception -> L184 RemoteException -> L186
    L177:
        if (r36.hasNext() == false) goto L194;
        PackageInfo r215 = (PackageInfo) r36.next();     // Catch: Throwable -> L182 Exception -> L184 RemoteException -> L186
        Slog.i(BackupManagerService.TAG, "--- Performing key-value backup for package " + r215.packageName + " ---");     // Catch: Throwable -> L182 Exception -> L184 RemoteException -> L186
        KeyValueAdbBackupEngine r216 = new KeyValueAdbBackupEngine(r35, r215, this.mUserBackupManagerService, this.mUserBackupManagerService.getPackageManager(), this.mUserBackupManagerService.getBaseStateDir(), this.mUserBackupManagerService.getDataDir());     // Catch: Throwable -> L188 Exception -> L190 RemoteException -> L192
        sendOnBackupPackage(r215.packageName);     // Catch: Throwable -> L182 Exception -> L184 RemoteException -> L186
        r216.backupOnePackage();     // Catch: Throwable -> L182 Exception -> L184 RemoteException -> L186
        goto L177
    L190:
        e = e;
        r12 = r35;
    L188:
        th = move-exception;
        r15 = th;
        r12 = r35;
        r17 = r14;
    L193:
        r12 = r35;
    L194:
        finalizeBackup(r35);     // Catch: Throwable -> L182 Exception -> L184 RemoteException -> L186
        if (r35 != null) goto L306;
    L199:
        this.mOutputFile.close();     // Catch: IOException -> L197
    L202:
        AtomicBoolean r37 = this.mLatch;
        monitor-enter(r37);
        this.mLatch.set(r14);     // Catch: Throwable -> L207
        this.mLatch.notifyAll();     // Catch: Throwable -> L207
        monitor-exit(r37);     // Catch: Throwable -> L207
        sendEndBackup();
        r2.tearDown();
        Slog.d(BackupManagerService.TAG, "Full backup pass complete.");
        this.mUserBackupManagerService.getWakeLock().release();
        return;
    L207:
        th = move-exception;
        throw th;
    L197:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, "IO error closing adb backup file: " + e.getMessage());
        goto L202
    L306:
        r35.flush();     // Catch: IOException -> L197
        r35.close();     // Catch: IOException -> L197
        goto L199
    L187:
        r12 = r35;
        goto L260
    L293:
        r10.add(this.mUserBackupManagerService.getPackageManager().getPackageInfo(UserBackupManagerService.SHARED_BACKUP_AGENT_PACKAGE, 0));     // Catch: Throwable -> L93 Exception -> L95 RemoteException -> L97 PackageManager.NameNotFoundException -> L99
    L95:
        e = e;
        r12 = r25;
        r14 = true;
    L93:
        th = move-exception;
        r12 = r25;
        r15 = th;
        r17 = 1;
    L100:
        Slog.e(BackupManagerService.TAG, "Unable to find shared-storage backup handler");     // Catch: Throwable -> L93 Exception -> L95 RemoteException -> L97
    L98:
        r12 = r25;
        r14 = true;
    L171:
        r14 = r14;
        r12 = r25;
        goto L260
    L87:
        r113 = r111;
        goto L88
    L212:
        e = e;
        goto L325
    L312:
        r112.append("none\n");     // Catch: Throwable -> L210 Exception -> L212
        goto L83
        goto L241
    L75:
        r23 = "\n0\n";
        goto L76
    L297:
    L44:
        th = move-exception;
        r15 = th;
        r17 = 1;
        goto L277
    L42:
        if (this.mEncryptPassword.length() <= 0) goto L50;
        r20 = true;
    L241:
        r14 = true;
        goto L260
    L5:
        r0 = "";
        goto L6
    }

    @Override // com.android.server.backup.BackupRestoreTask
    public void execute() {
    }

    @Override // com.android.server.backup.BackupRestoreTask
    public void operationComplete(long result) {
    }

    @Override // com.android.server.backup.BackupRestoreTask
    public void handleCancel(int cancellationReason) {
        PackageInfo target = this.mCurrentTarget;
        Slog.w(BackupManagerService.TAG, "adb backup cancel of " + target);
        if (target == null) goto L5;
        this.mUserBackupManagerService.getBackupAgentConnectionManager().unbindAgent(target.applicationInfo, true);
    L5:
        this.mOperationStorage.removeOperation(this.mCurrentOpToken);
    }
}
