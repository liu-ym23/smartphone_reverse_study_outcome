package com.bytedance.retrofit2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: BuiltInConverters.java */
/* JADX INFO: loaded from: classes.dex */
final class d extends com.bytedance.retrofit2.i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f9490a;

    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class a implements com.bytedance.retrofit2.i<com.bytedance.retrofit2.e.i, com.bytedance.retrofit2.e.i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f9491a = null;

        a() {
        }

        @Override // com.bytedance.retrofit2.i
        public /* synthetic */ com.bytedance.retrofit2.e.i b(com.bytedance.retrofit2.e.i r3) {
            return a((com.bytedance.retrofit2.e.i) ZeusTransformUtils.preCheckCast(r3, com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin"));
        }

        static {
            f9491a = new a();
        }

        public com.bytedance.retrofit2.e.i a(com.bytedance.retrofit2.e.i r4) {
            com.bytedance.retrofit2.e.i r3 = (com.bytedance.retrofit2.e.i) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin");
            if (r3 != null) goto L5;
        L16:
            return r3;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, com.bytedance.retrofit2.e.g.class) == true) goto L16;
            String r5 = r3.b();
            InputStream r6 = r3.e_();
            com.bytedance.retrofit2.e.g r1 = new com.bytedance.retrofit2.e.g(r5, an.a(r6), new String[0]);     // Catch: Throwable -> L12
            if (r6 != null) goto L21;
        L11:
            return r1;
        L21:
            r6.close();     // Catch: IOException -> L17
        L12:
            th = move-exception;
            if (r6 != null) goto L19;
        L15:
            throw th;
        L19:
            r6.close();     // Catch: IOException -> L18
            goto L15
        }
    }

    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class b implements com.bytedance.retrofit2.i<com.bytedance.retrofit2.b.b, com.bytedance.retrofit2.b.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f9492a = null;

        public com.bytedance.retrofit2.b.b a(com.bytedance.retrofit2.b.b r1) {
            return r1;
        }

        b() {
        }

        @Override // com.bytedance.retrofit2.i
        public /* synthetic */ com.bytedance.retrofit2.b.b b(com.bytedance.retrofit2.b.b r3) {
            return a((com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r3, com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin"));
        }

        static {
            f9492a = new b();
        }
    }

    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class c implements com.bytedance.retrofit2.i<Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f9493a = null;

        @Override // com.bytedance.retrofit2.i
        public Object b(Object r1) {
            return r1;
        }

        c() {
        }

        static {
            f9493a = new c();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.retrofit2.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class C0217d implements com.bytedance.retrofit2.i<com.bytedance.retrofit2.e.j, com.bytedance.retrofit2.e.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final C0217d f9494a = null;

        public com.bytedance.retrofit2.e.j a(com.bytedance.retrofit2.e.j r2) {
            return (com.bytedance.retrofit2.e.j) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.retrofit2.e.j.class, "com.obric.aiagent.plugin");
        }

        C0217d() {
        }

        @Override // com.bytedance.retrofit2.i
        public /* synthetic */ com.bytedance.retrofit2.e.j b(com.bytedance.retrofit2.e.j r3) {
            return a((com.bytedance.retrofit2.e.j) ZeusTransformUtils.preCheckCast(r3, com.bytedance.retrofit2.e.j.class, "com.obric.aiagent.plugin"));
        }

        static {
            f9494a = new C0217d();
        }
    }

    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class e implements com.bytedance.retrofit2.i<com.bytedance.retrofit2.e.i, com.bytedance.retrofit2.e.i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final e f9495a = null;

        public com.bytedance.retrofit2.e.i a(com.bytedance.retrofit2.e.i r2) {
            return (com.bytedance.retrofit2.e.i) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin");
        }

        e() {
        }

        @Override // com.bytedance.retrofit2.i
        public /* synthetic */ com.bytedance.retrofit2.e.i b(com.bytedance.retrofit2.e.i r3) {
            return a((com.bytedance.retrofit2.e.i) ZeusTransformUtils.preCheckCast(r3, com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin"));
        }

        static {
            f9495a = new e();
        }
    }

    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class f implements com.bytedance.retrofit2.i<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final f f9496a = null;

        public String a(String r1) {
            return r1;
        }

        f() {
        }

        @Override // com.bytedance.retrofit2.i
        public /* synthetic */ String b(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        static {
            f9496a = new f();
        }
    }

    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class g implements com.bytedance.retrofit2.i<com.bytedance.retrofit2.e.i, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final g f9497a = null;

        g() {
        }

        @Override // com.bytedance.retrofit2.i
        public /* synthetic */ String b(com.bytedance.retrofit2.e.i r3) {
            return a((com.bytedance.retrofit2.e.i) ZeusTransformUtils.preCheckCast(r3, com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin"));
        }

        static {
            f9497a = new g();
        }

        public String a(com.bytedance.retrofit2.e.i r4) {
            com.bytedance.retrofit2.e.i r3 = (com.bytedance.retrofit2.e.i) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r3, com.bytedance.retrofit2.e.g.class) == false) goto L9;
            String r5 = "UTF-8";
            if (r3.b() == null) goto L8;
            r5 = com.bytedance.retrofit2.e.d.a(r3.b(), "UTF-8");
        L8:
            return new String(((com.bytedance.retrofit2.e.g) ZeusTransformUtils.preCheckCast(r3, com.bytedance.retrofit2.e.g.class, "com.obric.aiagent.plugin")).i(), r5);
        L9:
            return null;
        }
    }

    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class h implements com.bytedance.retrofit2.i<Object, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final h f9498a = null;

        h() {
        }

        @Override // com.bytedance.retrofit2.i
        public /* synthetic */ String b(Object r1) {
            return a(r1);
        }

        static {
            f9498a = new h();
        }

        public String a(Object r1) {
            return r1.toString();
        }
    }

    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class i implements com.bytedance.retrofit2.i<com.bytedance.retrofit2.e.i, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final i f9499a = null;

        i() {
        }

        @Override // com.bytedance.retrofit2.i
        public /* synthetic */ d.x b(com.bytedance.retrofit2.e.i r3) {
            return a((com.bytedance.retrofit2.e.i) ZeusTransformUtils.preCheckCast(r3, com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin"));
        }

        static {
            f9499a = new i();
        }

        public d.x a(com.bytedance.retrofit2.e.i r2) {
            ((com.bytedance.retrofit2.e.i) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin")).e_().close();     // Catch: IOException -> L5
        L8:
            return d.x.f38692a;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L8
        }
    }

    /* JADX INFO: compiled from: BuiltInConverters.java */
    static final class j implements com.bytedance.retrofit2.i<com.bytedance.retrofit2.e.i, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final j f9500a = null;

        j() {
        }

        @Override // com.bytedance.retrofit2.i
        public /* synthetic */ Void b(com.bytedance.retrofit2.e.i r3) {
            return a((com.bytedance.retrofit2.e.i) ZeusTransformUtils.preCheckCast(r3, com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin"));
        }

        static {
            f9500a = new j();
        }

        public Void a(com.bytedance.retrofit2.e.i r2) {
            InputStream r1 = ((com.bytedance.retrofit2.e.i) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin")).e_();
            if (r1 == null) goto L7;
            r1.close();
            return null;
        L7:
            return null;
        }
    }

    d() {
        this.f9490a = true;
    }

    @Override // com.bytedance.retrofit2.i.a
    public com.bytedance.retrofit2.i<com.bytedance.retrofit2.e.i, ?> a(Type r2, Annotation[] r3, ab r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.aiagent.plugin");
        if (r5 != com.bytedance.retrofit2.e.i.class) goto L11;
        if (an.a(r3, com.bytedance.retrofit2.c.ae.class) == false) goto L9;
        return e.f9495a;
    L9:
        return a.f9491a;
    L11:
        if (r5 != String.class) goto L15;
        return g.f9497a;
    L15:
        if (r5 != Void.class) goto L19;
        return j.f9500a;
    L19:
        if (this.f9490a == true) goto L21;
        return null;
    L21:
        if (r5 != d.x.class) goto L30;
        return i.f9499a;
    L24:
        this.f9490a = false;
        return null;
    L30:
        return null;
    }

    @Override // com.bytedance.retrofit2.i.a
    public com.bytedance.retrofit2.i<?, com.bytedance.retrofit2.e.j> a(Type r1, Annotation[] r2, Annotation[] r3, ab r4) {
        if (com.bytedance.retrofit2.e.j.class.isAssignableFrom(an.a((Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.aiagent.plugin"))) == true) goto L5;
        return null;
    L5:
        return C0217d.f9494a;
    }

    @Override // com.bytedance.retrofit2.i.a
    public com.bytedance.retrofit2.i<?, Object> b(Type r1, Annotation[] r2, ab r3) {
        if (((Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.aiagent.plugin")) == Object.class) goto L5;
        return null;
    L5:
        return c.f9493a;
    }

    @Override // com.bytedance.retrofit2.i.a
    public com.bytedance.retrofit2.i<?, String> c(Type r1, Annotation[] r2, ab r3) {
        if (((Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.aiagent.plugin")) == String.class) goto L5;
        return null;
    L5:
        return f.f9496a;
    }

    @Override // com.bytedance.retrofit2.i.a
    public com.bytedance.retrofit2.i<?, com.bytedance.retrofit2.b.b> d(Type r1, Annotation[] r2, ab r3) {
        if (((Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.aiagent.plugin")) == com.bytedance.retrofit2.b.b.class) goto L5;
        return null;
    L5:
        return b.f9492a;
    }
}
