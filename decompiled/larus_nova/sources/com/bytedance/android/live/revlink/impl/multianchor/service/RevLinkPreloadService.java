package com.bytedance.android.live.revlink.impl.multianchor.service;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAudienceDataContext;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.vm.RevLinkPreloadContext;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.live.revlink.impl.service.internal.LinkRevInternalServiceContext;
import com.bytedance.android.livesdk.link.model.r;
import com.bytedance.android.livesdkapi.util.RxP4SchedulerHelper;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kc0.t;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class RevLinkPreloadService implements t, h {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final List<Long> f94642s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f94643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ExtraResponse<r, Extra> f94644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ExtraResponse<r, Extra> f94645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f94646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f94647e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f94648f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f94649g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f94650h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h.b f94651i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h.c f94652j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f94653k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f94654l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f94655m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f94656n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f94657o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f94658p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f94659q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f94660r;

    public static final class a {
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.h
    public final void g() {
        this.f94651i = null;
        this.f94652j = null;
    }

    static {
        f94642s = CollectionsKt.listOf(new Long[]{Long.valueOf(6), Long.valueOf(2)});
    }

    @Override // kc0.t
    public final void detach() {
        jy0.b.c("MultiLinkPreloadWidget", "PreloadWidget detach for channelID: " + this.f94655m + " roomID: " + this.f94656n, null, 4);
        this.f94644b = null;
        this.f94645c = null;
        Disposable r100 = this.f94648f;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f94651i = null;
        this.f94652j = null;
        this.f94653k = false;
        this.f94654l = false;
        this.f94655m = 0;
        this.f94657o = 0;
        this.f94658p = 0;
        this.f94659q = 0;
        this.f94660r = 0;
        this.f94650h.clear();
        RevLinkLayoutPreloadContext r101 = RevLinkLayoutPreloadContext.Companion.getContext(Long.valueOf(this.f94656n));
        if (r101 == null) goto L12;
        com.bytedance.live.datacontext.j<f> r102 = r101.getService();
        if (r102 == null) goto L12;
        f r103 = r102.getValue();
        if (r103 == null) goto L12;
        r103.d("detach");
    L12:
        Disposable r104 = this.f94649g;
        if (r104 == null) goto L16;
        r104.dispose();
        return;
    }

    public RevLinkPreloadService() {
        this.f94650h = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.h
    public final void d() {
        s1.getContext();
    }

    @Override // kc0.t
    public final void c(long r100) {
        jy0.b.c("MultiLinkPreloadWidget", "PreloadWidget attach for channelID: " + this.f94655m + " roomID: " + r100, null, 4);
        this.f94656n = r100;
        Pair r101 = com.bytedance.live.datacontext.d.a(RevLinkPreloadService$attach$1.INSTANCE);
        com.bytedance.live.datacontext.b.a((DataContext) r101.getFirst(), "MultiLinkPreloadWidget" + r100);
        ((RevLinkPreloadContext) r101.getFirst()).getService().d(this);
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) r101.getSecond(), this.f94650h);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.h
    public final void e(PkDoubleAudienceDataContext.C99401 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f94652j = r100;
        ExtraResponse<r, Extra> r101 = this.f94645c;
        if (r101 == null) goto L6;
        r100.b(this.f94660r, this.f94658p, r101, true);
        this.f94645c = null;
        this.f94658p = 0;
        this.f94660r = 0;
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.h
    public final void f(h.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f94651i = r100;
        ExtraResponse<r, Extra> r101 = this.f94644b;
        if (r101 == null) goto L6;
        r100.b(this.f94659q, this.f94657o, r101, true);
        this.f94644b = null;
        this.f94657o = 0;
        this.f94659q = 0;
        return;
    }

    public static final void i(RevLinkPreloadService r100, long r101) {
        r100.getClass();
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r102 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        r102.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.dynamic.a.f97535f.getValue(r102, com.bytedance.android.live.revlink.impl.settings.dynamic.a.f97530a[4])).booleanValue() == false) goto L13;
        LiveFullLinkPKMonitor r103 = com.bytedance.android.live.revlink.impl.global.b.q();
        if (r103 == null) goto L13;
        q r104 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r104 == null) goto L11;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r105 = r104.g();
        if (r105 == null) goto L11;
        int r106 = r105.isBattleStatsObtained();
    L12:
        LiveFullLinkPKMonitor.n(r103, r106, SystemClock.elapsedRealtime() - r101, 1);
    L11:
        r106 = 0;
    L13:
        jy0.b.d("RevLinkPreloadWidget", "load success time = " + (SystemClock.elapsedRealtime() - r101));
        jy0.b.d("RevLinkPreloadWidget", "lynx load success ");
    }

    public static final void h(RevLinkPreloadService r100, String r101, String r102) {
        r100.getClass();
        LiveFullLinkPKMonitor r103 = com.bytedance.android.live.revlink.impl.global.b.q();
        if (r103 != null) goto L5;
    L11:
        jy0.b.c("RevLinkPreloadWidget", "lynx load error errMsg = " + r102, null, 4);
        r100.getClass();
        return;
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        if (r102 != null) goto L9;
        String r104 = "";
    L10:
        LiveFullLinkPKMonitor.o(r103, "link_dynamic_central_load_failed", r101, r104, 0, 0, 24);
        goto L11
    L9:
        r104 = r102;
        goto L10
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.h
    public final boolean a(long r100, long r101, long r102, boolean r110) {
        if (r100 == this.f94656n) goto L5;
        return false;
    L5:
        if (r101 != this.f94655m) goto L22;
        long r103 = r102 - this.f94646d;
        u41.b r104 = u41.b.f548656i;
        r104.getClass();
        if (r103 <= ((Number) u41.b.f548654g.getValue(r104, u41.b.f548648a[5])).longValue()) goto L10;
        return false;
    L10:
        if (r110 == false) goto L17;
        if (this.f94644b == null) goto L14;
    L15:
        return true;
    L14:
        if (this.f94653k == true) goto L15;
        return false;
    L17:
        if (this.f94645c != null) goto L15;
        if (this.f94654l == true) goto L15;
        return false;
    L22:
        return false;
    }

    @Override // kc0.t
    public final void b(Context r210, long r211, long r212, String r310, long r311, String r312, Map<String, String> r313) {
        Intrinsics.checkNotNullParameter(r312, "rawSei");
        this.f94656n = r212;
        this.f94643a = r313;
        if (r210 != null) goto L5;
    L77:
        String r100 = "MultiLinkPreloadWidget";
    L79:
        if (u41.b.f548656i.b() == true) goto L82;
        return;
    L82:
        if (r311 == 6) goto L84;
        long r101 = 2;
        if (r311 == r101) goto L108;
        return;
    L108:
        if (this.f94656n != 0) goto L110;
        return;
    L110:
        if (this.f94654l == false) goto L112;
        return;
    L112:
        if (((wh6.a) vh6.c.b(wh6.a.class)).n2() == false) goto L149;
        Disposable r102 = this.f94648f;
        if (r102 == null) goto L117;
        r102.dispose();
    L117:
        this.f94655m = r211;
        i97.a r103 = i97.a.f488802a;
        this.f94646d = System.currentTimeMillis();
        this.f94645c = null;
        jy0.b.c(r100, "start preload battleStats for roomID: " + this.f94656n, null, 4);
        long r104 = System.currentTimeMillis();
        this.f94658p = com.bytedance.live.kmp.util.e.b();
        this.f94654l = true;
        if (com.bytedance.android.live.revlink.impl.global.b.r() == null) goto L120;
        String r105 = d21.d.c(PkDoubleAudienceDataContext.BattleStatsFromType.PKingInRoom.ordinal());
    L121:
        Observable r106 = r31.b.a(r31.a.f535859a).O(r211, r101, 1, true, r105, r212, r310);
        if (r106 == null) goto L145;
        Observable r107 = r106.compose(RxP4SchedulerHelper.rxP4SchedulerHelper());
        if (r107 == null) goto L146;
        Disposable r108 = r107.subscribe(new l(this, r104, r211, r105), new m(this, r211, r105));
        if (r108 == null) goto L147;
        com.bytedance.revenue.platform.api.core.rx.f.a(r108, this.f94650h);
        return;
    L147:
        return;
    L146:
        return;
    L145:
        return;
    L120:
        r105 = "";
        goto L121
    L149:
        return;
    L84:
        if (r211 != 0) goto L86;
    L104:
        jy0.b.c(r100, "intercept preload linkmic/list !!! channelID: " + r211 + " roomID: " + r212 + ' ' + this.f94653k, null, 4);
        return;
    L86:
        if (r212 == 0) goto L104;
        if (this.f94653k == true) goto L104;
        if (((wh6.a) vh6.c.b(wh6.a.class)).n2() == false) goto L104;
        jy0.b.f(r100, "start preload linkmic/list channelID: " + r211 + " roomID: " + r212, null, 4);
        Disposable r109 = this.f94648f;
        if (r109 == null) goto L95;
        r109.dispose();
    L95:
        this.f94655m = r211;
        i97.a r110 = i97.a.f488802a;
        this.f94646d = System.currentTimeMillis();
        this.f94644b = null;
        this.f94653k = true;
        this.f94657o = com.bytedance.live.kmp.util.e.b();
        long r111 = System.currentTimeMillis();
        Observable r112 = r31.b.a(r31.a.f535859a).v(r211, 4, r212);
        if (r112 == null) goto L102;
        Observable r113 = r112.compose(RxP4SchedulerHelper.rxP4SchedulerHelper());
        if (r113 == null) goto L102;
        Disposable r114 = r113.subscribe(new j(this, r211, r212, r111), new k(this, r211, r111));
        if (r114 == null) goto L102;
        com.bytedance.revenue.platform.api.core.rx.f.a(r114, this.f94650h);
        Disposable r115 = r114;
    L103:
        this.f94648f = r115;
        return;
    L102:
        r115 = null;
        goto L103
    L5:
        if (r212 == 0) goto L77;
        if (f94642s.contains(Long.valueOf(r311)) == false) goto L77;
        long r116 = 6;
        if (r311 != r116) goto L14;
        z41.e.f569909d.getClass();
        if (z41.e.f569908c.e9() == true) goto L14;
    L18:
        r100 = "MultiLinkPreloadWidget";
    L14:
        long r117 = 2;
        if (r311 != r117) goto L19;
        z41.e.f569909d.getClass();
        if (z41.e.f569908c.S7() == false) goto L18;
    L19:
        com.bytedance.android.live.revlink.impl.global.c r118 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r118 == null) goto L22;
        LinkRevInternalServiceContext r119 = r118.Cj();
    L23:
        if (r119 == null) goto L25;
        r100 = "MultiLinkPreloadWidget";
        jy0.b.c(r100, "intercept preInflateLayout, controlWidget already loaded", null, 4);
        goto L79
    L25:
        r100 = "MultiLinkPreloadWidget";
        if (this.f94647e <= 0) goto L30;
        i97.a r120 = i97.a.f488802a;
        if ((System.currentTimeMillis() - this.f94647e) >= 2000) goto L30;
        jy0.b.c(r100, "intercept preInflateLayout, too frequently", null, 4);
    L30:
        i97.a r121 = i97.a.f488802a;
        this.f94647e = System.currentTimeMillis();
        RevLinkLayoutPreloadContext.a r122 = RevLinkLayoutPreloadContext.Companion;
        RevLinkLayoutPreloadContext r123 = r122.getContext(Long.valueOf(r212));
        jy0.b.f(r100, "preInflateLayout for " + r212 + ' ' + r311 + ' ' + r123 + ' ' + this, null, 4);
        if (r123 != null) goto L33;
        Pair r124 = com.bytedance.live.datacontext.d.a(RevLinkPreloadService$preInflateLayout$1.INSTANCE);
        com.bytedance.live.datacontext.b.a((DataContext) r124.getFirst(), "RevLinkLayoutPreloadContext_" + r212);
        ((RevLinkLayoutPreloadContext) r124.getFirst()).getService().d(new p31.a(r210));
        this.f94649g = (Disposable) r124.getSecond();
    L33:
        RevLinkLayoutPreloadContext r125 = r122.getContext(Long.valueOf(r212));
        if (r125 == null) goto L38;
        com.bytedance.live.datacontext.j<f> r126 = r125.getService();
        if (r126 == null) goto L38;
        f r127 = r126.getValue();
    L39:
        if (r311 != r116) goto L71;
        int r128 = StringsKt.indexOf$default(r312, "grids", 0, false, 6, null);
        if (r128 >= 0) goto L43;
        jy0.b.c(r100, "can not find grids in sei", null, 4);
    L67:
        int r129 = 0;
    L69:
        if (r127 == null) goto L74;
        r127.b(r129);
    L74:
        Disposable r130 = Single.timer(6, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(r212));
        if (r130 == null) goto L79;
        this.f94650h.add(r130);
        goto L79
    L43:
        int r131 = r312.length();
    L44:
        if (r128 >= r131) goto L49;
        if (r312.charAt(r128) == '[') goto L49;
        r128 = r128 + 1;
    L49:
        if (r128 >= r131) goto L53;
        if (r312.charAt(r128) == '{') goto L53;
        r128 = r128 + 1;
    L53:
        int r132 = 0;
        int r133 = 0;
    L54:
        if (r128 >= r131) goto L66;
        if (r312.charAt(r128) == ']') goto L66;
        if (r312.charAt(r128) != '{') goto L61;
        r133 = r133 + 1;
    L65:
        r128 = r128 + 1;
        goto L54
    L61:
        if (r312.charAt(r128) != '}') goto L65;
        r133 = r133 - 1;
        if (r133 != 0) goto L65;
        r132 = r132 + 1;
    L66:
        if (r133 != 0) goto L67;
        r129 = RangesKt.coerceAtMost(r132, 4);
        goto L69
    L71:
        if (r311 != r117) goto L74;
        if (r127 == null) goto L74;
        r127.c();
    L38:
        r127 = null;
        goto L39
    L22:
        r119 = null;
        goto L23
    }
}
