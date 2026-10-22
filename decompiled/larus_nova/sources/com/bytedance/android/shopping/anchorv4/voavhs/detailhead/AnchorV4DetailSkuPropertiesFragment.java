package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.anchorv3.repository.dto.AttrItem;
import com.bytedance.android.shopping.anchorv3.repository.dto.ProductFormat;
import com.bytedance.android.shopping.anchorv3.repository.dto.ProductFormatGroup;
import com.bytedance.android.shopping.anchorv3.view.AnchorV4QualificationNewDesignView;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.jedi.JediBaseFragment;
import com.bytedance.commerce.uikit.flowlayout.TagFlowLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailSkuPropertiesFragment;", "Lcom/bytedance/android/shopping/jedi/JediBaseFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DetailSkuPropertiesFragment extends JediBaseFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f168184o = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f168185g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f168186h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f168187i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ExpandableLinearLayoutV4 f168188j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DetailSkuPropertiesFragmentParams f168189k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<u> f168190l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f168191m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f168192n;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        t r100 = this.f168189k.getViewModel();
        if (r100 == null) goto L7;
        CommonMeta r101 = r100.a();
        if (r101 == null) goto L7;
        Boolean r102 = Boolean.valueOf(r101.getEnablePDPOptimize());
    L9:
        return com.bytedance.android.shopping.extensions.k.i(r102);
    L7:
        r102 = null;
        goto L9
    }

    @Override // com.bytedance.android.ec.core.legacy.AbsFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f168191m == true) goto L97;
        this.f168191m = true;
        AnchorV4DetailSkuVO r100 = this.f168189k.getVo();
        if (r100 == null) goto L8;
        List<AnchorV4SubProduct> r101 = r100.getSubProducts();
    L9:
        if (r101 != null) goto L11;
    L86:
        View r102 = this.f168185g;
        if (r102 == null) goto L96;
        r102.setVisibility(8);
        return;
    L96:
        return;
    L11:
        if (r100.getSubProducts().isEmpty() == true) goto L86;
        ((ArrayList) this.f168190l).clear();
        AnchorV4SubProduct r103 = (AnchorV4SubProduct) ListProtector.get(r100.getSubProducts(), 0);
        TextView r104 = this.f168186h;
        if (r104 == null) goto L20;
        ProductFormatGroup r105 = r103.getProductFormatGroup();
        if (r105 == null) goto L18;
        String r106 = r105.getGroupName();
    L19:
        r104.setText(r106);
        goto L20
    L18:
        r106 = null;
    L20:
        StringBuilder r107 = new StringBuilder("x ");
        if (r103.getCombineNum() > 0) goto L23;
        int r108 = 1;
    L24:
        r107.append(r108);
        TextView r109 = this.f168187i;
        if (r109 == null) goto L27;
        r109.setText(r107.toString());
    L27:
        ProductFormatGroup r110 = r103.getProductFormatGroup();
        if (r110 == null) goto L30;
        List<ProductFormat> r111 = r110.getProductFormat();
    L31:
        ExpandableLinearLayoutV4 r112 = this.f168188j;
        if (r112 != null) goto L34;
    L71:
        ExpandableLinearLayoutV4 r113 = this.f168188j;
        if (r113 == null) goto L75;
        r113.setStateChangeListener(new o(this));
    L75:
        if (S90() == false) goto L93;
        View r114 = this.f168185g;
        if (r114 == null) goto L94;
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        if ((r115 instanceof ViewGroup.MarginLayoutParams) == true) goto L81;
        ViewGroup.LayoutParams r116 = null;
    L82:
        ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) r116;
        if (r117 == null) goto L85;
        r117.bottomMargin = com.bytedance.android.shopping.extensions.b.b(11);
        r117.leftMargin = com.bytedance.android.shopping.extensions.b.b(12);
        r117.rightMargin = com.bytedance.android.shopping.extensions.b.b(12);
        r114.setLayoutParams(r117);
    L85:
        r114.setBackgroundResource(R.drawable.shopping_bg_detail_combine_product_name_count_bg_opt);
        return;
    L81:
        r116 = r115;
        goto L82
    L94:
        return;
    L93:
        return;
    L34:
        if (r112.getChildCount() <= 0) goto L36;
        r112.removeAllViews();
    L36:
        if (r111 == null) goto L60;
        int r118 = r111.size();
        int r119 = this.f168192n;
        if (r118 > r119) goto L41;
        r119 = r111.size();
    L41:
        int r120 = r119;
        int r121 = 0;
    L42:
        if (r121 >= r120) goto L60;
        ProductFormat r122 = (ProductFormat) ListProtector.get(r111, r121);
        Context r123 = r112.getContext();
        ShoppingAsyncInflater.f45268e.getClass();
        View r124 = ShoppingAsyncInflater.a.a(r123).aU(R.layout.ec_commerce_anchor_v4_goods_info_extras_layout_opt, this.f168188j, false);
        ((TextView) r124.findViewById(R.id.tv_title)).setText(r122.getName());
        TagFlowLayout r125 = (TagFlowLayout) r124.findViewById(R.id.tag_layout);
        AnchorV4QualificationNewDesignView r126 = (AnchorV4QualificationNewDesignView) r124.findViewById(R.id.qualification_new_design);
        t r127 = this.f168189k.getViewModel();
        if (r127 == null) goto L48;
        CommonMeta r128 = r127.a();
        if (r128 == null) goto L48;
        String r129 = r128.getShopId();
    L49:
        q r130 = new q(this);
        int r131 = AnchorV4QualificationNewDesignView.f165480m;
        if (Intrinsics.areEqual(r122.getNewDesign(), Boolean.TRUE) == false) goto L58;
        wg.a.h(r126, true);
        wg.a.h(r125, false);
        AttrItem r132 = (AttrItem) CollectionsKt.getOrNull(r122.getMessage(), 0);
        if (r132 == null) goto L54;
        String r133 = r132.getDesc();
    L55:
        if (r133 != null) goto L57;
        r133 = "";
    L57:
        r126.d(r133, r122, r129, r130);
        ((ArrayList) this.f168190l).add(r126);
    L59:
        r112.a(r124);
        r121 = r121 + 1;
        goto L42
    L54:
        r133 = null;
        goto L55
    L58:
        wg.a.h(r125, true);
        wg.a.h(r126, false);
        r125.setTagAdapter(new p(this, r122, r129, r130, r122.getMessage()));
    L48:
        r129 = null;
    L60:
        AnchorV4DetailSkuVO r134 = this.f168189k.getVo();
        if (r134 != null) goto L63;
    L70:
        r112.post(new n(this, r111));
        goto L71
    L63:
        if (r134.getShowBottomView() != true) goto L70;
        Boolean r135 = Boolean.valueOf(S90());
        if (r135 == null) goto L68;
        r135.booleanValue();
        r112.f168209h = r135.booleanValue();
    L68:
        if (r112.f168203b == true) goto L70;
        r112.addView(r112.c(r112.f168209h));
        r112.f168203b = true;
        goto L70
    L30:
        r111 = null;
        goto L31
    L23:
        r108 = r103.getCombineNum();
        goto L24
    L8:
        r101 = null;
        goto L9
    }

    public AnchorV4DetailSkuPropertiesFragment() {
        this.f168189k = new DetailSkuPropertiesFragmentParams(0, null, null, 7, null);
        this.f168190l = new ArrayList();
        this.f168192n = 5;
    }

    @Override // com.bytedance.android.ec.core.legacy.AbsFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f168191m = false;
    }

    @Override // com.bytedance.android.ec.core.legacy.AbsFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f168185g = r100.findViewById(R.id.subproduct_info);
        this.f168186h = (TextView) r100.findViewById(R.id.detail_product_name);
        this.f168187i = (TextView) r100.findViewById(R.id.detail_product_count);
        this.f168188j = (ExpandableLinearLayoutV4) r100.findViewById(R.id.expandable_layout);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return u63.a.a(requireContext(), R.layout.ec_commerce_anchor_v4_combine_detail_page_content, r101, false);
    }
}
