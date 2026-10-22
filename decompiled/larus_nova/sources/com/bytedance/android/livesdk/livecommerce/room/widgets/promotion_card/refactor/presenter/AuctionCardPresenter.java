package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.os.Build;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.bytedance.android.ec.core.widget.ECAuctionStatusLayout;
import com.bytedance.android.ec.core.widget.ECHotAtmosphereView;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.CurrentUserInfo;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.RoundingParams;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class AuctionCardPresenter extends p {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f152382l = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f152383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i f152384h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ECAuctionStatusLayout f152385i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f152386j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f152387k;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AuctionCardPresenter f152388a;

        public b(AuctionCardPresenter r100) {
            this.f152388a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            ECUIPromotion r111 = (ECUIPromotion) r110;
            if (r111 == null) goto L5;
            String r100 = r111.getPromotionId();
        L7:
            if ((!Intrinsics.areEqual(r100, this.f152388a.f152387k)) == false) goto L9;
            this.f152388a.f152386j = false;
        L9:
            if (r111 != null) goto L11;
        L65:
            this.f152388a.u().d().q(rk2.b.class, 8);
            return;
        L11:
            if (r111.isAuction() != true) goto L65;
            this.f152388a.u().d().q(rk2.b.class, 0);
            final AuctionCardPresenter r101 = this.f152388a;
            ECPromotionAuctionInfo r102 = r111.campaign.auctionInfo;
            ViewGroup r103 = (ViewGroup) r101.w().f();
            if (r103.getChildCount() != 0) goto L15;
            th.a.c(r101.u().c(), R.layout.ec_explain_card_uimodule_auction, r103, true);
        L15:
            ExplainCardViewModel r104 = r101.f152468e;
            if (r104 == null) goto L20;
            QLiveData<bk2.a<Unit>> r105 = r104.getShowCardAction();
            if (r105 == null) goto L20;
            r105.g(new bk2.a(Unit.INSTANCE));
        L20:
            r101.F(r102);
            String r112 = r111.imageUrl;
            if (r112 == null) goto L23;
            float r106 = UtilityKotlinExtentionsKt.c(14);
            ECNetImageView r107 = (ECNetImageView) r101.w().b(R.id.iv_ec_main_image).f();
            r107.setController(Fresco.newDraweeControllerBuilder().setControllerListener(new g(r101)).build());
            r107.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(r106, r106, 0.0f, 0.0f));
            r107.setImageURI(r112);
            r107.getHierarchy().setPlaceholderImage(R.drawable.ec_live_promotion_list_loading_bg);
        L23:
            r101.G(r102);
            Query r113 = r101.w().b(R.id.layout_auction_info_hide);
            Query r108 = r101.w().b(R.id.layout_auction_info_show);
            if (r101.f152383g != null) goto L27;
            final int r109 = th.a.a(r101.u().c(), R.color.ec_color_black_161823);
            Query r114 = r113.b(R.id.tv_info_price);
            ((PriceView) r114.f()).C(new AuctionCardPresenter$updateBidInfo$$inlined$apply$lambda$1(r109));
            Unit r115 = Unit.INSTANCE;
            Query r116 = r108.b(R.id.tv_info_price);
            ((PriceView) r116.f()).C(new AuctionCardPresenter$updateBidInfo$$inlined$apply$lambda$2(r109));
            r101.f152383g = new h(r114, r116);
        L27:
            if (r101.f152384h != null) goto L29;
            r101.f152384h = new i(r113.b(R.id.layout_info_user_row), r108.b(R.id.layout_info_user_row));
        L29:
            Long r117 = r102.getPrice();
            if (r117 == null) goto L34;
            long r118 = r117.longValue();
            h r119 = r101.f152383g;
            if (r119 == null) goto L34;
            r119.c(Long.valueOf(r118));
        L34:
            final Ref.ObjectRef r120 = new Ref.ObjectRef();
            r120.element = null;
            final Ref.ObjectRef r121 = new Ref.ObjectRef();
            T r122 = (T) r102.getPriceLabel();
            if (r122 != null) goto L37;
            r122 = (T) "";
        L37:
            r121.element = r122;
            Integer r123 = r102.getStatus();
            if (r123 != null) goto L41;
        L61:
            i r124 = r101.f152384h;
            if (r124 == null) goto L64;
            r124.c(new Pair((CharSequence) r121.element, (String) r120.element));
        L64:
            r101.E(r102);
            r101.w().b(R.id.iv_close).a(new f(r101));
            com.bytedance.android.ec.core.widget.f.c(r101.w().b(R.id.layout_bottom).f(), null, "bind_key_live_cart_card", new AuctionCardPresenter$bindClick$2(r101), 1);
            com.bytedance.android.ec.core.widget.f.c(r101.w().b(R.id.iv_ec_main_image).f(), null, "bind_key_live_cart_card", new AuctionCardPresenter$bindClick$3(r101), 1);
            return;
        L41:
            if (r123.intValue() != 2) goto L61;
            CurrentUserInfo r125 = r102.getCurrentUserInfo();
            if (r125 == null) goto L61;
            ECUrlModel r126 = r125.getUserPic();
            if (r126 == null) goto L49;
            List<String> r127 = r126.getUrlList();
            if (r127 == null) goto L49;
            T r128 = (T) ((String) CollectionsKt.firstOrNull(r127));
        L50:
            r120.element = r128;
            String r129 = r125.getUserName();
            if (r129 == null) goto L59;
            if (r129.length() <= 0) goto L55;
            boolean r130 = true;
        L56:
            if (r130 != true) goto L59;
            r121.element = (T) th.a.h(r101.u().c(), R.string.ec_auction_bid_lead, new Object[]{r125.getUserName()});
            goto L59
        L55:
            r130 = false;
        L59:
            if (Intrinsics.areEqual(String.valueOf(r125.getUserId()), com.bytedance.android.ec.sdk.helper.r.f48132a.getCurrentUserId()) == false) goto L61;
            r120.element = null;
            com.bytedance.android.ec.core.toolbox.text.d r131 = new com.bytedance.android.ec.core.toolbox.text.d(new SpannableStringBuilder());
            r131.append(th.a.g(r101.u().c(), R.string.ec_auction_my_bid));
            com.bytedance.android.ec.core.toolbox.text.c.a.a(r131, (int) UIUtils.dip2Px(r101.u().c(), 2.0f));
            r131.g((int) 4294914884L, new AuctionCardPresenter$updateBidInfo$$inlined$let$lambda$1(r101, r120, r121));
            Unit r132 = Unit.INSTANCE;
            r121.element = (T) r131.f();
        L49:
            r128 = (T) null;
            goto L50
        L5:
            r100 = null;
            goto L7
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AuctionCardPresenter f152389a;

        public c(AuctionCardPresenter r100) {
            this.f152389a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            bk2.a r101 = (bk2.a) r100;
            AuctionCardPresenter r102 = this.f152389a;
            r102.f152386j = true;
            ExplainCardViewModel r103 = r102.f152468e;
            if (r103 == null) goto L14;
            QLiveData<ECUIPromotion> r104 = r103.getPromotionState();
            if (r104 == null) goto L15;
            ECUIPromotion r105 = r104.a();
            if (r105 == null) goto L16;
            AuctionCardPresenter r106 = this.f152389a;
            r106.f152387k = r105.getPromotionId();
            if (r105.isAuction() == false) goto L17;
            ECPromotionAuctionInfo r107 = r105.getAuctionInfo();
            if (r107 == null) goto L18;
            this.f152389a.F(r107);
            return;
        L18:
            return;
        L17:
            return;
        L16:
            return;
        L15:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p, com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        clearDisposable();
        ECAuctionStatusLayout r100 = this.f152385i;
        if (r100 == null) goto L6;
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.f153222a.c(r100);
        return;
    }

    public AuctionCardPresenter() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        ExplainCardViewModel r101 = this.f152468e;
        if (r101 == null) goto L7;
        QLiveData<ECUIPromotion> r102 = r101.getPromotionState();
        if (r102 == null) goto L7;
        r102.b(r100.getLifecycleOwner(), new b(this));
    L7:
        ExplainCardViewModel r103 = this.f152468e;
        if (r103 == null) goto L13;
        QLiveData<bk2.a<Unit>> r104 = r103.getShowAfterAnimAction();
        if (r104 == null) goto L14;
        r104.b(r100.getLifecycleOwner(), new c(this));
        return;
    L14:
        return;
    }

    public final void E(ECPromotionAuctionInfo r110) {
        Query r100 = w().b(R.id.tv_bottom);
        Query r101 = w().b(R.id.iv_bottom_user_head);
        r101.g(8);
        Query r102 = w().b(R.id.layout_bottom);
        Integer r103 = r110.getStatus();
        if (r103 == null) goto L5;
        int r104 = r103.intValue();
    L7:
        if (r104 > 2) goto L18;
        float r105 = UtilityKotlinExtentionsKt.c(12);
        View r106 = r100.f450937b;
        if ((r106 instanceof TextView) == false) goto L11;
        ((TextView) r106).setTextSize(0, r105);
    L11:
        View r107 = r100.f450937b;
        if ((r107 instanceof TextView) == false) goto L15;
        TextView r108 = (TextView) r107;
        r108.setTextColor(r108.getResources().getColor(R.color.ec_color_white));
    L15:
        if (Build.VERSION.SDK_INT < 24) goto L17;
        r102.f().setBackgroundResource(R.drawable.ec_auction_card_button_bg_normal);
    L28:
        Integer r109 = r110.getStatus();
        String r111 = "";
        if (r109 != null) goto L32;
    L48:
        if (r109 != null) goto L51;
    L55:
        if (r109 != null) goto L58;
    L62:
        String r112 = r110.getButtonLabel();
        if (r112 == null) goto L66;
        r111 = r112;
    L66:
        r100.e(r111);
        return;
    L58:
        if (r109.intValue() != 6) goto L62;
        View r113 = r100.f450937b;
        if ((r113 instanceof TextView) == false) goto L72;
        ((TextView) r113).setText(R.string.ec_auction_pre_end);
        return;
    L72:
        return;
    L51:
        if (r109.intValue() != 4) goto L55;
        View r114 = r100.f450937b;
        if ((r114 instanceof TextView) == false) goto L70;
        ((TextView) r114).setText(R.string.ec_auction_fail);
        return;
    L70:
        return;
    L32:
        if (r109.intValue() != 3) goto L48;
        CurrentUserInfo r115 = r110.getCurrentUserInfo();
        if (r115 == null) goto L43;
        ECUrlModel r116 = r115.getUserPic();
        if (r116 == null) goto L42;
        List<String> r117 = r116.getUrlList();
        if (r117 == null) goto L42;
        String r118 = (String) CollectionsKt.firstOrNull(r117);
        if (r118 == null) goto L42;
        r101.g(0);
        ECNetImageView r119 = (ECNetImageView) r101.f();
        r119.getHierarchy().setRoundingParams(RoundingParams.asCircle());
        r119.setImageURI(r118);
    L42:
        r100.e(th.a.h(u().c(), R.string.ec_auction_success, new Object[]{r115.getUserName()}));
        return;
    L43:
        String r120 = r110.getButtonLabel();
        if (r120 == null) goto L47;
        r111 = r120;
    L47:
        r100.e(r111);
        return;
    L17:
        r102.f().setBackgroundColor(th.a.a(u().c(), R.color.shopping_color_FFFF005C));
        goto L28
    L18:
        float r121 = UtilityKotlinExtentionsKt.c(10);
        View r122 = r100.f450937b;
        if ((r122 instanceof TextView) == false) goto L21;
        ((TextView) r122).setTextSize(0, r121);
    L21:
        View r123 = r100.f450937b;
        if ((r123 instanceof TextView) == false) goto L25;
        TextView r124 = (TextView) r123;
        r124.setTextColor(r124.getResources().getColor(R.color.shopping_std_text_3));
    L25:
        if (Build.VERSION.SDK_INT < 24) goto L27;
        r102.f().setBackgroundResource(R.drawable.ec_auction_card_button_bg_finish);
        goto L28
    L27:
        r102.f().setBackgroundColor(th.a.a(u().c(), R.color.shopping_color_80FF005C));
        goto L28
    L5:
        r104 = 1;
        goto L7
    }

    public final void F(ECPromotionAuctionInfo r100) {
        ECHotAtmosphereView r101 = (ECHotAtmosphereView) w().b(R.id.layout_hot_atmosphere).f();
        if (this.f152386j == true) goto L5;
        r101.setVisibility(4);
        return;
    L5:
        ECHotAtmosphereView.g(r101, true, true, null, 4);
        ECHotAtmosphere r102 = r100.getHotAtmosphere();
        if (r102 == null) goto L33;
        String r103 = r102.num;
        if (r103 == null) goto L14;
        Integer r104 = StringsKt.toIntOrNull(r103);
        if (r104 == null) goto L12;
        int r105 = r104.intValue();
    L13:
        if (r105 <= 0) goto L14;
    L28:
        if (r101.getVisibility() == 0) goto L30;
        r101.setVisibility(0);
        r101.setAlpha(0.0f);
        r101.setVisibility(0);
        r101.animate().cancel();
        ViewPropertyAnimator r106 = r101.animate().alpha(1.0f);
        r106.setDuration(160);
        r106.start();
    L30:
        r101.l(false);
        r101.j(r102, true, false);
        return;
    L12:
        r105 = 0;
    L14:
        int r107 = zg2.a.f572040a;
        ExplainCardViewModel r108 = this.f152468e;
        if (r108 == null) goto L19;
        ml.b r109 = r108.getLiveRoomInfo();
        if (r109 == null) goto L19;
        String r110 = r109.roomId();
    L20:
        ExplainCardViewModel r111 = this.f152468e;
        if (r111 == null) goto L25;
        RoomContextController r112 = r111.getRoomContextController();
        if (r112 == null) goto L25;
        String r113 = r112.D();
    L26:
        zg2.a.a(r110, r113, Action.GOODS_CARD_HOT_ATMOSPHERE_DATA_ERR, null);
    L25:
        r113 = null;
    L19:
        r110 = null;
        goto L20
    }

    public final void G(final ECPromotionAuctionInfo r100) {
        final ECAuctionStatusLayout r101 = (ECAuctionStatusLayout) w().b(R.id.layout_status).f();
        Function0<Unit> r102 = new AuctionCardPresenter$updateStatus$1(this, r101, r100);
        Intrinsics.checkNotNullParameter(r100, "auctionInfo");
        r101.f45892d = true;
        r101.f45895g = r102;
        r101.f45891c = r100;
        int r103 = wl.a.f560165b;
        r101.f45896h = wl.a.a(r100.getEndTime());
        r101.a(r100);
        this.f152385i = r101;
        if (r101.d(null) == false) goto L5;
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.f153222a.b(r101);
        return;
    L5:
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.f153222a.c(r101);
        if (r101.e(r100) == false) goto L10;
        G(r100);
        E(r100);
        return;
    }
}
