package com.android.server.backup.utils;

import android.content.Context;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.Signature;
import android.os.UserHandle;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.backup.BackupManagerService;
import com.android.server.backup.FileMetadata;
import com.android.server.backup.restore.RestoreDeleteObserver;
import com.android.server.backup.restore.RestorePolicy;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class RestoreUtils {

    private static class LocalIntentReceiver {
        private IIntentSender.Stub mLocalSender;
        private final Object mLock;
        private Intent mResult;

        /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
        static /* bridge */ /* synthetic */ Object m2549$$Nest$fgetmLock(LocalIntentReceiver r0) {
            return r0.mLock;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmResult, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2550$$Nest$fputmResult(LocalIntentReceiver r0, Intent r1) {
            r0.mResult = r1;
        }

        /* synthetic */ LocalIntentReceiver(RestoreUtilsIA r1) {
            this();
        }

        private LocalIntentReceiver() {
            this.mLock = new Object();
            this.mResult = null;
            this.mLocalSender = new AnonymousClass1(this);
        }

        public IntentSender getIntentSender() {
            return new IntentSender(this.mLocalSender);
        }

        public Intent getResult() {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L19:
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mResult != null) goto L12;
            this.mLock.wait();     // Catch: Throwable -> L8 InterruptedException -> L10
            goto L19
        L12:
            Intent r1 = this.mResult;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return r1;
        }
    }

    public RestoreUtils() {
    }

    public static boolean installApk(InputStream instream, Context context, RestoreDeleteObserver deleteObserver, HashMap<String, Signature[]> manifestSignatures, HashMap<String, RestorePolicy> packagePolicies, FileMetadata info, String installerPackageName, BytesReadListener bytesReadListener, int userId) {
        boolean okay = true;
        Slog.d(BackupManagerService.TAG, "Installing from backup: " + info.packageName);
        LocalIntentReceiver receiver = new LocalIntentReceiver(null);     // Catch: IOException -> L137
        PackageManager packageManager = context.getPackageManager();     // Catch: IOException -> L137
        PackageInstaller installer = packageManager.getPackageInstaller();     // Catch: IOException -> L137
        PackageInstaller.SessionParams params = new PackageInstaller.SessionParams(1);     // Catch: IOException -> L137
        params.setInstallerPackageName(installerPackageName);     // Catch: IOException -> L137
        int sessionId = installer.createSession(params);     // Catch: IOException -> L137
        PackageInstaller.Session session = installer.openSession(sessionId);     // Catch: Exception -> L130
        OutputStream apkStream = session.openWrite(info.packageName, 0, info.size);     // Catch: Throwable -> L119
        byte[] buffer = new byte[65536];     // Catch: Throwable -> L108
        long size = info.size;     // Catch: Throwable -> L108
    L10:
        boolean okay2 = okay;
        if (size <= 0) goto L35;
        PackageInstaller.SessionParams params2 = params;
        if (buffer.length < size) goto L151;
        long toRead = size;
    L20:
        LocalIntentReceiver receiver2 = receiver;
        int didRead = instream.read(buffer, 0, (int) toRead);     // Catch: Throwable -> L30
        if (didRead < 0) goto L28;
        bytesReadListener.onBytesRead(didRead);     // Catch: Throwable -> L25
    L25:
        th = th;
    L26:
        Throwable r3 = th;
    L141:
        if (apkStream != null) goto L178;
        throw r3;     // Catch: Throwable -> L115
    L178:
        apkStream.close();     // Catch: Throwable -> L113
    L189:
        throw r3;     // Catch: Throwable -> L115
    L113:
        th = move-exception;
        r3.addSuppressed(th);     // Catch: Throwable -> L115
        throw r3;     // Catch: Throwable -> L115
    L115:
        Throwable th = th;
    L39:
        Throwable r4 = th;
    L121:
        if (session != null) goto L161;
        throw r4;     // Catch: Exception -> L126
    L126:
        t = e;
    L182:
        installer.abandonSession(sessionId);     // Catch: IOException -> L135
        throw t;     // Catch: IOException -> L135
        goto L139
    L161:
        session.close();     // Catch: Throwable -> L124
    L191:
        throw r4;     // Catch: Exception -> L126
    L124:
        th = move-exception;
        r4.addSuppressed(th);     // Catch: Exception -> L126
        throw r4;     // Catch: Exception -> L126
    L28:
        apkStream.write(buffer, 0, didRead);     // Catch: Throwable -> L25
        size = size - ((long) didRead);
        okay = okay2;
        params = params2;
        receiver = receiver2;
    L30:
        th = th;
        goto L26
    L151:
        toRead = buffer.length;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r3 = th;
    L32:
        th = move-exception;
        r3 = th;
        goto L141
    L35:
        if (apkStream != null) goto L167;
    L40:
        session.abandon();     // Catch: Throwable -> L37
        session.close();     // Catch: Exception -> L106
        Intent result = null;
        if (1 != 0) goto L158;
        boolean uninstall = false;
        String installedPackageName = result.getStringExtra("android.content.pm.extra.PACKAGE_NAME");     // Catch: IOException -> L50
        if (installedPackageName.equals(info.packageName) == true) goto L185;
        Slog.w(BackupManagerService.TAG, "Restore stream claimed to include apk for " + info.packageName + " but apk was really " + installedPackageName);     // Catch: IOException -> L50
        uninstall = true;
        boolean okay3 = false;
    L95:
        if (uninstall == false) goto L192;
        deleteObserver.reset();     // Catch: IOException -> L102
        packageManager.deletePackage(installedPackageName, deleteObserver, 0);     // Catch: IOException -> L100
        deleteObserver.waitForCompletion();     // Catch: IOException -> L100
        return okay3;
    L192:
        return okay3;
    L185:
        PackageInfo pkg = packageManager.getPackageInfoAsUser(info.packageName, 134217728, userId);     // Catch: IOException -> L88 PackageManager.NameNotFoundException -> L90
        if ((pkg.applicationInfo.flags & 32768) == 0) goto L170;
    L163:
        Signature[] sigs = manifestSignatures.get(info.packageName);     // Catch: IOException -> L78 PackageManager.NameNotFoundException -> L86
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);     // Catch: IOException -> L78 PackageManager.NameNotFoundException -> L86
        BackupEligibilityRules eligibilityRules = BackupEligibilityRules.forBackup(packageManager, pmi, userId, context);     // Catch: IOException -> L78 PackageManager.NameNotFoundException -> L80
        if (eligibilityRules.signaturesMatch(sigs, pkg) == true) goto L74;
        Slog.w(BackupManagerService.TAG, "Installed app " + info.packageName + " signatures do not match restore manifest");     // Catch: IOException -> L78 PackageManager.NameNotFoundException -> L80
        okay3 = false;
        uninstall = true;
    L153:
    L74:
        if (UserHandle.isCore(pkg.applicationInfo.uid) == true) goto L76;
    L82:
        okay3 = okay2;
        goto L153
    L76:
        if (pkg.applicationInfo.backupAgentName != null) goto L82;
        Slog.w(BackupManagerService.TAG, "Installed app " + info.packageName + " has restricted uid and no agent");     // Catch: IOException -> L78 PackageManager.NameNotFoundException -> L80
        okay3 = false;
        goto L153
    L170:
        Slog.w(BackupManagerService.TAG, "Restore stream contains apk of package " + info.packageName + " but it disallows backup/restore");     // Catch: IOException -> L50 PackageManager.NameNotFoundException -> L64
        okay3 = false;
    L93:
        Slog.w(BackupManagerService.TAG, "Install of package " + info.packageName + " succeeded but now not found");     // Catch: IOException -> L78
        okay3 = false;
        goto L95
    L158:
        if (packagePolicies.get(info.packageName) == RestorePolicy.ACCEPT) goto L194;
        return false;
    L194:
        return okay2;
    L106:
        t = e;
    L37:
        th = th;
        goto L39
    L167:
        apkStream.close();     // Catch: Throwable -> L37
    L108:
        th = move-exception;
        okay2 = true;
        r3 = th;
    L119:
        th = move-exception;
        okay2 = true;
        r4 = th;
    L130:
        t = e;
        okay2 = true;
    L139:
        Slog.e(BackupManagerService.TAG, "Unable to transcribe restored apk for install");
        return false;
    }
}
