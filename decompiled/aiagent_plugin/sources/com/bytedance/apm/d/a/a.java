package com.bytedance.apm.d.a;

import com.bytedance.apm.h.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: CommonDataPipeline.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.apm.d.a<com.bytedance.apm.d.b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f4534c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f4535b;

    private a() {
    }

    public static a c() {
        if (f4534c != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f4534c != null) goto L9;
        f4534c = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f4534c;
    }

    public void a(b r3) {
        this.f4535b = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.apm.d.a
    public void d(com.bytedance.apm.d.b r8) {
        com.bytedance.apm.d.b r9 = (com.bytedance.apm.d.b) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.apm.d.b.class, "com.obric.aiagent.plugin");
        JSONObject r6 = r9.a();
        boolean r4 = r9.a(r6);
        if (com.bytedance.apm.c.i() == true) goto L16;
    L8:
        if (r4 == false) goto L10;
    L12:
        a(r9.b(), r9.c(), r6, r4, false);
        b r7 = this.f4535b;
        if (r7 == null) goto L18;
        r7.a(r9.b(), r9.c(), r6);
        return;
    L18:
        return;
    L10:
        if (r9.d() == true) goto L12;
        return;
    L16:
        e.a(com.bytedance.apm.h.b.h, new Object[]{"logType: " + r9.b() + ", subType: " + r9.c() + "data: " + r6, " ,sample: " + r4});     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }
}
