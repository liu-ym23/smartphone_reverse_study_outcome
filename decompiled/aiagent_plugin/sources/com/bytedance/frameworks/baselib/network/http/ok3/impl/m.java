package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.utility.Logger;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.capabilitykit.common.Ext;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.ag;
import okhttp3.u;
import okhttp3.v;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: OkHttp3RequestLog.java */
/* JADX INFO: loaded from: classes.dex */
public class m {
    private long A;
    private aa B;
    private String C;
    private boolean D;
    private boolean E;
    private String F;
    private Socket G;
    private u H;
    private String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f8541J;
    private final List<p> K;
    private d L;
    private String M;
    private int N;
    private s O;
    private String P;
    private boolean Q;
    private boolean R;
    private final List<com.bytedance.frameworks.baselib.network.http.ok3.impl.b.d> S;
    private int T;
    private com.bytedance.frameworks.baselib.network.http.ok3.impl.a.b U;
    private String V;
    private com.bytedance.frameworks.baselib.network.http.c W;
    private com.bytedance.frameworks.baselib.network.http.b X;
    private Context Y;
    private final AtomicBoolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f8542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f8543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f8544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f8545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f8546e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private final AtomicLong p;
    private long q;
    private long r;
    private final List<Pair<InetSocketAddress, Integer>> s;
    private Proxy.Type t;
    private c u;
    private ag v;
    private okhttp3.i w;
    private long x;
    private u y;
    private int z;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.ok3.impl.m$1, reason: invalid class name */
    /* JADX INFO: compiled from: OkHttp3RequestLog.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8547a = null;

        static {
            int[] r0 = new int[aa.values().length];
            f8547a = r0;
            r0[aa.f39694b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f8547a[aa.f39695c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f8547a[aa.f39697e.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f8547a[aa.f39696d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f8547a[aa.g.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    private static long a(long r3, long r5) {
        if (r5 != (-1)) goto L5;
    L8:
        return -1;
    L5:
        if (r3 == (-1)) goto L8;
        return r3 - r5;
    }

    public void a() {
        this.Z.set(true);
    }

    public m(com.bytedance.frameworks.baselib.network.http.b r6, Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        this.f8542a = -1;
        this.f8543b = -1;
        this.f8544c = -1;
        this.f8545d = -1;
        this.f8546e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.p = new AtomicLong(-1);
        this.q = -1;
        this.r = -1;
        this.s = new ArrayList();
        this.t = Proxy.Type.DIRECT;
        this.u = c.f8466a;
        this.x = 0;
        this.z = -1;
        this.A = 0;
        this.B = null;
        this.C = "";
        this.D = false;
        this.E = false;
        this.F = "";
        this.I = "";
        this.f8541J = 0;
        this.K = new ArrayList();
        this.L = d.f8470a;
        this.M = "";
        this.N = -1;
        this.O = s.f8564a;
        this.P = "";
        this.Q = false;
        this.R = false;
        this.S = new ArrayList();
        this.T = 0;
        this.V = "";
        this.Z = new AtomicBoolean(false);
        this.X = r6;
        this.Y = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
    }

    private void m() {
        this.X.l = -1;
        this.X.f8138d.f(a(this.f8544c, this.f8543b));
        this.X.f8138d.g(a(this.f, this.f8545d));
        this.X.f8138d.h(a(this.g, this.f));
        this.X.f8138d.i(a(this.i, this.h) + a(this.k, this.j));
        this.X.f8138d.j(-1);
        this.X.f8138d.k(-1);
        this.X.f8138d.l(a(this.o, this.n));
        this.X.f8138d.m(a(this.p.get(), this.f8542a));
        this.X.f8138d.b(a(this.Y));
        this.X.w = this.F;
        com.bytedance.frameworks.baselib.network.http.b r0 = this.X;
        if (this.f8545d == (-1)) goto L5;
    L7:
        boolean r3 = false;
    L8:
        r0.D = r3;
        this.X.x = this.x;
        this.X.y = this.A;
        this.X.z = this.A;
        this.X.E = -1;
        u r1 = this.y;
        if (r1 == null) goto L11;
        this.X.M = a(r1);
        this.X.x += this.y.c();
    L11:
        u r2 = this.H;
        if (r2 == null) goto L14;
        this.X.N = a(r2);
        this.X.y += this.H.c();
    L14:
        this.X.O = this.I;
        this.X.f8138d.aE();
        return;
    L5:
        if (this.q == (-1)) goto L7;
        r3 = true;
        goto L8
    }

    private static String a(u r6) {
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L18
        Iterator<Map.Entry<String, List<String>>> r7 = r6.e().entrySet().iterator();     // Catch: Exception -> L18
    L5:
        if (r7.hasNext() == false) goto L16;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
        List r4 = (List) ZeusTransformUtils.preCheckCast(r2.getValue(), List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r3) == true) goto L5;
        if (r4 == null) goto L5;
        if (r4.size() <= 0) goto L5;
        Iterator r5 = r4.iterator();     // Catch: Exception -> L18
    L14:
        if (r5.hasNext() == false) goto L5;
        r1.put(r3, (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L18
        goto L14
    L16:
        return r1.toString();
    L18:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    private String a(Context r24) {
        String r2 = "Cookie";
        String r3 = "ssl";
        String r4 = "dns";
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r24, Context.class, "com.obric.aiagent.plugin");
        JSONObject r10 = new JSONObject();
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L296
        String r12 = com.bytedance.frameworks.baselib.network.http.ok3.impl.b.l.a().g();     // Catch: JSONException -> L296
        ArrayList r13 = new ArrayList();     // Catch: JSONException -> L296
        if (TextUtils.isEmpty(r12) == true) goto L8;
        String[] r14 = r12.split(",");     // Catch: JSONException -> L296
        if (r14 == null) goto L8;
        r13.addAll(Arrays.asList(r14));     // Catch: JSONException -> L296
    L8:
        com.bytedance.frameworks.baselib.network.http.ok3.a r15 = r.i();     // Catch: JSONException -> L296
        if (r15 == null) goto L24;
        List<String> r16 = r15.e();     // Catch: JSONException -> L296
        if (r16 == null) goto L24;
        if (r16.size() > 5) goto L15;
    L17:
        Iterator<String> r17 = r16.iterator();     // Catch: JSONException -> L296
        int r18 = 0;
    L19:
        if (r17.hasNext() == false) goto L24;
        Iterator<String> r19 = r17;
        String r110 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L296
        r18 = r18 + 1;     // Catch: JSONException -> L296
        if (r18 > 5) goto L24;
        r13.add(r110);     // Catch: JSONException -> L296
        r17 = r19;
        goto L19
    L15:
        if (Logger.debug() == false) goto L17;
        Logger.d("ok3log", "ab sdk version count must less than 5");     // Catch: JSONException -> L296
    L24:
        JSONArray r111 = new JSONArray();     // Catch: JSONException -> L296
        Iterator r112 = r13.iterator();     // Catch: JSONException -> L296
    L26:
        if (r112.hasNext() == false) goto L30;
        String r113 = (String) ZeusTransformUtils.preCheckCast(r112.next(), String.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L296
        if (TextUtils.isEmpty(r113) == true) goto L26;
        r111.put(r113);     // Catch: JSONException -> L296
        goto L26
    L30:
        r11.put("hit", r111);     // Catch: JSONException -> L296
        r10.put("ab_test", r11);     // Catch: JSONException -> L296
        JSONObject r114 = new JSONObject();     // Catch: JSONException -> L296
        r114.put("load_state", this.L.ordinal());     // Catch: JSONException -> L296
        r114.put("method", this.M);     // Catch: JSONException -> L296
        if (this.O != s.f8566c) goto L33;
        boolean r115 = true;
    L34:
        r114.put("is_pending", r115);     // Catch: JSONException -> L296
        r114.put("status", this.O);     // Catch: JSONException -> L296
        if (this.O == s.f8565b) goto L39;
        r114.put("net_error", this.N);     // Catch: JSONException -> L296
    L39:
        if (TextUtils.isEmpty(this.P) == true) goto L49;
        Uri r116 = Uri.parse(this.P);     // Catch: JSONException -> L296
        if (r116 == null) goto L49;
        if (TextUtils.isEmpty(r116.getScheme()) == true) goto L49;
        if (TextUtils.isEmpty(r116.getHost()) == true) goto L49;
        if (r116.getPath() == null) goto L49;
        r114.put("origin_url", r116.getScheme() + "://" + r116.getHost() + r116.getPath());     // Catch: JSONException -> L296
    L49:
        r114.put("redirect_times", this.f8541J);     // Catch: JSONException -> L296
        JSONArray r117 = new JSONArray();     // Catch: JSONException -> L296
        JSONArray r118 = new JSONArray();     // Catch: JSONException -> L296
        Iterator<p> r119 = this.K.iterator();     // Catch: JSONException -> L296
    L51:
        String r120 = r2;
        if (r119.hasNext() == false) goto L67;
        String r121 = r3;
        Iterator<p> r122 = r119;
        p r5 = (p) ZeusTransformUtils.preCheckCast(r119.next(), p.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L296
        JSONObject r123 = new JSONObject();     // Catch: JSONException -> L296
        String r20 = r4;
        r123.put(MonitorConstants.CODE, r5.f8549a);     // Catch: JSONException -> L296
        r123.put("method", r5.f8550b);     // Catch: JSONException -> L296
        r123.put("internal", r5.f8552d);     // Catch: JSONException -> L296
        if (r5.f8551c == null) goto L66;
        Uri r6 = Uri.parse(r5.f8551c);     // Catch: JSONException -> L296
        if (r6 == null) goto L66;
        if (TextUtils.isEmpty(r6.getScheme()) == true) goto L66;
        if (TextUtils.isEmpty(r6.getHost()) == true) goto L66;
        String r7 = r6.getScheme() + "://" + r6.getHost();     // Catch: JSONException -> L296
        r118.put(r7);     // Catch: JSONException -> L296
        if (r6.getPath() == null) goto L65;
        r7 = r7 + r6.getPath();     // Catch: JSONException -> L296
    L65:
        r123.put("url", r7);     // Catch: JSONException -> L296
    L66:
        r117.put(r123);     // Catch: JSONException -> L296
        r3 = r121;
        r2 = r120;
        r119 = r122;
        r4 = r20;
        goto L51
    L67:
        String r124 = r3;
        String r21 = r4;
        r114.put("redirect_info", r117);     // Catch: JSONException -> L296
        r114.put("redirecting_list", r118);     // Catch: JSONException -> L296
        r114.put("dispatched", this.Q);     // Catch: JSONException -> L296
        r10.put("base", r114);     // Catch: JSONException -> L296
        JSONObject r9 = new JSONObject();     // Catch: JSONException -> L296
        r9.put(MonitorConstants.CODE, this.z);     // Catch: JSONException -> L296
        r9.put("connection_info", a(this.B).g);     // Catch: JSONException -> L296
        u r22 = this.y;     // Catch: JSONException -> L296
        if (r22 == null) goto L70;
        long r125 = r22.c();     // Catch: JSONException -> L296
    L71:
        r9.put("sent_bytes", this.x + r125);     // Catch: JSONException -> L296
        u r23 = this.H;     // Catch: JSONException -> L296
        if (r23 == null) goto L74;
        long r126 = r23.c();     // Catch: JSONException -> L296
    L75:
        r9.put("received_bytes", this.A + r126);     // Catch: JSONException -> L296
        r9.put("cached", this.D);     // Catch: JSONException -> L296
        r9.put("network_accessed", this.E);     // Catch: JSONException -> L296
        if (this.t == Proxy.Type.DIRECT) goto L78;
        boolean r25 = true;
    L79:
        r9.put("via_proxy", r25);     // Catch: JSONException -> L296
        u r26 = this.H;     // Catch: JSONException -> L296
        if (r26 == null) goto L94;
        List<String> r27 = r26.b("Set-Cookie");     // Catch: JSONException -> L296
        if (com.bytedance.common.utility.collection.a.a(r27) == true) goto L84;
        boolean r28 = true;
    L85:
        r9.put("set_cookie", r28);     // Catch: JSONException -> L296
        if (r28 == false) goto L94;
        r9.put("set_cookie_lines", r27.size());     // Catch: JSONException -> L296
        Iterator<String> r29 = r27.iterator();     // Catch: JSONException -> L296
        long r127 = 0;
    L89:
        if (r29.hasNext() == false) goto L93;
        String r30 = (String) ZeusTransformUtils.preCheckCast(r29.next(), String.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L296
        if (r30 == null) goto L89;
        r127 = r127 + ((long) r30.length());     // Catch: JSONException -> L296
        goto L89
    L93:
        r9.put("set_cookie_bytes", r127);     // Catch: JSONException -> L296
        goto L94
    L84:
        r28 = false;
    L94:
        r10.put("response", r9);     // Catch: JSONException -> L296
        JSONObject r31 = new JSONObject();     // Catch: JSONException -> L296
        if (this.H == null) goto L137;
        int r32 = 0;
    L99:
        if (r32 >= this.H.a()) goto L121;
        String r128 = this.H.a(r32);     // Catch: JSONException -> L296
        String r129 = this.H.b(r32);     // Catch: JSONException -> L296
        if (TextUtils.isEmpty(r128) == true) goto L120;
        if (TextUtils.isEmpty(r129) == true) goto L120;
        String r130 = r128.toLowerCase();     // Catch: JSONException -> L296
        if (r130.startsWith("x-tt-") == false) goto L120;
        if (r130.contains("sids") == true) goto L120;
        if (r130.contains(SensitiveType.SESSION) == true) goto L120;
        if (r130.contains("token") == true) goto L120;
        if (r130.contains("uid") == true) goto L120;
        if (r130.contains("sign") == true) goto L120;
        r31.put(r128, r129);     // Catch: JSONException -> L296
    L120:
        r32 = r32 + 1;     // Catch: JSONException -> L296
        goto L99
    L121:
        String r33 = this.H.a("tt-idc-switch");     // Catch: JSONException -> L296
        if (TextUtils.isEmpty(r33) == true) goto L124;
        r31.put("tt-idc-switch", r33);     // Catch: JSONException -> L296
    L124:
        String r34 = this.H.a("server-timing");     // Catch: JSONException -> L296
        if (TextUtils.isEmpty(r34) == true) goto L127;
        r31.put("server-timing", r34);     // Catch: JSONException -> L296
    L127:
        List<String> r35 = e.a().b();     // Catch: JSONException -> L296
        if (com.bytedance.common.utility.collection.a.a(r35) == true) goto L136;
        Iterator<String> r36 = r35.iterator();     // Catch: JSONException -> L296
    L131:
        if (r36.hasNext() == false) goto L136;
        String r37 = (String) ZeusTransformUtils.preCheckCast(r36.next(), String.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L296
        if (TextUtils.isEmpty(r37) == true) goto L131;
        r31.remove(r37);     // Catch: JSONException -> L296
    L136:
        r10.put("header", r31);     // Catch: JSONException -> L296
    L138:
        JSONObject r38 = new JSONObject();     // Catch: JSONException -> L296
        r38.put("libcore", "okhttp");     // Catch: JSONException -> L296
        r38.put("core_ver", r.h());     // Catch: JSONException -> L296
        r38.put("is_main_process", com.bytedance.frameworks.baselib.network.http.i.h.b(r8));     // Catch: JSONException -> L296
        r38.put("ttnet_version", "4.2.243.22-doubao");     // Catch: JSONException -> L296
        r38.put("retry_attempts", -1);     // Catch: JSONException -> L296
        com.bytedance.frameworks.baselib.network.http.c r39 = this.W;     // Catch: JSONException -> L296
        if (r39 != null) goto L141;
    L143:
        r10.put("other", r38);     // Catch: JSONException -> L296
        JSONObject r40 = new JSONObject();     // Catch: JSONException -> L296
        JSONObject r41 = new JSONObject();     // Catch: JSONException -> L296
        r41.put(r21, a(this.f8544c, this.f8543b));     // Catch: JSONException -> L296
        r41.put("tcp", a(this.f, this.f8545d));     // Catch: JSONException -> L296
        r41.put(r124, a(this.g, this.f));     // Catch: JSONException -> L296
        Object r131 = "";
        r41.put("send", a(this.i, this.h) + a(this.k, this.j));     // Catch: JSONException -> L296
        long r42 = a(this.m, this.i);     // Catch: JSONException -> L296
        r41.put(MonitorConstants.TTFB, r42);     // Catch: JSONException -> L296
        r41.put("header_recv", a(this.m, this.l));     // Catch: JSONException -> L296
        r41.put("body_recv", a(this.o, this.n));     // Catch: JSONException -> L296
        r41.put("dispatch", this.r);     // Catch: JSONException -> L296
        a(r34, r41, r42);     // Catch: JSONException -> L296
        com.bytedance.frameworks.baselib.network.http.ok3.impl.a.b r43 = this.U;     // Catch: JSONException -> L296
        if (r43 != null) goto L147;
    L149:
        r40.put("detailed_duration", r41);     // Catch: JSONException -> L296
        JSONObject r44 = new JSONObject();     // Catch: JSONException -> L296
        r44.put("start_time", this.f8542a);     // Catch: JSONException -> L296
        r44.put("duration", a(this.p.get(), this.f8542a));     // Catch: JSONException -> L296
        r44.put("request_sent_time", this.h);     // Catch: JSONException -> L296
        r44.put("response_recv_time", this.l);     // Catch: JSONException -> L296
        r40.put(Ext.KEY_REQUEST, r44);     // Catch: JSONException -> L296
        r10.put("timing", r40);     // Catch: JSONException -> L296
        JSONObject r45 = new JSONObject();     // Catch: JSONException -> L296
        Socket r46 = this.G;     // Catch: JSONException -> L296
        if (r46 == null) goto L168;
        InetAddress r47 = r46.getInetAddress();     // Catch: JSONException -> L296
        if (r47 == null) goto L168;
        a r48 = a.f8404a;     // Catch: JSONException -> L296
        if (ZeusTransformUtils.instanceOf(r47, Inet4Address.class) == false) goto L157;
        r48 = a.f8405b;     // Catch: JSONException -> L296
    L159:
        r45.put("address_family", r48.ordinal());     // Catch: JSONException -> L296
        if (this.f8545d == (-1)) goto L162;
    L164:
        boolean r49 = false;
    L165:
        r45.put("socket_reused", r49);     // Catch: JSONException -> L296
        if (r47.getHostAddress() == null) goto L168;
        r45.put("remote", r47.getHostAddress());     // Catch: JSONException -> L296
        goto L168
    L162:
        if (this.q == (-1)) goto L164;
        r49 = true;
        goto L165
    L157:
        if (ZeusTransformUtils.instanceOf(r47, Inet6Address.class) == false) goto L159;
        r48 = a.f8406c;     // Catch: JSONException -> L296
    L168:
        JSONArray r50 = new JSONArray();     // Catch: JSONException -> L296
        Iterator<Pair<InetSocketAddress, Integer>> r51 = this.s.iterator();     // Catch: JSONException -> L296
    L170:
        if (r51.hasNext() == false) goto L172;
        Pair r52 = (Pair) ZeusTransformUtils.preCheckCast(r51.next(), Pair.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L296
        JSONObject r132 = new JSONObject();     // Catch: JSONException -> L296
        r132.put(SensitiveType.ADDRESS, ((InetSocketAddress) ZeusTransformUtils.preCheckCast(r52.first, InetSocketAddress.class, "com.obric.aiagent.plugin")).toString().substring(1));     // Catch: JSONException -> L296
        r132.put("result", r52.second);     // Catch: JSONException -> L296
        r50.put(r132);     // Catch: JSONException -> L296
        goto L170
    L172:
        r45.put("connection_attempts", r50);     // Catch: JSONException -> L296
        r10.put("socket", r45);     // Catch: JSONException -> L296
        JSONObject r53 = new JSONObject();     // Catch: JSONException -> L296
        r53.put("handshake_type", this.u.ordinal());     // Catch: JSONException -> L296
        r53.put("cipher_suite", this.w);     // Catch: JSONException -> L296
        r53.put("ssl_version", this.v);     // Catch: JSONException -> L296
        r10.put(r124, r53);     // Catch: JSONException -> L296
        JSONObject r54 = new JSONObject();     // Catch: JSONException -> L296
        JSONArray r55 = new JSONArray();     // Catch: JSONException -> L296
        if (this.R == true) goto L176;
        List<com.bytedance.frameworks.baselib.network.http.ok3.impl.b.d> r133 = this.S;     // Catch: JSONException -> L296
        if (r133 == null) goto L200;
        Iterator<com.bytedance.frameworks.baselib.network.http.ok3.impl.b.d> r134 = r133.iterator();     // Catch: JSONException -> L296
    L181:
        if (r134.hasNext() == false) goto L200;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.b.d r135 = (com.bytedance.frameworks.baselib.network.http.ok3.impl.b.d) ZeusTransformUtils.preCheckCast(r134.next(), com.bytedance.frameworks.baselib.network.http.ok3.impl.b.d.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L296
        JSONObject r136 = new JSONObject();     // Catch: JSONException -> L296
        if (r135.f8442d == false) goto L181;
        r136.put("priority", r135.f8441c);     // Catch: JSONException -> L296
        r136.put("type", r135.f8443e);     // Catch: JSONException -> L296
        r136.put("action_hit", r135.f8442d);     // Catch: JSONException -> L296
        if (TextUtils.isEmpty(r135.g) == true) goto L191;
        Uri r137 = Uri.parse(r135.g);     // Catch: JSONException -> L296
        if (r137.getHost() == null) goto L190;
        r136.put("replace_host", r137.getHost());     // Catch: JSONException -> L296
    L190:
        Object r138 = r131;
    L192:
        r136.put("feedback", r135.f);     // Catch: JSONException -> L296
        r131 = r138;
        if (r135.f8440b <= 0) goto L196;
        r136.put("rule_id", r135.f8440b);     // Catch: JSONException -> L296
    L196:
        if (TextUtils.isEmpty(r135.f8439a) == true) goto L198;
        r136.put("service_name", r135.f8439a);     // Catch: JSONException -> L296
    L198:
        r55.put(r136);     // Catch: JSONException -> L296
        goto L181
    L191:
        r138 = r131;
        r136.put("replace_host", r138);     // Catch: JSONException -> L296
    L200:
        r54.put("action_info", r55);     // Catch: JSONException -> L296
        r54.put("empty_action", com.bytedance.frameworks.baselib.network.http.ok3.impl.b.l.a().b());     // Catch: JSONException -> L296
        boolean r56 = false;
        r54.put("host_replace_map", 0);     // Catch: JSONException -> L296
    L201:
        r54.put(DBHelper.BATTERY_COL_SOURCE, com.bytedance.frameworks.baselib.network.http.ok3.impl.b.l.a().d());     // Catch: JSONException -> L296
        r54.put("update_time", com.bytedance.frameworks.baselib.network.http.ok3.impl.b.l.a().e());     // Catch: JSONException -> L296
        r54.put("epoch", com.bytedance.frameworks.baselib.network.http.ok3.impl.b.l.a().c());     // Catch: JSONException -> L296
        r10.put("url_dispatch", r54);     // Catch: JSONException -> L296
        if (TextUtils.isEmpty(com.bytedance.frameworks.baselib.network.http.ok3.impl.b.l.a().f()) == true) goto L205;
        r10.put("tt_tnc_etag", com.bytedance.frameworks.baselib.network.http.ok3.impl.b.l.a().f());     // Catch: JSONException -> L296
    L205:
        if (this.U == null) goto L230;
        JSONObject r57 = new JSONObject();     // Catch: JSONException -> L296
        if (this.U.f8410c == null) goto L212;
        if (this.U.f8410c.isEmpty() == true) goto L212;
        r57.put("header_add", this.U.f8410c);     // Catch: JSONException -> L296
    L212:
        if (this.U.f8411d == null) goto L217;
        if (this.U.f8411d.isEmpty() == true) goto L217;
        r57.put("header_rm", this.U.f8411d);     // Catch: JSONException -> L296
    L217:
        if (this.U.f8408a == null) goto L222;
        if (this.U.f8408a.isEmpty() == true) goto L222;
        r57.put("query_add", this.U.f8408a);     // Catch: JSONException -> L296
    L222:
        if (this.U.f8409b == null) goto L227;
        if (this.U.f8409b.isEmpty() == true) goto L227;
        r57.put("query_rm", this.U.f8409b);     // Catch: JSONException -> L296
    L227:
        if (r57.length() <= 0) goto L230;
        r10.put("meta_dp", r57);     // Catch: JSONException -> L296
    L230:
        if (TextUtils.isEmpty(this.V) == false) goto L303;
    L232:
        JSONObject r58 = new JSONObject();     // Catch: JSONException -> L296
        com.bytedance.frameworks.baselib.network.http.c r59 = this.W;     // Catch: JSONException -> L296
        if (r59 != null) goto L235;
        long r139 = 0;
    L247:
        r10.put("socket_timeout_param", r58);     // Catch: JSONException -> L296
        JSONObject r60 = new JSONObject();     // Catch: JSONException -> L296
        r60.put("ipv4_reachable", com.bytedance.common.utility.i.b(r8));     // Catch: JSONException -> L296
        r60.put("ipv6_reachable", com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.d.b().get());     // Catch: JSONException -> L296
        r10.put("ifconfig", r60);     // Catch: JSONException -> L296
        if (r.c() == null) goto L253;
        Object r61 = r.c().a();     // Catch: JSONException -> L296
        if (r61 == null) goto L253;
        r10.put("tnc", r61);     // Catch: JSONException -> L296
    L253:
        if (com.bytedance.frameworks.baselib.network.http.h.b.a().e() == null) goto L256;
        r10.put("store_idc", com.bytedance.frameworks.baselib.network.http.h.b.a().e());     // Catch: JSONException -> L296
    L256:
        if (this.y == null) goto L299;
        JSONObject r62 = new JSONObject();     // Catch: JSONException -> L296
        List<String> r63 = this.y.b(r120);     // Catch: JSONException -> L296
        if (com.bytedance.common.utility.collection.a.a(r63) == true) goto L260;
        boolean r140 = true;
    L261:
        r62.put(r120, r140);     // Catch: JSONException -> L296
        if (r140 == false) goto L270;
        Iterator<String> r64 = r63.iterator();     // Catch: JSONException -> L296
    L265:
        if (r64.hasNext() == false) goto L269;
        String r65 = (String) ZeusTransformUtils.preCheckCast(r64.next(), String.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L296
        if (r65 == null) goto L265;
        r139 = r139 + ((long) r65.length());     // Catch: JSONException -> L296
        goto L265
    L269:
        r62.put("add_cookie_bytes", r139);     // Catch: JSONException -> L296
    L270:
        String r66 = this.y.a("x-tt-token");     // Catch: JSONException -> L296
        if (r66 == null) goto L276;
        if (r66.isEmpty() == true) goto L276;
        r62.put("token_md5", e.h.c(r66).f().i());     // Catch: JSONException -> L296
    L276:
        if ("http".equalsIgnoreCase(this.C) == false) goto L294;
        if (r63 != null) goto L279;
    L287:
        Set<String> r1 = com.bytedance.frameworks.baselib.network.b.a.a(this.y);     // Catch: JSONException -> L296
        if (r1 == null) goto L294;
        JSONArray r67 = new JSONArray();     // Catch: JSONException -> L296
        Iterator<String> r68 = r1.iterator();     // Catch: JSONException -> L296
    L291:
        if (r68.hasNext() == false) goto L293;
        r67.put((String) ZeusTransformUtils.preCheckCast(r68.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: JSONException -> L296
        goto L291
    L293:
        r62.put("insecure_headers", r67);     // Catch: JSONException -> L296
        goto L294
    L279:
        if (r63.isEmpty() == true) goto L287;
        Set<String> r69 = com.bytedance.frameworks.baselib.network.b.a.a(r63);     // Catch: JSONException -> L296
        if (r69 == null) goto L287;
        JSONArray r70 = new JSONArray();     // Catch: JSONException -> L296
        Iterator<String> r71 = r69.iterator();     // Catch: JSONException -> L296
    L284:
        if (r71.hasNext() == false) goto L286;
        r70.put((String) ZeusTransformUtils.preCheckCast(r71.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: JSONException -> L296
        goto L284
    L286:
        r62.put("insecure_cookies", r70);     // Catch: JSONException -> L296
    L294:
        r10.put(SensitiveType.SESSION, r62);     // Catch: JSONException -> L296
        goto L299
    L260:
        r140 = r56;
    L299:
        return r10.toString();
    L235:
        if (r59.i <= 0) goto L238;
        r58.put("protect", this.W.i);     // Catch: JSONException -> L296
    L238:
        if (this.W.f <= 0) goto L241;
        r58.put("connect", this.W.f);     // Catch: JSONException -> L296
    L241:
        if (this.W.f8190d <= 0) goto L243;
        r58.put("read", this.W.f8190d);     // Catch: JSONException -> L296
    L243:
        r139 = 0;
        if (this.W.f8191e <= 0) goto L247;
        r58.put("write", this.W.f8191e);     // Catch: JSONException -> L296
        goto L247
    L303:
        r10.put(r21, new JSONObject(this.V));     // Catch: JSONException -> L300
        goto L232
    L176:
        r54.put("host_replace_map", 1);     // Catch: JSONException -> L296
        r54.put("host_replace_map_size", this.T);     // Catch: JSONException -> L296
        r56 = false;
        goto L201
    L147:
        if (r43.f8412e < 0) goto L149;
        r41.put("meta_dp", this.U.f8412e);     // Catch: JSONException -> L296
        goto L149
    L141:
        if (r39.A == null) goto L143;
        r38.put("hook", 1);     // Catch: JSONException -> L296
        goto L143
    L137:
        r34 = "";
        goto L138
    L78:
        r25 = false;
        goto L79
    L74:
        r126 = 0;
        goto L75
    L70:
        r125 = 0;
        goto L71
    L33:
        r115 = false;
    L296:
        e = move-exception;
        e.printStackTrace();
        goto L299
    }

    private void a(String r16, JSONObject r17, long r18) {
        HashMap r1 = new HashMap();
        q r2 = new q();
        if (TextUtils.isEmpty(r16) == true) goto L18;
        String[] r3 = r16.split(",");
        if (r3 == null) goto L18;
        int r7 = r3.length;
        int r8 = 0;
    L7:
        if (r8 >= r7) goto L18;
        String[] r9 = r3[r8].split(";");
        if (r9 == null) goto L17;
        if (r9.length != 2) goto L17;
        if (TextUtils.isEmpty(r9[0]) == true) goto L17;
        if (TextUtils.isEmpty(r9[1]) == true) goto L17;
        r1.put(r9[0], r9[1]);
    L17:
        r8 = r8 + 1;
    L18:
        Iterator r4 = r1.entrySet().iterator();
    L20:
        if (r4.hasNext() == false) goto L42;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r12 = ((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin")).trim();
        String r6 = ((String) ZeusTransformUtils.preCheckCast(r5.getValue(), String.class, "com.obric.aiagent.plugin")).trim();
        if (r12.equalsIgnoreCase("cdn-cache") == true) goto L23;
        if (r12.equalsIgnoreCase("edge") == true) goto L31;
        if (r12.equalsIgnoreCase("origin") == true) goto L34;
        if (r12.equalsIgnoreCase("inner") == true) goto L37;
        if (TextUtils.isEmpty(r12) == true) goto L20;
        r17.put(r12, b(r6));
        goto L20
    L37:
        r2.f8557e = b(r6);
        goto L20
    L34:
        r2.f8556d = b(r6);
        goto L20
    L31:
        r2.f8555c = b(r6);
        goto L20
    L23:
        r2.f8553a = true;
        String[] r10 = r6.split("=");
        if (r10.length != 2) goto L28;
        if (r10[1].equalsIgnoreCase("hit") == false) goto L28;
        r2.f8554b = true;
    L28:
        r2.f8554b = false;
        goto L20
    L42:
        if (r2.f8553a == false) goto L52;
        if (r2.f8554b == false) goto L52;
        r17.put("edge", r2.f8555c);
        r17.put("cdn-cache", "hit");
        if (r18 != (-1)) goto L48;
    L50:
        r17.put("rtt", r2.f);
        return;
    L48:
        if (r18 <= r2.f8555c) goto L50;
        r2.f = r18 - r2.f8555c;
    L52:
        if (r2.f8553a == false) goto L63;
        r17.put("edge", r2.f8555c);
        r17.put("cdn-cache", "miss");
        if (r2.f8556d <= r2.f8557e) goto L56;
        r17.put("origin", r2.f8556d - r2.f8557e);
    L57:
        r17.put("inner", r2.f8557e);
        if (r18 != (-1)) goto L60;
    L62:
        r17.put("rtt", r2.f);
        return;
    L60:
        if (r18 <= (r2.f8556d + r2.f8555c)) goto L62;
        r2.f = (r18 - r2.f8556d) - r2.f8555c;
        goto L62
    L56:
        r17.put("origin", -1);
        goto L57
    L63:
        r17.put("inner", r2.f8557e);
        if (r18 != (-1)) goto L66;
    L68:
        r17.put("rtt", r2.f);
        return;
    L66:
        if (r18 <= r2.f8557e) goto L68;
        r2.f = r18 - r2.f8557e;
        goto L68
    }

    public void a(com.bytedance.frameworks.baselib.network.http.c r1) {
        this.W = r1;
    }

    private static long b(String r7) {
        String[] r8 = r7.split("=");
        if (r8.length == 2) goto L12;
        return -1;
    L12:
        long r3 = Long.parseLong(r8[1]);     // Catch: NumberFormatException -> L11
        if (r3 >= 0) goto L10;
        return -1;
    L10:
        return r3;
    L16:
        return -1;
    }

    private static b a(aa r1) {
        if (r1 == null) goto L4;
        int r2 = AnonymousClass1.f8547a[r1.ordinal()];
        if (r2 == 1) goto L26;
        if (r2 == 2) goto L24;
        if (r2 == 3) goto L22;
        if (r2 == 4) goto L20;
        if (r2 == 5) goto L18;
        return b.f8420a;
    L18:
        return b.f8424e;
    L20:
        return b.f8422c;
    L22:
        return b.f8423d;
    L24:
        return b.f8421b;
    L26:
        return b.f;
    L4:
        return b.f8420a;
    }

    public void b() {
        this.f8542a = System.currentTimeMillis();
        this.O = s.f8566c;
    }

    public void c() {
        this.f8543b = System.currentTimeMillis();
        this.L = d.k;
    }

    public void d() {
        this.f8544c = System.currentTimeMillis();
    }

    public void a(String r3) {
        this.f8544c = System.currentTimeMillis();
        this.V = r3;
    }

    public void e() {
        this.f8545d = System.currentTimeMillis();
        this.L = d.l;
    }

    public void f() {
        this.f = System.currentTimeMillis();
        this.L = d.m;
    }

    public void g() {
        this.g = System.currentTimeMillis();
    }

    public void a(Proxy r3) {
        this.f8546e = System.currentTimeMillis();
        if (r3 == null) goto L6;
        this.t = r3.type();
        return;
    }

    public void a(InetSocketAddress r5, IOException r6, String r7) {
        this.f8546e = System.currentTimeMillis();
        if (r5 == null) goto L8;
        if (this.p.get() != (-1)) goto L8;
        this.s.add(new Pair(r5, Integer.valueOf(b(r6))));
    L8:
        if (TextUtils.isEmpty(this.V) == true) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r7) == true) goto L14;
        this.V = r7;
        return;
    }

    public void a(okhttp3.j r5) {
        okhttp3.j r6 = (okhttp3.j) ZeusTransformUtils.wrapperContextForParams(r5, okhttp3.j.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
    L14:
        this.q = System.currentTimeMillis();
        return;
    L5:
        if (this.p.get() != (-1)) goto L14;
        if (r6.b() != null) goto L9;
    L13:
        this.G = r6.b();
        goto L14
    L9:
        if (r6.b().getInetAddress() == null) goto L13;
        if (r6.b().getInetAddress().getHostAddress() == null) goto L13;
        this.F = r6.b().getInetAddress().getHostAddress();
        goto L13
    }

    public void h() {
        this.L = d.n;
        this.h = System.currentTimeMillis();
    }

    public void a(ab r5) {
        this.i = System.currentTimeMillis();
        if (r5 != null) goto L5;
    L9:
        this.L = d.o;
        return;
    L5:
        if (this.p.get() != (-1)) goto L9;
        this.y = r5.c();
        if (r5.a() == null) goto L9;
        this.C = r5.a().a();
        goto L9
    }

    public void i() {
        this.j = System.currentTimeMillis();
    }

    public void a(long r3) {
        this.k = System.currentTimeMillis();
        this.x = r3;
    }

    public void j() {
        this.l = System.currentTimeMillis();
    }

    public void a(ad r5) {
        this.m = System.currentTimeMillis();
        if (this.g == (-1)) goto L5;
        this.u = c.f8468c;
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        if (this.p.get() != (-1)) goto L37;
        this.z = r5.d();
        this.B = r5.b();
        if (r5.e() == null) goto L14;
        this.v = r5.e().a();
        this.w = r5.e().b();
    L14:
        if (r5.p() == false) goto L27;
        this.f8541J++;
        p r0 = new p();
        r0.f8549a = r5.d();
        r0.f8550b = r5.a().b();
        String r1 = r5.b("location");
        if (TextUtils.isEmpty(r1) == false) goto L34;
    L25:
        this.K.add(r0);
        goto L27
    L34:
        v r2 = r5.a().a().a(r1);     // Catch: Throwable -> L33
        if (r2 == null) goto L23;
        if (TextUtils.isEmpty(r2.b()) == true) goto L23;
        r0.f8551c = r2.toString();     // Catch: Throwable -> L33
    L23:
        if (TextUtils.isEmpty(r0.f8551c) == false) goto L25;
        r0.f8551c = r1;
    L27:
        if (r5.n() == false) goto L31;
        String r3 = r5.b("content-type");
        if (TextUtils.isEmpty(r3) == true) goto L31;
        this.I = r3;
    L31:
        this.H = r5.f();
        return;
    L37:
        return;
    L5:
        this.u = c.f8467b;
        goto L6
    }

    public void k() {
        this.L = d.p;
        this.n = System.currentTimeMillis();
    }

    public void b(long r3) {
        this.o = System.currentTimeMillis();
        this.A = r3;
    }

    public void a(IOException r6) {
        if (this.p.compareAndSet(-1, System.currentTimeMillis()) == true) goto L6;
        return;
    L6:
        if (this.Z.get() == false) goto L8;
        r6 = new IOException("Biz Canceled");
    L8:
        this.L = d.f8470a;
        if (r6 != null) goto L11;
    L15:
        this.O = s.f8568e;
    L16:
        this.N = b(r6);
        m();
        return;
    L11:
        if (TextUtils.isEmpty(r6.getMessage()) == true) goto L15;
        if (r6.getMessage().contains("Canceled") == false) goto L15;
        this.O = s.f8567d;
        goto L16
    }

    public void l() {
        if (this.p.compareAndSet(-1, System.currentTimeMillis()) == true) goto L5;
        return;
    L5:
        this.L = d.f8470a;
        this.O = s.f8565b;
        m();
    }

    public void b(ad r4) {
        boolean r1 = true;
        if (r4.i() == null) goto L5;
        boolean r0 = true;
    L6:
        this.D = r0;
        if (r4.h() != null) goto L10;
        r1 = false;
    L10:
        this.E = r1;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void a(String r3, String r4, long r5, boolean r7, List<com.bytedance.frameworks.baselib.network.http.ok3.impl.b.d> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        p r0 = new p();
        r0.f8549a = 307;
        r0.f8552d = true;
        r0.f8550b = r3;
        r0.f8551c = r4;
        this.K.add(r0);
        this.f8541J++;
        this.r = r5;
        this.Q = true;
        if (r7 == false) goto L5;
        this.R = true;
        this.T = com.bytedance.frameworks.baselib.network.http.ok3.impl.b.l.a().h().size();
        return;
    L5:
        this.S.addAll(r9);
        this.R = false;
    }

    public void a(String r2, com.bytedance.frameworks.baselib.network.http.ok3.impl.b.d r3, boolean r4) {
        if (r4 == false) goto L4;
        p r5 = new p();
        r5.f8549a = 307;
        r5.f8552d = true;
        r5.f8550b = r2;
        r5.f8551c = r3.g;
        this.K.add(r5);
        this.f8541J++;
    L4:
        this.S.add(r3);
    }

    public void a(com.bytedance.frameworks.baselib.network.http.ok3.impl.a.b r1) {
        this.U = r1;
    }

    public void a(int r1) {
        this.N = r1;
    }

    public void a(String r1, String r2) {
        this.P = r1;
        this.M = r2;
    }

    public static int b(IOException r2) {
        if (ZeusTransformUtils.instanceOf(r2, SSLHandshakeException.class) == false) goto L6;
        return -148;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, SSLKeyException.class) == false) goto L9;
        return -149;
    L9:
        if (ZeusTransformUtils.instanceOf(r2, SSLProtocolException.class) == false) goto L12;
        return -107;
    L12:
        if (ZeusTransformUtils.instanceOf(r2, SSLPeerUnverifiedException.class) == false) goto L15;
        return -153;
    L15:
        if (ZeusTransformUtils.instanceOf(r2, UnknownHostException.class) == false) goto L18;
        return -105;
    L18:
        if (ZeusTransformUtils.instanceOf(r2, ConnectException.class) == false) goto L21;
        return a(r2, -104);
    L21:
        if (ZeusTransformUtils.instanceOf(r2, PortUnreachableException.class) == false) goto L24;
        return -108;
    L24:
        if (ZeusTransformUtils.instanceOf(r2, NoRouteToHostException.class) == false) goto L27;
        return -109;
    L27:
        if (ZeusTransformUtils.instanceOf(r2, BindException.class) == false) goto L30;
        return -147;
    L30:
        if (ZeusTransformUtils.instanceOf(r2, SocketException.class) == false) goto L33;
        return a(r2, -15);
    L33:
        if (ZeusTransformUtils.instanceOf(r2, MalformedURLException.class) == false) goto L36;
        return -300;
    L36:
        if (ZeusTransformUtils.instanceOf(r2, SocketTimeoutException.class) == false) goto L39;
        return -118;
    L39:
        if (ZeusTransformUtils.instanceOf(r2, ProtocolException.class) == false) goto L42;
        return -901;
    L42:
        if (ZeusTransformUtils.instanceOf(r2, HttpRetryException.class) == false) goto L50;
        String r3 = r2.getMessage();
        if (TextUtils.isEmpty(r3) == true) goto L68;
        if (r3.contains("Too many follow-up requests") == false) goto L68;
        return -310;
    L68:
        return -196;
    L50:
        if (ZeusTransformUtils.instanceOf(r2, UnknownServiceException.class) == false) goto L52;
        return -902;
    L52:
        return -1;
    }

    private static int a(IOException r2, int r3) {
        if (r2 != null) goto L21;
        return r3;
    L21:
        int r0 = a(r2.getMessage(), r3);     // Catch: Throwable -> L18
        if (r0 == r3) goto L19;
        return r0;
    L19:
        Throwable r4 = r2.getCause();     // Catch: Throwable -> L15
        if (r4 != null) goto L10;
        return r0;
    L10:
        String r5 = r4.getMessage();     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r5) == false) goto L13;
        return r0;
    L13:
        return a(r5, r3);
    L15:
        r3 = r0;
    L17:
        return r3;
    }

    private static int a(String r1, int r2) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return r2;
    L6:
        if (r1.contains("ECONNRESET") == false) goto L8;
    L39:
        return -101;
    L8:
        if (r1.contains("Connection reset") == true) goto L39;
        if (r1.contains("reset by peer") == true) goto L39;
        if (r1.contains("ECONNREFUSED") == false) goto L16;
        return -102;
    L16:
        if (r1.contains("CONNECTION_ABORTED") == false) goto L18;
    L38:
        return -103;
    L18:
        if (r1.contains("connection abort") == true) goto L38;
        if (r1.contains("ENETDOWN") == false) goto L23;
    L37:
        return -106;
    L23:
        if (r1.contains("Network is unreachable") == true) goto L37;
        if (r1.contains("EHOSTUNREACH") == false) goto L28;
    L36:
        return -109;
    L28:
        if (r1.contains("ENETUNREACH") == true) goto L36;
        if (r1.contains("EADDRNOTAVAIL") == false) goto L34;
        return -108;
    L34:
        if (r1.contains("EADDRINUSE") == false) goto L43;
        return -147;
    L43:
        return r2;
    }
}
