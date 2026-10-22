package com.baidu.lbsapi.auth;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.utils.logger.FLogger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f30461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f30462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap f30463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f30464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f30465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f30466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f30467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f30468h;

    public i(Context r100) {
        this.f30462b = null;
        this.f30463c = null;
        this.f30464d = null;
        this.f30466f = -1;
        this.f30461a = r100;
    }

    private String a(Context r100) {
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Exception -> L47
        if (r101 != null) goto L8;
        return null;
    L8:
        if (Build.VERSION.SDK_INT < 29) goto L25;
        NetworkCapabilities r102 = r101.getNetworkCapabilities(r101.getActiveNetwork());     // Catch: Exception -> L47
        if (r102 == null) goto L53;
        boolean r103 = r102.hasTransport(1);     // Catch: Exception -> L47
        boolean r104 = r102.hasTransport(0);     // Catch: Exception -> L47
        boolean r105 = r102.hasTransport(3);     // Catch: Exception -> L47
        boolean r106 = r102.hasTransport(6);     // Catch: Exception -> L47
        boolean r107 = r102.hasTransport(4);     // Catch: Exception -> L47
        boolean r108 = r102.hasTransport(5);     // Catch: Exception -> L47
        if (r103 == true) goto L54;
        if (r104 == true) goto L55;
        if (r105 == true) goto L56;
        if (r106 == true) goto L57;
        if (r107 == true) goto L58;
        if (r108 == false) goto L59;
        return "WifiAware";
    L59:
        return "wifi";
    L58:
        return "VPN";
    L57:
        return "LoWPAN";
    L56:
        return "ETHERNET";
    L55:
        return "CELLULAR";
    L54:
        return "WIFI";
    L53:
        return "wifi";
    L25:
        NetworkInfo r109 = r101.getActiveNetworkInfo();     // Catch: Exception -> L47
        if (r109 != null) goto L28;
    L46:
        return null;
    L28:
        if (r109.isAvailable() == false) goto L46;
        String r110 = com_baidu_lbsapi_auth_i_android_net_NetworkInfo_getExtraInfo(r109);     // Catch: Exception -> L47
        if (r110 == null) goto L45;
        if (r110.trim().toLowerCase().equals("cmwap") == true) goto L42;
        if (r110.trim().toLowerCase().equals("uniwap") == true) goto L42;
        if (r110.trim().toLowerCase().equals("3gwap") == true) goto L42;
        if (r110.trim().toLowerCase().equals("ctwap") == false) goto L45;
    L42:
        if (r110.trim().toLowerCase().equals("ctwap") == true) goto L61;
        return "cmwap";
    L61:
        return "ctwap";
    L45:
        return "wifi";
    L47:
        e = move-exception;
        if (b.f30442a == false) goto L51;
        e.printStackTrace();
    L51:
        return null;
    }

    public static /* synthetic */ String a(i r100) {
        return r100.f30467g;
    }

    private static String a(HashMap r100) throws UnsupportedEncodingException {
        StringBuilder r101 = new StringBuilder();
        Iterator r102 = r100.entrySet().iterator();
        boolean r103 = true;
    L4:
        if (r102.hasNext() == false) goto L11;
        Map.Entry r104 = (Map.Entry) r102.next();
        if (r103 == false) goto L8;
        r103 = false;
    L9:
        r101.append(URLEncoder.encode((String) r104.getKey(), "UTF-8"));
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r101.append(URLEncoder.encode((String) r104.getValue(), "UTF-8"));
        goto L4
    L8:
        r101.append("&");
        goto L9
    L11:
        return r101.toString();
    }

    private void a(HttpsURLConnection r110) {
        b.a("https Post start,url:" + this.f30462b);
        if (this.f30463c != null) goto L6;
        this.f30464d = ErrorMessage.a("httpsPost request paramters is null.");
        return;
    L6:
        OutputStream r100 = null;
        BufferedReader r111 = null;
        r111 = null;
        BufferedReader r101 = null;
        InputStream r102 = null;
        r102 = null;
        OutputStream r103 = null;
        OutputStream r104 = null;
        OutputStream r105 = null;
        boolean r106 = false;
        OutputStream r107 = r110.getOutputStream();     // Catch: Throwable -> L79 Exception -> L81 IOException -> L94 MalformedURLException -> L107
        BufferedWriter r108 = new BufferedWriter(new OutputStreamWriter(r107, "UTF-8"));     // Catch: Throwable -> L71 Exception -> L73 IOException -> L75 MalformedURLException -> L77
        r108.write(a(this.f30463c));     // Catch: Throwable -> L71 Exception -> L73 IOException -> L75 MalformedURLException -> L77
        b.a(a(this.f30463c));     // Catch: Throwable -> L71 Exception -> L73 IOException -> L75 MalformedURLException -> L77
        r108.flush();     // Catch: Throwable -> L71 Exception -> L73 IOException -> L75 MalformedURLException -> L77
        r108.close();     // Catch: Throwable -> L71 Exception -> L73 IOException -> L75 MalformedURLException -> L77
        r110.connect();     // Catch: Throwable -> L71 Exception -> L73 IOException -> L75 MalformedURLException -> L77
        InputStream r109 = r110.getInputStream();     // Catch: Throwable -> L38 IOException -> L41
    L158:
        int r112 = r110.getResponseCode();     // Catch: Throwable -> L34 IOException -> L36
        if (200 == r112) goto L154;
    L29:
        if (r109 == null) goto L32;
        if (r101 == null) goto L32;
        r101.close();     // Catch: Exception -> L65 IOException -> L67 MalformedURLException -> L69 Throwable -> L71
        r109.close();     // Catch: Exception -> L65 IOException -> L67 MalformedURLException -> L69 Throwable -> L71
    L32:
        r110.disconnect();     // Catch: Exception -> L65 IOException -> L67 MalformedURLException -> L69 Throwable -> L71
        r106 = true;
    L52:
        if (r107 != null) goto L140;
    L120:
        if (r106 == false) goto L125;
        if (200 == r112) goto L125;
        b.a("httpsPost failed,statusCode:" + r112);
        this.f30464d = ErrorMessage.a(-11, "httpsPost failed,statusCode:" + r112);
        return;
    L125:
        if (this.f30464d != null) goto L128;
        b.a("httpsPost failed,mResult is null");
        this.f30464d = ErrorMessage.a(-1, "httpsPost failed,internal error");
        return;
    L128:
        b.a("httpsPost success end,parse result = " + this.f30464d);
        return;
    L140:
        r107.close();     // Catch: IOException -> L55
    L55:
        e = e;
        if (b.f30442a == false) goto L120;
    L58:
        e.printStackTrace();
        goto L120
    L154:
        r111 = new BufferedReader(new InputStreamReader(r109, "UTF-8"));     // Catch: Throwable -> L23 IOException -> L26
        StringBuffer r113 = new StringBuffer();     // Catch: Throwable -> L19 IOException -> L21
    L14:
        int r114 = r111.read();     // Catch: Throwable -> L19 IOException -> L21
        if (r114 == (-1)) goto L17;
        r113.append((char) r114);     // Catch: Throwable -> L19 IOException -> L21
        goto L14
    L17:
        this.f30464d = r113.toString();     // Catch: Throwable -> L19 IOException -> L21
        r101 = r111;
        goto L29
    L21:
        e = e;
    L28:
        r102 = r109;
    L138:
    L59:
        th = th;
    L60:
        if (r102 == null) goto L63;
        if (r111 == null) goto L63;
        r111.close();     // Catch: Exception -> L65 IOException -> L67 MalformedURLException -> L69 Throwable -> L71
        r102.close();     // Catch: Exception -> L65 IOException -> L67 MalformedURLException -> L69 Throwable -> L71
    L63:
        r110.disconnect();     // Catch: Exception -> L65 IOException -> L67 MalformedURLException -> L69 Throwable -> L71
        throw th;     // Catch: Exception -> L65 IOException -> L67 MalformedURLException -> L69 Throwable -> L71
    L45:
        if (b.f30442a == false) goto L47;
        e.printStackTrace();     // Catch: Throwable -> L59
        b.a("httpsPost parse failed;" + e.getMessage());     // Catch: Throwable -> L59
    L47:
        this.f30464d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());     // Catch: Throwable -> L59
        if (r102 == null) goto L51;
        if (r111 == null) goto L51;
        r111.close();     // Catch: Exception -> L65 IOException -> L67 MalformedURLException -> L69 Throwable -> L71
        r102.close();     // Catch: Exception -> L65 IOException -> L67 MalformedURLException -> L69 Throwable -> L71
    L51:
        r110.disconnect();     // Catch: Exception -> L65 IOException -> L67 MalformedURLException -> L69 Throwable -> L71
    L19:
        th = th;
    L25:
        r102 = r109;
        goto L60
    L26:
        e = e;
        r111 = null;
    L23:
        th = th;
        r111 = null;
        goto L25
    L36:
        e = e;
        r102 = r109;
    L43:
        r112 = -1;
    L34:
        th = th;
        r102 = r109;
    L41:
        e = e;
    L38:
        th = th;
        goto L60
    L71:
        th = th;
        r103 = r107;
    L130:
        if (r103 != null) goto L147;
    L137:
        throw th;
    L147:
        r103.close();     // Catch: IOException -> L133
    L133:
        e = move-exception;
        if (b.f30442a == false) goto L137;
        e.printStackTrace();
    L69:
        e = e;
        r104 = r107;
    L110:
        if (b.f30442a == false) goto L112;
        e.printStackTrace();     // Catch: Throwable -> L79
    L112:
        this.f30464d = ErrorMessage.a(-11, "httpsPost failed,MalformedURLException:" + e.getMessage());     // Catch: Throwable -> L79
        if (r104 == null) goto L120;
        r104.close();     // Catch: IOException -> L116
    L116:
        e = e;
        if (b.f30442a == false) goto L120;
    L67:
        e = e;
        r105 = r107;
    L97:
        if (b.f30442a == false) goto L99;
        e.printStackTrace();     // Catch: Throwable -> L79
    L99:
        this.f30464d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());     // Catch: Throwable -> L79
        if (r105 == null) goto L120;
        r105.close();     // Catch: IOException -> L103
    L103:
        e = e;
        if (b.f30442a == false) goto L120;
    L65:
        e = e;
        r100 = r107;
    L84:
        if (b.f30442a == false) goto L86;
        e.printStackTrace();     // Catch: Throwable -> L79
    L86:
        this.f30464d = ErrorMessage.a(-11, "httpsPost failed,Exception:" + e.getMessage());     // Catch: Throwable -> L79
        if (r100 == null) goto L120;
        r100.close();     // Catch: IOException -> L90
    L90:
        e = e;
        if (b.f30442a == false) goto L120;
    L77:
        e = e;
        r104 = r107;
    L108:
        r112 = -1;
    L75:
        e = e;
        r105 = r107;
    L95:
        r112 = -1;
    L73:
        e = e;
        r100 = r107;
    L82:
        r112 = -1;
        goto L84
    L79:
        th = th;
    L107:
        e = e;
    L94:
        e = e;
    L81:
        e = e;
        goto L82
    }

    public static /* synthetic */ String b(i r100) {
        return r100.f30468h;
    }

    private HashMap b(HashMap r100) {
        HashMap r101 = new HashMap();
        Iterator r102 = r100.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = ((String) r102.next()).toString();
        r101.put(r103, (String) r100.get(r103));
        goto L4
    L6:
        return r101;
    }

    private HttpsURLConnection b() {
        URL r100 = new URL(this.f30462b);     // Catch: Exception -> L19 MalformedURLException -> L26
        b.a("https URL: " + this.f30462b);     // Catch: Exception -> L19 MalformedURLException -> L26
        String r101 = a(this.f30461a);     // Catch: Exception -> L19 MalformedURLException -> L26
        if (r101 != null) goto L6;
    L17:
        b.c("Current network is not available.");     // Catch: Exception -> L19 MalformedURLException -> L26
        this.f30464d = ErrorMessage.a(-10, "Current network is not available.");     // Catch: Exception -> L19 MalformedURLException -> L26
        return null;
    L6:
        if (r101.equals("") == true) goto L17;
        if (TextUtils.isEmpty(this.f30465e) == false) goto L11;
    L14:
        b.a("checkNetwork = ".concat(r101));     // Catch: Exception -> L19 MalformedURLException -> L26
        URLConnection r102 = INVOKEVIRTUAL_com_baidu_lbsapi_auth_i_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r100);     // Catch: Exception -> L19 MalformedURLException -> L26
    L13:
        HttpsURLConnection r103 = (HttpsURLConnection) r102;     // Catch: Exception -> L19 MalformedURLException -> L26
        r103.setHostnameVerifier(new k(this));     // Catch: Exception -> L19 MalformedURLException -> L26
        r103.setDoInput(true);     // Catch: Exception -> L19 MalformedURLException -> L26
        r103.setDoOutput(true);     // Catch: Exception -> L19 MalformedURLException -> L26
        r103.setRequestMethod("POST");     // Catch: Exception -> L19 MalformedURLException -> L26
        r103.setConnectTimeout(50000);     // Catch: Exception -> L19 MalformedURLException -> L26
        r103.setReadTimeout(50000);     // Catch: Exception -> L19 MalformedURLException -> L26
        return r103;
    L11:
        if (this.f30466f == (-1)) goto L14;
        b.a("Proxy mProxyHost: = " + this.f30465e + " mProxyPort: " + this.f30466f);     // Catch: Exception -> L19 MalformedURLException -> L26
        Proxy r104 = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(this.f30465e, this.f30466f));     // Catch: Exception -> L19 MalformedURLException -> L26
        Authenticator.setDefault(new j(this));     // Catch: Exception -> L19 MalformedURLException -> L26
        r102 = r100.openConnection(r104);     // Catch: Exception -> L19 MalformedURLException -> L26
    L26:
        e = move-exception;
        if (b.f30442a == false) goto L30;
        e.printStackTrace();
        b.a(e.getMessage());
    L30:
        String r105 = "Auth server could not be parsed as a URL.";
    L24:
        this.f30464d = ErrorMessage.a(-11, r105);
        return null;
    L19:
        e = move-exception;
        if (b.f30442a == false) goto L23;
        e.printStackTrace();
        b.a(e.getMessage());
    L23:
        r105 = "Init httpsurlconnection failed.";
        goto L24
    }

    public String a(HashMap r100, String r101, int r102, String r103, String r104) {
        HashMap r105 = b(r100);
        this.f30463c = r105;
        this.f30462b = (String) r105.get("url");
        this.f30465e = r101;
        this.f30466f = r102;
        this.f30467g = r103;
        this.f30468h = r104;
        HttpsURLConnection r106 = b();
        if (r106 != null) goto L7;
        b.c("syncConnect failed,httpsURLConnection is null");
    L6:
        return this.f30464d;
    L7:
        a(r106);
        goto L6
    }

    public boolean a() {
        b.a("checkNetwork start");
        ConnectivityManager r100 = (ConnectivityManager) this.f30461a.getSystemService("connectivity");     // Catch: Exception -> L24
        if (r100 != null) goto L7;
        return false;
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L16;
        NetworkCapabilities r101 = r100.getNetworkCapabilities(r100.getActiveNetwork());     // Catch: Exception -> L24
        if (r101 != null) goto L11;
    L15:
        return false;
    L11:
        if (r101.hasCapability(12) == false) goto L15;
        if (r101.hasCapability(16) == false) goto L15;
        return true;
    L16:
        NetworkInfo r102 = r100.getActiveNetworkInfo();     // Catch: Exception -> L24
        if (r102 != null) goto L19;
    L23:
        return false;
    L19:
        if (r102.isAvailable() == false) goto L23;
        b.a("checkNetwork end");
        return true;
    L24:
        e = move-exception;
        if (b.f30442a == false) goto L28;
        e.printStackTrace();
    L28:
        return false;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_baidu_lbsapi_auth_i_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
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

    private static String com_baidu_lbsapi_auth_i_android_net_NetworkInfo_getExtraInfo(NetworkInfo r110) {
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
        f06.d r106 = r105.preInvoke(102026, "android/net/NetworkInfo", "getExtraInfo", r110, r111, "java.lang.String", r112);     // Catch: Exception -> L22
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
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }
}
