package com.stepos.base.model;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.Mutex;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.base.model.ModelBase", f = "ModelBase.kt", l = {202, 33}, m = "initialize-gIAlu-s")
/* loaded from: classes.dex */
public final class ModelBase$initialize$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ModelBase f6309a;

    /* renamed from: b, reason: collision with root package name */
    public Object f6310b;

    /* renamed from: c, reason: collision with root package name */
    public Mutex f6311c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f6312d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ModelBase f6313e;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelBase$initialize$1(ModelBase modelBase, qb.b<? super ModelBase$initialize$1> bVar) {
        super(bVar);
        this.f6313e = modelBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f6312d = obj;
        this.h |= Integer.MIN_VALUE;
        Object objMo11initializegIAlus = this.f6313e.mo11initializegIAlus(null, this);
        return objMo11initializegIAlus == CoroutineSingletons.f10059a ? objMo11initializegIAlus : new Result(objMo11initializegIAlus);
    }
}
