package com.stepos.base.ability;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.base.ability.AbilityBase", f = "AbilityBase.kt", l = {207, 208}, m = "ensureLocalModelsReady-IoAF18A")
/* loaded from: classes.dex */
public final class AbilityBase$ensureLocalModelsReady$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public AbilityBase f6141a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f6142b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbilityBase<AbilityInput, AbilityOutput> f6143c;

    /* renamed from: d, reason: collision with root package name */
    public int f6144d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityBase$ensureLocalModelsReady$1(AbilityBase<AbilityInput, AbilityOutput> abilityBase, b<? super AbilityBase$ensureLocalModelsReady$1> bVar) {
        super(bVar);
        this.f6143c = abilityBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6142b = obj;
        this.f6144d |= Integer.MIN_VALUE;
        Object objM16ensureLocalModelsReadyIoAF18A = this.f6143c.m16ensureLocalModelsReadyIoAF18A(this);
        return objM16ensureLocalModelsReadyIoAF18A == CoroutineSingletons.f10059a ? objM16ensureLocalModelsReadyIoAF18A : new Result(objM16ensureLocalModelsReadyIoAF18A);
    }
}
