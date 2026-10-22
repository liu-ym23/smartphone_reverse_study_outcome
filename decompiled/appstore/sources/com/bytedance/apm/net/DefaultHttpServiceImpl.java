package com.bytedance.apm.net;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.e;
import com.bytedance.apm.util.k;
import com.bytedance.apm.util.t;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import i6.c;
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
import s1.a;

/* JADX INFO: loaded from: classes.dex */
public class DefaultHttpServiceImpl implements IHttpService {
    private static String METHOD_GET = "GET";
    private static String METHOD_POST = "POST";

    static {
    }

    public DefaultHttpServiceImpl() {
    }

    private c doRequest(String r10, byte[] r11, String r12, Map<String, String> r13) throws Exception {
        if (r12 == null) goto L70;
        HttpURLConnection r14 = k.a(r10);     // Catch: Throwable -> L55
        r14.setConnectTimeout(5000);     // Catch: Throwable -> L17
        r14.setReadTimeout(5000);     // Catch: Throwable -> L17
        if (r13 == null) goto L20;
        if (r13.isEmpty() == true) goto L20;
        Iterator<Map.Entry<String, String>> r15 = r13.entrySet().iterator();     // Catch: Throwable -> L17
    L12:
        if (r15.hasNext() == false) goto L20;
        Map.Entry<String, String> r16 = r15.next();     // Catch: Throwable -> L17
        if (r16 == null) goto L12;
        r14.setRequestProperty(r16.getKey(), r16.getValue());     // Catch: Throwable -> L17
    L20:
        if (TextUtils.equals(r12, METHOD_POST) == false) goto L22;
        r14.setDoOutput(true);     // Catch: Throwable -> L17
    L23:
        r14.setRequestMethod(r12);     // Catch: Throwable -> L17
        if (r11 != null) goto L26;
    L28:
        int r17 = r14.getResponseCode();     // Catch: Throwable -> L17
        if (r17 != 200) goto L52;
        InputStream r18 = r14.getInputStream();     // Catch: Throwable -> L17
        String r19 = r14.getContentEncoding();     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r19) == false) goto L34;
    L38:
        byte[] r20 = toByteArray(r18);     // Catch: Throwable -> L36
    L39:
        Map<String, List<String>> r110 = r14.getHeaderFields();     // Catch: Throwable -> L36
        HashMap r21 = new HashMap();     // Catch: Throwable -> L36
        Iterator<String> r22 = r110.keySet().iterator();     // Catch: Throwable -> L36
    L41:
        if (r22.hasNext() == false) goto L47;
        String r23 = r22.next();     // Catch: Throwable -> L36
        List<String> r24 = r110.get(r23);     // Catch: Throwable -> L36
        if (r24 == null) goto L41;
        if (ListUtils.b(r24) == true) goto L41;
        r21.put(r23, r24.get(0));     // Catch: Throwable -> L36
        goto L41
    L47:
        c r111 = new c(r17, r21, r20);     // Catch: Throwable -> L36
        if (r18 != null) goto L82;
    L78:
        r14.disconnect();     // Catch: Exception -> L72
    L51:
        return r111;
    L82:
        r18.close();     // Catch: Exception -> L71
        goto L78
    L34:
        if (r19.equalsIgnoreCase("gzip") == false) goto L38;
        GZIPInputStream r112 = new GZIPInputStream(r18);     // Catch: Throwable -> L36
        r20 = toByteArray(r112);     // Catch: Throwable -> L36
        r112.close();     // Catch: Throwable -> L36
    L36:
        th = th;
    L96:
        a.d("apm_debug", "http request msg: " + th.getMessage() + " ,stack: " + t.b(th, 10));     // Catch: Throwable -> L63
        if (r18 != null) goto L86;
    L60:
        if (r14 != null) goto L80;
    L62:
        return null;
    L80:
        r14.disconnect();     // Catch: Exception -> L74
        goto L62
    L86:
        r18.close();     // Catch: Exception -> L73
    L63:
        th = move-exception;
        if (r18 != null) goto L94;
    L66:
        if (r14 == null) goto L112;
        r14.disconnect();     // Catch: Exception -> L76
        throw th;
    L113:
        throw th;
    L112:
        throw th;
    L94:
        r18.close();     // Catch: Exception -> L75
        goto L66
    L52:
        c r113 = new c(r17, null);     // Catch: Throwable -> L17
        r14.disconnect();     // Catch: Exception -> L77
    L54:
        return r113;
    L26:
        if (r11.length <= 0) goto L28;
        DataOutputStream r114 = new DataOutputStream(r14.getOutputStream());     // Catch: Throwable -> L17
        r114.write(r11);     // Catch: Throwable -> L17
        r114.flush();     // Catch: Throwable -> L17
        r114.close();     // Catch: Throwable -> L17
        goto L28
    L22:
        r14.setDoOutput(false);     // Catch: Throwable -> L17
    L17:
        th = th;
        r18 = null;
    L55:
        th = th;
        r14 = null;
        r18 = null;
        goto L96
    L70:
        throw new IllegalArgumentException("request method is not null");
    }

    public static byte[] toByteArray(InputStream r10) throws IOException {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        byte[] r12 = new byte[8192];
    L3:
        int r13 = r10.read(r12);
        if ((-1) == r13) goto L6;
        r11.write(r12, 0, r13);
        goto L3
    L6:
        r10.close();
        return r11.toByteArray();
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public IMultipartUploader buildMultipartUpload(String r10, String r11, boolean r12) throws IOException {
        return new t1.a(r10, r11, r12, null);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public c doGet(String r10, Map<String, String> r11) throws Exception {
        return doRequest(r10, null, METHOD_GET, r11);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public c doPost(String r10, byte[] r11, Map<String, String> r12) throws Exception {
        return doRequest(r10, r11, METHOD_POST, r12);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    @Nullable
    public c uploadFiles(String r10, List<File> r11, Map<String, String> r12) throws Exception {
        return e.a(r10, r11, r12);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public IMultipartUploader buildMultipartUpload(String r10, String r11, boolean r12, Map<String, String> r13) throws Exception {
        return new t1.a(r10, r11, r12, r13);
    }
}
