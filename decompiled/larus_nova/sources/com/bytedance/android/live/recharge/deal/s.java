package com.bytedance.android.live.recharge.deal;

import com.bytedance.android.livesdkapi.depend.model.IOneKeyPay;
import com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class s implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f89737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<u> f89738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<d> f89739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f89740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f89741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Long, com.bytedance.android.live.recharge.model.diamond.e> f89742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> f89743g;

    @Override // com.bytedance.android.live.recharge.deal.i
    public final List<Long> a() {
        return this.f89737a.a();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final boolean b() {
        return this.f89737a.b();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final int e() {
        return this.f89737a.e();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final IOneKeyPay f() {
        return this.f89737a.f();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final String g() {
        return this.f89737a.g();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final com.bytedance.android.live.recharge.model.diamond.b getBizExtra() {
        return this.f89737a.getBizExtra();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final boolean h() {
        return this.f89737a.h();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final String i() {
        return this.f89737a.i();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final boolean isOneStep() {
        return this.f89737a.isOneStep();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final boolean m() {
        return this.f89737a.m();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final IPrePayCashierInfo n() {
        return this.f89737a.n();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final long o() {
        return this.f89737a.o();
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final List<u> c() {
        return this.f89738b;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final long d() {
        return this.f89740d;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> getPanelExtraInfo() {
        return this.f89743g;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final Map<Long, com.bytedance.android.live.recharge.model.diamond.e> j() {
        return this.f89742f;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final List<d> k() {
        return this.f89739c;
    }

    @Override // com.bytedance.android.live.recharge.deal.i
    public final long l() {
        return this.f89741e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(i r100, List<u> r101, List<d> r102, long r103, long r104, Map<Long, ? extends com.bytedance.android.live.recharge.model.diamond.e> r105, Map<Long, ? extends com.bytedance.android.live.recharge.platform.business.model.diamond.g> r110) {
        Intrinsics.checkNotNullParameter(r100, "original");
        Intrinsics.checkNotNullParameter(r101, "deals");
        Intrinsics.checkNotNullParameter(r102, "customDealTiers");
        Intrinsics.checkNotNullParameter(r105, "diamondExtraInfo");
        Intrinsics.checkNotNullParameter(r110, "panelExtraInfo");
        this.f89737a = r100;
        this.f89738b = r101;
        this.f89739c = r102;
        this.f89740d = r103;
        this.f89741e = r104;
        this.f89742f = r105;
        this.f89743g = r110;
        Iterator<T> r106 = r101.iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        ((u) r106.next()).a(this);
        goto L4
    L6:
        Iterator<T> r107 = this.f89739c.iterator();
    L8:
        if (r107.hasNext() == false) goto L10;
        ((d) r107.next()).a(this);
        goto L8
    }
}
