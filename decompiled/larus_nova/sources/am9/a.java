package am9;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.SystemClock;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.navigation.impl.NavigationDispatcher;
import com.larus.navigation.impl.q;
import com.larus.navigation.impl.s;
import faceverify.w;
import fna.g;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f4440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f4442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SensorManager f4443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Sensor f4444f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Sensor f4445g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Sensor f4446h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4447i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f4448j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float[] f4449k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f4450l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4451m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f4452n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f4453o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f4454p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f4455q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b f4456r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float[] f4457s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float[] f4458t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float[] f4459u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d f4460v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final c f4461w;

    /* JADX INFO: renamed from: am9.a$a, reason: collision with other inner class name */
    public static final class C0089a {
    }

    public interface b {
    }

    public static final class c implements SensorEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f4462a;

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, w.BLOB_ELEM_TYPE_SENSOR);
        }

        public c(a r100) {
            this.f4462a = r100;
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            int r101 = r100.sensor.getType();
            if (r101 != 1) goto L5;
            System.arraycopy(r100.values, 0, this.f4462a.f4448j, 0, 3);
            a r102 = this.f4462a;
            r102.f4450l = true;
            r102.f4452n = r100.timestamp;
        L9:
            a r103 = this.f4462a;
            if (r103.f4450l == true) goto L12;
            return;
        L12:
            if (r103.f4451m == true) goto L15;
            return;
        L15:
            if (Math.abs(r103.f4452n - r103.f4453o) <= 100000000) goto L17;
            return;
        L17:
            a r104 = this.f4462a;
            if (SensorManager.getRotationMatrix(r104.f4457s, null, r104.f4448j, r104.f4449k) == false) goto L25;
            a r105 = this.f4462a;
            int r106 = a.d(r105, r105.f4439a);
            a r107 = this.f4462a;
            a.e(r107, r107.f4457s, r106, r107.f4458t);
            a r108 = this.f4462a;
            SensorManager.getOrientation(r108.f4458t, r108.f4459u);
            float r109 = ((float) Math.toDegrees(this.f4462a.f4459u[0])) % 360.0f;
            if (r109 >= 0.0f) goto L22;
            r109 = r109 + 360.0f;
        L22:
            a.c(this.f4462a, r109);
            return;
        L25:
            return;
        L5:
            if (r101 != 2) goto L9;
            System.arraycopy(r100.values, 0, this.f4462a.f4449k, 0, 3);
            a r110 = this.f4462a;
            r110.f4451m = true;
            r110.f4453o = r100.timestamp;
            goto L9
        }
    }

    public static final class d implements SensorEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f4463a;

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, w.BLOB_ELEM_TYPE_SENSOR);
        }

        public d(a r100) {
            this.f4463a = r100;
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            if (r100.sensor.getType() == 11) goto L5;
            return;
        L5:
            SensorManager.getRotationMatrixFromVector(this.f4463a.f4457s, r100.values);
            a r101 = this.f4463a;
            int r102 = a.d(r101, r101.f4439a);
            a r103 = this.f4463a;
            a.e(r103, r103.f4457s, r102, r103.f4458t);
            a r104 = this.f4463a;
            SensorManager.getOrientation(r104.f4458t, r104.f4459u);
            float r105 = ((float) Math.toDegrees(this.f4463a.f4459u[0])) % 360.0f;
            if (r105 >= 0.0f) goto L8;
            r105 = r105 + 360.0f;
        L8:
            a.c(this.f4463a, r105);
        }
    }

    static {
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "appContext");
        this.f4439a = r100;
        this.f4440b = 1.0f;
        this.f4441c = 50;
        this.f4442d = 0.2f;
        Object r101 = r100.getSystemService(w.BLOB_ELEM_TYPE_SENSOR);
        Sensor r102 = null;
        if ((r101 instanceof SensorManager) == false) goto L5;
        SensorManager r103 = (SensorManager) r101;
    L6:
        this.f4443e = r103;
        if (r103 == null) goto L9;
        Sensor r104 = r103.getDefaultSensor(11);
    L10:
        this.f4444f = r104;
        if (r103 == null) goto L13;
        Sensor r105 = r103.getDefaultSensor(1);
    L14:
        this.f4445g = r105;
        if (r103 == null) goto L17;
        r102 = r103.getDefaultSensor(2);
    L17:
        this.f4446h = r102;
        this.f4448j = new float[3];
        this.f4449k = new float[3];
        this.f4452n = Long.MIN_VALUE;
        this.f4453o = Long.MIN_VALUE;
        this.f4454p = Float.NaN;
        this.f4457s = new float[9];
        this.f4458t = new float[9];
        this.f4459u = new float[3];
        this.f4460v = new d(this);
        this.f4461w = new c(this);
        return;
    L13:
        r105 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public static void b(SensorManager r100, SensorEventListener r101) {
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

    public static final void c(a r110, float r111) {
        r110.getClass();
        long r100 = SystemClock.elapsedRealtime();
        if (Float.isNaN(r110.f4454p) == true) goto L14;
        float r101 = r110.f4454p;
        float r112 = (r111 - r101) % 360.0f;
        if (r112 >= (-180.0f)) goto L8;
        r112 = r112 + 360.0f;
    L10:
        float r102 = (r101 + (r110.f4442d * r112)) % 360.0f;
        if (r102 >= 0.0f) goto L13;
        r102 = r102 + 360.0f;
    L13:
        r111 = r102;
        goto L14
    L8:
        if (r112 <= 180.0f) goto L10;
        r112 = r112 - 360.0f;
    L14:
        boolean r103 = false;
        if (Float.isNaN(r110.f4454p) == true) goto L26;
        float r104 = (r111 - r110.f4454p) % 360.0f;
        if (r104 >= (-180.0f)) goto L20;
        r104 = r104 + 360.0f;
    L23:
        if (Math.abs(r104) >= r110.f4440b) goto L26;
        boolean r105 = false;
    L28:
        if ((r100 - r110.f4455q) < r110.f4441c) goto L30;
        r103 = true;
    L30:
        if (r105 == false) goto L39;
        if (r103 == false) goto L40;
        r110.f4454p = r111;
        r110.f4455q = r100;
        float r113 = (360.0f - r111) % 360.0f;
        if (r113 >= 0.0f) goto L35;
        r113 = r113 + 360.0f;
    L35:
        b r114 = r110.f4456r;
        if (r114 == null) goto L41;
        s r115 = ((q) r114).f359953a;
        r115.f359956a.d(r115.f359959d, r113);
        NavigationDispatcher.a r116 = NavigationDispatcher.f359763e;
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L20:
        if (r104 <= 180.0f) goto L23;
        r104 = r104 - 360.0f;
    L26:
        r105 = true;
        goto L28
    }

    public static final int d(a r100, Context r101) {
        r100.getClass();
        int r102 = 0;
        WindowManager r103 = null;
        if (Build.VERSION.SDK_INT >= 30) goto L32;
    L23:
        Object r104 = r101.getSystemService(LiveEndPageData.TAG_WINDOW);
        if ((r104 instanceof WindowManager) == false) goto L26;
        r103 = (WindowManager) r104;
    L26:
        if (r103 == null) goto L31;
        Display r105 = r103.getDefaultDisplay();
        if (r105 == null) goto L31;
        r102 = r105.getRotation();
    L31:
        return r102;
    L32:
        Display r106 = r101.getDisplay();     // Catch: UnsupportedOperationException -> L8
        if (r106 == null) goto L9;
        return r106.getRotation();
    L9:
        Object r107 = r101.getSystemService("display");
        if ((r107 instanceof DisplayManager) == false) goto L12;
        DisplayManager r108 = (DisplayManager) r107;
    L13:
        if (r108 == null) goto L17;
        Display r109 = r108.getDisplay(0);
        if (r109 == null) goto L17;
        return r109.getRotation();
    L17:
        if (r108 == null) goto L23;
        Display[] r110 = r108.getDisplays();
        if (r110 == null) goto L23;
        Display r111 = (Display) ArraysKt.firstOrNull(r110);
        if (r111 == null) goto L23;
        return r111.getRotation();
    L12:
        r108 = null;
        goto L13
    }

    public static boolean a(SensorManager r100, SensorEventListener r101, Sensor r102) {
        if (g.d() == true) goto L6;
        Boolean r103 = Boolean.valueOf(r100.registerListener(r101, r102, 1, null));
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Boolean");
        return r103.booleanValue();
    L6:
        Boolean r104 = Boolean.valueOf(r100.registerListener(r101, r102, 1, null));
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r105 = r104.booleanValue();
        int r106 = 0;
        if (r101 == null) goto L9;
        int r107 = r101.hashCode();
    L10:
        if (r102 == null) goto L12;
        r106 = r102.hashCode();
    L12:
        ona.b.a(new ona.a(r107, Integer.valueOf(r106)));
        return r105;
    L9:
        r107 = 0;
        goto L10
    }

    public static final void e(a r100, float[] r101, int r102, float[] r103) {
        r100.getClass();
        if (r102 != 0) goto L5;
        SensorManager.remapCoordinateSystem(r101, 1, 2, r103);
        return;
    L5:
        if (r102 != 1) goto L7;
        SensorManager.remapCoordinateSystem(r101, 2, 129, r103);
        return;
    L7:
        if (r102 != 2) goto L9;
        SensorManager.remapCoordinateSystem(r101, 129, 130, r103);
        return;
    L9:
        if (r102 == 3) goto L11;
        SensorManager.remapCoordinateSystem(r101, 1, 2, r103);
        return;
    L11:
        SensorManager.remapCoordinateSystem(r101, 130, 1, r103);
    }
}
