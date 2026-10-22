package com.stepos.base.concurrency.cpuset;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.base.concurrency.cpuset.AiTier$on$2", f = "AiTier.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AiTier$on$2<T> extends SuspendLambda implements p<CoroutineScope, b<? super T>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zb.a<T> f6211a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AiTier$on$2(zb.a<? extends T> aVar, b<? super AiTier$on$2> bVar) {
        super(2, bVar);
        this.f6211a = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        return new AiTier$on$2(this.f6211a, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, Object obj) {
        return ((AiTier$on$2) create(coroutineScope, (b) obj)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        kotlin.c.b(obj);
        return this.f6211a.invoke();
    }
}
