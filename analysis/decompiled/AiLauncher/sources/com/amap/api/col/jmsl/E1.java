package com.amap.api.col.jmsl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.jmsl.s7;
import com.amap.api.maps.model.AMapException;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import io.ktor.sse.ServerSentEventKt;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class E1 {

    /* renamed from: o, reason: collision with root package name */
    public static SoftReference<SSLContext> f15999o;

    /* renamed from: p, reason: collision with root package name */
    public static SoftReference<N1> f16000p;

    /* renamed from: a, reason: collision with root package name */
    public boolean f16001a;

    /* renamed from: b, reason: collision with root package name */
    public SSLContext f16002b;

    /* renamed from: c, reason: collision with root package name */
    public Proxy f16003c;

    /* renamed from: d, reason: collision with root package name */
    public String f16004d;

    /* renamed from: e, reason: collision with root package name */
    public d f16005e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f16007g;

    /* renamed from: h, reason: collision with root package name */
    public String f16008h;

    /* renamed from: i, reason: collision with root package name */
    public String f16009i;

    /* renamed from: f, reason: collision with root package name */
    public String f16006f = "";

    /* renamed from: j, reason: collision with root package name */
    public boolean f16010j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f16011k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f16012l = false;

    /* renamed from: m, reason: collision with root package name */
    public String f16013m = "";

    /* renamed from: n, reason: collision with root package name */
    public f f16014n = new f();

    public static class a implements Cloneable, Comparable {

        /* renamed from: a, reason: collision with root package name */
        public String f16015a;

        /* renamed from: b, reason: collision with root package name */
        public String f16016b;

        /* renamed from: c, reason: collision with root package name */
        public String f16017c;

        /* renamed from: d, reason: collision with root package name */
        public String f16018d;

        /* renamed from: e, reason: collision with root package name */
        public int f16019e;

        /* renamed from: f, reason: collision with root package name */
        public int f16020f;

        /* renamed from: g, reason: collision with root package name */
        public int f16021g;

        /* renamed from: h, reason: collision with root package name */
        public long f16022h;

        /* renamed from: i, reason: collision with root package name */
        public volatile AtomicInteger f16023i = new AtomicInteger(1);

        public a(c cVar) {
            this.f16015a = cVar.f16028c;
            this.f16016b = cVar.f16030e;
            this.f16018d = cVar.f16029d;
            this.f16019e = cVar.f16038m;
            this.f16020f = cVar.f16039n;
            this.f16021g = cVar.f16027b.f();
            this.f16017c = cVar.f16026a;
            this.f16022h = cVar.f16031f;
        }

        public a a() {
            try {
                return (a) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        public Object clone() throws CloneNotSupportedException {
            try {
                return (a) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            ((a) obj).getClass();
            return 0;
        }

        public String i() {
            String str;
            String str2;
            String str3;
            String str4;
            try {
                String str5 = this.f16019e + Const.STR_MART_WELL;
                if (TextUtils.isEmpty(this.f16018d)) {
                    str = str5 + "-#";
                } else {
                    str = str5 + this.f16018d + Const.STR_MART_WELL;
                }
                String str6 = (str + this.f16021g + Const.STR_MART_WELL) + this.f16023i + Const.STR_MART_WELL;
                if (TextUtils.isEmpty(this.f16015a)) {
                    str2 = str6 + "-#";
                } else {
                    str2 = str6 + this.f16015a + Const.STR_MART_WELL;
                }
                if (this.f16019e == 1) {
                    str3 = str2 + this.f16017c + Const.STR_MART_WELL;
                } else {
                    str3 = str2 + "-#";
                }
                if (this.f16019e == 1) {
                    str4 = str3 + this.f16022h + Const.STR_MART_WELL;
                } else {
                    str4 = str3 + "-#";
                }
                String str7 = (str4 + this.f16016b + Const.STR_MART_WELL) + this.f16020f;
                String strG = C1568j1.g(C1610u0.a(str7.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                E1.h("上报异常数据" + str7 + "加密后：" + strG);
                return strG;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public HttpURLConnection f16024a;

        /* renamed from: b, reason: collision with root package name */
        public int f16025b = this.f16025b;

        /* renamed from: b, reason: collision with root package name */
        public int f16025b = this.f16025b;

        public b(HttpURLConnection httpURLConnection) {
            this.f16024a = httpURLConnection;
        }
    }

    public static class c implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        public String f16026a = "";

        /* renamed from: b, reason: collision with root package name */
        public s7.b f16027b = s7.b.FIRST_NONDEGRADE;

        /* renamed from: c, reason: collision with root package name */
        public String f16028c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f16029d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f16030e = "";

        /* renamed from: f, reason: collision with root package name */
        public long f16031f = 0;

        /* renamed from: g, reason: collision with root package name */
        public long f16032g = 0;

        /* renamed from: h, reason: collision with root package name */
        public long f16033h = 0;

        /* renamed from: i, reason: collision with root package name */
        public long f16034i = 0;

        /* renamed from: j, reason: collision with root package name */
        public long f16035j = 0;

        /* renamed from: k, reason: collision with root package name */
        public String f16036k = O6.l.DATE_SEPARATOR;

        /* renamed from: l, reason: collision with root package name */
        public String f16037l = O6.l.DATE_SEPARATOR;

        /* renamed from: m, reason: collision with root package name */
        public int f16038m = 0;

        /* renamed from: n, reason: collision with root package name */
        public int f16039n = 0;

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c clone() {
            try {
                return (c) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        public String d() {
            String str;
            String str2;
            if (TextUtils.isEmpty(this.f16028c)) {
                str = "-#";
            } else {
                str = this.f16028c + Const.STR_MART_WELL;
            }
            if (TextUtils.isEmpty(this.f16029d)) {
                str2 = str + "-#";
            } else {
                str2 = str + this.f16029d + Const.STR_MART_WELL;
            }
            String str3 = (((str2 + this.f16027b.f() + Const.STR_MART_WELL) + this.f16033h + Const.STR_MART_WELL) + this.f16035j + Const.STR_MART_WELL) + this.f16031f;
            String strG = C1568j1.g(C1610u0.a(str3.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            E1.h("上报耗时数据" + str3 + "加密后：" + strG);
            return strG;
        }

        public String toString() {
            return "RequestInfo{csid='" + this.f16026a + "', degradeType=" + this.f16027b + ", serverIp='" + this.f16028c + "', path='" + this.f16029d + "', hostname='" + this.f16030e + "', totalTime=" + this.f16031f + ", DNSTime=" + this.f16032g + ", connectionTime=" + this.f16033h + ", writeTime=" + this.f16034i + ", readTime=" + this.f16035j + ", serverTime='" + this.f16036k + "', datasize='" + this.f16037l + "', errorcode=" + this.f16038m + ", errorcodeSub=" + this.f16039n + '}';
        }
    }

    public static class e implements HostnameVerifier {

        /* renamed from: a, reason: collision with root package name */
        public String f16042a;

        /* renamed from: b, reason: collision with root package name */
        public String f16043b;

        public e() {
        }

        public final String a() {
            return this.f16043b;
        }

        public final void b(String str) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(this.f16042a) || !str.contains(ServerSentEventKt.COLON) || (strArrSplit = str.split(ServerSentEventKt.COLON)) == null || strArrSplit.length <= 0) {
                this.f16042a = str;
            } else {
                this.f16042a = strArrSplit[0];
            }
        }

        public final void c(String str) {
            this.f16043b = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            return !TextUtils.isEmpty(this.f16042a) ? this.f16042a.equals(str) : !TextUtils.isEmpty(this.f16043b) ? defaultHostnameVerifier.verify(this.f16043b, sSLSession) : defaultHostnameVerifier.verify(str, sSLSession);
        }

        public /* synthetic */ e(byte b10) {
            this();
        }
    }

    public class f {

        /* renamed from: a, reason: collision with root package name */
        public long f16044a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f16045b = 0;

        /* renamed from: c, reason: collision with root package name */
        public c f16046c = new c();

        /* renamed from: d, reason: collision with root package name */
        public a f16047d;

        /* renamed from: e, reason: collision with root package name */
        public c f16048e;

        /* renamed from: f, reason: collision with root package name */
        public String f16049f;

        /* renamed from: g, reason: collision with root package name */
        public URL f16050g;

        public f() {
        }

        public final void a() {
            this.f16046c.f16033h = SystemClock.elapsedRealtime() - this.f16045b;
        }

        public final void b(int i10) {
            E1.h("----errorcode-----".concat(String.valueOf(i10)));
            try {
                this.f16046c.f16031f = SystemClock.elapsedRealtime() - this.f16044a;
                c cVar = this.f16046c;
                cVar.f16038m = i10;
                if (cVar.f16027b.i()) {
                    C1602s0.s(false, this.f16046c.f16030e);
                }
                boolean zN = E1.this.n(this.f16046c.f16030e);
                if (zN) {
                    if (E1.this.f16011k && !TextUtils.isEmpty(E1.this.f16009i) && this.f16046c.f16027b.j()) {
                        C1602s0.y();
                    }
                    if (this.f16046c.f16027b.g()) {
                        C1602s0.s(this.f16046c.f16027b.g(), this.f16046c.f16030e);
                    }
                    C1602s0.A(this.f16048e);
                    C1602s0.r(false, this.f16047d);
                    C1602s0.l(this.f16046c);
                }
                C1602s0.q(this.f16050g.toString(), this.f16046c.f16027b.g(), true, zN);
                E1.h("!!!error-" + this.f16046c.toString());
            } catch (Throwable unused) {
            }
        }

        public final void c(long j10) {
            this.f16046c.f16037l = new DecimalFormat("0.00").format(j10 / 1024.0f);
        }

        public final void d(C1577l2 c1577l2) {
            c cVarClone;
            try {
                this.f16046c.f16031f = SystemClock.elapsedRealtime() - this.f16044a;
                c1577l2.f16723e = this.f16046c.f16027b.g();
                if (this.f16046c.f16027b.j()) {
                    c cVar = this.f16046c;
                    if (cVar.f16031f > 10000) {
                        C1602s0.s(false, cVar.f16030e);
                    }
                }
                if (this.f16046c.f16027b.h()) {
                    C1602s0.s(false, this.f16049f);
                }
                boolean zN = E1.this.n(this.f16046c.f16030e);
                if (zN) {
                    C1602s0.A(this.f16046c);
                    C1602s0.r(true, this.f16047d);
                    c cVar2 = this.f16046c;
                    if (cVar2.f16031f > C1602s0.f16878o && (cVarClone = cVar2.clone()) != null) {
                        cVarClone.f16038m = 1;
                        C1602s0.l(cVarClone);
                        E1.h("!!!finish&error-" + cVarClone.toString());
                    }
                }
                C1602s0.q(this.f16050g.toString(), this.f16046c.f16027b.g(), false, zN);
                E1.h("!!!finish-" + this.f16046c.toString());
            } catch (Throwable unused) {
            }
        }

        public final void e() {
            this.f16046c.f16034i = SystemClock.elapsedRealtime() - this.f16045b;
        }

        public final void f() {
            this.f16046c.f16035j = SystemClock.elapsedRealtime() - this.f16045b;
        }

        public final void g() {
            c cVarClone = this.f16046c.clone();
            if (this.f16046c.f16031f > C1602s0.f16878o) {
                cVarClone.f16038m = 1;
            }
            if (cVarClone == null || C1602s0.f16866c == null) {
                return;
            }
            HashMap map = new HashMap();
            map.put("serverip", cVarClone.f16028c);
            map.put("hostname", cVarClone.f16030e);
            map.put("path", cVarClone.f16029d);
            map.put("csid", cVarClone.f16026a);
            map.put("degrade", String.valueOf(cVarClone.f16027b.f()));
            map.put("errorcode", String.valueOf(cVarClone.f16038m));
            map.put("errorsubcode", String.valueOf(cVarClone.f16039n));
            map.put("connecttime", String.valueOf(cVarClone.f16033h));
            map.put("writetime", String.valueOf(cVarClone.f16034i));
            map.put("readtime", String.valueOf(cVarClone.f16035j));
            map.put("datasize", String.valueOf(cVarClone.f16037l));
            map.put("totaltime", String.valueOf(cVarClone.f16031f));
            String string = new JSONObject(map).toString();
            E1.h("--埋点--".concat(String.valueOf(string)));
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                C1558h c1558h = new C1558h(C1602s0.f16866c, "core", "2.0", "O008");
                c1558h.a(string);
                C1594q.d(c1558h, C1602s0.f16866c);
            } catch (g5 unused) {
            }
        }
    }

    public E1() {
        C1602s0.N();
        try {
            this.f16004d = UUID.randomUUID().toString().replaceAll(O6.l.DATE_SEPARATOR, "").toLowerCase();
        } catch (Throwable th) {
            C1611u1.b(th, "ht", "ic");
        }
    }

    public static String f(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || map == null || map.size() <= 0) {
            return str;
        }
        int iIndexOf = str.indexOf("?");
        if (iIndexOf >= 0) {
            HashMap map2 = new HashMap();
            String strSubstring = str.substring(iIndexOf);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                if (!strSubstring.matches(".*[\\?\\&]" + URLEncoder.encode(key) + "=.*")) {
                    map2.put(key, value);
                }
            }
            map = map2;
        }
        if (map.size() == 0) {
            return str;
        }
        String strG = g(map);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (iIndexOf < 0) {
            stringBuffer.append("?");
        } else if (!str.endsWith("?") && !str.endsWith(Const.STR_MART_ADD)) {
            stringBuffer.append(Const.STR_MART_ADD);
        }
        if (strG != null) {
            stringBuffer.append(strG);
        }
        return stringBuffer.toString();
    }

    public static String g(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            if (sb2.length() > 0) {
                sb2.append(Const.STR_MART_ADD);
            }
            sb2.append(URLEncoder.encode(key));
            sb2.append("=");
            sb2.append(URLEncoder.encode(value));
        }
        return sb2.toString();
    }

    public static void h(String str) {
        r.i("httpUrlutil", str, false);
    }

    public static String l(Map<String, List<String>> map) {
        try {
            List<String> list = map.get("sc");
            if (list == null || list.size() <= 0) {
                return "";
            }
            String str = list.get(0);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (!str.contains(Const.STR_MART_WELL)) {
                return str;
            }
            String[] strArrSplit = str.split(Const.STR_MART_WELL);
            return strArrSplit.length > 1 ? strArrSplit[0] : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean p(String str) {
        return str.contains("rest") || str.contains("apilocate");
    }

    public int a(Exception exc) {
        if (exc instanceof SSLHandshakeException) {
            return 4101;
        }
        if (exc instanceof SSLKeyException) {
            return 4102;
        }
        if (exc instanceof SSLProtocolException) {
            return 4103;
        }
        if (exc instanceof SSLPeerUnverifiedException) {
            return 4104;
        }
        if (exc instanceof ConnectException) {
            return 6101;
        }
        if (exc instanceof SocketException) {
            return 6102;
        }
        if (exc instanceof ConnectTimeoutException) {
            return 2101;
        }
        if (exc instanceof SocketTimeoutException) {
            return ReportUtil.EXCEPTION_CODE_SERVERAUTHCLIENSCODE;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x018f A[Catch: all -> 0x0200, TryCatch #0 {all -> 0x0200, blocks: (B:48:0x011a, B:50:0x012e, B:52:0x0131, B:54:0x0135, B:56:0x013b, B:61:0x0146, B:64:0x0154, B:66:0x0157, B:68:0x015d, B:78:0x0189, B:80:0x018f, B:82:0x0199, B:84:0x01aa, B:86:0x01ae, B:88:0x01d6, B:90:0x01f7, B:91:0x01fa, B:69:0x0173, B:71:0x0177, B:73:0x017a, B:75:0x0180, B:76:0x0185), top: B:224:0x011a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.amap.api.col.jmsl.E1.b b(com.amap.api.col.jmsl.s7 r19, boolean r20, boolean r21) throws com.amap.api.col.jmsl.g5, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1180
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.E1.b(com.amap.api.col.jmsl.s7, boolean, boolean):com.amap.api.col.jmsl.E1$b");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01e1 A[Catch: all -> 0x0204, TRY_LEAVE, TryCatch #18 {all -> 0x0204, blocks: (B:125:0x01dd, B:127:0x01e1, B:129:0x01e5, B:131:0x01f4, B:133:0x0200, B:136:0x0206, B:137:0x0207), top: B:178:0x01dd }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0207 A[Catch: all -> 0x0204, TRY_LEAVE, TryCatch #18 {all -> 0x0204, blocks: (B:125:0x01dd, B:127:0x01e1, B:129:0x01e5, B:131:0x01f4, B:133:0x0200, B:136:0x0206, B:137:0x0207), top: B:178:0x01dd }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0226 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0234 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0242 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0218 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:199:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.amap.api.col.jmsl.C1577l2 c(com.amap.api.col.jmsl.E1.b r12, boolean r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 591
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.E1.c(com.amap.api.col.jmsl.E1$b, boolean):com.amap.api.col.jmsl.l2");
    }

    public final C1577l2 d(s7 s7Var) throws g5 {
        h("makeGetRequest");
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        try {
                                            try {
                                                try {
                                                    o(s7Var);
                                                    String strF = f(this.f16008h, s7Var.getParams());
                                                    this.f16008h = strF;
                                                    C1577l2 c1577l2A = C1615v1.a(strF, this.f16006f);
                                                    if (c1577l2A != null) {
                                                        this.f16014n.g();
                                                        return c1577l2A;
                                                    }
                                                    b bVarB = b(s7Var, false, true);
                                                    httpURLConnection = bVarB.f16024a;
                                                    this.f16014n.f16045b = SystemClock.elapsedRealtime();
                                                    httpURLConnection.connect();
                                                    this.f16014n.a();
                                                    C1577l2 c1577l2C = c(bVarB, s7Var.isIgnoreGZip());
                                                    this.f16014n.d(c1577l2C);
                                                    try {
                                                        httpURLConnection.disconnect();
                                                    } catch (Throwable th) {
                                                        C1611u1.b(th, "ht", "mgr");
                                                    }
                                                    this.f16014n.g();
                                                    return c1577l2C;
                                                } catch (Throwable th2) {
                                                    th2.printStackTrace();
                                                    this.f16014n.b(9);
                                                    throw new g5(AMapException.ERROR_UNKNOWN);
                                                }
                                            } catch (SocketException e10) {
                                                this.f16014n.f16046c.f16039n = a(e10);
                                                this.f16014n.b(6);
                                                throw new g5(AMapException.ERROR_SOCKET);
                                            }
                                        } catch (SocketTimeoutException e11) {
                                            this.f16014n.f16046c.f16039n = a(e11);
                                            this.f16014n.b(2);
                                            throw new g5("socket 连接超时 - SocketTimeoutException");
                                        }
                                    } catch (ConnectException e12) {
                                        this.f16014n.f16046c.f16039n = a(e12);
                                        this.f16014n.b(6);
                                        throw new g5(AMapException.ERROR_CONNECTION);
                                    }
                                } catch (MalformedURLException unused) {
                                    this.f16014n.b(8);
                                    throw new g5("url异常 - MalformedURLException");
                                }
                            } catch (g5 e13) {
                                if (!e13.n() && e13.a() != 10) {
                                    this.f16014n.b(e13.g());
                                }
                                throw e13;
                            }
                        } catch (UnknownHostException unused2) {
                            this.f16014n.b(9);
                            throw new g5("未知主机 - UnKnowHostException");
                        }
                    } catch (IOException unused3) {
                        this.f16014n.b(7);
                        throw new g5("IO 操作异常 - IOException");
                    }
                } catch (SSLException e14) {
                    e14.printStackTrace();
                    this.f16014n.f16046c.f16039n = a(e14);
                    this.f16014n.b(4);
                    throw new g5("IO 操作异常 - IOException");
                }
            } catch (Throwable th3) {
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th4) {
                        C1611u1.b(th4, "ht", "mgr");
                    }
                }
                this.f16014n.g();
                throw th3;
            }
        } catch (ConnectTimeoutException e15) {
            e15.printStackTrace();
            this.f16014n.f16046c.f16039n = a(e15);
            this.f16014n.b(2);
            throw new g5("IO 操作异常 - IOException");
        } catch (InterruptedIOException unused4) {
            f fVar = this.f16014n;
            fVar.f16046c.f16039n = 7101;
            fVar.b(7);
            throw new g5(AMapException.ERROR_UNKNOWN);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        if ("1".equals(r1[1]) != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean j(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7, boolean r8) {
        /*
            r6 = this;
            java.lang.String r0 = "lct"
            java.lang.String r1 = "#"
            r2 = 0
            java.lang.String r3 = "sc"
            java.lang.Object r3 = r7.get(r3)     // Catch: java.lang.Throwable -> L5d
            java.util.List r3 = (java.util.List) r3     // Catch: java.lang.Throwable -> L5d
            if (r3 == 0) goto L5d
            int r4 = r3.size()     // Catch: java.lang.Throwable -> L5d
            if (r4 <= 0) goto L5d
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L5d
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L5d
            if (r4 != 0) goto L5d
            boolean r4 = r3.contains(r1)     // Catch: java.lang.Throwable -> L5d
            r5 = 1
            if (r4 != 0) goto L29
            goto L3a
        L29:
            java.lang.String[] r1 = r3.split(r1)     // Catch: java.lang.Throwable -> L5d
            int r3 = r1.length     // Catch: java.lang.Throwable -> L5d
            if (r3 <= r5) goto L5d
            java.lang.String r3 = "1"
            r1 = r1[r5]     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.equals(r1)     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L5d
        L3a:
            if (r8 == 0) goto L5c
            boolean r8 = r7.containsKey(r0)     // Catch: java.lang.Throwable -> L5d
            if (r8 == 0) goto L5b
            java.lang.Object r7 = r7.get(r0)     // Catch: java.lang.Throwable -> L5d
            java.util.List r7 = (java.util.List) r7     // Catch: java.lang.Throwable -> L5d
            if (r7 == 0) goto L5b
            int r8 = r7.size()     // Catch: java.lang.Throwable -> L5d
            if (r8 <= 0) goto L5b
            long r7 = com.amap.api.col.jmsl.C1602s0.a(r7)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r6 = r6.f16006f     // Catch: java.lang.Throwable -> L5d
            boolean r6 = com.amap.api.col.jmsl.C1602s0.t(r6, r7)     // Catch: java.lang.Throwable -> L5d
            return r6
        L5b:
            return r2
        L5c:
            return r5
        L5d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.E1.j(java.util.Map, boolean):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v15, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v19 */
    public final C1577l2 k(s7 s7Var) throws g5 {
        OutputStream outputStream;
        h("makePostReqeust");
        ?? r72 = 0;
        r72 = 0;
        try {
            try {
                o(s7Var);
                C1577l2 c1577l2A = C1615v1.a(this.f16008h, this.f16006f);
                if (c1577l2A != null) {
                    this.f16014n.g();
                    return c1577l2A;
                }
                b bVarB = b(s7Var, true, true);
                HttpURLConnection httpURLConnection = bVarB.f16024a;
                try {
                    this.f16014n.f16045b = SystemClock.elapsedRealtime();
                    httpURLConnection.connect();
                    this.f16014n.a();
                    byte[] entityBytes = s7Var.getEntityBytes();
                    if (entityBytes == null || entityBytes.length == 0) {
                        String strG = g(s7Var.getParams());
                        if (!TextUtils.isEmpty(strG)) {
                            entityBytes = C1604s2.t(strG);
                        }
                    }
                    if (entityBytes != null && entityBytes.length > 0) {
                        try {
                            this.f16014n.f16045b = SystemClock.elapsedRealtime();
                            outputStream = httpURLConnection.getOutputStream();
                            try {
                                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                                try {
                                    dataOutputStream.write(entityBytes);
                                    dataOutputStream.close();
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    this.f16014n.e();
                                } catch (Throwable th) {
                                    th = th;
                                    r72 = dataOutputStream;
                                    if (r72 != 0) {
                                        r72.close();
                                    }
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    this.f16014n.e();
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            outputStream = null;
                        }
                    }
                    C1577l2 c1577l2C = c(bVarB, s7Var.isIgnoreGZip());
                    this.f16014n.d(c1577l2C);
                    this.f16014n.f16046c.toString();
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th4) {
                        C1611u1.b(th4, "ht", "mPt");
                    }
                    this.f16014n.g();
                    return c1577l2C;
                } catch (g5 e10) {
                    e = e10;
                    if (!e.n() && e.a() != 10) {
                        this.f16014n.b(e.a());
                    }
                    C1611u1.b(e, "ht", "mPt");
                    throw e;
                } catch (ConnectException e11) {
                    e = e11;
                    this.f16014n.f16046c.f16039n = a(e);
                    this.f16014n.b(6);
                    throw new g5(AMapException.ERROR_CONNECTION);
                } catch (MalformedURLException unused) {
                    this.f16014n.b(8);
                    throw new g5("url异常 - MalformedURLException");
                } catch (ConnectTimeoutException e12) {
                    e = e12;
                    this.f16014n.f16046c.f16039n = a(e);
                    this.f16014n.b(2);
                    throw new g5("IO 操作异常 - IOException");
                } catch (InterruptedIOException unused2) {
                    f fVar = this.f16014n;
                    fVar.f16046c.f16039n = 7101;
                    fVar.b(7);
                    throw new g5(AMapException.ERROR_UNKNOWN);
                } catch (SocketException e13) {
                    e = e13;
                    this.f16014n.f16046c.f16039n = a(e);
                    this.f16014n.b(6);
                    throw new g5(AMapException.ERROR_SOCKET);
                } catch (SocketTimeoutException e14) {
                    e = e14;
                    this.f16014n.f16046c.f16039n = a(e);
                    this.f16014n.b(2);
                    throw new g5("socket 连接超时 - SocketTimeoutException");
                } catch (UnknownHostException unused3) {
                    this.f16014n.b(5);
                    throw new g5("未知主机 - UnKnowHostException");
                } catch (SSLException e15) {
                    e = e15;
                    this.f16014n.f16046c.f16039n = a(e);
                    this.f16014n.b(4);
                    throw new g5("IO 操作异常 - IOException");
                } catch (IOException unused4) {
                    this.f16014n.b(7);
                    throw new g5("IO 操作异常 - IOException");
                } catch (Throwable th5) {
                    th = th5;
                    C1611u1.b(th, "ht", "mPt");
                    this.f16014n.b(9);
                    throw new g5(AMapException.ERROR_UNKNOWN);
                }
            } catch (Throwable th6) {
                if (0 != 0) {
                    try {
                        r72.disconnect();
                    } catch (Throwable th7) {
                        C1611u1.b(th7, "ht", "mPt");
                    }
                }
                this.f16014n.g();
                throw th6;
            }
        } catch (g5 e16) {
            e = e16;
        } catch (ConnectException e17) {
            e = e17;
        } catch (MalformedURLException unused5) {
        } catch (SocketTimeoutException e18) {
            e = e18;
        } catch (InterruptedIOException unused6) {
        } catch (SocketException e19) {
            e = e19;
        } catch (UnknownHostException unused7) {
        } catch (SSLException e20) {
            e = e20;
        } catch (ConnectTimeoutException e21) {
            e = e21;
        } catch (IOException unused8) {
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public final boolean n(String str) {
        if (this.f16007g) {
            return true;
        }
        return (!TextUtils.isEmpty(this.f16009i) && (this.f16009i.contains("rest") || this.f16009i.contains("apilocate"))) || p(str);
    }

    public final void o(s7 s7Var) throws g5 {
        this.f16005e = new d((byte) 0);
        this.f16011k = s7Var.isIPV6Request();
        this.f16003c = s7Var.getProxy();
        s7Var.getUrlConnectionImpl();
        this.f16007g = s7Var.isBinary();
        this.f16006f = s7Var.parseSdkNameFromRequest();
        this.f16001a = C1607t1.a().d(s7Var.isHttps());
        String strB = s7Var.getDegradeType().j() ? s7Var.b() : s7Var.a();
        this.f16008h = strB;
        M1.a.b();
        this.f16008h = strB;
        String strN = C1615v1.n(strB, this.f16006f);
        this.f16008h = strN;
        h("restrictionURLTest: ".concat(String.valueOf(strN)));
        if (C1612u2.a().b(strN)) {
            h("restriction hit: ".concat(String.valueOf(strN)));
            throw new g5("限制访问的接口");
        }
        this.f16012l = s7Var.isTLSv3();
        this.f16009i = s7Var.getIPDNSName();
        if ("loc".equals(this.f16006f)) {
            String strA = s7Var.a();
            String strB2 = s7Var.b();
            if (!TextUtils.isEmpty(strA)) {
                try {
                    new URL(strA).getHost();
                } catch (Exception unused) {
                }
            }
            if (TextUtils.isEmpty(strB2)) {
                return;
            }
            try {
                if (TextUtils.isEmpty(this.f16009i)) {
                    new URL(strB2).getHost();
                }
            } catch (Exception unused2) {
            }
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public Vector<e> f16040a;

        /* renamed from: b, reason: collision with root package name */
        public volatile e f16041b;

        public d() {
            this.f16040a = new Vector<>();
            this.f16041b = new e((byte) 0);
        }

        public final e a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.f16041b;
            }
            byte b10 = 0;
            for (int i10 = 0; i10 < this.f16040a.size(); i10++) {
                e eVar = this.f16040a.get(i10);
                if (eVar != null && eVar.a().equals(str)) {
                    return eVar;
                }
            }
            e eVar2 = new e(b10);
            eVar2.c(str);
            this.f16040a.add(eVar2);
            return eVar2;
        }

        public /* synthetic */ d(byte b10) {
            this();
        }
    }
}
