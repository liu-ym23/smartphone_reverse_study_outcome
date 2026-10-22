package com.bytedance.android.annie.monitor.common.timing.jsb;

import android.view.View;
import android.webkit.WebView;
import c7.a;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.container.fragment.o;
import com.bytedance.android.annie.monitor.common.timing.PerformanceTiming;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import m16.b;
import org.json.JSONObject;
import sz2.e;
import y6.c;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "getPerfTiming")
public final class GetPerfTimingMethod extends f<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f39623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f39624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f39625c;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public GetPerfTimingMethod(b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        this.f39624b = LazyKt.lazy(GetPerfTimingMethod$mainLooper$2.INSTANCE);
        this.f39625c = LazyKt.lazy(new GetPerfTimingMethod$mHandler$2(this));
        JSBridgeManager r101 = (JSBridgeManager) r100.c(JSBridgeManager.class);
        if (r101 == null) goto L6;
        this.f39623a = r101;
        return;
    }

    public GetPerfTimingMethod(c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        this.f39624b = LazyKt.lazy(GetPerfTimingMethod$mainLooper$2.INSTANCE);
        this.f39625c = LazyKt.lazy(new GetPerfTimingMethod$mHandler$2(this));
        this.f39623a = r100;
    }

    public static final int j(GetPerfTimingMethod r100, JSONObject r101) {
        r100.getClass();
        if (r101.optInt("is_memory") != 1) goto L5;
        int r102 = 1;
    L7:
        if (r101.optInt("is_preloaded") != 1) goto L10;
        r102 = r102 + 2;
    L10:
        if (r101.optInt("is_request_reused") == 1) goto L12;
        return r102;
    L12:
        return r102 + 4;
    L5:
        r102 = 0;
        goto L7
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r110, final CallContext r111) {
        JSONObject r112 = r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        final JSONObject r100 = new JSONObject();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L67
        c r102 = this.f39623a;     // Catch: Throwable -> L67
        Map<String, Long> r103 = null;
        if (r102 == null) goto L17;
        IHybridComponent r104 = r102.c();     // Catch: Throwable -> L67
        if (r104 == null) goto L17;
        if ((r104 instanceof o) == true) goto L11;
        r104 = null;
    L11:
        if (r104 == null) goto L17;
        a r105 = ((o) r104).getAnnieContext();     // Catch: Throwable -> L67
        if (r105 == null) goto L17;
        String r106 = r105.getUuid();     // Catch: Throwable -> L67
        if (r106 == null) goto L17;
    L23:
        final int r107 = r112.optInt("level");     // Catch: Throwable -> L67
        if (r107 != 0) goto L64;
        c r113 = this.f39623a;     // Catch: Throwable -> L67
        if (r113 == null) goto L30;
        IHybridComponent r114 = r113.c();     // Catch: Throwable -> L67
        if (r114 == null) goto L30;
        Map<String, Long> r115 = r114.getExtraPerfInfo();     // Catch: Throwable -> L67
    L31:
        ConcurrentHashMap<String, PerformanceTiming> r108 = l8.b.f507905a;     // Catch: Throwable -> L67
        Intrinsics.checkNotNullParameter(r106, ST.UUID_DEVICE);     // Catch: Throwable -> L67
        ConcurrentHashMap<String, PerformanceTiming> r109 = l8.b.f507905a;     // Catch: Throwable -> L67
        PerformanceTiming r116 = r109.get(r106);     // Catch: Throwable -> L67
        if (r116 == null) goto L35;
        Map<String, Object> r117 = r116.getPerfInfo();     // Catch: Throwable -> L67
    L37:
        if (r117 == null) goto L52;
        JSONObject r118 = new JSONObject(r117);     // Catch: Throwable -> L67
        if (r115 == null) goto L44;
        Long r119 = r115.get("res_from");     // Catch: Throwable -> L67
        if (r119 == null) goto L44;
        long r120 = r119.longValue();     // Catch: Throwable -> L67
    L46:
        if (r120 != 0) goto L49;
        r118.put("main_res_type", "gecko");     // Catch: Throwable -> L67
    L51:
        r100.put("container_info", r118);     // Catch: Throwable -> L67
        goto L52
    L49:
        if (r120 != 1) goto L51;
        r118.put("main_res_type", "cdn");     // Catch: Throwable -> L67
    L44:
        r120 = -1;
    L52:
        Intrinsics.checkNotNullParameter(r106, ST.UUID_DEVICE);     // Catch: Throwable -> L67
        PerformanceTiming r121 = r109.get(r106);     // Catch: Throwable -> L67
        if (r121 == null) goto L55;
        r103 = r121.getPerfTimingMap();     // Catch: Throwable -> L67
    L55:
        LinkedHashMap r122 = new LinkedHashMap();     // Catch: Throwable -> L67
        if (r103 == null) goto L58;
        r122.putAll(r103);     // Catch: Throwable -> L67
    L58:
        if (r115 == null) goto L61;
        r122.putAll(r115);     // Catch: Throwable -> L67
        r122.remove("res_from");     // Catch: Throwable -> L67
    L61:
        if ((!r122.isEmpty()) == false) goto L63;
        r100.put("container_timing", new JSONObject(r122));     // Catch: Throwable -> L67
    L63:
        k(r111, r106, r100);     // Catch: Throwable -> L67
        finishWithResult(r100);     // Catch: Throwable -> L67
    L65:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L67
        return;
    L35:
        r117 = null;
    L30:
        r115 = null;
        goto L31
    L64:
        int r123 = r112.optInt("waitCompleteData");     // Catch: Throwable -> L67
        e r124 = e.f543917a;     // Catch: Throwable -> L67
        final String r125 = r106;
        Function1<JSONObject, Unit> r126 = new GetPerfTimingMethod$invoke$1$1$4(r100, this, r111, r125, r107);     // Catch: Throwable -> L67
        r124.getClass();     // Catch: Throwable -> L67
        e.g(r106, r123, r126);     // Catch: Throwable -> L67
    L17:
        c r127 = this.f39623a;     // Catch: Throwable -> L67
        if (r127 == null) goto L22;
        IHybridComponent r128 = r127.c();     // Catch: Throwable -> L67
        if (r128 == null) goto L22;
        r106 = r128.containerId();     // Catch: Throwable -> L67
    L22:
        r106 = "";
    L67:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void k(CallContext r100, String r101, JSONObject r102) {
        View r103 = r100.f249269d;
        if (r103 == null) goto L39;
        Map<String, Object> r104 = null;
        if ((r103 instanceof WebView) == true) goto L8;
        r103 = null;
    L8:
        if (r103 == null) goto L40;
        WebView r105 = (WebView) r103;
        ConcurrentHashMap<String, PerformanceTiming> r106 = l8.b.f507905a;
        Intrinsics.checkNotNullParameter(r101, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r105, "webView");
        PerformanceTiming r107 = l8.b.f507905a.get(r101);
        if (r107 == null) goto L12;
        com.bytedance.android.annie.monitor.common.timing.a r108 = r107.getTTWebViewLoadInfo(r105);
    L13:
        if (r108 == null) goto L38;
    L22:
        if (r108 == null) goto L41;
        Map<String, Long> r109 = r108.f39620a;
        if (r109.isEmpty() == false) goto L26;
        r109 = null;
    L26:
        if (r109 == null) goto L28;
        r102.put("ttwebview_timing", new JSONObject(r109));
    L28:
        Map<String, Object> r110 = r108.f39621b;
        if (r110.isEmpty() == true) goto L32;
        r104 = r110;
    L32:
        if (r104 == null) goto L34;
        r102.put("ttwebview_info", new JSONObject(r104));
    L34:
        String r111 = r108.f39622c;
        if (r111 == null) goto L42;
        r102.put("ttwebview_new_metrics", new JSONObject(r111));
        return;
    L42:
        return;
    L41:
        return;
    L38:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L19
        JSONObject r113 = ((aa.b) Annie.getService$default(aa.b.class, null, 2, null)).g0(r105);     // Catch: Throwable -> L19
        if (r113 == null) goto L17;
        List<String> r114 = com.bytedance.android.annie.monitor.common.timing.a.f39619d;     // Catch: Throwable -> L19
        r108 = com.bytedance.android.annie.monitor.common.timing.a.C0736a.a(r113, null);     // Catch: Throwable -> L19
        goto L22
    L17:
        Result.m9449constructorimpl(null);     // Catch: Throwable -> L19
    L21:
        r108 = null;
    L19:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L12:
        r108 = null;
        goto L13
    L40:
        return;
    }
}
