package com.bytedance.android.shopping.prepurchase.arch.exposure;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes13.dex */
public final class Scheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CoroutineScope f180873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Job f180874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f180875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f180876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f180877e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f180878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f180879g;

    public final void b() {
        this.f180876d = true;
        if (this.f180875c == false) goto L8;
        CoroutineScope r100 = this.f180873a;
        if (r100 == null) goto L9;
        BuildersKt.launch$default(r100, Dispatchers.getMain().getImmediate(), null, new Scheduler$resume$1(this, null), 2, null);
        return;
    L9:
        return;
    }

    public Scheduler(long r100, ExposureEngine.c r101) {
        Intrinsics.checkNotNullParameter(r101, "scheduler");
        this.f180878f = r100;
        this.f180879g = r101;
    }

    public static final Object a(Scheduler r100, Continuation r101) {
        r100.getClass();
        Object r102 = BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new Scheduler$scheduleOnce$2(r100, null), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }
}
