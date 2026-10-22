package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import j73.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class InstantService$dependency$1 implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InstantService f182015a;

    @Override // j73.j
    public final Map<String, Object> A() {
        return this.f182015a.f182007k;
    }

    @Override // j73.j
    public final boolean E() {
        return this.f182015a.f182010n;
    }

    @Override // j73.j
    public final Map<String, Object> l0() {
        return this.f182015a.f182005i;
    }

    @Override // j73.j
    public final Map<String, String> o0() {
        return this.f182015a.f182009m;
    }

    @Override // j73.j
    public final Map<String, Object> x() {
        return this.f182015a.f182006j;
    }

    public InstantService$dependency$1(InstantService r100) {
        this.f182015a = r100;
    }

    @Override // j73.j
    public final void J(List<com.bytedance.android.ecom.arch.slice.adapter.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r101 = this.f182015a.f182012p.a();
        ArrayList r102 = new ArrayList();
        if (r101 == null) goto L5;
        r102.addAll(r101);
    L5:
        r102.addAll(r100);
        this.f182015a.f182012p.g(r102);
    }

    @Override // j73.j
    public final void K(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.f182015a.f182005i = r100;
    }

    @Override // j73.j
    public final void j0(Function1<? super Map<String, ? extends Object>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "calcCB");
        r100.invoke(this.f182015a.f182011o.a());
    }

    @Override // j73.j
    public final void p0(boolean r100) {
        this.f182015a.f182008l = r100;
    }

    @Override // j73.j
    public final void q0(boolean r100) {
        this.f182015a.f182010n = r100;
    }

    @Override // j73.j
    public final void u0(final int r100) {
        j0(new InstantService$dependency$1$updateInstantSupermarketCartBarData$1(this, r100));
    }
}
