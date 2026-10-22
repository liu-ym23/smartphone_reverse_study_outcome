package com.stepos.base.model;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.base.model.ModelBase", f = "ModelBase.kt", l = {202, 99, 115}, m = "infer-0E7RQCE")
/* loaded from: classes.dex */
public final class ModelBase$infer$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f6290a;

    /* renamed from: b, reason: collision with root package name */
    public Object f6291b;

    /* renamed from: c, reason: collision with root package name */
    public Object f6292c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6293d;

    /* renamed from: e, reason: collision with root package name */
    public long f6294e;
    public /* synthetic */ Object h;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ ModelBase f6295j;

    /* renamed from: k, reason: collision with root package name */
    public int f6296k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelBase$infer$1(ModelBase modelBase, qb.b<? super ModelBase$infer$1> bVar) {
        super(bVar);
        this.f6295j = modelBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.h = obj;
        this.f6296k |= Integer.MIN_VALUE;
        Object objMo10infer0E7RQCE = this.f6295j.mo10infer0E7RQCE(null, null, this);
        return objMo10infer0E7RQCE == CoroutineSingletons.f10059a ? objMo10infer0E7RQCE : new Result(objMo10infer0E7RQCE);
    }
}
