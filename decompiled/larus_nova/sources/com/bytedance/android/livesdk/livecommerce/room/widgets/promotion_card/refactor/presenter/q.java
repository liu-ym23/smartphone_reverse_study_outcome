package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPreSaleData;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.skin.ECLiveSkinUtil;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBackgroundElement;
import com.bytedance.android.livesdk.livecommerce.utils.ECLiveDegradeHelper;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.ECLottieAnimationView;
import com.bytedance.android.livesdk.livecommerce.view.roundcorner.RoundCornerFrameLayout;
import com.bytedance.android.livesdk.livecommerce.view.roundcorner.RoundCornerRelativeLayout;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes10.dex */
public final class q extends p {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f152470j = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f152471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f152472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f152473i;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f152474a;

        public b(q r100) {
            this.f152474a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r210) {
            final ECUIPromotion r100 = (ECUIPromotion) r210;
            if (r100 == null) goto L214;
            if (r100.isAuction() == true) goto L214;
            final q r110 = this.f152474a;
            ExplainCardViewModel r101 = r110.f152468e;
            if (r101 == null) goto L9;
            final com.bytedance.android.livesdk.livecommerce.largemode.b r111 = r101.getLargeModeAdapter();
        L10:
            ECNetImageView r112 = (ECNetImageView) r110.w().b(R.id.iv_appointment_img).f();
            final PriceView r113 = (PriceView) r110.w().b(R.id.ecpv_price).f();
            ((RelativeLayout) r110.w().b(R.id.card_bottom).f()).setVisibility(0);
            ExplainCardViewModel r102 = r110.f152468e;
            int r103 = 12;
            if (r102 == null) goto L108;
            com.bytedance.android.livesdk.livecommerce.skin.g r104 = r102.getCardSkinHelper();
            if (r104 == null) goto L108;
            Pair r105 = r104.a();
            if (r105 == null) goto L108;
            ECLiveSkinBackgroundElement r106 = (ECLiveSkinBackgroundElement) r105.component1();
            List r107 = (List) r105.component2();
            if (r107 == null) goto L29;
            Integer r108 = (Integer) CollectionsKt.firstOrNull(r107);
            if (r108 == null) goto L29;
            if (r108.intValue() <= 0) goto L23;
            boolean r114 = true;
        L24:
            if (r114 == true) goto L27;
            r108 = null;
        L27:
            if (r108 == null) goto L29;
            float r109 = r108.intValue();
            r110.f152472h = r109;
            r110.f152473i = r109;
            goto L29
        L23:
            r114 = false;
        L29:
            if (r107 == null) goto L41;
            Integer r115 = (Integer) CollectionsKt.firstOrNull(r107);
            if (r115 == null) goto L41;
            if (r115.intValue() <= 0) goto L35;
            boolean r116 = true;
        L36:
            if (r116 == true) goto L39;
            r115 = null;
        L39:
            if (r115 == null) goto L41;
            r103 = r115.intValue();
            goto L41
        L35:
            r116 = false;
        L41:
            ViewExtensionsKt.g(r110.w().b(R.id.card_bottom).f(), UtilityKotlinExtentionsKt.c(Integer.valueOf(r103)), UtilityKotlinExtentionsKt.c(Integer.valueOf(r103)), UtilityKotlinExtentionsKt.c(Integer.valueOf(r103)), UtilityKotlinExtentionsKt.c(Integer.valueOf(r103)));
            if (r106 == null) goto L63;
            List<String> r117 = r106.getColor();
            if (r117 == null) goto L63;
            if (r117.size() != 1) goto L48;
            boolean r118 = true;
        L49:
            if (r118 == true) goto L52;
            r117 = null;
        L52:
            if (r117 == null) goto L63;
            ExplainCardViewModel r119 = r110.f152468e;
            if (r119 == null) goto L60;
            com.bytedance.android.livesdk.livecommerce.skin.g r120 = r119.getCardSkinHelper();
            if (r120 == null) goto L60;
            Pair r121 = r120.c();
            if (r121 == null) goto L60;
            Drawable r122 = (Drawable) r121.getFirst();
        L61:
            if (r122 == null) goto L63;
            ((RelativeLayout) r110.w().b(R.id.card_bottom).f()).setBackground(r122);
        L113:
            r112.setVisibility(8);
            r113.C(new BottomPresenter$updateUI$4(r110));
            PriceView.z(r113, 600, 4);
            ECDraweeView r123 = (ECDraweeView) r110.w().b(R.id.iv_bottom_button).f();
            r123.setBottomRightCornerRadius(UtilityKotlinExtentionsKt.c(Float.valueOf(r110.f152473i)));
            r123.setTopRightCornerRadius(UtilityKotlinExtentionsKt.c(Float.valueOf(r110.f152473i)));
            ECDraweeView r124 = (ECDraweeView) r110.w().b(R.id.iv_bottom_button_bg).f();
            r124.setBottomRightCornerRadius(UtilityKotlinExtentionsKt.c(Float.valueOf(r110.f152473i)));
            r124.setTopRightCornerRadius(UtilityKotlinExtentionsKt.c(Float.valueOf(r110.f152473i)));
            FrameLayout r125 = (FrameLayout) r110.w().b(R.id.ec_card_promotion_info_container).f();
            ECLottieAnimationView r126 = (ECLottieAnimationView) r110.w().b(R.id.iv_card_anim).f();     // Catch: NullPointerException -> L163
            if (r110.E() == false) goto L118;
        L145:
            ECLiveABUtils r127 = ECLiveABUtils.INSTANCE;     // Catch: NullPointerException -> L163
            if (r127.getEC_LIVE_BUTTON_DESIGN_UPGRADE_V2().booleanValue() == false) goto L148;
            int r128 = R.drawable.ec_ic_explain_card_buy_nobg_new_design;
        L149:
            ExplainCardViewModel r129 = r110.f152468e;     // Catch: NullPointerException -> L163
            if (r129 == null) goto L158;
            com.bytedance.android.livesdk.livecommerce.skin.g r130 = r129.getCardSkinHelper();     // Catch: NullPointerException -> L163
            if (r130 == null) goto L158;
            String r131 = r130.d(true);     // Catch: NullPointerException -> L163
            if (r131 == null) goto L158;
            ECLiveSkinUtil.f152968l.getClass();     // Catch: NullPointerException -> L163
            Integer r132 = ECLiveSkinUtil.b(r131);     // Catch: NullPointerException -> L163
            if (r132 == null) goto L158;
            r128 = r132.intValue();     // Catch: NullPointerException -> L163
        L158:
            ECDraweeView.setPlaceholderImage$default(r123, r128, null, 2, null);     // Catch: NullPointerException -> L163
            ImageExtensionsKt.D(r123, new com.bytedance.android.ec.core.imagex.r("ec_live", "goods_card_botton_normal_view"));     // Catch: NullPointerException -> L163
            com.bytedance.android.ec.core.utils.y.d(r123, r100.transparentBottonIcon);     // Catch: NullPointerException -> L163
            if (r127.getEC_LIVE_BUTTON_DESIGN_UPGRADE_V2().booleanValue() == false) goto L161;
            ((RoundCornerRelativeLayout) r110.w().b(R.id.card_bottom).f()).setBackground(th.a.b(r110.u().c(), R.drawable.ec_bg_explain_card_button_animation));     // Catch: NullPointerException -> L163
        L161:
            r124.setVisibility(8);     // Catch: NullPointerException -> L163
        L166:
            if (r100.isPreSale() == false) goto L174;
            ECUICampaign r133 = r100.campaign;
            if (r133 == null) goto L172;
            ECPreSaleData r134 = r133.preSaleData;
            if (r134 == null) goto L172;
            Long r135 = Long.valueOf(r134.getDepositPrice());
        L177:
            Long r136 = r135;
        L179:
            if (r100.isActivity() == false) goto L181;
            String r137 = r100.campaign.priceHeader;
        L182:
            if (r137 != null) goto L184;
            r137 = "";
        L184:
            final String r138 = r137;
            final Ref.ObjectRef r139 = new Ref.ObjectRef();
            r139.element = null;
            if (r100.isPriceDeduce() == true) goto L189;
            if (ECLiveABUtils.INSTANCE.getECOM_LIVE_CARD_NO_LOGIN().booleanValue() == true) goto L189;
        L193:
            if (r136 == null) goto L195;
            final long r140 = r136.longValue();
            int r141 = 0;
            r113.C(new BottomPresenter$updateUI$$inlined$let$lambda$1(r140, r113, r138, r139, r100));
            r100.setCostPrice(com.bytedance.android.ec.core.widget.price.b.b(r140, false));
        L196:
            boolean r142 = r100.shouldShowFindSimilarWithOtherStore();
            if (r100.isOnSale() == true) goto L200;
            if (r142 == true) goto L200;
            GradientDrawable r143 = new GradientDrawable();
            r143.setColor(th.a.a(r110.u().c(), R.color.ec_color_white_50));
            r143.setCornerRadius(UtilityKotlinExtentionsKt.c(Float.valueOf(r110.f152473i)));
            Unit r144 = Unit.INSTANCE;
            r125.setForeground(r143);
        L201:
            ECPromotion.ReservationInfo r145 = r100.reservationInfo;
            if (r145 == null) goto L208;
            ((RelativeLayout) r110.w().b(R.id.card_bottom).f()).setVisibility(8);
            if (r145.hasReserved != 0) goto L206;
            ECLiveImageUtils.i(r112, r100.normalBottonIcon, r141, r141);
        L207:
            r112.setVisibility(r141);
            goto L208
        L206:
            ECLiveImageUtils.i(r112, r100.transparentBottonIcon, r141, r141);
        L208:
            r113.C(new BottomPresenter$largeModeAdaptationForPrice$1(r111));
            ExplainCardViewModel r146 = r110.f152468e;
            if (r146 == null) goto L216;
            QLiveData<bk2.a<Unit>> r147 = r146.getShowCardAction();
            if (r147 == null) goto L217;
            r147.g(new bk2.a(Unit.INSTANCE));
            return;
        L217:
            return;
        L216:
            return;
        L200:
            r125.setForeground(null);
            goto L201
        L195:
            r141 = 0;
        L189:
            if (r100.isActivity() == false) goto L191;
            T r148 = (T) r100.campaign.priceStr;
        L192:
            r139.element = r148;
            goto L193
        L191:
            r148 = (T) r100.minPriceStr;
            goto L192
        L181:
            r137 = r100.priceHeader;
        L172:
            r136 = null;
            goto L179
        L174:
            if (r100.isActivity() == false) goto L176;
            r135 = Long.valueOf(com.bytedance.android.ec.core.widget.price.b.a(r100.campaign.price));
            goto L177
        L176:
            r135 = Long.valueOf(com.bytedance.android.ec.core.widget.price.b.a(r100.price));
            goto L177
        L148:
            r128 = R.drawable.ec_ic_explain_card_buy_nobg_new_design_old;
            goto L149
        L118:
            if (r126.getVisibility() == 0) goto L120;
        L122:
            r126.setVisibility(8);     // Catch: NullPointerException -> L163
            if (ECLiveABUtils.INSTANCE.getEC_LIVE_BUTTON_DESIGN_UPGRADE_V2().booleanValue() == false) goto L125;
            int r149 = R.drawable.ec_ic_explain_card_buy_new_design;
        L126:
            ExplainCardViewModel r150 = r110.f152468e;     // Catch: NullPointerException -> L163
            if (r150 == null) goto L135;
            com.bytedance.android.livesdk.livecommerce.skin.g r151 = r150.getCardSkinHelper();     // Catch: NullPointerException -> L163
            if (r151 == null) goto L135;
            String r152 = r151.d(false);     // Catch: NullPointerException -> L163
            if (r152 == null) goto L135;
            ECLiveSkinUtil.f152968l.getClass();     // Catch: NullPointerException -> L163
            Integer r153 = ECLiveSkinUtil.b(r152);     // Catch: NullPointerException -> L163
            if (r153 == null) goto L135;
            r149 = r153.intValue();     // Catch: NullPointerException -> L163
        L135:
            ECDraweeView.setPlaceholderImage$default(r123, r149, null, 2, null);     // Catch: NullPointerException -> L163
            String r154 = r100.backgroundButtonIcon;     // Catch: NullPointerException -> L163
            if (r154 != null) goto L138;
        L141:
            boolean r155 = true;
        L142:
            if (r155 == false) goto L144;
            ImageExtensionsKt.D(r123, new com.bytedance.android.ec.core.imagex.r("ec_live", "goods_card_botton_normal_view"));     // Catch: NullPointerException -> L163
            com.bytedance.android.ec.core.utils.y.d(r123, r100.normalBottonIcon);     // Catch: NullPointerException -> L163
            r124.setVisibility(8);     // Catch: NullPointerException -> L163
            goto L166
        L144:
            ImageExtensionsKt.D(r123, new com.bytedance.android.ec.core.imagex.r("ec_live", "goods_card_botton_normal_view"));     // Catch: NullPointerException -> L163
            com.bytedance.android.ec.core.utils.y.d(r123, r100.transparentBottonIcon);     // Catch: NullPointerException -> L163
            r124.setVisibility(0);     // Catch: NullPointerException -> L163
            ImageExtensionsKt.D(r124, new com.bytedance.android.ec.core.imagex.r("ec_live", "goods_card_botton_normal_view"));     // Catch: NullPointerException -> L163
            com.bytedance.android.ec.core.utils.y.d(r124, r100.backgroundButtonIcon);     // Catch: NullPointerException -> L163
            goto L166
        L138:
            if (r154.length() == 0) goto L141;
            r155 = false;
            goto L142
        L125:
            r149 = R.drawable.ec_ic_explain_card_buy_new_design_old;
            goto L126
        L120:
            if (r126.isAnimating() == false) goto L122;
        L163:
            e = move-exception;
            ECExceptionMonitor.e(e);
        L60:
            r122 = null;
            goto L61
        L48:
            r118 = false;
        L63:
            Lazy r156 = LazyKt.lazy(new BottomPresenter$updateUI$2$6$defaultBgDrawable$2(r110));
            ECLiveABUtils r157 = ECLiveABUtils.INSTANCE;
            Integer r158 = r157.getECOM_LIVE_BUTTON_V2_STYLE();
            if (r158 != null) goto L67;
        L85:
            Integer r159 = r157.getECOM_LIVE_BUTTON_V2_STYLE();
            if (r159 != null) goto L89;
        L107:
            ((RelativeLayout) r110.w().b(R.id.card_bottom).f()).setBackground((Drawable) r156.getValue());
            goto L113
        L89:
            if (r159.intValue() != 2) goto L107;
            ExplainCardViewModel r160 = r110.f152468e;
            if (r160 == null) goto L95;
            com.bytedance.android.livesdk.livecommerce.skin.g r161 = r160.getCardSkinHelper();
            if (r161 == null) goto L95;
            int[] r162 = r161.f();
        L96:
            if (r162 != null) goto L98;
        L106:
            ((RelativeLayout) r110.w().b(R.id.card_bottom).f()).setBackground((Drawable) r156.getValue());
            Unit r163 = Unit.INSTANCE;
            goto L113
        L98:
            if (r162.length != 2) goto L100;
            boolean r164 = true;
        L101:
            if (r164 == true) goto L104;
            r162 = null;
        L104:
            if (r162 == null) goto L106;
            ((RelativeLayout) r110.w().b(R.id.card_bottom).f()).setBackground(new com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin.a(r162, new float[]{0.0f, 0.4272f}, 118.0f, UtilityKotlinExtentionsKt.c(-5)));
            goto L113
        L100:
            r164 = false;
        L95:
            r162 = null;
            goto L96
        L67:
            if (r158.intValue() != 1) goto L85;
            ExplainCardViewModel r165 = r110.f152468e;
            if (r165 == null) goto L73;
            com.bytedance.android.livesdk.livecommerce.skin.g r166 = r165.getCardSkinHelper();
            if (r166 == null) goto L73;
            int[] r167 = r166.e();
        L74:
            if (r167 != null) goto L76;
        L84:
            ((RelativeLayout) r110.w().b(R.id.card_bottom).f()).setBackground((Drawable) r156.getValue());
            Unit r168 = Unit.INSTANCE;
            goto L113
        L76:
            if (r167.length != 4) goto L78;
            boolean r169 = true;
        L79:
            if (r169 == true) goto L82;
            r167 = null;
        L82:
            if (r167 == null) goto L84;
            ((RelativeLayout) r110.w().b(R.id.card_bottom).f()).setBackground(new com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin.a(r167, new float[]{0.0f, 0.38f, 0.62f, 1.0f}, 113.0f, 0.0f));
            goto L113
        L78:
            r169 = false;
        L73:
            r167 = null;
        L108:
            RoundCornerRelativeLayout r170 = (RoundCornerRelativeLayout) r110.w().b(R.id.card_bottom).f();
            if (Build.VERSION.SDK_INT < 24) goto L111;
            r170.setBackground(th.a.b(r110.u().c(), R.drawable.ec_bg_explain_card_button));
        L112:
            ViewExtensionsKt.g(r170, UtilityKotlinExtentionsKt.c(12), UtilityKotlinExtentionsKt.c(12), UtilityKotlinExtentionsKt.c(12), UtilityKotlinExtentionsKt.c(12));
            float r171 = 12;
            r110.f152472h = r171;
            r110.f152473i = r171;
            goto L113
        L111:
            r170.setBackgroundColor(th.a.a(r110.u().c(), R.color.shopping_color_FFFF005C));
            goto L112
        L9:
            r111 = null;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f152475a;

        public c(q r100) {
            this.f152475a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            bk2.a r101 = (bk2.a) r100;
            if (this.f152475a.E() == false) goto L28;
            ExplainCardViewModel r102 = this.f152475a.f152468e;
            if (r102 == null) goto L7;
            r102.setHasShowBtnAnimation(true);
        L7:
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.q.f152505a = false;
            Query r103 = this.f152475a.w().b(R.id.fl_card_anim);
            r103.g(0);
            ViewExtensionsKt.g((RoundCornerFrameLayout) r103.f(), UtilityKotlinExtentionsKt.c(Float.valueOf(this.f152475a.f152472h)), UtilityKotlinExtentionsKt.c(Float.valueOf(this.f152475a.f152472h)), UtilityKotlinExtentionsKt.c(Float.valueOf(this.f152475a.f152472h)), UtilityKotlinExtentionsKt.c(Float.valueOf(this.f152475a.f152472h)));
            Query r104 = this.f152475a.w().b(R.id.iv_card_anim);
            r104.g(0);
            ECLottieAnimationView r105 = (ECLottieAnimationView) r104.f();
            ExplainCardViewModel r106 = this.f152475a.f152468e;
            if (r106 == null) goto L29;
            QLiveData<ECUIPromotion> r107 = r106.getPromotionState();
            if (r107 == null) goto L30;
            ECUIPromotion r108 = r107.a();
            if (r108 != null) goto L15;
            return;
        L15:
            if (r108.buttomIconWide != 1) goto L22;
            if (ECLiveABUtils.INSTANCE.getEC_LIVE_BUTTON_DESIGN_UPGRADE_V2().booleanValue() == false) goto L19;
            String r109 = "ec_live_card_buy_long_lottie.json";
        L20:
            r105.setAnimation(r109);
        L26:
            r105.playAnimation();
            r105.loop(false);
            return;
        L19:
            r109 = "ec_live_card_buy_long_lottie_old.json";
            goto L20
        L22:
            if (ECLiveABUtils.INSTANCE.getEC_LIVE_BUTTON_DESIGN_UPGRADE_V2().booleanValue() == false) goto L24;
            String r110 = "ec_live_card_buy_short_lottie.json";
        L25:
            r105.setAnimation(r110);
            goto L26
        L24:
            r110 = "ec_live_card_buy_short_lottie_old.json";
            goto L25
        L30:
            return;
        L29:
            return;
        }
    }

    static {
    }

    public final boolean E() {
        if (this.f152471g == true) goto L5;
        return false;
    L5:
        ExplainCardViewModel r100 = this.f152468e;
        if (r100 != null) goto L8;
        return false;
    L8:
        if (r100.getNeedShowBtnAnimation() == true) goto L10;
        return false;
    L10:
        if (r100.getHasShowBtnAnimation() == true) goto L20;
        ECUIPromotion r101 = r100.getPromotionState().a();
        if (r101 == null) goto L14;
        ECPromotion.ReservationInfo r102 = r101.reservationInfo;
    L15:
        if (r102 == null) goto L17;
        return false;
    L17:
        return true;
    L14:
        r102 = null;
        goto L15
    L20:
        return false;
    }

    public q() {
        this.f152472h = 12.0f;
        this.f152473i = 12.0f;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        int r101 = ECSdk.f48106a;
        IAdapterService r102 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r102 == null) goto L5;
        r102.getStrategyService();
    L5:
        ECLiveDegradeHelper.f153042c.getClass();
        if (ECLiveDegradeHelper.a("shopping_card_bottom_anim_degrade", ECLiveDegradeHelper.b().getEnableShoppingCardBottomAnimDegrade()) != 0) goto L8;
        boolean r103 = true;
    L9:
        this.f152471g = r103;
        ECLiveABUtils r104 = ECLiveABUtils.INSTANCE;
        Integer r105 = r104.getECOM_LIVE_BUTTON_V2_STYLE();
        if (r105 != null) goto L13;
    L14:
        Integer r106 = r104.getECOM_LIVE_BUTTON_V2_STYLE();
        if (r106 != null) goto L18;
    L20:
        ExplainCardViewModel r107 = this.f152468e;
        if (r107 == null) goto L25;
        QLiveData<ECUIPromotion> r108 = r107.getPromotionState();
        if (r108 == null) goto L25;
        r108.b(r100.getLifecycleOwner(), new b(this));
    L25:
        ExplainCardViewModel r109 = this.f152468e;
        if (r109 == null) goto L31;
        QLiveData<bk2.a<Unit>> r110 = r109.getShowAfterAnimAction();
        if (r110 == null) goto L32;
        r110.b(r100.getLifecycleOwner(), new c(this));
        return;
    L32:
        return;
    L31:
        return;
    L18:
        if (r106.intValue() != 2) goto L20;
    L19:
        this.f152471g = false;
        goto L20
    L13:
        if (r105.intValue() == 1) goto L19;
    L8:
        r103 = false;
        goto L9
    }
}
