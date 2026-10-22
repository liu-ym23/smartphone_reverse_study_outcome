package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JsonValueSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class s extends aj<Object> implements com.fasterxml.jackson.databind.j.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.e.j f12908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.h.h f12909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.p<Object> f12910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.d f12911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12912e;
    protected final boolean f;
    protected transient com.fasterxml.jackson.databind.j.a.k g;

    /* JADX INFO: compiled from: JsonValueSerializer.java */
    static class a extends com.fasterxml.jackson.databind.h.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final com.fasterxml.jackson.databind.h.h f12913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final Object f12914b;

        public a(com.fasterxml.jackson.databind.h.h r1, Object r2) {
            this.f12913a = r1;
            this.f12914b = r2;
        }

        @Override // com.fasterxml.jackson.databind.h.h
        public com.fasterxml.jackson.databind.h.h a(com.fasterxml.jackson.databind.d r2) {
            com.fasterxml.jackson.databind.d r1 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r2, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.fasterxml.jackson.databind.h.h
        public JsonTypeInfo.As a() {
            return this.f12913a.a();
        }

        @Override // com.fasterxml.jackson.databind.h.h
        public String b() {
            return this.f12913a.b();
        }

        @Override // com.fasterxml.jackson.databind.h.h
        public com.fasterxml.jackson.a.g.b a(com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.a.g.b r3) {
            r3.f12067a = this.f12914b;
            return this.f12913a.a(r2, r3);
        }

        @Override // com.fasterxml.jackson.databind.h.h
        public com.fasterxml.jackson.a.g.b b(com.fasterxml.jackson.a.h r1, com.fasterxml.jackson.a.g.b r2) {
            return this.f12913a.b(r1, r2);
        }
    }

    public s(com.fasterxml.jackson.databind.e.j r2, com.fasterxml.jackson.databind.h.h r3, com.fasterxml.jackson.databind.p<?> r4) {
        super(r2.getType());
        this.f12908a = r2;
        this.f12912e = r2.getType();
        this.f12909b = r3;
        this.f12910c = r4;
        this.f12911d = null;
        this.f = true;
        this.g = com.fasterxml.jackson.databind.j.a.k.a();
    }

    public s(s r3, com.fasterxml.jackson.databind.d r4, com.fasterxml.jackson.databind.h.h r5, com.fasterxml.jackson.databind.p<?> r6, boolean r7) {
        com.fasterxml.jackson.databind.d r8 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        super(a(r3.a()));
        this.f12908a = r3.f12908a;
        this.f12912e = r3.f12912e;
        this.f12909b = r5;
        this.f12910c = r6;
        this.f12911d = r8;
        this.f = r7;
        this.g = com.fasterxml.jackson.databind.j.a.k.a();
    }

    private static final Class<Object> a(Class<?> r0) {
        if (r0 != null) goto L5;
        return Object.class;
    L5:
        return r0;
    }

    public s a(com.fasterxml.jackson.databind.d r7, com.fasterxml.jackson.databind.h.h r8, com.fasterxml.jackson.databind.p<?> r9, boolean r10) {
        com.fasterxml.jackson.databind.d r2 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r7, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        if (this.f12911d != r2) goto L12;
        if (this.f12909b != r8) goto L12;
        if (this.f12910c != r9) goto L12;
        if (r10 != this.f) goto L12;
        return this;
    L12:
        return new s(this, r2, r8, r9, r10);
    }

    @Override // com.fasterxml.jackson.databind.p
    public boolean a(com.fasterxml.jackson.databind.ac r2, Object r3) {
        Object r4 = this.f12908a.b(r3);
        if (r4 != null) goto L6;
        return true;
    L6:
        com.fasterxml.jackson.databind.p<Object> r0 = this.f12910c;
        if (r0 != null) goto L14;
        r0 = a(r2, r4.getClass());     // Catch: com.fasterxml.jackson.databind.m -> L10
    L10:
        e = move-exception;
        throw new com.fasterxml.jackson.databind.z(e);
    L14:
        return r0.a(r2, r4);
    }

    @Override // com.fasterxml.jackson.databind.j.j
    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.ac r4, com.fasterxml.jackson.databind.d r5) {
        com.fasterxml.jackson.databind.d r6 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.h.h r0 = this.f12909b;
        if (r0 == null) goto L5;
        r0 = r0.a(r6);
    L5:
        com.fasterxml.jackson.databind.p<?> r1 = this.f12910c;
        if (r1 != null) goto L19;
        if (r4.a(com.fasterxml.jackson.databind.r.p) == false) goto L10;
    L16:
        com.fasterxml.jackson.databind.p<Object> r7 = r4.b(this.f12912e, r6);
        return a(r6, r0, r7, a(this.f12912e.e(), r7));
    L10:
        if (this.f12912e.p() == true) goto L16;
        if (r6 != this.f12911d) goto L15;
        return this;
    L15:
        return a(r6, r0, r1, this.f);
    L19:
        return a(r6, r0, r4.a(r1, r6), this.f);
    }

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public void a(Object r5, com.fasterxml.jackson.a.h r6, com.fasterxml.jackson.databind.ac r7) {
        Object r8 = this.f12908a.b(r5);     // Catch: Exception -> L4
    L6:
        if (r8 != null) goto L8;
        r7.a(r6);
        return;
    L8:
        com.fasterxml.jackson.databind.p<Object> r0 = this.f12910c;
        if (r0 != null) goto L11;
        r0 = a(r7, r8.getClass());
    L11:
        com.fasterxml.jackson.databind.h.h r4 = this.f12909b;
        if (r4 == null) goto L14;
        r0.a(r8, r6, r7, r4);
        return;
    L14:
        r0.a(r8, r6, r7);
        return;
    L4:
        e = move-exception;
        a(r7, e, r5, this.f12908a.b() + "()");
        r8 = null;
        goto L6
    }

    @Override // com.fasterxml.jackson.databind.p
    public void a(Object r5, com.fasterxml.jackson.a.h r6, com.fasterxml.jackson.databind.ac r7, com.fasterxml.jackson.databind.h.h r8) {
        Object r0 = this.f12908a.b(r5);     // Catch: Exception -> L4
    L6:
        if (r0 != null) goto L9;
        r7.a(r6);
        return;
    L9:
        com.fasterxml.jackson.databind.p<Object> r1 = this.f12910c;
        if (r1 != null) goto L13;
        r1 = a(r7, r0.getClass());
    L16:
        r1.a(r0, r6, r7, new a(r8, r5));
        return;
    L13:
        if (this.f == false) goto L16;
        com.fasterxml.jackson.a.g.b r4 = r8.a(r6, r8.a(r5, com.fasterxml.jackson.a.n.h));
        r1.a(r0, r6, r7);
        r8.b(r6, r4);
        return;
    L4:
        e = move-exception;
        a(r7, e, r5, this.f12908a.b() + "()");
        r0 = null;
        goto L6
    }

    public boolean a(Class<?> r3, com.fasterxml.jackson.databind.p<?> r4) {
        if (r3.isPrimitive() == false) goto L12;
        if (r3 == Integer.TYPE) goto L21;
        if (r3 == Boolean.TYPE) goto L21;
        if (r3 == Double.TYPE) goto L21;
        return false;
    L21:
        return a(r4);
    L12:
        if (r3 == String.class) goto L21;
        if (r3 == Integer.class) goto L21;
        if (r3 == Boolean.class) goto L21;
        if (r3 == Double.class) goto L21;
        return false;
    }

    public com.fasterxml.jackson.databind.p<Object> a(com.fasterxml.jackson.databind.ac r2, Class<?> r3) {
        com.fasterxml.jackson.databind.p<Object> r0 = this.g.a(r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (this.f12912e.v() == false) goto L7;
        com.fasterxml.jackson.databind.k r4 = r2.a(this.f12912e, r3);
        com.fasterxml.jackson.databind.p<Object> r1 = r2.b(r4, this.f12911d);
        this.g = this.g.a(r4, r1).f12828b;
        return r1;
    L7:
        com.fasterxml.jackson.databind.p<Object> r5 = r2.b(r3, this.f12911d);
        this.g = this.g.a(r3, r5).f12828b;
        return r5;
    }

    public String toString() {
        return "(@JsonValue serializer for method " + this.f12908a.f() + "#" + this.f12908a.b() + ")";
    }
}
