package com.android.server.display.brightness.clamper;

import android.R;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Slog;
import com.android.server.am.HostingRecord;
import com.android.server.display.config.SensorData;
import com.android.server.display.utils.AmbientFilter;
import com.android.server.display.utils.AmbientFilterFactory;
import com.android.server.display.utils.DebugUtils;
import com.android.server.display.utils.SensorUtils;
import com.android.server.media.projection.IMediaProjectionManagerServiceExt;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class LightSensorController {
    private static final boolean DEBUG = false;
    static final float INVALID_LUX = -1.0f;
    private static final String TAG = "LightSensorController";
    private final AmbientFilter mAmbientFilter;
    private final Handler mHandler;
    private final Injector mInjector;
    private Sensor mLightSensor;
    private final SensorEventListener mLightSensorEventListener;
    private final LightSensorListener mLightSensorListener;
    private final int mLightSensorRate;
    private Sensor mRegisteredLightSensor;
    private final SensorManager mSensorManager;

    static class Injector {
        Injector() {
        }

        Sensor getLightSensor(SensorManager sensorManager, SensorData sensorData, int fallbackType) {
            return SensorUtils.findSensor(sensorManager, sensorData, fallbackType);
        }

        AmbientFilter getAmbientFilter(Resources resources) {
            return AmbientFilterFactory.createBrightnessFilter(LightSensorController.TAG, resources);
        }

        int getLightSensorRate(Resources resources) {
            return resources.getInteger(R.integer.config_bg_current_drain_location_min_duration);
        }

        long getTime() {
            return SystemClock.elapsedRealtime();
        }
    }

    interface LightSensorListener {
        void onAmbientLuxChange(float r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAmbientFilter, reason: not valid java name */
    static /* bridge */ /* synthetic */ AmbientFilter m4007$$Nest$fgetmAmbientFilter(LightSensorController r0) {
        return r0.mAmbientFilter;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInjector, reason: not valid java name */
    static /* bridge */ /* synthetic */ Injector m4008$$Nest$fgetmInjector(LightSensorController r0) {
        return r0.mInjector;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLightSensorListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ LightSensorListener m4009$$Nest$fgetmLightSensorListener(LightSensorController r0) {
        return r0.mLightSensorListener;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRegisteredLightSensor, reason: not valid java name */
    static /* bridge */ /* synthetic */ Sensor m4010$$Nest$fgetmRegisteredLightSensor(LightSensorController r0) {
        return r0.mRegisteredLightSensor;
    }

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
    }

    LightSensorController(SensorManager sensorManager, Resources resources, LightSensorListener listener, Handler handler) {
        this(sensorManager, resources, listener, handler, new Injector());
    }

    LightSensorController(SensorManager sensorManager, Resources resources, LightSensorListener listener, Handler handler, Injector injector) {
        this.mRegisteredLightSensor = null;
        this.mLightSensorEventListener = new AnonymousClass1(this);
        this.mSensorManager = sensorManager;
        this.mLightSensorRate = injector.getLightSensorRate(resources);
        this.mAmbientFilter = injector.getAmbientFilter(resources);
        this.mLightSensorListener = listener;
        this.mHandler = handler;
        this.mInjector = injector;
    }

    void restart() {
        if (this.mRegisteredLightSensor != this.mLightSensor) goto L6;
        return;
    L6:
        if (this.mLightSensor == null) goto L9;
        this.mSensorManager.registerListener(this.mLightSensorEventListener, this.mLightSensor, this.mLightSensorRate * 1000, this.mHandler);
    L9:
        if (this.mRegisteredLightSensor == null) goto L11;
        stop();
    L11:
        this.mRegisteredLightSensor = this.mLightSensor;
        if (DEBUG == false) goto L15;
        Slog.d(TAG, HostingRecord.HOSTING_TYPE_RESTART);
        return;
    }

    void stop() {
        if (this.mRegisteredLightSensor != null) goto L5;
        return;
    L5:
        this.mSensorManager.unregisterListener(this.mLightSensorEventListener, this.mRegisteredLightSensor);
        this.mRegisteredLightSensor = null;
        this.mAmbientFilter.clear();
        this.mLightSensorListener.onAmbientLuxChange(-1.0f);
        if (DEBUG == false) goto L9;
        Slog.d(TAG, IMediaProjectionManagerServiceExt.NODE_STOP);
        return;
    }

    void configure(SensorData sensorData, int displayId) {
        if (displayId != 0) goto L4;
        int fallbackType = 5;
    L5:
        this.mLightSensor = this.mInjector.getLightSensor(this.mSensorManager, sensorData, fallbackType);
        return;
    L4:
        fallbackType = 0;
        goto L5
    }

    void dump(PrintWriter writer) {
        writer.println(TAG);
        writer.println("  mLightSensor=" + this.mLightSensor);
        writer.println("  mRegisteredLightSensor=" + this.mRegisteredLightSensor);
    }
}
