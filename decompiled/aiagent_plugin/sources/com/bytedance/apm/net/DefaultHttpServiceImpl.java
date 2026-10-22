package com.bytedance.apm.net;

import android.text.TextUtils;
import com.bytedance.apm.util.e;
import com.bytedance.apm.util.j;
import com.bytedance.apm.util.m;
import com.bytedance.apm.util.u;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.c;
import com.bytedance.services.apm.api.h;
import com.ss.android.socialbase.downloader.setting.DownloadSettingValues;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes.dex */
public class DefaultHttpServiceImpl implements IHttpService {
    private static String METHOD_GET = "GET";
    private static String METHOD_POST = "POST";

    static {
    }

    public DefaultHttpServiceImpl() {
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public c doPost(String r3, byte[] r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        return doRequest(r3, r4, METHOD_POST, r6);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public c doGet(String r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        return doRequest(r3, null, METHOD_GET, r5);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public c uploadFiles(String r2, List<File> r3, Map<String, String> r4) {
        return e.a(r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public h buildMultipartUpload(String r2, String r3, boolean r4) {
        return new b(r2, r3, r4, null);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public h buildMultipartUpload(String r2, String r3, boolean r4, Map<String, String> r5) {
        return new b(r2, r3, r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin"));
    }

    private c doRequest(String r9, byte[] r10, String r11, Map<String, String> r12) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L73;
        HttpURLConnection r13 = m.a(r9);     // Catch: Throwable -> L58
        r13.setConnectTimeout(DownloadSettingValues.SYNC_INTERVAL_MS_FG);     // Catch: Throwable -> L56
        r13.setReadTimeout(DownloadSettingValues.SYNC_INTERVAL_MS_FG);     // Catch: Throwable -> L56
        if (r8 == null) goto L19;
        if (r8.isEmpty() == true) goto L19;
        Iterator r14 = r8.entrySet().iterator();     // Catch: Throwable -> L56
    L13:
        if (r14.hasNext() == false) goto L19;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L56
        if (r1 == null) goto L13;
        r13.setRequestProperty((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L56
    L19:
        if (TextUtils.equals(r11, METHOD_POST) == false) goto L21;
        r13.setDoOutput(true);     // Catch: Throwable -> L56
    L22:
        r13.setRequestMethod(r11);     // Catch: Throwable -> L56
        if (r10 != null) goto L25;
    L27:
        int r15 = r13.getResponseCode();     // Catch: Throwable -> L56
        if (r15 != 200) goto L52;
        InputStream r16 = r13.getInputStream();     // Catch: Throwable -> L56
        String r17 = r13.getContentEncoding();     // Catch: Throwable -> L50
        if (TextUtils.isEmpty(r17) == false) goto L33;
    L35:
        byte[] r2 = toByteArray(r16);     // Catch: Throwable -> L50
    L36:
        Map<String, List<String>> r18 = r13.getHeaderFields();     // Catch: Throwable -> L50
        HashMap r3 = new HashMap();     // Catch: Throwable -> L50
        Iterator<String> r4 = r18.keySet().iterator();     // Catch: Throwable -> L50
    L38:
        if (r4.hasNext() == false) goto L44;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50
        List r6 = (List) ZeusTransformUtils.preCheckCast(r18.get(r5), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50
        if (r6 == null) goto L38;
        if (j.a(r6) == true) goto L38;
        r3.put(r5, r6.get(0));     // Catch: Throwable -> L50
        goto L38
    L44:
        c r19 = new c(r15, r3, r2);     // Catch: Throwable -> L50
        if (r16 != null) goto L84;
    L47:
        if (r13 != null) goto L100;
    L49:
        return r19;
    L100:
        r13.disconnect();     // Catch: Exception -> L75
        goto L49
    L84:
        r16.close();     // Catch: Exception -> L74
        goto L47
    L33:
        if (r17.equalsIgnoreCase(DownloadHelper.GZIP) == false) goto L35;
        GZIPInputStream r110 = new GZIPInputStream(r16);     // Catch: Throwable -> L50
        r2 = toByteArray(r110);     // Catch: Throwable -> L50
        r110.close();     // Catch: Throwable -> L50
    L50:
        th = th;
    L98:
        com.bytedance.apm.h.a.b("apm_debug", "http request msg: " + th.getMessage() + " ,stack: " + u.a(th, 10));     // Catch: Throwable -> L66
        if (r16 != null) goto L94;
    L63:
        if (r13 != null) goto L90;
    L65:
        return null;
    L90:
        r13.disconnect();     // Catch: Exception -> L77
        goto L65
    L94:
        r16.close();     // Catch: Exception -> L76
    L66:
        th = move-exception;
        if (r16 != null) goto L96;
    L69:
        if (r13 == null) goto L115;
        r13.disconnect();     // Catch: Exception -> L79
        throw th;
    L116:
        throw th;
    L115:
        throw th;
    L96:
        r16.close();     // Catch: Exception -> L78
        goto L69
    L52:
        c r111 = new c(r15, null);     // Catch: Throwable -> L56
        if (r13 != null) goto L82;
    L55:
        return r111;
    L82:
        r13.disconnect();     // Catch: Exception -> L80
        goto L55
    L25:
        if (r10.length <= 0) goto L27;
        DataOutputStream r20 = new DataOutputStream(r13.getOutputStream());     // Catch: Throwable -> L56
        r20.write(r10);     // Catch: Throwable -> L56
        r20.flush();     // Catch: Throwable -> L56
        r20.close();     // Catch: Throwable -> L56
        goto L27
    L21:
        r13.setDoOutput(false);     // Catch: Throwable -> L56
    L56:
        th = th;
        r16 = null;
    L58:
        th = th;
        r13 = null;
        r16 = null;
        goto L98
    L73:
        throw new IllegalArgumentException("request method is not null");
    }

    public static byte[] toByteArray(InputStream r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[8192];
    L3:
        int r3 = r4.read(r1);
        if ((-1) == r3) goto L6;
        r0.write(r1, 0, r3);
        goto L3
    L6:
        if (r4 == null) goto L9;
        r4.close();
    L9:
        return r0.toByteArray();
    }
}
