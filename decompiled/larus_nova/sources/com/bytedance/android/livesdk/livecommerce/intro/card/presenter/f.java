package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardAtmosphereComponent;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.auction.IntroAuctionHotAtmosphereView;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroAtmosphere;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroNumAtmosphere;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s0;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroAuctionAtmosphereHelper;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f extends oh2.a implements b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f147895i;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f147896a;

        public a(f r100) {
            this.f147896a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            IntroPromotionVO r111 = (IntroPromotionVO) r110;
            if (r111 == null) goto L157;
            f r100 = this.f147896a;
            r100.f147895i.f147891e = r111.getProduct();
            e r101 = r100.f147895i;
            IntroProduct r102 = r111.getProduct();
            boolean r103 = false;
            if (r102 == null) goto L7;
            int r104 = r102.h();
        L8:
            r101.f147889c = r104;
            e r105 = r100.f147895i;
            IntroProduct r106 = r111.getProduct();
            if (r106 == null) goto L11;
            int r107 = r106.e();
        L12:
            r105.f147890d = r107;
            r100.f147895i.f147892f = r111.getAuctionInfo();
            r100.f147895i.f147888b = r111.getIntroAtmosphere();
            e r108 = r100.f147895i;
            oh2.e r109 = r100.f523247f;
            String r112 = "";
            if (r109 == null) goto L18;
            com.bytedance.android.livesdk.livecommerce.room.model.e r113 = r109.f523254c;
            if (r113 == null) goto L18;
            String r114 = r113.roomId();
            if (r114 == null) goto L18;
        L19:
            r108.getClass();
            Intrinsics.checkNotNullParameter(r114, "<set-?>");
            r108.f147893g = r114;
            e r115 = r100.f147895i;
            oh2.e r116 = r100.f523247f;
            if (r116 == null) goto L27;
            com.bytedance.android.livesdk.livecommerce.room.model.e r117 = r116.f523254c;
            if (r117 == null) goto L27;
            String r118 = r117.a();
            if (r118 == null) goto L27;
            r112 = r118;
        L27:
            r115.getClass();
            Intrinsics.checkNotNullParameter(r112, "<set-?>");
            r115.f147894h = r112;
            e r119 = r100.f147895i;
            int r120 = r119.f147890d;
            IntroAtmosphere r121 = null;
            if (r120 == 1) goto L34;
            if (r120 == 2) goto L34;
            if (r119.f147888b != null) goto L34;
            r119 = null;
        L34:
            if (r119 == null) goto L159;
            f r122 = this.f147896a;
            s0 r123 = r111.getControl();
            if (r123 == null) goto L38;
            int r124 = r123.d();
        L39:
            IntroCardAtmosphereComponent r125 = (IntroCardAtmosphereComponent) r122.w().f();
            Intrinsics.checkNotNullParameter(r119, "atmosphereModel");
            String r126 = r125.f147923l;
            IntroProduct r127 = r119.f147891e;
            if (r127 == null) goto L42;
            String r128 = r127.i();
        L44:
            if ((!Intrinsics.areEqual(r126, r128)) == false) goto L52;
            IntroProduct r129 = r119.f147891e;
            if (r129 == null) goto L48;
            String r130 = r129.i();
        L49:
            r125.f147923l = r130;
            r125.f147916e.i();
            IntroAuctionHotAtmosphereView r131 = r125.f147918g;
            if (r131 == null) goto L52;
            r131.setCallback(null);
            goto L52
        L48:
            r130 = null;
        L52:
            int r132 = r119.f147890d;
            if (r132 == 1) goto L126;
            if (r132 == 2) goto L71;
            IntroAuctionHotAtmosphereView r133 = r125.f147918g;
            if (r133 == null) goto L58;
            r133.setVisibility(8);
        L58:
            IntroAtmosphere r134 = r119.f147888b;
            if (r134 != null) goto L61;
        L68:
            b r135 = r125.f147914c;
            if (r135 == null) goto L161;
            r135.q(true);
            Unit r136 = Unit.INSTANCE;
            return;
        L161:
            return;
        L61:
            if (r134.a() != 1) goto L63;
            boolean r137 = true;
        L64:
            if (r137 == false) goto L66;
            r121 = r134;
        L66:
            if (r121 == null) goto L68;
            r125.T5(r121, r124, false);
            return;
        L63:
            r137 = false;
            goto L64
        L71:
            r125.f147916e.setVisibility(8);
            ECLiveABUtils r138 = ECLiveABUtils.INSTANCE;
            th2.b r139 = r138.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(Integer.valueOf(r124));
            if (r139 == null) goto L77;
            ECUrlModel r140 = r139.b();
            if (r140 == null) goto L77;
            String r141 = r140.getFirstUrl();
            if (r141 == null) goto L77;
        L78:
            th2.b r142 = r138.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(Integer.valueOf(r124));
            if (r142 == null) goto L84;
            ECUrlModel r143 = r142.d();
            if (r143 == null) goto L84;
            String r144 = r143.getFirstUrl();
            if (r144 == null) goto L84;
        L85:
            ECPromotionAuctionInfo r145 = r119.f147892f;
            if (r145 == null) goto L93;
            ECHotAtmosphere r146 = r145.getIntroHotAtmosphere(r141, r144);
            if (r146 == null) goto L93;
            if (r125.f147918g != null) goto L92;
            r125.R5();
        L92:
            r125.S5(r119, r146, r124);
            return;
        L93:
            IntroAtmosphere r147 = r119.f147888b;
            if (r147 != null) goto L96;
        L110:
            b r148 = r125.f147914c;
            if (r148 == null) goto L113;
            r148.q(true);
        L113:
            r119.f147887a.reset();
            IntroAuctionHotAtmosphereView r149 = r125.f147918g;
            if (r149 == null) goto L116;
            r149.setCallback(null);
        L116:
            IntroAuctionHotAtmosphereView r150 = r125.f147918g;
            if (r150 == null) goto L119;
            r150.setTag(null);
        L119:
            IntroAuctionHotAtmosphereView r151 = r125.f147918g;
            if (r151 == null) goto L122;
            r151.setVisibility(4);
        L122:
            IntroAuctionHotAtmosphereView r152 = r125.f147918g;
            if (r152 == null) goto L125;
            r152.h();
        L125:
            r125.f147915d.setVisibility(4);
            Unit r153 = Unit.INSTANCE;
            return;
        L96:
            if (r147.a() != 1) goto L102;
            IntroNumAtmosphere r154 = r147.d();
            if (r154 == null) goto L102;
            if (r154.getType() != 10001) goto L102;
            r103 = true;
        L102:
            if (r103 == true) goto L105;
            r147 = null;
        L105:
            if (r147 == null) goto L110;
            IntroAuctionHotAtmosphereView r155 = r125.f147918g;
            if (r155 == null) goto L109;
            r155.setVisibility(8);
        L109:
            r125.T5(r147, r124, true);
            return;
        L84:
            r144 = "https://lf3-static.bytednsdoc.com/obj/eden-cn/lcps_tvjl/ljhwZthlaukjlkulzlp/live_intro/auction/auction_deal_v2.webp";
        L77:
            r141 = "https://lf3-static.bytednsdoc.com/obj/eden-cn/lcps_tvjl/ljhwZthlaukjlkulzlp/live_intro/auction/auction_price_v3.webp";
            goto L78
        L126:
            r125.f147916e.setVisibility(8);
            IntroAtmosphere r156 = r119.f147888b;
            if (r156 != null) goto L129;
            return;
        L129:
            if (r156.a() != 2) goto L131;
            boolean r157 = true;
        L132:
            if (r157 == false) goto L134;
            r121 = r156;
        L134:
            if (r121 != null) goto L136;
            return;
        L136:
            if (r125.f147918g != null) goto L138;
            r125.R5();
        L138:
            IntroAtmosphere r158 = r119.f147888b;
            if (r158 != null) goto L141;
        L153:
            IntroAuctionHotAtmosphereView r159 = r125.f147918g;
            if (r159 == null) goto L156;
            r159.setVisibility(8);
        L156:
            r125.f147915d.setVisibility(8);
            r125.setVisibility(8);
            Unit r160 = Unit.INSTANCE;
            return;
        L141:
            if (r158.b() == null) goto L153;
            r125.setVisibility(0);
            IntroAuctionHotAtmosphereView r161 = r125.f147918g;
            if (r161 == null) goto L145;
            r161.setVisibility(0);
        L145:
            IntroAuctionAtmosphereHelper r162 = r125.f147919h;
            if (r162 == null) goto L148;
            r162.a(r119);
        L148:
            IntroAuctionAtmosphereHelper r163 = r125.f147919h;
            if (r163 != null) goto L151;
            return;
        L151:
            if (r163.f148481c == true) goto L169;
            com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.f153222a.b(r163);
            r163.f148481c = true;
            return;
        L169:
            return;
        L131:
            r157 = false;
            goto L132
        L42:
            r128 = null;
            goto L44
        L38:
            r124 = 0;
            goto L39
        L159:
            return;
        L18:
            r114 = "";
            goto L19
        L11:
            r107 = 0;
            goto L12
        L7:
            r104 = 0;
            goto L8
        L157:
            this.f147896a.E();
            Unit r164 = Unit.INSTANCE;
        }
    }

    public f() {
        super(0);
        this.f147895i = new e();
    }

    @Override // oh2.a, com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        clearDisposable();
        E();
    }

    public final void E() {
        IntroCardAtmosphereComponent r100 = (IntroCardAtmosphereComponent) w().f();
        r100.f147915d.setVisibility(8);
        r100.f147916e.setVisibility(8);
        IntroAuctionHotAtmosphereView r101 = r100.f147918g;
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        r100.setVisibility(8);
        r100.f147916e.i();
        IntroAuctionHotAtmosphereView r102 = r100.f147918g;
        if (r102 == null) goto L8;
        r102.h();
    L8:
        r100.f147921j = !ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_ANIM_OPT().b();
        r100.f147920i = false;
        IntroAuctionAtmosphereHelper r103 = r100.f147919h;
        if (r103 == null) goto L24;
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.f153222a.c(r103);
        r103.f148481c = false;
        Runnable r104 = r103.f148486h;
        if (r104 == null) goto L13;
        UtilityKotlinExtentionsKt.f153057b.removeCallbacks(r104);
    L13:
        Runnable r105 = r103.f148486h;
        if (r105 == null) goto L16;
        UtilityKotlinExtentionsKt.f153057b.removeCallbacks(r105);
    L16:
        r103.f148486h = null;
        Runnable r106 = r103.f148487i;
        if (r106 == null) goto L19;
        UtilityKotlinExtentionsKt.f153057b.removeCallbacks(r106);
    L19:
        Runnable r107 = r103.f148487i;
        if (r107 == null) goto L22;
        UtilityKotlinExtentionsKt.f153057b.removeCallbacks(r107);
    L22:
        r103.f148487i = null;
        r103.f148482d = null;
        r103.f148488j = true;
        return;
    }

    @Override // oh2.a
    public final void D(oh2.h r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        ((IntroCardAtmosphereComponent) w().f()).setPresenter(this);
        IntroCardAtmosphereComponent r101 = (IntroCardAtmosphereComponent) w().f();
        r101.setArgument(this.f523247f);
        r101.setContainerAbility(this.f523248g);
        this.f147895i = new e();
        IntroCardViewModel r102 = this.f523246e;
        if (r102 == null) goto L8;
        bk2.e<IntroPromotionVO> r103 = r102.getCardState();
        if (r103 == null) goto L9;
        r103.b(r100.getLifecycleOwner(), new a(this));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.presenter.b
    public final void q(boolean r100) {
        dm.a.a("IntroAuction").i("setImageTagVisibility to " + r100);
        IntroCardViewModel r101 = this.f523246e;
        if (r101 == null) goto L8;
        bk2.e<bk2.a<Boolean>> r102 = r101.getShowImageTagAction();
        if (r102 == null) goto L9;
        r102.g(new bk2.a(Boolean.valueOf(r100)));
        return;
    L9:
        return;
    }
}
