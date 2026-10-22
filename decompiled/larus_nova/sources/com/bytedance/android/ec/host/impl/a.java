package com.bytedance.android.ec.host.impl;

import com.bytedance.android.ec.base.api.ai.AIChatComponentParam;
import com.bytedance.android.shopping.anchorv4.ai.j0;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements xe.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dw8.s f46194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AIChatComponentParam f46195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<xe.e, dw8.t> f46196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<xe.b, va8.i> f46197d;

    @Override // xe.d
    public final void B1() {
        this.f46194a.B1();
    }

    @Override // xe.d
    public final void D3() {
        this.f46194a.D3();
    }

    @Override // xe.d
    public final int c9() {
        return this.f46194a.c9();
    }

    @Override // xe.d
    public final void K1(List<Pair<String, String>> r100) {
        this.f46194a.K1(r100);
    }

    @Override // xe.d
    public final void a(xe.e r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        dw8.t r101 = this.f46196c.remove(r100);
        if (r101 == null) goto L6;
        this.f46194a.K4(r101);
        return;
    }

    @Override // xe.d
    public final void b(xe.b r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        va8.i r101 = this.f46197d.remove(r100);
        if (r101 == null) goto L6;
        this.f46194a.Qr(r101);
        return;
    }

    @Override // xe.d
    public final void c(xe.c r100) {
        this.f46194a.K2(new c(this.f46195b, r100));
    }

    @Override // xe.d
    public final void d(xe.e r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (this.f46196c.containsKey(r100) == false) goto L5;
        return;
    L5:
        ECMessageObserverWrapper r101 = new ECMessageObserverWrapper(r100);
        this.f46196c.put(r100, r101);
        this.f46194a.G5(r101);
    }

    @Override // xe.d
    public final void e(j0 r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (this.f46197d.containsKey(r100) == false) goto L5;
        return;
    L5:
        b0 r101 = new b0(r100);
        this.f46197d.put(r100, r101);
        this.f46194a.YI(r101);
    }

    @Override // xe.d
    public final void sa(long r100) {
        this.f46194a.sa(r100);
    }

    @Override // xe.d
    public final void setVisibility(boolean r100) {
        this.f46194a.s70(r100, false);
    }

    public a(dw8.s r100, AIChatComponentParam r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "param");
        this.f46194a = r100;
        this.f46195b = r101;
        this.f46196c = new ConcurrentHashMap();
        this.f46197d = new ConcurrentHashMap();
    }
}
