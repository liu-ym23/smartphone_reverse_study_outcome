package com.bytedance.android.livesdk.livecommerce.playback.card.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cf.h;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/card/widget/ExplainProductCardWithBuyButtonView;", "Landroid/widget/RelativeLayout;", "Lcom/bytedance/android/livesdk/livecommerce/playback/card/widget/f;", "Lcf/h;", "listener", "", "setFinishPlaybackPageListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainProductCardWithBuyButtonView extends RelativeLayout implements com.bytedance.android.livesdk.livecommerce.playback.card.widget.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDraweeView f149841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PriceView f149842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f149843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f149844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f149845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f149846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f149847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f149848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f149849i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.playback.card.widget.e f149850j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ObjectAnimator f149851k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ObjectAnimator f149852l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ObjectAnimator f149853m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ObjectAnimator f149854n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ObjectAnimator f149855o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ObjectAnimator f149856p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f149857q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f149858r;

    public static final class a extends com.bytedance.android.ec.core.widget.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ ExplainProductCardWithBuyButtonView f149859g;

        public a(ExplainProductCardWithBuyButtonView r100) {
            this.f149859g = r100;
            super(null, null, 3);
        }

        @Override // com.bytedance.android.ec.core.widget.d
        public final void a(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f149859g.f149847g.setVisibility(8);
            cj2.c r101 = cj2.a.f23945a;
            HashMap r102 = new HashMap();
            r102.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, com.bytedance.android.ec.core.event.a.VALUE_REPlAY_POPUP_CARD);
            r102.put(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, "2");
            cj2.a.a("livesdk_replay_popup_card_close", r102, null, null);
        }
    }

    public static final class b {
    }

    public static final class c extends com.bytedance.android.ec.core.widget.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f149860g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ jf.d f149861h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ g f149862i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ Context f149863j;

        @Override // com.bytedance.android.ec.core.widget.d
        public final void a(View r110) {
            Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
            if (this.f149860g == true) goto L9;
            jf.d r100 = this.f149861h;
            if (r100 == null) goto L9;
            g r101 = this.f149862i;
            if (r101 == null) goto L9;
            jf.d.b.c(r100, this.f149863j, r101, BrowserDependency.UrlClickType.CARD, false, BtmUtilsKt.e("a1.b3390.c11834.d45925", PageFinder.via(r110)), null);
        L9:
            cj2.a.c(com.bytedance.android.ec.core.event.a.VALUE_EXIT_TYPE_CLICK_BLANK, "2");
            jf.d r102 = this.f149861h;
            if (r102 == null) goto L15;
            g r103 = this.f149862i;
            if (r103 == null) goto L16;
            jf.d.b.f(r102, r103, BrowserDependency.UrlClickType.CARD, false, "a1.b3390.c11834.d45925", null, r110, false, 84);
            return;
        L16:
            return;
        }

        public c(boolean r100, jf.d r101, g r102, Context r103) {
            this.f149860g = r100;
            this.f149861h = r101;
            this.f149862i = r102;
            this.f149863j = r103;
            super(null, null, 3);
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExplainProductCardWithBuyButtonView f149864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jf.d f149865b;

        public d(ExplainProductCardWithBuyButtonView r100, jf.d r101) {
            this.f149864a = r100;
            this.f149865b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ExplainProductCardWithBuyButtonView r100 = this.f149864a;     // Catch: Throwable -> L4
            r100.f149858r = r100.f149847g.getWidth();     // Catch: Throwable -> L4
            ExplainProductCardWithBuyButtonView r101 = this.f149864a;     // Catch: Throwable -> L4
            r101.f149857q = r101.f149847g.getHeight();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ dj2.d f149866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ExplainProductCardWithBuyButtonView f149867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0 f149868c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r110) {
            Intrinsics.checkNotNullParameter(r110, GXTemplateKey.GAIAX_ANIMATION);
            ExplainProductCardWithBuyButtonView r111 = this.f149867b;
            dj2.d r100 = this.f149866a;
            int r101 = r100.f468885a;
            int r102 = r100.f468886b;
            int r103 = r100.f468887c;
            Function0 r104 = this.f149868c;
            r111.getClass();
            AnimatorSet r105 = new AnimatorSet();
            ValueAnimator r106 = ValueAnimator.ofInt(new int[]{r111.getContext().getResources().getDimensionPixelOffset(R.dimen.ec_explain_playback_small_product_card_imagesize), r103});
            r106.addUpdateListener(new com.bytedance.android.livesdk.livecommerce.playback.card.widget.a(r111));
            r106.setTarget(r111.f149841a);
            ValueAnimator r107 = ValueAnimator.ofInt(new int[]{r111.f149858r, r101});
            r107.addUpdateListener(new com.bytedance.android.livesdk.livecommerce.playback.card.widget.b(r111));
            r107.setTarget(r111.f149847g);
            ValueAnimator r108 = ValueAnimator.ofInt(new int[]{r111.f149857q, r102});
            r108.addUpdateListener(new com.bytedance.android.livesdk.livecommerce.playback.card.widget.c(r111));
            r108.setTarget(r111.f149847g);
            r105.playTogether(new Animator[]{r106, r107, r108});
            r105.setDuration(300);
            r105.start();
            r105.addListener(new com.bytedance.android.livesdk.livecommerce.playback.card.widget.d(r111, r104));
        }

        public e(dj2.d r100, ExplainProductCardWithBuyButtonView r101, Function0 r102) {
            this.f149866a = r100;
            this.f149867b = r101;
            this.f149868c = r102;
        }
    }

    public static final class f extends AnimatorListenerAdapter {
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public f() {
        }
    }

    static {
    }

    public ExplainProductCardWithBuyButtonView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ExplainProductCardWithBuyButtonView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.playback.card.widget.f
    public void setFinishPlaybackPageListener(h r100) {
    }

    public final void c() {
        this.f149844d.setTextColor(th.a.a(getContext(), R.color.ec_color_34_161823));
        this.f149845e.setImageResource(R.drawable.ec_explain_playback_ic_playback_card_arrow_grey);
    }

    public ExplainProductCardWithBuyButtonView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f149850j = new com.bytedance.android.livesdk.livecommerce.playback.card.widget.e();
        LayoutInflater.from(r100).inflate(R.layout.ec_explain_playback_small_card_style_1, this);
        this.f149841a = (SimpleDraweeView) findViewById(R.id.ec_commerce_sv_playback_product_img);
        this.f149842b = (PriceView) findViewById(R.id.ec_commerce_pv_playback_product_price);
        ImageView r103 = (ImageView) findViewById(R.id.ec_commerce_iv_playback_close);
        this.f149843c = r103;
        this.f149844d = (TextView) findViewById(R.id.ec_commerce_tv_playback_purchase);
        this.f149845e = (ImageView) findViewById(R.id.ec_commerce_iv_purchase_arrow);
        this.f149846f = findViewById(R.id.ec_commerce_product_purchase_container);
        View r104 = findViewById(R.id.commerce_playback_product_purchase_card_rootview);
        this.f149847g = r104;
        this.f149848h = findViewById(R.id.ec_commerce_tv_product_unable_container);
        this.f149849i = (TextView) findViewById(R.id.ec_commerce_tv_product_unable_tip);
        r103.setOnClickListener(new a(this));
        Drawable r105 = r104.getBackground();
        if ((r105 instanceof BackgroundDrawable) == true) goto L5;
        r105 = null;
    L5:
        BackgroundDrawable r106 = (BackgroundDrawable) r105;
        if (r106 == null) goto L9;
        r106.setBgColor(-1);
        r106.setCornerRadius(com.bytedance.android.shopping.extensions.b.b(6));
        r106.invalidate();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.playback.card.widget.f
    public final void a(boolean r110, dj2.d r111, Function0<Unit> r112) {
        Intrinsics.checkNotNullParameter(r111, "cardViewState");
        AnimatorSet r100 = new AnimatorSet();
        if (r110 == false) goto L32;
        ViewGroup.LayoutParams r113 = this.f149847g.getLayoutParams();
        boolean r114 = r113 instanceof RelativeLayout.LayoutParams;
        ViewGroup.LayoutParams r115 = null;
        if (r114 == true) goto L7;
        ViewGroup.LayoutParams r101 = null;
    L8:
        RelativeLayout.LayoutParams r102 = (RelativeLayout.LayoutParams) r101;
        if (r102 == null) goto L11;
        r102.width = this.f149858r;
    L11:
        if (r114 == true) goto L13;
        ViewGroup.LayoutParams r116 = null;
    L14:
        RelativeLayout.LayoutParams r117 = (RelativeLayout.LayoutParams) r116;
        if (r117 == null) goto L17;
        r117.height = this.f149857q;
    L17:
        this.f149847g.setLayoutParams(r113);
        ViewGroup.LayoutParams r118 = this.f149841a.getLayoutParams();
        boolean r119 = r118 instanceof RelativeLayout.LayoutParams;
        if (r119 == true) goto L20;
        ViewGroup.LayoutParams r103 = null;
    L21:
        RelativeLayout.LayoutParams r104 = (RelativeLayout.LayoutParams) r103;
        if (r104 == null) goto L24;
        r104.width = getContext().getResources().getDimensionPixelSize(R.dimen.ec_explain_playback_small_product_card_imagesize);
    L24:
        if (r119 == false) goto L27;
        r115 = r118;
    L27:
        RelativeLayout.LayoutParams r120 = (RelativeLayout.LayoutParams) r115;
        if (r120 == null) goto L30;
        r120.height = getContext().getResources().getDimensionPixelSize(R.dimen.ec_explain_playback_small_product_card_imagesize);
    L30:
        this.f149841a.setLayoutParams(r118);
        r100.playTogether(new Animator[]{this.f149854n, this.f149855o, this.f149856p});
        r100.addListener(new f());
        r100.setDuration(200);
        r100.start();
        this.f149847g.setVisibility(0);
        return;
    L20:
        r103 = r118;
        goto L21
    L13:
        r116 = r113;
        goto L14
    L7:
        r101 = r113;
        goto L8
    L32:
        if (r111.f468885a > 0) goto L34;
    L38:
        r100.start();
        return;
    L34:
        if (r111.f468886b <= 0) goto L38;
        if (r111.f468887c <= 0) goto L38;
        r100.playTogether(new Animator[]{this.f149851k, this.f149852l, this.f149853m});
        r100.addListener(new e(r111, this, r112));
        r100.setDuration(200);
        goto L38
    }

    public /* synthetic */ ExplainProductCardWithBuyButtonView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    /* JADX WARN: Type inference failed for: r0v51, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v10, types: [T, java.lang.String] */
    public final void b(final ECUIPromotion r110, boolean r111, Context r112, jf.d r113, g r114) {
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        SimpleDraweeView r100 = this.f149841a;
        String r101 = r110.imageUrl;
        int r102 = r.f44937h;
        h0.e(r100, r101, r.a.b("explain_playback"), null, null, 120);
        com.bytedance.android.livesdk.livecommerce.playback.card.widget.e r103 = this.f149850j;
        final PriceView r104 = this.f149842b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r110, "promotion");
        Intrinsics.checkNotNullParameter(r104, "productPriceView");
        long r105 = SystemClock.elapsedRealtime();
        if (TextUtils.isEmpty(r110.priceHeader) == true) goto L19;
        ECUICampaign r106 = r110.campaign;
        if (r106 != null) goto L7;
    L9:
        String r107 = r110.price;
    L10:
        if (r106 != null) goto L12;
    L14:
        String r108 = r110.maxPrice;
    L15:
        final Ref.ObjectRef r109 = new Ref.ObjectRef();
        r109.element = null;
        if (com.bytedance.android.livesdk.livecommerce.playback.card.widget.e.a(r107, r108) == false) goto L18;
        r109.element = r104.getContext().getResources().getString(R.string.ec_explain_playback_tip_price_suffix_text);
    L18:
        r104.C(new ExplainProductSmallCardController$setPriceInfo$1(r109, r110));
    L63:
        int r115 = r110.getStatus();
        if (r115 != 4) goto L66;
    L73:
        c();
        this.f149844d.setText(R.string.ec_explain_playback_cannot_buy);
        this.f149848h.setVisibility(0);
        this.f149849i.setText(R.string.ec_explain_playback_tip_playback_cannot_buy);
    L74:
        setOnClickListener(new c(r111, r113, r114, r112));
        this.f149851k = ObjectAnimator.ofFloat(this.f149846f, "alpha", new float[]{1.0f, 0.0f});
        this.f149852l = ObjectAnimator.ofFloat(this.f149842b, "alpha", new float[]{1.0f, 0.0f});
        this.f149853m = ObjectAnimator.ofFloat(this.f149843c, "alpha", new float[]{1.0f, 0.0f});
        this.f149854n = ObjectAnimator.ofFloat(this.f149846f, "alpha", new float[]{0.0f, 1.0f});
        this.f149855o = ObjectAnimator.ofFloat(this.f149842b, "alpha", new float[]{0.0f, 1.0f});
        this.f149856p = ObjectAnimator.ofFloat(this.f149843c, "alpha", new float[]{0.0f, 1.0f});
        this.f149847g.post(new d(this, r113));
        return;
    L66:
        if (r115 == 3) goto L73;
        if (r115 != 5) goto L71;
        c();
        this.f149844d.setText(R.string.ec_explain_playback_under_stock);
        this.f149848h.setVisibility(0);
        this.f149849i.setText(R.string.ec_explain_playback_tip_playback_under_stock);
        goto L74
    L71:
        if (r115 != 2) goto L74;
        c();
        this.f149844d.setText(R.string.ec_explain_playback_no_stock);
        this.f149848h.setVisibility(0);
        this.f149849i.setText(R.string.ec_explain_playback_tip_playback_no_stock);
        goto L74
    L12:
        if (r105 >= r106.endTime) goto L14;
        r108 = r106.maxPrice;
        goto L15
    L7:
        if (r105 >= r106.endTime) goto L9;
        r107 = r106.price;
        goto L10
    L19:
        ECUICampaign r116 = r110.campaign;
        if (r116 != null) goto L22;
    L29:
        ECUICampaign r117 = r110.campaign;
        if (r117 != null) goto L32;
    L36:
        ECUICampaign r118 = r110.campaign;
        if (r118 != null) goto L39;
    L46:
        r104.C(new ExplainProductSmallCardController$setPriceInfo$6(r110));
    L47:
        ECUICampaign r119 = r110.campaign;
        if (r119 == null) goto L58;
        if (r119.startTime > r105) goto L58;
        if (r105 > r119.endTime) goto L58;
        if (com.bytedance.android.livesdk.livecommerce.playback.card.widget.e.a(r119.price, r119.maxPrice) == false) goto L56;
        r104.C(new ExplainProductSmallCardController$setPriceInfo$7(r104));
        goto L63
    L56:
        r104.C(ExplainProductSmallCardController$setPriceInfo$8.INSTANCE);
    L58:
        if (r110.isInsuranceProduct() == true) goto L60;
        r104.C(ExplainProductSmallCardController$setPriceInfo$10.INSTANCE);
        goto L63
    L60:
        if (com.bytedance.android.livesdk.livecommerce.playback.card.widget.e.a(r110.price, r110.maxPrice) == false) goto L63;
        r104.C(new ExplainProductSmallCardController$setPriceInfo$9(r104));
        goto L63
    L39:
        if (r118.startTime > r105) goto L46;
        if (r105 > r118.endTime) goto L46;
        if (r110.isSecKill().booleanValue() == false) goto L45;
        r104.C(new ExplainProductSmallCardController$setPriceInfo$4(r104));
    L45:
        r104.C(new ExplainProductSmallCardController$setPriceInfo$5(r110));
        goto L47
    L32:
        if (r117.isPreSale().booleanValue() == false) goto L36;
        if (r110.campaign.inCampaignTime() == false) goto L36;
        r104.C(new ExplainProductSmallCardController$setPriceInfo$3(r110, r104));
        goto L63
    L22:
        if (r105 > r116.endTime) goto L29;
        if (r116.isGroup().booleanValue() == false) goto L29;
        final Ref.ObjectRef r120 = new Ref.ObjectRef();
        r120.element = null;
        ECUICampaign r121 = r110.campaign;
        if (com.bytedance.android.livesdk.livecommerce.playback.card.widget.e.a(r121.price, r121.maxPrice) == false) goto L28;
        r120.element = r104.getContext().getResources().getString(R.string.ec_explain_playback_tip_price_suffix_text);
    L28:
        r104.C(new ExplainProductSmallCardController$setPriceInfo$2(r110, r120, r104));
        goto L63
    }
}
