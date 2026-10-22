package com.fasterxml.jackson.databind.b;

import com.fasterxml.jackson.databind.e.ac;
import com.fasterxml.jackson.databind.l.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.Serializable;

/* JADX INFO: compiled from: SettableBeanProperty.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class v extends com.fasterxml.jackson.databind.e.w implements Serializable {
    protected static final com.fasterxml.jackson.databind.l<Object> h = null;
    protected final com.fasterxml.jackson.databind.x i;
    protected final com.fasterxml.jackson.databind.k j;
    protected final com.fasterxml.jackson.databind.x k;
    protected final transient com.fasterxml.jackson.databind.l.b l;
    protected final com.fasterxml.jackson.databind.l<Object> m;
    protected final com.fasterxml.jackson.databind.h.e n;
    protected final s o;
    protected String p;
    protected ac q;
    protected ab r;
    protected int s;

    /* JADX INFO: compiled from: SettableBeanProperty.java */
    public static abstract class a extends v {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final v f12540c;

        public abstract v a(v r1);

        public a(v r1) {
            super(r1);
            this.f12540c = r1;
        }

        public v b(v r2) {
            if (r2 != this.f12540c) goto L6;
            return this;
        L6:
            return a(r2);
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public v a(com.fasterxml.jackson.databind.l<?> r2) {
            return b(this.f12540c.a(r2));
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public v a(com.fasterxml.jackson.databind.x r2) {
            return b(this.f12540c.a(r2));
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public v a(s r3) {
            s r4 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.aiagent.plugin");
            return b(this.f12540c.a(r4));
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public void a(int r1) {
            this.f12540c.a(r1);
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public void a(com.fasterxml.jackson.databind.g r1) {
            this.f12540c.a(r1);
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public Class<?> j() {
            return this.f12540c.j();
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public String k() {
            return this.f12540c.k();
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public ac l() {
            return this.f12540c.l();
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public boolean m() {
            return this.f12540c.m();
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public boolean n() {
            return this.f12540c.n();
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public com.fasterxml.jackson.databind.l<Object> o() {
            return this.f12540c.o();
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public com.fasterxml.jackson.databind.h.e p() {
            return this.f12540c.p();
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public boolean a(Class<?> r1) {
            return this.f12540c.a(r1);
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public boolean r() {
            return this.f12540c.r();
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public int g() {
            return this.f12540c.g();
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public Object h() {
            return this.f12540c.h();
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public boolean i() {
            return this.f12540c.i();
        }

        @Override // com.fasterxml.jackson.databind.b.v, com.fasterxml.jackson.databind.d
        public com.fasterxml.jackson.databind.e.j d() {
            return this.f12540c.d();
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public void a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, Object r3) {
            this.f12540c.a(r1, r2, r3);
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public Object b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, Object r3) {
            return this.f12540c.b(r1, r2, r3);
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public void a(Object r1, Object r2) {
            this.f12540c.a(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.b.v
        public Object b(Object r1, Object r2) {
            return this.f12540c.b(r1, r2);
        }
    }

    public abstract v a(s r1);

    public abstract v a(com.fasterxml.jackson.databind.l<?> r1);

    public abstract v a(com.fasterxml.jackson.databind.x r1);

    public abstract void a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, Object r3);

    public void a(com.fasterxml.jackson.databind.g r1) {
    }

    public abstract void a(Object r1, Object r2);

    public abstract Object b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, Object r3);

    public abstract Object b(Object r1, Object r2);

    @Override // com.fasterxml.jackson.databind.d
    public abstract com.fasterxml.jackson.databind.e.j d();

    public void e() {
    }

    public boolean f() {
        return false;
    }

    public Object h() {
        return null;
    }

    public boolean i() {
        return false;
    }

    static {
        h = new com.fasterxml.jackson.databind.b.a.h("No _valueDeserializer assigned");
    }

    public v(com.fasterxml.jackson.databind.e.t r8, com.fasterxml.jackson.databind.k r9, com.fasterxml.jackson.databind.h.e r10, com.fasterxml.jackson.databind.l.b r11) {
        com.fasterxml.jackson.databind.l.b r5 = (com.fasterxml.jackson.databind.l.b) ZeusTransformUtils.wrapperContextForParams(r11, com.fasterxml.jackson.databind.l.b.class, "com.obric.aiagent.plugin");
        this(r8.b(), r9, r8.c(), r10, r5, r8.h());
    }

    public v(com.fasterxml.jackson.databind.x r3, com.fasterxml.jackson.databind.k r4, com.fasterxml.jackson.databind.x r5, com.fasterxml.jackson.databind.h.e r6, com.fasterxml.jackson.databind.l.b r7, com.fasterxml.jackson.databind.w r8) {
        com.fasterxml.jackson.databind.l.b r9 = (com.fasterxml.jackson.databind.l.b) ZeusTransformUtils.wrapperContextForParams(r7, com.fasterxml.jackson.databind.l.b.class, "com.obric.aiagent.plugin");
        super(r8);
        this.s = -1;
        if (r3 != null) goto L5;
        this.i = com.fasterxml.jackson.databind.x.f13133b;
    L6:
        this.j = r4;
        this.k = r5;
        this.l = r9;
        this.r = null;
        if (r6 == null) goto L9;
        r6 = r6.a(this);
    L9:
        this.n = r6;
        com.fasterxml.jackson.databind.l<Object> r10 = h;
        this.m = r10;
        this.o = r10;
        return;
    L5:
        this.i = r3.a();
        goto L6
    }

    public v(com.fasterxml.jackson.databind.x r1, com.fasterxml.jackson.databind.k r2, com.fasterxml.jackson.databind.w r3, com.fasterxml.jackson.databind.l<Object> r4) {
        super(r3);
        this.s = -1;
        if (r1 != null) goto L5;
        this.i = com.fasterxml.jackson.databind.x.f13133b;
    L6:
        this.j = r2;
        this.k = null;
        this.l = null;
        this.r = null;
        this.n = null;
        this.m = r4;
        this.o = r4;
        return;
    L5:
        this.i = r1.a();
        goto L6
    }

    public v(v r2) {
        super(r2);
        this.s = -1;
        this.i = r2.i;
        this.j = r2.j;
        this.k = r2.k;
        this.l = r2.l;
        this.m = r2.m;
        this.n = r2.n;
        this.p = r2.p;
        this.s = r2.s;
        this.r = r2.r;
        this.o = r2.o;
    }

    public v(v r3, com.fasterxml.jackson.databind.l<?> r4, s r5) {
        s r6 = (s) ZeusTransformUtils.wrapperContextForParams(r5, s.class, "com.obric.aiagent.plugin");
        super(r3);
        this.s = -1;
        this.i = r3.i;
        this.j = r3.j;
        this.k = r3.k;
        this.l = r3.l;
        this.n = r3.n;
        this.p = r3.p;
        this.s = r3.s;
        if (r4 != null) goto L5;
        this.m = h;
    L6:
        this.r = r3.r;
        if (r6 != h) goto L9;
        r6 = this.m;
    L9:
        this.o = r6;
        return;
    L5:
        this.m = r4;
        goto L6
    }

    public v(v r2, com.fasterxml.jackson.databind.x r3) {
        super(r2);
        this.s = -1;
        this.i = r3;
        this.j = r2.j;
        this.k = r2.k;
        this.l = r2.l;
        this.m = r2.m;
        this.n = r2.n;
        this.p = r2.p;
        this.s = r2.s;
        this.r = r2.r;
        this.o = r2.o;
    }

    public v a(String r2) {
        com.fasterxml.jackson.databind.x r0 = this.i;
        if (r0 != null) goto L5;
        com.fasterxml.jackson.databind.x r1 = new com.fasterxml.jackson.databind.x(r2);
    L7:
        if (r1 != this.i) goto L10;
        return this;
    L10:
        return a(r1);
    L5:
        r1 = r0.b(r2);
        goto L7
    }

    public void b(String r1) {
        this.p = r1;
    }

    public void a(ac r1) {
        this.q = r1;
    }

    public void a(Class<?>[] r1) {
        if (r1 != null) goto L4;
        this.r = null;
        return;
    L4:
        this.r = ab.a(r1);
    }

    public void a(int r4) {
        if (this.s != (-1)) goto L7;
        this.s = r4;
        return;
    L7:
        throw new IllegalStateException("Property '" + a() + "' already had index (" + this.s + "), trying to assign " + r4);
    }

    @Override // com.fasterxml.jackson.databind.d, com.fasterxml.jackson.databind.l.r
    public final String a() {
        return this.i.b();
    }

    @Override // com.fasterxml.jackson.databind.d
    public com.fasterxml.jackson.databind.x b() {
        return this.i;
    }

    @Override // com.fasterxml.jackson.databind.d
    public com.fasterxml.jackson.databind.k getType() {
        return this.j;
    }

    public Class<?> j() {
        return d().f();
    }

    public String k() {
        return this.p;
    }

    public ac l() {
        return this.q;
    }

    public boolean m() {
        com.fasterxml.jackson.databind.l<Object> r1 = this.m;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1 == h) goto L7;
        return true;
    }

    public boolean n() {
        if (this.n == null) goto L5;
        return true;
    L5:
        return false;
    }

    public com.fasterxml.jackson.databind.l<Object> o() {
        com.fasterxml.jackson.databind.l<Object> r1 = this.m;
        if (r1 != h) goto L6;
        return null;
    L6:
        return r1;
    }

    public com.fasterxml.jackson.databind.h.e p() {
        return this.n;
    }

    public s q() {
        return this.o;
    }

    public boolean a(Class<?> r1) {
        ab r0 = this.r;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.a(r1) == true) goto L8;
        return false;
    }

    public boolean r() {
        if (this.r == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int g() {
        throw new IllegalStateException(String.format("Internal error: no creator index for property '%s' (of type %s)", new Object[]{a(), getClass().getName()}));
    }

    public final Object a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3) {
        if (r2.a(com.fasterxml.jackson.a.n.m) == true) goto L5;
        com.fasterxml.jackson.databind.h.e r0 = this.n;
        if (r0 != null) goto L9;
        Object r4 = this.m.a(r2, r3);
        if (r4 == null) goto L13;
        return r4;
    L13:
        return this.o.a(r3);
    L9:
        return this.m.a(r2, r3, r0);
    L5:
        return this.o.a(r3);
    }

    public final Object c(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6, Object r7) {
        if (r5.a(com.fasterxml.jackson.a.n.m) == false) goto L10;
        if (com.fasterxml.jackson.databind.b.a.q.a(this.o) == false) goto L8;
        return r7;
    L8:
        return this.o.a(r6);
    L10:
        if (this.n == null) goto L12;
        r6.b(getType(), String.format("Cannot merge polymorphic property '%s'", new Object[]{a()}));
    L12:
        Object r8 = this.m.a(r5, r6, r7);
        if (r8 == null) goto L15;
        return r8;
    L15:
        if (com.fasterxml.jackson.databind.b.a.q.a(this.o) == false) goto L18;
        return r7;
    L18:
        return this.o.a(r6);
    }

    public void a(com.fasterxml.jackson.a.k r3, Exception r4, Object r5) {
        if (ZeusTransformUtils.instanceOf(r4, IllegalArgumentException.class) == false) goto L10;
        String r6 = com.fasterxml.jackson.databind.l.h.d(r5);
        StringBuilder r2 = new StringBuilder("Problem deserializing property '").append(a()).append("' (expected type: ").append(getType()).append("; actual type: ").append(r6).append(")");
        String r7 = com.fasterxml.jackson.databind.l.h.h(r4);
        if (r7 == null) goto L7;
        r2.append(", problem: ").append(r7);
    L9:
        throw com.fasterxml.jackson.databind.m.a(r3, r2.toString(), r4);
    L7:
        r2.append(" (no error message provided)");
        goto L9
    L10:
        a(r3, r4);
    }

    public IOException a(com.fasterxml.jackson.a.k r1, Exception r2) {
        com.fasterxml.jackson.databind.l.h.c(r2);
        com.fasterxml.jackson.databind.l.h.b(r2);
        Throwable r0 = com.fasterxml.jackson.databind.l.h.d(r2);
        throw com.fasterxml.jackson.databind.m.a(r1, com.fasterxml.jackson.databind.l.h.h(r0), r0);
    }

    public void a(Exception r4, Object r5) {
        a((com.fasterxml.jackson.a.k) ZeusTransformUtils.preCheckCast(null, com.fasterxml.jackson.a.k.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public String toString() {
        return "[property '" + a() + "']";
    }
}
