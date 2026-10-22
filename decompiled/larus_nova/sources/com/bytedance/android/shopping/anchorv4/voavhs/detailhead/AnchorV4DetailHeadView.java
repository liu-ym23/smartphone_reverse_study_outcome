package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.RoundedLinearLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBannerStruct;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.detail.widget.AnchorV3CommonBannerView;
import com.bytedance.android.shopping.anchorv3.repository.dto.AttrItem;
import com.bytedance.android.shopping.anchorv3.repository.dto.DetailCombinePropertiesComponent;
import com.bytedance.android.shopping.anchorv3.repository.dto.DetailCombinePropertiesSkusStruct;
import com.bytedance.android.shopping.anchorv3.repository.dto.DetailTagCard;
import com.bytedance.android.shopping.anchorv3.repository.dto.ProductFormat;
import com.bytedance.android.shopping.anchorv3.repository.dto.ProductFormatGroup;
import com.bytedance.android.shopping.anchorv3.repository.dto.SkuSubProductsStruct;
import com.bytedance.android.shopping.anchorv3.utils.c0;
import com.bytedance.android.shopping.anchorv3.view.AnchorV4QualificationNewDesignView;
import com.bytedance.android.shopping.anchorv4.dto.Control;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.commerce.uikit.flowlayout.TagFlowLayout;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u00013\u0018\u00002\u00020\u0001:\u0001\u0007B)\b\u0007\u0012\b\u00109\u001a\u0004\u0018\u000108\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:\u0012\b\b\u0002\u0010=\u001a\u00020<¢\u0006\u0004\b>\u0010?J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002R#\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR#\u0010\u0010\u001a\n \u0006*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0015\u001a\n \u0006*\u0004\u0018\u00010\u00110\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u001a\u001a\n \u0006*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u001f\u001a\n \u0006*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001d\u0010\u001eR#\u0010$\u001a\n \u0006*\u0004\u0018\u00010 0 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\b\u001a\u0004\b\"\u0010#R#\u0010)\u001a\n \u0006*\u0004\u0018\u00010%0%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\b\u001a\u0004\b'\u0010(R#\u0010,\u001a\n \u0006*\u0004\u0018\u00010%0%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\b\u001a\u0004\b+\u0010(R#\u0010/\u001a\n \u0006*\u0004\u0018\u00010%0%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\b\u001a\u0004\b.\u0010(R#\u00102\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\b\u001a\u0004\b1\u0010\nR\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\b\u001a\u0004\b5\u00106¨\u0006@"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailHeadView;", "Landroid/widget/RelativeLayout;", "", "", "getShowParamsList", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getRootView", "()Landroid/widget/LinearLayout;", "rootView", "Landroid/widget/FrameLayout;", "b", "getHeaderContainer", "()Landroid/widget/FrameLayout;", "headerContainer", "Lcom/facebook/drawee/view/SimpleDraweeView;", "c", "getTagCardView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "tagCardView", "Lcom/bytedance/android/ec/core/widget/RoundedLinearLayout;", "d", "getExpandableLayoutContainer", "()Lcom/bytedance/android/ec/core/widget/RoundedLinearLayout;", "expandableLayoutContainer", "Landroid/widget/TextView;", "e", "getGoodDetailTitle", "()Landroid/widget/TextView;", "goodDetailTitle", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4;", "f", "getExpandableLayout", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4;", "expandableLayout", "Landroid/view/View;", ce.f26391f, "getExpandableLayoutArea", "()Landroid/view/View;", "expandableLayoutArea", "h", "getCombineDetailContentView", "combineDetailContentView", RXScreenCaptureService.KEY_INDEX, "getCombineDetailContentOptView", "combineDetailContentOptView", "l", "getLlBannerItems", "llBannerItems", "com/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailHeadView$updateCombineProductTabJsEventSubscriber$2$a", "w", "getUpdateCombineProductTabJsEventSubscriber", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailHeadView$updateCombineProductTabJsEventSubscriber$2$a;", "updateCombineProductTabJsEventSubscriber", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DetailHeadView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f168154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f168155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f168156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f168157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f168158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f168159f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f168160g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f168161h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f168162i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TabLayout f168163j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AutoHeightViewPager f168164k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f168165l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f168166m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public t f168167n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public d f168168o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<u> f168169p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AnchorV3CommonBannerView f168170q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList<AnchorV4DetailSkuVO> f168171r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f168172s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f168173t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f168174u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f168175v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f168176w;

    public static final class a {
    }

    static {
    }

    public AnchorV4DetailHeadView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV4DetailHeadView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final View getCombineDetailContentOptView() {
        return (View) this.f168162i.getValue();
    }

    private final View getCombineDetailContentView() {
        return (View) this.f168161h.getValue();
    }

    private final ExpandableLinearLayoutV4 getExpandableLayout() {
        return (ExpandableLinearLayoutV4) this.f168159f.getValue();
    }

    private final View getExpandableLayoutArea() {
        return (View) this.f168160g.getValue();
    }

    private final RoundedLinearLayout getExpandableLayoutContainer() {
        return (RoundedLinearLayout) this.f168157d.getValue();
    }

    private final TextView getGoodDetailTitle() {
        return (TextView) this.f168158e.getValue();
    }

    private final FrameLayout getHeaderContainer() {
        return (FrameLayout) this.f168155b.getValue();
    }

    private final LinearLayout getLlBannerItems() {
        return (LinearLayout) this.f168165l.getValue();
    }

    private final LinearLayout getRootView() {
        return (LinearLayout) this.f168154a.getValue();
    }

    private final SimpleDraweeView getTagCardView() {
        return (SimpleDraweeView) this.f168156c.getValue();
    }

    private final AnchorV4DetailHeadView$updateCombineProductTabJsEventSubscriber$2.a getUpdateCombineProductTabJsEventSubscriber() {
        return (AnchorV4DetailHeadView$updateCombineProductTabJsEventSubscriber$2.a) this.f168176w.getValue();
    }

    private final List<String> getShowParamsList() {
        ArrayList r100 = new ArrayList();
        d r101 = this.f168168o;
        if (r101 == null) goto L17;
        List<ProductFormatGroup> r102 = r101.f168218c;
        if (r102 == null) goto L17;
        Iterator<T> r103 = r102.iterator();
        int r104 = 0;
    L8:
        if (r103.hasNext() == false) goto L17;
        List<ProductFormat> r105 = ((ProductFormatGroup) r103.next()).getProductFormat();
        if (r105 == null) goto L8;
        Iterator<T> r106 = r105.iterator();
    L13:
        if (r106.hasNext() == false) goto L8;
        ProductFormat r107 = (ProductFormat) r106.next();
        if (r104 >= getExpandableLayout().getMaxItemCount()) goto L13;
        r104 = r104 + 1;
        r100.add(r107.getName());
    L17:
        return r100;
    }

    public final void e() {
        List<String> r100 = getShowParamsList();
        int r101 = r100.size();
        t r102 = this.f168167n;
        String r103 = "1";
        if (r102 == null) goto L33;
        d r110 = this.f168168o;
        if (r110 == null) goto L12;
        List<ProductFormatGroup> r111 = r110.f168218c;
        if (r111 == null) goto L12;
        if ((!r111.isEmpty()) != true) goto L12;
        if (com.bytedance.android.shopping.anchorv4.log.g.a(getExpandableLayout()) == false) goto L12;
    L22:
        boolean r112 = true;
    L24:
        if (r112 == false) goto L26;
        t r113 = r102;
    L27:
        if (r113 == null) goto L33;
        Pair[] r104 = new Pair[4];
        r104[0] = TuplesKt.to("params_cnt", Integer.valueOf(r101));
        if (r101 >= 5) goto L31;
        Object r114 = "0";
    L32:
        r104[1] = TuplesKt.to("is_fold", r114);
        r104[2] = TuplesKt.to("params_list", CollectionsKt.joinToString$default(r100, ",", null, null, 0, null, null, 62, null));
        r104[3] = TuplesKt.to("btm", "a1.b8094.c747297.0");
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r113, "show_product_feature", MapsKt.mapOf(r104), false, com.bytedance.android.ec.core.event.a.EVENT_PDP_MODULE_SHOW, null, null, null, VideoRef.VALUE_VIDEO_REF_CODEC_HAS_BYTEVC2);
        goto L33
    L31:
        r114 = "1";
        goto L32
    L26:
        r113 = null;
    L12:
        d r115 = this.f168168o;
        if (r115 == null) goto L23;
        DetailCombinePropertiesComponent r116 = r115.f168221f;
        if (r116 == null) goto L23;
        List<DetailCombinePropertiesSkusStruct> r117 = r116.getSkus();
        if (r117 == null) goto L23;
        if ((!r117.isEmpty()) != true) goto L23;
        if (com.bytedance.android.shopping.anchorv4.log.g.a(this.f168164k) == true) goto L22;
    L23:
        r112 = false;
    L33:
        t r105 = this.f168167n;
        if (r105 == null) goto L48;
        ExpandableLinearLayoutV4 r106 = getExpandableLayout();
        boolean r118 = this.f168174u;
        r106.f168209h = r118;
        View r107 = r106.c(r118);
        if (r107 == null) goto L38;
        boolean r108 = com.bytedance.android.shopping.anchorv4.log.g.a(r107);
    L39:
        if (r108 == false) goto L41;
        t r119 = r105;
    L42:
        if (r119 == null) goto L48;
        Pair[] r109 = new Pair[3];
        r109[0] = TuplesKt.to("params_cnt", Integer.valueOf(r101));
        if (r101 >= 5) goto L46;
        Object r120 = "0";
    L47:
        r109[1] = TuplesKt.to("is_fold", r120);
        r109[2] = TuplesKt.to("params_list", CollectionsKt.joinToString$default(r100, ",", null, null, 0, null, null, 62, null));
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r119, "show_product_feature_unfold", MapsKt.mapOf(r109), false, null, null, null, "show_product_feature_unfold", 116);
        goto L48
    L46:
        r120 = "1";
        goto L47
    L41:
        r119 = null;
        goto L42
    L38:
        r108 = false;
    L48:
        t r121 = this.f168167n;
        if (r121 == null) goto L63;
        ExpandableLinearLayoutV4 r122 = getExpandableLayout();
        boolean r123 = this.f168174u;
        r122.f168209h = r123;
        View r124 = r122.c(r123);
        if (r124 == null) goto L53;
        boolean r125 = com.bytedance.android.shopping.anchorv4.log.g.a(r124);
    L54:
        if (r125 == false) goto L56;
        t r126 = r121;
    L57:
        if (r126 == null) goto L63;
        Pair[] r127 = new Pair[3];
        r127[0] = TuplesKt.to("params_cnt", Integer.valueOf(r101));
        if (r101 >= 5) goto L61;
        Object r128 = "0";
    L62:
        r127[1] = TuplesKt.to("is_fold", r128);
        r127[2] = TuplesKt.to("params_list", CollectionsKt.joinToString$default(r100, ",", null, null, 0, null, null, 62, null));
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r126, com.bytedance.android.ec.core.event.a.EVENT_PDP_MODULE_SHOW, MapsKt.mapOf(r127), false, null, null, null, "pdp_module_show_product_feature_show", 116);
        goto L63
    L61:
        r128 = "1";
        goto L62
    L56:
        r126 = null;
        goto L57
    L53:
        r125 = false;
    L63:
        Iterator r129 = ((ArrayList) this.f168169p).iterator();
    L65:
        if (r129.hasNext() == false) goto L86;
        u r130 = (u) r129.next();
        t r131 = this.f168167n;
        if (r131 != null) goto L69;
    L74:
        t r132 = this.f168167n;
        if (r132 == null) goto L65;
        if (com.bytedance.android.shopping.anchorv4.log.g.a(r130.a()) == false) goto L79;
        t r133 = r132;
    L80:
        if (r133 == null) goto L65;
        Pair[] r134 = new Pair[3];
        TextView r135 = r130.a();
        if (r135 == null) goto L84;
        CharSequence r136 = r135.getText();
    L85:
        r134[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, r136);
        r134[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, this.f168166m);
        r134[2] = TuplesKt.to("character_type", r130.b());
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r133, "info_explanation_entrance_show", MapsKt.mapOf(r134), false, null, null, null, null, 244);
        goto L65
    L84:
        r136 = null;
        goto L85
    L79:
        r133 = null;
        goto L80
    L69:
        if (com.bytedance.android.shopping.anchorv4.log.g.a(r130.c()) == false) goto L71;
        t r137 = r131;
    L72:
        if (r137 == null) goto L74;
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r137, "brand_logo_show", MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, this.f168166m), TuplesKt.to("character_type", r130.b())}), false, null, null, null, null, 244);
        goto L74
    L71:
        r137 = null;
        goto L72
    L86:
        String r138 = com.bytedance.android.shopping.extensions.j.c(R.string.anchor_v3_dcar_report);
        t r139 = this.f168167n;
        if (r139 != null) goto L89;
    L94:
        d r140 = this.f168168o;
        if (r140 == null) goto L119;
        DetailCombinePropertiesComponent r141 = r140.f168221f;
        if (r141 == null) goto L119;
        List<DetailCombinePropertiesSkusStruct> r142 = r141.getSkus();
        if (r142 == null) goto L119;
        if (r142.size() > 1) goto L103;
    L105:
        boolean r143 = false;
    L106:
        if (r143 == true) goto L109;
        r142 = null;
    L109:
        if (r142 == null) goto L119;
        if (((DetailCombinePropertiesSkusStruct) CollectionsKt.getOrNull(r142, 0)) == null) goto L119;
        int r144 = b.f168215a;
        t r145 = this.f168167n;
        d r146 = this.f168168o;
        if (r146 == null) goto L115;
        DetailCombinePropertiesComponent r147 = r146.f168221f;
    L116:
        String r148 = b.b(r147);
        Intrinsics.checkNotNullParameter(r148, "tabType");
        if (r145 == null) goto L119;
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r145, "product_feature_tab_show", MapsKt.mapOf(TuplesKt.to("tab_type", r148)), false, null, null, null, null, 244);
        goto L119
    L115:
        r147 = null;
        goto L116
    L103:
        if (com.bytedance.android.shopping.anchorv4.log.g.a(this.f168163j) == false) goto L105;
        r143 = true;
    L119:
        AutoHeightViewPager r149 = this.f168164k;
        if (r149 != null) goto L122;
        return;
    L122:
        if (r149.getVisibility() != 0) goto L212;
        AutoHeightViewPager r150 = this.f168164k;
        if (r150 == null) goto L209;
        PagerAdapter r151 = r150.getAdapter();
        if ((r151 instanceof AnchorV4DetailCombinePropertyPagerAdapter) == true) goto L129;
        r151 = null;
    L129:
        AnchorV4DetailCombinePropertyPagerAdapter r152 = (AnchorV4DetailCombinePropertyPagerAdapter) r151;
        if (r152 == null) goto L210;
        Fragment r153 = r152.getItem(r150.getCurrentItem());
        if ((r153 instanceof AnchorV4DetailSkuPropertiesFragment) == true) goto L134;
        r153 = null;
    L134:
        AnchorV4DetailSkuPropertiesFragment r154 = (AnchorV4DetailSkuPropertiesFragment) r153;
        if (r154 == null) goto L211;
        ExpandableLinearLayoutV4 r155 = r154.f168188j;
        if (r155 == null) goto L159;
        boolean r156 = r154.S90();
        r155.f168209h = r156;
        View r157 = r155.c(r156);
        if (r157 == null) goto L141;
        boolean r158 = com.bytedance.android.shopping.anchorv4.log.g.a(r157);
    L142:
        if (r158 == false) goto L159;
        AnchorV4DetailSkuVO r159 = r154.f168189k.getVo();
        if (r159 == null) goto L146;
        boolean r160 = r159.getShowBottomView();
    L147:
        int r161 = b.f168215a;
        t r162 = r154.f168189k.getViewModel();
        AnchorV4DetailSkuVO r163 = r154.f168189k.getVo();
        if (r163 == null) goto L152;
        List<AnchorV4SubProduct> r164 = r163.getSubProducts();
        if (r164 == null) goto L152;
        int r165 = r164.size();
    L153:
        if (r162 == null) goto L159;
        Pair[] r166 = new Pair[2];
        r166[0] = TuplesKt.to("params_cnt", Integer.valueOf(r165));
        if (r160 == true) goto L158;
        r103 = "0";
    L158:
        r166[1] = TuplesKt.to("is_fold", r103);
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r162, "show_product_feature_unfold", MapsKt.mapOf(r166), false, null, null, null, "show_product_feature_unfold", 116);
    L152:
        r165 = 0;
        goto L153
    L146:
        r160 = false;
        goto L147
    L141:
        r158 = false;
    L159:
        Iterator r167 = ((ArrayList) r154.f168190l).iterator();
    L161:
        if (r167.hasNext() == false) goto L213;
        u r168 = (u) r167.next();
        t r169 = r154.f168189k.getViewModel();
        if (r169 != null) goto L165;
    L176:
        t r170 = r154.f168189k.getViewModel();
        if (r170 == null) goto L161;
        if (com.bytedance.android.shopping.anchorv4.log.g.a(r168.a()) == false) goto L181;
        t r171 = r170;
    L182:
        if (r171 == null) goto L161;
        Pair[] r172 = new Pair[2];
        TextView r173 = r168.a();
        if (r173 == null) goto L186;
        CharSequence r174 = r173.getText();
    L187:
        r172[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, r174);
        t r175 = r154.f168189k.getViewModel();
        if (r175 == null) goto L192;
        CommonMeta r176 = r175.a();
        if (r176 == null) goto L192;
        String r177 = r176.getShopId();
    L193:
        r172[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r177);
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r171, "info_explanation_entrance_show", MapsKt.mapOf(r172), false, null, null, null, null, 244);
    L192:
        r177 = null;
        goto L193
    L186:
        r174 = null;
        goto L187
    L181:
        r171 = null;
        goto L182
    L165:
        if (com.bytedance.android.shopping.anchorv4.log.g.a(r168.c()) == false) goto L167;
        t r178 = r169;
    L168:
        if (r178 == null) goto L176;
        t r179 = r154.f168189k.getViewModel();
        if (r179 == null) goto L174;
        CommonMeta r180 = r179.a();
        if (r180 == null) goto L174;
        String r181 = r180.getShopId();
    L175:
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r178, "brand_logo_show", MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r181)), false, null, null, null, null, 244);
    L174:
        r181 = null;
        goto L175
    L167:
        r178 = null;
        goto L168
    L213:
        return;
    L211:
        return;
    L210:
        return;
    L209:
        return;
    L212:
        return;
    L89:
        if (com.bytedance.android.shopping.anchorv4.log.g.a(this.f168170q) == false) goto L91;
        t r182 = r139;
    L92:
        if (r182 == null) goto L94;
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r182, "info_explanation_entrance_show", MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, r138)), false, null, null, null, null, 244);
        goto L94
    L91:
        r182 = null;
        goto L92
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d r100 = this.f168168o;
        if (r100 == null) goto L14;
        DetailCombinePropertiesComponent r101 = r100.f168221f;
        if (r101 == null) goto L15;
        Intrinsics.checkNotNullParameter(r101, "$this$getSkusCount");
        List<DetailCombinePropertiesSkusStruct> r102 = r101.getSkus();
        if (r102 == null) goto L9;
        int r103 = r102.size();
    L11:
        if (Integer.valueOf(r103).intValue() <= 1) goto L16;
        ECLiveHybridUtil.m("SKU_TAG_CHANGE_IN_PRODUCT_PARAMS_SUPERNATANT", getUpdateCombineProductTabJsEventSubscriber());
        return;
    L16:
        return;
    L9:
        r103 = 0;
        goto L11
    L15:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ECLiveHybridUtil.p("SKU_TAG_CHANGE_IN_PRODUCT_PARAMS_SUPERNATANT", getUpdateCombineProductTabJsEventSubscriber());
    }

    public static final /* synthetic */ ExpandableLinearLayoutV4 a(AnchorV4DetailHeadView r100) {
        return r100.getExpandableLayout();
    }

    public static final /* synthetic */ LinearLayout b(AnchorV4DetailHeadView r100) {
        return r100.getRootView();
    }

    public static final void c(AnchorV4DetailHeadView r110) {
        r110.getClass();
        Activity r100 = ECAppInfoService.f48114e.getCurrentActivity();
        if (r100 == null) goto L30;
        d r101 = r110.f168168o;
        if (r101 == null) goto L30;
        String r102 = r101.f168222g;
        if (r102 == null) goto L30;
        int r103 = c.f168216a;
        t r104 = r110.f168167n;
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter("", "activeId");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L25
        LinkedHashMap r106 = new LinkedHashMap();     // Catch: Throwable -> L25
        r106.put("active_id", "");     // Catch: Throwable -> L25
        if (r104 == null) goto L16;
        CommonMeta r107 = r104.a();     // Catch: Throwable -> L25
        if (r107 == null) goto L16;
        String r108 = r107.getPromotionId();     // Catch: Throwable -> L25
        if (r108 == null) goto L16;
        r106.put("promotion_id", r108);     // Catch: Throwable -> L25
    L16:
        if (r104 == null) goto L20;
        CommonMeta r109 = r104.a();     // Catch: Throwable -> L25
        if (r109 == null) goto L20;
        LinkedHashMap r111 = new LinkedHashMap();     // Catch: Throwable -> L25
        int r112 = com.bytedance.android.shopping.anchorv4.containers.b.f166215a;     // Catch: Throwable -> L25
        r111.put("track_params", com.bytedance.android.shopping.anchorv4.containers.b.a(r109, r104.b()).toString());     // Catch: Throwable -> L25
        r106.put("mega_object", r111.toString());     // Catch: Throwable -> L25
    L20:
        String r113 = p0.b(r102, r106);     // Catch: Throwable -> L25
        if (r113 != null) goto L23;
        r113 = r102;
    L23:
        ECLiveHybridUtil.k(r100, r113, false, false, false, null, 252);     // Catch: Throwable -> L25
        Object r114 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L30;
        ECExceptionMonitor.e(r115);
    L25:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L30:
        List<String> r117 = r110.getShowParamsList();
        int r118 = r117.size();
        int r119 = b.f168215a;
        b.a(r110.f168167n, r118, true, CollectionsKt.joinToString$default(r117, ",", null, null, 0, null, null, 62, null));
    }

    public AnchorV4DetailHeadView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        if (r100 == null) goto L5;
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_anchor_v4_detail_head_layout, this, true);
    L5:
        this.f168154a = LazyKt.lazy(new AnchorV4DetailHeadView$rootView$2(this));
        this.f168155b = LazyKt.lazy(new AnchorV4DetailHeadView$headerContainer$2(this));
        this.f168156c = LazyKt.lazy(new AnchorV4DetailHeadView$tagCardView$2(this));
        this.f168157d = LazyKt.lazy(new AnchorV4DetailHeadView$expandableLayoutContainer$2(this));
        this.f168158e = LazyKt.lazy(new AnchorV4DetailHeadView$goodDetailTitle$2(this));
        this.f168159f = LazyKt.lazy(new AnchorV4DetailHeadView$expandableLayout$2(this));
        this.f168160g = LazyKt.lazy(new AnchorV4DetailHeadView$expandableLayoutArea$2(this));
        this.f168161h = LazyKt.lazy(new AnchorV4DetailHeadView$combineDetailContentView$2(this));
        this.f168162i = LazyKt.lazy(new AnchorV4DetailHeadView$combineDetailContentOptView$2(this));
        this.f168165l = LazyKt.lazy(new AnchorV4DetailHeadView$llBannerItems$2(this));
        this.f168169p = new ArrayList();
        this.f168171r = new ArrayList();
        this.f168172s = 154;
        this.f168173t = 22;
        this.f168176w = LazyKt.lazy(new AnchorV4DetailHeadView$updateCombineProductTabJsEventSubscriber$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v65, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v64, types: [T, java.lang.String] */
    public final void d(d r210, String r211, t r212) {
        Intrinsics.checkNotNullParameter(r210, "detailHeadVO");
        Intrinsics.checkNotNullParameter(r212, "anchorV4VM");
        if (this.f168168o == null) goto L5;
        return;
    L5:
        this.f168166m = r211;
        this.f168167n = r212;
        boolean r100 = false;
        if (r212 == null) goto L16;
        CommonMeta r101 = r212.a();
        if (r101 == null) goto L16;
        float r102 = h73.a.f(r101);
        if (Intrinsics.areEqual(r101.getNeedEnlarged(), Boolean.TRUE) == false) goto L16;
        if (this.f168175v == true) goto L16;
        if (r102 <= 0) goto L16;
        this.f168175v = true;
        getViewTreeObserver().addOnGlobalLayoutListener(new k(r102, this));
    L16:
        CommonMeta r103 = r212.a();
        if (r103 == null) goto L19;
        Boolean r104 = Boolean.valueOf(r103.getEnablePDPOptimize());
    L20:
        boolean r105 = com.bytedance.android.shopping.extensions.k.i(r104);
        this.f168174u = r105;
        if (r105 == false) goto L44;
        this.f168163j = (TabLayout) findViewById(R.id.combine_tab_opt);
        this.f168164k = (AutoHeightViewPager) findViewById(R.id.combine_viewpager_opt);
        FrameLayout r106 = getHeaderContainer();
        if (r106 == null) goto L25;
        r106.setPadding(0, vf4.a.b(4), 0, vf4.a.b(8));
    L25:
        RoundedLinearLayout r107 = getExpandableLayoutContainer();
        if (r107 == null) goto L28;
        r107.setRadius(vf4.a.b(12));
    L28:
        TextView r108 = getGoodDetailTitle();
        if (r108 == null) goto L36;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == true) goto L33;
        r109 = null;
    L33:
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r109;
        if (r110 == null) goto L36;
        r110.leftMargin = vf4.a.b(12);
        r110.bottomMargin = vf4.a.b(11);
        r108.setLayoutParams(r110);
    L36:
        View r111 = getExpandableLayoutArea();
        if (r111 == null) goto L67;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == true) goto L41;
        r112 = null;
    L41:
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        if (r113 == null) goto L67;
        r113.bottomMargin = vf4.a.b(16);
        r111.setLayoutParams(r113);
    L67:
        if (this.f168174u == false) goto L80;
        SimpleDraweeView r114 = new SimpleDraweeView(getContext());
        r114.setBackgroundResource(R.drawable.anchor_v4_detail_header_img);
        if (ECAppInfoService.f48114e.f() == false) goto L71;
        FrameLayout.LayoutParams r115 = new FrameLayout.LayoutParams(vf4.a.b(Double.valueOf(((double) this.f168172s) * 1.13d)), vf4.a.b(Double.valueOf(((double) this.f168173t) * 1.13d)));
    L72:
        r115.gravity = 1;
        t r116 = this.f168167n;
        if (r116 == null) goto L79;
        Control r117 = r116.c();
        if (r117 == null) goto L79;
        if (r117.getDetailControl() != true) goto L79;
        getHeaderContainer().setVisibility(0);
        getHeaderContainer().addView(r114, r115);
    L87:
        DetailTagCard r118 = r210.f168223h;
        if (r118 == null) goto L102;
        ECUrlModel r119 = r118.getTagImage();
        if (r119 == null) goto L102;
        float r120 = r119.getWidth() / r119.getHeight();
        SimpleDraweeView r121 = getTagCardView();
        if (r121 == null) goto L94;
        ViewGroup.LayoutParams r122 = getTagCardView().getLayoutParams();
        r122.width = UIUtils.getScreenWidth(r121.getContext()) - vf4.a.b(16);
        r122.height = (int) ((UIUtils.getScreenWidth(r121.getContext()) - vf4.a.b(16)) / r120);
        r121.setLayoutParams(r122);
        y.a(r121, r119);
        r121.setOnClickListener(new j(r121, this, r210));
    L94:
        t r123 = this.f168167n;
        if (r123 == null) goto L97;
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r123, "wuyou_service_info_card_show", null, false, null, null, null, null, 246);
    L97:
        SimpleDraweeView r124 = getTagCardView();
        if (r124 == null) goto L100;
        r124.setVisibility(0);
        Unit r125 = Unit.INSTANCE;
    L101:
        if (r125 == null) goto L102;
    L105:
        boolean r126 = this.f168174u;
        this.f168168o = r210;
        Intrinsics.checkNotNullParameter(r210, "$this$hasProduct");
        if ((!r210.f168218c.isEmpty()) == false) goto L108;
        boolean r127 = true;
    L114:
        View r128 = getExpandableLayoutArea();
        if (r128 == null) goto L120;
        if (r127 == true) goto L118;
        int r129 = 8;
    L119:
        r128.setVisibility(r129);
        goto L120
    L118:
        r129 = 0;
    L120:
        ((ArrayList) this.f168169p).clear();
        if (r127 == false) goto L346;
        DetailCombinePropertiesComponent r130 = r210.f168221f;
        if (r130 == null) goto L128;
        Intrinsics.checkNotNullParameter(r130, "$this$getSkusCount");
        List<DetailCombinePropertiesSkusStruct> r131 = r130.getSkus();
        if (r131 == null) goto L128;
        int r132 = r131.size();
    L129:
        if (r132 <= 0) goto L287;
        if (r126 == false) goto L137;
        View r133 = getCombineDetailContentView();
        if (r133 == null) goto L134;
        r133.setVisibility(8);
    L134:
        View r134 = getCombineDetailContentOptView();
        if (r134 == null) goto L143;
        r134.setVisibility(0);
    L143:
        TabLayout r135 = this.f168163j;
        if (r135 == null) goto L149;
        if (r132 <= 1) goto L147;
        int r136 = 0;
    L148:
        r135.setVisibility(r136);
        goto L149
    L147:
        r136 = 8;
    L149:
        AutoHeightViewPager r137 = this.f168164k;
        if (r137 == null) goto L152;
        r137.setVisibility(0);
    L152:
        ExpandableLinearLayoutV4 r138 = getExpandableLayout();
        if (r138 == null) goto L155;
        r138.setVisibility(8);
    L155:
        t r139 = this.f168167n;
        if (r139 == null) goto L158;
        FragmentManager r140 = r139.h();
    L159:
        ArrayList<AnchorV4DetailSkuVO> r141 = new ArrayList();
        if (r132 < 0) goto L228;
        int r142 = 0;
    L162:
        Intrinsics.checkNotNullParameter(r210, "$this$trans2DetailSkuVO");
        DetailCombinePropertiesComponent r143 = r210.f168221f;
        if (r143 == null) goto L165;
        List<DetailCombinePropertiesSkusStruct> r144 = r143.getSkus();
    L166:
        if (r144 == null) goto L223;
        List<DetailCombinePropertiesSkusStruct> r145 = r210.f168221f.getSkus();
        if (r145 != null) goto L170;
    L173:
        boolean r146 = true;
    L174:
        if (r146 == true) goto L223;
        if (r142 >= r210.f168221f.getSkus().size()) goto L223;
        DetailCombinePropertiesSkusStruct r147 = (DetailCombinePropertiesSkusStruct) ListProtector.get(r210.f168221f.getSkus(), r142);
        List<SkuSubProductsStruct> r148 = r147.getSubProducts();
        String r149 = r147.getId();
        ArrayList r150 = new ArrayList();
        if (r148 == null) goto L191;
        Iterator<T> r151 = r148.iterator();
    L182:
        if (r151.hasNext() == false) goto L191;
        SkuSubProductsStruct r152 = (SkuSubProductsStruct) r151.next();
        String r153 = r152.getProductId();
        if (r153 == null) goto L182;
        HashMap<String, ProductFormatGroup> r154 = r210.f168221f.getProducts();
        if (r154 == null) goto L188;
        ProductFormatGroup r155 = r154.get(r153);
    L189:
        r150.add(new AnchorV4SubProduct(r152.getCombiningNum(), r153, r155));
        goto L182
    L188:
        r155 = null;
    L191:
        DetailCombinePropertiesComponent r156 = r210.f168221f;
        if (r156 == null) goto L194;
        String r157 = r156.getJumpUrl();
    L195:
        String r158 = r147.getName();
        ECUrlModel r159 = r147.getPic();
        DetailCombinePropertiesComponent r160 = r210.f168221f;
        Intrinsics.checkNotNullParameter(r160, "$this$showMoreBottomView");
        List<DetailCombinePropertiesSkusStruct> r161 = r160.getSkus();
        if (r161 == null) goto L221;
        Iterator<T> r162 = r161.iterator();
    L199:
        if (r162.hasNext() == false) goto L221;
        DetailCombinePropertiesSkusStruct r163 = (DetailCombinePropertiesSkusStruct) r162.next();
        List<SkuSubProductsStruct> r164 = r163.getSubProducts();
        if (r164 == null) goto L203;
        int r165 = r164.size();
    L204:
        if (1 < r165) goto L220;
        List<SkuSubProductsStruct> r166 = r163.getSubProducts();
        if (r166 == null) goto L199;
        SkuSubProductsStruct r167 = (SkuSubProductsStruct) ListProtector.get(r166, 0);
        if (r167 == null) goto L199;
        HashMap<String, ProductFormatGroup> r168 = r160.getProducts();
        if (r168 == null) goto L199;
        ProductFormatGroup r169 = r168.get(r167.getProductId());
        if (r169 == null) goto L199;
        List<ProductFormat> r170 = r169.getProductFormat();
        if (r170 == null) goto L217;
        int r171 = r170.size();
    L219:
        if (5 >= r171) goto L199;
    L217:
        r171 = 0;
    L220:
        boolean r172 = true;
    L222:
        AnchorV4DetailSkuVO r173 = new AnchorV4DetailSkuVO(r157, r149, r158, r159, r172, r150);
    L224:
        if (r173 == null) goto L226;
        r141.add(r173);
    L226:
        if (r142 == r132) goto L228;
        r142 = r142 + 1;
        goto L162
    L203:
        r165 = 0;
    L221:
        r172 = false;
        goto L222
    L194:
        r157 = null;
        goto L195
    L170:
        if (r145.isEmpty() == true) goto L173;
        r146 = false;
    L223:
        r173 = null;
        goto L224
    L165:
        r144 = null;
    L228:
        this.f168171r = r141;
        ArrayList r174 = new ArrayList();
        Iterator<AnchorV4DetailSkuVO> r175 = r141.iterator();
        int r176 = 0;
    L230:
        if (r175.hasNext() == false) goto L233;
        AnchorV4DetailSkuVO r177 = r175.next();
        int r178 = AnchorV4DetailSkuPropertiesFragment.f168184o;
        int r179 = r176 + 1;
        DetailSkuPropertiesFragmentParams r180 = new DetailSkuPropertiesFragmentParams(r176, r177, this.f168167n);
        Intrinsics.checkNotNullParameter(r180, "skuparams");
        AnchorV4DetailSkuPropertiesFragment r181 = new AnchorV4DetailSkuPropertiesFragment();
        r181.f168189k = r180;
        r174.add(r181);
        r176 = r179;
        goto L230
    L233:
        if (r141.size() <= 1) goto L237;
        TabLayout r182 = this.f168163j;
        if (r182 == null) goto L237;
        r182.setupWithViewPager(this.f168164k);
    L237:
        if (r140 == null) goto L239;
        AnchorV4DetailCombinePropertyPagerAdapter r183 = new AnchorV4DetailCombinePropertyPagerAdapter(r141, r174, r140);
    L240:
        AutoHeightViewPager r184 = this.f168164k;
        if (r184 == null) goto L243;
        PagerAdapter r185 = r184.getAdapter();
    L244:
        if (r185 != null) goto L246;
    L248:
        AutoHeightViewPager r186 = this.f168164k;
        if (r186 == null) goto L252;
        r186.setAdapter(r183);
    L252:
        if (r141.size() <= 1) goto L286;
        int r187 = r141.size();
        if (r187 < 0) goto L286;
        int r188 = 0;
    L256:
        TabLayout r189 = this.f168163j;
        if (r189 == null) goto L259;
        TabLayout.Tab r190 = r189.getTabAt(r188);
    L260:
        if (r190 == null) goto L284;
        AnchorV4DetailSkuVO r191 = (AnchorV4DetailSkuVO) ListProtector.get(r141, r188);
        if (r191.getPic() != null) goto L276;
        AnchorV4DetailTextTabView r192 = new AnchorV4DetailTextTabView(getContext(), null, 0);
        r192.setText(r191.getName());
        if (r126 == false) goto L266;
        int r193 = R.drawable.ec_commerce_anchor_v4_detail_text_selector_bg_opt;
    L267:
        r192.setBackgroundResource(r193);
        if (r126 == false) goto L270;
        ColorStateList r194 = r192.getResources().getColorStateList(R.color.ec_commerce_anchor_v4_detail_text_selector_color_opt);
    L271:
        r192.setTextColor(r194);
        r192.setTextSize(13.0f);
        if (r126 == false) goto L274;
        int r195 = c0.a(8.0d);
    L275:
        r192.setPadding(r195, 0, r195, 0);
        View r196 = r192;
    L277:
        if (r188 != 0) goto L279;
        r196.setSelected(true);
    L279:
        r190.setCustomView(r196);
        ViewParent r197 = r196.getParent();
        if (r197 == null) goto L283;
        ((ViewGroup) r197).setOnClickListener(new e(this, r141, r190));
        goto L284
    L283:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L274:
        r195 = c0.a(12.0d);
        goto L275
    L270:
        r194 = r192.getResources().getColorStateList(R.color.ec_commerce_anchor_v4_detail_text_selector_color);
        goto L271
    L266:
        r193 = R.drawable.ec_commerce_anchor_v4_detail_text_selector_bg;
        goto L267
    L276:
        AnchorV4DetailIconTextTabView r198 = new AnchorV4DetailIconTextTabView(getContext(), null, 0);
        r198.a(r191.getName(), r191.getPic(), r126);
        r196 = r198;
    L284:
        if (r188 == r187) goto L286;
        r188 = r188 + 1;
        goto L256
    L259:
        r190 = null;
    L286:
        Looper.myQueue().addIdleHandler(new g(this));
        goto L346
    L246:
        if (getParent() != null) goto L248;
        post(new f(this, r183));
        goto L252
    L243:
        r185 = null;
        goto L244
    L239:
        r183 = null;
        goto L240
    L158:
        r140 = null;
        goto L159
    L137:
        View r199 = getCombineDetailContentView();
        if (r199 == null) goto L140;
        r199.setVisibility(0);
    L140:
        View r200 = getCombineDetailContentOptView();
        if (r200 == null) goto L143;
        r200.setVisibility(8);
        goto L143
    L287:
        List<ProductFormatGroup> r1100 = r210.f168218c;
        ExpandableLinearLayoutV4 r201 = getExpandableLayout();
        if (r201 == null) goto L290;
        r201.setVisibility(0);
    L290:
        View r202 = getCombineDetailContentView();
        if (r202 == null) goto L293;
        r202.setVisibility(8);
    L293:
        View r203 = getCombineDetailContentOptView();
        if (r203 == null) goto L296;
        r203.setVisibility(8);
    L296:
        TabLayout r204 = this.f168163j;
        if (r204 == null) goto L299;
        r204.setVisibility(8);
    L299:
        AutoHeightViewPager r205 = this.f168164k;
        if (r205 == null) goto L303;
        r205.setVisibility(8);
    L303:
        if (getExpandableLayout().getChildCount() <= 0) goto L305;
        getExpandableLayout().removeAllViews();
    L305:
        Iterator r1101 = r1100.iterator();
        int r206 = 0;
    L307:
        if (r1101.hasNext() == false) goto L345;
        List<ProductFormat> r207 = ((ProductFormatGroup) r1101.next()).getProductFormat();
        if (r207 == null) goto L343;
        List<ProductFormat> r208 = r207;
        ArrayList r1102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r208, 10));
        Iterator r1103 = r208.iterator();
    L312:
        if (r1103.hasNext() == false) goto L337;
        ProductFormat r209 = (ProductFormat) r1103.next();
        if (r206 <= getExpandableLayout().getMaxItemCount()) goto L316;
        r1101 = r1101;
        r1103 = r1103;
        View r1104 = null;
    L334:
        r1102.add(r1104);
        r1101 = r1101;
        r1103 = r1103;
        r100 = false;
        goto L312
    L316:
        int r1105 = r206 + 1;
        ShoppingAsyncInflater.a r213 = ShoppingAsyncInflater.f45268e;
        Context r214 = getContext();
        r213.getClass();
        View r215 = ShoppingAsyncInflater.a.a(r214).aU(R.layout.ec_commerce_anchor_v4_goods_info_extras_layout_opt, this, r100);
        Ref.ObjectRef r216 = new Ref.ObjectRef();
        String r217 = "";
        r216.element = "";
        ((TextView) r215.findViewById(R.id.tv_title)).setText(r209.getName());
        r216.element = ((String) r216.element) + r209.getName();
        TagFlowLayout r1106 = (TagFlowLayout) r215.findViewById(R.id.tag_layout);
        AnchorV4QualificationNewDesignView r218 = (AnchorV4QualificationNewDesignView) r215.findViewById(R.id.qualification_new_design);
        m r219 = new m(this);
        int r1107 = AnchorV4QualificationNewDesignView.f165480m;
        if (Intrinsics.areEqual(r209.getNewDesign(), Boolean.TRUE) == false) goto L330;
        wg.a.h(r218, true);
        wg.a.h(r1106, false);
        AttrItem r1108 = (AttrItem) CollectionsKt.getOrNull(r209.getMessage(), 0);
        if (r1108 == null) goto L321;
        String r220 = r1108.getDesc();
    L322:
        if (r220 == null) goto L325;
        r217 = r220;
    L325:
        r218.d(r217, r209, this.f168166m, r219);
        r216.element = ((String) r216.element) + r218.getCurrentContentDescription();
        ((ArrayList) this.f168169p).add(r218);
        ViewGroup.LayoutParams r221 = ((TextView) r215.findViewById(R.id.tv_title)).getLayoutParams();
        if (r221 == null) goto L329;
        ((LinearLayout.LayoutParams) r221).gravity = 16;
        Ref.ObjectRef r222 = r216;
        View r1109 = r215;
    L333:
        r1109.setContentDescription((String) r222.element);
        r1104 = r1109;
        r206 = r1105;
        goto L334
    L329:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L321:
        r220 = null;
        goto L322
    L330:
        wg.a.h(r1106, true);
        wg.a.h(r218, false);
        r1109 = r215;
        r1106.setTagAdapter(new l(this, r209, r219, r216, r209.getMessage()));
        ViewGroup.LayoutParams r223 = ((TextView) r1109.findViewById(R.id.tv_title)).getLayoutParams();
        if (r223 == null) goto L336;
        ((LinearLayout.LayoutParams) r223).gravity = 48;
        r222 = r216;
        goto L333
    L336:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L337:
        Iterator r224 = r1101;
        Iterator r225 = r1102.iterator();
    L339:
        if (r225.hasNext() == false) goto L344;
        View r226 = (View) r225.next();
        if (r226 == null) goto L339;
        getExpandableLayout().a(r226);
    L344:
        r1101 = r224;
        r100 = false;
        goto L307
    L343:
        r224 = r1101;
        goto L344
    L345:
        getExpandableLayout().post(new h(this));
        getExpandableLayout().setStateChangeListener(new i(this, r1100));
    L128:
        r132 = 0;
    L346:
        boolean r227 = this.f168174u;
        v63.b r228 = r210.f168220e;
        if (r228 == null) goto L351;
        List<PromotionProductBannerStruct> r229 = r228.a();
        if (r229 == null) goto L351;
        Boolean r1110 = Boolean.valueOf(!r229.isEmpty());
    L353:
        if (Intrinsics.areEqual(r1110, Boolean.FALSE) == false) goto L355;
        getLlBannerItems().setVisibility(8);
        return;
    L355:
        getLlBannerItems().setVisibility(0);
        v63.b r230 = r210.f168220e;
        if (r230 == null) goto L425;
        List<PromotionProductBannerStruct> r231 = r230.a();
        if (r231 == null) goto L426;
        Iterator<T> r232 = r231.iterator();
        int r233 = 0;
    L361:
        if (r232.hasNext() == false) goto L427;
        Object r234 = r232.next();
        int r235 = r233 + 1;
        if (r233 >= 0) goto L365;
        CollectionsKt.throwIndexOverflow();
    L365:
        final PromotionProductBannerStruct r1111 = (PromotionProductBannerStruct) r234;
        if (r1111 != null) goto L368;
        ViewGroup.LayoutParams r236 = null;
        View r1112 = null;
    L376:
        getLlBannerItems().addView(r1112);
        if (r1112 == null) goto L388;
        ViewGroup.LayoutParams r237 = r1112.getLayoutParams();
        if ((r237 instanceof ViewGroup.MarginLayoutParams) == true) goto L381;
        r237 = r236;
    L381:
        ViewGroup.MarginLayoutParams r238 = (ViewGroup.MarginLayoutParams) r237;
        if (r238 == null) goto L388;
        if (r233 != 0) goto L386;
        r238.topMargin = vf4.a.b(4);
    L386:
        r238.bottomMargin = vf4.a.b(8);
        r1112.setLayoutParams(r238);
    L388:
        r233 = r235;
        goto L361
    L368:
        r236 = null;
        AnchorV3CommonBannerView r239 = new AnchorV3CommonBannerView(getContext(), null, 6, 0);
        AnchorV4DetailHeadView$generateBannerView$onClick$1 r240 = AnchorV4DetailHeadView$generateBannerView$onClick$1.INSTANCE;
        Integer r1113 = r1111.getBannerType();
        if (r1113 != null) goto L372;
    L374:
        Function1<String, Unit> r1114 = r240;
    L375:
        AnchorV3CommonBannerView.b(r239, r1111, r1114, false, 0, r227, 24);
        r1112 = r239;
        goto L376
    L372:
        if (r1113.intValue() != 32) goto L374;
        this.f168170q = r239;
        final String r241 = com.bytedance.android.shopping.extensions.j.c(R.string.anchor_v3_dcar_report);
        r1114 = new AnchorV4DetailHeadView$generateBannerView$1(this, r1111, r241);
        goto L375
    L427:
        return;
    L426:
        return;
    L425:
        return;
    L351:
        r1110 = null;
        goto L353
    L108:
        DetailCombinePropertiesComponent r242 = r210.f168221f;
        if (r242 == null) goto L113;
        List<DetailCombinePropertiesSkusStruct> r243 = r242.getSkus();
        if (r243 == null) goto L113;
        r127 = !r243.isEmpty();
    L113:
        r127 = false;
        goto L114
    L100:
        r125 = null;
    L102:
        SimpleDraweeView r244 = getTagCardView();
        if (r244 == null) goto L105;
        r244.setVisibility(8);
        Unit r245 = Unit.INSTANCE;
    L79:
        getHeaderContainer().setVisibility(8);
        goto L87
    L71:
        r115 = new FrameLayout.LayoutParams(vf4.a.b(Integer.valueOf(this.f168172s)), vf4.a.b(Integer.valueOf(this.f168173t)));
        goto L72
    L80:
        ECUrlModel r246 = r210.f168217b;
        if (r246 == null) goto L87;
        SimpleDraweeView r247 = new SimpleDraweeView(getContext());
        y.a(r247, r246);
        if (ECAppInfoService.f48114e.f() == false) goto L85;
        FrameLayout.LayoutParams r248 = new FrameLayout.LayoutParams(vf4.a.b(Double.valueOf(((double) r246.getWidth()) * 1.13d)), vf4.a.b(Double.valueOf(((double) r246.getHeight()) * 1.13d)));
    L86:
        r248.gravity = 1;
        getHeaderContainer().addView(r247, r248);
        goto L87
    L85:
        r248 = new FrameLayout.LayoutParams(vf4.a.b(Integer.valueOf(r246.getWidth())), vf4.a.b(Integer.valueOf(r246.getHeight())));
        goto L86
    L44:
        this.f168163j = (TabLayout) findViewById(R.id.combine_tab);
        this.f168164k = (AutoHeightViewPager) findViewById(R.id.combine_viewpager);
        FrameLayout r249 = getHeaderContainer();
        if (r249 == null) goto L47;
        r249.setPadding(0, vf4.a.b(8), 0, vf4.a.b(8));
    L47:
        RoundedLinearLayout r250 = getExpandableLayoutContainer();
        if (r250 == null) goto L50;
        r250.setRadius(vf4.a.b(8));
    L50:
        TextView r251 = getGoodDetailTitle();
        if (r251 == null) goto L58;
        ViewGroup.LayoutParams r252 = r251.getLayoutParams();
        if ((r252 instanceof ViewGroup.MarginLayoutParams) == true) goto L55;
        r252 = null;
    L55:
        ViewGroup.MarginLayoutParams r253 = (ViewGroup.MarginLayoutParams) r252;
        if (r253 == null) goto L58;
        r253.leftMargin = vf4.a.b(16);
        r253.bottomMargin = vf4.a.b(6);
        r251.setLayoutParams(r253);
    L58:
        View r254 = getExpandableLayoutArea();
        if (r254 == null) goto L67;
        ViewGroup.LayoutParams r255 = r254.getLayoutParams();
        if ((r255 instanceof ViewGroup.MarginLayoutParams) == true) goto L63;
        r255 = null;
    L63:
        ViewGroup.MarginLayoutParams r256 = (ViewGroup.MarginLayoutParams) r255;
        if (r256 == null) goto L67;
        r256.bottomMargin = vf4.a.b(12);
        r254.setLayoutParams(r256);
        goto L67
    L19:
        r104 = null;
        goto L20
    }

    public /* synthetic */ AnchorV4DetailHeadView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
