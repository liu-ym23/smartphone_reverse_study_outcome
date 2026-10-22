package com.bytedance.android.livesdk.livecommerce.intro.utils;

import android.content.Context;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class IntroCardLoadOpt {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f148501f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f148502g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f148503h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f148504i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final boolean f148505j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean f148506k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final boolean f148507l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final boolean f148508m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f148509n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Boolean f148510o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile LiveIntroResponse f148511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f148512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f148513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super LiveIntroResponse, Unit> f148514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ECContext f148515e;

    public static final class a {
        public static void a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_KMP_UI() == false) goto L5;
            int r101 = ph2.h.f529255o;
            int r102 = nh2.a.f519160a;
        L5:
            dm.a.a("IntroCardLoadOpt").i("asyncInflate intro card layout");
            ShoppingAsyncInflater.a r103 = ShoppingAsyncInflater.f45268e;
            Context r104 = th.a.e(r100, true);
            r103.getClass();
            com.bytedance.android.ec.opt.asyncInflate.d r105 = ShoppingAsyncInflater.a.a(r104).a();
            r105.c(R.layout.ec_intro_card_layout, 1, "ec_intro_card_layout");
            r105.c(R.layout.ec_intro_card_atmosphere_widget, 1, "ec_intro_card_atmosphere_widget");
            r105.commit();
        }
    }

    public IntroCardLoadOpt() {
    }

    static {
        boolean r100 = false;
        if (((Number) EComABUtils.getLiveSettingValue("ecom_live_opt_card_load_2", 0)).intValue() != 1) goto L5;
        boolean r101 = true;
    L6:
        f148501f = r101;
        int r102 = EComABUtils.cardLoadOptV2Request();
        f148502g = r102;
        if (r102 <= 0) goto L9;
        boolean r103 = true;
    L10:
        f148503h = r103;
        if (EComABUtils.cardLoadOptV2Bind() != 1) goto L13;
        boolean r104 = true;
    L14:
        f148504i = r104;
        if (EComABUtils.cardLoadOptV2Show() != 1) goto L17;
        boolean r105 = true;
    L18:
        f148505j = r105;
        if (EComABUtils.cardLoadOptV2CardDoFrame() != 1) goto L21;
        boolean r106 = true;
    L22:
        f148506k = r106;
        if (EComABUtils.cardLoadOptV2PicPreLoad() != 1) goto L25;
        boolean r107 = true;
    L26:
        f148507l = r107;
        if (EComABUtils.cardLoadOptV2PicDoFrame() != 1) goto L29;
        r100 = true;
    L29:
        f148508m = r100;
        EComABUtils.cardLoadOptV2Coupon();
        return;
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

    public final boolean a(String r100, final Function1<? super LiveIntroResponse, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        boolean r102 = false;
        if (cg4.a.a(r100) == false) goto L32;
        f.f148530o.getClass();
        if (f.f148525j == false) goto L32;
        final f r103 = f.f148529n.get(r100);
        if (r103 == null) goto L32;
        dm.a.a("IntroCardLoadOpt").a("consumeCachedIntro, isLoading=" + r103.f148531a + " isCacheAvailable=" + r103.f148535e);
        if (r103.f148531a == false) goto L12;
        r103.f148537g = new IntroCardLoadOpt$consumeCachedIntro$$inlined$let$lambda$1(r103, this, r101);
    L20:
        boolean r104 = true;
    L22:
        if (r104 == false) goto L32;
        ECContext r105 = this.f148515e;
        if (r105 == null) goto L30;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r106 = r105.getEcLivePerformanceMonitor();
        if (r106 == null) goto L30;
        ECLivePerformanceMonitor r107 = r106.getValue();
        if (r107 == null) goto L30;
        r107.C(r103.f148535e);
    L30:
        OptCardUtil.b(null, "enterload consumeCachedIntro isLoading=" + r103.f148531a + " isCacheAvailable=" + r103.f148535e);
        return true;
    L12:
        if (r103.f148535e == false) goto L21;
        r101.invoke(r103.f148534d);
        ECContext r108 = this.f148515e;
        if (r108 == null) goto L20;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r109 = r108.getEcLivePerformanceMonitor();
        if (r109 == null) goto L20;
        ECLivePerformanceMonitor r110 = r109.getValue();
        if (r110 == null) goto L20;
        r110.f(r103.f148532b, r103.f148533c);
        goto L20
    L21:
        r104 = false;
    L32:
        OptCardUtil.b(null, "consumeCachedIntro isCacheAvailable=" + this.f148512b);
        if (f148501f == true) goto L36;
    L49:
        ECContext r111 = this.f148515e;
        if (r111 == null) goto L56;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r112 = r111.getEcLivePerformanceMonitor();
        if (r112 == null) goto L56;
        ECLivePerformanceMonitor r113 = r112.getValue();
        if (r113 == null) goto L56;
        r113.C(this.f148512b);
    L56:
        return r102;
    L36:
        if (this.f148513c == false) goto L39;
        this.f148514d = r101;
    L48:
        r102 = true;
        goto L49
    L39:
        if (this.f148512b == false) goto L49;
        ECContext r114 = this.f148515e;
        if (r114 == null) goto L47;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r115 = r114.getEcLivePerformanceMonitor();
        if (r115 == null) goto L47;
        ECLivePerformanceMonitor r116 = r115.getValue();
        if (r116 == null) goto L47;
        r116.C(true);
    L47:
        r101.invoke(this.f148511a);
        goto L48
    }
}
