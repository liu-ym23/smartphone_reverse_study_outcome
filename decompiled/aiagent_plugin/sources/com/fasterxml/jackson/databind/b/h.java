package com.fasterxml.jackson.databind.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: BuilderBasedDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.e.k f12522a;
    protected final com.fasterxml.jackson.databind.k w;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.b.h$1, reason: invalid class name */
    /* JADX INFO: compiled from: BuilderBasedDeserializer.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12523a = null;

        static {
            int[] r0 = new int[com.fasterxml.jackson.databind.a.b.values().length];
            f12523a = r0;
            r0[com.fasterxml.jackson.databind.a.b.f12188d.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f12523a[com.fasterxml.jackson.databind.a.b.f12187c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f12523a[com.fasterxml.jackson.databind.a.b.f12186b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public h(e r11, com.fasterxml.jackson.databind.c r12, com.fasterxml.jackson.databind.k r13, com.fasterxml.jackson.databind.b.a.c r14, Map<String, v> r15, Set<String> r16, boolean r17, Set<String> r18, boolean r19) {
        super(r11, r12, r14, (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r16, Set.class, "com.obric.aiagent.plugin"), r17, (Set) ZeusTransformUtils.wrapperContextForParams(r18, Set.class, "com.obric.aiagent.plugin"), r19);
        this.w = r13;
        this.f12522a = r11.f();
        if (this.v != null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Cannot use Object Id with Builder-based deserialization (type " + r12.getType() + ")");
    }

    public h(h r1, boolean r2) {
        super(r1, r2);
        this.f12522a = r1.f12522a;
        this.w = r1.w;
    }

    public h(h r1, com.fasterxml.jackson.databind.l.q r2) {
        super(r1, r2);
        this.f12522a = r1.f12522a;
        this.w = r1.w;
    }

    public h(h r1, com.fasterxml.jackson.databind.b.a.s r2) {
        super(r1, r2);
        this.f12522a = r1.f12522a;
        this.w = r1.w;
    }

    public h(h r3, Set<String> r4, Set<String> r5) {
        super(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin"));
        this.f12522a = r3.f12522a;
        this.w = r3.w;
    }

    public h(h r1, com.fasterxml.jackson.databind.b.a.c r2) {
        super(r1, r2);
        this.f12522a = r1.f12522a;
        this.w = r1.w;
    }

    @Override // com.fasterxml.jackson.databind.b.d, com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.l<Object> a(com.fasterxml.jackson.databind.l.q r2) {
        return new h(this, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public d b(com.fasterxml.jackson.databind.b.a.s r2) {
        return new h(this, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public d b(Set<String> r3, Set<String> r4) {
        return new h(this, (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public d a(boolean r2) {
        return new h(this, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public d a(com.fasterxml.jackson.databind.b.a.c r2) {
        return new h(this, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public d h() {
        v[] r0 = this.k.d();
        return new com.fasterxml.jackson.databind.b.a.a(this, this.w, r0, this.f12522a);
    }

    @Override // com.fasterxml.jackson.databind.b.d, com.fasterxml.jackson.databind.l
    public Boolean a(com.fasterxml.jackson.databind.g r1) {
        return Boolean.FALSE;
    }

    public Object b(com.fasterxml.jackson.databind.h r5, Object r6) {
        com.fasterxml.jackson.databind.e.k r0 = this.f12522a;
        if (r0 != null) goto L10;
        return r6;
    L10:
        return r0.h().invoke(r6, (Object[]) ZeusTransformUtils.preCheckCast(null, Object[].class, "com.obric.aiagent.plugin"));
    L7:
        e = move-exception;
        return a(e, r5);
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4) {
        if (r3.r() == false) goto L11;
        com.fasterxml.jackson.a.n r0 = r3.g();
        if (this.j == false) goto L9;
        return b(r4, a(r3, r4, r0));
    L9:
        return b(r4, b(r3, r4));
    L11:
        switch(r3.m()) {
            case 2: goto L27;
            case 3: goto L25;
            case 4: goto L13;
            case 5: goto L27;
            case 6: goto L23;
            case 7: goto L21;
            case 8: goto L19;
            case 9: goto L17;
            case 10: goto L17;
            case 11: goto L13;
            case 12: goto L15;
            default: goto L13;
        };
    L13:
        return r4.a(f(r4), r3);
    L15:
        return r3.N();
    L17:
        return b(r4, p(r3, r4));
    L19:
        return b(r4, o(r3, r4));
    L21:
        return b(r4, m(r3, r4));
    L23:
        return b(r4, n(r3, r4));
    L25:
        return e(r3, r4);
    L27:
        return b(r4, b(r3, r4));
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6, Object r7) {
        com.fasterxml.jackson.databind.k r8 = this.w;
        Class<?> r4 = a();
        Class<?> r9 = r7.getClass();
        if (r4.isAssignableFrom(r9) == false) goto L7;
        return r6.b(r8, String.format("Deserialization of %s by passing existing Builder (%s) instance not supported", new Object[]{r8, r4.getName()}));
    L7:
        return r6.b(r8, String.format("Deserialization of %s by passing existing instance (of %s) not supported", new Object[]{r8, r9.getName()}));
    }

    private final Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, com.fasterxml.jackson.a.n r5) {
        Object r6 = this.f12514e.a(r4);
    L4:
        if (r3.l() != com.fasterxml.jackson.a.n.f) goto L13;
        String r0 = r3.w();
        r3.g();
        v r1 = this.k.a(r0);
        if (r1 != null) goto L14;
        a(r3, r4, r6, r0);
    L12:
        r3.g();
        goto L4
    L14:
        r6 = r1.b(r3, r4, r6);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        a(e, r6, r0, r4);
        goto L12
    L13:
        return r6;
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public Object b(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5) {
        if (this.i == true) goto L5;
        Object r0 = this.f12514e.a(r5);
        if (this.l == null) goto L18;
        a(r5, r0);
    L18:
        if (this.q == false) goto L24;
        Class<?> r1 = r5.d();
        if (r1 == null) goto L24;
        return a(r4, r5, r0, r1);
    L24:
        if (r4.l() != com.fasterxml.jackson.a.n.f) goto L33;
        String r2 = r4.w();
        r4.g();
        v r3 = this.k.a(r2);
        if (r3 != null) goto L34;
        a(r4, r5, r0, r2);
    L32:
        r4.g();
        goto L24
    L34:
        r0 = r3.b(r4, r5, r0);     // Catch: Exception -> L29
    L29:
        e = move-exception;
        a(e, r0, r2, r5);
        goto L32
    L33:
        return r0;
    L5:
        if (this.t == null) goto L9;
        return d(r4, r5);
    L9:
        if (this.u == null) goto L13;
        return g(r4, r5);
    L13:
        return l(r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public Object c(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10) {
        com.fasterxml.jackson.databind.b.a.v r0 = this.h;
        com.fasterxml.jackson.databind.b.a.y r1 = r0.a(r9, r10, this.v);
        if (this.q == false) goto L5;
        Class<?> r2 = r10.d();
    L6:
        com.fasterxml.jackson.a.n r4 = r9.l();
        com.fasterxml.jackson.databind.l.y r5 = null;
    L8:
        if (r4 != com.fasterxml.jackson.a.n.f) goto L59;
        String r6 = r9.w();
        r9.g();
        v r7 = r0.a(r6);
        if (r1.a(r6) == false) goto L13;
        if (r7 != null) goto L13;
    L44:
        r4 = r9.g();
    L13:
        if (r7 == null) goto L32;
        if (r2 == null) goto L19;
        if (r7.a(r2) == true) goto L19;
        r9.k();
    L19:
        if (r1.a(r7, r7.a(r9, r10)) == false) goto L44;
        r9.g();
        Object r3 = r0.a(r10, r1);     // Catch: Exception -> L30
        if (r3.getClass() != this.f12512c.e()) goto L25;
        if (r5 == null) goto L29;
        r3 = a(r10, r3, r5);
    L29:
        return b(r9, r10, r3);
    L25:
        return a(r9, r10, r3, r5);
    L30:
        e = move-exception;
        a(e, this.f12512c.e(), r6, r10);
        goto L44
    L32:
        v r8 = this.k.a(r6);
        if (r8 == null) goto L36;
        r1.b(r8, r8.a(r9, r10));
        goto L44
    L36:
        if (com.fasterxml.jackson.databind.l.m.a(r6, this.n, this.o) == false) goto L39;
        c(r9, r10, a(), r6);
        goto L44
    L39:
        if (this.m == null) goto L41;
        r1.a(this.m, r6, this.m.a(r9, r10));
        goto L44
    L41:
        if (r5 != null) goto L43;
        r5 = r10.a(r9);
    L43:
        r5.a(r6);
        r5.b(r9);
        goto L44
    L59:
        Object r11 = r0.a(r10, r1);     // Catch: Exception -> L47
    L49:
        if (r5 != null) goto L51;
        return r11;
    L51:
        if (r11.getClass() == this.f12512c.e()) goto L55;
        return a(null, r10, r11, r5);
    L55:
        return a(r10, r11, r5);
    L47:
        e = move-exception;
        r11 = a(e, r10);
        goto L49
    L5:
        r2 = null;
        goto L6
    }

    public final Object b(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
        if (this.l == null) goto L6;
        a(r4, r5);
    L6:
        if (this.t == null) goto L13;
        if (r3.a(com.fasterxml.jackson.a.n.f12152b) == false) goto L10;
        r3.g();
    L10:
        com.fasterxml.jackson.databind.l.y r0 = r4.a(r3);
        r0.j();
        return b(r3, r4, r5, r0);
    L13:
        if (this.u == null) goto L17;
        return c(r3, r4, r5);
    L17:
        if (this.q == false) goto L22;
        Class<?> r1 = r4.d();
        if (r1 == null) goto L22;
        return a(r3, r4, r5, r1);
    L22:
        com.fasterxml.jackson.a.n r2 = r3.l();
        if (r2 != com.fasterxml.jackson.a.n.f12152b) goto L26;
        r2 = r3.g();
    L26:
        if (r2 != com.fasterxml.jackson.a.n.f) goto L35;
        String r6 = r3.w();
        r3.g();
        v r7 = this.k.a(r6);
        if (r7 != null) goto L36;
        a(r3, r4, r5, r6);
    L34:
        r2 = r3.g();
        goto L26
    L36:
        r5 = r7.b(r3, r4, r5);     // Catch: Exception -> L31
    L31:
        e = move-exception;
        a(e, r5, r6, r4);
        goto L34
    L35:
        return r5;
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab
    public Object e(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10) {
        com.fasterxml.jackson.databind.l<Object> r0 = this.g;
        if (r0 != null) goto L32;
        r0 = this.f;
        if (r0 != null) goto L32;
        com.fasterxml.jackson.databind.a.b r1 = i(r10);
        boolean r2 = r10.a(com.fasterxml.jackson.databind.i.r);
        if (r2 == true) goto L12;
        if (r1 != com.fasterxml.jackson.databind.a.b.f12185a) goto L12;
    L31:
        return r10.a(f(r10), r9);
    L12:
        if (r9.g() != com.fasterxml.jackson.a.n.f12155e) goto L25;
        int r3 = AnonymousClass1.f12523a[r1.ordinal()];
        if (r3 == 1) goto L24;
        if (r3 == 2) goto L22;
        if (r3 == 3) goto L22;
        return r10.a(f(r10), com.fasterxml.jackson.a.n.f12154d, r9, null, new Object[0]);
    L22:
        return a(r10);
    L24:
        return c(r10);
    L25:
        if (r2 == false) goto L31;
        Object r4 = a(r9, r10);
        if (r9.g() == com.fasterxml.jackson.a.n.f12155e) goto L29;
        D(r9, r10);
    L29:
        return r4;
    L32:
        Object r11 = this.f12514e.b(r10, r0.a(r9, r10));
        if (this.l == null) goto L36;
        a(r10, r11);
    L36:
        return b(r10, r11);
    }

    public final Object a(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5, Object r6, Class<?> r7) {
        com.fasterxml.jackson.a.n r0 = r4.l();
    L4:
        if (r0 != com.fasterxml.jackson.a.n.f) goto L16;
        String r1 = r4.w();
        r4.g();
        v r2 = this.k.a(r1);
        if (r2 != null) goto L8;
        a(r4, r5, r6, r1);
    L15:
        r0 = r4.g();
        goto L4
    L8:
        if (r2.a(r7) == true) goto L17;
        r4.k();
        goto L15
    L17:
        r6 = r2.b(r4, r5, r6);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        a(e, r6, r1, r5);
        goto L15
    L16:
        return r6;
    }

    public Object d(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8) {
        if (this.f == null) goto L7;
        return this.f12514e.a(r8, this.f.a(r7, r8));
    L7:
        if (this.h != null) goto L9;
        com.fasterxml.jackson.databind.l.y r0 = r8.a(r7);
        r0.j();
        Object r1 = this.f12514e.a(r8);
        if (this.l == null) goto L14;
        a(r8, r1);
    L14:
        if (this.q == false) goto L16;
        Class<?> r2 = r8.d();
    L18:
        if (r7.l() != com.fasterxml.jackson.a.n.f) goto L39;
        String r3 = r7.w();
        r7.g();
        v r4 = this.k.a(r3);
        if (r4 == null) goto L30;
        if (r2 != null) goto L23;
    L41:
        r1 = r4.b(r7, r8, r1);     // Catch: Exception -> L27
    L38:
        r7.g();
    L27:
        e = move-exception;
        a(e, r1, r3, r8);
        goto L38
    L23:
        if (r4.a(r2) == true) goto L41;
        r7.k();
        goto L38
    L30:
        if (com.fasterxml.jackson.databind.l.m.a(r3, this.n, this.o) == false) goto L32;
        c(r7, r8, r1, r3);
        goto L38
    L32:
        r0.a(r3);
        r0.b(r7);
        if (this.m == null) goto L38;
        this.m.a(r7, r8, r1, r3);     // Catch: Exception -> L36
    L36:
        e = move-exception;
        a(e, r1, r3, r8);
        goto L38
    L39:
        r0.k();
        return this.t.a(r7, r8, r1, r0);
    L16:
        r2 = null;
        goto L18
    L9:
        return f(r7, r8);
    }

    public Object f(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8) {
        com.fasterxml.jackson.databind.b.a.v r0 = this.h;
        com.fasterxml.jackson.databind.b.a.y r1 = r0.a(r7, r8, this.v);
        com.fasterxml.jackson.databind.l.y r2 = r8.a(r7);
        r2.j();
        com.fasterxml.jackson.a.n r3 = r7.l();
    L4:
        if (r3 != com.fasterxml.jackson.a.n.f) goto L32;
        String r4 = r7.w();
        r7.g();
        v r5 = r0.a(r4);
        if (r1.a(r4) == false) goto L9;
        if (r5 != null) goto L9;
    L31:
        r3 = r7.g();
    L9:
        if (r5 != null) goto L11;
        v r6 = this.k.a(r4);
        if (r6 == null) goto L26;
        r1.b(r6, r6.a(r7, r8));
        goto L31
    L26:
        if (com.fasterxml.jackson.databind.l.m.a(r4, this.n, this.o) == false) goto L28;
        c(r7, r8, a(), r4);
        goto L31
    L28:
        r2.a(r4);
        r2.b(r7);
        if (this.m == null) goto L31;
        r1.a(this.m, r4, this.m.a(r7, r8));
        goto L31
    L11:
        if (r1.a(r5, r5.a(r7, r8)) == false) goto L31;
        r7.g();
        Object r9 = r0.a(r8, r1);     // Catch: Exception -> L20
        if (r9.getClass() == this.f12512c.e()) goto L19;
        return a(r7, r8, r9, r2);
    L19:
        return b(r7, r8, r9, r2);
    L20:
        e = move-exception;
        a(e, this.f12512c.e(), r4, r8);
        goto L31
    L32:
        r2.k();
        Object r10 = r0.a(r8, r1);     // Catch: Exception -> L36
        return this.t.a(r7, r8, r10, r2);
    L36:
        e = move-exception;
        return a(e, r8);
    }

    public Object b(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6, Object r7, com.fasterxml.jackson.databind.l.y r8) {
        if (this.q == false) goto L5;
        Class<?> r0 = r6.d();
    L6:
        com.fasterxml.jackson.a.n r1 = r5.l();
    L8:
        if (r1 != com.fasterxml.jackson.a.n.f) goto L26;
        String r2 = r5.w();
        v r3 = this.k.a(r2);
        r5.g();
        if (r3 == null) goto L20;
        if (r0 != null) goto L13;
    L28:
        r7 = r3.b(r5, r6, r7);     // Catch: Exception -> L17
    L25:
        r1 = r5.g();
    L17:
        e = move-exception;
        a(e, r7, r2, r6);
        goto L25
    L13:
        if (r3.a(r0) == true) goto L28;
        r5.k();
        goto L25
    L20:
        if (com.fasterxml.jackson.databind.l.m.a(r2, this.n, this.o) == false) goto L22;
        c(r5, r6, r7, r2);
        goto L25
    L22:
        r8.a(r2);
        r8.b(r5);
        if (this.m == null) goto L25;
        this.m.a(r5, r6, r7, r2);
        goto L25
    L26:
        r8.k();
        return this.t.a(r5, r6, r7, r8);
    L5:
        r0 = null;
        goto L6
    }

    public Object g(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
        if (this.h == null) goto L7;
        return h(r2, r3);
    L7:
        return c(r2, r3, this.f12514e.a(r3));
    }

    public Object c(com.fasterxml.jackson.a.k r6, com.fasterxml.jackson.databind.h r7, Object r8) {
        if (this.q == false) goto L5;
        Class<?> r0 = r7.d();
    L6:
        com.fasterxml.jackson.databind.b.a.g r1 = this.u.a();
        com.fasterxml.jackson.a.n r2 = r6.l();
    L8:
        if (r2 != com.fasterxml.jackson.a.n.f) goto L37;
        String r3 = r6.w();
        com.fasterxml.jackson.a.n r4 = r6.g();
        v r5 = this.k.a(r3);
        if (r5 == null) goto L23;
        if (r4.g() == false) goto L14;
        r1.a(r6, r7, r3, r8);
    L14:
        if (r0 != null) goto L16;
    L40:
        r8 = r5.b(r6, r7, r8);     // Catch: Exception -> L20
    L35:
        r2 = r6.g();
    L20:
        e = move-exception;
        a(e, r8, r3, r7);
        goto L35
    L16:
        if (r5.a(r0) == true) goto L40;
        r6.k();
        goto L35
    L23:
        if (com.fasterxml.jackson.databind.l.m.a(r3, this.n, this.o) == false) goto L26;
        c(r6, r7, r8, r3);
        goto L35
    L26:
        if (r1.b(r6, r7, r3, r8) == true) goto L35;
        if (this.m != null) goto L38;
        b(r6, r7, r8, r3);
        goto L35
    L38:
        this.m.a(r6, r7, r8, r3);     // Catch: Exception -> L32
    L32:
        e = move-exception;
        a(e, r8, r3, r7);
        goto L35
    L37:
        return r1.a(r6, r7, r8);
    L5:
        r0 = null;
        goto L6
    }

    public Object h(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
        com.fasterxml.jackson.databind.k r1 = this.w;
        return r3.b(r1, String.format("Deserialization (of %s) with Builder, External type id, @JsonCreator not yet implemented", new Object[]{r1}));
    }
}
