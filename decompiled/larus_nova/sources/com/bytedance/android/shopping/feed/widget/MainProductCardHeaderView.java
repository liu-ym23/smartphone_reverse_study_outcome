package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.widget.RoundedLinearLayout;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.CouponUrgeInfo;
import com.bytedance.android.ec.model.response.anchorv3.InnerFlowCouponExtra;
import com.bytedance.android.ec.model.response.anchorv3.PromotionLampStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCouponsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.opt.asyncInflate.ICachedAsyncInflater;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.ui.base.widget.viewflipper.ECViewFlipper;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\"\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/MainProductCardHeaderView;", "Lcom/bytedance/android/shopping/feed/widget/BaseCardHeaderView;", "Lcom/bytedance/android/ec/opt/asyncInflate/ICachedAsyncInflater$a;", "", "getLayoutResId", "", "visible", "", "setProductAttentionVisible", "", "factor", "setInfoViewTransitionAlpha", "s", "Z", "getNeedShowProductAttention", "()Z", "setNeedShowProductAttention", "(Z)V", "needShowProductAttention", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MainProductCardHeaderView extends BaseCardHeaderView implements ICachedAsyncInflater.a {
    public final int A;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final FrameLayout f175931n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<PromotionLampStruct> f175932o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f175933p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final View f175934q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final View f175935r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f175936s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RoundedLinearLayout f175937t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TextView f175938u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f175939v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final View f175940w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ECViewFlipper f175941x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ViewGroup f175942y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public n83.j f175943z;

    public MainProductCardHeaderView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MainProductCardHeaderView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.widget.BaseCardHeaderView
    public int getLayoutResId() {
        return R.layout.shopping_product_feed_main_product_header;
    }

    @Override // com.bytedance.android.ec.opt.asyncInflate.ICachedAsyncInflater.a
    public final void recycle() {
        this.f175933p = true;
    }

    @Override // com.bytedance.android.shopping.feed.widget.BaseCardHeaderView
    public final void c() {
        FeedProductEventTracker r100 = FeedProductEventTracker.f174442a;
        Context r101 = getContext();
        r100.getClass();
        FeedProductEventTracker.A(r101, "click_inflow_similar_tab", false, "product_image");
    }

    public final void d() {
        int r100 = ld3.c.f508687a;
        if (this.A == 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L22;
        ECViewFlipper r102 = this.f175941x;
        if (r102 == null) goto L10;
        r102.stopFlipping();
    L10:
        ECViewFlipper r103 = this.f175941x;
        if (r103 == null) goto L13;
        r103.setVisibility(8);
    L13:
        View r104 = this.f175940w;
        if (r104 == null) goto L16;
        r104.setVisibility(8);
    L16:
        RoundedLinearLayout r105 = this.f175937t;
        if (r105 == null) goto L23;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L24;
        r106.width = -2;
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final boolean getNeedShowProductAttention() {
        return this.f175936s;
    }

    public final void setInfoViewTransitionAlpha(float r100) {
        if (r100 < 0) goto L16;
        float r101 = 1;
        if (r100 > r101) goto L19;
        float r102 = r101 - r100;
        this.f175931n.setAlpha(r102);
        this.f175942y.setAlpha(r102);
        if (this.f175936s == true) goto L17;
        View r103 = this.f175934q;
        if (r103 == null) goto L12;
        r103.setAlpha(r102);
    L12:
        RoundedLinearLayout r104 = this.f175937t;
        if (r104 == null) goto L18;
        r104.setAlpha(r102);
        return;
    L18:
        return;
    L17:
        return;
    L19:
        return;
    }

    public final void setNeedShowProductAttention(boolean r100) {
        this.f175936s = r100;
    }

    public final void setProductAttentionVisible(boolean r100) {
        this.f175936s = r100;
        if (r100 == false) goto L6;
        this.f175931n.setVisibility(8);
        return;
    }

    @Override // com.bytedance.android.shopping.feed.widget.BaseCardHeaderView
    public final void a(v r110, final Function3<? super View, ? super String, ? super String, Unit> r111) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "detailOnClickListener");
        super.a(r110, r111);
        AnchorV3Param r100 = null;
        if (this.f175933p == false) goto L5;
    L17:
        rd3.a r101 = r110.f176077b;
        if (r101 == null) goto L29;
        Promotion r102 = r101.f();
        if (r102 == null) goto L29;
        PromotionProductStruct r103 = r102.getPromotionInfo();
        if (r103 == null) goto L29;
        if (r103.isApiBack() == true) goto L29;
        RoundedLinearLayout r112 = this.f175937t;
        if (r112 == null) goto L266;
        r112.setVisibility(8);
        return;
    L266:
        return;
    L29:
        this.f175933p = false;
        rd3.a r104 = r110.f176077b;
        if (r104 == null) goto L41;
        Promotion r105 = r104.f();
        if (r105 == null) goto L41;
        PromotionProductStruct r106 = r105.getPromotionInfo();
        if (r106 == null) goto L41;
        PromotionProductExtraStruct r107 = r106.getExtraInfo();
        if (r107 == null) goto L41;
        List<PromotionLampStruct> r108 = r107.getLamps();
        if (r108 == null) goto L41;
        if (r108.isEmpty() != true) goto L41;
    L47:
        this.f175931n.setVisibility(8);
    L76:
        ProductFeedViewModel r113 = getViewModel();
        if (r113 == null) goto L88;
        AnchorV3Param r114 = r113.m8290getAnchorV3Param();
        if (r114 == null) goto L88;
        if (r114.isFullScreen() != true) goto L88;
        View r115 = this.f175934q;
        if (r115 == null) goto L85;
        r115.setVisibility(8);
    L85:
        RoundedLinearLayout r116 = this.f175937t;
        if (r116 == null) goto L153;
        r116.setVisibility(8);
    L153:
        ProductFeedViewModel r117 = getViewModel();
        if (r117 == null) goto L193;
        rd3.a r109 = r110.f176077b;
        if (r109 == null) goto L160;
        Promotion r118 = r109.f();
        if (r118 == null) goto L160;
        PromotionProductStruct r119 = r118.getPromotionInfo();
    L161:
        Intrinsics.checkNotNullParameter(r117, "viewModel");
        InnerFlowPageStyleDTO r120 = r117.getInnerFlowPageStyle();
        if (r120 == null) goto L166;
        PageStyle r121 = r120.getPageStyle();
        if (r121 == null) goto L166;
        Integer r122 = r121.getSameProductSwitch();
    L167:
        if (r122 != null) goto L170;
    L171:
        if (r122 != null) goto L174;
    L176:
        this.f175935r.setVisibility(8);
        goto L193
    L174:
        if (r122.intValue() != 3) goto L176;
    L177:
        this.f175935r.setVisibility(0);
        HashSet<String> r123 = r117.getShowedSimilarEntranceProductId();
        if (r119 == null) goto L182;
        PromotionProductBaseStruct r124 = r119.getBaseInfo();
        if (r124 == null) goto L182;
        String r125 = r124.getProductId();
    L184:
        if (CollectionsKt.contains(r123, r125) == true) goto L192;
        if (r119 == null) goto L191;
        PromotionProductBaseStruct r126 = r119.getBaseInfo();
        if (r126 == null) goto L191;
        String r127 = r126.getProductId();
        if (r127 == null) goto L191;
        r117.getShowedSimilarEntranceProductId().add(r127);
    L191:
        FeedProductEventTracker r128 = FeedProductEventTracker.f174442a;
        Context r129 = getContext();
        r128.getClass();
        FeedProductEventTracker.A(r129, "show_inflow_similar_tab", false, null);
    L192:
        this.f175935r.setOnClickListener(new q(this, r117, r119));
    L182:
        r125 = null;
        goto L184
    L170:
        if (r122.intValue() == 1) goto L177;
    L166:
        r122 = null;
    L160:
        r119 = null;
    L193:
        int r130 = ECSdk.f48106a;
        IEShoppingService r131 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r131 != null) goto L196;
    L244:
        ProductFeedViewModel r132 = getViewModel();
        if (r132 == null) goto L264;
        InnerFlowPageStyleDTO r133 = r132.getInnerFlowPageStyle();
        if (r133 == null) goto L264;
        PageStyle r134 = r133.getPageStyle();
        if (r134 == null) goto L264;
        if (r134.getSearchPdtSwitch() != 1) goto L264;
        ProductFeedViewModel r135 = getViewModel();
        if (r135 == null) goto L264;
        InnerFlowPageStyleDTO r136 = r135.getInnerFlowPageStyle();
        if (r136 == null) goto L264;
        PageStyle r137 = r136.getPageStyle();
        if (r137 == null) goto L264;
        if (r137.getSearchPdtStyle() != 2) goto L264;
        ProductFeedViewModel r138 = getViewModel();
        if (r138 == null) goto L263;
        rd3.a r139 = r110.f176077b;
        Intrinsics.checkNotNullParameter(r138, "viewModel");
        super.b(r138, r139);
        FeedProductEventTracker r140 = FeedProductEventTracker.f174442a;
        Context r141 = getContext();
        r140.getClass();
        FeedProductEventTracker.A(r141, "show_inflow_similar_tab", false, "product_image");
        getNewSameProductEntranceView().setVisibility(0);
        return;
    L263:
        getNewSameProductEntranceView().setVisibility(8);
        return;
    L264:
        getNewSameProductEntranceView().setVisibility(8);
        return;
    L196:
        if (r131.shouldShowSaasCouponUrge() != true) goto L244;
        ProductFeedViewModel r142 = getViewModel();
        if (r142 == null) goto L203;
        AnchorV3Param r143 = r142.m8290getAnchorV3Param();
        if (r143 == null) goto L203;
        if (r143.isFullScreen() == true) goto L244;
    L203:
        rd3.a r144 = r110.f176077b;
        if (r144 == null) goto L212;
        Promotion r145 = r144.f();
        if (r145 == null) goto L212;
        PromotionProductStruct r146 = r145.getPromotionInfo();
        if (r146 == null) goto L212;
        PromotionProductPrivilegesStruct r147 = r146.getPrivilegeInfo();
        if (r147 == null) goto L212;
        PromotionProductCouponsStruct r148 = r147.getCoupons();
    L213:
        Context r149 = getContext();
        if (r148 == null) goto L218;
        InnerFlowCouponExtra r150 = r148.getInnerFlowCouponExtra();
        if (r150 == null) goto L218;
        CouponUrgeInfo r151 = r150.getCouponUrgeInfo();
    L219:
        if (r151 == null) goto L243;
        this.f175942y.setVisibility(0);
        if (this.f175943z != null) goto L229;
        IEShoppingService r152 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r152 == null) goto L225;
        n83.j r153 = r152.newCouponUrgeView(r149, 1);
    L226:
        this.f175943z = r153;
        if (r153 == null) goto L229;
        this.f175942y.addView(r153.i(), new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(26)));
        goto L229
    L225:
        r153 = null;
    L229:
        n83.j r154 = this.f175943z;
        if (r154 == null) goto L236;
        ProductFeedViewModel r155 = getViewModel();
        if (r155 == null) goto L234;
        r100 = r155.m8290getAnchorV3Param();
    L234:
        r154.a(r148, r100);
    L236:
        if (this.f175931n.getVisibility() != 0) goto L238;
        boolean r156 = true;
    L239:
        if (r156 == false) goto L244;
        this.f175931n.setVisibility(8);
        n83.j r157 = this.f175943z;
        if (r157 == null) goto L244;
        r157.setCountDownFinishCallback(new MainProductCardHeaderView$bindCouponUrge$2(this));
        goto L244
    L238:
        r156 = false;
        goto L239
    L243:
        this.f175942y.setVisibility(8);
    L218:
        r151 = null;
    L212:
        r148 = null;
    L88:
        int r158 = ld3.c.f508687a;
        if (this.A == 0) goto L91;
        boolean r159 = true;
    L92:
        if (r159 == false) goto L147;
        RoundedLinearLayout r160 = this.f175937t;
        if (r160 == null) goto L96;
        r160.setVisibility(0);
    L96:
        View r161 = this.f175934q;
        if (r161 == null) goto L100;
        r161.setVisibility(8);
    L100:
        if (this.A == 2) goto L136;
        rd3.a r162 = r110.f176077b;
        if (r162 == null) goto L110;
        Promotion r163 = r162.f();
        if (r163 == null) goto L110;
        PromotionProductStruct r164 = r163.getPromotionInfo();
        if (r164 == null) goto L110;
        PromotionProductExtraStruct r165 = r164.getExtraInfo();
        if (r165 == null) goto L110;
        List<PromotionLampStruct> r166 = r165.getLamps();
    L111:
        List<PromotionLampStruct> r167 = r166;
        if (r167 != null) goto L114;
    L117:
        boolean r168 = true;
    L118:
        if (r168 == true) goto L136;
        if (this.f175936s == true) goto L136;
        View r169 = this.f175940w;
        if (r169 == null) goto L125;
        r169.setVisibility(0);
    L125:
        ECViewFlipper r170 = this.f175941x;
        if (r170 == null) goto L128;
        r170.setVisibility(0);
    L128:
        int r171 = (UIUtils.getScreenWidth(getContext()) - com.bytedance.android.shopping.extensions.b.b(48)) - com.bytedance.android.shopping.extensions.b.b(92);
        RoundedLinearLayout r172 = this.f175937t;
        if (r172 == null) goto L133;
        ViewGroup.LayoutParams r173 = r172.getLayoutParams();
        if (r173 == null) goto L133;
        r173.width = Math.min(r171, com.bytedance.android.shopping.extensions.b.b(234));
    L133:
        this.f175939v = 12;
        TextView r174 = this.f175938u;
        if (r174 == null) goto L153;
        r174.setTextSize(1, 12);
        goto L153
    L114:
        if (r167.isEmpty() == true) goto L117;
        r168 = false;
    L110:
        r166 = null;
    L136:
        View r175 = this.f175940w;
        if (r175 == null) goto L139;
        r175.setVisibility(8);
    L139:
        ECViewFlipper r176 = this.f175941x;
        if (r176 == null) goto L142;
        r176.setVisibility(8);
    L142:
        RoundedLinearLayout r177 = this.f175937t;
        if (r177 == null) goto L153;
        ViewGroup.LayoutParams r178 = r177.getLayoutParams();
        if (r178 == null) goto L153;
        r178.width = -2;
        goto L153
    L147:
        View r179 = this.f175934q;
        if (r179 == null) goto L150;
        r179.setVisibility(0);
    L150:
        RoundedLinearLayout r180 = this.f175937t;
        if (r180 == null) goto L153;
        r180.setVisibility(8);
        goto L153
    L91:
        r159 = false;
    L41:
        ProductFeedViewModel r181 = getViewModel();
        if (r181 == null) goto L48;
        AnchorV3Param r182 = r181.m8290getAnchorV3Param();
        if (r182 == null) goto L48;
        if (r182.isFullScreen() == true) goto L47;
    L48:
        int r183 = ld3.c.f508687a;
        rd3.a r184 = r110.f176077b;
        if (r184 == null) goto L53;
        Promotion r185 = r184.f();
        if (r185 == null) goto L53;
        final PromotionProductStruct r186 = r185.getPromotionInfo();
    L54:
        if (r186 == null) goto L58;
        PromotionProductExtraStruct r187 = r186.getExtraInfo();
        if (r187 == null) goto L58;
        List<PromotionLampStruct> r188 = r187.getLamps();
    L59:
        this.f175932o = r188;
        if (this.A == 0) goto L62;
        boolean r189 = true;
    L63:
        if (r189 == false) goto L65;
        ECViewFlipper r190 = this.f175941x;
    L66:
        if (r190 == null) goto L68;
        r190.scrollToPosition(0);
    L68:
        if (r190 == null) goto L70;
        r190.setInterval(3000);
    L70:
        if (r190 == null) goto L74;
        RecyclerView.Adapter r191 = r190.getAdapter();
        if (r191 == null) goto L74;
        r191.notifyDataSetChanged();
    L74:
        if (r190 == null) goto L76;
        r190.setOnClickListener(new MainProductCardHeaderView$bindLampViewNew$1(this, r186, r111));
        goto L76
    L65:
        r190 = null;
        goto L66
    L62:
        r189 = false;
    L58:
        r188 = null;
    L53:
        r186 = null;
        goto L54
    L5:
        if (this.f175932o != null) goto L76;
        rd3.a r192 = r110.f176077b;
        if (r192 == null) goto L15;
        Promotion r193 = r192.f();
        if (r193 == null) goto L15;
        PromotionProductStruct r194 = r193.getPromotionInfo();
        if (r194 == null) goto L15;
        PromotionProductExtraStruct r195 = r194.getExtraInfo();
        if (r195 == null) goto L15;
        List<PromotionLampStruct> r196 = r195.getLamps();
    L16:
        if (r196 == null) goto L76;
    L15:
        r196 = null;
        goto L16
    }

    public MainProductCardHeaderView(final Context r100, final AttributeSet r101, final int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        FrameLayout r103 = (FrameLayout) findViewById(R.id.view_flipper_container);
        this.f175931n = r103;
        this.f175933p = true;
        this.f175934q = findViewById(R.id.product_attention_tv);
        this.f175935r = findViewById(R.id.main_product_card_same_product_entrance);
        this.f175939v = 13;
        this.f175942y = (ViewGroup) findViewById(R.id.coupon_urge_container);
        RoundedLinearLayout r104 = (RoundedLinearLayout) findViewById(R.id.new_style_product_attention_ll);
        this.f175937t = r104;
        if (r104 == null) goto L5;
        r104.setRadius(com.bytedance.android.shopping.extensions.b.b(13));
    L5:
        this.f175940w = findViewById(R.id.new_style_divider);
        this.f175938u = (TextView) findViewById(R.id.new_product_attention_tv);
        ECViewFlipper r105 = (ECViewFlipper) findViewById(R.id.new_style_view_fliper);
        this.f175941x = r105;
        int r106 = ld3.c.f508687a;
        if (r105 == null) goto L8;
        r105.setInfinity(false);
        r105.setNeedKeepLastView(false);
        r105.setEndCallback(new MainProductCardHeaderView$initNewStyleFlipper$$inlined$apply$lambda$1(this));
    L8:
        if (r105 == null) goto L10;
        r105.setViewFlipperAdapter(new MainProductCardHeaderView$initNewStyleFlipper$2(this, r100, r101, r102));
    L10:
        r103.setVisibility(8);
        this.A = 1;
    }

    public /* synthetic */ MainProductCardHeaderView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
