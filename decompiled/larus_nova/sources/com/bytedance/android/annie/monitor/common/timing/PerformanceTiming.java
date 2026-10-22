package com.bytedance.android.annie.monitor.common.timing;

import aa.b;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import y9.h;
import y9.k;
import y9.n;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b'\u0018\u0000 U2\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004:\u0001VB\u0007¢\u0006\u0004\bS\u0010TJ\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\bJ\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\nJ\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR*\u0010*\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00107\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010\u001a\u001a\u0004\b8\u0010\u001c\"\u0004\b9\u0010\u001eR$\u0010:\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010\u001a\u001a\u0004\b;\u0010\u001c\"\u0004\b<\u0010\u001eR$\u0010=\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010C\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010>\u001a\u0004\bD\u0010@\"\u0004\bE\u0010BR$\u0010F\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010>\u001a\u0004\bG\u0010@\"\u0004\bH\u0010BR$\u0010I\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010\u001a\u001a\u0004\bI\u0010\u001c\"\u0004\bJ\u0010\u001eR$\u0010K\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010\u001a\u001a\u0004\bK\u0010\u001c\"\u0004\bL\u0010\u001eR\u0018\u0010M\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010>R\u0018\u0010N\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010>R\u0018\u0010O\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010>R\u0016\u0010P\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010\u001aR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006W"}, d2 = {"Lcom/bytedance/android/annie/monitor/common/timing/PerformanceTiming;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "Lorg/json/JSONObject;", "wrapMetrics", "wrapCategory", "", "preParseData", "", "getPerfTimingMap", "", "getPerfInfo", "Landroid/webkit/WebView;", "webView", "Lcom/bytedance/android/annie/monitor/common/timing/a;", "getTTWebViewLoadInfo", "Landroid/os/Bundle;", "initBundle", "Landroid/os/Bundle;", "getInitBundle", "()Landroid/os/Bundle;", "setInitBundle", "(Landroid/os/Bundle;)V", "engineType", "Ljava/lang/String;", "getEngineType", "()Ljava/lang/String;", "setEngineType", "(Ljava/lang/String;)V", "templateResType", "getTemplateResType", "setTemplateResType", "pageUrl", "getPageUrl", "setPageUrl", "pageType", "getPageType", "setPageType", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "viewRef", "Ljava/lang/ref/WeakReference;", "getViewRef", "()Ljava/lang/ref/WeakReference;", "setViewRef", "(Ljava/lang/ref/WeakReference;)V", "", "errorCode", "Ljava/lang/Integer;", "getErrorCode", "()Ljava/lang/Integer;", "setErrorCode", "(Ljava/lang/Integer;)V", "errorMsg", "getErrorMsg", "setErrorMsg", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "getErrorReason", "setErrorReason", "realOpenTimeTs", "Ljava/lang/Long;", "getRealOpenTimeTs", "()Ljava/lang/Long;", "setRealOpenTimeTs", "(Ljava/lang/Long;)V", "resolveShortLinkStart", "getResolveShortLinkStart", "setResolveShortLinkStart", "resolveShortLinkEnd", "getResolveShortLinkEnd", "setResolveShortLinkEnd", "isContainerPreload", "setContainerPreload", "isPrerender", "setPrerender", "openTs", "activityOnCreateTs", "containerInitStartTs", "enterFrom", "ttWebViewLoadInfo", "Lcom/bytedance/android/annie/monitor/common/timing/a;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "annie-monitor-common_release"}, k = 1, mv = {1, 4, 3})
public final class PerformanceTiming extends HashMap<String, Long> {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f39616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f39617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f39618c;
    private Long activityOnCreateTs;
    private Long containerInitStartTs;
    private String engineType;
    private String enterFrom;
    private Integer errorCode;
    private String errorMsg;
    private String errorReason;
    private Bundle initBundle;
    private String isContainerPreload;
    private String isPrerender;
    private Long openTs;
    private String pageType;
    private String pageUrl;
    private Long realOpenTimeTs;
    private Long resolveShortLinkEnd;
    private Long resolveShortLinkStart;
    private String templateResType;
    private com.bytedance.android.annie.monitor.common.timing.a ttWebViewLoadInfo;
    private WeakReference<View> viewRef;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        f39616a = true;
        f39617b = true;
        f39618c = true;
    }

    public final void c() {
        if (this.openTs != null) goto L6;
        this.openTs = b("open_time");
    L6:
        if (this.activityOnCreateTs != null) goto L9;
        this.activityOnCreateTs = b("container_activity_on_create");
    L9:
        if (this.containerInitStartTs != null) goto L11;
        this.containerInitStartTs = b("container_init_start_time");
    L11:
        this.realOpenTimeTs = b("real_open_time");
        if (this.resolveShortLinkStart != null) goto L15;
        this.resolveShortLinkStart = b("resolve_short_link_start");
    L15:
        if (this.resolveShortLinkEnd != null) goto L18;
        this.resolveShortLinkEnd = b("resolve_short_link_end");
        return;
    }

    public final Map<String, Object> getPerfInfo() {
        LinkedHashMap r100 = new LinkedHashMap();
        Bundle r101 = this.initBundle;
        if (r101 == null) goto L5;
        this.isPrerender = r101.getString("is_prerender");
        this.isContainerPreload = r101.getString("is_container_preload");
    L5:
        Bundle r102 = this.initBundle;
        boolean r103 = false;
        if (r102 == null) goto L8;
        r103 = r102.getBoolean("container_has_recreated", false);
    L8:
        r100.put("has_activity_recreated", Boolean.valueOf(r103));
        r100.put("main_res_type", this.templateResType);
        r100.put("first_open", Boolean.valueOf(f39616a));
        if (Intrinsics.areEqual(this.engineType, IHybridComponent.HybridType.LYNX.getHybridName()) == false) goto L12;
        r100.put("first_open_lynx", Boolean.valueOf(f39618c));
    L14:
        String r104 = this.isContainerPreload;
        if (r104 == null) goto L17;
        r100.put("is_container_preload", r104);
    L17:
        String r105 = this.isPrerender;
        if (r105 == null) goto L20;
        r100.put("is_prerender", r105);
    L20:
        return r100;
    L12:
        if (Intrinsics.areEqual(this.engineType, IHybridComponent.HybridType.H5.getHybridName()) == false) goto L14;
        r100.put("first_open_web", Boolean.valueOf(f39617b));
        r100.put("is_ttwebview", Boolean.valueOf(((b) Annie.getService$default(b.class, null, 2, null)).isTTWebView()));
        goto L14
    }

    public final Map<String, Long> getPerfTimingMap() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.putAll(this);
        c();
        Long r101 = this.openTs;
        if (r101 != null) goto L5;
        r101 = (Long) get("open_time");
    L5:
        Long r102 = this.containerInitStartTs;
        if (r102 != null) goto L8;
        r102 = (Long) get("container_init_start");
    L8:
        if (r101 == null) goto L10;
        r100.put("open_time", r101);
    L10:
        if (r102 == null) goto L12;
        r100.put("container_init_start", r102);
    L12:
        Long r103 = this.activityOnCreateTs;
        if (r103 == null) goto L15;
        r100.put("container_activity_on_create", Long.valueOf(r103.longValue()));
    L15:
        Long r104 = this.realOpenTimeTs;
        if (r104 == null) goto L18;
        r100.put("real_open_time", Long.valueOf(r104.longValue()));
    L18:
        Long r105 = this.resolveShortLinkStart;
        if (r105 == null) goto L21;
        r100.put("resolve_short_link_start", Long.valueOf(r105.longValue()));
    L21:
        Long r106 = this.resolveShortLinkEnd;
        if (r106 == null) goto L24;
        r100.put("resolve_short_link_end", Long.valueOf(r106.longValue()));
    L24:
        return r100;
    }

    public final JSONObject wrapCategory() {
        JSONObject r100 = new JSONObject();
        r100.put("enter_from", this.enterFrom);
        r100.put("engine_type", this.engineType);
        r100.put("template_res_type", this.templateResType);
        r100.put(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, this.pageType);
        r100.put("first_open", String.valueOf(f39616a));
        r100.put("lynx_first_open", String.valueOf(f39618c));
        r100.put("web_first_open", String.valueOf(f39617b));
        Map<String, Object> r101 = getPerfInfo();
        if (r101 == null) goto L5;
        Object r102 = MapsKt.getValue(r101, "has_activity_recreated");
    L6:
        r100.put("has_activity_recreated", String.valueOf(r102));
        boolean r103 = true;
        if (this.openTs == null) goto L9;
        boolean r104 = true;
    L10:
        r100.put("open_ts_valid", String.valueOf(r104));
        if (this.containerInitStartTs != null) goto L14;
        r103 = false;
    L14:
        r100.put("container_init_ts_valid", String.valueOf(r103));
        String r105 = this.errorMsg;
        if (r105 == null) goto L17;
        r100.put("error_msg", r105);
    L17:
        Integer r106 = this.errorCode;
        if (r106 == null) goto L20;
        r100.put("error_code", String.valueOf(r106.intValue()));
    L20:
        String r107 = this.errorReason;
        if (r107 == null) goto L23;
        r100.put("error_reason", r107);
    L23:
        List<String> r108 = AnnieConfigSettingKeys.TIMING_AB_LIST.a();
        if (r108 == null) goto L36;
        Iterator<T> r109 = r108.iterator();
    L27:
        if (r109.hasNext() == false) goto L36;
        String r110 = (String) r109.next();
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L34
        String r112 = a(r110);     // Catch: Throwable -> L34
        if (r112 == null) goto L32;
        r100.put(r110, r112);     // Catch: Throwable -> L34
    L32:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L36:
        f39616a = false;
        if (Intrinsics.areEqual(this.engineType, IHybridComponent.HybridType.LYNX.getHybridName()) == false) goto L40;
        f39618c = false;
    L40:
        if (Intrinsics.areEqual(this.engineType, IHybridComponent.HybridType.H5.getHybridName()) == false) goto L42;
        f39617b = false;
    L42:
        return r100;
    L9:
        r104 = false;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final JSONObject wrapMetrics() {
        JSONObject r100 = new JSONObject();
        Long r101 = this.openTs;
        if (r101 != null) goto L5;
        r101 = (Long) get("open_time");
    L5:
        Long r102 = this.containerInitStartTs;
        if (r102 != null) goto L8;
        r102 = (Long) get("container_init_start");
    L8:
        d(r100, "timing_open_cost", r101, r102);
        Long r103 = (Long) get("prepare_init_data_start");
        d(r100, "timing_activity_init_cost", r102, r103);
        Long r104 = this.activityOnCreateTs;
        if (r104 == null) goto L11;
        long r105 = r104.longValue();
        d(r100, "timing_activity_start_cost", r102, Long.valueOf(r105));
        d(r100, "timing_activity_on_create_cost", Long.valueOf(r105), r103);
    L11:
        Long r106 = (Long) get("container_init_end");
        d(r100, "timing_fragment_init_cost", r103, (Long) get("prepare_init_data_end"));
        d(r100, "timing_container_init_cost", r102, r106);
        d(r100, "timing_lynx_env_init_cost", (Long) get("prepare_component_lynx_env_start"), (Long) get("prepare_component_lynx_env_end"));
        Long r107 = (Long) get("prepare_component_jsb_start");
        Long r108 = (Long) get("prepare_component_jsb_end");
        d(r100, "timing_jsb_init_cost", r107, r108);
        Long r109 = (Long) get("prepare_component_start");
        Long r110 = (Long) get("prepare_component_end");
        d(r100, "timing_component_init_cost", r109, r110);
        d(r100, "timing_component_before_jsb_cost", r109, r107);
        d(r100, "timing_component_after_jsb_cost", r108, r110);
        d(r100, "timing_template_load_cost", (Long) get("prepare_template_start"), (Long) get("prepare_template_end"));
        d(r100, "timing_global_props_cost", (Long) get("prepare_component_global_props_start"), (Long) get("prepare_component_global_props_end"));
        d(r100, "timing_init_props_cost", (Long) get("prepare_component_initial_props_start"), (Long) get("prepare_component_initial_props_end"));
        d(r100, "timing_render_data_cost", (Long) get("prepare_render_data_start"), (Long) get("prepare_render_data_end"));
        Long r111 = (Long) get("prepare_engine_load_end");
        d(r100, "timing_engine_load_cost", (Long) get("prepare_engine_load_start"), r111);
        d(r100, "timing_engine_js_load_cost", r111, (Long) get("prepare_engine_js_load_end"));
        Long r112 = (Long) get("prepare_card_load_start");
        d(r100, "timing_card_create_cost", r106, r112);
        d(r100, "timing_card_load_cost", r112, r111);
        d(r100, "timing_container_route_cost", r101, r106);
        d(r100, "timing_container_card_cost", r106, r111);
        d(r100, "timing_container_total_cost", r101, r111);
        return r100;
    }

    public PerformanceTiming() {
        this.engineType = "unknown";
        this.templateResType = "unknown";
        this.pageType = "unknown";
        this.enterFrom = "unknown";
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Long>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<String, Long>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Long> getValues() {
        return super.values();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    public final void preParseData() {
        c();
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L14
        Bundle r101 = this.initBundle;     // Catch: Throwable -> L14
        if (r101 == null) goto L11;
        String r102 = r101.getString("url");     // Catch: Throwable -> L14
        if (r102 == null) goto L11;
        this.pageUrl = r102;     // Catch: Throwable -> L14
        String r103 = UriProtector.getQueryParameter(UriProtector.parse(r102), "enter_from");     // Catch: Throwable -> L14
        if (r103 != null) goto L10;
        r103 = "unknown";
    L10:
        this.enterFrom = r103;     // Catch: Throwable -> L14
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        Result.m9449constructorimpl(r104);     // Catch: Throwable -> L14
        return;
    L11:
        r104 = null;
    L14:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<Long> values() {
        return getValues();
    }

    public final String getEngineType() {
        return this.engineType;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final String getErrorReason() {
        return this.errorReason;
    }

    public final Bundle getInitBundle() {
        return this.initBundle;
    }

    public final String getPageType() {
        return this.pageType;
    }

    public final String getPageUrl() {
        return this.pageUrl;
    }

    public final Long getRealOpenTimeTs() {
        return this.realOpenTimeTs;
    }

    public final Long getResolveShortLinkEnd() {
        return this.resolveShortLinkEnd;
    }

    public final Long getResolveShortLinkStart() {
        return this.resolveShortLinkStart;
    }

    public final String getTemplateResType() {
        return this.templateResType;
    }

    public final WeakReference<View> getViewRef() {
        return this.viewRef;
    }

    public final String isContainerPreload() {
        return this.isContainerPreload;
    }

    public final String isPrerender() {
        return this.isPrerender;
    }

    public static String a(String r100) {
        Map<String, JSONObject> r101 = h.f566939a;
        if ((Annie.getService(n.class) instanceof k) == true) goto L5;
        boolean r102 = ((n) Annie.getService(n.class)).L0(r100);
    L10:
        if (r102 == true) goto L12;
        return null;
    L12:
        Boolean r103 = (Boolean) h.c(r100, Boolean.class, Boolean.FALSE);
        if (r103 != null) goto L15;
        return null;
    L15:
        return String.valueOf(r103);
    L5:
        h.b();
        JSONObject r104 = (JSONObject) ((ConcurrentHashMap) h.f566939a).get("annie_setting_from_server_key");     // Catch: Exception -> L8
        Objects.requireNonNull(r104);     // Catch: Exception -> L8
        r102 = r104.has(r100);     // Catch: Exception -> L8
    L8:
        r102 = false;
        goto L10
    }

    public final Long b(String r100) {
        Bundle r101 = this.initBundle;
        if (r101 == null) goto L5;
        Long r102 = Long.valueOf(r101.getLong(r100));
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        if (r102.longValue() > 0) goto L11;
        return null;
    L11:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r100) {
        if ((r100 instanceof Long) == true) goto L7;
        return false;
    L7:
        return containsValue((Long) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Long get(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r100);
    }

    public final com.bytedance.android.annie.monitor.common.timing.a getTTWebViewLoadInfo(WebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        Unit r102 = null;
        JSONObject r103 = ((b) Annie.getService$default(b.class, null, 2, null)).g0(r100);     // Catch: Throwable -> L8
        if (r103 == null) goto L6;
        List<String> r104 = com.bytedance.android.annie.monitor.common.timing.a.f39619d;     // Catch: Throwable -> L8
        this.ttWebViewLoadInfo = com.bytedance.android.annie.monitor.common.timing.a.C0736a.a(r103, this.ttWebViewLoadInfo);     // Catch: Throwable -> L8
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L8
    L11:
        return this.ttWebViewLoadInfo;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Long remove(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r100);
    }

    public final void setContainerPreload(String r100) {
        this.isContainerPreload = r100;
    }

    public final void setEngineType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.engineType = r100;
    }

    public final void setErrorCode(Integer r100) {
        this.errorCode = r100;
    }

    public final void setErrorMsg(String r100) {
        this.errorMsg = r100;
    }

    public final void setErrorReason(String r100) {
        this.errorReason = r100;
    }

    public final void setInitBundle(Bundle r100) {
        this.initBundle = r100;
    }

    public final void setPageType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pageType = r100;
    }

    public final void setPageUrl(String r100) {
        this.pageUrl = r100;
    }

    public final void setPrerender(String r100) {
        this.isPrerender = r100;
    }

    public final void setRealOpenTimeTs(Long r100) {
        this.realOpenTimeTs = r100;
    }

    public final void setResolveShortLinkEnd(Long r100) {
        this.resolveShortLinkEnd = r100;
    }

    public final void setResolveShortLinkStart(Long r100) {
        this.resolveShortLinkStart = r100;
    }

    public final void setTemplateResType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.templateResType = r100;
    }

    public final void setViewRef(WeakReference<View> r100) {
        this.viewRef = r100;
    }

    public /* bridge */ boolean containsKey(String r100) {
        return super.containsKey(r100);
    }

    public /* bridge */ boolean containsValue(Long r100) {
        return super.containsValue(r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r100);
    }

    public /* bridge */ Long get(String r100) {
        return (Long) super.get(r100);
    }

    public /* bridge */ Long remove(String r100) {
        return (Long) super.remove(r100);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((String) r100, (Long) r101);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L6;
        return false;
    L6:
        if ((r101 instanceof Long) == true) goto L9;
        return false;
    L9:
        return remove((String) r100, (Long) r101);
    }

    public final /* bridge */ Long getOrDefault(Object r100, Long r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((String) r100, r101);
    }

    public /* bridge */ boolean remove(String r100, Long r101) {
        return super.remove(r100, r101);
    }

    public /* bridge */ Long getOrDefault(String r100, Long r101) {
        return (Long) super.getOrDefault(r100, r101);
    }

    public static void d(JSONObject r100, String r101, Long r102, Long r103) {
        if (r102 == null) goto L9;
        if (r103 == null) goto L9;
        if ((r103.longValue() - r102.longValue()) >= 0) goto L8;
        long r104 = -2;
    L10:
        r100.put(r101, r104);
        return;
    L8:
        r104 = r103.longValue() - r102.longValue();
    L9:
        r104 = -1;
        goto L10
    }
}
