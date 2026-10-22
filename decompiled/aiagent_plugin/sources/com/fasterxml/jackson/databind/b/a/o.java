package com.fasterxml.jackson.databind.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: MethodProperty.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o extends com.fasterxml.jackson.databind.b.v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.e.k f12318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final transient Method f12319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final boolean f12320e;

    public o(com.fasterxml.jackson.databind.e.t r3, com.fasterxml.jackson.databind.k r4, com.fasterxml.jackson.databind.h.e r5, com.fasterxml.jackson.databind.l.b r6, com.fasterxml.jackson.databind.e.k r7) {
        super(r3, r4, r5, (com.fasterxml.jackson.databind.l.b) ZeusTransformUtils.wrapperContextForParams(r6, com.fasterxml.jackson.databind.l.b.class, "com.obric.aiagent.plugin"));
        this.f12318c = r7;
        this.f12319d = r7.d();
        this.f12320e = q.a(this.o);
    }

    public o(o r3, com.fasterxml.jackson.databind.l<?> r4, com.fasterxml.jackson.databind.b.s r5) {
        com.fasterxml.jackson.databind.b.s r6 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
        super(r3, r4, r6);
        this.f12318c = r3.f12318c;
        this.f12319d = r3.f12319d;
        this.f12320e = q.a(r6);
    }

    public o(o r1, com.fasterxml.jackson.databind.x r2) {
        super(r1, r2);
        this.f12318c = r1.f12318c;
        this.f12319d = r1.f12319d;
        this.f12320e = r1.f12320e;
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public com.fasterxml.jackson.databind.b.v a(com.fasterxml.jackson.databind.x r2) {
        return new o(this, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public com.fasterxml.jackson.databind.b.v a(com.fasterxml.jackson.databind.l<?> r3) {
        if (this.m != r3) goto L6;
        return this;
    L6:
        if (this.m != this.o) goto L8;
        com.fasterxml.jackson.databind.b.s r0 = r3;
    L10:
        return new o(this, r3, r0);
    L8:
        r0 = this.o;
        goto L10
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public com.fasterxml.jackson.databind.b.v a(com.fasterxml.jackson.databind.b.s r3) {
        com.fasterxml.jackson.databind.b.s r4 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
        return new o(this, this.m, r4);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public void a(com.fasterxml.jackson.databind.g r2) {
        this.f12318c.a(r2.a(com.fasterxml.jackson.databind.r.o));
    }

    @Override // com.fasterxml.jackson.databind.b.v, com.fasterxml.jackson.databind.d
    public com.fasterxml.jackson.databind.e.j d() {
        return this.f12318c;
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public void a(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5, Object r6) {
        if (r4.a(com.fasterxml.jackson.a.n.m) == false) goto L9;
        if (this.f12320e == false) goto L7;
        return;
    L7:
        Object r7 = this.o.a(r5);
    L23:
        this.f12319d.invoke(r6, new Object[]{r7});     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        a(r4, e, r7);
        return;
    L9:
        if (this.n != null) goto L17;
        Object r0 = this.m.a(r4, r5);
        if (r0 == null) goto L13;
        r7 = r0;
        goto L23
    L13:
        if (this.f12320e == false) goto L15;
        return;
    L15:
        r7 = this.o.a(r5);
        goto L23
    L17:
        r7 = this.m.a(r4, r5, this.n);
        goto L23
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public Object b(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5, Object r6) {
        if (r4.a(com.fasterxml.jackson.a.n.m) == false) goto L9;
        if (this.f12320e == false) goto L7;
        return r6;
    L7:
        Object r7 = this.o.a(r5);
    L26:
        Object r3 = this.f12319d.invoke(r6, new Object[]{r7});     // Catch: Exception -> L23
        if (r3 != null) goto L22;
        return r6;
    L22:
        return r3;
    L23:
        e = move-exception;
        a(r4, e, r7);
        return null;
    L9:
        if (this.n != null) goto L17;
        Object r0 = this.m.a(r4, r5);
        if (r0 == null) goto L13;
        r7 = r0;
        goto L26
    L13:
        if (this.f12320e == false) goto L15;
        return r6;
    L15:
        r7 = this.o.a(r5);
        goto L26
    L17:
        r7 = this.m.a(r4, r5, this.n);
        goto L26
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public final void a(Object r4, Object r5) {
        this.f12319d.invoke(r4, new Object[]{r5});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        a(e, r5);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public Object b(Object r4, Object r5) {
        Object r3 = this.f12319d.invoke(r4, new Object[]{r5});     // Catch: Exception -> L7
        if (r3 != null) goto L6;
        return r4;
    L6:
        return r3;
    L7:
        e = move-exception;
        a(e, r5);
        return null;
    }
}
