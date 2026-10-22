package androidx.work.impl;

import h2.j;
import i2.m;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import lb.n;
import zb.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.work.impl.UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1", f = "UnfinishedWorkListener.kt", l = {59}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1 extends SuspendLambda implements r<FlowCollector<? super Boolean>, Throwable, Long, qb.b<? super Boolean>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f2831a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Throwable f2832b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ long f2833c;

    @Override // zb.r
    public final Object a(FlowCollector<? super Boolean> flowCollector, Throwable th, Long l10, qb.b<? super Boolean> bVar) {
        long jLongValue = l10.longValue();
        UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1 unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1 = new UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1(4, bVar);
        unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1.f2832b = th;
        unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1.f2833c = jLongValue;
        return unfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1.invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f2831a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            Throwable th = this.f2832b;
            long j10 = this.f2833c;
            j.d().c(m.f9473a, "Cannot check for unfinished work", th);
            long jMin = Math.min(j10 * 30000, m.f9474b);
            this.f2831a = 1;
            if (DelayKt.delay(jMin, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        return Boolean.TRUE;
    }
}
