package com.bytedance.android.shopping.store.home.presenter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.common.param.StoreAccountParam;
import com.bytedance.android.ec.store.repository.vo.AuthorReputationVO;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.bytedance.android.ec.store.view.ECTagListView;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.slice.ECStoreHeaderInfoSliceConfig;
import com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView;
import com.bytedance.android.shopping.store.slicecard.SliceItemType;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class t2 extends ECShopBasePresenter implements View.OnClickListener {
    public final c A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f184407u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ViewGroup f184408v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ViewGroup f184409w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public LottieAnimationView f184410x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ViewGroup f184411y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ValueAnimator f184412z;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t2 f184413a;

        public b(t2 r100) {
            this.f184413a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r210) {
            com.bytedance.android.shopping.store.home.entity.n r100 = (com.bytedance.android.shopping.store.home.entity.n) r210;
            if (r100.d() == false) goto L5;
        L85:
            this.f184413a.y().setVisibility(8);
            return;
        L5:
            if (r100.c() == true) goto L85;
            t2 r101 = this.f184413a;
            View r102 = r101.w().b(R.id.ec_shop_head_logo_wrapper).f();
            r102.setVisibility(0);
            r102.setOnClickListener(r101);
            SimpleDraweeView r103 = (SimpleDraweeView) r101.w().b(R.id.ec_shop_head_logo).f();
            com.bytedance.android.shopping.store.home.entity.e r104 = r100.f183748b;
            String r105 = null;
            if (r104 == null) goto L10;
            ECUrlModel r106 = r104.f183688c;
        L11:
            ECShopBasePresenter.Y(r101, r103, r106);
            r101.T().doEventAction("store_bind_author_show", (Pair[]) Arrays.copyOf(h4.a(r101.T(), "fold"), 8));
            r101.T().getViewTransitShipment().d(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.store.viewmodel.f.class), new w2(r101));
            t2 r107 = this.f184413a;
            r107.getClass();
            com.bytedance.android.shopping.store.home.slice.d r108 = r100.f183761o;
            if (r108 == null) goto L27;
            Map<String, ECStoreHeaderInfoSliceConfig> r109 = r108.f184505a;
            if (r109 == null) goto L27;
            ECStoreHeaderInfoSliceConfig r110 = r109.get(SliceItemType.SHOP_PROFILE.getType());
            if (r110 == null) goto L27;
            SimpleDraweeView r111 = (SimpleDraweeView) com.bytedance.android.ec.store.product.presenter.utils.f.a(r107.w().b(R.id.ec_shop_head_logo_living_border));
            Map<String, Object> r112 = r110.getSliceItemStates();
            if (r112 == null) goto L20;
            Object r113 = r112.get("shop_is_living");
        L22:
            if (Intrinsics.areEqual(r113, Boolean.TRUE) == false) goto L25;
            if (r111 == null) goto L27;
            ECShopBasePresenter.Y(r107, r111, com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.c.a(38, 38, "https://lf3-static.bytednsdoc.com/obj/eden-cn/wvoz_j_tvjl/ljhwZthlaukjlkulzlp/living/live_breathing_border.webp"));
            goto L27
        L25:
            if (r111 == null) goto L27;
            r111.setVisibility(8);
            goto L27
        L20:
            r113 = null;
        L27:
            t2 r114 = this.f184413a;
            ECStoreViewModel r115 = r114.T();
            BtmSDK r116 = BtmSDK.INSTANCE;
            uj3.j r117 = r114.T().getCurrentTab();
            if (r117 != null) goto L30;
        L32:
            String r118 = "a1.b6269.c5887.d3193";
        L33:
            Map<String, Object> r119 = r116.createReportParams(r118, PageFinder.via(r114.y()));
            ArrayList r120 = new ArrayList(r119.size());
            Iterator<Map.Entry<String, Object>> r121 = r119.entrySet().iterator();
        L35:
            if (r121.hasNext() == false) goto L37;
            Map.Entry<String, Object> r122 = r121.next();
            r120.add(TuplesKt.to(r122.getKey(), String.valueOf(r122.getValue())));
            goto L35
        L37:
            Map<String, String> r123 = MapsKt.toMap(r120);
            SpreadBuilder r124 = new SpreadBuilder(2);
            r124.add(TuplesKt.to("position", "fold"));
            int r125 = com.bytedance.android.shopping.store.home.d0.f183624a;
            r124.addSpread(com.bytedance.android.shopping.store.home.d0.a(r114.T()));
            r115.doEventAction("store_experience_score_show", r123, (Pair[]) r124.toArray(new Pair[r124.size()]));
            this.f184413a.T().getSelectedTabLocation().a(this.f184413a.W(), new z2(this), false);
            this.f184413a.T().getUpglideFactor().a(this.f184413a.W(), new a3(this), false);
            t2 r126 = this.f184413a;
            ECTagListView r127 = (ECTagListView) com.bytedance.android.ec.store.product.presenter.utils.f.a(r126.w().b(R.id.ec_store_info_top_tag_list));
            if (r127 == null) goto L44;
            r127.setVisibility(0);
            com.bytedance.android.shopping.store.home.entity.e r128 = r100.f183748b;
            if (r128 == null) goto L44;
            ECTagListDTO r129 = r128.f183701p;
            if (r129 == null) goto L44;
            ECTagListView.c(r127, r129, Integer.valueOf(r126.f184407u), MapsKt.toMutableMap(com.bytedance.android.ec.store.utils.m.b(r126.T().getBaseParams())), null, null, null, 56);
        L44:
            if (r127 == null) goto L46;
            r127.setOnClickListener(r126);
        L46:
            ECStoreViewModel r130 = r126.T();
            Pair<String, String>[] r131 = new Pair[3];
            r131[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SUBJECT, "user");
            r131[1] = TuplesKt.to("position", "fold");
            com.bytedance.android.shopping.store.home.entity.e r132 = r100.f183748b;
            if (r132 == null) goto L53;
            AuthorReputationVO r133 = r132.f183689d;
            if (r133 == null) goto L53;
            Double r134 = r133.getScore();
            if (r134 == null) goto L53;
            String r135 = String.valueOf(r134.doubleValue());
        L54:
            r131[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SCORE, r135);
            r130.doEventAction("author_sell_score_show", r131);
            t2 r136 = this.f184413a;
            com.bytedance.android.shopping.store.home.entity.e r137 = r100.f183748b;
            if (r137 == null) goto L59;
            com.bytedance.android.shopping.store.home.entity.v r138 = r137.f183693h;
            if (r138 == null) goto L59;
            String r139 = r138.a();
        L60:
            com.bytedance.android.shopping.store.home.entity.e r140 = r100.f183748b;
            if (r140 == null) goto L65;
            com.bytedance.android.shopping.store.home.entity.v r141 = r140.f183693h;
            if (r141 == null) goto L65;
            r105 = r141.b();
        L65:
            ECShopMarqueeTextView r142 = (ECShopMarqueeTextView) com.bytedance.android.ec.store.product.presenter.utils.f.a(r136.w().b(R.id.ec_store_info_area_name));
            if (r142 == null) goto L68;
            r142.post(new x2(r142, r136, r139, r105));
        L68:
            if (r142 == null) goto L70;
            r142.setOnClickListener(r136);
        L70:
            r136.T().getViewTransitShipment().d(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.store.viewmodel.g.class), new y2(r136, r142));
            t2 r143 = this.f184413a;
            LottieAnimationView r144 = r143.f184410x;
            if (r144 == null) goto L73;
            r144.setAnimation("ec_shop_follow_animation.json");
        L73:
            LottieAnimationView r145 = r143.f184410x;
            if (r145 == null) goto L76;
            r145.addAnimatorListener(new u2(r143));
        L76:
            ValueAnimator r146 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r143.f184412z = r146;
            if (r146 == null) goto L79;
            r146.setDuration(200);
        L79:
            ValueAnimator r147 = r143.f184412z;
            if (r147 == null) goto L82;
            r147.addUpdateListener(new v2(r143));
        L82:
            ViewGroup r148 = r143.f184411y;
            if (r148 == null) goto L88;
            r148.setOnClickListener(r143);
            return;
        L88:
            return;
        L59:
            r139 = null;
        L53:
            r135 = null;
            goto L54
        L30:
            if (r117.j() != true) goto L32;
            r118 = "a1.b0715.c722556";
            goto L33
        L10:
            r106 = null;
            goto L11
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t2 f184414a;

        public c(t2 r100) {
            this.f184414a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.android.shopping.store.home.a0 r101 = (com.bytedance.android.shopping.store.home.a0) r100;
            t2 r102 = this.f184414a;
            boolean r103 = r101.f183586a;
            LottieAnimationView r104 = r102.f184410x;
            if (r104 == null) goto L7;
            if (r103 == true) goto L6;
            r104.setVisibility(8);
            goto L7
        L6:
            r104.setVisibility(0);
        L7:
            ViewGroup r105 = r102.f184409w;
            if (r105 != null) goto L10;
        L12:
            boolean r106 = false;
        L13:
            if (r106 == r103) goto L21;
            ViewGroup r107 = r102.f184409w;
            if (r107 == null) goto L21;
            if (r103 == true) goto L19;
            r107.setVisibility(8);
            goto L21
        L19:
            r107.setVisibility(0);
            r107.setOnClickListener(new b3(r102));
        L21:
            if (r101.f183587b == false) goto L24;
            t2.q0(this.f184414a, r101.f183590e);
            return;
        L24:
            if (r101.f183588c == false) goto L28;
            t2.q0(this.f184414a, r101.f183590e);
            return;
        L28:
            return;
        L10:
            if (r105.getVisibility() != 0) goto L12;
            r106 = true;
            goto L13
        }
    }

    static {
    }

    public t2(Fragment r100) {
        super(r100);
        this.f184407u = com.bytedance.android.shopping.extensions.b.b(80);
        this.A = new c(this);
    }

    public static final void r0(t2 r100) {
        if (r100.T().needShopProfilePin2Top() == true) goto L7;
        ViewGroup r101 = r100.f184408v;
        if (r101 == null) goto L40;
        r101.setVisibility(8);
        return;
    L40:
        return;
    L7:
        Float r102 = r100.T().getUpglideFactor().getValue();
        if (r102 == null) goto L10;
        float r103 = r102.floatValue();
    L11:
        float r104 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r103, 0.0f), 1.0f);
        if (r104 >= 0.75f) goto L16;
        ViewGroup r105 = r100.f184408v;
        if (r105 == null) goto L42;
        r105.setVisibility(8);
        return;
    L42:
        return;
    L16:
        ViewGroup r106 = r100.f184408v;
        if (r106 == null) goto L19;
        r106.setVisibility(0);
    L19:
        ViewGroup r107 = r100.f184408v;
        if (r107 == null) goto L22;
        r107.setAlpha((r104 - 0.75f) * 4.0f);
    L22:
        ViewGroup r108 = r100.f184408v;
        if (r108 == null) goto L25;
        r108.requestLayout();
    L25:
        ViewGroup r109 = r100.f184411y;
        if (r109 == null) goto L28;
        r109.setAlpha(0.0f);
    L28:
        ValueAnimator r110 = r100.f184412z;
        if (r110 == null) goto L32;
        r110.cancel();
    L32:
        if (r104 != 1.0f) goto L44;
        ViewGroup r111 = r100.f184408v;
        if (r111 == null) goto L36;
        r111.setAlpha(1.0f);
    L36:
        ValueAnimator r112 = r100.f184412z;
        if (r112 == null) goto L45;
        r112.start();
        return;
    L45:
        return;
    L44:
        return;
    L10:
        r103 = 0.0f;
        goto L11
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        this.f184408v = (ViewGroup) w().b(R.id.ec_store_top_bar_mini_info_container).f();
        this.f184409w = (ViewGroup) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(R.id.ec_store_info_area_follow_wrapper));
        this.f184410x = (LottieAnimationView) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(R.id.ec_store_info_area_follow_lottieAnimationView));
        this.f184411y = (ViewGroup) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(R.id.ec_store_info_area_follow_container));
        ViewGroup r101 = this.f184408v;
        if (r101 == null) goto L5;
        r101.setVisibility(4);
    L5:
        T().getHeaderArea().a(W(), new b(this), false);
        T().getFollowConfigLiveData().a(W(), this.A, false);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = kn.a.f504133a;
        if (kn.a.a(r100.getId()) == false) goto L7;
        return;
    L7:
        if (U() == true) goto L9;
    L11:
        int r102 = r100.getId();
        if (r102 != R.id.ec_shop_head_logo_wrapper) goto L54;
        int r103 = com.bytedance.android.shopping.store.home.d0.f183624a;
        ECStoreViewModel r104 = T();
        View r105 = y();
        ECStoreViewModel r106 = T();
        Context r107 = u().c();
        Map<String, ? extends Object> r108 = MapsKt.mapOf(TuplesKt.to("position", "fold"));
        Intrinsics.checkNotNullParameter(r104, "eventReporter");
        Intrinsics.checkNotNullParameter(r105, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r106, "storeViewModel");
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        jm.a<com.bytedance.android.shopping.store.home.entity.n> r109 = r106.getHeaderArea();
        if (r109 == null) goto L22;
        com.bytedance.android.shopping.store.home.entity.n r110 = r109.getValue();
        if (r110 == null) goto L22;
        com.bytedance.android.shopping.store.home.entity.d r111 = r110.f183749c;
        if (r111 == null) goto L22;
        if (r111.f183678d != true) goto L22;
        com.bytedance.android.shopping.store.home.d0.c(r104, r105, r106, r107, r108);
        return;
    L22:
        ECStoreParam r112 = r106.getStoreParam();
        if (r112 == null) goto L27;
        String r113 = r112.getStoreHomePageUrl();
        if (r113 == null) goto L27;
        com.bytedance.android.ec.sdk.helper.p.f48130a.openSchema(r107, r113);
    L27:
        Pair<String, ? extends Object>[] r114 = new Pair[6];
        ECStoreParam r115 = r106.getStoreParam();
        Integer r116 = null;
        if (r115 == null) goto L30;
        String r117 = r115.getShopId();
    L31:
        r114[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r117);
        ECStoreParam r118 = r106.getStoreParam();
        if (r118 == null) goto L36;
        StoreAccountParam r119 = r118.getStoreAccountParam();
        if (r119 == null) goto L36;
        String r120 = r119.getUserId();
    L37:
        r114[1] = TuplesKt.to("author_id", r120);
        ECStoreParam r121 = r106.getStoreParam();
        if (r121 == null) goto L40;
        String r122 = r121.getStoreSourceMethod();
    L41:
        r114[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, r122);
        ECStoreParam r123 = r106.getStoreParam();
        if (r123 == null) goto L44;
        String r124 = r123.getStoreGroupType();
    L45:
        r114[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, r124);
        ECStoreParam r125 = r106.getStoreParam();
        if (r125 == null) goto L48;
        String r126 = r125.getStoreSourcePage();
    L49:
        r114[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, r126);
        ECStoreParam r127 = r106.getStoreParam();
        if (r127 == null) goto L52;
        r116 = r127.getFollowStatus();
    L52:
        r114[5] = TuplesKt.to("follow_status", String.valueOf(r116));
        r104.doAnyEventAction("store_bind_author_click", r108, r114);
        com.bytedance.android.shopping.store.home.d0.d(r104, r106, IInteractGameMonitorService.FAILURE_CODE_LINK_MIC_MUTEX, r108);
        return;
    L48:
        r126 = null;
        goto L49
    L44:
        r124 = null;
        goto L45
    L40:
        r122 = null;
    L36:
        r120 = null;
        goto L37
    L30:
        r117 = null;
        goto L31
    L54:
        if (r102 != R.id.ec_store_info_area_follow_wrapper) goto L61;
        ECStoreViewModel r128 = T();
        if (r128 == null) goto L72;
        com.bytedance.android.shopping.store.home.y r129 = r128.getIShopInfoAreaAbility();
        if (r129 == null) goto L73;
        r129.a();
        return;
    L73:
        return;
    L72:
        return;
    L61:
        if (r102 != R.id.ec_store_info_area_follow_container) goto L67;
        ECStoreViewModel r130 = T();
        if (r130 == null) goto L75;
        com.bytedance.android.shopping.store.home.y r131 = r130.getIShopInfoAreaAbility();
        if (r131 == null) goto L76;
        r131.a();
        return;
    L76:
        return;
    L75:
        return;
    L67:
        int r132 = com.bytedance.android.shopping.store.home.d0.f183624a;
        com.bytedance.android.shopping.store.home.d0.c(T(), y(), T(), u().c(), MapsKt.mapOf(TuplesKt.to("position", "fold")));
        return;
    L9:
        if (y().getAlpha() > 0.2f) goto L11;
    }

    public static final void q0(t2 r100, boolean r101) {
        if (r101 == false) goto L10;
        LottieAnimationView r102 = r100.f184410x;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.getVisibility() != 0) goto L15;
        LottieAnimationView r103 = r100.f184410x;
        if (r103 == null) goto L16;
        r103.playAnimation();
        return;
    L16:
        return;
    L15:
        return;
    L10:
        ViewGroup r104 = r100.f184411y;
        if (r104 == null) goto L18;
        r104.setVisibility(0);
        return;
    }
}
