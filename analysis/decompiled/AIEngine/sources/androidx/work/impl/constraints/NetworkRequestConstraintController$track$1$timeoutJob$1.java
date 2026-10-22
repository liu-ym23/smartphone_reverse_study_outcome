package androidx.work.impl.constraints;

import androidx.work.impl.constraints.a;
import h2.j;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ProducerScope;
import lb.n;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "androidx.work.impl.constraints.NetworkRequestConstraintController$track$1$timeoutJob$1", f = "WorkConstraintsTracker.kt", l = {149}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class NetworkRequestConstraintController$track$1$timeoutJob$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f2908a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NetworkRequestConstraintController f2909b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ProducerScope<a> f2910c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NetworkRequestConstraintController$track$1$timeoutJob$1(NetworkRequestConstraintController networkRequestConstraintController, ProducerScope<? super a> producerScope, qb.b<? super NetworkRequestConstraintController$track$1$timeoutJob$1> bVar) {
        super(2, bVar);
        this.f2909b = networkRequestConstraintController;
        this.f2910c = producerScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new NetworkRequestConstraintController$track$1$timeoutJob$1(this.f2909b, this.f2910c, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
        return ((NetworkRequestConstraintController$track$1$timeoutJob$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f2908a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            this.f2908a = 1;
            if (DelayKt.delay(1000L, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        j.d().a(WorkConstraintsTrackerKt.f2921a, "NetworkRequestConstraintController didn't receive neither onCapabilitiesChanged/onLost callback, sending `ConstraintsNotMet` after 1000 ms");
        this.f2910c.mo149trySendJP2dKIU(new a.b(7));
        return n.f10413a;
    }
}
