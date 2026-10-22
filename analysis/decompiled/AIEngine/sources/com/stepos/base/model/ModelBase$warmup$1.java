package com.stepos.base.model;

import com.stepos.deepbinder.core.exception.ErrorCodes;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.Mutex;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.base.model.ModelBase", f = "ModelBase.kt", l = {202, ErrorCodes.CALLER_IN_METHOD_BLACK_LIST_ERROR}, m = "warmup-IoAF18A")
/* loaded from: classes.dex */
public final class ModelBase$warmup$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ModelBase f6314a;

    /* renamed from: b, reason: collision with root package name */
    public Mutex f6315b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f6316c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ModelBase f6317d;

    /* renamed from: e, reason: collision with root package name */
    public int f6318e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelBase$warmup$1(ModelBase modelBase, qb.b<? super ModelBase$warmup$1> bVar) {
        super(bVar);
        this.f6317d = modelBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f6316c = obj;
        this.f6318e |= Integer.MIN_VALUE;
        Object objM21warmupIoAF18A = this.f6317d.m21warmupIoAF18A(this);
        return objM21warmupIoAF18A == CoroutineSingletons.f10059a ? objM21warmupIoAF18A : new Result(objM21warmupIoAF18A);
    }
}
