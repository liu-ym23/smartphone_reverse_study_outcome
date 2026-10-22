package com.fasterxml.jackson.databind.j.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MapProperty.java */
/* JADX INFO: loaded from: classes2.dex */
public class t extends com.fasterxml.jackson.databind.j.o {
    private static final com.fasterxml.jackson.databind.d i = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.h.h f12915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.d f12916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Object f12917e;
    protected Object f;
    protected com.fasterxml.jackson.databind.p<Object> g;
    protected com.fasterxml.jackson.databind.p<Object> h;

    static {
        i = new com.fasterxml.jackson.databind.d.a();
    }

    public t(com.fasterxml.jackson.databind.h.h r3, com.fasterxml.jackson.databind.d r4) {
        com.fasterxml.jackson.databind.d r5 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        com.fasterxml.jackson.databind.w r0 = com.fasterxml.jackson.databind.w.f13127c;
    L6:
        super(r0);
        this.f12915c = r3;
        if (r5 != null) goto L9;
        r5 = i;
    L9:
        this.f12916d = r5;
        return;
    L5:
        r0 = r5.c();
        goto L6
    }

    public void a(Object r1, Object r2, com.fasterxml.jackson.databind.p<Object> r3, com.fasterxml.jackson.databind.p<Object> r4) {
        this.f12917e = r1;
        this.f = r2;
        this.g = r3;
        this.h = r4;
    }

    @Override // com.fasterxml.jackson.databind.d, com.fasterxml.jackson.databind.l.r
    public String a() {
        if (ZeusTransformUtils.instanceOf(this.f12917e, String.class) == false) goto L7;
        return (String) ZeusTransformUtils.preCheckCast(this.f12917e, String.class, "com.obric.aiagent.plugin");
    L7:
        return String.valueOf(this.f12917e);
    }

    @Override // com.fasterxml.jackson.databind.d
    public com.fasterxml.jackson.databind.x b() {
        return new com.fasterxml.jackson.databind.x(a());
    }

    @Override // com.fasterxml.jackson.databind.j.o
    public void a(Object r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4) {
        this.g.a(this.f12917e, r3, r4);
        com.fasterxml.jackson.databind.h.h r5 = this.f12915c;
        if (r5 != null) goto L5;
        this.h.a(this.f, r3, r4);
        return;
    L5:
        this.h.a(this.f, r3, r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.j.o
    public void b(Object r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
        if (r2.g() == true) goto L6;
        r2.f(a());
        return;
    }

    @Override // com.fasterxml.jackson.databind.d
    public com.fasterxml.jackson.databind.k getType() {
        return this.f12916d.getType();
    }

    @Override // com.fasterxml.jackson.databind.d
    public com.fasterxml.jackson.databind.e.j d() {
        return this.f12916d.d();
    }
}
