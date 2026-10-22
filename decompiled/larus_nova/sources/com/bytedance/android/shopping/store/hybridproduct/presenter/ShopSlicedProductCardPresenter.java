package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.store.slicecard.ShopSliceKey;
import com.bytedance.android.shopping.store.slicecard.ShopSliceUniqueId;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes14.dex */
public final class ShopSlicedProductCardPresenter extends sm.l<com.bytedance.android.ec.store.repository.vo.l> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f185317m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e0 f185318n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f185319o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.android.ecom.arch.slice.render.r f185320p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ECStoreViewModel f185321q;

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void c0() {
        com.bytedance.android.ecom.arch.slice.render.r r100 = this.f185320p;
        if (r100 == null) goto L7;
        SlcTemplateContext r101 = r100.f50700b;
        if (r101 == null) goto L7;
        r101.u(this.f185317m);
    L7:
        e0 r102 = this.f185318n;
        if (r102 == null) goto L15;
        com.bytedance.android.ecom.arch.slice.render.r r103 = this.f185320p;
        if (r103 == null) goto L16;
        View r104 = r103.f50701c;
        if (r104 == null) goto L17;
        r104.removeOnLayoutChangeListener(r102);
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // sm.l
    public final void e0(StoreV2ProductItemVO r100) {
        final com.bytedance.android.ec.store.repository.vo.l r101 = (com.bytedance.android.ec.store.repository.vo.l) r100;
        if (r101 == null) goto L60;
        Map<String, ? extends Object> r102 = com.bytedance.android.ec.store.repository.vo.m.a(r101, this.f185321q.getSliceService().a());
        com.bytedance.android.ecom.arch.slice.render.r r103 = this.f185320p;
        if (r103 == null) goto L7;
        r103.b((ShopSlicedProductCardPresenter$slcActionHandler$2.a) this.f185319o.getValue());
    L7:
        String r104 = ShopSliceUniqueId.SHOP_PRODUCT_CARD.getId() + "_{data.productId}_" + r101.f48443w;
        this.f185317m = r104;
        com.bytedance.android.ecom.arch.slice.render.r r105 = this.f185320p;
        if (r105 == null) goto L12;
        SlcTemplateContext r106 = r105.f50700b;
        if (r106 == null) goto L12;
        r106.s(r104, new ShopSlicedProductCardPresenter$onElementBind$$inlined$let$lambda$1(r101, this));
    L12:
        com.bytedance.android.ecom.arch.slice.render.r r107 = this.f185320p;
        if (r107 == null) goto L15;
        r107.a(r102, this.f185317m);
    L15:
        e0 r108 = new e0(this);
        this.f185318n = r108;
        com.bytedance.android.ecom.arch.slice.render.r r109 = this.f185320p;
        com.bytedance.android.ec.store.repository.dto.o r110 = null;
        if (r109 == null) goto L18;
        View r111 = r109.f50701c;
    L19:
        if (r111 == null) goto L29;
        r111.addOnLayoutChangeListener(r108);
        this.f542549f.b();
        sm.h r112 = this.f542549f;
        com.bytedance.android.ecom.arch.slice.render.r r113 = this.f185320p;
        if (r113 == null) goto L27;
        SlcTemplateContext r114 = r113.f50700b;
        if (r114 == null) goto L27;
        if (r114.f50235w == null) goto L27;
        View r115 = SlcRenderContext.f(r111, ShopSliceKey.PRODUCT_COVER.getKey());
    L28:
        r112.i(r115);
    L30:
        sm.j r116 = this.f542553j;
        if (r116 == null) goto L33;
        r116.b(Reflection.getOrCreateKotlinClass(sm.k.class), new h0(this));
    L33:
        com.bytedance.android.ecom.arch.slice.render.r r117 = this.f185320p;
        if (r117 == null) goto L38;
        View r118 = r117.f50701c;
        if (r118 == null) goto L38;
        sm.h r119 = this.f542549f;
        SlcRenderContext r120 = r117.f50700b.f50235w;
        String r121 = ShopSliceKey.PRODUCT_COVER.getKey();
        r120.getClass();
        r119.i(SlcRenderContext.f(r118, r121));
    L39:
        com.bytedance.android.ec.store.repository.vo.l r122 = (com.bytedance.android.ec.store.repository.vo.l) this.f542554k;
        if (r122 == null) goto L44;
        com.bytedance.android.ec.store.repository.vo.b r123 = r122.f48444x;
        if (r123 == null) goto L44;
        Boolean r124 = r123.f48457d;
    L46:
        if (Intrinsics.areEqual(r124, Boolean.TRUE) == false) goto L48;
        sm.g r125 = this.f542550g;
        StoreV2ProductItemVO r126 = this.f542554k;
        Intrinsics.checkNotNull(r126);
        r125.c(r126);
    L48:
        StoreV2ProductItemVO r127 = this.f542554k;
        com.bytedance.android.ec.store.repository.vo.l r128 = (com.bytedance.android.ec.store.repository.vo.l) r127;
        if (r128 == null) goto L51;
        r110 = r128.f48440t;
    L51:
        if (r110 == null) goto L53;
        sm.g r129 = this.f542550g;
        Intrinsics.checkNotNull(r127);
        r129.h(r127);
    L53:
        sm.j r130 = this.f542553j;
        if (r130 == null) goto L56;
        r130.b(Reflection.getOrCreateKotlinClass(sm.n.class), new f0(this));
    L56:
        jm.a<ej3.a> r131 = this.f542549f.q();
        if (r131 == null) goto L61;
        r131.a(Y().e(), new g0(this), false);
        return;
    L61:
        return;
    L44:
        r124 = null;
    L38:
        this.f542549f.i(null);
    L27:
        r115 = null;
        goto L28
    L29:
        this.f542549f.i(null);
        goto L30
    L18:
        r111 = null;
        goto L19
    }

    public ShopSlicedProductCardPresenter(Fragment r100, com.bytedance.android.ecom.arch.slice.render.r r101, ECStoreViewModel r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "storeViewModel");
        super(r100);
        this.f185320p = r101;
        this.f185321q = r102;
        this.f185317m = "";
        this.f185319o = LazyKt.lazy(new ShopSlicedProductCardPresenter$slcActionHandler$2(this));
    }
}
