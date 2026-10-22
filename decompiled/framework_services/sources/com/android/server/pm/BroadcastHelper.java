package com.android.server.pm;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.BroadcastOptions;
import android.app.IActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.IIntentReceiver;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.Trace;
import android.os.UserHandle;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.provider.DeviceConfig;
import android.text.TextUtils;
import android.util.IntArray;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.pm.pkg.component.ParsedActivity;
import com.android.internal.pm.pkg.component.ParsedProvider;
import com.android.internal.pm.pkg.component.ParsedService;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.PackageUserStateInternal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public final class BroadcastHelper {
    private static final boolean DEBUG_BROADCASTS = false;
    private final ActivityManagerInternal mAmInternal;
    private final AppsFilterSnapshot mAppsFilter;
    private final Context mContext;
    private final Handler mHandler;
    private final PackageMonitorCallbackHelper mPackageMonitorCallbackHelper;
    private final UserManagerInternal mUmInternal;

    public static /* synthetic */ Bundle $r8$lambda$0B9HCn1vf6QimS7wJUMJ9dvoh3c(Supplier r0, Integer r1, Bundle r2) {
        return lambda$sendResourcesChangedBroadcast$0(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$D70H7ky9q6h4G5Q35Lsgrv5YLOA(BroadcastHelper r0, boolean r1, int r2, Supplier r3, String[] r4, String r5) {
        r0.lambda$sendMyPackageSuspendedOrUnsuspended$8(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$LaHdmMUvJ9UawhmO5eyjF4t1D68(BroadcastHelper r0, String r1, int r2, int[] r3, int[] r4, boolean r5, int r6, SparseArray r7) {
        r0.lambda$sendPackageAddedForNewUsers$2(r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ void $r8$lambda$MJMB0qlrojqhYKHthOSSagY91y4(BroadcastHelper r0, String r1, boolean r2, ArrayList r3, int r4, String r5, int[] r6, int[] r7, SparseArray r8, PackageStateInternal r9, String[] r10, String r11, int r12) {
        r0.lambda$sendPackageChangedBroadcast$4(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    /* JADX INFO: renamed from: $r8$lambda$Oug9dEN74-YzL_S_zLOLodG8ONM, reason: not valid java name */
    public static /* synthetic */ void m6612$r8$lambda$Oug9dEN74YzL_S_zLOLodG8ONM(BroadcastHelper r0, int[] r1, String r2, boolean r3) {
        r0.lambda$sendPackageAddedForNewUsers$3(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$U8HVWwxx8XZlOvvlHzULhiCt5C4(BroadcastHelper r0, Bundle r1, int r2, Supplier r3) {
        r0.lambda$sendDistractingPackagesChanged$10(r1, r2, r3);
    }

    public static /* synthetic */ Bundle $r8$lambda$a2Z1Nu599yOcxet0uhIrvF8v35U(Supplier r0, Integer r1, Bundle r2) {
        return lambda$sendPackagesSuspendedOrUnsuspendedForUser$6(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$clcBGnQt-06kKHBsgiJHusWsyNs, reason: not valid java name */
    public static /* synthetic */ void m6613$r8$lambda$clcBGnQt06kKHBsgiJHusWsyNs(BroadcastHelper r0, String r1, String r2, Bundle r3, int r4, String r5, IIntentReceiver r6, int[] r7, int[] r8, SparseArray r9, Bundle r10) {
        r0.lambda$sendPackageBroadcastAndNotify$5(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ void $r8$lambda$i8o0iZdBhpYueYoVdN3iTtpw0PY(BroadcastHelper r0, String r1, Bundle r2, int r3, BiFunction r4, Bundle r5) {
        r0.lambda$sendPackagesSuspendedOrUnsuspendedForUser$7(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$nOHrbCKi_oIEn_MfbAgPLe4KPbA(int r0) {
        lambda$sendPreferredActivityChangedBroadcast$1(r0);
    }

    public static /* synthetic */ Bundle $r8$lambda$rnKNtcTVJ4yPTacJOjnngz30icw(Supplier r0, Integer r1, Bundle r2) {
        return lambda$sendDistractingPackagesChanged$9(r0, r1, r2);
    }

    BroadcastHelper(PackageManagerServiceInjector injector) {
        this.mUmInternal = injector.getUserManagerInternal();
        this.mAmInternal = injector.getActivityManagerInternal();
        this.mContext = injector.getContext();
        this.mHandler = injector.getHandler();
        this.mPackageMonitorCallbackHelper = injector.getPackageMonitorCallbackHelper();
        this.mAppsFilter = injector.getAppsFilter();
    }

    void sendPackageBroadcastWithIntent(Intent intent, int userId, boolean isInstantApp, int flags, int[] visibilityAllowList, IIntentReceiver finishedReceiver, BiFunction<Integer, Bundle, Bundle> filterExtrasForReceiver, Bundle bOptions) {
        intent.addFlags(67108864 | flags);
        SparseArray<int[]> broadcastAllowList = new SparseArray();
        broadcastAllowList.put(userId, visibilityAllowList);
        broadcastIntent(intent, finishedReceiver, isInstantApp, userId, broadcastAllowList, filterExtrasForReceiver, bOptions, null);
    }

    void sendPackageBroadcast(String action, String pkg, Bundle extras, int flags, String targetPkg, IIntentReceiver finishedReceiver, int[] userIds, int[] instantUserIds, SparseArray<int[]> broadcastAllowList, BiFunction<Integer, Bundle, Bundle> filterExtrasForReceiver, Bundle bOptions, String[] requiredPermissions) {
        IActivityManager am = ActivityManager.getService();     // Catch: RemoteException -> L7
        if (am != null) goto L5;
        return;
    L5:
        if (userIds != null) goto L9;
        int[] resolvedUserIds = am.getRunningUserIds();     // Catch: RemoteException -> L7
    L11:
        if (ArrayUtils.isEmpty(instantUserIds) == false) goto L13;
        doSendBroadcast(action, pkg, extras, flags, targetPkg, finishedReceiver, resolvedUserIds, false, broadcastAllowList, filterExtrasForReceiver, bOptions, requiredPermissions);     // Catch: RemoteException -> L7
        return;
    L13:
        doSendBroadcast(action, pkg, extras, flags, targetPkg, finishedReceiver, instantUserIds, true, null, null, bOptions, requiredPermissions);     // Catch: RemoteException -> L7
        return;
    L9:
        resolvedUserIds = userIds;
        goto L11
    }

    private void doSendBroadcast(String action, String pkg, Bundle extras, int flags, String targetPkg, IIntentReceiver finishedReceiver, int[] userIds, boolean isInstantApp, SparseArray<int[]> broadcastAllowList, BiFunction<Integer, Bundle, Bundle> filterExtrasForReceiver, Bundle bOptions, String[] requiredPermissions) {
        int r13 = userIds.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L24;
        int userId = userIds[r14];
        Uri r4 = null;
        if (pkg == null) goto L7;
        r4 = Uri.fromParts(Settings.ATTR_PACKAGE, pkg, null);
    L7:
        Intent intent = new Intent(action, r4);
        if (extras == null) goto L10;
        intent.putExtras(extras);
    L10:
        if (targetPkg == null) goto L12;
        intent.setPackage(targetPkg);
    L12:
        int uid = intent.getIntExtra("android.intent.extra.UID", -1);
        if (uid < 0) goto L18;
        if (UserHandle.getUserId(uid) == userId) goto L18;
        intent.putExtra("android.intent.extra.UID", UserHandle.getUid(userId, UserHandle.getAppId(uid)));
    L18:
        if (broadcastAllowList == 0) goto L22;
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(targetPkg) == false) goto L22;
        intent.putExtra("android.intent.extra.VISIBILITY_ALLOW_LIST", broadcastAllowList.get(userId));
    L22:
        intent.putExtra("android.intent.extra.user_handle", userId);
        intent.addFlags(flags | 67108864);
        broadcastIntent(intent, finishedReceiver, isInstantApp, userId, broadcastAllowList, filterExtrasForReceiver, bOptions, requiredPermissions);
        r14 = r14 + 1;
        goto L3
    }

    private void broadcastIntent(Intent intent, IIntentReceiver finishedReceiver, boolean isInstantApp, int userId, SparseArray<int[]> broadcastAllowList, BiFunction<Integer, Bundle, Bundle> filterExtrasForReceiver, Bundle bOptions, String[] requiredPermissions) {
        if (isInstantApp == false) goto L4;
        String[] requiredPermissions2 = (String[]) ArrayUtils.appendElement(String.class, requiredPermissions, "android.permission.ACCESS_INSTANT_APPS");
    L5:
        ActivityManagerInternal r1 = this.mAmInternal;
        if (broadcastAllowList != null) goto L9;
        int[] r0 = null;
    L10:
        r1.broadcastIntentWithCallback(intent, finishedReceiver, requiredPermissions2, userId, r0, filterExtrasForReceiver, bOptions);
        return;
    L9:
        r0 = broadcastAllowList.get(userId);
        goto L10
    L4:
        requiredPermissions2 = requiredPermissions;
        goto L5
    }

    void sendResourcesChangedBroadcast(final Supplier<Computer> snapshotSupplier, boolean mediaStatus, boolean replacing, String[] pkgNames, int[] uids) {
        if (ArrayUtils.isEmpty(pkgNames) == true) goto L16;
        if (ArrayUtils.isEmpty(uids) == true) goto L17;
        Bundle extras = new Bundle();
        extras.putStringArray("android.intent.extra.changed_package_list", pkgNames);
        extras.putIntArray("android.intent.extra.changed_uid_list", uids);
        if (replacing == false) goto L10;
        extras.putBoolean("android.intent.extra.REPLACING", replacing);
    L10:
        if (mediaStatus == false) goto L12;
        String action = "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
    L13:
        sendPackageBroadcast(action, null, extras, 0, null, null, null, null, null, new BroadcastHelper$$ExternalSyntheticLambda0(snapshotSupplier), null, null);
        return;
    L12:
        action = "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
        goto L13
    L17:
        return;
    }

    private static /* synthetic */ Bundle lambda$sendResourcesChangedBroadcast$0(Supplier snapshotSupplier, Integer callingUid, Bundle intentExtras) {
        return filterExtrasChangedPackageList(snapshotSupplier, callingUid.intValue(), intentExtras);
    }

    private void sendBootCompletedBroadcastToSystemApp(String packageName, boolean includeStopped, int userId) {
        if (this.mUmInternal.isUserRunning(userId) == true) goto L5;
        return;
    L5:
        IActivityManager am = ActivityManager.getService();
        Intent lockedBcIntent = new Intent("android.intent.action.LOCKED_BOOT_COMPLETED").setPackage(packageName);     // Catch: RemoteException -> L30
        lockedBcIntent.putExtra("android.intent.extra.user_handle", userId);     // Catch: RemoteException -> L30
        if (includeStopped == true) goto L41;
    L13:
        String[] requiredPermissions = {"android.permission.RECEIVE_BOOT_COMPLETED"};     // Catch: RemoteException -> L30
        BroadcastOptions bOptions = getTemporaryAppAllowlistBroadcastOptions(202);     // Catch: RemoteException -> L30
        am.broadcastIntentWithFeature(null, null, lockedBcIntent, null, null, 0, null, null, requiredPermissions, null, null, -1, bOptions.toBundle(), false, false, userId);     // Catch: RemoteException -> L28
        am = am;
        if (this.mUmInternal.isUserUnlockingOrUnlocked(userId) == false) goto L34;
        Intent bcIntent = new Intent("android.intent.action.BOOT_COMPLETED").setPackage(packageName);     // Catch: RemoteException -> L30
        bcIntent.putExtra("android.intent.extra.user_handle", userId);     // Catch: RemoteException -> L30
        if (includeStopped == true) goto L22;
    L24:
        am.broadcastIntentWithFeature(null, null, bcIntent, null, null, 0, null, null, requiredPermissions, null, null, -1, bOptions.toBundle(), false, false, userId);     // Catch: RemoteException -> L28
        return;
    L22:
        bcIntent.addFlags(32);     // Catch: RemoteException -> L11
    L11:
        e = e;
    L36:
        throw e.rethrowFromSystemServer();
    L34:
        return;
    L28:
        e = e;
        goto L36
    L41:
        lockedBcIntent.addFlags(32);     // Catch: RemoteException -> L11
    L30:
        e = e;
        goto L36
    }

    private BroadcastOptions getTemporaryAppAllowlistBroadcastOptions(int reasonCode) {
        if (this.mAmInternal == null) goto L5;
        long duration = this.mAmInternal.getBootTimeTempAllowListDuration();
        long duration2 = duration;
    L6:
        BroadcastOptions bOptions = BroadcastOptions.makeBasic();
        bOptions.setTemporaryAppAllowlist(duration2, 0, reasonCode, "");
        return bOptions;
    L5:
        duration2 = 10000;
        goto L6
    }

    private ArrayList<String> getAllNotExportedComponents(AndroidPackage pkg, ArrayList<String> inputComponentNames) {
        ArrayList<String> outputNotExportedComponentNames = new ArrayList();
        int remainingComponentCount = inputComponentNames.size();
        Iterator r2 = pkg.getReceivers().iterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        ParsedActivity component = (ParsedActivity) r2.next();
        if (inputComponentNames.contains(component.getClassName()) == false) goto L4;
        if (component.isExported() == true) goto L10;
        outputNotExportedComponentNames.add(component.getClassName());
    L10:
        remainingComponentCount = remainingComponentCount - 1;
        if (remainingComponentCount > 0) goto L4;
        return outputNotExportedComponentNames;
    L14:
        Iterator r3 = pkg.getProviders().iterator();
    L16:
        if (r3.hasNext() == false) goto L26;
        ParsedProvider component2 = (ParsedProvider) r3.next();
        if (inputComponentNames.contains(component2.getClassName()) == false) goto L16;
        if (component2.isExported() == true) goto L22;
        outputNotExportedComponentNames.add(component2.getClassName());
    L22:
        remainingComponentCount = remainingComponentCount - 1;
        if (remainingComponentCount > 0) goto L16;
        return outputNotExportedComponentNames;
    L26:
        Iterator r4 = pkg.getServices().iterator();
    L28:
        if (r4.hasNext() == false) goto L38;
        ParsedService component3 = (ParsedService) r4.next();
        if (inputComponentNames.contains(component3.getClassName()) == false) goto L28;
        if (component3.isExported() == true) goto L34;
        outputNotExportedComponentNames.add(component3.getClassName());
    L34:
        remainingComponentCount = remainingComponentCount - 1;
        if (remainingComponentCount > 0) goto L28;
        return outputNotExportedComponentNames;
    L38:
        Iterator r5 = pkg.getActivities().iterator();
    L40:
        if (r5.hasNext() == false) goto L50;
        ParsedActivity component4 = (ParsedActivity) r5.next();
        if (inputComponentNames.contains(component4.getClassName()) == false) goto L40;
        if (component4.isExported() == true) goto L46;
        outputNotExportedComponentNames.add(component4.getClassName());
    L46:
        remainingComponentCount = remainingComponentCount - 1;
        if (remainingComponentCount > 0) goto L40;
        return outputNotExportedComponentNames;
    L50:
        return outputNotExportedComponentNames;
    }

    private void sendPackageChangedBroadcastInternal(String packageName, boolean dontKillApp, ArrayList<String> componentNames, int packageUid, String reason, int[] userIds, int[] instantUserIds, SparseArray<int[]> broadcastAllowList, AndroidPackage pkg, String[] sharedUidPackages, String reasonForTrace, int callingUidForTrace) {
        boolean isForWholeApp = componentNames.contains(packageName);
        String callingPackageNameForTrace = this.mContext.getPackageManager().getNameForUid(callingUidForTrace);
        if (isForWholeApp == true) goto L25;
        ArrayList<String> notExportedComponentNames = getAllNotExportedComponents(pkg, componentNames);
        ArrayList<String> exportedComponentNames = (ArrayList) componentNames.clone();
        exportedComponentNames.removeAll(notExportedComponentNames);
        if (notExportedComponentNames.isEmpty() == false) goto L7;
        String callingPackageNameForTrace2 = callingPackageNameForTrace;
        ArrayList<String> exportedComponentNames2 = exportedComponentNames;
    L21:
        if (exportedComponentNames2.isEmpty() == true) goto L24;
        tracePackageChangedBroadcastEvent(true, reasonForTrace, packageName, "<implicit>", "exported", exportedComponentNames2.size(), callingPackageNameForTrace2);
        sendPackageChangedBroadcastWithPermissions(packageName, dontKillApp, exportedComponentNames2, packageUid, reason, userIds, instantUserIds, broadcastAllowList, null, null);
        return;
    L24:
        return;
    L7:
        if (TextUtils.equals(packageName, PackageManagerService.PLATFORM_PACKAGE_NAME) == true) goto L9;
        tracePackageChangedBroadcastEvent(true, reasonForTrace, packageName, PackageManagerService.PLATFORM_PACKAGE_NAME, "notExported", notExportedComponentNames.size(), callingPackageNameForTrace);
        callingPackageNameForTrace2 = callingPackageNameForTrace;
        exportedComponentNames2 = exportedComponentNames;
        sendPackageChangedBroadcastWithPermissions(packageName, dontKillApp, notExportedComponentNames, packageUid, reason, userIds, instantUserIds, broadcastAllowList, PackageManagerService.PLATFORM_PACKAGE_NAME, null);
        ArrayList<String> notExportedComponentNames2 = notExportedComponentNames;
    L10:
        tracePackageChangedBroadcastEvent(true, reasonForTrace, packageName, packageName, "notExported", notExportedComponentNames2.size(), callingPackageNameForTrace2);
        String r1 = packageName;
        ArrayList<String> notExportedComponentNames3 = notExportedComponentNames2;
        sendPackageChangedBroadcastWithPermissions(r1, dontKillApp, notExportedComponentNames3, packageUid, reason, userIds, instantUserIds, broadcastAllowList, packageName, null);
        ArrayList<String> notExportedComponentNames4 = notExportedComponentNames3;
        int i = 0;
    L12:
        if (i >= sharedUidPackages.length) goto L21;
        String sharedPackage = sharedUidPackages[i];
        if (TextUtils.equals(r1, sharedPackage) == false) goto L16;
        ArrayList<String> notExportedComponentNames5 = notExportedComponentNames4;
    L17:
        i = i + 1;
        r1 = packageName;
        notExportedComponentNames4 = notExportedComponentNames5;
        goto L12
    L16:
        tracePackageChangedBroadcastEvent(true, reasonForTrace, r1, sharedPackage, "notExported", notExportedComponentNames4.size(), callingPackageNameForTrace2);
        ArrayList<String> notExportedComponentNames6 = notExportedComponentNames4;
        sendPackageChangedBroadcastWithPermissions(packageName, dontKillApp, notExportedComponentNames6, packageUid, reason, userIds, instantUserIds, broadcastAllowList, sharedPackage, null);
        notExportedComponentNames5 = notExportedComponentNames6;
        goto L17
    L9:
        callingPackageNameForTrace2 = callingPackageNameForTrace;
        notExportedComponentNames2 = notExportedComponentNames;
        exportedComponentNames2 = exportedComponentNames;
        goto L10
    L25:
        tracePackageChangedBroadcastEvent(true, reasonForTrace, packageName, "<implicit>", "whole", componentNames.size(), callingPackageNameForTrace);
        sendPackageChangedBroadcastWithPermissions(packageName, dontKillApp, componentNames, packageUid, reason, userIds, instantUserIds, broadcastAllowList, null, null);
    }

    private void sendPackageChangedBroadcastWithPermissions(String packageName, boolean dontKillApp, ArrayList<String> componentNames, int packageUid, String reason, int[] userIds, int[] instantUserIds, SparseArray<int[]> broadcastAllowList, String targetPackageName, String[] requiredPermissions) {
        Bundle extras = new Bundle(4);
        int r2 = 0;
        extras.putString("android.intent.extra.changed_component_name", componentNames.get(0));
        String[] nameList = new String[componentNames.size()];
        componentNames.toArray(nameList);
        extras.putStringArray("android.intent.extra.changed_component_name_list", nameList);
        extras.putBoolean("android.intent.extra.DONT_KILL_APP", dontKillApp);
        extras.putInt("android.intent.extra.UID", packageUid);
        if (reason == null) goto L6;
        extras.putString("android.intent.extra.REASON", reason);
    L6:
        if (componentNames.contains(packageName) == true) goto L8;
        r2 = 1073741824;
    L8:
        int flags = r2;
        sendPackageBroadcast("android.intent.action.PACKAGE_CHANGED", packageName, extras, flags, targetPackageName, null, userIds, instantUserIds, broadcastAllowList, null, null, requiredPermissions);
    }

    static void sendDeviceCustomizationReadyBroadcast() {
        Intent intent = new Intent("android.intent.action.DEVICE_CUSTOMIZATION_READY");
        intent.setFlags(16777216);
        IActivityManager am = ActivityManager.getService();
        String[] requiredPermissions = {"android.permission.RECEIVE_DEVICE_CUSTOMIZATION_READY"};
        am.broadcastIntentWithFeature(null, null, intent, null, null, 0, null, null, requiredPermissions, null, null, -1, null, false, false, -1);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    void sendSessionCommitBroadcast(Computer snapshot, PackageInstaller.SessionInfo sessionInfo, int userId, String appPredictionServicePackage) {
        UserManagerService ums = UserManagerService.getInstance();
        if (ums != null) goto L5;
        return;
    L5:
        if (sessionInfo.isStaged() == true) goto L21;
        UserInfo parent = ums.getProfileParent(userId);
        if (parent == null) goto L10;
        int launcherUserId = parent.id;
    L11:
        ComponentName launcherComponent = snapshot.getDefaultHomeActivity(launcherUserId);
        if (launcherComponent != null) goto L14;
    L16:
        if (appPredictionServicePackage == null) goto L20;
        Intent predictorIntent = new Intent("android.content.pm.action.SESSION_COMMITTED").putExtra("android.content.pm.extra.SESSION", sessionInfo).putExtra("android.intent.extra.USER", UserHandle.of(userId)).setPackage(appPredictionServicePackage);
        this.mContext.sendBroadcastAsUser(predictorIntent, UserHandle.of(launcherUserId));
        return;
    L20:
        return;
    L14:
        if (canLauncherAccessProfile(launcherComponent, userId) == false) goto L16;
        Intent launcherIntent = new Intent("android.content.pm.action.SESSION_COMMITTED").putExtra("android.content.pm.extra.SESSION", sessionInfo).putExtra("android.intent.extra.USER", UserHandle.of(userId)).setPackage(launcherComponent.getPackageName());
        this.mContext.sendBroadcastAsUser(launcherIntent, UserHandle.of(launcherUserId));
        goto L16
    L10:
        launcherUserId = userId;
        goto L11
    }

    boolean canLauncherAccessProfile(ComponentName launcherComponent, int userId) {
        if (this.mUmInternal.getUserProperties(userId).getProfileApiVisibility() == 1) goto L6;
        return true;
    L6:
        if (this.mContext.getPackageManager().checkPermission("android.permission.ACCESS_HIDDEN_PROFILES_FULL", launcherComponent.getPackageName()) != 0) goto L9;
        return true;
    L9:
        if (this.mContext.getPackageManager().checkPermission("android.permission.ACCESS_HIDDEN_PROFILES", launcherComponent.getPackageName()) == 0) goto L13;
        return false;
    L13:
        return true;
    }

    void sendPreferredActivityChangedBroadcast(final int userId) {
        this.mHandler.post(new BroadcastHelper$$ExternalSyntheticLambda7(userId));
    }

    private static /* synthetic */ void lambda$sendPreferredActivityChangedBroadcast$1(int userId) {
        IActivityManager am = ActivityManager.getService();
        if (am != null) goto L5;
        return;
    L5:
        Intent intent = new Intent("android.intent.action.ACTION_PREFERRED_ACTIVITY_CHANGED");
        intent.putExtra("android.intent.extra.user_handle", userId);
        intent.addFlags(67108864);
        am.broadcastIntentWithFeature(null, null, intent, null, null, 0, null, null, null, null, null, -1, null, false, false, userId);     // Catch: RemoteException -> L8
        return;
    }

    void sendPostInstallBroadcasts(Supplier<Computer> snapshotSupplier, InstallRequest request, String packageName, String requiredPermissionControllerPackage, String[] requiredVerifierPackages, String requiredInstallerPackage, PackageSender packageSender, boolean isLaunchedForRestore, boolean isKillApp, boolean isUpdate, boolean isArchived) {
        if (request.getRemovedInfo() != null) goto L5;
    L8:
        int[] firstUserIds = request.getFirstTimeBroadcastUserIds();
        int[] firstInstantUserIds = request.getFirstTimeBroadcastInstantUserIds();
        int[] updateUserIds = request.getUpdateBroadcastUserIds();
        int[] instantUserIds = request.getUpdateBroadcastInstantUserIds();
        if (request.getInstallerPackageName() == null) goto L12;
        String installerPackageName = request.getInstallerPackageName();
    L15:
        Bundle extras = new Bundle();
        extras.putInt("android.intent.extra.UID", request.getAppId());
        if (isUpdate == false) goto L18;
        extras.putBoolean("android.intent.extra.REPLACING", true);
    L18:
        if (isArchived == false) goto L20;
        extras.putBoolean("android.intent.extra.ARCHIVAL", true);
    L20:
        extras.putInt("android.content.pm.extra.DATA_LOADER_TYPE", request.getDataLoaderType());
        String staticSharedLibraryName = request.getPkg().getStaticSharedLibraryName();
        if (installerPackageName == null) goto L24;
        if (staticSharedLibraryName == null) goto L24;
        int[] updateUserIds2 = updateUserIds;
        sendPackageBroadcastAndNotify("android.intent.action.PACKAGE_ADDED", packageName, extras, 0, installerPackageName, null, request.getNewUsers(), null, null, null);
    L25:
        Computer snapshot = snapshotSupplier.get();
        if (staticSharedLibraryName != null) goto L82;
        int appId = UserHandle.getAppId(request.getAppId());
        boolean isSystem = request.isInstallSystem();
        if ((request.getInstallFlags() & 65536) == 0) goto L30;
        boolean isVirtualPreload = true;
    L31:
        if (isSystem == true) goto L35;
        if (isVirtualPreload == true) goto L35;
        boolean r3 = false;
    L36:
        sendPackageAddedForNewUsers(snapshot, packageName, r3, isVirtualPreload, appId, firstUserIds, firstInstantUserIds, isArchived, request.getDataLoaderType());
        SparseArray<int[]> newBroadcastAllowList = this.mAppsFilter.getVisibilityAllowList(snapshot, snapshot.getPackageStateInternal(packageName, 1000), updateUserIds2, snapshot.getPackageStates());
        Bundle extras2 = extras;
        int[] updateUserIds3 = updateUserIds2;
        sendPackageBroadcastAndNotify("android.intent.action.PACKAGE_ADDED", packageName, extras2, 0, null, null, updateUserIds3, instantUserIds, newBroadcastAllowList, null);
        if (installerPackageName == 0) goto L39;
        BroadcastHelper r0 = this;
        String installerPackageName2 = installerPackageName;
        r0.sendPackageBroadcastAndNotify("android.intent.action.PACKAGE_ADDED", packageName, extras2, 0, installerPackageName2, null, updateUserIds3, instantUserIds, null, null);
    L41:
        if (isPrivacySafetyLabelChangeNotificationsEnabled(r0.mContext) == false) goto L44;
        r0.sendPackageBroadcastAndNotify("android.intent.action.PACKAGE_ADDED", packageName, extras2, 0, requiredPermissionControllerPackage, null, updateUserIds3, instantUserIds, null, null);
    L44:
        int r1 = requiredVerifierPackages.length;
        int r2 = 0;
    L45:
        if (r2 >= r1) goto L53;
        String verifierPackageName = requiredVerifierPackages[r2];
        if (verifierPackageName != null) goto L49;
    L51:
        int r24 = r2;
    L52:
        r2 = r24 + 1;
        r1 = r1;
        updateUserIds3 = updateUserIds3;
        goto L45
    L49:
        if (verifierPackageName.equals(installerPackageName2) == true) goto L51;
        r24 = r2;
        sendPackageBroadcastAndNotify("android.intent.action.PACKAGE_ADDED", packageName, extras2, 0, verifierPackageName, null, updateUserIds3, instantUserIds, null, null);
        goto L52
    L53:
        int[] updateUserIds4 = updateUserIds3;
        sendPackageBroadcastAndNotify("android.intent.action.PACKAGE_ADDED", packageName, extras2, 16777216, requiredInstallerPackage, null, firstUserIds, instantUserIds, null, null);
        if (isUpdate == false) goto L68;
        sendPackageBroadcastAndNotify("android.intent.action.PACKAGE_REPLACED", packageName, extras2, 0, null, null, updateUserIds4, instantUserIds, request.getRemovedInfo().mBroadcastAllowList, null);
        if (installerPackageName2 == 0) goto L58;
        sendPackageBroadcastAndNotify("android.intent.action.PACKAGE_REPLACED", packageName, extras2, 0, installerPackageName2, null, updateUserIds4, instantUserIds, null, null);
    L58:
        int r4 = requiredVerifierPackages.length;
        int r5 = 0;
    L59:
        if (r5 >= r4) goto L67;
        String verifierPackageName2 = requiredVerifierPackages[r5];
        if (verifierPackageName2 != null) goto L63;
    L65:
        int r23 = r5;
    L66:
        r5 = r23 + 1;
        r4 = r4;
        extras2 = extras2;
        goto L59
    L63:
        if (verifierPackageName2.equals(installerPackageName2) == true) goto L65;
        r23 = r5;
        sendPackageBroadcastAndNotify("android.intent.action.PACKAGE_REPLACED", packageName, extras2, 0, verifierPackageName2, null, updateUserIds4, instantUserIds, null, null);
        goto L66
    L67:
        BroadcastHelper r6 = this;
        r6.sendPackageBroadcastAndNotify("android.intent.action.MY_PACKAGE_REPLACED", null, null, 0, packageName, null, updateUserIds4, instantUserIds, null, r6.getTemporaryAppAllowlistBroadcastOptions(311).toBundle());
        String r9 = packageName;
    L74:
        if (request.getPkg().isExternalStorage() == false) goto L98;
        if (isUpdate == true) goto L79;
        StorageManager storage = (StorageManager) r6.mContext.getSystemService(StorageManager.class);
        VolumeInfo volume = storage.findVolumeByUuid(StorageManager.convert(request.getPkg().getVolumeUuid()).toString());
        int packageExternalStorageType = PackageManagerServiceUtils.getPackageExternalStorageType(volume, true);
        if (packageExternalStorageType == 0) goto L79;
        FrameworkStatsLog.write(181, packageExternalStorageType, r9);
    L79:
        if (isArchived == true) goto L98;
        String[] pkgNames = {r9};
        int[] uids = {request.getPkg().getUid()};
        r6.sendResourcesChangedBroadcast(snapshotSupplier, true, true, pkgNames, uids);
        r6.notifyResourcesChanged(true, true, pkgNames, uids);
    L98:
        return;
    L68:
        r6 = this;
        r9 = packageName;
        if (isLaunchedForRestore == false) goto L74;
        if (request.isInstallSystem() == true) goto L74;
        r6.sendFirstLaunchBroadcast(r9, installerPackageName2, firstUserIds, firstInstantUserIds);
        goto L74
    L39:
        r0 = this;
        installerPackageName2 = installerPackageName;
    L35:
        r3 = true;
        goto L36
    L30:
        isVirtualPreload = false;
        goto L31
    L82:
        Computer snapshot2 = snapshot;
        ArrayList<AndroidPackage> libraryConsumers = request.getLibraryConsumers();
        if (ArrayUtils.isEmpty(libraryConsumers) == true) goto L90;
        boolean dontKillApp = !isUpdate;
        int i = 0;
    L86:
        if (i >= libraryConsumers.size()) goto L99;
        AndroidPackage pkg = libraryConsumers.get(i);
        int i2 = i;
        String r7 = pkg.getPackageName();
        ArrayList<String> r8 = new ArrayList(Collections.singletonList(pkg.getPackageName()));
        int i3 = pkg.getUid();
        Computer snapshot3 = snapshot2;
        sendPackageChangedBroadcast(snapshot3, r7, dontKillApp, r8, i3, null, "static_shared_library_changed", 1000);
        i = i2 + 1;
        snapshot2 = snapshot3;
        libraryConsumers = libraryConsumers;
        goto L86
    L99:
        return;
    L90:
        return;
    L24:
        updateUserIds2 = updateUserIds;
        goto L25
    L12:
        if (request.getRemovedInfo() == null) goto L14;
        installerPackageName = request.getRemovedInfo().mInstallerPackageName;
        goto L15
    L14:
        installerPackageName = null;
        goto L15
    L5:
        if (request.getRemovedInfo().mIsExternal == false) goto L7;
        String[] pkgNames2 = {request.getRemovedInfo().mRemovedPackage};
        int[] uids2 = {request.getRemovedInfo().mUid};
        notifyResourcesChanged(false, true, pkgNames2, uids2);
        sendResourcesChangedBroadcast(snapshotSupplier, false, true, pkgNames2, uids2);
    L7:
        sendPackageRemovedBroadcasts(request.getRemovedInfo(), packageSender, isKillApp, false, false);
        goto L8
    }

    private void sendPackageAddedForNewUsers(Computer snapshot, final String packageName, boolean sendBootCompleted, final boolean includeStopped, final int appId, final int[] userIds, final int[] instantUserIds, final boolean isArchived, final int dataLoaderType) {
        if (ArrayUtils.isEmpty(userIds) == true) goto L5;
    L7:
        final SparseArray<int[]> broadcastAllowList = this.mAppsFilter.getVisibilityAllowList(snapshot, snapshot.getPackageStateInternal(packageName, 1000), userIds, snapshot.getPackageStates());
        this.mHandler.post(new BroadcastHelper$$ExternalSyntheticLambda4(this, packageName, appId, userIds, instantUserIds, isArchived, dataLoaderType, broadcastAllowList));
        this.mPackageMonitorCallbackHelper.notifyPackageAddedForNewUsers(packageName, appId, userIds, instantUserIds, isArchived, dataLoaderType, broadcastAllowList, this.mHandler);
        if (sendBootCompleted == true) goto L10;
        return;
    L10:
        if (ArrayUtils.isEmpty(userIds) == true) goto L14;
        this.mHandler.post(new BroadcastHelper$$ExternalSyntheticLambda5(this, userIds, packageName, includeStopped));
        return;
    L14:
        return;
    L5:
        if (ArrayUtils.isEmpty(instantUserIds) == false) goto L7;
    }

    private /* synthetic */ void lambda$sendPackageAddedForNewUsers$2(String packageName, int appId, int[] userIds, int[] instantUserIds, boolean isArchived, int dataLoaderType, SparseArray broadcastAllowList) {
        sendPackageAddedForNewUsers(packageName, appId, userIds, instantUserIds, isArchived, dataLoaderType, broadcastAllowList);
    }

    private /* synthetic */ void lambda$sendPackageAddedForNewUsers$3(int[] userIds, String packageName, boolean includeStopped) {
        int r0 = userIds.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int userId = userIds[r1];
        sendBootCompletedBroadcastToSystemApp(packageName, includeStopped, userId);
        r1 = r1 + 1;
        goto L3
    }

    private void sendPackageAddedForNewUsers(String packageName, int appId, int[] userIds, int[] instantUserIds, boolean isArchived, int dataLoaderType, SparseArray<int[]> broadcastAllowlist) {
        Bundle extras = new Bundle(1);
        if (ArrayUtils.isEmpty(userIds) == false) goto L5;
        int r1 = instantUserIds[0];
    L6:
        int uid = UserHandle.getUid(r1, appId);
        extras.putInt("android.intent.extra.UID", uid);
        if (isArchived == false) goto L9;
        extras.putBoolean("android.intent.extra.ARCHIVAL", true);
    L9:
        extras.putInt("android.content.pm.extra.DATA_LOADER_TYPE", dataLoaderType);
        sendPackageBroadcast("android.intent.action.PACKAGE_ADDED", packageName, extras, 0, null, null, userIds, instantUserIds, broadcastAllowlist, null, null, null);
        if (isPrivacySafetyLabelChangeNotificationsEnabled(this.mContext) == false) goto L13;
        sendPackageBroadcast("android.intent.action.PACKAGE_ADDED", packageName, extras, 0, this.mContext.getPackageManager().getPermissionControllerPackageName(), null, userIds, instantUserIds, broadcastAllowlist, null, null, null);
        return;
    L13:
        return;
    L5:
        r1 = userIds[0];
        goto L6
    }

    void sendPackageAddedForUser(Computer snapshot, String packageName, PackageStateInternal packageState, int userId, boolean isArchived, int dataLoaderType, String appPredictionServicePackage) {
        PackageUserStateInternal userState = packageState.getUserStateOrDefault(userId);
        boolean isSystem = packageState.isSystem();
        boolean isInstantApp = userState.isInstantApp();
        if (isInstantApp == false) goto L6;
        int[] r4 = PackageManagerService.EMPTY_INT_ARRAY;
    L5:
        int[] userIds = r4;
        if (isInstantApp == false) goto L10;
        int[] r3 = {userId};
    L9:
        int[] instantUserIds = r3;
        sendPackageAddedForNewUsers(snapshot, packageName, isSystem, false, packageState.getAppId(), userIds, instantUserIds, isArchived, dataLoaderType);
        PackageInstaller.SessionInfo info = new PackageInstaller.SessionInfo();
        info.installReason = userState.getInstallReason();
        info.appPackageName = packageName;
        sendSessionCommitBroadcast(snapshot, info, userId, appPredictionServicePackage);
        return;
    L10:
        r3 = PackageManagerService.EMPTY_INT_ARRAY;
        goto L9
    L6:
        r4 = new int[]{userId};
        goto L5
    }

    void sendFirstLaunchBroadcast(String pkgName, String installerPkg, int[] userIds, int[] instantUserIds) {
        sendPackageBroadcast("android.intent.action.PACKAGE_FIRST_LAUNCH", pkgName, null, 0, installerPkg, null, userIds, instantUserIds, null, null, null, null);
    }

    private static Bundle filterExtrasChangedPackageList(Supplier<Computer> snapshotSupplier, int callingUid, Bundle extras) {
        if (UserHandle.isCore(callingUid) == false) goto L5;
        return extras;
    L5:
        String[] pkgs = extras.getStringArray("android.intent.extra.changed_package_list");
        if (ArrayUtils.isEmpty(pkgs) == false) goto L8;
        return extras;
    L8:
        int userId = extras.getInt("android.intent.extra.user_handle", UserHandle.getUserId(callingUid));
        int[] uids = extras.getIntArray("android.intent.extra.changed_uid_list");
        Computer snapshot = snapshotSupplier.get();
        Pair<String[], int[]> filteredPkgs = filterPackages(snapshot, pkgs, uids, callingUid, userId);
        if (ArrayUtils.isEmpty((String[]) filteredPkgs.first) == false) goto L12;
        return null;
    L12:
        Bundle filteredExtras = new Bundle(extras);
        filteredExtras.putStringArray("android.intent.extra.changed_package_list", (String[]) filteredPkgs.first);
        filteredExtras.putIntArray("android.intent.extra.changed_uid_list", (int[]) filteredPkgs.second);
        return filteredExtras;
    }

    private static boolean isPrivacySafetyLabelChangeNotificationsEnabled(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (DeviceConfig.getBoolean("privacy", "safety_label_change_notifications_enabled", true) == true) goto L5;
    L11:
        return false;
    L5:
        if (packageManager.hasSystemFeature("android.hardware.type.automotive") == true) goto L11;
        if (packageManager.hasSystemFeature("android.software.leanback") == true) goto L11;
        if (packageManager.hasSystemFeature("android.hardware.type.watch") == true) goto L11;
        return true;
    }

    private static Pair<String[], int[]> filterPackages(Computer snapshot, String[] pkgs, int[] uids, int callingUid, int userId) {
        int pkgSize = pkgs.length;
        if (ArrayUtils.isEmpty(uids) == true) goto L5;
        int uidSize = uids.length;
    L6:
        ArrayList<String> pkgList = new ArrayList(pkgSize);
        int[] r3 = null;
        if (uidSize <= 0) goto L9;
        IntArray uidList = new IntArray(uidSize);
    L10:
        int i = 0;
    L11:
        if (i >= pkgSize) goto L21;
        String packageName = pkgs[i];
        if (snapshot.shouldFilterApplication(snapshot.getPackageStateInternal(packageName), callingUid, userId) == true) goto L19;
        pkgList.add(packageName);
        if (uidList == null) goto L19;
        if (i >= uidSize) goto L19;
        uidList.add(uids[i]);
    L19:
        i = i + 1;
        goto L11
    L21:
        if (pkgList.size() <= 0) goto L23;
        String[] r6 = (String[]) pkgList.toArray(new String[pkgList.size()]);
    L24:
        if (uidList == null) goto L29;
        if (uidList.size() <= 0) goto L29;
        r3 = uidList.toArray();
    L29:
        return new Pair(r6, r3);
    L23:
        r6 = null;
        goto L24
    L9:
        uidList = null;
        goto L10
    L5:
        uidSize = 0;
        goto L6
    }

    void sendApplicationHiddenForUser(String packageName, PackageStateInternal packageState, int userId, PackageSender packageSender) {
        PackageRemovedInfo info = new PackageRemovedInfo();
        info.mRemovedPackage = packageName;
        info.mInstallerPackageName = packageState.getInstallSource().mInstallerPackageName;
        info.mRemovedUsers = new int[]{userId};
        info.mBroadcastUsers = new int[]{userId};
        info.mUid = UserHandle.getUid(userId, packageState.getAppId());
        info.mRemovedPackageVersionCode = packageState.getVersionCode();
        sendPackageRemovedBroadcasts(info, packageSender, true, false, false);
    }

    void sendPackageChangedBroadcast(Computer snapshot, final String packageName, final boolean dontKillApp, final ArrayList<String> componentNames, final int packageUid, final String reason, final String reasonForTrace, final int callingUidForTrace) {
        final PackageStateInternal setting = snapshot.getPackageStateInternal(packageName, 1000);
        if (setting == null) goto L23;
        if (setting.getPkg() == null) goto L24;
        int userId = UserHandle.getUserId(packageUid);
        boolean isInstantApp = snapshot.isInstantAppInternal(packageName, userId, 1000);
        if (isInstantApp == false) goto L11;
        int[] r4 = PackageManagerService.EMPTY_INT_ARRAY;
    L10:
        final int[] userIds = r4;
        if (isInstantApp == false) goto L15;
        int[] r3 = {userId};
    L14:
        final int[] instantUserIds = r3;
        if (isInstantApp == false) goto L19;
        SparseArray<int[]> r0 = null;
    L18:
        final SparseArray<int[]> broadcastAllowList = r0;
        final String[] sharedUserPackages = snapshot.getSharedUserPackagesForPackage(packageName, userId);
        this.mHandler.post(new BroadcastHelper$$ExternalSyntheticLambda3(this, packageName, dontKillApp, componentNames, packageUid, reason, userIds, instantUserIds, broadcastAllowList, setting, sharedUserPackages, reasonForTrace, callingUidForTrace));
        this.mPackageMonitorCallbackHelper.notifyPackageChanged(packageName, dontKillApp, componentNames, packageUid, reason, userIds, instantUserIds, broadcastAllowList, this.mHandler);
        return;
    L19:
        r0 = snapshot.getVisibilityAllowLists(packageName, userIds);
        goto L18
    L15:
        r3 = PackageManagerService.EMPTY_INT_ARRAY;
        goto L14
    L11:
        r4 = new int[]{userId};
        goto L10
    L24:
        return;
    }

    private /* synthetic */ void lambda$sendPackageChangedBroadcast$4(String packageName, boolean dontKillApp, ArrayList componentNames, int packageUid, String reason, int[] userIds, int[] instantUserIds, SparseArray broadcastAllowList, PackageStateInternal setting, String[] sharedUserPackages, String reasonForTrace, int callingUidForTrace) {
        sendPackageChangedBroadcastInternal(packageName, dontKillApp, componentNames, packageUid, reason, userIds, instantUserIds, broadcastAllowList, setting.getPkg(), sharedUserPackages, reasonForTrace, callingUidForTrace);
    }

    private /* synthetic */ void lambda$sendPackageBroadcastAndNotify$5(String action, String pkg, Bundle extras, int flags, String targetPkg, IIntentReceiver finishedReceiver, int[] userIds, int[] instantUserIds, SparseArray broadcastAllowList, Bundle bOptions) {
        sendPackageBroadcast(action, pkg, extras, flags, targetPkg, finishedReceiver, userIds, instantUserIds, broadcastAllowList, null, bOptions, null);
    }

    private void sendPackageBroadcastAndNotify(final String action, final String pkg, final Bundle extras, final int flags, final String targetPkg, final IIntentReceiver finishedReceiver, final int[] userIds, final int[] instantUserIds, final SparseArray<int[]> broadcastAllowList, final Bundle bOptions) {
        this.mHandler.post(new BroadcastHelper$$ExternalSyntheticLambda10(this, action, pkg, extras, flags, targetPkg, finishedReceiver, userIds, instantUserIds, broadcastAllowList, bOptions));
        if (targetPkg != null) goto L6;
        notifyPackageMonitor(action, pkg, extras, userIds, instantUserIds, broadcastAllowList, null);
        return;
    }

    void sendSystemPackageUpdatedBroadcasts(PackageRemovedInfo packageRemovedInfo) {
        if (packageRemovedInfo.mIsRemovedPackageSystemUpdate == true) goto L5;
        return;
    L5:
        String removedPackage = packageRemovedInfo.mRemovedPackage;
        String installerPackageName = packageRemovedInfo.mInstallerPackageName;
        SparseArray<int[]> broadcastAllowList = packageRemovedInfo.mBroadcastAllowList;
        Bundle extras = new Bundle(2);
        extras.putInt("android.intent.extra.UID", packageRemovedInfo.mUid);
        extras.putBoolean("android.intent.extra.REPLACING", true);
        sendPackageBroadcastAndNotify("android.intent.action.PACKAGE_ADDED", removedPackage, extras, 0, null, null, null, null, broadcastAllowList, null);
        if (installerPackageName == null) goto L8;
        sendPackageBroadcastAndNotify("android.intent.action.PACKAGE_ADDED", removedPackage, extras, 0, installerPackageName, null, null, null, null, null);
        sendPackageBroadcastAndNotify("android.intent.action.PACKAGE_REPLACED", removedPackage, extras, 0, installerPackageName, null, null, null, null, null);
    L8:
        sendPackageBroadcastAndNotify("android.intent.action.PACKAGE_REPLACED", removedPackage, extras, 0, null, null, null, null, broadcastAllowList, null);
        sendPackageBroadcastAndNotify("android.intent.action.MY_PACKAGE_REPLACED", null, null, 0, removedPackage, null, null, null, null, getTemporaryBroadcastOptionsForSystemPackageUpdate(311).toBundle());
    }

    private BroadcastOptions getTemporaryBroadcastOptionsForSystemPackageUpdate(int reasonCode) {
        if (this.mAmInternal == null) goto L5;
        long duration = this.mAmInternal.getBootTimeTempAllowListDuration();
        long duration2 = duration;
    L6:
        BroadcastOptions bOptions = BroadcastOptions.makeBasic();
        bOptions.setTemporaryAppAllowlist(duration2, 0, reasonCode, "");
        return bOptions;
    L5:
        duration2 = 10000;
        goto L6
    }

    void sendPackageRemovedBroadcasts(PackageRemovedInfo packageRemovedInfo, PackageSender packageSender, boolean killApp, boolean removedBySystem, boolean isArchived) {
        String removedPackage = packageRemovedInfo.mRemovedPackage;
        String installerPackageName = packageRemovedInfo.mInstallerPackageName;
        int[] broadcastUserIds = packageRemovedInfo.mBroadcastUsers;
        int[] instantUserIds = packageRemovedInfo.mInstantUserIds;
        SparseArray<int[]> broadcastAllowList = packageRemovedInfo.mBroadcastAllowList;
        boolean dataRemoved = packageRemovedInfo.mDataRemoved;
        boolean isUpdate = packageRemovedInfo.mIsUpdate;
        boolean isRemovedPackageSystemUpdate = packageRemovedInfo.mIsRemovedPackageSystemUpdate;
        boolean isRemovedForAllUsers = packageRemovedInfo.mRemovedForAllUsers;
        boolean isStaticSharedLib = packageRemovedInfo.mIsStaticSharedLib;
        Bundle extras = new Bundle();
        extras.putInt("android.intent.extra.UID", packageRemovedInfo.mUid);
        extras.putBoolean("android.intent.extra.DATA_REMOVED", dataRemoved);
        extras.putBoolean("android.intent.extra.SYSTEM_UPDATE_UNINSTALL", isRemovedPackageSystemUpdate);
        extras.putBoolean("android.intent.extra.DONT_KILL_APP", !killApp);
        extras.putBoolean("android.intent.extra.USER_INITIATED", !removedBySystem);
        if (isUpdate == true) goto L7;
        if (isRemovedPackageSystemUpdate == true) goto L7;
        boolean r7 = false;
    L8:
        boolean isReplace = r7;
        if (isReplace == true) goto L11;
        if (isArchived == true) goto L11;
    L12:
        if (isArchived == false) goto L14;
        extras.putBoolean("android.intent.extra.ARCHIVAL", true);
    L14:
        extras.putBoolean("android.intent.extra.REMOVED_FOR_ALL_USERS", isRemovedForAllUsers);
        if (removedPackage == null) goto L18;
        if (installerPackageName == null) goto L18;
        boolean isStaticSharedLib2 = isStaticSharedLib;
        sendPackageBroadcastAndNotify("android.intent.action.PACKAGE_REMOVED", removedPackage, extras, 0, installerPackageName, null, broadcastUserIds, instantUserIds, null, null);
    L19:
        if (isStaticSharedLib2 == false) goto L21;
        return;
    L21:
        if (removedPackage == null) goto L27;
        SparseArray<int[]> broadcastAllowList2 = broadcastAllowList;
        sendPackageBroadcastAndNotify("android.intent.action.PACKAGE_REMOVED", removedPackage, extras, 0, null, null, broadcastUserIds, instantUserIds, broadcastAllowList2, null);
        sendPackageBroadcastAndNotify("android.intent.action.PACKAGE_REMOVED_INTERNAL", removedPackage, extras, 0, PackageManagerService.PLATFORM_PACKAGE_NAME, null, broadcastUserIds, instantUserIds, broadcastAllowList2, null);
        if (dataRemoved == false) goto L29;
        if (isRemovedPackageSystemUpdate == true) goto L29;
        sendPackageBroadcastAndNotify("android.intent.action.PACKAGE_FULLY_REMOVED", removedPackage, extras, 16777216, null, null, broadcastUserIds, instantUserIds, broadcastAllowList2, null);
        packageSender.notifyPackageRemoved(removedPackage, packageRemovedInfo.mUid);
    L29:
        if (packageRemovedInfo.mIsAppIdRemoved == false) goto L35;
        if (isReplace == true) goto L32;
        if (isArchived == true) goto L32;
    L33:
        sendPackageBroadcastAndNotify("android.intent.action.UID_REMOVED", null, extras, 16777216, null, null, broadcastUserIds, instantUserIds, broadcastAllowList2, null);
        return;
    L32:
        extras.putString("android.intent.extra.PACKAGE_NAME", removedPackage);
        goto L33
    L35:
        return;
    L27:
        broadcastAllowList2 = broadcastAllowList;
    L18:
        isStaticSharedLib2 = isStaticSharedLib;
    L11:
        extras.putBoolean("android.intent.extra.REPLACING", true);
    L7:
        r7 = true;
        goto L8
    }

    void sendPackagesSuspendedOrUnsuspendedForUser(final Supplier<Computer> snapshotSupplier, final String intent, String[] pkgList, int[] uidList, boolean quarantined, final int userId) {
        final Bundle extras = new Bundle(3);
        extras.putStringArray("android.intent.extra.changed_package_list", pkgList);
        extras.putIntArray("android.intent.extra.changed_uid_list", uidList);
        if (quarantined == false) goto L5;
        extras.putBoolean("android.intent.extra.quarantined", true);
    L5:
        final Bundle options = new BroadcastOptions().setDeferralPolicy(2).toBundle();
        final BiFunction<Integer, Bundle, Bundle> filterExtrasForReceiver = new BroadcastHelper$$ExternalSyntheticLambda1(snapshotSupplier);
        this.mHandler.post(new BroadcastHelper$$ExternalSyntheticLambda2(this, intent, extras, userId, filterExtrasForReceiver, options));
        notifyPackageMonitor(intent, null, extras, new int[]{userId}, null, null, filterExtrasForReceiver);
    }

    private static /* synthetic */ Bundle lambda$sendPackagesSuspendedOrUnsuspendedForUser$6(Supplier snapshotSupplier, Integer callingUid, Bundle intentExtras) {
        return filterExtrasChangedPackageList(snapshotSupplier, callingUid.intValue(), intentExtras);
    }

    private /* synthetic */ void lambda$sendPackagesSuspendedOrUnsuspendedForUser$7(String intent, Bundle extras, int userId, BiFunction filterExtrasForReceiver, Bundle options) {
        sendPackageBroadcast(intent, null, extras, 1342177280, null, null, new int[]{userId}, null, null, filterExtrasForReceiver, options, null);
    }

    void sendMyPackageSuspendedOrUnsuspended(final Supplier<Computer> snapshotSupplier, final String[] affectedPackages, final boolean suspended, final int userId) {
        if (suspended == false) goto L4;
        String r0 = "android.intent.action.MY_PACKAGE_SUSPENDED";
    L5:
        final String action = r0;
        this.mHandler.post(new BroadcastHelper$$ExternalSyntheticLambda9(this, suspended, userId, snapshotSupplier, affectedPackages, action));
        return;
    L4:
        r0 = "android.intent.action.MY_PACKAGE_UNSUSPENDED";
        goto L5
    }

    private /* synthetic */ void lambda$sendMyPackageSuspendedOrUnsuspended$8(boolean suspended, int userId, Supplier snapshotSupplier, String[] affectedPackages, String action) {
        IActivityManager am = ActivityManager.getService();
        if (am != null) goto L10;
        StringBuilder r2 = new StringBuilder();
        r2.append("IActivityManager null. Cannot send MY_PACKAGE_ ");
        if (suspended == false) goto L7;
        String r3 = "";
    L8:
        r2.append(r3);
        r2.append("SUSPENDED broadcasts");
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, r2.toString());
        return;
    L7:
        r3 = "UN";
        goto L8
    L10:
        int[] targetUserIds = {userId};
        Computer snapshot = (Computer) snapshotSupplier.get();
        int r4 = affectedPackages.length;
        int r5 = 0;
    L11:
        if (r5 >= r4) goto L21;
        String packageName = affectedPackages[r5];
        if (suspended == false) goto L15;
        Bundle appExtras = SuspendPackageHelper.getSuspendedPackageAppExtras(snapshot, packageName, userId, 1000);
    L17:
        if (appExtras == null) goto L19;
        Bundle intentExtras = new Bundle(1);
        intentExtras.putBundle("android.intent.extra.SUSPENDED_PACKAGE_EXTRAS", appExtras);
    L20:
        doSendBroadcast(action, null, intentExtras, 16777216, packageName, null, targetUserIds, false, null, null, null, null);
        r5 = r5 + 1;
        r4 = r4;
        goto L11
    L19:
        intentExtras = null;
        goto L20
    L15:
        appExtras = null;
        goto L17
    }

    void sendDistractingPackagesChanged(final Supplier<Computer> snapshotSupplier, String[] pkgList, int[] uidList, final int userId, int distractionFlags) {
        final Bundle extras = new Bundle();
        extras.putStringArray("android.intent.extra.changed_package_list", pkgList);
        extras.putIntArray("android.intent.extra.changed_uid_list", uidList);
        extras.putInt("android.intent.extra.distraction_restrictions", distractionFlags);
        this.mHandler.post(new BroadcastHelper$$ExternalSyntheticLambda8(this, extras, userId, snapshotSupplier));
    }

    private /* synthetic */ void lambda$sendDistractingPackagesChanged$10(Bundle extras, int userId, final Supplier snapshotSupplier) {
        sendPackageBroadcast("android.intent.action.DISTRACTING_PACKAGES_CHANGED", null, extras, 1073741824, null, null, new int[]{userId}, null, null, new BroadcastHelper$$ExternalSyntheticLambda6(snapshotSupplier), null, null);
    }

    private static /* synthetic */ Bundle lambda$sendDistractingPackagesChanged$9(Supplier snapshotSupplier, Integer callingUid, Bundle intentExtras) {
        return filterExtrasChangedPackageList(snapshotSupplier, callingUid.intValue(), intentExtras);
    }

    void sendResourcesChangedBroadcastAndNotify(Supplier<Computer> snapshotSupplier, boolean mediaStatus, boolean replacing, ArrayList<AndroidPackage> packages) {
        int size = packages.size();
        String[] packageNames = new String[size];
        int[] packageUids = new int[size];
        int i = 0;
    L3:
        if (i >= size) goto L5;
        AndroidPackage pkg = packages.get(i);
        packageNames[i] = pkg.getPackageName();
        packageUids[i] = pkg.getUid();
        i = i + 1;
        goto L3
    L5:
        sendResourcesChangedBroadcast(snapshotSupplier, mediaStatus, replacing, packageNames, packageUids);
        notifyResourcesChanged(mediaStatus, replacing, packageNames, packageUids);
    }

    private void notifyPackageMonitor(String action, String pkg, Bundle extras, int[] userIds, int[] instantUserIds, SparseArray<int[]> broadcastAllowList, BiFunction<Integer, Bundle, Bundle> filterExtras) {
        this.mPackageMonitorCallbackHelper.notifyPackageMonitor(action, pkg, extras, userIds, instantUserIds, broadcastAllowList, this.mHandler, filterExtras);
    }

    private void notifyResourcesChanged(boolean mediaStatus, boolean replacing, String[] pkgNames, int[] uids) {
        this.mPackageMonitorCallbackHelper.notifyResourcesChanged(mediaStatus, replacing, pkgNames, uids, this.mHandler);
    }

    private static void tracePackageChangedBroadcastEvent(boolean applyFlag, String reasonForTrace, String packageName, String targetPackageName, String targetComponent, int componentSize, String callingPackageNameForTrace) {
        if (Trace.isTagEnabled(524288) == true) goto L5;
        return;
    L5:
        Trace.instant(524288, "broadcastPackageChanged; af=" + applyFlag + ",rft=" + reasonForTrace + ",pn=" + packageName + ",tpn=" + targetPackageName + ",tc=" + targetComponent + ",cs=" + componentSize + ",cpnft=" + callingPackageNameForTrace);
    }
}
