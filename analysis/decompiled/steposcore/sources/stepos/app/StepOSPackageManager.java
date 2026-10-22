package stepos.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.os.IBinder;
import android.os.IStepOSSpaceOptListenerWrapper;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import stepos.app.IStepOSPackageManager;

/* loaded from: classes.dex */
public class StepOSPackageManager extends StepOSCommonManager {
    private static final String REAL_STORAGE_PREFIX = "/data/media/";
    private static final String STORAGE_PREFIX = "/storage/emulated/";
    private static final String TAG = "StepOSPackageManager";
    protected IStepOSPackageManager mStepOSPm;

    private static final class InstanceHolder {
        private static final StepOSPackageManager INSTANCE = new StepOSPackageManager();

        private InstanceHolder() {
        }
    }

    public static StepOSPackageManager get() {
        return InstanceHolder.INSTANCE;
    }

    private StepOSPackageManager() {
        super("package");
        try {
            IBinder extension = this.mRemote.getExtension();
            this.mStepOSPm = IStepOSPackageManager.Stub.asInterface(extension);
        } catch (Exception e) {
            Log.e(TAG, "Failed to init stepos package manager", e);
        }
    }

    public void test() {
        if (this.mStepOSPm == null) {
            return;
        }
        try {
            this.mStepOSPm.test();
        } catch (RemoteException e) {
            e.rethrowFromSystemServer();
        }
    }

    public int backupDataStaged(String sourceDir, String targetDir, int singleCopyMb) throws RemoteException {
        StringBuffer sb = new StringBuffer();
        boolean transferTarget = false;
        if (targetDir != null && targetDir.contains("/storage/")) {
            File targetFile = new File(targetDir);
            if (targetFile.exists()) {
                transferTarget = Environment.isExternalStorageRemovable(targetFile);
            }
        }
        boolean transferSource = false;
        if (sourceDir != null && sourceDir.contains("/storage/")) {
            File sourceFile = new File(sourceDir);
            if (sourceFile.exists()) {
                transferSource = Environment.isExternalStorageRemovable(sourceFile);
            }
        }
        Log.d(TAG, "backupDataStaged transTarget:" + transferTarget + ",transSour:" + transferSource);
        Log.d(TAG, "backupDataStaged Target:" + targetDir + ",Sour:" + sourceDir);
        sb.append(REAL_STORAGE_PREFIX);
        if (targetDir == null || (!targetDir.startsWith(STORAGE_PREFIX) && !transferTarget)) {
            if (targetDir != null && (sourceDir.startsWith(STORAGE_PREFIX) || transferSource)) {
                String locEnd = sourceDir.substring(STORAGE_PREFIX.length());
                sb.append(locEnd);
                if (transferSource) {
                    return this.mStepOSPm.backupDataStaged(sourceDir, targetDir, singleCopyMb);
                }
                if (sourceDir.startsWith(STORAGE_PREFIX)) {
                    return this.mStepOSPm.backupDataStaged(sb.toString(), targetDir, singleCopyMb);
                }
                return -1;
            }
            return this.mStepOSPm.backupDataStaged(sourceDir, targetDir, singleCopyMb);
        }
        String locEnd2 = targetDir.substring(STORAGE_PREFIX.length());
        sb.append(locEnd2);
        if (transferTarget) {
            return this.mStepOSPm.backupDataStaged(sourceDir, targetDir, singleCopyMb);
        }
        if (targetDir.startsWith(STORAGE_PREFIX)) {
            return this.mStepOSPm.backupDataStaged(sourceDir, sb.toString(), singleCopyMb);
        }
        return -1;
    }

    public int backupDataRestore(String sourceDir, String targetDir) throws RemoteException {
        StringBuffer sb = new StringBuffer();
        boolean transferTarget = false;
        if (targetDir != null && targetDir.contains("/storage/")) {
            File targetFile = new File(targetDir);
            if (targetFile.exists()) {
                transferTarget = Environment.isExternalStorageRemovable(targetFile);
            }
        }
        boolean transferSource = false;
        if (sourceDir != null && sourceDir.contains("/storage/")) {
            File sourceFile = new File(sourceDir);
            if (sourceFile.exists()) {
                transferSource = Environment.isExternalStorageRemovable(sourceFile);
            }
        }
        Log.d(TAG, "backupDataRestore transTarget:" + transferTarget + ",transSour:" + transferSource);
        Log.d(TAG, "backupDataRestore Target:" + targetDir + ",Sour:" + sourceDir);
        sb.append(REAL_STORAGE_PREFIX);
        if (targetDir == null || (!targetDir.startsWith(STORAGE_PREFIX) && !transferTarget)) {
            if (targetDir != null && (sourceDir.startsWith(STORAGE_PREFIX) || transferSource)) {
                String locEnd = sourceDir.substring(STORAGE_PREFIX.length());
                sb.append(locEnd);
                if (transferSource) {
                    return this.mStepOSPm.backupDataRestore(sourceDir, targetDir);
                }
                if (sourceDir.startsWith(STORAGE_PREFIX)) {
                    return this.mStepOSPm.backupDataRestore(sb.toString(), targetDir);
                }
                return -1;
            }
            return this.mStepOSPm.backupDataRestore(sourceDir, targetDir);
        }
        String locEnd2 = targetDir.substring(STORAGE_PREFIX.length());
        sb.append(locEnd2);
        if (transferTarget) {
            return this.mStepOSPm.backupDataRestore(sourceDir, targetDir);
        }
        if (targetDir.startsWith(STORAGE_PREFIX)) {
            return this.mStepOSPm.backupDataRestore(sourceDir, sb.toString());
        }
        return -1;
    }

    public void backupDataInterrupt() throws RemoteException {
        this.mStepOSPm.backupDataInterrupt();
    }

    public void backupDataReset() throws RemoteException {
        this.mStepOSPm.backupDataReset();
    }

    public long backupDataGetRecoveredSize() throws RemoteException {
        return this.mStepOSPm.backupDataGetRecoveredSize();
    }

    public long backupDataGetTotalSize(String sourceDir) throws RemoteException {
        StringBuffer sb = new StringBuffer();
        boolean transferSource = false;
        if (sourceDir != null && sourceDir.contains("/storage/")) {
            File sourceFile = new File(sourceDir);
            if (sourceFile.exists()) {
                transferSource = Environment.isExternalStorageRemovable(sourceFile);
            }
        }
        Log.d(TAG, "backupDataGetTotalSize transSour:" + transferSource);
        Log.d(TAG, "backupDataGetTotalSize Sour:" + sourceDir);
        sb.append(REAL_STORAGE_PREFIX);
        if (sourceDir != null && (sourceDir.startsWith(STORAGE_PREFIX) || transferSource)) {
            String locEnd = sourceDir.substring(STORAGE_PREFIX.length());
            sb.append(locEnd);
            if (transferSource) {
                return this.mStepOSPm.backupDataGetTotalSize(sourceDir);
            }
            if (sourceDir.startsWith(STORAGE_PREFIX)) {
                return this.mStepOSPm.backupDataGetTotalSize(sb.toString());
            }
            return -1L;
        }
        return this.mStepOSPm.backupDataGetTotalSize(sourceDir);
    }

    public void backupDataRemoveRf(String packageName) throws RemoteException {
        this.mStepOSPm.backupDataRemoveRf(packageName);
    }

    public void startCaptureLog(String sourceDir) throws RemoteException {
        StringBuffer sb = new StringBuffer();
        boolean transferSource = false;
        if (sourceDir != null && sourceDir.contains("/storage/")) {
            File file = new File(sourceDir);
            if (file.exists()) {
                transferSource = Environment.isExternalStorageRemovable(file);
            }
        }
        Log.d(TAG, "startCaptureLog transSour:" + transferSource);
        Log.d(TAG, "startCaptureLog Sour:" + sourceDir);
        sb.append(REAL_STORAGE_PREFIX);
        if (sourceDir != null && (sourceDir.startsWith(STORAGE_PREFIX) || transferSource)) {
            String locEnd = sourceDir.substring(STORAGE_PREFIX.length());
            sb.append(locEnd);
            if (transferSource) {
                this.mStepOSPm.startCaptureLog(sourceDir);
            }
            if (sourceDir.startsWith(STORAGE_PREFIX)) {
                this.mStepOSPm.startCaptureLog(sourceDir);
                return;
            }
            return;
        }
        this.mStepOSPm.startCaptureLog(sourceDir);
    }

    public boolean backupData(String source, String target) {
        StringBuffer sb = new StringBuffer();
        boolean transferTarget = false;
        if (target != null && target.contains("/storage/")) {
            transferTarget = Environment.isExternalStorageRemovable(new File(target));
        }
        boolean transferSource = false;
        if (source != null && source.contains("/storage/")) {
            transferSource = Environment.isExternalStorageRemovable(new File(source));
        }
        Log.d(TAG, "transTarget:" + transferTarget + ",transSour:" + transferSource);
        Log.d(TAG, "Target:" + target + ",Sour:" + source);
        sb.append(REAL_STORAGE_PREFIX);
        if (target != null && (target.startsWith(STORAGE_PREFIX) || transferTarget)) {
            String locEnd = target.substring(STORAGE_PREFIX.length());
            sb.append(locEnd);
            try {
                if (transferTarget) {
                    return this.mStepOSPm.backupData(source, target);
                }
                if (target.startsWith(STORAGE_PREFIX)) {
                    return this.mStepOSPm.backupData(source, sb.toString());
                }
                return false;
            } catch (RemoteException e) {
                Log.e(TAG, "Failed to copyFiles", e);
                return false;
            }
        }
        if (target == null) {
            return false;
        }
        if (source.startsWith(STORAGE_PREFIX) || transferSource) {
            String locEnd2 = source.substring(STORAGE_PREFIX.length());
            sb.append(locEnd2);
            try {
                if (transferSource) {
                    return this.mStepOSPm.backupData(source, target);
                }
                if (source.startsWith(STORAGE_PREFIX)) {
                    return this.mStepOSPm.backupData(sb.toString(), target);
                }
                return false;
            } catch (RemoteException e2) {
                Log.e(TAG, "Failed to copyFiles", e2);
                return false;
            }
        }
        return false;
    }

    public boolean restoreAndroidDataOwner(String path, String packageName) {
        StringBuilder sb = new StringBuilder();
        if (!path.startsWith(STORAGE_PREFIX)) {
            return false;
        }
        String relativePath = path.substring(STORAGE_PREFIX.length());
        String realPath = sb.append(REAL_STORAGE_PREFIX).append(relativePath).toString();
        try {
            this.mStepOSPm.restoreAndroidDataOwner(realPath, packageName);
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to restoreAndroidDataOwner", e);
            return false;
        }
    }

    public void stopCaptureLog() {
        try {
            this.mStepOSPm.stopCaptureLog();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void startScan(IStepOSSpaceOptListenerWrapper listener) {
        try {
            this.mStepOSPm.startScan(listener);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void linkRepeatedFiles(String[] ids, IStepOSSpaceOptListenerWrapper listener) {
        try {
            this.mStepOSPm.linkRepeatedFiles(ids, listener);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void cancelTask() {
        try {
            this.mStepOSPm.cancelTask();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void startScanApps(String[] thirdApps, int days, IStepOSSpaceOptListenerWrapper listener) {
        try {
            this.mStepOSPm.startScanApps(thirdApps, days, listener);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void appCompress(String[] apps, int days, IStepOSSpaceOptListenerWrapper listener) {
        try {
            this.mStepOSPm.appCompress(apps, days, listener);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int linkRepeatedFilesByCow(String path1, String path2) {
        try {
            return this.mStepOSPm.linkRepeatedFilesByCow(path1, path2);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -99;
        }
    }

    public int markFileByCow(int type, String path) {
        try {
            return this.mStepOSPm.markFileByCow(type, path);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -99;
        }
    }

    public List<String> getStartingRestrictedPackages() {
        if (this.mStepOSPm == null) {
            return null;
        }
        try {
            return this.mStepOSPm.getStartingRestrictedPackages();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to getStartingRestrictedPackages", e);
            return null;
        }
    }

    public List<String> getSwitchablePackagesForCTA() {
        if (this.mStepOSPm == null) {
            return null;
        }
        try {
            return this.mStepOSPm.getSwitchablePackagesForCTA();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to getSwitchablePackagesForCTA", e);
            return null;
        }
    }

    public String getStepOSAppCodePath(String packageName) {
        if (this.mStepOSPm == null || packageName == null) {
            return null;
        }
        try {
            return this.mStepOSPm.getStepOSAppCodePath(packageName);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to getStepOSAppCodePath", e);
            return null;
        }
    }

    public boolean setForceFull(String packageName, boolean forceFull) {
        if (this.mStepOSPm == null) {
            return false;
        }
        try {
            return this.mStepOSPm.setForceFull(packageName, forceFull);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to setForceFull", e);
            return false;
        }
    }

    public boolean isForceFullForUid(int uid) {
        if (this.mStepOSPm == null) {
            return false;
        }
        try {
            return this.mStepOSPm.isForceFullForUid(uid);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to isForceFullForUid", e);
            return false;
        }
    }

    public String[] setPackagesSuspended(Context context, String[] packageNames, boolean suspended, PersistableBundle appExtras, PersistableBundle launcherExtras, String dialogMessage, int userId) {
        if (this.mStepOSPm == null) {
            return new String[0];
        }
        try {
            return this.mStepOSPm.setPackagesSuspendedAsUser(packageNames, suspended, appExtras, launcherExtras, dialogMessage, context.getOpPackageName(), userId);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to setPackagesSuspended", e);
            return new String[0];
        }
    }

    public boolean hidePackageIcon(Context context, String packageName) {
        if (this.mStepOSPm == null) {
            return false;
        }
        try {
            return this.mStepOSPm.hidePackageIcon(packageName, context.getUserId());
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to hidePackageIcon", e);
            return false;
        }
    }

    public boolean restorePackageIcon(Context context, String packageName) {
        if (this.mStepOSPm == null) {
            return false;
        }
        try {
            return this.mStepOSPm.restorePackageIcon(packageName, context.getUserId());
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to restorePackageIcon", e);
            return false;
        }
    }

    public boolean isSupportsHiddenIcon(String packageName) {
        if (this.mStepOSPm == null) {
            return false;
        }
        try {
            return this.mStepOSPm.isSupportsHiddenIcon(packageName);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to isSupportsHiddenIcon", e);
            return false;
        }
    }

    public List<ApplicationInfo> getPackageIconStates(Context context, List<String> packageNames) {
        if (this.mStepOSPm == null) {
            return new ArrayList();
        }
        try {
            return this.mStepOSPm.getPackageIconStates(packageNames, context.getUserId());
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to getPackageIconStates", e);
            return new ArrayList();
        }
    }

    public List<ApplicationInfo> getSupportsHiddenIconPackages(Context context) {
        if (this.mStepOSPm == null) {
            return new ArrayList();
        }
        try {
            return this.mStepOSPm.getSupportsHiddenIconPackages(context.getUserId());
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to getSupportsHiddenIconPackages", e);
            return new ArrayList();
        }
    }

    public void setInterceptPackage(List<String> packageSet) {
        if (this.mStepOSPm == null) {
            return;
        }
        try {
            this.mStepOSPm.setInterceptPackage(packageSet);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to setInterceptPackage", e);
        }
    }

    public void setKeyGuardPackage(String pkgname, boolean intercept, int level) {
        if (this.mStepOSPm == null) {
            return;
        }
        try {
            this.mStepOSPm.setKeyGuardPackage(pkgname, intercept, level);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to setKeyGuardPackage", e);
        }
    }

    public void setkeyguardActivitylist(ComponentName component, boolean shouldClear) {
        if (this.mStepOSPm == null) {
            return;
        }
        try {
            this.mStepOSPm.setkeyguardActivitylist(component, shouldClear);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to setkeyguardActivitylist", e);
        }
    }
}
