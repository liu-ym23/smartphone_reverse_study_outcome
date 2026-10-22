package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.Utils;

/* loaded from: classes.dex */
public class AmapSensorManager implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private Context f18270a;

    /* renamed from: b, reason: collision with root package name */
    SensorManager f18271b;

    /* renamed from: c, reason: collision with root package name */
    Sensor f18272c;

    /* renamed from: d, reason: collision with root package name */
    Sensor f18273d;

    /* renamed from: e, reason: collision with root package name */
    Sensor f18274e;
    public boolean isRegisterSensorEventListener = false;
    public double mAltitude = 0.0d;
    public float mPressure = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private float f18275f = 1013.25f;

    /* renamed from: g, reason: collision with root package name */
    private float f18276g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    Handler f18277h = new Handler();

    /* renamed from: i, reason: collision with root package name */
    double f18278i = 0.0d;

    /* renamed from: j, reason: collision with root package name */
    double f18279j = 0.0d;

    /* renamed from: k, reason: collision with root package name */
    double f18280k = 0.0d;

    /* renamed from: l, reason: collision with root package name */
    double f18281l = 0.0d;

    /* renamed from: m, reason: collision with root package name */
    double[] f18282m = new double[3];

    /* renamed from: n, reason: collision with root package name */
    volatile double f18283n = 0.0d;

    /* renamed from: o, reason: collision with root package name */
    long f18284o = 0;

    /* renamed from: p, reason: collision with root package name */
    long f18285p = 0;

    public AmapSensorManager(Context context) {
        this.f18270a = null;
        this.f18271b = null;
        this.f18272c = null;
        this.f18273d = null;
        this.f18274e = null;
        try {
            this.f18270a = context;
            if (this.f18271b == null) {
                this.f18271b = (SensorManager) context.getSystemService("sensor");
            }
            try {
                this.f18272c = this.f18271b.getDefaultSensor(6);
            } catch (Throwable unused) {
            }
            try {
                this.f18273d = this.f18271b.getDefaultSensor(11);
            } catch (Throwable unused2) {
            }
            try {
                this.f18274e = this.f18271b.getDefaultSensor(1);
            } catch (Throwable unused3) {
            }
        } catch (Throwable th) {
            CoreUtil.reportError(th, "AMapSensorManager", "<init>");
        }
    }

    private void a(float[] fArr) {
        double[] dArr = this.f18282m;
        double d10 = dArr[0] * 0.800000011920929d;
        float f10 = fArr[0];
        double d11 = d10 + (f10 * 0.19999999f);
        dArr[0] = d11;
        double d12 = dArr[1] * 0.800000011920929d;
        float f11 = fArr[1];
        double d13 = d12 + (f11 * 0.19999999f);
        dArr[1] = d13;
        double d14 = dArr[2] * 0.800000011920929d;
        float f12 = fArr[2];
        double d15 = d14 + (0.19999999f * f12);
        dArr[2] = d15;
        this.f18278i = f10 - d11;
        this.f18279j = f11 - d13;
        this.f18280k = f12 - d15;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f18284o < 100) {
            return;
        }
        double d16 = this.f18278i;
        double d17 = this.f18279j;
        double d18 = (d16 * d16) + (d17 * d17);
        double d19 = this.f18280k;
        double dSqrt = Math.sqrt(d18 + (d19 * d19));
        this.f18285p++;
        this.f18284o = jCurrentTimeMillis;
        this.f18283n += dSqrt;
        if (this.f18285p >= 30) {
            this.f18281l = this.f18283n / this.f18285p;
            this.f18283n = 0.0d;
            this.f18285p = 0L;
        }
    }

    public void destroy() {
        try {
            stopListener();
            this.f18272c = null;
            this.f18273d = null;
            this.f18271b = null;
            this.f18274e = null;
            this.isRegisterSensorEventListener = false;
        } catch (Throwable th) {
            CoreUtil.reportError(th, "AMapSensorManager", "destroy");
        }
    }

    public double getAltitude() {
        return this.mAltitude;
    }

    public float getBearing() {
        return this.f18276g;
    }

    public float getPressure() {
        return this.mPressure;
    }

    public double getSpeed() {
        return this.f18281l;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent == null) {
            return;
        }
        try {
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                if (this.f18274e != null) {
                    a((float[]) sensorEvent.values.clone());
                    return;
                }
                return;
            }
            if (type == 6) {
                if (this.f18272c != null) {
                    this.mPressure = ((float[]) sensorEvent.values.clone())[0];
                    this.mAltitude = Utils.formatFloatKeep2Point(SensorManager.getAltitude(this.f18275f, r4));
                    return;
                }
                return;
            }
            if (type == 11 && this.f18273d != null) {
                float[] fArr = new float[9];
                SensorManager.getRotationMatrixFromVector(fArr, (float[]) sensorEvent.values.clone());
                SensorManager.getOrientation(fArr, new float[3]);
                float degrees = (float) Math.toDegrees(r4[0]);
                this.f18276g = degrees;
                if (degrees <= 0.0f) {
                    degrees += 360.0f;
                }
                this.f18276g = (float) Math.floor(degrees);
            }
        } catch (Throwable unused) {
        }
    }

    public void startListener() {
        SensorManager sensorManager = this.f18271b;
        if (sensorManager == null || this.isRegisterSensorEventListener) {
            return;
        }
        this.isRegisterSensorEventListener = true;
        try {
            Sensor sensor = this.f18272c;
            if (sensor != null) {
                sensorManager.registerListener(this, sensor, 3, this.f18277h);
            }
        } catch (Throwable th) {
            CoreUtil.reportError(th, "AMapSensorManager", "registerListener mPressure");
        }
        try {
            Sensor sensor2 = this.f18273d;
            if (sensor2 != null) {
                this.f18271b.registerListener(this, sensor2, 3, this.f18277h);
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "AMapSensorManager", "registerListener mRotationVector");
        }
        try {
            Sensor sensor3 = this.f18274e;
            if (sensor3 != null) {
                this.f18271b.registerListener(this, sensor3, 3, this.f18277h);
            }
        } catch (Throwable th3) {
            CoreUtil.reportError(th3, "AMapSensorManager", "registerListener mAcceleroMeterVector");
        }
    }

    public void stopListener() {
        SensorManager sensorManager = this.f18271b;
        if (sensorManager == null || !this.isRegisterSensorEventListener) {
            return;
        }
        this.isRegisterSensorEventListener = false;
        try {
            Sensor sensor = this.f18272c;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
            }
        } catch (Throwable unused) {
        }
        try {
            Sensor sensor2 = this.f18273d;
            if (sensor2 != null) {
                this.f18271b.unregisterListener(this, sensor2);
            }
        } catch (Throwable unused2) {
        }
        try {
            Sensor sensor3 = this.f18274e;
            if (sensor3 != null) {
                this.f18271b.unregisterListener(this, sensor3);
            }
        } catch (Throwable unused3) {
        }
    }
}
