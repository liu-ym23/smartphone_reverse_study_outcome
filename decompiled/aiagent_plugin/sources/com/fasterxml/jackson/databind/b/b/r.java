package com.fasterxml.jackson.databind.b.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JsonNodeDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class r extends f<com.fasterxml.jackson.databind.n> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final r f12451b = null;

    /* JADX INFO: compiled from: JsonNodeDeserializer.java */
    static final class a extends f<com.fasterxml.jackson.databind.i.a> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected static final a f12452b = null;

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return f(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
            return a(r3, r4, (com.fasterxml.jackson.databind.i.a) ZeusTransformUtils.preCheckCast(r5, com.fasterxml.jackson.databind.i.a.class, "com.obric.aiagent.plugin"));
        }

        static {
            f12452b = new a();
        }

        public a() {
            super(com.fasterxml.jackson.databind.i.a.class, true);
        }

        public static a h() {
            return f12452b;
        }

        public com.fasterxml.jackson.databind.i.a f(com.fasterxml.jackson.a.k r8, com.fasterxml.jackson.databind.h r9) {
            if (r8.q() == false) goto L7;
            com.fasterxml.jackson.databind.i.l r4 = r9.l();
            com.fasterxml.jackson.databind.i.a r0 = r4.b();
            a(r8, r9, r4, new f.a(), r0);
            return r0;
        L7:
            return (com.fasterxml.jackson.databind.i.a) ZeusTransformUtils.preCheckCast(r9.a(com.fasterxml.jackson.databind.i.a.class, r8), com.fasterxml.jackson.databind.i.a.class, "com.obric.aiagent.plugin");
        }

        public com.fasterxml.jackson.databind.i.a a(com.fasterxml.jackson.a.k r8, com.fasterxml.jackson.databind.h r9, com.fasterxml.jackson.databind.i.a r10) {
            if (r8.q() == false) goto L7;
            a(r8, r9, r9.l(), new f.a(), r10);
            return r10;
        L7:
            return (com.fasterxml.jackson.databind.i.a) ZeusTransformUtils.preCheckCast(r9.a(com.fasterxml.jackson.databind.i.a.class, r8), com.fasterxml.jackson.databind.i.a.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: JsonNodeDeserializer.java */
    static final class b extends f<com.fasterxml.jackson.databind.i.q> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected static final b f12453b = null;

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
            return f(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.l
        public /* synthetic */ Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
            return a(r3, r4, (com.fasterxml.jackson.databind.i.q) ZeusTransformUtils.preCheckCast(r5, com.fasterxml.jackson.databind.i.q.class, "com.obric.aiagent.plugin"));
        }

        static {
            f12453b = new b();
        }

        public b() {
            super(com.fasterxml.jackson.databind.i.q.class, true);
        }

        public static b h() {
            return f12453b;
        }

        public com.fasterxml.jackson.databind.i.q f(com.fasterxml.jackson.a.k r8, com.fasterxml.jackson.databind.h r9) {
            com.fasterxml.jackson.databind.i.l r3 = r9.l();
            if (r8.r() == false) goto L7;
            com.fasterxml.jackson.databind.i.q r6 = r3.c();
            a(r8, r9, r3, new f.a(), r6);
            return r6;
        L7:
            if (r8.a(com.fasterxml.jackson.a.n.f) == false) goto L11;
            return a(r8, r9, r3, new f.a());
        L11:
            if (r8.a(com.fasterxml.jackson.a.n.f12153c) == false) goto L15;
            return r3.c();
        L15:
            return (com.fasterxml.jackson.databind.i.q) ZeusTransformUtils.preCheckCast(r9.a(com.fasterxml.jackson.databind.i.q.class, r8), com.fasterxml.jackson.databind.i.q.class, "com.obric.aiagent.plugin");
        }

        public com.fasterxml.jackson.databind.i.q a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, com.fasterxml.jackson.databind.i.q r5) {
            if (r3.r() == true) goto L10;
            if (r3.a(com.fasterxml.jackson.a.n.f) == true) goto L10;
            return (com.fasterxml.jackson.databind.i.q) ZeusTransformUtils.preCheckCast(r4.a(com.fasterxml.jackson.databind.i.q.class, r3), com.fasterxml.jackson.databind.i.q.class, "com.obric.aiagent.plugin");
        L10:
            return (com.fasterxml.jackson.databind.i.q) ZeusTransformUtils.preCheckCast(a(r3, r4, r5, new f.a()), com.fasterxml.jackson.databind.i.q.class, "com.obric.aiagent.plugin");
        }
    }

    @Override // com.fasterxml.jackson.databind.l, com.fasterxml.jackson.databind.b.s
    public Object b(com.fasterxml.jackson.databind.h r1) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.b.b.f, com.fasterxml.jackson.databind.l
    public /* bridge */ /* synthetic */ Boolean a(com.fasterxml.jackson.databind.g r1) {
        return super.a(r1);
    }

    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return f(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.b.f, com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public /* bridge */ /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
        return super.a(r1, r2, r3);
    }

    @Override // com.fasterxml.jackson.databind.l, com.fasterxml.jackson.databind.b.s
    public /* synthetic */ Object a(com.fasterxml.jackson.databind.h r1) {
        return d(r1);
    }

    @Override // com.fasterxml.jackson.databind.b.b.f, com.fasterxml.jackson.databind.l
    public /* bridge */ /* synthetic */ com.fasterxml.jackson.databind.k.f b() {
        return super.b();
    }

    @Override // com.fasterxml.jackson.databind.b.b.f, com.fasterxml.jackson.databind.l
    public /* bridge */ /* synthetic */ boolean c() {
        return super.c();
    }

    static {
        f12451b = new r();
    }

    public r() {
        super(com.fasterxml.jackson.databind.n.class, null);
    }

    public static com.fasterxml.jackson.databind.l<? extends com.fasterxml.jackson.databind.n> a(Class<?> r1) {
        if (r1 != com.fasterxml.jackson.databind.i.q.class) goto L7;
        return b.h();
    L7:
        if (r1 != com.fasterxml.jackson.databind.i.a.class) goto L11;
        return a.h();
    L11:
        return f12451b;
    }

    public com.fasterxml.jackson.databind.n d(com.fasterxml.jackson.databind.h r1) {
        return r1.l().a();
    }

    public com.fasterxml.jackson.databind.n f(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8) {
        f.a r4 = new f.a();
        com.fasterxml.jackson.databind.i.l r3 = r8.l();
        int r0 = r7.m();
        if (r0 == 1) goto L19;
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L15;
        if (r0 == 5) goto L13;
        return b(r7, r8);
    L13:
        return a(r7, r8, r3, r4);
    L15:
        return a(r7, r8, r3, r4, r3.b());
    L17:
        return r3.c();
    L19:
        return a(r7, r8, r3, r4, r3.c());
    }
}
