package com.baidu.vi;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import faceverify.w;
import fna.g;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class VCompass {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f33565a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SensorManager f33566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f33567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f33568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f33569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SensorEventListener f33570f;

    public static class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            VCompass r101 = (VCompass) r100.obj;
            if (r101 != null) goto L5;
            return;
        L5:
            int r102 = r100.what;
            if (r102 != 1) goto L8;
            Context r103 = VIContext.getContext();
            if (VCompass.a(r101) != null) goto L14;
            VCompass.a(r101, (SensorManager) r103.getSystemService(w.BLOB_ELEM_TYPE_SENSOR));
        L14:
            List<Sensor> r104 = VCompass.a(r101).getSensorList(3);
            if (r104.size() <= 0) goto L19;
            Sensor r105 = (Sensor) ListProtector.get(r104, 0);
            VCompass.a(r101).registerListener(VCompass.b(r101), r105, 1);
            return;
        L19:
            return;
        L8:
            if (r102 != 2) goto L20;
            INVOKEVIRTUAL_com_baidu_vi_VCompass$a_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(VCompass.a(r101), VCompass.b(r101));
            return;
        }

        public static void INVOKEVIRTUAL_com_baidu_vi_VCompass$a_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(SensorManager r100, SensorEventListener r101) {
            if (g.d() == true) goto L6;
            r100.unregisterListener(r101);
            return;
        L6:
            r100.unregisterListener(r101);
            if (r101 == null) goto L9;
            int r102 = r101.hashCode();
        L10:
            ona.b.c(new ona.a(r102, null));
            return;
        L9:
            r102 = 0;
            goto L10
        }
    }

    public class b implements SensorEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VCompass f33571a;

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor r100, int r101) {
        }

        public b(VCompass r100) {
            this.f33571a = r100;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent r100) {
            if (r100.sensor.getType() != 3) goto L7;
            int r101 = (int) VCompass.a(this.f33571a, r100.values[0]);
            VCompass.a(this.f33571a, r101);
            return;
        }
    }

    private float a(float r100, float r101, float r102) {
        float r103 = r100 - r101;
        if (r103 <= 180.0f) goto L5;
    L15:
        return r101;
    L5:
        if (r103 < (-180.0f)) goto L15;
        if (r103 < (-r102)) goto L14;
        if (r102 < r103) goto L14;
        return r100;
    L14:
        return (r100 + r101) / 2.0f;
    }

    private native void updateCompass(int r100);

    static {
        f33565a = new a();
    }

    public VCompass() {
        this.f33566b = null;
        this.f33568d = 2.0f;
        this.f33569e = 0;
        this.f33570f = new b(this);
    }

    private float a(float r100) {
        float r101 = a(this.f33567c, r100, this.f33568d);
        this.f33567c = r101;
        return r101;
    }

    public static /* synthetic */ SensorEventListener b(VCompass r100) {
        return r100.f33570f;
    }

    public static /* synthetic */ SensorManager a(VCompass r100) {
        return r100.f33566b;
    }

    public static /* synthetic */ float a(VCompass r100, float r101) {
        return r100.a(r101);
    }

    public static /* synthetic */ void a(VCompass r100, int r101) {
        r100.updateCompass(r101);
    }

    public static /* synthetic */ SensorManager a(VCompass r100, SensorManager r101) {
        r100.f33566b = r101;
        return r101;
    }
}
