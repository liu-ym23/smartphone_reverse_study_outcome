package com.stepos.base.concurrency.cpuset;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.base.concurrency.cpuset.AiTier", f = "AiTier.kt", l = {137, 137}, m = "on")
/* loaded from: classes.dex */
public final class AiTier$on$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public zb.a f6207a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f6208b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AiTier f6209c;

    /* renamed from: d, reason: collision with root package name */
    public int f6210d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiTier$on$1(AiTier aiTier, b<? super AiTier$on$1> bVar) {
        super(bVar);
        this.f6209c = aiTier;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6208b = obj;
        this.f6210d |= Integer.MIN_VALUE;
        return this.f6209c.b(null, this);
    }
}
