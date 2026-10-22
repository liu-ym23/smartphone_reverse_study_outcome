package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.event.p1;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.CoreRequests;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right_kmp.slice.ECLiveSliceHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import vi2.v0;

/* JADX INFO: loaded from: classes10.dex */
public final class n extends c0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f151643o = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ECUIPromotion f151644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f151645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.c f151646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o f151647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.intro.message.a f151648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public cf.d f151649h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.intro.manager.c f151650i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a f151651j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public uk2.b f151652k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<cf.g> f151653l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f151654m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.kmp.a f151655n;

    public static final class a {
        @JvmStatic
        public static n a(String r100, String r101) {
            n r102 = ControllerCenter.c(r100, r101).f151426q;
            Objects.toString(r102);
            return r102;
        }
    }

    public static final class b implements v0<ECPromotion> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f151656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f151657b;

        @Override // vi2.v0
        public final void onError(Throwable r100) {
        }

        @Override // vi2.v0
        public final void onSuccess(ECPromotion r100) {
            ECPromotion r101 = r100;
            if (TextUtils.equals(this.f151657b, this.f151656a.B()) == false) goto L6;
            n r102 = this.f151656a;
            Handler r103 = com.bytedance.android.livesdk.livecommerce.utils.k.f153092a;
            r102.f151644c = com.bytedance.android.livesdk.livecommerce.utils.k.d(r101, com.bytedance.android.livesdk.livecommerce.room.f.a(), 0, Boolean.TRUE);
            n r104 = this.f151656a;
            r104.f151645d = SystemClock.elapsedRealtime();
            return;
        }

        public b(n r100, String r101) {
            this.f151656a = r100;
            this.f151657b = r101;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onCreate() {
        if (this.f151655n == null) goto L6;
        ECLiveSliceHelper.a();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0
    public final void G() {
        if (s() == true) goto L5;
    L9:
        this.f151644c = null;
        this.f151645d = 0;
        uk2.b r100 = this.f151652k;
        if (r100 == null) goto L12;
        r100.clear();
    L12:
        this.f151652k = null;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a r101 = this.f151651j;
        if (r101 == null) goto L15;
        r101.o();
    L15:
        this.f151651j = null;
        return;
    L5:
        if (this.f151644c == null) goto L9;
        if (this.f151645d <= 0) goto L9;
        String r102 = B();
        String r103 = y();
        ECUIPromotion r104 = this.f151644c;
        Intrinsics.checkNotNull(r104);
        String r105 = r104.getPromotionId();
        ECUIPromotion r106 = this.f151644c;
        Intrinsics.checkNotNull(r106);
        String r107 = r106.getEventItemType();
        long r108 = this.f151645d;
        Handler r109 = com.bytedance.android.livesdk.livecommerce.utils.k.f153092a;
        new p1(r102, r103, r105, r107, SystemClock.elapsedRealtime() - r108).k();
        goto L9
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onDestroy() {
        super.onDestroy();
        this.f151647f = null;
        this.f151646e = null;
        this.f151648g = null;
        this.f151649h = null;
        uk2.b r100 = this.f151652k;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        this.f151652k = null;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a r101 = this.f151651j;
        if (r101 == null) goto L8;
        r101.o();
    L8:
        this.f151651j = null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onExitRoom() {
        super.onExitRoom();
        this.f151654m = true;
    }

    public n(RealRoomController$roomResources$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "roomResources");
        super(r100);
        this.f151653l = new ArrayList();
        this.f151654m = true;
        if (ECLiveABUtils.INSTANCE.getENABLE_KMP_POP_CARD() == false) goto L5;
        com.bytedance.android.livesdk.livecommerce.kmp.a r101 = new com.bytedance.android.livesdk.livecommerce.kmp.a();
    L6:
        this.f151655n = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void I(boolean r210) {
        if (s() == true) goto L5;
        return;
    L5:
        if (this.f151644c != null) goto L7;
    L9:
        this.f151644c = null;
        this.f151645d = 0;
        if (r210 == false) goto L20;
        String r100 = y();
        String r101 = z();
        String r110 = B();
        CompositeDisposable r102 = CoreRequests.f151395a;
        b r111 = new b(this, r110);
        ECEventUtilsV2.f147718b.getClass();
        vi2.h.l(r100, r101, r110, null, ECEventUtilsV2.a("0"), null, false, false, false, false, null, null, false, null, null).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.livecommerce.room.controller.j(r111), new com.bytedance.android.livesdk.livecommerce.room.controller.k(r111));
        com.bytedance.android.livesdk.livecommerce.event.o r103 = new com.bytedance.android.livesdk.livecommerce.event.o();
        PromotionListController.T.getClass();
        fh2.a r104 = PromotionListController.a.b(r110, null);
        if (r104 == null) goto L16;
        int r105 = 1;
        if (((LivePromotionListFragment) r104).p() != true) goto L16;
    L17:
        r103.d("list_is_show", r105);
        r103.k();
        return;
    L16:
        r105 = 0;
        goto L17
    L20:
        return;
    L7:
        if (this.f151645d <= 0) goto L9;
        String r106 = B();
        String r107 = y();
        ECUIPromotion r108 = this.f151644c;
        Intrinsics.checkNotNull(r108);
        String r109 = r108.getPromotionId();
        ECUIPromotion r112 = this.f151644c;
        Intrinsics.checkNotNull(r112);
        String r113 = r112.getEventItemType();
        long r114 = this.f151645d;
        Handler r115 = com.bytedance.android.livesdk.livecommerce.utils.k.f153092a;
        new p1(r106, r107, r109, r113, SystemClock.elapsedRealtime() - r114).k();
        goto L9
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onContextAttached(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f151655n == null) goto L6;
        ECLiveSliceHelper.b();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void c(Context r100, com.bytedance.android.ec.adapter.api.state.a r101) {
        super.c(r100, r101);
    }

    public static void H(n r100, ql.a r101, String r110, String r111) {
        ak2.m r102 = r100.A().f151429t.F;
        if (r102 == null) goto L31;
        if (r101 == null) goto L32;
        String r103 = r101.getEventItemType();
        if (r103 != null) goto L8;
        r103 = "-1";
    L8:
        JSONObject r104 = new JSONObject();
        r104.put("anchor_id", r100.y());     // Catch: Exception -> L20
        if (hh2.f.e() == false) goto L12;
        r104.put("anchor_open_id", r100.y());     // Catch: Exception -> L20
    L12:
        r104.put("room_id", r100.B());     // Catch: Exception -> L20
        r104.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r101.getPromotionId());     // Catch: Exception -> L20
        r104.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r103);     // Catch: Exception -> L20
        String r105 = r101.mo8153getPrice();     // Catch: Exception -> L20
        if (r105 == null) goto L17;
        Float r106 = StringsKt.toFloatOrNull(r105);     // Catch: Exception -> L20
        if (r106 == null) goto L17;
        float r107 = r106.floatValue();     // Catch: Exception -> L20
    L18:
        r104.put("commodity_price", (int) (r107 * 100));     // Catch: Exception -> L20
        r104.put("go_to_tag", r111);     // Catch: Exception -> L20
        r104.put("screen_type", l0.m(null, null));     // Catch: Exception -> L20
        r104.put("action_type", l0.i("action_type"));     // Catch: Exception -> L20
        r104.put("enter_from_merge", l0.i("enter_from_merge"));     // Catch: Exception -> L20
        r104.put("enter_method", l0.i("enter_method"));     // Catch: Exception -> L20
    L22:
        r102.onClickPromotion("live_ad", com.bytedance.android.ec.core.event.a.KEY_CLICK_PRODUCT, r110, r104);
        if (r100.C().f42706u == false) goto L26;
        r102.onClickPromotion("detail_ad", "click", "", r104);
    L26:
        if ((!Intrinsics.areEqual("short_half_screen_card", r111)) == false) goto L33;
        r102.onClickPromotion("live_ad", "live_click_buy_right_now", r110, r104);
        return;
    L33:
        return;
    L17:
        r107 = 0.0f;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    L32:
        return;
    }
}
