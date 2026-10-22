package com.android.server.backup.restore;

import android.app.backup.IFullBackupRestoreObserver;
import android.content.pm.PackageManagerInternal;
import android.os.ParcelFileDescriptor;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.backup.BackupManagerService;
import com.android.server.backup.BackupPasswordManager;
import com.android.server.backup.OperationStorage;
import com.android.server.backup.UserBackupManagerService;
import com.android.server.backup.fullbackup.FullBackupObbConnection;
import com.android.server.backup.utils.BackupEligibilityRules;
import com.android.server.backup.utils.FullBackupRestoreObserverUtils;
import com.android.server.backup.utils.PasswordUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.InflaterInputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.compress.utils.CharsetNames;

/* JADX INFO: loaded from: classes.dex */
public class PerformAdbRestoreTask implements Runnable {
    private final UserBackupManagerService mBackupManagerService;
    private final String mCurrentPassword;
    private final String mDecryptPassword;
    private final ParcelFileDescriptor mInputFile;
    private final AtomicBoolean mLatchObject;
    private final FullBackupObbConnection mObbConnection;
    private IFullBackupRestoreObserver mObserver;
    private final OperationStorage mOperationStorage;

    public PerformAdbRestoreTask(UserBackupManagerService backupManagerService, OperationStorage operationStorage, ParcelFileDescriptor fd, String curPassword, String decryptPassword, IFullBackupRestoreObserver observer, AtomicBoolean latch) {
        this.mBackupManagerService = backupManagerService;
        this.mOperationStorage = operationStorage;
        this.mInputFile = fd;
        this.mCurrentPassword = curPassword;
        this.mDecryptPassword = decryptPassword;
        this.mObserver = observer;
        this.mLatchObject = latch;
        this.mObbConnection = new FullBackupObbConnection(backupManagerService);
    }

    @Override // java.lang.Runnable
    public void run() {
        Slog.i(BackupManagerService.TAG, "--- Performing full-dataset restore ---");
        this.mObbConnection.establish();
        this.mObserver = FullBackupRestoreObserverUtils.sendStartRestore(this.mObserver);
        FileInputStream rawInStream = null;
        if (this.mBackupManagerService.backupPasswordMatches(this.mCurrentPassword) == true) goto L26;
        Slog.w(BackupManagerService.TAG, "Backup password mismatch; aborting");     // Catch: Throwable -> L22 Exception -> L24
        if (0 != 0) goto L103;
    L10:
        this.mInputFile.close();     // Catch: IOException -> L8
    L13:
        AtomicBoolean r4 = this.mLatchObject;
        monitor-enter(r4);
        this.mLatchObject.set(true);     // Catch: Throwable -> L19
        this.mLatchObject.notifyAll();     // Catch: Throwable -> L19
        monitor-exit(r4);     // Catch: Throwable -> L19
        this.mObbConnection.tearDown();
        this.mObserver = FullBackupRestoreObserverUtils.sendEndRestore(this.mObserver);
        Slog.d(BackupManagerService.TAG, "Full restore pass complete.");
        this.mBackupManagerService.getWakeLock().release();
        return;
    L19:
        th = move-exception;
        throw th;
    L8:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, "Close of restore data pipe threw", e);
        goto L13
    L103:
        rawInStream.close();     // Catch: IOException -> L8
        goto L10
    L26:
        FileInputStream rawInStream2 = new FileInputStream(this.mInputFile.getFileDescriptor());     // Catch: Throwable -> L22 Exception -> L24
        InputStream tarInputStream = parseBackupFileHeaderAndReturnTarStream(rawInStream2, this.mDecryptPassword);     // Catch: Throwable -> L22 Exception -> L24
        if (tarInputStream == null) goto L91;
        BackupEligibilityRules eligibilityRules = new BackupEligibilityRules(this.mBackupManagerService.getPackageManager(), (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class), this.mBackupManagerService.getUserId(), this.mBackupManagerService.getContext(), 2);     // Catch: Throwable -> L22 Exception -> L24
        FullRestoreEngine mEngine = new FullRestoreEngine(this.mBackupManagerService, this.mOperationStorage, null, this.mObserver, null, null, true, 0, true, eligibilityRules);     // Catch: Throwable -> L22 Exception -> L24
        FullRestoreEngineThread mEngineThread = new FullRestoreEngineThread(mEngine, tarInputStream);     // Catch: Throwable -> L22 Exception -> L24
        mEngineThread.run();     // Catch: Throwable -> L22 Exception -> L24
        rawInStream2.close();     // Catch: IOException -> L45
        this.mInputFile.close();     // Catch: IOException -> L45
    L47:
        AtomicBoolean r5 = this.mLatchObject;
        monitor-enter(r5);
        this.mLatchObject.set(true);     // Catch: Throwable -> L52
        this.mLatchObject.notifyAll();     // Catch: Throwable -> L52
        monitor-exit(r5);     // Catch: Throwable -> L52
    L51:
        this.mObbConnection.tearDown();
        this.mObserver = FullBackupRestoreObserverUtils.sendEndRestore(this.mObserver);
        Slog.d(BackupManagerService.TAG, "Full restore pass complete.");
        this.mBackupManagerService.getWakeLock().release();
        return;
    L52:
        th = move-exception;
        throw th;
    L45:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, "Close of restore data pipe threw", e);
        goto L47
    L91:
        rawInStream2.close();     // Catch: IOException -> L31
        this.mInputFile.close();     // Catch: IOException -> L31
    L33:
        AtomicBoolean r6 = this.mLatchObject;
        monitor-enter(r6);
        this.mLatchObject.set(true);     // Catch: Throwable -> L39
        this.mLatchObject.notifyAll();     // Catch: Throwable -> L39
        monitor-exit(r6);     // Catch: Throwable -> L39
        this.mObbConnection.tearDown();
        this.mObserver = FullBackupRestoreObserverUtils.sendEndRestore(this.mObserver);
        Slog.d(BackupManagerService.TAG, "Full restore pass complete.");
        this.mBackupManagerService.getWakeLock().release();
        return;
    L39:
        th = move-exception;
        throw th;
    L31:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, "Close of restore data pipe threw", e);
        goto L33
    L56:
        Slog.e(BackupManagerService.TAG, "Unable to read restore input");     // Catch: Throwable -> L22
        if (0 != 0) goto L89;
    L61:
        this.mInputFile.close();     // Catch: IOException -> L59
    L65:
        monitor-enter(this.mLatchObject);
        this.mLatchObject.set(true);     // Catch: Throwable -> L70
        this.mLatchObject.notifyAll();     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        throw th;
    L59:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, "Close of restore data pipe threw", e);
        goto L65
    L89:
        rawInStream.close();     // Catch: IOException -> L59
    L22:
        th = move-exception;
        if (0 != 0) goto L99;
    L77:
        this.mInputFile.close();     // Catch: IOException -> L75
    L81:
        monitor-enter(this.mLatchObject);
        this.mLatchObject.set(true);     // Catch: Throwable -> L86
        this.mLatchObject.notifyAll();     // Catch: Throwable -> L86
        this.mObbConnection.tearDown();
        this.mObserver = FullBackupRestoreObserverUtils.sendEndRestore(this.mObserver);
        Slog.d(BackupManagerService.TAG, "Full restore pass complete.");
        this.mBackupManagerService.getWakeLock().release();
        throw th;
    L86:
        th = move-exception;
        throw th;
    L75:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, "Close of restore data pipe threw", e);
        goto L81
    L99:
        rawInStream.close();     // Catch: IOException -> L75
        goto L77
    }

    private static void readFullyOrThrow(InputStream in, byte[] buffer) throws IOException {
        int offset = 0;
    L4:
        if (offset >= buffer.length) goto L10;
        int bytesRead = in.read(buffer, offset, buffer.length - offset);
        if (bytesRead <= 0) goto L9;
        offset = offset + bytesRead;
        goto L4
    L9:
        throw new IOException("Couldn't fully read data");
    }

    public static InputStream parseBackupFileHeaderAndReturnTarStream(InputStream rawInputStream, String decryptPassword) throws IOException {
        boolean compressed = false;
        InputStream preCompressStream = rawInputStream;
        boolean okay = false;
        int headerLen = UserBackupManagerService.BACKUP_FILE_HEADER_MAGIC.length();
        byte[] streamHeader = new byte[headerLen];
        readFullyOrThrow(rawInputStream, streamHeader);
        byte[] magicBytes = UserBackupManagerService.BACKUP_FILE_HEADER_MAGIC.getBytes(CharsetNames.UTF_8);
        if (Arrays.equals(magicBytes, streamHeader) == false) goto L26;
        String s = readHeaderLine(rawInputStream);
        int archiveVersion = Integer.parseInt(s);
        if (archiveVersion > 5) goto L24;
        boolean r9 = false;
        if (archiveVersion != 1) goto L9;
        boolean pbkdf2Fallback = true;
    L11:
        if (Integer.parseInt(readHeaderLine(rawInputStream)) == 0) goto L13;
        r9 = true;
    L13:
        compressed = r9;
        String s2 = readHeaderLine(rawInputStream);
        if (s2.equals("none") == false) goto L16;
        okay = true;
    L27:
        if (okay == true) goto L30;
        Slog.w(BackupManagerService.TAG, "Invalid restore data; aborting.");
        return null;
    L30:
        if (compressed == false) goto L33;
        return new InflaterInputStream(preCompressStream);
    L33:
        return preCompressStream;
    L16:
        if (decryptPassword != null) goto L18;
    L22:
        Slog.w(BackupManagerService.TAG, "Archive is encrypted but no password given");
        goto L27
    L18:
        if (decryptPassword.length() <= 0) goto L22;
        preCompressStream = decodeAesHeaderAndInitialize(decryptPassword, s2, pbkdf2Fallback, rawInputStream);
        if (preCompressStream == null) goto L27;
        okay = true;
        goto L27
    L9:
        pbkdf2Fallback = false;
        goto L11
    L24:
        Slog.w(BackupManagerService.TAG, "Wrong header version: " + s);
        goto L27
    L26:
        Slog.w(BackupManagerService.TAG, "Didn't read the right header magic");
        goto L27
    }

    private static String readHeaderLine(InputStream in) throws IOException {
        StringBuilder buffer = new StringBuilder(80);
    L3:
        int c = in.read();
        if (c < 0) goto L10;
        if (c == 10) goto L10;
        buffer.append((char) c);
    L10:
        return buffer.toString();
    }

    private static InputStream attemptEncryptionKeyDecryption(String decryptPassword, String algorithm, byte[] userSalt, byte[] ckSalt, int rounds, String userIvHex, String encryptionKeyBlobHex, InputStream rawInStream, boolean doLog) {
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: InvalidKeyException -> L68 NoSuchPaddingException -> L70 NoSuchAlgorithmException -> L72 IllegalBlockSizeException -> L74 BadPaddingException -> L76 InvalidAlgorithmParameterException -> L78
    L103:
        SecretKey userKey = PasswordUtils.buildPasswordKey(algorithm, decryptPassword, userSalt, rounds);     // Catch: InvalidKeyException -> L56 NoSuchPaddingException -> L58 NoSuchAlgorithmException -> L60 IllegalBlockSizeException -> L62 BadPaddingException -> L64 InvalidAlgorithmParameterException -> L66
        byte[] IV = PasswordUtils.hexToByteArray(userIvHex);     // Catch: InvalidKeyException -> L56 NoSuchPaddingException -> L58 NoSuchAlgorithmException -> L60 IllegalBlockSizeException -> L62 BadPaddingException -> L64 InvalidAlgorithmParameterException -> L66
        IvParameterSpec ivSpec = new IvParameterSpec(IV);     // Catch: InvalidKeyException -> L56 NoSuchPaddingException -> L58 NoSuchAlgorithmException -> L60 IllegalBlockSizeException -> L62 BadPaddingException -> L64 InvalidAlgorithmParameterException -> L66
        c.init(2, new SecretKeySpec(userKey.getEncoded(), "AES"), ivSpec);     // Catch: InvalidKeyException -> L56 NoSuchPaddingException -> L58 NoSuchAlgorithmException -> L60 IllegalBlockSizeException -> L62 BadPaddingException -> L64 InvalidAlgorithmParameterException -> L66
        byte[] mkCipher = PasswordUtils.hexToByteArray(encryptionKeyBlobHex);     // Catch: InvalidKeyException -> L56 NoSuchPaddingException -> L58 NoSuchAlgorithmException -> L60 IllegalBlockSizeException -> L62 BadPaddingException -> L64 InvalidAlgorithmParameterException -> L66
        byte[] mkBlob = c.doFinal(mkCipher);     // Catch: InvalidKeyException -> L56 NoSuchPaddingException -> L58 NoSuchAlgorithmException -> L60 IllegalBlockSizeException -> L62 BadPaddingException -> L64 InvalidAlgorithmParameterException -> L66
        int offset = 0 + 1;     // Catch: InvalidKeyException -> L56 NoSuchPaddingException -> L58 NoSuchAlgorithmException -> L60 IllegalBlockSizeException -> L62 BadPaddingException -> L64 InvalidAlgorithmParameterException -> L66
        int len = mkBlob[0];     // Catch: InvalidKeyException -> L56 NoSuchPaddingException -> L58 NoSuchAlgorithmException -> L60 IllegalBlockSizeException -> L62 BadPaddingException -> L64 InvalidAlgorithmParameterException -> L66
        InputStream result = null;
        byte[] IV2 = Arrays.copyOfRange(mkBlob, offset, offset + len);     // Catch: InvalidKeyException -> L44 NoSuchPaddingException -> L46 NoSuchAlgorithmException -> L48 IllegalBlockSizeException -> L50 BadPaddingException -> L52 InvalidAlgorithmParameterException -> L54
        int offset2 = offset + len;     // Catch: InvalidKeyException -> L44 NoSuchPaddingException -> L46 NoSuchAlgorithmException -> L48 IllegalBlockSizeException -> L50 BadPaddingException -> L52 InvalidAlgorithmParameterException -> L54
        int offset3 = offset2 + 1;     // Catch: InvalidKeyException -> L44 NoSuchPaddingException -> L46 NoSuchAlgorithmException -> L48 IllegalBlockSizeException -> L50 BadPaddingException -> L52 InvalidAlgorithmParameterException -> L54
        int len2 = mkBlob[offset2];     // Catch: InvalidKeyException -> L44 NoSuchPaddingException -> L46 NoSuchAlgorithmException -> L48 IllegalBlockSizeException -> L50 BadPaddingException -> L52 InvalidAlgorithmParameterException -> L54
        byte[] encryptionKey = Arrays.copyOfRange(mkBlob, offset3, offset3 + len2);     // Catch: InvalidKeyException -> L44 NoSuchPaddingException -> L46 NoSuchAlgorithmException -> L48 IllegalBlockSizeException -> L50 BadPaddingException -> L52 InvalidAlgorithmParameterException -> L54
        int offset4 = offset3 + len2;     // Catch: InvalidKeyException -> L44 NoSuchPaddingException -> L46 NoSuchAlgorithmException -> L48 IllegalBlockSizeException -> L50 BadPaddingException -> L52 InvalidAlgorithmParameterException -> L54
        int offset5 = offset4 + 1;     // Catch: InvalidKeyException -> L44 NoSuchPaddingException -> L46 NoSuchAlgorithmException -> L48 IllegalBlockSizeException -> L50 BadPaddingException -> L52 InvalidAlgorithmParameterException -> L54
        byte[] mkChecksum = Arrays.copyOfRange(mkBlob, offset5, offset5 + mkBlob[offset4]);     // Catch: InvalidKeyException -> L44 NoSuchPaddingException -> L46 NoSuchAlgorithmException -> L48 IllegalBlockSizeException -> L50 BadPaddingException -> L52 InvalidAlgorithmParameterException -> L54
    L107:
        byte[] calculatedCk = PasswordUtils.makeKeyChecksum(algorithm, encryptionKey, ckSalt, rounds);     // Catch: InvalidKeyException -> L15 NoSuchPaddingException -> L17 NoSuchAlgorithmException -> L19 IllegalBlockSizeException -> L21 BadPaddingException -> L23 InvalidAlgorithmParameterException -> L25
        if (Arrays.equals(calculatedCk, mkChecksum) == false) goto L40;
        IvParameterSpec ivSpec2 = new IvParameterSpec(IV2);     // Catch: InvalidKeyException -> L27 NoSuchPaddingException -> L29 NoSuchAlgorithmException -> L31 IllegalBlockSizeException -> L33 BadPaddingException -> L35 InvalidAlgorithmParameterException -> L37
        c.init(2, new SecretKeySpec(encryptionKey, "AES"), ivSpec2);     // Catch: InvalidKeyException -> L27 NoSuchPaddingException -> L29 NoSuchAlgorithmException -> L31 IllegalBlockSizeException -> L33 BadPaddingException -> L35 InvalidAlgorithmParameterException -> L37
    L14:
        InputStream result2 = new CipherInputStream(rawInStream, c);     // Catch: InvalidKeyException -> L15 NoSuchPaddingException -> L17 NoSuchAlgorithmException -> L19 IllegalBlockSizeException -> L21 BadPaddingException -> L23 InvalidAlgorithmParameterException -> L25
        return result2;
    L37:
        e = e;
    L97:
        if (doLog == false) goto L100;
        Slog.e(BackupManagerService.TAG, "Needed parameter spec unavailable!", e);
    L100:
        return result;
    L40:
        if (doLog == false) goto L110;
        Slog.w(BackupManagerService.TAG, "Incorrect password");     // Catch: InvalidKeyException -> L15 NoSuchPaddingException -> L17 NoSuchAlgorithmException -> L19 IllegalBlockSizeException -> L21 BadPaddingException -> L23 InvalidAlgorithmParameterException -> L25
    L110:
        return null;
    L25:
        e = e;
    L54:
        e = e;
    L81:
        if (doLog == false) goto L100;
        Slog.w(BackupManagerService.TAG, "Illegal password; aborting");
    L88:
        if (doLog == false) goto L100;
        Slog.e(BackupManagerService.TAG, "Needed decryption algorithm unavailable!");
    L94:
        if (doLog == false) goto L100;
        Slog.w(BackupManagerService.TAG, "Incorrect password");
    L91:
        if (doLog == false) goto L100;
        Slog.w(BackupManagerService.TAG, "Invalid block size in encryption key");
    L84:
        if (doLog == false) goto L100;
        Slog.e(BackupManagerService.TAG, "Needed padding mechanism unavailable!");
        goto L100
    L66:
        e = e;
    L67:
        result = null;
    L78:
        e = e;
    L57:
        result = null;
    L61:
        result = null;
    L65:
        result = null;
    L63:
        result = null;
    L59:
        result = null;
        goto L84
    }

    private static InputStream decodeAesHeaderAndInitialize(String decryptPassword, String encryptionName, boolean pbkdf2Fallback, InputStream rawInStream) {
        InputStream result = null;
        if (encryptionName.equals(PasswordUtils.ENCRYPTION_ALGORITHM_NAME) == false) goto L14;
        String userSaltHex = readHeaderLine(rawInStream);     // Catch: IOException -> L9 NumberFormatException -> L11
        byte[] userSalt = PasswordUtils.hexToByteArray(userSaltHex);     // Catch: IOException -> L9 NumberFormatException -> L11
        String ckSaltHex = readHeaderLine(rawInStream);     // Catch: IOException -> L9 NumberFormatException -> L11
        byte[] ckSalt = PasswordUtils.hexToByteArray(ckSaltHex);     // Catch: IOException -> L9 NumberFormatException -> L11
        int rounds = Integer.parseInt(readHeaderLine(rawInStream));     // Catch: IOException -> L9 NumberFormatException -> L11
        String userIvHex = readHeaderLine(rawInStream);     // Catch: IOException -> L9 NumberFormatException -> L11
        String encryptionKeyBlobHex = readHeaderLine(rawInStream);     // Catch: IOException -> L9 NumberFormatException -> L11
        result = attemptEncryptionKeyDecryption(decryptPassword, BackupPasswordManager.PBKDF_CURRENT, userSalt, ckSalt, rounds, userIvHex, encryptionKeyBlobHex, rawInStream, false);     // Catch: IOException -> L9 NumberFormatException -> L11
        if (result != null) goto L18;
        if (pbkdf2Fallback == false) goto L18;
        result = attemptEncryptionKeyDecryption(decryptPassword, BackupPasswordManager.PBKDF_FALLBACK, userSalt, ckSalt, rounds, userIvHex, encryptionKeyBlobHex, rawInStream, true);     // Catch: IOException -> L9 NumberFormatException -> L11
    L18:
        return result;
    L14:
        Slog.w(BackupManagerService.TAG, "Unsupported encryption method: " + encryptionName);     // Catch: IOException -> L9 NumberFormatException -> L11
        goto L18
    L16:
        Slog.w(BackupManagerService.TAG, "Can't read input header");
        goto L18
    L17:
        Slog.w(BackupManagerService.TAG, "Can't parse restore data header");
        goto L18
    }
}
