package com.baidu.vi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import java.util.List;

/* loaded from: classes.dex */
public class VCompass {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    private static final Handler f9476a = new a();

    /* renamed from: c, reason: collision with root package name */
    private float f9478c;

    /* renamed from: b, reason: collision with root package name */
    private SensorManager f9477b = null;

    /* renamed from: d, reason: collision with root package name */
    private float f9479d = 2.0f;

    /* renamed from: e, reason: collision with root package name */
    private int f9480e = 0;

    /* renamed from: f, reason: collision with root package name */
    private SensorEventListener f9481f = new b();

    public static class a extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            VCompass vCompass = (VCompass) message.obj;
            if (vCompass == null) {
                return;
            }
            int i4 = message.what;
            if (i4 != 1) {
                if (i4 != 2) {
                    return;
                }
                vCompass.f9477b.unregisterListener(vCompass.f9481f);
                return;
            }
            Context context = VIContext.getContext();
            if (vCompass.f9477b == null) {
                vCompass.f9477b = (SensorManager) context.getSystemService("sensor");
            }
            List<Sensor> sensorList = vCompass.f9477b.getSensorList(3);
            if (sensorList.size() > 0) {
                vCompass.f9477b.registerListener(vCompass.f9481f, sensorList.get(0), 1);
            }
        }
    }

    public class b implements SensorEventListener {
        public b() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() != 3) {
                return;
            }
            VCompass.this.updateCompass((int) VCompass.this.a(sensorEvent.values[0]));
        }
    }

    private float a(float f4, float f5, float f6) {
        float f7 = f4 - f5;
        return (f7 > 180.0f || f7 < -180.0f) ? f5 : (f7 < (-f6) || f6 < f7) ? (f4 + f5) / 2.0f : f4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void updateCompass(int i4);

    /* JADX INFO: Access modifiers changed from: private */
    public float a(float f4) {
        float fA = a(this.f9478c, f4, this.f9479d);
        this.f9478c = fA;
        return fA;
    }
}
