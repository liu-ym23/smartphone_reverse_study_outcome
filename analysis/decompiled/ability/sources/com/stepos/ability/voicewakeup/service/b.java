package com.stepos.ability.voicewakeup.service;

import H4.r;
import com.stepos.ability.voicewakeup.service.RebuildScheduler;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class b implements RebuildScheduler {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f3323a;

    public b() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new A4.b(7));
        kotlin.jvm.internal.k.e(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor(...)");
        this.f3323a = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    @Override // com.stepos.ability.voicewakeup.service.RebuildScheduler
    public final RebuildScheduler.Cancellable schedule(long j5, S7.a task) {
        kotlin.jvm.internal.k.f(task, "task");
        return new B5.a(this.f3323a.schedule(new r(3, task), j5, TimeUnit.MILLISECONDS), 18);
    }
}
