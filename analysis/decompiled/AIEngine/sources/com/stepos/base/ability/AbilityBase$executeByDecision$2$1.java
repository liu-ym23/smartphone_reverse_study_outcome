package com.stepos.base.ability;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.FlowCollector;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* JADX INFO: Add missing generic type declarations: [AbilityOutput] */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.base.ability.AbilityBase$executeByDecision$2$1", f = "AbilityBase.kt", l = {327}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AbilityBase$executeByDecision$2$1<AbilityOutput> extends SuspendLambda implements p<FlowCollector<? super Result<? extends AbilityOutput>>, b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f6150a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f6151b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Exception f6152c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityBase$executeByDecision$2$1(Exception exc, b<? super AbilityBase$executeByDecision$2$1> bVar) {
        super(2, bVar);
        this.f6152c = exc;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        AbilityBase$executeByDecision$2$1 abilityBase$executeByDecision$2$1 = new AbilityBase$executeByDecision$2$1(this.f6152c, bVar);
        abilityBase$executeByDecision$2$1.f6151b = obj;
        return abilityBase$executeByDecision$2$1;
    }

    @Override // zb.p
    public final Object invoke(Object obj, b<? super n> bVar) {
        return ((AbilityBase$executeByDecision$2$1) create((FlowCollector) obj, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f6150a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            FlowCollector flowCollector = (FlowCollector) this.f6151b;
            Result result = new Result(kotlin.c.a(this.f6152c));
            this.f6150a = 1;
            if (flowCollector.emit(result, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        return n.f10413a;
    }
}
