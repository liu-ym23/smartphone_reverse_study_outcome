package com.bytedance.android.livesdk.player.surfacecontrol.dbr;

import android.hardware.HardwareBuffer;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.core.util.Pools;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class SyncSurfaceControlRender implements com.bytedance.android.livesdk.player.surfacecontrol.dbr.c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f156136n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile SurfaceControlCompat f156137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Surface f156138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<SurfaceView> f156139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f156140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @MODE
    public int f156141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f156142f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f156143g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f156144h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SurfaceControlCompat.Transaction f156145i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f156146j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f156147k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f156148l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f156149m;

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/player/surfacecontrol/dbr/SyncSurfaceControlRender$MODE;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MODE {
        public static final int BUFFER = 2;
        public static final a Companion = null;
        public static final int SURFACE = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f156150a = null;

            public a() {
            }

            static {
                f156150a = new a();
            }
        }

        static {
            Companion = a.f156150a;
        }
    }

    public static final class a {
        public static SyncSurfaceControlRender a(String r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "name");
            if (r101 <= 0) goto L8;
            if (r102 <= 0) goto L10;
            SyncSurfaceControlRender r103 = new SyncSurfaceControlRender();
            r103.f156137a = new SurfaceControlCompat(new SurfaceControl.Builder().setName(r100).setBufferSize(r101, r102).setOpaque(false));
            return r103;
        L10:
            return null;
        L8:
            return null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Pools.SimplePool f156151a;

        /* JADX WARN: Multi-variable type inference failed */
        public final SurfaceControlCompat.Transaction a() {
            SurfaceControlCompat.Transaction r100 = (SurfaceControlCompat.Transaction) this.f156151a.acquire();     // Catch: Exception -> L8
            if (r100 == null) goto L16;
        L11:
            if (r100 == null) goto L13;
            return r100;
        L13:
            return new SurfaceControlCompat.Transaction();
        L16:
            r100 = new SurfaceControlCompat.Transaction();     // Catch: Exception -> L6
        L6:
            Exception e100 = e;
        L10:
            e100.printStackTrace();
        L8:
            e = move-exception;
            e100 = e;
            r100 = null;
            goto L10
        }

        public b() {
            this.f156151a = new Pools.SimplePool(3);
        }

        public final void b(SurfaceControlCompat.Transaction r100) {
            Intrinsics.checkNotNullParameter(r100, "transaction");
            boolean r101 = this.f156151a.release(r100);     // Catch: Exception -> L5
        L7:
            if (r101 == true) goto L12;
            r100.f156093a.close();
            return;
        L12:
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            r101 = false;
            goto L7
        }
    }

    public static final class c implements SurfaceHolder.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SyncSurfaceControlRender f156152a;

        public c(SyncSurfaceControlRender r100) {
            this.f156152a = r100;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder r100) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            WeakReference<SurfaceView> r101 = this.f156152a.f156139c;
            if (r101 == null) goto L25;
            SurfaceView r102 = r101.get();
            if (r102 == null) goto L26;
            SurfaceHolder r103 = r102.getHolder();
            if (r103 == null) goto L27;
            WeakReference<SurfaceView> r104 = this.f156152a.f156139c;
            if (r104 == null) goto L13;
            SurfaceView r105 = r104.get();
            if (r105 == null) goto L13;
            SurfaceHolder r106 = r105.getHolder();
        L15:
            if (Intrinsics.areEqual(r103, r106) == true) goto L18;
            r103 = null;
        L18:
            if (r103 == null) goto L28;
            WeakReference<SurfaceView> r107 = this.f156152a.f156139c;
            if (r107 == null) goto L29;
            SurfaceView r108 = r107.get();
            if (r108 == null) goto L30;
            this.f156152a.j(r108);
            return;
        L30:
            return;
        L29:
            return;
        L28:
            return;
        L13:
            r106 = null;
            goto L15
        L27:
            return;
        L26:
            return;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder r100) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            this.f156152a.getClass();
            Intrinsics.checkNotNullParameter("surfaceDestroyed", "msg");
            WeakReference<SurfaceView> r101 = this.f156152a.f156139c;
            SurfaceView r102 = null;
            if (r101 == null) goto L7;
            SurfaceView r103 = r101.get();
            if (r103 == null) goto L7;
            SurfaceHolder r104 = r103.getHolder();
        L9:
            if (Intrinsics.areEqual(r104, r100) == false) goto L14;
            SyncSurfaceControlRender r105 = this.f156152a;
            if (r105.f156149m == false) goto L13;
            r105.release();
            this.f156152a.getClass();
            Intrinsics.checkNotNullParameter("surfaceDestroyed: release1", "msg");
            return;
        L13:
            r105.g();
            return;
        L14:
            WeakReference<SurfaceView> r106 = this.f156152a.f156139c;
            if (r106 == null) goto L17;
            r102 = r106.get();
        L17:
            if (r102 != null) goto L24;
            SyncSurfaceControlRender r107 = this.f156152a;
            if (r107.f156149m == false) goto L25;
            r107.release();
            this.f156152a.getClass();
            Intrinsics.checkNotNullParameter("surfaceDestroyed: release2", "msg");
            return;
        L25:
            return;
        L24:
            return;
        L7:
            r104 = null;
            goto L9
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            this.f156152a.getClass();
            Intrinsics.checkNotNullParameter("surfaceChanged: " + r101 + ' ' + r102 + ' ' + r103, "msg");
            WeakReference<SurfaceView> r104 = this.f156152a.f156139c;
            if (r104 == null) goto L25;
            SurfaceView r105 = r104.get();
            if (r105 == null) goto L26;
            SurfaceHolder r106 = r105.getHolder();
            if (r106 == null) goto L27;
            WeakReference<SurfaceView> r107 = this.f156152a.f156139c;
            if (r107 == null) goto L13;
            SurfaceView r108 = r107.get();
            if (r108 == null) goto L13;
            SurfaceHolder r109 = r108.getHolder();
        L15:
            if (Intrinsics.areEqual(r106, r109) == true) goto L18;
            r106 = null;
        L18:
            if (r106 == null) goto L28;
            WeakReference<SurfaceView> r110 = this.f156152a.f156139c;
            if (r110 != null) goto L22;
            return;
        L22:
            if (r110.get() == null) goto L30;
            this.f156152a.c();
            return;
        L30:
            return;
        L28:
            return;
        L13:
            r109 = null;
            goto L15
        L27:
            return;
        L26:
            return;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SyncSurfaceControlRender f156153a;

        public d(SyncSurfaceControlRender r100) {
            this.f156153a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f156153a.c();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void c() {
        Object r100 = this.f156148l;
        monitor-enter(r100);
        SurfaceControlCompat r101 = this.f156137a;     // Catch: Throwable -> L31
        if (r101 == null) goto L29;
        WeakReference<SurfaceView> r102 = this.f156139c;     // Catch: Throwable -> L31
        if (r102 == null) goto L29;
        SurfaceView r103 = r102.get();     // Catch: Throwable -> L31
        if (r103 == null) goto L29;
        if (this.f156142f > 0) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == true) goto L19;
        r103 = null;
    L19:
        if (r103 == null) goto L29;
        int r105 = this.f156141e;     // Catch: Throwable -> L31
        if (r105 != 2) goto L26;
        int r106 = r103.getWidth();     // Catch: Throwable -> L31
        int r107 = r103.getHeight();     // Catch: Throwable -> L31
        float r108 = (r106 * 1.0f) / this.f156142f;     // Catch: Throwable -> L31
        float r109 = (r107 * 1.0f) / this.f156143g;     // Catch: Throwable -> L31
        SurfaceControlCompat.Transaction r110 = this.f156140d.a();     // Catch: Throwable -> L31
        if (Build.VERSION.SDK_INT < 33) goto L25;
        r110.f(r101, r108, r109);     // Catch: Throwable -> L31
    L25:
        r110.a();     // Catch: Throwable -> L31
        this.f156140d.b(r110);     // Catch: Throwable -> L31
    L28:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L31
        goto L29
    L26:
        if (r105 != 1) goto L28;
        SurfaceControlCompat.Transaction r112 = this.f156140d.a();     // Catch: Throwable -> L31
        r112.d(r101, r103.getWidth(), r103.getHeight());     // Catch: Throwable -> L31
        r112.a();     // Catch: Throwable -> L31
        goto L28
    L13:
        if (this.f156143g <= 0) goto L15;
        r104 = true;
    L29:
        monitor-exit(r100);
        return;
    L31:
        th = move-exception;
        throw th;
    }

    public final SurfaceControl d() {
        WeakReference<SurfaceView> r100 = this.f156139c;
        if (r100 == null) goto L7;
        SurfaceView r101 = r100.get();
        if (r101 == null) goto L7;
        return r101.getSurfaceControl();
    L7:
        return null;
    }

    public final Surface e() {
        SurfaceControlCompat r100 = this.f156137a;
        if (r100 == null) goto L15;
        Surface r101 = this.f156138b;
        if (r101 == null) goto L9;
        if (r101 == null) goto L9;
        if (r101.isValid() == true) goto L15;
    L9:
        this.f156138b = new Surface(r100.f156084a);
        Field r102 = Surface.class.getDeclaredField("mName");     // Catch: Exception -> L12
        r102.setAccessible(true);     // Catch: Exception -> L12
        r102.set(this.f156138b, "surfaceControl");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L15:
        return this.f156138b;
    }

    public final SurfaceControl f() {
        SurfaceControlCompat r100 = this.f156137a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f156084a;
    }

    public final void g() {
        Object r100 = this.f156148l;
        monitor-enter(r100);
        SurfaceControlCompat r101 = this.f156137a;     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        SurfaceControlCompat.Transaction r102 = this.f156140d.a();     // Catch: Throwable -> L9
        r102.b(r101, null);     // Catch: Throwable -> L9
        r102.g(r101, false);     // Catch: Throwable -> L9
        r102.a();     // Catch: Throwable -> L9
        this.f156140d.b(r102);     // Catch: Throwable -> L9
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void h() {
        WeakReference<SurfaceView> r100 = this.f156139c;
        if (r100 == null) goto L14;
        SurfaceView r101 = r100.get();
        if (r101 == null) goto L14;
        SurfaceHolder r102 = r101.getHolder();
        if (r102 == null) goto L14;
        Surface r103 = r102.getSurface();
        if (r103 == null) goto L14;
        if (r103.isValid() != true) goto L14;
        this.f156149m = true;
        return;
    L14:
        release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.c
    public final void release() {
        Object r100 = this.f156148l;
        monitor-enter(r100);
        g();     // Catch: Throwable -> L28
        Surface r101 = this.f156138b;     // Catch: Throwable -> L28
        if (r101 == null) goto L7;
        r101.release();     // Catch: Throwable -> L28
    L7:
        this.f156138b = null;     // Catch: Throwable -> L28
        this.f156146j = 0;     // Catch: Throwable -> L28
        SurfaceControlCompat r102 = this.f156137a;     // Catch: Throwable -> L28
        if (r102 == null) goto L10;
        r102.f156084a.release();     // Catch: Throwable -> L28
    L10:
        this.f156137a = null;     // Catch: Throwable -> L28
        b r103 = this.f156140d;     // Catch: Throwable -> L28
    L11:
        SurfaceControlCompat.Transaction r104 = (SurfaceControlCompat.Transaction) r103.f156151a.acquire();     // Catch: Throwable -> L28
        if (r104 == null) goto L14;
        r104.f156093a.close();     // Catch: Throwable -> L28
    L14:
        if (r104 != null) goto L11;
        WeakReference<SurfaceView> r105 = this.f156139c;     // Catch: Throwable -> L28
        if (r105 == null) goto L22;
        SurfaceView r106 = r105.get();     // Catch: Throwable -> L28
        if (r106 == null) goto L22;
        SurfaceHolder r107 = r106.getHolder();     // Catch: Throwable -> L28
        if (r107 == null) goto L22;
        r107.removeCallback(this.f156144h);     // Catch: Throwable -> L28
    L22:
        WeakReference<SurfaceView> r108 = this.f156139c;     // Catch: Throwable -> L28
        if (r108 == null) goto L25;
        r108.clear();     // Catch: Throwable -> L28
    L25:
        this.f156149m = false;     // Catch: Throwable -> L28
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r100);
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public SyncSurfaceControlRender() {
        this.f156140d = new b();
        this.f156141e = 1;
        this.f156144h = new c(this);
        this.f156145i = new SurfaceControlCompat.Transaction();
        this.f156147k = -1;
        this.f156148l = new Object();
    }

    @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.c
    public final int b() {
        return this.f156146j;
    }

    public final void j(SurfaceView r100) {
        Intrinsics.checkNotNullParameter(r100, "surfaceView");
        Object r101 = this.f156148l;
        monitor-enter(r101);
        SurfaceControlCompat r102 = this.f156137a;     // Catch: Throwable -> L22
        if (r102 == null) goto L20;
        WeakReference<SurfaceView> r103 = this.f156139c;     // Catch: Throwable -> L22
        if (r103 == null) goto L13;
        SurfaceView r104 = r103.get();     // Catch: Throwable -> L22
        if (r104 == null) goto L13;
        SurfaceHolder r105 = r104.getHolder();     // Catch: Throwable -> L22
        if (r105 == null) goto L13;
        r105.removeCallback(this.f156144h);     // Catch: Throwable -> L22
    L13:
        this.f156139c = new WeakReference(r100);     // Catch: Throwable -> L22
        r100.getHolder().removeCallback(this.f156144h);     // Catch: Throwable -> L22
        r100.getHolder().addCallback(this.f156144h);     // Catch: Throwable -> L22
        SurfaceControlCompat.Transaction r106 = this.f156140d.a();     // Catch: Throwable -> L22
        r106.b(r102, r100.getSurfaceControl());     // Catch: Throwable -> L22
        r106.g(r102, true);     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r102, "surfaceControl");     // Catch: Throwable -> L22
        if (r102.f156084a.isValid() == false) goto L17;
        r106.f156093a.setLayer(r102.f156084a, 1);     // Catch: Throwable -> L22
    L17:
        if (this.f156141e != 1) goto L19;
        r106.d(r102, r100.getWidth(), r100.getHeight());     // Catch: Throwable -> L22
    L19:
        r106.a();     // Catch: Throwable -> L22
        this.f156140d.b(r106);     // Catch: Throwable -> L22
        r100.post(new d(this));     // Catch: Throwable -> L22
    L20:
        monitor-exit(r101);
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public final void i(int r100, int r101) {
        Object r102 = this.f156148l;
        monitor-enter(r102);
        int r103 = this.f156142f;     // Catch: Throwable -> L15
        if (this.f156143g != r101) goto L7;
        if (r103 != r100) goto L7;
    L12:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r102);
        return;
    L7:
        this.f156142f = r100;     // Catch: Throwable -> L15
        this.f156143g = r101;     // Catch: Throwable -> L15
        c();     // Catch: Throwable -> L15
        if (this.f156141e != 2) goto L12;
        SurfaceControlCompat r105 = this.f156137a;     // Catch: Throwable -> L15
        if (r105 == null) goto L12;
        SurfaceControlCompat.Transaction r106 = this.f156140d.a();     // Catch: Throwable -> L15
        r106.d(r105, r100, r101);     // Catch: Throwable -> L15
        r106.a();     // Catch: Throwable -> L15
        this.f156140d.b(r106);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.livesdk.player.surfacecontrol.dbr.c
    public final void a(HardwareBuffer r100, int r101, int r102, int r103) {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return;
    L5:
        if (this.f156137a == null) goto L32;
        Object r104 = this.f156148l;
        monitor-enter(r104);
        SurfaceControlCompat r105 = this.f156137a;     // Catch: Throwable -> L26
        if (r105 == null) goto L24;
        SurfaceControlCompat.Transaction r106 = this.f156145i;     // Catch: Throwable -> L26
        r106.c(r105, r100);     // Catch: Throwable -> L26
        if (this.f156147k != r103) goto L13;
    L23:
        r106.a();     // Catch: Throwable -> L26
        i(r101, r102);     // Catch: Throwable -> L26
        this.f156146j++;     // Catch: Throwable -> L26
        goto L24
    L13:
        if (r103 != 6) goto L16;
        int r107 = 147193856;
    L22:
        r106.e(r105, r107);     // Catch: Throwable -> L26
        this.f156147k = r103;     // Catch: Throwable -> L26
        goto L23
    L16:
        if (r103 != 4) goto L19;
        r107 = 281280512;
        goto L22
    L19:
        if (r103 != 2) goto L21;
        r107 = 281149440;
        goto L22
    L21:
        r107 = 281083904;
    L24:
        monitor-exit(r104);
        return;
    L26:
        th = move-exception;
        throw th;
    }
}
