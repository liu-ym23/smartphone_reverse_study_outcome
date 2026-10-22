package com.a.c.b.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Every.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f3124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.c.b.d.b f3125b;

    public d(com.a.c.b.d.b r2) {
        this(d(), r2);
    }

    public d(e r3, com.a.c.b.d.b r4) {
        this.f3124a = (e) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r3, "Expression must not be null"), e.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        r4 = new com.a.c.b.d.b(1);
    L5:
        this.f3125b = r4;
    }

    public com.a.c.b.d.b b() {
        return this.f3125b;
    }

    public e c() {
        return this.f3124a;
    }

    @Override // com.a.c.b.c.e
    public e a(com.a.c.b.c.a.a r3) {
        return ((com.a.c.b.c.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.a.c.b.c.a.a.class, "com.obric.aiagent.plugin")).a(this);
    }

    @Override // com.a.c.b.c.e
    public String a() {
        String r0 = this.f3124a.a();
        if ("*".equals(r0) == false) goto L8;
        if (this.f3125b.b().intValue() != 1) goto L8;
        return r0;
    L8:
        return String.format("%s/%s", new Object[]{r0, this.f3125b});
    }
}
