package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.constant.TrafficConsts;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.DnsResult;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.common.net.HttpHeaders;
import com.obric.capabilitykit.common.Ext;
import com.ttnet.org.chromium.net.NetError;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public long A;
    public Protocol B;
    public boolean C;
    public boolean D;
    public String E;
    public Socket F;
    public Headers G;
    public String H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final List f7322J;
    public LoadState K;
    public String L;
    public int M;
    public Status N;
    public String O;
    public boolean P;
    public boolean Q;
    public final List R;
    public int S;
    public DnsResult.Source T;
    public CopyOnWriteArrayList U;
    public String V;
    public o4.a W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f7323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f7324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f7325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f7326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f7327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f7328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f7329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f7330h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f7331i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f7332j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f7333k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f7334l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f7335m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f7336n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f7337o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicLong f7338p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f7339q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f7340r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List f7341s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Proxy.Type f7342t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public HandshakeType f7343u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TlsVersion f7344v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public okhttp3.d f7345w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f7346x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Headers f7347y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f7348z;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7349a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f7350b = null;

        static {
            int[] r10 = new int[Protocol.values().length];
            f7350b = r10;
            r10[Protocol.HTTP_1_0.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L37:
            f7350b[Protocol.HTTP_1_1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L43:
            f7350b[Protocol.HTTP_2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L55:
            f7350b[Protocol.SPDY_3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L39:
            f7350b[Protocol.QUIC.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L12:
            int[] r11 = new int[DnsResult.Source.values().length];
            f7349a = r11;
            r11[DnsResult.Source.HTTPDNS_CACHE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L45:
            f7349a[DnsResult.Source.LOCALDNS_CACHE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L53:
            f7349a[DnsResult.Source.HTTPDNS_REQUEST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L35:
            f7349a[DnsResult.Source.LOCALDNS_REQUEST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L47:
            f7349a[DnsResult.Source.HTTPDNS_STALE_CACHE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L30
        L49:
            f7349a[DnsResult.Source.HARDCODE_IPS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L31
        L33:
            f7349a[DnsResult.Source.UNKNOWN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L32
            return;
        }
    }

    public e() {
        this.f7323a = -1;
        this.f7324b = -1;
        this.f7325c = -1;
        this.f7326d = -1;
        this.f7327e = -1;
        this.f7328f = -1;
        this.f7329g = -1;
        this.f7330h = -1;
        this.f7331i = -1;
        this.f7332j = -1;
        this.f7333k = -1;
        this.f7334l = -1;
        this.f7335m = -1;
        this.f7336n = -1;
        this.f7337o = -1;
        this.f7338p = new AtomicLong(-1);
        this.f7339q = -1;
        this.f7340r = -1;
        this.f7341s = new ArrayList();
        this.f7342t = Proxy.Type.DIRECT;
        this.f7343u = HandshakeType.HANDSHAKE_UNKNOWN;
        this.f7346x = 0;
        this.f7348z = -1;
        this.A = 0;
        this.B = null;
        this.C = false;
        this.D = false;
        this.E = "";
        this.H = "";
        this.I = 0;
        this.f7322J = new ArrayList();
        this.K = LoadState.IDLE;
        this.L = "";
        this.M = -1;
        this.N = Status.UNKNOWN;
        this.O = "";
        this.P = false;
        this.Q = false;
        this.R = new ArrayList();
        this.S = 0;
        this.T = DnsResult.Source.UNKNOWN;
        this.U = new CopyOnWriteArrayList();
        this.V = "";
    }

    public static ConnectionInfo F(Protocol r10) {
        if (r10 == null) goto L4;
        int r11 = a.f7350b[r10.ordinal()];
        if (r11 == 1) goto L26;
        if (r11 == 2) goto L24;
        if (r11 == 3) goto L22;
        if (r11 == 4) goto L20;
        if (r11 == 5) goto L18;
        return ConnectionInfo.CONNECTION_INFO_UNKNOWN;
    L18:
        return ConnectionInfo.CONNECTION_INFO_QUIC_UNKNOWN_VERSION;
    L20:
        return ConnectionInfo.CONNECTION_INFO_DEPRECATED_SPDY3;
    L22:
        return ConnectionInfo.CONNECTION_INFO_HTTP2;
    L24:
        return ConnectionInfo.CONNECTION_INFO_HTTP1_1;
    L26:
        return ConnectionInfo.CONNECTION_INFO_HTTP1_0;
    L4:
        return ConnectionInfo.CONNECTION_INFO_UNKNOWN;
    }

    public static long G(String r10) {
        String[] r11 = r10.split("=");
        if (r11.length == 2) goto L12;
        return -1;
    L12:
        long r12 = Long.parseLong(r11[1]);     // Catch: NumberFormatException -> L11
        if (r12 >= 0) goto L10;
        return -1;
    L10:
        return r12;
    L16:
        return -1;
    }

    public static long H(long r10, long r11) {
        if (r11 != (-1)) goto L5;
    L8:
        return -1;
    L5:
        if (r10 == (-1)) goto L8;
        return r10 - r11;
    }

    public static int i(IOException r10, int r11) {
        if (r10 != null) goto L21;
        return r11;
    L21:
        int r12 = j(r10.getMessage(), r11);     // Catch: Throwable -> L18
        if (r12 == r11) goto L19;
        return r12;
    L19:
        Throwable r13 = r10.getCause();     // Catch: Throwable -> L15
        if (r13 != null) goto L10;
        return r12;
    L10:
        String r14 = r13.getMessage();     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r14) == false) goto L13;
        return r12;
    L13:
        return j(r14, r11);
    L15:
        r11 = r12;
    L17:
        return r11;
    }

    public static int j(String r10, int r11) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return r11;
    L6:
        if (r10.contains("ECONNRESET") == false) goto L8;
    L39:
        return NetError.ERR_CONNECTION_RESET;
    L8:
        if (r10.contains("Connection reset") == true) goto L39;
        if (r10.contains("reset by peer") == true) goto L39;
        if (r10.contains("ECONNREFUSED") == false) goto L16;
        return NetError.ERR_CONNECTION_REFUSED;
    L16:
        if (r10.contains("CONNECTION_ABORTED") == false) goto L18;
    L38:
        return NetError.ERR_CONNECTION_ABORTED;
    L18:
        if (r10.contains("connection abort") == true) goto L38;
        if (r10.contains("ENETDOWN") == false) goto L23;
    L37:
        return NetError.ERR_INTERNET_DISCONNECTED;
    L23:
        if (r10.contains("Network is unreachable") == true) goto L37;
        if (r10.contains("EHOSTUNREACH") == false) goto L28;
    L36:
        return NetError.ERR_ADDRESS_UNREACHABLE;
    L28:
        if (r10.contains("ENETUNREACH") == true) goto L36;
        if (r10.contains("EADDRNOTAVAIL") == false) goto L34;
        return NetError.ERR_ADDRESS_INVALID;
    L34:
        if (r10.contains("EADDRINUSE") == false) goto L43;
        return NetError.ERR_ADDRESS_IN_USE;
    L43:
        return r11;
    }

    public static int k(IOException r10) {
        if ((r10 instanceof SSLHandshakeException) == false) goto L6;
        return NetError.ERR_SSL_HANDSHAKE_NOT_COMPLETED;
    L6:
        if ((r10 instanceof SSLKeyException) == false) goto L9;
        return NetError.ERR_SSL_BAD_PEER_PUBLIC_KEY;
    L9:
        if ((r10 instanceof SSLProtocolException) == false) goto L12;
        return NetError.ERR_SSL_PROTOCOL_ERROR;
    L12:
        if ((r10 instanceof SSLPeerUnverifiedException) == false) goto L15;
        return NetError.ERR_SSL_DECRYPT_ERROR_ALERT;
    L15:
        if ((r10 instanceof UnknownHostException) == false) goto L18;
        return NetError.ERR_NAME_NOT_RESOLVED;
    L18:
        if ((r10 instanceof ConnectException) == false) goto L21;
        return i(r10, NetError.ERR_CONNECTION_FAILED);
    L21:
        if ((r10 instanceof PortUnreachableException) == false) goto L24;
        return NetError.ERR_ADDRESS_INVALID;
    L24:
        if ((r10 instanceof NoRouteToHostException) == false) goto L27;
        return NetError.ERR_ADDRESS_UNREACHABLE;
    L27:
        if ((r10 instanceof BindException) == false) goto L30;
        return NetError.ERR_ADDRESS_IN_USE;
    L30:
        if ((r10 instanceof SocketException) == false) goto L33;
        return i(r10, -15);
    L33:
        if ((r10 instanceof MalformedURLException) == false) goto L36;
        return NetError.ERR_INVALID_URL;
    L36:
        if ((r10 instanceof SocketTimeoutException) == false) goto L39;
        return NetError.ERR_CONNECTION_TIMED_OUT;
    L39:
        if ((r10 instanceof ProtocolException) == false) goto L42;
        return -901;
    L42:
        if ((r10 instanceof HttpRetryException) == false) goto L50;
        String r11 = r10.getMessage();
        if (TextUtils.isEmpty(r11) == true) goto L68;
        if (r11.contains("Too many follow-up requests") == false) goto L68;
        return NetError.ERR_TOO_MANY_REDIRECTS;
    L68:
        return NetError.ERR_TTNET_UNSUPPORTED_REDIRECT;
    L50:
        if ((r10 instanceof UnknownServiceException) == false) goto L52;
        return -902;
    L52:
        return -1;
    }

    public void A(int r10) {
        this.M = r10;
    }

    public void B(String r10, String r11) {
        this.O = r10;
        this.L = r11;
    }

    public void C(BaseHttpRequestInfo r10, Context r11) {
        r10.f7162a = this.E;
        r10.f7171j = H(this.f7325c, this.f7324b);
        r10.f7172k = H(this.f7328f, this.f7326d);
        r10.f7173l = H(this.f7329g, this.f7328f);
        r10.f7174m = H(this.f7331i, this.f7330h) + H(this.f7333k, this.f7332j);
        r10.f7175n = -1;
        r10.f7176o = H(this.f7335m, this.f7331i);
        if (this.f7326d == (-1)) goto L5;
    L7:
        boolean r12 = false;
    L8:
        r10.f7177p = r12;
        r10.f7178q = -1;
        r10.f7179r = H(this.f7338p.get(), this.f7323a);
        r10.f7180s = this.f7346x;
        r10.f7181t = this.A;
        r10.f7186y = h(r11);
        r10.f7182u = -1;
        Headers r13 = this.f7347y;
        if (r13 == null) goto L11;
        r10.B = r13.toString();
        r10.f7180s += this.f7347y.a();
    L11:
        Headers r14 = this.G;
        if (r14 == null) goto L14;
        r10.C = r14.toString();
        r10.f7181t += this.G.a();
    L14:
        r10.K = this.H;
        r10.E = -1;
        r10.D = -1;
        r10.F = -1;
        return;
    L5:
        if (this.f7339q == (-1)) goto L7;
        r12 = true;
        goto L8
    }

    public void D(o4.a r10) {
        this.W = r10;
    }

    public void E(Response r10) {
        boolean r11 = false;
        if (r10.c() == null) goto L5;
        boolean r12 = true;
    L6:
        this.C = r12;
        if (r10.m() == null) goto L9;
        r11 = true;
    L9:
        this.D = r11;
        return;
    L5:
        r12 = false;
        goto L6
    }

    public void a() {
        this.f7338p.set(System.currentTimeMillis());
        this.K = LoadState.IDLE;
        this.N = Status.SUCCESS;
    }

    public void b(IOException r10) {
        this.f7338p.set(System.currentTimeMillis());
        this.K = LoadState.IDLE;
        if (r10 != null) goto L5;
    L9:
        this.N = Status.FAILED;
    L10:
        this.M = k(r10);
        return;
    L5:
        if (TextUtils.isEmpty(r10.getMessage()) == true) goto L9;
        if (r10.getMessage().contains("Canceled") == false) goto L9;
        this.N = Status.CANCELED;
        goto L10
    }

    public void c() {
        this.f7323a = System.currentTimeMillis();
        this.N = Status.IO_PENDING;
    }

    public void d(Proxy r10) {
        this.f7327e = System.currentTimeMillis();
        if (r10 == null) goto L6;
        this.f7342t = r10.type();
        return;
    }

    public void e(InetSocketAddress r10, IOException r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.f7338p.get() != (-1)) goto L8;
        this.f7341s.add(new Pair(r10, Integer.valueOf(k(r11))));
        return;
    }

    public void f() {
        this.f7326d = System.currentTimeMillis();
        this.K = LoadState.CONNECTING;
    }

    public void g(Connection r10) {
        if (r10 != null) goto L4;
    L13:
        this.f7339q = System.currentTimeMillis();
        return;
    L4:
        if (this.f7338p.get() != (-1)) goto L13;
        if (r10.socket() != null) goto L8;
    L12:
        this.F = r10.socket();
        goto L13
    L8:
        if (r10.socket().getInetAddress() == null) goto L12;
        if (r10.socket().getInetAddress().getHostAddress() == null) goto L12;
        this.E = r10.socket().getInetAddress().getHostAddress();
        goto L12
    }

    public final String h(Context r19) {
        JSONObject r10 = new JSONObject();
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L10
        String r12 = com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g.l().g();     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(r12) == true) goto L14;
        String[] r13 = r12.split(",");     // Catch: JSONException -> L10
        JSONArray r14 = new JSONArray();     // Catch: JSONException -> L10
        int r15 = r13.length;     // Catch: JSONException -> L10
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L13;
        String r17 = r13[r16];     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(r17) == true) goto L12;
        r14.put(r17);     // Catch: JSONException -> L10
    L12:
        r16 = r16 + 1;     // Catch: JSONException -> L10
        goto L6
    L13:
        r11.put("hit", r14);     // Catch: JSONException -> L10
    L14:
        r10.put("ab_test", r11);     // Catch: JSONException -> L10
        JSONObject r18 = new JSONObject();     // Catch: JSONException -> L10
        r18.put("load_state", this.K.ordinal());     // Catch: JSONException -> L10
        r18.put("method", this.L);     // Catch: JSONException -> L10
        if (this.N != Status.IO_PENDING) goto L17;
        boolean r110 = true;
    L18:
        r18.put("is_pending", r110);     // Catch: JSONException -> L10
        r18.put("status", this.N);     // Catch: JSONException -> L10
        if (this.N == Status.SUCCESS) goto L23;
        r18.put("net_error", this.M);     // Catch: JSONException -> L10
    L23:
        if (TextUtils.isEmpty(this.O) == true) goto L33;
        Uri r20 = Uri.parse(this.O);     // Catch: JSONException -> L10
        if (r20 == null) goto L33;
        if (TextUtils.isEmpty(r20.getScheme()) == true) goto L33;
        if (TextUtils.isEmpty(r20.getHost()) == true) goto L33;
        if (r20.getPath() == null) goto L33;
        r18.put("origin_url", r20.getScheme() + "://" + r20.getHost() + r20.getPath());     // Catch: JSONException -> L10
    L33:
        r18.put("redirect_times", this.I);     // Catch: JSONException -> L10
        JSONArray r21 = new JSONArray();     // Catch: JSONException -> L10
        JSONArray r111 = new JSONArray();     // Catch: JSONException -> L10
        Iterator r112 = this.f7322J.iterator();     // Catch: JSONException -> L10
    L36:
        if (r112.hasNext() == false) goto L50;
        g r113 = (g) r112.next();     // Catch: JSONException -> L10
        JSONObject r114 = new JSONObject();     // Catch: JSONException -> L10
        Iterator r115 = r112;
        r114.put(ServerElements.CODE, r113.f7351a);     // Catch: JSONException -> L10
        r114.put("method", r113.f7352b);     // Catch: JSONException -> L10
        r114.put("internal", r113.f7354d);     // Catch: JSONException -> L10
        String r116 = r113.f7353c;     // Catch: JSONException -> L10
        if (r116 == null) goto L49;
        Uri r117 = Uri.parse(r116);     // Catch: JSONException -> L10
        if (r117 == null) goto L49;
        if (TextUtils.isEmpty(r117.getScheme()) == true) goto L49;
        if (TextUtils.isEmpty(r117.getHost()) == true) goto L49;
        String r118 = r117.getScheme() + "://" + r117.getHost();     // Catch: JSONException -> L10
        r111.put(r118);     // Catch: JSONException -> L10
        if (r117.getPath() == null) goto L48;
        r118 = r118 + r117.getPath();     // Catch: JSONException -> L10
    L48:
        r114.put("url", r118);     // Catch: JSONException -> L10
    L49:
        r21.put(r114);     // Catch: JSONException -> L10
        r112 = r115;
        goto L36
    L50:
        r18.put("redirect_info", r21);     // Catch: JSONException -> L10
        r18.put("redirecting_list", r111);     // Catch: JSONException -> L10
        r18.put("dispatched", this.P);     // Catch: JSONException -> L10
        r10.put(TraceStatsConsts.STATS_BASE_MODULE, r18);     // Catch: JSONException -> L10
        JSONObject r22 = new JSONObject();     // Catch: JSONException -> L10
        r22.put(ServerElements.CODE, this.f7348z);     // Catch: JSONException -> L10
        r22.put("connection_info", F(this.B).mValue);     // Catch: JSONException -> L10
        Headers r23 = this.f7347y;     // Catch: JSONException -> L10
        if (r23 == null) goto L53;
        long r119 = r23.a();     // Catch: JSONException -> L10
    L54:
        r22.put("sent_bytes", this.f7346x + r119);     // Catch: JSONException -> L10
        Headers r24 = this.G;     // Catch: JSONException -> L10
        if (r24 == null) goto L57;
        long r120 = r24.a();     // Catch: JSONException -> L10
    L58:
        r22.put("received_bytes", this.A + r120);     // Catch: JSONException -> L10
        r22.put("cached", this.C);     // Catch: JSONException -> L10
        r22.put("network_accessed", this.D);     // Catch: JSONException -> L10
        if (this.f7342t == Proxy.Type.DIRECT) goto L61;
        boolean r121 = true;
    L62:
        r22.put("via_proxy", r121);     // Catch: JSONException -> L10
        r10.put("response", r22);     // Catch: JSONException -> L10
        JSONObject r25 = new JSONObject();     // Catch: JSONException -> L10
        if (this.G == null) goto L86;
        int r26 = 0;
    L67:
        if (r26 >= this.G.h()) goto L79;
        String r122 = this.G.d(r26);     // Catch: JSONException -> L10
        String r123 = this.G.j(r26);     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(r122) == true) goto L78;
        String r124 = r122.toLowerCase();     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(r124) == true) goto L78;
        if (r124.startsWith("x-tt-") == false) goto L78;
        if (TextUtils.isEmpty(r123) == true) goto L78;
        r25.put(r122, r123);     // Catch: JSONException -> L10
    L78:
        r26 = r26 + 1;     // Catch: JSONException -> L10
        goto L67
    L79:
        String r27 = this.G.b("tt-idc-switch");     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(r27) == true) goto L82;
        r25.put("tt-idc-switch", r27);     // Catch: JSONException -> L10
    L82:
        String r28 = this.G.b("server-timing");     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(r28) == true) goto L85;
        r25.put("server-timing", r28);     // Catch: JSONException -> L10
    L85:
        r10.put("header", r25);     // Catch: JSONException -> L10
    L87:
        JSONObject r29 = new JSONObject();     // Catch: JSONException -> L10
        r29.put("libcore", TrafficConsts.NET_CONSUME_TYPE_OK);     // Catch: JSONException -> L10
        r29.put("core_ver", "tt-ok/3.10.0.2");     // Catch: JSONException -> L10
        r29.put("is_main_process", com.bytedance.frameworks.baselib.network.http.util.f.e(r19));     // Catch: JSONException -> L10
        r29.put("ttnet_version", "4.1.79.42-pico");     // Catch: JSONException -> L10
        r29.put(ICronetClient.KEY_RETRY_ATTEMPTS, -1);     // Catch: JSONException -> L10
        r10.put(AppInfo.SEARCH_SOURCE_EXTENAL, r29);     // Catch: JSONException -> L10
        JSONObject r30 = new JSONObject();     // Catch: JSONException -> L10
        JSONObject r31 = new JSONObject();     // Catch: JSONException -> L10
        r31.put("dns", H(this.f7325c, this.f7324b));     // Catch: JSONException -> L10
        r31.put("tcp", H(this.f7328f, this.f7326d));     // Catch: JSONException -> L10
        r31.put("ssl", H(this.f7329g, this.f7328f));     // Catch: JSONException -> L10
        r31.put(CommonKey.KEY_SEND, H(this.f7331i, this.f7330h) + H(this.f7333k, this.f7332j));     // Catch: JSONException -> L10
        long r32 = H(this.f7335m, this.f7331i);     // Catch: JSONException -> L10
        r31.put(ICronetClient.KEY_TTFB, r32);     // Catch: JSONException -> L10
        r31.put("header_recv", H(this.f7335m, this.f7334l));     // Catch: JSONException -> L10
        r31.put("body_recv", H(this.f7337o, this.f7336n));     // Catch: JSONException -> L10
        r31.put("dispatch", this.f7340r);     // Catch: JSONException -> L10
        n(r28, r31, r32);     // Catch: JSONException -> L10
        r30.put("detailed_duration", r31);     // Catch: JSONException -> L10
        JSONObject r33 = new JSONObject();     // Catch: JSONException -> L10
        r33.put("start_time", this.f7323a);     // Catch: JSONException -> L10
        r33.put("duration", H(this.f7338p.get(), this.f7323a));     // Catch: JSONException -> L10
        r33.put("request_sent_time", this.f7330h);     // Catch: JSONException -> L10
        r33.put("response_recv_time", this.f7334l);     // Catch: JSONException -> L10
        r30.put(Ext.KEY_REQUEST, r33);     // Catch: JSONException -> L10
        r10.put("timing", r30);     // Catch: JSONException -> L10
        JSONObject r34 = new JSONObject();     // Catch: JSONException -> L10
        Socket r35 = this.F;     // Catch: JSONException -> L10
        if (r35 == null) goto L106;
        InetAddress r36 = r35.getInetAddress();     // Catch: JSONException -> L10
        if (r36 == null) goto L106;
        AddressFamily r37 = AddressFamily.ADDRESS_FAMILY_UNSPECIFIED;     // Catch: JSONException -> L10
        if ((r36 instanceof Inet4Address) == false) goto L95;
        r37 = AddressFamily.ADDRESS_FAMILY_IPV4;     // Catch: JSONException -> L10
    L97:
        r34.put("address_family", r37.ordinal());     // Catch: JSONException -> L10
        if (this.f7326d == (-1)) goto L100;
    L102:
        boolean r38 = false;
    L103:
        r34.put(ICronetClient.KEY_SOCKET_REUSED, r38);     // Catch: JSONException -> L10
        if (r36.getHostAddress() == null) goto L106;
        r34.put("remote", r36.getHostAddress());     // Catch: JSONException -> L10
        goto L106
    L100:
        if (this.f7339q == (-1)) goto L102;
        r38 = true;
        goto L103
    L95:
        if ((r36 instanceof Inet6Address) == false) goto L97;
        r37 = AddressFamily.ADDRESS_FAMILY_IPV6;     // Catch: JSONException -> L10
    L106:
        JSONArray r39 = new JSONArray();     // Catch: JSONException -> L10
        Iterator r40 = this.f7341s.iterator();     // Catch: JSONException -> L10
    L108:
        if (r40.hasNext() == false) goto L110;
        Pair r41 = (Pair) r40.next();     // Catch: JSONException -> L10
        JSONObject r42 = new JSONObject();     // Catch: JSONException -> L10
        r42.put("address", ((InetSocketAddress) r41.first).toString().substring(1));     // Catch: JSONException -> L10
        r42.put("result", r41.second);     // Catch: JSONException -> L10
        r39.put(r42);     // Catch: JSONException -> L10
        goto L108
    L110:
        r34.put("connection_attempts", r39);     // Catch: JSONException -> L10
        r10.put("socket", r34);     // Catch: JSONException -> L10
        JSONObject r43 = new JSONObject();     // Catch: JSONException -> L10
        r43.put("handshake_type", this.f7343u.ordinal());     // Catch: JSONException -> L10
        r43.put("cipher_suite", this.f7345w);     // Catch: JSONException -> L10
        r43.put("ssl_version", this.f7344v);     // Catch: JSONException -> L10
        r10.put("ssl", r43);     // Catch: JSONException -> L10
        JSONObject r44 = new JSONObject();     // Catch: JSONException -> L10
        JSONArray r45 = new JSONArray();     // Catch: JSONException -> L10
        if (this.Q == false) goto L115;
        boolean r46 = true;
        r44.put("host_replace_map", 1);     // Catch: JSONException -> L10
        r44.put("host_replace_map_size", this.S);     // Catch: JSONException -> L10
        boolean r47 = false;
    L137:
        r44.put("source", com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g.l().i());     // Catch: JSONException -> L10
        r44.put(ServerElements.UPDATE_TIME, com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g.l().j());     // Catch: JSONException -> L10
        r44.put("epoch", com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g.l().e());     // Catch: JSONException -> L10
        r10.put("url_dispatch", r44);     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g.l().h()) == true) goto L140;
        r10.put("tt_tnc_etag", com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g.l().h());     // Catch: JSONException -> L10
    L140:
        JSONObject r48 = new JSONObject();     // Catch: JSONException -> L10
        JSONArray r49 = new JSONArray();     // Catch: JSONException -> L10
        Iterator r50 = this.U.iterator();     // Catch: JSONException -> L10
    L142:
        if (r50.hasNext() == false) goto L144;
        r49.put((String) r50.next());     // Catch: JSONException -> L10
        goto L142
    L144:
        r48.put("address_list", r49);     // Catch: JSONException -> L10
        r48.put("httpdns_prefer", com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.b.q().s());     // Catch: JSONException -> L10
        TTNetDnsSource r51 = TTNetDnsSource.NOT_SET;     // Catch: JSONException -> L10
        TTNetDnsCacheSource r52 = TTNetDnsCacheSource.UNKNOWN;     // Catch: JSONException -> L10
        switch(a.f7349a[this.T.ordinal()]) {
            case 1: goto L152;
            case 2: goto L151;
            case 3: goto L150;
            case 4: goto L149;
            case 5: goto L148;
            case 6: goto L147;
            default: goto L146;
        };     // Catch: JSONException -> L10
    L146:
        boolean r125 = r47;
    L153:
        r48.put("source", r51.mValue);     // Catch: JSONException -> L10
        r48.put("cache_source", r52.mValue);     // Catch: JSONException -> L10
        r48.put("from_stale_cache", r125);     // Catch: JSONException -> L10
        r10.put("dns", r48);     // Catch: JSONException -> L10
        c.b().c(this.V, this);     // Catch: JSONException -> L10
        JSONObject r53 = new JSONObject();     // Catch: JSONException -> L10
        o4.a r54 = this.W;     // Catch: JSONException -> L10
        if (r54 == null) goto L167;
        long r55 = r54.f22486i;     // Catch: JSONException -> L10
        if (r55 <= 0) goto L158;
        r53.put("protect", r55);     // Catch: JSONException -> L10
    L158:
        long r56 = this.W.f22483f;     // Catch: JSONException -> L10
        if (r56 <= 0) goto L161;
        r53.put("connect", r56);     // Catch: JSONException -> L10
    L161:
        long r57 = this.W.f22481d;     // Catch: JSONException -> L10
        if (r57 <= 0) goto L164;
        r53.put("read", r57);     // Catch: JSONException -> L10
    L164:
        long r58 = this.W.f22482e;     // Catch: JSONException -> L10
        if (r58 <= 0) goto L167;
        r53.put("write", r58);     // Catch: JSONException -> L10
    L167:
        r10.put("socket_timeout_param", r53);     // Catch: JSONException -> L10
        JSONObject r59 = new JSONObject();     // Catch: JSONException -> L10
        r59.put("ipv4_reachable", NetworkUtils.l(r19));     // Catch: JSONException -> L10
        r59.put("ipv6_reachable", t4.d.b().get());     // Catch: JSONException -> L10
        r10.put("ifconfig", r59);     // Catch: JSONException -> L10
        if (i.D() == null) goto L173;
        Object r60 = i.D().getTNCInfo();     // Catch: JSONException -> L10
        if (r60 == null) goto L173;
        r10.put("tnc", r60);     // Catch: JSONException -> L10
    L173:
        if (StoreRegionManager.m().h() == null) goto L178;
        r10.put("store_idc", StoreRegionManager.m().h());     // Catch: JSONException -> L10
    L178:
        return r10.toString();
    L147:
        r51 = TTNetDnsSource.SERVE_FROM_HARDCODE_HOSTS;     // Catch: JSONException -> L10
        goto L146
    L148:
        r51 = TTNetDnsSource.SERVE_FROM_CACHE;     // Catch: JSONException -> L10
        r52 = TTNetDnsCacheSource.SOURCE_HTTPDNS;     // Catch: JSONException -> L10
        r125 = r46;
        goto L153
    L149:
        r51 = TTNetDnsSource.SERVE_FROM_PROC_DNS_JOB;     // Catch: JSONException -> L10
        goto L146
    L150:
        r51 = TTNetDnsSource.SERVE_FROM_HTTP_DNS_JOB;     // Catch: JSONException -> L10
        goto L146
    L151:
        r51 = TTNetDnsSource.SERVE_FROM_CACHE;     // Catch: JSONException -> L10
        r52 = TTNetDnsCacheSource.SOURCE_PROC;     // Catch: JSONException -> L10
        goto L146
    L152:
        r51 = TTNetDnsSource.SERVE_FROM_CACHE;     // Catch: JSONException -> L10
        r52 = TTNetDnsCacheSource.SOURCE_HTTPDNS;     // Catch: JSONException -> L10
        goto L146
    L115:
        r46 = true;
        List r61 = this.R;     // Catch: JSONException -> L10
        if (r61 == null) goto L136;
        Iterator r62 = r61.iterator();     // Catch: JSONException -> L10
    L119:
        if (r62.hasNext() == false) goto L136;
        u4.a r63 = (u4.a) r62.next();     // Catch: JSONException -> L10
        JSONObject r126 = new JSONObject();     // Catch: JSONException -> L10
        if (r63.f24854d == false) goto L119;
        r126.put("priority", r63.f24853c);     // Catch: JSONException -> L10
        r126.put("type", r63.f24855e);     // Catch: JSONException -> L10
        r126.put("action_hit", r63.f24854d);     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(r63.f24857g) == true) goto L128;
        Uri r127 = Uri.parse(r63.f24857g);     // Catch: JSONException -> L10
        if (r127.getHost() == null) goto L129;
        r126.put("replace_host", r127.getHost());     // Catch: JSONException -> L10
    L129:
        r126.put("feedback", r63.f24856f);     // Catch: JSONException -> L10
        long r128 = r63.f24852b;     // Catch: JSONException -> L10
        if (r128 <= 0) goto L133;
        r126.put("rule_id", r128);     // Catch: JSONException -> L10
    L133:
        if (TextUtils.isEmpty(r63.f24851a) == true) goto L135;
        r126.put("service_name", r63.f24851a);     // Catch: JSONException -> L10
    L135:
        r45.put(r126);     // Catch: JSONException -> L10
        goto L119
    L128:
        r126.put("replace_host", "");     // Catch: JSONException -> L10
    L136:
        r44.put("action_info", r45);     // Catch: JSONException -> L10
        r44.put("empty_action", com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g.l().m());     // Catch: JSONException -> L10
        r47 = false;
        r44.put("host_replace_map", 0);     // Catch: JSONException -> L10
        goto L137
    L86:
        r28 = "";
        goto L87
    L61:
        r121 = false;
        goto L62
    L57:
        r120 = 0;
        goto L58
    L53:
        r119 = 0;
        goto L54
    L17:
        r110 = false;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L178
    }

    public void l() {
        this.f7325c = System.currentTimeMillis();
    }

    public void m() {
        this.f7324b = System.currentTimeMillis();
        this.K = LoadState.RESOLVING_HOST;
    }

    public final void n(String r12, JSONObject r13, long r14) {
        HashMap r11 = new HashMap();
        h r10 = new h();
        if (TextUtils.isEmpty(r12) == true) goto L18;
        String[] r15 = r12.split(",");
        if (r15 == null) goto L18;
        int r16 = r15.length;
        int r17 = 0;
    L7:
        if (r17 >= r16) goto L18;
        String[] r18 = r15[r17].split(";");
        if (r18 == null) goto L17;
        if (r18.length != 2) goto L17;
        if (TextUtils.isEmpty(r18[0]) == true) goto L17;
        if (TextUtils.isEmpty(r18[1]) == true) goto L17;
        r11.put(r18[0], r18[1]);
    L17:
        r17 = r17 + 1;
    L18:
        Iterator r19 = r11.entrySet().iterator();
    L20:
        if (r19.hasNext() == false) goto L41;
        Map.Entry r110 = (Map.Entry) r19.next();
        String r20 = ((String) r110.getKey()).trim();
        String r111 = ((String) r110.getValue()).trim();
        if (r20.equalsIgnoreCase("cdn-cache") == true) goto L23;
        if (r20.equalsIgnoreCase("edge") == true) goto L31;
        if (r20.equalsIgnoreCase(HttpHeaders.ReferrerPolicyValues.ORIGIN) == true) goto L34;
        if (r20.equalsIgnoreCase("inner") == true) goto L37;
        if (TextUtils.isEmpty(r20) == true) goto L20;
        r13.put(r20, G(r111));
        goto L20
    L37:
        r10.f7359e = G(r111);
        goto L20
    L34:
        r10.f7358d = G(r111);
        goto L20
    L31:
        r10.f7357c = G(r111);
        goto L20
    L23:
        r10.f7355a = true;
        String[] r112 = r111.split("=");
        if (r112.length != 2) goto L28;
        if (r112[1].equalsIgnoreCase("hit") == false) goto L28;
        r10.f7356b = true;
    L28:
        r10.f7356b = false;
        goto L20
    L41:
        boolean r113 = r10.f7355a;
        if (r113 == true) goto L44;
    L51:
        if (r113 == false) goto L62;
        r13.put("edge", r10.f7357c);
        r13.put("cdn-cache", "miss");
        long r21 = r10.f7358d;
        long r22 = r10.f7359e;
        if (r21 <= r22) goto L55;
        r13.put(HttpHeaders.ReferrerPolicyValues.ORIGIN, r21 - r22);
    L56:
        r13.put("inner", r10.f7359e);
        if (r14 == (-1)) goto L61;
        long r23 = r10.f7358d;
        long r24 = r10.f7357c;
        if (r14 <= (r23 + r24)) goto L61;
        r10.f7360f = (r14 - r23) - r24;
    L61:
        r13.put("rtt", r10.f7360f);
        return;
    L55:
        r13.put(HttpHeaders.ReferrerPolicyValues.ORIGIN, -1);
        goto L56
    L62:
        r13.put("inner", r10.f7359e);
        if (r14 == (-1)) goto L67;
        long r25 = r10.f7359e;
        if (r14 <= r25) goto L67;
        r10.f7360f = r14 - r25;
    L67:
        r13.put("rtt", r10.f7360f);
        return;
    L44:
        if (r10.f7356b == false) goto L51;
        r13.put("edge", r10.f7357c);
        r13.put("cdn-cache", "hit");
        if (r14 == (-1)) goto L50;
        long r26 = r10.f7357c;
        if (r14 <= r26) goto L50;
        r10.f7360f = r14 - r26;
    L50:
        r13.put("rtt", r10.f7360f);
    }

    public boolean o() {
        if (this.f7338p.get() == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public void p(String r10, String r11, long r12, boolean r13, List r14) {
        g r15 = new g();
        r15.f7351a = 307;
        r15.f7354d = true;
        r15.f7352b = r10;
        r15.f7353c = r11;
        this.f7322J.add(r15);
        this.I++;
        this.f7340r = r12;
        this.P = true;
        if (r13 == false) goto L5;
        this.Q = true;
        this.S = com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g.l().f().size();
        return;
    L5:
        this.R.addAll(r14);
        this.Q = false;
    }

    public void q(long r10) {
        this.f7333k = System.currentTimeMillis();
        this.f7346x = r10;
    }

    public void r() {
        this.f7332j = System.currentTimeMillis();
    }

    public void s(Request r10) {
        this.f7331i = System.currentTimeMillis();
        if (r10 != null) goto L5;
    L7:
        this.K = LoadState.WAITING_FOR_RESPONSE;
        return;
    L5:
        if (this.f7338p.get() != (-1)) goto L7;
        this.f7347y = r10.e();
        goto L7
    }

    public void t() {
        this.K = LoadState.SENDING_REQUEST;
        this.f7330h = System.currentTimeMillis();
    }

    public void u(long r10) {
        this.f7337o = System.currentTimeMillis();
        this.A = r10;
    }

    public void v() {
        this.K = LoadState.READING_RESPONSE;
        this.f7336n = System.currentTimeMillis();
    }

    public void w(Response r10) {
        this.f7335m = System.currentTimeMillis();
        if (this.f7329g == (-1)) goto L5;
        this.f7343u = HandshakeType.HANDSHAKE_FULL;
    L6:
        if (r10 != null) goto L8;
        return;
    L8:
        if (this.f7338p.get() != (-1)) goto L27;
        this.f7348z = r10.d();
        this.B = r10.p();
        if (r10.e() == null) goto L14;
        this.f7344v = r10.e().f();
        this.f7345w = r10.e().a();
    L14:
        if (r10.j() == false) goto L20;
        this.I++;
        g r11 = new g();
        r11.f7351a = r10.d();
        r11.f7352b = r10.r().g();
        String r12 = r10.f("location");
        if (TextUtils.isEmpty(r12) == true) goto L18;
        r11.f7353c = r12;
    L18:
        this.f7322J.add(r11);
    L20:
        if (r10.k() == false) goto L24;
        String r13 = r10.f("content-type");
        if (TextUtils.isEmpty(r13) == true) goto L24;
        this.H = r13;
    L24:
        this.G = r10.i();
        return;
    L27:
        return;
    L5:
        this.f7343u = HandshakeType.HANDSHAKE_RESUME;
        goto L6
    }

    public void x() {
        this.f7334l = System.currentTimeMillis();
    }

    public void y() {
        this.f7329g = System.currentTimeMillis();
    }

    public void z() {
        this.f7328f = System.currentTimeMillis();
        this.K = LoadState.SSL_HANDSHAKE;
    }
}
