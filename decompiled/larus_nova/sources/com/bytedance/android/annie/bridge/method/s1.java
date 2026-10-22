package com.bytedance.android.annie.bridge.method;

import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.RequestResultModel;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.auth.SecurityContextUtils;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "request")
public final class s1 extends e7.v<e7.s0, RequestResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f38817a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f38818b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f38819c = null;

    public static final class a {
        @JvmStatic
        public static String a(JsonObject r100) {
            if (r100 != null) goto L5;
            return "application/x-www-form-urlencoded";
        L5:
            JsonElement r101 = r100.get("Content-Type");
            if (r101 == null) goto L11;
            String r102 = r101.getAsString();
            if (r102 == null) goto L11;
            return r102;
        L11:
            JsonElement r103 = r100.get(com.alipay.sdk.m.p.e.f25658f);
            if (r103 == null) goto L14;
            String r104 = r103.getAsString();
        L15:
            if (r104 != null) goto L18;
            return "application/x-www-form-urlencoded";
        L18:
            return r104;
        L14:
            r104 = null;
            goto L15
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    static {
        f38817a = CollectionsKt.listOf(new String[]{MonitorConstants.CONNECT_TYPE_GET, UGCMonitor.TYPE_POST});
        f38818b = CollectionsKt.listOf(new String[]{"json", "text"});
        f38819c = CollectionsKt.listOf(new String[]{"application/x-www-form-urlencoded", "application/json"});
    }

    public s1() {
    }

    public static void j(e7.s0 r100) {
        String r101 = r100.g();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if ((!r103) == false) goto L30;
        List<String> r104 = f38817a;
        String r105 = r100.c();
        Intrinsics.checkNotNull(r105);
        if (r104.contains(r105) == false) goto L28;
        String r106 = a.a(r100.b());
        Iterator<String> r107 = f38819c.iterator();
    L15:
        if (r107.hasNext() == false) goto L19;
        if (StringsKt.startsWith$default(r106, r107.next(), false, 2, null) == false) goto L15;
        r102 = true;
    L19:
        if (r102 == false) goto L26;
        List<String> r108 = f38818b;
        String r109 = r100.f();
        Intrinsics.checkNotNull(r109);
        if (r108.contains(r109) == false) goto L24;
        return;
    L24:
        throw new IllegalStateException("invalid response type".toString());
    L26:
        throw new IllegalStateException(" invalid content-type ".toString());
    L28:
        throw new IllegalStateException(" invalid method ".toString());
    L30:
        throw new IllegalStateException(" invalid url ".toString());
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r103 = false;
        goto L10
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        e7.s0 r112 = (e7.s0) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r100 = r112.c();
        if (r100 == null) goto L6;
        String r101 = r100.toLowerCase(Locale.getDefault());
        if (r101 == null) goto L6;
    L7:
        r112.j(r101);
        Boolean r102 = r112.d();
        if (r102 != null) goto L10;
        r102 = Boolean.TRUE;
    L10:
        r112.k(r102);
        String r103 = r112.f();
        if (r103 != null) goto L13;
        r103 = "json";
    L13:
        r112.l(r103);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L16
        j(r112);     // Catch: Throwable -> L16
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L21;
        RequestResultModel r113 = new RequestResultModel();
        r113.b(RequestResultModel.Code.InvalidParam);
        r113.e(r106.getMessage());
        finishWithResult(r113);
        return;
    L21:
        t1 r107 = new t1(this);
        if (Intrinsics.areEqual(r112.h(), Boolean.TRUE) == false) goto L24;
        RequestResultModel r114 = new RequestResultModel();
        r114.e("prefetch not impl");
        r114.b(RequestResultModel.Code.InvalidParam);
        finishWithResult(r114);
        return;
    L24:
        String r108 = r112.g();
        Intrinsics.checkNotNull(r108);
        JsonObject r109 = r112.e();
        if (r109 == null) goto L43;
        Uri.Builder r115 = UriProtector.parse(r108).buildUpon();
        Iterator<T> r116 = r109.entrySet().iterator();
    L29:
        if (r116.hasNext() == false) goto L42;
        Map.Entry r117 = (Map.Entry) r116.next();
        String r118 = (String) r117.getKey();
        JsonElement r119 = (JsonElement) r117.getValue();     // Catch: UnsupportedOperationException -> L35
        if (r119 == null) goto L38;
        String r120 = r119.getAsString();     // Catch: UnsupportedOperationException -> L35
    L39:
        if (r120 != null) goto L41;
        r120 = "";
    L41:
        r115.appendQueryParameter(r118, r120);
    L38:
        r120 = null;
    L35:
        JsonElement r121 = (JsonElement) r117.getValue();
        if (r121 == null) goto L38;
        r120 = r121.toString();
        goto L39
    L42:
        r108 = r115.toString();
    L43:
        r112.m(r108);
        JsonObject r122 = r112.b();
        if (r122 != null) goto L46;
        r122 = new JsonObject();
    L46:
        Set<String> r123 = SecurityContextUtils.f269807a;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        String r124 = SecurityContextUtils.b(r111);
        Iterator<T> r125 = r122.keySet().iterator();
    L48:
        if (r125.hasNext() == false) goto L52;
        Object r126 = r125.next();
        if (StringsKt.equals((String) r126, "x-security-argus", true) == false) goto L48;
    L53:
        String r127 = (String) r126;
        if (r127 == null) goto L56;
        r122.remove(r127);
    L56:
        r122.addProperty("x-security-argus", r124);
        r112.i(r122);
        if ((r111.f249269d instanceof WebView) == false) goto L61;
        JsonObject r128 = r112.b();
        if (r128 == null) goto L61;
        r128.addProperty("hybrid-app-engine", "webview");
    L61:
        View r129 = r111.f249269d;
        if (r129 == null) goto L70;
        ILatchService r130 = (ILatchService) Annie.getService$default(ILatchService.class, null, 2, null);
        if (r130.c(r129) == false) goto L66;
    L67:
        JsonObject r131 = r112.b();
        if (r131 == null) goto L70;
        r131.addProperty("hybrid-app-engine", "lynx");
        goto L70
    L66:
        if (r130.O0(r129) == true) goto L67;
    L70:
        u1.b r132 = new u1.b(r112, r107, r111);
        String r133 = r132.f38836b.c();
        Intrinsics.checkNotNull(r133);
        Observable.just(r133).subscribeOn(Schedulers.io()).map(new v1(r132)).observeOn(AndroidSchedulers.mainThread()).subscribe(new w1(r132), new x1(r132));
        return;
    L52:
        r126 = null;
    L16:
        th = move-exception;
        Result.Companion r134 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L6:
        r101 = MonitorConstants.CONNECT_TYPE_GET;
        goto L7
    }
}
