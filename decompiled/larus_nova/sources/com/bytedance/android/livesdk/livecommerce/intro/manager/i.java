package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.content.Context;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.livesdk.livecommerce.eventcenter.LiveEventCenter;
import com.bytedance.android.livesdk.livecommerce.intro.controller.IntroAuctionWidgetController;
import com.bytedance.android.livesdk.livecommerce.intro.controller.IntroCardWidgetController;
import com.bytedance.android.livesdk.livecommerce.intro.message.IntroCardMessageListener;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntro;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroAuctionPromotionVO;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.quick.LiveRoomLifecycleOwner;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sg2.v;

/* JADX INFO: loaded from: classes10.dex */
public final class i implements c, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f148396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f148397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IntroCardAnimController f148398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseArray<com.bytedance.android.livesdk.livecommerce.intro.controller.b> f148399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f148400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f148401f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j f148402g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l f148403h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.intro.event.j f148404i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IntroManagerViewModel f148405j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.room.model.e f148406k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RoomContextController f148407l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final q f148408m;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f148409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f148410b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f148411c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f148409a, r101.f148409a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f148410b, r101.f148410b) == true) goto L10;
            return false;
        L10:
            if (this.f148411c == r101.f148411c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f148409a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f148410b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return ((r103 + r101) * 31) + this.f148411c;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "OpenPriceAnimationExecution(promotionId=" + this.f148409a + ", productId=" + this.f148410b + ", executionKey=" + this.f148411c + ")";
        }

        public a() {
            this.f148409a = null;
            this.f148410b = null;
            this.f148411c = 0;
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.d
    public final void i(int r100, Runnable r101) {
        this.f148408m.i(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.c
    public final List<uh2.a> b() {
        uh2.c r100 = this.f148405j.getIntroVOLiveData().a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f550088a;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.c
    public final Integer j() {
        uh2.c r100 = this.f148405j.getIntroVOLiveData().a();
        if (r100 == null) goto L9;
        List<uh2.a> r101 = r100.f550088a;
        if (r101 == null) goto L9;
        uh2.a r102 = (uh2.a) CollectionsKt.firstOrNull(r101);
        if (r102 == null) goto L9;
        return Integer.valueOf(r102.getIntroType());
    L9:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.c
    public final com.bytedance.android.livesdk.livecommerce.intro.event.j c() {
        return this.f148404i;
    }

    public static Pair k(uh2.a r100) {
        if ((r100 instanceof IntroPromotionVO) == false) goto L6;
        IntroPromotionVO r101 = (IntroPromotionVO) r100;
        return TuplesKt.to(r101.getPromotionId(), r101.getCardReqScene());
    L6:
        if ((r100 instanceof IntroAuctionPromotionVO) == false) goto L8;
        IntroAuctionPromotionVO r102 = (IntroAuctionPromotionVO) r100;
        return TuplesKt.to(r102.getPromotionId(), r102.getCardReqScene());
    L8:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.c
    public final boolean a(Integer r100) {
        if (r100 != null) goto L10;
        SparseArray<com.bytedance.android.livesdk.livecommerce.intro.controller.b> r101 = this.f148399d;
        int r102 = r101.size();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L18;
        if (r101.valueAt(r103).i() == true) goto L8;
        r103 = r103 + 1;
        goto L5
    L8:
        return true;
    L18:
        return false;
    L10:
        com.bytedance.android.livesdk.livecommerce.intro.controller.b r104 = this.f148399d.get(r100.intValue());
        if (r104 != null) goto L13;
        return false;
    L13:
        return r104.i();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.c
    public final void d(LiveIntroResponse r110) {
        if (this.f148401f == null) goto L5;
        return;
    L5:
        SparseArray<com.bytedance.android.livesdk.livecommerce.intro.controller.b> r100 = this.f148399d;
        int r101 = r100.size();
        boolean r102 = false;
        int r103 = 0;
    L7:
        if (r103 >= r101) goto L12;
        if (r100.valueAt(r103).i() == true) goto L10;
        r103 = r103 + 1;
        goto L7
    L10:
        r102 = true;
    L12:
        if (r102 == true) goto L14;
        return;
    L14:
        if (r110 == null) goto L26;
        List<LiveIntro> r104 = r110.getIntros();
        if (r104 != null) goto L18;
        return;
    L18:
        if ((!r104.isEmpty()) == true) goto L21;
        r104 = null;
    L21:
        if (r104 == null) goto L28;
        IntroManagerViewModel.handleIntroResp$default(this.f148405j, r110, IntroCardScene.REFRESH_MESSAGE, null, false, false, false, 56, null);
        return;
    L28:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.c
    public final void f(List<? extends uh2.a> r100) {
        if (this.f148401f == null) goto L5;
        return;
    L5:
        uh2.c r101 = this.f148405j.getIntroVOLiveData().a();
        IntroPromotionVO r102 = null;
        if (r101 == null) goto L17;
        List<uh2.a> r103 = r101.f550088a;
        if (r103 == null) goto L17;
        Iterator<T> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L15;
        Object r105 = r104.next();
        if ((((uh2.a) r105) instanceof IntroPromotionVO) == false) goto L11;
    L16:
        uh2.a r106 = (uh2.a) r105;
    L19:
        if ((r106 instanceof IntroPromotionVO) == true) goto L21;
        r106 = null;
    L21:
        IntroPromotionVO r107 = (IntroPromotionVO) r106;
        Iterator<T> r108 = r100.iterator();
    L23:
        if (r108.hasNext() == false) goto L27;
        Object r109 = r108.next();
        if ((((uh2.a) r109) instanceof IntroPromotionVO) == false) goto L23;
    L28:
        uh2.a r110 = (uh2.a) r109;
        if ((r110 instanceof IntroPromotionVO) == true) goto L31;
        r110 = null;
    L31:
        IntroPromotionVO r111 = (IntroPromotionVO) r110;
        if (r111 == null) goto L49;
        String r112 = r111.getPromotionId();
        if (r107 == null) goto L36;
        String r113 = r107.getPromotionId();
    L38:
        if (Intrinsics.areEqual(r112, r113) == false) goto L40;
        r102 = r111;
    L40:
        if (r102 == null) goto L50;
        this.f148405j.updateIntroVOs(r100);
        return;
    L50:
        return;
    L36:
        r113 = null;
        goto L38
    L49:
        return;
    L27:
        r109 = null;
        goto L28
    L15:
        r105 = null;
    L17:
        r106 = null;
        goto L19
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.c
    public final boolean h(sh2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "popMessageContext");
        return l(IntroCardScene.POP_MESSAGE, r100);
    }

    public final boolean l(IntroCardScene r100, sh2.a r101) {
        if (this.f148401f != null) goto L6;
        return false;
    L6:
        if (r100 != IntroCardScene.ACTION) goto L9;
        return false;
    L9:
        if (r101 == null) goto L25;
        Integer r102 = r101.f541938b;
        if (r102 != null) goto L14;
    L15:
        Integer r103 = r101.f541938b;
        if (r103 != null) goto L19;
    L21:
        boolean r104 = false;
    L23:
        if (r104 != true) goto L25;
        boolean r105 = true;
    L27:
        if (r100 != IntroCardScene.POP_MESSAGE) goto L36;
        if (r101 != null) goto L30;
    L31:
        if (r101 == null) goto L36;
        if (r101.f541937a != 1) goto L36;
    L34:
        if (r105 == true) goto L36;
        boolean r106 = true;
    L37:
        if (r106 == false) goto L40;
        this.f148401f = null;
        return false;
    L40:
        return true;
    L30:
        if (r101.f541937a == 0) goto L34;
    L36:
        r106 = false;
        goto L37
    L19:
        if (r103.intValue() != 2) goto L21;
    L22:
        r104 = true;
        goto L23
    L14:
        if (r102.intValue() == 1) goto L22;
    L25:
        r105 = false;
        goto L27
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.c
    public final void g(String r110, String r111, boolean r112) {
        SparseArray<com.bytedance.android.livesdk.livecommerce.intro.controller.b> r100 = this.f148399d;
        int r101 = r100.size();
        boolean r102 = false;
        int r103 = 0;
    L4:
        if (r103 >= r101) goto L9;
        if (r100.valueAt(r103).n() == true) goto L7;
        r103 = r103 + 1;
        goto L4
    L7:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L13;
        return;
    L13:
        if (r112 == false) goto L44;
        uh2.c r113 = this.f148405j.getIntroVOLiveData().a();
        if (r113 == null) goto L35;
        List<uh2.a> r114 = r113.f550088a;
        if (r114 == null) goto L35;
        Iterator<T> r115 = r114.iterator();
    L20:
        if (r115.hasNext() == false) goto L33;
        Object r105 = r115.next();
        Pair r106 = k((uh2.a) r105);
        if (r106 == null) goto L24;
        String r107 = (String) r106.getFirst();
    L25:
        if (r111 != null) goto L27;
    L30:
        boolean r108 = true;
    L31:
        if (r108 == false) goto L20;
    L34:
        uh2.a r109 = (uh2.a) r105;
    L36:
        if (r109 == null) goto L38;
        com.bytedance.android.livesdk.livecommerce.intro.controller.b r116 = this.f148399d.get(r109.getIntroType());
    L39:
        if (r116 != null) goto L42;
        int r117 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.f148548a;
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[cancelIntroCard] ignore stale pop cancel, promotionId=" + r111);
        return;
    L42:
        this.f148401f = null;
        com.bytedance.android.livesdk.livecommerce.intro.controller.b.a.a(r116, r110, r111, true, false, 8);
        return;
    L38:
        r116 = null;
        goto L39
    L27:
        if (Intrinsics.areEqual(r111, r107) == true) goto L30;
        r108 = false;
        goto L31
    L24:
        r107 = null;
        goto L25
    L33:
        r105 = null;
    L35:
        r109 = null;
        goto L36
    L44:
        SparseArray<com.bytedance.android.livesdk.livecommerce.intro.controller.b> r118 = this.f148399d;
        int r119 = r118.size();
        int r120 = 0;
    L45:
        if (r120 >= r119) goto L47;
        r118.keyAt(r120);
        com.bytedance.android.livesdk.livecommerce.intro.controller.b.a.a(r118.valueAt(r120), r110, r111, false, false, 8);
        r120 = r120 + 1;
        goto L45
    L47:
        a r121 = this.f148401f;
        if (r121 == null) goto L70;
        if (r110 != null) goto L51;
    L52:
        if (r111 != null) goto L54;
    L55:
        r102 = true;
    L56:
        if (r102 == true) goto L59;
        r121 = null;
    L59:
        if (r121 == null) goto L71;
        this.f148401f = null;
        return;
    L71:
        return;
    L54:
        if (Intrinsics.areEqual(r111, r121.f148409a) == false) goto L56;
    L51:
        if (Intrinsics.areEqual(r110, r121.f148410b) == false) goto L56;
    L70:
        return;
    L9:
        r104 = false;
        goto L10
    }

    public i(Context r210, com.bytedance.android.livesdk.livecommerce.room.model.g r211, LiveRoomParams r212, RoomContextController r213, qh2.d.b r214, qh2.b r310, qh2.c r311) {
        q r100 = new q();
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "liveRoomInfo");
        Intrinsics.checkNotNullParameter(r213, "roomContextController");
        Intrinsics.checkNotNullParameter(r214, "btmInfo");
        Intrinsics.checkNotNullParameter(r100, "cardQueue");
        Intrinsics.checkNotNullParameter(r310, "introCardWidget");
        Intrinsics.checkNotNullParameter(r311, "widgetCallback");
        this.f148406k = r211;
        this.f148407l = r213;
        this.f148408m = r100;
        u r101 = new u(r311, new IntroCardManager$animDelegate$1(this));
        this.f148397b = r101;
        IntroCardAnimController r102 = new IntroCardAnimController(r213, r101);
        this.f148398c = r102;
        SparseArray<com.bytedance.android.livesdk.livecommerce.intro.controller.b> r103 = new SparseArray();
        this.f148399d = r103;
        j r104 = new j(this);
        this.f148402g = r104;
        l r105 = new l(this);
        this.f148403h = r105;
        if (r212 == null) goto L5;
        com.bytedance.android.livesdk.livecommerce.intro.event.j r106 = new com.bytedance.android.livesdk.livecommerce.intro.event.j(r212);
    L6:
        com.bytedance.android.livesdk.livecommerce.intro.event.j r107 = r106;
        this.f148404i = r107;
        r r108 = new r();
        h r109 = new h(this, r210);
        r109.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Unit r110 = Unit.INSTANCE;
        this.f148396a = r109;
        IntroManagerViewModel r111 = new IntroManagerViewModel(r108, r211, r212, r213);
        this.f148405j = r111;
        k r112 = new k(this);
        IntroCardWidgetController r113 = new IntroCardWidgetController(r210, r213, r211, r212, r109, r214, this, r102, r101, r107, r310, r112);
        r103.put(r113.f148156a, r113);
        IntroAuctionWidgetController r114 = new IntroAuctionWidgetController(r210, r213, r211, r212, r109, r214, this, r102, r101, r310, r112);
        r103.put(r114.f148114a, r114);
        bk2.e<uh2.c> r115 = r111.getIntroVOLiveData();
        ECContext r116 = r213.r();
        if (r116 == null) goto L13;
        com.bytedance.live.datacontext.i<LiveRoomLifecycleOwner> r117 = r116.getLifecycleOwner();
        if (r117 == null) goto L13;
        LiveRoomLifecycleOwner r118 = r117.getValue();
        if (r118 == null) goto L13;
    L14:
        r115.b(r118, new p(this));
        if (this.f148400e == true) goto L18;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r119 = r213.A().f151426q;
        r119.f151648g = new IntroCardMessageListener(r210, r211, r213, this, r108);
        Lazy r120 = LiveEventCenter.f147750b;
        LiveEventCenter.a.a().b(r105);
        this.f148400e = true;
    L18:
        r213.A().f151426q.f151650i = this;
        ECLiveHybridUtil.m("closeExplainCard", r104);
        return;
    L13:
        r118 = ECQuickUtilKt.f45526b;
        goto L14
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.c
    public final void e(IntroCardScene r110, Pair<Long, Long> r111, sh2.b r112, String r113, Map<String, String> r114, Function2<? super LiveIntroResponse, ? super List<? extends uh2.a>, Unit> r115, sh2.a r116) {
        Intrinsics.checkNotNullParameter(r110, "cardScene");
        if (l(r110, r116) == false) goto L6;
        int r100 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.f148548a;
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[createIntroCard] filter refresh during open price animation, scene=" + r110);
        return;
    L6:
        SparseArray<com.bytedance.android.livesdk.livecommerce.intro.controller.b> r101 = this.f148399d;
        int r102 = r101.size();
        int r103 = 0;
    L7:
        boolean r104 = true;
        if (r103 >= r102) goto L13;
        if (r101.valueAt(r103).n() == true) goto L11;
        r103 = r103 + 1;
        goto L7
    L11:
        boolean r105 = true;
    L14:
        if (r105 == true) goto L16;
    L18:
        com.bytedance.android.livesdk.livecommerce.intro.event.j r106 = this.f148404i;
        if (r106 != null) goto L21;
    L27:
        IntroManagerViewModel r107 = this.f148405j;
        if (r116 == null) goto L44;
        Integer r108 = r116.f541938b;
        if (r108 != null) goto L33;
    L34:
        Integer r109 = r116.f541938b;
        if (r109 != null) goto L38;
    L40:
        boolean r117 = false;
    L42:
        if (r117 != true) goto L44;
    L45:
        r107.queryIntro(r110, r111, r112, r113, r114, r104, r115);
        return;
    L38:
        if (r109.intValue() != 2) goto L40;
    L41:
        r117 = true;
        goto L42
    L33:
        if (r108.intValue() == 1) goto L41;
    L44:
        r104 = false;
        goto L45
    L21:
        if (sh2.f.b(r110) == true) goto L23;
        String r118 = "enter_room";
    L24:
        v r119 = new v("livesdk_popup_card_request_show", r106.f148276d);
        r119.c("from_scene", r118);
        Unit r120 = Unit.INSTANCE;
        if (r106.f148275c == false) goto L27;
        r119.i(null);
        goto L27
    L23:
        r118 = "message";
        goto L24
    L16:
        if (r110 == IntroCardScene.ACTION) goto L18;
        return;
    L13:
        r105 = false;
        goto L14
    }
}
