package com.fasterxml.jackson.databind.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: FieldProperty.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends com.fasterxml.jackson.databind.b.v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.e.h f12305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final transient Field f12306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final boolean f12307e;

    public i(com.fasterxml.jackson.databind.e.t r3, com.fasterxml.jackson.databind.k r4, com.fasterxml.jackson.databind.h.e r5, com.fasterxml.jackson.databind.l.b r6, com.fasterxml.jackson.databind.e.h r7) {
        super(r3, r4, r5, (com.fasterxml.jackson.databind.l.b) ZeusTransformUtils.wrapperContextForParams(r6, com.fasterxml.jackson.databind.l.b.class, "com.obric.aiagent.plugin"));
        this.f12305c = r7;
        this.f12306d = r7.d();
        this.f12307e = q.a(this.o);
    }

    public i(i r3, com.fasterxml.jackson.databind.l<?> r4, com.fasterxml.jackson.databind.b.s r5) {
        com.fasterxml.jackson.databind.b.s r6 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
        super(r3, r4, r6);
        this.f12305c = r3.f12305c;
        this.f12306d = r3.f12306d;
        this.f12307e = q.a(r6);
    }

    public i(i r1, com.fasterxml.jackson.databind.x r2) {
        super(r1, r2);
        this.f12305c = r1.f12305c;
        this.f12306d = r1.f12306d;
        this.f12307e = r1.f12307e;
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public com.fasterxml.jackson.databind.b.v a(com.fasterxml.jackson.databind.x r2) {
        return new i(this, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public com.fasterxml.jackson.databind.b.v a(com.fasterxml.jackson.databind.l<?> r3) {
        if (this.m != r3) goto L6;
        return this;
    L6:
        if (this.m != this.o) goto L8;
        com.fasterxml.jackson.databind.b.s r0 = r3;
    L10:
        return new i(this, r3, r0);
    L8:
        r0 = this.o;
        goto L10
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public com.fasterxml.jackson.databind.b.v a(com.fasterxml.jackson.databind.b.s r3) {
        com.fasterxml.jackson.databind.b.s r4 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
        return new i(this, this.m, r4);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public void a(com.fasterxml.jackson.databind.g r2) {
        com.fasterxml.jackson.databind.l.h.a(this.f12306d, r2.a(com.fasterxml.jackson.databind.r.o));
    }

    @Override // com.fasterxml.jackson.databind.b.v, com.fasterxml.jackson.databind.d
    public com.fasterxml.jackson.databind.e.j d() {
        return this.f12305c;
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public void a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
        if (r3.a(com.fasterxml.jackson.a.n.m) == false) goto L9;
        if (this.f12307e == false) goto L7;
        return;
    L7:
        Object r6 = this.o.a(r4);
    L23:
        this.f12306d.set(r5, r6);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        a(r3, e, r6);
        return;
    L9:
        if (this.n != null) goto L17;
        Object r0 = this.m.a(r3, r4);
        if (r0 == null) goto L13;
        r6 = r0;
        goto L23
    L13:
        if (this.f12307e == false) goto L15;
        return;
    L15:
        r6 = this.o.a(r4);
        goto L23
    L17:
        r6 = this.m.a(r3, r4, this.n);
        goto L23
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public Object b(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
        if (r3.a(com.fasterxml.jackson.a.n.m) == false) goto L9;
        if (this.f12307e == false) goto L7;
        return r5;
    L7:
        Object r6 = this.o.a(r4);
    L23:
        this.f12306d.set(r5, r6);     // Catch: Exception -> L20
    L22:
        return r5;
    L20:
        e = move-exception;
        a(r3, e, r6);
        goto L22
    L9:
        if (this.n != null) goto L17;
        Object r0 = this.m.a(r3, r4);
        if (r0 == null) goto L13;
        r6 = r0;
        goto L23
    L13:
        if (this.f12307e == false) goto L15;
        return r5;
    L15:
        r6 = this.o.a(r4);
        goto L23
    L17:
        r6 = this.m.a(r3, r4, this.n);
        goto L23
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public void a(Object r2, Object r3) {
        this.f12306d.set(r2, r3);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        a(e, r3);
    }

    @Override // com.fasterxml.jackson.databind.b.v
    public Object b(Object r2, Object r3) {
        this.f12306d.set(r2, r3);     // Catch: Exception -> L4
    L6:
        return r2;
    L4:
        e = move-exception;
        a(e, r3);
        goto L6
    }
}
