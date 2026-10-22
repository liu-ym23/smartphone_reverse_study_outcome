package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f152699f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f152700g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f152701h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f152702i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final boolean f152703j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean f152704k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final boolean f152705l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final boolean f152706m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final boolean f152707n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final boolean f152708o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f152709p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static Boolean f152710q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ECUIPromotion f152711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f152712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f152713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super ECUIPromotion, Unit> f152714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ECContext f152715e;

    public static final class a {
        public static void a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            ShoppingAsyncInflater.a r101 = ShoppingAsyncInflater.f45268e;
            Context r102 = th.a.e(r100, true);
            r101.getClass();
            com.bytedance.android.ec.opt.asyncInflate.d r103 = ShoppingAsyncInflater.a.a(r102).a();
            r103.c(R.layout.ec_explain_card_uimodule_above, 1, "ec_explain_card_uimodule_above");
            r103.c(R.layout.ec_explain_card_bottom_layout, 1, "ec_explain_card_bottom_layout");
            r103.commit();
        }
    }

    public t() {
    }

    static {
        boolean r100 = false;
        if (((Number) EComABUtils.getLiveSettingValue("ecom_live_opt_card_load_2", 0)).intValue() != 1) goto L5;
        boolean r101 = true;
    L6:
        f152699f = r101;
        int r102 = EComABUtils.cardLoadOptV2Request();
        f152700g = r102;
        if (r102 <= 0) goto L9;
        boolean r103 = true;
    L10:
        f152701h = r103;
        if (EComABUtils.cardLoadOptV2Bind() != 1) goto L13;
        boolean r104 = true;
    L14:
        f152702i = r104;
        if (EComABUtils.cardLoadOptV2Show() != 1) goto L17;
        boolean r105 = true;
    L18:
        f152703j = r105;
        if (EComABUtils.cardLoadOptV2CardDoFrame() != 1) goto L21;
        boolean r106 = true;
    L22:
        f152704k = r106;
        if (EComABUtils.cardLoadOptV2PicPreLoad() != 1) goto L25;
        boolean r107 = true;
    L26:
        f152705l = r107;
        if (EComABUtils.cardLoadOptV2PicDoFrame() != 1) goto L29;
        boolean r108 = true;
    L30:
        f152706m = r108;
        if (EComABUtils.cardLoadOptV2Coupon() != 1) goto L33;
        boolean r109 = true;
    L34:
        f152707n = r109;
        if (r103 == true) goto L41;
        if (r104 == true) goto L41;
        if (r105 == true) goto L41;
        if (r106 == true) goto L41;
        if (r107 == true) goto L41;
        if (r108 == true) goto L41;
    L42:
        f152708o = r100;
        return;
    L41:
        r100 = true;
        goto L42
    L33:
        r109 = false;
        goto L34
    L29:
        r108 = false;
        goto L30
    L25:
        r107 = false;
        goto L26
    L21:
        r106 = false;
        goto L22
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    @JvmStatic
    public static final void a(String r100, String r101, boolean r102, ECCurrentPromotion r103) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "rooUniqueKey");
        if (r102 == false) goto L38;
        if (r103 == null) goto L39;
        boolean r104 = EntryController.M1;
        t r105 = EntryController.a.b(r100, r101).T;
        if (r105 == null) goto L40;
        Intrinsics.checkNotNullParameter(r103, "currentPromotion");
        if (f152701h == true) goto L10;
        return;
    L10:
        if (r105.f152713c == false) goto L42;
        ECContext r106 = r105.f152715e;
        if (r106 != null) goto L14;
    L16:
        ECContext r107 = r105.f152715e;
        if (r107 == null) goto L23;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r108 = r107.getEcLivePerformanceMonitor();
        if (r108 == null) goto L23;
        ECLivePerformanceMonitor r109 = r108.getValue();
        if (r109 == null) goto L23;
        r109.i();
    L23:
        r105.f152713c = false;
        ECUIPromotion r110 = com.bytedance.android.livesdk.livecommerce.utils.k.e(com.bytedance.android.livesdk.livecommerce.utils.k.c(r103), Boolean.TRUE);
        if (r110 != null) goto L26;
        r110 = null;
    L30:
        r105.f152711a = r110;
        r105.f152712b = true;
        if (r105.f152714d == null) goto L36;
        OptCardUtil.b(null, "handleResponse post callback");
        int r111 = f152700g;
        if (r111 <= 1) goto L35;
        UtilityKotlinExtentionsKt.f153057b.postAtTime(new u(r105), r111);
        return;
    L35:
        UtilityKotlinExtentionsKt.f153057b.postAtFrontOfQueue(new v(r105));
        return;
    L36:
        OptCardUtil.b(null, "handleResponse callback is null");
        return;
    L26:
        if (f152705l == false) goto L28;
        OptCardUtil.b(null, "handleResponse preload image");
        y.f152727o.getClass();
        y.a.b(r110);
    L28:
        Unit r112 = Unit.INSTANCE;
        goto L30
    L14:
        if (r106.isCleared() != true) goto L16;
        return;
    L42:
        return;
    L40:
        return;
    L39:
        return;
    }

    public final void b(ECContext r110, com.bytedance.android.livesdk.livecommerce.room.model.g r111, Context r112, p r113, String r114) {
        Intrinsics.checkNotNullParameter(r110, "ecContext");
        Intrinsics.checkNotNullParameter(r111, "liveRoomInfo");
        if (ECLiveABUtils.INSTANCE.getENABLE_KMP_POP_CARD() == false) goto L5;
        return;
    L5:
        dm.a.b r100 = dm.a.a("LiveCardLoad");
        StringBuilder r101 = new StringBuilder("preload explain card, is instant = ");
        if (r113 == null) goto L8;
        boolean r102 = true;
    L9:
        r101.append(r102);
        r100.i(r101.toString());
        if (r113 == null) goto L14;
        r113.c(r110, r111, r114);
        return;
    L14:
        if (f152699f == true) goto L16;
        return;
    L16:
        y.f152727o.getClass();
        y r115 = y.f152726n.get(r111.roomId());
        if (r115 != null) goto L19;
    L20:
        if (r115 != null) goto L22;
    L23:
        OptCardUtil.b(null, "request=" + f152701h + " bind=" + f152702i + " show=" + f152703j + " CardDoFrame=" + f152704k + " PicPreload=" + f152705l + " PicDoFrame=" + f152706m);
        qk2.a r103 = new qk2.a();
        this.f152713c = true;
        ECLivePerformanceMonitor r104 = r110.getEcLivePerformanceMonitor().getValue();
        r104.getClass();
        r104.u("ec_perf_duration_shopping_card", "request_start", Long.valueOf(SystemClock.elapsedRealtime()));
        String r105 = r104.f149762p;
        if (r105 == null) goto L26;
        Map<String, com.bytedance.android.ec.core.monitor.a> r106 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.h(r105, MetricNames.POP_API_DURATION, null);
    L26:
        bk2.c.a(r103.b(r111, true, true, null, null).subscribe(new w(this, r110), new x(this, r110)), r110.getDisposableContext().getValue());
    L27:
        this.f152715e = r110;
        if (r112 != null) goto L30;
        return;
    L30:
        if (y.f152723k == false) goto L54;
        if (r115 == null) goto L35;
        WeakReference<Context> r116 = r115.getContext();
        if (r116 == null) goto L35;
        Context r117 = r116.get();
    L36:
        boolean r118 = Intrinsics.areEqual(r117, r112);
        ECLivePerformanceMonitor r119 = r110.getEcLivePerformanceMonitor().getValue();
        r119.getClass();
        String r107 = "1";
        if (r118 == false) goto L39;
        String r108 = "1";
    L40:
        r119.b("ec_perf_duration_shopping_card", "is_preload_same_activity", r108);
        String r120 = r119.f149762p;
        if (r120 == null) goto L47;
        Map<String, com.bytedance.android.ec.core.monitor.a> r121 = com.bytedance.android.ec.core.monitor.c.f45142a;
        if (r118 == true) goto L46;
        r107 = "0";
    L46:
        com.bytedance.android.ec.core.monitor.c.e(r120, "is_preload_same_activity", r107);
    L47:
        OptCardUtil.b(null, "async layout same: " + r118);
        if (r115 != null) goto L50;
    L53:
        a.a(r112);
        return;
    L50:
        if (r115.f152735h != true) goto L53;
        if (r118 == false) goto L53;
        return;
    L39:
        r108 = "0";
    L35:
        r117 = null;
        goto L36
    L54:
        a.a(r112);
        return;
    L22:
        if (r115.f152732e == true) goto L27;
    L19:
        if (r115.f152728a == true) goto L27;
    L8:
        r102 = false;
        goto L9
    }
}
