package com.bytedance.android.livesdk.player.surfacecontrol.dbr;

import android.hardware.HardwareBuffer;
import android.view.SurfaceControl;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class SurfaceControlCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SurfaceControl f156084a;

    public static final class Transaction {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy f156085b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy f156086c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Lazy f156087d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Lazy f156088e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Lazy f156089f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Lazy f156090g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final Lazy f156091h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final Lazy f156092i = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SurfaceControl.Transaction f156093a;

        public static final class a {
            public a() {
            }

            public static final void a(Method r100, Object[] r101, Object r102) {
                Lazy r103 = Transaction.f156085b;
                r100.setAccessible(true);     // Catch: Exception -> L5
                r100.invoke(r102, Arrays.copyOf(r101, r101.length));     // Catch: Exception -> L5
                return;
            L5:
                e = move-exception;
                e.printStackTrace();
            }
        }

        static {
            new a();
            f156085b = LazyKt.lazy(SurfaceControlCompat$Transaction$Companion$setFrameRate$2.INSTANCE);
            f156086c = LazyKt.lazy(SurfaceControlCompat$Transaction$Companion$setPosition$2.INSTANCE);
            f156087d = LazyKt.lazy(SurfaceControlCompat$Transaction$Companion$setScale$2.INSTANCE);
            f156088e = LazyKt.lazy(SurfaceControlCompat$Transaction$Companion$show$2.INSTANCE);
            f156089f = LazyKt.lazy(SurfaceControlCompat$Transaction$Companion$hide$2.INSTANCE);
            f156090g = LazyKt.lazy(SurfaceControlCompat$Transaction$Companion$setCrop$2.INSTANCE);
            f156091h = LazyKt.lazy(SurfaceControlCompat$Transaction$Companion$setBuffer$2.INSTANCE);
            f156092i = LazyKt.lazy(SurfaceControlCompat$Transaction$Companion$setDataSpace$2.INSTANCE);
        }

        public final void a() {
            this.f156093a.apply();
        }

        public Transaction() {
            this.f156093a = new SurfaceControl.Transaction();
        }

        public final void b(SurfaceControlCompat r100, SurfaceControl r101) {
            Intrinsics.checkNotNullParameter(r100, "surfaceControl");
            if (r100.f156084a.isValid() == false) goto L6;
            this.f156093a.reparent(r100.f156084a, r101);
            return;
        }

        public final void c(SurfaceControlCompat r100, HardwareBuffer r101) {
            Intrinsics.checkNotNullParameter(r100, "surfaceControl");
            if (r100.f156084a.isValid() == false) goto L6;
            a.a((Method) f156091h.getValue(), new Object[]{r100.f156084a, r101}, this.f156093a);
            return;
        }

        public final void e(SurfaceControlCompat r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "surfaceControl");
            if (r100.f156084a.isValid() == false) goto L6;
            a.a((Method) f156092i.getValue(), new Object[]{r100.f156084a, Integer.valueOf(r101)}, this.f156093a);
            return;
        }

        public final void g(SurfaceControlCompat r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "surfaceControl");
            if (r100.f156084a.isValid() == false) goto L6;
            this.f156093a.setVisibility(r100.f156084a, r101);
            return;
        }

        public final void d(SurfaceControlCompat r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surfaceControl");
            if (r100.f156084a.isValid() == false) goto L6;
            this.f156093a.setBufferSize(r100.f156084a, r101, r102);
            return;
        }

        public final void f(SurfaceControlCompat r100, float r101, float r102) {
            Intrinsics.checkNotNullParameter(r100, "surfaceControl");
            if (r100.f156084a.isValid() == false) goto L6;
            a.a((Method) f156087d.getValue(), new Object[]{r100.f156084a, Float.valueOf(r101), Float.valueOf(r102)}, this.f156093a);
            return;
        }
    }

    public SurfaceControlCompat(SurfaceControl.Builder r100) {
        Intrinsics.checkNotNullParameter(r100, "build");
        this.f156084a = r100.build();
    }
}
