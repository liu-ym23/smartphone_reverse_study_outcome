package com.bytedance.android.shopping.mall.homepage.component;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.k;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.IECNativeHomeArgument;
import com.bytedance.android.shopping.api.mall.MallPageName;
import com.bytedance.android.shopping.api.mall.ability.MallAbilityManager;
import com.bytedance.android.shopping.api.mall.common.tools.l;
import com.bytedance.android.shopping.api.mall.model.SkinConfig;
import com.bytedance.android.shopping.api.mall.model.SkinConfigPage;
import com.bytedance.android.shopping.api.mall.model.SkinConfigStyle;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.homepage.ECMallFragment;
import com.bytedance.android.shopping.mall.homepage.MallUtil;
import com.bytedance.android.shopping.mall.homepage.tools.ECMallFavoriteSectionHelper;
import com.bytedance.android.shopping.mall.homepage.tools.q;
import com.bytedance.android.shopping.mall.utils.ECMallSkinManager;
import com.bytedance.android.shopping.mall.widget.ECDetectableFrameLayout;
import com.bytedance.android.shopping.mall.widget.ECTouchEventDetector;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.nova.R;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class ECFMiddleware extends u93.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bf3.a f178100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECMallFeed f178101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ECHybridListEngine f178102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f178103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f178104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f178105f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final jf3.c f178106g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ik.a f178107h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f178108i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData<Integer> f178109j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f178110k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f178111l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f178112m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ViewGroup f178113n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewGroup f178114o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f178115p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ECMallSkinManager f178116q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public af3.e f178117r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f178118s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f178119t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final com.bytedance.android.shopping.mall.homepage.pagecard.d f178120u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f178121v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f178122w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile ck.a f178123x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final a f178124y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ECMallFragment f178125z;

    public static final class a extends ECTouchEventDetector {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ ECFMiddleware f178126h;

        @Override // com.bytedance.android.shopping.mall.widget.ECTouchEventDetector
        public final void a() {
            d(false);
        }

        @Override // com.bytedance.android.shopping.mall.widget.ECTouchEventDetector
        public final void b() {
            d(true);
        }

        public a(ECFMiddleware r100) {
            this.f178126h = r100;
        }

        public final void d(boolean r110) {
            ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.mallFeedDidClick", System.currentTimeMillis(), (String) this.f178126h.f178110k.getValue(), false, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_long_click", Boolean.valueOf(r110))}), false, 40));
        }

        @Override // com.bytedance.android.shopping.mall.widget.ECTouchEventDetector
        public final void c(int r100, int r101, int r102, int r103) {
            ECMallFeed r104 = this.f178126h.f178101b;
            if (r104 == null) goto L6;
            r104.Q(r100, r101, r102, r103);
            return;
        }
    }

    public final IECNativeHomeArgument f() {
        return (IECNativeHomeArgument) this.f178103d.getValue();
    }

    public final String a() {
        if (this.f178116q.a() == false) goto L5;
        return "dark";
    L5:
        return "light";
    }

    public final String b() {
        SkinConfig r100 = (SkinConfig) new Gson().fromJson(this.f178116q.f178599b, SkinConfig.class);     // Catch: Exception -> L4
    L13:
        if (k() == false) goto L20;
        if (r100 == null) goto L26;
        SkinConfigStyle r101 = r100.getDark();
        if (r101 == null) goto L26;
        SkinConfigPage r102 = r101.getPageStyle();
        if (r102 == null) goto L26;
    L30:
        return r102.getBgUrl();
    L26:
        return null;
    L20:
        if (r100 == null) goto L26;
        SkinConfigStyle r103 = r100.getLight();
        if (r103 == null) goto L26;
        r102 = r103.getPageStyle();
        if (r102 == null) goto L26;
    L4:
        e = move-exception;
        SkinConfig r104 = new SkinConfig(null, null, null, 7, null);
        IHybridHostService r105 = com.bytedance.android.ec.hybrid.a.h();
        if (r105 == null) goto L11;
        String r106 = e.getMessage();
        if (r106 != null) goto L10;
        r106 = "";
    L10:
        r105.ensureNotReachHere(r106);
    L11:
        r100 = r104;
        goto L13
    }

    public final String c() {
        if (this.f178115p.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        Object r101 = null;
        boolean r102 = r101 instanceof String;
        String r103 = (String) null;
        this.f178115p = "";
    L9:
        return this.f178115p;
    L5:
        r100 = false;
        goto L6
    }

    public final String e() {
        if (this.f178112m.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        Object r101 = null;
        boolean r102 = r101 instanceof String;
        String r103 = (String) null;
        this.f178112m = "homepage";
    L9:
        return this.f178112m;
    L5:
        r100 = false;
        goto L6
    }

    public final ck.a g() {
        if (((Boolean) this.f178121v.getValue()).booleanValue() == false) goto L8;
        Lazy r100 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(k.e.f47505b, "popupUseNewComponent = true, use popupLayerAbility");
        bf3.a r101 = this.f178100a;
        if (r101.f18817a != null) goto L10;
        ConcurrentHashMap<Class<? extends e93.d>, Map<String, MallAbilityManager.a<? extends e93.d>>> r102 = MallAbilityManager.f170215a;
        r101.f18817a = (e93.b) MallAbilityManager.b(e93.b.class, r101.f18818b);
    L10:
        return r101.f18817a;
    L8:
        Lazy r103 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(k.e.f47505b, "popupUseNewComponent = false, use popupManager");
        return this.f178123x;
    }

    public final ViewGroup h() {
        if (this.f178114o != null) goto L10;
        View r100 = this.f178125z.getView();
        if (r100 == null) goto L7;
        FrameLayout r101 = (FrameLayout) r100.findViewById(R.id.ec_mall_popup_layer_card_container);
    L8:
        this.f178114o = r101;
        goto L10
    L7:
        r101 = null;
    L10:
        return this.f178114o;
    }

    public final ViewGroup i() {
        if (this.f178113n != null) goto L16;
        View r100 = this.f178125z.getView();
        ViewGroup r101 = null;
        if (r100 == null) goto L7;
        ViewGroup r102 = (ViewGroup) r100.findViewById(R.id.topbar);
    L8:
        this.f178113n = r102;
        if ((r102 instanceof ECDetectableFrameLayout) == false) goto L12;
        r101 = r102;
    L12:
        ECDetectableFrameLayout r103 = (ECDetectableFrameLayout) r101;
        if (r103 == null) goto L16;
        r103.setTouchEventDetector(this.f178124y);
        goto L16
    L7:
        r102 = null;
    L16:
        return this.f178113n;
    }

    public final String j() {
        if (this.f178119t.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L14;
        Object r101 = MapsKt.emptyMap().get("tab_id");
        if (r101 == null) goto L11;
        String r102 = r101.toString();
        if (r102 == null) goto L11;
    L12:
        this.f178119t = r102;
    L11:
        r102 = "0";
    L14:
        return this.f178119t;
    L5:
        r100 = false;
        goto L6
    }

    public final boolean k() {
        return this.f178116q.a();
    }

    public final Map<String, String> l() {
        Lazy r100 = MallUtil.f177398a;
        Long r101 = this.f178104e;
        String r102 = e();
        String r103 = c();
        Intrinsics.checkNotNullParameter(r102, "pageName");
        Intrinsics.checkNotNullParameter(r103, "enterFrom");
        if (r101 == null) goto L6;
        String r104 = String.valueOf(r101.longValue());
        if (r104 == null) goto L6;
    L8:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("na_offline_version", r104), TuplesKt.to("na_page_name", r102), TuplesKt.to("enter_from", r103), TuplesKt.to("mall_hybrid_monitor_vid", (String) MallUtil.f177398a.getValue())});
    L6:
        r104 = "-1";
        goto L8
    }

    public final com.bytedance.android.shopping.mall.homepage.pagecard.c m() {
        return this.f178120u.a();
    }

    public final Map<String, Object> d() {
        String r100 = a();
        Lazy r101 = HybridAppInfoService.f47530a;
        if (HybridAppInfoService.h() == true) goto L7;
        return null;
    L7:
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("appTheme", r100)});
    }

    public ECFMiddleware(ECMallFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f178125z = r100;
        this.f178100a = new bf3.a(r100);
        this.f178103d = LazyKt.lazy(new ECFMiddleware$parentArguments$2(this));
        this.f178105f = LazyKt.lazy(new ECFMiddleware$preloadTaskManager$2(this));
        this.f178106g = new jf3.c();
        this.f178107h = new ik.a();
        this.f178108i = new Handler(Looper.getMainLooper());
        this.f178109j = new MutableLiveData();
        this.f178110k = LazyKt.lazy(new ECFMiddleware$sceneID$2(this));
        this.f178112m = "";
        this.f178115p = "";
        this.f178116q = new ECMallSkinManager(this);
        this.f178118s = LazyKt.lazy(new ECFMiddleware$favoriteSectionHelper$2(this));
        this.f178119t = "";
        this.f178120u = new com.bytedance.android.shopping.mall.homepage.pagecard.d();
        this.f178121v = LazyKt.lazy(ECFMiddleware$popupUseNewComponent$2.INSTANCE);
        this.f178122w = LazyKt.lazy(ECFMiddleware$enableSkinCMS$2.INSTANCE);
        this.f178124y = new a(this);
    }

    public final void n(y93.d r210) {
        Intrinsics.checkNotNullParameter(r210, "monitorBean");
        if (r210.f566970a == false) goto L5;
        return;
    L5:
        JSONObject r110 = new JSONObject();
        r110.put("type", "LYNX_RENDER_LOG");
        r110.put(ChameleonOpenTracker.ParamKey.RES_VERSION, this.f178104e);
        int r100 = f93.a.f475963a;
        f93.a.c(r110, this.f178125z.fa0("c0.d0", false, null));
        r110.put("page_name", e());
        r110.putOpt("enter_from", c());
        r110.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        String r101 = ((ECMallFavoriteSectionHelper) this.f178118s.getValue()).f178453v;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r110.put("log_id", r101);
        r110.put(CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY, r210.f());
        r110.put("error_msg", r210.b());
        r110.put("perf_dict", r210.e());
        r110.put("detail", new JSONObject(GsonProtectorUtils.toJson(new Gson(), y93.d.a(r210, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, 8388078))));
        l r102 = l.f170445a;
        IECNativeHomeArgument r103 = f();
        if (r103 == null) goto L11;
        Integer r111 = r103.getReportSlardar();
    L12:
        l.b(r102, r110, r111, false, 12);
        return;
    L11:
        r111 = null;
        goto L12
    }

    public final void o(String r100, boolean r101) {
        ECMallSkinManager r102 = this.f178116q;
        r102.f178599b = r100;
        String r103 = null;
        Boolean r104 = com.bytedance.android.shopping.mall.background.a.a(r100, null).isDarkMode();
        Boolean r105 = Boolean.TRUE;
        boolean r106 = Intrinsics.areEqual(r104, r105);
        boolean r107 = true;
        if ((!Intrinsics.areEqual(r102.b().getValue(), Boolean.valueOf(r106))) == false) goto L5;
        r102.b().setValue(Boolean.valueOf(r106));
    L5:
        Context r108 = r102.f178602e.f178125z.getContext();
        if (r101 == true) goto L34;
        if (r108 == null) goto L35;
        String r109 = r102.f178599b;
        ECFMiddleware r110 = r102.f178602e;
        if (Intrinsics.areEqual(r110.e(), MallPageName.X_TAB_MALL) == true) goto L14;
        IECNativeHomeArgument r111 = r110.f();
        if (r111 == null) goto L14;
        r103 = r111.getDataEngineTag();
    L14:
        Intrinsics.checkNotNullParameter(r108, PerfLog.PARAM_KEY_CONTEXT_ID);
        StringBuilder r112 = new StringBuilder();
        if (r103 != null) goto L17;
    L20:
        if (r107 == false) goto L22;
        r103 = "default";
    L22:
        r112.append(r103);
        r112.append("_douyin_skin");
        String r113 = r112.toString();
        if (r109 == null) goto L25;
        q.f(r108, r113, r109);
    L29:
        if (((Boolean) r102.f178601d.getValue()).booleanValue() == false) goto L36;
        IHybridHostService r114 = com.bytedance.android.ec.hybrid.a.h();
        if (r114 == null) goto L37;
        r114.updateThemeStorage(r108, r102.f178602e.e(), Intrinsics.areEqual(r102.b().getValue(), r105));
        return;
    L37:
        return;
    L36:
        return;
    L25:
        if (q.c(r108, "ec_mall_cache_storage").contains(r113) == false) goto L29;
        q.c(r108, "ec_mall_cache_storage").edit().remove(r113).apply();
        goto L29
    L17:
        if (r103.length() == 0) goto L20;
        r107 = false;
        goto L20
    L35:
        return;
    }
}
