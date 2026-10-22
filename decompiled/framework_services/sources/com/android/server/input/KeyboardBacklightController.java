package com.android.server.input;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.hardware.input.IKeyboardBacklightListener;
import android.hardware.input.IKeyboardBacklightState;
import android.hardware.input.InputManager;
import android.hardware.lights.Light;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.sysprop.InputProperties;
import android.text.TextUtils;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.view.InputDevice;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
final class KeyboardBacklightController implements InputManagerService.KeyboardBacklightControllerInterface, InputManager.InputDeviceListener {
    private static final boolean DEBUG = false;
    static final int[] DEFAULT_BRIGHTNESS_VALUE_FOR_LEVEL = null;
    private static final int DEFAULT_NUM_BRIGHTNESS_CHANGE_STEPS = 10;
    private static final int MAX_BRIGHTNESS = 255;
    static final int MAX_BRIGHTNESS_CHANGE_STEPS = 10;
    private static final int MSG_DECREMENT_KEYBOARD_BACKLIGHT = 3;
    private static final int MSG_INCREMENT_KEYBOARD_BACKLIGHT = 2;
    private static final int MSG_INTERACTIVE_STATE_CHANGED = 6;
    private static final int MSG_NOTIFY_USER_ACTIVITY = 4;
    private static final int MSG_NOTIFY_USER_INACTIVITY = 5;
    private static final int MSG_UPDATE_EXISTING_DEVICES = 1;
    private static final String TAG = "KbdBacklightController";
    private static final long TRANSITION_ANIMATION_DURATION_MILLIS = 0;
    private int mAmbientBacklightValue;
    private final AmbientKeyboardBacklightController mAmbientController;
    private AmbientKeyboardBacklightController.AmbientKeyboardBacklightListener mAmbientListener;
    private final AnimatorFactory mAnimatorFactory;
    private final Context mContext;
    private final Handler mHandler;
    private boolean mIsBacklightOn;
    private boolean mIsInteractive;
    private final boolean mKeyboardBacklightAnimationEnabled;
    private final SparseArray<KeyboardBacklightListenerRecord> mKeyboardBacklightListenerRecords;
    private final SparseArray<KeyboardBacklightState> mKeyboardBacklights;
    private final NativeInputManagerService mNative;
    private final int mUserInactivityThresholdMs;

    interface AnimatorFactory {
        ValueAnimator makeIntAnimator(int r1, int r2);
    }

    private static final enum Direction extends Enum<Direction> {
        private static final /* synthetic */ Direction[] $VALUES = null;
        public static final Direction DIRECTION_DOWN = null;
        public static final Direction DIRECTION_UP = null;

        private static /* synthetic */ Direction[] $values() {
            return new Direction[]{DIRECTION_UP, DIRECTION_DOWN};
        }

        private Direction(String r1, int r2) {
            super(r1, r2);
        }

        public static Direction valueOf(String name) {
            return (Direction) Enum.valueOf(Direction.class, name);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }

        static {
            DIRECTION_UP = new Direction("DIRECTION_UP", 0);
            DIRECTION_DOWN = new Direction("DIRECTION_DOWN", 1);
            $VALUES = $values();
        }
    }

    private class KeyboardBacklightListenerRecord implements IBinder.DeathRecipient {
        public final IKeyboardBacklightListener mListener;
        public final int mPid;
        final /* synthetic */ KeyboardBacklightController this$0;

        KeyboardBacklightListenerRecord(KeyboardBacklightController r1, int pid, IKeyboardBacklightListener listener) {
            this.this$0 = r1;
            this.mPid = pid;
            this.mListener = listener;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (KeyboardBacklightController.m4564$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.d(KeyboardBacklightController.TAG, "Keyboard backlight listener for pid " + this.mPid + " died.");
        L5:
            KeyboardBacklightController.m4563$$Nest$monKeyboardBacklightListenerDied(this.this$0, this.mPid);
        }

        public void notifyKeyboardBacklightChanged(int deviceId, IKeyboardBacklightState state, boolean isTriggeredByKeyPress) {
            this.mListener.onBrightnessChanged(deviceId, state, isTriggeredByKeyPress);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.w(KeyboardBacklightController.TAG, "Failed to notify process " + this.mPid + " that keyboard backlight changed, assuming it died.", ex);
            binderDied();
        }
    }

    private class KeyboardBacklightState {
        private ValueAnimator mAnimator;
        private int mBrightnessLevel;
        private final int[] mBrightnessValueForLevel;
        private final int mDeviceId;
        private final Light mLight;
        private boolean mUseAmbientController;
        final /* synthetic */ KeyboardBacklightController this$0;

        /* JADX INFO: renamed from: $r8$lambda$-8QB5Z76GgocqWkA9CqVSxnW9bg, reason: not valid java name */
        public static /* synthetic */ void m4566$r8$lambda$8QB5Z76GgocqWkA9CqVSxnW9bg(KeyboardBacklightState r0, ValueAnimator r1) {
            r0.lambda$startAnimation$0(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmBrightnessLevel, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4567$$Nest$fgetmBrightnessLevel(KeyboardBacklightState r0) {
            return r0.mBrightnessLevel;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmBrightnessValueForLevel, reason: not valid java name */
        static /* bridge */ /* synthetic */ int[] m4568$$Nest$fgetmBrightnessValueForLevel(KeyboardBacklightState r0) {
            return r0.mBrightnessValueForLevel;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLight, reason: not valid java name */
        static /* bridge */ /* synthetic */ Light m4569$$Nest$fgetmLight(KeyboardBacklightState r0) {
            return r0.mLight;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUseAmbientController, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m4570$$Nest$fgetmUseAmbientController(KeyboardBacklightState r0) {
            return r0.mUseAmbientController;
        }

        /* JADX INFO: renamed from: -$$Nest$mgetNumBrightnessChangeSteps, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4571$$Nest$mgetNumBrightnessChangeSteps(KeyboardBacklightState r0) {
            return r0.getNumBrightnessChangeSteps();
        }

        /* JADX INFO: renamed from: -$$Nest$monAmbientBacklightValueChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4572$$Nest$monAmbientBacklightValueChanged(KeyboardBacklightState r0) {
            r0.onAmbientBacklightValueChanged();
        }

        /* JADX INFO: renamed from: -$$Nest$monBacklightStateChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4573$$Nest$monBacklightStateChanged(KeyboardBacklightState r0) {
            r0.onBacklightStateChanged();
        }

        /* JADX INFO: renamed from: -$$Nest$msetBrightnessLevel, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4574$$Nest$msetBrightnessLevel(KeyboardBacklightState r0, int r1) {
            r0.setBrightnessLevel(r1);
        }

        KeyboardBacklightState(KeyboardBacklightController r1, int deviceId, Light light) {
            this.this$0 = r1;
            this.mUseAmbientController = true;
            this.mDeviceId = deviceId;
            this.mLight = light;
            this.mBrightnessValueForLevel = setupBrightnessLevels();
        }

        private int[] setupBrightnessLevels() {
            int[] customLevels = this.mLight.getPreferredBrightnessLevels();
            if (customLevels == null) goto L25;
            if (customLevels.length == 0) goto L25;
            TreeSet<Integer> brightnessLevels = new TreeSet();
            int r2 = 0;
            brightnessLevels.add(0);
            int r3 = customLevels.length;
        L9:
            if (r2 >= r3) goto L15;
            int level = customLevels[r2];
            if (level <= 0) goto L14;
            if (level >= 255) goto L14;
            brightnessLevels.add(Integer.valueOf(level));
        L14:
            r2 = r2 + 1;
            goto L9
        L15:
            brightnessLevels.add(255);
            int brightnessChangeSteps = brightnessLevels.size() - 1;
            if (brightnessChangeSteps > 10) goto L18;
            int[] result = new int[brightnessLevels.size()];
            int index = 0;
            Iterator<Integer> r5 = brightnessLevels.iterator();
        L21:
            if (r5.hasNext() == false) goto L23;
            int val = r5.next().intValue();
            result[index] = val;
            index = index + 1;
            goto L21
        L23:
            return result;
        L18:
            return KeyboardBacklightController.DEFAULT_BRIGHTNESS_VALUE_FOR_LEVEL;
        L25:
            return KeyboardBacklightController.DEFAULT_BRIGHTNESS_VALUE_FOR_LEVEL;
        }

        private int getNumBrightnessChangeSteps() {
            return this.mBrightnessValueForLevel.length - 1;
        }

        private void onBacklightStateChanged() {
            if (this.mUseAmbientController == false) goto L5;
            int toValue = KeyboardBacklightController.m4558$$Nest$fgetmAmbientBacklightValue(this.this$0);
        L7:
            if (KeyboardBacklightController.m4560$$Nest$fgetmIsBacklightOn(this.this$0) == false) goto L9;
            int r1 = toValue;
        L10:
            setBacklightValue(r1);
            return;
        L9:
            r1 = 0;
            goto L10
        L5:
            toValue = this.mBrightnessValueForLevel[this.mBrightnessLevel];
            goto L7
        }

        private void setBrightnessLevel(int brightnessLevel) {
            this.mUseAmbientController = false;
            if (KeyboardBacklightController.m4560$$Nest$fgetmIsBacklightOn(this.this$0) == false) goto L5;
            setBacklightValue(this.mBrightnessValueForLevel[brightnessLevel]);
        L5:
            this.mBrightnessLevel = brightnessLevel;
        }

        private void onAmbientBacklightValueChanged() {
            if (KeyboardBacklightController.m4560$$Nest$fgetmIsBacklightOn(this.this$0) == true) goto L5;
            return;
        L5:
            if (this.mUseAmbientController == false) goto L9;
            setBacklightValue(KeyboardBacklightController.m4558$$Nest$fgetmAmbientBacklightValue(this.this$0));
            return;
        }

        private void cancelAnimation() {
            if (this.mAnimator != null) goto L5;
            return;
        L5:
            if (this.mAnimator.isRunning() == false) goto L9;
            this.mAnimator.cancel();
            return;
        }

        private void setBacklightValue(int toValue) {
            int fromValue = Color.alpha(KeyboardBacklightController.m4562$$Nest$fgetmNative(this.this$0).getLightColor(this.mDeviceId, this.mLight.getId()));
            if (fromValue != toValue) goto L6;
            return;
        L6:
            if (KeyboardBacklightController.m4561$$Nest$fgetmKeyboardBacklightAnimationEnabled(this.this$0) == false) goto L8;
            startAnimation(fromValue, toValue);
            return;
        L8:
            KeyboardBacklightController.m4562$$Nest$fgetmNative(this.this$0).setLightColor(this.mDeviceId, this.mLight.getId(), Color.argb(toValue, 0, 0, 0));
        }

        private void startAnimation(int fromValue, int toValue) {
            cancelAnimation();
            this.mAnimator = KeyboardBacklightController.m4559$$Nest$fgetmAnimatorFactory(this.this$0).makeIntAnimator(fromValue, toValue);
            this.mAnimator.addUpdateListener(new KeyboardBacklightController$KeyboardBacklightState$$ExternalSyntheticLambda0(this));
            this.mAnimator.setDuration(KeyboardBacklightController.m4565$$Nest$sfgetTRANSITION_ANIMATION_DURATION_MILLIS()).start();
        }

        private /* synthetic */ void lambda$startAnimation$0(ValueAnimator animation) {
            KeyboardBacklightController.m4562$$Nest$fgetmNative(this.this$0).setLightColor(this.mDeviceId, this.mLight.getId(), Color.argb(((Integer) animation.getAnimatedValue()).intValue(), 0, 0, 0));
        }

        public String toString() {
            return "KeyboardBacklightState{Light=" + this.mLight.getId() + ", BrightnessLevel=" + this.mBrightnessLevel + "}";
        }
    }

    public static /* synthetic */ ValueAnimator $r8$lambda$gLE2VR5qX7q5aVLtb99mO7iYb5Q(int r0, int r1) {
        return lambda$new$0(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$x56uNWQ8yZ3aSFy91aBfHRGVrXg(KeyboardBacklightController r0, Message r1) {
        return r0.handleMessage(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAmbientBacklightValue, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4558$$Nest$fgetmAmbientBacklightValue(KeyboardBacklightController r0) {
        return r0.mAmbientBacklightValue;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAnimatorFactory, reason: not valid java name */
    static /* bridge */ /* synthetic */ AnimatorFactory m4559$$Nest$fgetmAnimatorFactory(KeyboardBacklightController r0) {
        return r0.mAnimatorFactory;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsBacklightOn, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4560$$Nest$fgetmIsBacklightOn(KeyboardBacklightController r0) {
        return r0.mIsBacklightOn;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmKeyboardBacklightAnimationEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4561$$Nest$fgetmKeyboardBacklightAnimationEnabled(KeyboardBacklightController r0) {
        return r0.mKeyboardBacklightAnimationEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNative, reason: not valid java name */
    static /* bridge */ /* synthetic */ NativeInputManagerService m4562$$Nest$fgetmNative(KeyboardBacklightController r0) {
        return r0.mNative;
    }

    /* JADX INFO: renamed from: -$$Nest$monKeyboardBacklightListenerDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4563$$Nest$monKeyboardBacklightListenerDied(KeyboardBacklightController r0, int r1) {
        r0.onKeyboardBacklightListenerDied(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4564$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTRANSITION_ANIMATION_DURATION_MILLIS, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m4565$$Nest$sfgetTRANSITION_ANIMATION_DURATION_MILLIS() {
        return TRANSITION_ANIMATION_DURATION_MILLIS;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        TRANSITION_ANIMATION_DURATION_MILLIS = Duration.ofSeconds(1).toMillis();
        DEFAULT_BRIGHTNESS_VALUE_FOR_LEVEL = new int[11];
        int i = 0;
    L4:
        if (i > 10) goto L7;
        DEFAULT_BRIGHTNESS_VALUE_FOR_LEVEL[i] = (int) Math.floor((i * 255.0f) / 10.0f);
        i = i + 1;
        goto L4
    }

    KeyboardBacklightController(Context context, NativeInputManagerService nativeService, Looper looper) {
        this(context, nativeService, looper, new KeyboardBacklightController$$ExternalSyntheticLambda2());
    }

    private static /* synthetic */ ValueAnimator lambda$new$0(int xva$0, int xva$1) {
        return ValueAnimator.ofInt(new int[]{xva$0, xva$1});
    }

    KeyboardBacklightController(Context context, NativeInputManagerService nativeService, Looper looper, AnimatorFactory animatorFactory) {
        this.mKeyboardBacklights = new SparseArray(1);
        this.mIsBacklightOn = false;
        this.mIsInteractive = true;
        this.mKeyboardBacklightListenerRecords = new SparseArray();
        this.mAmbientBacklightValue = 0;
        this.mContext = context;
        this.mNative = nativeService;
        this.mHandler = new Handler(looper, new KeyboardBacklightController$$ExternalSyntheticLambda1(this));
        this.mAnimatorFactory = animatorFactory;
        this.mAmbientController = new AmbientKeyboardBacklightController(context, looper);
        Resources res = this.mContext.getResources();
        this.mUserInactivityThresholdMs = res.getInteger(R.integer.config_longPressOnBackBehavior);
        this.mKeyboardBacklightAnimationEnabled = ((Boolean) InputProperties.enable_keyboard_backlight_animation().orElse(false)).booleanValue();
    }

    @Override // com.android.server.input.InputManagerService.KeyboardBacklightControllerInterface
    public void systemRunning() {
        InputManager inputManager = (InputManager) this.mContext.getSystemService(InputManager.class);
        inputManager.getClass();
        inputManager.registerInputDeviceListener(this, this.mHandler);
        Message msg = Message.obtain(this.mHandler, 1, inputManager.getInputDeviceIds());
        this.mHandler.sendMessage(msg);
        this.mAmbientController.systemRunning();
    }

    @Override // com.android.server.input.InputManagerService.KeyboardBacklightControllerInterface
    public void incrementKeyboardBacklight(int deviceId) {
        Message msg = Message.obtain(this.mHandler, 2, Integer.valueOf(deviceId));
        this.mHandler.sendMessage(msg);
    }

    @Override // com.android.server.input.InputManagerService.KeyboardBacklightControllerInterface
    public void decrementKeyboardBacklight(int deviceId) {
        Message msg = Message.obtain(this.mHandler, 3, Integer.valueOf(deviceId));
        this.mHandler.sendMessage(msg);
    }

    @Override // com.android.server.input.InputManagerService.KeyboardBacklightControllerInterface
    public void notifyUserActivity() {
        Message msg = Message.obtain(this.mHandler, 4);
        this.mHandler.sendMessage(msg);
    }

    @Override // com.android.server.input.InputManagerService.KeyboardBacklightControllerInterface
    public void onInteractiveChanged(boolean isInteractive) {
        Message msg = Message.obtain(this.mHandler, 6, Boolean.valueOf(isInteractive));
        this.mHandler.sendMessage(msg);
    }

    private void updateKeyboardBacklight(int deviceId, Direction direction) {
        InputDevice inputDevice = getInputDevice(deviceId);
        KeyboardBacklightState state = this.mKeyboardBacklights.get(deviceId);
        if (inputDevice == null) goto L38;
        if (state != null) goto L7;
        return;
    L7:
        if (KeyboardBacklightState.m4570$$Nest$fgetmUseAmbientController(state) == false) goto L17;
        int index = Arrays.binarySearch(KeyboardBacklightState.m4568$$Nest$fgetmBrightnessValueForLevel(state), this.mAmbientBacklightValue);
        if (index >= 0) goto L15;
        int lowerBound = Math.max(0, (-(index + 1)) - 1);
        if (direction != Direction.DIRECTION_UP) goto L13;
        int currBrightnessLevel = lowerBound;
    L19:
        if (direction != Direction.DIRECTION_UP) goto L21;
        int newBrightnessLevel = Math.min(currBrightnessLevel + 1, KeyboardBacklightState.m4571$$Nest$mgetNumBrightnessChangeSteps(state));
    L22:
        KeyboardBacklightState.m4574$$Nest$msetBrightnessLevel(state, newBrightnessLevel);
        updateAmbientLightListener();
        if (DEBUG == false) goto L25;
        Slog.d(TAG, "Changing state from " + KeyboardBacklightState.m4567$$Nest$fgetmBrightnessLevel(state) + " to " + newBrightnessLevel);
    L25:
        SparseArray<KeyboardBacklightListenerRecord> r3 = this.mKeyboardBacklightListenerRecords;
        monitor-enter(r3);
        int i = 0;
    L39:
    L31:
        th = move-exception;
        throw th;
    L29:
        if (i >= this.mKeyboardBacklightListenerRecords.size()) goto L34;
        IKeyboardBacklightState callbackState = new IKeyboardBacklightState();     // Catch: Throwable -> L31
        callbackState.brightnessLevel = newBrightnessLevel;     // Catch: Throwable -> L31
        callbackState.maxBrightnessLevel = KeyboardBacklightState.m4571$$Nest$mgetNumBrightnessChangeSteps(state);     // Catch: Throwable -> L31
        this.mKeyboardBacklightListenerRecords.valueAt(i).notifyKeyboardBacklightChanged(deviceId, callbackState, true);     // Catch: Throwable -> L31
        i = i + 1;     // Catch: Throwable -> L31
        goto L39
    L34:
        monitor-exit(r3);     // Catch: Throwable -> L31
        return;
    L21:
        int newBrightnessLevel2 = currBrightnessLevel - 1;
        newBrightnessLevel = Math.max(newBrightnessLevel2, 0);
        goto L22
    L13:
        currBrightnessLevel = lowerBound + 1;
        goto L19
    L15:
        currBrightnessLevel = index;
        goto L19
    L17:
        currBrightnessLevel = KeyboardBacklightState.m4567$$Nest$fgetmBrightnessLevel(state);
        goto L19
    }

    private void handleUserActivity() {
        if (this.mIsInteractive == true) goto L5;
        return;
    L5:
        this.mIsBacklightOn = true;
        int i = 0;
    L7:
        if (i >= this.mKeyboardBacklights.size()) goto L9;
        KeyboardBacklightState state = this.mKeyboardBacklights.valueAt(i);
        KeyboardBacklightState.m4573$$Nest$monBacklightStateChanged(state);
        i = i + 1;
        goto L7
    L9:
        this.mHandler.removeMessages(5);
        this.mHandler.sendEmptyMessageAtTime(5, SystemClock.uptimeMillis() + ((long) this.mUserInactivityThresholdMs));
    }

    private void handleUserInactivity() {
        this.mIsBacklightOn = false;
        int i = 0;
    L4:
        if (i >= this.mKeyboardBacklights.size()) goto L7;
        KeyboardBacklightState state = this.mKeyboardBacklights.valueAt(i);
        KeyboardBacklightState.m4573$$Nest$monBacklightStateChanged(state);
        i = i + 1;
        goto L4
    }

    public void handleInteractiveStateChange(boolean isInteractive) {
        this.mIsInteractive = isInteractive;
        if (isInteractive == false) goto L5;
        handleUserActivity();
    L6:
        updateAmbientLightListener();
        return;
    L5:
        handleUserInactivity();
        goto L6
    }

    public void handleAmbientLightValueChanged(int brightnessValue) {
        this.mAmbientBacklightValue = brightnessValue;
        int i = 0;
    L4:
        if (i >= this.mKeyboardBacklights.size()) goto L7;
        KeyboardBacklightState state = this.mKeyboardBacklights.valueAt(i);
        KeyboardBacklightState.m4572$$Nest$monAmbientBacklightValueChanged(state);
        i = i + 1;
        goto L4
    }

    private boolean handleMessage(Message msg) {
        int r1 = 0;
        switch(msg.what) {
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        handleInteractiveStateChange(((Boolean) msg.obj).booleanValue());
        return true;
    L7:
        handleUserInactivity();
        return true;
    L9:
        handleUserActivity();
        return true;
    L11:
        updateKeyboardBacklight(((Integer) msg.obj).intValue(), Direction.DIRECTION_DOWN);
        return true;
    L13:
        updateKeyboardBacklight(((Integer) msg.obj).intValue(), Direction.DIRECTION_UP);
        return true;
    L15:
        int[] r0 = (int[]) msg.obj;
        int r3 = r0.length;
    L16:
        if (r1 >= r3) goto L18;
        int deviceId = r0[r1];
        onInputDeviceAdded(deviceId);
        r1 = r1 + 1;
        goto L16
    L18:
        return true;
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceAdded(int deviceId) {
        onInputDeviceChanged(deviceId);
        updateAmbientLightListener();
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceRemoved(int deviceId) {
        this.mKeyboardBacklights.remove(deviceId);
        updateAmbientLightListener();
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceChanged(int deviceId) {
        InputDevice inputDevice = getInputDevice(deviceId);
        if (inputDevice != null) goto L5;
        return;
    L5:
        Light keyboardBacklight = getKeyboardBacklight(inputDevice);
        if (keyboardBacklight != null) goto L9;
        this.mKeyboardBacklights.remove(deviceId);
        return;
    L9:
        KeyboardBacklightState state = this.mKeyboardBacklights.get(deviceId);
        if (state != null) goto L12;
    L14:
        this.mKeyboardBacklights.put(deviceId, new KeyboardBacklightState(this, deviceId, keyboardBacklight));
        return;
    L12:
        if (KeyboardBacklightState.m4569$$Nest$fgetmLight(state).getId() != keyboardBacklight.getId()) goto L14;
    }

    private InputDevice getInputDevice(int deviceId) {
        InputManager inputManager = (InputManager) this.mContext.getSystemService(InputManager.class);
        if (inputManager != null) goto L7;
        return null;
    L7:
        return inputManager.getInputDevice(deviceId);
    }

    private Light getKeyboardBacklight(InputDevice inputDevice) {
        Iterator<Light> r0 = inputDevice.getLightsManager().getLights().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Light light = r0.next();
        if (light.getType() != 10003) goto L4;
        if (light.hasBrightnessControl() == false) goto L4;
        return light;
    L11:
        return null;
    }

    @Override // com.android.server.input.InputManagerService.KeyboardBacklightControllerInterface
    public void registerKeyboardBacklightListener(IKeyboardBacklightListener listener, int pid) {
        SparseArray<KeyboardBacklightListenerRecord> r0 = this.mKeyboardBacklightListenerRecords;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mKeyboardBacklightListenerRecords.get(pid) != null) goto L17;
        KeyboardBacklightListenerRecord record = new KeyboardBacklightListenerRecord(this, pid, listener);     // Catch: Throwable -> L11
        listener.asBinder().linkToDeath(record, 0);     // Catch: Throwable -> L11 RemoteException -> L13
        this.mKeyboardBacklightListenerRecords.put(pid, record);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        ex = move-exception;
        throw new RuntimeException(ex);     // Catch: Throwable -> L11
    L17:
        throw new IllegalStateException("The calling process has already registered a KeyboardBacklightListener.");     // Catch: Throwable -> L11
    }

    @Override // com.android.server.input.InputManagerService.KeyboardBacklightControllerInterface
    public void unregisterKeyboardBacklightListener(IKeyboardBacklightListener listener, int pid) {
        SparseArray<KeyboardBacklightListenerRecord> r0 = this.mKeyboardBacklightListenerRecords;
        monitor-enter(r0);
        KeyboardBacklightListenerRecord record = this.mKeyboardBacklightListenerRecords.get(pid);     // Catch: Throwable -> L11
        if (record == null) goto L16;
        if (record.mListener.asBinder() != listener.asBinder()) goto L14;
        record.mListener.asBinder().unlinkToDeath(record, 0);     // Catch: Throwable -> L11
        this.mKeyboardBacklightListenerRecords.remove(pid);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L14:
        throw new IllegalStateException("The calling process has a different registered KeyboardBacklightListener.");     // Catch: Throwable -> L11
    L16:
        throw new IllegalStateException("The calling process has no registered KeyboardBacklightListener.");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private void onKeyboardBacklightListenerDied(int pid) {
        SparseArray<KeyboardBacklightListenerRecord> r0 = this.mKeyboardBacklightListenerRecords;
        monitor-enter(r0);
        this.mKeyboardBacklightListenerRecords.remove(pid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void updateAmbientLightListener() {
        boolean needToListenAmbientLightSensor = false;
        int i = 0;
    L4:
        if (i >= this.mKeyboardBacklights.size()) goto L6;
        needToListenAmbientLightSensor = needToListenAmbientLightSensor | KeyboardBacklightState.m4570$$Nest$fgetmUseAmbientController(this.mKeyboardBacklights.valueAt(i));
        i = i + 1;
        goto L4
    L6:
        boolean needToListenAmbientLightSensor2 = needToListenAmbientLightSensor & this.mIsInteractive;
        if (needToListenAmbientLightSensor2 == true) goto L9;
    L11:
        if (needToListenAmbientLightSensor2 == false) goto L13;
        return;
    L13:
        if (this.mAmbientListener == null) goto L18;
        this.mAmbientController.unregisterAmbientBacklightListener(this.mAmbientListener);
        this.mAmbientListener = null;
        return;
    L18:
        return;
    L9:
        if (this.mAmbientListener != null) goto L11;
        this.mAmbientListener = new KeyboardBacklightController$$ExternalSyntheticLambda0(this);
        this.mAmbientController.registerAmbientBacklightListener(this.mAmbientListener);
        goto L11
    }

    private static boolean isValidBacklightNodePath(String devPath) {
        if (TextUtils.isEmpty(devPath) == false) goto L5;
        return false;
    L5:
        int index = devPath.lastIndexOf(47);
        if (index >= 0) goto L8;
        return false;
    L8:
        String backlightNode = devPath.substring(index + 1);
        String devPath2 = devPath.substring(0, index);
        if (devPath2.endsWith("leds") == true) goto L11;
    L17:
        return false;
    L11:
        if (backlightNode.contains("kbd_backlight") == false) goto L17;
        if (devPath2.lastIndexOf(47) < 0) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // com.android.server.input.InputManagerService.KeyboardBacklightControllerInterface
    public void dump(PrintWriter pw) {
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw);
        ipw.println("KbdBacklightController: " + this.mKeyboardBacklights.size() + " keyboard backlights");
        ipw.increaseIndent();
        int i = 0;
    L4:
        if (i >= this.mKeyboardBacklights.size()) goto L6;
        KeyboardBacklightState state = this.mKeyboardBacklights.valueAt(i);
        ipw.println(i + ": " + state.toString());
        i = i + 1;
        goto L4
    L6:
        ipw.decreaseIndent();
    }
}
