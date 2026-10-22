package com.baidu.mapsdkplatform.comapi.commonutils.b;

import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExecutorService f32062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f32063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<com.baidu.mapsdkplatform.comapi.commonutils.b.b> f32064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f32065d;

    public static /* synthetic */ class a {
    }

    public class b implements InterfaceC0643c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private File f32066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f32067b;

        @Override // com.baidu.mapsdkplatform.comapi.commonutils.b.c.InterfaceC0643c
        public void a(com.baidu.mapsdkplatform.comapi.commonutils.b.b r100) {
            if (c.a(this.f32067b) != null) goto L5;
            return;
        L5:
            if (c.a(this.f32067b).size() == 0) goto L17;
            if (r100 != null) goto L9;
            return;
        L9:
            if (r100.a() == true) goto L11;
            return;
        L11:
            if (c.a(this.f32067b) == null) goto L19;
            c.a(this.f32067b).remove(r100);
            if (c.a(this.f32067b).size() != 0) goto L20;
            c.b(this.f32067b).a(this.f32066a);
            return;
        L20:
            return;
        L19:
            return;
        }

        @Override // com.baidu.mapsdkplatform.comapi.commonutils.b.c.InterfaceC0643c
        public void b(com.baidu.mapsdkplatform.comapi.commonutils.b.b r100) {
            if (c.a(this.f32067b) != null) goto L5;
            return;
        L5:
            if (c.a(this.f32067b).size() == 0) goto L13;
            if (r100 == null) goto L15;
            c.a(this.f32067b).clear();
            if (c.b(this.f32067b) == null) goto L14;
            c.b(this.f32067b).a();
            return;
        L14:
            return;
        L15:
            return;
        }

        private b(c r100, File r101) {
            this.f32067b = r100;
            this.f32066a = r101;
        }

        public /* synthetic */ b(c r100, File r101, a r102) {
            this(r100, r101);
        }
    }

    /* JADX INFO: renamed from: com.baidu.mapsdkplatform.comapi.commonutils.b.c$c, reason: collision with other inner class name */
    public interface InterfaceC0643c {
        void a(com.baidu.mapsdkplatform.comapi.commonutils.b.b r100);

        void b(com.baidu.mapsdkplatform.comapi.commonutils.b.b r100);
    }

    public interface d {
        void a();

        void a(File r100);
    }

    public static class e implements HostnameVerifier {
        public e() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String r100, SSLSession r101) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(r100, r101);
        }
    }

    public c() {
        this.f32063b = 1;
        this.f32064c = new LinkedList();
        this.f32062a = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("mmonutils/b/c"));
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_baidu_mapsdkplatform_comapi_commonutils_b_c_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
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

    private HttpURLConnection a(String r100) {
        URL r101 = new URL(r100);     // Catch: Exception -> L8
        if (HttpClient.isHttpsEnable == false) goto L5;
        HttpsURLConnection r102 = (HttpsURLConnection) INVOKEVIRTUAL_com_baidu_mapsdkplatform_comapi_commonutils_b_c_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r101);     // Catch: Exception -> L8
        r102.setHostnameVerifier(new e());     // Catch: Exception -> L8
        HttpURLConnection r103 = r102;
    L6:
        r103.setConnectTimeout(5000);     // Catch: Exception -> L8
        r103.setRequestMethod("GET");     // Catch: Exception -> L8
        r103.connect();     // Catch: Exception -> L8
        return r103;
    L5:
        r103 = (HttpURLConnection) INVOKEVIRTUAL_com_baidu_mapsdkplatform_comapi_commonutils_b_c_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r101);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static /* synthetic */ d b(c r100) {
        return r100.f32065d;
    }

    public static /* synthetic */ List a(c r100) {
        return r100.f32064c;
    }

    private void a(String r100, String r101, String r102) {
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);
        if (r103.exists() == false) goto L5;
    L7:
        HttpURLConnection r104 = a(r100);
        if (r104 == null) goto L34;
    L35:
        return;
    L10:
        if (r104.getResponseCode() != 200) goto L34;
        int r105 = r104.getContentLength();     // Catch: Exception -> L35
        if (r105 <= 0) goto L32;
        if (r102 != null) goto L24;
        String r106 = r104.getHeaderField("Content-Disposition");     // Catch: Exception -> L35
        if (r106 != null) goto L17;
        return;
    L17:
        if (r106.length() == 0) goto L37;
        r102 = URLDecoder.decode(r106.substring(r106.indexOf("filename=") + 9), "UTF-8");     // Catch: Exception -> L35
        if (r102 != null) goto L22;
        return;
    L22:
        if (r102.length() != 0) goto L24;
        return;
    L37:
        return;
    L24:
        PolarisFileWrapper r107 = new PolarisFileWrapper(r103, r102);     // Catch: Exception -> L35
        RandomAccessFile r108 = new RandomAccessFile(r107, "rw");     // Catch: Exception -> L35
        r108.setLength(r105);     // Catch: Exception -> L35
        r108.close();     // Catch: Exception -> L35
        r104.disconnect();     // Catch: Exception -> L35
        int r109 = this.f32063b;
        int r110 = r105 % r109;
        int r111 = r105 / r109;
        if (r110 == 0) goto L29;
        r111 = r111 + 1;
    L29:
        a(r100, r107, r111, r105);
        return;
    L32:
        throw new RuntimeException("unKnow file length");     // Catch: Exception -> L35
    L34:
        throw new RuntimeException("server no response.");     // Catch: Exception -> L35
    L5:
        if (r103.mkdirs() == true) goto L7;
    }

    private void a(String r100, File r101, int r102, int r103) {
        if (TextUtils.isEmpty(r100) == true) goto L23;
        if (r101 == null) goto L28;
        if (r102 <= 0) goto L29;
        if (r103 <= 0) goto L30;
        int r104 = 0;
    L10:
        if (r104 >= this.f32063b) goto L31;
        int r105 = r104 + 1;
        com.baidu.mapsdkplatform.comapi.commonutils.b.a r106 = new com.baidu.mapsdkplatform.comapi.commonutils.b.a(r104, r104 * r102, (r105 * r102) - 1);
        if (r104 != (this.f32063b - 1)) goto L14;
        r106.a(r103);
    L14:
        com.baidu.mapsdkplatform.comapi.commonutils.b.b r107 = new com.baidu.mapsdkplatform.comapi.commonutils.b.b(r100, r101, r106, new b(this, r101, null));
        List<com.baidu.mapsdkplatform.comapi.commonutils.b.b> r108 = this.f32064c;
        if (r108 == null) goto L17;
        r108.add(r107);
    L17:
        ExecutorService r109 = this.f32062a;
        if (r109 == null) goto L22;
        if (r109.isShutdown() == true) goto L22;
        this.f32062a.submit(r107);
    L22:
        r104 = r105;
        goto L10
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }

    public void a(String r100, String r101, String r102, int r103, d r104) {
        if (r103 > 0) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r102) == true) goto L15;
        this.f32063b = r103;
        this.f32065d = r104;
        a(r100, r101, r102);
        return;
    }
}
