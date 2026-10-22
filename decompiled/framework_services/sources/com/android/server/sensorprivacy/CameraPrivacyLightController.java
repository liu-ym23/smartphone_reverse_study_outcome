package com.android.server.sensorprivacy;

import android.R;
import android.app.AppOpsManager;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.lights.Light;
import android.hardware.lights.LightState;
import android.hardware.lights.LightsManager;
import android.hardware.lights.LightsRequest;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.Looper;
import android.os.SystemClock;
import android.permission.PermissionManager;
import android.util.ArraySet;
import android.util.Pair;
import com.android.internal.util.ArrayUtils;
import com.android.server.FgThread;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
class CameraPrivacyLightController implements AppOpsManager.OnOpActiveChangedListener, SensorEventListener {
    private static final double LIGHT_VALUE_MULTIPLIER = 0.0d;
    private final Set<String> mActivePackages;
    private final Set<String> mActivePhonePackages;
    private long mAlvSum;
    private final ArrayDeque<Pair<Long, Integer>> mAmbientLightValues;
    private final AppOpsManager mAppOpsManager;
    private final List<Light> mCameraLights;
    private final int[] mColors;
    private final Context mContext;
    private final Object mDelayedUpdateToken;
    private long mElapsedRealTime;
    private long mElapsedTimeStartedReading;
    private final Executor mExecutor;
    private final Handler mHandler;
    private boolean mIsAmbientLightListenerRegistered;
    private int mLastLightColor;
    private final Sensor mLightSensor;
    private final LightsManager mLightsManager;
    private LightsManager.LightsSession mLightsSession;
    private final long mMovingAverageIntervalMillis;
    private final SensorManager mSensorManager;
    private final long[] mThresholds;

    public static /* synthetic */ void $r8$lambda$SMiyzXtZBAwi2UTaXppZg0EcP9M(CameraPrivacyLightController r0) {
        r0.updateLightSession();
    }

    static {
        LIGHT_VALUE_MULTIPLIER = 1.0d / Math.log(1.1d);
    }

    CameraPrivacyLightController(Context context) {
        this(context, FgThread.get().getLooper());
    }

    CameraPrivacyLightController(Context context, Looper looper) {
        this.mActivePackages = new ArraySet();
        this.mActivePhonePackages = new ArraySet();
        this.mCameraLights = new ArrayList();
        this.mLightsSession = null;
        this.mIsAmbientLightListenerRegistered = false;
        this.mAmbientLightValues = new ArrayDeque();
        this.mAlvSum = 0;
        this.mLastLightColor = 0;
        this.mDelayedUpdateToken = new Object();
        this.mElapsedRealTime = -1;
        this.mColors = context.getResources().getIntArray(R.array.config_defaultImperceptibleKillingExemptionProcStates);
        if (ArrayUtils.isEmpty(this.mColors) == false) goto L6;
        this.mHandler = null;
        this.mExecutor = null;
        this.mContext = null;
        this.mAppOpsManager = null;
        this.mLightsManager = null;
        this.mSensorManager = null;
        this.mLightSensor = null;
        this.mMovingAverageIntervalMillis = 0;
        this.mThresholds = null;
        return;
    L6:
        this.mContext = context;
        this.mHandler = new Handler(looper);
        this.mExecutor = new HandlerExecutor(this.mHandler);
        this.mAppOpsManager = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        this.mLightsManager = (LightsManager) this.mContext.getSystemService(LightsManager.class);
        this.mSensorManager = (SensorManager) this.mContext.getSystemService(SensorManager.class);
        this.mMovingAverageIntervalMillis = this.mContext.getResources().getInteger(R.integer.config_datause_polling_period_sec);
        int[] thresholdsLux = this.mContext.getResources().getIntArray(R.array.config_defaultImperceptibleKillingExemptionPkgs);
        if (thresholdsLux.length != (this.mColors.length - 1)) goto L26;
        this.mThresholds = new long[thresholdsLux.length];
        int i = 0;
    L10:
        if (i >= thresholdsLux.length) goto L12;
        int luxValue = thresholdsLux[i];
        this.mThresholds[i] = (long) (Math.log(luxValue) * LIGHT_VALUE_MULTIPLIER);
        i = i + 1;
        goto L10
    L12:
        List<Light> lights = this.mLightsManager.getLights();
        int i2 = 0;
    L14:
        if (i2 >= lights.size()) goto L20;
        Light light = lights.get(i2);
        if (light.getType() != 9) goto L18;
        this.mCameraLights.add(light);
    L18:
        i2 = i2 + 1;
        goto L14
    L20:
        if (this.mCameraLights.isEmpty() == false) goto L23;
        this.mLightSensor = null;
        return;
    L23:
        this.mAppOpsManager.startWatchingActive(new String[]{"android:camera", "android:phone_call_camera"}, this.mExecutor, this);
        this.mLightSensor = this.mSensorManager.getDefaultSensor(5);
        return;
    L26:
        throw new IllegalStateException("There must be exactly one more color than thresholds. Found " + this.mColors.length + " colors and " + thresholdsLux.length + " thresholds.");
    }

    private void addElement(long time, int value) {
        if (this.mAmbientLightValues.isEmpty() == false) goto L5;
        this.mAmbientLightValues.add(new Pair(Long.valueOf((time - getCurrentIntervalMillis()) - 1), Integer.valueOf(value)));
    L5:
        Pair<Long, Integer> lastElement = this.mAmbientLightValues.peekLast();
        this.mAmbientLightValues.add(new Pair(Long.valueOf(time), Integer.valueOf(value)));
        this.mAlvSum += (time - ((Long) lastElement.first).longValue()) * ((long) ((Integer) lastElement.second).intValue());
        removeObsoleteData(time);
    }

    private void removeObsoleteData(long time) {
    L3:
        if (this.mAmbientLightValues.size() <= 1) goto L11;
        Pair<Long, Integer> element0 = this.mAmbientLightValues.pollFirst();
        Pair<Long, Integer> element1 = this.mAmbientLightValues.peekFirst();
        if (((Long) element1.first).longValue() > (time - getCurrentIntervalMillis())) goto L6;
        this.mAlvSum -= (((Long) element1.first).longValue() - ((Long) element0.first).longValue()) * ((long) ((Integer) element0.second).intValue());
        goto L3
    L6:
        this.mAmbientLightValues.addFirst(element0);
        return;
    }

    private long getLiveAmbientLightTotal() {
        if (this.mAmbientLightValues.isEmpty() == true) goto L5;
        long time = getElapsedRealTime();
        removeObsoleteData(time);
        Pair<Long, Integer> firstElement = this.mAmbientLightValues.peekFirst();
        Pair<Long, Integer> lastElement = this.mAmbientLightValues.peekLast();
        return (this.mAlvSum - (Math.max(0, (time - getCurrentIntervalMillis()) - ((Long) firstElement.first).longValue()) * ((long) ((Integer) firstElement.second).intValue()))) + ((time - ((Long) lastElement.first).longValue()) * ((long) ((Integer) lastElement.second).intValue()));
    L5:
        return this.mAlvSum;
    }

    @Override // android.app.AppOpsManager.OnOpActiveChangedListener
    public void onOpActiveChanged(String op, int uid, String packageName, boolean active) {
        if ("android:camera".equals(op) == false) goto L6;
        Set<String> activePackages = this.mActivePackages;
    L8:
        if (active == false) goto L10;
        activePackages.add(packageName);
    L11:
        updateLightSession();
        return;
    L10:
        activePackages.remove(packageName);
        goto L11
    L6:
        if ("android:phone_call_camera".equals(op) == false) goto L13;
        activePackages = this.mActivePhonePackages;
        goto L8
    }

    private void updateLightSession() {
        if (Looper.myLooper() == this.mHandler.getLooper()) goto L6;
        this.mHandler.post(new CameraPrivacyLightController$$ExternalSyntheticLambda0(this));
        return;
    L6:
        Set<String> exemptedPackages = PermissionManager.getIndicatorExemptedPackages(this.mContext);
        if (exemptedPackages.containsAll(this.mActivePackages) == true) goto L9;
    L11:
        boolean shouldSessionEnd = false;
    L12:
        updateSensorListener(shouldSessionEnd);
        if (shouldSessionEnd == false) goto L19;
        if (this.mLightsSession != null) goto L17;
        return;
    L17:
        this.mLightsSession.close();
        this.mLightsSession = null;
        return;
    L19:
        if (this.mLightSensor != null) goto L21;
        int lightColor = this.mColors[this.mColors.length - 1];
    L23:
        if (this.mLastLightColor == lightColor) goto L25;
    L27:
        this.mLastLightColor = lightColor;
        LightsRequest.Builder requestBuilder = new LightsRequest.Builder();
        int i = 0;
    L29:
        if (i >= this.mCameraLights.size()) goto L32;
        requestBuilder.addLight(this.mCameraLights.get(i), new LightState.Builder().setColor(lightColor).build());
        i = i + 1;
        goto L29
    L32:
        if (this.mLightsSession != null) goto L34;
        this.mLightsSession = this.mLightsManager.openSession(Integer.MAX_VALUE);
    L34:
        this.mLightsSession.requestLights(requestBuilder.build());
        return;
    L25:
        if (this.mLightsSession == null) goto L27;
        return;
    L21:
        lightColor = computeCurrentLightColor();
        goto L23
    L9:
        if (exemptedPackages.containsAll(this.mActivePhonePackages) == false) goto L11;
        shouldSessionEnd = true;
        goto L12
    }

    private int computeCurrentLightColor() {
        long liveAmbientLightTotal = getLiveAmbientLightTotal();
        long currentInterval = getCurrentIntervalMillis();
        int i = 0;
    L4:
        if (i >= this.mThresholds.length) goto L11;
        if (liveAmbientLightTotal < (this.mThresholds[i] * currentInterval)) goto L8;
        i = i + 1;
        goto L4
    L8:
        return this.mColors[i];
    L11:
        return this.mColors[this.mColors.length - 1];
    }

    private void updateSensorListener(boolean shouldSessionEnd) {
        if (shouldSessionEnd == true) goto L4;
    L6:
        if (shouldSessionEnd == false) goto L8;
        return;
    L8:
        if (this.mIsAmbientLightListenerRegistered == false) goto L10;
        return;
    L10:
        if (this.mLightSensor == null) goto L15;
        this.mSensorManager.registerListener(this, this.mLightSensor, 3, this.mHandler);
        this.mIsAmbientLightListenerRegistered = true;
        this.mElapsedTimeStartedReading = getElapsedRealTime();
        return;
    L15:
        return;
    L4:
        if (this.mIsAmbientLightListenerRegistered == false) goto L6;
        this.mSensorManager.unregisterListener(this);
        this.mIsAmbientLightListenerRegistered = false;
        goto L6
    }

    private long getElapsedRealTime() {
        if (this.mElapsedRealTime != (-1)) goto L6;
        return SystemClock.elapsedRealtime();
    L6:
        return this.mElapsedRealTime;
    }

    void setElapsedRealTime(long time) {
        this.mElapsedRealTime = time;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        addElement(TimeUnit.NANOSECONDS.toMillis(event.timestamp), Math.max(0, (int) (Math.log(event.values[0]) * LIGHT_VALUE_MULTIPLIER)));
        updateLightSession();
        this.mHandler.removeCallbacksAndMessages(this.mDelayedUpdateToken);
        this.mHandler.postDelayed(new CameraPrivacyLightController$$ExternalSyntheticLambda0(this), this.mDelayedUpdateToken, this.mMovingAverageIntervalMillis);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    private long getCurrentIntervalMillis() {
        return Math.min(this.mMovingAverageIntervalMillis, getElapsedRealTime() - this.mElapsedTimeStartedReading);
    }
}
