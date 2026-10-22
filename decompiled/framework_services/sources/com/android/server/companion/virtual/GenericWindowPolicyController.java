package com.android.server.companion.virtual;

import android.app.compat.CompatChanges;
import android.content.AttributionSource;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.util.ArraySet;
import android.util.Slog;
import android.window.DisplayWindowPolicyController;
import com.android.internal.app.BlockedAppStreamingActivity;
import com.android.modules.expresslog.Counter;
import com.android.server.pm.PackageManagerService;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class GenericWindowPolicyController extends DisplayWindowPolicyController {
    public static final long ALLOW_SECURE_ACTIVITY_DISPLAY_ON_REMOTE_DEVICE = 201712607;
    private static final ComponentName BLOCKED_APP_STREAMING_COMPONENT = null;
    private static final String TAG = "GenericWindowPolicyController";
    private boolean mActivityLaunchAllowedByDefault;
    private final ActivityListener mActivityListener;
    private final ArraySet<ComponentName> mActivityPolicyExemptions;
    private final ArraySet<String> mActivityPolicyPackageExemptions;
    private final ArraySet<UserHandle> mAllowedUsers;
    private final AttributionSource mAttributionSource;
    private final boolean mCrossTaskNavigationAllowedByDefault;
    private final ArraySet<ComponentName> mCrossTaskNavigationExemptions;
    private int mCurrentWindowFlags;
    private final ComponentName mCustomHomeComponent;
    private final Set<String> mDisplayCategories;
    private int mDisplayId;
    private final CountDownLatch mDisplayIdSetLatch;
    private final Object mGenericWindowPolicyControllerLock;
    private final Handler mHandler;
    private boolean mIsMirrorDisplay;
    private final ArraySet<RunningAppsChangedListener> mRunningAppsChangedListeners;
    private final ArraySet<Integer> mRunningUids;
    private boolean mShowTasksInHostDeviceRecents;

    public interface ActivityListener {
        void onActivityLaunchBlocked(int r1, ActivityInfo r2, IntentSender r3);

        void onDisplayEmpty(int r1);

        void onSecureWindowHidden(int r1);

        void onSecureWindowShown(int r1, ActivityInfo r2);

        void onTopActivityChanged(int r1, ComponentName r2, int r3);

        boolean shouldInterceptIntent(Intent r1);
    }

    public interface RunningAppsChangedListener {
        void onRunningAppsChanged(ArraySet<Integer> r1);
    }

    public static /* synthetic */ void $r8$lambda$02U1odZ6o6YS3y0icH3ZN59VRfo(GenericWindowPolicyController r0, int r1) {
        r0.lambda$keepActivityOnWindowFlagsChanged$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Q4-qR8hIE_MCMQoXPRM74QPKBFo, reason: not valid java name */
    public static /* synthetic */ void m2977$r8$lambda$Q4qR8hIE_MCMQoXPRM74QPKBFo(GenericWindowPolicyController r0, int r1, ComponentName r2, int r3) {
        r0.lambda$onTopActivityChanged$2(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$bbXS2KwiPC7_e4kKJzTVkNuGKnU(GenericWindowPolicyController r0, int r1, ActivityInfo r2) {
        r0.lambda$keepActivityOnWindowFlagsChanged$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$tzd6uyr53U3EVZgEiuhju3ASygM(GenericWindowPolicyController r0, int r1) {
        r0.lambda$onRunningAppsChanged$3(r1);
    }

    public static /* synthetic */ void $r8$lambda$tzhyKGqOen2FKRsQ76KIvqDswU8(ArraySet r0, ArraySet r1) {
        lambda$onRunningAppsChanged$4(r0, r1);
    }

    static {
        BLOCKED_APP_STREAMING_COMPONENT = new ComponentName(PackageManagerService.PLATFORM_PACKAGE_NAME, BlockedAppStreamingActivity.class.getName());
    }

    public GenericWindowPolicyController(int windowFlags, int systemWindowFlags, AttributionSource attributionSource, ArraySet<UserHandle> allowedUsers, boolean activityLaunchAllowedByDefault, Set<ComponentName> activityPolicyExemptions, Set<String> activityPolicyPackageExemptions, boolean crossTaskNavigationAllowedByDefault, Set<ComponentName> crossTaskNavigationExemptions, ActivityListener activityListener, Set<String> displayCategories, boolean showTasksInHostDeviceRecents, ComponentName customHomeComponent) {
        this.mGenericWindowPolicyControllerLock = new Object();
        this.mDisplayId = -1;
        this.mIsMirrorDisplay = false;
        this.mDisplayIdSetLatch = new CountDownLatch(1);
        this.mCurrentWindowFlags = 0;
        this.mRunningUids = new ArraySet();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mRunningAppsChangedListeners = new ArraySet();
        this.mAttributionSource = attributionSource;
        this.mAllowedUsers = allowedUsers;
        this.mActivityLaunchAllowedByDefault = activityLaunchAllowedByDefault;
        this.mActivityPolicyExemptions = new ArraySet(activityPolicyExemptions);
        this.mActivityPolicyPackageExemptions = new ArraySet(activityPolicyPackageExemptions);
        this.mCrossTaskNavigationAllowedByDefault = crossTaskNavigationAllowedByDefault;
        this.mCrossTaskNavigationExemptions = new ArraySet(crossTaskNavigationExemptions);
        setInterestedWindowFlags(windowFlags, systemWindowFlags);
        this.mActivityListener = activityListener;
        this.mDisplayCategories = displayCategories;
        this.mShowTasksInHostDeviceRecents = showTasksInHostDeviceRecents;
        this.mCustomHomeComponent = customHomeComponent;
    }

    void setDisplayId(int displayId, boolean isMirrorDisplay) {
        this.mDisplayId = displayId;
        this.mIsMirrorDisplay = isMirrorDisplay;
        this.mDisplayIdSetLatch.countDown();
    }

    private int waitAndGetDisplayId() {
        if (this.mDisplayIdSetLatch.await(10, TimeUnit.SECONDS) == true) goto L10;
        Slog.e(TAG, "Timed out while waiting for GWPC displayId to be set.");     // Catch: InterruptedException -> L7
        return -1;
    L10:
        return this.mDisplayId;
    L11:
        Slog.e(TAG, "Interrupted while waiting for GWPC displayId to be set.");
        return -1;
    }

    private boolean waitAndGetIsMirrorDisplay() {
        if (this.mDisplayIdSetLatch.await(10, TimeUnit.SECONDS) == true) goto L10;
        Slog.e(TAG, "Timed out while waiting for GWPC isMirrorDisplay to be set.");     // Catch: InterruptedException -> L7
        return false;
    L10:
        return this.mIsMirrorDisplay;
    L11:
        Slog.e(TAG, "Interrupted while waiting for GWPC isMirrorDisplay to be set.");
        return false;
    }

    public void setShowInHostDeviceRecents(boolean showInHostDeviceRecents) {
        Object r0 = this.mGenericWindowPolicyControllerLock;
        monitor-enter(r0);
        this.mShowTasksInHostDeviceRecents = showInHostDeviceRecents;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setActivityLaunchDefaultAllowed(boolean activityLaunchDefaultAllowed) {
        Object r0 = this.mGenericWindowPolicyControllerLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mActivityLaunchAllowedByDefault == activityLaunchDefaultAllowed) goto L9;
        this.mActivityPolicyExemptions.clear();     // Catch: Throwable -> L7
        this.mActivityPolicyPackageExemptions.clear();     // Catch: Throwable -> L7
    L9:
        this.mActivityLaunchAllowedByDefault = activityLaunchDefaultAllowed;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    void addActivityPolicyExemption(ComponentName componentName) {
        Object r0 = this.mGenericWindowPolicyControllerLock;
        monitor-enter(r0);
        this.mActivityPolicyExemptions.add(componentName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void removeActivityPolicyExemption(ComponentName componentName) {
        Object r0 = this.mGenericWindowPolicyControllerLock;
        monitor-enter(r0);
        this.mActivityPolicyExemptions.remove(componentName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void addActivityPolicyExemption(String packageName) {
        Object r0 = this.mGenericWindowPolicyControllerLock;
        monitor-enter(r0);
        this.mActivityPolicyPackageExemptions.add(packageName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void removeActivityPolicyExemption(String packageName) {
        Object r0 = this.mGenericWindowPolicyControllerLock;
        monitor-enter(r0);
        this.mActivityPolicyPackageExemptions.remove(packageName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void registerRunningAppsChangedListener(RunningAppsChangedListener listener) {
        Object r0 = this.mGenericWindowPolicyControllerLock;
        monitor-enter(r0);
        this.mRunningAppsChangedListeners.add(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unregisterRunningAppsChangedListener(RunningAppsChangedListener listener) {
        Object r0 = this.mGenericWindowPolicyControllerLock;
        monitor-enter(r0);
        this.mRunningAppsChangedListeners.remove(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean canActivityBeLaunched(ActivityInfo activityInfo, Intent intent, int windowingMode, int launchingFromDisplayId, boolean isNewTask, boolean isResultExpected, Supplier<IntentSender> intentSender) {
        if (intent == null) goto L9;
        if (this.mActivityListener.shouldInterceptIntent(intent) == false) goto L9;
        logActivityLaunchBlocked("Virtual device intercepting intent");
        return false;
    L9:
        if (canContainActivity(activityInfo, windowingMode, launchingFromDisplayId, isNewTask) == true) goto L15;
        if (isResultExpected == false) goto L12;
        Supplier<IntentSender> r1 = null;
    L13:
        notifyActivityBlocked(activityInfo, r1);
        return false;
    L12:
        r1 = intentSender;
        goto L13
    L15:
        return true;
    }

    public boolean canContainActivity(ActivityInfo activityInfo, int windowingMode, int launchingFromDisplayId, boolean isNewTask) {
        if (waitAndGetIsMirrorDisplay() == false) goto L7;
        logActivityLaunchBlocked("Mirror virtual displays cannot contain activities.");
        return false;
    L7:
        if (isWindowingModeSupported(windowingMode) == true) goto L11;
        logActivityLaunchBlocked("Virtual device doesn't support windowing mode " + windowingMode);
        return false;
    L11:
        if ((activityInfo.flags & 65536) != 0) goto L14;
        logActivityLaunchBlocked("Activity requires android:canDisplayOnRemoteDevices=true");
        return false;
    L14:
        UserHandle activityUser = UserHandle.getUserHandleForUid(activityInfo.applicationInfo.uid);
        if (activityUser.isSystem() == false) goto L17;
    L20:
        ComponentName activityComponent = activityInfo.getComponentName();
        if (BLOCKED_APP_STREAMING_COMPONENT.equals(activityComponent) == false) goto L26;
        if (activityUser.isSystem() == false) goto L26;
        return true;
    L26:
        if (activityUser.isSystem() == true) goto L32;
        if (this.mAllowedUsers.contains(activityUser) == true) goto L32;
        logActivityLaunchBlocked("Activity launch disallowed from user " + activityUser);
        return false;
    L32:
        if (activityMatchesDisplayCategory(activityInfo) == true) goto L36;
        logActivityLaunchBlocked("The activity's required display category '" + activityInfo.requiredDisplayCategory + "' not found on virtual display with the following categories: " + this.mDisplayCategories);
        return false;
    L36:
        if (isAllowedByPolicy(activityComponent) == true) goto L39;
        logActivityLaunchBlocked("Activity launch disallowed by policy: " + activityComponent);
        return false;
    L39:
        if (isNewTask == false) goto L45;
        if (launchingFromDisplayId == 0) goto L45;
        if (isAllowedByPolicy(this.mCrossTaskNavigationAllowedByDefault, this.mCrossTaskNavigationExemptions, activityComponent) == true) goto L45;
        logActivityLaunchBlocked("Cross task navigation disallowed by policy: " + activityComponent);
        return false;
    L45:
        return true;
    L17:
        if (this.mAllowedUsers.contains(activityUser) == true) goto L20;
        logActivityLaunchBlocked("Activity launch disallowed from user " + activityUser);
        return false;
    }

    private void logActivityLaunchBlocked(String reason) {
        Slog.d(TAG, "Virtual device activity launch disallowed on display " + waitAndGetDisplayId() + ", reason: " + reason);
    }

    public boolean keepActivityOnWindowFlagsChanged(final ActivityInfo activityInfo, int windowFlags, int systemWindowFlags) {
        final int displayId = waitAndGetDisplayId();
        if (displayId != (-1)) goto L5;
    L14:
        this.mCurrentWindowFlags = windowFlags;
        if (CompatChanges.isChangeEnabled(ALLOW_SECURE_ACTIVITY_DISPLAY_ON_REMOTE_DEVICE, activityInfo.packageName, UserHandle.getUserHandleForUid(activityInfo.applicationInfo.uid)) == false) goto L17;
        return true;
    L17:
        if ((windowFlags & 8192) == 0) goto L19;
    L20:
        notifyActivityBlocked(activityInfo, null);
        return false;
    L19:
        if ((524288 & systemWindowFlags) != 0) goto L20;
        return true;
    L5:
        if ((windowFlags & 8192) == 0) goto L10;
        if ((this.mCurrentWindowFlags & 8192) != 0) goto L10;
        this.mHandler.post(new GenericWindowPolicyController$$ExternalSyntheticLambda1(this, displayId, activityInfo));
    L10:
        if ((windowFlags & 8192) != 0) goto L14;
        if ((this.mCurrentWindowFlags & 8192) == 0) goto L14;
        this.mHandler.post(new GenericWindowPolicyController$$ExternalSyntheticLambda2(this, displayId));
        goto L14
    }

    private /* synthetic */ void lambda$keepActivityOnWindowFlagsChanged$0(int displayId, ActivityInfo activityInfo) {
        this.mActivityListener.onSecureWindowShown(displayId, activityInfo);
    }

    private /* synthetic */ void lambda$keepActivityOnWindowFlagsChanged$1(int displayId) {
        this.mActivityListener.onSecureWindowHidden(displayId);
    }

    public void onTopActivityChanged(final ComponentName topActivity, int uid, final int userId) {
        final int displayId = waitAndGetDisplayId();
        if (topActivity != null) goto L5;
        return;
    L5:
        if (displayId == (-1)) goto L9;
        this.mHandler.post(new GenericWindowPolicyController$$ExternalSyntheticLambda0(this, displayId, topActivity, userId));
        return;
    }

    private /* synthetic */ void lambda$onTopActivityChanged$2(int displayId, ComponentName topActivity, int userId) {
        this.mActivityListener.onTopActivityChanged(displayId, topActivity, userId);
    }

    public void onRunningAppsChanged(final ArraySet<Integer> runningUids) {
        Object r0 = this.mGenericWindowPolicyControllerLock;
        monitor-enter(r0);
        this.mRunningUids.clear();     // Catch: Throwable -> L9
        this.mRunningUids.addAll(runningUids);     // Catch: Throwable -> L9
        final int displayId = waitAndGetDisplayId();     // Catch: Throwable -> L9
        if (this.mRunningUids.isEmpty() == false) goto L12;
        if (displayId == (-1)) goto L12;
        this.mHandler.post(new GenericWindowPolicyController$$ExternalSyntheticLambda3(this, displayId));     // Catch: Throwable -> L9
    L12:
        if (this.mRunningAppsChangedListeners.isEmpty() == true) goto L14;
        final ArraySet<RunningAppsChangedListener> listeners = new ArraySet(this.mRunningAppsChangedListeners);     // Catch: Throwable -> L9
        this.mHandler.post(new GenericWindowPolicyController$$ExternalSyntheticLambda4(listeners, runningUids));     // Catch: Throwable -> L9
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onRunningAppsChanged$3(int displayId) {
        this.mActivityListener.onDisplayEmpty(displayId);
    }

    private static /* synthetic */ void lambda$onRunningAppsChanged$4(ArraySet listeners, ArraySet runningUids) {
        Iterator r0 = listeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        RunningAppsChangedListener listener = (RunningAppsChangedListener) r0.next();
        listener.onRunningAppsChanged(runningUids);
        goto L4
    }

    public boolean canShowTasksInHostDeviceRecents() {
        Object r0 = this.mGenericWindowPolicyControllerLock;
        monitor-enter(r0);
        boolean r1 = this.mShowTasksInHostDeviceRecents;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public ComponentName getCustomHomeComponent() {
        return this.mCustomHomeComponent;
    }

    boolean containsUid(int uid) {
        Object r0 = this.mGenericWindowPolicyControllerLock;
        monitor-enter(r0);
        boolean r1 = this.mRunningUids.contains(Integer.valueOf(uid));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean activityMatchesDisplayCategory(ActivityInfo activityInfo) {
        if (this.mDisplayCategories.isEmpty() == false) goto L9;
        if (activityInfo.requiredDisplayCategory == null) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (activityInfo.requiredDisplayCategory != null) goto L11;
        return false;
    L11:
        if (this.mDisplayCategories.contains(activityInfo.requiredDisplayCategory) == true) goto L14;
        return false;
    L14:
        return true;
    }

    private void notifyActivityBlocked(ActivityInfo activityInfo, Supplier<IntentSender> intentSender) {
        int displayId = waitAndGetDisplayId();
        if (waitAndGetIsMirrorDisplay() == false) goto L5;
    L11:
        Counter.logIncrementWithUid("virtual_devices.value_activity_blocked_count", this.mAttributionSource.getUid());
        return;
    L5:
        if (displayId == (-1)) goto L11;
        ActivityListener r1 = this.mActivityListener;
        if (intentSender != null) goto L9;
        IntentSender r2 = null;
    L10:
        r1.onActivityLaunchBlocked(displayId, activityInfo, r2);
        goto L11
    L9:
        r2 = intentSender.get();
        goto L10
    }

    private boolean isAllowedByPolicy(ComponentName component) {
        Object r0 = this.mGenericWindowPolicyControllerLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mActivityPolicyExemptions.contains(component) == true) goto L15;
        if (this.mActivityPolicyPackageExemptions.contains(component.getPackageName()) == true) goto L15;
        boolean r1 = this.mActivityLaunchAllowedByDefault;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L15:
        if (this.mActivityLaunchAllowedByDefault == true) goto L17;
        boolean r2 = true;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L17:
        r2 = false;
        goto L18
    }

    private static boolean isAllowedByPolicy(boolean allowedByDefault, Set<ComponentName> exemptions, ComponentName component) {
        if (allowedByDefault == exemptions.contains(component)) goto L5;
        return true;
    L5:
        return false;
    }

    int getRunningAppsChangedListenersSizeForTesting() {
        Object r0 = this.mGenericWindowPolicyControllerLock;
        monitor-enter(r0);
        int r1 = this.mRunningAppsChangedListeners.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
