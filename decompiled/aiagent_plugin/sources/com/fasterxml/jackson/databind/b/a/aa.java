package com.fasterxml.jackson.databind.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SetterlessProperty.java */
/* JADX INFO: loaded from: classes2.dex */
public final class aa extends com.fasterxml.jackson.databind.b.v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.e.k f12266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Method f12267d;

    public aa(com.fasterxml.jackson.databind.e.t r3, com.fasterxml.jackson.databind.k r4, com.fasterxml.jackson.databind.h.e r5, com.fasterxml.jackson.databind.l.b r6, com.fasterxml.jackson.databind.e.k r7) {
        super(r3, r4, r5, (com.fasterxml.jackson.databind.l.b) ZeusTransformUtils.wrapperContextForParams(r6, com.fasterxml.jackson.databind.l.b.class, "com.obric.aiagent.plugin"));
        this.f12266c = r7;
        this.f12267d = r7.d();
    }

    public aa(aa r3, com.fasterxml.jackson.databind.l<?> r4, com.fasterxml.jackson.databind.b.s r5) {
        super(r3, r4, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"));
        this.f12266c = r3.f12266c;
        this.f12267d = r3.f12267d;
    }

    public aa(aa r1, com.fasterxml.jackson.databind.x r2) {
        super(r1, r2);
        this.f12266c = r1.f12266c;
        this.f12267d = r1.f12267d;
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public com.fasterxml.jackson.databind.b.v a(com.fasterxml.jackson.databind.x r2) {
        return new aa(this, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public com.fasterxml.jackson.databind.b.v a(com.fasterxml.jackson.databind.l<?> r3) {
        if (this.m != r3) goto L6;
        return this;
    L6:
        if (this.m != this.o) goto L8;
        com.fasterxml.jackson.databind.b.s r0 = r3;
    L10:
        return new aa(this, r3, r0);
    L8:
        r0 = this.o;
        goto L10
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public com.fasterxml.jackson.databind.b.v a(com.fasterxml.jackson.databind.b.s r3) {
        com.fasterxml.jackson.databind.b.s r4 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
        return new aa(this, this.m, r4);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public void a(com.fasterxml.jackson.databind.g r2) {
        this.f12266c.a(r2.a(com.fasterxml.jackson.databind.r.o));
    }

    @Override // com.fasterxml.jackson.databind.b.v, com.fasterxml.jackson.databind.d
    public com.fasterxml.jackson.databind.e.j d() {
        return this.f12266c;
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public final void a(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8, Object r9) {
        if (r7.a(com.fasterxml.jackson.a.n.m) == false) goto L6;
        return;
    L6:
        if (this.n == null) goto L16;
        r8.b(getType(), String.format("Problem deserializing 'setterless' property (\"%s\"): no way to handle typed deser with setterless yet", new Object[]{a()}));
    L16:
        Object r10 = this.f12267d.invoke(r9, (Object[]) ZeusTransformUtils.preCheckCast(null, Object[].class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L13
        if (r10 != null) goto L11;
        r8.b(getType(), String.format("Problem deserializing 'setterless' property '%s': get method returned null", new Object[]{a()}));
    L11:
        this.m.a(r7, r8, r10);
        return;
    L13:
        e = move-exception;
        a(r7, e);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public Object b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, Object r3) {
        a(r1, r2, r3);
        return r3;
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public final void a(Object r2, Object r3) {
        throw new UnsupportedOperationException("Should never call `set()` on setterless property ('" + a() + "')");
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public Object b(Object r1, Object r2) {
        a(r1, r2);
        return r1;
    }
}
