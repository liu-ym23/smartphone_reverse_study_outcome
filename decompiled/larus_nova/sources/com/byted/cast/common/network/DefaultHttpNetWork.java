package com.byted.cast.common.network;

import com.byted.cast.common.api.IHttpNetWork;
import com.byted.cast.common.api.Response;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.larus.utils.logger.FLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class DefaultHttpNetWork implements IHttpNetWork {
    private int timeOut;

    public DefaultHttpNetWork() {
        this.timeOut = 10000;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_byted_cast_common_network_DefaultHttpNetWork_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
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

    private String is2String(InputStream r100) throws IOException {
        BufferedReader r101 = new BufferedReader(new InputStreamReader(r100, XML.CHARSET_UTF8));
        StringBuilder r102 = new StringBuilder();
    L3:
        String r103 = r101.readLine();
        if (r103 == null) goto L7;
        r102.append(r103);
        goto L3
    L7:
        return r102.toString().trim();
    }

    public void setTimeOut(int r100) {
        this.timeOut = r100;
    }

    @Override // com.byted.cast.common.api.IHttpNetWork
    public Response doGet(String r100, Map<String, String> r101) throws Exception {
        HttpsURLConnection r102 = (HttpsURLConnection) INVOKEVIRTUAL_com_byted_cast_common_network_DefaultHttpNetWork_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r100));
        r102.setRequestMethod("GET");
        if (r101 == null) goto L8;
        Iterator<Map.Entry<String, String>> r103 = r101.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<String, String> r104 = r103.next();
        r102.setRequestProperty(r104.getKey(), r104.getValue());
    L8:
        r102.setConnectTimeout(this.timeOut);
        r102.setReadTimeout(this.timeOut);
        r102.setDoInput(true);
        r102.setUseCaches(false);
        r102.connect();
        int r105 = r102.getResponseCode();
        String r106 = r102.getResponseMessage();
        if (r105 != 200) goto L11;
        String r107 = is2String(r102.getInputStream());
    L13:
        return new Response(null, r107, r105, r106);
    L11:
        r107 = null;
        goto L13
    }

    @Override // com.byted.cast.common.api.IHttpNetWork
    public Response doPost(String r100, String r101, Map<String, String> r102) throws Exception {
        HttpsURLConnection r103 = (HttpsURLConnection) INVOKEVIRTUAL_com_byted_cast_common_network_DefaultHttpNetWork_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r100));
        r103.setRequestMethod("POST");
        if (r102 == null) goto L8;
        Iterator<Map.Entry<String, String>> r104 = r102.entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        Map.Entry<String, String> r105 = r104.next();
        r103.setRequestProperty(r105.getKey(), r105.getValue());
    L8:
        r103.setConnectTimeout(this.timeOut);
        r103.setReadTimeout(this.timeOut);
        r103.setDoInput(true);
        r103.setDoOutput(true);
        r103.setUseCaches(false);
        r103.getOutputStream().write(r101.getBytes("UTF-8"));
        r103.connect();
        int r106 = r103.getResponseCode();
        String r107 = r103.getResponseMessage();
        if (r106 >= 400) goto L11;
        InputStream r108 = r103.getInputStream();     // Catch: Exception -> L14
    L12:
        String r109 = is2String(r108);     // Catch: Exception -> L14
    L17:
        return new Response(null, r109, r106, r107);
    L11:
        r108 = r103.getErrorStream();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        r109 = null;
        goto L17
    }
}
