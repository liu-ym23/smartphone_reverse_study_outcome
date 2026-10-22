package com.bytedance.bdturing.ttnet;

import com.bytedance.retrofit2.ak;
import com.bytedance.retrofit2.e;
import com.bytedance.retrofit2.e.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: TTNetUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static byte[] a(String r2, String r3, Map<String, String> r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        List<com.bytedance.retrofit2.b.b> r7 = a((Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin"));
        e<i> r8 = a(r2).doGet(true, r2, r6, r7);
        ak<i> r9 = r8.a();     // Catch: Throwable -> L11 Exception -> L15
        if (r9.c() != 200) goto L9;
        byte[] r10 = a(((i) ZeusTransformUtils.preCheckCast(r9.f(), i.class, "com.obric.aiagent.plugin")).e_());     // Catch: Throwable -> L11 Exception -> L15
        if (r8 == null) goto L8;
        r8.b();
    L8:
        return r10;
    L9:
        if (r8 == null) goto L18;
    L16:
        r8.b();
    L18:
        return new byte[0];
    L15:
        if (r8 == null) goto L18;
    L11:
        th = move-exception;
        if (r8 == null) goto L14;
        r8.b();
    L14:
        throw th;
    }

    public static byte[] a(String r2, String r3, Map<String, String> r4, final byte[] r5, Map<String, String> r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        List<com.bytedance.retrofit2.b.b> r8 = a((Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin"));
        e<i> r9 = a(r2).doPost(r2, r7, new AnonymousClass1(r5), r8);
        ak<i> r10 = r9.a();     // Catch: Throwable -> L11 Exception -> L15
        if (r10.c() != 200) goto L9;
        byte[] r11 = a(((i) ZeusTransformUtils.preCheckCast(r10.f(), i.class, "com.obric.aiagent.plugin")).e_());     // Catch: Throwable -> L11 Exception -> L15
        if (r9 == null) goto L8;
        r9.b();
    L8:
        return r11;
    L9:
        if (r9 == null) goto L18;
    L16:
        r9.b();
    L18:
        return new byte[0];
    L15:
        if (r9 == null) goto L18;
    L11:
        th = move-exception;
        if (r9 == null) goto L14;
        r9.b();
    L14:
        throw th;
    }

    private static byte[] a(InputStream r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[1024];
    L3:
        int r2 = r4.read(r1);
        if (r2 == (-1)) goto L7;
        r0.write(r1, 0, r2);
        goto L3
    L7:
        return r0.toByteArray();
    }

    private static List<com.bytedance.retrofit2.b.b> a(Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        LinkedList r0 = new LinkedList();
        if (r7 == null) goto L8;
        Iterator r8 = r7.entrySet().iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r0.add(new com.bytedance.retrofit2.b.b((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin")));
    L8:
        return r0;
    }

    public static void a() {
        com.bytedance.ttnet.utils.d.a(a.a());
    }

    private static INetworkApi a(String r2) {
        return (INetworkApi) ZeusTransformUtils.preCheckCast(com.bytedance.ttnet.utils.d.b(r2).a(INetworkApi.class), INetworkApi.class, "com.obric.aiagent.plugin");
    }
}
