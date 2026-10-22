package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.PriceView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.GroupInfo;
import com.bytedance.android.ec.model.response.anchorv3.PromotionSubsidizedActivity;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.FontStyle;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.LocalImage;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.PriceElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ImageExtensionsKt;
import com.bytedance.android.shopping.anchorv4.widgets.CountDownLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/AnchorV4ActivityLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/core/utils/l1$a;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityVO;", "vo", "", "update", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "setActionHub", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ActivityLayout extends FrameLayout implements l1.a, ActionHubAccessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f167894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ActivityVO f167895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a f167896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final QUIManager f167897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f167898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FragmentActivity f167899f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AnchorV4ActivityGroupPresenter f167900g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AnchorV4VM f167901h;

    public static final class a<T> implements y.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4ActivityLayout f167902a;

        public a(AnchorV4ActivityLayout r100) {
            this.f167902a = r100;
        }

        @Override // com.bytedance.android.ec.core.utils.y.c
        public final void accept(Object r100) {
            this.f167902a.post(new com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.b(this, (Bitmap) r100));
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4ActivityLayout f167903a;

        public b(AnchorV4ActivityLayout r100) {
            this.f167903a = r100;
        }

        public final void a() {
            if (ECAppInfoService.f48114e.f() == false) goto L18;
            ((AnchorV4PriceViewContainer) this.f167903a.a(R.id.activity_price_container)).setMaxWidth((k1.m(this.f167903a.getContext()) - com.bytedance.android.shopping.extensions.b.b(32)) - ((LinearLayout) this.f167903a.a(R.id.activity_sec_kill_time)).getMeasuredWidth());
            ViewGroup.LayoutParams r100 = ((AnchorV4PriceViewContainer) this.f167903a.a(R.id.activity_price_container)).getLayoutParams();
            ViewGroup.LayoutParams r101 = null;
            if ((r100 instanceof ConstraintLayout.LayoutParams) == true) goto L7;
            r100 = null;
        L7:
            ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r100;
            if (r102 == null) goto L10;
            r102.topToBottom = R.id.activity_price_desc_container;
        L10:
            View r103 = this.f167903a.a(R.id.activity_icon_image);
            ViewGroup.LayoutParams r104 = r103.getLayoutParams();
            if ((r104 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
            r101 = r104;
        L14:
            ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r101;
            if (r105 == null) goto L19;
            r105.topMargin = com.bytedance.android.shopping.extensions.b.b(9);
            r103.setLayoutParams(r105);
            return;
        L19:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return null;
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onStart() {
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onFinish() {
        AnchorV4VM r100 = this.f167901h;
        if (r100 == null) goto L6;
        AnchorV4VM.refresh$default(r100, false, false, null, 7, null);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.f167896c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public AnchorV4ActivityLayout(Context r100) {
        this(r100, null);
    }

    public static boolean c(ActivityTime r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        long r101 = System.currentTimeMillis() / ((long) 1000);
        long r102 = r100.getStartTime();
        long r103 = r100.getEndTime();
        if (r102 <= r101) goto L9;
        return false;
    L9:
        if (r103 < r101) goto L12;
        return true;
    L12:
        return false;
    }

    public final View a(int r100) {
        if (this.f167894a != null) goto L5;
        this.f167894a = new LinkedHashMap();
    L5:
        View r101 = this.f167894a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f167894a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void d(ActivityVO r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getActivityIconImage() != null) goto L7;
        a(R.id.activity_icon_image).setVisibility(8);
    L26:
        if (r100.getActivityTime() != null) goto L28;
        a(R.id.activity_sec_kill_time).setVisibility(8);
    L30:
        if (r100.getActivityHintText() == null) goto L41;
        a(R.id.activity_time).setVisibility(0);
        if (ECAppInfoService.f48114e.f() == false) goto L37;
        FontStyle r101 = r100.getActivityHintText().getFontStyle();
        if (r101 == null) goto L36;
        r101.setLine(2);
    L36:
        ((TextElementView) a(R.id.activity_time)).setMaxWidth(((k1.m(getContext()) - com.bytedance.android.shopping.extensions.b.b(24)) / 2) - com.bytedance.android.shopping.extensions.b.b(12));
        ((TextElementView) a(R.id.activity_time)).setGravity(GravityCompat.END);
    L37:
        ((TextElementView) a(R.id.activity_time)).x(r100.getActivityHintText());
        CountDownLayout r102 = (CountDownLayout) a(R.id.activity_sec_kill_time_countdown);
        if (r102 == null) goto L51;
        r102.setVisibility(8);
    L51:
        e(r100);
        return;
    L41:
        if (c(r100.getActivityTime()) == false) goto L48;
        a(R.id.activity_time).setVisibility(8);
        CountDownLayout r103 = (CountDownLayout) a(R.id.activity_sec_kill_time_countdown);
        if (r103 == null) goto L45;
        r103.setVisibility(0);
    L45:
        CountDownLayout r104 = (CountDownLayout) a(R.id.activity_sec_kill_time_countdown);
        if (r104 == null) goto L51;
        r104.b(r100.getActivityTime());
        goto L51
    L48:
        CountDownLayout r105 = (CountDownLayout) a(R.id.activity_sec_kill_time_countdown);
        if (r105 == null) goto L51;
        r105.setVisibility(8);
        goto L51
    L28:
        a(R.id.activity_sec_kill_time).setVisibility(0);
        goto L30
    L7:
        ViewGroup.LayoutParams r106 = null;
        if (r100.getActivityTime() == null) goto L10;
    L18:
        a(R.id.activity_icon_image).setVisibility(0);
        ViewGroup.LayoutParams r107 = ((SimpleDraweeView) a(R.id.activity_icon_image)).getLayoutParams();
        if ((r107 instanceof ConstraintLayout.LayoutParams) == false) goto L22;
        r106 = r107;
    L22:
        ConstraintLayout.LayoutParams r108 = (ConstraintLayout.LayoutParams) r106;
        if (r108 == null) goto L26;
        r108.topToTop = 0;
        r108.topToBottom = R.id.activity_sec_kill_time;
        r108.bottomToBottom = -1;
        ((SimpleDraweeView) a(R.id.activity_icon_image)).setLayoutParams(r108);
        goto L26
    L10:
        if (r100.getActivityHintText() != null) goto L18;
        a(R.id.activity_icon_image).setVisibility(0);
        ViewGroup.LayoutParams r109 = ((SimpleDraweeView) a(R.id.activity_icon_image)).getLayoutParams();
        if ((r109 instanceof ConstraintLayout.LayoutParams) == false) goto L15;
        r106 = r109;
    L15:
        ConstraintLayout.LayoutParams r110 = (ConstraintLayout.LayoutParams) r106;
        if (r110 == null) goto L26;
        r110.topToTop = 0;
        r110.bottomToBottom = 0;
        ((SimpleDraweeView) a(R.id.activity_icon_image)).setLayoutParams(r110);
        goto L26
    }

    public final void e(ActivityVO r100) {
        ActivityTime r101 = null;
        if (r100 == null) goto L5;
        ActivityTime r102 = r100.getActivityTime();
    L7:
        if (c(r102) == false) goto L16;
        CountDownLayout r103 = (CountDownLayout) findViewById(R.id.subsidized_activity_countdown);
        if (r103 == null) goto L11;
        r103.setVisibility(0);
    L11:
        CountDownLayout r104 = (CountDownLayout) findViewById(R.id.subsidized_activity_countdown);
        if (r104 == null) goto L20;
        if (r100 == null) goto L15;
        r101 = r100.getActivityTime();
    L15:
        r104.b(r101);
        return;
    L20:
        return;
    L16:
        CountDownLayout r105 = (CountDownLayout) findViewById(R.id.subsidized_activity_countdown);
        if (r105 == null) goto L22;
        r105.setVisibility(8);
        return;
    L22:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return ActionHubAccessor.DefaultImpls.c(r100);
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onTick(long r100) {
        d(this.f167895b);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r100) {
        Intrinsics.checkNotNullParameter(r100, "hub");
        this.f167896c = r100;
    }

    public final void update(ActivityVO r100) {
        this.f167895b = r100;
        AnchorV4VM r101 = this.f167901h;
        if (r101 == null) goto L5;
        r101.listenActivityTick(this);
    L5:
        d(r100);
    }

    public AnchorV4ActivityLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f167894a = new LinkedHashMap();
        this.f167897d = new QUIManager();
        FrameLayout.inflate(r100, R.layout.shopping_anchor_v4_activity_layout, this);
    }

    public final void b(ActivityVO r310, FragmentActivity r311, AnchorV4VM r312) {
        Intrinsics.checkNotNullParameter(r311, "activity");
        Intrinsics.checkNotNullParameter(r312, "viewModel");
        ConstraintLayout r100 = (ConstraintLayout) a(R.id.activity_root);
        if (r100 == null) goto L16;
        List<View> r101 = com.bytedance.commerce.base.view.b.a(r100);
        if (r101 == null) goto L16;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L16;
        View r110 = (View) r102.next();
        if (Intrinsics.areEqual(r110, (ViewStub) a(R.id.activity_subsidized_viewstub)) == true) goto L15;
        if (Intrinsics.areEqual(r110, findViewById(R.id.anchor_v3_sv_subsized_activity_layout)) == true) goto L15;
        r110.setVisibility(0);
    L15:
        r110.setVisibility(8);
    L16:
        this.f167895b = r310;
        this.f167899f = r311;
        this.f167901h = r312;
        r312.listenActivityTick(this);
        if (r310 != null) goto L19;
    L203:
        setVisibility(8);
        return;
    L19:
        if (com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.a.a(r310) == false) goto L203;
        setVisibility(0);
        ImageModel r103 = r310.getActivityBgUrl();
        ViewGroup.LayoutParams r111 = null;
        if (r103 == null) goto L24;
        ECUrlModel r104 = r103.getRemote();
    L26:
        if (r104 == null) goto L28;
        y.l(r310.getActivityBgUrl().getRemote(), -1, -1, new a(this));
    L34:
        ImageExtensionsKt.d((SimpleDraweeView) a(R.id.activity_icon_image), r310.getActivityIconImage(), null);
        d(r310);
        ((LinearLayout) a(R.id.activity_sec_kill_time)).post(new b(this));
        TextElement r105 = r310.getPriceDesc();
        if (r105 != null) goto L37;
    L42:
        a(R.id.activity_price_desc).setVisibility(8);
    L43:
        TextElement r106 = r310.getSales();
        if (r106 == null) goto L46;
        ((TextElementView) a(R.id.activity_sales)).x(r106);
        a(R.id.activity_sales).setVisibility(0);
    L47:
        ((TextElementView) a(R.id.activity_sales)).setBackground(com.bytedance.commerce.base.drawable.a.a(AnchorV4ActivityLayout$bind$9.INSTANCE));
        ((PriceElementView) a(R.id.activity_price)).D(r310.getPrice());
        ViewGroup.LayoutParams r107 = ((PriceElementView) a(R.id.activity_price)).getLayoutParams();
        if ((r107 instanceof ConstraintLayout.LayoutParams) == true) goto L50;
        r107 = null;
    L50:
        ConstraintLayout.LayoutParams r108 = (ConstraintLayout.LayoutParams) r107;
        if (r108 == null) goto L57;
        if (r310.getDiscountPrice() != null) goto L55;
        ((ViewGroup.MarginLayoutParams) r108).bottomMargin = com.bytedance.android.shopping.extensions.b.b(6);
        goto L57
    L55:
        ((ViewGroup.MarginLayoutParams) r108).bottomMargin = com.bytedance.android.shopping.extensions.b.b(8);
    L57:
        if (r310.getDepositPrice() == null) goto L59;
        ((PriceElementView) a(R.id.activity_deposit_price)).D(r310.getDepositPrice());
        ((PriceElementView) a(R.id.activity_deposit_price)).C(AnchorV4ActivityLayout$bind$11.INSTANCE);
        a(R.id.activity_deposit_price).setVisibility(0);
    L61:
        if (r310.getDiscountPrice() == null) goto L73;
        a(R.id.activity_discount_price).setVisibility(0);
        ((PriceElementView) a(R.id.activity_discount_price)).D(r310.getDiscountPrice());
        ((PriceElementView) a(R.id.activity_discount_price)).C(AnchorV4ActivityLayout$bind$12.INSTANCE);
        if (r310.getDiscountPrice().getBgType() != 1) goto L66;
        ((PriceElementView) a(R.id.activity_discount_price)).setBackground(com.bytedance.commerce.base.drawable.a.a(AnchorV4ActivityLayout$bind$13.INSTANCE));
    L66:
        if (r310.getDiscountPrice().getBgType() != 0) goto L75;
        View r109 = a(R.id.activity_discount_price);
        ViewGroup.LayoutParams r112 = r109.getLayoutParams();
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == true) goto L70;
        r112 = null;
    L70:
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        if (r113 == null) goto L75;
        r113.setMarginStart(0);
        r109.setLayoutParams(r113);
    L75:
        if (r310.getMarketPrice() == null) goto L77;
        a(R.id.activity_market_price).setVisibility(0);
        ((PriceElementView) a(R.id.activity_market_price)).D(r310.getMarketPrice());
        ((PriceElementView) a(R.id.activity_market_price)).C(AnchorV4ActivityLayout$bind$15.INSTANCE);
    L79:
        if (this.f167900g != null) goto L81;
        this.f167900g = new AnchorV4ActivityGroupPresenter(r311);
    L81:
        AnchorV4ActivityGroupPresenter r114 = this.f167900g;
        Intrinsics.checkNotNull(r114);
        ActivityVO r115 = this.f167895b;
        CommonMeta r116 = r312.commonMeta();
        if (r115 != null) goto L84;
        ((AnchorV4ActivityGroupViewModel) r114.f167892e.getValue()).getGroupInfo().g(null);
    L87:
        ((AnchorV4ActivityGroupViewModel) r114.f167892e.getValue()).getCommonMeta().g(r116);
        r114.f167893f = r115;
        AnchorV4ActivityGroupPresenter r117 = this.f167900g;
        Intrinsics.checkNotNull(r117);
        r312.watchPageStatusChange(r117);
        long r118 = 0;
        if (r310.getGroupId() != 0) goto L90;
        a(R.id.group_bottom_layout).setVisibility(8);
    L95:
        PromotionSubsidizedActivity r119 = r310.getSubsidy();
        if (r119 == null) goto L199;
        ConstraintLayout r120 = (ConstraintLayout) a(R.id.activity_root);
        if (r120 == null) goto L100;
        r120.setBackground(null);
    L100:
        ConstraintLayout r121 = (ConstraintLayout) a(R.id.activity_root);
        if (r121 == null) goto L108;
        List<View> r122 = com.bytedance.commerce.base.view.b.a(r121);
        if (r122 == null) goto L108;
        Iterator<T> r123 = r122.iterator();
    L106:
        if (r123.hasNext() == false) goto L108;
        ((View) r123.next()).setVisibility(8);
    L108:
        ViewStub r124 = (ViewStub) a(R.id.activity_subsidized_viewstub);
        if (r124 == null) goto L111;
        r124.setVisibility(0);
    L111:
        findViewById(R.id.anchor_v3_sv_subsized_activity_layout).setVisibility(0);
        View r125 = findViewById(R.id.anchor_v3_subsidized_vertical_line);
        TextView r126 = (TextView) findViewById(R.id.anchor_v3_subsidized_has_sold_count);
        if (r310.getSales() == null) goto L119;
        if (r125 == null) goto L115;
        r125.setVisibility(0);
    L115:
        if (r126 == null) goto L117;
        r126.setVisibility(0);
    L117:
        if (r126 == null) goto L123;
        r126.setText(r310.getSales().getText());
    L123:
        e(r310);
        SimpleDraweeView r127 = (SimpleDraweeView) findViewById(R.id.anchor_v3_sv_subsidized_left_background);
        if (r127 == null) goto L131;
        ECUrlModel r128 = r119.getLogoBackground();
        if (r128 == null) goto L131;
        ViewGroup.LayoutParams r129 = r127.getLayoutParams();
        if (r129 == null) goto L130;
        r129.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r128.getWidth()));
        r129.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r128.getHeight()));
        r127.setLayoutParams(r129);
    L130:
        y.a(r127, r128);
    L131:
        SimpleDraweeView r130 = (SimpleDraweeView) findViewById(R.id.anchor_v3_sv_activity_background);
        if (r130 == null) goto L134;
        y.a(r130, r119.getBeltBackground());
    L134:
        SimpleDraweeView r131 = (SimpleDraweeView) findViewById(R.id.anchor_v3_subsidized_sv_sell_price_desc);
        if (r131 == null) goto L142;
        ECUrlModel r132 = r119.getSellPriceIcon();
        if (r132 == null) goto L141;
        ViewGroup.LayoutParams r133 = r131.getLayoutParams();
        if (r133 == null) goto L141;
        r133.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r132.getWidth()));
        r133.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r132.getHeight()));
        r131.setLayoutParams(r133);
    L141:
        y.a(r131, r119.getSellPriceIcon());
    L142:
        PriceView r134 = (PriceView) findViewById(R.id.anchor_v3_subsidized_sell_price_view);
        if (r134 == null) goto L177;
        int r135 = com.bytedance.android.shopping.utils.g.f187081a;
        Long r136 = r119.getSellPrice();
        if (r136 == null) goto L147;
        r118 = r136.longValue();
    L147:
        r134.setPriceText(com.bytedance.android.shopping.utils.g.d(r118));
        if (r119.getSellPrice() != null) goto L150;
    L154:
        r134.setExtraText("");
    L155:
        ECUrlModel r137 = r119.getLogoBackground();
        if (r137 == null) goto L177;
        int r138 = r137.getWidth();
        Long r139 = r119.getSellPrice();
        if (r139 != null) goto L160;
    L175:
        r134.setMaxWidth(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r138)) - com.bytedance.android.shopping.extensions.b.b(18));
        goto L177
    L160:
        if ((r139.longValue() / ((long) 100)) <= 10000) goto L168;
        ViewGroup.LayoutParams r140 = r134.getLayoutParams();
        if ((r140 instanceof ConstraintLayout.LayoutParams) == false) goto L165;
        r111 = r140;
    L165:
        ConstraintLayout.LayoutParams r141 = (ConstraintLayout.LayoutParams) r111;
        if (r141 == null) goto L175;
        ((ViewGroup.MarginLayoutParams) r141).leftMargin = 0;
        r141.startToStart = 0;
        r141.endToEnd = 0;
        r134.setLayoutParams(r141);
        goto L175
    L168:
        ViewGroup.LayoutParams r142 = r134.getLayoutParams();
        if ((r142 instanceof ConstraintLayout.LayoutParams) == false) goto L172;
        r111 = r142;
    L172:
        ConstraintLayout.LayoutParams r143 = (ConstraintLayout.LayoutParams) r111;
        if (r143 == null) goto L175;
        ((ViewGroup.MarginLayoutParams) r143).leftMargin = com.bytedance.android.shopping.extensions.b.b(12);
        r143.startToStart = 0;
        r143.endToEnd = -1;
        r134.setLayoutParams(r143);
        goto L175
    L150:
        if (r119.getMaxSellPrice() == null) goto L154;
        if ((!Intrinsics.areEqual(r119.getMaxSellPrice(), r119.getSellPrice())) == false) goto L154;
        r134.setExtraText(getResources().getString(R.string.commerce_tip_price_append_text));
    L177:
        if (com.bytedance.android.shopping.extensions.k.c(r119.getSubsidizedPriceDesc()) == false) goto L184;
        TextView r144 = (TextView) findViewById(R.id.anchor_v3_tv_subsidized_price_desc);
        if (r144 == null) goto L181;
        r144.setVisibility(0);
    L181:
        TextView r145 = (TextView) findViewById(R.id.anchor_v3_tv_subsidized_price_desc);
        if (r145 == null) goto L187;
        r145.setText(r119.getSubsidizedPriceDesc());
    L187:
        TextView r146 = (TextView) findViewById(R.id.anchor_v3_tv_market_price_desc);
        String r147 = r119.getMarketPriceDesc();
        if (r147 == null) goto L195;
        String r148 = a2.d(r147);
        if (r148 == null) goto L195;
        if (r146 == null) goto L193;
        r146.setVisibility(0);
    L193:
        if (r146 == null) goto L213;
        r146.setText(r148);
        return;
    L213:
        return;
    L195:
        if (r146 == null) goto L197;
        r146.setVisibility(8);
    L197:
        if (r125 == null) goto L215;
        r125.setVisibility(8);
        return;
    L215:
        return;
    L184:
        TextView r149 = (TextView) findViewById(R.id.anchor_v3_tv_subsidized_price_desc);
        if (r149 == null) goto L187;
        r149.setVisibility(8);
        goto L187
    L119:
        if (r125 == null) goto L121;
        r125.setVisibility(8);
    L121:
        if (r126 == null) goto L123;
        r126.setVisibility(8);
        goto L123
    L199:
        View r150 = findViewById(R.id.anchor_v3_sv_subsized_activity_layout);
        if (r150 == null) goto L217;
        r150.setVisibility(8);
        return;
    L217:
        return;
    L90:
        a(R.id.group_bottom_layout).setVisibility(0);
        if (this.f167898e != null) goto L95;
        FragmentActivity r151 = this.f167899f;
        if (r151 == null) goto L95;
        Intrinsics.checkNotNull(r151);
        g r152 = new g(r151, this.f167901h);
        this.f167898e = r152;
        QUIManager r153 = this.f167897d;
        Intrinsics.checkNotNull(r152);
        r153.l(r152, getContext(), false);
        this.f167897d.c(g.class, null);
        ((ViewGroup) findViewById(R.id.group_bottom_layout)).addView(this.f167897d.p());
        goto L95
    L84:
        if ((!Intrinsics.areEqual(r115, r114.f167893f)) == false) goto L87;
        ((AnchorV4ActivityGroupViewModel) r114.f167892e.getValue()).getGroupInfo().g(new GroupInfo(0, null, r115.getJoined(), r115.getGroupSize(), r115.getPercent(), r115.getSkuMinPrice(), r115.getSkuMaxPrice(), r115.getGroupId(), null, null, 771, null));
        goto L87
    L77:
        a(R.id.activity_market_price).setVisibility(8);
        goto L79
    L73:
        a(R.id.activity_discount_price).setVisibility(8);
        goto L75
    L59:
        a(R.id.activity_deposit_price).setVisibility(8);
        goto L61
    L46:
        a(R.id.activity_sales).setVisibility(8);
        goto L47
    L37:
        if (com.bytedance.android.shopping.extensions.k.c(r105.getText()) == true) goto L40;
        r105 = null;
    L40:
        if (r105 == null) goto L42;
        ((TextElementView) a(R.id.activity_price_desc)).x(r105);
        a(R.id.activity_price_desc).setVisibility(0);
        goto L43
    L28:
        ImageModel r154 = r310.getActivityBgUrl();
        if (r154 == null) goto L31;
        LocalImage r155 = r154.getLocal();
    L32:
        if (r155 == null) goto L34;
        ((ConstraintLayout) a(R.id.activity_root)).setBackground(ImageExtensionsKt.b(r310.getActivityBgUrl().getLocal(), getContext()));
        goto L34
    L31:
        r155 = null;
        goto L32
    L24:
        r104 = null;
        goto L26
    }
}
