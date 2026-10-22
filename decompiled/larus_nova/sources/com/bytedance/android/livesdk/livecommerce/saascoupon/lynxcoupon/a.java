package com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import bl2.g;
import com.bytedance.android.ec.common.api.card.CardType;
import com.bytedance.android.ec.common.api.card.ExternalCardPriority;
import com.bytedance.android.ec.common.api.card.ExternalCardStatus;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.BottomRightAnimController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.BottomRightCardManager;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import el2.k;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Job;
import org.json.JSONArray;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements ef.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f152877s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Job f152878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f152879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f152880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f152881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ExternalCardStatus f152882e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f152883f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f152884g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f152885h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g f152886i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final el.b f152887j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f152888k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ff.a f152889l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ef.c f152890m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final k f152891n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final gf.a f152892o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LiveRoomParams f152893p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f152894q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ef.a f152895r;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon.a$a, reason: collision with other inner class name */
    public static final class C2357a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f152896a;

        public b(a r100) {
            this.f152896a = r100;
        }

        public final void a() {
            dm.a.a("LynxCardController").i("[scheduled][ExternalCard] card on scheduled, create card now.");
            this.f152896a.f152890m.getRootView().removeView(this.f152896a.f152881d);
            if (this.f152896a.f152882e.compareTo(ExternalCardStatus.PENDING) <= 0) goto L5;
            dm.a.a("LynxCardController").w("[scheduled][ExternalCard] create card but card status is displaying, error status.", null);
            return;
        L5:
            a r100 = this.f152896a;
            BottomRightCardManager.b r101 = r100.f152890m.getRootView();
            dm.a.a("LynxCardController").a("[create][ExternalCard] createLynxCouponPopup");
            r100.f152882e = ExternalCardStatus.SCHEDULED;
            String r102 = r100.f152887j.b();
            if (r102 == null) goto L13;
            r100.f152882e = ExternalCardStatus.LOADING;
            Context r103 = r100.f152885h;
            String r104 = r100.f152887j.a();
            LinkedHashMap r105 = new LinkedHashMap();
            Map<String, Object> r106 = com.bytedance.android.shopping.extensions.k.z(r104);
            if (r106 == null) goto L10;
            r105.put("render_info", r106);
        L10:
            r105.put("request_id", r100.f152888k);
            r105.put("enter_from", r100.f152886i.f19404a);
            r105.put("room_id", r100.f152886i.f19407d);
            r105.put("anchor_open_id", r100.f152886i.f19408e);
            r105.put("ad_info", MapsKt.mapOf(new Pair[]{TuplesKt.to("reqid", r100.f152886i.f19409f), TuplesKt.to("token", r100.f152886i.f19410g), TuplesKt.to("cid", String.valueOf(r100.f152886i.f19411h))}));
            r105.put("enter_timestamp", r100.f152891n.b(r100.f152886i.f19407d));
            r100.f152880c = ECLiveHybridUtil.b(r103, r102, r105, r100.f152881d, new com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon.c(r102, r100, r101), null, null, false, null, null, false, 4064);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f152897a;

        public c(a r100) {
            this.f152897a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f152897a.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // ef.b
    public final void b() {
        this.f152895r.c(CardType.COUPON_CARD, new LynxCardController$cancelExternalCard$1(this));
    }

    public final void c() {
        ef.a r100 = this.f152895r;
        Integer r101 = this.f152887j.d();
        int r102 = 1;
        if (r101 != null) goto L6;
    L8:
        if (r101 != null) goto L11;
    L13:
        ExternalCardPriority r103 = ExternalCardPriority.EXPLAIN_CARD_HIGH_PRIORITY;
    L14:
        int r104 = com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon.b.f152898a[r103.ordinal()];
        if (r104 != 1) goto L17;
        dm.a.a("LynxCardController").i("Init lynx card, explain card showing, explain > external");
    L22:
        r100.l(new ef.d(r102, CardType.COUPON_CARD, new b(this), new c(this)));
        return;
    L17:
        if (r104 != 2) goto L20;
        dm.a.a("LynxCardController").i("Init lynx card, explain card showing, external > explain");
        r102 = 20;
        goto L22
    L20:
        throw new NoWhenBranchMatchedException();
    L11:
        if (r101.intValue() != 1) goto L13;
        r103 = ExternalCardPriority.EXTERNAL_CARD_HIGH_PRIORITY;
        goto L14
    L6:
        if (r101.intValue() != 0) goto L8;
        r103 = ExternalCardPriority.EXPLAIN_CARD_HIGH_PRIORITY;
        goto L14
    }

    @Override // ef.b
    public final void a(boolean r210) {
        dm.a.a("LynxCardController").i("[destroy][ExternalCard] card destroyed");
        if (this.f152884g == true) goto L41;
        if (r210 == true) goto L10;
        if (this.f152882e.getStatusCode() < ExternalCardStatus.ANIM_SHOWING.getStatusCode()) goto L41;
        if (this.f152882e.getStatusCode() >= ExternalCardStatus.FINISHED.getStatusCode()) goto L41;
    L10:
        if (this.f152894q == false) goto L41;
        this.f152884g = true;
        if (this.f152893p == null) goto L41;
        JSONObject r100 = com.bytedance.android.shopping.extensions.k.w(this.f152887j.a());     // Catch: Exception -> L39
        if (r100 == null) goto L19;
        JSONArray r101 = JSONObjectProtectorUtils.getJSONArray(r100, "coupon_card");     // Catch: Exception -> L39
        if (r101 == null) goto L19;
        JSONObject r102 = JSONArrayProtectorUtils.getJSONObject(r101, 0);     // Catch: Exception -> L39
    L20:
        if (r100 == null) goto L22;
        JSONObject r103 = JSONObjectProtectorUtils.getJSONObject(r100, "log_data");     // Catch: Exception -> L39
    L23:
        r r104 = r.f48132a;     // Catch: Exception -> L39
        long r110 = 0;
        if (r104.a() != 0) goto L26;
        String r105 = "nologin";
    L30:
        String r106 = r105;
        long r107 = System.currentTimeMillis();     // Catch: Exception -> L39
        Long r108 = this.f152879b;     // Catch: Exception -> L39
        if (r108 == null) goto L33;
        r110 = r108.longValue();     // Catch: Exception -> L39
    L33:
        long r111 = r107 - r110;     // Catch: Exception -> L39
        Long r109 = this.f152887j.c();     // Catch: Exception -> L39
        if (r109 == null) goto L36;
        long r112 = r109.longValue();     // Catch: Exception -> L39
    L37:
        oh.a.a(new d(r102, r106, r103, RangesKt.coerceIn(r111, 0, r112), this));     // Catch: Exception -> L39
        goto L41
    L36:
        r112 = 10000;
        goto L37
    L26:
        if (r104.isLogin() == false) goto L28;
        r105 = "login_auth";
        goto L30
    L28:
        r105 = "login_no_auth";
        goto L30
    L22:
        r103 = null;
    L19:
        r102 = null;
    L39:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L41:
        this.f152882e = ExternalCardStatus.FINISHED;
        this.f152890m.getRootView().removeView(this.f152881d);
        this.f152890m.a();
        Job r113 = this.f152878a;
        if (r113 == null) goto L44;
        Job.DefaultImpls.cancel$default(r113, null, 1, null);
    L44:
        l r114 = this.f152880c;
        if (r114 == null) goto L50;
        r114.release();
        return;
    }

    public static void d(final a r100, View r101, final Function0 r110) {
        r100.getClass();
        dm.a.a("LynxCardController").a("[anim][ExternalCard] hideCardAnim");
        final Function0 r102 = null;
        r100.f152889l.b(r101, LynxCardController$hideCardAnim$1.INSTANCE, new LynxCardController$hideCardAnim$2(r100, r102), new LynxCardController$hideCardAnim$3(r100, r110), null);
    }

    public a(Context r100, g r101, el.b r102, String r103, BottomRightAnimController r104, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.b r105, k r106, gf.a r107, LiveRoomParams r110, boolean r111, ef.a r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "requestParams");
        Intrinsics.checkNotNullParameter(r102, "lynxCouponPopupModel");
        Intrinsics.checkNotNullParameter(r104, "animController");
        Intrinsics.checkNotNullParameter(r105, "cardViewProvider");
        Intrinsics.checkNotNullParameter(r106, "liveService");
        Intrinsics.checkNotNullParameter(r107, "fromType");
        Intrinsics.checkNotNullParameter(r112, "cardManager");
        this.f152885h = r100;
        this.f152886i = r101;
        this.f152887j = r102;
        this.f152888k = r103;
        this.f152889l = r104;
        this.f152890m = r105;
        this.f152891n = r106;
        this.f152892o = r107;
        this.f152893p = r110;
        this.f152894q = r111;
        this.f152895r = r112;
        FrameLayout r108 = new FrameLayout(r100);
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(-2, -2);
        r109.gravity = 80;
        Unit r113 = Unit.INSTANCE;
        r108.setLayoutParams(r109);
        this.f152881d = r108;
        this.f152882e = ExternalCardStatus.UNINITIALIZED;
    }
}
