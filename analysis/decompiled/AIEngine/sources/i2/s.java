package i2;

import androidx.work.WorkerParameters;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class s implements r {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.work.impl.a f9486a;

    /* renamed from: b, reason: collision with root package name */
    public final s2.b f9487b;

    public s(androidx.work.impl.a processor, s2.b workTaskExecutor) {
        kotlin.jvm.internal.g.f(processor, "processor");
        kotlin.jvm.internal.g.f(workTaskExecutor, "workTaskExecutor");
        this.f9486a = processor;
        this.f9487b = workTaskExecutor;
    }

    @Override // i2.r
    public final void b(k workSpecId, int i10) {
        kotlin.jvm.internal.g.f(workSpecId, "workSpecId");
        this.f9487b.d(new r2.l(this.f9486a, workSpecId, false, i10));
    }

    public final void c(k workSpecId, WorkerParameters.a aVar) {
        kotlin.jvm.internal.g.f(workSpecId, "workSpecId");
        this.f9487b.d(new com.stepos.statsapp.v3.lib.plugin.emitter.remote.c(this, workSpecId, aVar, 6));
    }
}
