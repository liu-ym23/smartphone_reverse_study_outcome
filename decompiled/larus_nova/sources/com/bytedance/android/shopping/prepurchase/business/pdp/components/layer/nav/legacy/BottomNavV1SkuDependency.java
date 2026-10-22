package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.bottom.d0;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class BottomNavV1SkuDependency implements d0, j73.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f181276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j73.m f181277b;

    @Override // j73.m
    public final void F(String r100, com.bytedance.android.shopping.utils.a0 r101) {
        Intrinsics.checkNotNullParameter(r100, "skuSessionId");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f181277b.F(r100, r101);
    }

    @Override // j73.m
    public final boolean I() {
        return this.f181277b.I();
    }

    @Override // j73.m
    public final SkuRestoreState P() {
        return this.f181277b.P();
    }

    @Override // j73.m
    public final void S(String r100) {
        Intrinsics.checkNotNullParameter(r100, "specId");
        this.f181277b.S(r100);
    }

    @Override // j73.m
    public final boolean X() {
        return this.f181277b.X();
    }

    @Override // j73.m
    public final void d0(int r100) {
        this.f181277b.d0(r100);
    }

    @Override // j73.m
    public final void e0(SkuRestoreState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f181277b.e0(r100);
    }

    @Override // j73.m
    public final void f0() {
        this.f181277b.f0();
    }

    @Override // j73.m
    public final boolean h0() {
        return this.f181277b.h0();
    }

    @Override // j73.m
    public final void l(SkuProductDetailInfo r100) {
        this.f181277b.l(r100);
    }

    @Override // j73.m
    public final void n0(boolean r100) {
        this.f181277b.n0(false);
    }

    @Override // j73.m
    public final void q(SkuRestoreState r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f181277b.q(r100, r101);
    }

    @Override // j73.m
    public final void v() {
        this.f181277b.v();
    }

    @Override // j73.m
    public final void z() {
        this.f181277b.z();
    }

    @Override // com.bytedance.android.shopping.anchorv4.bottom.d0
    public final CommonMeta a() {
        return this.f181276a.a();
    }

    @Override // com.bytedance.android.shopping.anchorv4.bottom.d0
    public final boolean e() {
        return this.f181276a.e();
    }

    @Override // com.bytedance.android.shopping.anchorv4.bottom.d0
    public final String getSessionId() {
        return this.f181276a.getSessionId();
    }

    @Override // com.bytedance.android.shopping.anchorv4.bottom.d0
    public final Boolean i() {
        return this.f181276a.i();
    }

    @Override // com.bytedance.android.shopping.anchorv4.bottom.d0
    public final int r() {
        return this.f181276a.r();
    }

    @Override // com.bytedance.android.shopping.anchorv4.bottom.d0
    public final V4NativeParams w() {
        return this.f181276a.c();
    }

    @Override // com.bytedance.android.shopping.anchorv4.bottom.d0
    public final void g(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f181276a.g(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.bottom.d0
    public final void h(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "extraElementId");
        this.f181276a.h(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.bottom.d0
    public final void k(SkuRestoreState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f181276a.k(r100);
    }

    public BottomNavV1SkuDependency(d r100, j73.m r101) {
        Intrinsics.checkNotNullParameter(r100, "anchorV4VM");
        Intrinsics.checkNotNullParameter(r101, "eventChainDependency");
        this.f181277b = r101;
        this.f181276a = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.bottom.d0
    public final boolean m(IAction r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "view");
        this.f181276a.m(r100, r101);
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.bottom.d0
    public final void n(final String r110, final Map<String, ? extends Object> r111, final boolean r112, final boolean r113, final String r114, final PageFinder r115) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        this.f181276a.d(new BottomNavV1SkuDependency$track$1(this, r111, r114, r115, r110, r113, r112));
    }
}
