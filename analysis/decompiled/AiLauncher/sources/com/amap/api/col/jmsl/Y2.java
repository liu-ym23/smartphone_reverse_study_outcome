package com.amap.api.col.jmsl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.Marker;

/* loaded from: classes.dex */
public class Y2 implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    public SensorManager f16484a;

    /* renamed from: b, reason: collision with root package name */
    public Sensor f16485b;

    /* renamed from: d, reason: collision with root package name */
    public float f16487d;

    /* renamed from: e, reason: collision with root package name */
    public Context f16488e;

    /* renamed from: f, reason: collision with root package name */
    public InterfaceC1552f1 f16489f;

    /* renamed from: g, reason: collision with root package name */
    public Marker f16490g;

    /* renamed from: c, reason: collision with root package name */
    public long f16486c = 0;

    /* renamed from: h, reason: collision with root package name */
    public boolean f16491h = true;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SensorEvent f16492a;

        public a(SensorEvent sensorEvent) {
            this.f16492a = sensorEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            WindowManager windowManager;
            if (this.f16492a.sensor.getType() != 3) {
                return;
            }
            int i10 = 0;
            float f10 = this.f16492a.values[0];
            Context context = Y2.this.f16488e;
            if (context != null && (windowManager = (WindowManager) context.getSystemService("window")) != null) {
                try {
                    int rotation = windowManager.getDefaultDisplay().getRotation();
                    if (rotation == 1) {
                        i10 = 90;
                    } else if (rotation == 2) {
                        i10 = 180;
                    } else if (rotation == 3) {
                        i10 = -90;
                    }
                } catch (Throwable unused) {
                }
            }
            float f11 = (f10 + i10) % 360.0f;
            if (f11 > 180.0f) {
                f11 -= 360.0f;
            } else if (f11 < -180.0f) {
                f11 += 360.0f;
            }
            if (Math.abs(Y2.this.f16487d - f11) < 3.0f) {
                return;
            }
            Y2 y22 = Y2.this;
            if (Float.isNaN(f11)) {
                f11 = 0.0f;
            }
            y22.f16487d = f11;
            if (Y2.this.f16490g != null) {
                try {
                    if (Y2.this.f16491h) {
                        Y2.this.f16489f.H(CameraUpdateFactory.changeBearing(Y2.this.f16487d));
                        Y2.this.f16490g.setRotateAngle(-Y2.this.f16487d);
                    } else {
                        Y2.this.f16490g.setRotateAngle(360.0f - Y2.this.f16487d);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            Y2.this.f16486c = System.currentTimeMillis();
        }
    }

    public Y2(Context context, InterfaceC1552f1 interfaceC1552f1) {
        this.f16488e = context.getApplicationContext();
        this.f16489f = interfaceC1552f1;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.f16484a = sensorManager;
            if (sensorManager != null) {
                this.f16485b = sensorManager.getDefaultSensor(3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void d() {
        Sensor sensor;
        SensorManager sensorManager = this.f16484a;
        if (sensorManager == null || (sensor = this.f16485b) == null) {
            return;
        }
        sensorManager.registerListener(this, sensor, 3);
    }

    public void e(Marker marker) {
        this.f16490g = marker;
    }

    public void f(boolean z10) {
        this.f16491h = z10;
    }

    public void h() {
        Sensor sensor;
        SensorManager sensorManager = this.f16484a;
        if (sensorManager == null || (sensor = this.f16485b) == null) {
            return;
        }
        sensorManager.unregisterListener(this, sensor);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (System.currentTimeMillis() - this.f16486c < 100) {
                return;
            }
            C1534b.a().b(new a(sensorEvent));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
