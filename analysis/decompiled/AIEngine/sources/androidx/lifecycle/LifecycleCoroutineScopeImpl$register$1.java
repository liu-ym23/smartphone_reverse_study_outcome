package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt__JobKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
final class LifecycleCoroutineScopeImpl$register$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f2219a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f2220b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleCoroutineScopeImpl$register$1(m mVar, qb.b<? super LifecycleCoroutineScopeImpl$register$1> bVar) {
        super(2, bVar);
        this.f2220b = mVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        LifecycleCoroutineScopeImpl$register$1 lifecycleCoroutineScopeImpl$register$1 = new LifecycleCoroutineScopeImpl$register$1(this.f2220b, bVar);
        lifecycleCoroutineScopeImpl$register$1.f2219a = obj;
        return lifecycleCoroutineScopeImpl$register$1;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
        return ((LifecycleCoroutineScopeImpl$register$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        kotlin.c.b(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.f2219a;
        m mVar = this.f2220b;
        Lifecycle lifecycle = mVar.f2285a;
        if (lifecycle.b().compareTo(Lifecycle.State.f2215b) >= 0) {
            lifecycle.a(mVar);
        } else {
            JobKt__JobKt.cancel$default(coroutineScope.getCoroutineContext(), null, 1, null);
        }
        return lb.n.f10413a;
    }
}
