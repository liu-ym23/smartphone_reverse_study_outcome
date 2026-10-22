package com.bytedance.android.livesdk.summer;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.service.ILiveLifecycle;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class c<R> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f158442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public R f158443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ILiveLifecycle f158444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f158445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicInteger f158446e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicInteger f158447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f158448g;

    public abstract R f();

    public void g() {
    }

    public int c() {
        if (this.f158442a != (-1)) goto L6;
        AtomicInteger r100 = b.f158441a;
        this.f158442a = b.f158441a.getAndAdd(1);
    L6:
        return this.f158442a;
    }

    public R d() {
        this.f158447f.incrementAndGet();
        if (this.f158445d != 4) goto L11;
        this.f158445d = 5;
        if (this.f158443b == null) goto L7;
        this.f158446e.incrementAndGet();
    L7:
        R r100 = this.f158443b;
        if (r100 == null) goto L13;
        return r100;
    L13:
        return f();
    L11:
        return f();
    }

    public R e() {
        this.f158447f.incrementAndGet();
        if (this.f158445d != 4) goto L8;
        this.f158445d = 5;
        if (this.f158443b == null) goto L10;
        this.f158446e.incrementAndGet();
    L10:
        return this.f158443b;
    L8:
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L3:
        if (this.f158445d != 1) goto L10;
        this.f158445d = 2;     // Catch: Throwable -> L7
        this.f158443b = f();     // Catch: Throwable -> L7
        this.f158445d = 4;     // Catch: Throwable -> L7
        return;
    }

    public c() {
        this.f158442a = -1;
        this.f158446e = new AtomicInteger(0);
        this.f158447f = new AtomicInteger(0);
        this.f158448g = "unknown";
    }

    public void a(ILiveLifecycle r100) {
        Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.LIFECYCLE);
        this.f158444c = r100;
        this.f158445d = 1;
    }

    public <T> boolean b(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        R r101 = this.f158443b;
        if (r101 != null) goto L12;
        return false;
    L12:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl(r100.cast(r101));     // Catch: Throwable -> L8
    L11:
        return Result.m9456isSuccessimpl(r103);
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final void setResult(R r100) {
        this.f158443b = r100;
    }
}
