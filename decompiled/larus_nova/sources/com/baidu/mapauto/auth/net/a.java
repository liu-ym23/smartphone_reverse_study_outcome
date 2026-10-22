package com.baidu.mapauto.auth.net;

import android.text.TextUtils;
import com.alipay.sdk.m.p.e;
import com.baidu.mapauto.auth.util.LogUtil;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public final class a implements com.baidu.mapauto.auth.net.base.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f31791b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ boolean f31792c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f31793a;

    static {
        f31792c = true;
        f31791b = BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY;
    }

    public a() {
    }

    public a(c r100) {
        this.f31793a = r100;
    }

    public static String a(InputStream r100) {
        BufferedReader r101 = new BufferedReader(new InputStreamReader(r100));     // Catch: Exception -> L16
        StringWriter r102 = new StringWriter();     // Catch: Throwable -> L10
        char[] r103 = new char[8192];     // Catch: Throwable -> L10
    L4:
        int r104 = r101.read(r103);     // Catch: Throwable -> L10
        if (r104 < 0) goto L7;
        r102.write(r103, 0, r104);     // Catch: Throwable -> L10
        goto L4
    L7:
        String r105 = r102.toString();     // Catch: Throwable -> L10
        r101.close();     // Catch: Exception -> L16
        return r105;
    L10:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L13
    L15:
        throw th;     // Catch: Exception -> L16
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L16
    L16:
        return null;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_baidu_mapauto_auth_net_a_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
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

    public final b a(String r110, HashMap r111) throws Exception {
        com.baidu.mapauto.auth.net.format.a r100 = new com.baidu.mapauto.auth.net.format.a();
        HttpURLConnection r101 = null;
        c r102 = this.f31793a;     // Catch: Throwable -> L79
        if (f31792c == false) goto L7;
    L13:
        if (r102 == null) goto L78;
        String r103 = r102.f31799b;     // Catch: Throwable -> L79
        boolean r104 = false;
        if (TextUtils.isEmpty(r103) == false) goto L19;
    L23:
        boolean r105 = false;
    L25:
        if (r105 == false) goto L76;
        String r112 = r102.f31799b + r110;     // Catch: Throwable -> L79
        if ("POST".equals("GET") == true) goto L29;
    L31:
        URL r106 = new URL(r112);     // Catch: Throwable -> L79
        if (r112.startsWith("https") == false) goto L34;
    L35:
        r104 = true;
    L36:
        if (r104 == false) goto L44;
        HttpsURLConnection r107 = (HttpsURLConnection) INVOKEVIRTUAL_com_baidu_mapauto_auth_net_a_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r106);     // Catch: Throwable -> L79
        HostnameVerifier r108 = r102.f31801d;     // Catch: Throwable -> L42
        HttpURLConnection r109 = r107;
        if (r108 == null) goto L45;
        r107.setHostnameVerifier(r108);     // Catch: Throwable -> L42
        r109 = r107;
    L45:
        r101 = r109;
        r101.setRequestMethod("POST");     // Catch: Throwable -> L79
        if ("POST".equals("POST") == false) goto L48;
        r101.setDoInput(true);     // Catch: Throwable -> L79
    L48:
        r101.setDoOutput(true);     // Catch: Throwable -> L79
        r101.setReadTimeout(r102.f31798a);     // Catch: Throwable -> L79
        r101.setConnectTimeout(5000);     // Catch: Throwable -> L79
        Map<String, Object> r113 = r102.f31800c;     // Catch: Throwable -> L79
        if (r113 == null) goto L55;
        Iterator<String> r114 = r113.keySet().iterator();     // Catch: Throwable -> L79
    L52:
        if (r114.hasNext() == false) goto L55;
        String r115 = r114.next();     // Catch: Throwable -> L79
        Object r116 = r113.get(r115);     // Catch: Throwable -> L79
        Objects.requireNonNull(r116);     // Catch: Throwable -> L79
        r101.setRequestProperty(r115, r116.toString());     // Catch: Throwable -> L79
    L55:
        if ("POST".equals("POST") == true) goto L57;
    L58:
        LogUtil r117 = LogUtil.getInstance();     // Catch: Throwable -> L79
        String r118 = f31791b;     // Catch: Throwable -> L79
        r117.i(r118, "请求地址: " + r112);     // Catch: Throwable -> L79
        LogUtil.getInstance().i(r118, "请求方式: POST");     // Catch: Throwable -> L79
        LogUtil.getInstance().i(r118, "请求头: " + r113);     // Catch: Throwable -> L79
        LogUtil.getInstance().i(r118, "请求参数: " + r111);     // Catch: Throwable -> L79
        if ("POST".equals("POST") == false) goto L70;
        OutputStream r119 = r101.getOutputStream();     // Catch: Throwable -> L79
        String r120 = r100.a(r111);     // Catch: Throwable -> L79
        DataOutputStream r121 = new DataOutputStream(r119);     // Catch: Throwable -> L79
        r121.writeBytes(r120);     // Catch: Throwable -> L64
        r121.flush();     // Catch: Throwable -> L64
        r121.close();     // Catch: Throwable -> L79
        goto L70
    L64:
        th = move-exception;
        r121.close();     // Catch: Throwable -> L67
    L69:
        throw th;     // Catch: Throwable -> L79
    L67:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L79
    L70:
        r101.connect();     // Catch: Throwable -> L79
        b r122 = new b();     // Catch: Throwable -> L79
        int r123 = r101.getResponseCode();     // Catch: Throwable -> L79
        r122.f31794a = Integer.valueOf(r123);     // Catch: Throwable -> L79
        r122.f31795b = r101.getResponseMessage();     // Catch: Throwable -> L79
        if (r123 != 200) goto L73;
        r122.f31796c = a(r101.getInputStream());     // Catch: Throwable -> L79
    L73:
        r101.disconnect();
        return r122;
    L57:
        r101.setRequestProperty(e.f25658f, "multipart/form-data; boundary=" + com.baidu.mapauto.auth.net.format.a.f31806a);     // Catch: Throwable -> L79
    L42:
        th = th;
        r101 = r107;
    L80:
        if (r101 == null) goto L82;
        r101.disconnect();
    L82:
        throw th;
    L44:
        r109 = (HttpURLConnection) INVOKEVIRTUAL_com_baidu_mapauto_auth_net_a_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r106);     // Catch: Throwable -> L79
        goto L45
    L34:
        if (r112.startsWith("HTTPS") == false) goto L36;
    L29:
        if (r111.isEmpty() == true) goto L31;
        r112 = "?" + r100.a(r111);     // Catch: Throwable -> L79
        goto L31
    L76:
        throw new IllegalArgumentException("net config 检验失败");     // Catch: Throwable -> L79
    L19:
        if (r103.startsWith("https") == false) goto L21;
    L24:
        r105 = true;
        goto L25
    L21:
        if (r103.startsWith("HTTPS") == false) goto L23;
    L78:
        throw new IllegalArgumentException("net config 不能为空");     // Catch: Throwable -> L79
    L7:
        if ("POST".equals("POST") == true) goto L13;
        if ("POST".equals("GET") == true) goto L13;
        throw new AssertionError();     // Catch: Throwable -> L79
    L79:
        th = th;
        goto L80
    }
}
