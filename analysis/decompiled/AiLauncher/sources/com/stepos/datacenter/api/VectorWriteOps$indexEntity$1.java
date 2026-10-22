package com.stepos.datacenter.api;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.api.VectorWriteOps", f = "VectorWriteOps.kt", l = {62, 80, 89, 95}, m = "indexEntity")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VectorWriteOps$indexEntity$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29963a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29964b;

    /* renamed from: c, reason: collision with root package name */
    public Object f29965c;

    /* renamed from: d, reason: collision with root package name */
    public Object f29966d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f29967e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ VectorWriteOps f29968f;

    /* renamed from: g, reason: collision with root package name */
    public int f29969g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VectorWriteOps$indexEntity$1(VectorWriteOps vectorWriteOps, InterfaceC4014c<? super VectorWriteOps$indexEntity$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29968f = vectorWriteOps;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29967e = obj;
        this.f29969g |= Integer.MIN_VALUE;
        return this.f29968f.d(null, null, null, this);
    }
}
