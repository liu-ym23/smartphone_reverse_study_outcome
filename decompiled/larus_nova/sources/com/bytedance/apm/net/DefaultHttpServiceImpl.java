package com.bytedance.apm.net;

import android.text.TextUtils;
import com.bytedance.apm.util.f;
import com.bytedance.apm.util.k;
import com.bytedance.apm.util.m;
import com.bytedance.apm.util.s;
import com.bytedance.services.apm.api.IHttpService;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import ff7.b;
import ff7.g;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import qs3.a;

/* JADX INFO: loaded from: classes.dex */
public class DefaultHttpServiceImpl implements IHttpService {
    private static String METHOD_GET = "GET";
    private static String METHOD_POST = "POST";

    public DefaultHttpServiceImpl() {
    }

    public static byte[] toByteArray(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        byte[] r102 = new byte[8192];
    L3:
        int r103 = r100.read(r102);
        if ((-1) == r103) goto L6;
        r101.write(r102, 0, r103);
        goto L3
    L6:
        r100.close();
        return r101.toByteArray();
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b doGet(String r100, Map<String, String> r101) throws Exception {
        return doRequest(r100, null, METHOD_GET, r101);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public g buildMultipartUpload(String r100, String r101, boolean r102) throws IOException {
        return new a(r100, r101, r102, null);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b doPost(String r100, byte[] r101, Map<String, String> r102) throws Exception {
        return doRequest(r100, r101, METHOD_POST, r102);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b uploadFiles(String r100, List<File> r101, Map<String, String> r102) throws Exception {
        return f.a(r100, r101, r102);
    }

    private b doRequest(String r100, byte[] r110, String r111, Map<String, String> r112) throws Exception {
        if (r111 == null) goto L74;
        HttpURLConnection r101 = m.a(r100);     // Catch: Throwable -> L55
        r101.setConnectTimeout(5000);     // Catch: Throwable -> L53
        r101.setReadTimeout(5000);     // Catch: Throwable -> L53
        if (r112 == null) goto L18;
        if (r112.isEmpty() == true) goto L18;
        Iterator<Map.Entry<String, String>> r113 = r112.entrySet().iterator();     // Catch: Throwable -> L53
    L12:
        if (r113.hasNext() == false) goto L18;
        Map.Entry<String, String> r102 = r113.next();     // Catch: Throwable -> L53
        if (r102 == null) goto L12;
        r101.setRequestProperty(r102.getKey(), r102.getValue());     // Catch: Throwable -> L53
    L18:
        if (TextUtils.equals(r111, METHOD_POST) == false) goto L20;
        r101.setDoOutput(true);     // Catch: Throwable -> L53
    L21:
        r101.setRequestMethod(r111);     // Catch: Throwable -> L53
        if (r110 != null) goto L24;
    L26:
        int r114 = r101.getResponseCode();     // Catch: Throwable -> L53
        if (r114 != 200) goto L50;
        InputStream r115 = r101.getInputStream();     // Catch: Throwable -> L53
        String r116 = r101.getContentEncoding();     // Catch: Throwable -> L48
        if (TextUtils.isEmpty(r116) == false) goto L32;
    L34:
        byte[] r103 = toByteArray(r115);     // Catch: Throwable -> L48
    L35:
        Map<String, List<String>> r117 = r101.getHeaderFields();     // Catch: Throwable -> L48
        HashMap r104 = new HashMap();     // Catch: Throwable -> L48
        Iterator<String> r105 = r117.keySet().iterator();     // Catch: Throwable -> L48
    L37:
        if (r105.hasNext() == false) goto L43;
        String r106 = r105.next();     // Catch: Throwable -> L48
        List<String> r107 = r117.get(r106);     // Catch: Throwable -> L48
        if (r107 == null) goto L37;
        if (k.b(r107) == true) goto L37;
        r104.put(r106, r107.get(0));     // Catch: Throwable -> L48
        goto L37
    L43:
        b r118 = new b(r114, r104, r103);     // Catch: Throwable -> L48
        if (r115 != null) goto L97;
    L93:
        r101.disconnect();     // Catch: Exception -> L76
    L47:
        return r118;
    L97:
        r115.close();     // Catch: Exception -> L75
        goto L93
    L32:
        if (r116.equalsIgnoreCase(DownloadHelper.GZIP) == false) goto L34;
        GZIPInputStream r119 = new GZIPInputStream(r115);     // Catch: Throwable -> L48
        r103 = toByteArray(r119);     // Catch: Throwable -> L48
        r119.close();     // Catch: Throwable -> L48
    L48:
        th = th;
    L82:
        th.getMessage();     // Catch: Throwable -> L65
        s.a(th, 10);     // Catch: Throwable -> L65
        if (r115 != null) goto L87;
    L62:
        if (r101 != null) goto L80;
    L64:
        return null;
    L80:
        r101.disconnect();     // Catch: Exception -> L77
        goto L64
    L87:
        r115.close();     // Catch: Exception -> L61
    L65:
        th = move-exception;
        if (r115 != null) goto L91;
    L70:
        if (r101 == null) goto L114;
        r101.disconnect();     // Catch: Exception -> L78
        throw th;
    L115:
        throw th;
    L114:
        throw th;
    L91:
        r115.close();     // Catch: Exception -> L69
        goto L70
    L50:
        b r120 = new b(r114, null);     // Catch: Throwable -> L53
        r101.disconnect();     // Catch: Exception -> L79
    L52:
        return r120;
    L24:
        if (r110.length <= 0) goto L26;
        DataOutputStream r121 = new DataOutputStream(r101.getOutputStream());     // Catch: Throwable -> L53
        r121.write(r110);     // Catch: Throwable -> L53
        r121.flush();     // Catch: Throwable -> L53
        r121.close();     // Catch: Throwable -> L53
        goto L26
    L20:
        r101.setDoOutput(false);     // Catch: Throwable -> L53
    L53:
        th = th;
        r115 = null;
    L55:
        th = th;
        r101 = null;
        r115 = null;
        goto L82
    L74:
        throw new IllegalArgumentException("request method is not null");
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public g buildMultipartUpload(String r100, String r101, boolean r102, Map<String, String> r103) throws Exception {
        return new a(r100, r101, r102, r103);
    }
}
