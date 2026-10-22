package com.bytedance.android.ec.core.utils;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.google.gson.Gson;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45625a = 0;

    static {
    }

    @JvmStatic
    public static final di.d b(CommerceBaseResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "baseResponse");
        if (r100.getTtNetExtraInfo() != null) goto L8;
        return null;
    L8:
        return a(com.bytedance.android.ec.hybrid.list.util.k.d(r100.getTtNetExtraInfo()), r100.getEcNetRequestEnd());
    L10:
        return null;
    }

    @JvmStatic
    public static final di.l e(Object r100) {
        if (r100 != null) goto L14;
        return null;
    L14:
        Gson r101 = new Gson();     // Catch: Exception -> L11
        di.l r102 = (di.l) r101.fromJson(com.bytedance.android.ec.hybrid.list.util.k.d(r100), di.l.class);     // Catch: Exception -> L11
        if (r102 == null) goto L8;
        String r103 = r102.f();     // Catch: Exception -> L11
    L9:
        r102.f468712a = (di.m) r101.fromJson(r103, di.m.class);     // Catch: Exception -> L11
        return r102;
    L8:
        r103 = null;
    L11:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    }

    public static di.b f(di.l r210) {
        Intrinsics.checkNotNullParameter(r210, "requestInfo");
        di.m r100 = r210.f468712a;
        if (r100 == null) goto L8;
        di.a r101 = r100.a();
        if (r101 == null) goto L8;
        String r102 = r101.b();
        if (r102 == null) goto L8;
    L9:
        String r103 = UriProtector.parse(r102).getPath();
        di.m r104 = r210.f468712a;
        if (r104 == null) goto L14;
        di.a r105 = r104.a();
        if (r105 == null) goto L14;
        String r106 = r105.a();
    L15:
        di.m r107 = r210.f468712a;
        if (r107 == null) goto L20;
        di.n r108 = r107.d();
        if (r108 == null) goto L20;
        Integer r109 = r108.a();
    L21:
        di.m r110 = r210.f468712a;
        if (r110 == null) goto L26;
        di.n r111 = r110.d();
        if (r111 == null) goto L26;
        Integer r112 = r111.c();
    L27:
        di.m r113 = r210.f468712a;
        if (r113 == null) goto L32;
        di.n r114 = r113.d();
        if (r114 == null) goto L32;
        Integer r115 = r114.d();
    L33:
        di.m r116 = r210.f468712a;
        if (r116 == null) goto L38;
        di.o r117 = r116.e();
        if (r117 == null) goto L38;
        Boolean r118 = r117.a();
    L39:
        Integer r119 = Integer.valueOf(Intrinsics.areEqual(r118, Boolean.TRUE) ? 1 : 0);
        di.m r120 = r210.f468712a;
        if (r120 == null) goto L44;
        di.n r121 = r120.d();
        if (r121 == null) goto L44;
        Integer r122 = r121.b();
    L45:
        di.m r123 = r210.f468712a;
        if (r123 == null) goto L50;
        di.k r124 = r123.c();
        if (r124 == null) goto L50;
        Integer r125 = r124.a();
    L51:
        di.m r126 = r210.f468712a;
        if (r126 == null) goto L56;
        di.k r127 = r126.c();
        if (r127 == null) goto L56;
        String r128 = r127.b();
    L57:
        di.e r129 = r210.c();
        if (r129 == null) goto L60;
        Integer r130 = r129.a();
    L61:
        di.e r131 = r210.c();
        if (r131 == null) goto L64;
        String r132 = r131.b();
    L65:
        di.e r133 = r210.c();
        if (r133 == null) goto L68;
        String r134 = r133.c();
    L69:
        di.m r135 = r210.f468712a;
        if (r135 == null) goto L74;
        di.g r136 = r135.b();
        if (r136 == null) goto L74;
        Integer r137 = r136.a();
    L75:
        di.m r138 = r210.f468712a;
        if (r138 == null) goto L80;
        di.g r139 = r138.b();
        if (r139 == null) goto L80;
        Integer r140 = r139.b();
    L81:
        di.m r141 = r210.f468712a;
        if (r141 == null) goto L86;
        di.g r142 = r141.b();
        if (r142 == null) goto L86;
        Integer r143 = r142.c();
    L87:
        di.m r144 = r210.f468712a;
        if (r144 == null) goto L92;
        di.g r145 = r144.b();
        if (r145 == null) goto L92;
        Integer r146 = r145.e();
    L93:
        di.m r147 = r210.f468712a;
        if (r147 == null) goto L98;
        di.g r148 = r147.b();
        if (r148 == null) goto L98;
        Integer r149 = r148.d();
    L100:
        return new di.b(r103, r106, r109, r112, r115, r119, r122, r125, r128, r130, r132, r134, r137, r140, r143, r146, r149);
    L98:
        r149 = null;
    L92:
        r146 = null;
    L86:
        r143 = null;
    L80:
        r140 = null;
    L74:
        r137 = null;
        goto L75
    L68:
        r134 = null;
        goto L69
    L64:
        r132 = null;
        goto L65
    L60:
        r130 = null;
    L56:
        r128 = null;
    L50:
        r125 = null;
    L44:
        r122 = null;
    L38:
        r118 = null;
    L32:
        r115 = null;
    L26:
        r112 = null;
    L20:
        r109 = null;
    L14:
        r106 = null;
    L8:
        r102 = "";
        goto L9
    }

    public static JSONObject i(di.d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toJSONObject");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L5
        r102.putOpt("path", r100.f468711c.f468670a);     // Catch: Throwable -> L5
        r102.putOpt(com.alipay.sdk.m.p.e.f25671s, r100.f468711c.f468671b);     // Catch: Throwable -> L5
        r102.putOpt("code", r100.f468711c.f468672c);     // Catch: Throwable -> L5
        r102.putOpt("socket_reused", r100.f468711c.f468675f);     // Catch: Throwable -> L5
        r102.putOpt("connection_info", r100.f468711c.f468676g);     // Catch: Throwable -> L5
        r102.putOpt("net_thread_priority", r100.f468711c.f468677h);     // Catch: Throwable -> L5
        r102.putOpt("ttnet_version", r100.f468711c.f468678i);     // Catch: Throwable -> L5
        r102.putOpt("priority_level", r100.f468711c.f468679j);     // Catch: Throwable -> L5
        r102.putOpt("request_compress_type", r100.f468711c.f468680k);     // Catch: Throwable -> L5
        r102.putOpt("response_compress_type", r100.f468711c.f468681l);     // Catch: Throwable -> L5
        r102.putOpt("effective_net_type", r100.f468711c.f468683n);     // Catch: Throwable -> L5
        r102.putOpt("real_net_type", r100.f468711c.f468686q);     // Catch: Throwable -> L5
        r102.putOpt("before_stream", r100.f468709a.f468687a);     // Catch: Throwable -> L5
        r102.putOpt("body_recv", r100.f468709a.f468688b);     // Catch: Throwable -> L5
        r102.putOpt("connect_delay", r100.f468709a.f468689c);     // Catch: Throwable -> L5
        r102.putOpt("create_stream", r100.f468709a.f468690d);     // Catch: Throwable -> L5
        r102.putOpt("dispatch", r100.f468709a.f468691e);     // Catch: Throwable -> L5
        r102.putOpt(MultiProcessFileUtils.KEY_DNS, r100.f468709a.f468692f);     // Catch: Throwable -> L5
        r102.putOpt("edge", r100.f468709a.f468693g);     // Catch: Throwable -> L5
        r102.putOpt("header_recv", r100.f468709a.f468694h);     // Catch: Throwable -> L5
        r102.putOpt(RNParamRegisterEventHandler.SRC_INNER, r100.f468709a.f468695i);     // Catch: Throwable -> L5
        r102.putOpt(PlayerResolution.SDKKEY.ORIGIN, r100.f468709a.f468696j);     // Catch: Throwable -> L5
        r102.putOpt("proxy", r100.f468709a.f468697k);     // Catch: Throwable -> L5
        r102.putOpt("rtt", r100.f468709a.f468698l);     // Catch: Throwable -> L5
        r102.putOpt("security_callback", r100.f468709a.f468699m);     // Catch: Throwable -> L5
        r102.putOpt("send", r100.f468709a.f468700n);     // Catch: Throwable -> L5
        r102.putOpt(TTVideoEngineInterface.PLAY_API_KEY_SSL, r100.f468709a.f468701o);     // Catch: Throwable -> L5
        r102.putOpt("tcp", r100.f468709a.f468702p);     // Catch: Throwable -> L5
        r102.putOpt(MonitorConstants.TTFB, r100.f468709a.f468703q);     // Catch: Throwable -> L5
        r102.putOpt("tt_agw", r100.f468709a.f468704r);     // Catch: Throwable -> L5
        r102.putOpt("pre_request_duration", Long.valueOf(r100.f468709a.f468705s));     // Catch: Throwable -> L5
        r102.putOpt("net_total_duration", r100.f468709a.f468706t);     // Catch: Throwable -> L5
        r102.putOpt("after_request_duration", Long.valueOf(r100.f468709a.f468707u));     // Catch: Throwable -> L5
        r102.putOpt("response_serializer_duration", Long.valueOf(r100.f468709a.f468708v));     // Catch: Throwable -> L5
        r102.putOpt(ILoadStallMonitor.START_TIME, r100.f468710b.f468713a);     // Catch: Throwable -> L5
        r102.putOpt("create_stream_start", r100.f468710b.f468714b);     // Catch: Throwable -> L5
        r102.putOpt("create_stream_finish", r100.f468710b.f468715c);     // Catch: Throwable -> L5
        r102.putOpt("request_sent_time", r100.f468710b.f468716d);     // Catch: Throwable -> L5
        r102.putOpt("response_recv_time", r100.f468710b.f468717e);     // Catch: Throwable -> L5
        r102.putOpt("end_time", r100.f468710b.f468718f);     // Catch: Throwable -> L5
        r102.putOpt("ec_net_request_start", r100.f468710b.f468719g);     // Catch: Throwable -> L5
        r102.putOpt("ec_net_request_end", r100.f468710b.f468720h);     // Catch: Throwable -> L5
        r102.putOpt("app_level_request_start", r100.f468710b.f468721i);     // Catch: Throwable -> L5
        r102.putOpt("before_all_interceptors", r100.f468710b.f468722j);     // Catch: Throwable -> L5
        r102.putOpt(StreamTrafficObservable.STREAM_RECEIVEDBYTES, r100.f468711c.f468673d);     // Catch: Throwable -> L5
        r102.putOpt(StreamTrafficObservable.STREAM_SENTBYTES, r100.f468711c.f468674e);     // Catch: Throwable -> L5
        r102.putOpt("downlink_throughput", r100.f468711c.f468682m);     // Catch: Throwable -> L5
        r102.putOpt("http_rtt", r100.f468711c.f468684o);     // Catch: Throwable -> L5
        r102.putOpt("tcp_rtt", r100.f468711c.f468685p);     // Catch: Throwable -> L5
        return r102;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    @JvmStatic
    public static final di.d a(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "info");
        boolean r102 = false;
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L28;
        return null;
    L28:
        di.l r104 = (di.l) new Gson().fromJson(r100, di.l.class);     // Catch: Exception -> L25
        if (r104 == null) goto L12;
        String r105 = r104.f();     // Catch: Exception -> L25
    L13:
        if (r105 != null) goto L15;
    L16:
        r102 = true;
    L17:
        if (r102 == false) goto L19;
        return null;
    L19:
        Gson r106 = new Gson();     // Catch: Exception -> L25
        if (r104 == null) goto L22;
        String r107 = r104.f();     // Catch: Exception -> L25
    L23:
        r104.f468712a = (di.m) r106.fromJson(r107, di.m.class);     // Catch: Exception -> L25
        return new di.d(g(r104, r101), h(r104, r101), f(r104));
    L22:
        r107 = null;
        goto L23
    L15:
        if (r105.length() != 0) goto L17;
    L12:
        r105 = null;
    L25:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    L5:
        r103 = false;
        goto L7
    }

    @JvmStatic
    public static final di.d c(SsResponse<?> r110, long r111) {
        Intrinsics.checkNotNullParameter(r110, "retrofitResponse");
        if (r110.raw().getExtraInfo() != null) goto L18;
        return null;
    L18:
        di.l r100 = (di.l) new Gson().fromJson(com.bytedance.android.ec.hybrid.list.util.k.d(r110.raw().getExtraInfo()), di.l.class);     // Catch: Exception -> L15
        Gson r101 = new Gson();     // Catch: Exception -> L15
        if (r100 == null) goto L8;
        String r102 = r100.f();     // Catch: Exception -> L15
    L9:
        r100.f468712a = (di.m) r101.fromJson(r102, di.m.class);     // Catch: Exception -> L15
        di.c r103 = g(r100, null);     // Catch: Exception -> L15
        Long r104 = r100.e();     // Catch: Exception -> L15
        if (r104 == null) goto L12;
        long r105 = r111 - r104.longValue();     // Catch: Exception -> L15
    L13:
        r103.f468707u = r105;     // Catch: Exception -> L15
        Unit r106 = Unit.INSTANCE;     // Catch: Exception -> L15
        di.q r107 = h(r100, null);     // Catch: Exception -> L15
        return new di.d(r103, new di.q(r107.f468713a, r107.f468714b, r107.f468715c, r107.f468716d, r107.f468717e, r107.f468718f, r107.f468719g, Long.valueOf(r111), r107.f468721i, r107.f468722j), f(r100));
    L12:
        r105 = -1;
        goto L13
    L8:
        r102 = null;
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    }

    public static di.c g(di.l r310, Long r311) {
        Intrinsics.checkNotNullParameter(r310, "requestInfo");
        di.m r100 = r310.f468712a;
        if (r100 == null) goto L9;
        di.p r101 = r100.f();
        if (r101 == null) goto L9;
        di.j r102 = r101.a();
        if (r102 == null) goto L9;
        Integer r103 = r102.a();
    L10:
        di.m r104 = r310.f468712a;
        if (r104 == null) goto L17;
        di.p r105 = r104.f();
        if (r105 == null) goto L17;
        di.j r106 = r105.a();
        if (r106 == null) goto L17;
        Integer r107 = r106.b();
    L18:
        di.m r108 = r310.f468712a;
        if (r108 == null) goto L25;
        di.p r109 = r108.f();
        if (r109 == null) goto L25;
        di.j r110 = r109.a();
        if (r110 == null) goto L25;
        Integer r111 = r110.c();
    L26:
        di.m r112 = r310.f468712a;
        if (r112 == null) goto L33;
        di.p r113 = r112.f();
        if (r113 == null) goto L33;
        di.j r114 = r113.a();
        if (r114 == null) goto L33;
        Integer r115 = r114.d();
    L34:
        di.m r116 = r310.f468712a;
        if (r116 == null) goto L41;
        di.p r117 = r116.f();
        if (r117 == null) goto L41;
        di.j r118 = r117.a();
        if (r118 == null) goto L41;
        Integer r119 = r118.e();
    L42:
        di.m r120 = r310.f468712a;
        if (r120 == null) goto L49;
        di.p r121 = r120.f();
        if (r121 == null) goto L49;
        di.j r122 = r121.a();
        if (r122 == null) goto L49;
        Integer r123 = r122.f();
    L50:
        di.m r124 = r310.f468712a;
        if (r124 == null) goto L57;
        di.p r125 = r124.f();
        if (r125 == null) goto L57;
        di.j r126 = r125.a();
        if (r126 == null) goto L57;
        Integer r127 = r126.g();
    L58:
        di.m r128 = r310.f468712a;
        if (r128 == null) goto L65;
        di.p r129 = r128.f();
        if (r129 == null) goto L65;
        di.j r130 = r129.a();
        if (r130 == null) goto L65;
        Integer r131 = r130.h();
    L66:
        di.m r132 = r310.f468712a;
        if (r132 == null) goto L73;
        di.p r133 = r132.f();
        if (r133 == null) goto L73;
        di.j r134 = r133.a();
        if (r134 == null) goto L73;
        Integer r135 = r134.i();
    L74:
        di.m r136 = r310.f468712a;
        if (r136 == null) goto L81;
        di.p r137 = r136.f();
        if (r137 == null) goto L81;
        di.j r138 = r137.a();
        if (r138 == null) goto L81;
        Integer r139 = r138.j();
    L82:
        di.m r140 = r310.f468712a;
        if (r140 == null) goto L89;
        di.p r141 = r140.f();
        if (r141 == null) goto L89;
        di.j r142 = r141.a();
        if (r142 == null) goto L89;
        Integer r143 = r142.k();
    L90:
        di.m r144 = r310.f468712a;
        if (r144 == null) goto L97;
        di.p r145 = r144.f();
        if (r145 == null) goto L97;
        di.j r146 = r145.a();
        if (r146 == null) goto L97;
        Integer r147 = r146.l();
    L98:
        di.m r148 = r310.f468712a;
        if (r148 == null) goto L105;
        di.p r149 = r148.f();
        if (r149 == null) goto L105;
        di.j r150 = r149.a();
        if (r150 == null) goto L105;
        Integer r151 = r150.m();
    L106:
        di.m r152 = r310.f468712a;
        if (r152 == null) goto L113;
        di.p r153 = r152.f();
        if (r153 == null) goto L113;
        di.j r154 = r153.a();
        if (r154 == null) goto L113;
        Integer r155 = r154.n();
    L114:
        di.m r156 = r310.f468712a;
        if (r156 == null) goto L121;
        di.p r157 = r156.f();
        if (r157 == null) goto L121;
        di.j r158 = r157.a();
        if (r158 == null) goto L121;
        Integer r159 = r158.o();
    L122:
        di.m r160 = r310.f468712a;
        if (r160 == null) goto L129;
        di.p r161 = r160.f();
        if (r161 == null) goto L129;
        di.j r162 = r161.a();
        if (r162 == null) goto L129;
        Integer r163 = r162.p();
    L130:
        di.m r164 = r310.f468712a;
        if (r164 == null) goto L137;
        di.p r165 = r164.f();
        if (r165 == null) goto L137;
        di.j r166 = r165.a();
        if (r166 == null) goto L137;
        Integer r210 = r166.r();
    L138:
        di.m r167 = r310.f468712a;
        if (r167 == null) goto L145;
        di.p r168 = r167.f();
        if (r168 == null) goto L145;
        di.j r169 = r168.a();
        if (r169 == null) goto L145;
        Integer r211 = r169.q();
    L146:
        Long r170 = r310.a();
        if (r170 == null) goto L160;
        long r171 = r170.longValue();
        di.m r172 = r310.f468712a;
        if (r172 == null) goto L157;
        di.p r173 = r172.f();
        if (r173 == null) goto L157;
        di.h r174 = r173.b();
        if (r174 == null) goto L157;
        Double r175 = r174.f();
        if (r175 == null) goto L157;
        Double r176 = Double.valueOf((r175.doubleValue() * ((double) 1000)) - r171);
    L158:
        if (r176 == null) goto L161;
        long r177 = (long) r176.doubleValue();
    L162:
        di.m r178 = r310.f468712a;
        if (r178 == null) goto L169;
        di.p r179 = r178.f();
        if (r179 == null) goto L169;
        di.h r180 = r179.b();
        if (r180 == null) goto L169;
        Long r212 = r180.c();
    L170:
        Long r181 = r310.e();
        if (r181 == null) goto L178;
        long r182 = r181.longValue();
        if (r311 == null) goto L175;
        Long r183 = Long.valueOf(r311.longValue() - r182);
    L176:
        if (r183 == null) goto L178;
        long r213 = r183.longValue();
    L179:
        di.e r184 = r310.c();
        if (r184 == null) goto L191;
        Long r185 = r184.e();
        if (r185 == null) goto L191;
        long r186 = r185.longValue();
        di.e r187 = r310.c();
        if (r187 == null) goto L188;
        Long r188 = r187.d();
        if (r188 == null) goto L188;
        Long r189 = Long.valueOf(r188.longValue() - r186);
    L189:
        if (r189 == null) goto L191;
        long r312 = r189.longValue();
    L193:
        return new di.c(r103, r107, r111, r115, r119, r123, r127, r131, r135, r139, r143, r147, r151, r155, r159, r163, r210, r211, r177, r212, r213, r312);
    L188:
        r189 = null;
    L191:
        r312 = -1;
        goto L193
    L175:
        r183 = null;
    L178:
        r213 = -1;
    L169:
        r212 = null;
    L161:
        r177 = -1;
    L157:
        r176 = null;
        goto L158
    L160:
        r143 = r143;
        r147 = r147;
    L145:
        r211 = null;
    L137:
        r210 = null;
    L129:
        r163 = null;
    L121:
        r159 = null;
    L113:
        r155 = null;
    L105:
        r151 = null;
    L97:
        r147 = null;
    L89:
        r143 = null;
    L81:
        r139 = null;
    L73:
        r135 = null;
    L65:
        r131 = null;
    L57:
        r127 = null;
    L49:
        r123 = null;
    L41:
        r119 = null;
    L33:
        r115 = null;
    L25:
        r111 = null;
    L17:
        r107 = null;
    L9:
        r103 = null;
        goto L10
    }

    public static di.q h(di.l r110, Long r111) {
        Intrinsics.checkNotNullParameter(r110, "requestInfo");
        di.m r100 = r110.f468712a;
        if (r100 == null) goto L11;
        di.p r101 = r100.f();
        if (r101 == null) goto L11;
        di.h r102 = r101.b();
        if (r102 == null) goto L11;
        Double r103 = r102.f();
        if (r103 == null) goto L11;
        Long r104 = Long.valueOf((long) (r103.doubleValue() * ((double) 1000)));
    L12:
        di.m r105 = r110.f468712a;
        if (r105 == null) goto L21;
        di.p r106 = r105.f();
        if (r106 == null) goto L21;
        di.h r107 = r106.b();
        if (r107 == null) goto L21;
        Double r108 = r107.b();
        if (r108 == null) goto L21;
        Long r109 = Long.valueOf((long) (r108.doubleValue() * ((double) 1000)));
    L22:
        di.m r112 = r110.f468712a;
        if (r112 == null) goto L31;
        di.p r113 = r112.f();
        if (r113 == null) goto L31;
        di.h r114 = r113.b();
        if (r114 == null) goto L31;
        Double r115 = r114.a();
        if (r115 == null) goto L31;
        Long r116 = Long.valueOf((long) (r115.doubleValue() * ((double) 1000)));
    L32:
        di.m r117 = r110.f468712a;
        if (r117 == null) goto L41;
        di.p r118 = r117.f();
        if (r118 == null) goto L41;
        di.h r119 = r118.b();
        if (r119 == null) goto L41;
        Double r120 = r119.d();
        if (r120 == null) goto L41;
        Long r121 = Long.valueOf((long) (r120.doubleValue() * ((double) 1000)));
    L42:
        di.m r122 = r110.f468712a;
        if (r122 == null) goto L51;
        di.p r123 = r122.f();
        if (r123 == null) goto L51;
        di.h r124 = r123.b();
        if (r124 == null) goto L51;
        Double r125 = r124.e();
        if (r125 == null) goto L51;
        Long r126 = Long.valueOf((long) (r125.doubleValue() * ((double) 1000)));
    L53:
        return new di.q(r104, r109, r116, r121, r126, r110.e(), r110.a(), r111, r110.a(), r110.b());
    L51:
        r126 = null;
    L41:
        r121 = null;
    L31:
        r116 = null;
    L21:
        r109 = null;
    L11:
        r104 = null;
        goto L12
    }

    public static Map d(Object r100, di.l r110, int r111) {
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r110 = null;
    L8:
        if (r100 != null) goto L11;
        if (r110 != null) goto L11;
        return null;
    L11:
        if (r110 == null) goto L135;
    L13:
        LinkedHashMap r101 = new LinkedHashMap();     // Catch: Exception -> L132
        if (r110 == null) goto L16;
        di.m r112 = r110.f468712a;     // Catch: Exception -> L132
    L17:
        if (r112 == null) goto L137;
        if (r110.c() == null) goto L137;
        di.m r113 = r110.f468712a;     // Catch: Exception -> L132
        if (r113 == null) goto L25;
        di.p r102 = r113.f();     // Catch: Exception -> L132
        if (r102 == null) goto L25;
        di.j r103 = r102.a();     // Catch: Exception -> L132
    L26:
        if (r113 == null) goto L30;
        di.p r114 = r113.f();     // Catch: Exception -> L132
        if (r114 == null) goto L30;
        di.h r115 = r114.b();     // Catch: Exception -> L132
    L31:
        di.e r104 = r110.c();     // Catch: Exception -> L132
        if (r115 == null) goto L34;
        Long r116 = r115.c();     // Catch: Exception -> L132
    L35:
        r101.put("tt_total_duration", String.valueOf(r116));     // Catch: Exception -> L132
        if (r103 == null) goto L38;
        Integer r105 = r103.r();     // Catch: Exception -> L132
    L39:
        r101.put("tt_net_duration", String.valueOf(r105));     // Catch: Exception -> L132
        if (r103 == null) goto L42;
        Integer r106 = r103.f();     // Catch: Exception -> L132
    L43:
        r101.put("tt_timing_dns", String.valueOf(r106));     // Catch: Exception -> L132
        if (r103 == null) goto L46;
        Integer r107 = r103.p();     // Catch: Exception -> L132
    L47:
        r101.put("tt_timing_connect", String.valueOf(r107));     // Catch: Exception -> L132
        if (r103 == null) goto L50;
        Integer r108 = r103.o();     // Catch: Exception -> L132
    L51:
        r101.put("tt_timing_ssl", String.valueOf(r108));     // Catch: Exception -> L132
        if (r103 == null) goto L54;
        Integer r109 = r103.k();     // Catch: Exception -> L132
    L55:
        r101.put("tt_timing_proxy", String.valueOf(r109));     // Catch: Exception -> L132
        if (r103 == null) goto L58;
        Integer r117 = r103.n();     // Catch: Exception -> L132
    L59:
        r101.put("tt_timing_send", String.valueOf(r117));     // Catch: Exception -> L132
        if (r103 == null) goto L62;
        Integer r118 = r103.h();     // Catch: Exception -> L132
    L63:
        r101.put("tt_timing_header_recv", String.valueOf(r118));     // Catch: Exception -> L132
        if (r103 == null) goto L66;
        Integer r119 = r103.b();     // Catch: Exception -> L132
    L67:
        r101.put("tt_timing_body_recv", String.valueOf(r119));     // Catch: Exception -> L132
        if (r103 == null) goto L70;
        Integer r120 = r103.g();     // Catch: Exception -> L132
    L71:
        r101.put("tt_timing_ttfb_edge", String.valueOf(r120));     // Catch: Exception -> L132
        if (r103 == null) goto L74;
        Integer r121 = r103.j();     // Catch: Exception -> L132
    L75:
        r101.put("tt_timing_ttfb_origin", String.valueOf(r121));     // Catch: Exception -> L132
        if (r103 == null) goto L78;
        Integer r122 = r103.i();     // Catch: Exception -> L132
    L79:
        r101.put("tt_timing_ttfb_inner", String.valueOf(r122));     // Catch: Exception -> L132
        if (r103 == null) goto L82;
        Integer r123 = r103.l();     // Catch: Exception -> L132
    L83:
        r101.put("tt_timing_ttfb_rtt", String.valueOf(r123));     // Catch: Exception -> L132
        Long r124 = r110.g();     // Catch: Exception -> L132
        Long r125 = r110.b();     // Catch: Exception -> L132
        if (r124 == null) goto L87;
        if (r125 == null) goto L87;
        r101.put("tt_timing_req_interceptor", String.valueOf(r124.longValue() - r125.longValue()));     // Catch: Exception -> L132
    L87:
        int r126 = 0;
        if (r103 == null) goto L92;
        Integer r127 = r103.m();     // Catch: Exception -> L132
        if (r127 == null) goto L92;
        int r128 = r127.intValue();     // Catch: Exception -> L132
    L93:
        if (r103 == null) goto L97;
        Integer r129 = r103.e();     // Catch: Exception -> L132
        if (r129 == null) goto L97;
        int r130 = r129.intValue();     // Catch: Exception -> L132
    L98:
        r101.put("tt_timing_req_pre_process", String.valueOf(r128 + r130));     // Catch: Exception -> L132
        if (r103 == null) goto L103;
        Integer r131 = r103.k();     // Catch: Exception -> L132
        if (r131 == null) goto L103;
        int r132 = r131.intValue();     // Catch: Exception -> L132
    L104:
        if (r103 == null) goto L108;
        Integer r133 = r103.f();     // Catch: Exception -> L132
        if (r133 == null) goto L108;
        int r134 = r133.intValue();     // Catch: Exception -> L132
    L109:
        int r135 = r132 + r134;     // Catch: Exception -> L132
        if (r103 == null) goto L114;
        Integer r136 = r103.p();     // Catch: Exception -> L132
        if (r136 == null) goto L114;
        int r137 = r136.intValue();     // Catch: Exception -> L132
    L115:
        int r138 = r135 + r137;     // Catch: Exception -> L132
        if (r103 == null) goto L120;
        Integer r139 = r103.o();     // Catch: Exception -> L132
        if (r139 == null) goto L120;
        r126 = r139.intValue();     // Catch: Exception -> L132
    L120:
        r101.put("tt_timing_req_create", String.valueOf(r138 + r126));     // Catch: Exception -> L132
        long r140 = 0;
        if (r104 == null) goto L125;
        Long r141 = r104.d();     // Catch: Exception -> L132
        if (r141 == null) goto L125;
        long r142 = r141.longValue();     // Catch: Exception -> L132
    L126:
        if (r104 == null) goto L130;
        Long r143 = r104.e();     // Catch: Exception -> L132
        if (r143 == null) goto L130;
        r140 = r143.longValue();     // Catch: Exception -> L132
    L130:
        r101.put("tt_timing_parse", String.valueOf(r142 - r140));     // Catch: Exception -> L132
        r101.put("tt_resp_body_size", String.valueOf(r110.d()));     // Catch: Exception -> L132
        r101.put("tt_req_body_size", String.valueOf(r110.h()));     // Catch: Exception -> L132
    L132:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    L125:
        r142 = 0;
    L114:
        r137 = 0;
    L108:
        r134 = 0;
    L103:
        r132 = 0;
    L97:
        r130 = 0;
    L92:
        r128 = 0;
        goto L93
    L82:
        r123 = null;
        goto L83
    L78:
        r122 = null;
        goto L79
    L74:
        r121 = null;
        goto L75
    L70:
        r120 = null;
        goto L71
    L66:
        r119 = null;
        goto L67
    L62:
        r118 = null;
        goto L63
    L58:
        r117 = null;
        goto L59
    L54:
        r109 = null;
        goto L55
    L50:
        r108 = null;
        goto L51
    L46:
        r107 = null;
        goto L47
    L42:
        r106 = null;
        goto L43
    L38:
        r105 = null;
        goto L39
    L34:
        r116 = null;
    L30:
        r115 = null;
    L25:
        r103 = null;
    L137:
        return r101;
    L16:
        r112 = null;
        goto L17
    L135:
        r110 = e(r100);     // Catch: Exception -> L132
        goto L13
    }
}
