package aq6;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.locallife.dito.common.lynx.DitoLynxNativeModule;
import com.bytedance.locallife.dito.data.DitoPage;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes21.dex */
public final class c {
    public static final uq6.k c(SsResponse<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "ssResponse");
        uq6.k r101 = new uq6.k(0);
        r101.z(Integer.valueOf(r100.code()));
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        r101.A(r100.message());     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Object r103 = r100.raw().getExtraInfo();
        if (r103 == null) goto L142;
        Unit r104 = null;
        Number r105 = null;
        if ((r103 instanceof BaseHttpRequestInfo) == false) goto L12;
        BaseHttpRequestInfo r106 = (BaseHttpRequestInfo) r103;
    L13:
        if (r106 == null) goto L142;
        r101.u(r106.dnsTime);
        r101.s(r106.connectTime);
        r101.F(r106.sslTime);
        r101.C(r106.sendTime);
        r101.H(r106.ttfbMs);
        r101.x(r106.receiveTime);
        r101.G(r106.totalTime);
        r101.D(r106.sentByteCount);
        r101.y(r106.receivedByteCount);
        r101.E(r106.isSocketReused);
        Intrinsics.checkNotNullParameter(r106, "<this>");
        Intrinsics.checkNotNullParameter(r101, "httpRequestInfo");
        String r107 = r106.requestLog;
        if (r107 == null) goto L142;
        Object r108 = GsonProtectorUtils.fromJson(kp6.d.a(), r107, new b().getRawType());     // Catch: Throwable -> L136
        if ((r108 instanceof Map) == false) goto L20;
        Map r109 = (Map) r108;     // Catch: Throwable -> L136
    L21:
        if (r109 == null) goto L23;
        Object r110 = r109.get("timing");     // Catch: Throwable -> L136
    L25:
        if ((r110 instanceof Map) == false) goto L27;
        Map r111 = (Map) r110;     // Catch: Throwable -> L136
    L28:
        if (r109 == null) goto L30;
        Object r112 = r109.get("response");     // Catch: Throwable -> L136
    L32:
        if ((r112 instanceof Map) == false) goto L34;
        Map r113 = (Map) r112;     // Catch: Throwable -> L136
    L35:
        long r114 = 0;
        if (r111 == null) goto L107;
        Map r115 = (Map) r111.get("detailed_duration");     // Catch: Throwable -> L136
        if (r115 == null) goto L40;
        Object r116 = r115.get("proxy");     // Catch: Throwable -> L136
    L42:
        if ((r116 instanceof Number) == false) goto L44;
        Number r117 = (Number) r116;     // Catch: Throwable -> L136
    L45:
        if (r117 == null) goto L47;
        Long r118 = Long.valueOf(r117.longValue());     // Catch: Throwable -> L136
    L48:
        r101.w(r118);     // Catch: Throwable -> L136
        if (r115 == null) goto L51;
        Object r119 = r115.get("rtt");     // Catch: Throwable -> L136
    L53:
        if ((r119 instanceof Number) == false) goto L55;
        Number r120 = (Number) r119;     // Catch: Throwable -> L136
    L56:
        if (r120 == null) goto L58;
        Long r121 = Long.valueOf(r120.longValue());     // Catch: Throwable -> L136
    L59:
        r101.B(r121);     // Catch: Throwable -> L136
        if (r115 == null) goto L62;
        Object r122 = r115.get("header_recv");     // Catch: Throwable -> L136
    L64:
        if ((r122 instanceof Number) == false) goto L66;
        Number r123 = (Number) r122;     // Catch: Throwable -> L136
    L67:
        if (r123 == null) goto L69;
        Long r124 = Long.valueOf(r123.longValue());     // Catch: Throwable -> L136
    L70:
        r101.v(r124);     // Catch: Throwable -> L136
        if (r115 == null) goto L73;
        Object r125 = r115.get("body_recv");     // Catch: Throwable -> L136
    L75:
        if ((r125 instanceof Number) == false) goto L77;
        Number r126 = (Number) r125;     // Catch: Throwable -> L136
    L78:
        if (r126 == null) goto L80;
        Long r127 = Long.valueOf(r126.longValue());     // Catch: Throwable -> L136
    L81:
        r101.r(r127);     // Catch: Throwable -> L136
        if (r101.p() > 0) goto L94;
        if (r115 == null) goto L85;
        Object r128 = r115.get(MonitorConstants.TTFB);     // Catch: Throwable -> L136
    L87:
        if ((r128 instanceof Number) == false) goto L89;
        Number r129 = (Number) r128;     // Catch: Throwable -> L136
    L90:
        if (r129 == null) goto L92;
        long r130 = r129.longValue();     // Catch: Throwable -> L136
    L93:
        r101.H(r130);     // Catch: Throwable -> L136
        goto L94
    L92:
        r130 = 0;
        goto L93
    L89:
        r129 = null;
        goto L90
    L85:
        r128 = null;
    L94:
        Map r131 = (Map) r111.get("request");     // Catch: Throwable -> L136
        if (r101.o() > 0) goto L107;
        if (r131 == null) goto L98;
        Object r132 = r131.get("duration");     // Catch: Throwable -> L136
    L100:
        if ((r132 instanceof Number) == false) goto L102;
        Number r133 = (Number) r132;     // Catch: Throwable -> L136
    L103:
        if (r133 == null) goto L105;
        long r134 = r133.longValue();     // Catch: Throwable -> L136
    L106:
        r101.G(r134);     // Catch: Throwable -> L136
        goto L107
    L105:
        r134 = 0;
        goto L106
    L102:
        r133 = null;
        goto L103
    L98:
        r132 = null;
        goto L100
    L80:
        r127 = null;
        goto L81
    L77:
        r126 = null;
        goto L78
    L73:
        r125 = null;
        goto L75
    L69:
        r124 = null;
        goto L70
    L66:
        r123 = null;
        goto L67
    L62:
        r122 = null;
        goto L64
    L58:
        r121 = null;
        goto L59
    L55:
        r120 = null;
        goto L56
    L51:
        r119 = null;
        goto L53
    L47:
        r118 = null;
        goto L48
    L44:
        r117 = null;
        goto L45
    L40:
        r116 = null;
    L107:
        if (r113 == null) goto L134;
        Object r135 = r113.get("connection_info");     // Catch: Throwable -> L136
        if ((r135 instanceof Number) == false) goto L111;
        Number r136 = (Number) r135;     // Catch: Throwable -> L136
    L112:
        if (r136 == null) goto L114;
        Integer r137 = Integer.valueOf(r136.intValue());     // Catch: Throwable -> L136
    L115:
        r101.t(r137);     // Catch: Throwable -> L136
        if (r101.g() > 0) goto L126;
        Object r138 = r113.get(StreamTrafficObservable.STREAM_RECEIVEDBYTES);     // Catch: Throwable -> L136
        if ((r138 instanceof Number) == false) goto L120;
        Number r139 = (Number) r138;     // Catch: Throwable -> L136
    L121:
        if (r139 == null) goto L123;
        long r140 = r139.longValue();     // Catch: Throwable -> L136
    L124:
        r101.y(r140);     // Catch: Throwable -> L136
        goto L126
    L123:
        r140 = 0;
        goto L124
    L120:
        r139 = null;
    L126:
        if (r101.l() > 0) goto L133;
        Object r141 = r113.get(StreamTrafficObservable.STREAM_SENTBYTES);     // Catch: Throwable -> L136
        if ((r141 instanceof Number) == false) goto L130;
        r105 = (Number) r141;     // Catch: Throwable -> L136
    L130:
        if (r105 == null) goto L132;
        r114 = r105.longValue();     // Catch: Throwable -> L136
    L132:
        r101.D(r114);     // Catch: Throwable -> L136
    L133:
        r104 = Unit.INSTANCE;     // Catch: Throwable -> L136
        goto L134
    L114:
        r137 = null;
        goto L115
    L111:
        r136 = null;
    L134:
        Object r142 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L136
    L138:
        Throwable r143 = Result.m9452exceptionOrNullimpl(r142);
        if (r143 == null) goto L142;
        rq6.a.f538927a.b(DitoLynxNativeModule.NAME, "===appendInfoFromRequestLog error:" + r143.getMessage() + ",casue:" + r143.getCause());
        goto L142
    L34:
        r113 = null;
        goto L35
    L30:
        r112 = null;
        goto L32
    L27:
        r111 = null;
        goto L28
    L23:
        r110 = null;
        goto L25
    L20:
        r109 = null;
    L136:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        r142 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L138
    L12:
        r106 = null;
    L142:
        return r101;
    L5:
        th = move-exception;
        Result.Companion r145 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final lp6.a a(SsResponse<?> r100, DitoPage r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List<Header> r102 = r100.headers();
        LinkedHashMap r103 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r102, 10)), 16));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Header r105 = (Header) r104.next();
        Pair r106 = TuplesKt.to(r105.getName(), r105.getValue());
        r103.put(r106.getFirst(), r106.getSecond());
        goto L4
    L6:
        lp6.a r107 = new lp6.a(r101, r103, 4);
        uq6.k r108 = c(r100);
        Intrinsics.checkNotNullParameter(r107, "<this>");
        Object r109 = r107.f510232c.put("DITO_HTTP_REQUEST_INFO", r108);
        if ((r109 instanceof uq6.k) == false) goto L9;
        uq6.k r110 = (uq6.k) r109;
    L9:
        return r107;
    }

    public static final com.bytedance.locallife.dito.provider.b<Object> b(String r100, Map<String, Object> r101) {
        int r102 = com.bytedance.locallife.dito.provider.b.f258669b;
        com.bytedance.locallife.dito.provider.b<Object> r103 = new com.bytedance.locallife.dito.provider.b(1, null, new LinkedHashMap(), false, 2);
        Map r104 = (Map) r103.c();
        if (r104 == null) goto L7;
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        r104.put("node_tag", r100);
    L7:
        if (r101 == null) goto L11;
        Map r105 = (Map) r103.c();
        if (r105 == null) goto L11;
        r105.putAll(r101);
    L11:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.locallife.dito.provider.DitoActionResult<kotlin.Any?>");
        return r103;
    }
}
