package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.presenter;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.widget.ECConstrainLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.Product;
import com.bytedance.android.ec.model.response.PromotionExtendType;
import com.bytedance.android.ec.model.response.d1;
import com.bytedance.android.ec.model.response.g1;
import com.bytedance.android.ec.model.response.i0;
import com.bytedance.android.ec.model.response.j1;
import com.bytedance.android.ec.model.response.q0;
import com.bytedance.android.ec.model.response.v0;
import com.bytedance.android.ec.model.response.z0;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import com.bytedance.android.livesdk.livecommerce.promotion.card.k;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component.PromotionCardBottomComponent;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component.PromotionCardButtonComponent;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component.PromotionCardImageComponent;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component.PromotionCardInfoComponent;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component.PromotionCardPriceComponent;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component.PromotionCardTitleComponent;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.PromotionCardInfoLineContainer;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.utils.HotAtmosphereHelperV2;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import mh2.q;

/* JADX INFO: loaded from: classes10.dex */
public final class f extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.promotion.card.h f150701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f150702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f150703g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LivePromotionCardArgsV2 f150704h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a f150705i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<PromotionCardModuleName, Integer> f150706j;

    public final void E() {
        if (this.f150702f == false) goto L5;
        this.f150703g = true;
    L5:
        D(false);
        ((PromotionCardPriceComponent) w().b(R.id.container_price_info).f()).c();
        PromotionCardInfoComponent r100 = (PromotionCardInfoComponent) w().b(R.id.ll_info_container).f();
        Iterator r101 = ((ArrayList) r100.f150537a).iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        PromotionCardInfoLineContainer r102 = (PromotionCardInfoLineContainer) r101.next();
        if (r102.getVisibility() == 8) goto L7;
        r102.setVisibility(8);
        goto L7
    L11:
        Iterator r103 = ((ArrayList) r100.f150537a).iterator();
    L13:
        if (r103.hasNext() == false) goto L15;
        ((PromotionCardInfoLineContainer) r103.next()).d();
        goto L13
    L15:
        PromotionCardImageComponent r104 = (PromotionCardImageComponent) w().b(R.id.liiam_image_container).f();
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableIdleLoadCardNoImage() == false) goto L18;
        r104.f150512d.setImageBitmap(null);
        r104.f150512d.a();
    L18:
        HotAtmosphereHelperV2 r105 = r104.f150524p;
        if (r105 == null) goto L33;
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.f153222a.c(r105);
        Runnable r106 = r105.f150757h;
        if (r106 == null) goto L23;
        UtilityKotlinExtentionsKt.f153057b.removeCallbacks(r106);
    L23:
        Runnable r107 = r105.f150757h;
        if (r107 == null) goto L26;
        UtilityKotlinExtentionsKt.f153057b.removeCallbacks(r107);
    L26:
        r105.f150757h = null;
        Runnable r108 = r105.f150758i;
        if (r108 == null) goto L29;
        UtilityKotlinExtentionsKt.f153057b.removeCallbacks(r108);
    L29:
        Runnable r109 = r105.f150758i;
        if (r109 == null) goto L32;
        UtilityKotlinExtentionsKt.f153057b.removeCallbacks(r109);
    L32:
        r105.f150758i = null;
    L33:
        Disposable r110 = ((PromotionCardTitleComponent) w().b(R.id.tv_title).f()).f150551a;
        if (r110 == null) goto L43;
        r110.dispose();
        return;
    }

    public final void F() {
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r100 = this.f150701e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L5:
        ql.a r101 = r100.f150056a.f42873a;
        jj2.a r102 = null;
        if ((r101 instanceof ECUIPromotionV2) == true) goto L8;
        r101 = null;
    L8:
        ECUIPromotionV2 r103 = (ECUIPromotionV2) r101;
        if (r103 == null) goto L13;
        g1 r104 = r103.getPurchase();
        if (r104 == null) goto L13;
        r102 = new jj2.a(r104, r100.f150057b, r100.f150058c, r103.getPromotionId(), r103.getProductId(), r103.getIronIndex());
    L13:
        if (r102 == null) goto L16;
        ((PromotionCardButtonComponent) w().b(R.id.libm_shop_cart_and_buy).f()).b(r102);
        return;
    }

    public final void G() {
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r100 = this.f150701e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L5:
        ql.a r101 = r100.f150056a.f42873a;
        jj2.c r102 = null;
        if ((r101 instanceof ECUIPromotionV2) == true) goto L8;
        r101 = null;
    L8:
        ECUIPromotionV2 r103 = (ECUIPromotionV2) r101;
        if (r103 == null) goto L27;
        z0 r104 = r103.getImage();
        if (r104 == null) goto L27;
        UpdateType r105 = r100.f150057b;
        k r106 = r100.f150058c;
        String r107 = r100.f150056a.f42873a.getPromotionId();
        String r110 = r100.f150056a.f42873a.getProductId();
        boolean r111 = r100.f150056a.f42873a.isOnExplaining();
        int r112 = r100.f150056a.f42873a.getIronIndex();
        boolean r113 = r100.f150056a.f42873a.isAuction();
        ECPromotionAuctionInfo r114 = r100.f150056a.f42873a.getAuctionInfo();
        LiveRoomParams r108 = (LiveRoomParams) r100.f150056a.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r108 == null) goto L18;
        String r109 = r108.getRoomId();
        if (r109 == null) goto L18;
        String r115 = r109;
    L19:
        LiveRoomParams r116 = (LiveRoomParams) r100.f150056a.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r116 == null) goto L25;
        String r117 = r116.getRoomUniqueKey();
        if (r117 == null) goto L25;
        String r118 = r117;
    L26:
        r102 = new jj2.c(r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r118, !r100.f150056a.f42873a.getClientData().f533693b, r100.f150056a.f42873a.getHasPreferredCouponEffect());
    L25:
        r118 = "";
    L18:
        r115 = "";
    L27:
        if (r102 == null) goto L30;
        ((PromotionCardImageComponent) w().b(R.id.liiam_image_container).f()).b(r102);
        return;
    }

    public final void I() {
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r100 = this.f150701e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L5:
        IPromotionUIConfig.d r101 = r100.f150058c.a(PromotionCardModuleName.InfoAreaModule);
        if (r101 == null) goto L8;
        Boolean r102 = r101.d();
    L10:
        if (Intrinsics.areEqual(r102, Boolean.FALSE) == false) goto L18;
        Iterator r103 = ((ArrayList) ((PromotionCardInfoComponent) w().b(R.id.ll_info_container).f()).f150537a).iterator();
    L13:
        if (r103.hasNext() == false) goto L17;
        PromotionCardInfoLineContainer r104 = (PromotionCardInfoLineContainer) r103.next();
        if (r104.getVisibility() == 8) goto L13;
        r104.setVisibility(8);
        goto L13
    L17:
        return;
    L18:
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r105 = this.f150701e;
        if (r105 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L21:
        ql.a r106 = r105.f150056a.f42873a;
        if ((r106 instanceof ECUIPromotionV2) == true) goto L24;
        r106 = null;
    L24:
        ECUIPromotionV2 r107 = (ECUIPromotionV2) r106;
        int r108 = 0;
        if (r107 == null) goto L37;
        q0 r109 = r107.getBenefits();
        if (r109 == null) goto L37;
        UpdateType r110 = r105.f150057b;
        k r111 = r105.f150058c;
        Product r112 = r107.getProduct();
        if (r112 == null) goto L31;
        boolean r113 = r112.isAuction();
    L32:
        Product r114 = r107.getProduct();
        if (r114 == null) goto L35;
        long r115 = r114.getAuctionType();
    L36:
        jj2.d r116 = new jj2.d(r109, r110, r111, r113, r115);
    L38:
        if (r116 == null) goto L137;
        PromotionCardInfoComponent r117 = (PromotionCardInfoComponent) w().b(R.id.ll_info_container).f();
        Intrinsics.checkNotNullParameter(r116, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        List<i0> r118 = r116.f499302a.a();
        if (r118 == null) goto L110;
        Iterator<T> r119 = r118.iterator();
        int r120 = 0;
    L43:
        if (r119.hasNext() == false) goto L110;
        Object r121 = r119.next();
        int r122 = r120 + 1;
        if (r120 >= 0) goto L47;
        CollectionsKt.throwIndexOverflow();
    L47:
        i0 r123 = (i0) r121;
        Integer r124 = Integer.valueOf(((ArrayList) r117.f150537a).size());
        if (r124.intValue() > r120) goto L50;
        boolean r125 = true;
    L51:
        if (r125 == true) goto L54;
        r124 = null;
    L54:
        if (r124 == null) goto L101;
        r124.intValue();
        PromotionCardInfoLineContainer r126 = new PromotionCardInfoLineContainer(r117.getContext(), null, r117.f150539c, r117.f150538b, 10);
        ((ArrayList) r117.f150537a).add(r126);
        r126.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        if (r120 == 0) goto L100;
        ViewGroup.LayoutParams r127 = r126.getLayoutParams();
        if ((r127 instanceof ViewGroup.MarginLayoutParams) == true) goto L60;
        r127 = null;
    L60:
        ViewGroup.MarginLayoutParams r128 = (ViewGroup.MarginLayoutParams) r127;
        if (r128 == null) goto L63;
        r128.topMargin = UtilityKotlinExtentionsKt.d(4);
        r126.setLayoutParams(r128);
    L63:
        IPromotionUIConfig.d r129 = r116.f499304c.a(PromotionCardModuleName.InfoAreaInnerModule);
        if (r129 == null) goto L100;
        IPromotionUIConfig.c r130 = r129.b();
        if (r130 == null) goto L100;
        int r131 = UIConfigHelper.f150297a;
        Intrinsics.checkNotNullParameter(r126, "view");
        Intrinsics.checkNotNullParameter(r130, "layout");
        Integer r132 = r130.k();
        if (r132 == null) goto L70;
        int r133 = UtilityKotlinExtentionsKt.d(r132);
    L71:
        Integer r134 = r130.m();
        if (r134 == null) goto L74;
        int r135 = UtilityKotlinExtentionsKt.d(r134);
    L75:
        Integer r136 = r130.l();
        if (r136 == null) goto L78;
        int r137 = UtilityKotlinExtentionsKt.d(r136);
    L79:
        Integer r138 = r130.j();
        if (r138 == null) goto L82;
        int r139 = UtilityKotlinExtentionsKt.d(r138);
    L83:
        r126.setPadding(r133, r135, r137, r139);
        Integer r140 = r130.g();
        if (r140 == null) goto L86;
        int r141 = UtilityKotlinExtentionsKt.d(r140);
    L87:
        Integer r142 = r130.i();
        if (r142 == null) goto L90;
        int r143 = UtilityKotlinExtentionsKt.d(r142);
    L91:
        Integer r144 = r130.h();
        if (r144 == null) goto L94;
        int r145 = UtilityKotlinExtentionsKt.d(r144);
    L95:
        Integer r146 = r130.f();
        if (r146 == null) goto L98;
        int r147 = UtilityKotlinExtentionsKt.d(r146);
    L99:
        wg.a.f(r126, r141, r143, r145, r147);
        goto L100
    L98:
        r147 = 0;
        goto L99
    L94:
        r145 = 0;
        goto L95
    L90:
        r143 = 0;
        goto L91
    L86:
        r141 = 0;
        goto L87
    L82:
        r139 = 0;
        goto L83
    L78:
        r137 = 0;
        goto L79
    L74:
        r135 = 0;
        goto L75
    L70:
        r133 = 0;
    L100:
        r117.addView(r126);
    L101:
        PromotionCardInfoLineContainer r148 = (PromotionCardInfoLineContainer) CollectionsKt.getOrNull(r117.f150537a, r120);
        if (r148 == null) goto L104;
        r148.b(r123, r116.f499305d, r116.f499306e, r116.f499304c);
    L104:
        PromotionCardInfoLineContainer r149 = (PromotionCardInfoLineContainer) CollectionsKt.getOrNull(r117.f150537a, r120);
        if (r149 == null) goto L109;
        if (r149.getVisibility() == 0) goto L109;
        r149.setVisibility(0);
    L109:
        r120 = r122;
        goto L43
    L50:
        r125 = false;
    L110:
        List<i0> r150 = r116.f499302a.a();
        if (r150 == null) goto L113;
        r108 = r150.size();
    L113:
        ArrayList r151 = (ArrayList) r117.f150537a;
        Iterator r152 = r151.subList(r108, r151.size()).iterator();
    L115:
        if (r152.hasNext() == false) goto L119;
        PromotionCardInfoLineContainer r153 = (PromotionCardInfoLineContainer) r152.next();
        if (r153.getVisibility() == 8) goto L115;
        r153.setVisibility(8);
        goto L115
    L119:
        IPromotionUIConfig.d r154 = r116.f499304c.a(PromotionCardModuleName.InfoAreaModule);
        if (r154 == null) goto L138;
        UIConfigHelper.d(r117, r154);
        return;
    L138:
        return;
    L137:
        return;
    L35:
        r115 = 0;
        goto L36
    L31:
        r113 = false;
    L37:
        r116 = null;
        goto L38
    L8:
        r102 = null;
        goto L10
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        E();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v35, types: [com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component.PromotionCardBottomComponent] */
    /* JADX WARN: Type inference failed for: r0v44, types: [com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component.PromotionCardPriceComponent] */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Float, java.lang.Number] */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.Number] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r18v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27, types: [java.lang.Object, jj2.f] */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30, types: [jj2.e] */
    /* JADX WARN: Type inference failed for: r4v56 */
    /* JADX WARN: Type inference failed for: r4v57 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [jj2.b] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r210) {
        QModel r100 = r210;
        if ((r100 instanceof com.bytedance.android.livesdk.livecommerce.promotion.card.h) == true) goto L5;
        r100 = null;
    L5:
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r101 = (com.bytedance.android.livesdk.livecommerce.promotion.card.h) r100;
        if (r101 == null) goto L230;
        cl.d r102 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r102 == null) goto L11;
        r102.c(w().f());
    L11:
        if (this.f150702f == true) goto L14;
        this.f150702f = true;
        ((PromotionCardButtonComponent) w().b(R.id.libm_shop_cart_and_buy).f()).setArgument(this.f150704h);
        ((PromotionCardButtonComponent) w().b(R.id.libm_shop_cart_and_buy).f()).setAbility(this.f150705i);
        ((PromotionCardImageComponent) w().b(R.id.liiam_image_container).f()).setArgument(this.f150704h);
        ((PromotionCardImageComponent) w().b(R.id.liiam_image_container).f()).setAbility(this.f150705i);
        ((PromotionCardPriceComponent) w().b(R.id.container_price_info).f()).setArgument(this.f150704h);
        ((PromotionCardPriceComponent) w().b(R.id.container_price_info).f()).setAbility(this.f150705i);
        ((PromotionCardBottomComponent) w().b(R.id.libm_bottom_module).f()).setArgument(this.f150704h);
        ((PromotionCardBottomComponent) w().b(R.id.libm_bottom_module).f()).setAbility(this.f150705i);
        ((PromotionCardInfoComponent) w().b(R.id.ll_info_container).f()).setArgument(this.f150704h);
        ((PromotionCardInfoComponent) w().b(R.id.ll_info_container).f()).setContainerAbility(this.f150705i);
        D(true);
    L14:
        this.f150701e = r101;
        int r103 = c.f150698a[r101.f150057b.ordinal()];
        if (r103 == 1) goto L28;
        if (r103 == 2) goto L24;
        if (r103 == 3) goto L23;
        if (r103 == 4) goto L22;
        if (r103 != 5) goto L27;
        F();
    L27:
        String r104 = null;
    L205:
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r105 = this.f150701e;
        if (r105 != null) goto L208;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L208:
        ql.a r106 = r105.f150056a.f42873a;
        View r107 = y();
        StringBuilder r108 = new StringBuilder();     // Catch: Exception -> L214
        if (r106.getIronIndex() <= 0) goto L212;
        r108.append(r106.getIronIndex() + "号商品");     // Catch: Exception -> L214
    L212:
        r108.append(r106.mo8154getTitle());     // Catch: Exception -> L214
        PromotionCardPriceComponent r109 = (PromotionCardPriceComponent) w().b(R.id.container_price_info).f();     // Catch: Exception -> L214
        r108.append(((PromotionCardInfoComponent) w().b(R.id.ll_info_container).f()).getInfoAreaContentDescription());     // Catch: Exception -> L214
        r108.append(r109.getReadableText());     // Catch: Exception -> L214
        String r110 = r108.toString();     // Catch: Exception -> L214
    L216:
        r107.setContentDescription(r110);
        return;
    L214:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r110 = r104;
        goto L216
    L22:
        E();
        goto L27
    L23:
        G();
        goto L27
    L24:
        PromotionCardImageComponent r111 = (PromotionCardImageComponent) w().b(R.id.liiam_image_container).f();
        jj2.c r112 = r111.f150511c;
        if (r112 == null) goto L27;
        r111.f(r112, true);
        goto L27
    L28:
        int r113 = UIConfigHelper.f150297a;
        ConstraintLayout r114 = (ConstraintLayout) w().f();
        Map<PromotionCardModuleName, Integer> r115 = this.f150706j;
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r116 = this.f150701e;
        if (r116 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L31:
        UIConfigHelper.e(r114, r115, r116.f150058c);
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r117 = this.f150701e;
        if (r117 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L34:
        ql.a r118 = r117.f150056a.f42873a;
        if ((r118 instanceof ECUIPromotionV2) == true) goto L37;
        r118 = null;
    L37:
        final ECUIPromotionV2 r119 = (ECUIPromotionV2) r118;
        boolean r120 = false;
        if (r119 != null) goto L40;
        r104 = null;
    L92:
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r121 = this.f150701e;
        if (r121 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L95:
        Object r122 = r121.f150056a.f42873a;
        if ((r122 instanceof ECUIPromotionV2) == true) goto L98;
        r122 = r104;
    L98:
        ECUIPromotionV2 r123 = (ECUIPromotionV2) r122;
        if (r123 == null) goto L103;
        j1 r124 = r123.getTitle();
        if (r124 == null) goto L103;
        ?? r125 = new jj2.f(r124, r121.f150057b, r121.f150058c);
    L104:
        if (r125 == 0) goto L150;
        List<ECRitTag> r126 = r125.f499310a.c();
        if (r126 == null) goto L113;
        Iterator r127 = r126.iterator();
    L109:
        if (r127.hasNext() == false) goto L113;
        RitTagTrack r128 = ((ECRitTag) r127.next()).getTagTrack();
        if (r128 == null) goto L109;
        r128.setVisibile(true);
    L113:
        PromotionCardTitleComponent r129 = (PromotionCardTitleComponent) w().b(R.id.tv_title).f();
        Intrinsics.checkNotNullParameter(r125, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        String r130 = r125.f499310a.b();
        List<ECRitTag> r131 = r125.f499310a.c();
        int r132 = (int) r125.f499310a.a();
        if (r131 == null) goto L143;
        ArrayList r133 = new ArrayList();
        Iterator r134 = r131.iterator();
    L117:
        if (r134.hasNext() == false) goto L121;
        ECUrlModel r135 = ((ECRitTag) r134.next()).getTextIcon();
        if (r135 == null) goto L117;
        r133.add(r135);
        goto L117
    L121:
        boolean r136 = !r133.isEmpty();
        ?? r137 = r133;
        if (r136 == true) goto L125;
        r137 = r104;
    L125:
        if (r137 == 0) goto L143;
        ECUrlModel r138 = (ECUrlModel) CollectionsKt.getOrNull(r137, 0);
        if (r138 == null) goto L129;
        float r139 = r138.getHeight();
    L130:
        IPromotionUIConfig.d r140 = r125.f499312c.a(PromotionCardModuleName.TitleTag);
        if (r140 == null) goto L142;
        IPromotionUIConfig.b r141 = r140.a();
        if (r141 == null) goto L142;
        ?? r142 = Float.valueOf(r141.c());
        if (r142.floatValue() <= 0) goto L137;
        r120 = true;
    L137:
        if (r120 == true) goto L140;
        r142 = r104;
    L140:
        if (r142 == 0) goto L142;
        r139 = r139 * r142.floatValue();
    L142:
        r129.f150551a = q.b(r137, r130, r139, r129, true, 64);
    L144:
        r129.setMaxLines(r132);
        r129.setFocusable(true);
        IPromotionUIConfig.d r143 = r125.f499312c.a(PromotionCardModuleName.Title);
        if (r143 == null) goto L150;
        IPromotionUIConfig.b r144 = r143.a();
        if (r144 == null) goto L150;
        UIConfigHelper.c(r129, r144);
        goto L150
    L129:
        r139 = 0.0f;
    L143:
        r129.setText(r130);
        Unit r145 = Unit.INSTANCE;
    L150:
        if (this.f150703g == true) goto L152;
    L165:
        G();
        I();
    L166:
        F();
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r146 = this.f150701e;
        if (r146 != null) goto L169;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L169:
        Object r147 = r146.f150056a.f42873a;
        if ((r147 instanceof ECUIPromotionV2) == true) goto L172;
        r147 = r104;
    L172:
        ECUIPromotionV2 r148 = (ECUIPromotionV2) r147;
        if (r148 == null) goto L177;
        d1 r149 = r148.getPrice();
        if (r149 == null) goto L177;
        ?? r150 = new jj2.e(r149, r146.f150057b, r146.f150058c);
    L178:
        if (r150 == 0) goto L180;
        ((PromotionCardPriceComponent) w().b(R.id.container_price_info).f()).b(r150);
    L180:
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r151 = this.f150701e;
        if (r151 != null) goto L183;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L183:
        IPromotionUIConfig.d r152 = r151.f150058c.a(PromotionCardModuleName.BottomModule);
        if (r152 == null) goto L186;
        Object r153 = r152.d();
    L188:
        if (Intrinsics.areEqual(r153, Boolean.FALSE) == false) goto L190;
        w().b(R.id.libm_bottom_module).f().setVisibility(8);
        goto L205
    L190:
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r154 = this.f150701e;
        if (r154 != null) goto L193;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L193:
        Object r155 = r154.f150056a.f42873a;
        if ((r155 instanceof ECUIPromotionV2) == true) goto L196;
        r155 = r104;
    L196:
        ECUIPromotionV2 r156 = (ECUIPromotionV2) r155;
        if (r156 == null) goto L201;
        v0 r157 = r156.getExtend();
        if (r157 == null) goto L201;
        ?? r158 = new jj2.b(r157, r154.f150057b, r154.f150058c, r156.getIronIndex());
    L202:
        if (r158 == 0) goto L204;
        ((PromotionCardBottomComponent) w().b(R.id.libm_bottom_module).f()).a(r158);
        goto L205
    L204:
        w().b(R.id.libm_bottom_module).f().setVisibility(8);
        Unit r159 = Unit.INSTANCE;
    L201:
        r158 = r104;
        goto L202
    L186:
        r153 = r104;
    L177:
        r150 = r104;
        goto L178
    L152:
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableIdleLoadCard() == false) goto L165;
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r160 = this.f150701e;
        if (r160 != null) goto L156;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L156:
        Object r161 = r160.f150056a.f42873a;
        if ((r161 instanceof ECUIPromotionV2) == true) goto L159;
        r161 = r104;
    L159:
        ECUIPromotionV2 r162 = (ECUIPromotionV2) r161;
        if (r162 == null) goto L164;
        z0 r163 = r162.getImage();
        if (r163 == null) goto L164;
        ((PromotionCardImageComponent) w().b(R.id.liiam_image_container).f()).d(r163);
    L164:
        Looper.myQueue().addIdleHandler(new e(this));
    L103:
        r125 = r104;
        goto L104
    L40:
        v0 r164 = r119.getExtend();
        if (r164 == null) goto L43;
        PromotionExtendType r165 = r164.e();
    L45:
        if (r165 == PromotionExtendType.GENERAL_BANNER) goto L60;
        v0 r166 = r119.getExtend();
        if (r166 == null) goto L49;
        PromotionExtendType r167 = r166.e();
    L51:
        if (r167 == PromotionExtendType.COMBINATION) goto L60;
        v0 r168 = r119.getExtend();
        if (r168 == null) goto L55;
        PromotionExtendType r169 = r168.e();
    L57:
        if (r169 == PromotionExtendType.GIVEN) goto L60;
        boolean r170 = false;
    L61:
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r171 = this.f150701e;
        if (r171 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L64:
        IPromotionUIConfig.d r172 = r171.f150058c.a(PromotionCardModuleName.Parent);
        if (r172 == null) goto L67;
        UIConfigHelper.d(w().f(), r172);
    L67:
        List r173 = (List) this.f150704h.f150038b.n(ILivePromotionCardContainerHandler.Scene.ExplainPromotionBackgroundRadius, Reflection.getOrCreateKotlinClass(List.class), null);
        if (r173 == null) goto L70;
        Object r174 = CollectionsKt.firstOrNull(r173);
    L72:
        if ((r174 instanceof Integer) == true) goto L74;
        r174 = null;
    L74:
        Integer r175 = (Integer) r174;
        if (r175 == null) goto L77;
        int r176 = r175.intValue();
    L78:
        float r177 = r176;
        ViewExtensionsKt.g(w().f(), r177, r177, r177, r177);
        View r178 = w().f();
        if (r119.isOnTopExplaining() != true) goto L81;
        GradientDrawable r179 = new GradientDrawable();
        r179.setShape(0);
        r179.setOrientation(GradientDrawable.Orientation.TL_BR);
        r179.setGradientType(0);
        r179.setColors(new int[]{th.a.a(u().c(), R.color.shopping_color_FFFEC5C7), th.a.a(u().c(), R.color.shopping_color_FFFEC5C7), th.a.a(u().c(), R.color.shopping_color_FFFEC5C7), th.a.a(u().c(), R.color.shopping_color_FFFFE3B9), th.a.a(u().c(), R.color.shopping_color_FFFEC5C4), th.a.a(u().c(), R.color.shopping_color_FFFEC5C4)});
        r179.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(Integer.valueOf(r176)));
        GradientDrawable r180 = new GradientDrawable();
        r180.setShape(0);
        r180.setColor(th.a.a(u().c(), R.color.shopping_color_FFFEF3F5));
        r180.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(Integer.valueOf(r176 - 1)));
        LayerDrawable r181 = new LayerDrawable(new Drawable[]{r179, r180});
        Resources r182 = Resources.getSystem();
        int r211 = MathKt.roundToInt(TypedValue.applyDimension(1, 1, WindowDisplayMetricsOverride.apply(r182, r182.getDisplayMetrics())));
        r181.setLayerInset(1, r211, r211, r211, r211);
        Intrinsics.checkNotNullParameter(r178, "$this$setBackgroundCompat");
        r178.setBackground(r181);
    L82:
        r104 = null;
        com.bytedance.android.ec.core.widget.f.c(y(), null, "bind_key_live_promotion_list", new PromotionCardGroupPresenter$updateItemView$3(this), 1);
        y().setOnLongClickListener(new d(this));
        if ((y() instanceof ECConstrainLayout) == false) goto L89;
        View r183 = y();
        if (r183 == null) goto L88;
        ((ECConstrainLayout) r183).setViewOnClickListener(new PromotionCardGroupPresenter$updateItemView$5(this, r119));
    L90:
        if (r170 == false) goto L92;
        y().setPadding(y().getPaddingLeft(), y().getPaddingTop(), y().getPaddingRight(), 0);
        goto L92
    L88:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.widget.ECConstrainLayout");
    L89:
        ECExceptionMonitor.e(new RuntimeException("商品卡点击监听器注册失败，可能影响购物列表进商城推荐"));
        goto L90
    L81:
        r178.setBackgroundColor(th.a.a(u().c(), R.color.shopping_std_bg_primary_white));
        goto L82
    L77:
        r176 = 16;
        goto L78
    L70:
        r174 = null;
        goto L72
    L55:
        r169 = null;
        goto L57
    L49:
        r167 = null;
    L60:
        r170 = true;
        goto L61
    L43:
        r165 = null;
        goto L45
    }

    public final void D(boolean r100) {
        int r101 = ph.b.f529227a;
        ph.b.c(w().b(R.id.tv_title).f(), r100);
        ph.b.c(w().b(R.id.ll_info_container).f(), r100);
        ph.b.c(w().b(R.id.container_price_info).f(), r100);
        ph.b.c(w().b(R.id.libm_shop_cart_and_buy).f(), r100);
        ph.b.c(w().b(R.id.libm_bottom_module).f(), r100);
    }

    public f(LivePromotionCardArgsV2 r100, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r101, Map<PromotionCardModuleName, Integer> r102) {
        Intrinsics.checkNotNullParameter(r100, "argument");
        Intrinsics.checkNotNullParameter(r101, "containerAbility");
        Intrinsics.checkNotNullParameter(r102, "moduleIdMap");
        this.f150704h = r100;
        this.f150705i = r101;
        this.f150706j = r102;
    }
}
