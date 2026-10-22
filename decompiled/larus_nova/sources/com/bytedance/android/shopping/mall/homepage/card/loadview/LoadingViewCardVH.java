package com.bytedance.android.shopping.mall.homepage.card.loadview;

import android.view.View;
import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s93.c;
import yj.g;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/loadview/LoadingViewCardVH;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LoadingViewCardVH extends BaseViewHolder {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final boolean f178007q = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final View f178008o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final o93.a f178009p;

    public static final class a {
    }

    public interface b {
        void a();
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder, com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final boolean C3() {
        return false;
    }

    static {
        int r100 = c.f541066a;
        Object r101 = Boolean.TRUE;
        IHybridHostService r102 = com.bytedance.android.ec.hybrid.a.h();
        if (r102 == null) goto L10;
        g r103 = r102.getHostAB();
        if (r103 == null) goto L10;
        Object r104 = r103.a("ec_mall_feed_loading_layout_opt_enable", r101);
        if (r104 == null) goto L10;
        r101 = r104;
    L10:
        Lazy r105 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.f47463b, "Key : ec_mall_feed_loading_layout_opt_enable, Value: " + r101);
        f178007q = ((Boolean) r101).booleanValue();
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder, com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final void o() {
        super.o();
        o93.a r100 = this.f178009p;
        r100.f522469d.setVisibility(8);
        LottieAnimationView r101 = r100.f522466a;
        if (r101 == null) goto L6;
        r101.cancelAnimation();
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder, com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final void onRelease() {
        super.onRelease();
        LottieAnimationView r100 = this.f178009p.f522466a;
        if (r100 == null) goto L6;
        r100.cancelAnimation();
        return;
    }

    public LoadingViewCardVH(View r100, ECHybridListContainer r101, o93.a r102) {
        super(r100);
        this.f178008o = r101;
        this.f178009p = r102;
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder
    public final void b4(Object r100, String r101, k.a r102) {
        Intrinsics.checkNotNullParameter(r101, "itemId");
        super.b4(r100, r101, r102);
        boolean r103 = r100 instanceof JSONObject;
        Object r104 = null;
        if (r103 == true) goto L5;
        Object r105 = null;
    L6:
        JSONObject r106 = (JSONObject) r105;
        if (r106 == null) goto L9;
        int r107 = r106.optInt("loading_view_type");
    L11:
        if (r107 == 1) goto L28;
        ECHybridListAdapter r108 = this.f47156g;
        if (r108 == null) goto L20;
        ECHybridListEngine r109 = r108.f46860u;
        if (r109 == null) goto L20;
        BaseViewHolder r110 = r109.e("category_tab_section", "category_tab_section");
        if (r110 == null) goto L20;
        View r111 = r110.itemView;
    L21:
        if (r111 == null) goto L28;
        View r112 = this.f178008o;
        if (r112 == null) goto L28;
        int r113 = r112.getHeight() - r111.getBottom();
        View r114 = this.f178009p.f522469d;
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        if (f178007q == false) goto L27;
        r115.width = this.f178008o.getWidth();
    L27:
        r115.height = r113;
        r114.setLayoutParams(r115);
    L20:
        r111 = null;
    L28:
        if (r103 == true) goto L30;
        r100 = null;
    L30:
        JSONObject r116 = (JSONObject) r100;
        if (r116 == null) goto L34;
        r104 = r116.get("loading_status");
    L34:
        if (Intrinsics.areEqual(r104, 1) == false) goto L48;
        o93.a r117 = this.f178009p;
        r117.f522469d.setVisibility(0);
        LottieAnimationView r118 = r117.f522466a;
        if (r118 == null) goto L38;
        r118.setVisibility(0);
    L38:
        View r119 = r117.f522467b;
        if (r119 == null) goto L41;
        r119.setVisibility(8);
    L41:
        View r120 = r117.f522468c;
        if (r120 == null) goto L44;
        r120.setVisibility(8);
    L44:
        LottieAnimationView r121 = r117.f522466a;
        if (r121 == null) goto L70;
        r121.playAnimation();
        return;
    L70:
        return;
    L48:
        if (Intrinsics.areEqual(r104, 2) == false) goto L59;
        o93.a r122 = this.f178009p;
        r122.f522469d.setVisibility(0);
        View r123 = r122.f522468c;
        if (r123 == null) goto L52;
        r123.setVisibility(0);
    L52:
        LottieAnimationView r124 = r122.f522466a;
        if (r124 == null) goto L55;
        r124.setVisibility(8);
    L55:
        View r125 = r122.f522467b;
        if (r125 == null) goto L72;
        r125.setVisibility(8);
        return;
    L72:
        return;
    L59:
        if (Intrinsics.areEqual(r104, 3) == false) goto L74;
        o93.a r126 = this.f178009p;
        r126.f522469d.setVisibility(0);
        View r127 = r126.f522467b;
        if (r127 == null) goto L63;
        r127.setVisibility(0);
    L63:
        LottieAnimationView r128 = r126.f522466a;
        if (r128 == null) goto L66;
        r128.setVisibility(8);
    L66:
        View r129 = r126.f522468c;
        if (r129 == null) goto L75;
        r129.setVisibility(8);
        return;
    L75:
        return;
    L74:
        return;
    L9:
        r107 = 0;
        goto L11
    L5:
        r105 = r100;
        goto L6
    }
}
