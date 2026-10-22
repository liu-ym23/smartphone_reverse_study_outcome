package com.android.server.backup;

import android.app.IBackupAgent;
import android.app.backup.FullBackup;
import android.app.backup.FullBackupDataOutput;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SELinux;
import android.util.Slog;
import com.android.server.backup.fullbackup.AppMetadataBackupWriter;
import com.android.server.backup.remote.ServiceBackupCallback;
import com.android.server.backup.utils.FullBackupUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes.dex */
public class KeyValueAdbBackupEngine {
    private static final String BACKUP_KEY_VALUE_BACKUP_DATA_FILENAME_SUFFIX = ".data";
    private static final String BACKUP_KEY_VALUE_BLANK_STATE_FILENAME = "blank_state";
    private static final String BACKUP_KEY_VALUE_DIRECTORY_NAME = "key_value_dir";
    private static final String BACKUP_KEY_VALUE_NEW_STATE_FILENAME_SUFFIX = ".new";
    private static final boolean DEBUG = false;
    private static final String TAG = "KeyValueAdbBackupEngine";
    private final BackupAgentTimeoutParameters mAgentTimeoutParameters;
    private ParcelFileDescriptor mBackupData;
    private final File mBackupDataName;
    private UserBackupManagerService mBackupManagerService;
    private final File mBlankStateName;
    private final PackageInfo mCurrentPackage;
    private final File mDataDir;
    private final File mManifestFile;
    private ParcelFileDescriptor mNewState;
    private final File mNewStateName;
    private final OutputStream mOutput;
    private final PackageManager mPackageManager;
    private ParcelFileDescriptor mSavedState;
    private final File mStateDir;

    class KeyValueAdbBackupDataCopier implements Runnable {
        private final PackageInfo mPackage;
        private final ParcelFileDescriptor mPipe;
        private final int mToken;
        final /* synthetic */ KeyValueAdbBackupEngine this$0;

        KeyValueAdbBackupDataCopier(KeyValueAdbBackupEngine this$0, PackageInfo pack, ParcelFileDescriptor pipe, int token) throws IOException {
            this.this$0 = this$0;
            this.mPackage = pack;
            this.mPipe = ParcelFileDescriptor.dup(pipe.getFileDescriptor());
            this.mToken = token;
        }

        @Override // java.lang.Runnable
        public void run() {
            FullBackupDataOutput output = new FullBackupDataOutput(this.mPipe);     // Catch: Throwable -> L6 IOException -> L12
            AppMetadataBackupWriter writer = new AppMetadataBackupWriter(output, KeyValueAdbBackupEngine.m2479$$Nest$fgetmPackageManager(this.this$0));     // Catch: Throwable -> L6 IOException -> L12
            Slog.d(KeyValueAdbBackupEngine.TAG, "Writing manifest for " + this.mPackage.packageName);     // Catch: Throwable -> L6 IOException -> L12
            writer.backupManifest(this.mPackage, KeyValueAdbBackupEngine.m2478$$Nest$fgetmManifestFile(this.this$0), KeyValueAdbBackupEngine.m2477$$Nest$fgetmDataDir(this.this$0), "k", null, false);     // Catch: Throwable -> L6 IOException -> L12
            KeyValueAdbBackupEngine.m2478$$Nest$fgetmManifestFile(this.this$0).delete();     // Catch: Throwable -> L6 IOException -> L12
            Slog.d(KeyValueAdbBackupEngine.TAG, "Writing key-value package payload" + this.mPackage.packageName);     // Catch: Throwable -> L6 IOException -> L12
            FullBackup.backupToTar(this.mPackage.packageName, "k", null, KeyValueAdbBackupEngine.m2477$$Nest$fgetmDataDir(this.this$0).getAbsolutePath(), KeyValueAdbBackupEngine.m2475$$Nest$fgetmBackupDataName(this.this$0).getAbsolutePath(), output);     // Catch: Throwable -> L6 IOException -> L12
            FileOutputStream out = new FileOutputStream(this.mPipe.getFileDescriptor());     // Catch: Throwable -> L6 IOException -> L8
            byte[] buf = new byte[4];     // Catch: Throwable -> L6 IOException -> L8
            out.write(buf);     // Catch: Throwable -> L6 IOException -> L8
        L28:
            KeyValueAdbBackupEngine.m2476$$Nest$fgetmBackupManagerService(this.this$0).getBackupManagerBinder().opComplete(this.mToken, 0);     // Catch: Throwable -> L6 IOException -> L12 RemoteException -> L14
        L16:
            IoUtils.closeQuietly(this.mPipe);
            return;
        L9:
            Slog.e(KeyValueAdbBackupEngine.TAG, "Unable to finalize backup stream!");     // Catch: Throwable -> L6 IOException -> L12
        L12:
            e = move-exception;
            Slog.e(KeyValueAdbBackupEngine.TAG, "Error running full backup for " + this.mPackage.packageName + ". " + e);     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            IoUtils.closeQuietly(this.mPipe);
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBackupDataName, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m2475$$Nest$fgetmBackupDataName(KeyValueAdbBackupEngine r0) {
        return r0.mBackupDataName;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBackupManagerService, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserBackupManagerService m2476$$Nest$fgetmBackupManagerService(KeyValueAdbBackupEngine r0) {
        return r0.mBackupManagerService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDataDir, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m2477$$Nest$fgetmDataDir(KeyValueAdbBackupEngine r0) {
        return r0.mDataDir;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmManifestFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m2478$$Nest$fgetmManifestFile(KeyValueAdbBackupEngine r0) {
        return r0.mManifestFile;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManager m2479$$Nest$fgetmPackageManager(KeyValueAdbBackupEngine r0) {
        return r0.mPackageManager;
    }

    public KeyValueAdbBackupEngine(OutputStream output, PackageInfo packageInfo, UserBackupManagerService backupManagerService, PackageManager packageManager, File baseStateDir, File dataDir) {
        this.mOutput = output;
        this.mCurrentPackage = packageInfo;
        this.mBackupManagerService = backupManagerService;
        this.mPackageManager = packageManager;
        this.mDataDir = dataDir;
        this.mStateDir = new File(baseStateDir, BACKUP_KEY_VALUE_DIRECTORY_NAME);
        this.mStateDir.mkdirs();
        String pkg = this.mCurrentPackage.packageName;
        this.mBlankStateName = new File(this.mStateDir, BACKUP_KEY_VALUE_BLANK_STATE_FILENAME);
        this.mBackupDataName = new File(this.mDataDir, pkg + ".data");
        this.mNewStateName = new File(this.mStateDir, pkg + ".new");
        this.mManifestFile = new File(this.mDataDir, UserBackupManagerService.BACKUP_MANIFEST_FILENAME);
        BackupAgentTimeoutParameters r1 = backupManagerService.getAgentTimeoutParameters();
        r1.getClass();
        this.mAgentTimeoutParameters = r1;
    }

    public void backupOnePackage() throws IOException {
        ApplicationInfo targetApp = this.mCurrentPackage.applicationInfo;
        prepareBackupFiles(this.mCurrentPackage.packageName);     // Catch: Throwable -> L8 FileNotFoundException -> L10
        IBackupAgent agent = bindToAgent(targetApp);     // Catch: Throwable -> L8 FileNotFoundException -> L10
        if (agent != null) goto L13;
        Slog.e(TAG, "Failed binding to BackupAgent for package " + this.mCurrentPackage.packageName);     // Catch: Throwable -> L8 FileNotFoundException -> L10
        cleanup();
        return;
    L13:
        if (invokeAgentForAdbBackup(this.mCurrentPackage.packageName, agent) == true) goto L17;
        Slog.e(TAG, "Backup Failed for package " + this.mCurrentPackage.packageName);     // Catch: Throwable -> L8 FileNotFoundException -> L10
        cleanup();
        return;
    L17:
        writeBackupData();     // Catch: Throwable -> L8 FileNotFoundException -> L10
    L18:
        cleanup();
        return;
    L10:
        e = move-exception;
        Slog.e(TAG, "Failed creating files for package " + this.mCurrentPackage.packageName + " will ignore package. " + e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        cleanup();
        throw th;
    }

    private void prepareBackupFiles(String packageName) throws FileNotFoundException {
        this.mSavedState = ParcelFileDescriptor.open(this.mBlankStateName, AudioFormat.MP2);
        this.mBackupData = ParcelFileDescriptor.open(this.mBackupDataName, 1006632960);
        if (SELinux.restorecon(this.mBackupDataName) == true) goto L5;
        Slog.e(TAG, "SELinux restorecon failed on " + this.mBackupDataName);
    L5:
        this.mNewState = ParcelFileDescriptor.open(this.mNewStateName, 1006632960);
    }

    private IBackupAgent bindToAgent(ApplicationInfo targetApp) {
        return this.mBackupManagerService.getBackupAgentConnectionManager().bindToAgentSynchronous(targetApp, 0, 0);
    L4:
        e = move-exception;
        Slog.e(TAG, "error in binding to agent for package " + targetApp.packageName + ". " + e);
        return null;
    }

    private boolean invokeAgentForAdbBackup(String packageName, IBackupAgent agent) {
        int token = this.mBackupManagerService.generateRandomIntegerToken();
        long kvBackupAgentTimeoutMillis = this.mAgentTimeoutParameters.getKvBackupAgentTimeoutMillis();
        this.mBackupManagerService.prepareOperationTimeout(token, kvBackupAgentTimeoutMillis, null, 0);     // Catch: RemoteException -> L7
        agent.doBackup(this.mSavedState, this.mBackupData, this.mNewState, Long.MAX_VALUE, new ServiceBackupCallback(this.mBackupManagerService.getBackupManagerBinder(), token), 0);     // Catch: RemoteException -> L7
        if (this.mBackupManagerService.waitUntilOperationComplete(token) == true) goto L9;
        Slog.e(TAG, "Key-value backup failed on package " + packageName);     // Catch: RemoteException -> L7
        return false;
    L9:
        Slog.i(TAG, "Key-value backup success for package " + packageName);     // Catch: RemoteException -> L7
        return true;
    L7:
        e = move-exception;
        Slog.e(TAG, "Error invoking agent for backup on " + packageName + ". " + e);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeBackupData() throws IOException {
        int r3 = this.mBackupManagerService.generateRandomIntegerToken();
        long r4 = this.mAgentTimeoutParameters.getKvBackupAgentTimeoutMillis();
        Object[] r2 = 0;
        ParcelFileDescriptor[] r5 = null;
        ParcelFileDescriptor[] r0 = ParcelFileDescriptor.createPipe();     // Catch: Throwable -> L14 IOException -> L16
        this.mBackupManagerService.prepareOperationTimeout(r3, r4, null, 0);     // Catch: Throwable -> L8 IOException -> L10
        KeyValueAdbBackupDataCopier r1 = new KeyValueAdbBackupDataCopier(this, this.mCurrentPackage, r0[1], r3);     // Catch: Throwable -> L8 IOException -> L10
        r0[1].close();     // Catch: Throwable -> L8 IOException -> L10
        r0[1] = null;     // Catch: Throwable -> L8 IOException -> L10
        Thread r6 = new Thread(r1, "key-value-app-data-runner");     // Catch: Throwable -> L8 IOException -> L10
        r6.start();     // Catch: Throwable -> L8 IOException -> L10
        FullBackupUtils.routeSocketDataToOutput(r0[0], this.mOutput);     // Catch: Throwable -> L8 IOException -> L10
        if (this.mBackupManagerService.waitUntilOperationComplete(r3) == true) goto L12;
        Slog.e(TAG, "Full backup failed on package " + this.mCurrentPackage.packageName);     // Catch: Throwable -> L8 IOException -> L10
    L13:
        this.mOutput.flush();
        IoUtils.closeQuietly(r0[0]);
        IoUtils.closeQuietly(r0[1]);
        r2 = r6;
    L28:
        return;
    L12:
        Slog.d(TAG, "Full package backup success: " + this.mCurrentPackage.packageName);     // Catch: Throwable -> L8 IOException -> L10
    L10:
        e = e;
        r5 = r0;
    L18:
        Slog.e(TAG, "Error backing up " + this.mCurrentPackage.packageName + ": " + e);     // Catch: Throwable -> L14
        this.mOutput.flush();
        if (r5 == null) goto L22;
        IoUtils.closeQuietly(r5[0]);
        IoUtils.closeQuietly(r5[1]);
    L22:
        r2 = r5;
    L8:
        th = th;
        r2 = r0;
    L24:
        this.mOutput.flush();
        if (r2 == 0) goto L27;
        IoUtils.closeQuietly(r2[0]);
        IoUtils.closeQuietly(r2[1]);
    L27:
        throw th;
    L14:
        th = th;
    L16:
        e = e;
        goto L18
    }

    private void cleanup() {
        this.mBackupManagerService.getBackupAgentConnectionManager().unbindAgent(this.mCurrentPackage.applicationInfo, true);
        this.mBlankStateName.delete();
        this.mNewStateName.delete();
        this.mBackupDataName.delete();
    }
}
