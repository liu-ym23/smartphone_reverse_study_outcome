package com.android.server.wm;

import android.provider.DeviceConfig;
import android.provider.DeviceConfigInterface;
import android.util.ArraySet;
import com.android.server.am.IZswContentProviderHelper;
import com.android.server.pm.PackageManagerService;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
final class WindowManagerConstants {
    private static final String KEY_IGNORE_ACTIVITY_ORIENTATION_REQUEST = "ignore_activity_orientation_request";
    private static final String KEY_IGNORE_ACTIVITY_ORIENTATION_REQUEST_SCREENS = "ignore_activity_orientation_request_screens";
    private static final String KEY_OPT_OUT_IGNORE_ACTIVITY_ORIENTATION_REQUEST_LIST = "opt_out_ignore_activity_orientation_request_list";
    static final String KEY_SYSTEM_GESTURE_EXCLUSION_LOG_DEBOUNCE_MILLIS = "system_gesture_exclusion_log_debounce_millis";
    private static final int MIN_GESTURE_EXCLUSION_LIMIT_DP = 200;
    private final DeviceConfigInterface mDeviceConfig;
    private final WindowManagerGlobalLock mGlobalLock;
    boolean mIgnoreActivityOrientationRequestLargeScreen;
    boolean mIgnoreActivityOrientationRequestSmallScreen;
    private final DeviceConfig.OnPropertiesChangedListener mListenerAndroid;
    private final DeviceConfig.OnPropertiesChangedListener mListenerWindowManager;
    private ArraySet<String> mOptOutIgnoreActivityOrientationRequestPackages;
    boolean mSystemGestureExcludedByPreQStickyImmersive;
    int mSystemGestureExclusionLimitDp;
    long mSystemGestureExclusionLogDebounceTimeoutMillis;
    private final Runnable mUpdateSystemGestureExclusionCallback;

    public static /* synthetic */ void $r8$lambda$eUFhT9hdWSYnRFf4b7Ae4A_NcK8(WindowManagerService r0) {
        lambda$new$0(r0);
    }

    public static /* synthetic */ void $r8$lambda$kw7nkERC6P7XlbxngpVlVq5rcqo(WindowManagerConstants r0, DeviceConfig.Properties r1) {
        r0.onAndroidPropertiesChanged(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$yZhRKMPFS71X9_8ICDB5TEPj-L8, reason: not valid java name */
    public static /* synthetic */ void m10405$r8$lambda$yZhRKMPFS71X9_8ICDB5TEPjL8(WindowManagerConstants r0, DeviceConfig.Properties r1) {
        r0.onWindowPropertiesChanged(r1);
    }

    WindowManagerConstants(final WindowManagerService service, DeviceConfigInterface deviceConfig) {
        this(service.mGlobalLock, new WindowManagerConstants$$ExternalSyntheticLambda3(service), deviceConfig);
    }

    private static /* synthetic */ void lambda$new$0(WindowManagerService service) {
        service.mRoot.forAllDisplays(new WindowManagerConstants$$ExternalSyntheticLambda2());
    }

    WindowManagerConstants(WindowManagerGlobalLock globalLock, Runnable updateSystemGestureExclusionCallback, DeviceConfigInterface deviceConfig) {
        globalLock.getClass();
        this.mGlobalLock = globalLock;
        updateSystemGestureExclusionCallback.getClass();
        this.mUpdateSystemGestureExclusionCallback = updateSystemGestureExclusionCallback;
        this.mDeviceConfig = deviceConfig;
        this.mListenerAndroid = new WindowManagerConstants$$ExternalSyntheticLambda0(this);
        this.mListenerWindowManager = new WindowManagerConstants$$ExternalSyntheticLambda1(this);
    }

    void start(Executor executor) {
        this.mDeviceConfig.addOnPropertiesChangedListener(PackageManagerService.PLATFORM_PACKAGE_NAME, executor, this.mListenerAndroid);
        this.mDeviceConfig.addOnPropertiesChangedListener("window_manager", executor, this.mListenerWindowManager);
        updateSystemGestureExclusionLogDebounceMillis();
        updateSystemGestureExclusionLimitDp();
        updateSystemGestureExcludedByPreQStickyImmersive();
        updateIgnoreActivityOrientationRequest();
        updateOptOutIgnoreActivityOrientationRequestList();
    }

    private void onAndroidPropertiesChanged(DeviceConfig.Properties properties) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        boolean updateSystemGestureExclusionLimit = false;
        Iterator r2 = properties.getKeyset().iterator();     // Catch: Throwable -> L13
    L7:
        if (r2.hasNext() == false) goto L30;
        String name = (String) r2.next();     // Catch: Throwable -> L13
        if (name == null) goto L10;
        switch(name.hashCode()) {
            case -1271675449: goto L22;
            case 316878247: goto L19;
            default: goto L24;
        };     // Catch: Throwable -> L13
    L24:
        byte r4 = -1;
    L25:
        switch(r4) {
            case 0: goto L28;
            case 1: goto L27;
            default: goto L7;
        };     // Catch: Throwable -> L13
    L27:
        updateSystemGestureExcludedByPreQStickyImmersive();     // Catch: Throwable -> L13
        updateSystemGestureExclusionLimit = true;
        goto L7
    L28:
        updateSystemGestureExclusionLimitDp();     // Catch: Throwable -> L13
        updateSystemGestureExclusionLimit = true;
        goto L7
    L19:
        if (name.equals("system_gesture_exclusion_limit_dp") == false) goto L24;
        r4 = 0;
        goto L25
    L22:
        if (name.equals("system_gestures_excluded_by_pre_q_sticky_immersive") == false) goto L24;
        r4 = 1;
        goto L25
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L30:
        if (updateSystemGestureExclusionLimit == false) goto L32;
        this.mUpdateSystemGestureExclusionCallback.run();     // Catch: Throwable -> L13
    L32:
        monitor-exit(r0);     // Catch: Throwable -> L13
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L13:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void onWindowPropertiesChanged(DeviceConfig.Properties properties) {
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        Iterator r1 = properties.getKeyset().iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L36;
        String name = (String) r1.next();     // Catch: Throwable -> L12
        if (name == null) goto L9;
        switch(name.hashCode()) {
            case -2109521787: goto L27;
            case -679749315: goto L24;
            case -125834358: goto L21;
            case 190802493: goto L18;
            default: goto L29;
        };     // Catch: Throwable -> L12
    L29:
        byte r3 = -1;
    L30:
        switch(r3) {
            case 0: goto L34;
            case 1: goto L33;
            case 2: goto L33;
            case 3: goto L32;
            default: goto L6;
        };     // Catch: Throwable -> L12
    L32:
        updateOptOutIgnoreActivityOrientationRequestList();     // Catch: Throwable -> L12
        goto L6
    L33:
        updateIgnoreActivityOrientationRequest();     // Catch: Throwable -> L12
        goto L6
    L34:
        updateSystemGestureExclusionLogDebounceMillis();     // Catch: Throwable -> L12
        goto L6
    L18:
        if (name.equals(KEY_OPT_OUT_IGNORE_ACTIVITY_ORIENTATION_REQUEST_LIST) == false) goto L29;
        r3 = 3;
        goto L30
    L21:
        if (name.equals(KEY_SYSTEM_GESTURE_EXCLUSION_LOG_DEBOUNCE_MILLIS) == false) goto L29;
        r3 = 0;
        goto L30
    L24:
        if (name.equals(KEY_IGNORE_ACTIVITY_ORIENTATION_REQUEST) == false) goto L29;
        r3 = 1;
        goto L30
    L27:
        if (name.equals(KEY_IGNORE_ACTIVITY_ORIENTATION_REQUEST_SCREENS) == false) goto L29;
        r3 = 2;
        goto L30
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L36:
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void updateSystemGestureExclusionLogDebounceMillis() {
        this.mSystemGestureExclusionLogDebounceTimeoutMillis = this.mDeviceConfig.getLong("window_manager", KEY_SYSTEM_GESTURE_EXCLUSION_LOG_DEBOUNCE_MILLIS, 0);
    }

    private void updateSystemGestureExclusionLimitDp() {
        this.mSystemGestureExclusionLimitDp = Math.max(200, this.mDeviceConfig.getInt(PackageManagerService.PLATFORM_PACKAGE_NAME, "system_gesture_exclusion_limit_dp", 0));
    }

    private void updateSystemGestureExcludedByPreQStickyImmersive() {
        this.mSystemGestureExcludedByPreQStickyImmersive = this.mDeviceConfig.getBoolean(PackageManagerService.PLATFORM_PACKAGE_NAME, "system_gestures_excluded_by_pre_q_sticky_immersive", false);
    }

    private void updateIgnoreActivityOrientationRequest() {
        boolean largeScreens = false;
        boolean allScreens = this.mDeviceConfig.getBoolean("window_manager", KEY_IGNORE_ACTIVITY_ORIENTATION_REQUEST, false);
        String whichScreens = this.mDeviceConfig.getProperty("window_manager", KEY_IGNORE_ACTIVITY_ORIENTATION_REQUEST_SCREENS);
        boolean allScreens2 = allScreens | IZswContentProviderHelper.DUMP_ALL.equalsIgnoreCase(whichScreens);
        if (allScreens2 == false) goto L5;
    L6:
        largeScreens = true;
    L7:
        this.mIgnoreActivityOrientationRequestSmallScreen = allScreens2;
        this.mIgnoreActivityOrientationRequestLargeScreen = largeScreens;
        return;
    L5:
        if ("large".equalsIgnoreCase(whichScreens) == false) goto L7;
        goto L6
    }

    private void updateOptOutIgnoreActivityOrientationRequestList() {
        String packageList = this.mDeviceConfig.getString("window_manager", KEY_OPT_OUT_IGNORE_ACTIVITY_ORIENTATION_REQUEST_LIST, "");
        if (packageList.isEmpty() == false) goto L6;
        this.mOptOutIgnoreActivityOrientationRequestPackages = null;
        return;
    L6:
        this.mOptOutIgnoreActivityOrientationRequestPackages = new ArraySet();
        this.mOptOutIgnoreActivityOrientationRequestPackages.addAll(Arrays.asList(packageList.split(",")));
    }

    boolean isPackageOptOutIgnoreActivityOrientationRequest(String packageName) {
        if (this.mOptOutIgnoreActivityOrientationRequestPackages != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mOptOutIgnoreActivityOrientationRequestPackages.contains(packageName) == false) goto L7;
        return true;
    }

    void dump(PrintWriter pw) {
        pw.println("WINDOW MANAGER CONSTANTS (dumpsys window constants):");
        pw.print("  ");
        pw.print(KEY_SYSTEM_GESTURE_EXCLUSION_LOG_DEBOUNCE_MILLIS);
        pw.print("=");
        pw.println(this.mSystemGestureExclusionLogDebounceTimeoutMillis);
        pw.print("  ");
        pw.print("system_gesture_exclusion_limit_dp");
        pw.print("=");
        pw.println(this.mSystemGestureExclusionLimitDp);
        pw.print("  ");
        pw.print("system_gestures_excluded_by_pre_q_sticky_immersive");
        pw.print("=");
        pw.println(this.mSystemGestureExcludedByPreQStickyImmersive);
        pw.print("  ");
        pw.print(KEY_IGNORE_ACTIVITY_ORIENTATION_REQUEST_SCREENS);
        pw.print("=");
        if (this.mIgnoreActivityOrientationRequestSmallScreen == false) goto L6;
        String r2 = IZswContentProviderHelper.DUMP_ALL;
    L9:
        pw.println(r2);
        if (this.mOptOutIgnoreActivityOrientationRequestPackages == null) goto L12;
        pw.print("  ");
        pw.print(KEY_OPT_OUT_IGNORE_ACTIVITY_ORIENTATION_REQUEST_LIST);
        pw.print("=");
        pw.println(this.mOptOutIgnoreActivityOrientationRequestPackages);
    L12:
        pw.println();
        return;
    L6:
        if (this.mIgnoreActivityOrientationRequestLargeScreen == false) goto L8;
        r2 = "large";
        goto L9
    L8:
        r2 = "none";
        goto L9
    }
}
