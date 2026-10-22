package com.bytedance.ttnet.utils;

import android.util.Pair;
import com.bytedance.retrofit2.ab;
import com.bytedance.retrofit2.c.aa;
import com.bytedance.retrofit2.c.ag;
import com.bytedance.retrofit2.c.h;
import com.bytedance.retrofit2.c.l;
import com.bytedance.retrofit2.c.y;
import com.bytedance.retrofit2.e.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TTNetProtocolUtil {

    public interface Service {
        @y(a = 3)
        @h
        com.bytedance.retrofit2.e<i> getCall(@ag String r1, @aa(a = true) Map<String, String> r2, @com.bytedance.retrofit2.c.a boolean r3, @l List<com.bytedance.retrofit2.b.b> r4);
    }

    public static void a(String r7, String r8, Map<String, String> r9, Map<String, String> r10) {
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        String r13 = "https://" + r7 + r8;
        Pair<String, String> r14 = com.bytedance.frameworks.baselib.network.http.i.l.a(r13, r11);
        String r0 = (String) ZeusTransformUtils.preCheckCast(r14.first, String.class, "com.obric.aiagent.plugin");
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.second, String.class, "com.obric.aiagent.plugin");
        ab r2 = d.b(r0);
        if (r2 == null) goto L24;
        Service r1 = (Service) ZeusTransformUtils.preCheckCast(r2.a(Service.class), Service.class, "com.obric.aiagent.plugin");
        ArrayList r3 = new ArrayList();
        r3.add(new com.bytedance.retrofit2.b.b("x-ttnet-protocol-handler", "1"));
        r3.add(new com.bytedance.retrofit2.b.b("x-metasec-bypass-ttnet-features", "1"));
        if (r12 != null) goto L7;
    L12:
        com.bytedance.retrofit2.e<i> r16 = r1.getCall(r15, r11, false, r3);
        r16.a();     // Catch: Throwable -> L16 Exception -> L18
        r16.b();
        return;
    L18:
        e = move-exception;
        throw new IOException("TTNet-protocol request execution failed for URL: " + r13, e);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r16.b();
        throw th;
    L7:
        if (r12.isEmpty() == true) goto L12;
        Iterator r17 = r12.entrySet().iterator();
    L10:
        if (r17.hasNext() == false) goto L12;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r17.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r3.add(new com.bytedance.retrofit2.b.b((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.aiagent.plugin")));
        goto L10
    L24:
        throw new IOException("Failed to get Retrofit instance for base URL: " + r0);
    }

    public static void a(String r6, String r7, Map<String, String> r8, Map<String, String> r9, com.bytedance.retrofit2.h<i> r10) {
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        com.bytedance.retrofit2.h<i> r13 = (com.bytedance.retrofit2.h) ZeusTransformUtils.wrapperContextForParams(r10, com.bytedance.retrofit2.h.class, "com.obric.aiagent.plugin");
        Pair<String, String> r14 = com.bytedance.frameworks.baselib.network.http.i.l.a("https://" + r6 + r7, r11);
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.first, String.class, "com.obric.aiagent.plugin");
        String r16 = (String) ZeusTransformUtils.preCheckCast(r14.second, String.class, "com.obric.aiagent.plugin");
        ab r0 = d.b(r15);
        if (r0 == null) goto L15;
        Service r17 = (Service) ZeusTransformUtils.preCheckCast(r0.a(Service.class), Service.class, "com.obric.aiagent.plugin");
        ArrayList r1 = new ArrayList();
        r1.add(new com.bytedance.retrofit2.b.b("x-ttnet-protocol-handler", "1"));
        r1.add(new com.bytedance.retrofit2.b.b("x-metasec-bypass-ttnet-features", "1"));
        if (r12 != null) goto L7;
    L12:
        r17.getCall(r16, r11, false, r1).a(r13);
        return;
    L7:
        if (r12.isEmpty() == true) goto L12;
        Iterator r18 = r12.entrySet().iterator();
    L10:
        if (r18.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r1.add(new com.bytedance.retrofit2.b.b((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin")));
        goto L10
    L15:
        throw new IOException("Failed to get Retrofit instance for base URL: " + r15);
    }
}
