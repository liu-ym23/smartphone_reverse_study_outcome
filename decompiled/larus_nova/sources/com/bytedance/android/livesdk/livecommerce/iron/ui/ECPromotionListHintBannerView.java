package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.ExplainingPromotionBar;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import sg2.v;
import xi2.m0;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\t\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002J\b\u0010\r\u001a\u0004\u0018\u00010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/ECPromotionListHintBannerView;", "Landroid/widget/FrameLayout;", "", "roomId", "", "setRoomId", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/business/PromotionListController;", "listController", "setPromotionListController", "getCurrentPromotionId", "promotionId", "setPreviousPromotionId", "Landroid/view/View;", "getCartAddMotionDestination", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionListHintBannerView extends FrameLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f148900k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f148901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECPromotionList.p f148902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RelativeLayout f148903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExplainingPromotionBar f148904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ECDraweeView f148905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ECCustomizedElementView f148906f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ECCustomizedElementView f148907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ECDraweeView f148908h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PromotionListController f148909i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f148910j;

    public static final class a {
    }

    static {
    }

    public ECPromotionListHintBannerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECPromotionListHintBannerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void d() {
        this.f148906f.e();
        this.f148907g.e();
        this.f148903c.setVisibility(8);
    }

    public final String getCurrentPromotionId() {
        ExplainingPromotionBar r100 = this.f148904d;
        if (r100.getVisibility() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        r100 = null;
    L9:
        if (r100 == null) goto L12;
        String r102 = r100.getCurrentPromotionId();
        if (r102 == null) goto L12;
        return r102;
    L12:
        return "";
    L5:
        r101 = false;
        goto L6
    }

    public final boolean e() {
        if (getVisibility() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        return false;
    L8:
        if (this.f148904d.getVisibility() != 0) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == false) goto L13;
    L17:
        return true;
    L13:
        if (this.f148903c.getVisibility() != 0) goto L15;
        boolean r102 = true;
    L16:
        if (r102 == true) goto L17;
        return false;
    L15:
        r102 = false;
        goto L16
    L10:
        r101 = false;
        goto L11
    L5:
        r100 = false;
        goto L6
    }

    public final View getCartAddMotionDestination() {
        Object r100 = null;
        if (e() == true) goto L5;
        return null;
    L5:
        Iterator<T> r101 = com.bytedance.commerce.base.view.b.a(this.f148906f).iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((View) r102).getTag(), "cart_add_destination") == false) goto L7;
    L12:
        View r103 = (View) r102;
        if (r103 != null) goto L28;
        Iterator<T> r104 = com.bytedance.commerce.base.view.b.a(this.f148907g).iterator();
    L16:
        if (r104.hasNext() == false) goto L21;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((View) r105).getTag(), "cart_add_destination") == false) goto L16;
        r100 = r105;
    L21:
        return (View) r100;
    L28:
        return r103;
    L11:
        r102 = null;
        goto L12
    }

    public final void f(int r100) {
        ECPromotionList.p r101 = this.f148902b;
        if (r101 == null) goto L8;
        List<com.bytedance.android.ec.model.live.b> r102 = r101.leftContent;
        if (r102 == null) goto L9;
        ControllerExtensionsKt.b(this.f148909i, this.f148901a).getClass();
        this.f148906f.b(r102, true);
        return;
    L9:
        return;
    }

    public final void h(int r100) {
        ViewGroup.LayoutParams r101 = this.f148906f.getLayoutParams();
        if (r101 == null) goto L7;
        RelativeLayout.LayoutParams r102 = (RelativeLayout.LayoutParams) r101;
        r102.setMargins(r102.leftMargin, r102.topMargin, r100, r102.bottomMargin);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    public final void setPreviousPromotionId(String r100) {
        this.f148904d.setPreviousPromotionId(r100);
    }

    public final void setPromotionListController(PromotionListController r100) {
        this.f148909i = r100;
    }

    public final void setRoomId(String r100) {
        this.f148901a = r100;
    }

    public final void g(int r100, int r101) {
        wg.a.f(this.f148903c, 0, r100, 0, r101);
        wg.a.f(this.f148904d, 0, r100, 0, r101);
    }

    public ECPromotionListHintBannerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f148910j = UtilityKotlinExtentionsKt.d(Float.valueOf(26.0f));
        th.a.c(r100, R.layout.shopping_layout_iron_promotion_list_hint_banner_view, this, true);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.f148903c = (RelativeLayout) findViewById(R.id.rl_customized_container);
        this.f148904d = (ExplainingPromotionBar) findViewById(R.id.epb_explaining_bar);
        this.f148905e = (ECDraweeView) findViewById(R.id.dv_background);
        ECCustomizedElementView r103 = (ECCustomizedElementView) findViewById(R.id.cev_left_content);
        this.f148906f = r103;
        ECCustomizedElementView r104 = (ECCustomizedElementView) findViewById(R.id.cev_right_content);
        this.f148907g = r104;
        this.f148908h = (ECDraweeView) findViewById(R.id.view_icon);
        r103.setCountDownEndCallback(new AnonymousClass1(this));
        r104.setCountDownEndCallback(new AnonymousClass2(this));
    }

    public /* synthetic */ ECPromotionListHintBannerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        boolean r105 = true;
        if (this.f148903c.getVisibility() != 0) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == false) goto L21;
        ECPromotionList.p r107 = this.f148902b;
        if (r107 == null) goto L12;
        if (r107.bannerType != 5) goto L12;
        return;
    L12:
        if ((this.f148907g.getLeft() - this.f148906f.getRight()) >= this.f148910j) goto L15;
        ECCustomizedElementView r108 = this.f148907g;
        r108.layout(r108.getLeft(), 0, this.f148907g.getLeft(), 0);
        return;
    L15:
        if (this.f148908h.getVisibility() == 0) goto L18;
        r105 = false;
    L18:
        if (r105 == false) goto L24;
        ECDraweeView r109 = this.f148908h;
        r109.layout(r109.getLeft(), 0, this.f148908h.getLeft(), 0);
        return;
    L24:
        return;
    L21:
        return;
    L5:
        r106 = false;
        goto L6
    }

    public static /* synthetic */ void c(ECPromotionListHintBannerView r100, ECPromotionList.p r101, JSONObject r102, boolean r110, int r111, gi2.a r112) {
        r100.e();
        r100.b(r101, r102, false, r110, r111, r112);
    }

    public final void b(final ECPromotionList.p r110, JSONObject r111, final boolean r112, boolean r113, int r114, gi2.a r210) {
        if (ECLiveABUtils.INSTANCE.getECOM_LIVE_PROMOTION_LIST_HINT_HAR_OPT_CONFIG().a() != 2) goto L6;
        if (r113 == true) goto L6;
        return;
    L6:
        if (r110 != null) goto L8;
    L13:
        boolean r100 = true;
        if ((!Intrinsics.areEqual(this.f148902b, r110)) == true) goto L16;
        if (r112 == true) goto L16;
        return;
    L16:
        this.f148902b = r110;
        boolean r101 = false;
        if (this.f148904d.getVisibility() != 0) goto L19;
        boolean r102 = true;
    L20:
        if (r102 == false) goto L28;
        if (r110 != null) goto L23;
        return;
    L23:
        if (r110.priority <= 40) goto L25;
        r101 = true;
    L25:
        if (r101 != true) goto L104;
        this.f148904d.b();
        return;
    L104:
        return;
    L28:
        if (r110 != null) goto L31;
        d();
        return;
    L31:
        this.f148903c.setVisibility(0);
        Map<String, String> r103 = null;
        if (r110.bannerType != 7) goto L52;
        setVisibility(0);
        ECPromotionList.p r104 = this.f148902b;
        int r105 = -1;
        if (r104 == null) goto L51;
        List<com.bytedance.android.ec.model.live.b> r106 = r104.leftContent;
        if (r106 == null) goto L51;
        Iterator<T> r107 = r106.iterator();
        int r108 = 0;
    L39:
        if (r107.hasNext() == false) goto L51;
        Object r115 = r107.next();
        int r116 = r108 + 1;
        if (r108 >= 0) goto L43;
        CollectionsKt.throwIndexOverflow();
    L43:
        com.bytedance.android.ec.model.live.b r117 = (com.bytedance.android.ec.model.live.b) r115;
        if (r117.o() != 2) goto L50;
        String r118 = r117.s();
        if (r118 == null) goto L50;
        if (StringsKt.contains$default(r118, "#{left_time}", false, 2, null) != true) goto L50;
        r117.s();
        r105 = r108;
    L50:
        r108 = r116;
    L51:
        ControllerExtensionsKt.b(this.f148909i, this.f148901a).getClass();
        f(r105);
    L56:
        this.f148905e.setCornerRadius(UtilityKotlinExtentionsKt.c(8));
        y.d(this.f148905e, r110.bgImageUrl);
        List<com.bytedance.android.ec.model.live.b> r109 = r110.rightContent;
        if (r109 == null) goto L78;
        this.f148907g.setVisibility(0);
        this.f148907g.b(r109, r112);
        if (r110.bannerType != 4) goto L61;
        com.bytedance.android.ec.core.widget.f.c(this.f148907g, null, null, new ECPromotionListHintBannerView$bindListBannerInfo$$inlined$also$lambda$1(this, r112, r110), 3);
        com.bytedance.android.ec.core.widget.f.c(this.f148908h, null, null, new ECPromotionListHintBannerView$bindListBannerInfo$$inlined$also$lambda$2(this, r112, r110), 3);
    L62:
        com.bytedance.android.ec.model.live.b r119 = (com.bytedance.android.ec.model.live.b) CollectionsKt.lastOrNull(r109);
        if (r119 != null) goto L65;
    L77:
        this.f148908h.setVisibility(8);
        h(UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f)));
        Unit r120 = Unit.INSTANCE;
    L80:
        if (a2.b(r110.jumpUrl) == false) goto L82;
        setOnClickListener(new g(this, r110, r111, r210, r114));
    L84:
        if (r110.f149500a == true) goto L106;
        StringBuilder r121 = new StringBuilder("livesdk_show_");
        m0 r122 = r110.trackInfo;
        if (r122 == null) goto L88;
        String r123 = r122.b();
    L89:
        r121.append(r123);
        String r124 = r121.toString();
        oh.a.c(r124, new h(this, r124, r110, r111));
        com.bytedance.android.btm.api.model.d r125 = BtmUtilsKt.e("a1.b0715.c298306.d93817", PageFinder.via(this));
        if (r210 == null) goto L92;
        com.bytedance.android.ec.common.api.jump.model.a r126 = r210;
    L93:
        v r127 = new v("livesdk_common_banner_show", r126);
        m0 r128 = r110.trackInfo;
        if (r128 == null) goto L96;
        r103 = r128.c();
    L96:
        r127.d(r103);
        r127.a("banner_type", r110.bannerType);
        r127.i(r125.f42022a);
        return;
    L92:
        r126 = com.bytedance.android.ec.common.api.jump.model.b.f42853a;
        goto L93
    L88:
        r123 = null;
        goto L89
    L106:
        return;
    L82:
        setOnClickListener(null);
        goto L84
    L65:
        if (r119.o() == 4) goto L68;
        r100 = false;
    L68:
        if (r100 == true) goto L71;
        r119 = null;
    L71:
        if (r119 == null) goto L77;
        this.f148908h.setVisibility(0);
        y.a(this.f148908h, r119.q());
        ECUrlModel r129 = r119.q();
        if (r129 == null) goto L75;
        int r130 = r129.getWidth();
    L76:
        h(UtilityKotlinExtentionsKt.d(Integer.valueOf(r130 + 30)));
        goto L80
    L75:
        r130 = 16;
        goto L76
    L61:
        this.f148907g.setClickable(false);
        this.f148908h.setClickable(false);
        goto L62
    L78:
        this.f148907g.setVisibility(8);
        this.f148908h.setVisibility(8);
        h(UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f)));
        goto L80
    L52:
        ControllerExtensionsKt.b(this.f148909i, this.f148901a).getClass();
        List<com.bytedance.android.ec.model.live.b> r131 = r110.leftContent;
        if (r131 == null) goto L55;
        this.f148906f.setVisibility(0);
        this.f148906f.b(r131, r112);
        goto L56
    L55:
        this.f148906f.setVisibility(8);
        goto L56
    L19:
        r102 = false;
        goto L20
    L8:
        if (r110.bannerType != 14) goto L13;
        if (e() == false) goto L13;
        if (r112 == true) goto L13;
    }

    public final void a(ql.a r110, final JSONObject r111, final boolean r112, final int r113, final gi2.a r114, Function0<Unit> r210, final Function0<Unit> r211) {
        Intrinsics.checkNotNullParameter(r110, "promotion");
        Intrinsics.checkNotNullParameter(r111, "entranceInfo");
        Intrinsics.checkNotNullParameter(r210, "clickListener");
        Intrinsics.checkNotNullParameter(r211, "extraHideListener");
        ExplainingPromotionBar r115 = this.f148904d;
        Function0<Unit> r116 = new ECPromotionListHintBannerView$bindExplainingPromotionBar$1(this, r211, r111, r112, r113, r114);
        r115.getClass();
        Intrinsics.checkNotNullParameter(r110, "promotion");
        Intrinsics.checkNotNullParameter(r210, "clickListener");
        Intrinsics.checkNotNullParameter(r116, "hideListener");
        r115.f149125d = r110.getPromotionId();
        r115.f149122a.setText(String.valueOf(r110.getIronIndex()));
        r115.f149123b.setText(r110.mo8154getTitle());
        r115.setOnClickListener(new com.bytedance.android.livesdk.livecommerce.iron.widgets.d(r210));
        r115.f149126e = r116;
    }
}
