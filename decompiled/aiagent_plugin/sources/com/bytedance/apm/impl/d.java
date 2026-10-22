package com.bytedance.apm.impl;

import com.bytedance.apm.util.u;
import com.bytedance.retrofit2.ak;
import com.bytedance.retrofit2.e.i;
import com.bytedance.retrofit2.e.j;
import com.bytedance.retrofit2.e.k;
import com.bytedance.services.apm.api.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTNetMultipartUploader.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, String> f4669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, j> f4670e;

    public d(String r3, String r4, boolean r5, Map<String, String> r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        this.f4670e = new HashMap();
        this.f4666a = r3;
        this.f4669d = r7;
        this.f4667b = r4;
        this.f4668c = r5;
    }

    @Override // com.bytedance.services.apm.api.h
    public void a(String r2, String r3) {
        this.f4670e.put(r2, new k(r3));
    }

    @Override // com.bytedance.services.apm.api.h
    public void a(String r3, File r4, String r5, Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        this.f4670e.put(r3, new c(r7, new com.bytedance.retrofit2.e.h(null, r4)));
    }

    @Override // com.bytedance.services.apm.api.h
    public void a(String r2, String r3, String r4, Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        this.f4670e.put(r2, new b(r2, r3, r6));
    }

    @Override // com.bytedance.services.apm.api.h
    public com.bytedance.services.apm.api.c a() {
        return a(this.f4666a, this.f4670e, this.f4669d);
    }

    private com.bytedance.services.apm.api.c a(String r5, Map<String, j> r6, Map<String, String> r7) {
        Map<String, j> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        RetrofitMonitorService r9 = (RetrofitMonitorService) ZeusTransformUtils.preCheckCast(com.bytedance.ttnet.utils.d.a(r5, RetrofitMonitorService.class), RetrofitMonitorService.class, "com.obric.aiagent.plugin");
        HashMap r1 = new HashMap();
        ak<i> r10 = r9.uploadFiles(r5, r4, DefaultTTNetImpl.convertHeaderMap(r8)).a();     // Catch: Throwable -> L11
        byte[] r11 = DefaultTTNetImpl.toByteArray(((i) ZeusTransformUtils.preCheckCast(r10.f(), i.class, "com.obric.aiagent.plugin")).e_());     // Catch: Throwable -> L11
        List<com.bytedance.retrofit2.b.b> r12 = r10.d();     // Catch: Throwable -> L11
        if (com.bytedance.apm.util.j.a(r12) == true) goto L9;
        Iterator<com.bytedance.retrofit2.b.b> r13 = r12.iterator();     // Catch: Throwable -> L11
    L7:
        if (r13.hasNext() == false) goto L9;
        com.bytedance.retrofit2.b.b r14 = (com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r13.next(), com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        r1.put(r14.a(), r14.b());     // Catch: Throwable -> L11
    L9:
        int r15 = r10.c();     // Catch: Throwable -> L11
    L19:
        return new com.bytedance.services.apm.api.c(r15, r1, r11);
    L11:
        th = move-exception;
        th.printStackTrace();
        JSONObject r16 = new JSONObject();
        r16.put("exception", th.getMessage() + u.a(th));     // Catch: Exception -> L15
        r16.put("exception_object", th.toString());     // Catch: Exception -> L15
    L17:
        r11 = r16.toString().getBytes();
        r15 = 100001;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }
}
