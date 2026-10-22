package com.apm.lite.j;

import com.baidu.mapapi.http.HttpClient;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes39.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HttpURLConnection f29977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f29978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f29979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l f29980e;

    public final String a() {
        ArrayList r100 = new ArrayList();
        byte[] r101 = ("\r\n--" + this.f29976a + "--\r\n").getBytes();
        if (this.f29978c == false) goto L5;
        this.f29980e.write(r101);
        this.f29980e.b();
        this.f29980e.a();
    L6:
        int r102 = this.f29977b.getResponseCode();
        if (r102 != 200) goto L19;
        BufferedReader r103 = new BufferedReader(new InputStreamReader(this.f29977b.getInputStream()));
    L9:
        String r104 = r103.readLine();
        if (r104 == null) goto L12;
        r100.add(r104);
        goto L9
    L12:
        r103.close();
        this.f29977b.disconnect();
        StringBuilder r105 = new StringBuilder();
        Iterator r106 = r100.iterator();
    L14:
        if (r106.hasNext() == false) goto L17;
        r105.append((String) r106.next());
        goto L14
    L17:
        return r105.toString();
    L19:
        throw new IOException("Server returned non-OK status: " + r102);
    L5:
        this.f29979d.write(r101);
        this.f29979d.flush();
        this.f29979d.a();
        goto L6
    }

    public final void b(String r100, PolarisFileWrapper r101, Map r102) {
        String r103 = r101.getName();
        StringBuilder r104 = new StringBuilder(HttpClient.ENDFLAG);
        r104.append(this.f29976a);
        r104.append("\r\nContent-Disposition: form-data; name=\"");
        r104.append(r100);
        r104.append("\"; filename=\"");
        r104.append(r103);
        r104.append("\"");
        Iterator r105 = ((HashMap) r102).entrySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        Map.Entry r106 = (Map.Entry) r105.next();
        r104.append("; ");
        r104.append((String) r106.getKey());
        r104.append("=\"");
        r104.append((String) r106.getValue());
        r104.append("\"");
        goto L4
    L6:
        r104.append("\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        if (this.f29978c == false) goto L9;
        this.f29980e.write(r104.toString().getBytes());
    L10:
        PolarisFileInputStreamWrapper r107 = new PolarisFileInputStreamWrapper(r101);
        byte[] r108 = new byte[8192];
    L11:
        int r109 = r107.read(r108);
        if (r109 == (-1)) goto L17;
        if (this.f29978c == true) goto L15;
        this.f29979d.write(r108, 0, r109);
        goto L11
    L15:
        this.f29980e.write(r108, 0, r109);
        goto L11
    L17:
        r107.close();
        if (this.f29978c == false) goto L20;
        this.f29980e.write("\r\n".getBytes());
        return;
    L20:
        this.f29979d.write("\r\n".getBytes());
        this.f29979d.flush();
        return;
    L9:
        this.f29979d.write(r104.toString().getBytes());
        goto L10
    }

    public final void c(String r100, String r101, boolean r102) {
        StringBuilder r103 = new StringBuilder(HttpClient.ENDFLAG);
        r103.append(this.f29976a);
        r103.append("\r\nContent-Disposition: form-data; name=\"");
        r103.append(r100);
        r103.append("\"\r\nContent-Type: text/plain; charset=UTF-8\r\n\r\n");
        if (this.f29978c == false) goto L6;
        this.f29980e.write(r103.toString().getBytes());     // Catch: IOException -> L14
    L16:
        goto L7
    L6:
        this.f29979d.write(r103.toString().getBytes());     // Catch: IOException -> L14
    L7:
        byte[] r104 = r101.getBytes();
        if (this.f29978c == false) goto L12;
        this.f29980e.write(r104);     // Catch: IOException -> L15
        this.f29980e.write("\r\n".getBytes());     // Catch: IOException -> L15
    L19:
        return;
    L12:
        this.f29979d.write(r104);     // Catch: IOException -> L15
        this.f29979d.write("\r\n".getBytes());     // Catch: IOException -> L15
    }

    public final void d(File... r100) {
        StringBuilder r101 = new StringBuilder(HttpClient.ENDFLAG);
        r101.append(this.f29976a);
        r101.append("\r\nContent-Disposition: form-data; name=\"file\"; filename=\"file\"\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        if (this.f29978c == false) goto L5;
        this.f29980e.write(r101.toString().getBytes());
    L7:
        if (this.f29978c == false) goto L9;
        OutputStream r102 = this.f29980e;
    L43:
        ZipOutputStream r103 = new ZipOutputStream(r102);     // Catch: Throwable -> L37
        r103.putNextEntry(new ZipEntry(HTTP.URL_DEFAULT));     // Catch: Throwable -> L35
        int r104 = r100.length;     // Catch: Throwable -> L35
        int r105 = 0;
    L12:
        if (r105 >= r104) goto L30;
        File r106 = r100[r105];     // Catch: Throwable -> L35
        if (r106 == null) goto L29;
        if (r106.exists() == false) goto L29;
        if (r106.isDirectory() == false) goto L21;
        File[] r107 = r106.listFiles();     // Catch: Throwable -> L35
    L22:
        if (r107 == null) goto L29;
        int r108 = 0;
    L26:
        if (r108 >= r107.length) goto L29;
        File r109 = r107[r108];     // Catch: Throwable -> L35
        com.apm.lite.k.h.j(r103, r109, r109.getName());     // Catch: Throwable -> L35
        r108 = r108 + 1;
        goto L26
    L21:
        r107 = new File[]{r106};     // Catch: Throwable -> L35
    L29:
        r105 = r105 + 1;
        goto L12
    L30:
        com.apm.lite.k.j.a(r103);
        if (this.f29978c == false) goto L33;
        this.f29980e.write("\r\n".getBytes());
        return;
    L33:
        this.f29979d.write("\r\n".getBytes());
        this.f29979d.flush();
        return;
    L35:
        th = th;
    L39:
        com.apm.lite.k.j.a(r103);
        throw th;
    L37:
        th = th;
        r103 = null;
        goto L39
    L9:
        r102 = this.f29979d;
        goto L43
    L5:
        this.f29979d.write(r101.toString().getBytes());
        goto L7
    }

    public h(String r100, Map r101, boolean r110) {
        this.f29978c = r110;
        this.f29976a = "AAA" + System.currentTimeMillis() + "AAA";
        URL r102 = new URL(r100);
        String r103 = r102.getHost();     // Catch: Throwable -> L8 IOException -> L20
        String r104 = r102.getPath();     // Catch: Throwable -> L8 IOException -> L20
        if (com.obric.assistant.network.okhttp.a.c(r103, r104) == false) goto L10;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r103 + " path=" + r104);     // Catch: Throwable -> L8 IOException -> L20
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r103, r104), r103, r104);     // Catch: Throwable -> L8 IOException -> L20
        throw new IOException("[NetGuard] dropped " + r102);     // Catch: Throwable -> L8 IOException -> L20
    L10:
        HttpURLConnection r105 = (HttpURLConnection) r102.openConnection();
        this.f29977b = r105;
        o1.a.a(r105);
        r105.setUseCaches(false);
        r105.setDoOutput(true);
        r105.setDoInput(true);
        r105.setRequestMethod("POST");
        r105.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f29976a);
        if (r101 == null) goto L16;
        Iterator r106 = ((HashMap) r101).entrySet().iterator();
    L14:
        if (r106.hasNext() == false) goto L16;
        Map.Entry r107 = (Map.Entry) r106.next();
        this.f29977b.setRequestProperty((String) r107.getKey(), (String) r107.getValue());
    L16:
        if (r110 == false) goto L18;
        this.f29977b.setRequestProperty("Content-Encoding", DownloadHelper.GZIP);
        this.f29980e = new l(this.f29977b.getOutputStream());
        return;
    L18:
        this.f29979d = new f(this.f29977b.getOutputStream());
        return;
    L20:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L10
    }
}
