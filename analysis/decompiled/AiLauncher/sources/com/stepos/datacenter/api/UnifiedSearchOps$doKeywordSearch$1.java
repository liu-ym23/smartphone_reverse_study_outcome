package com.stepos.datacenter.api;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.api.UnifiedSearchOps", f = "UnifiedSearchOps.kt", l = {122, 132}, m = "doKeywordSearch")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UnifiedSearchOps$doKeywordSearch$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29912a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29913b;

    /* renamed from: c, reason: collision with root package name */
    public Object f29914c;

    /* renamed from: d, reason: collision with root package name */
    public Object f29915d;

    /* renamed from: e, reason: collision with root package name */
    public Object f29916e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f29917f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ UnifiedSearchOps f29918g;

    /* renamed from: h, reason: collision with root package name */
    public int f29919h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnifiedSearchOps$doKeywordSearch$1(UnifiedSearchOps unifiedSearchOps, InterfaceC4014c<? super UnifiedSearchOps$doKeywordSearch$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29918g = unifiedSearchOps;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29917f = obj;
        this.f29919h |= Integer.MIN_VALUE;
        return this.f29918g.e(null, this);
    }
}
