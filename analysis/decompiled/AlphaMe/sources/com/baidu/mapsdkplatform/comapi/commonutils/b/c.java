package com.baidu.mapsdkplatform.comapi.commonutils.b;

import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.stepos.activeview.utils.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    private d f7941d;

    /* renamed from: b, reason: collision with root package name */
    private int f7939b = 1;

    /* renamed from: c, reason: collision with root package name */
    private List<com.baidu.mapsdkplatform.comapi.commonutils.b.b> f7940c = new LinkedList();

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f7938a = Executors.newCachedThreadPool();

    public class b implements InterfaceC0026c {

        /* renamed from: a, reason: collision with root package name */
        private File f7942a;

        @Override // com.baidu.mapsdkplatform.comapi.commonutils.b.c.InterfaceC0026c
        public void a(com.baidu.mapsdkplatform.comapi.commonutils.b.b bVar) {
            if (c.this.f7940c == null || c.this.f7940c.size() == 0 || bVar == null || !bVar.a() || c.this.f7940c == null) {
                return;
            }
            c.this.f7940c.remove(bVar);
            if (c.this.f7940c.size() == 0) {
                c.this.f7941d.a(this.f7942a);
            }
        }

        @Override // com.baidu.mapsdkplatform.comapi.commonutils.b.c.InterfaceC0026c
        public void b(com.baidu.mapsdkplatform.comapi.commonutils.b.b bVar) {
            if (c.this.f7940c == null || c.this.f7940c.size() == 0 || bVar == null) {
                return;
            }
            c.this.f7940c.clear();
            if (c.this.f7941d != null) {
                c.this.f7941d.a();
            }
        }

        private b(File file) {
            this.f7942a = file;
        }
    }

    /* renamed from: com.baidu.mapsdkplatform.comapi.commonutils.b.c$c, reason: collision with other inner class name */
    public interface InterfaceC0026c {
        void a(com.baidu.mapsdkplatform.comapi.commonutils.b.b bVar);

        void b(com.baidu.mapsdkplatform.comapi.commonutils.b.b bVar);
    }

    public interface d {
        void a();

        void a(File file);
    }

    public static class e implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }

    public void a(String str, String str2, String str3, int i4, d dVar) throws IOException {
        if (i4 <= 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        this.f7939b = i4;
        this.f7941d = dVar;
        a(str, str2, str3);
    }

    private void a(String str, String str2, String str3) throws IOException {
        String headerField;
        File file = new File(str2);
        if (file.exists() || file.mkdirs()) {
            HttpURLConnection httpURLConnectionA = a(str);
            if (httpURLConnectionA != null) {
                try {
                    if (httpURLConnectionA.getResponseCode() == 200) {
                        int contentLength = httpURLConnectionA.getContentLength();
                        if (contentLength > 0) {
                            if (str3 == null && ((headerField = httpURLConnectionA.getHeaderField("Content-Disposition")) == null || headerField.length() == 0 || (str3 = URLDecoder.decode(headerField.substring(headerField.indexOf("filename=") + 9), Constants.UTF_8_CODE)) == null || str3.length() == 0)) {
                                return;
                            }
                            File file2 = new File(file, str3);
                            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                            randomAccessFile.setLength(contentLength);
                            randomAccessFile.close();
                            httpURLConnectionA.disconnect();
                            int i4 = this.f7939b;
                            int i5 = contentLength % i4;
                            int i6 = contentLength / i4;
                            if (i5 != 0) {
                                i6++;
                            }
                            a(str, file2, i6, contentLength);
                            return;
                        }
                        throw new RuntimeException("unKnow file length");
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            throw new RuntimeException("server no response.");
        }
    }

    private void a(String str, File file, int i4, int i5) {
        if (TextUtils.isEmpty(str) || file == null || i4 <= 0 || i5 <= 0) {
            return;
        }
        int i6 = 0;
        while (i6 < this.f7939b) {
            int i7 = i6 + 1;
            com.baidu.mapsdkplatform.comapi.commonutils.b.a aVar = new com.baidu.mapsdkplatform.comapi.commonutils.b.a(i6, i6 * i4, (i7 * i4) - 1);
            if (i6 == this.f7939b - 1) {
                aVar.a(i5);
            }
            com.baidu.mapsdkplatform.comapi.commonutils.b.b bVar = new com.baidu.mapsdkplatform.comapi.commonutils.b.b(str, file, aVar, new b(file));
            List<com.baidu.mapsdkplatform.comapi.commonutils.b.b> list = this.f7940c;
            if (list != null) {
                list.add(bVar);
            }
            ExecutorService executorService = this.f7938a;
            if (executorService != null && !executorService.isShutdown()) {
                this.f7938a.submit(bVar);
            }
            i6 = i7;
        }
    }

    private HttpURLConnection a(String str) throws IOException {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str);
            if (HttpClient.isHttpsEnable) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                httpsURLConnection.setHostnameVerifier(new e());
                httpURLConnection = httpsURLConnection;
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            return httpURLConnection;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
