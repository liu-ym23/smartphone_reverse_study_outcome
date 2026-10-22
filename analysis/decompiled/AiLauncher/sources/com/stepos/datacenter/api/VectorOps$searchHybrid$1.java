package com.stepos.datacenter.api;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.api.VectorOps", f = "VectorOps.kt", l = {141, 263}, m = "searchHybrid")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VectorOps$searchHybrid$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29938a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29939b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f29940c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ VectorOps f29941d;

    /* renamed from: e, reason: collision with root package name */
    public int f29942e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VectorOps$searchHybrid$1(VectorOps vectorOps, InterfaceC4014c<? super VectorOps$searchHybrid$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29941d = vectorOps;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29940c = obj;
        this.f29942e |= Integer.MIN_VALUE;
        return this.f29941d.a(null, null, this);
    }
}
