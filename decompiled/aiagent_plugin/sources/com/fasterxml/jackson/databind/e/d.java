package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: AnnotatedClass.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends b implements ag {
    private static final a o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Class<?> f12611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k.n f12612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final List<com.fasterxml.jackson.databind.k> f12613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b f12614e;
    protected final com.fasterxml.jackson.databind.k.o f;
    protected final u.a g;
    protected final Class<?> h;
    protected final boolean i;
    protected final com.fasterxml.jackson.databind.l.b j;
    protected a k;
    protected m l;
    protected List<h> m;
    protected transient Boolean n;

    /* JADX INFO: compiled from: AnnotatedClass.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f12615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<f> f12616b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<k> f12617c;

        public a(f r3, List<f> r4, List<k> r5) {
            List<f> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            List<k> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            this.f12615a = r3;
            this.f12616b = r6;
            this.f12617c = r7;
        }
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public /* synthetic */ AnnotatedElement a() {
        return d();
    }

    static {
        o = new a(null, Collections.emptyList(), Collections.emptyList());
    }

    d(com.fasterxml.jackson.databind.k r3, Class<?> r4, List<com.fasterxml.jackson.databind.k> r5, Class<?> r6, com.fasterxml.jackson.databind.l.b r7, com.fasterxml.jackson.databind.k.n r8, com.fasterxml.jackson.databind.b r9, u.a r10, com.fasterxml.jackson.databind.k.o r11, boolean r12) {
        List<com.fasterxml.jackson.databind.k> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.l.b r14 = (com.fasterxml.jackson.databind.l.b) ZeusTransformUtils.wrapperContextForParams(r7, com.fasterxml.jackson.databind.l.b.class, "com.obric.aiagent.plugin");
        u.a r15 = (u.a) ZeusTransformUtils.wrapperContextForParams(r10, u.a.class, "com.obric.aiagent.plugin");
        this.f12610a = r3;
        this.f12611b = r4;
        this.f12613d = r13;
        this.h = r6;
        this.j = r14;
        this.f12612c = r8;
        this.f12614e = r9;
        this.g = r15;
        this.f = r11;
        this.i = r12;
    }

    d(Class<?> r2) {
        this.f12610a = null;
        this.f12611b = r2;
        this.f12613d = Collections.emptyList();
        this.h = null;
        this.j = p.a();
        this.f12612c = com.fasterxml.jackson.databind.k.n.a();
        this.f12614e = null;
        this.g = null;
        this.f = null;
        this.i = false;
    }

    @Override // com.fasterxml.jackson.databind.e.ag
    public com.fasterxml.jackson.databind.k a(Type r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin");
        return this.f.a(r4, this.f12612c);
    }

    public Class<?> d() {
        return this.f12611b;
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public String b() {
        return this.f12611b.getName();
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public <A extends Annotation> A a(Class<A> r1) {
        return (A) this.j.a(r1);
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public boolean b(Class<?> r1) {
        return this.j.b(r1);
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public boolean a(Class<? extends Annotation>[] r1) {
        return this.j.a(r1);
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public Class<?> c() {
        return this.f12611b;
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public com.fasterxml.jackson.databind.k getType() {
        return this.f12610a;
    }

    public com.fasterxml.jackson.databind.l.b e() {
        return this.j;
    }

    public boolean f() {
        if (this.j.a() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public f g() {
        return o().f12615a;
    }

    public List<f> h() {
        return o().f12616b;
    }

    public List<k> i() {
        return o().f12617c;
    }

    public Iterable<k> j() {
        return n();
    }

    public k a(String r1, Class<?>[] r2) {
        return n().a(r1, r2);
    }

    public Iterable<h> k() {
        return m();
    }

    public boolean l() {
        Boolean r0 = this.n;
        if (r0 != null) goto L6;
        r0 = Boolean.valueOf(com.fasterxml.jackson.databind.l.h.p(this.f12611b));
        this.n = r0;
    L6:
        return r0.booleanValue();
    }

    private final List<h> m() {
        List<h> r0 = this.m;
        if (r0 != null) goto L9;
        com.fasterxml.jackson.databind.k r5 = this.f12610a;
        if (r5 != null) goto L7;
        r0 = Collections.emptyList();
    L8:
        this.m = r0;
        goto L9
    L7:
        r0 = i.a(this.f12614e, this, this.g, this.f, r5, this.i);
    L9:
        return r0;
    }

    private final m n() {
        m r0 = this.l;
        if (r0 != null) goto L9;
        com.fasterxml.jackson.databind.k r5 = this.f12610a;
        if (r5 != null) goto L7;
        r0 = new m();
    L8:
        this.l = r0;
        goto L9
    L7:
        r0 = l.a(this.f12614e, this, this.g, this.f, r5, this.f12613d, this.h, this.i);
    L9:
        return r0;
    }

    private final a o() {
        a r0 = this.k;
        if (r0 != null) goto L9;
        com.fasterxml.jackson.databind.k r4 = this.f12610a;
        if (r4 != null) goto L7;
        r0 = o;
    L8:
        this.k = r0;
        goto L9
    L7:
        r0 = g.a(this.f12614e, this.f, this, r4, this.h, this.i);
    L9:
        return r0;
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public String toString() {
        return "[AnnotedClass " + this.f12611b.getName() + "]";
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public int hashCode() {
        return this.f12611b.getName().hashCode();
    }

    @Override // com.fasterxml.jackson.databind.e.b
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (com.fasterxml.jackson.databind.l.h.a(r5, getClass()) == true) goto L9;
        return false;
    L9:
        if (((d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin")).f12611b != this.f12611b) goto L12;
        return true;
    L12:
        return false;
    }
}
