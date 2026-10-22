package com.bytedance.android.monitorV2.webview;

import android.webkit.WebView;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.util.r;
import com.bytedance.android.monitorV2.webview.cache.impl.WebNativeCommon;
import com.bytedance.android.monitorV2.webview.ttweb.TTUtils;
import com.bytedance.lynx.webview.TTWebSdk;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class NavigationDataManager {
    public static final Lazy<yz2.a> C = null;
    public Function1<? super JSONObject, Unit> A;
    public final Lazy B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebViewDataManager f163259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f163260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f163261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f163262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f163263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f163264f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final WebNativeCommon f163265g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public jz2.a f163266h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public jz2.b f163267i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final jz2.e f163268j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h f163269k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function3<String, BidInfo.BidConfig, String, Unit> f163270l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f163271m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f163272n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f163273o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f163274p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f163275q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile boolean f163276r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f163277s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f163278t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final wz2.b f163279u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final jz2.m f163280v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final gz2.f f163281w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f163282x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f163283y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f163284z;

    public static final class a {
        public static final yz2.a a() {
            Lazy<yz2.a> r100 = NavigationDataManager.C;
            return NavigationDataManager.C.getValue();
        }

        public a() {
        }
    }

    static {
        new a();
        C = LazyKt.lazy(NavigationDataManager$Companion$navigationInfoCollector$2.INSTANCE);
    }

    public final JSONObject b() {
        JSONObject r100 = new JSONObject();
        r100.put("nativeBase", c().f163006f.toJsonObject());
        fz2.b r101 = c().f163019m;
        JSONObject r102 = null;
        if (r101 == null) goto L5;
        JSONObject r103 = r101.toJsonObject();
    L6:
        r100.put("nativeInfo", r103);
        r100.put("jsInfo", c().f163021o);
        r100.put("jsBase", c().f163007g);
        jz2.b r104 = c().f163020n;
        if (r104 == null) goto L9;
        JSONObject r105 = r104.toJsonObject();
    L10:
        r100.put("containerInfo", r105);
        jz2.a r106 = c().f163008h;
        if (r106 == null) goto L13;
        r102 = r106.toJsonObject();
    L13:
        r100.put("containerBase", r102);
        return r100;
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public final com.bytedance.android.monitorV2.event.a c() {
        return (com.bytedance.android.monitorV2.event.a) this.B.getValue();
    }

    public final void d() {
        if (this.f163260b != null) goto L6;
        return;
    L6:
        if (this.f163276r == false) goto L8;
        return;
    L8:
        this.f163276r = true;
        wz2.b r100 = this.f163279u;
        r100.getClass();
        r100.f561926j = System.currentTimeMillis();
        j();
        nz2.b.f("NavigationDataManager", "clearNavigationData");
        i();
        j();
        this.f163269k.a(c());
        yz2.a r101 = a.a();
        if (r101 == null) goto L11;
        r101.onEventEnqueue(c());
    L11:
        this.f163269k.f163352b.d();
        this.A = null;
    }

    public final void i() {
        WebViewDataManager r100 = this.f163259a;
        r100.getClass();
        JSONObject r101 = new JSONObject();
        k r102 = r100.f163294j.get(WebViewLifeState.ATTACHED);
        Long r103 = null;
        if (r102 == null) goto L5;
        Long r104 = Long.valueOf(r102.f163357a);
    L6:
        com.bytedance.android.monitorV2.util.l.p(r101, "attach_ts", r104);
        k r105 = r100.f163294j.get(WebViewLifeState.DETACHED);
        if (r105 == null) goto L9;
        Long r106 = Long.valueOf(r105.f163357a);
    L10:
        com.bytedance.android.monitorV2.util.l.p(r101, "detach_ts", r106);
        k r107 = r100.f163294j.get(WebViewLifeState.CREATED);
        if (r107 == null) goto L13;
        r103 = Long.valueOf(r107.f163357a);
    L13:
        com.bytedance.android.monitorV2.util.l.p(r101, "container_init_ts", r103);
        boolean r108 = false;
        if (r100.f163295k <= 1) goto L16;
        boolean r109 = true;
    L17:
        com.bytedance.android.monitorV2.util.l.p(r101, "container_reuse", Boolean.valueOf(r109));
        com.bytedance.android.monitorV2.util.l.q(r101, "web_version", r100.f163299o);
        this.f163265g.saveCommonData(r101);
        this.f163265g.setContainerType(this.f163271m);
        this.f163265g.setWebViewType(this.f163272n);
        this.f163265g.setUrlCache(this.f163260b);
        this.f163265g.setClickStartTime(r.a());
        this.f163265g.setLoadUrlTime(this.f163275q);
        this.f163265g.setNavigationIdCache(this.f163277s);
        WebNativeCommon r110 = this.f163265g;
        JSONObject r111 = new JSONObject();
        WebView r112 = this.f163259a.d();
        if (r112 == null) goto L25;
        m r113 = m.f163358f;
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type com.bytedance.android.monitorV2.webview.WebViewMonitorHelper");
        if (r113.D() == false) goto L24;
        Lazy r114 = TTUtils.f163378a;
        if (TTUtils.a(r112) == false) goto L24;
        r108 = true;
    L24:
        r111.put("use_ttweb_hook", r108);
        r111.put("webview_type", this.f163272n);
    L25:
        r110.addContext(r111);
        WebView r115 = this.f163259a.d();
        if (r115 == null) goto L29;
        this.f163265g.initNativePage(r115.getContext());
        return;
    L29:
        return;
    L16:
        r109 = false;
        goto L17
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public final void j() {
        com.bytedance.android.monitorV2.event.a r100 = c();
        r100.f163008h = this.f163266h;
        com.bytedance.android.monitorV2.event.a r101 = c();
        r101.f163020n = this.f163267i;
        c().h(this.f163265g);
        jz2.m r102 = this.f163280v;
        r102.f501167b = this.f163279u.f561920d;
        com.bytedance.android.monitorV2.event.a r103 = c();
        r103.f163019m = this.f163280v;
        c().e();
    }

    public NavigationDataManager(WebViewDataManager r100) {
        Intrinsics.checkNotNullParameter(r100, "webViewDataManager");
        this.f163259a = r100;
        this.f163261c = System.currentTimeMillis();
        this.f163262d = "";
        this.f163263e = new JSONObject();
        WebNativeCommon r101 = new WebNativeCommon();
        this.f163265g = r101;
        this.f163268j = new jz2.e(r101);
        this.f163269k = new h(this);
        new BidInfo.BidConfig("__hybrid_default");
        this.f163270l = new NavigationDataManager$dataHandlerPostProcessor$1(this);
        this.f163271m = "web";
        this.f163272n = "web";
        this.f163274p = true;
        this.f163277s = com.bytedance.android.monitorV2.util.n.a();
        this.f163278t = 15;
        this.f163279u = new wz2.b(r101);
        this.f163280v = new jz2.m();
        this.f163281w = new gz2.f(CollectionsKt.listOf(new String[]{"res_loader_perf_template", "res_loader_perf", "jsbPerf"}));
        this.B = LazyKt.lazy(new NavigationDataManager$perfEvent$2(this));
        nz2.b.a("NavigationDataManager", "buildNewNavigation cache new url : " + this.f163260b);
        WebView r102 = r100.d();     // Catch: Throwable -> L25
        if (r102 == null) goto L7;
        boolean r103 = TTWebSdk.isTTWebView(r102);     // Catch: Throwable -> L25
    L8:
        if (r103 == false) goto L10;
        this.f163272n = "ttweb";
    L10:
        Map r104 = MapsKt.toMap(this.f163259a.f163298n);
        Iterator r105 = r104.keySet().iterator();
    L12:
        if (r105.hasNext() == false) goto L16;
        String r106 = (String) r105.next();
        Integer r107 = (Integer) r104.get(r106);
        if (r107 == null) goto L12;
        this.f163265g.saveExtra(r106, Integer.valueOf(r107.intValue()));
        goto L12
    L16:
        WebView r108 = this.f163259a.d();
        jz2.b r109 = null;
        if (r108 == null) goto L19;
        jz2.a r110 = sz2.a.g(r108);
    L20:
        this.f163266h = r110;
        WebView r111 = this.f163259a.d();
        if (r111 == null) goto L23;
        r109 = sz2.a.h(r111);
    L23:
        this.f163267i = r109;
        i();
        return;
    L19:
        r110 = null;
    L7:
        r103 = false;
        goto L8
    }

    public final void a(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "json");
        wz2.b r100 = this.f163279u;
        r100.getClass();
        if (r110 == null) goto L6;
        r100.f557699b = new JSONObject();
        r100.f557700c = new JSONObject();
        com.bytedance.android.monitorV2.util.l.a(r100.f557699b, r110.optJSONObject("jsBase"));
        com.bytedance.android.monitorV2.util.l.a(r100.f557700c, r110.optJSONObject("jsInfo"));
    L6:
        if (this.f163276r == true) goto L40;
        c().f163007g = r110.optJSONObject("jsBase");
        c().f163021o = r110.optJSONObject("jsInfo");
        JSONObject r111 = c().f163021o;
        if (r111 == null) goto L33;
        Function1<Long, Unit> r101 = new NavigationDataManager$coverPerfEvent$1$1(this);
        com.bytedance.android.monitorV2.util.k r102 = new com.bytedance.android.monitorV2.util.k(r111);
        Long r112 = r102.c("actual_fmp", 0L);
        if (r112 == null) goto L13;
        long r103 = r112.longValue();
    L14:
        this.f163282x = r103;
        if (r103 != 0) goto L21;
        Long r113 = r102.c("fmp", 0L);
        if (r113 == null) goto L19;
        r103 = r113.longValue();
    L20:
        this.f163283y = r103;
        goto L21
    L19:
        r103 = 0;
    L21:
        Long r114 = r102.c("timing.navigationStart", 0L);
        if (r114 == null) goto L24;
        long r104 = r114.longValue();
    L26:
        if (r103 != 0) goto L29;
        long r105 = System.currentTimeMillis();
    L32:
        r101.invoke(Long.valueOf(r105));
        goto L33
    L29:
        if (r104 != 0) goto L31;
        r105 = System.currentTimeMillis();
        goto L32
    L31:
        r105 = r104 + r103;
        goto L32
    L24:
        r104 = 0;
        goto L26
    L13:
        r103 = 0;
    L33:
        c().e();
        JSONObject r115 = c().f163021o;
        if (r115 != null) goto L36;
    L38:
        nz2.b.f("NavigationDataManager", "coverPerf " + c().hashCode());
        return;
    L36:
        if (r115.has("actual_fmp") == false) goto L38;
        this.f163268j.a(4);
        goto L38
    }

    public final boolean e(String r110) {
        boolean r100 = false;
        if (this.f163274p == true) goto L18;
        return false;
    L18:
        String r101 = UriProtector.parse(r110).getHost();     // Catch: Throwable -> L14
        if (r101 != null) goto L8;
        return false;
    L8:
        Set<String> r102 = com.bytedance.android.monitorV2.g.e().d().e();     // Catch: Throwable -> L14
        List r103 = StringsKt.split$default(r101, new String[]{"."}, false, 0, 6, null);     // Catch: Throwable -> L14
        int r104 = r103.size() - 1;     // Catch: Throwable -> L14
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L16;
        if (r102.contains(CollectionsKt.joinToString$default(r103.subList(r105, r103.size()), ".", null, null, 0, null, null, 62, null)) == true) goto L12;
        r105 = r105 + 1;
        goto L9
    L12:
        r100 = true;
    L16:
        this.f163274p = r100;
        return r100;
    L14:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        goto L16
    }

    public final void f(com.bytedance.android.monitorV2.event.b r100) {
        Intrinsics.checkNotNullParameter(r100, "customEvent");
        this.f163269k.a(r100);
        yz2.a r101 = a.a();
        if (r101 == null) goto L6;
        r101.onEventEnqueue(r100);
        return;
    }

    public NavigationDataManager(WebViewDataManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "webViewDataManager");
        Intrinsics.checkNotNullParameter(r101, "url");
        this(r100);
        this.f163260b = r101;
        this.f163265g.url = r101;
    }

    public final void g(String r100, JSONObject r101) {
        if (r100 == null) goto L11;
        com.bytedance.android.monitorV2.event.a r102 = new com.bytedance.android.monitorV2.event.a(r100);
        r102.c();
        Map<String, Object> r103 = r102.f163005e;
        c r104 = this.f163259a.c();
        if (r104 == null) goto L6;
        String r105 = r104.f163342g;
    L7:
        r103.put("config_bid", r105);
        r102.h(this.f163265g);
        r102.f163021o = com.bytedance.android.monitorV2.util.l.i(r101, "jsInfo");
        r102.f163007g = com.bytedance.android.monitorV2.util.l.i(r101, "jsBase");
        this.f163269k.a(r102);
        yz2.a r106 = a.a();
        if (r106 == null) goto L10;
        r106.onEventEnqueue(r102);
    L10:
        this.f163268j.update(r102);
        Intrinsics.checkNotNullParameter(r102, "event");
        this.f163268j.b(r102, 0, "");
        goto L11
    L6:
        r105 = null;
    L11:
        this.f163279u.a(r100);
    }

    public final void h(com.bytedance.android.monitorV2.event.a r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (Intrinsics.areEqual("blank", r100.f163001a) == false) goto L5;
        com.bytedance.android.monitorV2.util.l.o(r101, "enter_page_time", this.f163261c);
    L5:
        r100.h(this.f163265g);
        String r102 = r100.f163001a;
        if (r101 != null) goto L8;
        r101 = new JSONObject();
    L8:
        r100.f163019m = new jz2.l(r102, r101);
        this.f163269k.a(r100);
        yz2.a r103 = a.a();
        if (r103 == null) goto L11;
        r103.onEventEnqueue(r100);
    L11:
        this.f163268j.update(r100);
        this.f163279u.a(r100.f163001a);
        this.f163281w.a(r100);
    }
}
