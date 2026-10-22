package com.amap.api.col.s;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.utils.logger.FLogger;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.PushbackInputStream;
import java.lang.ref.SoftReference;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public final class cv {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static SoftReference<SSLContext> f26494k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static SoftReference<cw> f26495m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f26496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f26497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f26498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SSLContext f26499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Proxy f26500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f26501f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f26502g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f26503h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f26504i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private b f26505j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private cs.a f26506l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f26507n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f26508o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f26509p;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HttpURLConnection f26510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f26511b;

        public a(HttpURLConnection r100, int r101) {
            this.f26510a = r100;
            this.f26511b = r101;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Vector<c> f26512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile c f26513b;

        private b() {
            this.f26512a = new Vector();
            this.f26513b = new c(0);
        }

        public final c a() {
            return this.f26513b;
        }

        public /* synthetic */ b(byte r100) {
            this();
        }

        public final c a(String r100) {
            if (TextUtils.isEmpty(r100) == true) goto L5;
            byte r101 = 0;
            int r102 = 0;
        L8:
            if (r102 >= this.f26512a.size()) goto L15;
            c r103 = this.f26512a.get(r102);
            if (r103 == null) goto L14;
            if (r103.a().equals(r100) == false) goto L14;
            return r103;
        L14:
            r102 = r102 + 1;
            goto L8
        L15:
            c r104 = new c(r101);
            r104.b(r100);
            this.f26512a.add(r104);
            return r104;
        L5:
            return this.f26513b;
        }

        public final void b(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L5;
            return;
        L5:
            this.f26513b.a(r100);
        }
    }

    public static class c implements HostnameVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f26514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f26515b;

        private c() {
        }

        public final String a() {
            return this.f26515b;
        }

        public /* synthetic */ c(byte r100) {
            this();
        }

        public final void a(String r100) {
            this.f26514a = r100;
        }

        public final void b(String r100) {
            this.f26515b = r100;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String r100, SSLSession r101) {
            HostnameVerifier r102 = HttpsURLConnection.getDefaultHostnameVerifier();
            if (TextUtils.isEmpty(this.f26514a) == true) goto L7;
            return this.f26514a.equals(r100);
        L7:
            if (TextUtils.isEmpty(this.f26515b) == true) goto L11;
            return r102.verify(this.f26515b, r101);
        L11:
            return r102.verify(r100, r101);
        }
    }

    private cw a() {
        SoftReference<cw> r100 = f26495m;     // Catch: Throwable -> L15
        if (r100 != null) goto L6;
    L7:
        f26495m = new SoftReference(new cw(bj.f26201c, this.f26499d));     // Catch: Throwable -> L15
    L9:
        if (f26494k == null) goto L11;
        cw r101 = f26495m.get();     // Catch: Throwable -> L15
    L12:
        if (r101 != null) goto L20;
        return new cw(bj.f26201c, this.f26499d);
    L20:
        return r101;
    L11:
        r101 = null;
        goto L12
    L6:
        if (r100.get() != null) goto L9;
    L15:
        th = move-exception;
        cg.c(th, "ht", "gsf");
        return null;
    }

    public static boolean a(int r100) {
        if (r100 != 2) goto L6;
        return true;
    L6:
        return false;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_amap_api_col_s_cv_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    private static String a(String r100) {
        String r101 = "";
    L29:
        th = move-exception;
        cd.a(th, "ht", "pnfp");
    L31:
        return r101;
    L4:
        if (TextUtils.isEmpty(r100) == true) goto L31;
        String[] r102 = r100.split("&");     // Catch: Throwable -> L29
        if (r102.length <= 1) goto L31;
        int r103 = r102.length;     // Catch: Throwable -> L29
        int r104 = 0;
        String r105 = "";
    L8:
        if (r104 >= r103) goto L16;
        String r106 = r102[r104];     // Catch: Throwable -> L29
        if (r106.contains("sdkversion") == false) goto L13;
        r105 = r106;
    L13:
        if (r106.contains("product") == true) goto L18;
        r104 = r104 + 1;     // Catch: Throwable -> L29
    L18:
        if (TextUtils.isEmpty(r106) == true) goto L31;
        String[] r107 = r106.split(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L29
        if (r107.length <= 1) goto L31;
        r101 = r107[1].trim();     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r105) == true) goto L31;
        if (TextUtils.isEmpty(cc.a(r101)) == false) goto L31;
        String[] r108 = r105.split(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L29
        if (r108.length <= 1) goto L31;
        cc.a(r101, r108[1].trim());     // Catch: Throwable -> L29
        goto L31
    L16:
        r106 = "";
        goto L18
    }

    private void b(int r100) {
        if (r100 != 2) goto L5;
        this.f26496a = Math.max(this.f26496a - 5000, 5000);     // Catch: Throwable -> L11
        this.f26497b = Math.max(this.f26497b - 5000, 5000);     // Catch: Throwable -> L11
        return;
    L5:
        if (r100 != 3) goto L13;
        this.f26496a = 5000;     // Catch: Throwable -> L11
        this.f26497b = 5000;     // Catch: Throwable -> L11
        return;
    L13:
        return;
    }

    public static String a(Map<String, String> r100) {
        if (r100 == null) goto L15;
        StringBuilder r101 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L5:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<String, String> r103 = r102.next();
        String r104 = r103.getKey();
        String r105 = r103.getValue();
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        if (r101.length() <= 0) goto L12;
        r101.append("&");
    L12:
        r101.append(URLEncoder.encode(r104));
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r101.append(URLEncoder.encode(r105));
        goto L5
    L14:
        return r101.toString();
    L15:
        return null;
    }

    private static String b(Map<String, String> r100) {
        if (r100 != null) goto L12;
        return null;
    L12:
    L9:
        th = move-exception;
        cd.a(th, "ht", "pnfh");
        return null;
    L6:
        if (r100.containsKey("platinfo") == false) goto L14;
        return a(r100.get("platinfo"));
    L14:
        return null;
    }

    public static int a(cy r100) {
    L18:
        th = move-exception;
        cg.c(th, "htu", "gt");
    L20:
        return 1;
    L4:
        if (bj.b() == false) goto L7;
        return 4;
    L7:
        if (r100 != null) goto L9;
    L11:
        if (bj.a() == true) goto L15;
        char r101 = 1;
    L16:
        if (2 != r101) goto L20;
        return 2;
    L15:
        r101 = 2;
        goto L16
    L9:
        if (r100.k() == true) goto L11;
        return 1;
    }

    public cv(cy r100, boolean r101) {
        this(r100, r101, (byte) 0);
    }

    private cz a(a r110, long r210) throws bh, IOException {
        String r100 = "";
        cu.a();     // Catch: Throwable -> L96 IOException -> L99
        HttpURLConnection r101 = r110.f26510a;     // Catch: Throwable -> L96 IOException -> L99
        r101.connect();     // Catch: Throwable -> L96 IOException -> L99
        Map<String, List<String>> r102 = r101.getHeaderFields();     // Catch: Throwable -> L96 IOException -> L99
        int r103 = r101.getResponseCode();     // Catch: Throwable -> L96 IOException -> L99
        if (r102 == null) goto L39;
        List<String> r111 = r102.get("gsid");     // Catch: Throwable -> L96 IOException -> L99
        if (r111 != null) goto L8;
    L154:
        if (TextUtils.isEmpty(this.f26509p) == true) goto L39;
        if (this.f26508o == true) goto L16;
        boolean r112 = a(r102, true);     // Catch: Throwable -> L38
        char r113 = 2;
    L148:
        if (r112 == true) goto L23;
        if (r113 != 1) goto L41;
        cu.a(false, this.f26509p);     // Catch: Throwable -> L34
    L147:
        goto L41
    L23:
        if (this.f26509p.equals("loc") == false) goto L29;
        String r114 = this.f26509p;     // Catch: Throwable -> L34
        if (r113 != 2) goto L27;
        boolean r115 = true;
    L28:
        bj.a(r114, r115, r101.getURL().getHost(), r101.getURL().getHost(), this.f26507n);     // Catch: Throwable -> L34
        goto L147
    L27:
        r115 = false;
        goto L28
    L29:
        String r104 = this.f26509p;     // Catch: Throwable -> L34
        if (r113 != 2) goto L32;
        boolean r116 = true;
    L33:
        bj.b(r104, r116);     // Catch: Throwable -> L34
        goto L147
    L32:
        r116 = false;
    L41:
        if (r103 != 200) goto L94;
        ByteArrayOutputStream r105 = new ByteArrayOutputStream();     // Catch: Throwable -> L96 IOException -> L99
        InputStream r117 = r101.getInputStream();     // Catch: Throwable -> L90 IOException -> L92
        PushbackInputStream r118 = new PushbackInputStream(r117, 2);     // Catch: Throwable -> L84 IOException -> L87
    L162:
        byte[] r106 = new byte[2];     // Catch: Throwable -> L80 IOException -> L82
        r118.read(r106);     // Catch: Throwable -> L80 IOException -> L82
        r118.unread(r106);     // Catch: Throwable -> L80 IOException -> L82
        if (r106[0] == 31) goto L48;
    L51:
        InputStream r119 = r118;
    L155:
        byte[] r107 = new byte[1024];     // Catch: Throwable -> L76 IOException -> L78
    L54:
        int r108 = r119.read(r107);     // Catch: Throwable -> L76 IOException -> L78
        if (r108 == (-1)) goto L57;
        r105.write(r107, 0, r108);     // Catch: Throwable -> L76 IOException -> L78
        goto L54
    L57:
        cg.b();     // Catch: Throwable -> L76 IOException -> L78
        cz r120 = new cz();     // Catch: Throwable -> L76 IOException -> L78
        r120.f26524a = r105.toByteArray();     // Catch: Throwable -> L76 IOException -> L78
        r120.f26525b = r102;     // Catch: Throwable -> L76 IOException -> L78
        r120.f26526c = this.f26504i;     // Catch: Throwable -> L76 IOException -> L78
        r120.f26527d = r100;     // Catch: Throwable -> L76 IOException -> L78
        r120.f26528e = r112;     // Catch: Throwable -> L76 IOException -> L78
        cu.a(r101.getURL(), r120);     // Catch: Throwable -> L76 IOException -> L78
        a(r110, false, r210, System.currentTimeMillis());     // Catch: Throwable -> L76 IOException -> L78
        r105.close();     // Catch: Throwable -> L60
    L62:
        if (r117 != null) goto L152;
    L133:
        r118.close();     // Catch: Throwable -> L69
    L139:
        r119.close();     // Catch: Throwable -> L73
    L75:
        return r120;
    L73:
        th = move-exception;
        cd.a(th, "ht", "par");
    L69:
        th = move-exception;
        cd.a(th, "ht", "par");
        goto L139
    L152:
        r117.close();     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        cd.a(th, "ht", "par");
    L60:
        th = move-exception;
        cd.a(th, "ht", "par");
        goto L62
    L78:
        e = e;
        r117 = r117;
    L137:
        bh r109 = new bh(AMapException.AMAP_CLIENT_IO_EXCEPTION, r100, this.f26504i);     // Catch: Throwable -> L110
        if ((e instanceof InterruptedIOException) == true) goto L105;
        throw r109;     // Catch: Throwable -> L110
    L105:
        if (TextUtils.isEmpty(e.getMessage()) == false) goto L107;
        throw r109;     // Catch: Throwable -> L110
    L107:
        if (e.getMessage().equals("thread interrupted") == false) goto L167;
        r109.g();     // Catch: Throwable -> L110
        throw r109;     // Catch: Throwable -> L110
    L167:
        throw r109;     // Catch: Throwable -> L110
    L110:
        th = move-exception;
        Throwable r121 = th;
    L112:
        if (r105 != null) goto L141;
    L117:
        if (r117 != null) goto L150;
    L122:
        if (r118 != null) goto L135;
    L127:
        if (r119 == null) goto L168;
        r119.close();     // Catch: Throwable -> L130
        throw r121;
    L130:
        th = move-exception;
        cd.a(th, "ht", "par");
        throw r121;
    L168:
        throw r121;
    L135:
        r118.close();     // Catch: Throwable -> L125
    L125:
        th = move-exception;
        cd.a(th, "ht", "par");
        goto L127
    L150:
        r117.close();     // Catch: Throwable -> L120
    L120:
        th = move-exception;
        cd.a(th, "ht", "par");
        goto L122
    L141:
        r105.close();     // Catch: Throwable -> L115
    L115:
        th = move-exception;
        cd.a(th, "ht", "par");
    L76:
        th = move-exception;
        r121 = th;
        r117 = r117;
        goto L112
    L48:
        if (r106[1] != (-117)) goto L51;
        r119 = new GZIPInputStream(r118);     // Catch: Throwable -> L80 IOException -> L82
        goto L155
    L82:
        e = e;
    L89:
        r119 = null;
    L80:
        th = move-exception;
        r121 = th;
    L86:
        r119 = null;
    L87:
        e = e;
        r118 = null;
    L84:
        th = move-exception;
        r121 = th;
        r118 = null;
        goto L86
    L92:
        e = e;
    L101:
        r118 = null;
        r119 = null;
        r117 = null;
    L90:
        th = move-exception;
        r121 = th;
    L98:
        r118 = null;
        r119 = null;
        r117 = null;
        goto L112
    L94:
        bh r122 = new bh("网络异常原因：" + r101.getResponseMessage() + " 网络异常状态码：" + r103 + tb2.c.DEFAULT_TEXT + r100 + " " + this.f26504i, r100, this.f26504i);     // Catch: Throwable -> L96 IOException -> L99
        r122.a(r103);     // Catch: Throwable -> L96 IOException -> L99
        throw r122;     // Catch: Throwable -> L96 IOException -> L99
    L16:
        if (r102.containsKey(SRStrategy.KEY_SR_STRATEGY_CONFIG) == false) goto L18;
        r112 = a(r102, false);     // Catch: Throwable -> L38
        r113 = 1;
        goto L148
    L18:
        bj.b(this.f26509p);     // Catch: Throwable -> L38
        r112 = false;
        r113 = 0;
        goto L148
    L8:
        if (r111.size() <= 0) goto L154;
        r100 = r111.get(0);     // Catch: Throwable -> L96 IOException -> L99
    L39:
        r112 = false;
    L99:
        e = e;
        r105 = null;
    L96:
        th = move-exception;
        r121 = th;
        r105 = null;
        goto L98
    }

    private boolean a(Map<String, List<String>> r100, boolean r101) {
        List<String> r102 = r100.get(SRStrategy.KEY_SR_STRATEGY_CONFIG);     // Catch: Throwable -> L33
        if (r102 != null) goto L6;
    L17:
        boolean r103 = false;
    L18:
        if (r103 == true) goto L20;
        return false;
    L20:
        if (r101 == true) goto L22;
        return true;
    L22:
        if (r100.containsKey("lct") == false) goto L36;
        List<String> r104 = r100.get("lct");     // Catch: Throwable -> L33
        if (r104 != null) goto L26;
        return false;
    L26:
        if (r104.size() <= 0) goto L38;
        String r105 = (String) ListProtector.get(r104, 0);     // Catch: Throwable -> L33
        if (TextUtils.isEmpty(r105) == true) goto L39;
        long r106 = CastLongProtector.valueOf(r105).longValue();     // Catch: Throwable -> L33
        return bj.a(this.f26509p, r106);
    L39:
        return false;
    L38:
        return false;
    L36:
        return false;
    L6:
        if (r102.size() <= 0) goto L17;
        String r107 = (String) ListProtector.get(r102, 0);     // Catch: Throwable -> L33
        if (TextUtils.isEmpty(r107) == true) goto L17;
        if (r107.contains("#") == true) goto L12;
    L11:
        r103 = true;
        goto L18
    L12:
        String[] r108 = r107.split("#");     // Catch: Throwable -> L33
        if (r108.length <= 1) goto L17;
        if ("1".equals(r108[1]) == false) goto L17;
    L41:
        return false;
    }

    private void a(Map<String, String> r100, HttpURLConnection r101) {
        if (r100 == null) goto L13;
        Iterator<String> r102 = r100.keySet().iterator();
    L5:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();
        r101.addRequestProperty(r103, r100.get(r103));
    L13:
        r101.addRequestProperty("csid", this.f26504i);     // Catch: Throwable -> L9
    L11:
        r101.setConnectTimeout(this.f26496a);
        r101.setReadTimeout(this.f26497b);
        return;
    L9:
        th = move-exception;
        cd.a(th, "ht", "adh");
        goto L11
    }

    private static String a(String r100, Map<String, String> r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        String r102 = a(r101);
        StringBuffer r103 = new StringBuffer();
        r103.append(r100);
        if (r102 == null) goto L9;
        r103.append("?");
        r103.append(r102);
    L9:
        return r103.toString();
    }

    private cv(cy r100, boolean r101, byte r102) {
        this(r100.f26521g, r100.f26522h, r100.f26523i, r101);
        String r103 = r100.c();     // Catch: Throwable -> L11
        this.f26509p = r103;     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r103) == true) goto L6;
        return;
    L6:
        if ((r100 instanceof ct) == false) goto L9;
        this.f26509p = a(((ct) r100).l());     // Catch: Throwable -> L11
        return;
    L9:
        this.f26509p = b(r100.f());     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        cd.a(th, "ht", "pnfr");
    }

    private String a(int r100, String r101, Map<String, String> r102) {
        if (r100 == 1) goto L5;
        String r103 = "";
    L7:
        if (TextUtils.isEmpty(r103) == false) goto L9;
        return r101;
    L9:
        Uri r104 = UriProtector.parse(r101);
        String r105 = r104.getHost();
        String r106 = r104.buildUpon().encodedAuthority(r103).build().toString();
        if (r102 == null) goto L13;
        r102.put("targetHost", r105);
    L13:
        if (this.f26498c == false) goto L15;
        this.f26505j.b(r103);
    L15:
        return r106;
    L5:
        r103 = cs.f26477b;
        goto L7
    }

    private static String a(String r100, String r101, int r102) {
        if (r102 != 2) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L15;
    L13:
        return r100;
    L15:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        return r101;
    L5:
        if (r102 == 4) goto L8;
        r103 = false;
        goto L9
    }

    private cv(int r100, int r101, Proxy r102, boolean r103) {
        byte r104 = 0;
        this.f26501f = false;
        this.f26502g = -1;
        this.f26503h = 0;
        this.f26508o = false;
        this.f26509p = "";
        this.f26496a = r100;
        this.f26497b = r101;
        this.f26500e = r102;
        this.f26498c = bo.a().b(r103);
        bj.c();
        if (bo.b() == false) goto L5;
        this.f26498c = false;
    L5:
        this.f26506l = null;
        this.f26504i = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();     // Catch: Throwable -> L8
    L11:
        if (this.f26498c == true) goto L33;
    L29:
        this.f26505j = new b(r104);
        return;
    L33:
        SoftReference<SSLContext> r105 = f26494k;     // Catch: Throwable -> L21
        if (r105 != null) goto L15;
    L16:
        f26494k = new SoftReference(SSLContext.getInstance("TLS"));     // Catch: Throwable -> L21
    L17:
        SoftReference<SSLContext> r106 = f26494k;     // Catch: Throwable -> L21
        if (r106 == null) goto L22;
        SSLContext r107 = r106.get();     // Catch: Throwable -> L21
    L23:
        if (r107 == null) goto L31;
    L25:
        r107.init(null, null, null);     // Catch: Throwable -> L27
        this.f26499d = r107;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        cd.a(th, "ht", "ne");
        goto L29
    L31:
        r107 = SSLContext.getInstance("TLS");     // Catch: Throwable -> L27
        goto L25
    L15:
        if (r105.get() != null) goto L17;
    L22:
        r107 = null;
    L8:
        th = move-exception;
        cd.a(th, "ht", "ic");
        goto L11
    }

    private static void a(a r100, boolean r101, long r110, long r111) {
        boolean r102 = false;
        String r103 = r100.f26510a.getURL().toString();     // Catch: Throwable -> L16
        int r104 = r100.f26511b;     // Catch: Throwable -> L15
        if (r104 != 3) goto L8;
        boolean r105 = true;
    L10:
        if (r104 != 2) goto L12;
    L13:
        r102 = true;
    L14:
        boolean r106 = r102;
        boolean r107 = r105;
        String r108 = r103;
    L19:
        if (TextUtils.isEmpty(r108) == false) goto L21;
        return;
    L21:
        bj.a(r108, r106, r107, r101, Math.max(0, r111 - r110));
        return;
    L12:
        if (r104 != 4) goto L14;
    L8:
        r105 = false;
    L17:
        r108 = r103;
        r106 = false;
        r107 = false;
    L16:
        r103 = null;
        goto L17
    }

    public final cz a(String r110, String r111, boolean r112, String r210, Map<String, String> r211, byte[] r212, int r213) throws bh {
    L161:
        cz r100 = cu.a(r110, r111, this.f26509p);     // Catch: IOException -> L64 SocketTimeoutException -> L67 SocketException -> L70 UnknownHostException -> L73 MalformedURLException -> L76 ConnectException -> L79 Throwable -> L82 bh -> L87 InterruptedIOException -> L103
        if (r100 == null) goto L8;
        return r100;
    L8:
        long r101 = System.currentTimeMillis();     // Catch: IOException -> L64 SocketTimeoutException -> L67 SocketException -> L70 UnknownHostException -> L73 MalformedURLException -> L76 ConnectException -> L79 Throwable -> L82 bh -> L87 InterruptedIOException -> L103
        a r102 = a(r110, r111, r112, r210, r211, true, r213);     // Catch: IOException -> L64 SocketTimeoutException -> L67 SocketException -> L70 UnknownHostException -> L73 MalformedURLException -> L76 ConnectException -> L79 Throwable -> L82 bh -> L87 InterruptedIOException -> L103
        goto L106
    L163:
        HttpURLConnection r103 = r102.f26510a;     // Catch: Throwable -> L47 bh -> L49 IOException -> L51 InterruptedIOException -> L53 SocketTimeoutException -> L54 SocketException -> L56 UnknownHostException -> L58 MalformedURLException -> L60 ConnectException -> L62
        if (r212 != null) goto L162;
    L23:
        cz r104 = a(r102, r101);     // Catch: Throwable -> L30 bh -> L32 IOException -> L34 InterruptedIOException -> L36 SocketTimeoutException -> L37 SocketException -> L39 UnknownHostException -> L41 MalformedURLException -> L43 ConnectException -> L45
        if (r103 != null) goto L157;
    L29:
        return r104;
    L157:
        r103.disconnect();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        cd.a(th, "ht", "mPt");
        goto L29
    L162:
    L32:
        e = e;
        HttpURLConnection r113 = r103;
    L151:
        boolean r114 = !e.f();
        cd.a(e, "ht", "mPt");     // Catch: Throwable -> L94
        throw e;     // Catch: Throwable -> L94
    L94:
        th = move-exception;
        Throwable r105 = th;
    L134:
        if (r114 == true) goto L153;
    L138:
        if (r113 == null) goto L165;
        r113.disconnect();     // Catch: Throwable -> L141
        throw r105;
    L141:
        th = move-exception;
        cd.a(th, "ht", "mPt");
        throw r105;
    L165:
        throw r105;
    L153:
        bj.a(r213);     // Catch: Throwable -> L137
        a(r102, true, 0, 0);     // Catch: Throwable -> L137
    L96:
        th = th;
    L133:
        r105 = th;
        r114 = true;
    L45:
        e = e;
    L130:
        e.printStackTrace();     // Catch: Throwable -> L132
        throw new bh("http连接失败 - ConnectionException");     // Catch: Throwable -> L132
    L43:
        e = e;
    L125:
        e.printStackTrace();     // Catch: Throwable -> L132
        throw new bh(AMapException.AMAP_CLIENT_URL_EXCEPTION);     // Catch: Throwable -> L132
    L39:
        e = e;
    L115:
        e.printStackTrace();     // Catch: Throwable -> L132
        throw new bh("socket 连接异常 - SocketException");     // Catch: Throwable -> L132
    L37:
        e = e;
    L110:
        e.printStackTrace();     // Catch: Throwable -> L132
        throw new bh(AMapException.AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION);     // Catch: Throwable -> L132
    L41:
        e = e;
    L120:
        e.printStackTrace();     // Catch: Throwable -> L132
        throw new bh(AMapException.AMAP_CLIENT_UNKNOWHOST_EXCEPTION);     // Catch: Throwable -> L132
    L34:
        e = e;
    L101:
        e.printStackTrace();     // Catch: Throwable -> L132
        throw new bh(AMapException.AMAP_CLIENT_IO_EXCEPTION);     // Catch: Throwable -> L132
    L30:
        th = th;
    L85:
        cd.a(th, "ht", "mPt");     // Catch: Throwable -> L132
        throw new bh("未知的错误");     // Catch: Throwable -> L132
    L12:
        if (r212.length <= 0) goto L23;
        DataOutputStream r106 = new DataOutputStream(r103.getOutputStream());     // Catch: Throwable -> L18
        r106.write(r212);     // Catch: Throwable -> L16
        r106.close();     // Catch: Throwable -> L30 bh -> L32 IOException -> L34 InterruptedIOException -> L36 SocketTimeoutException -> L37 SocketException -> L39 UnknownHostException -> L41 MalformedURLException -> L43 ConnectException -> L45
    L16:
        th = th;
        DataOutputStream r115 = r106;
    L20:
        if (r115 == null) goto L22;
        r115.close();     // Catch: Throwable -> L30 bh -> L32 IOException -> L34 InterruptedIOException -> L36 SocketTimeoutException -> L37 SocketException -> L39 UnknownHostException -> L41 MalformedURLException -> L43 ConnectException -> L45
    L22:
        throw th;     // Catch: Throwable -> L30 bh -> L32 IOException -> L34 InterruptedIOException -> L36 SocketTimeoutException -> L37 SocketException -> L39 UnknownHostException -> L41 MalformedURLException -> L43 ConnectException -> L45
    L18:
        th = th;
        r115 = null;
        goto L20
    L49:
        e = e;
    L89:
        r113 = null;
    L62:
        e = e;
    L60:
        e = e;
    L56:
        e = e;
    L54:
        e = e;
    L58:
        e = e;
    L51:
        e = e;
    L47:
        th = th;
    L79:
        e = e;
    L76:
        e = e;
    L70:
        e = e;
    L67:
        e = e;
    L73:
        e = e;
    L64:
        e = e;
    L132:
        th = th;
    L87:
        e = e;
        r102 = null;
    L82:
        th = th;
    L127:
        e = e;
    L122:
        e = e;
    L112:
        e = e;
    L107:
        e = e;
    L117:
        e = e;
    L98:
        e = e;
    L106:
        throw new bh("未知的错误");     // Catch: Throwable -> L132
    }

    public final cz a(String r110, String r111, boolean r112, String r210, Map<String, String> r211, Map<String, String> r212, int r213) throws bh {
        String r100 = a(r110, r212);     // Catch: Throwable -> L37 bh -> L42 IOException -> L52 InterruptedIOException -> L56 SocketTimeoutException -> L60 SocketException -> L64 UnknownHostException -> L68 MalformedURLException -> L72 ConnectException -> L76
        String r101 = a(r111, r212);     // Catch: Throwable -> L37 bh -> L42 IOException -> L52 InterruptedIOException -> L56 SocketTimeoutException -> L60 SocketException -> L64 UnknownHostException -> L68 MalformedURLException -> L72 ConnectException -> L76
        cz r102 = cu.a(r100, r101, this.f26509p);     // Catch: Throwable -> L37 bh -> L42 IOException -> L52 InterruptedIOException -> L56 SocketTimeoutException -> L60 SocketException -> L64 UnknownHostException -> L68 MalformedURLException -> L72 ConnectException -> L76
        if (r102 == null) goto L6;
        return r102;
    L6:
        long r103 = System.currentTimeMillis();     // Catch: Throwable -> L37 bh -> L42 IOException -> L52 InterruptedIOException -> L56 SocketTimeoutException -> L60 SocketException -> L64 UnknownHostException -> L68 MalformedURLException -> L72 ConnectException -> L76
        a r104 = a(r100, r101, r112, r210, r211, false, r213);     // Catch: Throwable -> L37 bh -> L42 IOException -> L52 InterruptedIOException -> L56 SocketTimeoutException -> L60 SocketException -> L64 UnknownHostException -> L68 MalformedURLException -> L72 ConnectException -> L76
        HttpURLConnection r105 = r104.f26510a;     // Catch: Throwable -> L26 bh -> L28 IOException -> L30 InterruptedIOException -> L31 SocketTimeoutException -> L32 SocketException -> L33 UnknownHostException -> L34 MalformedURLException -> L35 ConnectException -> L36
    L106:
        cz r106 = a(r104, r103);     // Catch: Throwable -> L15 bh -> L17 IOException -> L19 InterruptedIOException -> L20 SocketTimeoutException -> L21 SocketException -> L22 UnknownHostException -> L23 MalformedURLException -> L24 ConnectException -> L25
        if (r105 != null) goto L97;
    L14:
        return r106;
    L97:
        r105.disconnect();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        cd.a(th, "ht", "mgr");
        goto L14
    L17:
        e = e;
        a r113 = r104;
        HttpURLConnection r114 = r105;
    L94:
        boolean r115 = !e.f();
        throw e;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        Throwable r107 = th;
    L82:
        if (r115 == true) goto L99;
    L86:
        if (r114 == null) goto L108;
        r114.disconnect();     // Catch: Throwable -> L89
        throw r107;
    L89:
        th = move-exception;
        cd.a(th, "ht", "mgr");
        throw r107;
    L108:
        throw r107;
    L99:
        bj.a(r213);     // Catch: Throwable -> L85
        a(r113, true, 0, 0);     // Catch: Throwable -> L85
    L50:
        th = th;
    L81:
        r107 = th;
        r115 = true;
    L15:
        th = th;
    L40:
        th.printStackTrace();     // Catch: Throwable -> L80
        throw new bh("未知的错误");     // Catch: Throwable -> L80
    L28:
        e = e;
        r113 = r104;
    L44:
        r114 = null;
    L26:
        th = th;
        goto L40
    L80:
        th = th;
    L42:
        e = e;
        r113 = null;
    L37:
        th = th;
    L59:
        throw new bh("未知的错误");     // Catch: Throwable -> L80
    L79:
        throw new bh("http连接失败 - ConnectionException");     // Catch: Throwable -> L80
    L75:
        throw new bh(AMapException.AMAP_CLIENT_URL_EXCEPTION);     // Catch: Throwable -> L80
    L67:
        throw new bh("socket 连接异常 - SocketException");     // Catch: Throwable -> L80
    L63:
        throw new bh(AMapException.AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION);     // Catch: Throwable -> L80
    L71:
        throw new bh(AMapException.AMAP_CLIENT_UNKNOWHOST_EXCEPTION);     // Catch: Throwable -> L80
    L55:
        throw new bh(AMapException.AMAP_CLIENT_IO_EXCEPTION);     // Catch: Throwable -> L80
    }

    private a a(String r100, String r101, boolean r102, String r103, Map<String, String> r104, boolean r105, int r106) throws IOException, bh {
        String r107 = cu.a(a(r100, r101, r106), this.f26509p);
        b(r106);
        if (r104 != null) goto L5;
        r104 = new HashMap();
    L5:
        c r108 = this.f26505j.a();
        this.f26507n = r103;
        if (r102 == false) goto L11;
        if (TextUtils.isEmpty(r103) == true) goto L11;
        r108 = this.f26505j.a(r103);
    L11:
        if (r107.contains("/v3/iasdkauth") == false) goto L13;
    L17:
        String r109 = a(cs.f26476a, r107, r104);
        if (this.f26498c == false) goto L20;
        r109 = bo.a(r109);
    L20:
        URL r110 = new URL(r109);
        cs.a r111 = this.f26506l;
        if (r111 == null) goto L23;
        URLConnection r112 = r111.a();
    L24:
        if (r112 != null) goto L30;
        Proxy r113 = this.f26500e;
        if (r113 == null) goto L28;
        r112 = r110.openConnection(r113);
        goto L30
    L28:
        r112 = INVOKEVIRTUAL_com_amap_api_col_s_cv_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r110);
    L30:
        if (this.f26498c == false) goto L39;
        HttpsURLConnection r114 = (HttpsURLConnection) r112;
        if (bj.f.f26240a == false) goto L37;
        cw r115 = a();
        if (r115 == null) goto L36;
        r114.setSSLSocketFactory(r115);
        r115.a();
    L38:
        r114.setHostnameVerifier(r108);
        HttpURLConnection r116 = r114;
    L41:
        if (Build.VERSION.SDK == null) goto L43;
        r116.setRequestProperty("Connection", "close");
    L43:
        a(r104, r116);
        if (r105 == false) goto L46;
        r116.setRequestMethod("POST");
        r116.setUseCaches(false);
        r116.setDoInput(true);
        r116.setDoOutput(true);
    L48:
        return new a(r116, r106);
    L46:
        r116.setRequestMethod("GET");
        r116.setDoInput(true);
        goto L48
    L36:
        r114.setSSLSocketFactory(this.f26499d.getSocketFactory());
        goto L38
    L37:
        r114.setSSLSocketFactory(this.f26499d.getSocketFactory());
        goto L38
    L39:
        r116 = (HttpURLConnection) r112;
        goto L41
    L23:
        r112 = null;
        goto L24
    L13:
        if (TextUtils.isEmpty(this.f26509p) == true) goto L17;
        if (bj.a(this.f26509p) == false) goto L17;
        this.f26508o = true;
        r104.put("lct", String.valueOf(bj.c(this.f26509p)));
        goto L17
    }
}
