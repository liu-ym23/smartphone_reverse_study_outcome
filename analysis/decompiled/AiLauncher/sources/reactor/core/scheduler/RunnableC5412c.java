package reactor.core.scheduler;

import reactor.core.scheduler.BoundedElasticScheduler;

/* renamed from: reactor.core.scheduler.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final /* synthetic */ class RunnableC5412c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BoundedElasticScheduler.BoundedServices f39831a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f39831a.eviction();
    }
}
