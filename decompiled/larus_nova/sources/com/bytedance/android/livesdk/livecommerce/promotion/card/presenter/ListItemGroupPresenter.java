package com.bytedance.android.livesdk.livecommerce.promotion.card.presenter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.widget.ECConstrainLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.promotion.ECUILotteryInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.promotion.card.Decision;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.module.ListItemBottomModule;
import com.bytedance.android.livesdk.livecommerce.promotion.card.module.ListItemButtonModule;
import com.bytedance.android.livesdk.livecommerce.promotion.card.module.ListItemImageAreaModule;
import com.bytedance.android.livesdk.livecommerce.promotion.card.module.ListItemInfoWidgetContainer;
import com.bytedance.android.livesdk.livecommerce.promotion.card.module.ListItemPriceAreaModule;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECSalePointView;
import com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECTagAndSalePointWidget;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mh2.q;

/* JADX INFO: loaded from: classes10.dex */
public final class ListItemGroupPresenter extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public hj2.h f150179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.promotion.card.i f150180f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f150181g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f150182h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f150183i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LivePromotionCardArgs f150184j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<PromotionCardModuleName, Integer> f150185k;

    public final void E() {
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r100 = this.f150180f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L5:
        ECUIPromotion r101 = r100.f150059a.f42855a;
        int r102 = r101.getIronIndex();
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r103 = this.f150184j.f150037a;
        if (r103 == null) goto L8;
        String r104 = r103.a(ListItemGroupPresenter$onClick$btm$1.INSTANCE, r102);
    L9:
        String r105 = r104;
        if (r105 != null) goto L12;
        String r106 = "";
    L13:
        BtmItemBuilder r107 = new BtmItemBuilder(r106, Boolean.TRUE).withView(y());
        com.bytedance.android.btm.api.model.d r110 = BtmUtilsKt.e(r105, PageFinder.via(y()));
        LivePromotionCardArgs r108 = this.f150184j;
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r109 = this.f150180f;
        if (r109 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L16:
        LivePromotionCardArgs.b(r108, r109.f150059a, "blank", r105, r107, y(), 4);
        jf.d r111 = this.f150184j.f150098g;
        Context r112 = u().c();
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r113 = this.f150180f;
        if (r113 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L19:
        jf.d.b.a(r111, r112, "blank", r113.f150059a.f42856b, r110, null, y(), null, 192);
        xh.c.a("Live").d("good_list", "cell_blank", MapsKt.mapOf(new Pair[]{TuplesKt.to("promotion_id", r101.getPromotionId()), TuplesKt.to("product_id", r101.getProductId())}));
        return;
    L12:
        r106 = r105;
        goto L13
    L8:
        r104 = null;
        goto L9
    }

    public final void F() {
        if (this.f150182h == false) goto L5;
        this.f150183i = true;
    L5:
        D(false);
        Disposable r100 = this.f150181g;
        if (r100 == null) goto L8;
        r100.dispose();
    L8:
        ((ListItemPriceAreaModule) w().b(R.id.container_price_info).f()).c();
        ((ListItemInfoWidgetContainer) w().b(R.id.ll_first_info_container).f()).d();
        ((ListItemInfoWidgetContainer) w().b(R.id.ll_second_info_container).f()).d();
        ListItemImageAreaModule r101 = (ListItemImageAreaModule) w().b(R.id.liiam_image_container).f();
    }

    public final void K() {
        boolean r100 = true;
        if (this.f150179e != null) goto L5;
        hj2.h r101 = new hj2.h(u().c(), this.f150184j);
        this.f150179e = r101;
        List<? extends ij2.b> r102 = CollectionsKt.listOf(new ListItemInfoWidgetContainer[]{(ListItemInfoWidgetContainer) w().b(R.id.ll_first_info_container).f(), (ListItemInfoWidgetContainer) w().b(R.id.ll_second_info_container).f()});
        Intrinsics.checkNotNullParameter(r102, "list");
        r101.f490052a = r102;
    L5:
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r103 = this.f150180f;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L8:
        IPromotionUIConfig.d r104 = r103.f150061c.a(PromotionCardModuleName.InfoAreaModule);
        Object r105 = null;
        if (r104 == null) goto L11;
        Boolean r106 = r104.d();
    L13:
        if (Intrinsics.areEqual(r106, Boolean.FALSE) == false) goto L22;
        hj2.h r107 = this.f150179e;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("widgetManager");
    L17:
        Iterator<T> r108 = r107.f490052a.iterator();
    L19:
        if (r108.hasNext() == false) goto L21;
        ((ij2.b) r108.next()).hide();
        goto L19
    L21:
        return;
    L22:
        hj2.h r109 = this.f150179e;
        if (r109 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("widgetManager");
    L25:
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r110 = this.f150180f;
        if (r110 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L28:
        com.bytedance.android.ec.common.api.jump.model.e r111 = r110.f150059a;
        Function2<Integer, Boolean, Unit> r112 = new ListItemGroupPresenter$updateInfoArea$2(this);
        r109.getClass();
        Intrinsics.checkNotNullParameter(r111, "data");
        Intrinsics.checkNotNullParameter(r112, "callback");
        boolean r113 = r109.f485399f.b(r111);
        boolean r114 = r109.f485400g.b(r111);
        boolean r115 = r109.f485401h.b(r111);
        boolean r116 = r109.f485402i.b(r111);
        boolean r117 = r109.f485403j.b(r111);
        ij2.c r118 = r109.f485397d;
        if (r118.b(r111) == true) goto L32;
        r118 = null;
    L32:
        if (r118 != null) goto L38;
        r118 = r109.f485398e;
        if (r118.b(r111) == true) goto L38;
        r118 = null;
    L38:
        if (r118 == null) goto L42;
        ij2.c r119 = hj2.h.a(r111, CollectionsKt.listOf(new ij2.c[]{r109.f485401h, r109.f485402i, r109.f485400g, r109.f485399f}));
        if (Intrinsics.areEqual(r119, r109.f485401h) == false) goto L50;
        ij2.c r120 = r118;
        r118 = r109.f485401h;
        r119 = r120;
    L50:
        if (r117 == false) goto L55;
        if (r118 != null) goto L53;
        r118 = r109.f485403j;
        goto L55
    L53:
        if (r119 != null) goto L55;
        r119 = r109.f485403j;
    L55:
        List r121 = CollectionsKt.listOfNotNull(new ij2.c[]{r118, r119});
        Intrinsics.checkNotNullParameter(r111, "data");
        Intrinsics.checkNotNullParameter(r121, "factoryList");
        if (r109.f490052a.isEmpty() == true) goto L83;
        Iterator r122 = r121.iterator();
        int r123 = 0;
    L60:
        if (r122.hasNext() == false) goto L79;
        ij2.c r124 = (ij2.c) r122.next();
        if (r123 >= r109.f490052a.size()) goto L79;
        if (r124.b(r111) == false) goto L60;
        ij2.a r125 = ((ij2.b) ListProtector.get(r109.f490052a, r123)).getCurrentWidget();
        if (r125 != null) goto L68;
    L72:
        ((ij2.b) ListProtector.get(r109.f490052a, r123)).b();
        r125 = r124.a(r109.f490054c, r109.f490053b);
        if (r125.a() == false) goto L77;
        ij2.b r126 = r125.getParentContainer();
        if (r126 == null) goto L77;
        r126.b();
    L77:
        ((ij2.b) ListProtector.get(r109.f490052a, r123)).a(r125);
    L78:
        ((ij2.b) ListProtector.get(r109.f490052a, r123)).show();
        r125.b(r111);
        r123 = r123 + 1;
        goto L60
    L68:
        if (Intrinsics.areEqual(r125.getType(), r124.getType()) == true) goto L71;
        r125 = null;
    L71:
        if (r125 != null) goto L78;
    L79:
        List<? extends ij2.b> r127 = r109.f490052a;
        Iterator<T> r128 = r127.subList(r123, r127.size()).iterator();
    L81:
        if (r128.hasNext() == false) goto L83;
        ((ij2.b) r128.next()).hide();
    L83:
        ECUIPromotion r129 = r111.f42855a;
        Iterator r130 = r121.iterator();
    L85:
        if (r130.hasNext() == false) goto L89;
        Object r131 = r130.next();
        if ((((ij2.c) r131) instanceof hj2.g) == false) goto L85;
        r105 = r131;
    L89:
        if (r105 == null) goto L91;
        boolean r132 = true;
    L92:
        r129.isShowUserRightsTag = r132;
        List<? extends ij2.b> r133 = r109.f490052a;
        ArrayList r134 = new ArrayList();
        Iterator<T> r135 = r133.iterator();
    L94:
        if (r135.hasNext() == false) goto L98;
        Object r136 = r135.next();
        if (((ij2.b) r136).c() == false) goto L94;
        r134.add(r136);
        goto L94
    L98:
        Integer r137 = Integer.valueOf(r134.size());
        ArrayList r138 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r134, 10));
        Iterator r139 = r134.iterator();
    L100:
        if (r139.hasNext() == false) goto L103;
        r138.add(((ij2.b) r139.next()).getCurrentWidget());
        goto L100
    L103:
        if (r138.isEmpty() == true) goto L134;
        Iterator r140 = r138.iterator();
    L107:
        if (r140.hasNext() == false) goto L134;
        ij2.a r141 = (ij2.a) r140.next();
        if ((r141 instanceof ECTagAndSalePointWidget) == false) goto L131;
        ECTagAndSalePointWidget r142 = (ECTagAndSalePointWidget) r141;
        ECSalePointView r143 = r142.f150435h;
        if (r143 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L114:
        if (r143.getVisibility() != 0) goto L116;
        boolean r144 = true;
    L117:
        if (r144 == true) goto L128;
        ECSalePointView r145 = r142.f150436i;
        if (r145 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout2");
    L122:
        if (r145.getVisibility() != 0) goto L124;
        boolean r146 = true;
    L125:
        if (r146 == true) goto L128;
        boolean r147 = false;
    L129:
        if (r147 == false) goto L131;
        boolean r148 = true;
    L132:
        if (r148 == false) goto L107;
    L135:
        r112.invoke(r137, Boolean.valueOf(r100));
        return;
    L124:
        r146 = false;
    L128:
        r147 = true;
        goto L129
    L116:
        r144 = false;
    L131:
        r148 = false;
    L134:
        r100 = false;
        goto L135
    L91:
        r132 = false;
        goto L92
    L42:
        if (r116 == false) goto L44;
        r118 = r109.f485402i;
        r119 = hj2.h.a(r111, CollectionsKt.listOf(new ij2.c[]{r109.f485401h, r109.f485399f, r109.f485400g}));
        goto L50
    L44:
        if (r115 == false) goto L46;
        r118 = r109.f485401h;
        r119 = hj2.h.a(r111, CollectionsKt.listOf(new ij2.c[]{r109.f485399f, r109.f485400g}));
        goto L50
    L46:
        if (r113 == false) goto L49;
        if (r114 == false) goto L49;
        r118 = r109.f485399f;
        r119 = r109.f485400g;
    L49:
        r118 = hj2.h.a(r111, CollectionsKt.listOf(new ij2.c[]{r109.f485399f, r109.f485400g}));
        r119 = null;
        goto L50
    L11:
        r106 = null;
        goto L13
    }

    public final void G() {
        ListItemButtonModule r100 = (ListItemButtonModule) w().b(R.id.libm_shop_cart_and_buy).f();
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r101 = this.f150180f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L5:
        r100.b(r101);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        F();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r110) {
        Boolean r100 = null;
        if ((r110 instanceof com.bytedance.android.livesdk.livecommerce.promotion.card.i) == true) goto L5;
        r110 = null;
    L5:
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r111 = (com.bytedance.android.livesdk.livecommerce.promotion.card.i) r110;
        if (r111 == null) goto L183;
        cl.d r101 = k.a();
        if (r101 == null) goto L11;
        r101.c(w().f());
    L11:
        if (this.f150182h == true) goto L14;
        this.f150182h = true;
        ((ListItemButtonModule) w().b(R.id.libm_shop_cart_and_buy).f()).setArgument(this.f150184j);
        ((ListItemImageAreaModule) w().b(R.id.liiam_image_container).f()).setArgument(this.f150184j);
        ((ListItemPriceAreaModule) w().b(R.id.container_price_info).f()).setArgument(this.f150184j);
        ((ListItemBottomModule) w().b(R.id.libm_bottom_module).f()).setArgument(this.f150184j);
        D(true);
    L14:
        this.f150180f = r111;
        ECUIPromotion r102 = r111.f150059a.f42855a;
        View r103 = y();
        Context r104 = u().c();     // Catch: Exception -> L28
        StringBuilder r105 = new StringBuilder();     // Catch: Exception -> L28
        if (r102.getIronIndex() <= 0) goto L18;
        r105.append(r102.getIronIndex() + "号商品");     // Catch: Exception -> L28
    L18:
        r105.append(r102.title);     // Catch: Exception -> L28
        ListItemPriceAreaModule r112 = (ListItemPriceAreaModule) w().b(R.id.container_price_info).f();     // Catch: Exception -> L28
        ListItemInfoWidgetContainer r113 = (ListItemInfoWidgetContainer) w().b(R.id.ll_first_info_container).f();     // Catch: Exception -> L28
        ListItemInfoWidgetContainer r114 = (ListItemInfoWidgetContainer) w().b(R.id.ll_second_info_container).f();     // Catch: Exception -> L28
        ij2.a r115 = r113.getCurrentWidget();     // Catch: Exception -> L28
        if (r115 == null) goto L21;
        String r116 = r115.getCurrentContentDescription();     // Catch: Exception -> L28
    L22:
        r105.append(r116);     // Catch: Exception -> L28
        ij2.a r117 = r114.getCurrentWidget();     // Catch: Exception -> L28
        if (r117 == null) goto L25;
        String r118 = r117.getCurrentContentDescription();     // Catch: Exception -> L28
    L26:
        r105.append(r118);     // Catch: Exception -> L28
        r105.append(com.bytedance.android.livesdk.livecommerce.utils.a.c(r102, r104, false));     // Catch: Exception -> L28
        r105.append(r112.getReadableText());     // Catch: Exception -> L28
        String r106 = r105.toString();     // Catch: Exception -> L28
    L30:
        r103.setContentDescription(r106);
        int r107 = d.f150195a[r111.f150060b.ordinal()];
        if (r107 != 1) goto L33;
        int r119 = UIConfigHelper.f150297a;
        ConstraintLayout r120 = (ConstraintLayout) w().f();
        Map<PromotionCardModuleName, Integer> r108 = this.f150185k;
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r109 = this.f150180f;
        if (r109 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L50:
        UIConfigHelper.e(r120, r108, r109.f150061c);
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r121 = this.f150180f;
        if (r121 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L53:
        final ECUIPromotion r122 = r121.f150059a.f42855a;
        ViewExtensionsKt.g(w().f(), 12.0f, 12.0f, 12.0f, 12.0f);
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r123 = this.f150180f;
        if (r123 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L56:
        IPromotionUIConfig.d r124 = r123.f150061c.a(PromotionCardModuleName.Parent);
        if (r124 == null) goto L59;
        UIConfigHelper.d(w().f(), r124);
    L59:
        View r125 = w().f();
        if (r122.isOnTopExplain() == false) goto L65;
        Drawable r126 = (Drawable) this.f150184j.f150038b.n(ILivePromotionCardContainerHandler.Scene.ExplainPromotionBackground, Reflection.getOrCreateKotlinClass(Drawable.class), null);
        if (r126 == null) goto L64;
        r125.setBackground(r126);
    L67:
        if (r122.isLottery() == false) goto L79;
        ECUILotteryInfo r127 = r122.getLotteryInfo();
        if (r127 != null) goto L71;
    L73:
        ECUILotteryInfo r128 = r122.getLotteryInfo();
        if (r128 != null) goto L76;
    L78:
        com.bytedance.android.ec.core.widget.f.c(y(), null, "bind_key_live_promotion_list", new ListItemGroupPresenter$updateItemView$4(this), 1);
    L80:
        y().setOnLongClickListener(new f(this));
        if ((y() instanceof ECConstrainLayout) == false) goto L87;
        View r129 = y();
        if (r129 == null) goto L86;
        ((ECConstrainLayout) r129).setViewOnClickListener(new ListItemGroupPresenter$updateItemView$7(this, r122));
    L88:
        ImageView r130 = (ImageView) w().b(R.id.iv_promotion_card_close).f();
        if (this.f150184j.f150038b.h(Decision.PROMOTION_CARD_CLOSE_STYLE) == false) goto L91;
        int r131 = R.drawable.ec_commerce_ic_playback_promotion_shrink;
    L92:
        r130.setImageResource(r131);
        r130.setOnClickListener(new e(this));
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r132 = this.f150180f;
        if (r132 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L95:
        ECUIPromotion r133 = r132.f150059a.f42855a;
        if (r133 == null) goto L109;
        Map<String, List<ECRitTag>> r134 = r133.getRitTag();
        if (r134 == null) goto L109;
        List<ECRitTag> r135 = r134.get("live_room_product_title_before");
        if (r135 == null) goto L109;
        Iterator<T> r136 = r135.iterator();
    L103:
        if (r136.hasNext() == false) goto L109;
        ECRitTag r137 = (ECRitTag) r136.next();
        if (r137 == null) goto L103;
        RitTagTrack r138 = r137.getTagTrack();
        if (r138 == null) goto L103;
        r138.setVisibile(true);
    L109:
        AppCompatTextView r139 = (AppCompatTextView) w().b(R.id.tv_title).f();
        Map<String, List<ECRitTag>> r140 = r133.getRitTag();
        if (r140 == null) goto L125;
        List<ECRitTag> r141 = r140.get("live_room_product_title_before");
        if (r141 == null) goto L125;
        ArrayList r142 = new ArrayList();
        Iterator<T> r143 = r141.iterator();
    L115:
        if (r143.hasNext() == false) goto L120;
        ECUrlModel r144 = ((ECRitTag) r143.next()).getTextIcon();
        if (r144 == null) goto L115;
        r142.add(r144);
        goto L115
    L120:
        if ((!r142.isEmpty()) == true) goto L123;
        r142 = null;
    L123:
        if (r142 == null) goto L125;
        this.f150181g = q.b(r142, r133.title, ((ECUrlModel) ListProtector.get(r142, 0)).getHeight(), r139, false, 96);
    L126:
        r139.setFocusable(true);
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r145 = this.f150180f;
        if (r145 != null) goto L129;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L129:
        IPromotionUIConfig.d r146 = r145.f150061c.a(PromotionCardModuleName.Title);
        if (r146 == null) goto L135;
        IPromotionUIConfig.b r147 = r146.a();
        if (r147 == null) goto L135;
        UIConfigHelper.c(r139, r147);
    L135:
        if (this.f150183i == true) goto L137;
    L139:
        I(null);
        K();
    L140:
        G();
        ListItemPriceAreaModule r148 = (ListItemPriceAreaModule) w().b(R.id.container_price_info).f();
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r149 = this.f150180f;
        if (r149 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L143:
        r148.b(r149);
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r150 = this.f150180f;
        if (r150 != null) goto L146;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L146:
        IPromotionUIConfig.d r151 = r150.f150061c.a(PromotionCardModuleName.BottomModule);
        if (r151 == null) goto L150;
        r100 = r151.d();
    L150:
        if (Intrinsics.areEqual(r100, Boolean.FALSE) == false) goto L152;
        w().b(R.id.libm_bottom_module).f().setVisibility(8);
    L156:
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r152 = this.f150180f;
        if (r152 != null) goto L159;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L159:
        ECUIPromotion r153 = r152.f150059a.f42855a;
        View r154 = w().f();
        if (r153.shouldShowFindSimilarWithOtherStore() == false) goto L162;
        r154.setAlpha(1.0f);
        return;
    L162:
        int r155 = r153.overlayType;
        if (r155 == 0) goto L167;
        if (r155 != 1) goto L192;
        r154.setAlpha(0.5f);
        return;
    L192:
        return;
    L167:
        r154.setAlpha(1.0f);
        return;
    L152:
        ListItemBottomModule r156 = (ListItemBottomModule) w().b(R.id.libm_bottom_module).f();
        r156.setVisibility(0);
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r157 = this.f150180f;
        if (r157 != null) goto L155;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L155:
        r156.a(r157);
        goto L156
    L137:
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableIdleLoadCard() == false) goto L139;
        Looper.myQueue().addIdleHandler(new g(this));
    L125:
        r139.setText(r133.title);
        goto L126
    L91:
        r131 = R.drawable.ec_common_ic_playback_promotion_card_close;
        goto L92
    L86:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.widget.ECConstrainLayout");
    L87:
        ECExceptionMonitor.e(new RuntimeException("商品卡点击监听器注册失败，可能影响购物列表进商城推荐"));
        goto L88
    L76:
        if (r128.isButtonGray() != true) goto L78;
        y().setOnClickListener(null);
        goto L80
    L71:
        if (r127.isScarceLottery() != true) goto L73;
        com.bytedance.android.ec.core.widget.f.c(y(), null, "bind_key_live_promotion_list", new ListItemGroupPresenter$updateItemView$3(this), 1);
        goto L80
    L79:
        com.bytedance.android.ec.core.widget.f.c(y(), null, "bind_key_live_promotion_list", new ListItemGroupPresenter$updateItemView$5(this), 1);
        goto L80
    L64:
        r125.setBackgroundResource(R.drawable.ec_bg_promotion_card_on_explain);
        Unit r158 = Unit.INSTANCE;
        goto L67
    L65:
        r125.setBackgroundColor(th.a.a(u().c(), R.color.shopping_std_bg_primary_white));
        goto L67
    L33:
        if (r107 != 2) goto L35;
        ListItemImageAreaModule r159 = (ListItemImageAreaModule) w().b(R.id.liiam_image_container).f();
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r160 = r159.f150130c;
        if (r160 == null) goto L187;
        r159.e(r160, true);
        return;
    L187:
        return;
    L35:
        if (r107 != 3) goto L37;
        I(r111.f150060b);
        return;
    L37:
        if (r107 != 4) goto L39;
        F();
        return;
    L39:
        if (r107 != 5) goto L191;
        G();
        return;
    L191:
        return;
    L25:
        r118 = null;
        goto L26
    L21:
        r116 = null;
    L28:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r106 = null;
        goto L30
    }

    public final void D(boolean r100) {
        int r101 = ph.b.f529227a;
        ph.b.c(w().b(R.id.tv_title).f(), r100);
        ph.b.c(w().b(R.id.ll_first_info_container).f(), r100);
        ph.b.c(w().b(R.id.ll_second_info_container).f(), r100);
        ph.b.c(w().b(R.id.container_price_info).f(), r100);
        ph.b.c(w().b(R.id.libm_shop_cart_and_buy).f(), r100);
        ph.b.c(w().b(R.id.libm_bottom_module).f(), r100);
    }

    public final void I(UpdateType r100) {
        ListItemImageAreaModule r101 = (ListItemImageAreaModule) w().b(R.id.liiam_image_container).f();
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r102 = this.f150180f;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L5:
        r101.b(r102, r100);
    }

    public ListItemGroupPresenter(LivePromotionCardArgs r100, Map<PromotionCardModuleName, Integer> r101) {
        Intrinsics.checkNotNullParameter(r100, "argument");
        Intrinsics.checkNotNullParameter(r101, "moduleIdMap");
        this.f150184j = r100;
        this.f150185k = r101;
    }
}
