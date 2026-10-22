package com.obric.autogui.net.ttnet.b;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.article.common.network.ICommonApi;
import com.bytedance.common.utility.g;
import com.bytedance.retrofit2.ak;
import com.bytedance.retrofit2.e.i;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: CustomNetworkClient.java */
/* JADX INFO: loaded from: classes3.dex */
class c extends g {
    private static void a(g.a r2, ak<String> r3) {
        if (ZeusTransformUtils.instanceOf(r2, d.class) == false) goto L6;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.aiagent.plugin");
        r4.f29230b = com.obric.autogui.net.ttnet.e.f29244a.a(r3.d());
        return;
    }

    public static List<com.bytedance.retrofit2.b.b> a(Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r0.add(new com.bytedance.retrofit2.b.b((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin")));
        goto L8
    L10:
        return r0;
    }

    public static Pair<String, String> a(String r4) {
        Uri r5 = Uri.parse(r4);
        StringBuilder r0 = new StringBuilder();
        String r1 = r5.getScheme();
        String r2 = r5.getHost();
        int r3 = r5.getPort();
        if (r2 == null) goto L9;
        if (r1 == null) goto L6;
        r0.append(r1);
        r0.append("://");
    L6:
        r0.append(r2);
        if (r3 <= 0) goto L9;
        r0.append(':');
        r0.append(r3);
    L9:
        String r6 = r0.toString();
        String r7 = r5.getPath();
        String r8 = r5.getQuery();
        if (r8 == null) goto L13;
        r7 = r7 + "?" + r8;
    L13:
        return new Pair(r6, r7);
    }

    @Override // com.bytedance.common.utility.g
    public String a(String r4, Map<String, String> r5, g.a r6) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        Pair<String, String> r7 = a(r4);
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.first, String.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r7.second, String.class, "com.obric.aiagent.plugin");
        ICommonApi r10 = (ICommonApi) ZeusTransformUtils.preCheckCast(com.bytedance.ttnet.utils.d.a(r8, ICommonApi.class), ICommonApi.class, "com.obric.aiagent.plugin");
        List<com.bytedance.retrofit2.b.b> r11 = a(r3);
        if (r6 == null) goto L5;
        boolean r1 = r6.f6725a;
    L6:
        ak<String> r12 = r10.get(-1, r9, r11, r1).a();
        a(r6, r12);
        return (String) ZeusTransformUtils.preCheckCast(r12.f(), String.class, "com.obric.aiagent.plugin");
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.bytedance.common.utility.g
    public String a(String r11, byte[] r12, Map<String, String> r13, g.a r14) {
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        Pair<String, String> r2 = a(r11);     // Catch: Exception -> L17
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.first, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L17
        String r6 = (String) ZeusTransformUtils.preCheckCast(r2.second, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L17
        ICommonApi r4 = (ICommonApi) ZeusTransformUtils.preCheckCast(com.bytedance.ttnet.utils.d.a(r3, ICommonApi.class), ICommonApi.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L17
        String r5 = null;
        if (r15 == null) goto L6;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r15.get(DownloadHelper.CONTENT_TYPE), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L17
        r15.remove(DownloadHelper.CONTENT_TYPE);     // Catch: Exception -> L17
        r5 = r7;
    L6:
        List<com.bytedance.retrofit2.b.b> r8 = a(r15);     // Catch: Exception -> L17
        if (r14 == null) goto L9;
        boolean r9 = r14.f6725a;     // Catch: Exception -> L17
    L10:
        ak<String> r16 = r4.postData(-1, r6, new com.bytedance.retrofit2.e.g(r5, r12, new String[0]), r8, r9).a();     // Catch: Exception -> L17
        if (IAppContext.Companion.isDebug() == false) goto L13;
    L14:
        Loog.INSTANCE.d("CNC", r11 + " header : " + r16.d());     // Catch: Exception -> L17
        Loog.INSTANCE.d("CNC", r11 + " body : " + ((String) ZeusTransformUtils.preCheckCast(r16.f(), String.class, "com.obric.aiagent.plugin")));     // Catch: Exception -> L17
    L15:
        a(r14, r16);     // Catch: Exception -> L17
        return (String) ZeusTransformUtils.preCheckCast(r16.f(), String.class, "com.obric.aiagent.plugin");
    L13:
        if (IAppContext.Companion.isReleaseChannel() == true) goto L15;
    L9:
        r9 = false;
    L17:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, com.bytedance.frameworks.baselib.network.http.c.d.class) == true) goto L27;
        if (ZeusTransformUtils.instanceOf(e, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class) == true) goto L23;
        Loog.INSTANCE.e("CNC", "unhandled TTNet Exception: " + e.getClass(), e);
        throw new b(0, 0, e.getMessage(), e);
    L23:
        throw new b(((com.bytedance.frameworks.baselib.network.http.cronet.b.c) ZeusTransformUtils.preCheckCast(e, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class, "com.obric.aiagent.plugin")).c(), ((com.bytedance.frameworks.baselib.network.http.cronet.b.c) ZeusTransformUtils.preCheckCast(e, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class, "com.obric.aiagent.plugin")).d(), e.getMessage(), e);
    L27:
        throw new b(((com.bytedance.frameworks.baselib.network.http.c.d) ZeusTransformUtils.preCheckCast(e, com.bytedance.frameworks.baselib.network.http.c.d.class, "com.obric.aiagent.plugin")).a(), 0, e.getMessage(), e);
    }

    @Override // com.bytedance.common.utility.g
    public byte[] b(String r11, byte[] r12, Map<String, String> r13, g.a r14) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        InputStream r15 = null;
        Pair<String, String> r16 = a(r11);     // Catch: Throwable -> L37 Exception -> L39
        String r2 = (String) ZeusTransformUtils.preCheckCast(r16.first, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37 Exception -> L39
        String r5 = (String) ZeusTransformUtils.preCheckCast(r16.second, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37 Exception -> L39
        ICommonApi r3 = (ICommonApi) ZeusTransformUtils.preCheckCast(com.bytedance.ttnet.utils.d.a(r2, ICommonApi.class), ICommonApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37 Exception -> L39
        if (r10 == null) goto L6;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r10.get(DownloadHelper.CONTENT_TYPE), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37 Exception -> L39
        r10.remove(DownloadHelper.CONTENT_TYPE);     // Catch: Throwable -> L37 Exception -> L39
    L7:
        List<com.bytedance.retrofit2.b.b> r7 = a(r10);     // Catch: Throwable -> L37 Exception -> L39
        if (r14 == null) goto L10;
        boolean r8 = r14.f6725a;     // Catch: Throwable -> L37 Exception -> L39
    L11:
        InputStream r17 = ((i) ZeusTransformUtils.preCheckCast(r3.postDataStream(-1, r5, new com.bytedance.retrofit2.e.g(r4, r12, new String[0]), r7, r8).a().f(), i.class, "com.obric.aiagent.plugin")).e_();     // Catch: Throwable -> L37 Exception -> L39
        ByteArrayOutputStream r18 = new ByteArrayOutputStream();     // Catch: Throwable -> L33 Exception -> L35
    L76:
        byte[] r19 = new byte[1024];     // Catch: Throwable -> L29 Exception -> L31
    L15:
        int r110 = r17.read(r19);     // Catch: Throwable -> L29 Exception -> L31
        if (r110 == (-1)) goto L18;
        r18.write(r19, 0, r110);     // Catch: Throwable -> L29 Exception -> L31
        goto L15
    L18:
        byte[] r111 = r18.toByteArray();     // Catch: Throwable -> L29 Exception -> L31
        if (r17 != null) goto L67;
    L63:
        r18.close();     // Catch: IOException -> L26
    L28:
        return r111;
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L67:
        r17.close();     // Catch: IOException -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L63
    L31:
        e = move-exception;
        r15 = r17;
        e = e;
    L71:
    L51:
        th = th;
    L52:
        if (r15 != null) goto L65;
    L57:
        if (r18 == null) goto L79;
        r18.close();     // Catch: IOException -> L60
        throw th;
    L60:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L79:
        throw th;
    L65:
        r15.close();     // Catch: IOException -> L55
    L55:
        e = move-exception;
        e.printStackTrace();
        goto L57
    L42:
        if (ZeusTransformUtils.instanceOf(e, com.bytedance.frameworks.baselib.network.http.c.d.class) == true) goto L50;
        if (ZeusTransformUtils.instanceOf(e, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class) == false) goto L48;
        throw new com.bytedance.common.utility.b(((com.bytedance.frameworks.baselib.network.http.cronet.b.c) ZeusTransformUtils.preCheckCast(e, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class, "com.obric.aiagent.plugin")).c(), e.getMessage());     // Catch: Throwable -> L51
    L48:
        throw new com.bytedance.common.utility.b(0, e.getMessage());     // Catch: Throwable -> L51
    L50:
        throw new com.bytedance.common.utility.b(((com.bytedance.frameworks.baselib.network.http.c.d) ZeusTransformUtils.preCheckCast(e, com.bytedance.frameworks.baselib.network.http.c.d.class, "com.obric.aiagent.plugin")).a(), e.getMessage());     // Catch: Throwable -> L51
    L29:
        th = move-exception;
        r15 = r17;
        th = th;
    L35:
        e = move-exception;
        r15 = r17;
        e = e;
        r18 = null;
    L33:
        th = move-exception;
        r15 = r17;
        th = th;
        r18 = null;
        goto L52
    L10:
        r8 = false;
        goto L11
    L6:
        r4 = null;
    L39:
        e = e;
        r18 = null;
    L37:
        th = th;
        r18 = null;
        goto L52
    }
}
