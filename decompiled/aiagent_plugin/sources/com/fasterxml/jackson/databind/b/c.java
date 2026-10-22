package com.fasterxml.jackson.databind.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: BeanDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends d implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected transient Exception f12505a;
    private volatile transient com.fasterxml.jackson.databind.l.q w;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.b.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: BeanDeserializer.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12506a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f12507b = null;

        static {
            int[] r0 = new int[com.fasterxml.jackson.databind.a.b.values().length];
            f12507b = r0;
            r0[com.fasterxml.jackson.databind.a.b.f12188d.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L37:
            f12507b[com.fasterxml.jackson.databind.a.b.f12187c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L43:
            f12507b[com.fasterxml.jackson.databind.a.b.f12186b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L8:
            int[] r3 = new int[com.fasterxml.jackson.a.n.values().length];
            f12506a = r3;
            r3[com.fasterxml.jackson.a.n.h.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L57:
            f12506a[com.fasterxml.jackson.a.n.i.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L35:
            f12506a[com.fasterxml.jackson.a.n.j.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L41:
            f12506a[com.fasterxml.jackson.a.n.g.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L55:
            f12506a[com.fasterxml.jackson.a.n.k.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L39:
            f12506a[com.fasterxml.jackson.a.n.l.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L45:
            f12506a[com.fasterxml.jackson.a.n.m.ordinal()] = 7;     // Catch: NoSuchFieldError -> L29
        L49:
            f12506a[com.fasterxml.jackson.a.n.f12154d.ordinal()] = 8;     // Catch: NoSuchFieldError -> L30
        L51:
            f12506a[com.fasterxml.jackson.a.n.f.ordinal()] = 9;     // Catch: NoSuchFieldError -> L31
        L33:
            f12506a[com.fasterxml.jackson.a.n.f12153c.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
            return;
        }
    }

    /* JADX INFO: compiled from: BeanDeserializer.java */
    static class a extends com.fasterxml.jackson.databind.b.a.z.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.fasterxml.jackson.databind.h f12508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final v f12509b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object f12510c;

        a(com.fasterxml.jackson.databind.h r1, w r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.b.a.y r4, v r5) {
            super(r2, r3);
            this.f12508a = r1;
            this.f12509b = r5;
        }

        public void a(Object r1) {
            this.f12510c = r1;
        }

        @Override // com.fasterxml.jackson.databind.b.a.z.a
        public void a(Object r5, Object r6) {
            if (this.f12510c != null) goto L5;
            com.fasterxml.jackson.databind.h r7 = this.f12508a;
            v r0 = this.f12509b;
            r7.a(r0, "Cannot resolve ObjectId forward reference using property '%s' (of type %s): Bean not yet resolved", new Object[]{r0.a(), this.f12509b.j().getName()});
        L5:
            this.f12509b.a(this.f12510c, r6);
        }
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public /* synthetic */ d b(com.fasterxml.jackson.databind.b.a.s r1) {
        return a(r1);
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public /* synthetic */ d b(Set r3, Set r4) {
        return a((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"));
    }

    public c(e r12, com.fasterxml.jackson.databind.c r13, com.fasterxml.jackson.databind.b.a.c r14, Map<String, v> r15, HashSet<String> r16, boolean r17, Set<String> r18, boolean r19) {
        super(r12, r13, r14, (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin"), r16, r17, (Set) ZeusTransformUtils.wrapperContextForParams(r18, Set.class, "com.obric.aiagent.plugin"), r19);
    }

    public c(d r2) {
        super(r2, r2.p);
    }

    public c(d r1, boolean r2) {
        super(r1, r2);
    }

    public c(d r1, com.fasterxml.jackson.databind.l.q r2) {
        super(r1, r2);
    }

    public c(d r1, com.fasterxml.jackson.databind.b.a.s r2) {
        super(r1, r2);
    }

    public c(d r3, Set<String> r4, Set<String> r5) {
        super(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin"));
    }

    public c(d r1, com.fasterxml.jackson.databind.b.a.c r2) {
        super(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.d, com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.l<Object> a(com.fasterxml.jackson.databind.l.q r3) {
        if (getClass() == c.class) goto L6;
        return this;
    L6:
        if (this.w != r3) goto L8;
        return this;
    L8:
        this.w = r3;
        c r1 = new c(this, r3);     // Catch: Throwable -> L12
        this.w = null;
        return r1;
    L12:
        th = move-exception;
        this.w = null;
        throw th;
    }

    public c a(com.fasterxml.jackson.databind.b.a.s r2) {
        return new c(this, r2);
    }

    public c a(Set<String> r3, Set<String> r4) {
        return new c(this, (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public d a(boolean r2) {
        return new c(this, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public d a(com.fasterxml.jackson.databind.b.a.c r2) {
        return new c(this, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public d h() {
        return new com.fasterxml.jackson.databind.b.a.b(this, this.k.d());
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
        if (r2.r() == false) goto L15;
        if (this.j == true) goto L7;
        r2.g();
        if (this.v == null) goto L13;
        return j(r2, r3);
    L13:
        return b(r2, r3);
    L7:
        return b(r2, r3, r2.g());
    L15:
        return a(r2, r3, r2.l());
    }

    public final Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, com.fasterxml.jackson.a.n r5) {
        if (r5 == null) goto L31;
        switch(AnonymousClass1.f12506a[r5.ordinal()]) {
            case 1: goto L29;
            case 2: goto L27;
            case 3: goto L25;
            case 4: goto L23;
            case 5: goto L21;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L17;
            case 9: goto L7;
            case 10: goto L7;
            default: goto L31;
        };
    L7:
        if (this.j == false) goto L11;
        return b(r3, r4, r5);
    L11:
        if (this.v == null) goto L15;
        return j(r3, r4);
    L15:
        return b(r3, r4);
    L17:
        return e(r3, r4);
    L19:
        return d(r3, r4);
    L21:
        return p(r3, r4);
    L23:
        return q(r3, r4);
    L25:
        return o(r3, r4);
    L27:
        return m(r3, r4);
    L29:
        return n(r3, r4);
    L31:
        return r4.a(f(r4), r3);
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
        r3.a(r5);
        if (this.l == null) goto L6;
        a(r4, r5);
    L6:
        if (this.t == null) goto L10;
        return b(r3, r4, r5);
    L10:
        if (this.u == null) goto L14;
        return c(r3, r4, r5);
    L14:
        if (r3.r() == false) goto L19;
        String r0 = r3.i();
        if (r0 != null) goto L22;
        return r5;
    L22:
        if (this.q == false) goto L27;
        Class<?> r1 = r4.d();
        if (r1 == null) goto L27;
        return a(r3, r4, r5, r1);
    L27:
        r3.g();
        v r2 = this.k.a(r0);
        if (r2 != null) goto L37;
        a(r3, r4, r5, r0);
    L34:
        r0 = r3.i();
        if (r0 != null) goto L27;
    L36:
        return r5;
    L37:
        r2.a(r3, r4, r5);     // Catch: Exception -> L31
    L31:
        e = move-exception;
        a(e, r5, r0, r4);
        goto L34
    L19:
        if (r3.b(5) == false) goto L36;
        r0 = r3.w();
        goto L22
    }

    private final Object b(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, com.fasterxml.jackson.a.n r5) {
        Object r6 = this.f12514e.a(r4);
        r3.a(r6);
        if (r3.b(5) == false) goto L14;
        String r0 = r3.w();
    L5:
        r3.g();
        v r1 = this.k.a(r0);
        if (r1 != null) goto L15;
        a(r3, r4, r6, r0);
    L12:
        r0 = r3.i();
        if (r0 != null) goto L5;
    L15:
        r1.a(r3, r4, r6);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        a(e, r6, r0, r4);
    L14:
        return r6;
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public Object b(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5) {
        if (this.v == null) goto L13;
        if (this.v.c() == false) goto L13;
        if (r4.b(5) == false) goto L13;
        if (this.v.a(r4.w(), r4) == false) goto L13;
        return k(r4, r5);
    L13:
        if (this.i == true) goto L15;
        Object r0 = this.f12514e.a(r5);
        r4.a(r0);
        if (r4.S() == false) goto L30;
        Object r2 = r4.U();
        if (r2 == null) goto L30;
        a(r4, r5, r0, r2);
    L30:
        if (this.l == null) goto L33;
        a(r5, r0);
    L33:
        if (this.q == false) goto L39;
        Class<?> r3 = r5.d();
        if (r3 == null) goto L39;
        return a(r4, r5, r0, r3);
    L39:
        if (r4.b(5) == false) goto L50;
        String r1 = r4.w();
    L41:
        r4.g();
        v r6 = this.k.a(r1);
        if (r6 != null) goto L51;
        a(r4, r5, r0, r1);
    L48:
        r1 = r4.i();
        if (r1 != null) goto L41;
    L51:
        r6.a(r4, r5, r0);     // Catch: Exception -> L45
    L45:
        e = move-exception;
        a(e, r0, r1, r5);
    L50:
        return r0;
    L15:
        if (this.t == null) goto L19;
        return f(r4, r5);
    L19:
        if (this.u == null) goto L23;
        return h(r4, r5);
    L23:
        return l(r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.b.d
    public Object c(com.fasterxml.jackson.a.k r10, com.fasterxml.jackson.databind.h r11) {
        com.fasterxml.jackson.databind.b.a.v r0 = this.h;
        com.fasterxml.jackson.databind.b.a.y r1 = r0.a(r10, r11, this.v);
        if (this.q == false) goto L5;
        Class<?> r2 = r11.d();
    L6:
        com.fasterxml.jackson.a.n r4 = r10.l();
        ArrayList r5 = null;
        com.fasterxml.jackson.databind.l.y r6 = null;
    L8:
        if (r4 != com.fasterxml.jackson.a.n.f) goto L87;
        String r7 = r10.w();
        r10.g();
        v r8 = r0.a(r7);
        if (r1.a(r7) == false) goto L13;
        if (r8 != null) goto L13;
    L60:
        r4 = r10.g();
    L13:
        if (r8 == null) goto L36;
        if (r2 == null) goto L19;
        if (r8.a(r2) == true) goto L19;
        r10.k();
    L19:
        if (r1.a(r8, a(r10, r11, r8)) == false) goto L60;
        r10.g();
        Object r3 = r0.a(r11, r1);     // Catch: Exception -> L23
    L25:
        if (r3 == null) goto L27;
        r10.a(r3);
        if (r3.getClass() != this.f12512c.e()) goto L31;
        if (r6 == null) goto L35;
        r3 = a(r11, r3, r6);
    L35:
        return a(r10, r11, r3);
    L31:
        return a(r10, r11, r3, r6);
    L27:
        return r11.a(a(), null, i());
    L23:
        e = move-exception;
        r3 = a(e, r11);
        goto L25
    L36:
        v r9 = this.k.a(r7);
        if (r9 == null) goto L46;
        r1.b(r9, a(r10, r11, r9));     // Catch: w -> L40
    L40:
        e = move-exception;
        a r12 = a(r11, r9, r1, e);
        if (r5 != null) goto L44;
        r5 = new ArrayList();
    L44:
        r5.add(r12);
        goto L60
    L46:
        if (com.fasterxml.jackson.databind.l.m.a(r7, this.n, this.o) == false) goto L49;
        c(r10, r11, a(), r7);
        goto L60
    L49:
        if (this.m == null) goto L55;
        r1.a(this.m, r7, this.m.a(r10, r11));     // Catch: Exception -> L52
    L52:
        e = move-exception;
        a(e, this.f12512c.e(), r7, r11);
        goto L60
    L55:
        if (this.p == false) goto L57;
        r10.k();
        goto L60
    L57:
        if (r6 != null) goto L59;
        r6 = r11.a(r10);
    L59:
        r6.a(r7);
        r6.b(r10);
        goto L60
    L87:
        Object r13 = r0.a(r11, r1);     // Catch: Exception -> L63
    L66:
        if (this.l == null) goto L68;
        a(r11, r13);
    L68:
        if (r5 == null) goto L73;
        Iterator r14 = r5.iterator();
    L71:
        if (r14.hasNext() == false) goto L73;
        ((a) ZeusTransformUtils.preCheckCast(r14.next(), a.class, "com.obric.aiagent.plugin")).a(r13);
    L73:
        if (r6 != null) goto L75;
        return r13;
    L75:
        if (r13.getClass() == this.f12512c.e()) goto L79;
        return a(null, r11, r13, r6);
    L79:
        return a(r11, r13, r6);
    L63:
        e = move-exception;
        a(e, r11);
        r13 = null;
        goto L66
    L5:
        r2 = null;
        goto L6
    }

    private a a(com.fasterxml.jackson.databind.h r7, v r8, com.fasterxml.jackson.databind.b.a.y r9, w r10) {
        a r6 = new a(r7, r10, r8.getType(), r9, r8);
        r10.f().a(r6);
        return r6;
    }

    public final Object a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3, v r4) {
        return r4.a(r2, r3);
    L4:
        e = move-exception;
        a(e, this.f12512c.e(), r4.a(), r3);
        return null;
    }

    public Object d(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
        if (r2.b() == false) goto L11;
        com.fasterxml.jackson.databind.l.y r0 = r3.a(r2);
        r0.k();
        com.fasterxml.jackson.a.k r4 = r0.d(r2);
        r4.g();
        if (this.j == false) goto L7;
        Object r1 = b(r4, r3, com.fasterxml.jackson.a.n.f12153c);
    L8:
        r4.close();
        return r1;
    L7:
        r1 = b(r4, r3);
        goto L8
    L11:
        return r3.a(f(r3), r2);
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab
    public Object e(com.fasterxml.jackson.a.k r14, com.fasterxml.jackson.databind.h r15) {
        com.fasterxml.jackson.databind.l<Object> r0 = this.g;
        if (r0 != null) goto L35;
        r0 = this.f;
        if (r0 != null) goto L35;
        com.fasterxml.jackson.databind.a.b r1 = i(r15);
        boolean r2 = r15.a(com.fasterxml.jackson.databind.i.r);
        if (r2 == true) goto L12;
        if (r1 != com.fasterxml.jackson.databind.a.b.f12185a) goto L12;
    L34:
        return r15.a(f(r15), r14);
    L12:
        if (r14.g() != com.fasterxml.jackson.a.n.f12155e) goto L24;
        int r3 = AnonymousClass1.f12507b[r1.ordinal()];
        if (r3 == 1) goto L23;
        if (r3 == 2) goto L21;
        if (r3 == 3) goto L21;
        return r15.a(f(r15), com.fasterxml.jackson.a.n.f12154d, r14, null, new Object[0]);
    L21:
        return a(r15);
    L23:
        return c(r15);
    L24:
        if (r2 == false) goto L34;
        if (r14.g() != com.fasterxml.jackson.a.n.f12154d) goto L29;
        com.fasterxml.jackson.databind.k r8 = f(r15);
        return r15.a(r8, com.fasterxml.jackson.a.n.f12154d, r14, "Cannot deserialize value of type %s from deeply-nested JSON Array: only single wrapper allowed with `%s`", new Object[]{com.fasterxml.jackson.databind.l.h.b(r8), "DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS"});
    L29:
        Object r4 = a(r14, r15);
        if (r14.g() == com.fasterxml.jackson.a.n.f12155e) goto L32;
        D(r14, r15);
    L32:
        return r4;
    L35:
        Object r16 = this.f12514e.b(r15, r0.a(r14, r15));
        if (this.l == null) goto L38;
        a(r15, r16);
    L38:
        return r16;
    }

    public final Object a(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5, Object r6, Class<?> r7) {
        if (r4.b(5) == false) goto L17;
        String r0 = r4.w();
    L5:
        r4.g();
        v r1 = this.k.a(r0);
        if (r1 != null) goto L8;
        a(r4, r5, r6, r0);
    L15:
        r0 = r4.i();
        if (r0 != null) goto L5;
    L8:
        if (r1.a(r7) == true) goto L18;
        r4.k();
        goto L15
    L18:
        r1.a(r4, r5, r6);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        a(e, r6, r0, r5);
    L17:
        return r6;
    }

    public Object f(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8) {
        if (this.f == null) goto L7;
        return this.f12514e.a(r8, this.f.a(r7, r8));
    L7:
        if (this.h != null) goto L9;
        com.fasterxml.jackson.databind.l.y r0 = r8.a(r7);
        r0.j();
        Object r1 = this.f12514e.a(r8);
        r7.a(r1);
        if (this.l == null) goto L13;
        a(r8, r1);
    L13:
        String r3 = null;
        if (this.q == false) goto L16;
        Class<?> r2 = r8.d();
    L18:
        if (r7.b(5) == false) goto L20;
        r3 = r7.w();
    L20:
        if (r3 == null) goto L43;
        r7.g();
        v r4 = this.k.a(r3);
        if (r4 == null) goto L32;
        if (r2 != null) goto L25;
    L47:
        r4.a(r7, r8, r1);     // Catch: Exception -> L29
    L42:
        r3 = r7.i();
    L29:
        e = move-exception;
        a(e, r1, r3, r8);
        goto L42
    L25:
        if (r4.a(r2) == true) goto L47;
        r7.k();
        goto L42
    L32:
        if (com.fasterxml.jackson.databind.l.m.a(r3, this.n, this.o) == false) goto L35;
        c(r7, r8, r1, r3);
        goto L42
    L35:
        if (this.m != null) goto L37;
        r0.a(r3);
        r0.b(r7);
        goto L42
    L37:
        com.fasterxml.jackson.databind.l.y r5 = r8.b(r7);
        r0.a(r3);
        r0.a(r5);
        this.m.a(r5.p(), r8, r1, r3);     // Catch: Exception -> L40
    L40:
        e = move-exception;
        a(e, r1, r3, r8);
        goto L42
    L43:
        r0.k();
        this.t.a(r7, r8, r1, r0);
        return r1;
    L16:
        r2 = null;
        goto L18
    L9:
        return g(r7, r8);
    }

    public Object b(com.fasterxml.jackson.a.k r6, com.fasterxml.jackson.databind.h r7, Object r8) {
        com.fasterxml.jackson.a.n r0 = r6.l();
        if (r0 != com.fasterxml.jackson.a.n.f12152b) goto L5;
        r0 = r6.g();
    L5:
        com.fasterxml.jackson.databind.l.y r1 = r7.a(r6);
        r1.j();
        if (this.q == false) goto L8;
        Class<?> r2 = r7.d();
    L10:
        if (r0 != com.fasterxml.jackson.a.n.f) goto L33;
        String r3 = r6.w();
        v r4 = this.k.a(r3);
        r6.g();
        if (r4 == null) goto L22;
        if (r2 != null) goto L15;
    L35:
        r4.a(r6, r7, r8);     // Catch: Exception -> L19
    L32:
        r0 = r6.g();
    L19:
        e = move-exception;
        a(e, r8, r3, r7);
        goto L32
    L15:
        if (r4.a(r2) == true) goto L35;
        r6.k();
        goto L32
    L22:
        if (com.fasterxml.jackson.databind.l.m.a(r3, this.n, this.o) == false) goto L25;
        c(r6, r7, r8, r3);
        goto L32
    L25:
        if (this.m != null) goto L27;
        r1.a(r3);
        r1.b(r6);
        goto L32
    L27:
        com.fasterxml.jackson.databind.l.y r5 = r7.b(r6);
        r1.a(r3);
        r1.a(r5);
        this.m.a(r5.p(), r7, r8, r3);     // Catch: Exception -> L30
    L30:
        e = move-exception;
        a(e, r8, r3, r7);
        goto L32
    L33:
        r1.k();
        this.t.a(r6, r7, r8, r1);
        return r8;
    L8:
        r2 = null;
        goto L10
    }

    public Object g(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10) {
        com.fasterxml.jackson.databind.b.a.v r0 = this.h;
        com.fasterxml.jackson.databind.b.a.y r1 = r0.a(r9, r10, this.v);
        com.fasterxml.jackson.databind.l.y r2 = r10.a(r9);
        r2.j();
        com.fasterxml.jackson.a.n r3 = r9.l();
    L4:
        if (r3 != com.fasterxml.jackson.a.n.f) goto L51;
        String r4 = r9.w();
        r9.g();
        v r5 = r0.a(r4);
        if (r1.a(r4) == false) goto L9;
        if (r5 != null) goto L9;
    L44:
        r3 = r9.g();
    L9:
        if (r5 != null) goto L11;
        v r6 = this.k.a(r4);
        if (r6 == null) goto L34;
        r1.b(r6, a(r9, r10, r6));
        goto L44
    L34:
        if (com.fasterxml.jackson.databind.l.m.a(r4, this.n, this.o) == false) goto L37;
        c(r9, r10, a(), r4);
        goto L44
    L37:
        if (this.m != null) goto L39;
        r2.a(r4);
        r2.b(r9);
        goto L44
    L39:
        com.fasterxml.jackson.databind.l.y r7 = r10.b(r9);
        r2.a(r4);
        r2.a(r7);
        r1.a(this.m, r4, this.m.a(r7.p(), r10));     // Catch: Exception -> L42
    L42:
        e = move-exception;
        a(e, this.f12512c.e(), r4, r10);
        goto L44
    L11:
        if (r1.a(r5, a(r9, r10, r5)) == false) goto L44;
        com.fasterxml.jackson.a.n r8 = r9.g();
        Object r11 = r0.a(r10, r1);     // Catch: Exception -> L15
    L17:
        r9.a(r11);
    L19:
        if (r8 != com.fasterxml.jackson.a.n.f) goto L22;
        r2.b(r9);
        r8 = r9.g();
        goto L19
    L22:
        if (r8 == com.fasterxml.jackson.a.n.f12153c) goto L24;
        r10.a(this, com.fasterxml.jackson.a.n.f12153c, "Attempted to unwrap '%s' value", new Object[]{a().getName()});
    L24:
        r2.k();
        if (r11.getClass() == this.f12512c.e()) goto L29;
        r10.a(r5, "Cannot create polymorphic instances with unwrapped values", new Object[0]);
        return null;
    L29:
        return this.t.a(r9, r10, r11, r2);
    L15:
        e = move-exception;
        r11 = a(e, r10);
        goto L17
    L51:
        return this.t.a(r9, r10, r0.a(r10, r1), r2);
    L48:
        e = move-exception;
        a(e, r10);
        return null;
    }

    public Object h(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
        if (this.h == null) goto L7;
        return i(r2, r3);
    L7:
        if (this.f == null) goto L11;
        return this.f12514e.a(r3, this.f.a(r2, r3));
    L11:
        return c(r2, r3, this.f12514e.a(r3));
    }

    public Object c(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3, Object r4) {
        return a(r2, r3, r4, this.u.a());
    }

    public Object a(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6, Object r7, com.fasterxml.jackson.databind.b.a.g r8) {
        if (this.q == false) goto L5;
        Class<?> r0 = r6.d();
    L6:
        com.fasterxml.jackson.a.n r1 = r5.l();
    L8:
        if (r1 != com.fasterxml.jackson.a.n.f) goto L37;
        String r2 = r5.w();
        com.fasterxml.jackson.a.n r3 = r5.g();
        v r4 = this.k.a(r2);
        if (r4 == null) goto L23;
        if (r3.g() == false) goto L14;
        r8.a(r5, r6, r2, r7);
    L14:
        if (r0 != null) goto L16;
    L40:
        r4.a(r5, r6, r7);     // Catch: Exception -> L20
    L35:
        r1 = r5.g();
    L20:
        e = move-exception;
        a(e, r7, r2, r6);
        goto L35
    L16:
        if (r4.a(r0) == true) goto L40;
        r5.k();
        goto L35
    L23:
        if (com.fasterxml.jackson.databind.l.m.a(r2, this.n, this.o) == false) goto L26;
        c(r5, r6, r7, r2);
        goto L35
    L26:
        if (r8.b(r5, r6, r2, r7) == true) goto L35;
        if (this.m != null) goto L38;
        b(r5, r6, r7, r2);
        goto L35
    L38:
        this.m.a(r5, r6, r7, r2);     // Catch: Exception -> L32
    L32:
        e = move-exception;
        a(e, r7, r2, r6);
        goto L35
    L37:
        return r8.a(r5, r6, r7);
    L5:
        r0 = null;
        goto L6
    }

    public Object i(com.fasterxml.jackson.a.k r10, com.fasterxml.jackson.databind.h r11) {
        com.fasterxml.jackson.databind.b.a.g r0 = this.u.a();
        com.fasterxml.jackson.databind.b.a.v r1 = this.h;
        com.fasterxml.jackson.databind.b.a.y r2 = r1.a(r10, r11, this.v);
        if (this.q == false) goto L5;
        Class<?> r3 = r11.d();
    L6:
        com.fasterxml.jackson.a.n r5 = r10.l();
    L8:
        if (r5 != com.fasterxml.jackson.a.n.f) goto L57;
        String r6 = r10.w();
        com.fasterxml.jackson.a.n r7 = r10.g();
        v r8 = r1.a(r6);
        if (r2.a(r6) == false) goto L13;
        if (r8 != null) goto L13;
    L49:
        r5 = r10.g();
    L13:
        if (r8 != null) goto L15;
        v r9 = this.k.a(r6);
        if (r9 == null) goto L40;
        if (r7.g() == false) goto L34;
        r0.a(r10, r11, r6, null);
    L34:
        if (r3 != null) goto L36;
    L38:
        r2.b(r9, r9.a(r10, r11));
        goto L49
    L36:
        if (r9.a(r3) == true) goto L38;
        r10.k();
        goto L49
    L40:
        if (r0.b(r10, r11, r6, null) == true) goto L49;
        if (com.fasterxml.jackson.databind.l.m.a(r6, this.n, this.o) == false) goto L46;
        c(r10, r11, a(), r6);
        goto L49
    L46:
        if (this.m == null) goto L48;
        r2.a(this.m, r6, this.m.a(r10, r11));
        goto L49
    L48:
        b(r10, r11, this.B, r6);
        goto L49
    L15:
        if (r0.b(r10, r11, r6, null) == true) goto L49;
        if (r2.a(r8, a(r10, r11, r8)) == false) goto L49;
        r10.g();
        Object r4 = r1.a(r11, r2);     // Catch: Exception -> L27
        if (r4.getClass() == this.f12512c.e()) goto L26;
        return r11.b(this.f12512c, String.format("Cannot create polymorphic instances with external type ids (%s -> %s)", new Object[]{this.f12512c, r4.getClass()}));
    L26:
        return a(r10, r11, r4, r0);
    L27:
        e = move-exception;
        a(e, this.f12512c.e(), r6, r11);
        goto L49
    L57:
        return r0.a(r10, r11, r2, r1);
    L52:
        e = move-exception;
        return a(e, r11);
    L5:
        r3 = null;
        goto L6
    }

    public Exception i() {
        if (this.f12505a != null) goto L6;
        this.f12505a = new NullPointerException("JSON Creator returned null");
    L6:
        return this.f12505a;
    }
}
