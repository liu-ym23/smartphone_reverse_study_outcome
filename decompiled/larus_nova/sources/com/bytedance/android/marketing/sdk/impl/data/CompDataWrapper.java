package com.bytedance.android.marketing.sdk.impl.data;

import android.R;
import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.marketing.sdk.impl.actions.p;
import com.bytedance.android.marketing.sdk.impl.utils.CommonUtils;
import com.bytedance.android.marketing.sdk.impl.utils.ECMarketingErrorType;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.socialbase.appdownloader.ah.DevicePlans;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class CompDataWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f162702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f162703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f162704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public fx2.f f162705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public fx2.b f162706e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f162707f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WindowManager f162708g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FragmentManager.FragmentLifecycleCallbacks f162709h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FragmentManager f162710i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f162711j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f162712k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f162713l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f162714m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function0<RitDataWrapper> f162715n;

    public final JSONObject g() {
        Map<String, h> r100 = ECMarketingDataCenter.f162719a;
        Map<String, com.bytedance.android.marketing.sdk.api.c> r101 = ECMarketingDataCenter.f162720b;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        com.bytedance.android.marketing.sdk.api.c r103 = (com.bytedance.android.marketing.sdk.api.c) r102.get(this.f162712k);
        if (r103 == null) goto L5;
        LinkedHashMap r104 = new LinkedHashMap();
        r104.putAll(r103.f162681l);
        Unit r105 = Unit.INSTANCE;
        JSONObject r106 = ex2.d.b(r104);
        if (r106 == null) goto L9;
        return r106;
    L9:
        return new JSONObject();
    L5:
        return new JSONObject();
    }

    public final Map<String, Object> h() {
        Function0<RitDataWrapper> r100 = this.f162715n;
        Long r101 = null;
        if (r100 == null) goto L9;
        RitDataWrapper r102 = r100.invoke();
        if (r102 == null) goto L9;
        h r103 = r102.f162746p;
        if (r103 == null) goto L9;
        TrackData r104 = r103.f162802h;
    L10:
        Pair[] r105 = new Pair[5];
        r105[0] = TuplesKt.to("ec_marketing_biz_params", g());
        CommonUtils.f162812a.getClass();
        r105[1] = TuplesKt.to("ec_marketing_ohr_info", CommonUtils.b());
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("native_show_pendant_time", Long.valueOf(System.currentTimeMillis()));
        Unit r107 = Unit.INSTANCE;
        JSONObject r108 = ex2.d.b(r106);
        if (r108 != null) goto L13;
        r108 = new JSONObject();
    L13:
        r105[2] = TuplesKt.to("ec_marketing_extra_business_info", r108);
        r105[3] = TuplesKt.to("ec_marketing_page_id", this.f162712k);
        int r109 = com.bytedance.android.marketing.sdk.impl.utils.e.f162816a;
        if (r104 == null) goto L16;
        Long r110 = Long.valueOf(r104.getTOpenTime());
    L17:
        if (r104 == null) goto L19;
        Long r111 = Long.valueOf(r104.getTNativeHandleTime());
    L20:
        if (r104 == null) goto L22;
        r101 = Long.valueOf(r104.getTMarketingFirstScreen());
    L22:
        r105[4] = TuplesKt.to("ec_marketing_load_time", com.bytedance.android.marketing.sdk.impl.utils.e.a(r110, r111, r101));
        return MapsKt.mapOf(r105);
    L19:
        r111 = null;
        goto L20
    L16:
        r110 = null;
    L9:
        r104 = null;
        goto L10
    }

    public final View i() {
        fx2.f r100 = this.f162705d;
        if (r100 == null) goto L6;
        View r101 = r100.getHybridView();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return null;
    }

    public final RitDataWrapper j() {
        Function0<RitDataWrapper> r100 = this.f162715n;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.invoke();
    }

    public final void c() {
        RitDataWrapper r100 = j();
        if (r100 == null) goto L5;
        String r101 = r100.f162732b;
    L7:
        if (Intrinsics.areEqual(r101, this.f162714m) == false) goto L15;
        d(this.f162706e);
        this.f162706e = null;
        d(this.f162705d);
        this.f162705d = null;
        this.f162708g = null;
        FragmentManager.FragmentLifecycleCallbacks r102 = this.f162709h;
        if (r102 == null) goto L13;
        FragmentManager r103 = this.f162710i;
        if (r103 == null) goto L13;
        r103.unregisterFragmentLifecycleCallbacks(r102);
    L13:
        this.f162709h = null;
        this.f162710i = null;
        return;
    L15:
        return;
    L5:
        r101 = null;
        goto L7
    }

    public final JSONObject e() {
        RitDataWrapper r100 = j();
        com.bytedance.android.marketing.sdk.api.c r101 = (com.bytedance.android.marketing.sdk.api.c) ((LinkedHashMap) ECMarketingDataCenter.f162720b).get(this.f162712k);
        JSONObject r102 = null;
        if (r101 == null) goto L5;
        String r103 = ex2.c.a(r101);
    L6:
        JSONObject r104 = new JSONObject();
        r104.put("pageId", this.f162712k);
        r104.put(BdpAppEventConstant.PARAMS_RIT, this.f162713l);
        r104.put("compName", this.f162714m);
        Gson r105 = com.bytedance.android.marketing.sdk.impl.utils.f.f162817a;
        com.bytedance.android.marketing.sdk.impl.utils.f.c(r104, this.f162703b, true);
        r104.put("isDefaultView", k());
        if (r100 == null) goto L14;
        LinkedHashMap r106 = new LinkedHashMap();
        Map<String, ? extends Object> r107 = r100.f162746p.f162800f;
        if (r107 == null) goto L11;
        r106.putAll(r107);
    L11:
        Map<String, ? extends Object> r108 = r100.f162737g;
        if (r108 == null) goto L15;
        r106.putAll(r108);
    L15:
        r104.put("commonLogParams", ex2.d.b(r106));
        if (r100 == null) goto L23;
        LinkedHashMap r109 = new LinkedHashMap();
        Map<String, ? extends Object> r110 = r100.f162746p.f162799e;
        if (r110 == null) goto L20;
        r109.putAll(r110);
    L20:
        Map<String, ? extends Object> r111 = r100.f162736f;
        if (r111 == null) goto L24;
        r109.putAll(r111);
    L24:
        r104.put(ControlRule.KEY_EXTRA_DATA, ex2.d.b(r109));
        r104.put("customData", ex2.d.b(this.f162704c));
        if ((r103 instanceof String) == true) goto L27;
        r103 = null;
    L27:
        if (r103 == null) goto L29;
        r104.put(r103, ((LinkedHashMap) ECMarketingDataCenter.f162724f).get(r103));
    L29:
        Function0<RitDataWrapper> r112 = this.f162715n;
        if (r112 == null) goto L38;
        RitDataWrapper r113 = r112.invoke();
        if (r113 == null) goto L38;
        h r114 = r113.f162746p;
        if (r114 == null) goto L38;
        TrackData r115 = r114.f162802h;
        if (r115 == null) goto L38;
        r104.put("trackData", ex2.d.b(r115));
    L38:
        if (r100 != null) goto L40;
    L59:
        return r104;
    L40:
        if (Intrinsics.areEqual(r100.f162738h, DevicePlans.DEVICE_PLAN_VIVO4) != true) goto L59;
        JSONObject r116 = r100.f162739i;
        if (r116 != null) goto L60;
    L57:
        if (r102 == null) goto L59;
        com.bytedance.android.marketing.sdk.impl.utils.f.c(r104, r102, true);
        goto L59
    L60:
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L49
        String r118 = r116.toString();     // Catch: Throwable -> L49
        if (r118 == null) goto L46;
        JSONObject r119 = new JSONObject(r118);     // Catch: Throwable -> L49
    L47:
        Object r120 = Result.m9449constructorimpl(r119);     // Catch: Throwable -> L49
    L52:
        if (Result.m9455isFailureimpl(r120) == false) goto L54;
        r120 = null;
    L54:
        JSONObject r121 = (JSONObject) r120;
        if (r121 == null) goto L57;
        r121.remove("extra_data");
        r121.remove("common_log_params");
        r121.remove("view_config");
        r102 = r121;
        goto L57
    L46:
        r119 = null;
    L49:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L52
    L23:
        r109 = null;
        goto L24
    L14:
        r106 = null;
        goto L15
    L5:
        r103 = null;
        goto L6
    }

    public final boolean k() {
        RitDataWrapper r100 = j();
        Boolean r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.f162732b;
    L7:
        if (Intrinsics.areEqual(r102, this.f162714m) == true) goto L15;
        a r103 = this.f162702a;
        if (r103 == null) goto L12;
        r101 = r103.d();
    L12:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == true) goto L15;
        return false;
    L15:
        return true;
    L5:
        r102 = null;
        goto L7
    }

    public final String b(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L30
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L30
        RitDataWrapper r103 = j();     // Catch: Throwable -> L30
        if (r103 == null) goto L5;
        String r104 = r103.f162744n;     // Catch: Throwable -> L30
    L6:
        r102.put("pageId", r104);     // Catch: Throwable -> L30
        r102.put(BdpAppEventConstant.PARAMS_RIT, this.f162713l);     // Catch: Throwable -> L30
        r102.put("compName", this.f162714m);     // Catch: Throwable -> L30
        String r105 = r102.toString();     // Catch: Throwable -> L30
        String r106 = com.bytedance.android.marketing.sdk.impl.utils.g.a(r100);     // Catch: Throwable -> L30
        if (r106.length() <= 0) goto L10;
        boolean r107 = true;
    L12:
        if (r107 == false) goto L14;
        String r108 = com.bytedance.android.marketing.sdk.impl.utils.a.b(r106, "ecm_data", r105);     // Catch: Throwable -> L30
        String r109 = com.bytedance.android.marketing.sdk.impl.utils.a.d(com.bytedance.android.marketing.sdk.impl.utils.a.d(r100, "url", r108), "surl", r108);     // Catch: Throwable -> L30
    L15:
        String r110 = com.bytedance.android.marketing.sdk.impl.utils.a.b(r109, "ecm_data", r105);     // Catch: Throwable -> L30
        Map<String, com.bytedance.android.marketing.sdk.api.c> r111 = ECMarketingDataCenter.f162720b;     // Catch: Throwable -> L30
        Function0<RitDataWrapper> r112 = this.f162715n;     // Catch: Throwable -> L30
        if (r112 == null) goto L21;
        RitDataWrapper r113 = r112.invoke();     // Catch: Throwable -> L30
        if (r113 == null) goto L21;
        String r114 = r113.f162744n;     // Catch: Throwable -> L30
        if (r114 == null) goto L21;
    L22:
        com.bytedance.android.marketing.sdk.api.c r115 = (com.bytedance.android.marketing.sdk.api.c) ((LinkedHashMap) r111).get(r114);     // Catch: Throwable -> L30
        if (r115 == null) goto L35;
        Map<String, Object> r116 = r115.f162681l;     // Catch: Throwable -> L30
        if (r116 != null) goto L27;
        return r110;
    L27:
        if ((!r116.isEmpty()) != true) goto L37;
        String r117 = com.bytedance.android.marketing.sdk.impl.utils.a.b(r110, "ec_marketing_biz_params", g().toString());     // Catch: Throwable -> L30
        CommonUtils.f162812a.getClass();     // Catch: Throwable -> L30
        return com.bytedance.android.marketing.sdk.impl.utils.a.b(r117, "ec_marketing_ohr_info", CommonUtils.b().toString());
    L37:
        return r110;
    L35:
        return r110;
    L21:
        r114 = "";
        goto L22
    L14:
        r109 = r100;
        goto L15
    L10:
        r107 = false;
        goto L12
    L5:
        r104 = null;
    L30:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return r100;
    }

    public final void d(fx2.f r100) {
        if (r100 == null) goto L35;
        View r101 = r100.getHybridView();
        Unit r102 = null;
        if (r101 == null) goto L6;
        ViewParent r103 = r101.getParent();
    L8:
        if ((r103 instanceof ViewGroup) == true) goto L10;
        r103 = null;
    L10:
        ViewGroup r104 = (ViewGroup) r103;
        if (r104 == null) goto L14;
        r104.removeView(r100.getHybridView());
    L14:
        if (this.f162708g == null) goto L26;
        View r105 = r100.getHybridView();
        if (r105 == null) goto L26;
        if (r105.isAttachedToWindow() != true) goto L26;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L24
        WindowManager r107 = this.f162708g;     // Catch: Throwable -> L24
        if (r107 == null) goto L22;
        r107.removeView(r100.getHybridView());     // Catch: Throwable -> L24
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L24
    L22:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L26:
        FragmentManager.FragmentLifecycleCallbacks r109 = this.f162709h;
        if (r109 == null) goto L31;
        FragmentManager r110 = this.f162710i;
        if (r110 == null) goto L31;
        r110.unregisterFragmentLifecycleCallbacks(r109);
    L31:
        r100.release();
        return;
    L6:
        r103 = null;
        goto L8
    }

    public final Activity f(String r110) {
        CommonUtils.f162812a.getClass();
        Activity r100 = CommonUtils.c();
        Map<String, com.bytedance.android.marketing.sdk.api.c> r101 = ECMarketingDataCenter.f162720b;
        Function0<RitDataWrapper> r102 = this.f162715n;
        if (r102 == null) goto L8;
        RitDataWrapper r103 = r102.invoke();
        if (r103 == null) goto L8;
        String r104 = r103.f162744n;
        if (r104 == null) goto L8;
    L9:
        com.bytedance.android.marketing.sdk.api.c r105 = (com.bytedance.android.marketing.sdk.api.c) ((LinkedHashMap) r101).get(r104);
        if (r105 != null) goto L12;
        return r100;
    L12:
        WeakReference<Activity> r106 = r105.f162672c;
        if (r106 == null) goto L15;
        Activity r107 = r106.get();
    L17:
        if (Intrinsics.areEqual(fx2.d.f479104a.get("enter_secondary_page_enable"), Boolean.TRUE) == false) goto L19;
    L20:
        if (r107 != null) goto L22;
    L25:
        Fragment r111 = r105.f162685p;
        if (r111 == null) goto L29;
        return r111.getActivity();
    L29:
        if (r105.getActivity() != null) goto L35;
        if (r107 != null) goto L33;
        return r100;
    L33:
        return r107;
    L35:
        return r105.getActivity();
    L22:
        if ((!Intrinsics.areEqual(r107, r100)) == false) goto L25;
        int r108 = com.bytedance.android.marketing.sdk.impl.utils.d.f162815a;
        com.bytedance.android.marketing.sdk.impl.utils.d.c(new TrackData(), "", 2, this.f162714m, this.f162713l, "container_mismatch", r110);
        com.bytedance.android.marketing.sdk.impl.utils.b.e("进入二级页面了, 不展示");
        return null;
    L19:
        if (r105.f162683n != 1) goto L25;
    L15:
        r107 = null;
    L8:
        r104 = "";
        goto L9
    }

    public final void q(boolean r100) {
        if (r100 == false) goto L6;
        View r101 = i();
        if (r101 == null) goto L10;
        r101.setVisibility(0);
        return;
    L10:
        return;
    L6:
        View r102 = i();
        if (r102 == null) goto L12;
        r102.setVisibility(8);
        return;
    }

    public final void l(String r100, String r101) {
        ji.a r102 = com.bytedance.android.marketing.sdk.impl.utils.b.f162814a;
        com.bytedance.android.marketing.sdk.impl.utils.b.g(r100, this.f162713l, this.f162714m, r101);
        Map<String, com.bytedance.android.marketing.sdk.api.a> r103 = e.f162793a;
        com.bytedance.android.marketing.sdk.api.a r104 = e.a(this.f162712k);
        if (r104 == null) goto L6;
        r104.a(r101);
        return;
    }

    public final void o(ECMarketingErrorType r100, String r101) {
        String r102 = this.f162713l;
        RitDataWrapper r103 = j();
        if (r103 == null) goto L5;
        String r104 = r103.f162740j;
    L6:
        RitDataWrapper r105 = j();
        if (r105 == null) goto L9;
        String r106 = r105.f162741k;
    L10:
        n(this, r102, r104, r106, r100.getCode(), r101);
        return;
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public final void p(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        fx2.f r102 = this.f162705d;
        if (r102 == null) goto L6;
        r102.sendEvent(r100, r101);
    L6:
        if (this.f162706e == null) goto L9;
        Intrinsics.checkNotNullParameter(r100, "eventName");
        return;
    }

    public CompDataWrapper(String r100, String r101, String r102, Function0<RitDataWrapper> r103) {
        Intrinsics.checkNotNullParameter(r100, "pageId");
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_RIT);
        Intrinsics.checkNotNullParameter(r102, "compName");
        this.f162712k = r100;
        this.f162713l = r101;
        this.f162714m = r102;
        this.f162715n = r103;
        this.f162707f = "";
        this.f162711j = LazyKt.lazy(CompDataWrapper$windowConfig$2.INSTANCE);
    }

    public static void n(CompDataWrapper r100, String r110, String r111, String r112, String r113, String r114) {
        RitDataWrapper r101 = r100.j();
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.f162742l;
    L6:
        RitDataWrapper r104 = r100.j();
        if (r104 == null) goto L9;
        r102 = r104.f162743m;
    L9:
        if (r102 != null) goto L11;
        String r105 = "";
    L12:
        r100.getClass();
        com.bytedance.android.marketing.sdk.impl.utils.e.e(r110, r111, r112, r113, r114, r103, r105);
        return;
    L11:
        r105 = r102;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v37, types: [T, fx2.f, fx2.g] */
    /* JADX WARN: Type inference failed for: r1v20, types: [T, fx2.f] */
    public static void m(final CompDataWrapper r210, String r211, Object r212, p r310, String r311, String r312, int r313) {
        if ((r313 & 1) == 0) goto L5;
        String r110 = null;
    L7:
        if ((r313 & 2) == 0) goto L9;
        Object r100 = null;
    L11:
        if ((r313 & 4) == 0) goto L13;
        final p r111 = null;
    L15:
        if ((r313 & 8) == 0) goto L17;
        String r112 = null;
    L19:
        if ((r313 & 16) == 0) goto L21;
        String r101 = null;
    L23:
        if (r210.f162702a != null) goto L35;
        if (r111 == null) goto L26;
        r111.onFailed("compData null");
    L26:
        String r102 = r210.f162713l;
        RitDataWrapper r103 = r210.j();
        if (r103 == null) goto L29;
        String r104 = r103.f162740j;
    L30:
        RitDataWrapper r105 = r210.j();
        if (r105 == null) goto L33;
        String r113 = r105.f162741k;
    L34:
        n(r210, r102, r104, r113, ECMarketingErrorType.PROTOCOL_PARSE_ERROR.getCode(), "comp数据解析异常, compData is null");
        return;
    L33:
        r113 = null;
        goto L34
    L29:
        r104 = null;
        goto L30
    L35:
        r210.f162704c = r100;
        RitDataWrapper r106 = r210.j();
        if (r106 == null) goto L38;
        Function1<? super String, Unit> r107 = r106.f162746p.f162797c;
    L39:
        a r108 = r210.f162702a;
        if (r108 == null) goto L43;
        Object r109 = r108.c();
        if (r109 == null) goto L43;
    L46:
        if (r107 == null) goto L80;
        if (r109 == null) goto L80;
        r210.f162707f = "custom_open";
        String r114 = com.bytedance.android.marketing.sdk.impl.utils.f.d(r109);
        RitDataWrapper r115 = r210.j();
        if (r110 != null) goto L54;
        a r116 = r210.f162702a;
        if (r116 == null) goto L53;
        String r117 = r116.b();
    L55:
        if (r117 == null) goto L57;
        String r118 = r210.b(r117);
    L59:
        if (ex2.d.a(r118) == true) goto L358;
        if (r111 == null) goto L156;
        r111.onFailed("comp数据解析异常, schema is null");
    L156:
        String r119 = r110;
    L347:
        int r120 = com.bytedance.android.marketing.sdk.impl.utils.d.f162815a;
        Function0<RitDataWrapper> r121 = r210.f162715n;
        if (r121 == null) goto L355;
        RitDataWrapper r122 = r121.invoke();
        if (r122 == null) goto L355;
        h r123 = r122.f162746p;
        if (r123 == null) goto L355;
        TrackData r124 = r123.f162802h;
        if (r124 == null) goto L355;
    L356:
        com.bytedance.android.marketing.sdk.impl.utils.d.f(r124, r210.f162713l, r210.f162714m, r119, r210.f162707f);
        return;
    L355:
        r124 = new TrackData();
        goto L356
    L358:
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L76
        JSONObject r126 = new JSONObject(r114);     // Catch: Throwable -> L76
        JSONObject r127 = r126.optJSONObject("popup_config");     // Catch: Throwable -> L76
        if (r127 == null) goto L156;
        if (ex2.d.a(r118) == false) goto L66;
        r127.put("schema", r118);     // Catch: Throwable -> L76
    L66:
        r127.put("data", r210.e());     // Catch: Throwable -> L76
        if (r115 == null) goto L71;
        Function1<? super String, Unit> r128 = r115.f162746p.f162797c;     // Catch: Throwable -> L76
        if (r128 == null) goto L71;
        Unit r129 = r128.invoke(r126.toString());     // Catch: Throwable -> L76
    L71:
        if (r111 == null) goto L73;
        r111.onSuccess();     // Catch: Throwable -> L76
        Unit r130 = Unit.INSTANCE;     // Catch: Throwable -> L76
    L74:
        Result.m9449constructorimpl(r130);     // Catch: Throwable -> L76
        goto L156
    L73:
        r130 = null;
    L76:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L156
    L57:
        r118 = null;
        goto L59
    L53:
        r117 = null;
        goto L55
    L54:
        r117 = r110;
    L80:
        r210.f162707f = "build_in";
        String r132 = "hyBirdView is null";
        a r133 = r210.f162702a;
        if (r133 == null) goto L156;
        if (r110 != null) goto L85;
        String r134 = r133.b();
    L86:
        if (r134 == null) goto L88;
        String r135 = r210.b(r134);
    L89:
        if (r110 != null) goto L91;
        String r136 = r133.b();
    L92:
        if (r136 != null) goto L363;
        String r137 = null;
    L99:
        Object r138 = r133.a();
        if (r138 == null) goto L102;
        String r139 = r138.toString();
    L103:
        RitDataWrapper r140 = r210.j();
        if (r140 == null) goto L106;
        String r141 = r140.f162742l;
    L107:
        RitDataWrapper r142 = r210.j();
        if (r142 == null) goto L110;
        String r143 = r142.f162743m;
    L112:
        if (r143 != null) goto L114;
        String r144 = "";
    L361:
        Result.Companion r145 = Result.Companion;     // Catch: Throwable -> L141
        Function0<RitDataWrapper> r146 = r210.f162715n;     // Catch: Throwable -> L141
        if (r146 == null) goto L122;
        RitDataWrapper r147 = r146.invoke();     // Catch: Throwable -> L141
        if (r147 == null) goto L122;
        h r148 = r147.f162746p;     // Catch: Throwable -> L141
        if (r148 == null) goto L122;
        TrackData r149 = r148.f162802h;     // Catch: Throwable -> L141
    L123:
        if (r149 == null) goto L125;
        long r150 = r149.getTOpenTime();     // Catch: Throwable -> L141
    L126:
        if (r149 == null) goto L128;
        r149.setTNativeHandleTime(System.currentTimeMillis());     // Catch: Throwable -> L141
    L128:
        if (r149 == null) goto L130;
        long r151 = r149.getTNativeHandleTime();     // Catch: Throwable -> L141
    L131:
        int r152 = com.bytedance.android.marketing.sdk.impl.utils.e.f162816a;     // Catch: Throwable -> L141
        Long r213 = Long.valueOf(r150);     // Catch: Throwable -> L141
        String r153 = r210.f162713l;     // Catch: Throwable -> L141
        RitDataWrapper r154 = r210.j();     // Catch: Throwable -> L141
        if (r154 == null) goto L134;
        String r214 = r154.f162740j;     // Catch: Throwable -> L141
    L135:
        RitDataWrapper r155 = r210.j();     // Catch: Throwable -> L141
        if (r155 == null) goto L138;
        String r215 = r155.f162741k;     // Catch: Throwable -> L141
    L139:
        com.bytedance.android.marketing.sdk.impl.utils.e.d(r151, r213, r153, r214, r215, r141, r144);     // Catch: Throwable -> L141
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L141
    L144:
        if (r135 != null) goto L146;
    L149:
        boolean r156 = true;
    L150:
        if (r156 == false) goto L152;
        r119 = r110;
        String r157 = null;
        String r158 = r135;
        if (r111 == null) goto L336;
        r111.onFailed("schema is empty");
    L336:
        if (r158 != null) goto L338;
        String r159 = "";
    L339:
        r210.l(r159, "schema is empty");
        String r160 = r210.f162713l;
        RitDataWrapper r161 = r210.j();
        if (r161 == null) goto L342;
        String r162 = r161.f162740j;
    L343:
        RitDataWrapper r163 = r210.j();
        if (r163 == null) goto L346;
        r157 = r163.f162741k;
    L346:
        n(r210, r160, r162, r157, ECMarketingErrorType.PROTOCOL_PARSE_ERROR.getCode(), "comp数据解析异常, schema is empty");
        goto L347
    L342:
        r162 = null;
        goto L343
    L338:
        r159 = r158;
        goto L339
    L152:
        if (r210.k() == true) goto L365;
        r119 = r110;
        String r164 = r135;
        CommonUtils.f162812a.getClass();
        Activity r165 = CommonUtils.c();
        if (r165 == null) goto L347;
        RitDataWrapper r166 = r210.j();
        if (r166 == null) goto L316;
        String r167 = r166.f162744n;
    L318:
        if (Intrinsics.areEqual(r167, String.valueOf(r165.hashCode())) == false) goto L330;
        r210.f162707f = PrefetchTiming.ROUTER;
        IHybridHostService r168 = com.bytedance.android.ec.hybrid.a.h();
        if (r168 == null) goto L324;
        yj.p r169 = r168.IHybridHostRouterService();
        if (r169 == null) goto L324;
        r169.d(r165, r164, null);
    L324:
        if (r111 == null) goto L326;
        r111.onSuccess();
    L326:
        ji.a r170 = com.bytedance.android.marketing.sdk.impl.utils.b.f162814a;
        com.bytedance.android.marketing.sdk.impl.utils.b.f(r164, r210.f162713l, r210.f162714m);
        Map<String, com.bytedance.android.marketing.sdk.api.a> r171 = e.f162793a;
        com.bytedance.android.marketing.sdk.api.a r172 = e.a(r210.f162712k);
        if (r172 == null) goto L347;
        r172.b(r210.f162713l, r210.f162714m);
        goto L347
    L330:
        if (r111 == null) goto L332;
        r111.onFailed("未在当前页打开，打开失败");
    L332:
        r210.l(r164, "未在当前页打开，打开失败");
        goto L347
    L316:
        r167 = null;
        goto L318
    L365:
        Activity r173 = r210.f(r101);     // Catch: Throwable -> L301
        if (r173 != null) goto L159;
        r210.o(ECMarketingErrorType.GET_HOST_CONTAINER_FAILED, "未获取到宿主容器");     // Catch: Throwable -> L301
        goto L156
    L159:
        if (com.bytedance.android.marketing.sdk.impl.utils.g.b(r135) == true) goto L161;
        Ref.ObjectRef r174 = new Ref.ObjectRef();     // Catch: Throwable -> L301
        ?? r175 = r210.f162705d;     // Catch: Throwable -> L301
        r174.element = r175;     // Catch: Throwable -> L301
        if (r175 == 0) goto L167;
        Ref.ObjectRef r176 = r174;
        Activity r177 = r173;
        r119 = r110;
        final String r178 = r135;
    L172:
        View r179 = ((fx2.f) r176.element).getHybridView();     // Catch: Throwable -> L169
    L173:
        RitDataWrapper r180 = r210.j();     // Catch: Throwable -> L169
        if (r180 == null) goto L176;
        WeakReference<FrameLayout> r181 = r180.f162734d;     // Catch: Throwable -> L169
    L177:
        if (r181 == null) goto L183;
        RitDataWrapper r182 = r210.j();     // Catch: Throwable -> L169
        if (r182 == null) goto L195;
        WeakReference<FrameLayout> r183 = r182.f162734d;     // Catch: Throwable -> L169
        if (r183 == null) goto L195;
        FrameLayout r184 = r183.get();     // Catch: Throwable -> L169
    L197:
        if (r179 != null) goto L201;
        r210.o(ECMarketingErrorType.CREATE_LYNX_VIEW_FAILED, "创建LynxView失败: hyBirdView is null");     // Catch: Throwable -> L169
        r210.l(r178, r132);     // Catch: Throwable -> L169
        if (r111 == null) goto L347;
        r111.onFailed(r132);     // Catch: Throwable -> L169
        goto L347
    L201:
        f r185 = (f) r210.f162711j.getValue();     // Catch: Throwable -> L169
        if (r185 == null) goto L207;
        Map<String, List<String>> r186 = r185.a();     // Catch: Throwable -> L169
        if (r186 == null) goto L207;
        final List<String> r187 = r186.get(r210.f162713l);     // Catch: Throwable -> L169
        if (r187 == null) goto L207;
    L209:
        String r188 = "内嵌组件 container is null";
        if (r179.getParent() != null) goto L265;
        int r189 = com.bytedance.android.marketing.sdk.impl.utils.h.f162818a;     // Catch: Throwable -> L169
        if (r139 != null) goto L217;
        RitDataWrapper r190 = r210.j();     // Catch: Throwable -> L169
        if (r190 == null) goto L216;
        String r191 = r190.f162735e;     // Catch: Throwable -> L169
    L218:
        Pair r192 = com.bytedance.android.marketing.sdk.impl.utils.h.a(r191, r112);     // Catch: Throwable -> L169
        FrameLayout.LayoutParams r193 = (FrameLayout.LayoutParams) r192.component1();     // Catch: Throwable -> L169
        r179.setZ(((Number) r192.component2()).floatValue());     // Catch: Throwable -> L169
        CommonUtils.f162812a.getClass();     // Catch: Throwable -> L169
        String r194 = CommonUtils.a(r177, r187);     // Catch: Throwable -> L169
        f r195 = (f) r210.f162711j.getValue();     // Catch: Throwable -> L169
        if (r195 == null) goto L240;
        boolean r196 = true;
        if (r195.b() == true) goto L223;
    L241:
        if (r184 == null) goto L243;
        r184.addView(r179, r193);     // Catch: Throwable -> L169
        r188 = null;
    L243:
        f r197 = (f) r210.f162711j.getValue();     // Catch: Throwable -> L169
        if (r197 != null) goto L246;
    L284:
        if (r188 != null) goto L286;
    L293:
        ji.a r198 = com.bytedance.android.marketing.sdk.impl.utils.b.f162814a;     // Catch: Throwable -> L169
        com.bytedance.android.marketing.sdk.impl.utils.b.f(r178, r210.f162713l, r210.f162714m);     // Catch: Throwable -> L169
        Map<String, com.bytedance.android.marketing.sdk.api.a> r199 = e.f162793a;     // Catch: Throwable -> L169
        com.bytedance.android.marketing.sdk.api.a r200 = e.a(r210.f162712k);     // Catch: Throwable -> L169
        if (r200 == null) goto L296;
        r200.b(r210.f162713l, r210.f162714m);     // Catch: Throwable -> L169
    L296:
        if (r111 == null) goto L298;
        r111.onSuccess();     // Catch: Throwable -> L169
        Unit r1100 = Unit.INSTANCE;     // Catch: Throwable -> L169
    L299:
        Object r201 = Result.m9449constructorimpl(r1100);     // Catch: Throwable -> L169
    L304:
        Throwable r202 = Result.m9452exceptionOrNullimpl(r201);
        if (r202 == null) goto L347;
        String r203 = r202.getMessage();
        if (r203 != null) goto L309;
        r203 = "";
    L309:
        r210.o(ECMarketingErrorType.CREATE_LYNX_VIEW_FAILED, "创建LynxView失败: ".concat(r203));
    L298:
        r1100 = null;
        goto L299
    L286:
        if (r188.length() <= 0) goto L288;
        boolean r204 = true;
    L289:
        if (r204 != r196) goto L293;
        r210.o(ECMarketingErrorType.GET_HOST_CONTAINER_FAILED, r188);     // Catch: Throwable -> L169
        r210.l(r178, r188);     // Catch: Throwable -> L169
        if (r111 == null) goto L298;
        r111.onFailed(r188);     // Catch: Throwable -> L169
        r1100 = Unit.INSTANCE;     // Catch: Throwable -> L169
        goto L299
    L288:
        r204 = false;
        goto L289
    L246:
        if (r197.b() != r196) goto L284;
        if ((r187.isEmpty() ^ r196) == false) goto L284;
        if ((r177 instanceof AppCompatActivity) == true) goto L252;
        Activity r205 = null;
    L253:
        AppCompatActivity r206 = (AppCompatActivity) r205;     // Catch: Throwable -> L169
        if (r206 == null) goto L256;
        FragmentManager r207 = r206.getSupportFragmentManager();     // Catch: Throwable -> L169
    L257:
        r210.f162710i = r207;     // Catch: Throwable -> L169
        FragmentManager.FragmentLifecycleCallbacks r208 = new CompDataWrapper$openWithBuildInFunc$$inlined$runCatching$lambda$3(r187, r210, r178, r111);     // Catch: Throwable -> L169
        r210.f162709h = r208;     // Catch: Throwable -> L169
        FragmentManager r209 = r210.f162710i;     // Catch: Throwable -> L169
        if (r209 == null) goto L260;
        r209.registerFragmentLifecycleCallbacks(r208, r196);     // Catch: Throwable -> L169
    L260:
        Handler r216 = ECHybridExtensionsKt.c();     // Catch: Throwable -> L169
        d r217 = new d(r210, r111);     // Catch: Throwable -> L169
        f r218 = (f) r210.f162711j.getValue();     // Catch: Throwable -> L169
        if (r218 == null) goto L263;
        long r219 = r218.c();     // Catch: Throwable -> L169
    L264:
        r216.postDelayed(r217, r219);     // Catch: Throwable -> L169
        goto L284
    L263:
        r219 = 1000;
        goto L264
    L256:
        r207 = null;
        goto L257
    L252:
        r205 = r177;
        goto L253
    L223:
        if ((!r187.isEmpty()) == false) goto L241;
        if (r194 == null) goto L241;
        Object r220 = r177.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L169
        if ((r220 instanceof WindowManager) == true) goto L228;
        r220 = null;
    L228:
        r210.f162708g = (WindowManager) r220;     // Catch: Throwable -> L169
        WindowManager.LayoutParams r221 = new WindowManager.LayoutParams();     // Catch: Throwable -> L169
        r221.width = -1;     // Catch: Throwable -> L169
        View r222 = r177.getWindow().getDecorView();     // Catch: Throwable -> L169
        if (com.larus.home.impl.utils.c.f346345e == false) goto L233;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L169
        Thread r223 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L169
        if (r223 == com.larus.home.impl.utils.c.f346341a) goto L233;
        com.larus.home.impl.utils.c.a(r223, "getDecorView");     // Catch: Throwable -> L169
    L233:
        r221.height = r222.getHeight();     // Catch: Throwable -> L169
        r221.format = -3;     // Catch: Throwable -> L169
        r221.gravity = 8388659;     // Catch: Throwable -> L169
        r221.flags = ISmModel.VERSION_0300;     // Catch: Throwable -> L169
        r179.setFocusableInTouchMode(true);     // Catch: Throwable -> L169
        r179.requestFocus();     // Catch: Throwable -> L169
        r179.setOnKeyListener(new c(r210, r111));     // Catch: Throwable -> L169
        WindowManager r224 = r210.f162708g;     // Catch: Throwable -> L169
        if (r224 == null) goto L237;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r179, r221);     // Catch: Throwable -> L169
        r224.addView(r179, r221);     // Catch: Throwable -> L169
    L237:
        if (r210.f162708g == null) goto L239;
        int r225 = com.bytedance.android.marketing.sdk.impl.utils.d.f162815a;     // Catch: Throwable -> L169
        com.bytedance.android.marketing.sdk.impl.utils.d.e(r210.f162713l, r210.f162714m, r178, r194, "1");     // Catch: Throwable -> L169
    L283:
        r188 = null;
        goto L284
    L239:
        r210.o(ECMarketingErrorType.GET_HOST_CONTAINER_FAILED, "内嵌组件 windowManager is null");     // Catch: Throwable -> L169
        goto L283
    L240:
        r196 = true;
        goto L241
    L216:
        r191 = null;
        goto L218
    L217:
        r191 = r139;
        goto L218
    L265:
        String r226 = r112;
        r196 = true;
        if ((!Intrinsics.areEqual(r179.getParent(), r184)) == false) goto L283;
        ViewParent r227 = r179.getParent();     // Catch: Throwable -> L169
        if ((r227 instanceof ViewGroup) == true) goto L270;
        r227 = null;
    L270:
        ViewGroup r228 = (ViewGroup) r227;     // Catch: Throwable -> L169
        if (r228 == null) goto L273;
        r228.removeView(r179);     // Catch: Throwable -> L169
    L273:
        int r229 = com.bytedance.android.marketing.sdk.impl.utils.h.f162818a;     // Catch: Throwable -> L169
        if (r139 != null) goto L279;
        RitDataWrapper r230 = r210.j();     // Catch: Throwable -> L169
        if (r230 == null) goto L278;
        String r231 = r230.f162735e;     // Catch: Throwable -> L169
    L280:
        Pair r232 = com.bytedance.android.marketing.sdk.impl.utils.h.a(r231, r226);     // Catch: Throwable -> L169
        FrameLayout.LayoutParams r233 = (FrameLayout.LayoutParams) r232.component1();     // Catch: Throwable -> L169
        r179.setZ(((Number) r232.component2()).floatValue());     // Catch: Throwable -> L169
        if (r184 == null) goto L284;
        r184.addView(r179, r233);     // Catch: Throwable -> L169
        goto L283
    L278:
        r231 = null;
        goto L280
    L279:
        r231 = r139;
    L207:
        r187 = CollectionsKt.emptyList();     // Catch: Throwable -> L169
    L195:
        r184 = null;
        goto L197
    L183:
        RitDataWrapper r234 = r210.j();     // Catch: Throwable -> L169
        if (r234 == null) goto L188;
        WeakReference<FrameLayout> r235 = r234.f162746p.f162796b;     // Catch: Throwable -> L169
        if (r235 == null) goto L188;
        FrameLayout r236 = r235.get();     // Catch: Throwable -> L169
    L189:
        if (r236 == null) goto L196;
        RitDataWrapper r237 = r210.j();     // Catch: Throwable -> L169
        if (r237 == null) goto L195;
        WeakReference<FrameLayout> r238 = r237.f162746p.f162796b;     // Catch: Throwable -> L169
        if (r238 == null) goto L195;
        r184 = r238.get();     // Catch: Throwable -> L169
        goto L197
    L196:
        r184 = (FrameLayout) r177.findViewById(R.id.content);     // Catch: Throwable -> L169
    L188:
        r236 = null;
        goto L189
    L176:
        r181 = null;
        goto L177
    L167:
        r177 = r173;
        String r239 = r110;
        r119 = r110;
        r178 = r135;
        b r240 = new b(r174, r210, r101, r135, r239, r141, r144, r137, r111);     // Catch: Throwable -> L169
        Intrinsics.checkNotNullParameter(r177, SocialConstants.PARAM_ACT);     // Catch: Throwable -> L169
        Intrinsics.checkNotNullParameter(r178, "url");     // Catch: Throwable -> L169
        Intrinsics.checkNotNullParameter(r240, "callback");     // Catch: Throwable -> L169
        ?? r241 = new fx2.g(r177, r178, r240);     // Catch: Throwable -> L169
        r176 = r174;
        r176.element = r241;     // Catch: Throwable -> L169
        r210.f162705d = r241;     // Catch: Throwable -> L169
        r241.renderTemplate(r178, cd.a.e(r210.e()));     // Catch: Throwable -> L169
        ((fx2.f) r176.element).updateGlobalProps(r210.h());     // Catch: Throwable -> L169
    L169:
        th = th;
    L303:
        Result.Companion r242 = Result.Companion;
        r201 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L304
    L161:
        if (r210.f162706e != null) goto L163;
        Intrinsics.checkNotNullParameter(r135, "url");     // Catch: Throwable -> L301
        fx2.b r243 = new fx2.b(r135);     // Catch: Throwable -> L301
        r210.f162706e = r243;     // Catch: Throwable -> L301
        r243.updateGlobalProps(r210.h());     // Catch: Throwable -> L301
    L163:
        r177 = r173;
        r119 = r110;
        r112 = r112;
        r179 = null;
        r178 = r135;
        r132 = "hyBirdView is null";
    L301:
        th = th;
        r119 = r110;
        goto L303
    L146:
        if (r135.length() == 0) goto L149;
        r156 = false;
        goto L150
    L138:
        r215 = null;
        goto L139
    L134:
        r214 = null;
        goto L135
    L130:
        r151 = 0;
        goto L131
    L125:
        r150 = 0;
    L122:
        r149 = null;
    L141:
        th = move-exception;
        Result.Companion r244 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L144
    L114:
        r144 = r143;
        goto L361
    L110:
        r143 = null;
        goto L112
    L106:
        r141 = null;
        goto L107
    L102:
        r139 = null;
        goto L103
    L363:
        Result.Companion r245 = Result.Companion;     // Catch: Throwable -> L95
        r136 = com.bytedance.android.marketing.sdk.impl.utils.g.a(r136);     // Catch: Throwable -> L95
    L97:
        r137 = r136;
    L95:
        th = move-exception;
        Result.Companion r246 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L97
    L91:
        r136 = r110;
        goto L92
    L88:
        r135 = null;
        goto L89
    L85:
        r134 = r110;
    L43:
        if (r106 == null) goto L45;
        r109 = r106.f162746p.f162798d;
        goto L46
    L45:
        r109 = null;
        goto L46
    L38:
        r107 = null;
        goto L39
    L21:
        r101 = r312;
        goto L23
    L17:
        r112 = r311;
        goto L19
    L13:
        r111 = r310;
        goto L15
    L9:
        r100 = r212;
        goto L11
    L5:
        r110 = r211;
        goto L7
    }

    public static final Map a(CompDataWrapper r100, String r101, String r102, String r103, String r104, String r105, Integer r106, Map r107) {
        r100.getClass();
        LinkedHashMap r108 = new LinkedHashMap();
        if (r101 == null) goto L5;
        r108.put("pageId", r101);
    L5:
        if (r102 == null) goto L7;
        r108.put(BdpAppEventConstant.PARAMS_RIT, r102);
    L7:
        if (r103 == null) goto L9;
        r108.put("compName", r103);
    L9:
        if (r104 == null) goto L11;
        r108.put("schema", r104);
    L11:
        if (r105 == null) goto L13;
        r108.put("url", r105);
    L13:
        if (r106 == null) goto L15;
        r108.put("status", Integer.valueOf(r106.intValue()));
    L15:
        if (r107 == null) goto L17;
        r108.put("initialData", r107);
    L17:
        return r108;
    }
}
