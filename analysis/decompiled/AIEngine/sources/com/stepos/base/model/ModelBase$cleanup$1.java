package com.stepos.base.model;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.Mutex;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.base.model.ModelBase", f = "ModelBase.kt", l = {202, 70}, m = "cleanup-IoAF18A")
/* loaded from: classes.dex */
public final class ModelBase$cleanup$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ModelBase f6280a;

    /* renamed from: b, reason: collision with root package name */
    public Mutex f6281b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f6282c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ModelBase f6283d;

    /* renamed from: e, reason: collision with root package name */
    public int f6284e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelBase$cleanup$1(ModelBase modelBase, qb.b<? super ModelBase$cleanup$1> bVar) {
        super(bVar);
        this.f6283d = modelBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f6282c = obj;
        this.f6284e |= Integer.MIN_VALUE;
        Object objM20cleanupIoAF18A = this.f6283d.m20cleanupIoAF18A(this);
        return objM20cleanupIoAF18A == CoroutineSingletons.f10059a ? objM20cleanupIoAF18A : new Result(objM20cleanupIoAF18A);
    }
}
