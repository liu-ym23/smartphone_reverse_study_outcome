package com.android.server.display;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.util.IndentingPrintWriter;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class ScreenOffBrightnessSensorController implements SensorEventListener {
    private static final int SENSOR_INVALID_VALUE = -1;
    private static final long SENSOR_VALUE_VALID_TIME_MILLIS = 1500;
    private static final String TAG = "ScreenOffBrightnessSensorController";
    private final BrightnessMappingStrategy mBrightnessMapper;
    private final Clock mClock;
    private final Handler mHandler;
    private int mLastSensorValue;
    private final Sensor mLightSensor;
    private boolean mRegistered;
    private long mSensorDisableTime;
    private final SensorManager mSensorManager;
    private final int[] mSensorValueToLux;

    public interface Clock {
        long uptimeMillis();
    }

    public ScreenOffBrightnessSensorController(SensorManager sensorManager, Sensor lightSensor, Handler handler, Clock clock, int[] sensorValueToLux, BrightnessMappingStrategy brightnessMapper) {
        this.mLastSensorValue = -1;
        this.mSensorDisableTime = -1;
        this.mSensorManager = sensorManager;
        this.mLightSensor = lightSensor;
        this.mHandler = handler;
        this.mClock = clock;
        this.mSensorValueToLux = sensorValueToLux;
        this.mBrightnessMapper = brightnessMapper;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        if (this.mRegistered == false) goto L6;
        this.mLastSensorValue = (int) event.values[0];
        return;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void setLightSensorEnabled(boolean enabled) {
        if (enabled == true) goto L4;
    L6:
        if (enabled == false) goto L8;
        return;
    L8:
        if (this.mRegistered == false) goto L13;
        this.mSensorManager.unregisterListener(this);
        this.mRegistered = false;
        this.mSensorDisableTime = this.mClock.uptimeMillis();
        return;
    L13:
        return;
    L4:
        if (this.mRegistered == true) goto L6;
        this.mRegistered = this.mSensorManager.registerListener(this, this.mLightSensor, 3, this.mHandler);
        this.mLastSensorValue = -1;
    }

    public void stop() {
        setLightSensorEnabled(false);
    }

    public float getAutomaticScreenBrightness() {
        if (this.mLastSensorValue >= 0) goto L5;
    L16:
        return Float.NaN;
    L5:
        if (this.mLastSensorValue >= this.mSensorValueToLux.length) goto L16;
        if (this.mRegistered == false) goto L9;
    L11:
        int lux = this.mSensorValueToLux[this.mLastSensorValue];
        if (lux >= 0) goto L15;
        return Float.NaN;
    L15:
        return this.mBrightnessMapper.getBrightness(lux);
    L9:
        if ((this.mClock.uptimeMillis() - this.mSensorDisableTime) <= SENSOR_VALUE_VALID_TIME_MILLIS) goto L11;
        goto L11
    }

    public void dump(PrintWriter pw) {
        pw.println("Screen Off Brightness Sensor Controller:");
        pw.println("----------------------------------------");
        IndentingPrintWriter idpw = new IndentingPrintWriter(pw);
        idpw.increaseIndent();
        idpw.println("registered=" + this.mRegistered);
        idpw.println("lastSensorValue=" + this.mLastSensorValue);
    }
}
