package com.bytedance.article.common.network;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.common.utility.g;
import com.bytedance.frameworks.baselib.network.http.cronet.b.c;
import com.bytedance.retrofit2.b.b;
import com.bytedance.retrofit2.e.i;
import com.bytedance.ttnet.utils.d;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SSNetworkClient.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends g {
    public a() {
    }

    private static List<b> a(Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r0.add(new b((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin")));
        goto L8
    L10:
        return r0;
    }

    private static Pair<String, String> a(String r4) {
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
    public String a(String r3, Map<String, String> r4, g.a r5) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        Pair<String, String> r6 = a(r3);
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.first, String.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r6.second, String.class, "com.obric.aiagent.plugin");
        ICommonApi r9 = (ICommonApi) ZeusTransformUtils.preCheckCast(d.a(r7, ICommonApi.class), ICommonApi.class, "com.obric.aiagent.plugin");
        List<b> r10 = a(r2);
        if (r5 == null) goto L5;
        boolean r11 = r5.f6725a;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(r9.get(-1, r8, r10, r11).a().f(), String.class, "com.obric.aiagent.plugin");
    L5:
        r11 = false;
        goto L7
    }

    @Override // com.bytedance.common.utility.g
    public String a(String r9, byte[] r10, Map<String, String> r11, g.a r12) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        Pair<String, String> r13 = a(r9);     // Catch: Exception -> L12
        String r1 = (String) ZeusTransformUtils.preCheckCast(r13.first, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        String r4 = (String) ZeusTransformUtils.preCheckCast(r13.second, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        ICommonApi r2 = (ICommonApi) ZeusTransformUtils.preCheckCast(d.a(r1, ICommonApi.class), ICommonApi.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        String r14 = null;
        if (r8 == null) goto L6;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r8.get(DownloadHelper.CONTENT_TYPE), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        r8.remove(DownloadHelper.CONTENT_TYPE);     // Catch: Exception -> L12
        r14 = r3;
    L6:
        List<b> r6 = a(r8);     // Catch: Exception -> L12
        if (r12 == null) goto L9;
        boolean r7 = r12.f6725a;     // Catch: Exception -> L12
    L10:
        return (String) ZeusTransformUtils.preCheckCast(r2.postData(-1, r4, new com.bytedance.retrofit2.e.g(r14, r10, new String[0]), r6, r7).a().f(), String.class, "com.obric.aiagent.plugin");
    L9:
        r7 = false;
    L12:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, com.bytedance.frameworks.baselib.network.http.c.d.class) == true) goto L22;
        if (ZeusTransformUtils.instanceOf(e, c.class) == false) goto L20;
        throw new com.bytedance.common.utility.b(((c) ZeusTransformUtils.preCheckCast(e, c.class, "com.obric.aiagent.plugin")).c(), e.getMessage());
    L20:
        throw new com.bytedance.common.utility.b(0, e.getMessage());
    L22:
        throw new com.bytedance.common.utility.b(((com.bytedance.frameworks.baselib.network.http.c.d) ZeusTransformUtils.preCheckCast(e, com.bytedance.frameworks.baselib.network.http.c.d.class, "com.obric.aiagent.plugin")).a(), e.getMessage());
    }

    @Override // com.bytedance.common.utility.g
    public byte[] b(String r11, byte[] r12, Map<String, String> r13, g.a r14) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        InputStream r15 = null;
        Pair<String, String> r16 = a(r11);     // Catch: Throwable -> L37 Exception -> L39
        String r2 = (String) ZeusTransformUtils.preCheckCast(r16.first, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37 Exception -> L39
        String r5 = (String) ZeusTransformUtils.preCheckCast(r16.second, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37 Exception -> L39
        ICommonApi r3 = (ICommonApi) ZeusTransformUtils.preCheckCast(d.a(r2, ICommonApi.class), ICommonApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37 Exception -> L39
        if (r10 == null) goto L6;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r10.get(DownloadHelper.CONTENT_TYPE), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37 Exception -> L39
        r10.remove(DownloadHelper.CONTENT_TYPE);     // Catch: Throwable -> L37 Exception -> L39
    L7:
        List<b> r7 = a(r10);     // Catch: Throwable -> L37 Exception -> L39
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
        if (ZeusTransformUtils.instanceOf(e, c.class) == false) goto L48;
        throw new com.bytedance.common.utility.b(((c) ZeusTransformUtils.preCheckCast(e, c.class, "com.obric.aiagent.plugin")).c(), e.getMessage());     // Catch: Throwable -> L51
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
