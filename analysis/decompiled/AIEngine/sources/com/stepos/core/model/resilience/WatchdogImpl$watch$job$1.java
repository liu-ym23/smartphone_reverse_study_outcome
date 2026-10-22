package com.stepos.core.model.resilience;

import android.util.Log;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import lb.n;
import qb.b;
import rb.c;
import zb.a;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.model.resilience.WatchdogImpl$watch$job$1", f = "Watchdog.kt", l = {84}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class WatchdogImpl$watch$job$1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
    final /* synthetic */ a<n> $onTimeout;
    final /* synthetic */ String $taskId;
    final /* synthetic */ long $timeoutMs;
    int label;
    final /* synthetic */ WatchdogImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchdogImpl$watch$job$1(long j10, String str, WatchdogImpl watchdogImpl, a<n> aVar, b<? super WatchdogImpl$watch$job$1> bVar) {
        super(2, bVar);
        this.$timeoutMs = j10;
        this.$taskId = str;
        this.this$0 = watchdogImpl;
        this.$onTimeout = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        return new WatchdogImpl$watch$job$1(this.$timeoutMs, this.$taskId, this.this$0, this.$onTimeout, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        try {
            if (i10 == 0) {
                kotlin.c.b(obj);
                long j10 = this.$timeoutMs;
                this.label = 1;
                if (DelayKt.delay(j10, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            Log.w("Watchdog", "Task timeout: " + this.$taskId);
            this.this$0.totalTimeouts.incrementAndGet();
            this.$onTimeout.invoke();
        } catch (CancellationException unused) {
        } catch (Throwable th) {
            this.this$0.watchJobs.remove(this.$taskId);
            throw th;
        }
        this.this$0.watchJobs.remove(this.$taskId);
        return n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
        return ((WatchdogImpl$watch$job$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
