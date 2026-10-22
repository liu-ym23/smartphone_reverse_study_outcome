package com.a.c.b.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Between.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.c.b.d.a<?> f3122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.c.b.d.a<?> f3123b;

    public c(com.a.c.b.d.a<?> r1, com.a.c.b.d.a<?> r2) {
        this.f3122a = r1;
        this.f3123b = r2;
    }

    public com.a.c.b.d.a<?> b() {
        return this.f3122a;
    }

    public com.a.c.b.d.a<?> c() {
        return this.f3123b;
    }

    @Override // com.a.c.b.c.e
    public e a(com.a.c.b.c.a.a r3) {
        return ((com.a.c.b.c.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.a.c.b.c.a.a.class, "com.obric.aiagent.plugin")).a(this);
    }

    @Override // com.a.c.b.c.e
    public String a() {
        return String.format("%s-%s", new Object[]{this.f3122a, this.f3123b});
    }
}
