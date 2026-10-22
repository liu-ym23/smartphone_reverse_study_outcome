package com.bytedance.android.livesdk.player.surfacecontrol.dbr;

import android.os.Build;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class SurfaceControlRender {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f156094l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile SurfaceControlCompat f156095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<SurfaceView> f156096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f156097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @MODE
    public int f156098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f156099e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f156100f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f156101g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SurfaceControlCompat.Transaction f156102h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f156103i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f156104j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f156105k;

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/player/surfacecontrol/dbr/SurfaceControlRender$MODE;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MODE {
        public static final int BUFFER = 2;
        public static final a Companion = null;
        public static final int SURFACE = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f156106a = null;

            public a() {
            }

            static {
                f156106a = new a();
            }
        }

        static {
            Companion = a.f156106a;
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Pools.SimplePool f156107a;

        /* JADX WARN: Multi-variable type inference failed */
        public final SurfaceControlCompat.Transaction a() {
            SurfaceControlCompat.Transaction r100 = (SurfaceControlCompat.Transaction) this.f156107a.acquire();     // Catch: Exception -> L8
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
            this.f156107a = new Pools.SimplePool(3);
        }

        public final void b(SurfaceControlCompat.Transaction r100) {
            Intrinsics.checkNotNullParameter(r100, "transaction");
            boolean r101 = this.f156107a.release(r100);     // Catch: Exception -> L5
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
        public final /* synthetic */ SurfaceControlRender f156108a;

        public c(SurfaceControlRender r100) {
            this.f156108a = r100;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder r100) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            WeakReference<SurfaceView> r101 = this.f156108a.f156096b;
            if (r101 == null) goto L25;
            SurfaceView r102 = r101.get();
            if (r102 == null) goto L26;
            SurfaceHolder r103 = r102.getHolder();
            if (r103 == null) goto L27;
            WeakReference<SurfaceView> r104 = this.f156108a.f156096b;
            if (r104 == null) goto L13;
            SurfaceView r105 = r104.get();
            if (r105 == null) goto L13;
            SurfaceHolder r106 = r105.getHolder();
        L15:
            if (Intrinsics.areEqual(r103, r106) == true) goto L18;
            r103 = null;
        L18:
            if (r103 == null) goto L28;
            WeakReference<SurfaceView> r107 = this.f156108a.f156096b;
            if (r107 == null) goto L29;
            SurfaceView r108 = r107.get();
            if (r108 == null) goto L30;
            this.f156108a.e(r108);
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
            this.f156108a.getClass();
            Intrinsics.checkNotNullParameter("surfaceDestroyed", "msg");
            WeakReference<SurfaceView> r101 = this.f156108a.f156096b;
            SurfaceView r102 = null;
            if (r101 == null) goto L7;
            SurfaceView r103 = r101.get();
            if (r103 == null) goto L7;
            SurfaceHolder r104 = r103.getHolder();
        L9:
            if (Intrinsics.areEqual(r104, r100) == false) goto L13;
            this.f156108a.getClass();
            SurfaceControlRender r105 = this.f156108a;
            SurfaceControlCompat r106 = r105.f156095a;
            if (r106 == null) goto L19;
            SurfaceControlCompat.Transaction r107 = r105.f156097c.a();
            r107.b(r106, null);
            r107.g(r106, false);
            r107.a();
            r105.f156097c.b(r107);
            return;
        L19:
            return;
        L13:
            WeakReference<SurfaceView> r108 = this.f156108a.f156096b;
            if (r108 == null) goto L16;
            r102 = r108.get();
        L16:
            if (r102 != null) goto L21;
            this.f156108a.getClass();
            return;
        L21:
            return;
        L7:
            r104 = null;
            goto L9
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            this.f156108a.getClass();
            Intrinsics.checkNotNullParameter("surfaceChanged: " + r101 + ' ' + r102 + ' ' + r103, "msg");
            WeakReference<SurfaceView> r104 = this.f156108a.f156096b;
            if (r104 == null) goto L25;
            SurfaceView r105 = r104.get();
            if (r105 == null) goto L26;
            SurfaceHolder r106 = r105.getHolder();
            if (r106 == null) goto L27;
            WeakReference<SurfaceView> r107 = this.f156108a.f156096b;
            if (r107 == null) goto L13;
            SurfaceView r108 = r107.get();
            if (r108 == null) goto L13;
            SurfaceHolder r109 = r108.getHolder();
        L15:
            if (Intrinsics.areEqual(r106, r109) == true) goto L18;
            r106 = null;
        L18:
            if (r106 == null) goto L28;
            WeakReference<SurfaceView> r110 = this.f156108a.f156096b;
            if (r110 != null) goto L22;
            return;
        L22:
            if (r110.get() == null) goto L30;
            this.f156108a.a();
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
        public final /* synthetic */ SurfaceControlRender f156109a;

        public d(SurfaceControlRender r100) {
            this.f156109a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f156109a.a();     // Catch: Throwable -> L4
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

    public final void a() {
        SurfaceControlCompat r100 = this.f156095a;
        if (r100 == null) goto L27;
        WeakReference<SurfaceView> r101 = this.f156096b;
        if (r101 == null) goto L28;
        SurfaceView r102 = r101.get();
        if (r102 != null) goto L9;
        return;
    L9:
        if (this.f156099e > 0) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == true) goto L17;
        r102 = null;
    L17:
        if (r102 == null) goto L30;
        int r104 = this.f156098d;
        if (r104 != 2) goto L24;
        int r105 = r102.getWidth();
        int r106 = r102.getHeight();
        float r107 = (r105 * 1.0f) / this.f156099e;
        float r108 = (r106 * 1.0f) / this.f156100f;
        SurfaceControlCompat.Transaction r109 = this.f156097c.a();
        if (Build.VERSION.SDK_INT < 33) goto L23;
        r109.f(r100, r107, r108);
    L23:
        r109.a();
        this.f156097c.b(r109);
        return;
    L24:
        if (r104 != 1) goto L32;
        SurfaceControlCompat.Transaction r110 = this.f156097c.a();
        r110.d(r100, r102.getWidth(), r102.getHeight());
        r110.a();
        return;
    L32:
        return;
    L30:
        return;
    L11:
        if (this.f156100f <= 0) goto L13;
        r103 = true;
        goto L14
    L28:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        Object r100 = this.f156105k;
        monitor-enter(r100);
        SurfaceControlCompat r101 = this.f156095a;     // Catch: Throwable -> L28
        if (r101 == null) goto L7;
        SurfaceControlCompat.Transaction r102 = this.f156097c.a();     // Catch: Throwable -> L28
        r102.b(r101, null);     // Catch: Throwable -> L28
        r102.g(r101, false);     // Catch: Throwable -> L28
        r102.a();     // Catch: Throwable -> L28
        this.f156097c.b(r102);     // Catch: Throwable -> L28
    L7:
        this.f156103i = 0;     // Catch: Throwable -> L28
        SurfaceControlCompat r103 = this.f156095a;     // Catch: Throwable -> L28
        if (r103 == null) goto L10;
        r103.f156084a.release();     // Catch: Throwable -> L28
    L10:
        this.f156095a = null;     // Catch: Throwable -> L28
        b r104 = this.f156097c;     // Catch: Throwable -> L28
    L11:
        SurfaceControlCompat.Transaction r105 = (SurfaceControlCompat.Transaction) r104.f156107a.acquire();     // Catch: Throwable -> L28
        if (r105 == null) goto L14;
        r105.f156093a.close();     // Catch: Throwable -> L28
    L14:
        if (r105 != null) goto L11;
        WeakReference<SurfaceView> r106 = this.f156096b;     // Catch: Throwable -> L28
        if (r106 == null) goto L22;
        SurfaceView r107 = r106.get();     // Catch: Throwable -> L28
        if (r107 == null) goto L22;
        SurfaceHolder r108 = r107.getHolder();     // Catch: Throwable -> L28
        if (r108 == null) goto L22;
        r108.removeCallback(this.f156101g);     // Catch: Throwable -> L28
    L22:
        WeakReference<SurfaceView> r109 = this.f156096b;     // Catch: Throwable -> L28
        if (r109 == null) goto L25;
        r109.clear();     // Catch: Throwable -> L28
    L25:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r100);
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public SurfaceControlRender() {
        this.f156097c = new b();
        this.f156098d = 1;
        this.f156101g = new c(this);
        this.f156102h = new SurfaceControlCompat.Transaction();
        this.f156104j = -1;
        this.f156105k = new Object();
    }

    public static int b(int r100) {
        if (r100 != 6) goto L7;
        return 147193856;
    L7:
        if (r100 != 4) goto L11;
        return 281280512;
    L11:
        if (r100 != 2) goto L14;
        return 281149440;
    L14:
        int r101 = com.bytedance.android.livesdk.player.surfacecontrol.dbr.a.f156154a;
        if (r100 < 65536) goto L23;
        int r102 = (r100 >>> 16) & 63;
        int r103 = (r100 >>> 22) & 31;
        int r104 = (r100 >>> 27) & 7;
        Intrinsics.checkNotNullParameter("covertDataSpace pack:" + r100 + ",standard:" + r102 + " transfer:" + r103 + " range:" + r104, "msg");
        if (r103 == 7) goto L22;
        if (r103 == 6) goto L22;
        return r100;
    L22:
        return ((r102 << 16) | ((r103 + 1) << 22)) | (r104 << 27);
    L23:
        return 281083904;
    }

    public final void e(SurfaceView r100) {
        Intrinsics.checkNotNullParameter(r100, "surfaceView");
        SurfaceControlCompat r101 = this.f156095a;
        if (r101 == null) goto L19;
        WeakReference<SurfaceView> r102 = this.f156096b;
        if (r102 == null) goto L11;
        SurfaceView r103 = r102.get();
        if (r103 == null) goto L11;
        SurfaceHolder r104 = r103.getHolder();
        if (r104 == null) goto L11;
        r104.removeCallback(this.f156101g);
    L11:
        this.f156096b = new WeakReference(r100);
        r100.getHolder().removeCallback(this.f156101g);
        r100.getHolder().addCallback(this.f156101g);
        SurfaceControlCompat.Transaction r105 = this.f156097c.a();
        r105.b(r101, r100.getSurfaceControl());
        r105.g(r101, true);
        Intrinsics.checkNotNullParameter(r101, "surfaceControl");
        if (r101.f156084a.isValid() == false) goto L15;
        r105.f156093a.setLayer(r101.f156084a, 1);
    L15:
        if (this.f156098d != 1) goto L17;
        r105.d(r101, r100.getWidth(), r100.getHeight());
    L17:
        r105.a();
        this.f156097c.b(r105);
        r100.post(new d(this));
        return;
    }

    public final void d(int r100, int r101) {
        int r102 = this.f156099e;
        if (this.f156100f != r101) goto L5;
        if (r102 != r100) goto L5;
        return;
    L5:
        this.f156099e = r100;
        this.f156100f = r101;
        a();
        if (this.f156098d != 2) goto L12;
        SurfaceControlCompat r103 = this.f156095a;
        if (r103 == null) goto L13;
        SurfaceControlCompat.Transaction r104 = this.f156097c.a();
        r104.d(r103, r100, r101);
        r104.a();
        this.f156097c.b(r104);
        return;
    L13:
        return;
    }
}
