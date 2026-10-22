package com.baidu.mshield.x0.h;

import android.content.Context;
import com.baidu.mshield.x0.d.d;
import com.baidu.mshield.x6.EngineImpl;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile long f32520a;

    /* JADX INFO: renamed from: com.baidu.mshield.x0.h.a$a, reason: collision with other inner class name */
    public class C0657a extends com.baidu.mshield.x0.d.h.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f32521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f32522c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f32523d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f32524e;

        @Override // com.baidu.mshield.x0.d.h.b
        public void a() {
        L21:
            th = move-exception;
            d.a(th);
            return;
        L3:
            if (this.f32521b == 1) goto L5;
            EngineImpl.getInstance(this.f32523d).uccs(this.f32524e, this.f32521b);     // Catch: Throwable -> L21
            return;
        L5:
            monitor-enter(a.class);     // Catch: Throwable -> L21
            long r100 = System.currentTimeMillis();     // Catch: Throwable -> L16
            if (a.a() != 0) goto L9;
        L12:
            a.a(r100);     // Catch: Throwable -> L16
            monitor-exit(a.class);     // Catch: Throwable -> L16
            EngineImpl.getInstance(this.f32523d).uccs(this.f32524e, this.f32521b);     // Catch: Throwable -> L21
            return;
        L9:
            if ((r100 - a.a()) >= this.f32522c) goto L12;
            monitor-exit(a.class);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;     // Catch: Throwable -> L21
        }

        public C0657a(a r100, int r101, long r102, Context r103, int r104) {
            this.f32521b = r101;
            this.f32522c = r102;
            this.f32523d = r103;
            this.f32524e = r104;
        }
    }

    public a() {
    }

    public static /* synthetic */ long a() {
        return f32520a;
    }

    public static /* synthetic */ long a(long r100) {
        f32520a = r100;
        return r100;
    }

    public void a(Context r110, int r111, int r112, long r113) {
        com.baidu.mshield.x0.d.h.d.b().a(new C0657a(this, r112, r113, r110, r111));
    }
}
