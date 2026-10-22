package com.fasterxml.jackson.databind.b.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StdDelegatingDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class aa<T> extends ab<T> implements com.fasterxml.jackson.databind.b.i, com.fasterxml.jackson.databind.b.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.l.j<Object, T> f12372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.l<Object> f12374c;

    public aa(com.fasterxml.jackson.databind.l.j<?, T> r3) {
        com.fasterxml.jackson.databind.l.j<Object, T> r4 = (com.fasterxml.jackson.databind.l.j) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.l.j.class, "com.obric.aiagent.plugin");
        super(Object.class);
        this.f12372a = r4;
        this.f12373b = null;
        this.f12374c = null;
    }

    public aa(com.fasterxml.jackson.databind.l.j<Object, T> r3, com.fasterxml.jackson.databind.k r4, com.fasterxml.jackson.databind.l<?> r5) {
        com.fasterxml.jackson.databind.l.j<Object, T> r6 = (com.fasterxml.jackson.databind.l.j) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.l.j.class, "com.obric.aiagent.plugin");
        super(r4);
        this.f12372a = r6;
        this.f12373b = r4;
        this.f12374c = r5;
    }

    public aa<T> a(com.fasterxml.jackson.databind.l.j<Object, T> r3, com.fasterxml.jackson.databind.k r4, com.fasterxml.jackson.databind.l<?> r5) {
        com.fasterxml.jackson.databind.l.j r6 = (com.fasterxml.jackson.databind.l.j) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.l.j.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.l.h.a(aa.class, this, "withDelegate");
        return new aa(r6, r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.b.t
    public void d(com.fasterxml.jackson.databind.h r3) {
        com.fasterxml.jackson.databind.l<Object> r0 = this.f12374c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r0, com.fasterxml.jackson.databind.b.t.class) == false) goto L9;
        ((com.fasterxml.jackson.databind.b.t) ZeusTransformUtils.preCheckCast(this.f12374c, com.fasterxml.jackson.databind.b.t.class, "com.obric.aiagent.plugin")).d(r3);
        return;
    }

    @Override // com.fasterxml.jackson.databind.b.i
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.d r4) {
        com.fasterxml.jackson.databind.d r5 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.l<?> r0 = this.f12374c;
        if (r0 == null) goto L8;
        com.fasterxml.jackson.databind.l<?> r6 = r3.b(r0, r5, this.f12373b);
        if (r6 != this.f12374c) goto L7;
        return this;
    L7:
        return a(this.f12372a, this.f12373b, r6);
    L8:
        com.fasterxml.jackson.databind.k r1 = this.f12372a.a(r3.b());
        return a(this.f12372a, r1, r3.a(r1, r5));
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public Class<?> a() {
        return this.f12374c.a();
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return this.f12374c.b();
    }

    @Override // com.fasterxml.jackson.databind.l
    public Boolean a(com.fasterxml.jackson.databind.g r1) {
        return this.f12374c.a(r1);
    }

    @Override // com.fasterxml.jackson.databind.l
    public T a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
        Object r4 = this.f12374c.a(r2, r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return a(r4);
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
        Object r4 = this.f12374c.a(r1, r2);
        if (r4 != null) goto L7;
        return null;
    L7:
        return a(r4);
    }

    @Override // com.fasterxml.jackson.databind.l
    public T a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
        if (this.f12373b.e().isAssignableFrom(r5.getClass()) == false) goto L7;
        return (T) this.f12374c.a(r3, r4, r5);
    L7:
        return (T) b(r3, r4, r5);
    }

    public Object b(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3, Object r4) {
        throw new UnsupportedOperationException(String.format("Cannot update object of type %s (using deserializer for type %s)" + r4.getClass().getName(), new Object[]{this.f12373b}));
    }

    public T a(Object r1) {
        return this.f12372a.a(r1);
    }
}
