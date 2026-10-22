package com.bytedance.applet.aibridge.baidunavi;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.xiaomi.mipush.sdk.MiPushClient;
import faceverify.w;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f190954a = 0;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f190955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C2770a f190956b;

        /* JADX INFO: renamed from: com.bytedance.applet.aibridge.baidunavi.h$a$a, reason: collision with other inner class name */
        public static final class C2770a implements SensorEventListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f190957a;

            public C2770a(a r100) {
                this.f190957a = r100;
            }

            @Override // android.hardware.SensorEventListener
            public final void onSensorChanged(SensorEvent r100) {
                Intrinsics.checkNotNullParameter(r100, "event");
                FLogger.f375446a.i("sensor_util", "onSensorChanged:[" + r100.values + ']');
                Float r101 = ArraysKt.firstOrNull(r100.values);
                if (r101 == null) goto L8;
                float r102 = r101.floatValue();
                if (Math.abs(this.f190957a.f190955a - r102) < 1.0f) goto L9;
                a r103 = this.f190957a;
                r103.f190955a = r102;
                r103.a(r102);
                return;
            L9:
                return;
            }

            @Override // android.hardware.SensorEventListener
            public final void onAccuracyChanged(Sensor r100, int r101) {
                FLogger r102 = FLogger.f375446a;
                StringBuilder r103 = new StringBuilder("onAccuracyChanged:[");
                if (r100 == null) goto L5;
                Integer r104 = Integer.valueOf(r100.getType());
            L6:
                r103.append(r104);
                r103.append("][");
                r103.append(r101);
                r103.append(']');
                r102.i("sensor_util", r103.toString());
                return;
            L5:
                r104 = null;
                goto L6
            }
        }

        public abstract void a(float r100);

        public a() {
            this.f190956b = new C2770a(this);
        }
    }

    static {
    }

    public static boolean a(Context r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        Object r102 = r100.getSystemService(w.BLOB_ELEM_TYPE_SENSOR);
        if ((r102 instanceof SensorManager) == false) goto L5;
        SensorManager r103 = (SensorManager) r102;
    L6:
        boolean r104 = false;
        if (r103 != null) goto L10;
        FLogger.f375446a.e("sensor_util", "no sensor mgr");
        return false;
    L10:
        Sensor r105 = r103.getDefaultSensor(3);
        if (r105 == null) goto L13;
        r103.registerListener(r101.f190956b, r105, 2);
    L13:
        if (r105 == null) goto L15;
        r104 = true;
    L15:
        FLogger.f375446a.i("sensor_util", "register:" + r104);
        return r104;
    L5:
        r103 = null;
        goto L6
    }

    public static void b(Context r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        FLogger r102 = FLogger.f375446a;
        r102.e("sensor_util", MiPushClient.COMMAND_UNREGISTER);
        Object r103 = r100.getSystemService(w.BLOB_ELEM_TYPE_SENSOR);
        if ((r103 instanceof SensorManager) == false) goto L5;
        SensorManager r104 = (SensorManager) r103;
    L6:
        if (r104 != null) goto L9;
        r102.e("sensor_util", "no sensor mgr");
        return;
    L9:
        a.C2770a r105 = r101.f190956b;
        if (fna.g.d() == true) goto L12;
        r104.unregisterListener(r105);
        return;
    L12:
        r104.unregisterListener(r105);
        if (r105 == null) goto L15;
        int r106 = r105.hashCode();
    L16:
        ona.b.c(new ona.a(r106, null));
        return;
    L15:
        r106 = 0;
        goto L16
    L5:
        r104 = null;
        goto L6
    }
}
