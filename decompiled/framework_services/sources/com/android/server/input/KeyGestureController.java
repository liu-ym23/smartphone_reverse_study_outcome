package com.android.server.input;

import android.R;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.hardware.display.DisplayManager;
import android.hardware.input.AidlInputGestureData;
import android.hardware.input.AidlKeyGestureEvent;
import android.hardware.input.AppLaunchData;
import android.hardware.input.IKeyGestureEventListener;
import android.hardware.input.IKeyGestureHandler;
import android.hardware.input.InputGestureData;
import android.hardware.input.InputManager;
import android.hardware.input.InputSettings;
import android.hardware.input.KeyGestureEvent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserManager;
import android.provider.Settings;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.android.internal.accessibility.AccessibilityShortcutController;
import com.android.internal.policy.IShortcutService;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.LocalServices;
import com.android.server.pm.UserManagerInternal;
import com.android.server.policy.KeyCombinationManager;
import com.android.server.usb.descriptors.UsbACInterface;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
final class KeyGestureController {
    private static final boolean DEBUG = false;
    private static final int LAST_SEARCH_KEY_BEHAVIOR = 1;
    private static final int LAST_SETTINGS_KEY_BEHAVIOR = 2;
    private static final int MAX_TRACKED_EVENTS = 10;
    private static final int MSG_ACCESSIBILITY_SHORTCUT = 4;
    private static final int MSG_LOAD_CUSTOM_GESTURES = 3;
    private static final int MSG_NOTIFY_KEY_GESTURE_EVENT = 1;
    private static final int MSG_PERSIST_CUSTOM_GESTURES = 2;
    static final int POWER_VOLUME_UP_BEHAVIOR_GLOBAL_ACTIONS = 2;
    static final int POWER_VOLUME_UP_BEHAVIOR_MUTE = 1;
    static final int POWER_VOLUME_UP_BEHAVIOR_NOTHING = 0;
    private static final int SEARCH_KEY_BEHAVIOR_DEFAULT_SEARCH = 0;
    private static final int SEARCH_KEY_BEHAVIOR_TARGET_ACTIVITY = 1;
    private static final int SETTINGS_KEY_BEHAVIOR_NOTHING = 2;
    private static final int SETTINGS_KEY_BEHAVIOR_NOTIFICATION_PANEL = 1;
    private static final int SETTINGS_KEY_BEHAVIOR_SETTINGS_ACTIVITY = 0;
    private static final int SHORTCUT_META_MASK = 69635;
    private static final String TAG = "KeyGestureController";
    private static final Object mUserLock = null;
    final AccessibilityShortcutController mAccessibilityShortcutController;
    private final AppLaunchShortcutManager mAppLaunchShortcutManager;
    private final SparseArray<Set<Integer>> mConsumedKeysForDevice;
    private final Context mContext;
    private int mCurrentUserId;
    private final DisplayManager mDisplayManager;
    private final Handler mHandler;
    private boolean mHasFeatureLeanback;
    private boolean mHasFeatureWatch;
    private final InputDataStore mInputDataStore;
    private final InputGestureManager mInputGestureManager;
    private final Handler mIoHandler;
    private final KeyCombinationManager mKeyCombinationManager;
    private final SparseArray<KeyGestureEventListenerRecord> mKeyGestureEventListenerRecords;
    private final SparseArray<KeyGestureHandlerRecord> mKeyGestureHandlerRecords;
    private final ArrayDeque<KeyGestureEvent> mLastHandledEvents;
    private boolean mPendingCapsLockToggle;
    private boolean mPendingHideRecentSwitcher;
    private boolean mPendingMetaAction;
    private int mPowerVolUpBehavior;
    private int mRingerToggleChord;
    private int mSearchKeyBehavior;
    private int mSettingsKeyBehavior;
    private final SettingsObserver mSettingsObserver;
    private final SparseIntArray mSupportedKeyGestureToPidMap;
    private final int mSystemPid;
    private final UserManagerInternal mUserManagerInternal;
    private final boolean mVisibleBackgroundUsersEnabled;
    private InputManagerService.WindowManagerCallbacks mWindowManagerCallbacks;

    static class Injector {
        Injector() {
        }

        AccessibilityShortcutController getAccessibilityShortcutController(Context context, Handler handler) {
            return new AccessibilityShortcutController(context, handler, 0);
        }
    }

    private class KeyGestureEventListenerRecord implements IBinder.DeathRecipient {
        public final IKeyGestureEventListener mListener;
        public final int mPid;
        final /* synthetic */ KeyGestureController this$0;

        KeyGestureEventListenerRecord(KeyGestureController r1, int pid, IKeyGestureEventListener listener) {
            this.this$0 = r1;
            this.mPid = pid;
            this.mListener = listener;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (KeyGestureController.m4556$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.d(KeyGestureController.TAG, "Key gesture event listener for pid " + this.mPid + " died.");
        L5:
            KeyGestureController.m4554$$Nest$monKeyGestureEventListenerDied(this.this$0, this.mPid);
        }

        public void onKeyGestureEvent(AidlKeyGestureEvent event) {
            this.mListener.onKeyGestureEvent(event);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.w(KeyGestureController.TAG, "Failed to notify process " + this.mPid + " that key gesture event occurred, assuming it died.", ex);
            binderDied();
        }
    }

    private class KeyGestureHandlerRecord implements IBinder.DeathRecipient {
        public final IKeyGestureHandler mKeyGestureHandler;
        public final int mPid;
        final /* synthetic */ KeyGestureController this$0;

        KeyGestureHandlerRecord(KeyGestureController r1, int pid, IKeyGestureHandler keyGestureHandler) {
            this.this$0 = r1;
            this.mPid = pid;
            this.mKeyGestureHandler = keyGestureHandler;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (KeyGestureController.m4556$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.d(KeyGestureController.TAG, "Key gesture event handler for pid " + this.mPid + " died.");
        L5:
            KeyGestureController.m4555$$Nest$monKeyGestureHandlerRemoved(this.this$0, this.mPid);
        }

        public void handleKeyGesture(AidlKeyGestureEvent event, IBinder focusedToken) {
            this.mKeyGestureHandler.handleKeyGesture(event, focusedToken);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.w(KeyGestureController.TAG, "Failed to send key gesture to process " + this.mPid + ", assuming it died.", ex);
            binderDied();
        }
    }

    private class SettingsObserver extends ContentObserver {
        final /* synthetic */ KeyGestureController this$0;

        /* JADX INFO: renamed from: -$$Nest$mobserve, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4557$$Nest$mobserve(SettingsObserver r0) {
            r0.observe();
        }

        /* synthetic */ SettingsObserver(KeyGestureController r1, Handler r2, KeyGestureControllerIA r3) {
            this(r1, r2);
        }

        private SettingsObserver(KeyGestureController r1, Handler handler) {
            this.this$0 = r1;
            super(handler);
        }

        private void observe() {
            ContentResolver resolver = KeyGestureController.m4548$$Nest$fgetmContext(this.this$0).getContentResolver();
            resolver.registerContentObserver(Settings.Secure.getUriFor("volume_hush_gesture"), false, this, -1);
            resolver.registerContentObserver(Settings.Global.getUriFor("key_chord_power_volume_up"), false, this, -1);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            KeyGestureController.m4553$$Nest$minitBehaviorsFromSettings(this.this$0);
        }
    }

    public static /* synthetic */ boolean $r8$lambda$4PRjtj8OHRdlnwn5_WqXshoVPTQ(KeyGestureController r0, Message r1) {
        return r0.handleMessage(r1);
    }

    public static /* synthetic */ void $r8$lambda$Sf1Es3TGUz0CYGsl4UYFi8RH0Fw(KeyGestureController r0, KeyGestureEvent r1, IBinder r2) {
        r0.lambda$initKeyGestures$0(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$SkZtDf-juTn1Sesg7AZpQ5YVzto, reason: not valid java name */
    public static /* synthetic */ void m4547$r8$lambda$SkZtDfjuTn1Sesg7AZpQ5YVzto(KeyGestureController r0) {
        r0.initBehaviorsFromSettings();
    }

    public static /* synthetic */ boolean $r8$lambda$mbUjwi2JsgUBPoJ0pQ_Q0JJY3EI(KeyGestureController r0, Message r1) {
        return r0.handleIoMessage(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m4548$$Nest$fgetmContext(KeyGestureController r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerVolUpBehavior, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4549$$Nest$fgetmPowerVolUpBehavior(KeyGestureController r0) {
        return r0.mPowerVolUpBehavior;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRingerToggleChord, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4550$$Nest$fgetmRingerToggleChord(KeyGestureController r0) {
        return r0.mRingerToggleChord;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowManagerCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ InputManagerService.WindowManagerCallbacks m4551$$Nest$fgetmWindowManagerCallbacks(KeyGestureController r0) {
        return r0.mWindowManagerCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleMultiKeyGesture, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4552$$Nest$mhandleMultiKeyGesture(KeyGestureController r0, int[] r1, int r2, int r3, int r4) {
        r0.handleMultiKeyGesture(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$minitBehaviorsFromSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4553$$Nest$minitBehaviorsFromSettings(KeyGestureController r0) {
        r0.initBehaviorsFromSettings();
    }

    /* JADX INFO: renamed from: -$$Nest$monKeyGestureEventListenerDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4554$$Nest$monKeyGestureEventListenerDied(KeyGestureController r0, int r1) {
        r0.onKeyGestureEventListenerDied(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monKeyGestureHandlerRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4555$$Nest$monKeyGestureHandlerRemoved(KeyGestureController r0, int r1) {
        r0.onKeyGestureHandlerRemoved(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4556$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        mUserLock = new Object();
    }

    public KeyGestureController(Context context, Looper looper, Looper ioLooper, InputDataStore inputDataStore) {
        this(context, looper, ioLooper, inputDataStore, new Injector());
    }

    KeyGestureController(Context context, Looper looper, Looper ioLooper, InputDataStore inputDataStore, Injector injector) {
        this.mCurrentUserId = 0;
        this.mRingerToggleChord = 0;
        this.mKeyGestureEventListenerRecords = new SparseArray();
        this.mKeyGestureHandlerRecords = new SparseArray();
        this.mSupportedKeyGestureToPidMap = new SparseIntArray();
        this.mLastHandledEvents = new ArrayDeque();
        this.mConsumedKeysForDevice = new SparseArray();
        this.mVisibleBackgroundUsersEnabled = UserManager.isVisibleBackgroundUsersEnabled();
        this.mContext = context;
        this.mHandler = new Handler(looper, new KeyGestureController$$ExternalSyntheticLambda0(this));
        this.mIoHandler = new Handler(ioLooper, new KeyGestureController$$ExternalSyntheticLambda1(this));
        this.mSystemPid = Process.myPid();
        this.mKeyCombinationManager = new KeyCombinationManager(this.mHandler);
        this.mSettingsObserver = new SettingsObserver(this, this.mHandler, null);
        this.mAppLaunchShortcutManager = new AppLaunchShortcutManager(this.mContext);
        this.mInputGestureManager = new InputGestureManager(this.mContext);
        this.mAccessibilityShortcutController = injector.getAccessibilityShortcutController(this.mContext, this.mHandler);
        DisplayManager r0 = (DisplayManager) this.mContext.getSystemService(DisplayManager.class);
        r0.getClass();
        this.mDisplayManager = r0;
        this.mInputDataStore = inputDataStore;
        this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        initBehaviors();
        initKeyCombinationRules();
    }

    private void initBehaviors() {
        PackageManager pm = this.mContext.getPackageManager();
        this.mHasFeatureWatch = pm.hasSystemFeature("android.hardware.type.watch");
        this.mHasFeatureLeanback = pm.hasSystemFeature("android.software.leanback");
        Resources res = this.mContext.getResources();
        this.mSearchKeyBehavior = res.getInteger(R.integer.config_soundEffectVolumeDb);
        if (this.mSearchKeyBehavior >= 0) goto L5;
    L6:
        this.mSearchKeyBehavior = 0;
    L7:
        this.mSettingsKeyBehavior = res.getInteger(R.integer.config_stableDeviceDisplayWidth);
        if (this.mSettingsKeyBehavior >= 0) goto L10;
    L11:
        this.mSettingsKeyBehavior = 0;
    L12:
        this.mHandler.post(new KeyGestureController$$ExternalSyntheticLambda2(this));
        return;
    L10:
        if (this.mSettingsKeyBehavior <= 2) goto L12;
    L5:
        if (this.mSearchKeyBehavior <= 1) goto L7;
        goto L6
    }

    private void initBehaviorsFromSettings() {
        ContentResolver resolver = this.mContext.getContentResolver();
        this.mRingerToggleChord = Settings.Secure.getIntForUser(resolver, "volume_hush_gesture", 0, -2);
        this.mPowerVolUpBehavior = Settings.Global.getInt(resolver, "key_chord_power_volume_up", this.mContext.getResources().getInteger(R.integer.config_lockSoundVolumeDb));
    }

    private void initKeyCombinationRules() {
        if (InputSettings.doesKeyGestureEventHandlerSupportMultiKeyGestures() == true) goto L5;
        return;
    L5:
        boolean screenshotChordEnabled = this.mContext.getResources().getBoolean(R.bool.config_enableTelephonyTimeZoneDetection);
        final int r1 = 25;
        final int r2 = 26;
        if (screenshotChordEnabled == false) goto L10;
        this.mKeyCombinationManager.addRule(new AnonymousClass1(this, r1, r2));
        if (this.mHasFeatureWatch == false) goto L10;
        final int r5 = 264;
        this.mKeyCombinationManager.addRule(new AnonymousClass2(this, r2, r5));
    L10:
        final int r6 = 24;
        this.mKeyCombinationManager.addRule(new AnonymousClass3(this, r1, r6));
        this.mKeyCombinationManager.addRule(new AnonymousClass4(this, r6, r2));
        if (this.mHasFeatureLeanback == false) goto L14;
        final int r3 = 20;
        final int r4 = 4;
        this.mKeyCombinationManager.addRule(new AnonymousClass5(this, r4, r3));
        final int r7 = 23;
        this.mKeyCombinationManager.addRule(new AnonymousClass6(this, r4, r7));
        return;
    }

    public void systemRunning() {
        SettingsObserver.m4557$$Nest$mobserve(this.mSettingsObserver);
        this.mAppLaunchShortcutManager.init();
        this.mInputGestureManager.init(this.mAppLaunchShortcutManager.getBookmarks());
        initKeyGestures();
        Object r0 = mUserLock;
        monitor-enter(r0);
        int userId = this.mCurrentUserId;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mIoHandler.obtainMessage(3, Integer.valueOf(userId)).sendToTarget();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void initKeyGestures() {
        InputManager im = (InputManager) this.mContext.getSystemService(InputManager.class);
        im.getClass();
        im.registerKeyGestureEventHandler(List.of(55), new KeyGestureController$$ExternalSyntheticLambda3(this));
    }

    private /* synthetic */ void lambda$initKeyGestures$0(KeyGestureEvent event, IBinder focusedToken) {
        if (event.getKeyGestureType() == 55) goto L5;
        Log.w(TAG, "Received a key gesture " + event + " that was not registered by this handler");
        return;
    L5:
        if (event.getAction() != 1) goto L7;
        this.mHandler.removeMessages(4);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(4), getAccessibilityShortcutTimeout());
        return;
    L7:
        this.mHandler.removeMessages(4);
    }

    public boolean interceptKeyBeforeQueueing(KeyEvent event, int policyFlags) {
        boolean r1 = false;
        if (this.mVisibleBackgroundUsersEnabled == false) goto L8;
        if (shouldIgnoreKeyEventForVisibleBackgroundUser(event) == false) goto L8;
        return false;
    L8:
        if (InputSettings.doesKeyGestureEventHandlerSupportMultiKeyGestures() == true) goto L10;
    L21:
        return false;
    L10:
        if ((event.getFlags() & 1024) != 0) goto L21;
        if ((536870912 & policyFlags) == 0) goto L14;
        boolean interactive = true;
    L15:
        boolean isDefaultDisplayOn = isDefaultDisplayOn();
        KeyCombinationManager r4 = this.mKeyCombinationManager;
        if (interactive == false) goto L20;
        if (isDefaultDisplayOn == false) goto L20;
        r1 = true;
    L20:
        return r4.interceptKey(event, r1);
    L14:
        interactive = false;
        goto L15
    }

    private boolean shouldIgnoreKeyEventForVisibleBackgroundUser(KeyEvent event) {
        int displayAssignedUserId = this.mUserManagerInternal.getUserAssignedToDisplay(event.getDisplayId());
        Object r1 = mUserLock;
        monitor-enter(r1);
        int currentUserId = this.mCurrentUserId;     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        if (currentUserId != displayAssignedUserId) goto L8;
        return false;
    L8:
        if (KeyEvent.isVisibleBackgroundUserAllowedKey(event.getKeyCode()) == false) goto L10;
        return false;
    L10:
        if (DEBUG == false) goto L21;
        Slog.w(TAG, "Ignored key event [" + event + "] for visible background user [" + displayAssignedUserId + "]");
        return true;
    L21:
        return true;
    L16:
        th = move-exception;
        throw th;
    }

    public long interceptKeyBeforeDispatching(IBinder focusedToken, KeyEvent event, int policyFlags) {
        int keyCode = event.getKeyCode();
        int deviceId = event.getDeviceId();
        int flags = event.getFlags();
        if (InputSettings.doesKeyGestureEventHandlerSupportMultiKeyGestures() == false) goto L13;
        KeyEvent r11 = event;
        if (this.mKeyCombinationManager.isKeyConsumed(r11) == false) goto L8;
        return -1;
    L8:
        if ((flags & 1024) != 0) goto L14;
        long now = SystemClock.uptimeMillis();
        long interceptTimeout = this.mKeyCombinationManager.getKeyInterceptTimeout(keyCode);
        if (now >= interceptTimeout) goto L14;
        return interceptTimeout - now;
    L14:
        Set<Integer> consumedKeys = this.mConsumedKeysForDevice.get(deviceId);
        if (consumedKeys != null) goto L18;
        consumedKeys = new HashSet();
        this.mConsumedKeysForDevice.put(deviceId, consumedKeys);
    L18:
        if (interceptSystemKeysAndShortcuts(focusedToken, event) == true) goto L20;
    L25:
        boolean needToConsumeKey = consumedKeys.contains(Integer.valueOf(keyCode));
        if (r11.getAction() != 1) goto L28;
    L29:
        consumedKeys.remove(Integer.valueOf(keyCode));
        if (consumedKeys.isEmpty() == false) goto L32;
        this.mConsumedKeysForDevice.remove(deviceId);
    L32:
        if (needToConsumeKey == true) goto L36;
        return 0;
    L36:
        return -1;
    L28:
        if (r11.isCanceled() == false) goto L32;
    L20:
        if (r11.getAction() != 0) goto L25;
        if (r11.getRepeatCount() != 0) goto L25;
        consumedKeys.add(Integer.valueOf(keyCode));
        return -1;
    L13:
        r11 = event;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean interceptSystemKeysAndShortcuts(IBinder r21, KeyEvent r22) {
        int r12 = r22.getKeyCode();
        int r13 = r22.getRepeatCount();
        int r4 = r22.getMetaState() & SHORTCUT_META_MASK;
        if (r22.getAction() != 0) goto L5;
        Object[] r0 = true;
    L6:
        Object[] r15 = r0;
        boolean r16 = r22.isCanceled();
        int r7 = r22.getDisplayId();
        int r2 = r22.getDeviceId();
        if (r15 == false) goto L10;
        if (r13 != 0) goto L10;
        Object[] r1 = true;
    L11:
        Object[] r17 = r1;
        if (this.mPendingMetaAction == false) goto L17;
        if (KeyEvent.isMetaKey(r12) == true) goto L17;
        this.mPendingMetaAction = false;
    L17:
        if (this.mPendingCapsLockToggle == true) goto L19;
    L23:
        AppLaunchShortcutManager.InterceptKeyResult r18 = this.mAppLaunchShortcutManager.interceptKey(r22);
        if (r18.consumed() == false) goto L27;
        return true;
    L27:
        if (r18.appLaunchData() == null) goto L30;
        handleKeyGesture(r2, new int[]{r12}, r4, 51, 2, r7, r21, 0, r18.appLaunchData());
        return true;
    L30:
        if (r17 == false) goto L38;
        InputGestureData r3 = this.mInputGestureManager.getSystemShortcutForKeyEvent(r22);
        if (r3 == null) goto L38;
        handleKeyGesture(r2, new int[]{r12}, r4, r3.getAction().keyGestureType(), 2, r7, r21, 0, r3.getAction().appLaunchData());
        return true;
    L38:
        switch(r12) {
            case 57: goto L144;
            case 58: goto L144;
            case 61: goto L132;
            case 83: goto L128;
            case 84: goto L122;
            case 115: goto L118;
            case 117: goto L104;
            case 118: goto L104;
            case 176: goto L93;
            case 187: goto L86;
            case 204: goto L83;
            case 219: goto L81;
            case 220: goto L74;
            case 221: goto L74;
            case 231: goto L72;
            case 284: goto L69;
            case 305: goto L66;
            case 306: goto L63;
            case 307: goto L60;
            case 308: goto L58;
            case 309: goto L58;
            case 310: goto L58;
            case 311: goto L58;
            case 312: goto L55;
            case 318: goto L52;
            case 322: goto L49;
            case 324: goto L45;
            case 325: goto L41;
            default: goto L39;
        };
    L39:
        KeyGestureController r5 = this;
    L159:
        if (r5.mAppLaunchShortcutManager.handleShortcutService(r22) == false) goto L161;
        return true;
    L161:
        if (r17 == false) goto L176;
        Object r6 = mUserLock;
        monitor-enter(r6);
        InputGestureData r8 = r5.mInputGestureManager.getCustomGestureForKeyEvent(r5.mCurrentUserId, r22);     // Catch: Throwable -> L170
        monitor-exit(r6);     // Catch: Throwable -> L170
        if (r8 != null) goto L168;
        return false;
    L168:
        r5.handleKeyGesture(r2, new int[]{r12}, r4, r8.getAction().keyGestureType(), 2, r7, r21, 0, r8.getAction().appLaunchData());
        return true;
    L170:
        th = th;
    L179:
        throw th;
    L174:
        th = th;
        goto L179
    L176:
        return false;
    L52:
        if (r17 == false) goto L54;
        handleKeyGesture(r2, new int[]{r12}, 0, 10, 2, r7, r21, 0, null);
    L54:
        return true;
    L55:
        if (r17 == false) goto L57;
        handleKeyGesture(r2, new int[]{r12}, 0, 2, 2, r7, r21, 0, null);
    L57:
        return true;
    L58:
        Slog.wtf(TAG, "KEYCODE_STYLUS_BUTTON_* should be handled in interceptKeyBeforeQueueing");
        return true;
    L60:
        if (r15 == true) goto L62;
        handleKeyGesture(r2, new int[]{r12}, 0, 17, 2, r7, r21, 0, null);
    L62:
        return true;
    L63:
        if (r15 == false) goto L65;
        handleKeyGesture(r2, new int[]{r12}, 0, 15, 2, r7, r21, 0, null);
    L65:
        return true;
    L66:
        if (r15 == false) goto L68;
        handleKeyGesture(r2, new int[]{r12}, 0, 16, 2, r7, r21, 0, null);
    L68:
        return true;
    L69:
        if (r17 == false) goto L71;
        handleKeyGesture(r2, new int[]{r12}, 0, 21, 2, r7, r21, 0, null);
    L71:
        return true;
    L72:
        Slog.wtf(TAG, "KEYCODE_VOICE_ASSIST should be handled in interceptKeyBeforeQueueing");
        return true;
    L74:
        if (r15 == false) goto L80;
        int[] r9 = {r12};
        if (r12 != 221) goto L78;
        int r10 = 13;
    L79:
        handleKeyGesture(r2, r9, 0, r10, 2, r7, r21, 0, null);
        goto L80
    L78:
        r10 = 14;
    L80:
        return true;
    L81:
        Slog.wtf(TAG, "KEYCODE_ASSIST should be handled in interceptKeyBeforeQueueing");
        return true;
    L83:
        if (r17 == false) goto L85;
        handleKeyGesture(r2, new int[]{r12}, r22.isShiftPressed() ? 1 : 0, 23, 2, r7, r21, 0, null);
    L85:
        return true;
    L86:
        if (r17 == false) goto L88;
        handleKeyGesture(r2, new int[]{r12}, 0, 4, 1, r7, r21, 0, null);
    L91:
        return true;
    L88:
        if (r15 == true) goto L91;
        handleKeyGesture(r2, new int[]{r12}, 0, 4, 2, r7, r21, r16 ? 1 : 0, null);
        goto L91
    L118:
        if (r15 == true) goto L120;
        r5 = this;
        r5.mHandler.sendMessage(Message.obtain(r5.mHandler, 1, r5.createKeyGestureEvent(r2, new int[]{r12}, r4, 25, 2, r7, 0, null)));
        goto L159
    L120:
        r5 = this;
        goto L159
    L128:
        if (r15 == true) goto L131;
        handleKeyGesture(r2, new int[]{r12}, 0, 8, 2, r7, r21, 0, null);
    L131:
        return true;
    L132:
        r5 = this;
        if (r17 == true) goto L135;
        r2 = r2;
        goto L159
    L135:
        if (r5.mPendingHideRecentSwitcher == false) goto L137;
        r2 = r2;
        goto L159
    L137:
        if (KeyEvent.metaStateHasModifiers(r22.getModifiers() & (-194), 2) == false) goto L140;
        r5.mPendingHideRecentSwitcher = true;
        r5.handleKeyGesture(r2, new int[]{r12}, 2, 54, 1, r7, r21, 0, null);
        return true;
    L140:
        r2 = r2;
        goto L159
    L41:
        if (r17 == false) goto L43;
        handleKeyGesture(r2, new int[]{325}, 0, 53, 2, r7, r21, 0, null);
    L43:
        return true;
    L45:
        if (r17 == false) goto L47;
        handleKeyGesture(r2, new int[]{FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_ACTIVE_DEVICE_ADMIN}, 0, 32, 2, r7, r21, 0, null);
    L47:
        return true;
    L49:
        if (r17 == false) goto L51;
        handleKeyGesture(r2, new int[]{322}, 0, 75, 2, r7, r21, 0, null);
    L51:
        return true;
    L93:
        if (r17 == false) goto L102;
        if (this.mSettingsKeyBehavior != 0) goto L98;
        handleKeyGesture(r2, new int[]{r12}, 0, 7, 2, r7, r21, 0, null);
        goto L102
    L98:
        if (this.mSettingsKeyBehavior != 1) goto L102;
        handleKeyGesture(r2, new int[]{r12}, 0, 8, 2, r7, r21, 0, null);
    L102:
        return true;
    L104:
        if (r15 == false) goto L110;
        if (r22.isAltPressed() == false) goto L108;
        this.mPendingCapsLockToggle = true;
        this.mPendingMetaAction = false;
    L117:
        return true;
    L108:
        this.mPendingCapsLockToggle = false;
        this.mPendingMetaAction = true;
        goto L117
    L110:
        if (this.mPendingCapsLockToggle == false) goto L113;
        this.mPendingCapsLockToggle = false;
        handleKeyGesture(r2, new int[]{117, 57}, 0, 25, 2, r7, r21, 0, null);
        goto L117
    L113:
        if (this.mPendingMetaAction == false) goto L117;
        this.mPendingMetaAction = false;
        if (r16 == true) goto L117;
        handleKeyGesture(r2, new int[]{r12}, 0, 21, 2, r7, r21, 0, null);
        goto L117
    L122:
        if (r17 == true) goto L124;
    L127:
        r5 = this;
        goto L159
    L124:
        if (this.mSearchKeyBehavior != 1) goto L127;
        handleKeyGesture(r2, new int[]{r12}, 0, 22, 2, r7, r21, 0, null);
        return true;
    L144:
        if (r15 == false) goto L150;
        if (r22.isMetaPressed() == false) goto L148;
        this.mPendingCapsLockToggle = true;
        this.mPendingMetaAction = false;
        r5 = this;
        r2 = r2;
        goto L159
    L148:
        this.mPendingCapsLockToggle = false;
        r5 = this;
        r2 = r2;
        goto L159
    L150:
        if (this.mPendingHideRecentSwitcher == false) goto L154;
        this.mPendingHideRecentSwitcher = false;
        handleKeyGesture(r2, new int[]{61}, 2, 54, 2, r7, r21, 0, null);
        return true;
    L154:
        if (this.mPendingCapsLockToggle == false) goto L157;
        this.mPendingCapsLockToggle = false;
        handleKeyGesture(r2, new int[]{117, 57}, 0, 25, 2, r7, r21, 0, null);
        return true;
    L157:
        r5 = this;
        r2 = r2;
        goto L159
    L19:
        if (KeyEvent.isMetaKey(r12) == true) goto L23;
        if (KeyEvent.isAltKey(r12) == true) goto L23;
        this.mPendingCapsLockToggle = false;
    L10:
        r1 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    boolean interceptUnhandledKey(KeyEvent event, IBinder focusedToken) {
        int keyCode = event.getKeyCode();
        int repeatCount = event.getRepeatCount();
        int r3 = 1;
        if (event.getAction() != 0) goto L5;
        boolean down = true;
    L6:
        int metaState = event.getModifiers();
        int deviceId = event.getDeviceId();
        int displayId = event.getDisplayId();
        switch(keyCode) {
            case 54: goto L26;
            case 62: goto L17;
            case 111: goto L12;
            case 120: goto L9;
            default: goto L30;
        };
    L9:
        if (down == false) goto L30;
        if (repeatCount != 0) goto L30;
        handleKeyGesture(deviceId, new int[]{keyCode}, 0, 10, 2, displayId, focusedToken, 0, null);
        goto L30
    L12:
        if (down == false) goto L30;
        if (KeyEvent.metaStateHasNoModifiers(metaState) == false) goto L30;
        if (repeatCount != 0) goto L30;
        handleKeyGesture(deviceId, new int[]{keyCode}, 0, 61, 2, displayId, focusedToken, 0, null);
        goto L30
    L17:
        if (down == false) goto L30;
        if (repeatCount != 0) goto L30;
        if (KeyEvent.metaStateHasModifiers(metaState & (-194), 4096) == false) goto L30;
        int[] r6 = {keyCode};
        if (event.isShiftPressed() == true) goto L25;
        r3 = 0;
    L25:
        handleKeyGesture(deviceId, r6, r3 | 4096, 23, 2, displayId, focusedToken, 0, null);
        goto L30
    L26:
        if (down == false) goto L30;
        if (KeyEvent.metaStateHasModifiers(metaState, UsbACInterface.FORMAT_II_AC3) == false) goto L30;
        handleKeyGesture(deviceId, new int[]{keyCode}, UsbACInterface.FORMAT_II_AC3, 60, 2, displayId, focusedToken, 0, null);
    L30:
        return false;
    L5:
        down = false;
        goto L6
    }

    private void handleMultiKeyGesture(int[] keycodes, int gestureType, int action, int flags) {
        handleKeyGesture(-1, keycodes, 0, gestureType, action, 0, null, flags, null);
    }

    private void handleTouchpadGesture(int keyGestureType, AppLaunchData appLaunchData) {
        handleKeyGesture(-1, new int[0], 0, keyGestureType, 2, 0, null, 0, appLaunchData);
    }

    void handleKeyGesture(int deviceId, int[] keycodes, int modifierState, int gestureType, int action, int displayId, IBinder focusedToken, int flags, AppLaunchData appLaunchData) {
        handleKeyGesture(createKeyGestureEvent(deviceId, keycodes, modifierState, gestureType, action, displayId, flags, appLaunchData), focusedToken);
    }

    private void handleKeyGesture(AidlKeyGestureEvent event, IBinder focusedToken) {
        if (this.mVisibleBackgroundUsersEnabled == true) goto L5;
    L9:
        SparseArray<KeyGestureHandlerRecord> r0 = this.mKeyGestureHandlerRecords;
        monitor-enter(r0);
        int index = this.mSupportedKeyGestureToPidMap.indexOfKey(event.gestureType);     // Catch: Throwable -> L16
        if (index >= 0) goto L18;
        Log.i(TAG, "Key gesture: " + event.gestureType + " is not supported");     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L18:
        int pid = this.mSupportedKeyGestureToPidMap.valueAt(index);     // Catch: Throwable -> L16
        this.mKeyGestureHandlerRecords.get(pid).handleKeyGesture(event, focusedToken);     // Catch: Throwable -> L16
        Message msg = Message.obtain(this.mHandler, 1, event);     // Catch: Throwable -> L16
        this.mHandler.sendMessage(msg);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    L5:
        if (event.displayId == 0) goto L9;
        if (shouldIgnoreGestureEventForVisibleBackgroundUser(event.gestureType, event.displayId) == false) goto L9;
    }

    private boolean shouldIgnoreGestureEventForVisibleBackgroundUser(int gestureType, int displayId) {
        int displayAssignedUserId = this.mUserManagerInternal.getUserAssignedToDisplay(displayId);
        Object r1 = mUserLock;
        monitor-enter(r1);
        int currentUserId = this.mCurrentUserId;     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        if (currentUserId != displayAssignedUserId) goto L8;
        return false;
    L8:
        if (KeyGestureEvent.isVisibleBackgrounduserAllowedGesture(gestureType) == false) goto L10;
        return false;
    L10:
        if (DEBUG == false) goto L21;
        Slog.w(TAG, "Ignored gesture event [" + gestureType + "] for visible background user [" + displayAssignedUserId + "]");
        return true;
    L21:
        return true;
    L16:
        th = move-exception;
        throw th;
    }

    public void notifyKeyGestureCompleted(int deviceId, int[] keycodes, int modifierState, int gestureType) {
        AidlKeyGestureEvent event = createKeyGestureEvent(deviceId, keycodes, modifierState, gestureType, 2, 0, 0, null);
        this.mHandler.obtainMessage(1, event).sendToTarget();
    }

    public void handleKeyGesture(int deviceId, int[] keycodes, int modifierState, int gestureType) {
        AidlKeyGestureEvent event = createKeyGestureEvent(deviceId, keycodes, modifierState, gestureType, 2, 0, 0, null);
        handleKeyGesture(event, null);
    }

    public void handleTouchpadGesture(int touchpadGestureType) {
        Object r0 = mUserLock;
        monitor-enter(r0);
        InputGestureData customGesture = this.mInputGestureManager.getCustomGestureForTouchpadGesture(this.mCurrentUserId, touchpadGestureType);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (customGesture != null) goto L8;
        return;
    L8:
        handleTouchpadGesture(customGesture.getAction().keyGestureType(), customGesture.getAction().appLaunchData());
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setCurrentUserId(int userId) {
        Object r0 = mUserLock;
        monitor-enter(r0);
        this.mCurrentUserId = userId;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mAccessibilityShortcutController.setCurrentUser(userId);
        this.mIoHandler.obtainMessage(3, Integer.valueOf(userId)).sendToTarget();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void setWindowManagerCallbacks(InputManagerService.WindowManagerCallbacks callbacks) {
        this.mWindowManagerCallbacks = callbacks;
    }

    private boolean isDefaultDisplayOn() {
        Display defaultDisplay = this.mDisplayManager.getDisplay(0);
        if (defaultDisplay != null) goto L6;
        return false;
    L6:
        return Display.isOnState(defaultDisplay.getState());
    }

    private void notifyKeyGestureEvent(AidlKeyGestureEvent event) {
        InputDevice device = getInputDevice(event.deviceId);
        if (device != null) goto L5;
        return;
    L5:
        KeyGestureEvent keyGestureEvent = new KeyGestureEvent(event);
        if (event.action != 2) goto L8;
        KeyboardMetricsCollector.logKeyboardSystemsEventReportedAtom(device, event.keycodes, event.modifierState, keyGestureEvent.getLogEvent());
    L8:
        notifyAllListeners(event);
    L10:
        if (this.mLastHandledEvents.size() < 10) goto L12;
        this.mLastHandledEvents.removeFirst();
        goto L10
    L12:
        this.mLastHandledEvents.addLast(keyGestureEvent);
    }

    private void notifyAllListeners(AidlKeyGestureEvent event) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Key gesture event occurred, event = " + event);
    L5:
        SparseArray<KeyGestureEventListenerRecord> r0 = this.mKeyGestureEventListenerRecords;
        monitor-enter(r0);
        int i = 0;
    L18:
    L11:
        th = move-exception;
        throw th;
    L9:
        if (i >= this.mKeyGestureEventListenerRecords.size()) goto L14;
        this.mKeyGestureEventListenerRecords.valueAt(i).onKeyGestureEvent(event);     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L18
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    private boolean handleMessage(Message msg) {
        switch(msg.what) {
            case 1: goto L6;
            case 4: goto L5;
            default: goto L10;
        };
    L5:
        this.mAccessibilityShortcutController.performAccessibilityShortcut();
        return true;
    L6:
        AidlKeyGestureEvent event = (AidlKeyGestureEvent) msg.obj;
        notifyKeyGestureEvent(event);
        return true;
    L10:
        return true;
    }

    private boolean handleIoMessage(Message msg) {
        switch(msg.what) {
            case 2: goto L6;
            case 3: goto L5;
            default: goto L10;
        };
    L5:
        int userId = ((Integer) msg.obj).intValue();
        loadInputGestures(userId);
        return true;
    L6:
        int userId2 = ((Integer) msg.obj).intValue();
        persistInputGestures(userId2);
        return true;
    L10:
        return true;
    }

    public void registerKeyGestureEventListener(IKeyGestureEventListener listener, int pid) {
        SparseArray<KeyGestureEventListenerRecord> r0 = this.mKeyGestureEventListenerRecords;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mKeyGestureEventListenerRecords.get(pid) != null) goto L17;
        KeyGestureEventListenerRecord record = new KeyGestureEventListenerRecord(this, pid, listener);     // Catch: Throwable -> L11
        listener.asBinder().linkToDeath(record, 0);     // Catch: Throwable -> L11 RemoteException -> L13
        this.mKeyGestureEventListenerRecords.put(pid, record);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        ex = move-exception;
        throw new RuntimeException(ex);     // Catch: Throwable -> L11
    L17:
        throw new IllegalStateException("The calling process has already registered a KeyGestureEventListener.");     // Catch: Throwable -> L11
    }

    public void unregisterKeyGestureEventListener(IKeyGestureEventListener listener, int pid) {
        SparseArray<KeyGestureEventListenerRecord> r0 = this.mKeyGestureEventListenerRecords;
        monitor-enter(r0);
        KeyGestureEventListenerRecord record = this.mKeyGestureEventListenerRecords.get(pid);     // Catch: Throwable -> L11
        if (record == null) goto L16;
        if (record.mListener.asBinder() != listener.asBinder()) goto L14;
        record.mListener.asBinder().unlinkToDeath(record, 0);     // Catch: Throwable -> L11
        this.mKeyGestureEventListenerRecords.remove(pid);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L14:
        throw new IllegalStateException("The calling process has a different registered KeyGestureEventListener.");     // Catch: Throwable -> L11
    L16:
        throw new IllegalStateException("The calling process has no registered KeyGestureEventListener.");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public AidlInputGestureData getInputGesture(int userId, AidlInputGestureData.Trigger trigger) {
        InputGestureData gestureData = this.mInputGestureManager.getInputGesture(userId, InputGestureData.createTriggerFromAidlTrigger(trigger));
        if (gestureData != null) goto L7;
        return null;
    L7:
        return gestureData.getAidlData();
    }

    public int addCustomInputGesture(int userId, AidlInputGestureData inputGestureData) {
        int result = this.mInputGestureManager.addCustomInputGesture(userId, new InputGestureData(inputGestureData));
        if (result != 1) goto L5;
        this.mIoHandler.obtainMessage(2, Integer.valueOf(userId)).sendToTarget();
    L5:
        return result;
    }

    public int removeCustomInputGesture(int userId, AidlInputGestureData inputGestureData) {
        int result = this.mInputGestureManager.removeCustomInputGesture(userId, new InputGestureData(inputGestureData));
        if (result != 1) goto L5;
        this.mIoHandler.obtainMessage(2, Integer.valueOf(userId)).sendToTarget();
    L5:
        return result;
    }

    public void removeAllCustomInputGestures(int userId, InputGestureData.Filter filter) {
        this.mInputGestureManager.removeAllCustomInputGestures(userId, filter);
        this.mIoHandler.obtainMessage(2, Integer.valueOf(userId)).sendToTarget();
    }

    public AidlInputGestureData[] getCustomInputGestures(int userId, InputGestureData.Filter filter) {
        List<InputGestureData> customGestures = this.mInputGestureManager.getCustomInputGestures(userId, filter);
        AidlInputGestureData[] result = new AidlInputGestureData[customGestures.size()];
        int i = 0;
    L4:
        if (i >= customGestures.size()) goto L7;
        result[i] = customGestures.get(i).getAidlData();
        i = i + 1;
        goto L4
    L7:
        return result;
    }

    public AidlInputGestureData[] getAppLaunchBookmarks() {
        List<InputGestureData> bookmarks = this.mAppLaunchShortcutManager.getBookmarks();
        AidlInputGestureData[] result = new AidlInputGestureData[bookmarks.size()];
        int i = 0;
    L4:
        if (i >= bookmarks.size()) goto L7;
        result[i] = bookmarks.get(i).getAidlData();
        i = i + 1;
        goto L4
    L7:
        return result;
    }

    private void onKeyGestureEventListenerDied(int pid) {
        SparseArray<KeyGestureEventListenerRecord> r0 = this.mKeyGestureEventListenerRecords;
        monitor-enter(r0);
        this.mKeyGestureEventListenerRecords.remove(pid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    byte[] getInputGestureBackupPayload(int userId) throws IOException {
        List<InputGestureData> inputGestureDataList = this.mInputGestureManager.getCustomInputGestures(userId, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputDataStore r2 = this.mInputDataStore;
        monitor-enter(r2);
        this.mInputDataStore.writeInputGestureXml(byteArrayOutputStream, true, inputGestureDataList);     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        return byteArrayOutputStream.toByteArray();
    L8:
        th = move-exception;
        throw th;
    }

    void applyInputGesturesBackupPayload(byte[] payload, int userId) throws XmlPullParserException, IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(payload);
        InputDataStore r1 = this.mInputDataStore;
        monitor-enter(r1);
        List<InputGestureData> inputGestureDataList = this.mInputDataStore.readInputGesturesXml(byteArrayInputStream, true);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        Iterator<InputGestureData> r2 = inputGestureDataList.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        InputGestureData inputGestureData = r2.next();
        this.mInputGestureManager.addCustomInputGesture(userId, inputGestureData);
        goto L8
    L10:
        this.mHandler.obtainMessage(2, Integer.valueOf(userId)).sendToTarget();
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void registerKeyGestureHandler(int[] keyGesturesToHandle, IKeyGestureHandler handler, int pid) {
        SparseArray<KeyGestureHandlerRecord> r0 = this.mKeyGestureHandlerRecords;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mKeyGestureHandlerRecords.get(pid) != null) goto L31;
        if (keyGesturesToHandle.length == 0) goto L29;
        int r1 = keyGesturesToHandle.length;     // Catch: Throwable -> L15
        int r2 = 0;
        int r3 = 0;
    L9:
        if (r3 >= r1) goto L17;
        int gestureType = keyGesturesToHandle[r3];     // Catch: Throwable -> L15
        if (this.mSupportedKeyGestureToPidMap.indexOfKey(gestureType) >= 0) goto L14;
        r3 = r3 + 1;     // Catch: Throwable -> L15
        goto L9
    L14:
        throw new IllegalArgumentException("Key gesture " + gestureType + " is already registered by pid = " + this.mSupportedKeyGestureToPidMap.get(gestureType));     // Catch: Throwable -> L15
    L17:
        KeyGestureHandlerRecord record = new KeyGestureHandlerRecord(this, pid, handler);     // Catch: Throwable -> L15
        handler.asBinder().linkToDeath(record, 0);     // Catch: Throwable -> L15 RemoteException -> L25
        this.mKeyGestureHandlerRecords.put(pid, record);     // Catch: Throwable -> L15
        int r4 = keyGesturesToHandle.length;     // Catch: Throwable -> L15
    L21:
        if (r2 >= r4) goto L23;
        this.mSupportedKeyGestureToPidMap.put(keyGesturesToHandle[r2], pid);     // Catch: Throwable -> L15
        r2 = r2 + 1;     // Catch: Throwable -> L15
        goto L21
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L25:
        ex = move-exception;
        throw new RuntimeException(ex);     // Catch: Throwable -> L15
    L29:
        throw new IllegalArgumentException("No key gestures provided for pid = " + pid);     // Catch: Throwable -> L15
    L31:
        throw new IllegalStateException("The calling process has already registered a KeyGestureHandler.");     // Catch: Throwable -> L15
    }

    public void unregisterKeyGestureHandler(IKeyGestureHandler handler, int pid) {
        SparseArray<KeyGestureHandlerRecord> r0 = this.mKeyGestureHandlerRecords;
        monitor-enter(r0);
        KeyGestureHandlerRecord record = this.mKeyGestureHandlerRecords.get(pid);     // Catch: Throwable -> L11
        if (record == null) goto L16;
        if (record.mKeyGestureHandler.asBinder() != handler.asBinder()) goto L14;
        record.mKeyGestureHandler.asBinder().unlinkToDeath(record, 0);     // Catch: Throwable -> L11
        onKeyGestureHandlerRemoved(pid);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L14:
        throw new IllegalStateException("The calling process has a different registered KeyGestureHandler.");     // Catch: Throwable -> L11
    L16:
        throw new IllegalStateException("The calling process has no registered KeyGestureHandler.");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void registerShortcutKey(long shortcutCode, IShortcutService shortcutKeyReceiver) throws RemoteException {
        this.mAppLaunchShortcutManager.registerShortcutKey(shortcutCode, shortcutKeyReceiver);
    }

    public List<InputGestureData> getBookmarks() {
        return this.mAppLaunchShortcutManager.getBookmarks();
    }

    private void onKeyGestureHandlerRemoved(int pid) {
        SparseArray<KeyGestureHandlerRecord> r0 = this.mKeyGestureHandlerRecords;
        monitor-enter(r0);
        this.mKeyGestureHandlerRecords.remove(pid);     // Catch: Throwable -> L9
        int i = this.mSupportedKeyGestureToPidMap.size() - 1;     // Catch: Throwable -> L9
    L5:
        if (i < 0) goto L13;
        if (this.mSupportedKeyGestureToPidMap.valueAt(i) != pid) goto L11;
        this.mSupportedKeyGestureToPidMap.removeAt(i);     // Catch: Throwable -> L9
    L11:
        i = i - 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void persistInputGestures(int userId) {
        InputDataStore r0 = this.mInputDataStore;
        monitor-enter(r0);
        List<InputGestureData> inputGestureDataList = this.mInputGestureManager.getCustomInputGestures(userId, null);     // Catch: Throwable -> L7
        this.mInputDataStore.saveInputGestures(userId, inputGestureDataList);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void loadInputGestures(int userId) {
        InputDataStore r0 = this.mInputDataStore;
        monitor-enter(r0);
        this.mInputGestureManager.removeAllCustomInputGestures(userId, null);     // Catch: Throwable -> L8
        List<InputGestureData> inputGestureDataList = this.mInputDataStore.loadInputGestures(userId);     // Catch: Throwable -> L8
        Iterator<InputGestureData> r2 = inputGestureDataList.iterator();     // Catch: Throwable -> L8
    L6:
        if (r2.hasNext() == false) goto L10;
        InputGestureData inputGestureData = r2.next();     // Catch: Throwable -> L8
        this.mInputGestureManager.addCustomInputGesture(userId, inputGestureData);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private InputDevice getInputDevice(int deviceId) {
        InputManager inputManager = (InputManager) this.mContext.getSystemService(InputManager.class);
        if (inputManager != null) goto L7;
        return null;
    L7:
        return inputManager.getInputDevice(deviceId);
    }

    private AidlKeyGestureEvent createKeyGestureEvent(int deviceId, int[] keycodes, int modifierState, int gestureType, int action, int displayId, int flags, AppLaunchData appLaunchData) {
        AidlKeyGestureEvent event = new AidlKeyGestureEvent();
        event.deviceId = deviceId;
        event.keycodes = keycodes;
        event.modifierState = modifierState;
        event.gestureType = gestureType;
        event.action = action;
        event.displayId = displayId;
        event.flags = flags;
        if (appLaunchData != null) goto L5;
    L15:
        return event;
    L5:
        if ((appLaunchData instanceof AppLaunchData.CategoryData) == false) goto L8;
        AppLaunchData.CategoryData categoryData = (AppLaunchData.CategoryData) appLaunchData;
        event.appLaunchCategory = categoryData.getCategory();
        goto L15
    L8:
        if ((appLaunchData instanceof AppLaunchData.RoleData) == false) goto L11;
        AppLaunchData.RoleData roleData = (AppLaunchData.RoleData) appLaunchData;
        event.appLaunchRole = roleData.getRole();
        goto L15
    L11:
        if ((appLaunchData instanceof AppLaunchData.ComponentData) == false) goto L14;
        AppLaunchData.ComponentData componentData = (AppLaunchData.ComponentData) appLaunchData;
        event.appLaunchPackageName = componentData.getPackageName();
        event.appLaunchClassName = componentData.getClassName();
        goto L15
    L14:
        throw new IllegalArgumentException("AppLaunchData type is invalid!");
    }

    private long getAccessibilityShortcutTimeout() {
        Object r0 = mUserLock;
        monitor-enter(r0);
        ViewConfiguration config = ViewConfiguration.get(this.mContext);     // Catch: Throwable -> L15
        boolean skipTimeoutRestriction = false;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "accessibility_shortcut_dialog_shown", 0, this.mCurrentUserId) == 0) goto L7;
        boolean hasDialogShown = true;
    L9:
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "skip_accessibility_shortcut_dialog_timeout_restriction", 0, this.mCurrentUserId) == 0) goto L11;
        skipTimeoutRestriction = true;
    L11:
        if (hasDialogShown == true) goto L17;
        if (skipTimeoutRestriction == true) goto L17;
        long r3 = config.getAccessibilityShortcutKeyTimeout();     // Catch: Throwable -> L15
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return r3;
    L17:
        r3 = config.getAccessibilityShortcutKeyTimeoutAfterConfirmation();     // Catch: Throwable -> L15
        goto L18
    L7:
        hasDialogShown = false;
    L15:
        th = move-exception;
        throw th;
    }

    public void dump(IndentingPrintWriter ipw) {
        ipw.println("KeyGestureController:");
        ipw.increaseIndent();
        ipw.println("mCurrentUserId = " + this.mCurrentUserId);
        ipw.println("mSystemPid = " + this.mSystemPid);
        ipw.println("mPendingMetaAction = " + this.mPendingMetaAction);
        ipw.println("mPendingCapsLockToggle = " + this.mPendingCapsLockToggle);
        ipw.println("mPendingHideRecentSwitcher = " + this.mPendingHideRecentSwitcher);
        ipw.println("mSearchKeyBehavior = " + this.mSearchKeyBehavior);
        ipw.println("mSettingsKeyBehavior = " + this.mSettingsKeyBehavior);
        ipw.println("mRingerToggleChord = " + this.mRingerToggleChord);
        ipw.println("mPowerVolUpBehavior = " + this.mPowerVolUpBehavior);
        ipw.print("mKeyGestureEventListenerRecords = {");
        SparseArray<KeyGestureEventListenerRecord> r0 = this.mKeyGestureEventListenerRecords;
        monitor-enter(r0);
        int size = this.mKeyGestureEventListenerRecords.size();     // Catch: Throwable -> L9
        int i = 0;
    L5:
        if (i >= size) goto L13;
        ipw.print(this.mKeyGestureEventListenerRecords.keyAt(i));     // Catch: Throwable -> L9
        if (i >= (size - 1)) goto L11;
        ipw.print(", ");     // Catch: Throwable -> L9
    L11:
        i = i + 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        ipw.println("}");
        SparseArray<KeyGestureHandlerRecord> r1 = this.mKeyGestureHandlerRecords;
        monitor-enter(r1);
        ipw.print("mKeyGestureHandlerRecords = {");     // Catch: Throwable -> L21
        int size2 = this.mKeyGestureHandlerRecords.size();     // Catch: Throwable -> L21
        int i2 = 0;
    L17:
        if (i2 >= size2) goto L24;
        int pid = this.mKeyGestureHandlerRecords.keyAt(i2);     // Catch: Throwable -> L21
        ipw.print(pid);     // Catch: Throwable -> L21
        if (i2 >= (size2 - 1)) goto L23;
        ipw.print(", ");     // Catch: Throwable -> L21
    L23:
        i2 = i2 + 1;     // Catch: Throwable -> L21
        goto L17
    L24:
        ipw.println("}");     // Catch: Throwable -> L21
        ipw.println("mSupportedKeyGestures = " + Arrays.toString(this.mSupportedKeyGestureToPidMap.copyKeys()));     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        ipw.decreaseIndent();
        ipw.println("Last handled KeyGestureEvents: ");
        ipw.increaseIndent();
        Iterator<KeyGestureEvent> r2 = this.mLastHandledEvents.iterator();
    L28:
        if (r2.hasNext() == false) goto L30;
        KeyGestureEvent ev = r2.next();
        ipw.println(ev);
        goto L28
    L30:
        ipw.decreaseIndent();
        this.mKeyCombinationManager.dump("", ipw);
        this.mAppLaunchShortcutManager.dump(ipw);
        this.mInputGestureManager.dump(ipw);
        return;
    L21:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        throw th;
    }
}
