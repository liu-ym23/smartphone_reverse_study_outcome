package com.stepos.datacenter.api;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.api.UnifiedSearchOps", f = "UnifiedSearchOps.kt", l = {185, 189, 192, 202}, m = "doHybridSearch")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UnifiedSearchOps$doHybridSearch$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29905a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29906b;

    /* renamed from: c, reason: collision with root package name */
    public Object f29907c;

    /* renamed from: d, reason: collision with root package name */
    public Object f29908d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f29909e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ UnifiedSearchOps f29910f;

    /* renamed from: g, reason: collision with root package name */
    public int f29911g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnifiedSearchOps$doHybridSearch$1(UnifiedSearchOps unifiedSearchOps, InterfaceC4014c<? super UnifiedSearchOps$doHybridSearch$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29910f = unifiedSearchOps;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29909e = obj;
        this.f29911g |= Integer.MIN_VALUE;
        return this.f29910f.d(null, null, this);
    }
}
