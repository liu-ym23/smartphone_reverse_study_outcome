package com.stepos.datacenter.api;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.api.VectorWriteOps", f = "VectorWriteOps.kt", l = {129}, m = "ensureCollectionRegistered")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VectorWriteOps$ensureCollectionRegistered$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29958a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29959b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f29960c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ VectorWriteOps f29961d;

    /* renamed from: e, reason: collision with root package name */
    public int f29962e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VectorWriteOps$ensureCollectionRegistered$1(VectorWriteOps vectorWriteOps, InterfaceC4014c<? super VectorWriteOps$ensureCollectionRegistered$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29961d = vectorWriteOps;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29960c = obj;
        this.f29962e |= Integer.MIN_VALUE;
        return this.f29961d.c(null, null, this);
    }
}
