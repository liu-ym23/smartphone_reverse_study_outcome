package com.alipay.sdk.m.o;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.i;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.utils.logger.FLogger;
import f06.d;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25636a = "msp";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f25637b = "application/octet-stream;binary/octet-stream";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CookieManager f25638c = null;

    /* JADX INFO: renamed from: com.alipay.sdk.m.o.a$a, reason: collision with other inner class name */
    public static final class C0489a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f25639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f25640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, String> f25641c;

        public String toString() {
            return String.format("<UrlConnectionConfigure url=%s headers=%s>", new Object[]{this.f25639a, this.f25641c});
        }

        public C0489a(String r100, Map<String, String> r101, byte[] r102) {
            this.f25639a = r100;
            this.f25640b = r102;
            this.f25641c = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, List<String>> f25642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f25643b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f25644c;

        public b(Map<String, List<String>> r100, String r101, byte[] r102) {
            this.f25642a = r100;
            this.f25643b = r101;
            this.f25644c = r102;
        }
    }

    static {
        f25638c = new CookieManager();
    }

    public a() {
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_alipay_sdk_m_o_a_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
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

    public static String a(Context r100) {
        NetworkInfo r101 = com.alipay.sdk.m.w.b.a(null, r100);     // Catch: Exception -> L15
        if (r101 == null) goto L14;
        if (r101.isAvailable() == false) goto L14;
        if (r101.getType() != 1) goto L12;
        return "wifi";
    L12:
        return com_alipay_sdk_m_o_a_android_net_NetworkInfo_getExtraInfo(r101).toLowerCase();
    L14:
        return "none";
    }

    public static Proxy b(Context r100) {
        String r101 = a(r100);
        if (r101 != null) goto L5;
    L13:
        String r102 = System.getProperty("https.proxyHost");     // Catch: Throwable -> L12
        String r103 = System.getProperty("https.proxyPort");     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r102) == true) goto L15;
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(r102, Integer.parseInt(r103)));
    L15:
        return null;
    L16:
        return null;
    L5:
        if (r101.contains("wap") == true) goto L13;
        return null;
    }

    private static String com_alipay_sdk_m_o_a_android_net_NetworkInfo_getExtraInfo(NetworkInfo r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102026);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        d r106 = r105.preInvoke(102026, "android/net/NetworkInfo", "getExtraInfo", r110, r111, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (String) r106.f474983b;
    L21:
        return r110.getExtraInfo();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static byte[] a(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        byte[] r102 = new byte[1024];
    L3:
        int r103 = r100.read(r102, 0, 1024);
        if (r103 == (-1)) goto L6;
        r101.write(r102, 0, r103);
        goto L3
    L6:
        r101.flush();
        return r101.toByteArray();
    }

    public static b a(Context r110, C0489a r111) {
        if (r110 != null) goto L122;
        return null;
    L122:
        e.d(com.alipay.sdk.m.l.a.A, "conn config: " + r111);     // Catch: Throwable -> L73
        URL r100 = new URL(r111.f25639a);     // Catch: Throwable -> L73
        Proxy r112 = b(r110);     // Catch: Throwable -> L73
        e.d(com.alipay.sdk.m.l.a.A, "conn proxy: " + r112);     // Catch: Throwable -> L73
        if (r112 == null) goto L8;
        HttpURLConnection r113 = (HttpURLConnection) r100.openConnection(r112);     // Catch: Throwable -> L73
    L120:
        System.setProperty("http.keepAlive", "false");     // Catch: Throwable -> L71
        if ((r113 instanceof HttpsURLConnection) == false) goto L12;
        HttpsURLConnection r101 = (HttpsURLConnection) r113;     // Catch: Throwable -> L71
    L12:
        CookieManager r102 = f25638c;     // Catch: Throwable -> L71
        if (r102.getCookieStore().getCookies().size() > 0) goto L15;
    L16:
        r113.setConnectTimeout(20000);     // Catch: Throwable -> L71
        r113.setReadTimeout(30000);     // Catch: Throwable -> L71
        r113.setInstanceFollowRedirects(true);     // Catch: Throwable -> L71
        r113.setRequestProperty("User-Agent", f25636a);     // Catch: Throwable -> L71
        byte[] r103 = r111.f25640b;     // Catch: Throwable -> L71
        if (r103 != null) goto L20;
    L22:
        r113.setRequestMethod("GET");     // Catch: Throwable -> L71
    L23:
        Map<String, String> r104 = r111.f25641c;     // Catch: Throwable -> L71
        if (r104 == null) goto L32;
        Iterator<Map.Entry<String, String>> r105 = r104.entrySet().iterator();     // Catch: Throwable -> L71
    L27:
        if (r105.hasNext() == false) goto L32;
        Map.Entry<String, String> r106 = r105.next();     // Catch: Throwable -> L71
        if (r106.getKey() == null) goto L27;
        r113.setRequestProperty(r106.getKey(), r106.getValue());     // Catch: Throwable -> L71
    L32:
        r113.setDoInput(true);     // Catch: Throwable -> L71
        if ("POST".equals(r113.getRequestMethod()) == false) goto L36;
        r113.setDoOutput(true);     // Catch: Throwable -> L71
    L36:
        if ("POST".equals(r113.getRequestMethod()) == false) goto L39;
        BufferedOutputStream r107 = new BufferedOutputStream(r113.getOutputStream());     // Catch: Throwable -> L71
        r107.write(r111.f25640b);     // Catch: Throwable -> L69
        r107.flush();     // Catch: Throwable -> L69
    L40:
        BufferedInputStream r114 = new BufferedInputStream(r113.getInputStream());     // Catch: Throwable -> L69
        byte[] r108 = a(r114);     // Catch: Throwable -> L67
        Map<String, List<String>> r109 = r113.getHeaderFields();     // Catch: Throwable -> L67
        if (r109 != null) goto L44;
    L47:
        String r115 = null;
    L48:
        List<String> r116 = r109.get("Set-Cookie");     // Catch: Throwable -> L67
        if (r116 == null) goto L59;
        Iterator<String> r117 = r116.iterator();     // Catch: Throwable -> L67
    L52:
        if (r117.hasNext() == false) goto L59;
        List<HttpCookie> r118 = HttpCookie.parse(r117.next());     // Catch: Throwable -> L67
        if (r118 == null) goto L52;
        if (r118.isEmpty() == true) goto L52;
        f25638c.getCookieStore().add(r100.toURI(), r118.get(0));     // Catch: Throwable -> L67
    L59:
        b r119 = new b(r109, r115, r108);     // Catch: Throwable -> L67
        r113.disconnect();     // Catch: Throwable -> L100
    L106:
        r114.close();     // Catch: Throwable -> L63
    L64:
        if (r107 != null) goto L110;
    L66:
        return r119;
    L110:
        r107.close();     // Catch: Throwable -> L101
        goto L66
    L44:
        if (r109.get(null) == null) goto L47;
        r115 = TextUtils.join(",", r109.get(null));     // Catch: Throwable -> L67
    L67:
        Throwable th10 = th;
    L118:
        e.a(th10);     // Catch: Throwable -> L88
        if (r113 != null) goto L129;
    L81:
        if (r114 != null) goto L108;
    L85:
        if (r107 != null) goto L116;
    L87:
        return null;
    L116:
        r107.close();     // Catch: Throwable -> L102
        goto L87
    L108:
        r114.close();     // Catch: Throwable -> L84
        goto L85
    L129:
        r113.disconnect();     // Catch: Throwable -> L80
    L88:
        th = move-exception;
        if (r113 != null) goto L123;
    L93:
        if (r114 != null) goto L125;
    L97:
        if (r107 == null) goto L145;
        r107.close();     // Catch: Throwable -> L103
        throw th;
    L146:
        throw th;
    L145:
        throw th;
    L125:
        r114.close();     // Catch: Throwable -> L96
        goto L97
    L123:
        r113.disconnect();     // Catch: Throwable -> L92
    L69:
        th = move-exception;
        th10 = th;
        r114 = null;
        goto L118
    L39:
        r107 = null;
        goto L40
    L20:
        if (r103.length <= 0) goto L22;
        r113.setRequestMethod("POST");     // Catch: Throwable -> L71
        r113.setRequestProperty("Content-Type", f25637b);     // Catch: Throwable -> L71
        r113.setRequestProperty("Accept-Charset", "UTF-8");     // Catch: Throwable -> L71
        r113.setRequestProperty("Connection", HTTP.KEEP_ALIVE);     // Catch: Throwable -> L71
        r113.setRequestProperty(HTTP.KEEP_ALIVE, "timeout=180, max=100");     // Catch: Throwable -> L71
        goto L23
    L15:
        r113.setRequestProperty("Cookie", TextUtils.join(i.f25853b, r102.getCookieStore().getCookies()));     // Catch: Throwable -> L71
    L71:
        Throwable th11 = th;
    L75:
        th10 = th11;
        r114 = null;
        r107 = null;
        goto L118
    L8:
        r113 = (HttpURLConnection) INVOKEVIRTUAL_com_alipay_sdk_m_o_a_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r100);     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        th11 = th;
        r113 = null;
        goto L75
    }
}
