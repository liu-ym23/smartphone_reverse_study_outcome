package com.a.c.b.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Always.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final a f3118a = null;

    @Override // com.a.c.b.c.e
    public String a() {
        return "*";
    }

    public String toString() {
        return "Always{}";
    }

    static {
        f3118a = new a();
    }

    private a() {
    }

    @Override // com.a.c.b.c.e
    public e a(com.a.c.b.c.a.a r3) {
        return ((com.a.c.b.c.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.a.c.b.c.a.a.class, "com.obric.aiagent.plugin")).a(this);
    }
}
