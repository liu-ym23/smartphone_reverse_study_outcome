package com.stepos.base.model;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.Mutex;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.base.model.ModelBase", f = "ModelBase.kt", l = {202, 58}, m = "close-IoAF18A")
/* loaded from: classes.dex */
public final class ModelBase$close$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ModelBase f6285a;

    /* renamed from: b, reason: collision with root package name */
    public Mutex f6286b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f6287c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ModelBase f6288d;

    /* renamed from: e, reason: collision with root package name */
    public int f6289e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelBase$close$1(ModelBase modelBase, qb.b<? super ModelBase$close$1> bVar) {
        super(bVar);
        this.f6288d = modelBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f6287c = obj;
        this.f6289e |= Integer.MIN_VALUE;
        Object objMo9closeIoAF18A = this.f6288d.mo9closeIoAF18A(this);
        return objMo9closeIoAF18A == CoroutineSingletons.f10059a ? objMo9closeIoAF18A : new Result(objMo9closeIoAF18A);
    }
}
