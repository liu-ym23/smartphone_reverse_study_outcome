package com.bytedance.ttnet.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.i;
import com.bytedance.common.utility.j;
import com.bytedance.frameworks.baselib.network.http.f.f;
import com.bytedance.frameworks.baselib.network.http.g;
import com.bytedance.ttnet.TTNetInit;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: HttpURLConnClient.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static String a(final String r11, Map<String, String> r12, Map<String, List<String>> r13, a r14) {
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        HttpURLConnection r3 = null;
        if (j.a(r11) == true) goto L91;
        if (r14 == null) goto L91;
        if (i.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L98;
        return null;
    L98:
    L84:
        th = th;
    L100:
        th.printStackTrace();     // Catch: Throwable -> L87
        throw th;     // Catch: Throwable -> L87
    L87:
        th = move-exception;
        if (r3 != null) goto L95;
    L90:
        throw th;
    L95:
        r3.disconnect();     // Catch: Exception -> L94
        goto L90
    L10:
        if (r14.g == false) goto L24;
        String r1 = g.a(r11, true, null);     // Catch: Throwable -> L84
        if (TextUtils.isEmpty(r1) == true) goto L24;
        if (r1.equals(r11) == false) goto L23;
        StringBuilder r17 = new StringBuilder(r1);     // Catch: Throwable -> L84
        if (r1.indexOf(63) >= 0) goto L18;
        r17.append("?");     // Catch: Throwable -> L84
    L19:
        r17.append("aid=").append(TTNetInit.getTTNetDepend().g()).append("&device_platform=").append("android");     // Catch: Throwable -> L84
        if (TTNetInit.getCronetProvider() == null) goto L22;
        r17.append("&version_code=").append(TTNetInit.getCronetProvider().getVersionCode()).append("&channel=").append(TTNetInit.getCronetProvider().getChannel()).append("device_id").append(TTNetInit.getCronetProvider().getDeviceId());     // Catch: Throwable -> L84
    L22:
        r11 = r17.toString();     // Catch: Throwable -> L84
        goto L24
    L18:
        r17.append("&");     // Catch: Throwable -> L84
        goto L19
    L23:
        r11 = r1;
    L24:
        final HttpURLConnection r2 = (HttpURLConnection) ZeusTransformUtils.preCheckCast(a(new URL(r11)), HttpURLConnection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L84
        r2.setRequestMethod("GET");     // Catch: Throwable -> L82
        r2.setConnectTimeout(g.a());     // Catch: Throwable -> L82
        r2.setReadTimeout(g.b());     // Catch: Throwable -> L82
        r2.setInstanceFollowRedirects(true);     // Catch: Throwable -> L82
        r2.setRequestProperty(DownloadHelper.ACCEPT_ENCODING, DownloadHelper.GZIP);     // Catch: Throwable -> L82
        if (r14.f == false) goto L28;
        String r5 = " HttpsURLConnection";
    L29:
        r2.setRequestProperty(DownloadConstants.USER_AGENT, "ttnet" + r5);     // Catch: Throwable -> L82
        if (r15 != null) goto L32;
    L37:
        int r18 = r2.getResponseCode();     // Catch: Throwable -> L82
        r14.f11408a = r18;     // Catch: Throwable -> L82
        if (r16 == null) goto L50;
        if (r2.getHeaderFields() == null) goto L50;
        Map<String, List<String>> r6 = r2.getHeaderFields();     // Catch: Throwable -> L82
        if (r6 == null) goto L50;
        Iterator<Map.Entry<String, List<String>>> r7 = r6.entrySet().iterator();     // Catch: Throwable -> L82
    L45:
        if (r7.hasNext() == false) goto L50;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L82
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L82
        if (TextUtils.isEmpty(r9) == true) goto L45;
        r16.put(r9.toLowerCase(), (List) ZeusTransformUtils.preCheckCast(r8.getValue(), List.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L82
    L50:
        if (r14.f == true) goto L52;
        r14.f11412e = r2.getHeaderField("X-SS-SIGN");     // Catch: Throwable -> L82
    L52:
        r14.h = r2.getHeaderField("x-ss-etag");     // Catch: Throwable -> L82
        r14.i = r2.getHeaderField("x-tt-tnc-abtest");     // Catch: Throwable -> L82
        r14.l = r2.getHeaderField("x-tt-tnc-control");     // Catch: Throwable -> L82
        r14.m = r2.getHeaderField("x-tt-tnc-config");     // Catch: Throwable -> L82
        r14.n = r2.getHeaderField("x-ss-canary");     // Catch: Throwable -> L82
        r14.j = r2.getHeaderField("x-tt-tnc-query-region");     // Catch: Throwable -> L82
        r14.k = r2.getHeaderField("x-tt-logid");     // Catch: Throwable -> L82
        if (r18 != 200) goto L81;
        InputStream r10 = r2.getInputStream();     // Catch: Throwable -> L82
        boolean r19 = DownloadHelper.GZIP.equals(r2.getHeaderField(DownloadHelper.CONTENT_ENCODING));     // Catch: Throwable -> L82
        String r110 = r2.getHeaderField(DownloadHelper.CONTENT_TYPE);     // Catch: Throwable -> L82
        boolean r111 = f.a(r110);     // Catch: Throwable -> L82
        Pair<String, String> r112 = com.bytedance.ttnet.utils.d.a(r110);     // Catch: Throwable -> L82
        if (r112 != null) goto L57;
    L61:
        String r113 = null;
    L62:
        if (r113 != null) goto L64;
        r113 = "UTF-8";
    L64:
        int[] r114 = {0};     // Catch: Throwable -> L82
        byte[] r115 = f.a(r19, r2.getHeaderFields(), -1, r10, r114, new AnonymousClass1(r11, r2));     // Catch: Throwable -> L82
        if (r115 != null) goto L67;
    L77:
        if (r2 != null) goto L102;
    L79:
        return null;
    L102:
        r2.disconnect();     // Catch: Exception -> L93
        goto L79
    L67:
        if (r114[0] <= 0) goto L77;
        if (r114[0] > r115.length) goto L77;
        if (r111 == false) goto L73;
        f.a(r115, r114[0]);     // Catch: Throwable -> L82
    L73:
        String r116 = new String(r115, 0, r114[0], r113);     // Catch: Throwable -> L82
        if (r2 != null) goto L104;
    L76:
        return r116;
    L104:
        r2.disconnect();     // Catch: Exception -> L92
        goto L76
    L57:
        if (r112.second == null) goto L61;
        if (Charset.isSupported((String) ZeusTransformUtils.preCheckCast(r112.second, String.class, "com.obric.aiagent.plugin")) == false) goto L61;
        r113 = (String) ZeusTransformUtils.preCheckCast(r112.second, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L82
        goto L62
    L81:
        throw new IOException("err status = " + r18);     // Catch: Throwable -> L82
    L32:
        if (r15.size() <= 0) goto L37;
        Iterator r117 = r15.entrySet().iterator();     // Catch: Throwable -> L82
    L35:
        if (r117.hasNext() == false) goto L37;
        Map.Entry r20 = (Map.Entry) ZeusTransformUtils.preCheckCast(r117.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L82
        r2.setRequestProperty((String) ZeusTransformUtils.preCheckCast(r20.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r20.getValue(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L82
        goto L35
    L28:
        r5 = " HttpURLConnection";
    L82:
        th = th;
        r3 = r2;
    L91:
        return null;
    }

    @Skip({"com.obric.aiagent.okhttp"})
    public static URLConnection a(URL r4) {
        URL r0 = (URL) ZeusTransformUtils.preCheckCast(r4, URL.class, "com.obric.aiagent.plugin");
        String r1 = r0.getHost();
        String r2 = r0.getPath();
        if (com.obric.aiagent.a.b.a(r1, r2) == false) goto L5;
        ILogDepend.Companion.i("AiAgentUrlConnLancet", "openConnection drop host=" + r1 + " path=" + r2);
        com.obric.aiagent.a.b.a(com.obric.aiagent.a.b.b(r1, r2), r1, r2);
        throw new IOException("[NetGuard] dropped ");
    L5:
        return r4.openConnection();
    }
}
