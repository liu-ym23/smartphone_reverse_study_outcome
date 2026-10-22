package com.android.server.pm;

import android.app.ActivityManager;
import android.app.admin.SecurityLog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.LocalServices;
import com.android.server.pm.pkg.AndroidPackage;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
final class PackageMetrics {
    public static final int STEP_COMMIT = 4;
    public static final int STEP_DEXOPT = 5;
    public static final int STEP_FREEZE_INSTALL = 6;
    public static final int STEP_PREPARE = 1;
    public static final int STEP_RECONCILE = 3;
    public static final int STEP_RESTORE = 7;
    public static final int STEP_SCAN = 2;
    public static final int STEP_WAIT_DEXOPT = 8;
    private static final String TAG = "PackageMetrics";
    private final InstallRequest mInstallRequest;
    private final long mInstallStartTimestampMillis;
    private final SparseArray<InstallStep> mInstallSteps;

    public static class ComponentStateMetrics {
        public int mCallingUid;
        private String mClassName;
        public int mComponentNewState;
        public int mComponentOldState;
        public boolean mIsForWholeApp;
        private String mPackageName;
        public int mUid;

        ComponentStateMetrics(PackageManager.ComponentEnabledSetting setting, int uid, int componentOldState, int callingUid) {
            this.mUid = uid;
            this.mComponentOldState = componentOldState;
            this.mComponentNewState = setting.getEnabledState();
            this.mIsForWholeApp = !setting.isComponent();
            this.mPackageName = setting.getPackageName();
            this.mClassName = setting.getClassName();
            this.mCallingUid = callingUid;
        }

        public boolean isLauncherActivity(Computer computer, int userId) {
            if (this.mIsForWholeApp == false) goto L5;
            return false;
        L5:
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(this.mPackageName);
            List<ResolveInfo> launcherActivities = computer.queryIntentActivitiesInternal(intent, null, 787008, 1000, userId);
            if (launcherActivities == null) goto L8;
            int launcherActivitiesSize = launcherActivities.size();
        L9:
            int i = 0;
        L10:
            if (i >= launcherActivitiesSize) goto L17;
            ResolveInfo resolveInfo = launcherActivities.get(i);
            if (isSameComponent(resolveInfo.activityInfo) == true) goto L13;
            i = i + 1;
            goto L10
        L13:
            return true;
        L17:
            return false;
        L8:
            launcherActivitiesSize = 0;
            goto L9
        }

        private boolean isSameComponent(ActivityInfo activityInfo) {
            if (activityInfo != null) goto L6;
            return false;
        L6:
            if (this.mIsForWholeApp == false) goto L9;
            return TextUtils.equals(activityInfo.packageName, this.mPackageName);
        L9:
            return activityInfo.getComponentName().equals(new ComponentName(this.mPackageName, this.mClassName));
        }
    }

    private static class InstallStep {
        private long mDurationMillis;
        private final long mStartTimestampMillis;

        InstallStep() {
            this.mDurationMillis = -1;
            this.mStartTimestampMillis = System.currentTimeMillis();
        }

        InstallStep(long durationMillis) {
            this.mDurationMillis = -1;
            this.mStartTimestampMillis = -1;
            this.mDurationMillis = durationMillis;
        }

        void finish() {
            this.mDurationMillis = System.currentTimeMillis() - this.mStartTimestampMillis;
        }

        long getDurationMillis() {
            return this.mDurationMillis;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StepInt {
    }

    PackageMetrics(InstallRequest installRequest) {
        this.mInstallSteps = new SparseArray();
        this.mInstallStartTimestampMillis = System.currentTimeMillis();
        this.mInstallRequest = installRequest;
    }

    public void onInstallSucceed() {
        reportInstallationToSecurityLog(this.mInstallRequest.getUserId());
        reportInstallationStats(true);
    }

    public void onInstallFailed() {
        reportInstallationStats(false);
    }

    private void reportInstallationStats(boolean success) {
        UserManagerInternal userManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        if (userManagerInternal != null) goto L5;
        return;
    L5:
        long installDurationMillis = System.currentTimeMillis() - this.mInstallStartTimestampMillis;
        Pair<int[], long[]> stepDurations = getInstallStepDurations();
        int[] newUsers = this.mInstallRequest.getNewUsers();
        int[] originalUsers = this.mInstallRequest.getOriginUsers();
        if (success == false) goto L8;
    L11:
        String packageName = null;
    L12:
        int installerPackageUid = this.mInstallRequest.getInstallerPackageUid();
        long versionCode = 0;
        long apksSize = 0;
        if (success == true) goto L15;
    L23:
        long versionCode2 = 0;
        long apksSize2 = 0;
    L24:
        FrameworkStatsLog.write(524, this.mInstallRequest.getSessionId(), packageName, getUid(this.mInstallRequest.getAppId(), this.mInstallRequest.getUserId()), newUsers, userManagerInternal.getUserTypesForStatsd(newUsers), originalUsers, userManagerInternal.getUserTypesForStatsd(originalUsers), this.mInstallRequest.getReturnCode(), this.mInstallRequest.getInternalErrorCode(), apksSize2, versionCode2, (int[]) stepDurations.first, (long[]) stepDurations.second, installDurationMillis, this.mInstallRequest.getInstallFlags(), installerPackageUid, -1, this.mInstallRequest.getDataLoaderType(), this.mInstallRequest.getRequireUserAction(), this.mInstallRequest.isInstantInstall(), this.mInstallRequest.isInstallReplace(), this.mInstallRequest.isInstallSystem(), this.mInstallRequest.isInstallInherit(), this.mInstallRequest.isInstallForUsers(), this.mInstallRequest.isInstallMove(), false, this.mInstallRequest.isDependencyInstallerEnabled(), this.mInstallRequest.getMissingSharedLibraryCount());
        return;
    L15:
        if (this.mInstallRequest.isInstallForUsers() == false) goto L20;
        AndroidPackage pkg = this.mInstallRequest.getPkg();
        if (pkg == null) goto L19;
        versionCode = pkg.getLongVersionCode();
        apksSize = getApksSize(new File(pkg.getPath()));
    L19:
        versionCode2 = versionCode;
        apksSize2 = apksSize;
        goto L24
    L20:
        PackageSetting ps = this.mInstallRequest.getScannedPackageSetting();
        if (ps == null) goto L23;
        long versionCode3 = ps.getVersionCode();
        long apksSize3 = getApksSize(ps.getPath());
        versionCode2 = versionCode3;
        apksSize2 = apksSize3;
        goto L24
    L8:
        if (this.mInstallRequest.isInstallFromAdb() == true) goto L11;
        packageName = this.mInstallRequest.getName();
        goto L12
    }

    private static int getUid(int appId, int userId) {
        if (userId != (-1)) goto L6;
        userId = ActivityManager.getCurrentUser();
    L6:
        return UserHandle.getUid(userId, appId);
    }

    private long getApksSize(final File apkDir) {
        final AtomicLong apksSize = new AtomicLong();
        Files.walkFileTree(apkDir.toPath(), new AnonymousClass1(this, apkDir, apksSize));     // Catch: IOException -> L5
    L7:
        return apksSize.get();
    }

    public void onStepStarted(int step) {
        this.mInstallSteps.put(step, new InstallStep());
    }

    public void onStepFinished(int step) {
        InstallStep installStep = this.mInstallSteps.get(step);
        if (installStep == null) goto L6;
        installStep.finish();
        return;
    }

    public void onStepFinished(int step, long durationMillis) {
        this.mInstallSteps.put(step, new InstallStep(durationMillis));
    }

    private Pair<int[], long[]> getInstallStepDurations() {
        ArrayList<Integer> steps = new ArrayList();
        ArrayList<Long> durations = new ArrayList();
        int i = 0;
    L4:
        if (i >= this.mInstallSteps.size()) goto L9;
        long duration = this.mInstallSteps.valueAt(i).getDurationMillis();
        if (duration < 0) goto L8;
        steps.add(Integer.valueOf(this.mInstallSteps.keyAt(i)));
        durations.add(Long.valueOf(this.mInstallSteps.valueAt(i).getDurationMillis()));
    L8:
        i = i + 1;
        goto L4
    L9:
        int i2 = steps.size();
        int[] stepsArray = new int[i2];
        long[] durationsArray = new long[durations.size()];
        int i3 = 0;
    L11:
        if (i3 >= stepsArray.length) goto L14;
        stepsArray[i3] = steps.get(i3).intValue();
        durationsArray[i3] = durations.get(i3).longValue();
        i3 = i3 + 1;
        goto L11
    L14:
        return new Pair(stepsArray, durationsArray);
    }

    public static void onUninstallSucceeded(PackageRemovedInfo info, int deleteFlags, int userId) {
        if (info.mIsUpdate == false) goto L5;
        return;
    L5:
        UserManagerInternal userManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        if (userManagerInternal != null) goto L8;
        return;
    L8:
        int[] removedUsers = info.mRemovedUsers;
        int[] removedUserTypes = userManagerInternal.getUserTypesForStatsd(removedUsers);
        int[] originalUsers = info.mOrigUsers;
        int[] originalUserTypes = userManagerInternal.getUserTypesForStatsd(originalUsers);
        FrameworkStatsLog.write(FrameworkStatsLog.PACKAGE_UNINSTALLATION_REPORTED, getUid(info.mUid, userId), removedUsers, removedUserTypes, originalUsers, originalUserTypes, deleteFlags, 1, info.mIsRemovedPackageSystemUpdate, !info.mRemovedForAllUsers);
        String packageName = info.mRemovedPackage;
        long versionCode = info.mRemovedPackageVersionCode;
        reportUninstallationToSecurityLog(packageName, versionCode, userId);
    }

    public static void onVerificationFailed(VerifyingSession verifyingSession) {
        FrameworkStatsLog.write(524, verifyingSession.getSessionId(), null, -1, null, null, null, null, verifyingSession.getRet(), 0, 0, 0, null, null, 0, 0, verifyingSession.getInstallerPackageUid(), -1, verifyingSession.getDataLoaderType(), verifyingSession.getUserActionRequiredType(), verifyingSession.isInstant(), false, false, verifyingSession.isInherit(), false, false, verifyingSession.isStaged(), false, 0);
    }

    static void onDependencyInstallationFailure(int sessionId, String packageName, int errorCode, int installerPackageUid, PackageInstaller.SessionParams params, int missingDependenciesCount) {
        if (params != null) goto L6;
        return;
    L6:
        if (params.dataLoaderParams == null) goto L8;
        int dataLoaderType = params.dataLoaderParams.getType();
        int dataLoaderType2 = dataLoaderType;
    L9:
        int dataLoaderType3 = params.requireUserAction;
        if ((params.installFlags & 2048) == 0) goto L12;
        boolean r25 = true;
    L14:
        if (params.mode != 2) goto L16;
        boolean r28 = true;
    L17:
        FrameworkStatsLog.write(524, sessionId, packageName, -1, null, null, null, null, errorCode, 0, 0, 0, null, null, 0, 0, installerPackageUid, -1, dataLoaderType2, dataLoaderType3, r25, false, false, r28, false, false, params.isStaged, true, missingDependenciesCount);
        return;
    L16:
        r28 = false;
        goto L17
    L12:
        r25 = false;
        goto L14
    L8:
        dataLoaderType2 = 0;
        goto L9
    }

    private void reportInstallationToSecurityLog(int userId) {
        if (SecurityLog.isLoggingEnabled() == true) goto L17;
        return;
    L17:
        PackageSetting ps = this.mInstallRequest.getScannedPackageSetting();     // Catch: Throwable -> L11
        if (ps != null) goto L8;
        return;
    L8:
        String packageName = ps.getPackageName();     // Catch: Throwable -> L11
        long versionCode = ps.getVersionCode();     // Catch: Throwable -> L11
        if (this.mInstallRequest.isInstallReplace() == true) goto L13;
        SecurityLog.writeEvent(210041, new Object[]{packageName, Long.valueOf(versionCode), Integer.valueOf(userId)});     // Catch: Throwable -> L11
    L16:
        return;
    L13:
        SecurityLog.writeEvent(210042, new Object[]{packageName, Long.valueOf(versionCode), Integer.valueOf(userId)});     // Catch: Throwable -> L11
    }

    private static void reportUninstallationToSecurityLog(String packageName, long versionCode, int userId) {
        if (SecurityLog.isLoggingEnabled() == true) goto L5;
        return;
    L5:
        SecurityLog.writeEvent(210043, new Object[]{packageName, Long.valueOf(versionCode), Integer.valueOf(userId)});
    }

    public static void reportComponentStateChanged(Computer computer, List<ComponentStateMetrics> componentStateMetricsList, int userId) {
        if (componentStateMetricsList != null) goto L4;
    L11:
        Slog.d(TAG, "Fail to report component state due to metrics is empty");
        return;
    L4:
        if (componentStateMetricsList.isEmpty() == true) goto L11;
        int metricsSize = componentStateMetricsList.size();
        int i = 0;
    L7:
        if (i >= metricsSize) goto L10;
        ComponentStateMetrics componentStateMetrics = componentStateMetricsList.get(i);
        reportComponentStateChanged(componentStateMetrics.mUid, componentStateMetrics.mComponentOldState, componentStateMetrics.mComponentNewState, componentStateMetrics.isLauncherActivity(computer, userId), componentStateMetrics.mIsForWholeApp, componentStateMetrics.mCallingUid);
        i = i + 1;
        goto L7
    }

    private static void reportComponentStateChanged(int uid, int componentOldState, int componentNewState, boolean isLauncher, boolean isForWholeApp, int callingUid) {
        FrameworkStatsLog.write(FrameworkStatsLog.COMPONENT_STATE_CHANGED_REPORTED, uid, componentOldState, componentNewState, isLauncher, isForWholeApp, callingUid);
    }
}
