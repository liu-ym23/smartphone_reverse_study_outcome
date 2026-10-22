package com.stepos.datacenter.api;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.api.VectorWriteOps", f = "VectorWriteOps.kt", l = {206}, m = "deleteVector")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VectorWriteOps$deleteVector$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f29955a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VectorWriteOps f29956b;

    /* renamed from: c, reason: collision with root package name */
    public int f29957c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VectorWriteOps$deleteVector$1(VectorWriteOps vectorWriteOps, InterfaceC4014c<? super VectorWriteOps$deleteVector$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29956b = vectorWriteOps;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29955a = obj;
        this.f29957c |= Integer.MIN_VALUE;
        return this.f29956b.b(0L, this);
    }
}
