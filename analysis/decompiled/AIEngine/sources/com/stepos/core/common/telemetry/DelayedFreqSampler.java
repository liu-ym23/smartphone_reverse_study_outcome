package com.stepos.core.common.telemetry;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DelayedFreqSampler {
    public static final DelayedFreqSampler INSTANCE = new DelayedFreqSampler();
    private static final String TAG = "AIEngine_DelayedSampler";
    private static final ScheduledExecutorService scheduler;

    static {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new com.stepos.aicgroup.d(4));
        kotlin.jvm.internal.g.e(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor(...)");
        scheduler = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    private DelayedFreqSampler() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleAfter$lambda$4$lambda$3(zb.a aVar) {
        Object objA;
        try {
            objA = aVar.invoke();
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            a0.a.A("delayed sampling threw: ", thB.getMessage(), TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread scheduler$lambda$1(Runnable runnable) {
        return com.stepos.core.ota.d.n(runnable, "AIEngine-DelayedSampler", true);
    }

    public final boolean scheduleAfter(long j10, zb.a<n> block) {
        Object objA;
        kotlin.jvm.internal.g.f(block, "block");
        try {
            scheduler.schedule(new c(0, block), j10, TimeUnit.MILLISECONDS);
            objA = Boolean.TRUE;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }
}
