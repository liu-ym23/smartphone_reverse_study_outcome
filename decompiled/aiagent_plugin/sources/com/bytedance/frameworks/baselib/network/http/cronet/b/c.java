package com.bytedance.frameworks.baselib.network.http.cronet.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CronetIOException.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends com.bytedance.retrofit2.f.c {
    private int f;
    private final int g;
    private d h;

    public c(Exception r9, com.bytedance.frameworks.baselib.network.http.b r10, int r11) {
        String r0 = r9.getMessage();
        if (r9.getCause() != null) goto L5;
        Throwable r1 = r9;
    L6:
        super(r0, r1);
        if (r10.v == null) goto L9;
        String r2 = r10.v.toString();
    L10:
        super.a(false, true, r2, r10.P, r10);
        this.g = r11;
        if (ZeusTransformUtils.instanceOf(r9, com.bytedance.frameworks.baselib.network.http.c.d.class) == false) goto L14;
        this.f = ((com.bytedance.frameworks.baselib.network.http.c.d) ZeusTransformUtils.preCheckCast(r9, com.bytedance.frameworks.baselib.network.http.c.d.class, "com.obric.aiagent.plugin")).a();
    L14:
        if (ZeusTransformUtils.instanceOf(r10.f8138d.aF.i.g, d.class) == false) goto L17;
        this.h = (d) ZeusTransformUtils.preCheckCast(r10.f8138d.aF.i.g, d.class, "com.obric.aiagent.plugin");
        return;
    L17:
        return;
    L9:
        r2 = "";
        goto L10
    L5:
        r1 = r9.getCause();
        goto L6
    }

    public com.bytedance.frameworks.baselib.network.http.b a() {
        return (com.bytedance.frameworks.baselib.network.http.b) ZeusTransformUtils.preCheckCast(this.f9549e, com.bytedance.frameworks.baselib.network.http.b.class, "com.obric.aiagent.plugin");
    }

    public String b() {
        return a().f8134J;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.g;
    }
}
