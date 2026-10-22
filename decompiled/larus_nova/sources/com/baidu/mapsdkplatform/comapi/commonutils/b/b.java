package com.baidu.mapsdkplatform.comapi.commonutils.b;

import com.baidu.mapapi.http.HttpClient;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import me.ele.lancet.base.annotations.Skip;
import x.i;

/* JADX INFO: loaded from: classes39.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f32057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f32058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.commonutils.b.a f32059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c.InterfaceC0643c f32060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f32061e;

    public static class a implements HostnameVerifier {
        public a() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String r100, SSLSession r101) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(r100, r101);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com_baidu_mapsdkplatform_comapi_commonutils_b_b_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void com_baidu_mapsdkplatform_comapi_commonutils_b_b__run$___twin___() {
        InputStream r100 = null;
        URL r101 = new URL(this.f32057a);     // Catch: Throwable -> L25 Exception -> L27
        if (HttpClient.isHttpsEnable == false) goto L6;
        HttpsURLConnection r102 = (HttpsURLConnection) INVOKEVIRTUAL_com_baidu_mapsdkplatform_comapi_commonutils_b_b_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r101);     // Catch: Throwable -> L25 Exception -> L27
        r102.setHostnameVerifier(new a());     // Catch: Throwable -> L25 Exception -> L27
        HttpURLConnection r103 = r102;
    L7:
        r103.setRequestMethod("GET");     // Catch: Throwable -> L25 Exception -> L27
        r103.setConnectTimeout(10000);     // Catch: Throwable -> L25 Exception -> L27
        r103.setReadTimeout(10000);     // Catch: Throwable -> L25 Exception -> L27
        r103.setRequestProperty("Range", "bytes=" + this.f32059c.b() + "-" + this.f32059c.a());     // Catch: Throwable -> L25 Exception -> L27
        r103.setRequestProperty("Connection", HTTP.KEEP_ALIVE);     // Catch: Throwable -> L25 Exception -> L27
        RandomAccessFile r104 = new RandomAccessFile(this.f32058b, "rw");     // Catch: Throwable -> L25 Exception -> L27
        r104.seek(this.f32059c.b());     // Catch: Exception -> L50 Throwable -> L39
        int r105 = r103.getResponseCode();     // Catch: Exception -> L50 Throwable -> L39
        if (r105 != 200) goto L13;
    L14:
        byte[] r106 = new byte[1048576];     // Catch: Exception -> L50 Throwable -> L39
        r100 = r103.getInputStream();     // Catch: Exception -> L50 Throwable -> L39
    L15:
        int r107 = r100.read(r106);     // Catch: Exception -> L50 Throwable -> L39
        if (r107 == (-1)) goto L18;
        r104.write(r106, 0, r107);     // Catch: Exception -> L50 Throwable -> L39
    L18:
        this.f32061e = true;     // Catch: Exception -> L50 Throwable -> L39
        if (r100 != null) goto L58;
    L21:
        r104.close();     // Catch: IOException -> L23
    L37:
        this.f32060d.a(this);
        return;
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L37
    L58:
        r100.close();     // Catch: IOException -> L23
        goto L21
    L13:
        if (r105 != 206) goto L18;
    L28:
        this.f32061e = false;     // Catch: Throwable -> L39
        this.f32060d.b(this);     // Catch: Throwable -> L39
        if (r100 != null) goto L52;
    L33:
        if (r104 == null) goto L37;
        r104.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L37
    L52:
        r100.close();     // Catch: IOException -> L31
        goto L33
    L6:
        r103 = (HttpURLConnection) INVOKEVIRTUAL_com_baidu_mapsdkplatform_comapi_commonutils_b_b_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r101);     // Catch: Throwable -> L25 Exception -> L27
    L39:
        th = move-exception;
        i r108 = "bytes=";
        th = th;
    L41:
        if (0 != 0) goto L56;
    L45:
        if (r108 == 0) goto L62;
        r108.close();     // Catch: IOException -> L43
        throw th;
    L43:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L62:
        throw th;
    L56:
        r100.close();     // Catch: IOException -> L43
    L27:
        r104 = null;
    L25:
        th = th;
        r108 = 0;
        goto L41
    }

    public boolean a() {
        return this.f32061e;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_baidu_mapsdkplatform_comapi_commonutils_b_b_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
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

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_baidu_mapsdkplatform_comapi_commonutils_b_b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
        r100.com_baidu_mapsdkplatform_comapi_commonutils_b_b__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(String r100, File r101, com.baidu.mapsdkplatform.comapi.commonutils.b.a r102, c.InterfaceC0643c r103) {
        this.f32061e = false;
        this.f32057a = r100;
        this.f32058b = r101;
        this.f32059c = r102;
        this.f32060d = r103;
    }
}
