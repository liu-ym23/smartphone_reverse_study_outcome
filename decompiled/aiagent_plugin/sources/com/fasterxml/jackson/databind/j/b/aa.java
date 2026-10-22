package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ReferenceTypeSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class aa<T> extends aj<T> implements com.fasterxml.jackson.databind.j.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f12861a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.d f12863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.h.h f12864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.p<Object> f12865e;
    protected final com.fasterxml.jackson.databind.l.q f;
    protected transient com.fasterxml.jackson.databind.j.a.k g;
    protected final Object h;
    protected final boolean i;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.j.b.aa$1, reason: invalid class name */
    /* JADX INFO: compiled from: ReferenceTypeSerializer.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12866a = null;

        static {
            int[] r0 = new int[JsonInclude.Include.values().length];
            f12866a = r0;
            r0[JsonInclude.Include.NON_DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f12866a[JsonInclude.Include.NON_ABSENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f12866a[JsonInclude.Include.NON_EMPTY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f12866a[JsonInclude.Include.CUSTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f12866a[JsonInclude.Include.NON_NULL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f12866a[JsonInclude.Include.ALWAYS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public abstract aa<T> a(com.fasterxml.jackson.databind.d r1, com.fasterxml.jackson.databind.h.h r2, com.fasterxml.jackson.databind.p<?> r3, com.fasterxml.jackson.databind.l.q r4);

    public abstract aa<T> a(Object r1, boolean r2);

    public abstract Object a(T r1);

    public abstract Object b(T r1);

    public abstract boolean c(T r1);

    static {
        f12861a = JsonInclude.Include.NON_EMPTY;
    }

    public aa(com.fasterxml.jackson.databind.k.j r1, boolean r2, com.fasterxml.jackson.databind.h.h r3, com.fasterxml.jackson.databind.p<Object> r4) {
        super(r1);
        this.f12862b = r1.y();
        this.f12863c = null;
        this.f12864d = r3;
        this.f12865e = r4;
        this.f = null;
        this.h = null;
        this.i = false;
        this.g = com.fasterxml.jackson.databind.j.a.k.a();
    }

    public aa(aa<?> r3, com.fasterxml.jackson.databind.d r4, com.fasterxml.jackson.databind.h.h r5, com.fasterxml.jackson.databind.p<?> r6, com.fasterxml.jackson.databind.l.q r7, Object r8, boolean r9) {
        com.fasterxml.jackson.databind.d r10 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        super(r3);
        this.f12862b = r3.f12862b;
        this.g = com.fasterxml.jackson.databind.j.a.k.a();
        this.f12863c = r10;
        this.f12864d = r5;
        this.f12865e = r6;
        this.f = r7;
        this.h = r8;
        this.i = r9;
    }

    @Override // com.fasterxml.jackson.databind.p
    public com.fasterxml.jackson.databind.p<T> a(com.fasterxml.jackson.databind.l.q r4) {
        com.fasterxml.jackson.databind.p<?> r0 = this.f12865e;
        if (r0 == null) goto L7;
        r0 = r0.a(r4);
        if (r0 != this.f12865e) goto L7;
        return this;
    L7:
        com.fasterxml.jackson.databind.l.q r1 = this.f;
        if (r1 == null) goto L12;
        r4 = com.fasterxml.jackson.databind.l.q.a(r4, r1);
    L12:
        if (this.f12865e != r0) goto L17;
        if (this.f != r4) goto L17;
        return this;
    L17:
        return a(this.f12863c, this.f12864d, r0, r4);
    }

    @Override // com.fasterxml.jackson.databind.j.j
    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.ac r6, com.fasterxml.jackson.databind.d r7) {
        com.fasterxml.jackson.databind.d r8 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r7, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.h.h r0 = this.f12864d;
        if (r0 == null) goto L5;
        r0 = r0.a(r8);
    L5:
        com.fasterxml.jackson.databind.p<?> r1 = b(r6, r8);
        if (r1 != null) goto L14;
        r1 = this.f12865e;
        if (r1 == null) goto L10;
        r1 = r6.a(r1, r8);
        goto L14
    L10:
        if (a(r6, r8, this.f12862b) == false) goto L14;
        r1 = a(r6, this.f12862b, r8);
    L14:
        if (this.f12863c == r8) goto L16;
    L20:
        aa<T> r2 = a(r8, r0, r1, this.f);
    L21:
        if (r8 == null) goto L56;
        JsonInclude.Value r9 = r8.b(r6.c(), a());
        if (r9 == null) goto L57;
        JsonInclude.Include r3 = r9.getContentInclusion();
        if (r3 == JsonInclude.Include.USE_DEFAULTS) goto L58;
        int r4 = AnonymousClass1.f12866a[r3.ordinal()];
        Object r5 = null;
        boolean r10 = true;
        if (r4 != 1) goto L29;
        r5 = com.fasterxml.jackson.databind.l.e.a(this.f12862b);
        if (r5 != null) goto L48;
    L51:
        if (this.h != r5) goto L55;
        if (this.i != r10) goto L55;
        return r2;
    L55:
        return r2.a(r5, r10);
    L48:
        if (r5.getClass().isArray() == false) goto L51;
        r5 = com.fasterxml.jackson.databind.l.c.a(r5);
        goto L51
    L29:
        if (r4 == 2) goto L43;
        if (r4 != 3) goto L33;
        r5 = f12861a;
        goto L51
    L33:
        if (r4 != 4) goto L35;
        r5 = r6.a(null, r9.getContentFilter());
        if (r5 == null) goto L51;
        r10 = r6.b(r5);
        goto L51
    L35:
        if (r4 == 5) goto L51;
        r10 = false;
        goto L51
    L43:
        if (this.f12862b.a() == false) goto L51;
        r5 = f12861a;
        goto L51
    L58:
        return r2;
    L57:
        return r2;
    L56:
        return r2;
    L16:
        if (this.f12864d != r0) goto L20;
        if (this.f12865e != r1) goto L20;
        r2 = this;
        goto L21
    }

    public boolean a(com.fasterxml.jackson.databind.ac r3, com.fasterxml.jackson.databind.d r4, com.fasterxml.jackson.databind.k r5) {
        com.fasterxml.jackson.databind.d r2 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        if (r5.t() == false) goto L6;
        return false;
    L6:
        if (r5.p() == false) goto L9;
        return true;
    L9:
        if (r5.u() == false) goto L11;
        return true;
    L11:
        com.fasterxml.jackson.databind.b r6 = r3.d();
        if (r6 == null) goto L23;
        if (r2 == null) goto L23;
        if (r2.d() == null) goto L23;
        JsonSerialize.Typing r7 = r6.q(r2.d());
        if (r7 != JsonSerialize.Typing.STATIC) goto L20;
        return true;
    L20:
        if (r7 != JsonSerialize.Typing.DYNAMIC) goto L23;
        return false;
    L23:
        return r3.a(com.fasterxml.jackson.databind.r.p);
    }

    @Override // com.fasterxml.jackson.databind.p
    public boolean a(com.fasterxml.jackson.databind.ac r3, T r4) {
        if (c(r4) == true) goto L6;
        return true;
    L6:
        Object r5 = b(r4);
        if (r5 != null) goto L11;
        return this.i;
    L11:
        if (this.h != null) goto L14;
        return false;
    L14:
        com.fasterxml.jackson.databind.p<Object> r0 = this.f12865e;
        if (r0 == null) goto L27;
    L21:
        Object r2 = this.h;
        if (r2 != f12861a) goto L26;
        return r0.a(r3, r5);
    L26:
        return r2.equals(r5);
    L27:
        r0 = a(r3, r5.getClass());     // Catch: com.fasterxml.jackson.databind.m -> L18
    L18:
        e = move-exception;
        throw new com.fasterxml.jackson.databind.z(e);
    }

    @Override // com.fasterxml.jackson.databind.p
    public boolean c() {
        if (this.f == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public void a(T r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4) {
        Object r5 = a(r2);
        if (r5 == null) goto L5;
        com.fasterxml.jackson.databind.p<Object> r0 = this.f12865e;
        if (r0 != null) goto L11;
        r0 = a(r4, r5.getClass());
    L11:
        com.fasterxml.jackson.databind.h.h r1 = this.f12864d;
        if (r1 == null) goto L14;
        r0.a(r5, r3, r4, r1);
        return;
    L14:
        r0.a(r5, r3, r4);
        return;
    L5:
        if (this.f != null) goto L16;
        r4.a(r3);
        return;
    }

    @Override // com.fasterxml.jackson.databind.p
    public void a(T r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4, com.fasterxml.jackson.databind.h.h r5) {
        Object r6 = a(r2);
        if (r6 == null) goto L5;
        com.fasterxml.jackson.databind.p<Object> r0 = this.f12865e;
        if (r0 != null) goto L11;
        r0 = a(r4, r6.getClass());
    L11:
        r0.a(r6, r3, r4, r5);
        return;
    L5:
        if (this.f != null) goto L13;
        r4.a(r3);
        return;
    }

    private final com.fasterxml.jackson.databind.p<Object> a(com.fasterxml.jackson.databind.ac r3, Class<?> r4) {
        com.fasterxml.jackson.databind.p<Object> r0 = this.g.a(r4);
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (this.f12862b.v() == false) goto L7;
        com.fasterxml.jackson.databind.p<Object> r5 = r3.b(r3.a(this.f12862b, r4), this.f12863c);
    L8:
        com.fasterxml.jackson.databind.l.q r1 = this.f;
        if (r1 == null) goto L11;
        r5 = r5.a(r1);
    L11:
        com.fasterxml.jackson.databind.p<Object> r2 = r5;
        this.g = this.g.b(r4, r2);
        return r2;
    L7:
        r5 = r3.b(r4, this.f12863c);
        goto L8
    }

    private final com.fasterxml.jackson.databind.p<Object> a(com.fasterxml.jackson.databind.ac r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.d r4) {
        return r2.b(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"));
    }
}
