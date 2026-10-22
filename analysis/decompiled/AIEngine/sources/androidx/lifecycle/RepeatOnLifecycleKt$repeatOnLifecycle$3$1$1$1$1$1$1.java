package androidx.lifecycle;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {110}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 extends SuspendLambda implements zb.p<CoroutineScope, qb.b<? super lb.n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f2243a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2244b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zb.p<CoroutineScope, qb.b<? super lb.n>, Object> f2245c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(zb.p<? super CoroutineScope, ? super qb.b<? super lb.n>, ? extends Object> pVar, qb.b<? super RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1> bVar) {
        super(2, bVar);
        this.f2245c = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<lb.n> create(Object obj, qb.b<?> bVar) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(this.f2245c, bVar);
        repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1.f2244b = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super lb.n> bVar) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f2243a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f2244b;
            this.f2243a = 1;
            if (this.f2245c.invoke(coroutineScope, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        return lb.n.f10413a;
    }
}
