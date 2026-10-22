package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.annie.bridge.FetchTimingSession;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.config.in0;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonParser;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "fetch")
public final class FetchV3Method extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f63239e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f63240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FetchTimingSession f63241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f63242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f63243d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onDestroy() {
        if (Intrinsics.areEqual(xa1.a.f563030d.getValue(), Boolean.TRUE) == true) goto L5;
    L6:
        super.onDestroy();
        return;
    L5:
        if (this.f63243d == false) goto L6;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        FetchTimingSession r100 = this.f63241b;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        Disposable r101 = this.f63240a;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }

    public FetchV3Method() {
        this.f63242c = true;
    }

    public static List o(JSONObject r100) {
        ArrayList r101 = new ArrayList();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L9;
        String r103 = r102.next();
        String r104 = r100.optString(r103);
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r101.add(new NameValuePair(r103, r104));
        goto L4
    L9:
        return r101;
    }

    public static String k(String r100, JSONObject r101) {
        Uri.Builder r102 = UriProtector.parse(r100).buildUpon();
        Iterator<String> r103 = r101.keys();
    L4:
        if (r103.hasNext() == false) goto L12;
        String r104 = r103.next();
        Object r105 = r101.opt(r104);
        if (r105 == null) goto L9;
        String r106 = r105.toString();
        if (r106 == null) goto L9;
    L10:
        r102.appendQueryParameter(r104, r106);
    L9:
        r106 = "";
        goto L10
    L12:
        return r102.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [T, org.json.JSONObject] */
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r110, CallContext r111) {
        JSONObject r112 = r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        FetchTimingSession.Companion.getClass();
        Intrinsics.checkNotNullParameter(r112, "params");
        boolean r100 = false;
        boolean r101 = r112.optBoolean("enable_timing", false);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        if (r101 == false) goto L9;
        FetchTimingSession r103 = new FetchTimingSession();     // Catch: Throwable -> L7
        r103.recordJsbStartTiming();     // Catch: Throwable -> L7
    L10:
        this.f63241b = r103;
        String r104 = r112.optString("url", "");
        String r105 = r112.optString(com.alipay.sdk.m.p.e.f25671s, "");
        if (r105 == null) goto L14;
        String r106 = r105.toLowerCase(Locale.getDefault());
        if (r106 == null) goto L14;
    L15:
        String r113 = r106;
        JSONObject r107 = r112.optJSONObject("headers");
        if (r107 != null) goto L18;
        r107 = new JSONObject();
    L18:
        Ref.ObjectRef r114 = new Ref.ObjectRef();
        JSONObject r108 = r112.optJSONObject("params");
        T r109 = r108;
        if (r108 != null) goto L21;
        r109 = new JSONObject();
    L21:
        r114.element = r109;
        JSONObject r115 = r112.optJSONObject("data");
        if (r115 != null) goto L24;
        r115 = new JSONObject();
    L24:
        JSONObject r116 = r115;
        this.f63242c = r112.optBoolean("add_common_params", true);
        ?? r117 = (JSONObject) r114.element;
        r117.put("live_request_from_jsb", 1);
        r114.element = r117;
        String r118 = r117.optString("webcast_sdk_version");
        if (r118 != null) goto L27;
    L30:
        boolean r119 = true;
    L31:
        if (r119 == false) goto L33;
        r117.put("webcast_sdk_version", com.bytedance.android.livesdk.paas.c.b());
    L33:
        r114.element = r117;
        IMiddleWareHostContext r120 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        if (r120 == null) goto L57;
        Map<String, String> r121 = r120.getFEParamExtra();
        if (r121 == null) goto L57;
        Set<Map.Entry<String, String>> r122 = r121.entrySet();
        if (r122 == null) goto L57;
        Iterator<T> r123 = r122.iterator();
    L41:
        if (r123.hasNext() == false) goto L57;
        Map.Entry r124 = (Map.Entry) r123.next();
        String r125 = (String) r124.getKey();
        if (r125 == null) goto L41;
        if (r125.length() <= 0) goto L47;
        boolean r126 = true;
    L48:
        if (r126 != true) goto L41;
        String r127 = (String) r124.getValue();
        if (r127 == null) goto L41;
        if (r127.length() <= 0) goto L54;
        boolean r128 = true;
    L55:
        if (r128 != true) goto L41;
        r117.put((String) r124.getKey(), r124.getValue());
        goto L41
    L54:
        r128 = false;
        goto L55
    L47:
        r126 = false;
    L57:
        r114.element = r117;
        if (StringsKt.contains$default(r104, "aweme/v1/user/", false, 2, null) == false) goto L67;
        String r129 = ((JSONObject) r114.element).optString("sec_user_id");
        if (r129 != null) goto L62;
    L63:
        r100 = true;
    L64:
        if (r100 == true) goto L67;
        ((JSONObject) r114.element).remove("anchor_id");
        goto L67
    L62:
        if (r129.length() != 0) goto L64;
    L67:
        if ((r111.f249269d instanceof WebView) == false) goto L69;
        r107.put("hybrid-app-engine", "webview");
    L69:
        View r130 = r111.f249269d;
        if (r130 == null) goto L76;
        ILatchService r131 = (ILatchService) com.bytedance.android.annie.a.c(ILatchService.class);
        if (r131.c(r130) == false) goto L74;
    L75:
        r107.put("hybrid-app-engine", "lynx");
        goto L76
    L74:
        if (r131.O0(r130) == true) goto L75;
    L76:
        l30.i.b(r107, r111);
        JSONObject r132 = r112.optJSONObject("pb_extras");
        String r133 = r111.f249267b;
        Logger.d("AnnieBusinessLatchService", "fetchV3 invoke. head:" + r107 + ", requestObj:" + ((JSONObject) r114.element) + ", postObj:" + r116);
        this.f63240a = Observable.just(r113).subscribeOn(Schedulers.io()).map(new i3(this, r104, r107, r114, r116, r133, r132)).observeOn(AndroidSchedulers.mainThread()).subscribe(new j3(this, r111, r114, r112, r104, r113), new k3(this, r104, r113, r114, r111));
        return;
    L27:
        if (r118.length() == 0) goto L30;
        r119 = false;
    L14:
        r106 = MonitorConstants.CONNECT_TYPE_GET;
    L9:
        r103 = null;
    L7:
        th = move-exception;
        Result.Companion r134 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public static final JSONObject j(FetchV3Method r100, JSONObject r101, HttpResponse r102) {
        r100.getClass();
        JSONObject r103 = new JSONObject();
        r103.put(TemplateNodeType.RAW, r101);
        JSONObject r104 = new JSONObject();
        String r105 = r102.header(NetResponse.HEADER_KEY_LOG_ID);
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        r104.put(NetResponse.HEADER_KEY_LOG_ID, r105);
        r103.put("header", r104);
        return r103;
    }

    public static void l(int r110, String r111, long r112) {
        j9.b r100 = ((k9.e) com.bytedance.android.annie.a.c(k9.e.class)).H0();
        JSONObject r101 = new JSONObject();
        r101.put("status_code", r110);
        Unit r113 = Unit.INSTANCE;
        JSONObject r102 = new JSONObject();
        r102.put("duration", r112);
        JSONObject r103 = new JSONObject();
        com.bytedance.android.annie.ng.a r114 = com.bytedance.android.annie.ng.g.f39671c.get("webcast");
        if (r114 == null) goto L7;
        o8.f r115 = r114.f39644b;
        if (r115 == null) goto L7;
        String r116 = r115.f522331a;
    L8:
        r103.put("virtual_aid", r116);
        j9.b.a.a(r100, null, "latch_pb_result_duration", r111, r101, r102, null, r103, 1, 256);
        return;
    L7:
        r116 = null;
        goto L8
    }

    public final Function1<HttpResponse, JSONObject> n(final String r110, final JSONObject r210, List<NameValuePair> r211) {
        if (r210 == null) goto L5;
        final boolean r100 = r210.optBoolean("report_metric");
    L6:
        final FetchV3Method$modifyHeadersAndGetResponseDecoder$1 r111 = new FetchV3Method$modifyHeadersAndGetResponseDecoder$1(this, r110, r100);
        if (r110 == null) goto L94;
        if (r210 == null) goto L94;
        if (in0.f120467a.getValue().booleanValue() == true) goto L15;
        return new FetchV3Method$modifyHeadersAndGetResponseDecoder$3(r111);
    L15:
        if (r210.optBoolean("enable") == false) goto L17;
        String r101 = r210.optString("pb_definitions");
        if (r101.length() <= 0) goto L21;
        boolean r102 = true;
    L22:
        if (r102 == true) goto L25;
        r101 = null;
    L25:
        if (r101 == null) goto L27;
        final boolean r103 = true;
    L28:
        String r104 = r210.optString("data_message_name");
        if (r104.length() <= 0) goto L31;
        boolean r105 = true;
    L32:
        if (r105 == false) goto L34;
        String r112 = r104;
    L35:
        if (r112 != null) goto L38;
        m(0, "data_message_name is empty", r110, r103);
        return new FetchV3Method$modifyHeadersAndGetResponseDecoder$$inlined$run$lambda$1(r110, r103, r111);
    L38:
        String r106 = r210.optString("extra_message_name");
        if (r106.length() <= 0) goto L41;
        boolean r107 = true;
    L42:
        if (r107 == false) goto L44;
        String r113 = r106;
    L45:
        long r114 = SystemClock.elapsedRealtime();
        if (r101 != null) goto L95;
    L69:
        String r108 = r210.optString("channel");
        if (r108.length() != 0) goto L72;
        boolean r109 = true;
    L73:
        if (r109 == false) goto L75;
        r108 = ((com.bytedance.android.annie.service.prefetch.p) com.bytedance.android.annie.a.c(com.bytedance.android.annie.service.prefetch.p.class)).A0(r110);
    L75:
        if (r108 != null) goto L78;
        m(0, "channel is empty", r110, r103);
        return new FetchV3Method$modifyHeadersAndGetResponseDecoder$$inlined$run$lambda$2(r210, r110, r103, r111, r112, r113, r100, r114);
    L78:
        t9.b r115 = ((t9.c) com.bytedance.android.annie.a.c(t9.c.class)).w0(r108);
        if (r115 != null) goto L81;
    L91:
        m(0, "definitions is empty", r110, r103);
        return new FetchV3Method$modifyHeadersAndGetResponseDecoder$$inlined$run$lambda$3(r210, r110, r103, r111, r112, r113, r100, r114);
    L81:
        if (r115.b(r112, r113) == false) goto L83;
        t9.b r116 = r115;
    L84:
        if (r116 == null) goto L91;
        if (r100 == false) goto L88;
        l(2, r110, SystemClock.elapsedRealtime() - r114);
    L88:
        final t9.b r117 = r116;
    L89:
        ArrayList r118 = (ArrayList) r211;
        r118.add(new NameValuePair("response-format", "protobuf"));
        final String r119 = r112;
        final String r120 = r113;
        return new FetchV3Method$modifyHeadersAndGetResponseDecoder$5(this, r117, r119, r120, r210, r110, r100, r103, r111);
    L83:
        r116 = null;
        goto L84
    L72:
        r109 = false;
        goto L73
    L95:
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L55
        t9.b r122 = ((t9.c) com.bytedance.android.annie.a.c(t9.c.class)).M0(new JsonParser().parse(r101).getAsJsonObject());     // Catch: Throwable -> L55
        if (r122 != null) goto L50;
    L52:
        r122 = null;
    L53:
        Object r123 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L55
    L58:
        if (Result.m9456isSuccessimpl(r123) == false) goto L63;
        t9.b r124 = (t9.b) r123;
        if (r100 == false) goto L63;
        l(3, r110, SystemClock.elapsedRealtime() - r114);
    L63:
        if (Result.m9455isFailureimpl(r123) == false) goto L65;
        r123 = null;
    L65:
        t9.b r125 = (t9.b) r123;
        if (r125 == null) goto L69;
        r117 = r125;
        goto L89
    L50:
        if (r122.b(r112, r113) == false) goto L52;
    L55:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L58
    L44:
        r113 = null;
        goto L45
    L41:
        r107 = false;
        goto L42
    L34:
        r112 = null;
        goto L35
    L31:
        r105 = false;
        goto L32
    L27:
        r103 = false;
        goto L28
    L21:
        r102 = false;
        goto L22
    L17:
        return new FetchV3Method$modifyHeadersAndGetResponseDecoder$4(r111);
    L94:
        return new FetchV3Method$modifyHeadersAndGetResponseDecoder$2(r111);
    L5:
        r100 = false;
        goto L6
    }

    public static void m(int r110, String r111, String r112, boolean r113) {
        j9.b r100 = ((k9.e) com.bytedance.android.annie.a.c(k9.e.class)).H0();
        JSONObject r101 = new JSONObject();
        r101.put("status_code", r110);
        r101.put("reason", r111);
        r101.put("dynamic", r113 ? 1 : 0);
        Unit r114 = Unit.INSTANCE;
        JSONObject r102 = new JSONObject();
        com.bytedance.android.annie.ng.a r115 = com.bytedance.android.annie.ng.g.f39671c.get("webcast");
        if (r115 == null) goto L7;
        o8.f r116 = r115.f39644b;
        if (r116 == null) goto L7;
        Object r117 = r116.f522331a;
    L8:
        r102.put("virtual_aid", r117);
        j9.b.a.a(r100, null, "latch_pb_result_all", r112, r101, null, null, r102, 1, 256);
        return;
    L7:
        r117 = null;
        goto L8
    }
}
