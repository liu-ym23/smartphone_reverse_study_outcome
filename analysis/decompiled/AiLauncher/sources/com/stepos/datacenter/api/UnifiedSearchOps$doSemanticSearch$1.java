package com.stepos.datacenter.api;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.api.UnifiedSearchOps", f = "UnifiedSearchOps.kt", l = {163, 167}, m = "doSemanticSearch")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UnifiedSearchOps$doSemanticSearch$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29920a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29921b;

    /* renamed from: c, reason: collision with root package name */
    public Object f29922c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f29923d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ UnifiedSearchOps f29924e;

    /* renamed from: f, reason: collision with root package name */
    public int f29925f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnifiedSearchOps$doSemanticSearch$1(UnifiedSearchOps unifiedSearchOps, InterfaceC4014c<? super UnifiedSearchOps$doSemanticSearch$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29924e = unifiedSearchOps;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29923d = obj;
        this.f29925f |= Integer.MIN_VALUE;
        return this.f29924e.f(null, null, null, this);
    }
}
