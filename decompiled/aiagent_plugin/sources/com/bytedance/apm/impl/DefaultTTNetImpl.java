package com.bytedance.apm.impl;

import com.bytedance.apm.util.j;
import com.bytedance.retrofit2.ak;
import com.bytedance.retrofit2.e;
import com.bytedance.retrofit2.e.g;
import com.bytedance.retrofit2.e.i;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DefaultTTNetImpl implements IHttpService {
    public DefaultTTNetImpl() {
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public com.bytedance.services.apm.api.c doPost(String r6, byte[] r7, Map<String, String> r8) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        RetrofitMonitorService r9 = (RetrofitMonitorService) ZeusTransformUtils.preCheckCast(com.bytedance.ttnet.utils.d.a(r6, RetrofitMonitorService.class), RetrofitMonitorService.class, "com.obric.aiagent.plugin");
        List<com.bytedance.retrofit2.b.b> r10 = convertHeaderMap(r5);
        int r2 = 0;
        e<i> r11 = r9.report(r6, new g("application/json; charset=utf-8", r7, new String[0]), r10, false);
        HashMap r12 = new HashMap();
        byte[] r13 = null;
        ak<i> r14 = r11.a();     // Catch: Throwable -> L11
        r13 = toByteArray(((i) ZeusTransformUtils.preCheckCast(r14.f(), i.class, "com.obric.aiagent.plugin")).e_());     // Catch: Throwable -> L11
        List<com.bytedance.retrofit2.b.b> r15 = r14.d();     // Catch: Throwable -> L11
        if (j.a(r15) == true) goto L9;
        Iterator<com.bytedance.retrofit2.b.b> r16 = r15.iterator();     // Catch: Throwable -> L11
    L7:
        if (r16.hasNext() == false) goto L9;
        com.bytedance.retrofit2.b.b r1 = (com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r16.next(), com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        r12.put(r1.a(), r1.b());     // Catch: Throwable -> L11
    L9:
        int r17 = r14.c();     // Catch: Throwable -> L11
    L21:
        return new com.bytedance.services.apm.api.c(r17, r12, r13);
    L11:
        th = move-exception;
        if (ZeusTransformUtils.instanceOf(th, com.bytedance.frameworks.baselib.network.http.c.d.class) == false) goto L16;
        r2 = ((com.bytedance.frameworks.baselib.network.http.c.d) ZeusTransformUtils.preCheckCast(th, com.bytedance.frameworks.baselib.network.http.c.d.class, "com.obric.aiagent.plugin")).a();     // Catch: Exception -> L22
    L16:
        if (ZeusTransformUtils.instanceOf(th, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class) == false) goto L19;
        r17 = ((com.bytedance.frameworks.baselib.network.http.cronet.b.c) ZeusTransformUtils.preCheckCast(th, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class, "com.obric.aiagent.plugin")).c();     // Catch: Exception -> L22
    L19:
        r17 = r2;
        goto L21
    }

    public static List<com.bytedance.retrofit2.b.b> convertHeaderMap(Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        ArrayList r0 = new ArrayList();
        if (r7 != null) goto L5;
    L13:
        com.bytedance.services.apm.api.i r8 = com.bytedance.apm.c.k();
        if (r8 == null) goto L26;
        Map<String, String> r9 = r8.a();
        if (r9 == null) goto L26;
        if (r9.isEmpty() == true) goto L26;
        Iterator<Map.Entry<String, String>> r10 = r9.entrySet().iterator();
    L21:
        if (r10.hasNext() == false) goto L26;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L21;
        r0.add(new com.bytedance.retrofit2.b.b((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin")));
    L26:
        return r0;
    L5:
        if (r7.isEmpty() == true) goto L13;
        Iterator r11 = r7.entrySet().iterator();
    L8:
        if (r11.hasNext() == false) goto L13;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L8;
        r0.add(new com.bytedance.retrofit2.b.b((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.aiagent.plugin")));
        goto L8
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public com.bytedance.services.apm.api.c doGet(String r5, Map<String, String> r6) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        List<com.bytedance.retrofit2.b.b> r7 = convertHeaderMap(null);
        RetrofitMonitorService r1 = (RetrofitMonitorService) ZeusTransformUtils.preCheckCast(com.bytedance.ttnet.utils.d.a(r5, RetrofitMonitorService.class), RetrofitMonitorService.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
    L7:
        e<i> r8 = r1.fetch(r5, r4, false);
    L8:
        ak<i> r9 = r8.a();
        byte[] r10 = toByteArray(((i) ZeusTransformUtils.preCheckCast(r9.f(), i.class, "com.obric.aiagent.plugin")).e_());
        return new com.bytedance.services.apm.api.c(r9.c(), r10);
    L5:
        if (r7.size() <= 0) goto L7;
        r8 = r1.fetch(r5, r7, r4, false);
        goto L8
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public com.bytedance.services.apm.api.c uploadFiles(String r2, List<File> r3, Map<String, String> r4) {
        return com.bytedance.apm.util.e.a(r2, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public h buildMultipartUpload(String r2, String r3, boolean r4) {
        return new d(r2, r3, r4, null);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public h buildMultipartUpload(String r2, String r3, boolean r4, Map<String, String> r5) {
        return new d(r2, r3, r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin"));
    }

    public static byte[] toByteArray(InputStream r5) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[8192];
        if (r5 == null) goto L5;
    L6:
        int r4 = r5.read(r1);
        if ((-1) == r4) goto L9;
        r0.write(r1, 0, r4);
        goto L6
    L9:
        r5.close();
        return r0.toByteArray();
    L5:
        return new byte[0];
    }
}
