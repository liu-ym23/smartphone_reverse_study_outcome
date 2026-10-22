package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.content.Context;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.widget.AuctionHotAtmosphereView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionCountdownAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionCurrentUserInfo;
import com.bytedance.android.ec.model.response.ECAuctionDigitalAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionInfo;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.AuctionV2CardAtmosphereHelper;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.newauction.AuctionBidPriceAreaView;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.newauction.AuctionButtonView;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.newauction.AuctionStatusView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.generic.RoundingParams;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class AuctionV2CardPresenter extends p {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f152390l = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f152391g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AuctionV2CardAtmosphereHelper f152392h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DisposableScope f152393i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f152394j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f152395k;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AuctionV2CardPresenter f152396a;

        public b(AuctionV2CardPresenter r100) {
            this.f152396a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            ECUIPromotion r111 = (ECUIPromotion) r110;
            if (r111 == null) goto L94;
            boolean r100 = true;
            if (r111.isAuctionV2() != true) goto L94;
            this.f152396a.u().d().q(rk2.c.class, 0);
            AuctionV2CardPresenter r101 = this.f152396a;
            if (r101.f152391g == true) goto L9;
            th.a.c(this.f152396a.u().c(), R.layout.ec_explain_card_uimodule_auction_v2, (ViewGroup) r101.w().f(), true);
            this.f152396a.f152391g = true;
        L9:
            final AuctionV2CardPresenter r102 = this.f152396a;
            r102.getClass();
            String r103 = r111.imageUrl;
            if (r103 == null) goto L12;
            ECDraweeView r104 = (ECDraweeView) r102.w().b(R.id.card_main_image).f();
            float r105 = UtilityKotlinExtentionsKt.c(14);
            r104.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(r105, r105, 0.0f, 0.0f));
            h0.e(r104, r103, new com.bytedance.android.ec.core.imagex.r("ec_live", "auction_card_view"), null, null, 120);
        L12:
            r102.I(r111.auctionV2);
            r102.G(r111.auctionV2);
            ECAuctionInfo r106 = r111.auctionV2;
            if (r106 == null) goto L15;
            AuctionBidPriceAreaView r107 = (AuctionBidPriceAreaView) r102.w().b(R.id.card_bid_price_area).f();
            Intrinsics.checkNotNullParameter(r106, "auctionInfo");
            r107.f152519e.getValue().c(Long.valueOf(r106.getPrice()));
            r107.f152520f.getValue().c(r106);
        L15:
            AuctionHotAtmosphereView r108 = (AuctionHotAtmosphereView) r102.w().b(R.id.card_hot_atmosphere).f();
            ECAuctionAtmosphere r109 = r111.auctionAtmosphere;
            if (r109 == null) goto L83;
            AuctionV2CardAtmosphereHelper r112 = r102.f152392h;
            ECAuctionCountdownAtmosphere r113 = null;
            if (r112 != null) goto L26;
            String r114 = r102.f152394j;
            String r115 = r102.f152395k;
            ExplainCardViewModel r116 = r102.f152468e;
            if (r116 == null) goto L22;
            com.bytedance.android.ec.common.api.jump.model.a r117 = r116.buildAuctionV2PromotionParams(r111);
        L23:
            if (r117 != null) goto L25;
            r117 = com.bytedance.android.ec.common.api.jump.model.b.f42853a;
        L25:
            r102.f152392h = new AuctionV2CardAtmosphereHelper(r114, r115, r108, r117);
        L33:
            AuctionV2CardAtmosphereHelper r118 = r102.f152392h;
            if (r118 == null) goto L37;
            com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.f153222a.b(r118);
        L37:
            if (r109.getDigital() == null) goto L39;
        L53:
            AuctionV2CardAtmosphereHelper r119 = r102.f152392h;
            if (r119 == null) goto L86;
            Intrinsics.checkNotNullParameter(r109, "auctionAtmosphere");
            r119.f152293a = r109;
            r119.f152295c = false;
            Runnable r120 = r119.f152296d;
            if (r120 == null) goto L58;
            UtilityKotlinExtentionsKt.f153057b.removeCallbacks(r120);
        L58:
            r119.f152296d = null;
            r119.f152299g.setVisibility(4);
            ECAuctionAtmosphere r121 = r119.f152293a;
            if (r121 == null) goto L61;
            ECAuctionDigitalAtmosphere r122 = r121.getDigital();
        L62:
            ECAuctionAtmosphere r123 = r119.f152293a;
            if (r123 == null) goto L65;
            r113 = r123.getCountDown();
        L65:
            dm.a.b r124 = dm.a.a("AuctionV2");
            StringBuilder r125 = new StringBuilder("show auction atmosphere, has digital=");
            if (r122 == null) goto L68;
            boolean r126 = true;
        L69:
            r125.append(r126);
            r125.append(", has count down=");
            if (r113 != null) goto L73;
            r100 = false;
        L73:
            r125.append(r100);
            r124.i(r125.toString());
            if (r122 != null) goto L76;
            if (r113 != null) goto L86;
        L76:
            if (r122 == null) goto L79;
            if (r113 != null) goto L79;
            r119.b(r122);
        L79:
            if (r122 == null) goto L82;
            if (r113 == null) goto L82;
            r119.b(r122);
        L82:
            r119.f152299g.setVisibility(4);
            goto L86
        L68:
            r126 = false;
            goto L69
        L61:
            r122 = null;
        L86:
            r102.w().b(R.id.iv_card_close).f().setOnClickListener(new AuctionV2CardPresenter$bindClick$1(r102));
            ((AuctionButtonView) r102.w().b(R.id.card_btn).f()).setOnClickListener(new j(r102));
            r102.w().f().setOnClickListener(new k(r102));
            if (r102.F(r111.auctionV2) == false) goto L89;
            r102.I(r111.auctionV2);
            r102.G(r111.auctionV2);
        L89:
            ExplainCardViewModel r127 = this.f152396a.f152468e;
            if (r127 == null) goto L96;
            QLiveData<bk2.a<Unit>> r128 = r127.getShowCardAction();
            if (r128 == null) goto L97;
            r128.g(new bk2.a(Unit.INSTANCE));
            return;
        L97:
            return;
        L96:
            return;
        L39:
            if (r109.getCountDown() != null) goto L53;
            int r129 = zg2.a.f572040a;
            ExplainCardViewModel r130 = r102.f152468e;
            if (r130 == null) goto L45;
            ml.b r131 = r130.getLiveRoomInfo();
            if (r131 == null) goto L45;
            String r132 = r131.roomId();
        L46:
            ExplainCardViewModel r133 = r102.f152468e;
            if (r133 == null) goto L51;
            RoomContextController r134 = r133.getRoomContextController();
            if (r134 == null) goto L51;
            String r135 = r134.D();
        L52:
            zg2.a.a(r132, r135, Action.GOODS_CARD_HOT_ATMOSPHERE_DATA_ERR, null);
        L51:
            r135 = null;
        L45:
            r132 = null;
            goto L46
        L22:
            r117 = null;
            goto L23
        L26:
            ExplainCardViewModel r136 = r102.f152468e;
            if (r136 == null) goto L29;
            com.bytedance.android.ec.common.api.jump.model.a r137 = r136.buildAuctionV2PromotionParams(r111);
        L30:
            if (r137 != null) goto L32;
            r137 = com.bytedance.android.ec.common.api.jump.model.b.f42853a;
        L32:
            Intrinsics.checkNotNullParameter(r137, "<set-?>");
            r112.f152300h = r137;
            goto L33
        L29:
            r137 = null;
            goto L30
        L83:
            AuctionV2CardAtmosphereHelper r138 = r102.f152392h;
            if (r138 == null) goto L86;
            r138.f152299g.setVisibility(4);
            Unit r139 = Unit.INSTANCE;
        L94:
            this.f152396a.u().d().q(rk2.c.class, 8);
            this.f152396a.clear();
        }
    }

    static {
    }

    public final void clear() {
        if (this.f152391g == false) goto L18;
        AuctionV2CardAtmosphereHelper r100 = this.f152392h;
        if (r100 == null) goto L7;
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.f153222a.c(r100);
    L7:
        AuctionV2CardAtmosphereHelper r101 = this.f152392h;
        if (r101 == null) goto L16;
        Runnable r102 = r101.f152296d;
        if (r102 == null) goto L12;
        UtilityKotlinExtentionsKt.f153057b.removeCallbacks(r102);
    L12:
        Runnable r103 = r101.f152296d;
        if (r103 == null) goto L15;
        UtilityKotlinExtentionsKt.f153057b.removeCallbacks(r103);
    L15:
        r101.f152296d = null;
    L16:
        AuctionStatusView r104 = (AuctionStatusView) w().b(R.id.card_auction_status).f();
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.f153222a.c(r104);
        r104.f152529f = null;
        this.f152393i.clearDisposable();
        return;
    }

    public AuctionV2CardPresenter() {
        this.f152393i = new DisposableScope();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p, com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        clearDisposable();
        clear();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        ExplainCardViewModel r101 = this.f152468e;
        String r102 = null;
        if (r101 == null) goto L7;
        RoomContextController r103 = r101.getRoomContextController();
        if (r103 == null) goto L7;
        String r104 = r103.B();
    L8:
        this.f152394j = r104;
        ExplainCardViewModel r105 = this.f152468e;
        if (r105 == null) goto L13;
        RoomContextController r106 = r105.getRoomContextController();
        if (r106 == null) goto L13;
        r102 = r106.D();
    L13:
        this.f152395k = r102;
        ExplainCardViewModel r107 = this.f152468e;
        if (r107 == null) goto L19;
        QLiveData<ECUIPromotion> r108 = r107.getPromotionState();
        if (r108 == null) goto L20;
        r108.b(r100.getLifecycleOwner(), new b(this));
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r104 = null;
        goto L8
    }

    public final boolean F(ECAuctionInfo r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (((AuctionStatusView) w().b(R.id.card_auction_status).f()).S5(null) == true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void G(ECAuctionInfo r110) {
        if (r110 == null) goto L47;
        AuctionButtonView r100 = (AuctionButtonView) w().b(R.id.card_btn).f();
        Intrinsics.checkNotNullParameter(r110, "auctionInfo");
        Long r101 = Long.valueOf(r110.getStatus());
        if (r101.longValue() > 2) goto L7;
        boolean r102 = true;
    L8:
        String r103 = null;
        if (r102 == true) goto L13;
        r101 = null;
    L13:
        if (r101 == null) goto L18;
        r101.longValue();
        r100.f152523c.setTextColor(com.bytedance.android.ec.core.utils.s.a("#FFFFFFFF", -1));
        if (Build.VERSION.SDK_INT < 24) goto L17;
        r100.setBackground(th.a.b(r100.getContext(), R.drawable.ec_auction_card_button_bg_normal));
    L23:
        r100.f152522b.setVisibility(8);
        String r104 = "";
        if (r110.getStatus() != 3) goto L41;
        ECAuctionCurrentUserInfo r105 = r110.getCurrentUserInfo();
        if (r105 == null) goto L36;
        ECUrlModel r111 = r105.getUserPic();
        if (r111 == null) goto L36;
        r100.f152522b.setVisibility(0);
        r100.f152522b.getRoundingParams().setRoundAsCircle(true);
        ECDraweeView r106 = r100.f152522b;
        int r107 = com.bytedance.android.ec.core.imagex.r.f44937h;
        h0.d(r106, r111, com.bytedance.android.ec.core.imagex.r.a.b("auction_card_button_head_icon"), null, null, null, null, 120);
        TextView r108 = r100.f152523c;
        Context r109 = r100.getContext();
        Object[] r112 = new Object[1];
        ECAuctionCurrentUserInfo r113 = r110.getCurrentUserInfo();
        if (r113 == null) goto L32;
        r103 = r113.getUserName();
    L32:
        if (r103 == null) goto L35;
        r104 = r103;
    L35:
        r112[0] = r104;
        r108.setText(th.a.h(r109, R.string.ec_auction_success, r112));
        return;
    L36:
        r100.f152522b.setVisibility(8);
        TextView r114 = r100.f152523c;
        String r115 = r110.getButtonLabel();
        if (r115 == null) goto L40;
        r104 = r115;
    L40:
        r114.setText(r104);
        Unit r116 = Unit.INSTANCE;
        return;
    L41:
        TextView r117 = r100.f152523c;
        String r118 = r110.getButtonLabel();
        if (r118 == null) goto L45;
        r104 = r118;
    L45:
        r117.setText(r104);
        return;
    L17:
        r100.setBackgroundColor(th.a.a(r100.getContext(), R.color.shopping_color_FFFF005C));
        goto L23
    L18:
        r100.f152523c.setTextColor(com.bytedance.android.ec.core.utils.s.a("#80FFFFFF", -1));
        if (Build.VERSION.SDK_INT < 24) goto L21;
        r100.setBackground(th.a.b(r100.getContext(), R.drawable.ec_auction_card_button_bg_finish));
    L22:
        Unit r119 = Unit.INSTANCE;
        goto L23
    L21:
        r100.setBackgroundColor(th.a.a(r100.getContext(), R.color.shopping_color_80FF005C));
        goto L22
    L7:
        r102 = false;
        goto L8
    }

    public final void I(final ECAuctionInfo r100) {
        if (r100 == null) goto L8;
        AuctionStatusView r101 = (AuctionStatusView) w().b(R.id.card_auction_status).f();
        Function0<Unit> r102 = new AuctionV2CardPresenter$updateStatus$$inlined$also$lambda$1(r100, this);
        Intrinsics.checkNotNullParameter(r100, "auctionData");
        Intrinsics.checkNotNullParameter(r102, "onCountDownFinish");
        r101.f152530g = r100;
        r101.f152529f = r102;
        r101.f152525b.setVisibility(8);
        int r103 = wl.a.f560165b;
        r101.f152528e = wl.a.a(r100.getEndTime());
        r101.R5(r100);
        if (r101.S5(null) == false) goto L6;
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.f153222a.b(r101);
        return;
    L6:
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.f153222a.c(r101);
        return;
    }

    public static final void E(AuctionV2CardPresenter r100, String r110, ECUIPromotion r111) {
        r100.getClass();
        if (r111 == null) goto L47;
        ECAuctionInfo r101 = r111.auctionV2;
        if (r101 != null) goto L9;
        return;
    L9:
        if (r110.length() <= 0) goto L11;
        boolean r102 = true;
    L13:
        if (r102 == false) goto L15;
        String r103 = r110;
    L16:
        if (r103 == null) goto L46;
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("report_type", "1");
        r104.put("auction_id", String.valueOf(r101.getAuctionId()));
        r104.put("product_id", r111.getProductId());
        ExplainCardViewModel r112 = r100.f152468e;
        if (r112 == null) goto L22;
        ml.b r113 = r112.getLiveRoomInfo();
        if (r113 == null) goto L22;
        String r114 = r113.roomId();
    L24:
        if (r114 != null) goto L26;
        r114 = "";
    L26:
        r104.put("room_id", r114);
        ExplainCardViewModel r115 = r100.f152468e;
        if (r115 == null) goto L31;
        ml.b r116 = r115.getLiveRoomInfo();
        if (r116 == null) goto L31;
        String r117 = r116.c();
    L32:
        if (r117 != null) goto L34;
        String r105 = "";
    L35:
        ExplainCardViewModel r118 = r100.f152468e;
        if (r118 == null) goto L40;
        ml.b r119 = r118.getLiveRoomInfo();
        if (r119 == null) goto L40;
        String r120 = r119.d();
    L41:
        if (r120 != null) goto L43;
        String r106 = "";
    L44:
        com.bytedance.android.ec.core.async.a.a(vi2.h.e(null, null, r110, new vi2.v(r106, r105, r104, MapsKt.mapOf(TuplesKt.to("Agw-Js-Conv", "str")), r110)).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(l.f152462a, m.f152463a), r100.f152393i);
        return;
    L43:
        r106 = r120;
    L40:
        r120 = null;
        goto L41
    L34:
        r105 = r117;
    L31:
        r117 = null;
    L22:
        r114 = null;
        goto L24
    L46:
        return;
    L15:
        r103 = null;
        goto L16
    L11:
        r102 = false;
        goto L13
    }
}
