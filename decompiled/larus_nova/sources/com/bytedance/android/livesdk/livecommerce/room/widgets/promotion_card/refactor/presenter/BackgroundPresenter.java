package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.core.widget.ECPromotionImageView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.promotion.ECUISmallPopCard;
import com.bytedance.android.ec.model.response.ECCombination;
import com.bytedance.android.ec.model.response.ECCombinationProduct;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.model.response.ECPromotionPopHeader;
import com.bytedance.android.ec.model.response.PopStyle;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.CombinationView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class BackgroundPresenter extends p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f152398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f152399h;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BackgroundPresenter f152400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c f152401b;

        public a(BackgroundPresenter r100, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r101) {
            this.f152400a = r100;
            this.f152401b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            ECUIPromotion r100 = (ECUIPromotion) r110;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.isAuction() == false) goto L7;
            return;
        L7:
            if ((!Intrinsics.areEqual(r100.getPromotionId(), this.f152400a.f152398g)) == false) goto L9;
            this.f152400a.f152399h = null;
        L9:
            OptCardUtil.b(null, "observe promotion change");
            final BackgroundPresenter r101 = this.f152400a;
            r101.getClass();
            r101.f152398g = r100.getPromotionId();
            ECPromotionImageView r102 = (ECPromotionImageView) r101.w().b(R.id.iv_ec_main_image).f();
            OptCardUtil.b("image", "bind image");
            r102.setPromotionImageBindConfig(new com.bytedance.android.ec.core.utils.w(new o(r101), new BackgroundPresenter$updateUI$2(r101)));
            r102.setCallerContext(new com.bytedance.android.ec.core.imagex.r("ec_live", "goods_card_view"));
            ECLiveImageUtils.h(r102, r100, r100.getStatus(), false, false);
            Query r103 = r101.w().b(R.id.iv_ec_activity_cover);
            r103.g(8);
            ECUISmallPopCard r104 = r100.smallPopCard;
            if (r104 == null) goto L24;
            String r105 = r104.backgroundImgNew;
            if (r105 == null) goto L24;
            if (r105.length() <= 0) goto L16;
            boolean r111 = true;
        L17:
            if (r111 == false) goto L24;
            ECCurrentPromotion.PopBackground r112 = r100.getBackground();
            if (r112 == null) goto L23;
            RitTagTrack r113 = r112.tagTrack;
            if (r113 == null) goto L23;
            r113.setVisibile(true);
        L23:
            r103.g(0);
            ViewExtensionsKt.g(r103.f(), 16.0f, 16.0f, 16.0f, 16.0f);
            r103.g(0);
            SimpleDraweeView r106 = (SimpleDraweeView) r103.f();
            ImageExtensionsKt.D(r106, new com.bytedance.android.ec.core.imagex.r("ec_live", "goods_card_activity_view"));
            ECLiveImageUtils.j(r106, r105);
            goto L24
        L16:
            r111 = false;
        L24:
            ECCombination r107 = r100.getCombination();
            if (r107 == null) goto L65;
            r100.setShowCombination(true);
            Query r108 = r101.w().b(R.id.cv_ec_combination);
            r108.g(0);
            CombinationView r109 = (CombinationView) r108.f();
            Intrinsics.checkNotNullParameter(r107, "combination");
            int r114 = com.bytedance.android.ec.core.utils.s.f45717a;
            PopStyle r115 = r107.getPopStyle();
            if (r115 == null) goto L29;
            String r116 = r115.getBackgroundColor();
        L30:
            Integer r117 = com.bytedance.android.ec.core.utils.s.b(r116);
            if (r117 == null) goto L33;
            r109.setBackgroundColor(r117.intValue());
        L33:
            r109.setRadius(UtilityKotlinExtentionsKt.c(6));
            List<ECCombinationProduct> r118 = r107.getCombinationProducts();
            if (r118 == null) goto L52;
            Iterator<T> r119 = r118.iterator();
            int r120 = 0;
        L37:
            if (r119.hasNext() == false) goto L52;
            T r121 = r119.next();
            int r122 = r120 + 1;
            if (r120 >= 0) goto L41;
            CollectionsKt.throwIndexOverflow();
        L41:
            ECCombinationProduct r123 = (ECCombinationProduct) r121;
            if (r120 < ((ArrayList) r109.f152506b).size()) goto L45;
            List<ECNetImageView> r124 = r109.f152506b;
            ECNetImageView r125 = new ECNetImageView(r109.getContext());
            LinearLayout.LayoutParams r126 = new LinearLayout.LayoutParams((int) UtilityKotlinExtentionsKt.c(23), (int) UtilityKotlinExtentionsKt.c(23));
            r126.setMargins((int) UtilityKotlinExtentionsKt.c(2), (int) UtilityKotlinExtentionsKt.c(3), 0, (int) UtilityKotlinExtentionsKt.c(3));
            Unit r127 = Unit.INSTANCE;
            r125.setLayoutParams(r126);
            ((ArrayList) r124).add(r125);
            View r128 = (View) ListProtector.get(r109.f152506b, r120);
            int r129 = r109.f152507c;
            r109.f152507c = r129 + 1;
            r109.addView(r128, r129);
        L45:
            if (((ECNetImageView) ListProtector.get(r109.f152506b, r120)).getVisibility() == 0) goto L47;
            r109.f152507c++;
            ((ECNetImageView) ListProtector.get(r109.f152506b, r120)).setVisibility(0);
        L47:
            ECLiveImageUtils.i((SimpleDraweeView) ListProtector.get(r109.f152506b, r120), r123.getCoverUrl(), 4, 0);
            ECDraweeView r130 = r109.f152509e;
            PopStyle r131 = r107.getPopStyle();
            if (r131 == null) goto L50;
            String r132 = r131.getRightIcon();
        L51:
            com.bytedance.android.ec.core.utils.y.d(r130, r132);
            r120 = r122;
            goto L37
        L50:
            r132 = null;
        L52:
            int r133 = r109.f152507c - r109.f152508d;
            List<ECCombinationProduct> r134 = r107.getCombinationProducts();
            if (r134 != null) goto L55;
        L66:
            Query r135 = r101.w().b(R.id.layout_tryon);
            if (ECLiveABUtils.INSTANCE.getECOM_TRYON_CLICK_AREA().booleanValue() == false) goto L71;
            View r136 = r135.f();
            ViewGroup.LayoutParams r137 = r136.getLayoutParams();
            if (r137 == null) goto L71;
            r137.width = -2;
            r136.setLayoutParams(r137);
        L71:
            ECPromotionPopHeader r138 = r100.popHeader;
            if (r138 != null) goto L74;
            r135.c();
            return;
        L74:
            if ((!Intrinsics.areEqual(r100.getPromotionId(), r101.f152399h)) == false) goto L93;
            r101.f152399h = r100.getPromotionId();
            int r139 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.f152313a;
            ExplainCardViewModel r140 = r101.f152468e;
            if (r140 == null) goto L80;
            ml.b r141 = r140.getLiveRoomInfo();
            if (r141 == null) goto L80;
            String r142 = r141.roomId();
        L81:
            ExplainCardViewModel r143 = r101.f152468e;
            if (r143 == null) goto L86;
            Function0<Map<String, Map<String, String>>> r144 = r143.getEventPassthroughParams();
            if (r144 == null) goto L86;
            Map<String, Map<String, String>> r145 = r144.invoke();
        L87:
            ExplainCardViewModel r146 = r101.f152468e;
            if (r146 == null) goto L90;
            RoomContextController r147 = r146.getRoomContextController();
        L91:
            Intrinsics.checkNotNullParameter(r100, "uiPromotion");
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.a("ECCardBannerExplainStatusShowEvent", new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.f(r100, ControllerExtensionsKt.c(r147, r142), r145));
            goto L93
        L90:
            r147 = null;
        L86:
            r145 = null;
        L80:
            r142 = null;
        L93:
            if (r135.d() == true) goto L95;
            r135.g(0);
        L95:
            ECNetImageView r148 = (ECNetImageView) r135.b(R.id.iv_tryon_right).f();
            ECUrlModel r149 = r138.getRightIcon();
            if (r149 != null) goto L98;
            r148.setVisibility(8);
        L99:
            ECNetImageView r150 = (ECNetImageView) r135.b(R.id.iv_tryon_left).f();
            ECUrlModel r151 = r138.getLeftIcon();
            if (r151 != null) goto L102;
            r150.setVisibility(8);
        L103:
            Query r152 = r135.b(R.id.tv_tryon_text);
            String r153 = r138.getText();
            if (r153 != null) goto L106;
            r153 = "";
        L106:
            r152.e(r153);
            r135.f().setOnClickListener(new n(r138, r101, r100));
            return;
        L102:
            r150.setVisibility(0);
            ECLiveImageUtils.c(r150, r151, true, null);
            goto L103
        L98:
            r148.setVisibility(0);
            ECLiveImageUtils.c(r148, r149, true, null);
            goto L99
        L55:
            if (r133 <= r134.size()) goto L57;
            boolean r154 = true;
        L58:
            if (r154 == true) goto L61;
            r134 = null;
        L61:
            if (r134 == null) goto L66;
            int r155 = r134.size();
        L63:
            if (r155 >= r133) goto L66;
            r109.f152507c--;
            ((ECNetImageView) ListProtector.get(r109.f152506b, r155)).setVisibility(8);
            r155 = r155 + 1;
            goto L63
        L57:
            r154 = false;
            goto L58
        L29:
            r116 = null;
            goto L30
        L65:
            r100.setShowCombination(false);
            r101.w().b(R.id.cv_ec_combination).c();
            goto L66
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BackgroundPresenter f152402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c f152403b;

        public b(BackgroundPresenter r100, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r101) {
            this.f152402a = r100;
            this.f152403b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            pk2.d r101 = (pk2.d) r100;
            View r102 = this.f152402a.w().b(R.id.fl_ec_main_image).f();
            if (r101.f529590b != 2) goto L6;
            r102.setPivotX(UtilityKotlinExtentionsKt.c(4));
            r102.setPivotY(UtilityKotlinExtentionsKt.c(4));
            r102.setBackgroundColor(-1);
            r102.animate().scaleX(0.25f).scaleY(0.25f).setDuration(500).setInterpolator(new FastOutSlowInInterpolator()).start();
        L6:
            if (r101.f529590b != 0) goto L9;
            r102.animate().cancel();
            r102.setScaleX(1.0f);
            r102.setScaleY(1.0f);
            r102.setBackgroundColor(0);
            return;
        }
    }

    public BackgroundPresenter() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        ExplainCardViewModel r101 = this.f152468e;
        if (r101 == null) goto L5;
        r101.getPromotionState().b(r100.getLifecycleOwner(), new a(this, r100));
        r101.getCardExtendInfoState().b(r100.getLifecycleOwner(), new b(this, r100));
    L5:
        com.bytedance.android.ec.core.widget.f.c(w().b(R.id.cv_ec_combination).f(), null, "bind_key_live_cart_card", new BackgroundPresenter$bind$2(this), 1);
    }
}
