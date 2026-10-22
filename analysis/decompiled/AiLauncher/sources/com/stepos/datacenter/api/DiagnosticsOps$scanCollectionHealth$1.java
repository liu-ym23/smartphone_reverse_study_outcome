package com.stepos.datacenter.api;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.api.DiagnosticsOps", f = "DiagnosticsOps.kt", l = {32, 34, 48}, m = "scanCollectionHealth")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DiagnosticsOps$scanCollectionHealth$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29828a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29829b;

    /* renamed from: c, reason: collision with root package name */
    public Object f29830c;

    /* renamed from: d, reason: collision with root package name */
    public Object f29831d;

    /* renamed from: e, reason: collision with root package name */
    public Object f29832e;

    /* renamed from: f, reason: collision with root package name */
    public Object f29833f;

    /* renamed from: g, reason: collision with root package name */
    public Object f29834g;

    /* renamed from: h, reason: collision with root package name */
    public Object f29835h;

    /* renamed from: i, reason: collision with root package name */
    public Object f29836i;

    /* renamed from: j, reason: collision with root package name */
    public Object f29837j;

    /* renamed from: k, reason: collision with root package name */
    public Object f29838k;

    /* renamed from: l, reason: collision with root package name */
    public int f29839l;

    /* renamed from: m, reason: collision with root package name */
    public int f29840m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ Object f29841n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ DiagnosticsOps f29842o;

    /* renamed from: p, reason: collision with root package name */
    public int f29843p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsOps$scanCollectionHealth$1(DiagnosticsOps diagnosticsOps, InterfaceC4014c<? super DiagnosticsOps$scanCollectionHealth$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29842o = diagnosticsOps;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29841n = obj;
        this.f29843p |= Integer.MIN_VALUE;
        return this.f29842o.a(this);
    }
}
