package com.android.server.input;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManagerInternal;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Slog;
import android.util.TypedValue;
import android.view.DisplayInfo;
import com.android.server.LocalServices;
import com.android.server.display.utils.SensorUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class AmbientKeyboardBacklightController implements DisplayManager.DisplayListener, SensorEventListener {
    private static final boolean DEBUG = false;
    public static final int HYSTERESIS_THRESHOLD = 2;
    private static final int MSG_BRIGHTNESS_CALLBACK = 0;
    private static final int MSG_SETUP_DISPLAY_AND_SENSOR = 1;
    private static final String TAG = "KbdBacklightController";
    private static final Object sAmbientControllerLock = null;
    private final List<AmbientKeyboardBacklightListener> mAmbientKeyboardBacklightListeners;
    private BrightnessStep[] mBrightnessSteps;
    private final Context mContext;
    private int mCurrentBrightnessStepIndex;
    private String mCurrentDefaultDisplayUniqueId;
    private final Handler mHandler;
    private int mHysteresisCount;
    private HysteresisState mHysteresisState;
    private Sensor mLightSensor;
    private int mSmoothedLux;
    private int mSmoothedLuxAtLastAdjustment;
    private float mSmoothingConstant;

    public interface AmbientKeyboardBacklightListener {
        void onKeyboardBacklightValueChanged(int r1);
    }

    private static class BrightnessStep {
        private final int mBrightnessValue;
        private final int mDecreaseLuxThreshold;
        private final int mIncreaseLuxThreshold;

        /* JADX INFO: renamed from: -$$Nest$fgetmBrightnessValue, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4464$$Nest$fgetmBrightnessValue(BrightnessStep r0) {
            return r0.mBrightnessValue;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDecreaseLuxThreshold, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4465$$Nest$fgetmDecreaseLuxThreshold(BrightnessStep r0) {
            return r0.mDecreaseLuxThreshold;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIncreaseLuxThreshold, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4466$$Nest$fgetmIncreaseLuxThreshold(BrightnessStep r0) {
            return r0.mIncreaseLuxThreshold;
        }

        /* synthetic */ BrightnessStep(int r1, int r2, int r3, AmbientKeyboardBacklightControllerIA r4) {
            this(r1, r2, r3);
        }

        private BrightnessStep(int brightnessValue, int increaseLuxThreshold, int decreaseLuxThreshold) {
            this.mBrightnessValue = brightnessValue;
            this.mIncreaseLuxThreshold = increaseLuxThreshold;
            this.mDecreaseLuxThreshold = decreaseLuxThreshold;
        }

        public String toString() {
            return "BrightnessStep{mBrightnessValue=" + this.mBrightnessValue + ", mIncreaseThreshold=" + this.mIncreaseLuxThreshold + ", mDecreaseThreshold=" + this.mDecreaseLuxThreshold + '}';
        }
    }

    private static final enum HysteresisState extends Enum<HysteresisState> {
        private static final /* synthetic */ HysteresisState[] $VALUES = null;
        public static final HysteresisState DECREASING = null;
        public static final HysteresisState IMMEDIATE = null;
        public static final HysteresisState INCREASING = null;
        public static final HysteresisState STABLE = null;

        private static /* synthetic */ HysteresisState[] $values() {
            return new HysteresisState[]{STABLE, DECREASING, INCREASING, IMMEDIATE};
        }

        private HysteresisState(String r1, int r2) {
            super(r1, r2);
        }

        public static HysteresisState valueOf(String name) {
            return (HysteresisState) Enum.valueOf(HysteresisState.class, name);
        }

        public static HysteresisState[] values() {
            return (HysteresisState[]) $VALUES.clone();
        }

        static {
            STABLE = new HysteresisState("STABLE", 0);
            DECREASING = new HysteresisState("DECREASING", 1);
            INCREASING = new HysteresisState("INCREASING", 2);
            IMMEDIATE = new HysteresisState("IMMEDIATE", 3);
            $VALUES = $values();
        }
    }

    public static /* synthetic */ boolean $r8$lambda$JJuuzJTMpjI9ZCGBKjwNrMezjco(AmbientKeyboardBacklightController r0, Message r1) {
        return r0.handleMessage(r1);
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        sAmbientControllerLock = new Object();
    }

    AmbientKeyboardBacklightController(Context context, Looper looper) {
        this.mAmbientKeyboardBacklightListeners = new ArrayList();
        this.mHysteresisCount = 0;
        this.mContext = context;
        this.mHandler = new Handler(looper, new AmbientKeyboardBacklightController$$ExternalSyntheticLambda0(this));
        initConfiguration();
    }

    public void systemRunning() {
        this.mHandler.sendEmptyMessage(1);
        DisplayManager displayManager = (DisplayManager) this.mContext.getSystemService(DisplayManager.class);
        displayManager.getClass();
        displayManager.registerDisplayListener(this, this.mHandler);
    }

    public void registerAmbientBacklightListener(AmbientKeyboardBacklightListener listener) {
        Object r0 = sAmbientControllerLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mAmbientKeyboardBacklightListeners.contains(listener) == true) goto L15;
        if (this.mAmbientKeyboardBacklightListeners.isEmpty() == false) goto L11;
        addSensorListener(this.mLightSensor);     // Catch: Throwable -> L9
    L11:
        this.mAmbientKeyboardBacklightListeners.add(listener);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L15:
        throw new IllegalStateException("AmbientKeyboardBacklightListener was already registered, listener = " + listener);     // Catch: Throwable -> L9
    }

    public void unregisterAmbientBacklightListener(AmbientKeyboardBacklightListener listener) {
        Object r0 = sAmbientControllerLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mAmbientKeyboardBacklightListeners.contains(listener) == false) goto L14;
        this.mAmbientKeyboardBacklightListeners.remove(listener);     // Catch: Throwable -> L9
        if (this.mAmbientKeyboardBacklightListeners.isEmpty() == false) goto L11;
        removeSensorListener(this.mLightSensor);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L14:
        throw new IllegalStateException("AmbientKeyboardBacklightListener was never registered, listener = " + listener);     // Catch: Throwable -> L9
    }

    private void sendBrightnessAdjustment(int brightnessValue) {
        Message msg = Message.obtain(this.mHandler, 0, Integer.valueOf(brightnessValue));
        this.mHandler.sendMessage(msg);
    }

    private void handleBrightnessCallback(int brightnessValue) {
        Object r0 = sAmbientControllerLock;
        monitor-enter(r0);
        Iterator<AmbientKeyboardBacklightListener> r1 = this.mAmbientKeyboardBacklightListeners.iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        AmbientKeyboardBacklightListener listener = r1.next();     // Catch: Throwable -> L8
        listener.onKeyboardBacklightValueChanged(brightnessValue);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void handleAmbientLuxChange(float rawLux) {
        if (rawLux >= 0.0f) goto L6;
        Slog.w(TAG, "Light sensor doesn't have valid value");
        return;
    L6:
        updateSmoothedLux(rawLux);
        if (this.mHysteresisState != HysteresisState.IMMEDIATE) goto L9;
    L12:
        int newStepIndex = Math.max(0, this.mCurrentBrightnessStepIndex);
        int numSteps = this.mBrightnessSteps.length;
        if (this.mSmoothedLux <= this.mSmoothedLuxAtLastAdjustment) goto L28;
        if (this.mHysteresisState == HysteresisState.IMMEDIATE) goto L22;
        if (this.mHysteresisState == HysteresisState.INCREASING) goto L22;
        if (DEBUG == false) goto L21;
        Slog.d(TAG, "ALS transitioned to brightness increasing state");
    L21:
        this.mHysteresisState = HysteresisState.INCREASING;
        this.mHysteresisCount = 0;
    L22:
        if (newStepIndex >= numSteps) goto L43;
        if (this.mSmoothedLux < BrightnessStep.m4466$$Nest$fgetmIncreaseLuxThreshold(this.mBrightnessSteps[newStepIndex])) goto L43;
        newStepIndex = newStepIndex + 1;
    L43:
        if (this.mHysteresisState != HysteresisState.IMMEDIATE) goto L47;
        this.mCurrentBrightnessStepIndex = newStepIndex;
        this.mSmoothedLuxAtLastAdjustment = this.mSmoothedLux;
        this.mHysteresisState = HysteresisState.STABLE;
        this.mHysteresisCount = 0;
        sendBrightnessAdjustment(BrightnessStep.m4464$$Nest$fgetmBrightnessValue(this.mBrightnessSteps[newStepIndex]));
        return;
    L47:
        if (newStepIndex != this.mCurrentBrightnessStepIndex) goto L49;
        return;
    L49:
        this.mHysteresisCount++;
        if (DEBUG == false) goto L53;
        Slog.d(TAG, "Incremented hysteresis count to " + this.mHysteresisCount + " (lux went from " + this.mSmoothedLuxAtLastAdjustment + " to " + this.mSmoothedLux + ")");
    L53:
        if (this.mHysteresisCount < 2) goto L62;
        this.mCurrentBrightnessStepIndex = newStepIndex;
        this.mSmoothedLuxAtLastAdjustment = this.mSmoothedLux;
        this.mHysteresisCount = 1;
        sendBrightnessAdjustment(BrightnessStep.m4464$$Nest$fgetmBrightnessValue(this.mBrightnessSteps[newStepIndex]));
        return;
    L62:
        return;
    L28:
        if (this.mSmoothedLux >= this.mSmoothedLuxAtLastAdjustment) goto L43;
        if (this.mHysteresisState == HysteresisState.IMMEDIATE) goto L37;
        if (this.mHysteresisState == HysteresisState.DECREASING) goto L37;
        if (DEBUG == false) goto L36;
        Slog.d(TAG, "ALS transitioned to brightness decreasing state");
    L36:
        this.mHysteresisState = HysteresisState.DECREASING;
        this.mHysteresisCount = 0;
    L37:
        if (newStepIndex < 0) goto L43;
        if (this.mSmoothedLux > BrightnessStep.m4465$$Nest$fgetmDecreaseLuxThreshold(this.mBrightnessSteps[newStepIndex])) goto L43;
        newStepIndex = newStepIndex - 1;
        goto L37
    L9:
        if (this.mSmoothedLux != this.mSmoothedLuxAtLastAdjustment) goto L12;
        this.mHysteresisState = HysteresisState.STABLE;
    }

    private void handleDisplayChange() {
        DisplayManagerInternal displayManagerInternal = (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
        DisplayInfo displayInfo = displayManagerInternal.getDisplayInfo(0);
        if (displayInfo != null) goto L5;
        return;
    L5:
        Object r3 = sAmbientControllerLock;
        monitor-enter(r3);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (Objects.equals(this.mCurrentDefaultDisplayUniqueId, displayInfo.uniqueId) == false) goto L14;
        monitor-exit(r3);     // Catch: Throwable -> L11
        return;
    L14:
        if (DEBUG == false) goto L16;
        Slog.d(TAG, "Default display changed: resetting the light sensor");     // Catch: Throwable -> L11
    L16:
        this.mCurrentDefaultDisplayUniqueId = displayInfo.uniqueId;     // Catch: Throwable -> L11
        if (this.mAmbientKeyboardBacklightListeners.isEmpty() == true) goto L19;
        removeSensorListener(this.mLightSensor);     // Catch: Throwable -> L11
    L19:
        this.mLightSensor = getAmbientLightSensor(displayManagerInternal.getAmbientLightSensorData(0));     // Catch: Throwable -> L11
        if (this.mAmbientKeyboardBacklightListeners.isEmpty() == true) goto L22;
        addSensorListener(this.mLightSensor);     // Catch: Throwable -> L11
    L22:
        monitor-exit(r3);     // Catch: Throwable -> L11
    }

    private Sensor getAmbientLightSensor(DisplayManagerInternal.AmbientLightSensorData ambientSensor) {
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService(SensorManager.class);
        sensorManager.getClass();
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "Ambient Light sensor data: " + ambientSensor);
    L6:
        return SensorUtils.findSensor(sensorManager, ambientSensor.sensorType, ambientSensor.sensorName, 5);
    }

    private void updateSmoothedLux(float rawLux) {
        if (this.mHysteresisState != HysteresisState.IMMEDIATE) goto L5;
        this.mSmoothedLux = (int) rawLux;
    L7:
        if (DEBUG == false) goto L10;
        Slog.d(TAG, "Current smoothed lux from ALS = " + this.mSmoothedLux);
        return;
    L10:
        return;
    L5:
        this.mSmoothedLux = (int) ((this.mSmoothingConstant * rawLux) + ((1.0f - this.mSmoothingConstant) * this.mSmoothedLux));
        goto L7
    }

    public void addSensorListener(Sensor sensor) {
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService(SensorManager.class);
        if (sensorManager == null) goto L10;
        if (sensor == null) goto L12;
        reset();
        sensorManager.registerListener(this, sensor, 3, this.mHandler);
        if (DEBUG == false) goto L11;
        Slog.d(TAG, "Registering ALS listener");
        return;
    L11:
        return;
    L12:
        return;
    }

    private void removeSensorListener(Sensor sensor) {
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService(SensorManager.class);
        if (sensorManager == null) goto L10;
        if (sensor == null) goto L12;
        sensorManager.unregisterListener(this, sensor);
        if (DEBUG == false) goto L11;
        Slog.d(TAG, "Unregistering ALS listener");
        return;
    L11:
        return;
    L12:
        return;
    }

    private void initConfiguration() {
        Resources res = this.mContext.getResources();
        int[] brightnessValueArray = res.getIntArray(R.array.config_brightnessThresholdsOfPeakRefreshRate);
        int[] decreaseThresholdArray = res.getIntArray(R.array.config_builtInDisplayIsRoundArray);
        int[] increaseThresholdArray = res.getIntArray(R.array.config_callBarringMMI);
        if (brightnessValueArray.length != decreaseThresholdArray.length) goto L37;
        if (decreaseThresholdArray.length != increaseThresholdArray.length) goto L37;
        int size = brightnessValueArray.length;
        this.mBrightnessSteps = new BrightnessStep[size];
        int i = 0;
    L7:
        int decreaseThreshold = Integer.MIN_VALUE;
        int increaseThreshold = Integer.MAX_VALUE;
        if (i >= size) goto L18;
        if (increaseThresholdArray[i] < 0) goto L14;
        increaseThreshold = increaseThresholdArray[i];
    L14:
        if (decreaseThresholdArray[i] < 0) goto L17;
        decreaseThreshold = decreaseThresholdArray[i];
    L17:
        this.mBrightnessSteps[i] = new BrightnessStep(brightnessValueArray[i], increaseThreshold, decreaseThreshold, null);
        i = i + 1;
        goto L7
    L18:
        int numSteps = this.mBrightnessSteps.length;
        if (numSteps == 0) goto L35;
        if (BrightnessStep.m4465$$Nest$fgetmDecreaseLuxThreshold(this.mBrightnessSteps[0]) != Integer.MIN_VALUE) goto L35;
        if (BrightnessStep.m4466$$Nest$fgetmIncreaseLuxThreshold(this.mBrightnessSteps[numSteps - 1]) != Integer.MAX_VALUE) goto L35;
        TypedValue smoothingConstantValue = new TypedValue();
        res.getValue(R.dimen.datepicker_list_year_label_size, smoothingConstantValue, true);
        this.mSmoothingConstant = smoothingConstantValue.getFloat();
        if (this.mSmoothingConstant <= 0.0d) goto L33;
        if (this.mSmoothingConstant > 1.0d) goto L33;
        if (DEBUG == false) goto L41;
        Log.d(TAG, "Brightness steps: " + Arrays.toString(this.mBrightnessSteps) + " Smoothing constant = " + this.mSmoothingConstant);
        return;
    L41:
        return;
    L33:
        throw new IllegalArgumentException("The config files for auto keyboard backlight brightness must contain smoothing constant in range (0.0, 1.0].");
    L35:
        throw new IllegalArgumentException("The config files for auto keyboard backlight brightness must contain arrays of length > 0 and have -1 or Integer.MIN_VALUE as lower bound for decrease thresholds and -1 or Integer.MAX_VALUE as upper bound for increase thresholds");
    L37:
        throw new IllegalArgumentException("The config files for auto keyboard backlight brightness must contain arrays of equal lengths");
    }

    private void reset() {
        this.mHysteresisState = HysteresisState.IMMEDIATE;
        this.mSmoothedLux = 0;
        this.mSmoothedLuxAtLastAdjustment = 0;
        this.mCurrentBrightnessStepIndex = -1;
    }

    private boolean handleMessage(Message msg) {
        switch(msg.what) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        handleDisplayChange();
        return true;
    L8:
        handleBrightnessCallback(((Integer) msg.obj).intValue());
        return true;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        handleAmbientLuxChange(event.values[0]);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int displayId) {
        handleDisplayChange();
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int displayId) {
        handleDisplayChange();
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int displayId) {
        handleDisplayChange();
    }
}
