package com.bytedance.anniex.bd.foundation.impl;

import android.util.Pair;
import com.bytedance.anniex.bd.utils.ISLNetworkAPI;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class SLNetworkImpl {
    public SLNetworkImpl() {
    }

    public static final String a(SLNetworkImpl r100, String r101) {
        r100.getClass();
        SLNetworkImpl r102 = f.f190143a;     // Catch: Throwable -> L5
        String r103 = URLEncoder.encode(r101, "UTF-8");     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L5
        return r103;
    L5:
        th = move-exception;
        Intrinsics.checkNotNull(th, "null cannot be cast to non-null type kotlin.Throwable{ com.bytedance.rts.foundation.RTSErrorKt.RTSError }");
        String r104 = th.getMessage();
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        throw new Throwable("Encoding error: ".concat(r104));
    }

    public final String b(String r100, final Map<String, String> r101) {
        if (r101 != null) goto L4;
        return r100;
    L4:
        if (r101.size() == 0) goto L20;
        ArrayList r102 = com.bytedance.rts.foundation.m.c(r101);
        if (com.bytedance.rts.foundation.j.d(r102) != 0) goto L9;
        String r103 = "";
    L11:
        if (r100.length() != 0) goto L14;
        return r103;
    L14:
        if (StringsKt.indexOf$default(r100, "?", 0, false, 6, null) < 0) goto L16;
        StringBuilder r104 = new StringBuilder();
        r104.append(r100);
        SLNetworkImpl r105 = f.f190143a;
        r104.append("&");
    L17:
        r104.append(r103);
        return r104.toString();
    L16:
        r104 = new StringBuilder();
        r104.append(r100);
        r104.append('?');
        goto L17
    L9:
        final StringBuilder r106 = new StringBuilder();
        com.bytedance.rts.foundation.j.h(r102, new SLNetworkImpl$formatUrl$1(r106, this, r101));
        r103 = r106.toString();
        Intrinsics.checkNotNull(r103);
        goto L11
    L20:
        return r100;
    }

    public final void c(final lr3.c r100, Function2<? super lr3.b, ? super lr3.d, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, HiAnalyticsConstant.Direction.REQUEST);
        Intrinsics.checkNotNullParameter(r101, "callback");
        String r102 = b(r100.f510391a, r100.f510394d);     // Catch: Throwable -> L20
        Map r103 = TypeIntrinsics.asMutableMap(new LinkedHashMap());     // Catch: Throwable -> L20
        Pair<String, String> r104 = UrlUtils.parseUrl(new UrlBuilder(r102).build(), r103);     // Catch: Throwable -> L20
        String r105 = null;
        if (r104 == null) goto L6;
        String r106 = (String) r104.first;     // Catch: Throwable -> L20
    L7:
        String r107 = "";
        if (r106 != null) goto L10;
        r106 = "";
    L10:
        if (r104 == null) goto L12;
        r105 = (String) r104.second;     // Catch: Throwable -> L20
    L12:
        if (r105 == null) goto L15;
        r107 = r105;
    L15:
        v r108 = new v(r106, r107, r103);     // Catch: Throwable -> L20
        final ArrayList r109 = new ArrayList();     // Catch: Throwable -> L20
        Map<String, String> r110 = r100.f510395e;     // Catch: Throwable -> L20
        if (r110 == null) goto L18;
        com.bytedance.rts.foundation.j.h(com.bytedance.rts.foundation.m.c(r110), new SLNetworkImpl$parseHeaderList$1(r100, r109));     // Catch: Throwable -> L20
    L18:
        d(r100, r108, r109, r101);     // Catch: Throwable -> L20
        return;
    L6:
        r106 = null;
    }

    public static void d(lr3.c r110, v r111, ArrayList r112, Function2 r113) {
        String r100 = r111.f190158a;
        String r101 = r111.f190159b;
        Map<String, String> r114 = r111.f190160c;
        JSONObject r102 = null;
        if (r114 == null) goto L5;
        Map<String, String> r103 = r114;
    L6:
        final LinkedHashMap r115 = new LinkedHashMap();
        Object r104 = RetrofitUtils.createSsService(r100, ISLNetworkAPI.class);
        Intrinsics.checkNotNull(r104);
        String r105 = r110.f510392b;
        if (Intrinsics.areEqual(r105, "GET") == false) goto L10;
        boolean r106 = !Intrinsics.areEqual(r110.f510393c, Boolean.FALSE);
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type kotlin.collections.List<com.bytedance.retrofit2.client.Header>");
        Call<String> r116 = ((ISLNetworkAPI) r104).doGetForString(r106, -1, r101, r103, r112, null);
    L28:
        if (r116 == null) goto L68;
        int r117 = 0;
        SsResponse<String> r118 = r116.execute();     // Catch: Throwable -> L38
        if (r118 == null) goto L37;
        r117 = r118.code();     // Catch: Throwable -> L38
        String r107 = r118.body();     // Catch: Throwable -> L38
        List<Header> r119 = r118.headers();     // Catch: Throwable -> L35
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type java.util.ArrayList<com.bytedance.retrofit2.client.Header>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<com.bytedance.retrofit2.client.Header> }");     // Catch: Throwable -> L35
        com.bytedance.rts.foundation.j.h((ArrayList) r119, new SLNetworkImpl$requestInternal$2(r115));     // Catch: Throwable -> L35
    L67:
        lr3.b r108 = null;
    L71:
        if (r107 == null) goto L73;
        r102 = o.d(r107);
    L73:
        r113.invoke(r108, new lr3.d(r117, r115, r102));
        return;
    L35:
        th = th;
    L41:
        if ((th instanceof HttpResponseException) == false) goto L43;
        HttpResponseException r109 = (HttpResponseException) th;
    L45:
        if ((th instanceof NetworkNotAvailabeException) == false) goto L47;
        NetworkNotAvailabeException r120 = (NetworkNotAvailabeException) th;
    L49:
        if ((th instanceof CronetIOException) == false) goto L51;
        CronetIOException r121 = th;
    L52:
        if (r109 == null) goto L54;
        r117 = r109.getStatusCode();
        goto L67
    L54:
        String r122 = "";
        if (r120 == null) goto L61;
        String r123 = r120.getMessage();
        if (r123 == null) goto L60;
        r122 = r123;
    L60:
        lr3.b r124 = new lr3.b(r122);
    L69:
        r108 = r124;
        r117 = -1;
        goto L71
    L61:
        if (r121 == null) goto L67;
        r117 = r121.getStatusCode();
        String r125 = r121.getMessage();
        if (r125 == null) goto L66;
        r122 = r125;
    L66:
        r121.getStatusCode();
        r108 = new lr3.b(r122);
        goto L71
    L51:
        r121 = null;
        goto L52
    L47:
        r120 = null;
        goto L49
    L43:
        r109 = null;
        goto L45
    L37:
        r107 = null;
        r108 = null;
    L38:
        th = th;
        r107 = null;
        goto L41
    L68:
        r124 = null;
        r107 = null;
        goto L69
    L10:
        if (Intrinsics.areEqual(r105, "POST") == false) goto L27;
        SLNetworkImpl r126 = f.f190143a;
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type kotlin.collections.List<com.bytedance.retrofit2.client.Header>");
        List<Header> r127 = CollectionsKt.toMutableList(r112);
        Iterator r128 = r112.iterator();
    L13:
        if (r128.hasNext() == false) goto L17;
        Object r129 = r128.next();
        String r130 = ((Header) r129).getName();
        SLNetworkImpl r131 = f.f190143a;
        if (Intrinsics.areEqual(r130, "Content-Type") == false) goto L13;
    L18:
        Header r132 = (Header) r129;
        if (r132 == null) goto L21;
        String r133 = r132.getValue();
        Intrinsics.checkNotNull(r133);
    L22:
        Object r134 = r110.f510396f;
        if (r134 == null) goto L25;
        Intrinsics.checkNotNull(r134);
        String r135 = o.e(TypeIntrinsics.asMutableMap(r134)).toString();
        Intrinsics.checkNotNull(r135, "null cannot be cast to non-null type kotlin.String");
        TypedByteArray r136 = new TypedByteArray(r133, StringsKt.encodeToByteArray(r135), new String[]{null});
    L26:
        boolean r137 = !Intrinsics.areEqual(r110.f510393c, Boolean.FALSE);
        Intrinsics.checkNotNull(r127, "null cannot be cast to non-null type kotlin.collections.List<com.bytedance.retrofit2.client.Header>");
        r116 = ((ISLNetworkAPI) r104).doPostForString(r137, -1, r101, r103, r127, r136, null);
        goto L28
    L25:
        r136 = null;
        goto L26
    L21:
        SLNetworkImpl r138 = f.f190143a;
        r127.add(new Header("Content-Type", "application/json"));
        r133 = "application/json";
        goto L22
    L17:
        r129 = null;
        goto L18
    L27:
        SLNetworkImpl r139 = f.f190143a;
        r113.invoke(new lr3.b("Unsupported Request Method"), null);
        r116 = null;
        goto L28
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("queryMap");
        r103 = null;
        goto L6
    }
}
