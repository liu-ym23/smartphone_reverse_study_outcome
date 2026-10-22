package com.bytedance.apm.impl;

import com.bytedance.retrofit2.e.h;
import com.bytedance.retrofit2.e.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: MonitorFiledPart.java */
/* JADX INFO: loaded from: classes.dex */
final class c implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f4664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f4665b;

    public c(Map<String, String> r3, h r4) {
        this.f4665b = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        this.f4664a = r4;
    }

    @Override // com.bytedance.retrofit2.e.j
    public String a() {
        return e();
    }

    @Override // com.bytedance.retrofit2.e.j
    public String b() {
        return this.f4664a.b();
    }

    @Override // com.bytedance.retrofit2.e.j
    public long c() {
        return this.f4664a.c();
    }

    @Override // com.bytedance.retrofit2.e.j
    public void a(OutputStream r1) {
        this.f4664a.a(r1);
    }

    @Override // com.bytedance.retrofit2.e.j
    public String d() {
        return this.f4664a.d();
    }

    private String e() {
        StringBuilder r0 = new StringBuilder(this.f4664a.a()).append("\"");
        Iterator<Map.Entry<String, String>> r6 = this.f4665b.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin");
        r0.append("; ").append(r3).append("=\"").append((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin")).append("\"");
        goto L4
    L6:
        r0.deleteCharAt(r0.length() - 1);
        return r0.toString();
    }
}
