package android.os;

import android.content.Context;
import android.content.IntentExt;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageDeleteObserver;
import android.content.pm.PackageManager;
import android.util.Log;
import com.android.internal.util.ArrayUtils;

/* loaded from: classes.dex */
public class StepOSInstallManager {
    public static final String SERVICES_NAME = "stepos_installd";
    private static final String TAG = "StepOSInstallManager";
    PackageManager mPm;
    protected IStepOSInstall mService;

    private static final class InstanceHolder {
        private static final StepOSInstallManager INSTANCE = new StepOSInstallManager();

        private InstanceHolder() {
        }
    }

    public static StepOSInstallManager get() {
        return InstanceHolder.INSTANCE;
    }

    public StepOSInstallManager() {
    }

    public StepOSInstallManager(Context context, IStepOSInstall service) {
        try {
            this.mService = service;
            this.mPm = context.getPackageManager();
        } catch (Exception e) {
            Log.e(TAG, "Failed to init stepos install manager", e);
        }
    }

    public void copyFiles(String srcPath, String targetPath) {
        try {
            this.mService.copyFiles(srcPath, targetPath);
        } catch (Exception e) {
            Log.e(TAG, "Failed to copyFiles", e);
        }
    }

    public int copyFilesStaged(String srcPath, String targetPath, int singleCopyMb) {
        try {
            return this.mService.copyFilesStaged(srcPath, targetPath, singleCopyMb);
        } catch (Exception e) {
            Log.e(TAG, "Failed to copyFilesStaged", e);
            return -1;
        }
    }

    public int copyFilesRestore(String srcPath, String targetPath) {
        try {
            return this.mService.copyFilesRestore(srcPath, targetPath);
        } catch (Exception e) {
            Log.e(TAG, "Failed to copyFilesRestore", e);
            return -1;
        }
    }

    public void interruptCopyAndRestore() {
        try {
            this.mService.interruptCopyAndRestore();
        } catch (Exception e) {
            Log.e(TAG, "Failed to interruptCopyAndRestore", e);
        }
    }

    public void resetPauseIno() {
        try {
            this.mService.resetPauseIno();
        } catch (Exception e) {
            Log.e(TAG, "Failed to resetPauseIno", e);
        }
    }

    public long getCurrentRecoveredSize() {
        try {
            return this.mService.getCurrentRecoveredSize();
        } catch (Exception e) {
            Log.e(TAG, "Failed to getCurrentRecoveredSize", e);
            return -1L;
        }
    }

    public long getTotalSize(String srcPath) {
        try {
            return this.mService.getTotalSize(srcPath);
        } catch (Exception e) {
            Log.e(TAG, "Failed to getTotalSize", e);
            return -1L;
        }
    }

    public void removeRf(String packageName) {
        try {
            this.mService.removeRf(packageName);
        } catch (Exception e) {
            Log.e(TAG, "Failed to removeRf", e);
        }
    }

    public void startCaptureLog(String srcPath) {
        try {
            this.mService.startCaptureLog(srcPath);
        } catch (Exception e) {
            Log.e(TAG, "Failed to init stepos install manager", e);
        }
    }

    public void stopCaptureLog() {
        try {
            this.mService.stopCaptureLog();
        } catch (Exception e) {
            Log.e(TAG, "Failed to stopCaptureLog", e);
        }
    }

    public void copyDataFiles(String srcPath, String targetPath) {
        try {
            this.mService.copyFiles(srcPath, targetPath);
        } catch (Exception e) {
            Log.e(TAG, "Failed to copyDataFiles", e);
        }
    }

    public boolean restoreAndroidDataOwner(String path, int uid) {
        try {
            return this.mService.restoreAndroidDataOwner(path, uid);
        } catch (Exception e) {
            Log.e(TAG, "Failed to restoreAndroidDataOwner", e);
            return false;
        }
    }

    public void deletePackageAsUser(String packageName, IPackageDeleteObserver observer, int flags, int userId) throws PackageManager.NameNotFoundException {
        int callingUid = Binder.getCallingUid();
        String[] packages = this.mPm.getPackagesForUid(callingUid);
        if (ArrayUtils.isEmpty(packages)) {
            return;
        }
        ApplicationInfo info = null;
        try {
            info = this.mPm.getApplicationInfo(packages[0], 0);
        } catch (PackageManager.NameNotFoundException e) {
        }
        if (info == null) {
            return;
        }
        ApplicationInfo deleteInfo = null;
        try {
            deleteInfo = this.mPm.getApplicationInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e2) {
        }
        if (deleteInfo == null) {
            return;
        }
        boolean uninstallSystem = (deleteInfo.privateFlags & IntentExt.STEPOS_FLAG_SPLIT_MODE) != 0;
        if (uninstallSystem) {
            flags |= 4;
        }
        boolean allow = (info.flags & 129) != 0;
        if ("com.stepos.safe".equals(info.packageName)) {
            allow = true;
        }
        if (allow) {
            this.mPm.deletePackageAsUser(packageName, observer, flags, userId);
        }
    }
}
