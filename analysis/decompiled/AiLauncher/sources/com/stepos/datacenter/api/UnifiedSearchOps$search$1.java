package com.stepos.datacenter.api;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.api.UnifiedSearchOps", f = "UnifiedSearchOps.kt", l = {24, 31, 37, 39, 59}, m = "search")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UnifiedSearchOps$search$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29926a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29927b;

    /* renamed from: c, reason: collision with root package name */
    public Object f29928c;

    /* renamed from: d, reason: collision with root package name */
    public Object f29929d;

    /* renamed from: e, reason: collision with root package name */
    public Object f29930e;

    /* renamed from: f, reason: collision with root package name */
    public Object f29931f;

    /* renamed from: g, reason: collision with root package name */
    public Object f29932g;

    /* renamed from: h, reason: collision with root package name */
    public long f29933h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f29934i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ UnifiedSearchOps f29935j;

    /* renamed from: k, reason: collision with root package name */
    public int f29936k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnifiedSearchOps$search$1(UnifiedSearchOps unifiedSearchOps, InterfaceC4014c<? super UnifiedSearchOps$search$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29935j = unifiedSearchOps;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29934i = obj;
        this.f29936k |= Integer.MIN_VALUE;
        return this.f29935j.i(null, null, this);
    }
}
