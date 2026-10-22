package com.fasterxml.jackson.databind.j.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StdDelegatingSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class ae extends aj<Object> implements com.fasterxml.jackson.databind.j.j, com.fasterxml.jackson.databind.j.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.l.j<Object, ?> f12876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.p<Object> f12878c;

    public ae(com.fasterxml.jackson.databind.l.j<Object, ?> r3, com.fasterxml.jackson.databind.k r4, com.fasterxml.jackson.databind.p<?> r5) {
        com.fasterxml.jackson.databind.l.j<Object, ?> r6 = (com.fasterxml.jackson.databind.l.j) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.l.j.class, "com.obric.aiagent.plugin");
        super(r4);
        this.f12876a = r6;
        this.f12877b = r4;
        this.f12878c = r5;
    }

    public ae a(com.fasterxml.jackson.databind.l.j<Object, ?> r3, com.fasterxml.jackson.databind.k r4, com.fasterxml.jackson.databind.p<?> r5) {
        com.fasterxml.jackson.databind.l.j r6 = (com.fasterxml.jackson.databind.l.j) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.l.j.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.l.h.a(ae.class, this, "withDelegate");
        return new ae(r6, r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.j.p
    public void a(com.fasterxml.jackson.databind.ac r3) {
        com.fasterxml.jackson.databind.p<Object> r0 = this.f12878c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r0, com.fasterxml.jackson.databind.j.p.class) == false) goto L9;
        ((com.fasterxml.jackson.databind.j.p) ZeusTransformUtils.preCheckCast(this.f12878c, com.fasterxml.jackson.databind.j.p.class, "com.obric.aiagent.plugin")).a(r3);
        return;
    }

    @Override // com.fasterxml.jackson.databind.j.j
    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.ac r4, com.fasterxml.jackson.databind.d r5) {
        com.fasterxml.jackson.databind.d r6 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.p<?> r0 = this.f12878c;
        com.fasterxml.jackson.databind.k r1 = this.f12877b;
        if (r0 != null) goto L10;
        if (r1 != null) goto L7;
        r1 = this.f12876a.b(r4.b());
    L7:
        if (r1.t() == true) goto L10;
        r0 = r4.a(r1);
    L10:
        if (ZeusTransformUtils.instanceOf(r0, com.fasterxml.jackson.databind.j.j.class) == false) goto L13;
        r0 = r4.b(r0, r6);
    L13:
        if (r0 != this.f12878c) goto L18;
        if (r1 != this.f12877b) goto L18;
        return this;
    L18:
        return a(this.f12876a, r1, r0);
    }

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public void a(Object r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4) {
        Object r5 = a(r2);
        if (r5 != null) goto L6;
        r4.a(r3);
        return;
    L6:
        com.fasterxml.jackson.databind.p<Object> r0 = this.f12878c;
        if (r0 != null) goto L9;
        r0 = a(r5, r4);
    L9:
        r0.a(r5, r3, r4);
    }

    @Override // com.fasterxml.jackson.databind.p
    public void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
        Object r0 = a(r3);
        com.fasterxml.jackson.databind.p<Object> r1 = this.f12878c;
        if (r1 != null) goto L5;
        r1 = a(r3, r5);
    L5:
        r1.a(r0, r4, r5, r6);
    }

    @Override // com.fasterxml.jackson.databind.p
    public boolean a(com.fasterxml.jackson.databind.ac r3, Object r4) {
        Object r0 = a(r4);
        if (r0 != null) goto L5;
        return true;
    L5:
        com.fasterxml.jackson.databind.p<Object> r2 = this.f12878c;
        if (r2 != null) goto L12;
        if (r4 == null) goto L13;
        return false;
    L13:
        return true;
    L12:
        return r2.a(r3, r0);
    }

    public Object a(Object r1) {
        return this.f12876a.a(r1);
    }

    public com.fasterxml.jackson.databind.p<Object> a(Object r1, com.fasterxml.jackson.databind.ac r2) {
        return r2.c(r1.getClass());
    }
}
