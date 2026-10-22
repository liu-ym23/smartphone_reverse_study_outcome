package com.bytedance.bdinstall;

import android.text.TextUtils;
import android.util.Pair;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: compiled from: DefaultClientWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class q implements aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f6436a = null;

    /* JADX INFO: compiled from: DefaultClientWrapper.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f6437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f6438b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        byte[] f6439c;

        a(int r1) {
            this.f6437a = r1;
        }
    }

    public q() {
    }

    static {
        f6436a = new String[]{"GET", "POST"};
    }

    @Override // com.bytedance.bdinstall.aj
    public com.bytedance.bdinstall.e.a a(String r2, Map<String, String> r3) {
        return a(0, r2, (HashMap) ZeusTransformUtils.preCheckCast((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"), HashMap.class, "com.obric.aiagent.plugin"), null);
    }

    @Override // com.bytedance.bdinstall.aj
    public com.bytedance.bdinstall.e.a a(String r2, byte[] r3, Map<String, String> r4) {
        return a(1, r2, (HashMap) ZeusTransformUtils.preCheckCast((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin"), HashMap.class, "com.obric.aiagent.plugin"), r3);
    }

    public com.bytedance.bdinstall.e.a a(String r3, byte[] r4, String r5) {
        HashMap r0 = new HashMap();
        if (TextUtils.isEmpty(r5) == true) goto L6;
        r0.put(DownloadHelper.CONTENT_TYPE, r5);
    L6:
        return a(r3, r4, r0);
    }

    public byte[] b(String r2, byte[] r3, Map<String, String> r4) {
        return a(1, r2, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin"), r3, 1).f6439c;
    }

    private static a a(int r9, String r10, Map<String, String> r11, byte[] r12, int r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        if (t.f6443a == false) goto L16;
        t.a("http: " + r10);
        if (r14 == null) goto L14;
        Iterator r2 = r14.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r4.getKey(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L8;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r4.getValue(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L8;
        t.a("http headers key:" + ((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin")) + " value:" + ((String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.aiagent.plugin")));
    L14:
        if (r12 == null) goto L16;
        t.a("http data length:" + r12.length);
    L16:
        a r3 = new a(r13);
        Closeable r5 = null;
        HttpURLConnection r15 = (HttpURLConnection) ZeusTransformUtils.preCheckCast(a(new URL(r10)), HttpURLConnection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L84
        if (r9 != 0) goto L21;
        r15.setDoOutput(false);     // Catch: Throwable -> L84
    L24:
        r15.setRequestMethod(f6436a[r9]);     // Catch: Throwable -> L84
        if (r14 != null) goto L27;
    L37:
        r15.setRequestProperty(DownloadHelper.ACCEPT_ENCODING, DownloadHelper.GZIP);     // Catch: Throwable -> L84
        if (r12 != null) goto L40;
    L43:
        DataOutputStream r16 = null;
    L44:
        int r17 = r15.getResponseCode();     // Catch: Throwable -> L81
        if (r17 != 200) goto L80;
        if (r13 == 0) goto L48;
        InputStream r18 = r15.getInputStream();     // Catch: Throwable -> L81
        if (DownloadHelper.GZIP.equalsIgnoreCase(r15.getContentEncoding()) == true) goto L66;
    L97:
        ByteArrayOutputStream r19 = new ByteArrayOutputStream();     // Catch: Throwable -> L77
        byte[] r110 = new byte[1024];     // Catch: Throwable -> L75
    L70:
        int r111 = r18.read(r110);     // Catch: Throwable -> L75
        if (r111 == (-1)) goto L73;
        r19.write(r110, 0, r111);     // Catch: Throwable -> L75
        goto L70
    L73:
        r3.f6439c = r19.toByteArray();     // Catch: Throwable -> L75
        ByteArrayOutputStream r112 = r19;
    L74:
        ba.a(r16);
        ba.a(r5);
        Closeable r113 = r112;
    L89:
        ba.a(r18);
        ba.a(r113);
        return r3;
    L75:
        th = move-exception;
        r5 = r16;
        th = th;
        BufferedReader r114 = null;
        Closeable r115 = r19;
    L103:
        t.a(th);     // Catch: Throwable -> L93
        if (ZeusTransformUtils.instanceOf(th, aw.class) == true) goto L92;
        ba.a(r5);
        ba.a(r114);
        r113 = r115;
        goto L89
    L92:
        throw ((aw) ZeusTransformUtils.preCheckCast(th, aw.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L93
    L93:
        th = move-exception;
        ba.a(r5);
        ba.a(r114);
        ba.a(r18);
        ba.a(r115);
        throw th;
    L77:
        Throwable th = th;
        r114 = null;
    L83:
        r5 = r16;
        th = th;
        r115 = r114;
        goto L103
    L66:
        r18 = new GZIPInputStream(r18);     // Catch: Throwable -> L81
        goto L97
    L48:
        if (r15.getContentLength() >= 10240) goto L61;
        InputStream r116 = r15.getInputStream();     // Catch: Throwable -> L81
        if (DownloadHelper.GZIP.equalsIgnoreCase(r15.getContentEncoding()) == false) goto L52;
        r114 = new BufferedReader(new InputStreamReader(new GZIPInputStream(r116)));     // Catch: Throwable -> L81
    L101:
        StringBuilder r117 = new StringBuilder(r116.available());     // Catch: Throwable -> L59
    L54:
        String r118 = r114.readLine();     // Catch: Throwable -> L59
        if (r118 == null) goto L57;
        r117.append(r118).append("\n");     // Catch: Throwable -> L59
        goto L54
    L57:
        r3.f6438b = r117.toString();     // Catch: Throwable -> L59
        JSONObject r119 = new JSONObject(r3.f6438b);     // Catch: Throwable -> L59
        r119.put("Set-Cookie", r15.getHeaderField("Set-Cookie"));     // Catch: Throwable -> L59
        r3.f6438b = r119.toString();     // Catch: Throwable -> L59
    L62:
        r112 = null;
        r18 = null;
        r5 = r114;
    L59:
        th = move-exception;
        r18 = null;
        r5 = r16;
        th = th;
        r115 = null;
        goto L103
    L52:
        r114 = new BufferedReader(new InputStreamReader(r116));     // Catch: Throwable -> L81
        goto L101
    L61:
        t.a(null);     // Catch: Throwable -> L81
        r114 = null;
        goto L62
    L80:
        throw new aw(r17, r15.getResponseMessage());     // Catch: Throwable -> L81
    L40:
        if (r12.length <= 0) goto L43;
        r16 = new DataOutputStream(r15.getOutputStream());     // Catch: Throwable -> L84
        r16.write(r12);     // Catch: Throwable -> L81
        r16.flush();     // Catch: Throwable -> L81
        r16.close();     // Catch: Throwable -> L81
    L81:
        th = th;
        r18 = null;
        r114 = null;
        goto L83
    L27:
        if (r14.isEmpty() == true) goto L37;
        Iterator r20 = r14.entrySet().iterator();     // Catch: Throwable -> L84
    L30:
        if (r20.hasNext() == false) goto L37;
        Map.Entry r120 = (Map.Entry) ZeusTransformUtils.preCheckCast(r20.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L84
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r120.getKey(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L36;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r120.getValue(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L36;
        r15.addRequestProperty((String) ZeusTransformUtils.preCheckCast(r120.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r120.getValue(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L84
    L36:
        t.a(null);     // Catch: Throwable -> L84
        goto L30
    L21:
        if (r9 != 1) goto L23;
        r15.setDoOutput(true);     // Catch: Throwable -> L84
        goto L24
    L23:
        t.a(null);     // Catch: Throwable -> L84
    L84:
        th = th;
        r115 = null;
        r18 = null;
        r114 = null;
        goto L103
    }

    public static com.bytedance.bdinstall.e.a a(int r9, String r10, HashMap<String, String> r11, byte[] r12) {
        if (t.a() == false) goto L16;
        t.a("http: " + r10);
        if (r11 == null) goto L14;
        Iterator<Map.Entry<String, String>> r2 = r11.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r4.getKey(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L8;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r4.getValue(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L8;
        t.a("http headers key:" + ((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin")) + " value:" + ((String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.aiagent.plugin")));
    L14:
        if (r12 == null) goto L16;
        t.a("http data length:" + r12.length);
    L16:
        com.bytedance.bdinstall.e.a r3 = null;
        BufferedReader r5 = null;
        r3 = null;
        r3 = null;
        HttpURLConnection r6 = (HttpURLConnection) ZeusTransformUtils.preCheckCast(a(new URL(r10)), HttpURLConnection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L75
        if (r9 != 0) goto L21;
        r6.setDoOutput(false);     // Catch: Throwable -> L75
    L24:
        r6.setRequestMethod(f6436a[r9]);     // Catch: Throwable -> L75
        if (r11 != null) goto L27;
    L37:
        r6.setRequestProperty(DownloadHelper.ACCEPT_ENCODING, DownloadHelper.GZIP);     // Catch: Throwable -> L75
        if (r12 != null) goto L40;
    L43:
        DataOutputStream r13 = null;
    L44:
        int r14 = r6.getResponseCode();     // Catch: Throwable -> L72
        if (r14 != 200) goto L71;
        if (r6.getContentLength() >= 10240) goto L63;
        InputStream r7 = r6.getInputStream();     // Catch: Throwable -> L72
        if (DownloadHelper.GZIP.equalsIgnoreCase(r6.getContentEncoding()) == false) goto L51;
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new GZIPInputStream(r7)));     // Catch: Throwable -> L72
    L116:
        StringBuilder r8 = new StringBuilder(r7.available());     // Catch: Throwable -> L61
    L53:
        String r15 = r1.readLine();     // Catch: Throwable -> L61
        if (r15 == null) goto L56;
        r8.append(r15).append("\n");     // Catch: Throwable -> L61
        goto L53
    L56:
        String r16 = r8.toString();     // Catch: Throwable -> L61
        JSONObject r17 = new JSONObject(r16);     // Catch: Throwable -> L59
        r17.put("HttpCode", 200);     // Catch: Throwable -> L59
        r17.put("Set-Cookie", r6.getHeaderField("Set-Cookie"));     // Catch: Throwable -> L59
        List<Pair<String, String>> r18 = com.bytedance.bdinstall.j.l.a(r6.getHeaderFields());     // Catch: Throwable -> L59
        r16 = r17.toString();     // Catch: Throwable -> L59
        com.bytedance.bdinstall.e.a r0 = new com.bytedance.bdinstall.e.a(r10, r14, r18, r16);     // Catch: Throwable -> L59
        r5 = r1;
    L65:
        if (r13 != null) goto L103;
    L67:
        if (r5 != null) goto L111;
    L69:
        r3 = r0;
    L84:
        if (t.a() == false) goto L86;
        t.a("http response: " + r16);
    L86:
        return r3;
    L111:
        r5.close();     // Catch: IOException -> L96
        goto L69
    L103:
        r13.close();     // Catch: IOException -> L95
    L59:
        Throwable th = th;
    L74:
        Throwable r19 = th;
        DataOutputStream r110 = r13;
        th = r19;
    L101:
        t.a(th);     // Catch: Throwable -> L89
        if (ZeusTransformUtils.instanceOf(th, aw.class) == true) goto L88;
        if (r110 != null) goto L109;
    L81:
        if (r1 == null) goto L84;
        r1.close();     // Catch: IOException -> L97
        goto L84
    L109:
        r110.close();     // Catch: IOException -> L98
        goto L81
    L88:
        throw ((aw) ZeusTransformUtils.preCheckCast(th, aw.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        if (r110 != null) goto L105;
    L92:
        if (r1 == null) goto L137;
        r1.close();     // Catch: IOException -> L100
        throw th;
    L138:
        throw th;
    L137:
        throw th;
    L105:
        r110.close();     // Catch: IOException -> L99
    L61:
        th = th;
        r16 = null;
        goto L74
    L51:
        r1 = new BufferedReader(new InputStreamReader(r7));     // Catch: Throwable -> L72
        goto L116
    L63:
        t.a(null);     // Catch: Throwable -> L72
        r0 = null;
        r16 = null;
        goto L65
    L71:
        throw new aw(r14, r6.getResponseMessage());     // Catch: Throwable -> L72
    L40:
        if (r12.length <= 0) goto L43;
        r13 = new DataOutputStream(r6.getOutputStream());     // Catch: Throwable -> L75
        r13.write(r12);     // Catch: Throwable -> L72
        r13.flush();     // Catch: Throwable -> L72
        r13.close();     // Catch: Throwable -> L72
    L72:
        th = th;
        r1 = null;
        r16 = null;
        goto L74
    L27:
        if (r11.isEmpty() == true) goto L37;
        Iterator<Map.Entry<String, String>> r20 = r11.entrySet().iterator();     // Catch: Throwable -> L75
    L30:
        if (r20.hasNext() == false) goto L37;
        Map.Entry r111 = (Map.Entry) ZeusTransformUtils.preCheckCast(r20.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L75
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r111.getKey(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L36;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r111.getValue(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L36;
        r6.addRequestProperty((String) ZeusTransformUtils.preCheckCast(r111.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r111.getValue(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L75
    L36:
        t.a(null);     // Catch: Throwable -> L75
        goto L30
    L21:
        if (r9 != 1) goto L23;
        r6.setDoOutput(true);     // Catch: Throwable -> L75
        goto L24
    L23:
        t.a(null);     // Catch: Throwable -> L75
    L75:
        th = th;
        r110 = null;
        r1 = null;
        r16 = null;
        goto L101
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
