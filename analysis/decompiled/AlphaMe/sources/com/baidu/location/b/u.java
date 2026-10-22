package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public class u implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private float[] f5480a;

    /* renamed from: b, reason: collision with root package name */
    private SensorManager f5481b;

    /* renamed from: c, reason: collision with root package name */
    private float f5482c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5483d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f5484e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5485f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5486g;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final u f5487a = new u();
    }

    private u() {
        this.f5483d = false;
        this.f5484e = false;
        this.f5485f = false;
        this.f5486g = false;
    }

    public static u a() {
        return a.f5487a;
    }

    public synchronized void b() {
        Sensor defaultSensor;
        try {
            if (this.f5486g) {
                return;
            }
            if (this.f5483d || f()) {
                if (this.f5481b == null) {
                    this.f5481b = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
                }
                SensorManager sensorManager = this.f5481b;
                if (sensorManager != null && (defaultSensor = sensorManager.getDefaultSensor(11)) != null && (this.f5483d || f())) {
                    this.f5481b.registerListener(this, defaultSensor, 3);
                }
                this.f5486g = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void c() {
        try {
            if (this.f5486g) {
                if (f()) {
                    return;
                }
                SensorManager sensorManager = this.f5481b;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(this);
                    this.f5481b = null;
                }
                this.f5486g = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean d() {
        return this.f5483d;
    }

    public float e() {
        return this.f5482c;
    }

    public boolean f() {
        return this.f5485f;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i4) {
    }

    @Override // android.hardware.SensorEventListener
    @SuppressLint({"NewApi"})
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() != 11) {
            return;
        }
        float[] fArr = (float[]) sensorEvent.values.clone();
        this.f5480a = fArr;
        float[] fArr2 = new float[9];
        try {
            SensorManager.getRotationMatrixFromVector(fArr2, fArr);
            SensorManager.getOrientation(fArr2, new float[3]);
            float degrees = (float) Math.toDegrees(r5[0]);
            this.f5482c = degrees;
            if (degrees < Property.DEFAULT_FLOAT_VALUE) {
                degrees += 360.0f;
            }
            this.f5482c = (float) Math.floor(degrees);
        } catch (Exception unused) {
            this.f5482c = Property.DEFAULT_FLOAT_VALUE;
        }
    }

    public void a(boolean z4) {
        this.f5483d = z4;
    }
}
