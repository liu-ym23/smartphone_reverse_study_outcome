package com.android.server.devicepolicy;

import android.app.admin.DevicePolicyEventLogger;
import android.app.admin.StartInstallingUpdateCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.FileUtils;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
abstract class UpdateInstaller {
    static final String TAG = "UpdateInstaller";
    private StartInstallingUpdateCallback mCallback;
    private DevicePolicyConstants mConstants;
    protected Context mContext;
    protected File mCopiedUpdateFile;
    private DevicePolicyManagerService.Injector mInjector;
    private ParcelFileDescriptor mUpdateFileDescriptor;

    public static /* synthetic */ void $r8$lambda$Q2DgDQIlKCZYHawkFhSkCL1NT3U(UpdateInstaller r0) {
        r0.lambda$startInstallUpdate$0();
    }

    public abstract void installUpdateInThread();

    protected UpdateInstaller(Context context, ParcelFileDescriptor updateFileDescriptor, StartInstallingUpdateCallback callback, DevicePolicyManagerService.Injector injector, DevicePolicyConstants constants) {
        this.mContext = context;
        this.mCallback = callback;
        this.mUpdateFileDescriptor = updateFileDescriptor;
        this.mInjector = injector;
        this.mConstants = constants;
    }

    public void startInstallUpdate() {
        this.mCopiedUpdateFile = null;
        if (isBatteryLevelSufficient() == true) goto L6;
        notifyCallbackOnError(5, "The battery level must be above " + this.mConstants.BATTERY_THRESHOLD_NOT_CHARGING + " while not charging or above " + this.mConstants.BATTERY_THRESHOLD_CHARGING + " while charging");
        return;
    L6:
        Thread thread = new Thread(new UpdateInstaller$$ExternalSyntheticLambda0(this));
        thread.setPriority(10);
        thread.start();
    }

    private /* synthetic */ void lambda$startInstallUpdate$0() {
        this.mCopiedUpdateFile = copyUpdateFileToDataOtaPackageDir();
        if (this.mCopiedUpdateFile != null) goto L6;
        notifyCallbackOnError(1, "Error while copying file.");
        return;
    L6:
        installUpdateInThread();
    }

    private boolean isBatteryLevelSufficient() {
        Intent batteryStatus = this.mContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        float batteryPercentage = calculateBatteryPercentage(batteryStatus);
        if (batteryStatus.getIntExtra("plugged", -1) <= 0) goto L5;
        boolean isBatteryPluggedIn = true;
    L6:
        if (isBatteryPluggedIn == false) goto L11;
        if (batteryPercentage >= this.mConstants.BATTERY_THRESHOLD_CHARGING) goto L15;
        return false;
    L15:
        return true;
    L11:
        if (batteryPercentage >= this.mConstants.BATTERY_THRESHOLD_NOT_CHARGING) goto L13;
        return false;
    L13:
        return true;
    L5:
        isBatteryPluggedIn = false;
        goto L6
    }

    private float calculateBatteryPercentage(Intent batteryStatus) {
        int level = batteryStatus.getIntExtra("level", -1);
        int scale = batteryStatus.getIntExtra("scale", -1);
        return (level * 100) / scale;
    }

    private File copyUpdateFileToDataOtaPackageDir() {
        File destination = createNewFileWithPermissions();     // Catch: IOException -> L4
        copyToFile(destination);     // Catch: IOException -> L4
        return destination;
    L4:
        e = move-exception;
        Log.w(TAG, "Failed to copy update file to OTA directory", e);
        notifyCallbackOnError(1, Log.getStackTraceString(e));
        return null;
    }

    private File createNewFileWithPermissions() throws IOException {
        File destination = File.createTempFile("update", ".zip", new File(Environment.getDataDirectory() + "/ota_package"));
        FileUtils.setPermissions(destination, 484, -1, -1);
        return destination;
    }

    private void copyToFile(File destination) throws IOException {
        OutputStream out = new FileOutputStream(destination);
        InputStream in = new ParcelFileDescriptor.AutoCloseInputStream(this.mUpdateFileDescriptor);     // Catch: Throwable -> L8
        FileUtils.copy(in, out);     // Catch: Throwable -> L10
        in.close();     // Catch: Throwable -> L8
        out.close();
        return;
    L10:
        th = move-exception;
        in.close();     // Catch: Throwable -> L13
    L15:
        throw th;     // Catch: Throwable -> L8
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        out.close();     // Catch: Throwable -> L18
    L20:
        throw th;
    L18:
        th = move-exception;
        th.addSuppressed(th);
        goto L20
    }

    void cleanupUpdateFile() {
        if (this.mCopiedUpdateFile != null) goto L5;
        return;
    L5:
        if (this.mCopiedUpdateFile.exists() == false) goto L9;
        this.mCopiedUpdateFile.delete();
        return;
    }

    protected void notifyCallbackOnError(int errorCode, String errorMessage) {
        cleanupUpdateFile();
        DevicePolicyEventLogger.createEvent(74).setInt(errorCode).write();
        this.mCallback.onStartInstallingUpdateError(errorCode, errorMessage);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Log.d(TAG, "Error while calling callback", e);
    }

    protected void notifyCallbackOnSuccess() {
        cleanupUpdateFile();
        this.mInjector.powerManagerReboot("deviceowner");
    }
}
