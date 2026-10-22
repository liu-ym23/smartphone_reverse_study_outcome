package com.android.server.input;

import android.R;
import android.app.ActivityManagerInternal;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.IntentFilter;
import android.content.PermissionChecker;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Region;
import android.hardware.SensorPrivacyManagerInternal;
import android.hardware.display.DisplayManagerInternal;
import android.hardware.display.DisplayTopologyGraph;
import android.hardware.display.DisplayViewport;
import android.hardware.input.AidlInputGestureData;
import android.hardware.input.HostUsiVersion;
import android.hardware.input.IInputDeviceBatteryListener;
import android.hardware.input.IInputDeviceBatteryState;
import android.hardware.input.IInputDevicesChangedListener;
import android.hardware.input.IInputManager;
import android.hardware.input.IInputSensorEventListener;
import android.hardware.input.IKeyEventActivityListener;
import android.hardware.input.IKeyGestureEventListener;
import android.hardware.input.IKeyGestureHandler;
import android.hardware.input.IKeyboardBacklightListener;
import android.hardware.input.IStickyModifierStateListener;
import android.hardware.input.ITabletModeChangedListener;
import android.hardware.input.InputDeviceIdentifier;
import android.hardware.input.InputGestureData;
import android.hardware.input.InputManager;
import android.hardware.input.InputSensorInfo;
import android.hardware.input.InputSettings;
import android.hardware.input.KeyGestureEvent;
import android.hardware.input.KeyGlyphMap;
import android.hardware.input.KeyboardLayout;
import android.hardware.input.KeyboardLayoutSelectionResult;
import android.hardware.input.TouchCalibration;
import android.hardware.lights.Light;
import android.hardware.lights.LightState;
import android.media.AudioManager;
import android.os.Binder;
import android.os.CombinedVibration;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.IVibratorStateListener;
import android.os.Looper;
import android.os.Message;
import android.os.PermissionEnforcer;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.VibrationEffect;
import android.os.vibrator.StepSegment;
import android.os.vibrator.VibrationEffectSegment;
import android.provider.DeviceConfig;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.IInputFilter;
import android.view.IInputFilterHost;
import android.view.IInputMonitorHost;
import android.view.InputApplicationHandle;
import android.view.InputChannel;
import android.view.InputDevice;
import android.view.InputEvent;
import android.view.InputMonitor;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.SurfaceControl;
import android.view.VerifiedInputEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import com.android.internal.inputmethod.InputMethodSubtypeHandle;
import com.android.internal.os.SomeArgs;
import com.android.internal.policy.IShortcutService;
import com.android.internal.policy.KeyInterceptionInfo;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.Preconditions;
import com.android.internal.view.IObricInputManager;
import com.android.server.DisplayThread;
import com.android.server.IoThread;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.SystemService;
import com.android.server.Watchdog;
import com.android.server.am.SysMonitorSvcBridge;
import com.android.server.audio.AudioService$$ExternalSyntheticLambda2;
import com.android.server.input.debug.FocusEventDebugView;
import com.android.server.input.debug.TouchpadDebugViewController;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.android.server.utils.VintfHalManager;
import com.android.server.wm.WindowManagerInternal;
import com.obric.utils.ObricImplFactory;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Consumer;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParserException;
import vendor.bd.hardware.touchhal.ITouchHal;

/* JADX INFO: loaded from: classes2.dex */
public class InputManagerService extends IInputManager.Stub implements Watchdog.Monitor {
    public static final int BTN_MOUSE = 272;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_VIBRATION_MAGNITUDE = 192;
    private static final String EXCLUDED_DEVICES_PATH = "etc/excluded-input-devices.xml";
    private static final int INJECTION_TIMEOUT_MILLIS = 30000;
    public static final int INPUT_OVERLAY_LAYER_GESTURE_MONITOR = 1;
    public static final int INPUT_OVERLAY_LAYER_HANDWRITING_SURFACE = 2;
    private static final long KEY_EVENT_ACTIVITY_RATE_LIMIT_INTERVAL_MS = 1000;
    public static final int KEY_STATE_DOWN = 1;
    public static final int KEY_STATE_UNKNOWN = -1;
    public static final int KEY_STATE_UP = 0;
    public static final int KEY_STATE_VIRTUAL = 2;
    private static final int MSG_CURRENT_USER_CHANGED = 4;
    private static final int MSG_DELIVER_INPUT_DEVICES_CHANGED = 1;
    private static final int MSG_DELIVER_TABLET_MODE_CHANGED = 3;
    private static final int MSG_RELOAD_DEVICE_ALIASES = 2;
    private static final int MSG_SYSTEM_READY = 5;
    private static final String PORT_ASSOCIATIONS_PATH = "etc/input-port-associations.xml";
    public static final int SW_CAMERA_LENS_COVER = 9;
    public static final int SW_CAMERA_LENS_COVER_BIT = 512;
    public static final int SW_HEADPHONE_INSERT = 2;
    public static final int SW_HEADPHONE_INSERT_BIT = 4;
    public static final int SW_JACK_BITS = 212;
    public static final int SW_JACK_PHYSICAL_INSERT = 7;
    public static final int SW_JACK_PHYSICAL_INSERT_BIT = 128;
    public static final int SW_KEYPAD_SLIDE = 10;
    public static final int SW_KEYPAD_SLIDE_BIT = 1024;
    public static final int SW_LID = 0;
    public static final int SW_LID_BIT = 1;
    public static final int SW_LINEOUT_INSERT = 6;
    public static final int SW_LINEOUT_INSERT_BIT = 64;
    public static final int SW_MICROPHONE_INSERT = 4;
    public static final int SW_MICROPHONE_INSERT_BIT = 16;
    public static final int SW_MUTE_DEVICE = 14;
    public static final int SW_MUTE_DEVICE_BIT = 16384;
    public static final int SW_TABLET_MODE = 1;
    public static final int SW_TABLET_MODE_BIT = 2;
    static final String TAG = "InputManager";
    private static final String VELOCITYTRACKER_STRATEGY_PROPERTY = "velocitytracker_strategy";
    private InputManagerInternal.AccessibilityPointerMotionFilter mAccessibilityPointerMotionFilter;
    private final Object mAccessibilityPointerMotionFilterLock;
    private final SparseArray<AdditionalDisplayInputProperties> mAdditionalDisplayInputProperties;
    private final Object mAdditionalDisplayInputPropertiesLock;
    private final Object mAssociationsLock;
    private final BatteryController mBatteryController;
    final Context mContext;
    private final PersistentDataStore mDataStore;
    private final Map<String, String> mDeviceTypeAssociations;
    private DisplayManagerInternal mDisplayManagerInternal;
    private final File mDoubleTouchGestureEnableFile;
    private final SparseArray<KeyCharacterMap.FallbackAction> mFallbackActions;
    private FocusEventDebugView mFocusEventDebugView;
    private final Object mFocusEventDebugViewLock;
    private final InputManagerHandler mHandler;
    private final InputDataStore mInputDataStore;
    private InputDevice[] mInputDevices;
    private final SparseArray<InputDevicesChangedListenerRecord> mInputDevicesChangedListeners;
    private boolean mInputDevicesChangedPending;
    private final Object mInputDevicesLock;
    IInputFilter mInputFilter;
    InputFilterHost mInputFilterHost;
    final Object mInputFilterLock;
    final Map<IBinder, GestureMonitorSpyWindow> mInputMonitors;
    private final SparseBooleanArray mIsVibrating;
    private final List<IKeyEventActivityListener> mKeyEventActivityListenersToNotify;
    final Object mKeyEventActivityLock;
    private final KeyGestureController mKeyGestureController;
    private final KeyRemapper mKeyRemapper;
    private final KeyboardBacklightControllerInterface mKeyboardBacklightController;
    private final KeyboardGlyphManager mKeyboardGlyphManager;
    private final Map<String, String> mKeyboardLayoutAssociations;
    private final KeyboardLayoutManager mKeyboardLayoutManager;
    private final KeyboardLedController mKeyboardLedController;
    private long mLastKeyEventActivityTimeMs;
    private final List<InputManagerInternal.LidSwitchCallback> mLidSwitchCallbacks;
    private final Object mLidSwitchLock;
    private final Object mLightLock;
    private final ArrayMap<IBinder, LightSession> mLightSessions;
    private final NativeInputManagerService mNative;
    private int mNextVibratorTokenValue;
    private IObricInputManagerService mObricExt;
    private final PointerIconCache mPointerIconCache;
    private final Map<String, Integer> mRuntimeAssociations;
    private final List<SensorEventListenerRecord> mSensorAccuracyListenersToNotify;
    private final SparseArray<SensorEventListenerRecord> mSensorEventListeners;
    private final List<SensorEventListenerRecord> mSensorEventListenersToNotify;
    private final Object mSensorEventLock;
    private final InputSettingsObserver mSettingsObserver;
    private boolean mShowKeyPresses;
    private boolean mShowRotaryInput;
    private final Map<String, Integer> mStaticAssociations;
    private final StickyModifierStateController mStickyModifierStateController;
    private final SysfsNodeMonitor mSysfsNodeMonitor;
    private boolean mSystemReady;
    private final SparseArray<TabletModeChangedListenerRecord> mTabletModeChangedListeners;
    private final Object mTabletModeLock;
    private final ArrayList<InputDevicesChangedListenerRecord> mTempInputDevicesChangedListenersToNotify;
    private final List<TabletModeChangedListenerRecord> mTempTabletModeChangedListenersToNotify;
    private final TouchpadDebugViewController mTouchpadDebugViewController;
    private final Map<String, String> mUniqueIdAssociationsByDescriptor;
    private final Map<String, String> mUniqueIdAssociationsByPort;
    final boolean mUseDevInputEventForAudioJack;
    private final String mVelocityTrackerStrategy;
    private final Object mVibratorLock;
    private final SparseArray<RemoteCallbackList<IVibratorStateListener>> mVibratorStateListeners;
    private final Map<IBinder, VibratorToken> mVibratorTokens;
    private WindowManagerCallbacks mWindowManagerCallbacks;
    private WindowManagerInternal mWindowManagerInternal;
    private WiredAccessoryCallbacks mWiredAccessoryCallbacks;

    private static class AdditionalDisplayInputProperties {
        static final boolean DEFAULT_MOUSE_SCALING_ENABLED = true;
        static final boolean DEFAULT_POINTER_ICON_VISIBLE = true;
        public boolean mouseScalingEnabled;
        public boolean pointerIconVisible;

        AdditionalDisplayInputProperties() {
            reset();
        }

        public boolean allDefaults() {
            if (this.mouseScalingEnabled == true) goto L5;
        L7:
            return false;
        L5:
            if (this.pointerIconVisible != true) goto L7;
            return true;
        }

        public void reset() {
            this.mouseScalingEnabled = true;
            this.pointerIconVisible = true;
        }
    }

    static class Injector {
        private final Context mContext;
        private final Looper mIoLooper;
        private final Looper mLooper;
        private final UEventManager mUEventManager;

        Injector(Context context, Looper looper, Looper ioLooper, UEventManager uEventManager) {
            this.mContext = context;
            this.mLooper = looper;
            this.mIoLooper = ioLooper;
            this.mUEventManager = uEventManager;
        }

        Context getContext() {
            return this.mContext;
        }

        Looper getLooper() {
            return this.mLooper;
        }

        Looper getIoLooper() {
            return this.mIoLooper;
        }

        UEventManager getUEventManager() {
            return this.mUEventManager;
        }

        NativeInputManagerService getNativeService(InputManagerService service) {
            return new NativeInputManagerService.NativeImpl(service, this.mLooper.getQueue());
        }

        void registerLocalService(InputManagerInternal localService) {
            LocalServices.addService(InputManagerInternal.class, localService);
        }

        KeyboardBacklightControllerInterface getKeyboardBacklightController(NativeInputManagerService nativeService) {
            return new KeyboardBacklightController(this.mContext, nativeService, this.mLooper);
        }
    }

    private final class InputDevicesChangedListenerRecord implements IBinder.DeathRecipient {
        private final IInputDevicesChangedListener mListener;
        private final int mPid;
        final /* synthetic */ InputManagerService this$0;

        public InputDevicesChangedListenerRecord(InputManagerService r1, int pid, IInputDevicesChangedListener listener) {
            this.this$0 = r1;
            this.mPid = pid;
            this.mListener = listener;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (InputManagerService.m4529$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.d(InputManagerService.TAG, "Input devices changed listener for pid " + this.mPid + " died.");
        L5:
            InputManagerService.m4517$$Nest$monInputDevicesChangedListenerDied(this.this$0, this.mPid);
        }

        public void notifyInputDevicesChanged(int[] info) {
            this.mListener.onInputDevicesChanged(info);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.w(InputManagerService.TAG, "Failed to notify process " + this.mPid + " that input devices changed, assuming it died.", ex);
            binderDied();
        }
    }

    private final class InputFilterHost extends IInputFilterHost.Stub {
        private boolean mDisconnected;
        final /* synthetic */ InputManagerService this$0;

        /* synthetic */ InputFilterHost(InputManagerService r1, InputManagerServiceIA r2) {
            this(r1);
        }

        private InputFilterHost(InputManagerService r1) {
            this.this$0 = r1;
        }

        public void disconnectLocked() {
            this.mDisconnected = true;
        }

        public void sendInputEvent(InputEvent event, int policyFlags) {
            if (InputManagerService.m4512$$Nest$mcheckCallingPermission(this.this$0, "android.permission.INJECT_EVENTS", "sendInputEvent()") == false) goto L21;
            event.getClass();
            Object r1 = this.this$0.mInputFilterLock;
            monitor-enter(r1);
        L11:
            th = move-exception;
            Throwable r10 = th;
        L18:
            monitor-exit(r1);     // Catch: Throwable -> L11
            throw r10;
        L13:
            th = move-exception;
            r10 = th;
            goto L18
        L7:
            if (this.mDisconnected == true) goto L16;
            InputManagerService.m4509$$Nest$fgetmNative(this.this$0).injectInputEvent(event, false, -1, 0, 0, policyFlags | 67108864);     // Catch: Throwable -> L11
        L16:
            monitor-exit(r1);     // Catch: Throwable -> L11
            return;
        L21:
            throw new SecurityException("The INJECT_EVENTS permission is required for injecting input events.");
        }
    }

    private final class InputManagerHandler extends Handler {
        final /* synthetic */ InputManagerService this$0;

        public InputManagerHandler(InputManagerService r2, Looper looper) {
            this.this$0 = r2;
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L9;
                case 2: goto L8;
                case 3: goto L7;
                case 4: goto L6;
                case 5: goto L5;
                default: goto L15;
            };
        L5:
            this.this$0.systemRunning();
            return;
        L6:
            InputManagerService.m4515$$Nest$mhandleCurrentUserChanged(this.this$0, ((Integer) msg.obj).intValue());
            return;
        L7:
            SomeArgs args = (SomeArgs) msg.obj;
            long whenNanos = (((long) args.argi1) & 4294967295L) | (((long) args.argi2) << 32);
            boolean inTabletMode = ((Boolean) args.arg1).booleanValue();
            InputManagerService.m4514$$Nest$mdeliverTabletModeChanged(this.this$0, whenNanos, inTabletMode);
            return;
        L8:
            InputManagerService.m4521$$Nest$mreloadDeviceAliases(this.this$0);
            return;
        L9:
            InputManagerService.m4513$$Nest$mdeliverInputDevicesChanged(this.this$0, (InputDevice[]) msg.obj);
            return;
        }
    }

    private final class InputMonitorHost extends IInputMonitorHost.Stub {
        private final IBinder mInputChannelToken;
        final /* synthetic */ InputManagerService this$0;

        InputMonitorHost(InputManagerService r1, IBinder inputChannelToken) {
            this.this$0 = r1;
            this.mInputChannelToken = inputChannelToken;
        }

        public void pilferPointers() {
            InputManagerService.m4509$$Nest$fgetmNative(this.this$0).pilferPointers(this.mInputChannelToken);
        }

        public void dispose() {
            InputManagerService.m4523$$Nest$mremoveSpyWindowGestureMonitor(this.this$0, this.mInputChannelToken);
        }

        public void setTouchableRegion(Rect crop, Region region) {
            Map<IBinder, GestureMonitorSpyWindow> r0 = this.this$0.mInputMonitors;
            monitor-enter(r0);
            GestureMonitorSpyWindow spyWindow = this.this$0.mInputMonitors.get(this.mInputChannelToken);     // Catch: Throwable -> L7
            if (spyWindow == null) goto L9;
            spyWindow.mWindowHandle.replaceTouchableRegionWithCrop = false;     // Catch: Throwable -> L7
            spyWindow.mWindowHandle.touchableRegion.set(region);     // Catch: Throwable -> L7
            SurfaceControl.Transaction t = new SurfaceControl.Transaction();     // Catch: Throwable -> L7
            t.setInputWindowInfo(spyWindow.mInputSurface, spyWindow.mWindowHandle);     // Catch: Throwable -> L7
            t.setCrop(spyWindow.mInputSurface, crop);     // Catch: Throwable -> L7
            t.apply();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    interface KeyboardBacklightControllerInterface {
        default void incrementKeyboardBacklight(int deviceId) {
        }

        default void decrementKeyboardBacklight(int deviceId) {
        }

        default void registerKeyboardBacklightListener(IKeyboardBacklightListener l, int pid) {
        }

        default void unregisterKeyboardBacklightListener(IKeyboardBacklightListener l, int pid) {
        }

        default void onInteractiveChanged(boolean isInteractive) {
        }

        default void notifyUserActivity() {
        }

        default void systemRunning() {
        }

        default void dump(PrintWriter pw) {
        }
    }

    public static final class Lifecycle extends SystemService {
        private final InputManagerService mService;

        public Lifecycle(Context context) {
            super(context);
            this.mService = new InputManagerService(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            publishBinderService("input", this.mService, false, 1);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            InputManagerService.m4516$$Nest$monBootPhase(this.mService, phase);
        }

        @Override // com.android.server.SystemService
        public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
            InputManagerService.m4520$$Nest$monUserSwitching(this.mService, from, to);
        }

        public InputManagerService getService() {
            return this.mService;
        }
    }

    private final class LightSession implements IBinder.DeathRecipient {
        private final int mDeviceId;
        private int[] mLightIds;
        private LightState[] mLightStates;
        private final String mOpPkg;
        private final IBinder mToken;
        final /* synthetic */ InputManagerService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmDeviceId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4530$$Nest$fgetmDeviceId(LightSession r0) {
            return r0.mDeviceId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLightIds, reason: not valid java name */
        static /* bridge */ /* synthetic */ int[] m4531$$Nest$fgetmLightIds(LightSession r0) {
            return r0.mLightIds;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLightStates, reason: not valid java name */
        static /* bridge */ /* synthetic */ LightState[] m4532$$Nest$fgetmLightStates(LightSession r0) {
            return r0.mLightStates;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOpPkg, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m4533$$Nest$fgetmOpPkg(LightSession r0) {
            return r0.mOpPkg;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmLightIds, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4534$$Nest$fputmLightIds(LightSession r0, int[] r1) {
            r0.mLightIds = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmLightStates, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4535$$Nest$fputmLightStates(LightSession r0, LightState[] r1) {
            r0.mLightStates = r1;
        }

        LightSession(InputManagerService r1, int deviceId, String opPkg, IBinder token) {
            this.this$0 = r1;
            this.mDeviceId = deviceId;
            this.mOpPkg = opPkg;
            this.mToken = token;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (InputManagerService.m4529$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.d(InputManagerService.TAG, "Light token died.");
        L5:
            Object r0 = InputManagerService.m4507$$Nest$fgetmLightLock(this.this$0);
            monitor-enter(r0);
            this.this$0.closeLightSession(this.mDeviceId, this.mToken);     // Catch: Throwable -> L10
            InputManagerService.m4508$$Nest$fgetmLightSessions(this.this$0).remove(this.mToken);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    private final class LocalService extends InputManagerInternal {
        final /* synthetic */ InputManagerService this$0;

        /* synthetic */ LocalService(InputManagerService r1, InputManagerServiceIA r2) {
            this(r1);
        }

        private LocalService(InputManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.input.InputManagerInternal
        public void setDisplayViewports(List<DisplayViewport> viewports) {
            InputManagerService.m4526$$Nest$msetDisplayViewportsInternal(this.this$0, viewports);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void setDisplayTopology(DisplayTopologyGraph topology) {
            InputManagerService.m4525$$Nest$msetDisplayTopologyInternal(this.this$0, topology);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void setDisplayInteractivities(SparseBooleanArray displayInteractivities) {
            boolean globallyInteractive = false;
            ArraySet<Integer> nonInteractiveDisplays = new ArraySet();
            int i = 0;
        L4:
            if (i >= displayInteractivities.size()) goto L10;
            int displayId = displayInteractivities.keyAt(i);
            boolean displayInteractive = displayInteractivities.get(displayId);
            if (displayInteractive == false) goto L8;
            globallyInteractive = true;
        L9:
            i = i + 1;
            goto L4
        L8:
            nonInteractiveDisplays.add(Integer.valueOf(displayId));
            goto L9
        L10:
            InputManagerService.m4509$$Nest$fgetmNative(this.this$0).setNonInteractiveDisplays(nonInteractiveDisplays.stream().mapToInt(new AudioService$$ExternalSyntheticLambda2()).toArray());
            InputManagerService.m4501$$Nest$fgetmBatteryController(this.this$0).onInteractiveChanged(globallyInteractive);
            InputManagerService.m4505$$Nest$fgetmKeyboardBacklightController(this.this$0).onInteractiveChanged(globallyInteractive);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void toggleCapsLock(int deviceId) {
            InputManagerService.m4509$$Nest$fgetmNative(this.this$0).toggleCapsLock(deviceId);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void setPulseGestureEnabled(boolean enabled) {
            if (InputManagerService.m4502$$Nest$fgetmDoubleTouchGestureEnableFile(this.this$0) == null) goto L20;
            FileWriter writer = null;
            writer = new FileWriter(InputManagerService.m4502$$Nest$fgetmDoubleTouchGestureEnableFile(this.this$0));     // Catch: Throwable -> L8 IOException -> L10
            if (enabled == false) goto L12;
            String r1 = "1";
        L13:
            writer.write(r1);     // Catch: Throwable -> L8 IOException -> L10
        L14:
            IoUtils.closeQuietly(writer);
            return;
        L12:
            r1 = "0";
        L8:
            th = move-exception;
            IoUtils.closeQuietly(writer);
            throw th;
        L10:
            e = move-exception;
            Log.wtf(InputManagerService.TAG, "Unable to setPulseGestureEnabled", e);     // Catch: Throwable -> L8
            goto L14
        }

        @Override // com.android.server.input.InputManagerInternal
        public boolean transferTouchGesture(IBinder fromChannelToken, IBinder toChannelToken, boolean transferEntireGesture) {
            return this.this$0.transferTouchGesture(fromChannelToken, toChannelToken, transferEntireGesture);
        }

        @Override // com.android.server.input.InputManagerInternal
        public PointF getCursorPosition(int displayId) {
            float[] p = InputManagerService.m4509$$Nest$fgetmNative(this.this$0).getMouseCursorPosition(displayId);
            if (p == null) goto L9;
            if (p.length != 2) goto L9;
            return new PointF(p[0], p[1]);
        L9:
            throw new IllegalStateException("Failed to get mouse cursor position");
        }

        @Override // com.android.server.input.InputManagerInternal
        public void setMouseScalingEnabled(boolean enabled, int displayId) {
            InputManagerService.m4527$$Nest$msetMouseScalingEnabled(this.this$0, enabled, displayId);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void setDisplayEligibilityForPointerCapture(int displayId, boolean isEligible) {
            InputManagerService.m4524$$Nest$msetDisplayEligibilityForPointerCapture(this.this$0, displayId, isEligible);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void setPointerIconVisible(boolean visible, int displayId) {
            InputManagerService.m4528$$Nest$msetPointerIconVisible(this.this$0, visible, displayId);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void registerLidSwitchCallback(InputManagerInternal.LidSwitchCallback callbacks) {
            this.this$0.registerLidSwitchCallbackInternal(callbacks);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void unregisterLidSwitchCallback(InputManagerInternal.LidSwitchCallback callbacks) {
            this.this$0.unregisterLidSwitchCallbackInternal(callbacks);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void notifyInputMethodConnectionActive(boolean connectionIsActive) {
            InputManagerService.m4509$$Nest$fgetmNative(this.this$0).setInputMethodConnectionIsActive(connectionIsActive);
        }

        @Override // com.android.server.input.InputManagerInternal
        public InputChannel createInputChannel(String inputChannelName) {
            return this.this$0.createInputChannel(inputChannelName);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void pilferPointers(IBinder token) {
            InputManagerService.m4509$$Nest$fgetmNative(this.this$0).pilferPointers(token);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void onInputMethodSubtypeChangedForKeyboardLayoutMapping(int userId, InputMethodSubtypeHandle subtypeHandle, InputMethodSubtype subtype) {
            InputManagerService.m4506$$Nest$fgetmKeyboardLayoutManager(this.this$0).onInputMethodSubtypeChanged(userId, subtypeHandle, subtype);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void notifyUserActivity() {
            InputManagerService.m4505$$Nest$fgetmKeyboardBacklightController(this.this$0).notifyUserActivity();
        }

        @Override // com.android.server.input.InputManagerInternal
        public void incrementKeyboardBacklight(int deviceId) {
            InputManagerService.m4505$$Nest$fgetmKeyboardBacklightController(this.this$0).incrementKeyboardBacklight(deviceId);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void decrementKeyboardBacklight(int deviceId) {
            InputManagerService.m4505$$Nest$fgetmKeyboardBacklightController(this.this$0).decrementKeyboardBacklight(deviceId);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void setTypeAssociation(String inputPort, String type) {
            this.this$0.setTypeAssociationInternal(inputPort, type);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void unsetTypeAssociation(String inputPort) {
            this.this$0.unsetTypeAssociationInternal(inputPort);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void addKeyboardLayoutAssociation(String inputPort, String languageTag, String layoutType) {
            InputManagerService.m4511$$Nest$maddKeyboardLayoutAssociation(this.this$0, inputPort, languageTag, layoutType);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void removeKeyboardLayoutAssociation(String inputPort) {
            InputManagerService.m4522$$Nest$mremoveKeyboardLayoutAssociation(this.this$0, inputPort);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void setStylusButtonMotionEventsEnabled(boolean enabled) {
            InputManagerService.m4509$$Nest$fgetmNative(this.this$0).setStylusButtonMotionEventsEnabled(enabled);
        }

        @Override // com.android.server.input.InputManagerInternal
        public int getLastUsedInputDeviceId() {
            return InputManagerService.m4509$$Nest$fgetmNative(this.this$0).getLastUsedInputDeviceId();
        }

        @Override // com.android.server.input.InputManagerInternal
        public void notifyKeyGestureCompleted(int deviceId, int[] keycodes, int modifierState, int gestureType) {
            InputManagerService.m4504$$Nest$fgetmKeyGestureController(this.this$0).notifyKeyGestureCompleted(deviceId, keycodes, modifierState, gestureType);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void handleKeyGestureInKeyGestureController(int deviceId, int[] keycodes, int modifierState, int gestureType) {
            InputManagerService.m4504$$Nest$fgetmKeyGestureController(this.this$0).handleKeyGesture(deviceId, keycodes, modifierState, gestureType);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void setAccessibilityPointerIconScaleFactor(int displayId, float scaleFactor) {
            this.this$0.setAccessibilityPointerIconScaleFactor(displayId, scaleFactor);
        }

        @Override // com.android.server.input.InputManagerInternal
        public void setCurrentUser(int newUserId) {
            InputManagerService.m4503$$Nest$fgetmHandler(this.this$0).obtainMessage(4, Integer.valueOf(newUserId)).sendToTarget();
        }

        @Override // com.android.server.input.InputManagerInternal
        public void registerShortcutKey(long shortcutCode, IShortcutService shortcutKeyReceiver) throws RemoteException {
            InputManagerService.m4504$$Nest$fgetmKeyGestureController(this.this$0).registerShortcutKey(shortcutCode, shortcutKeyReceiver);
        }

        @Override // com.android.server.input.InputManagerInternal
        public boolean setKernelWakeEnabled(int deviceId, boolean enabled) {
            return InputManagerService.m4509$$Nest$fgetmNative(this.this$0).setKernelWakeEnabled(deviceId, enabled);
        }

        @Override // com.android.server.input.InputManagerInternal
        public Map<Integer, byte[]> getBackupPayload(int userId) throws IOException {
            Map<Integer, byte[]> payload = new HashMap();
            payload.put(0, InputManagerService.m4504$$Nest$fgetmKeyGestureController(this.this$0).getInputGestureBackupPayload(userId));
            return payload;
        }

        @Override // com.android.server.input.InputManagerInternal
        public void applyBackupPayload(Map<Integer, byte[]> payload, int userId) throws XmlPullParserException, IOException {
            if (payload.containsKey(0) == false) goto L6;
            InputManagerService.m4504$$Nest$fgetmKeyGestureController(this.this$0).applyInputGesturesBackupPayload(payload.get(0), userId);
            return;
        }

        @Override // com.android.server.input.InputManagerInternal
        public void registerAccessibilityPointerMotionFilter(InputManagerInternal.AccessibilityPointerMotionFilter filter) {
            this.this$0.registerAccessibilityPointerMotionFilter(filter);
        }

        @Override // com.android.server.input.InputManagerInternal
        public IObricInputManagerService getObricExt() {
            return InputManagerService.m4510$$Nest$fgetmObricExt(this.this$0);
        }
    }

    private final class SensorEventListenerRecord implements IBinder.DeathRecipient {
        private final IInputSensorEventListener mListener;
        private final int mPid;
        final /* synthetic */ InputManagerService this$0;

        SensorEventListenerRecord(InputManagerService r1, int pid, IInputSensorEventListener listener) {
            this.this$0 = r1;
            this.mPid = pid;
            this.mListener = listener;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (InputManagerService.m4529$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.d(InputManagerService.TAG, "Sensor event listener for pid " + this.mPid + " died.");
        L5:
            InputManagerService.m4518$$Nest$monSensorEventListenerDied(this.this$0, this.mPid);
        }

        public IInputSensorEventListener getListener() {
            return this.mListener;
        }

        public void notifySensorEvent(int deviceId, int sensorType, int accuracy, long timestamp, float[] values) {
            this.mListener.onInputSensorChanged(deviceId, sensorType, accuracy, timestamp, values);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            RemoteException ex = e;
        L10:
            Slog.w(InputManagerService.TAG, "Failed to notify process " + this.mPid + " that sensor event notified, assuming it died.", ex);
            binderDied();
            return;
        L8:
            e = move-exception;
            ex = e;
            goto L10
        }

        public void notifySensorAccuracy(int deviceId, int sensorType, int accuracy) {
            this.mListener.onInputSensorAccuracyChanged(deviceId, sensorType, accuracy);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.w(InputManagerService.TAG, "Failed to notify process " + this.mPid + " that sensor accuracy notified, assuming it died.", ex);
            binderDied();
        }
    }

    private final class TabletModeChangedListenerRecord implements IBinder.DeathRecipient {
        private final ITabletModeChangedListener mListener;
        private final int mPid;
        final /* synthetic */ InputManagerService this$0;

        public TabletModeChangedListenerRecord(InputManagerService r1, int pid, ITabletModeChangedListener listener) {
            this.this$0 = r1;
            this.mPid = pid;
            this.mListener = listener;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (InputManagerService.m4529$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.d(InputManagerService.TAG, "Tablet mode changed listener for pid " + this.mPid + " died.");
        L5:
            InputManagerService.m4519$$Nest$monTabletModeChangedListenerDied(this.this$0, this.mPid);
        }

        public void notifyTabletModeChanged(long whenNanos, boolean inTabletMode) {
            this.mListener.onTabletModeChanged(whenNanos, inTabletMode);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.w(InputManagerService.TAG, "Failed to notify process " + this.mPid + " that tablet mode changed, assuming it died.", ex);
            binderDied();
        }
    }

    private static class VibrationInfo {
        private final int[] mAmplitudes;
        private final long[] mPattern;
        private final int mRepeat;

        public long[] getPattern() {
            return this.mPattern;
        }

        public int[] getAmplitudes() {
            return this.mAmplitudes;
        }

        public int getRepeatIndex() {
            return this.mRepeat;
        }

        VibrationInfo(VibrationEffect effect) {
            long[] pattern = null;
            int[] amplitudes = null;
            int patternRepeatIndex = -1;
            int amplitudeCount = -1;
            if ((effect instanceof VibrationEffect.Composed) == false) goto L18;
            VibrationEffect.Composed composed = (VibrationEffect.Composed) effect;
            int segmentCount = composed.getSegments().size();
            pattern = new long[segmentCount];
            amplitudes = new int[segmentCount];
            patternRepeatIndex = composed.getRepeatIndex();
            amplitudeCount = 0;
            int i = 0;
        L5:
            if (i >= segmentCount) goto L20;
            StepSegment r8 = (VibrationEffectSegment) composed.getSegments().get(i);
            if (composed.getRepeatIndex() != i) goto L10;
            patternRepeatIndex = amplitudeCount;
        L10:
            if ((r8 instanceof StepSegment) == false) goto L11;
            float amplitude = r8.getAmplitude();
            if (Float.compare(amplitude, -1.0f) != 0) goto L15;
            amplitudes[amplitudeCount] = 192;
        L16:
            pattern[amplitudeCount] = r8.getDuration();
            i = i + 1;
            amplitudeCount = amplitudeCount + 1;
            goto L5
        L15:
            amplitudes[amplitudeCount] = (int) (255.0f * amplitude);
            goto L16
        L11:
            Slog.w(InputManagerService.TAG, "Input devices don't support segment " + r8);
            amplitudeCount = -1;
        L20:
            if (amplitudeCount >= 0) goto L22;
            Slog.w(InputManagerService.TAG, "Only oneshot and step waveforms are supported on input devices");
            this.mPattern = new long[0];
            this.mAmplitudes = new int[0];
            this.mRepeat = -1;
            return;
        L22:
            this.mRepeat = patternRepeatIndex;
            this.mPattern = new long[amplitudeCount];
            this.mAmplitudes = new int[amplitudeCount];
            System.arraycopy(pattern, 0, this.mPattern, 0, amplitudeCount);
            System.arraycopy(amplitudes, 0, this.mAmplitudes, 0, amplitudeCount);
            if (this.mRepeat >= this.mPattern.length) goto L26;
            return;
        L26:
            throw new ArrayIndexOutOfBoundsException("Repeat index " + this.mRepeat + " must be within the bounds of the pattern.length " + this.mPattern.length);
        L18:
            Slog.w(InputManagerService.TAG, "Input devices don't support effect " + effect);
            goto L20
        }
    }

    private final class VibratorToken implements IBinder.DeathRecipient {
        public final int mDeviceId;
        public final IBinder mToken;
        public final int mTokenValue;
        public boolean mVibrating;
        final /* synthetic */ InputManagerService this$0;

        public VibratorToken(InputManagerService r1, int deviceId, IBinder token, int tokenValue) {
            this.this$0 = r1;
            this.mDeviceId = deviceId;
            this.mToken = token;
            this.mTokenValue = tokenValue;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (InputManagerService.m4529$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.d(InputManagerService.TAG, "Vibrator token died.");
        L5:
            this.this$0.onVibratorTokenDied(this);
        }
    }

    public interface WindowManagerCallbacks extends InputManagerInternal.LidSwitchCallback {
        SurfaceControl createSurfaceForGestureMonitor(String r1, int r2);

        SurfaceControl getParentSurfaceForPointers(int r1);

        int getPointerDisplayId();

        int getPointerLayer();

        long interceptKeyBeforeDispatching(IBinder r1, KeyEvent r2, int r3);

        int interceptKeyBeforeQueueing(KeyEvent r1, int r2);

        int interceptMotionBeforeQueueingNonInteractive(int r1, int r2, int r3, long r4, int r6);

        boolean interceptUnhandledKey(KeyEvent r1, IBinder r2);

        boolean isKeyguardLocked(int r1);

        void notifyCameraLensCoverSwitchChanged(long r1, boolean r3);

        void notifyConfigurationChanged();

        void notifyDropWindow(IBinder r1, float r2, float r3);

        void notifyFocusChanged(IBinder r1, IBinder r2);

        void notifyInputChannelBroken(IBinder r1);

        void notifyNoFocusedWindowAnr(InputApplicationHandle r1, String r2);

        void notifyPointerLocationChanged(boolean r1);

        void notifyWindowResponsive(IBinder r1, OptionalInt r2);

        void notifyWindowUnresponsive(IBinder r1, OptionalInt r2, String r3);

        void onPointerDownOutsideFocus(IBinder r1);

        void togglePowerAndAiKey(boolean r1);
    }

    public interface WiredAccessoryCallbacks {
        void notifyWiredAccessoryChanged(long r1, int r3, int r4);

        void systemReady();
    }

    public static /* synthetic */ void $r8$lambda$3K08EKjk9Mk9Ukplrs0Q3rMHiRc(boolean r0, AdditionalDisplayInputProperties r1) {
        lambda$setMouseScalingEnabled$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$J7S08y3ZDUWRahBY7dv-2xrwWt4, reason: not valid java name */
    public static /* synthetic */ void m4495$r8$lambda$J7S08y3ZDUWRahBY7dv2xrwWt4(boolean r0, AdditionalDisplayInputProperties r1) {
        lambda$setPointerIconVisible$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Kah4qwVKd93Uhzj44pUEnsAc5Gw(List r0, String r1, Object r2) {
        lambda$flatten$10(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$P6kxuSkUabdg2iEWvAv1QXmulww(IndentingPrintWriter r0, String r1, String r2) {
        lambda$dumpAssociations$5(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$RqZJ0PY7bfV90FxNExHuOVtQCdU(IndentingPrintWriter r0, String r1, Integer r2) {
        lambda$dumpAssociations$3(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$VwZ6khknKv2NA982rW9SoVjxBBU(IndentingPrintWriter r0, String r1, String r2) {
        lambda$dumpAssociations$7(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$_lq68lI-mAIn9_KuD39dCgc47TQ, reason: not valid java name */
    public static /* synthetic */ void m4496$r8$lambda$_lq68lImAIn9_KuD39dCgc47TQ(InputManagerService r0, InputChannel r1) {
        r0.lambda$createSpyWindowGestureMonitor$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$cP-8M_oJ3cJxiMWouBPeDum6DUc, reason: not valid java name */
    public static /* synthetic */ void m4497$r8$lambda$cP8M_oJ3cJxiMWouBPeDum6DUc(InputManagerService r0, KeyGestureEvent r1, IBinder r2) {
        r0.lambda$initKeyGestures$9(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$fOjwyWaRSOqSofpA-1hKOuhc0Ug, reason: not valid java name */
    public static /* synthetic */ boolean m4498$r8$lambda$fOjwyWaRSOqSofpA1hKOuhc0Ug(IKeyEventActivityListener r0, IKeyEventActivityListener r1) {
        return lambda$unregisterKeyEventActivityListenerInternal$8(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$sQMrlNF2K3IZ6pcGcqbo-QQHGBc, reason: not valid java name */
    public static /* synthetic */ void m4499$r8$lambda$sQMrlNF2K3IZ6pcGcqboQQHGBc(IndentingPrintWriter r0, String r1, String r2) {
        lambda$dumpAssociations$6(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$yBQqQtaiwd66G-IwvbD_ay61RVg, reason: not valid java name */
    public static /* synthetic */ void m4500$r8$lambda$yBQqQtaiwd66GIwvbD_ay61RVg(IndentingPrintWriter r0, String r1, Integer r2) {
        lambda$dumpAssociations$4(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBatteryController, reason: not valid java name */
    static /* bridge */ /* synthetic */ BatteryController m4501$$Nest$fgetmBatteryController(InputManagerService r0) {
        return r0.mBatteryController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDoubleTouchGestureEnableFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m4502$$Nest$fgetmDoubleTouchGestureEnableFile(InputManagerService r0) {
        return r0.mDoubleTouchGestureEnableFile;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ InputManagerHandler m4503$$Nest$fgetmHandler(InputManagerService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmKeyGestureController, reason: not valid java name */
    static /* bridge */ /* synthetic */ KeyGestureController m4504$$Nest$fgetmKeyGestureController(InputManagerService r0) {
        return r0.mKeyGestureController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmKeyboardBacklightController, reason: not valid java name */
    static /* bridge */ /* synthetic */ KeyboardBacklightControllerInterface m4505$$Nest$fgetmKeyboardBacklightController(InputManagerService r0) {
        return r0.mKeyboardBacklightController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmKeyboardLayoutManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ KeyboardLayoutManager m4506$$Nest$fgetmKeyboardLayoutManager(InputManagerService r0) {
        return r0.mKeyboardLayoutManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLightLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m4507$$Nest$fgetmLightLock(InputManagerService r0) {
        return r0.mLightLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLightSessions, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m4508$$Nest$fgetmLightSessions(InputManagerService r0) {
        return r0.mLightSessions;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNative, reason: not valid java name */
    static /* bridge */ /* synthetic */ NativeInputManagerService m4509$$Nest$fgetmNative(InputManagerService r0) {
        return r0.mNative;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmObricExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IObricInputManagerService m4510$$Nest$fgetmObricExt(InputManagerService r0) {
        return r0.mObricExt;
    }

    /* JADX INFO: renamed from: -$$Nest$maddKeyboardLayoutAssociation, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4511$$Nest$maddKeyboardLayoutAssociation(InputManagerService r0, String r1, String r2, String r3) {
        r0.addKeyboardLayoutAssociation(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckCallingPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4512$$Nest$mcheckCallingPermission(InputManagerService r0, String r1, String r2) {
        return r0.checkCallingPermission(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mdeliverInputDevicesChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4513$$Nest$mdeliverInputDevicesChanged(InputManagerService r0, InputDevice[] r1) {
        r0.deliverInputDevicesChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdeliverTabletModeChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4514$$Nest$mdeliverTabletModeChanged(InputManagerService r0, long r1, boolean r3) {
        r0.deliverTabletModeChanged(r1, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleCurrentUserChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4515$$Nest$mhandleCurrentUserChanged(InputManagerService r0, int r1) {
        r0.handleCurrentUserChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monBootPhase, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4516$$Nest$monBootPhase(InputManagerService r0, int r1) {
        r0.onBootPhase(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monInputDevicesChangedListenerDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4517$$Nest$monInputDevicesChangedListenerDied(InputManagerService r0, int r1) {
        r0.onInputDevicesChangedListenerDied(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monSensorEventListenerDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4518$$Nest$monSensorEventListenerDied(InputManagerService r0, int r1) {
        r0.onSensorEventListenerDied(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monTabletModeChangedListenerDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4519$$Nest$monTabletModeChangedListenerDied(InputManagerService r0, int r1) {
        r0.onTabletModeChangedListenerDied(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserSwitching, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4520$$Nest$monUserSwitching(InputManagerService r0, SystemService.TargetUser r1, SystemService.TargetUser r2) {
        r0.onUserSwitching(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mreloadDeviceAliases, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4521$$Nest$mreloadDeviceAliases(InputManagerService r0) {
        r0.reloadDeviceAliases();
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveKeyboardLayoutAssociation, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4522$$Nest$mremoveKeyboardLayoutAssociation(InputManagerService r0, String r1) {
        r0.removeKeyboardLayoutAssociation(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveSpyWindowGestureMonitor, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4523$$Nest$mremoveSpyWindowGestureMonitor(InputManagerService r0, IBinder r1) {
        r0.removeSpyWindowGestureMonitor(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetDisplayEligibilityForPointerCapture, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4524$$Nest$msetDisplayEligibilityForPointerCapture(InputManagerService r0, int r1, boolean r2) {
        r0.setDisplayEligibilityForPointerCapture(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetDisplayTopologyInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4525$$Nest$msetDisplayTopologyInternal(InputManagerService r0, DisplayTopologyGraph r1) {
        r0.setDisplayTopologyInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetDisplayViewportsInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4526$$Nest$msetDisplayViewportsInternal(InputManagerService r0, List r1) {
        r0.setDisplayViewportsInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetMouseScalingEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4527$$Nest$msetMouseScalingEnabled(InputManagerService r0, boolean r1, int r2) {
        r0.setMouseScalingEnabled(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetPointerIconVisible, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4528$$Nest$msetPointerIconVisible(InputManagerService r0, boolean r1, int r2) {
        r0.setPointerIconVisible(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4529$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public InputManagerService(Context context) {
        this(new Injector(context, DisplayThread.get().getLooper(), IoThread.get().getLooper(), new AnonymousClass1()), (PermissionEnforcer) context.getSystemService(PermissionEnforcer.class));
    }

    InputManagerService(Injector injector, PermissionEnforcer permissionEnforcer) {
        super(permissionEnforcer);
        this.mTabletModeLock = new Object();
        this.mTabletModeChangedListeners = new SparseArray();
        this.mTempTabletModeChangedListenersToNotify = new ArrayList();
        this.mSensorEventLock = new Object();
        this.mSensorEventListeners = new SparseArray();
        this.mSensorEventListenersToNotify = new ArrayList();
        this.mSensorAccuracyListenersToNotify = new ArrayList();
        this.mDataStore = new PersistentDataStore();
        this.mInputDevicesLock = new Object();
        this.mInputDevices = new InputDevice[0];
        this.mInputDevicesChangedListeners = new SparseArray();
        this.mTempInputDevicesChangedListenersToNotify = new ArrayList();
        this.mVibratorLock = new Object();
        this.mVibratorTokens = new ArrayMap();
        this.mVibratorStateListeners = new SparseArray();
        this.mIsVibrating = new SparseBooleanArray();
        this.mLightLock = new Object();
        this.mLightSessions = new ArrayMap();
        this.mLidSwitchLock = new Object();
        this.mLidSwitchCallbacks = new ArrayList();
        this.mInputFilterLock = new Object();
        this.mAssociationsLock = new Object();
        this.mRuntimeAssociations = new ArrayMap();
        this.mKeyEventActivityLock = new Object();
        this.mKeyEventActivityListenersToNotify = new ArrayList();
        this.mLastKeyEventActivityTimeMs = 0;
        this.mUniqueIdAssociationsByPort = new ArrayMap();
        this.mUniqueIdAssociationsByDescriptor = new ArrayMap();
        this.mKeyboardLayoutAssociations = new ArrayMap();
        this.mDeviceTypeAssociations = new ArrayMap();
        this.mAdditionalDisplayInputPropertiesLock = new Object();
        this.mAdditionalDisplayInputProperties = new SparseArray();
        this.mInputMonitors = new HashMap();
        this.mFallbackActions = new SparseArray();
        this.mFocusEventDebugViewLock = new Object();
        this.mShowKeyPresses = false;
        this.mShowRotaryInput = false;
        this.mAccessibilityPointerMotionFilterLock = new Object();
        InputManagerServiceIA r0 = null;
        this.mAccessibilityPointerMotionFilter = null;
        this.mObricExt = (IObricInputManagerService) ObricImplFactory.getImpl(IObricInputManagerService.class, new Object[]{this});
        this.mStaticAssociations = loadStaticInputPortAssociations();
        this.mContext = injector.getContext();
        this.mHandler = new InputManagerHandler(this, injector.getLooper());
        this.mNative = injector.getNativeService(this);
        this.mSettingsObserver = new InputSettingsObserver(this.mContext, this.mHandler, this, this.mNative);
        this.mKeyboardLayoutManager = new KeyboardLayoutManager(this.mContext, this.mNative, this.mDataStore, injector.getLooper());
        this.mTouchpadDebugViewController = new TouchpadDebugViewController(this.mContext, injector.getLooper(), this);
        this.mBatteryController = new BatteryController(this.mContext, this.mNative, injector.getLooper(), injector.getUEventManager());
        this.mSysfsNodeMonitor = new SysfsNodeMonitor(this.mContext, this.mNative, injector.getLooper(), injector.getUEventManager());
        this.mKeyboardBacklightController = injector.getKeyboardBacklightController(this.mNative);
        this.mStickyModifierStateController = new StickyModifierStateController();
        this.mInputDataStore = new InputDataStore();
        this.mKeyGestureController = new KeyGestureController(this.mContext, injector.getLooper(), injector.getIoLooper(), this.mInputDataStore);
        this.mKeyboardLedController = new KeyboardLedController(this.mContext, injector.getLooper(), this.mNative);
        this.mKeyRemapper = new KeyRemapper(this.mContext, this.mNative, this.mDataStore, injector.getLooper());
        this.mKeyboardGlyphManager = new KeyboardGlyphManager(this.mContext, injector.getLooper());
        this.mPointerIconCache = new PointerIconCache(this.mContext, this.mNative);
        this.mUseDevInputEventForAudioJack = this.mContext.getResources().getBoolean(R.bool.config_use_strict_phone_number_comparation_for_kazakhstan);
        Slog.i(TAG, "Initializing input manager, mUseDevInputEventForAudioJack=" + this.mUseDevInputEventForAudioJack);
        String doubleTouchGestureEnablePath = this.mContext.getResources().getString(R.string.config_networkLocationProviderPackageName);
        if (TextUtils.isEmpty(doubleTouchGestureEnablePath) == false) goto L5;
        File r2 = null;
    L6:
        this.mDoubleTouchGestureEnableFile = r2;
        this.mVelocityTrackerStrategy = DeviceConfig.getProperty("input_native_boot", VELOCITYTRACKER_STRATEGY_PROPERTY);
        injector.registerLocalService(new LocalService(this, r0));
        return;
    L5:
        r2 = new File(doubleTouchGestureEnablePath);
        goto L6
    }

    public void setWindowManagerCallbacks(WindowManagerCallbacks callbacks) {
        if (this.mWindowManagerCallbacks == null) goto L5;
        unregisterLidSwitchCallbackInternal(this.mWindowManagerCallbacks);
    L5:
        this.mWindowManagerCallbacks = callbacks;
        registerLidSwitchCallbackInternal(this.mWindowManagerCallbacks);
        this.mKeyGestureController.setWindowManagerCallbacks(callbacks);
    }

    public void setWiredAccessoryCallbacks(WiredAccessoryCallbacks callbacks) {
        this.mWiredAccessoryCallbacks = callbacks;
    }

    void registerLidSwitchCallbackInternal(InputManagerInternal.LidSwitchCallback callback) {
        Object r0 = this.mLidSwitchLock;
        monitor-enter(r0);
        this.mLidSwitchCallbacks.add(callback);     // Catch: Throwable -> L10
        if (this.mSystemReady == false) goto L12;
        boolean lidOpen = false;
        if (getSwitchState(-1, -256, 0) != 0) goto L9;
        lidOpen = true;
    L9:
        callback.notifyLidSwitchChanged(0, lidOpen);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void unregisterLidSwitchCallbackInternal(InputManagerInternal.LidSwitchCallback callback) {
        Object r0 = this.mLidSwitchLock;
        monitor-enter(r0);
        this.mLidSwitchCallbacks.remove(callback);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void start() {
        Slog.i(TAG, "Starting input manager");
        this.mNative.start();
        Watchdog.getInstance().addMonitor(this);
    }

    private void onBootPhase(int phase) {
        if (phase != 550) goto L6;
        this.mHandler.sendEmptyMessage(5);
        return;
    }

    public void systemRunning() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "System ready.");
    L5:
        this.mDisplayManagerInternal = (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
        this.mWindowManagerInternal = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
        this.mSettingsObserver.registerAndUpdate();
        Object r0 = this.mLidSwitchLock;
        monitor-enter(r0);
        this.mSystemReady = true;     // Catch: Throwable -> L16
        int switchState = getSwitchState(-1, -256, 0);     // Catch: Throwable -> L16
        int i = 0;
    L10:
        if (i >= this.mLidSwitchCallbacks.size()) goto L19;
        InputManagerInternal.LidSwitchCallback callback = this.mLidSwitchCallbacks.get(i);     // Catch: Throwable -> L16
        if (switchState != 0) goto L14;
        boolean r8 = true;
    L15:
        callback.notifyLidSwitchChanged(0, r8);     // Catch: Throwable -> L16
        i = i + 1;     // Catch: Throwable -> L16
        goto L10
    L14:
        r8 = false;
        goto L15
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L16
        int micMuteState = getSwitchState(-1, -256, 14);
        if (micMuteState != 1) goto L23;
        setSensorPrivacy(1, true);
    L23:
        int cameraMuteState = getSwitchState(-1, -256, 9);
        if (cameraMuteState != 1) goto L26;
        setSensorPrivacy(2, true);
    L26:
        IntentFilter filter = new IntentFilter("android.bluetooth.device.action.ALIAS_CHANGED");
        this.mContext.registerReceiver(new AnonymousClass2(this), filter, null, this.mHandler);
        this.mHandler.sendEmptyMessage(2);
        if (this.mWiredAccessoryCallbacks == null) goto L29;
        this.mWiredAccessoryCallbacks.systemReady();
    L29:
        this.mKeyboardLayoutManager.systemRunning();
        this.mBatteryController.systemRunning();
        this.mSysfsNodeMonitor.systemRunning();
        this.mKeyboardBacklightController.systemRunning();
        this.mKeyboardLedController.systemRunning();
        this.mKeyRemapper.systemRunning();
        this.mPointerIconCache.systemRunning();
        this.mKeyboardGlyphManager.systemRunning();
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private void reloadDeviceAliases() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Reloading device names.");
    L5:
        this.mNative.reloadDeviceAliases();
    }

    private void setDisplayViewportsInternal(List<DisplayViewport> viewports) {
        DisplayViewport[] vArray = new DisplayViewport[viewports.size()];
        int i = viewports.size() - 1;
    L3:
        if (i < 0) goto L5;
        vArray[i] = viewports.get(i);
        i = i - 1;
        goto L3
    L5:
        this.mNative.setDisplayViewports(vArray);
        this.mNative.setPointerDisplayId(this.mWindowManagerCallbacks.getPointerDisplayId());
        if (vArray.length <= 0) goto L27;
        ITouchHal touchHal = VintfHalManager.getTouchHal();
        if (touchHal == null) goto L28;
        int i2 = 0;
    L22:
    L16:
        e = move-exception;
        Slog.e(TAG, "Failed setTsFeatureConfig", e);
        return;
    L11:
        if (i2 >= vArray.length) goto L30;
        if (vArray[i2].type == 1) goto L14;
        i2 = i2 + 1;
        goto L22
    L14:
        Slog.d(TAG, "i = " + i2 + " orentation = " + vArray[i2].orientation);     // Catch: RemoteException -> L16
        touchHal.setTsOrientationStatus(vArray[i2].orientation);     // Catch: RemoteException -> L16
        return;
    L30:
        return;
    L28:
        return;
    }

    private void setDisplayTopologyInternal(DisplayTopologyGraph topology) {
        this.mNative.setDisplayTopology(topology);
    }

    public int getKeyCodeState(int deviceId, int sourceMask, int keyCode) {
        return this.mNative.getKeyCodeState(deviceId, sourceMask, keyCode);
    }

    public int getScanCodeState(int deviceId, int sourceMask, int scanCode) {
        return this.mNative.getScanCodeState(deviceId, sourceMask, scanCode);
    }

    public int getSwitchState(int deviceId, int sourceMask, int switchCode) {
        return this.mNative.getSwitchState(deviceId, sourceMask, switchCode);
    }

    public boolean hasKeys(int deviceId, int sourceMask, int[] keyCodes, boolean[] keyExists) {
        keyCodes.getClass();
        keyExists.getClass();
        if (keyExists.length < keyCodes.length) goto L7;
        return this.mNative.hasKeys(deviceId, sourceMask, keyCodes, keyExists);
    L7:
        throw new IllegalArgumentException("keyExists must be at least as large as keyCodes");
    }

    public int getKeyCodeForKeyLocation(int deviceId, int locationKeyCode) {
        if (locationKeyCode > 0) goto L4;
        return 0;
    L4:
        if (locationKeyCode <= KeyEvent.getMaxKeyCode()) goto L7;
        return 0;
    L7:
        return this.mNative.getKeyCodeForKeyLocation(deviceId, locationKeyCode);
    }

    public InputChannel myInput(String inputChannelName, int displayId) {
        PackageManager pm = this.mContext.getPackageManager();
        int uid = Binder.getCallingUid();
        String[] packages = pm.getPackagesForUid(uid);
        if (packages != null) goto L5;
    L26:
        Slog.d(TAG, "Package is null or empty");
    L27:
        return null;
    L5:
        if (packages.length <= 0) goto L26;
        Slog.d(TAG, "Current packages:  " + packages[0]);
        String packageName = packages[0];
        PackageInfo pkgInfo = pm.getPackageInfo(packageName, 0);     // Catch: Exception -> L16
        if ("cn.nubia.gameassist".equals(packageName) == false) goto L10;
    L18:
        if (pkgInfo != null) goto L20;
    L23:
        Slog.d(TAG, "Cannot get myInput interface for package:  " + packageName);     // Catch: Exception -> L16
        return null;
    L20:
        if ((pkgInfo.applicationInfo.flags & 1) <= 0) goto L23;
        Slog.d(TAG, "Can get myInput interface for package:  " + packageName);     // Catch: Exception -> L16
        return monitorInput(inputChannelName, displayId);
    L10:
        if ("cn.nubia.gamelauncher".equals(packageName) == true) goto L18;
        if ("cn.nubia.gamepad".equals(packageName) == true) goto L18;
        if ("cn.zte.gamefloat".equals(packageName) == false) goto L23;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L27
    }

    public KeyCharacterMap getKeyCharacterMap(String layoutDescriptor) {
        layoutDescriptor.getClass();
        return this.mKeyboardLayoutManager.getKeyCharacterMap(layoutDescriptor);
    }

    @Deprecated
    public boolean transferTouch(IBinder destChannelToken, int displayId) {
        destChannelToken.getClass();
        return this.mNative.transferTouch(destChannelToken, displayId);
    }

    public InputChannel monitorInput(String inputChannelName, int displayId) {
        inputChannelName.getClass();
        if (displayId < 0) goto L7;
        return this.mNative.createInputMonitor(displayId, inputChannelName, Binder.getCallingPid());
    L7:
        throw new IllegalArgumentException("displayId must >= 0.");
    }

    private InputChannel createSpyWindowGestureMonitor(IBinder monitorToken, String name, SurfaceControl sc, int displayId, int pid, int uid) {
        final InputChannel channel = createInputChannel(name);
        monitorToken.linkToDeath(new InputManagerService$$ExternalSyntheticLambda10(this, channel), 0);     // Catch: RemoteException -> L13
        Map<IBinder, GestureMonitorSpyWindow> r8 = this.mInputMonitors;
        monitor-enter(r8);
        this.mInputMonitors.put(channel.getToken(), new GestureMonitorSpyWindow(monitorToken, name, displayId, pid, uid, sc, channel));     // Catch: Throwable -> L10
        monitor-exit(r8);     // Catch: Throwable -> L10
        InputChannel outInputChannel = new InputChannel();
        channel.copyTo(outInputChannel);
        return outInputChannel;
    L10:
        th = move-exception;
        throw th;
    L14:
        Slog.i(TAG, "Client died before '" + name + "' could be created.");
        return null;
    }

    private /* synthetic */ void lambda$createSpyWindowGestureMonitor$0(InputChannel channel) {
        removeSpyWindowGestureMonitor(channel.getToken());
    }

    private void removeSpyWindowGestureMonitor(IBinder inputChannelToken) {
        Map<IBinder, GestureMonitorSpyWindow> r0 = this.mInputMonitors;
        monitor-enter(r0);
        GestureMonitorSpyWindow monitor = this.mInputMonitors.remove(inputChannelToken);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        removeInputChannel(inputChannelToken);
        if (monitor != null) goto L9;
        return;
    L9:
        monitor.remove();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public InputMonitor monitorGestureInput(IBinder monitorToken, String requestedName, int displayId) {
        if (checkCallingPermission("android.permission.MONITOR_INPUT", "monitorGestureInput()") == false) goto L25;
        requestedName.getClass();
        monitorToken.getClass();
        if (displayId < 0) goto L23;
        String name = "[Gesture Monitor] " + requestedName;
        int pid = Binder.getCallingPid();
        int uid = Binder.getCallingUid();
        long ident = Binder.clearCallingIdentity();
        SurfaceControl sc = this.mWindowManagerCallbacks.createSurfaceForGestureMonitor(name, displayId);     // Catch: Throwable -> L18
        if (sc == null) goto L17;
        InputChannel inputChannel = createSpyWindowGestureMonitor(monitorToken, name, sc, displayId, pid, uid);     // Catch: Throwable -> L13
        InputMonitor r15 = new InputMonitor(inputChannel, new InputMonitorHost(this, inputChannel.getToken()), new SurfaceControl(sc, "IMS.monitorGestureInput"));     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(ident);
        return r15;
    L17:
        throw new IllegalArgumentException("Could not create gesture monitor surface on display: " + displayId);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Throwable r13 = th;
    L20:
        Binder.restoreCallingIdentity(ident);
        throw r13;
    L18:
        th = move-exception;
        r13 = th;
        goto L20
    L23:
        throw new IllegalArgumentException("displayId must >= 0.");
    L25:
        throw new SecurityException("Requires MONITOR_INPUT permission");
    }

    public InputChannel createInputChannel(String name) {
        return this.mNative.createInputChannel(name);
    }

    public void removeInputChannel(IBinder connectionToken) {
        connectionToken.getClass();
        this.mNative.removeInputChannel(connectionToken);
    }

    public void setInputFilter(IInputFilter filter) {
        Object r0 = this.mInputFilterLock;
        monitor-enter(r0);
        IInputFilter oldFilter = this.mInputFilter;     // Catch: Throwable -> L8
        if (oldFilter != filter) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        InputManagerServiceIA r2 = null;
        if (oldFilter == null) goto L16;
        this.mInputFilter = null;     // Catch: Throwable -> L8
        this.mInputFilterHost.disconnectLocked();     // Catch: Throwable -> L8
        this.mInputFilterHost = null;     // Catch: Throwable -> L8
        oldFilter.uninstall();     // Catch: Throwable -> L8 RemoteException -> L15
    L16:
        if (filter == null) goto L21;
        this.mInputFilter = filter;     // Catch: Throwable -> L8
        this.mInputFilterHost = new InputFilterHost(this, r2);     // Catch: Throwable -> L8
        filter.install(this.mInputFilterHost);     // Catch: Throwable -> L8 RemoteException -> L20
    L21:
        NativeInputManagerService r3 = this.mNative;     // Catch: Throwable -> L8
        if (filter == null) goto L24;
        boolean r4 = true;
    L25:
        r3.setInputFilterEnabled(r4);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L24:
        r4 = false;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean setInTouchMode(boolean inTouchMode, int pid, int uid, boolean hasPermission, int displayId) {
        return this.mNative.setInTouchMode(inTouchMode, pid, uid, hasPermission, displayId);
    }

    public boolean injectInputEvent(InputEvent event, int mode) {
        return injectInputEventToTarget(event, mode, -1);
    }

    public boolean injectInputEventToTarget(InputEvent event, int mode, int targetUid) {
        if (checkCallingPermission("android.permission.INJECT_EVENTS", "injectInputEvent()", true) == false) goto L38;
        event.getClass();
        if (mode == 0) goto L13;
        if (mode == 2) goto L13;
        if (mode == 1) goto L13;
        throw new IllegalArgumentException("mode is invalid");
    L13:
        if (this.mWindowManagerInternal.getObricWindowManagerInternal().getRobotsAgentUid() != 0) goto L15;
    L17:
        int pid = Binder.getCallingPid();
        long ident = Binder.clearCallingIdentity();
        if (targetUid == (-1)) goto L20;
        boolean injectIntoUid = true;
    L39:
        int result = this.mObricExt.injectInputEvent(event, injectIntoUid, targetUid, mode, this.mDisplayManagerInternal, this.mNative);     // Catch: Throwable -> L34
        Binder.restoreCallingIdentity(ident);
        switch(result) {
            case 0: goto L33;
            case 1: goto L28;
            case 2: goto L24;
            case 3: goto L26;
            default: goto L24;
        };
    L24:
        Slog.w(TAG, "Input event injection from pid " + pid + " failed.");
        return false;
    L26:
        Slog.w(TAG, "Input event injection from pid " + pid + " timed out.");
        return false;
    L28:
        if (injectIntoUid == true) goto L32;
        throw new IllegalStateException("Injection should not result in TARGET_MISMATCH when it is not targeted into to a specific uid.");
    L32:
        throw new IllegalArgumentException("Targeted input event injection from pid " + pid + " was not directed at a window owned by uid " + targetUid + ".");
    L33:
        return true;
    L34:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L20:
        injectIntoUid = false;
        goto L39
    L15:
        if (this.mWindowManagerInternal.getObricWindowManagerInternal().getRobotsAgentUid() != Binder.getCallingUid()) goto L17;
        this.mObricExt.onInputEventInjectedForRobots(event);
        goto L17
    L38:
        throw new SecurityException("Injecting input events requires the caller (or the source of the instrumentation, if any) to have the INJECT_EVENTS permission.");
    }

    public VerifiedInputEvent verifyInputEvent(InputEvent event) {
        event.getClass();
        return this.mNative.verifyInputEvent(event);
    }

    public String getVelocityTrackerStrategy() {
        return this.mVelocityTrackerStrategy;
    }

    public InputDevice getInputDevice(int deviceId) {
        Object r0 = this.mInputDevicesLock;
        monitor-enter(r0);
        InputDevice[] r1 = this.mInputDevices;     // Catch: Throwable -> L10
        int r2 = r1.length;     // Catch: Throwable -> L10
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L13;
        InputDevice inputDevice = r1[r3];     // Catch: Throwable -> L10
        if (inputDevice.getId() == deviceId) goto L8;
        r3 = r3 + 1;     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return inputDevice;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return null;
    L10:
        th = move-exception;
        throw th;
    }

    public void enableInputDevice(int deviceId) {
        if (checkCallingPermission("android.permission.DISABLE_INPUT_DEVICE", "enableInputDevice()") == false) goto L7;
        this.mNative.enableInputDevice(deviceId);
        return;
    L7:
        throw new SecurityException("Requires DISABLE_INPUT_DEVICE permission");
    }

    public void disableInputDevice(int deviceId) {
        if (checkCallingPermission("android.permission.DISABLE_INPUT_DEVICE", "disableInputDevice()") == false) goto L7;
        this.mNative.disableInputDevice(deviceId);
        return;
    L7:
        throw new SecurityException("Requires DISABLE_INPUT_DEVICE permission");
    }

    public int[] getInputDeviceIds() {
        Object r0 = this.mInputDevicesLock;
        monitor-enter(r0);
        int count = this.mInputDevices.length;     // Catch: Throwable -> L7
        int[] ids = new int[count];     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= count) goto L10;
        ids[i] = this.mInputDevices[i].getId();     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return ids;
    L7:
        th = move-exception;
        throw th;
    }

    public InputDevice[] getInputDevices() {
        Object r0 = this.mInputDevicesLock;
        monitor-enter(r0);
        InputDevice[] r1 = this.mInputDevices;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void registerInputDevicesChangedListener(IInputDevicesChangedListener listener) {
        listener.getClass();
        Object r0 = this.mInputDevicesLock;
        monitor-enter(r0);
        int callingPid = Binder.getCallingPid();     // Catch: Throwable -> L7
        if (this.mInputDevicesChangedListeners.get(callingPid) == null) goto L9;
        Slog.w(TAG, "The calling process " + callingPid + " has already registered an InputDevicesChangedListener");     // Catch: Throwable -> L7
    L9:
        InputDevicesChangedListenerRecord record = new InputDevicesChangedListenerRecord(this, callingPid, listener);     // Catch: Throwable -> L7
        IBinder binder = listener.asBinder();     // Catch: Throwable -> L7 RemoteException -> L14
        binder.linkToDeath(record, 0);     // Catch: Throwable -> L7 RemoteException -> L14
        this.mInputDevicesChangedListeners.put(callingPid, record);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L14:
        ex = move-exception;
        throw new RuntimeException(ex);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private void onInputDevicesChangedListenerDied(int pid) {
        Object r0 = this.mInputDevicesLock;
        monitor-enter(r0);
        this.mInputDevicesChangedListeners.remove(pid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void deliverInputDevicesChanged(InputDevice[] oldInputDevices) {
        this.mTempInputDevicesChangedListenersToNotify.clear();
        Object r0 = this.mInputDevicesLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mInputDevicesChangedPending == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mInputDevicesChangedPending = false;     // Catch: Throwable -> L8
        int numListeners = this.mInputDevicesChangedListeners.size();     // Catch: Throwable -> L8
        int i = 0;
    L11:
        if (i >= numListeners) goto L13;
        this.mTempInputDevicesChangedListenersToNotify.add(this.mInputDevicesChangedListeners.valueAt(i));     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L11
    L13:
        int numDevices = this.mInputDevices.length;     // Catch: Throwable -> L8
        int[] deviceIdAndGeneration = new int[numDevices * 2];     // Catch: Throwable -> L8
        int i2 = 0;
    L14:
        if (i2 >= numDevices) goto L20;
        InputDevice inputDevice = this.mInputDevices[i2];     // Catch: Throwable -> L8
        deviceIdAndGeneration[i2 * 2] = inputDevice.getId();     // Catch: Throwable -> L8
        deviceIdAndGeneration[(i2 * 2) + 1] = inputDevice.getGeneration();     // Catch: Throwable -> L8
        if (DEBUG == false) goto L18;
        Log.d(TAG, "device " + inputDevice.getId() + " generation " + inputDevice.getGeneration());     // Catch: Throwable -> L8
    L18:
        i2 = i2 + 1;     // Catch: Throwable -> L8
        goto L14
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L8
        int i3 = 0;
    L22:
        if (i3 >= numListeners) goto L24;
        this.mTempInputDevicesChangedListenersToNotify.get(i3).notifyInputDevicesChanged(deviceIdAndGeneration);
        i3 = i3 + 1;
        goto L22
    L24:
        this.mTempInputDevicesChangedListenersToNotify.clear();
    }

    public TouchCalibration getTouchCalibrationForInputDevice(String inputDeviceDescriptor, int surfaceRotation) {
        inputDeviceDescriptor.getClass();
        PersistentDataStore r0 = this.mDataStore;
        monitor-enter(r0);
        TouchCalibration r1 = this.mDataStore.getTouchCalibration(inputDeviceDescriptor, surfaceRotation);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setTouchCalibrationForInputDevice(String inputDeviceDescriptor, int surfaceRotation, TouchCalibration calibration) {
        if (checkCallingPermission("android.permission.SET_INPUT_CALIBRATION", "setTouchCalibrationForInputDevice()") == false) goto L28;
        inputDeviceDescriptor.getClass();
        calibration.getClass();
        if (surfaceRotation < 0) goto L26;
        if (surfaceRotation > 3) goto L26;
        PersistentDataStore r0 = this.mDataStore;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        this.mDataStore.saveIfNeeded();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L11:
        if (this.mDataStore.setTouchCalibration(inputDeviceDescriptor, surfaceRotation, calibration) == false) goto L16;
        this.mNative.reloadCalibration();     // Catch: Throwable -> L14
    L16:
        this.mDataStore.saveIfNeeded();     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L26:
        throw new IllegalArgumentException("surfaceRotation value out of bounds");
    L28:
        throw new SecurityException("Requires SET_INPUT_CALIBRATION permission");
    }

    public int isInTabletMode() {
        if (checkCallingPermission("android.permission.TABLET_MODE", "isInTabletMode()") == false) goto L7;
        return getSwitchState(-1, -256, 1);
    L7:
        throw new SecurityException("Requires TABLET_MODE permission");
    }

    public int isMicMuted() {
        return getSwitchState(-1, -256, 14);
    }

    public void registerTabletModeChangedListener(ITabletModeChangedListener listener) {
        if (checkCallingPermission("android.permission.TABLET_MODE", "registerTabletModeChangedListener()") == false) goto L23;
        listener.getClass();
        Object r0 = this.mTabletModeLock;
        monitor-enter(r0);
        int callingPid = Binder.getCallingPid();     // Catch: Throwable -> L13
        if (this.mTabletModeChangedListeners.get(callingPid) != null) goto L19;
        TabletModeChangedListenerRecord record = new TabletModeChangedListenerRecord(this, callingPid, listener);     // Catch: Throwable -> L13
        IBinder binder = listener.asBinder();     // Catch: Throwable -> L13 RemoteException -> L15
        binder.linkToDeath(record, 0);     // Catch: Throwable -> L13 RemoteException -> L15
        this.mTabletModeChangedListeners.put(callingPid, record);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L15:
        ex = move-exception;
        throw new RuntimeException(ex);     // Catch: Throwable -> L13
    L19:
        throw new IllegalStateException("The calling process has already registered a TabletModeChangedListener.");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L23:
        throw new SecurityException("Requires TABLET_MODE_LISTENER permission");
    }

    private void onTabletModeChangedListenerDied(int pid) {
        Object r0 = this.mTabletModeLock;
        monitor-enter(r0);
        this.mTabletModeChangedListeners.remove(pid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void deliverTabletModeChanged(long whenNanos, boolean inTabletMode) {
        this.mTempTabletModeChangedListenersToNotify.clear();
        Object r0 = this.mTabletModeLock;
        monitor-enter(r0);
        int numListeners = this.mTabletModeChangedListeners.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= numListeners) goto L10;
        this.mTempTabletModeChangedListenersToNotify.add(this.mTabletModeChangedListeners.valueAt(i));     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        int i2 = 0;
    L12:
        if (i2 >= numListeners) goto L15;
        this.mTempTabletModeChangedListenersToNotify.get(i2).notifyTabletModeChanged(whenNanos, inTabletMode);
        i2 = i2 + 1;
        goto L12
    L15:
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public KeyboardLayout[] getKeyboardLayouts() {
        return this.mKeyboardLayoutManager.getKeyboardLayouts();
    }

    public KeyboardLayout getKeyboardLayout(String keyboardLayoutDescriptor) {
        return this.mKeyboardLayoutManager.getKeyboardLayout(keyboardLayoutDescriptor);
    }

    public KeyboardLayoutSelectionResult getKeyboardLayoutForInputDevice(InputDeviceIdentifier identifier, int userId, InputMethodInfo imeInfo, InputMethodSubtype imeSubtype) {
        return this.mKeyboardLayoutManager.getKeyboardLayoutForInputDevice(identifier, userId, imeInfo, imeSubtype);
    }

    public void setKeyboardLayoutOverrideForInputDevice(InputDeviceIdentifier identifier, String keyboardLayoutDescriptor) {
        super.setKeyboardLayoutOverrideForInputDevice_enforcePermission();
        this.mKeyboardLayoutManager.setKeyboardLayoutOverrideForInputDevice(identifier, keyboardLayoutDescriptor);
    }

    public void setKeyboardLayoutForInputDevice(InputDeviceIdentifier identifier, int userId, InputMethodInfo imeInfo, InputMethodSubtype imeSubtype, String keyboardLayoutDescriptor) {
        super.setKeyboardLayoutForInputDevice_enforcePermission();
        this.mKeyboardLayoutManager.setKeyboardLayoutForInputDevice(identifier, userId, imeInfo, imeSubtype, keyboardLayoutDescriptor);
    }

    public KeyboardLayout[] getKeyboardLayoutListForInputDevice(InputDeviceIdentifier identifier, int userId, InputMethodInfo imeInfo, InputMethodSubtype imeSubtype) {
        return this.mKeyboardLayoutManager.getKeyboardLayoutListForInputDevice(identifier, userId, imeInfo, imeSubtype);
    }

    public KeyGlyphMap getKeyGlyphMap(int deviceId) {
        return this.mKeyboardGlyphManager.getKeyGlyphMap(deviceId);
    }

    public void setFocusedApplication(int displayId, InputApplicationHandle application) {
        this.mNative.setFocusedApplication(displayId, application);
    }

    public void setFocusedDisplay(int displayId) {
        this.mNative.setFocusedDisplay(displayId);
    }

    public void onDisplayRemoved(int displayId) {
        updateAdditionalDisplayInputProperties(displayId, new InputManagerService$$ExternalSyntheticLambda1());
        this.mNative.displayRemoved(displayId);
    }

    public void requestPointerCapture(IBinder inputChannelToken, boolean enabled) {
        inputChannelToken.getClass();
        this.mNative.requestPointerCapture(inputChannelToken, enabled);
    }

    public void setInputDispatchMode(boolean enabled, boolean frozen) {
        this.mNative.setInputDispatchMode(enabled, frozen);
    }

    public void setSystemUiLightsOut(boolean lightsOut) {
        this.mNative.setSystemUiLightsOut(lightsOut);
    }

    public boolean startDragAndDrop(IBinder fromChannelToken, IBinder dragAndDropChannelToken) {
        return this.mNative.transferTouchGesture(fromChannelToken, dragAndDropChannelToken, true, false);
    }

    public boolean transferTouchGesture(IBinder fromChannelToken, IBinder toChannelToken, boolean transferEntireGesture) {
        fromChannelToken.getClass();
        toChannelToken.getClass();
        return this.mNative.transferTouchGesture(fromChannelToken, toChannelToken, false, transferEntireGesture);
    }

    public int getMousePointerSpeed() {
        return this.mNative.getMousePointerSpeed();
    }

    public void tryPointerSpeed(int speed) {
        if (checkCallingPermission("android.permission.SET_POINTER_SPEED", "tryPointerSpeed()") == false) goto L13;
        if (speed < (-7)) goto L11;
        if (speed > 7) goto L11;
        setPointerSpeedUnchecked(speed);
        return;
    L11:
        throw new IllegalArgumentException("speed out of range");
    L13:
        throw new SecurityException("Requires SET_POINTER_SPEED permission");
    }

    private void setPointerSpeedUnchecked(int speed) {
        int speed2 = Math.min(Math.max(speed, -7), 7);
        this.mNative.setPointerSpeed(speed2);
    }

    private void setMouseScalingEnabled(final boolean enabled, int displayId) {
        updateAdditionalDisplayInputProperties(displayId, new InputManagerService$$ExternalSyntheticLambda3(enabled));
    }

    private static /* synthetic */ void lambda$setMouseScalingEnabled$1(boolean enabled, AdditionalDisplayInputProperties properties) {
        properties.mouseScalingEnabled = enabled;
    }

    private void setPointerIconVisible(final boolean visible, int displayId) {
        updateAdditionalDisplayInputProperties(displayId, new InputManagerService$$ExternalSyntheticLambda0(visible));
    }

    private static /* synthetic */ void lambda$setPointerIconVisible$2(boolean visible, AdditionalDisplayInputProperties properties) {
        properties.pointerIconVisible = visible;
    }

    private void setDisplayEligibilityForPointerCapture(int displayId, boolean isEligible) {
        this.mNative.setDisplayEligibilityForPointerCapture(displayId, isEligible);
    }

    private VibratorToken getVibratorToken(int deviceId, IBinder token) {
        Object r0 = this.mVibratorLock;
        monitor-enter(r0);
        VibratorToken v = this.mVibratorTokens.get(token);     // Catch: Throwable -> L10
        if (v != null) goto L15;
        int r3 = this.mNextVibratorTokenValue;     // Catch: Throwable -> L10
        this.mNextVibratorTokenValue = r3 + 1;     // Catch: Throwable -> L10
        v = new VibratorToken(this, deviceId, token, r3);     // Catch: Throwable -> L10
        token.linkToDeath(v, 0);     // Catch: Throwable -> L10 RemoteException -> L12
        this.mVibratorTokens.put(token, v);     // Catch: Throwable -> L10
        goto L15
    L12:
        ex = move-exception;
        throw new RuntimeException(ex);     // Catch: Throwable -> L10
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return v;
    L10:
        th = move-exception;
        throw th;
    }

    public void vibrate(int deviceId, VibrationEffect effect, IBinder token) {
        VibrationInfo info = new VibrationInfo(effect);
        VibratorToken v = getVibratorToken(deviceId, token);
        monitor-enter(v);
        v.mVibrating = true;     // Catch: Throwable -> L12
        this.mNative.vibrate(deviceId, info.getPattern(), info.getAmplitudes(), info.getRepeatIndex(), v.mTokenValue);     // Catch: Throwable -> L10
        monitor-exit(v);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Throwable r10 = th;
    L14:
        monitor-exit(v);     // Catch: Throwable -> L10
        throw r10;
    L12:
        th = move-exception;
        r10 = th;
        goto L14
    }

    public int[] getVibratorIds(int deviceId) {
        return this.mNative.getVibratorIds(deviceId);
    }

    public boolean isVibrating(int deviceId) {
        return this.mNative.isVibrating(deviceId);
    }

    public void vibrateCombined(int deviceId, CombinedVibration effect, IBinder token) {
        VibratorToken v = getVibratorToken(deviceId, token);
        monitor-enter(v);
    L11:
        th = move-exception;
        throw th;
    L5:
        if ((effect instanceof CombinedVibration.Mono) == false) goto L7;
    L13:
        v.mVibrating = true;     // Catch: Throwable -> L11
        if ((effect instanceof CombinedVibration.Mono) == false) goto L18;
        CombinedVibration.Mono mono = (CombinedVibration.Mono) effect;     // Catch: Throwable -> L11
        VibrationInfo info = new VibrationInfo(mono.getEffect());     // Catch: Throwable -> L11
        this.mNative.vibrate(deviceId, info.getPattern(), info.getAmplitudes(), info.getRepeatIndex(), v.mTokenValue);     // Catch: Throwable -> L11
    L30:
        monitor-exit(v);     // Catch: Throwable -> L11
        return;
    L18:
        if ((effect instanceof CombinedVibration.Stereo) == false) goto L30;
        CombinedVibration.Stereo stereo = (CombinedVibration.Stereo) effect;     // Catch: Throwable -> L11
        SparseArray<VibrationEffect> effects = stereo.getEffects();     // Catch: Throwable -> L11
        long[] pattern = new long[0];     // Catch: Throwable -> L11
        SparseArray<int[]> amplitudes = new SparseArray(effects.size());     // Catch: Throwable -> L11
        long[] pattern2 = pattern;
        int i = 0;
        int repeat = Integer.MIN_VALUE;
    L20:
        int repeat2 = effects.size();     // Catch: Throwable -> L11
        if (i >= repeat2) goto L29;
        VibrationInfo info2 = new VibrationInfo(effects.valueAt(i));     // Catch: Throwable -> L11
        if (pattern2.length != 0) goto L26;
        pattern2 = info2.getPattern();     // Catch: Throwable -> L11
    L26:
        if (repeat != Integer.MIN_VALUE) goto L28;
        repeat = info2.getRepeatIndex();     // Catch: Throwable -> L11
    L28:
        amplitudes.put(effects.keyAt(i), info2.getAmplitudes());     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L20
    L29:
        this.mNative.vibrateCombined(deviceId, pattern2, amplitudes, repeat, v.mTokenValue);     // Catch: Throwable -> L11
        goto L30
    L7:
        if ((effect instanceof CombinedVibration.Stereo) == true) goto L13;
        Slog.e(TAG, "Only Mono and Stereo effects are supported");     // Catch: Throwable -> L11
        monitor-exit(v);     // Catch: Throwable -> L11
    }

    public void cancelVibrate(int deviceId, IBinder token) {
        Object r0 = this.mVibratorLock;
        monitor-enter(r0);
        VibratorToken v = this.mVibratorTokens.get(token);     // Catch: Throwable -> L12
        if (v == null) goto L14;
        if (v.mDeviceId != deviceId) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
        cancelVibrateIfNeeded(v);
        return;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void onVibratorTokenDied(VibratorToken v) {
        Object r0 = this.mVibratorLock;
        monitor-enter(r0);
        this.mVibratorTokens.remove(v.mToken);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        cancelVibrateIfNeeded(v);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void cancelVibrateIfNeeded(VibratorToken v) {
        monitor-enter(v);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (v.mVibrating == false) goto L8;
        this.mNative.cancelVibrate(v.mDeviceId, v.mTokenValue);     // Catch: Throwable -> L6
        v.mVibrating = false;     // Catch: Throwable -> L6
    L8:
        monitor-exit(v);     // Catch: Throwable -> L6
    }

    private void notifyVibratorState(int deviceId, boolean isOn) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "notifyVibratorState: deviceId=" + deviceId + " isOn=" + isOn);
    L5:
        Object r0 = this.mVibratorLock;
        monitor-enter(r0);
        this.mIsVibrating.put(deviceId, isOn);     // Catch: Throwable -> L10
        notifyVibratorStateListenersLocked(deviceId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void notifyVibratorStateListenersLocked(int deviceId) {
        if (this.mVibratorStateListeners.contains(deviceId) == false) goto L5;
        RemoteCallbackList<IVibratorStateListener> listeners = this.mVibratorStateListeners.get(deviceId);
        int length = listeners.beginBroadcast();
        int i = 0;
    L9:
        if (i >= length) goto L15;
        notifyVibratorStateListenerLocked(deviceId, (IVibratorStateListener) listeners.getBroadcastItem(i));     // Catch: Throwable -> L12
        i = i + 1;
    L12:
        th = move-exception;
        listeners.finishBroadcast();
        throw th;
    L15:
        listeners.finishBroadcast();
        return;
    L5:
        if (DEBUG == false) goto L20;
        Slog.v(TAG, "Device " + deviceId + " doesn't have vibrator state listener.");
        return;
    }

    private void notifyVibratorStateListenerLocked(int deviceId, IVibratorStateListener listener) {
        listener.onVibrating(this.mIsVibrating.get(deviceId));     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Vibrator state listener failed to call", e);
    }

    public boolean registerVibratorStateListener(int deviceId, IVibratorStateListener listener) {
        listener.getClass();
        Object r0 = this.mVibratorLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mVibratorStateListeners.contains(deviceId) == true) goto L9;
        RemoteCallbackList<IVibratorStateListener> listeners = new RemoteCallbackList();     // Catch: Throwable -> L7
        this.mVibratorStateListeners.put(deviceId, listeners);     // Catch: Throwable -> L7
    L10:
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L7
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L7
        throw th;     // Catch: Throwable -> L7
    L12:
        if (listeners.register(listener) == true) goto L20;
        Slog.e(TAG, "Could not register vibrator state listener " + listener);     // Catch: Throwable -> L18
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return false;
    L20:
        notifyVibratorStateListenerLocked(deviceId, listener);     // Catch: Throwable -> L18
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return true;
    L9:
        listeners = this.mVibratorStateListeners.get(deviceId);     // Catch: Throwable -> L7
        goto L10
    }

    public boolean unregisterVibratorStateListener(int deviceId, IVibratorStateListener listener) {
        Object r0 = this.mVibratorLock;
        monitor-enter(r0);
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L12
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L6:
        if (this.mVibratorStateListeners.contains(deviceId) == true) goto L16;
        Slog.w(TAG, "Vibrator state listener " + deviceId + " doesn't exist");     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L16:
        RemoteCallbackList<IVibratorStateListener> listeners = this.mVibratorStateListeners.get(deviceId);     // Catch: Throwable -> L14
        boolean r4 = listeners.unregister(listener);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r4;
    L12:
        th = move-exception;
        throw th;
    }

    public IInputDeviceBatteryState getBatteryState(int deviceId) {
        return this.mBatteryController.getBatteryState(deviceId);
    }

    public boolean setPointerIcon(PointerIcon icon, int displayId, int deviceId, int pointerId, IBinder inputToken) {
        icon.getClass();
        return this.mNative.setPointerIcon(icon, displayId, deviceId, pointerId, inputToken);
    }

    public void addPortAssociation(String inputPort, int displayPort) {
        if (checkCallingPermission("android.permission.ASSOCIATE_INPUT_DEVICE_TO_DISPLAY", "addPortAssociation()") == false) goto L14;
        inputPort.getClass();
        Object r0 = this.mAssociationsLock;
        monitor-enter(r0);
        this.mRuntimeAssociations.put(inputPort, Integer.valueOf(displayPort));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        this.mNative.notifyPortAssociationsChanged();
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        throw new SecurityException("Requires ASSOCIATE_INPUT_DEVICE_TO_DISPLAY permission");
    }

    public void removePortAssociation(String inputPort) {
        if (checkCallingPermission("android.permission.ASSOCIATE_INPUT_DEVICE_TO_DISPLAY", "removePortAssociation()") == false) goto L14;
        inputPort.getClass();
        Object r0 = this.mAssociationsLock;
        monitor-enter(r0);
        this.mRuntimeAssociations.remove(inputPort);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        this.mNative.notifyPortAssociationsChanged();
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        throw new SecurityException("Requires ASSOCIATE_INPUT_DEVICE_TO_DISPLAY permission");
    }

    public void addUniqueIdAssociationByPort(String inputPort, String displayUniqueId) {
        if (checkCallingPermission("android.permission.ASSOCIATE_INPUT_DEVICE_TO_DISPLAY", "addUniqueIdAssociation()") == false) goto L14;
        inputPort.getClass();
        displayUniqueId.getClass();
        Object r0 = this.mAssociationsLock;
        monitor-enter(r0);
        this.mUniqueIdAssociationsByPort.put(inputPort, displayUniqueId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        this.mNative.changeUniqueIdAssociation();
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        throw new SecurityException("Requires ASSOCIATE_INPUT_DEVICE_TO_DISPLAY permission");
    }

    public void removeUniqueIdAssociationByPort(String inputPort) {
        if (checkCallingPermission("android.permission.ASSOCIATE_INPUT_DEVICE_TO_DISPLAY", "removeUniqueIdAssociation()") == false) goto L14;
        inputPort.getClass();
        Object r0 = this.mAssociationsLock;
        monitor-enter(r0);
        this.mUniqueIdAssociationsByPort.remove(inputPort);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        this.mNative.changeUniqueIdAssociation();
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        throw new SecurityException("Requires ASSOCIATE_INPUT_DEVICE_TO_DISPLAY permission");
    }

    public void addUniqueIdAssociationByDescriptor(String inputDeviceDescriptor, String displayUniqueId) {
        if (checkCallingPermission("android.permission.ASSOCIATE_INPUT_DEVICE_TO_DISPLAY", "addUniqueIdAssociationByDescriptor()") == false) goto L14;
        inputDeviceDescriptor.getClass();
        displayUniqueId.getClass();
        Object r0 = this.mAssociationsLock;
        monitor-enter(r0);
        this.mUniqueIdAssociationsByDescriptor.put(inputDeviceDescriptor, displayUniqueId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        this.mNative.changeUniqueIdAssociation();
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        throw new SecurityException("Requires ASSOCIATE_INPUT_DEVICE_TO_DISPLAY permission");
    }

    public void removeUniqueIdAssociationByDescriptor(String inputDeviceDescriptor) {
        if (checkCallingPermission("android.permission.ASSOCIATE_INPUT_DEVICE_TO_DISPLAY", "removeUniqueIdAssociationByDescriptor()") == false) goto L14;
        inputDeviceDescriptor.getClass();
        Object r0 = this.mAssociationsLock;
        monitor-enter(r0);
        this.mUniqueIdAssociationsByDescriptor.remove(inputDeviceDescriptor);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        this.mNative.changeUniqueIdAssociation();
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        throw new SecurityException("Requires ASSOCIATE_INPUT_DEVICE_TO_DISPLAY permission");
    }

    void setTypeAssociationInternal(String inputPort, String type) {
        inputPort.getClass();
        type.getClass();
        Object r0 = this.mAssociationsLock;
        monitor-enter(r0);
        this.mDeviceTypeAssociations.put(inputPort, type);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mNative.changeTypeAssociation();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void unsetTypeAssociationInternal(String inputPort) {
        inputPort.getClass();
        Object r0 = this.mAssociationsLock;
        monitor-enter(r0);
        this.mDeviceTypeAssociations.remove(inputPort);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mNative.changeTypeAssociation();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void addKeyboardLayoutAssociation(String inputPort, String languageTag, String layoutType) {
        inputPort.getClass();
        languageTag.getClass();
        layoutType.getClass();
        Object r0 = this.mAssociationsLock;
        monitor-enter(r0);
        this.mKeyboardLayoutAssociations.put(inputPort, TextUtils.formatSimple("%s,%s", new Object[]{languageTag, layoutType}));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mNative.changeKeyboardLayoutAssociation();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void removeKeyboardLayoutAssociation(String inputPort) {
        inputPort.getClass();
        Object r0 = this.mAssociationsLock;
        monitor-enter(r0);
        this.mKeyboardLayoutAssociations.remove(inputPort);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mNative.changeKeyboardLayoutAssociation();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public InputSensorInfo[] getSensorList(int deviceId) {
        return this.mNative.getSensorList(deviceId);
    }

    public TouchpadHardwareProperties getTouchpadHardwareProperties(int deviceId) {
        return this.mNative.getTouchpadHardwareProperties(deviceId);
    }

    public boolean registerSensorListener(IInputSensorEventListener listener) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "registerSensorListener: listener=" + listener + " callingPid=" + Binder.getCallingPid());
    L5:
        listener.getClass();
        Object r0 = this.mSensorEventLock;
        monitor-enter(r0);
        int callingPid = Binder.getCallingPid();     // Catch: Throwable -> L12
        if (this.mSensorEventListeners.get(callingPid) == null) goto L14;
        Slog.e(TAG, "The calling process " + callingPid + " has already registered an InputSensorEventListener.");     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L14:
        SensorEventListenerRecord record = new SensorEventListenerRecord(this, callingPid, listener);     // Catch: Throwable -> L12
        IBinder binder = listener.asBinder();     // Catch: Throwable -> L12 RemoteException -> L20
        binder.linkToDeath(record, 0);     // Catch: Throwable -> L12 RemoteException -> L20
        this.mSensorEventListeners.put(callingPid, record);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L20:
        ex = move-exception;
        throw new RuntimeException(ex);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public void unregisterSensorListener(IInputSensorEventListener listener) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "unregisterSensorListener: listener=" + listener + " callingPid=" + Binder.getCallingPid());
    L5:
        listener.getClass();
        Object r0 = this.mSensorEventLock;
        monitor-enter(r0);
        int callingPid = Binder.getCallingPid();     // Catch: Throwable -> L12
        if (this.mSensorEventListeners.get(callingPid) == null) goto L16;
        SensorEventListenerRecord record = this.mSensorEventListeners.get(callingPid);     // Catch: Throwable -> L12
        if (record.getListener().asBinder() != listener.asBinder()) goto L15;
        this.mSensorEventListeners.remove(callingPid);     // Catch: Throwable -> L12
        goto L16
    L15:
        throw new IllegalArgumentException("listener is not registered");     // Catch: Throwable -> L12
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public boolean flushSensor(int deviceId, int sensorType) {
        Object r0 = this.mSensorEventLock;
        monitor-enter(r0);
        int callingPid = Binder.getCallingPid();     // Catch: Throwable -> L9
        SensorEventListenerRecord listener = this.mSensorEventListeners.get(callingPid);     // Catch: Throwable -> L9
        if (listener == null) goto L11;
        boolean r3 = this.mNative.flushSensor(deviceId, sensorType);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean enableSensor(int deviceId, int sensorType, int samplingPeriodUs, int maxBatchReportLatencyUs) {
        Object r0 = this.mInputDevicesLock;
        monitor-enter(r0);
        boolean r1 = this.mNative.enableSensor(deviceId, sensorType, samplingPeriodUs, maxBatchReportLatencyUs);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void disableSensor(int deviceId, int sensorType) {
        Object r0 = this.mInputDevicesLock;
        monitor-enter(r0);
        this.mNative.disableSensor(deviceId, sensorType);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public List<Light> getLights(int deviceId) {
        return this.mNative.getLights(deviceId);
    }

    private void setLightStateInternal(int deviceId, Light light, LightState lightState) {
        light.getClass();
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "setLightStateInternal device " + deviceId + " light " + light + "lightState " + lightState);
    L6:
        if (light.getType() != 10002) goto L8;
        this.mNative.setLightPlayerId(deviceId, light.getId(), lightState.getPlayerId());
        return;
    L8:
        this.mNative.setLightColor(deviceId, light.getId(), lightState.getColor());
    }

    private void setLightStatesInternal(int deviceId, int[] lightIds, LightState[] lightStates) {
        List<Light> lights = this.mNative.getLights(deviceId);
        SparseArray<Light> lightArray = new SparseArray();
        int i = 0;
    L4:
        if (i >= lights.size()) goto L6;
        lightArray.put(lights.get(i).getId(), lights.get(i));
        i = i + 1;
        goto L4
    L6:
        int i2 = 0;
    L8:
        if (i2 >= lightIds.length) goto L14;
        if (lightArray.contains(lightIds[i2]) == false) goto L12;
        setLightStateInternal(deviceId, lightArray.get(lightIds[i2]), lightStates[i2]);
    L12:
        i2 = i2 + 1;
        goto L8
    }

    public void setLightStates(int deviceId, int[] lightIds, LightState[] lightStates, IBinder token) {
        boolean r2 = false;
        if (lightIds.length != lightStates.length) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "lights and light states are not same length");
        Object r1 = this.mLightLock;
        monitor-enter(r1);
        LightSession lightSession = this.mLightSessions.get(token);     // Catch: Throwable -> L18
        if (lightSession == null) goto L11;
        boolean r4 = true;
    L12:
        Preconditions.checkArgument(r4, "not registered");     // Catch: Throwable -> L18
        if (LightSession.m4530$$Nest$fgetmDeviceId(lightSession) != deviceId) goto L15;
        r2 = true;
    L15:
        Preconditions.checkState(r2, "Incorrect device ID");     // Catch: Throwable -> L18
        LightSession.m4534$$Nest$fputmLightIds(lightSession, (int[]) lightIds.clone());     // Catch: Throwable -> L18
        LightSession.m4535$$Nest$fputmLightStates(lightSession, (LightState[]) lightStates.clone());     // Catch: Throwable -> L18
        if (DEBUG == false) goto L20;
        Slog.d(TAG, "setLightStates for " + LightSession.m4533$$Nest$fgetmOpPkg(lightSession) + " device " + deviceId);     // Catch: Throwable -> L18
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L18
        setLightStatesInternal(deviceId, lightIds, lightStates);
        return;
    L11:
        r4 = false;
    L18:
        th = move-exception;
        throw th;
    L5:
        r0 = false;
        goto L6
    }

    public LightState getLightState(int deviceId, int lightId) {
        Object r0 = this.mLightLock;
        monitor-enter(r0);
        int color = this.mNative.getLightColor(deviceId, lightId);     // Catch: Throwable -> L7
        int playerId = this.mNative.getLightPlayerId(deviceId, lightId);     // Catch: Throwable -> L7
        LightState r3 = new LightState(color, playerId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void openLightSession(int deviceId, String opPkg, IBinder token) {
        token.getClass();
        Object r0 = this.mLightLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mLightSessions.get(token) != null) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1, "already registered");     // Catch: Throwable -> L11
        LightSession lightSession = new LightSession(this, deviceId, opPkg, token);     // Catch: Throwable -> L11
        token.linkToDeath(lightSession, 0);     // Catch: Throwable -> L11 RemoteException -> L13
    L15:
        this.mLightSessions.put(token, lightSession);     // Catch: Throwable -> L11
        if (DEBUG == false) goto L18;
        Slog.d(TAG, "Open light session for " + opPkg + " device " + deviceId);     // Catch: Throwable -> L11
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        ex = move-exception;
        ex.rethrowAsRuntimeException();     // Catch: Throwable -> L11
        goto L15
    L7:
        r1 = false;
        goto L8
    }

    public void closeLightSession(int deviceId, IBinder token) {
        token.getClass();
        Object r0 = this.mLightLock;
        monitor-enter(r0);
        LightSession lightSession = this.mLightSessions.get(token);     // Catch: Throwable -> L11
        if (lightSession == null) goto L7;
        boolean r3 = true;
    L8:
        Preconditions.checkState(r3, "not registered");     // Catch: Throwable -> L11
        Arrays.fill(LightSession.m4532$$Nest$fgetmLightStates(lightSession), new LightState(0));     // Catch: Throwable -> L11
        setLightStatesInternal(deviceId, LightSession.m4531$$Nest$fgetmLightIds(lightSession), LightSession.m4532$$Nest$fgetmLightStates(lightSession));     // Catch: Throwable -> L11
        this.mLightSessions.remove(token);     // Catch: Throwable -> L11
        if (this.mLightSessions.isEmpty() == true) goto L13;
        LightSession nextSession = this.mLightSessions.valueAt(0);     // Catch: Throwable -> L11
        setLightStatesInternal(deviceId, LightSession.m4531$$Nest$fgetmLightIds(nextSession), LightSession.m4532$$Nest$fgetmLightStates(nextSession));     // Catch: Throwable -> L11
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        r3 = false;
    L11:
        th = move-exception;
        throw th;
    }

    public void cancelCurrentTouch() {
        if (checkCallingPermission("android.permission.MONITOR_INPUT", "cancelCurrentTouch()") == false) goto L7;
        this.mNative.cancelCurrentTouch();
        return;
    L7:
        throw new SecurityException("Requires MONITOR_INPUT permission");
    }

    public void registerBatteryListener(int deviceId, IInputDeviceBatteryListener listener) {
        listener.getClass();
        this.mBatteryController.registerBatteryListener(deviceId, listener, Binder.getCallingPid());
    }

    public void unregisterBatteryListener(int deviceId, IInputDeviceBatteryListener listener) {
        listener.getClass();
        this.mBatteryController.unregisterBatteryListener(deviceId, listener, Binder.getCallingPid());
    }

    public String getInputDeviceBluetoothAddress(int deviceId) {
        super.getInputDeviceBluetoothAddress_enforcePermission();
        String address = this.mNative.getBluetoothAddress(deviceId);
        if (address != null) goto L7;
        return null;
    L7:
        if (BluetoothAdapter.checkBluetoothAddress(address) == false) goto L10;
        return address;
    L10:
        throw new IllegalStateException("The Bluetooth address of input device " + deviceId + " should not be invalid: address=" + address);
    }

    public void pilferPointers(IBinder inputChannelToken) {
        super.pilferPointers_enforcePermission();
        inputChannelToken.getClass();
        this.mNative.pilferPointers(inputChannelToken);
    }

    public void registerKeyboardBacklightListener(IKeyboardBacklightListener listener) {
        super.registerKeyboardBacklightListener_enforcePermission();
        listener.getClass();
        this.mKeyboardBacklightController.registerKeyboardBacklightListener(listener, Binder.getCallingPid());
    }

    public void unregisterKeyboardBacklightListener(IKeyboardBacklightListener listener) {
        super.unregisterKeyboardBacklightListener_enforcePermission();
        listener.getClass();
        this.mKeyboardBacklightController.unregisterKeyboardBacklightListener(listener, Binder.getCallingPid());
    }

    public HostUsiVersion getHostUsiVersionFromDisplayConfig(int displayId) {
        return this.mDisplayManagerInternal.getHostUsiVersion(displayId);
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ");
        ipw.println("INPUT MANAGER (dumpsys input)\n");
        String dumpStr = this.mNative.dump();
        if (dumpStr == null) goto L8;
        pw.println(dumpStr);
    L8:
        ipw.println("Input Manager Service (Java) State:");
        ipw.increaseIndent();
        dumpAssociations(ipw);
        dumpSpyWindowGestureMonitors(ipw);
        dumpDisplayInputPropertiesValues(ipw);
        this.mBatteryController.dump(ipw);
        this.mKeyboardBacklightController.dump(ipw);
        this.mKeyboardLedController.dump(ipw);
        this.mKeyboardGlyphManager.dump(ipw);
        this.mKeyGestureController.dump(ipw);
    }

    private void dumpAssociations(final IndentingPrintWriter pw) {
        if (this.mStaticAssociations.isEmpty() == true) goto L5;
        pw.println("Static Associations:");
        this.mStaticAssociations.forEach(new InputManagerService$$ExternalSyntheticLambda4(pw));
    L5:
        Object r0 = this.mAssociationsLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mRuntimeAssociations.isEmpty() == true) goto L13;
        pw.println("Runtime Associations:");     // Catch: Throwable -> L10
        this.mRuntimeAssociations.forEach(new InputManagerService$$ExternalSyntheticLambda5(pw));     // Catch: Throwable -> L10
    L13:
        if (this.mUniqueIdAssociationsByPort.isEmpty() == true) goto L16;
        pw.println("Unique Id Associations:");     // Catch: Throwable -> L10
        this.mUniqueIdAssociationsByPort.forEach(new InputManagerService$$ExternalSyntheticLambda6(pw));     // Catch: Throwable -> L10
    L16:
        if (this.mUniqueIdAssociationsByDescriptor.isEmpty() == true) goto L19;
        pw.println("Unique Id Associations:");     // Catch: Throwable -> L10
        this.mUniqueIdAssociationsByDescriptor.forEach(new InputManagerService$$ExternalSyntheticLambda7(pw));     // Catch: Throwable -> L10
    L19:
        if (this.mDeviceTypeAssociations.isEmpty() == true) goto L21;
        pw.println("Type Associations:");     // Catch: Throwable -> L10
        this.mDeviceTypeAssociations.forEach(new InputManagerService$$ExternalSyntheticLambda8(pw));     // Catch: Throwable -> L10
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    private static /* synthetic */ void lambda$dumpAssociations$3(IndentingPrintWriter pw, String k, Integer v) {
        pw.print("  port: " + k);
        pw.println("  display: " + v);
    }

    private static /* synthetic */ void lambda$dumpAssociations$4(IndentingPrintWriter pw, String k, Integer v) {
        pw.print("  port: " + k);
        pw.println("  display: " + v);
    }

    private static /* synthetic */ void lambda$dumpAssociations$5(IndentingPrintWriter pw, String k, String v) {
        pw.print("  port: " + k);
        pw.println("  uniqueId: " + v);
    }

    private static /* synthetic */ void lambda$dumpAssociations$6(IndentingPrintWriter pw, String k, String v) {
        pw.print("  descriptor: " + k);
        pw.println("  uniqueId: " + v);
    }

    private static /* synthetic */ void lambda$dumpAssociations$7(IndentingPrintWriter pw, String k, String v) {
        pw.print("  port: " + k);
        pw.println("  type: " + v);
    }

    private void dumpKeyRemapper(IndentingPrintWriter pw) {
        pw.println("KeyRemapper:" + this.mKeyRemapper.toString());
    }

    private void dumpSpyWindowGestureMonitors(IndentingPrintWriter pw) {
        Map<IBinder, GestureMonitorSpyWindow> r0 = this.mInputMonitors;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mInputMonitors.isEmpty() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        pw.println("Gesture Monitors (implemented as spy windows):");     // Catch: Throwable -> L8
        int i = 0;
        Iterator<GestureMonitorSpyWindow> r2 = this.mInputMonitors.values().iterator();     // Catch: Throwable -> L8
    L12:
        if (r2.hasNext() == false) goto L14;
        GestureMonitorSpyWindow monitor = r2.next();     // Catch: Throwable -> L8
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L8
        r4.append("  ");     // Catch: Throwable -> L8
        int i2 = i + 1;     // Catch: Throwable -> L8
        r4.append(i);     // Catch: Throwable -> L8
        r4.append(": ");     // Catch: Throwable -> L8
        pw.append(r4.toString()).println(monitor.dump());     // Catch: Throwable -> L8
        i = i2;
        goto L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void dumpDisplayInputPropertiesValues(IndentingPrintWriter pw) {
        Object r0 = this.mAdditionalDisplayInputPropertiesLock;
        monitor-enter(r0);
        pw.println("mAdditionalDisplayInputProperties:");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
    L13:
        th = move-exception;
        pw.decreaseIndent();     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L6:
        if (this.mAdditionalDisplayInputProperties.size() != 0) goto L15;
        pw.println("<none>");     // Catch: Throwable -> L13
        pw.decreaseIndent();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L15:
        int i = 0;
    L17:
        if (i >= this.mAdditionalDisplayInputProperties.size()) goto L21;
        pw.println("displayId: " + this.mAdditionalDisplayInputProperties.keyAt(i));     // Catch: Throwable -> L13
        AdditionalDisplayInputProperties properties = this.mAdditionalDisplayInputProperties.valueAt(i);     // Catch: Throwable -> L13
        pw.println("mouseScalingEnabled: " + properties.mouseScalingEnabled);     // Catch: Throwable -> L13
        pw.println("pointerIconVisible: " + properties.pointerIconVisible);     // Catch: Throwable -> L13
        i = i + 1;
        goto L17
    L21:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private boolean checkCallingPermission(String permission, String func) {
        return checkCallingPermission(permission, func, false);
    }

    private boolean checkCallingPermission(String permission, String func, boolean checkInstrumentationSource) {
        if (Binder.getCallingPid() != Process.myPid()) goto L6;
        return true;
    L6:
        if (this.mContext.checkCallingPermission(permission) != 0) goto L8;
        return true;
    L8:
        if (checkInstrumentationSource == false) goto L20;
        ActivityManagerInternal ami = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        ami.getClass();
        int instrumentationUid = ami.getInstrumentationSourceUid(Binder.getCallingUid());
        if (instrumentationUid == (-1)) goto L20;
        long token = Binder.clearCallingIdentity();
        if (this.mContext.checkPermission(permission, -1, instrumentationUid) != 0) goto L16;
        Binder.restoreCallingIdentity(token);
        return true;
    L16:
        Binder.restoreCallingIdentity(token);
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L20:
        String msg = "Permission Denial: " + func + " from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " requires " + permission;
        Slog.w(TAG, msg);
        return false;
    }

    @Override // com.android.server.Watchdog.Monitor
    public void monitor() {
        Object r0 = this.mInputFilterLock;
        monitor-enter(r0);
        monitor-exit(r0);     // Catch: Throwable -> L31
        Object r1 = this.mAssociationsLock;
        monitor-enter(r1);
        monitor-exit(r1);     // Catch: Throwable -> L28
        Object r2 = this.mLidSwitchLock;
        monitor-enter(r2);
        monitor-exit(r2);     // Catch: Throwable -> L25
        Map<IBinder, GestureMonitorSpyWindow> r3 = this.mInputMonitors;
        monitor-enter(r3);
        monitor-exit(r3);     // Catch: Throwable -> L22
        Object r4 = this.mAdditionalDisplayInputPropertiesLock;
        monitor-enter(r4);
        monitor-exit(r4);     // Catch: Throwable -> L19
        this.mBatteryController.monitor();
        this.mPointerIconCache.monitor();
        long start = Process.getCpuClocks();
        this.mNative.monitor();
        long end = Process.getCpuClocks();
        SysMonitorSvcBridge.getFactory().getAnrMonitor().notifyInputFlingerTime(end - start);
        return;
    L19:
        th = move-exception;
        throw th;
    L22:
        th = move-exception;
        throw th;
    L25:
        th = move-exception;
        throw th;
    L28:
        th = move-exception;
        throw th;
    L31:
        th = move-exception;
        throw th;
    }

    private void notifyInputDevicesChanged(InputDevice[] inputDevices) {
        Object r0 = this.mInputDevicesLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mInputDevicesChangedPending == true) goto L9;
        this.mInputDevicesChangedPending = true;     // Catch: Throwable -> L7
        this.mHandler.obtainMessage(1, this.mInputDevices).sendToTarget();     // Catch: Throwable -> L7
    L9:
        this.mInputDevices = inputDevices;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        this.mWindowManagerCallbacks.notifyConfigurationChanged();
    }

    private void notifyTouchpadHardwareState(TouchpadHardwareState hardwareStates, int deviceId) {
        if (this.mTouchpadDebugViewController == null) goto L6;
        this.mTouchpadDebugViewController.updateTouchpadHardwareState(hardwareStates, deviceId);
        return;
    }

    private void notifyTouchpadGestureInfo(int type, int deviceId) {
        if (this.mTouchpadDebugViewController == null) goto L6;
        this.mTouchpadDebugViewController.updateTouchpadGestureInfo(type, deviceId);
        return;
    }

    private void notifyTouchpadThreeFingerTap() {
        this.mKeyGestureController.handleTouchpadGesture(1);
    }

    private void notifySwitch(long whenNanos, int switchValues, int switchMask) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "notifySwitch: values=" + Integer.toHexString(switchValues) + ", mask=" + Integer.toHexString(switchMask));
    L5:
        boolean micMute = false;
        if ((switchMask & 1) == 0) goto L26;
        if ((switchValues & 1) != 0) goto L10;
        boolean lidOpen = true;
    L11:
        Object r3 = this.mLidSwitchLock;
        monitor-enter(r3);
    L19:
        th = move-exception;
        throw th;
    L14:
        if (this.mSystemReady == false) goto L21;
        int i = 0;
    L17:
        if (i >= this.mLidSwitchCallbacks.size()) goto L21;
        InputManagerInternal.LidSwitchCallback callbacks = this.mLidSwitchCallbacks.get(i);     // Catch: Throwable -> L19
        callbacks.notifyLidSwitchChanged(whenNanos, lidOpen);     // Catch: Throwable -> L19
        i = i + 1;     // Catch: Throwable -> L19
    L21:
        monitor-exit(r3);     // Catch: Throwable -> L19
        goto L26
    L10:
        lidOpen = false;
    L26:
        if ((switchMask & 512) != 0) goto L28;
    L32:
        boolean lensCovered = this.mUseDevInputEventForAudioJack;
        if (lensCovered == false) goto L38;
        if ((switchMask & 212) == 0) goto L38;
        this.mWiredAccessoryCallbacks.notifyWiredAccessoryChanged(whenNanos, switchValues, switchMask);
    L38:
        if ((switchMask & 2) == 0) goto L45;
        SomeArgs args = SomeArgs.obtain();
        args.argi1 = (int) ((-1) & whenNanos);
        args.argi2 = (int) (whenNanos >> 32);
        if ((switchValues & 2) == 0) goto L42;
        boolean r4 = true;
    L43:
        args.arg1 = Boolean.valueOf(r4);
        this.mHandler.obtainMessage(3, args).sendToTarget();
        goto L45
    L42:
        r4 = false;
    L45:
        if ((switchMask & 16384) != 0) goto L47;
        return;
    L47:
        if ((switchValues & 16384) == 0) goto L49;
        micMute = true;
    L49:
        AudioManager audioManager = (AudioManager) this.mContext.getSystemService(AudioManager.class);
        audioManager.setMicrophoneMuteFromSwitch(micMute);
        setSensorPrivacy(1, micMute);
        return;
    L28:
        if ((switchValues & 512) == 0) goto L30;
        boolean lensCovered2 = true;
    L31:
        this.mWindowManagerCallbacks.notifyCameraLensCoverSwitchChanged(whenNanos, lensCovered2);
        setSensorPrivacy(2, lensCovered2);
        goto L32
    L30:
        lensCovered2 = false;
        goto L31
    }

    private void setSensorPrivacy(int sensor, boolean enablePrivacy) {
        SensorPrivacyManagerInternal sensorPrivacyManagerInternal = (SensorPrivacyManagerInternal) LocalServices.getService(SensorPrivacyManagerInternal.class);
        sensorPrivacyManagerInternal.setPhysicalToggleSensorPrivacy(-2, sensor, enablePrivacy);
    }

    private void notifyInputChannelBroken(IBinder token) {
        Map<IBinder, GestureMonitorSpyWindow> r0 = this.mInputMonitors;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mInputMonitors.containsKey(token) == false) goto L9;
        removeSpyWindowGestureMonitor(token);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        this.mWindowManagerCallbacks.notifyInputChannelBroken(token);
    }

    private void notifyFocusChanged(IBinder oldToken, IBinder newToken) {
        this.mWindowManagerCallbacks.notifyFocusChanged(oldToken, newToken);
    }

    private void notifyDropWindow(IBinder token, float x, float y) {
        this.mWindowManagerCallbacks.notifyDropWindow(token, x, y);
    }

    private void notifyNoFocusedWindowAnr(InputApplicationHandle inputApplicationHandle, String reason) {
        this.mWindowManagerCallbacks.notifyNoFocusedWindowAnr(inputApplicationHandle, reason);
    }

    private void notifyWindowUnresponsive(IBinder token, int pid, boolean isPidValid, String reason) {
        WindowManagerCallbacks r0 = this.mWindowManagerCallbacks;
        if (isPidValid == false) goto L5;
        OptionalInt r1 = OptionalInt.of(pid);
    L6:
        r0.notifyWindowUnresponsive(token, r1, reason);
        return;
    L5:
        r1 = OptionalInt.empty();
        goto L6
    }

    private void notifyWindowResponsive(IBinder token, int pid, boolean isPidValid) {
        WindowManagerCallbacks r0 = this.mWindowManagerCallbacks;
        if (isPidValid == false) goto L5;
        OptionalInt r1 = OptionalInt.of(pid);
    L6:
        r0.notifyWindowResponsive(token, r1);
        return;
    L5:
        r1 = OptionalInt.empty();
        goto L6
    }

    private void notifySensorEvent(int deviceId, int sensorType, int accuracy, long timestamp, float[] values) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "notifySensorEvent: deviceId=" + deviceId + " sensorType=" + sensorType + " values=" + Arrays.toString(values));
    L5:
        this.mSensorEventListenersToNotify.clear();
        Object r1 = this.mSensorEventLock;
        monitor-enter(r1);
        int numListeners = this.mSensorEventListeners.size();     // Catch: Throwable -> L10
        int i = 0;
    L8:
        if (i >= numListeners) goto L13;
        this.mSensorEventListenersToNotify.add(this.mSensorEventListeners.valueAt(i));     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L8
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L10
        int i2 = 0;
    L15:
        if (i2 >= numListeners) goto L17;
        this.mSensorEventListenersToNotify.get(i2).notifySensorEvent(deviceId, sensorType, accuracy, timestamp, values);
        i2 = i2 + 1;
        goto L15
    L17:
        this.mSensorEventListenersToNotify.clear();
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void notifySensorAccuracy(int deviceId, int sensorType, int accuracy) {
        this.mSensorAccuracyListenersToNotify.clear();
        Object r0 = this.mSensorEventLock;
        monitor-enter(r0);
        int numListeners = this.mSensorEventListeners.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= numListeners) goto L10;
        this.mSensorAccuracyListenersToNotify.add(this.mSensorEventListeners.valueAt(i));     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        int i2 = 0;
    L12:
        if (i2 >= numListeners) goto L14;
        this.mSensorAccuracyListenersToNotify.get(i2).notifySensorAccuracy(deviceId, sensorType, accuracy);
        i2 = i2 + 1;
        goto L12
    L14:
        this.mSensorAccuracyListenersToNotify.clear();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    final boolean filterInputEvent(InputEvent event, int policyFlags) {
        Object r0 = this.mInputFilterLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mInputFilter != null) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L8
        event.recycle();
        return true;
    L19:
        this.mInputFilter.filterInputEvent(event, policyFlags);     // Catch: Throwable -> L8 RemoteException -> L10
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    }

    public boolean registerKeyEventActivityListener(IKeyEventActivityListener listener) {
        super.registerKeyEventActivityListener_enforcePermission();
        listener.getClass();
        return registerKeyEventActivityListenerInternal(listener);
    }

    public boolean unregisterKeyEventActivityListener(IKeyEventActivityListener listener) {
        super.unregisterKeyEventActivityListener_enforcePermission();
        listener.getClass();
        return unregisterKeyEventActivityListenerInternal(listener);
    }

    private boolean registerKeyEventActivityListenerInternal(IKeyEventActivityListener listener) {
        Object r0 = this.mKeyEventActivityLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mKeyEventActivityListenersToNotify.contains(listener) == true) goto L12;
        this.mKeyEventActivityListenersToNotify.add(listener);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return true;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return false;
    }

    private boolean unregisterKeyEventActivityListenerInternal(final IKeyEventActivityListener listener) {
        Object r0 = this.mKeyEventActivityLock;
        monitor-enter(r0);
        boolean r1 = this.mKeyEventActivityListenersToNotify.removeIf(new InputManagerService$$ExternalSyntheticLambda9(listener));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$unregisterKeyEventActivityListenerInternal$8(IKeyEventActivityListener listener, IKeyEventActivityListener existingListener) {
        if (existingListener.asBinder() != listener.asBinder()) goto L5;
        return true;
    L5:
        return false;
    }

    private void notifyKeyActivityListeners(KeyEvent event) {
        SystemClock.uptimeMillis();
    }

    final float[] filterPointerMotion(float dx, float dy, float currentX, float currentY, int displayId) {
        Object r1 = this.mAccessibilityPointerMotionFilterLock;
        monitor-enter(r1);
    L11:
        th = move-exception;
        Throwable r9 = th;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L11
        throw r9;
    L13:
        th = move-exception;
        r9 = th;
        goto L17
    L5:
        if (this.mAccessibilityPointerMotionFilter == null) goto L16;
        float[] r10 = this.mAccessibilityPointerMotionFilter.filterPointerMotionEvent(dx, dy, currentX, currentY, displayId);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return r10;
    L16:
        throw new IllegalStateException("filterCursor is invoked but no callback is registered.");     // Catch: Throwable -> L11
    }

    public int interceptKeyBeforeQueueing(KeyEvent event, int policyFlags) {
        notifyKeyActivityListeners(event);
        Object r0 = this.mFocusEventDebugViewLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mFocusEventDebugView == null) goto L9;
        this.mFocusEventDebugView.reportKeyEvent(event);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return this.mWindowManagerCallbacks.interceptKeyBeforeQueueing(event, policyFlags);
    }

    private int interceptMotionBeforeQueueingNonInteractive(int displayId, int source, int action, long whenNanos, int policyFlags) {
        return this.mWindowManagerCallbacks.interceptMotionBeforeQueueingNonInteractive(displayId, source, action, whenNanos, policyFlags);
    }

    long interceptKeyBeforeDispatching(IBinder focus, KeyEvent event, int policyFlags) {
        if (event.isMetaPressed() == true) goto L7;
        if (KeyEvent.isMetaKey(event.getKeyCode()) == true) goto L7;
    L10:
        if (0 != 0) goto L14;
        long value = this.mWindowManagerCallbacks.interceptKeyBeforeDispatching(focus, event, policyFlags);
        return value;
    L14:
        return 0;
    L7:
        if (shouldInterceptShortcuts(focus) == false) goto L10;
        return 0;
    }

    private boolean shouldInterceptShortcuts(IBinder focusedToken) {
        KeyInterceptionInfo info = this.mWindowManagerInternal.getKeyInterceptionInfoFromToken(focusedToken);
        if (info != null) goto L5;
    L7:
        boolean hasInterceptWindowFlag = false;
    L8:
        if (hasInterceptWindowFlag == true) goto L10;
        return false;
    L10:
        if (PermissionChecker.checkPermissionForDataDelivery(this.mContext, "android.permission.OVERRIDE_SYSTEM_KEY_BEHAVIOR_IN_FOCUSED_WINDOW", -1, info.windowOwnerUid, null, null, null) == 0) goto L12;
        return false;
    L12:
        return true;
    L5:
        if ((info.layoutParamsPrivateFlags & 8388608) == 0) goto L7;
        hasInterceptWindowFlag = true;
        goto L8
    }

    private KeyEvent dispatchUnhandledKey(IBinder focus, KeyEvent event, int policyFlags) {
        if (interceptUnhandledKey(event, focus) == false) goto L6;
        return null;
    L6:
        if ((event.getFlags() & 1024) == 0) goto L8;
        return null;
    L8:
        KeyCharacterMap kcm = event.getKeyCharacterMap();
        int keyCode = event.getKeyCode();
        int metaState = event.getMetaState();
        if (event.getAction() == 0) goto L11;
    L13:
        boolean initialDown = false;
    L15:
        if (initialDown == false) goto L17;
        KeyCharacterMap.FallbackAction fallbackAction = kcm.getFallbackAction(keyCode, metaState);
    L18:
        if (fallbackAction != null) goto L20;
        return null;
    L20:
        int flags = event.getFlags() | 1024;
        KeyEvent fallbackEvent = KeyEvent.obtain(event.getDownTime(), event.getEventTime(), event.getAction(), fallbackAction.keyCode, event.getRepeatCount(), fallbackAction.metaState, event.getDeviceId(), event.getScanCode(), flags, event.getSource(), event.getDisplayId(), null);
        if (interceptFallback(focus, fallbackEvent, policyFlags) == true) goto L23;
        fallbackEvent.recycle();
        fallbackEvent = null;
    L23:
        if (initialDown == false) goto L26;
        this.mFallbackActions.put(keyCode, fallbackAction);
    L28:
        return fallbackEvent;
    L26:
        if (event.getAction() != 1) goto L28;
        this.mFallbackActions.remove(keyCode);
        fallbackAction.recycle();
        goto L28
    L17:
        fallbackAction = this.mFallbackActions.get(keyCode);
        goto L18
    L11:
        if (event.getRepeatCount() != 0) goto L13;
        initialDown = true;
        goto L15
    }

    private boolean interceptFallback(IBinder focusedToken, KeyEvent fallbackEvent, int policyFlags) {
        int actions = interceptKeyBeforeQueueing(fallbackEvent, policyFlags);
        if ((actions & 1) != 0) goto L5;
        return false;
    L5:
        long delayMillis = interceptKeyBeforeDispatching(focusedToken, fallbackEvent, policyFlags);
        if (delayMillis == 0) goto L8;
        return false;
    L8:
        if (interceptUnhandledKey(fallbackEvent, focusedToken) == true) goto L12;
        return true;
    L12:
        return false;
    }

    private boolean interceptUnhandledKey(KeyEvent event, IBinder focus) {
        return this.mWindowManagerCallbacks.interceptUnhandledKey(event, focus);
    }

    private void initKeyGestures() {
        InputManager im = (InputManager) this.mContext.getSystemService(InputManager.class);
        im.getClass();
        List<Integer> supportedGestures = List.of(15, 16, 17, 25, 65, 67, 64, 66);
        im.registerKeyGestureEventHandler(supportedGestures, new InputManagerService$$ExternalSyntheticLambda2(this));
    }

    private /* synthetic */ void lambda$initKeyGestures$9(KeyGestureEvent event, IBinder focusedToken) {
        handleKeyGestureEvent(event);
    }

    void handleKeyGestureEvent(KeyGestureEvent event) {
        int deviceId = event.getDeviceId();
        int r3 = 0;
        if (event.getAction() == 2) goto L5;
    L7:
        boolean complete = false;
    L9:
        switch(event.getKeyGestureType()) {
            case 15: goto L34;
            case 16: goto L32;
            case 17: goto L52;
            case 25: goto L29;
            case 64: goto L27;
            case 65: goto L21;
            case 66: goto L15;
            case 67: goto L11;
            default: goto L10;
        };
    L10:
        Log.w(TAG, "Received a key gesture " + event + " that was not registered by this handler");
        return;
    L11:
        if (complete == true) goto L13;
        return;
    L13:
        if (InputSettings.isAccessibilityMouseKeysFeatureFlagEnabled() == false) goto L39;
        boolean mouseKeysEnabled = InputSettings.isAccessibilityMouseKeysEnabled(this.mContext);
        InputSettings.setAccessibilityMouseKeysEnabled(this.mContext, !mouseKeysEnabled);
        return;
    L39:
        return;
    L15:
        if (complete == false) goto L41;
        boolean slowKeysEnabled = InputSettings.isAccessibilitySlowKeysEnabled(this.mContext);
        Context r5 = this.mContext;
        if (slowKeysEnabled == true) goto L20;
        r3 = 500;
    L20:
        InputSettings.setAccessibilitySlowKeysThreshold(r5, r3);
        return;
    L41:
        return;
    L21:
        if (complete == false) goto L43;
        boolean bounceKeysEnabled = InputSettings.isAccessibilityBounceKeysEnabled(this.mContext);
        Context r6 = this.mContext;
        if (bounceKeysEnabled == true) goto L26;
        r3 = 500;
    L26:
        InputSettings.setAccessibilityBounceKeysThreshold(r6, r3);
        return;
    L43:
        return;
    L27:
        if (complete == false) goto L45;
        boolean stickyKeysEnabled = InputSettings.isAccessibilityStickyKeysEnabled(this.mContext);
        InputSettings.setAccessibilityStickyKeysEnabled(this.mContext, !stickyKeysEnabled);
        return;
    L45:
        return;
    L29:
        if (complete == false) goto L47;
        this.mNative.toggleCapsLock(deviceId);
        return;
    L47:
        return;
    L32:
        if (complete == false) goto L49;
        this.mKeyboardBacklightController.decrementKeyboardBacklight(deviceId);
        return;
    L49:
        return;
    L34:
        if (complete == false) goto L51;
        this.mKeyboardBacklightController.incrementKeyboardBacklight(deviceId);
        return;
    L51:
        return;
    L52:
        return;
    L5:
        if (event.isCancelled() == true) goto L7;
        complete = true;
        goto L9
    }

    private void onPointerDownOutsideFocus(IBinder touchedToken) {
        this.mWindowManagerCallbacks.onPointerDownOutsideFocus(touchedToken);
    }

    private int getVirtualKeyQuietTimeMillis() {
        return this.mContext.getResources().getInteger(R.integer.db_wal_truncate_size);
    }

    private static String[] getExcludedDeviceNames() {
        List<String> names = new ArrayList();
        File[] baseDirs = {Environment.getRootDirectory(), Environment.getVendorDirectory()};
        int r2 = baseDirs.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L22;
        File baseDir = baseDirs[r4];
        File confFile = new File(baseDir, EXCLUDED_DEVICES_PATH);
        InputStream stream = new FileInputStream(confFile);     // Catch: Exception -> L9 FileNotFoundException -> L11
        names.addAll(ConfigurationProcessor.processExcludedDeviceNames(stream));     // Catch: Throwable -> L13
        stream.close();     // Catch: Exception -> L9 FileNotFoundException -> L11
    L13:
        th = move-exception;
        stream.close();     // Catch: Throwable -> L16
    L18:
        throw th;     // Catch: Exception -> L9 FileNotFoundException -> L11
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L9 FileNotFoundException -> L11
    L9:
        e = move-exception;
        Slog.e(TAG, "Could not parse '" + confFile.getAbsolutePath() + "'", e);
    L20:
        r4 = r4 + 1;
        goto L3
    L22:
        return (String[]) names.toArray(new String[0]);
    }

    private boolean isPerDisplayTouchModeEnabled() {
        return this.mContext.getResources().getBoolean(R.bool.config_perDisplayFocusEnabled);
    }

    private void notifyStylusGestureStarted(int deviceId, long eventTime) {
        this.mBatteryController.notifyStylusGestureStarted(deviceId, eventTime);
        if (this.mDisplayManagerInternal == null) goto L6;
        this.mDisplayManagerInternal.stylusGestureStarted(eventTime);
        return;
    }

    private static <T> String[] flatten(Map<String, T> map) {
        final List<String> list = new ArrayList(map.size() * 2);
        map.forEach(new InputManagerService$$ExternalSyntheticLambda11(list));
        return (String[]) list.toArray(new String[0]);
    }

    private static /* synthetic */ void lambda$flatten$10(List list, String k, Object v) {
        list.add(k);
        list.add(v.toString());
    }

    private static Map<String, Integer> loadStaticInputPortAssociations() {
        File baseDir = Environment.getOdmDirectory();
        File confFile = new File(baseDir, PORT_ASSOCIATIONS_PATH);
        if (confFile.exists() == true) goto L27;
        File baseDir2 = Environment.getVendorDirectory();
        confFile = new File(baseDir2, PORT_ASSOCIATIONS_PATH);
    L27:
        InputStream stream = new FileInputStream(confFile);     // Catch: Exception -> L9 FileNotFoundException -> L11
        Map<String, Integer> r3 = ConfigurationProcessor.processInputPortAssociations(stream);     // Catch: Throwable -> L13
        stream.close();     // Catch: Exception -> L9 FileNotFoundException -> L11
        return r3;
    L13:
        th = move-exception;
        stream.close();     // Catch: Throwable -> L16
    L18:
        throw th;     // Catch: Exception -> L9 FileNotFoundException -> L11
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L9 FileNotFoundException -> L11
    L9:
        e = move-exception;
        Slog.e(TAG, "Could not parse '" + confFile.getAbsolutePath() + "'", e);
    L22:
        return new HashMap();
    }

    private String[] getInputPortAssociations() {
        Map<String, Integer> associations = new HashMap(this.mStaticAssociations);
        Object r1 = this.mAssociationsLock;
        monitor-enter(r1);
        associations.putAll(this.mRuntimeAssociations);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return flatten(associations);
    L8:
        th = move-exception;
        throw th;
    }

    private String[] getInputUniqueIdAssociationsByPort() {
        Object r0 = this.mAssociationsLock;
        monitor-enter(r0);
        Map<String, String> associations = new HashMap(this.mUniqueIdAssociationsByPort);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return flatten(associations);
    L8:
        th = move-exception;
        throw th;
    }

    private String[] getInputUniqueIdAssociationsByDescriptor() {
        Object r0 = this.mAssociationsLock;
        monitor-enter(r0);
        Map<String, String> associations = new HashMap(this.mUniqueIdAssociationsByDescriptor);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return flatten(associations);
    L8:
        th = move-exception;
        throw th;
    }

    String[] getDeviceTypeAssociations() {
        Object r0 = this.mAssociationsLock;
        monitor-enter(r0);
        Map<String, String> associations = new HashMap(this.mDeviceTypeAssociations);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return flatten(associations);
    L8:
        th = move-exception;
        throw th;
    }

    private String[] getKeyboardLayoutAssociations() {
        Map<String, String> configs = new ArrayMap();
        Object r1 = this.mAssociationsLock;
        monitor-enter(r1);
        configs.putAll(this.mKeyboardLayoutAssociations);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return flatten(configs);
    L8:
        th = move-exception;
        throw th;
    }

    public boolean canDispatchToDisplay(int deviceId, int displayId) {
        return this.mNative.canDispatchToDisplay(deviceId, displayId);
    }

    private int getHoverTapTimeout() {
        return ViewConfiguration.getHoverTapTimeout();
    }

    private int getHoverTapSlop() {
        return ViewConfiguration.getHoverTapSlop();
    }

    private int getDoubleTapTimeout() {
        return ViewConfiguration.getDoubleTapTimeout();
    }

    private int getLongPressTimeout() {
        return ViewConfiguration.getLongPressTimeout();
    }

    private int getPointerLayer() {
        return this.mWindowManagerCallbacks.getPointerLayer();
    }

    private PointerIcon getLoadedPointerIcon(int displayId, int type) {
        return this.mPointerIconCache.getLoadedPointerIcon(displayId, type);
    }

    private long getParentSurfaceForPointers(int displayId) {
        SurfaceControl sc = this.mWindowManagerCallbacks.getParentSurfaceForPointers(displayId);
        if (sc != null) goto L7;
        return 0;
    L7:
        return sc.mNativeObject;
    }

    private String[] getKeyboardLayoutOverlay(InputDeviceIdentifier identifier, String languageTag, String layoutType) {
        if (this.mSystemReady == true) goto L7;
        return null;
    L7:
        return this.mKeyboardLayoutManager.getKeyboardLayoutOverlay(identifier, languageTag, layoutType);
    }

    public void remapModifierKey(int fromKey, int toKey) {
        super.remapModifierKey_enforcePermission();
        this.mKeyRemapper.remapKey(fromKey, toKey);
    }

    public void clearAllModifierKeyRemappings() {
        super.clearAllModifierKeyRemappings_enforcePermission();
        this.mKeyRemapper.clearAllKeyRemappings();
    }

    public Map<Integer, Integer> getModifierKeyRemapping() {
        super.getModifierKeyRemapping_enforcePermission();
        return this.mKeyRemapper.getKeyRemapping();
    }

    private String getDeviceAlias(String uniqueId) {
        if (BluetoothAdapter.checkBluetoothAddress(uniqueId) == false) goto L5;
        return null;
    L5:
        return null;
    }

    private void notifyBoostRefreshRate(int displayId, int state) {
        SysOptBridge.getFactory().getDynamicRefreshRateService().onInputEventReceivedBeforeDispatch(displayId, state);
    }

    private void notifyInputInfoTrans(int displayId) {
        SysOptBridge.getFactory().getInputInfoTransService().notifyInputInfoTrans(displayId);
    }

    public void registerStickyModifierStateListener(IStickyModifierStateListener listener) {
        super.registerStickyModifierStateListener_enforcePermission();
        listener.getClass();
        this.mStickyModifierStateController.registerStickyModifierStateListener(listener, Binder.getCallingPid());
    }

    public void unregisterStickyModifierStateListener(IStickyModifierStateListener listener) {
        super.unregisterStickyModifierStateListener_enforcePermission();
        listener.getClass();
        this.mStickyModifierStateController.unregisterStickyModifierStateListener(listener, Binder.getCallingPid());
    }

    void notifyStickyModifierStateChanged(int modifierState, int lockedModifierState) {
        this.mStickyModifierStateController.notifyStickyModifierStateChanged(modifierState, lockedModifierState);
    }

    private void enforceManageKeyGesturePermission() {
        String systemUIPackage = this.mContext.getString(R.string.config_systemUi);
        PackageManagerInternal pm = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        if (pm == null) goto L8;
        int systemUIAppId = UserHandle.getAppId(pm.getPackageUid(systemUIPackage, DeviceStorageMonitorServiceSmtEx.TrafficStats.MB_IN_BYTES, 0));
        if (UserHandle.getCallingAppId() != systemUIAppId) goto L8;
        return;
    L8:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MANAGE_KEY_GESTURES") != 0) goto L11;
        return;
    L11:
        throw new SecurityException("Managing Key Gestures requires the following permission: android.permission.MANAGE_KEY_GESTURES");
    }

    public void registerKeyGestureEventListener(IKeyGestureEventListener listener) {
        enforceManageKeyGesturePermission();
        listener.getClass();
        this.mKeyGestureController.registerKeyGestureEventListener(listener, Binder.getCallingPid());
    }

    public void unregisterKeyGestureEventListener(IKeyGestureEventListener listener) {
        enforceManageKeyGesturePermission();
        listener.getClass();
        this.mKeyGestureController.unregisterKeyGestureEventListener(listener, Binder.getCallingPid());
    }

    public void registerKeyGestureHandler(int[] keyGesturesToHandle, IKeyGestureHandler handler) {
        enforceManageKeyGesturePermission();
        handler.getClass();
        keyGesturesToHandle.getClass();
        this.mKeyGestureController.registerKeyGestureHandler(keyGesturesToHandle, handler, Binder.getCallingPid());
    }

    public void unregisterKeyGestureHandler(IKeyGestureHandler handler) {
        enforceManageKeyGesturePermission();
        handler.getClass();
        this.mKeyGestureController.unregisterKeyGestureHandler(handler, Binder.getCallingPid());
    }

    public AidlInputGestureData getInputGesture(int userId, AidlInputGestureData.Trigger trigger) {
        enforceManageKeyGesturePermission();
        trigger.getClass();
        return this.mKeyGestureController.getInputGesture(userId, trigger);
    }

    public int addCustomInputGesture(int userId, AidlInputGestureData inputGestureData) {
        enforceManageKeyGesturePermission();
        inputGestureData.getClass();
        return this.mKeyGestureController.addCustomInputGesture(userId, inputGestureData);
    }

    public int removeCustomInputGesture(int userId, AidlInputGestureData inputGestureData) {
        enforceManageKeyGesturePermission();
        inputGestureData.getClass();
        return this.mKeyGestureController.removeCustomInputGesture(userId, inputGestureData);
    }

    public void removeAllCustomInputGestures(int userId, int tag) {
        enforceManageKeyGesturePermission();
        this.mKeyGestureController.removeAllCustomInputGestures(userId, InputGestureData.Filter.of(tag));
    }

    public AidlInputGestureData[] getCustomInputGestures(int userId, int tag) {
        return this.mKeyGestureController.getCustomInputGestures(userId, InputGestureData.Filter.of(tag));
    }

    public AidlInputGestureData[] getAppLaunchBookmarks() {
        return this.mKeyGestureController.getAppLaunchBookmarks();
    }

    public void resetLockedModifierState() {
        this.mNative.resetLockedModifierState();
    }

    private void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "onUserSwitching from=" + from + " to=" + to);
    L5:
        this.mHandler.obtainMessage(4, Integer.valueOf(to.getUserIdentifier())).sendToTarget();
    }

    private void handleCurrentUserChanged(int userId) {
        this.mKeyGestureController.setCurrentUserId(userId);
    }

    private void onSensorEventListenerDied(int pid) {
        Object r0 = this.mSensorEventLock;
        monitor-enter(r0);
        this.mSensorEventListeners.remove(pid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        new InputShellCommand().exec(this, in, out, err, args, callback, resultReceiver);
    }

    private void updateAdditionalDisplayInputProperties(int displayId, Consumer<AdditionalDisplayInputProperties> updater) {
        Object r0 = this.mAdditionalDisplayInputPropertiesLock;
        monitor-enter(r0);
        AdditionalDisplayInputProperties properties = this.mAdditionalDisplayInputProperties.get(displayId);     // Catch: Throwable -> L7
        if (properties != null) goto L9;
        properties = new AdditionalDisplayInputProperties();     // Catch: Throwable -> L7
        this.mAdditionalDisplayInputProperties.put(displayId, properties);     // Catch: Throwable -> L7
    L9:
        boolean oldPointerIconVisible = properties.pointerIconVisible;     // Catch: Throwable -> L7
        boolean oldMouseScalingEnabled = properties.mouseScalingEnabled;     // Catch: Throwable -> L7
        updater.accept(properties);     // Catch: Throwable -> L7
        if (oldPointerIconVisible == properties.pointerIconVisible) goto L13;
        this.mNative.setPointerIconVisibility(displayId, properties.pointerIconVisible);     // Catch: Throwable -> L7
    L13:
        if (oldMouseScalingEnabled == properties.mouseScalingEnabled) goto L16;
        this.mNative.setMouseScalingEnabled(displayId, properties.mouseScalingEnabled);     // Catch: Throwable -> L7
    L16:
        if (properties.allDefaults() == false) goto L18;
        this.mAdditionalDisplayInputProperties.remove(displayId);     // Catch: Throwable -> L7
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void updateTouchpadVisualizerEnabled(boolean enabled) {
        this.mNative.setShouldNotifyTouchpadHardwareState(enabled);
        if (this.mTouchpadDebugViewController == null) goto L6;
        this.mTouchpadDebugViewController.updateTouchpadVisualizerEnabled(enabled);
        return;
    }

    void updatePointerLocationEnabled(boolean enabled) {
        this.mWindowManagerCallbacks.notifyPointerLocationChanged(enabled);
    }

    public void togglePowerAndAiKey(boolean enable) {
    }

    void updateShowKeyPresses(boolean enabled) {
        if (this.mShowKeyPresses != enabled) goto L5;
        return;
    L5:
        this.mShowKeyPresses = enabled;
        updateFocusEventDebugViewEnabled();
        Object r0 = this.mFocusEventDebugViewLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mFocusEventDebugView == null) goto L12;
        this.mFocusEventDebugView.updateShowKeyPresses(enabled);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    void updateShowRotaryInput(boolean enabled) {
        if (this.mShowRotaryInput != enabled) goto L5;
        return;
    L5:
        this.mShowRotaryInput = enabled;
        updateFocusEventDebugViewEnabled();
        Object r0 = this.mFocusEventDebugViewLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mFocusEventDebugView == null) goto L12;
        this.mFocusEventDebugView.updateShowRotaryInput(enabled);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    private void updateFocusEventDebugViewEnabled() {
        if (this.mShowKeyPresses == false) goto L5;
    L8:
        boolean enabled = true;
    L9:
        Object r3 = this.mFocusEventDebugViewLock;
        monitor-enter(r3);
    L18:
        th = move-exception;
        throw th;
    L12:
        if (this.mFocusEventDebugView == null) goto L14;
        boolean r4 = true;
    L15:
        if (enabled != r4) goto L20;
        monitor-exit(r3);     // Catch: Throwable -> L18
        return;
    L20:
        if (enabled == false) goto L22;
        this.mFocusEventDebugView = new FocusEventDebugView(this.mContext, this);     // Catch: Throwable -> L18
        FocusEventDebugView view = this.mFocusEventDebugView;     // Catch: Throwable -> L18
    L23:
        monitor-exit(r3);     // Catch: Throwable -> L18
        view.getClass();
        WindowManager wm = (WindowManager) this.mContext.getSystemService(WindowManager.class);
        wm.getClass();
        if (enabled == true) goto L28;
        wm.removeView(view);
        return;
    L28:
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.type = 2015;
        lp.flags = FrameworkStatsLog.TV_CAS_SESSION_OPEN_STATUS;
        lp.privateFlags |= 16;
        lp.setFitInsetsTypes(0);
        lp.layoutInDisplayCutoutMode = 3;
        lp.format = -3;
        lp.setTitle("FocusEventDebugView - display " + this.mContext.getDisplayId());
        lp.inputFeatures = 1 | lp.inputFeatures;
        wm.addView(view, lp);
        return;
    L22:
        view = this.mFocusEventDebugView;     // Catch: Throwable -> L18
        this.mFocusEventDebugView = null;     // Catch: Throwable -> L18
        goto L23
    L14:
        r4 = false;
        goto L15
    L5:
        if (this.mShowRotaryInput == true) goto L8;
        enabled = false;
        goto L9
    }

    public void setAccessibilityBounceKeysThreshold(int thresholdTimeMs) {
        this.mNative.setAccessibilityBounceKeysThreshold(thresholdTimeMs);
    }

    public void setAccessibilitySlowKeysThreshold(int thresholdTimeMs) {
        this.mNative.setAccessibilitySlowKeysThreshold(thresholdTimeMs);
    }

    public void setAccessibilityStickyKeysEnabled(boolean enabled) {
        this.mNative.setAccessibilityStickyKeysEnabled(enabled);
    }

    void setUseLargePointerIcons(boolean useLargeIcons) {
        this.mPointerIconCache.setUseLargePointerIcons(useLargeIcons);
    }

    void setPointerFillStyle(int fillStyle) {
        this.mPointerIconCache.setPointerFillStyle(fillStyle);
    }

    void setPointerStrokeStyle(int strokeStyle) {
        this.mPointerIconCache.setPointerStrokeStyle(strokeStyle);
    }

    void setPointerScale(float scale) {
        this.mPointerIconCache.setPointerScale(scale);
    }

    void setAccessibilityPointerIconScaleFactor(int displayId, float scaleFactor) {
        this.mPointerIconCache.setAccessibilityScaleFactor(displayId, scaleFactor);
    }

    void registerAccessibilityPointerMotionFilter(InputManagerInternal.AccessibilityPointerMotionFilter filter) {
        this.mNative.setAccessibilityPointerMotionFilterEnabled(false);
        Object r0 = this.mAccessibilityPointerMotionFilterLock;
        monitor-enter(r0);
        this.mAccessibilityPointerMotionFilter = filter;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (filter == null) goto L14;
        this.mNative.setAccessibilityPointerMotionFilterEnabled(true);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public IObricInputManager getIObricExt() {
        return this.mObricExt.getIObricExt();
    }
}
