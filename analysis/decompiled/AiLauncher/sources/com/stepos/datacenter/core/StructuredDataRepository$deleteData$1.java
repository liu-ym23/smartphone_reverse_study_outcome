package com.stepos.datacenter.core;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.datacenter.core.StructuredDataRepository", f = "StructuredDataRepository.kt", l = {79}, m = "deleteData")
/* loaded from: classes3.dex */
public final class StructuredDataRepository$deleteData$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29982a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f29983b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ StructuredDataRepository f29984c;

    /* renamed from: d, reason: collision with root package name */
    public int f29985d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StructuredDataRepository$deleteData$1(StructuredDataRepository structuredDataRepository, InterfaceC4014c<? super StructuredDataRepository$deleteData$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29984c = structuredDataRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29983b = obj;
        this.f29985d |= Integer.MIN_VALUE;
        return this.f29984c.d(null, this);
    }
}
