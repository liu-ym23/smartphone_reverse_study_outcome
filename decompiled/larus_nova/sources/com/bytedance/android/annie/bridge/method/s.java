package com.bytedance.android.annie.bridge.method;

import android.net.Uri;
import android.util.Pair;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.FetchTimingSession;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.android.annie.service.network.IAnnieNetworkService;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.auth.SecurityContextUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "fetch")
public final class s extends com.bytedance.ies.web.jsbridge2.f<JsonObject, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f38812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f38813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IAnnieNetworkService f38814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FetchTimingSession f38815d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        FetchTimingSession r100 = this.f38815d;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        Disposable r101 = this.f38812a;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }

    public s() {
    }

    public static JsonObject k(com.bytedance.android.annie.service.network.d r100) {
        JsonObject r101 = new JsonObject();
        r101.add(TemplateNodeType.RAW, GsonProtectorUtils.parse(new JsonParser(), new String(r100.f39893c, Charsets.UTF_8)).getAsJsonObject());
        JsonObject r102 = new JsonObject();
        int r103 = 0;
    L4:
        if (r103 >= r100.f39892b.size()) goto L9;
        if (NetResponse.HEADER_KEY_LOG_ID.equalsIgnoreCase((String) ((Pair) ListProtector.get(r100.f39892b, r103)).first) == true) goto L7;
        r103 = r103 + 1;
        goto L4
    L7:
        String r104 = (String) ((Pair) ListProtector.get(r100.f39892b, r103)).second;
    L10:
        if (r104 != null) goto L12;
        r104 = "";
    L12:
        r102.addProperty(NetResponse.HEADER_KEY_LOG_ID, r104);
        r101.add("header", r102.getAsJsonObject());
        return r101;
    L9:
        r104 = null;
        goto L10
    }

    public final List<Pair<String, String>> l(JsonObject r100) {
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        Map.Entry r103 = (Map.Entry) r102.next();
        Object r104 = r103.getKey();
        JsonElement r105 = (JsonElement) r103.getValue();
        if (r105 == null) goto L8;
        String r106 = r105.getAsString();
    L9:
        if (r106 != null) goto L11;
        r106 = "";
    L11:
        r101.add(new Pair(r104, r106));
        goto L4
    L8:
        r106 = null;
        goto L9
    L12:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.google.gson.JsonObject] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [T] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [T] */
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JsonObject r110, CallContext r111) {
        JsonObject r112 = r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f38814c = (IAnnieNetworkService) Annie.getService(IAnnieNetworkService.class, r111.a());
        FetchTimingSession.Companion.getClass();
        this.f38815d = FetchTimingSession.a.a(r112);
        JsonElement r100 = r112.get("url");
        if (r100 == null) goto L5;
        String r101 = r100.getAsString();
    L6:
        Intrinsics.checkNotNull(r101);
        JsonElement r102 = r112.get(com.alipay.sdk.m.p.e.f25671s);
        if (r102 == null) goto L12;
        String r103 = r102.getAsString();
        if (r103 == null) goto L12;
        String r104 = r103.toLowerCase(Locale.getDefault());
        if (r104 == null) goto L12;
    L13:
        String r105 = r104;
        JsonElement r106 = r112.get("headers");
        if (r106 == null) goto L16;
        JsonObject r107 = r106.getAsJsonObject();
    L17:
        if (r107 != null) goto L19;
        r107 = new JsonObject();
    L19:
        JsonObject r108 = r107;
        Set<String> r109 = SecurityContextUtils.f269807a;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        String r113 = SecurityContextUtils.b(r111);
        Iterator r114 = r108.keySet().iterator();
    L20:
        boolean r115 = true;
        if (r114.hasNext() == false) goto L25;
        Object r116 = r114.next();
        if (StringsKt.equals((String) r116, "x-security-argus", true) == false) goto L20;
    L26:
        String r117 = (String) r116;
        if (r117 == null) goto L29;
        r108.remove(r117);
    L29:
        r108.addProperty("x-security-argus", r113);
        Ref.ObjectRef r118 = new Ref.ObjectRef();
        JsonElement r119 = r112.get("params");
        if (r119 == null) goto L32;
        ?? r120 = r119.getAsJsonObject();
    L33:
        if (r120 != 0) goto L35;
        r120 = new JsonObject();
    L35:
        r118.element = r120;
        JsonElement r121 = r112.get("data");
        if (r121 == null) goto L38;
        JsonObject r122 = r121.getAsJsonObject();
    L39:
        if (r122 != null) goto L41;
        r122 = new JsonObject();
    L41:
        JsonElement r123 = r112.get("num_to_string");
        if (r123 == null) goto L44;
        boolean r124 = r123.getAsBoolean();
    L45:
        this.f38813b = r124;
        JsonObject r125 = (JsonObject) r118.element;
        if (r125 != null) goto L48;
        ?? r126 = new JsonObject();
    L49:
        if (r125 == null) goto L51;
        r125.addProperty("live_request_from_jsb", 1);
    L51:
        r118.element = r126;
        if (com.bytedance.android.annie.ng.g.b().f39659c.f522324a == false) goto L67;
        if (StringsKt.contains$default(r101, "aweme/v1/user/", false, 2, null) == false) goto L67;
        JsonElement r127 = ((JsonObject) r118.element).get("sec_user_id");
        if (r127 == null) goto L58;
        String r128 = r127.getAsString();
    L59:
        if (r128 != null) goto L61;
    L64:
        if (r115 == true) goto L67;
        ((JsonObject) r118.element).remove("anchor_id");
        goto L67
    L61:
        if (r128.length() == 0) goto L64;
        r115 = false;
        goto L64
    L58:
        r128 = null;
    L67:
        if ((r111.f249269d instanceof WebView) == false) goto L69;
        r108.addProperty("hybrid-app-engine", "webview");
    L69:
        View r129 = r111.f249269d;
        if (r129 == null) goto L76;
        ILatchService r130 = (ILatchService) Annie.getService$default(ILatchService.class, null, 2, null);
        if (r130.c(r129) == false) goto L74;
    L75:
        r108.addProperty("hybrid-app-engine", "lynx");
        goto L76
    L74:
        if (r130.O0(r129) == true) goto L75;
    L76:
        this.f38812a = Observable.just(r105).subscribeOn(Schedulers.io()).map(new t(this, r101, r108, r118, r122)).observeOn(AndroidSchedulers.mainThread()).subscribe(new u(this, r111, r112), new v(this, r111, r101, r105));
        return;
    L48:
        r126 = r125;
        goto L49
    L44:
        r124 = false;
        goto L45
    L38:
        r122 = null;
        goto L39
    L32:
        r120 = 0;
        goto L33
    L25:
        r116 = null;
        goto L26
    L16:
        r107 = null;
    L12:
        r104 = MonitorConstants.CONNECT_TYPE_GET;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    public final String j(String r100, JsonObject r101) {
        Uri.Builder r102 = UriProtector.parse(r100).buildUpon();
        Iterator<T> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L17;
        Map.Entry r104 = (Map.Entry) r103.next();
        String r105 = (String) r104.getKey();
        String r106 = null;
        JsonElement r107 = (JsonElement) r104.getValue();     // Catch: UnsupportedOperationException -> L10
        if (r107 == null) goto L13;
        r106 = r107.getAsString();     // Catch: UnsupportedOperationException -> L10
    L13:
        if (r106 != null) goto L15;
        r106 = "";
    L15:
        r102.appendQueryParameter(r105, r106);
    L10:
        JsonElement r108 = (JsonElement) r104.getValue();
        if (r108 == null) goto L13;
        r106 = r108.toString();
        goto L13
    L17:
        return r102.toString();
    }
}
