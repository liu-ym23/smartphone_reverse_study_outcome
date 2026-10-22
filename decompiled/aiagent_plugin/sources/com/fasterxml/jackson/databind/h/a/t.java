package com.fasterxml.jackson.databind.h.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TypeSerializerBase.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class t extends com.fasterxml.jackson.databind.h.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.h.f f12743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.d f12744c;

    @Override // com.fasterxml.jackson.databind.h.h
    public String b() {
        return null;
    }

    public void b(Object r1) {
    }

    public t(com.fasterxml.jackson.databind.h.f r3, com.fasterxml.jackson.databind.d r4) {
        com.fasterxml.jackson.databind.h.f r5 = (com.fasterxml.jackson.databind.h.f) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.h.f.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.d r6 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        this.f12743b = r5;
        this.f12744c = r6;
    }

    @Override // com.fasterxml.jackson.databind.h.h
    public com.fasterxml.jackson.a.g.b a(com.fasterxml.jackson.a.h r1, com.fasterxml.jackson.a.g.b r2) {
        a(r2);
        return r1.a(r2);
    }

    @Override // com.fasterxml.jackson.databind.h.h
    public com.fasterxml.jackson.a.g.b b(com.fasterxml.jackson.a.h r1, com.fasterxml.jackson.a.g.b r2) {
        return r1.b(r2);
    }

    public void a(com.fasterxml.jackson.a.g.b r3) {
        if (r3.f12069c != null) goto L10;
        Object r0 = r3.f12067a;
        Class<?> r1 = r3.f12068b;
        if (r1 != null) goto L7;
        String r2 = a(r0);
    L8:
        r3.f12069c = r2;
        return;
    L7:
        r2 = a(r0, r1);
        goto L8
    }

    public String a(Object r2) {
        String r0 = this.f12743b.a(r2);
        if (r0 != null) goto L5;
        b(r2);
    L5:
        return r0;
    }

    public String a(Object r2, Class<?> r3) {
        String r4 = this.f12743b.a(r2, r3);
        if (r4 != null) goto L5;
        b(r2);
    L5:
        return r4;
    }
}
