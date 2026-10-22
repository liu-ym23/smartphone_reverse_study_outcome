package com.stepos.core.cta;

import android.content.Context;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.cta.CtaGatedInitManager$bootstrap$1$1$1", f = "CtaGatedInitManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class CtaGatedInitManager$bootstrap$1$1$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
    final /* synthetic */ Context $appContext;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CtaGatedInitManager$bootstrap$1$1$1(Context context, qb.b<? super CtaGatedInitManager$bootstrap$1$1$1> bVar) {
        super(2, bVar);
        this.$appContext = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new CtaGatedInitManager$bootstrap$1$1$1(this.$appContext, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        CtaGatedInitManager ctaGatedInitManager = CtaGatedInitManager.INSTANCE;
        Context context = this.$appContext;
        g.c(context);
        ctaGatedInitManager.evaluate(context);
        return n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
        return ((CtaGatedInitManager$bootstrap$1$1$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
