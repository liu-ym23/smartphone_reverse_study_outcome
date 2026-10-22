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
@c(c = "com.stepos.base.ability.AbilityBase$executeByDecision$6$1", f = "AbilityBase.kt", l = {354}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AbilityBase$executeByDecision$6$1<AbilityOutput> extends SuspendLambda implements p<FlowCollector<? super Result<? extends AbilityOutput>>, b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f6159a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f6160b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Exception f6161c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityBase$executeByDecision$6$1(Exception exc, b<? super AbilityBase$executeByDecision$6$1> bVar) {
        super(2, bVar);
        this.f6161c = exc;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        AbilityBase$executeByDecision$6$1 abilityBase$executeByDecision$6$1 = new AbilityBase$executeByDecision$6$1(this.f6161c, bVar);
        abilityBase$executeByDecision$6$1.f6160b = obj;
        return abilityBase$executeByDecision$6$1;
    }

    @Override // zb.p
    public final Object invoke(Object obj, b<? super n> bVar) {
        return ((AbilityBase$executeByDecision$6$1) create((FlowCollector) obj, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f6159a;
        if (i10 == 0) {
            kotlin.c.b(obj);
            FlowCollector flowCollector = (FlowCollector) this.f6160b;
            Result result = new Result(kotlin.c.a(this.f6161c));
            this.f6159a = 1;
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
