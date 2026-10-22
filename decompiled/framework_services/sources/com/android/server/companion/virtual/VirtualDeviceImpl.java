package com.android.server.companion.virtual;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.app.admin.DevicePolicyManager;
import android.app.compat.CompatChanges;
import android.companion.AssociationInfo;
import android.companion.virtual.ActivityPolicyExemption;
import android.companion.virtual.IVirtualDevice;
import android.companion.virtual.IVirtualDeviceActivityListener;
import android.companion.virtual.IVirtualDeviceIntentInterceptor;
import android.companion.virtual.IVirtualDeviceSoundEffectListener;
import android.companion.virtual.VirtualDevice;
import android.companion.virtual.VirtualDeviceParams;
import android.companion.virtual.audio.IAudioConfigChangedCallback;
import android.companion.virtual.audio.IAudioRoutingCallback;
import android.companion.virtual.camera.VirtualCameraConfig;
import android.companion.virtual.sensor.VirtualSensor;
import android.companion.virtual.sensor.VirtualSensorAdditionalInfo;
import android.companion.virtual.sensor.VirtualSensorEvent;
import android.content.AttributionSource;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.graphics.PointF;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManagerGlobal;
import android.hardware.display.DisplayManagerInternal;
import android.hardware.display.IVirtualDisplayCallback;
import android.hardware.display.VirtualDisplayConfig;
import android.hardware.input.VirtualDpadConfig;
import android.hardware.input.VirtualKeyEvent;
import android.hardware.input.VirtualKeyboardConfig;
import android.hardware.input.VirtualMouseButtonEvent;
import android.hardware.input.VirtualMouseConfig;
import android.hardware.input.VirtualMouseRelativeEvent;
import android.hardware.input.VirtualMouseScrollEvent;
import android.hardware.input.VirtualNavigationTouchpadConfig;
import android.hardware.input.VirtualRotaryEncoderConfig;
import android.hardware.input.VirtualRotaryEncoderScrollEvent;
import android.hardware.input.VirtualStylusButtonEvent;
import android.hardware.input.VirtualStylusConfig;
import android.hardware.input.VirtualStylusMotionEvent;
import android.hardware.input.VirtualTouchEvent;
import android.hardware.input.VirtualTouchscreenConfig;
import android.media.AudioManager;
import android.media.audiopolicy.AudioMix;
import android.os.Binder;
import android.os.IBinder;
import android.os.LocaleList;
import android.os.Looper;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;
import android.window.DisplayWindowPolicyController;
import com.android.internal.app.BlockedAppStreamingActivity;
import com.android.modules.expresslog.Counter;
import com.android.server.LocalServices;
import com.android.server.companion.virtual.audio.VirtualAudioController;
import com.android.server.companion.virtual.camera.VirtualCameraController;
import com.android.server.inputmethod.InputMethodManagerInternal;
import dalvik.annotation.optimization.FastNative;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
final class VirtualDeviceImpl extends IVirtualDevice.Stub implements IBinder.DeathRecipient, GenericWindowPolicyController.RunningAppsChangedListener {
    private static final int DEFAULT_VIRTUAL_DISPLAY_FLAGS = 24896;
    private static final List<String> DEVICE_PROFILES_ALLOWING_MIRROR_DISPLAYS = null;
    public static final long DO_NOT_SHOW_TOAST_WHEN_SECURE_SURFACE_SHOWN = 311101667;
    private static final long PENDING_TRAMPOLINE_TIMEOUT_MS = 5000;
    private static final String PERSISTENT_ID_PREFIX_CDM_ASSOCIATION = "companion:";
    private static final String TAG = "VirtualDeviceImpl";
    private IVirtualDeviceActivityListener mActivityListener;
    private GenericWindowPolicyController.ActivityListener mActivityListenerAdapter;
    private final Set<ComponentName> mActivityPolicyExemptions;
    private final Set<String> mActivityPolicyPackageExemptions;
    private final IBinder mAppToken;
    private final AssociationInfo mAssociationInfo;
    private final AttributionSource mAttributionSource;
    private final int mBaseVirtualDisplayFlags;
    private final CameraAccessController mCameraAccessController;
    private final Context mContext;
    private boolean mDefaultShowPointerIcon;
    private final int mDeviceId;
    private final SparseIntArray mDevicePolicies;
    private final DisplayManagerGlobal mDisplayManager;
    private final DisplayManagerInternal mDisplayManagerInternal;
    private final InputController mInputController;
    private final Map<IBinder, IntentFilter> mIntentInterceptors;
    private LocaleList mLocaleList;
    private boolean mLockdownActive;
    private final String mOwnerPackageName;
    private final int mOwnerUid;
    private final VirtualDeviceParams mParams;
    private final PendingTrampolineCallback mPendingTrampolineCallback;
    private final String mPersistentDeviceId;
    private final Object mPowerLock;
    private final PowerManager mPowerManager;
    private final VirtualDevice mPublicVirtualDeviceObject;
    private boolean mRequestedToBeAwake;
    private final Consumer<ArraySet<Integer>> mRunningAppsChangedCallback;
    private final SensorController mSensorController;
    private final VirtualDeviceManagerService mService;
    private IVirtualDeviceSoundEffectListener mSoundEffectListener;
    private VirtualAudioController mVirtualAudioController;
    private final VirtualCameraController mVirtualCameraController;
    private final Object mVirtualDeviceLock;
    private final VirtualDeviceLog mVirtualDeviceLog;
    private final SparseArray<VirtualDisplayWrapper> mVirtualDisplays;

    private class GwpcActivityListener implements GenericWindowPolicyController.ActivityListener {
        final /* synthetic */ VirtualDeviceImpl this$0;

        /* synthetic */ GwpcActivityListener(VirtualDeviceImpl r1, VirtualDeviceImplIA r2) {
            this(r1);
        }

        private GwpcActivityListener(VirtualDeviceImpl r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.companion.virtual.GenericWindowPolicyController.ActivityListener
        public void onTopActivityChanged(int displayId, ComponentName topActivity, int userId) {
            VirtualDeviceImpl.m3008$$Nest$fgetmActivityListener(this.this$0).onTopActivityChanged(displayId, topActivity, userId);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.w(VirtualDeviceImpl.TAG, "Unable to call mActivityListener for display: " + displayId, e);
        }

        @Override // com.android.server.companion.virtual.GenericWindowPolicyController.ActivityListener
        public void onDisplayEmpty(int displayId) {
            VirtualDeviceImpl.m3008$$Nest$fgetmActivityListener(this.this$0).onDisplayEmpty(displayId);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.w(VirtualDeviceImpl.TAG, "Unable to call mActivityListener for display: " + displayId, e);
        }

        @Override // com.android.server.companion.virtual.GenericWindowPolicyController.ActivityListener
        public void onActivityLaunchBlocked(int displayId, ActivityInfo activityInfo, IntentSender intentSender) {
            Intent intent = BlockedAppStreamingActivity.createIntent(activityInfo, this.this$0.getDisplayName());
            if (VirtualDeviceImpl.m3014$$Nest$mshouldShowBlockedActivityDialog(this.this$0, activityInfo.getComponentName(), intent.getComponent()) == false) goto L11;
            VirtualDeviceImpl.m3010$$Nest$fgetmContext(this.this$0).startActivityAsUser(intent.addFlags(268468224), ActivityOptions.makeBasic().setLaunchDisplayId(displayId).toBundle(), UserHandle.SYSTEM);
        L11:
            VirtualDeviceImpl.m3008$$Nest$fgetmActivityListener(this.this$0).onActivityLaunchBlocked(displayId, activityInfo.getComponentName(), UserHandle.getUserHandleForUid(activityInfo.applicationInfo.uid), intentSender);     // Catch: RemoteException -> L8
            return;
        L8:
            e = move-exception;
            Slog.w(VirtualDeviceImpl.TAG, "Unable to call mActivityListener for display: " + displayId, e);
        }

        @Override // com.android.server.companion.virtual.GenericWindowPolicyController.ActivityListener
        public void onSecureWindowShown(int displayId, ActivityInfo activityInfo) {
            VirtualDeviceImpl.m3008$$Nest$fgetmActivityListener(this.this$0).onSecureWindowShown(displayId, activityInfo.getComponentName(), UserHandle.getUserHandleForUid(activityInfo.applicationInfo.uid));     // Catch: RemoteException -> L5
        L8:
            if (CompatChanges.isChangeEnabled(VirtualDeviceImpl.DO_NOT_SHOW_TOAST_WHEN_SECURE_SURFACE_SHOWN, VirtualDeviceImpl.m3012$$Nest$fgetmOwnerPackageName(this.this$0), UserHandle.getUserHandleForUid(VirtualDeviceImpl.m3013$$Nest$fgetmOwnerUid(this.this$0))) == false) goto L10;
            return;
        L10:
            DisplayManager displayManager = (DisplayManager) VirtualDeviceImpl.m3010$$Nest$fgetmContext(this.this$0).getSystemService(DisplayManager.class);
            Display display = displayManager.getDisplay(displayId);
            if (display != null) goto L13;
            Slog.e(VirtualDeviceImpl.TAG, "Calling onSecureWindowShown on a non existent/connected display: " + displayId);
            return;
        L13:
            if ((display.getFlags() & 2) != 0) goto L19;
            this.this$0.showToastWhereUidIsRunning(activityInfo.applicationInfo.uid, 17042330, 1, VirtualDeviceImpl.m3010$$Nest$fgetmContext(this.this$0).getMainLooper());
            Counter.logIncrementWithUid("virtual_devices.value_secure_window_blocked_count", VirtualDeviceImpl.m3009$$Nest$fgetmAttributionSource(this.this$0).getUid());
            return;
        L19:
            return;
        L5:
            e = move-exception;
            Slog.w(VirtualDeviceImpl.TAG, "Unable to call mActivityListener for display: " + displayId, e);
            goto L8
        }

        @Override // com.android.server.companion.virtual.GenericWindowPolicyController.ActivityListener
        public void onSecureWindowHidden(int displayId) {
            VirtualDeviceImpl.m3008$$Nest$fgetmActivityListener(this.this$0).onSecureWindowHidden(displayId);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.w(VirtualDeviceImpl.TAG, "Unable to call mActivityListener for display: " + displayId, e);
        }

        @Override // com.android.server.companion.virtual.GenericWindowPolicyController.ActivityListener
        public boolean shouldInterceptIntent(Intent intent) {
            Map r1 = VirtualDeviceImpl.m3011$$Nest$fgetmIntentInterceptors(this.this$0);
            monitor-enter(r1);
            Iterator r2 = VirtualDeviceImpl.m3011$$Nest$fgetmIntentInterceptors(this.this$0).entrySet().iterator();     // Catch: Throwable -> L14
            boolean hasInterceptedIntent = false;
        L6:
            boolean hasInterceptedIntent2 = r2.hasNext();     // Catch: Throwable -> L14
            if (hasInterceptedIntent2 == false) goto L26;
            Map.Entry<IBinder, IntentFilter> interceptor = (Map.Entry) r2.next();     // Catch: Throwable -> L14
            IntentFilter intentFilter = interceptor.getValue();     // Catch: Throwable -> L14
            if (intent.getAction() != null) goto L16;
            if (intentFilter.countActions() == 0) goto L16;
            boolean r0 = false;
        L17:
            boolean explicitActionMatch = r0;
            if (explicitActionMatch == false) goto L6;
            if (intentFilter.match(intent.getAction(), intent.getType(), intent.getScheme(), intent.getData(), intent.getCategories(), VirtualDeviceImpl.TAG) < 0) goto L6;
            IVirtualDeviceIntentInterceptor.Stub.asInterface(interceptor.getKey()).onIntentIntercepted(new Intent(intent.getAction(), intent.getData()));     // Catch: Throwable -> L14 RemoteException -> L23
            hasInterceptedIntent = true;
            goto L6
        L23:
            e = move-exception;
            Slog.w(VirtualDeviceImpl.TAG, "Unable to call mActivityListener", e);     // Catch: Throwable -> L14
        L16:
            r0 = true;
            goto L17
        L26:
            monitor-exit(r1);     // Catch: Throwable -> L14
            return hasInterceptedIntent;
        L14:
            th = move-exception;
            throw th;
        }
    }

    static class PendingTrampoline {
        final int mDisplayId;
        final PendingIntent mPendingIntent;
        final ResultReceiver mResultReceiver;

        /* synthetic */ PendingTrampoline(PendingIntent r1, ResultReceiver r2, int r3, VirtualDeviceImplIA r4) {
            this(r1, r2, r3);
        }

        private PendingTrampoline(PendingIntent pendingIntent, ResultReceiver resultReceiver, int displayId) {
            this.mPendingIntent = pendingIntent;
            this.mResultReceiver = resultReceiver;
            this.mDisplayId = displayId;
        }

        public String toString() {
            return "PendingTrampoline{pendingIntent=" + this.mPendingIntent + ", resultReceiver=" + this.mResultReceiver + ", displayId=" + this.mDisplayId + "}";
        }
    }

    interface PendingTrampolineCallback {
        void startWaitingForPendingTrampoline(PendingTrampoline r1);

        void stopWaitingForPendingTrampoline(PendingTrampoline r1);
    }

    private static final class VirtualDisplayWrapper {
        private final boolean mIsMirror;
        private final boolean mIsTrusted;
        private final IVirtualDisplayCallback mToken;
        private final PowerManager.WakeLock mWakeLock;
        private final GenericWindowPolicyController mWindowPolicyController;

        VirtualDisplayWrapper(IVirtualDisplayCallback token, GenericWindowPolicyController windowPolicyController, PowerManager.WakeLock wakeLock, boolean isTrusted, boolean isMirror) {
            token.getClass();
            this.mToken = token;
            windowPolicyController.getClass();
            this.mWindowPolicyController = windowPolicyController;
            this.mWakeLock = wakeLock;
            this.mIsTrusted = isTrusted;
            this.mIsMirror = isMirror;
        }

        GenericWindowPolicyController getWindowPolicyController() {
            return this.mWindowPolicyController;
        }

        void acquireWakeLock() {
            if (this.mWakeLock != null) goto L5;
            return;
        L5:
            if (this.mWakeLock.isHeld() == true) goto L9;
            this.mWakeLock.acquire();
            return;
        }

        void releaseWakeLock() {
            if (this.mWakeLock != null) goto L5;
            return;
        L5:
            if (this.mWakeLock.isHeld() == false) goto L9;
            this.mWakeLock.release();
            return;
        }

        boolean isTrusted() {
            return this.mIsTrusted;
        }

        boolean isMirror() {
            return this.mIsMirror;
        }

        IVirtualDisplayCallback getToken() {
            return this.mToken;
        }
    }

    public static /* synthetic */ void $r8$lambda$RaugeT8uCZZ5nfGjgxbmta7PqXg(VirtualDeviceImpl r0, PendingTrampoline r1) {
        r0.lambda$launchPendingIntent$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Z53MQXY6IsRZRvjFonPCLjY24-0, reason: not valid java name */
    public static /* synthetic */ void m3006$r8$lambda$Z53MQXY6IsRZRvjFonPCLjY240(VirtualDeviceImpl r0, int r1, VirtualDisplayWrapper r2, boolean r3, GenericWindowPolicyController r4) {
        r0.lambda$createVirtualDisplay$1(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$uN140wfIUX0kWtdsfc-KpevIzLQ, reason: not valid java name */
    public static /* synthetic */ boolean m3007$r8$lambda$uN140wfIUX0kWtdsfcKpevIzLQ(int r0, InputController.InputDeviceDescriptor r1) {
        return lambda$isInputDeviceOwnedByVirtualDevice$2(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ IVirtualDeviceActivityListener m3008$$Nest$fgetmActivityListener(VirtualDeviceImpl r0) {
        return r0.mActivityListener;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAttributionSource, reason: not valid java name */
    static /* bridge */ /* synthetic */ AttributionSource m3009$$Nest$fgetmAttributionSource(VirtualDeviceImpl r0) {
        return r0.mAttributionSource;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m3010$$Nest$fgetmContext(VirtualDeviceImpl r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIntentInterceptors, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m3011$$Nest$fgetmIntentInterceptors(VirtualDeviceImpl r0) {
        return r0.mIntentInterceptors;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOwnerPackageName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3012$$Nest$fgetmOwnerPackageName(VirtualDeviceImpl r0) {
        return r0.mOwnerPackageName;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOwnerUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3013$$Nest$fgetmOwnerUid(VirtualDeviceImpl r0) {
        return r0.mOwnerUid;
    }

    /* JADX INFO: renamed from: -$$Nest$mshouldShowBlockedActivityDialog, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3014$$Nest$mshouldShowBlockedActivityDialog(VirtualDeviceImpl r0, ComponentName r1, ComponentName r2) {
        return r0.shouldShowBlockedActivityDialog(r1, r2);
    }

    @FastNative
    private static native boolean nativeVirtualCameraServiceBuildFlagEnabled();

    static {
        DEVICE_PROFILES_ALLOWING_MIRROR_DISPLAYS = List.of("android.app.role.COMPANION_DEVICE_APP_STREAMING");
    }

    VirtualDeviceImpl(Context context, AssociationInfo associationInfo, VirtualDeviceManagerService service, VirtualDeviceLog virtualDeviceLog, IBinder token, AttributionSource attributionSource, int deviceId, CameraAccessController cameraAccessController, PendingTrampolineCallback pendingTrampolineCallback, IVirtualDeviceActivityListener activityListener, IVirtualDeviceSoundEffectListener soundEffectListener, Consumer<ArraySet<Integer>> runningAppsChangedCallback, VirtualDeviceParams params) {
        DisplayManagerGlobal r15 = DisplayManagerGlobal.getInstance();
        if (isVirtualCameraEnabled() == false) goto L5;
        VirtualDeviceParams r14 = params;
        int r7 = deviceId;
        VirtualCameraController r16 = new VirtualCameraController(r14.getDevicePolicy(5), r7);
    L6:
        this(context, associationInfo, service, virtualDeviceLog, token, attributionSource, r7, null, cameraAccessController, pendingTrampolineCallback, activityListener, soundEffectListener, runningAppsChangedCallback, r14, r15, r16);
        return;
    L5:
        r7 = deviceId;
        r14 = params;
        r16 = null;
        goto L6
    }

    VirtualDeviceImpl(Context context, AssociationInfo associationInfo, VirtualDeviceManagerService service, VirtualDeviceLog virtualDeviceLog, IBinder token, AttributionSource attributionSource, int deviceId, InputController inputController, CameraAccessController cameraAccessController, PendingTrampolineCallback pendingTrampolineCallback, IVirtualDeviceActivityListener activityListener, IVirtualDeviceSoundEffectListener soundEffectListener, Consumer<ArraySet<Integer>> runningAppsChangedCallback, VirtualDeviceParams params, DisplayManagerGlobal displayManager, VirtualCameraController virtualCameraController) {
        this.mVirtualDeviceLock = new Object();
        this.mVirtualDisplays = new SparseArray();
        String r0 = null;
        this.mActivityListenerAdapter = null;
        this.mIntentInterceptors = new ArrayMap();
        this.mDefaultShowPointerIcon = true;
        this.mLocaleList = null;
        this.mPowerLock = new Object();
        this.mLockdownActive = false;
        this.mRequestedToBeAwake = true;
        this.mActivityPolicyPackageExemptions = new ArraySet();
        this.mVirtualDeviceLog = virtualDeviceLog;
        this.mOwnerPackageName = attributionSource.getPackageName();
        this.mAttributionSource = attributionSource;
        UserHandle ownerUserHandle = UserHandle.getUserHandleForUid(attributionSource.getUid());
        this.mContext = context.createContextAsUser(ownerUserHandle, 0);
        this.mAssociationInfo = associationInfo;
        if (associationInfo == null) goto L6;
        r0 = createPersistentDeviceId(associationInfo.getId());
    L6:
        this.mPersistentDeviceId = r0;
        this.mService = service;
        this.mPendingTrampolineCallback = pendingTrampolineCallback;
        this.mActivityListener = activityListener;
        this.mSoundEffectListener = soundEffectListener;
        this.mRunningAppsChangedCallback = runningAppsChangedCallback;
        this.mOwnerUid = attributionSource.getUid();
        this.mDeviceId = deviceId;
        this.mAppToken = token;
        this.mParams = params;
        this.mDevicePolicies = params.getDevicePolicies();
        this.mDisplayManager = displayManager;
        this.mDisplayManagerInternal = (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
        this.mPowerManager = (PowerManager) context.getSystemService(PowerManager.class);
        if (this.mDevicePolicies.get(4, 0) == 0) goto L14;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.ADD_TRUSTED_DISPLAY") == 0) goto L14;
        throw new SecurityException("Requires ADD_TRUSTED_DISPLAY permission to set a custom clipboard policy.");
    L14:
        if (this.mParams.getLockState() == 1) goto L16;
        int flags = DEFAULT_VIRTUAL_DISPLAY_FLAGS;
    L21:
        this.mBaseVirtualDisplayFlags = flags;
        if (inputController != null) goto L24;
        this.mInputController = new InputController(context.getMainThreadHandler(), (WindowManager) context.getSystemService(WindowManager.class), this.mAttributionSource);
    L25:
        this.mSensorController = new SensorController(this, this.mDeviceId, this.mAttributionSource, this.mParams.getVirtualSensorCallback(), this.mParams.getVirtualSensorConfigs());
        this.mCameraAccessController = cameraAccessController;
        if (this.mCameraAccessController == null) goto L28;
        this.mCameraAccessController.startObservingIfNeeded();
    L28:
        this.mVirtualCameraController = virtualCameraController;
        token.linkToDeath(this, 0);     // Catch: RemoteException -> L38
        this.mVirtualDeviceLog.logCreated(deviceId, this.mOwnerUid);
        this.mPublicVirtualDeviceObject = new VirtualDevice(this, getDeviceId(), getPersistentDeviceId(), this.mParams.getName(), getDisplayName());
        if (this.mParams.getDevicePolicy(3) != 0) goto L33;
        Set r2 = this.mParams.getBlockedActivities();
    L34:
        this.mActivityPolicyExemptions = new ArraySet(r2);
        if (this.mParams.getInputMethodComponent() == null) goto L43;
        String imeId = this.mParams.getInputMethodComponent().flattenToShortString();
        Slog.d(TAG, "Setting custom input method " + imeId + " as default for virtual device " + deviceId);
        InputMethodManagerInternal.get().setVirtualDeviceInputMethodForAllUsers(this.mDeviceId, imeId);
        return;
    L43:
        return;
    L33:
        r2 = this.mParams.getAllowedActivities();
    L38:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    L24:
        this.mInputController = inputController;
        goto L25
    L16:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.ADD_ALWAYS_UNLOCKED_DISPLAY") != 0) goto L19;
        int flags2 = DEFAULT_VIRTUAL_DISPLAY_FLAGS | 4096;
        flags = flags2;
        goto L21
    L19:
        throw new SecurityException("Requires ADD_ALWAYS_UNLOCKED_DISPLAY permission to create an always unlocked virtual device.");
    }

    void onLockdownChanged(boolean lockdownActive) {
        Object r0 = this.mPowerLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (lockdownActive == this.mLockdownActive) goto L14;
        this.mLockdownActive = lockdownActive;     // Catch: Throwable -> L9
        if (this.mLockdownActive == false) goto L12;
        goToSleepInternal(12);     // Catch: Throwable -> L9
        goto L14
    L12:
        if (this.mRequestedToBeAwake == false) goto L14;
        wakeUpInternal(11, "android.server.companion.virtual:LOCKDOWN_ENDED");     // Catch: Throwable -> L9
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    SensorController getSensorControllerForTest() {
        return this.mSensorController;
    }

    static String createPersistentDeviceId(int associationId) {
        return PERSISTENT_ID_PREFIX_CDM_ASSOCIATION + associationId;
    }

    int getBaseVirtualDisplayFlags() {
        return this.mBaseVirtualDisplayFlags;
    }

    CameraAccessController getCameraAccessController() {
        return this.mCameraAccessController;
    }

    CharSequence getDisplayName() {
        if (this.mAssociationInfo != null) goto L6;
        return this.mParams.getName();
    L6:
        return this.mAssociationInfo.getDisplayName();
    }

    String getDeviceProfile() {
        if (this.mAssociationInfo != null) goto L6;
        return null;
    L6:
        return this.mAssociationInfo.getDeviceProfile();
    }

    VirtualDevice getPublicVirtualDeviceObject() {
        return this.mPublicVirtualDeviceObject;
    }

    LocaleList getDeviceLocaleList() {
        Object r0 = this.mVirtualDeviceLock;
        monitor-enter(r0);
        LocaleList r1 = this.mLocaleList;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setListeners(IVirtualDeviceActivityListener activityListener, IVirtualDeviceSoundEffectListener soundEffectListener) {
        activityListener.getClass();
        this.mActivityListener = activityListener;
        soundEffectListener.getClass();
        this.mSoundEffectListener = soundEffectListener;
    }

    public int getDevicePolicy(int policyType) {
        Object r0 = this.mVirtualDeviceLock;
        monitor-enter(r0);
        int r1 = this.mDevicePolicies.get(policyType, 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getAudioPlaybackSessionId() {
        return this.mParams.getAudioPlaybackSessionId();
    }

    public int getAudioRecordingSessionId() {
        return this.mParams.getAudioRecordingSessionId();
    }

    public int getDeviceId() {
        return this.mDeviceId;
    }

    public String getPersistentDeviceId() {
        return this.mPersistentDeviceId;
    }

    public int getAssociationId() {
        if (this.mAssociationInfo != null) goto L6;
        return 0;
    L6:
        return this.mAssociationInfo.getId();
    }

    public void goToSleep() {
        checkCallerIsDeviceOwner();
        Object r0 = this.mPowerLock;
        monitor-enter(r0);
        this.mRequestedToBeAwake = false;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        long ident = Binder.clearCallingIdentity();
        goToSleepInternal(4);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(ident);
        return;
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L14:
        th = move-exception;
        throw th;
    }

    public void wakeUp() {
        checkCallerIsDeviceOwner();
        Object r0 = this.mPowerLock;
        monitor-enter(r0);
        this.mRequestedToBeAwake = true;     // Catch: Throwable -> L10
        if (this.mLockdownActive == false) goto L12;
        Slog.w(TAG, "Cannot wake up device during lockdown.");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        long ident = Binder.clearCallingIdentity();
        wakeUpInternal(1, "android.server.companion.virtual:DEVICE_ON");     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(ident);
        return;
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L10:
        th = move-exception;
        throw th;
    }

    public void launchPendingIntent(int displayId, PendingIntent pendingIntent, ResultReceiver resultReceiver) {
        checkCallerIsDeviceOwner();
        pendingIntent.getClass();
        Object r0 = this.mVirtualDeviceLock;
        monitor-enter(r0);
        checkDisplayOwnedByVirtualDeviceLocked(displayId);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        VirtualDeviceImplIA r2 = null;
        if (pendingIntent.isActivity() == true) goto L21;
        final PendingTrampoline pendingTrampoline = new PendingTrampoline(pendingIntent, resultReceiver, displayId, r2);
        this.mPendingTrampolineCallback.startWaitingForPendingTrampoline(pendingTrampoline);
        this.mContext.getMainThreadHandler().postDelayed(new VirtualDeviceImpl$$ExternalSyntheticLambda0(this, pendingTrampoline), PENDING_TRAMPOLINE_TIMEOUT_MS);
        sendPendingIntent(displayId, pendingIntent);     // Catch: PendingIntent.CanceledException -> L15
        return;
    L15:
        e = move-exception;
        Slog.w(TAG, "Pending intent canceled", e);
        resultReceiver.send(1, null);
        this.mPendingTrampolineCallback.stopWaitingForPendingTrampoline(pendingTrampoline);
        return;
    L21:
        sendPendingIntent(displayId, pendingIntent);     // Catch: PendingIntent.CanceledException -> L10
        resultReceiver.send(0, null);     // Catch: PendingIntent.CanceledException -> L10
        return;
    L10:
        e = move-exception;
        Slog.w(TAG, "Pending intent canceled", e);
        resultReceiver.send(1, null);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$launchPendingIntent$0(PendingTrampoline pendingTrampoline) {
        pendingTrampoline.mResultReceiver.send(2, null);
        this.mPendingTrampolineCallback.stopWaitingForPendingTrampoline(pendingTrampoline);
    }

    public void addActivityPolicyExemption(ActivityPolicyExemption exemption) {
        checkCallerIsDeviceOwner();
        int displayId = exemption.getDisplayId();
        if (exemption.getComponentName() == null) goto L6;
        if (displayId != (-1)) goto L6;
    L6:
        Object r1 = this.mVirtualDeviceLock;
        monitor-enter(r1);
        if (displayId == (-1)) goto L18;
        checkDisplayOwnedByVirtualDeviceLocked(displayId);     // Catch: Throwable -> L12
        if (exemption.getComponentName() == null) goto L15;
        this.mVirtualDisplays.get(displayId).getWindowPolicyController().addActivityPolicyExemption(exemption.getComponentName());     // Catch: Throwable -> L12
    L34:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L15:
        if (exemption.getPackageName() == null) goto L34;
        this.mVirtualDisplays.get(displayId).getWindowPolicyController().addActivityPolicyExemption(exemption.getPackageName());     // Catch: Throwable -> L12
        goto L34
    L18:
        if (exemption.getComponentName() == null) goto L27;
        if (this.mActivityPolicyExemptions.add(exemption.getComponentName()) == false) goto L27;
        int i = 0;
    L23:
        if (i >= this.mVirtualDisplays.size()) goto L34;
        this.mVirtualDisplays.valueAt(i).getWindowPolicyController().addActivityPolicyExemption(exemption.getComponentName());     // Catch: Throwable -> L12
        i = i + 1;     // Catch: Throwable -> L12
    L27:
        if (exemption.getPackageName() == null) goto L34;
        if (this.mActivityPolicyPackageExemptions.add(exemption.getPackageName()) == false) goto L34;
        int i2 = 0;
    L32:
        if (i2 >= this.mVirtualDisplays.size()) goto L34;
        this.mVirtualDisplays.valueAt(i2).getWindowPolicyController().addActivityPolicyExemption(exemption.getPackageName());     // Catch: Throwable -> L12
        i2 = i2 + 1;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public void removeActivityPolicyExemption(ActivityPolicyExemption exemption) {
        checkCallerIsDeviceOwner();
        int displayId = exemption.getDisplayId();
        if (exemption.getComponentName() == null) goto L6;
        if (displayId != (-1)) goto L6;
    L6:
        Object r1 = this.mVirtualDeviceLock;
        monitor-enter(r1);
        if (displayId == (-1)) goto L18;
        checkDisplayOwnedByVirtualDeviceLocked(displayId);     // Catch: Throwable -> L12
        if (exemption.getComponentName() == null) goto L15;
        this.mVirtualDisplays.get(displayId).getWindowPolicyController().removeActivityPolicyExemption(exemption.getComponentName());     // Catch: Throwable -> L12
    L34:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L15:
        if (exemption.getPackageName() == null) goto L34;
        this.mVirtualDisplays.get(displayId).getWindowPolicyController().removeActivityPolicyExemption(exemption.getPackageName());     // Catch: Throwable -> L12
        goto L34
    L18:
        if (exemption.getComponentName() == null) goto L27;
        if (this.mActivityPolicyExemptions.remove(exemption.getComponentName()) == false) goto L27;
        int i = 0;
    L23:
        if (i >= this.mVirtualDisplays.size()) goto L34;
        this.mVirtualDisplays.valueAt(i).getWindowPolicyController().removeActivityPolicyExemption(exemption.getComponentName());     // Catch: Throwable -> L12
        i = i + 1;     // Catch: Throwable -> L12
    L27:
        if (exemption.getPackageName() == null) goto L34;
        if (this.mActivityPolicyPackageExemptions.remove(exemption.getPackageName()) == false) goto L34;
        int i2 = 0;
    L32:
        if (i2 >= this.mVirtualDisplays.size()) goto L34;
        this.mVirtualDisplays.valueAt(i2).getWindowPolicyController().removeActivityPolicyExemption(exemption.getPackageName());     // Catch: Throwable -> L12
        i2 = i2 + 1;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private void sendPendingIntent(int displayId, PendingIntent pendingIntent) throws PendingIntent.CanceledException {
        ActivityOptions options = ActivityOptions.makeBasic().setLaunchDisplayId(displayId);
        options.setPendingIntentBackgroundActivityStartMode(3);
        pendingIntent.send(this.mContext, 0, null, null, null, null, options.toBundle());
    }

    public void close() {
        if (this.mService.removeVirtualDevice(this.mDeviceId) == true) goto L5;
        return;
    L5:
        this.mVirtualDeviceLog.logClosed(this.mDeviceId, this.mOwnerUid);
        long ident = Binder.clearCallingIdentity();
        Object r2 = this.mVirtualDeviceLock;     // Catch: Throwable -> L22
        monitor-enter(r2);     // Catch: Throwable -> L22
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L9:
        if (this.mVirtualAudioController == null) goto L13;
        this.mVirtualAudioController.stopListening();     // Catch: Throwable -> L11
        this.mVirtualAudioController = null;     // Catch: Throwable -> L11
    L13:
        this.mLocaleList = null;     // Catch: Throwable -> L11
        VirtualDisplayWrapper[] virtualDisplaysToBeReleased = new VirtualDisplayWrapper[this.mVirtualDisplays.size()];     // Catch: Throwable -> L11
        int i = 0;
    L15:
        if (i >= this.mVirtualDisplays.size()) goto L17;
        virtualDisplaysToBeReleased[i] = this.mVirtualDisplays.valueAt(i);     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L15
    L17:
        this.mVirtualDisplays.clear();     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        int r3 = virtualDisplaysToBeReleased.length;     // Catch: Throwable -> L22
        int r6 = 0;
    L20:
        if (r6 >= r3) goto L24;
        VirtualDisplayWrapper virtualDisplayWrapper = virtualDisplaysToBeReleased[r6];     // Catch: Throwable -> L22
        this.mDisplayManager.releaseVirtualDisplay(virtualDisplayWrapper.getToken());     // Catch: Throwable -> L22
        releaseOwnedVirtualDisplayResources(virtualDisplayWrapper);     // Catch: Throwable -> L22
        r6 = r6 + 1;     // Catch: Throwable -> L22
        goto L20
    L24:
        this.mAppToken.unlinkToDeath(this, 0);     // Catch: Throwable -> L22
        if (this.mCameraAccessController == null) goto L28;
        this.mCameraAccessController.stopObservingIfNeeded();     // Catch: Throwable -> L22
    L28:
        if (this.mParams.getInputMethodComponent() == null) goto L30;
        InputMethodManagerInternal.get().setVirtualDeviceInputMethodForAllUsers(this.mDeviceId, null);     // Catch: Throwable -> L22
    L30:
        this.mInputController.close();     // Catch: Throwable -> L22
        this.mSensorController.close();     // Catch: Throwable -> L22
        Binder.restoreCallingIdentity(ident);
        if (this.mVirtualCameraController == null) goto L44;
        this.mVirtualCameraController.close();
        return;
    L44:
        return;
    L22:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        close();
    }

    @Override // com.android.server.companion.virtual.GenericWindowPolicyController.RunningAppsChangedListener
    public void onRunningAppsChanged(ArraySet<Integer> runningUids) {
        if (this.mCameraAccessController == null) goto L5;
        this.mCameraAccessController.blockCameraAccessIfNeeded(runningUids);
    L5:
        this.mRunningAppsChangedCallback.accept(runningUids);
    }

    VirtualAudioController getVirtualAudioControllerForTesting() {
        return this.mVirtualAudioController;
    }

    public void onAudioSessionStarting(int displayId, IAudioRoutingCallback routingCallback, IAudioConfigChangedCallback configChangedCallback) {
        checkCallerIsDeviceOwner();
        Object r0 = this.mVirtualDeviceLock;
        monitor-enter(r0);
        checkDisplayOwnedByVirtualDeviceLocked(displayId);     // Catch: Throwable -> L7
        if (this.mVirtualAudioController != null) goto L9;
        this.mVirtualAudioController = new VirtualAudioController(this.mContext, this.mAttributionSource);     // Catch: Throwable -> L7
        GenericWindowPolicyController gwpc = this.mVirtualDisplays.get(displayId).getWindowPolicyController();     // Catch: Throwable -> L7
        this.mVirtualAudioController.startListening(gwpc, routingCallback, configChangedCallback);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onAudioSessionEnded() {
        checkCallerIsDeviceOwner();
        Object r0 = this.mVirtualDeviceLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mVirtualAudioController == null) goto L9;
        this.mVirtualAudioController.stopListening();     // Catch: Throwable -> L7
        this.mVirtualAudioController = null;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void setDevicePolicy(int policyType, int devicePolicy) {
        checkCallerIsDeviceOwner();
        switch(policyType) {
            case 2: goto L61;
            case 3: goto L41;
            case 4: goto L15;
            case 5: goto L5;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        Object r0 = this.mVirtualDeviceLock;
        monitor-enter(r0);
        this.mDevicePolicies.put(policyType, devicePolicy);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L41:
        Object r2 = this.mVirtualDeviceLock;
        monitor-enter(r2);
    L46:
        th = move-exception;
        throw th;
    L44:
        if (getDevicePolicy(policyType) == devicePolicy) goto L48;
        this.mActivityPolicyExemptions.clear();     // Catch: Throwable -> L46
        this.mActivityPolicyPackageExemptions.clear();     // Catch: Throwable -> L46
    L48:
        this.mDevicePolicies.put(policyType, devicePolicy);     // Catch: Throwable -> L46
        int i = 0;
    L50:
        if (i >= this.mVirtualDisplays.size()) goto L57;
        GenericWindowPolicyController r4 = this.mVirtualDisplays.valueAt(i).getWindowPolicyController();     // Catch: Throwable -> L46
        if (devicePolicy != 0) goto L54;
        boolean r5 = true;
    L55:
        r4.setActivityLaunchDefaultAllowed(r5);     // Catch: Throwable -> L46
        i = i + 1;     // Catch: Throwable -> L46
        goto L50
    L54:
        r5 = false;
        goto L55
    L57:
        monitor-exit(r2);     // Catch: Throwable -> L46
        return;
    L61:
        Object r3 = this.mVirtualDeviceLock;
        monitor-enter(r3);
        this.mDevicePolicies.put(policyType, devicePolicy);     // Catch: Throwable -> L73
        int i2 = 0;
    L65:
        if (i2 >= this.mVirtualDisplays.size()) goto L77;
        VirtualDisplayWrapper wrapper = this.mVirtualDisplays.valueAt(i2);     // Catch: Throwable -> L73
        if (wrapper.isTrusted() == false) goto L75;
        GenericWindowPolicyController r6 = wrapper.getWindowPolicyController();     // Catch: Throwable -> L73
        if (devicePolicy != 0) goto L71;
        boolean r7 = true;
    L72:
        r6.setShowInHostDeviceRecents(r7);     // Catch: Throwable -> L73
        goto L75
    L71:
        r7 = false;
    L75:
        i2 = i2 + 1;     // Catch: Throwable -> L73
        goto L65
    L77:
        monitor-exit(r3);     // Catch: Throwable -> L73
        return;
    L73:
        th = move-exception;
        throw th;
    L15:
        if (devicePolicy == 1) goto L17;
    L21:
        Object r8 = this.mVirtualDeviceLock;
        monitor-enter(r8);
        int i3 = 0;
    L83:
    L33:
        th = move-exception;
        throw th;
    L25:
        if (i3 >= this.mVirtualDisplays.size()) goto L36;
        VirtualDisplayWrapper wrapper2 = this.mVirtualDisplays.valueAt(i3);     // Catch: Throwable -> L33
        if (wrapper2.isTrusted() == true) goto L35;
        if (wrapper2.isMirror() == true) goto L35;
        throw new SecurityException("All displays must be trusted for devices with custom clipboard policy.");     // Catch: Throwable -> L33
    L35:
        i3 = i3 + 1;     // Catch: Throwable -> L33
        goto L83
    L36:
        this.mDevicePolicies.put(policyType, devicePolicy);     // Catch: Throwable -> L33
        monitor-exit(r8);     // Catch: Throwable -> L33
        return;
    L17:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.ADD_TRUSTED_DISPLAY") == 0) goto L21;
        throw new SecurityException("Requires ADD_TRUSTED_DISPLAY permission to set a custom clipboard policy.");
    L5:
        throw new IllegalArgumentException("Device policy " + policyType + " cannot be changed at runtime. ");
    }

    public void setDevicePolicyForDisplay(int displayId, int policyType, int devicePolicy) {
        checkCallerIsDeviceOwner();
        Object r0 = this.mVirtualDeviceLock;
        monitor-enter(r0);
        checkDisplayOwnedByVirtualDeviceLocked(displayId);     // Catch: Throwable -> L8
        boolean r1 = false;
        switch(policyType) {
            case 2: goto L14;
            case 3: goto L10;
            default: goto L7;
        };     // Catch: Throwable -> L8
    L10:
        GenericWindowPolicyController r3 = this.mVirtualDisplays.get(displayId).getWindowPolicyController();     // Catch: Throwable -> L8
        if (devicePolicy != 0) goto L13;
        r1 = true;
    L13:
        r3.setActivityLaunchDefaultAllowed(r1);     // Catch: Throwable -> L8
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        VirtualDisplayWrapper wrapper = this.mVirtualDisplays.get(displayId);     // Catch: Throwable -> L8
        if (wrapper.isTrusted() == false) goto L20;
        GenericWindowPolicyController r4 = wrapper.getWindowPolicyController();     // Catch: Throwable -> L8
        if (devicePolicy != 0) goto L19;
        r1 = true;
    L19:
        r4.setShowInHostDeviceRecents(r1);     // Catch: Throwable -> L8
        goto L20
    L7:
        throw new IllegalArgumentException("Device policy " + policyType + " cannot be changed for a specific display. ");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public void createVirtualDpad(VirtualDpadConfig config, IBinder deviceToken) {
        checkCallerIsDeviceOwner();
        config.getClass();
        checkVirtualInputDeviceDisplayIdAssociation(config.getAssociatedDisplayId());
        long ident = Binder.clearCallingIdentity();
    L22:
        this.mInputController.createDpad(config.getInputDeviceName(), config.getVendorId(), config.getProductId(), deviceToken, getTargetDisplayIdForInput(config.getAssociatedDisplayId()));     // Catch: Throwable -> L8 InputController.DeviceCreationException -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L10:
        e = move-exception;
        InputController.DeviceCreationException e = e;
    L18:
        throw new IllegalArgumentException(e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        InputController.DeviceCreationException e2 = th;
    L19:
        Binder.restoreCallingIdentity(ident);
        throw e2;
    L14:
        e = move-exception;
        e = e;
    L12:
        th = move-exception;
        e2 = th;
        goto L19
    }

    public void createVirtualKeyboard(VirtualKeyboardConfig config, IBinder deviceToken) {
        checkCallerIsDeviceOwner();
        config.getClass();
        checkVirtualInputDeviceDisplayIdAssociation(config.getAssociatedDisplayId());
        long ident = Binder.clearCallingIdentity();
    L29:
        this.mInputController.createKeyboard(config.getInputDeviceName(), config.getVendorId(), config.getProductId(), deviceToken, getTargetDisplayIdForInput(config.getAssociatedDisplayId()), config.getLanguageTag(), config.getLayoutType());     // Catch: Throwable -> L14 InputController.DeviceCreationException -> L16
        Object r13 = this.mVirtualDeviceLock;     // Catch: Throwable -> L14 InputController.DeviceCreationException -> L16
        monitor-enter(r13);     // Catch: Throwable -> L14 InputController.DeviceCreationException -> L16
        this.mLocaleList = LocaleList.forLanguageTags(config.getLanguageTag());     // Catch: Throwable -> L11
        monitor-exit(r13);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(ident);
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14 InputController.DeviceCreationException -> L16
    L16:
        e = move-exception;
        InputController.DeviceCreationException e = e;
    L24:
        throw new IllegalArgumentException(e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        InputController.DeviceCreationException e2 = th;
    L25:
        Binder.restoreCallingIdentity(ident);
        throw e2;
    L20:
        e = move-exception;
        e = e;
    L18:
        th = move-exception;
        e2 = th;
        goto L25
    }

    public void createVirtualMouse(VirtualMouseConfig config, IBinder deviceToken) {
        checkCallerIsDeviceOwner();
        config.getClass();
        checkVirtualInputDeviceDisplayIdAssociation(config.getAssociatedDisplayId());
        long ident = Binder.clearCallingIdentity();
    L21:
        this.mInputController.createMouse(config.getInputDeviceName(), config.getVendorId(), config.getProductId(), deviceToken, config.getAssociatedDisplayId());     // Catch: Throwable -> L8 InputController.DeviceCreationException -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L10:
        e = move-exception;
        InputController.DeviceCreationException e = e;
    L18:
        throw new IllegalArgumentException(e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        InputController.DeviceCreationException e2 = th;
    L19:
        Binder.restoreCallingIdentity(ident);
        throw e2;
    L14:
        e = move-exception;
        e = e;
    L12:
        th = move-exception;
        e2 = th;
        goto L19
    }

    public void createVirtualTouchscreen(VirtualTouchscreenConfig config, IBinder deviceToken) {
        checkCallerIsDeviceOwner();
        config.getClass();
        checkVirtualInputDeviceDisplayIdAssociation(config.getAssociatedDisplayId());
        long ident = Binder.clearCallingIdentity();
    L21:
        this.mInputController.createTouchscreen(config.getInputDeviceName(), config.getVendorId(), config.getProductId(), deviceToken, config.getAssociatedDisplayId(), config.getHeight(), config.getWidth());     // Catch: Throwable -> L8 InputController.DeviceCreationException -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L10:
        e = move-exception;
        InputController.DeviceCreationException e = e;
    L18:
        throw new IllegalArgumentException(e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        InputController.DeviceCreationException e2 = th;
    L19:
        Binder.restoreCallingIdentity(ident);
        throw e2;
    L14:
        e = move-exception;
        e = e;
    L12:
        th = move-exception;
        e2 = th;
        goto L19
    }

    public void createVirtualNavigationTouchpad(VirtualNavigationTouchpadConfig config, IBinder deviceToken) {
        checkCallerIsDeviceOwner();
        config.getClass();
        checkVirtualInputDeviceDisplayIdAssociation(config.getAssociatedDisplayId());
        long ident = Binder.clearCallingIdentity();
    L21:
        this.mInputController.createNavigationTouchpad(config.getInputDeviceName(), config.getVendorId(), config.getProductId(), deviceToken, getTargetDisplayIdForInput(config.getAssociatedDisplayId()), config.getHeight(), config.getWidth());     // Catch: Throwable -> L8 InputController.DeviceCreationException -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L10:
        e = move-exception;
        InputController.DeviceCreationException e = e;
    L18:
        throw new IllegalArgumentException(e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        InputController.DeviceCreationException e2 = th;
    L19:
        Binder.restoreCallingIdentity(ident);
        throw e2;
    L14:
        e = move-exception;
        e = e;
    L12:
        th = move-exception;
        e2 = th;
        goto L19
    }

    public void createVirtualStylus(VirtualStylusConfig config, IBinder deviceToken) {
        checkCallerIsDeviceOwner();
        config.getClass();
        deviceToken.getClass();
        checkVirtualInputDeviceDisplayIdAssociation(config.getAssociatedDisplayId());
        long ident = Binder.clearCallingIdentity();
    L21:
        this.mInputController.createStylus(config.getInputDeviceName(), config.getVendorId(), config.getProductId(), deviceToken, config.getAssociatedDisplayId(), config.getHeight(), config.getWidth());     // Catch: Throwable -> L8 InputController.DeviceCreationException -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L10:
        e = move-exception;
        InputController.DeviceCreationException e = e;
    L18:
        throw new IllegalArgumentException(e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        InputController.DeviceCreationException e2 = th;
    L19:
        Binder.restoreCallingIdentity(ident);
        throw e2;
    L14:
        e = move-exception;
        e = e;
    L12:
        th = move-exception;
        e2 = th;
        goto L19
    }

    public void createVirtualRotaryEncoder(VirtualRotaryEncoderConfig config, IBinder deviceToken) {
        checkCallerIsDeviceOwner();
        config.getClass();
        deviceToken.getClass();
        checkVirtualInputDeviceDisplayIdAssociation(config.getAssociatedDisplayId());
        long ident = Binder.clearCallingIdentity();
    L21:
        this.mInputController.createRotaryEncoder(config.getInputDeviceName(), config.getVendorId(), config.getProductId(), deviceToken, getTargetDisplayIdForInput(config.getAssociatedDisplayId()));     // Catch: Throwable -> L8 InputController.DeviceCreationException -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L10:
        e = move-exception;
        InputController.DeviceCreationException e = e;
    L18:
        throw new IllegalArgumentException(e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        InputController.DeviceCreationException e2 = th;
    L19:
        Binder.restoreCallingIdentity(ident);
        throw e2;
    L14:
        e = move-exception;
        e = e;
    L12:
        th = move-exception;
        e2 = th;
        goto L19
    }

    public void unregisterInputDevice(IBinder token) {
        checkCallerIsDeviceOwner();
        long ident = Binder.clearCallingIdentity();
        this.mInputController.unregisterInputDevice(token);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public int getInputDeviceId(IBinder token) {
        long ident = Binder.clearCallingIdentity();
        int r2 = this.mInputController.getInputDeviceId(token);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public boolean sendDpadKeyEvent(IBinder token, VirtualKeyEvent event) {
        checkCallerIsDeviceOwner();
        long ident = Binder.clearCallingIdentity();
        boolean r2 = this.mInputController.sendDpadKeyEvent(token, event);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public boolean sendKeyEvent(IBinder token, VirtualKeyEvent event) {
        checkCallerIsDeviceOwner();
        long ident = Binder.clearCallingIdentity();
        boolean r2 = this.mInputController.sendKeyEvent(token, event);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public boolean sendButtonEvent(IBinder token, VirtualMouseButtonEvent event) {
        checkCallerIsDeviceOwner();
        long ident = Binder.clearCallingIdentity();
        boolean r2 = this.mInputController.sendButtonEvent(token, event);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public boolean sendTouchEvent(IBinder token, VirtualTouchEvent event) {
        checkCallerIsDeviceOwner();
        long ident = Binder.clearCallingIdentity();
        boolean r2 = this.mInputController.sendTouchEvent(token, event);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public boolean sendRelativeEvent(IBinder token, VirtualMouseRelativeEvent event) {
        checkCallerIsDeviceOwner();
        long ident = Binder.clearCallingIdentity();
        boolean r2 = this.mInputController.sendRelativeEvent(token, event);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public boolean sendScrollEvent(IBinder token, VirtualMouseScrollEvent event) {
        checkCallerIsDeviceOwner();
        long ident = Binder.clearCallingIdentity();
        boolean r2 = this.mInputController.sendScrollEvent(token, event);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public PointF getCursorPosition(IBinder token) {
        long ident = Binder.clearCallingIdentity();
        PointF r2 = this.mInputController.getCursorPosition(token);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public boolean sendStylusMotionEvent(IBinder token, VirtualStylusMotionEvent event) {
        checkCallerIsDeviceOwner();
        token.getClass();
        event.getClass();
        long ident = Binder.clearCallingIdentity();
        boolean r2 = this.mInputController.sendStylusMotionEvent(token, event);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public boolean sendStylusButtonEvent(IBinder token, VirtualStylusButtonEvent event) {
        checkCallerIsDeviceOwner();
        token.getClass();
        event.getClass();
        long ident = Binder.clearCallingIdentity();
        boolean r2 = this.mInputController.sendStylusButtonEvent(token, event);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public boolean sendRotaryEncoderScrollEvent(IBinder token, VirtualRotaryEncoderScrollEvent event) {
        checkCallerIsDeviceOwner();
        long ident = Binder.clearCallingIdentity();
        boolean r2 = this.mInputController.sendRotaryEncoderScrollEvent(token, event);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void setShowPointerIcon(boolean showPointerIcon) {
        checkCallerIsDeviceOwner();
        long ident = Binder.clearCallingIdentity();
        Object r2 = this.mVirtualDeviceLock;     // Catch: Throwable -> L23
        monitor-enter(r2);     // Catch: Throwable -> L23
        this.mDefaultShowPointerIcon = showPointerIcon;     // Catch: Throwable -> L13
        int i = 0;
    L7:
        if (i >= this.mVirtualDisplays.size()) goto L18;
        VirtualDisplayWrapper wrapper = this.mVirtualDisplays.valueAt(i);     // Catch: Throwable -> L13
        if (wrapper.isTrusted() == true) goto L15;
        if (wrapper.isMirror() == true) goto L15;
    L16:
        i = i + 1;     // Catch: Throwable -> L13
    L15:
        this.mInputController.setShowPointerIcon(this.mDefaultShowPointerIcon, this.mVirtualDisplays.keyAt(i));     // Catch: Throwable -> L13
        goto L16
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(ident);
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void setDisplayImePolicy(int displayId, int policy) {
        checkCallerIsDeviceOwner();
        Object r0 = this.mVirtualDeviceLock;
        monitor-enter(r0);
        checkDisplayOwnedByVirtualDeviceLocked(displayId);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        long ident = Binder.clearCallingIdentity();
        this.mInputController.setDisplayImePolicy(displayId, policy);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L13:
        th = move-exception;
        throw th;
    }

    public List<VirtualSensor> getVirtualSensorList() {
        checkCallerIsDeviceOwner();
        return this.mSensorController.getSensorList();
    }

    VirtualSensor getVirtualSensorByHandle(int handle) {
        return this.mSensorController.getSensorByHandle(handle);
    }

    public boolean sendSensorEvent(IBinder token, VirtualSensorEvent event) {
        checkCallerIsDeviceOwner();
        long ident = Binder.clearCallingIdentity();
        boolean r2 = this.mSensorController.sendSensorEvent(token, event);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public boolean sendSensorAdditionalInfo(IBinder token, VirtualSensorAdditionalInfo info) {
        checkCallerIsDeviceOwner();
        long ident = Binder.clearCallingIdentity();
        boolean r2 = this.mSensorController.sendSensorAdditionalInfo(token, info);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void registerIntentInterceptor(IVirtualDeviceIntentInterceptor intentInterceptor, IntentFilter filter) {
        checkCallerIsDeviceOwner();
        intentInterceptor.getClass();
        filter.getClass();
        Map<IBinder, IntentFilter> r0 = this.mIntentInterceptors;
        monitor-enter(r0);
        this.mIntentInterceptors.put(intentInterceptor.asBinder(), filter);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unregisterIntentInterceptor(IVirtualDeviceIntentInterceptor intentInterceptor) {
        checkCallerIsDeviceOwner();
        intentInterceptor.getClass();
        Map<IBinder, IntentFilter> r0 = this.mIntentInterceptors;
        monitor-enter(r0);
        this.mIntentInterceptors.remove(intentInterceptor.asBinder());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void registerVirtualCamera(VirtualCameraConfig cameraConfig) throws RemoteException {
        checkCallerIsDeviceOwner();
        cameraConfig.getClass();
        if (this.mVirtualCameraController == null) goto L7;
        this.mVirtualCameraController.registerCamera(cameraConfig, this.mAttributionSource);
        return;
    L7:
        throw new UnsupportedOperationException("Virtual camera controller is not available");
    }

    public void unregisterVirtualCamera(VirtualCameraConfig cameraConfig) throws RemoteException {
        checkCallerIsDeviceOwner();
        cameraConfig.getClass();
        if (this.mVirtualCameraController == null) goto L7;
        this.mVirtualCameraController.unregisterCamera(cameraConfig);
        return;
    L7:
        throw new UnsupportedOperationException("Virtual camera controller is not available");
    }

    public String getVirtualCameraId(VirtualCameraConfig cameraConfig) throws RemoteException {
        cameraConfig.getClass();
        if (this.mVirtualCameraController == null) goto L7;
        return this.mVirtualCameraController.getCameraId(cameraConfig);
    L7:
        throw new UnsupportedOperationException("Virtual camera controller is not available");
    }

    public boolean hasCustomAudioInputSupport() throws RemoteException {
        return hasCustomAudioInputSupportInternal();
    }

    public boolean canCreateMirrorDisplays() {
        return DEVICE_PROFILES_ALLOWING_MIRROR_DISPLAYS.contains(getDeviceProfile());
    }

    private boolean hasCustomAudioInputSupportInternal() {
        if (getDevicePolicy(1) != 1) goto L5;
        return true;
    L5:
        long token = Binder.clearCallingIdentity();
        AudioManager audioManager = (AudioManager) this.mContext.getSystemService(AudioManager.class);     // Catch: Throwable -> L15
        Iterator r4 = audioManager.getRegisteredPolicyMixes().iterator();     // Catch: Throwable -> L15
    L8:
        if (r4.hasNext() == false) goto L18;
        AudioMix mix = (AudioMix) r4.next();     // Catch: Throwable -> L15
        if (mix.matchesVirtualDeviceId(getDeviceId()) == false) goto L8;
        if (mix.getMixType() != 1) goto L8;
        Binder.restoreCallingIdentity(token);
        return true;
    L18:
        Binder.restoreCallingIdentity(token);
        return false;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        fout.println("  VirtualDevice: ");
        fout.println("    mDeviceId: " + this.mDeviceId);
        fout.println("    mAssociationId: " + getAssociationId());
        fout.println("    mOwnerPackageName: " + this.mOwnerPackageName);
        StringBuilder r1 = new StringBuilder();
        r1.append("    ");
        r1.append("mParams: ");
        fout.println(r1.toString());
        this.mParams.dump(fout, "        ");
        fout.println("    mVirtualDisplayIds: ");
        Object r2 = this.mVirtualDeviceLock;
        monitor-enter(r2);
        int i = 0;
    L19:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mVirtualDisplays.size()) goto L10;
        fout.println("      " + this.mVirtualDisplays.keyAt(i));     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L19
    L10:
        fout.println("    mDevicePolicies: " + this.mDevicePolicies);     // Catch: Throwable -> L8
        fout.println("    mDefaultShowPointerIcon: " + this.mDefaultShowPointerIcon);     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        this.mInputController.dump(fout);
        this.mSensorController.dump(fout);
        if (this.mVirtualCameraController == null) goto L15;
        this.mVirtualCameraController.dump(fout, "    ");
    L15:
        fout.println("    hasCustomAudioInputSupport: " + hasCustomAudioInputSupportInternal());
    }

    private int getTargetDisplayIdForInput(int displayId) {
        DisplayManagerInternal displayManager = (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
        int mirroredDisplayId = displayManager.getDisplayIdToMirror(displayId);
        if (mirroredDisplayId != (-1)) goto L6;
        return displayId;
    L6:
        return mirroredDisplayId;
    }

    private GenericWindowPolicyController createWindowPolicyController(Set<String> displayCategories) {
        if (getDevicePolicy(3) != 0) goto L5;
        boolean r0 = true;
    L6:
        boolean activityLaunchAllowedByDefault = r0;
        if (this.mParams.getDefaultNavigationPolicy() != 0) goto L9;
        boolean crossTaskNavigationAllowedByDefault = true;
    L11:
        if (getDevicePolicy(2) != 0) goto L13;
        boolean showTasksInHostDeviceRecents = true;
    L14:
        Object r2 = this.mVirtualDeviceLock;
        monitor-enter(r2);
    L19:
        th = move-exception;
        throw th;
    L17:
        if (this.mActivityListenerAdapter != null) goto L21;
        this.mActivityListenerAdapter = new GwpcActivityListener(this, null);     // Catch: Throwable -> L19
    L21:
        AttributionSource r7 = this.mAttributionSource;     // Catch: Throwable -> L19
        ArraySet<UserHandle> r8 = getAllowedUserHandles();     // Catch: Throwable -> L19
        Set<ComponentName> r10 = this.mActivityPolicyExemptions;     // Catch: Throwable -> L19
        Set<String> r11 = this.mActivityPolicyPackageExemptions;     // Catch: Throwable -> L19
        if (crossTaskNavigationAllowedByDefault == false) goto L24;
        Set r13 = this.mParams.getBlockedCrossTaskNavigations();     // Catch: Throwable -> L19
    L25:
        GenericWindowPolicyController r4 = new GenericWindowPolicyController(8192, 524288, r7, r8, activityLaunchAllowedByDefault, r10, r11, crossTaskNavigationAllowedByDefault, r13, this.mActivityListenerAdapter, displayCategories, showTasksInHostDeviceRecents, this.mParams.getHomeComponent());     // Catch: Throwable -> L19
        monitor-exit(r2);     // Catch: Throwable -> L19
        return r4;
    L24:
        r13 = this.mParams.getAllowedCrossTaskNavigations();     // Catch: Throwable -> L19
        goto L25
    L13:
        showTasksInHostDeviceRecents = false;
        goto L14
    L9:
        crossTaskNavigationAllowedByDefault = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public int createVirtualDisplay(VirtualDisplayConfig virtualDisplayConfig, IVirtualDisplayCallback callback) {
        checkCallerIsDeviceOwner();
        if ((virtualDisplayConfig.getFlags() & 1024) != 1024) goto L5;
        boolean r0 = true;
    L6:
        boolean isTrustedDisplay = r0;
        if (isTrustedDisplay == false) goto L9;
    L13:
        final GenericWindowPolicyController gwpc = createWindowPolicyController(virtualDisplayConfig.getDisplayCategories());
        final int displayId = this.mDisplayManagerInternal.createVirtualDisplay(virtualDisplayConfig, callback, this, gwpc, this.mOwnerPackageName);
        if (displayId != (-1)) goto L16;
        return displayId;
    L16:
        Object r2 = this.mVirtualDeviceLock;
        monitor-enter(r2);
    L29:
        th = move-exception;
        Throwable r10 = th;
    L31:
        monitor-exit(r2);     // Catch: Throwable -> L29
        throw r10;
    L24:
        th = move-exception;
        r10 = th;
        goto L31
    L19:
        if (this.mVirtualDisplays.contains(displayId) == false) goto L28;
        final VirtualDisplayWrapper displayWrapper = this.mVirtualDisplays.get(displayId);     // Catch: Throwable -> L24
        final boolean showPointer = this.mDefaultShowPointerIcon;     // Catch: Throwable -> L24
        monitor-exit(r2);     // Catch: Throwable -> L24
        displayWrapper.acquireWakeLock();
        gwpc.registerRunningAppsChangedListener(this);
        Binder.withCleanCallingIdentity(new VirtualDeviceImpl$$ExternalSyntheticLambda1(this, displayId, displayWrapper, showPointer, gwpc));
        Counter.logIncrementWithUid("virtual_devices.value_virtual_display_created_count", this.mAttributionSource.getUid());
        return displayId;
    L28:
        throw new IllegalStateException("Virtual device was not notified about the creation of display with ID " + displayId);     // Catch: Throwable -> L29
    L9:
        if (getDevicePolicy(4) == 0) goto L13;
        throw new SecurityException("All displays must be trusted for devices with custom clipboard policy.");
    L5:
        r0 = false;
        goto L6
    }

    private /* synthetic */ void lambda$createVirtualDisplay$1(int displayId, VirtualDisplayWrapper displayWrapper, boolean showPointer, GenericWindowPolicyController gwpc) throws Exception {
        this.mInputController.setMouseScalingEnabled(false, displayId);
        this.mInputController.setDisplayEligibilityForPointerCapture(false, displayId);
        if (displayWrapper.isTrusted() == false) goto L5;
        this.mInputController.setShowPointerIcon(showPointer, displayId);
        this.mInputController.setDisplayImePolicy(displayId, 0);
        return;
    L5:
        gwpc.setShowInHostDeviceRecents(true);
    }

    private PowerManager.WakeLock createWakeLockForDisplay(int displayId) {
        return null;
    }

    private boolean shouldShowBlockedActivityDialog(ComponentName blockedComponent, ComponentName blockedAppStreamingActivityComponent) {
        if (Objects.equals(blockedComponent, blockedAppStreamingActivityComponent) == false) goto L6;
        return false;
    L6:
        if (getDevicePolicy(6) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    private ArraySet<UserHandle> getAllowedUserHandles() {
        ArraySet<UserHandle> result = new ArraySet();
        long token = Binder.clearCallingIdentity();
        DevicePolicyManager dpm = (DevicePolicyManager) this.mContext.getSystemService(DevicePolicyManager.class);     // Catch: Throwable -> L15
        UserManager userManager = (UserManager) this.mContext.getSystemService(UserManager.class);     // Catch: Throwable -> L15
        Iterator r5 = userManager.getAllProfiles().iterator();     // Catch: Throwable -> L15
    L4:
        if (r5.hasNext() == false) goto L19;
        UserHandle profile = (UserHandle) r5.next();     // Catch: Throwable -> L15
        int nearbyAppStreamingPolicy = dpm.getNearbyAppStreamingPolicy(profile.getIdentifier());     // Catch: Throwable -> L15
        if (nearbyAppStreamingPolicy == 2) goto L17;
        if (nearbyAppStreamingPolicy == 0) goto L17;
        if (nearbyAppStreamingPolicy != 3) goto L4;
        if (this.mParams.getUsersWithMatchingAccounts().contains(profile) == false) goto L4;
        result.add(profile);     // Catch: Throwable -> L15
    L17:
        result.add(profile);     // Catch: Throwable -> L15
        goto L4
    L19:
        Binder.restoreCallingIdentity(token);
        return result;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void onVirtualDisplayCreated(int displayId, IVirtualDisplayCallback callback, DisplayWindowPolicyController dwpc) {
        if (this.mDisplayManagerInternal.getDisplayIdToMirror(displayId) == (-1)) goto L5;
        boolean r0 = true;
    L6:
        boolean isMirrorDisplay = r0;
        if ((this.mDisplayManagerInternal.getDisplayInfo(displayId).flags & 128) != 128) goto L9;
        boolean isTrustedDisplay = true;
    L10:
        GenericWindowPolicyController gwpc = (GenericWindowPolicyController) dwpc;
        gwpc.setDisplayId(displayId, isMirrorDisplay);
        if (isTrustedDisplay == false) goto L14;
        PowerManager.WakeLock r1 = createWakeLockForDisplay(displayId);
    L13:
        PowerManager.WakeLock wakeLock = r1;
        Object r2 = this.mVirtualDeviceLock;
        monitor-enter(r2);
    L29:
        th = th;
    L33:
        monitor-exit(r2);     // Catch: Throwable -> L29
        throw th;
    L31:
        th = th;
        goto L33
    L18:
        if (this.mVirtualDisplays.contains(displayId) == true) goto L36;
        this.mVirtualDisplays.put(displayId, new VirtualDisplayWrapper(callback, gwpc, wakeLock, isTrustedDisplay, isMirrorDisplay));     // Catch: Throwable -> L29
        monitor-exit(r2);     // Catch: Throwable -> L29
        return;
    L36:
        Slog.wtf(TAG, "Virtual device already has a virtual display with ID " + displayId);     // Catch: Throwable -> L22
        monitor-exit(r2);     // Catch: Throwable -> L22
        return;
    L22:
        th = th;
        goto L33
    L14:
        r1 = null;
        goto L13
    L9:
        isTrustedDisplay = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    void onVirtualDisplayRemoved(int displayId) {
        Object r0 = this.mVirtualDeviceLock;
        monitor-enter(r0);
        VirtualDisplayWrapper virtualDisplayWrapper = (VirtualDisplayWrapper) this.mVirtualDisplays.removeReturnOld(displayId);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        if (virtualDisplayWrapper != null) goto L9;
        Slog.w(TAG, "Virtual device " + this.mDeviceId + " doesn't have a virtual display with ID " + displayId);
        return;
    L9:
        long ident = Binder.clearCallingIdentity();
        releaseOwnedVirtualDisplayResources(virtualDisplayWrapper);     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(ident);
        return;
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L16:
        th = move-exception;
        throw th;
    }

    private void checkVirtualInputDeviceDisplayIdAssociation(int displayId) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INJECT_EVENTS") == 0) goto L19;
        Object r0 = this.mVirtualDeviceLock;
        monitor-enter(r0);
        checkDisplayOwnedByVirtualDeviceLocked(displayId);     // Catch: Throwable -> L13
        VirtualDisplayWrapper wrapper = this.mVirtualDisplays.get(displayId);     // Catch: Throwable -> L13
        if (wrapper.isTrusted() == true) goto L15;
        if (wrapper.isMirror() == true) goto L15;
        throw new SecurityException("Cannot create input device associated with an untrusted display");     // Catch: Throwable -> L13
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private void checkDisplayOwnedByVirtualDeviceLocked(int displayId) {
        if (this.mVirtualDisplays.contains(displayId) == false) goto L6;
        return;
    L6:
        throw new SecurityException("Invalid displayId: Display " + displayId + " is not associated with this virtual device");
    }

    private void checkCallerIsDeviceOwner() {
        if (Binder.getCallingUid() != this.mOwnerUid) goto L6;
        return;
    L6:
        throw new SecurityException("Caller is not the owner of this virtual device");
    }

    void goToSleepInternal(int reason) {
        long now = SystemClock.uptimeMillis();
        IntArray displayIds = new IntArray();
        Object r1 = this.mVirtualDeviceLock;
        monitor-enter(r1);
        int i = 0;
    L33:
    L25:
        th = th;
    L35:
        monitor-exit(r1);     // Catch: Throwable -> L29
        throw th;
    L29:
        th = th;
        goto L35
    L6:
        if (i >= this.mVirtualDisplays.size()) goto L18;
        VirtualDisplayWrapper wrapper = this.mVirtualDisplays.valueAt(i);     // Catch: Throwable -> L14
        if (wrapper.isTrusted() == false) goto L16;
        if (wrapper.isMirror() == true) goto L16;
        int displayId = this.mVirtualDisplays.keyAt(i);     // Catch: Throwable -> L14
        displayIds.add(displayId);     // Catch: Throwable -> L14
    L16:
        i = i + 1;
    L14:
        th = th;
        goto L35
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L25
        int i2 = 0;
    L21:
        if (i2 >= displayIds.size()) goto L24;
        this.mPowerManager.goToSleep(displayIds.get(i2), now, reason, 0);
        i2 = i2 + 1;
        goto L21
    }

    void wakeUpInternal(int reason, String details) {
        long now = SystemClock.uptimeMillis();
        IntArray displayIds = new IntArray();
        Object r3 = this.mVirtualDeviceLock;
        monitor-enter(r3);
        int i = 0;
    L33:
    L25:
        th = th;
    L35:
        monitor-exit(r3);     // Catch: Throwable -> L29
        throw th;
    L29:
        th = th;
        goto L35
    L6:
        if (i >= this.mVirtualDisplays.size()) goto L18;
        VirtualDisplayWrapper wrapper = this.mVirtualDisplays.valueAt(i);     // Catch: Throwable -> L14
        if (wrapper.isTrusted() == false) goto L16;
        if (wrapper.isMirror() == true) goto L16;
        int displayId = this.mVirtualDisplays.keyAt(i);     // Catch: Throwable -> L14
        displayIds.add(displayId);     // Catch: Throwable -> L14
    L16:
        i = i + 1;
    L14:
        th = th;
        goto L35
    L18:
        monitor-exit(r3);     // Catch: Throwable -> L25
        int i2 = 0;
    L21:
        if (i2 >= displayIds.size()) goto L24;
        this.mPowerManager.wakeUp(now, reason, details, displayIds.get(i2));
        i2 = i2 + 1;
        goto L21
    }

    private void releaseOwnedVirtualDisplayResources(VirtualDisplayWrapper virtualDisplayWrapper) {
        virtualDisplayWrapper.releaseWakeLock();
        virtualDisplayWrapper.getWindowPolicyController().unregisterRunningAppsChangedListener(this);
    }

    int getOwnerUid() {
        return this.mOwnerUid;
    }

    long getDimDurationMillis() {
        return this.mParams.getDimDuration().toMillis();
    }

    long getScreenOffTimeoutMillis() {
        return this.mParams.getScreenOffTimeout().toMillis();
    }

    public int[] getDisplayIds() {
        Object r0 = this.mVirtualDeviceLock;
        monitor-enter(r0);
        int size = this.mVirtualDisplays.size();     // Catch: Throwable -> L7
        int[] displayIds = new int[size];     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= size) goto L10;
        displayIds[i] = this.mVirtualDisplays.keyAt(i);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return displayIds;
    L7:
        th = move-exception;
        throw th;
    }

    GenericWindowPolicyController getDisplayWindowPolicyControllerForTest(int displayId) {
        Object r0 = this.mVirtualDeviceLock;
        monitor-enter(r0);
        VirtualDisplayWrapper virtualDisplayWrapper = this.mVirtualDisplays.get(displayId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (virtualDisplayWrapper != null) goto L15;
        return null;
    L15:
        return virtualDisplayWrapper.getWindowPolicyController();
    L10:
        th = move-exception;
        throw th;
    }

    boolean isAppRunningOnVirtualDevice(int uid) {
        Object r0 = this.mVirtualDeviceLock;
        monitor-enter(r0);
        int i = 0;
    L21:
    L12:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mVirtualDisplays.size()) goto L16;
        if (this.mVirtualDisplays.valueAt(i).getWindowPolicyController().containsUid(uid) == true) goto L9;
        i = i + 1;     // Catch: Throwable -> L12
        goto L21
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    }

    void showToastWhereUidIsRunning(int uid, int resId, int duration, Looper looper) {
        showToastWhereUidIsRunning(uid, this.mContext.getString(resId), duration, looper);
    }

    void showToastWhereUidIsRunning(int uid, String text, int duration, Looper looper) {
        IntArray displayIdsForUid = getDisplayIdsWhereUidIsRunning(uid);
        if (displayIdsForUid.size() != 0) goto L5;
        return;
    L5:
        DisplayManager displayManager = (DisplayManager) this.mContext.getSystemService(DisplayManager.class);
        int i = 0;
    L7:
        if (i >= displayIdsForUid.size()) goto L15;
        Display display = displayManager.getDisplay(displayIdsForUid.get(i));
        if (display == null) goto L13;
        if (display.isValid() == false) goto L13;
        Toast.makeText(this.mContext.createDisplayContext(display), looper, text, duration).show();
    L13:
        i = i + 1;
        goto L7
    }

    private IntArray getDisplayIdsWhereUidIsRunning(int uid) {
        IntArray displayIdsForUid = new IntArray();
        Object r1 = this.mVirtualDeviceLock;
        monitor-enter(r1);
        int i = 0;
    L18:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mVirtualDisplays.size()) goto L14;
        if (this.mVirtualDisplays.valueAt(i).getWindowPolicyController().containsUid(uid) == false) goto L12;
        displayIdsForUid.add(this.mVirtualDisplays.keyAt(i));     // Catch: Throwable -> L10
    L12:
        i = i + 1;     // Catch: Throwable -> L10
        goto L18
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return displayIdsForUid;
    }

    boolean isDisplayOwnedByVirtualDevice(int displayId) {
        Object r0 = this.mVirtualDeviceLock;
        monitor-enter(r0);
        boolean r1 = this.mVirtualDisplays.contains(displayId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isInputDeviceOwnedByVirtualDevice(final int inputDeviceId) {
        return this.mInputController.getInputDeviceDescriptors().values().stream().anyMatch(new VirtualDeviceImpl$$ExternalSyntheticLambda2(inputDeviceId));
    }

    private static /* synthetic */ boolean lambda$isInputDeviceOwnedByVirtualDevice$2(int inputDeviceId, InputController.InputDeviceDescriptor inputDeviceDescriptor) {
        if (inputDeviceDescriptor.getInputDeviceId() != inputDeviceId) goto L5;
        return true;
    L5:
        return false;
    }

    void playSoundEffect(int effectType) {
        this.mSoundEffectListener.onPlaySoundEffect(effectType);     // Catch: RemoteException -> L4
        return;
    L4:
        exception = move-exception;
        Slog.w(TAG, "Unable to invoke sound effect listener", exception);
    }

    private static boolean isVirtualCameraEnabled() {
        return nativeVirtualCameraServiceBuildFlagEnabled();
    }
}
