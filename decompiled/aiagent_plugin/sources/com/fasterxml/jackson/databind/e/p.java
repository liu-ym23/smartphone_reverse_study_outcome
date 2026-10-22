package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: AnnotationCollector.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final com.fasterxml.jackson.databind.l.b f12646a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Object f12647b;

    /* JADX INFO: compiled from: AnnotationCollector.java */
    static class a extends p {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f12648c = null;

        @Override // com.fasterxml.jackson.databind.e.p
        public boolean a(Annotation r2) {
            Annotation r1 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r2, Annotation.class, "com.obric.aiagent.plugin");
            return false;
        }

        static {
            f12648c = new a(null);
        }

        a(Object r1) {
            super(r1);
        }

        @Override // com.fasterxml.jackson.databind.e.p
        public com.fasterxml.jackson.databind.l.b c() {
            return f12646a;
        }

        @Override // com.fasterxml.jackson.databind.e.p
        public q d() {
            return new q();
        }

        @Override // com.fasterxml.jackson.databind.e.p
        public p b(Annotation r3) {
            Annotation r4 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r3, Annotation.class, "com.obric.aiagent.plugin");
            return new e(this.f12647b, r4.annotationType(), r4);
        }
    }

    /* JADX INFO: compiled from: AnnotationCollector.java */
    static class b extends p {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final HashMap<Class<?>, Annotation> f12649c;

        public b(Object r3, Class<?> r4, Annotation r5, Class<?> r6, Annotation r7) {
            Annotation r8 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r5, Annotation.class, "com.obric.aiagent.plugin");
            Annotation r9 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r7, Annotation.class, "com.obric.aiagent.plugin");
            super(r3);
            HashMap<Class<?>, Annotation> r10 = new HashMap();
            this.f12649c = r10;
            r10.put(r4, r8);
            r10.put(r6, r9);
        }

        @Override // com.fasterxml.jackson.databind.e.p
        public com.fasterxml.jackson.databind.l.b c() {
            if (this.f12649c.size() != 2) goto L7;
            Iterator<Map.Entry<Class<?>, Annotation>> r6 = this.f12649c.entrySet().iterator();
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            return new f((Class) ZeusTransformUtils.preCheckCast(r0.getKey(), Class.class, "com.obric.aiagent.plugin"), (Annotation) ZeusTransformUtils.preCheckCast(r0.getValue(), Annotation.class, "com.obric.aiagent.plugin"), (Class) ZeusTransformUtils.preCheckCast(r7.getKey(), Class.class, "com.obric.aiagent.plugin"), (Annotation) ZeusTransformUtils.preCheckCast(r7.getValue(), Annotation.class, "com.obric.aiagent.plugin"));
        L7:
            return new q(this.f12649c);
        }

        @Override // com.fasterxml.jackson.databind.e.p
        public q d() {
            q r0 = new q();
            Iterator<Annotation> r4 = this.f12649c.values().iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r0.a((Annotation) ZeusTransformUtils.preCheckCast(r4.next(), Annotation.class, "com.obric.aiagent.plugin"));
            goto L4
        L6:
            return r0;
        }

        @Override // com.fasterxml.jackson.databind.e.p
        public boolean a(Annotation r3) {
            Annotation r4 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r3, Annotation.class, "com.obric.aiagent.plugin");
            return this.f12649c.containsKey(r4.annotationType());
        }

        @Override // com.fasterxml.jackson.databind.e.p
        public p b(Annotation r3) {
            Annotation r4 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r3, Annotation.class, "com.obric.aiagent.plugin");
            this.f12649c.put(r4.annotationType(), r4);
            return this;
        }
    }

    /* JADX INFO: compiled from: AnnotationCollector.java */
    public static class c implements com.fasterxml.jackson.databind.l.b, Serializable {
        @Override // com.fasterxml.jackson.databind.l.b
        public int a() {
            return 0;
        }

        @Override // com.fasterxml.jackson.databind.l.b
        public <A extends Annotation> A a(Class<A> r1) {
            return null;
        }

        @Override // com.fasterxml.jackson.databind.l.b
        public boolean a(Class<? extends Annotation>[] r1) {
            return false;
        }

        @Override // com.fasterxml.jackson.databind.l.b
        public boolean b(Class<?> r1) {
            return false;
        }

        c() {
        }
    }

    /* JADX INFO: compiled from: AnnotationCollector.java */
    public static class d implements com.fasterxml.jackson.databind.l.b, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<?> f12650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Annotation f12651b;

        @Override // com.fasterxml.jackson.databind.l.b
        public int a() {
            return 1;
        }

        public d(Class<?> r3, Annotation r4) {
            Annotation r5 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r4, Annotation.class, "com.obric.aiagent.plugin");
            this.f12650a = r3;
            this.f12651b = r5;
        }

        @Override // com.fasterxml.jackson.databind.l.b
        public <A extends Annotation> A a(Class<A> r2) {
            if (this.f12650a == r2) goto L5;
            return null;
        L5:
            return (A) this.f12651b;
        }

        @Override // com.fasterxml.jackson.databind.l.b
        public boolean b(Class<?> r1) {
            if (this.f12650a != r1) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.fasterxml.jackson.databind.l.b
        public boolean a(Class<? extends Annotation>[] r6) {
            int r0 = r6.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L9;
            if (r6[r2] == this.f12650a) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }
    }

    /* JADX INFO: compiled from: AnnotationCollector.java */
    static class e extends p {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Class<?> f12652c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Annotation f12653d;

        public e(Object r3, Class<?> r4, Annotation r5) {
            Annotation r6 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r5, Annotation.class, "com.obric.aiagent.plugin");
            super(r3);
            this.f12652c = r4;
            this.f12653d = r6;
        }

        @Override // com.fasterxml.jackson.databind.e.p
        public com.fasterxml.jackson.databind.l.b c() {
            return new d(this.f12652c, this.f12653d);
        }

        @Override // com.fasterxml.jackson.databind.e.p
        public q d() {
            return q.a(this.f12652c, this.f12653d);
        }

        @Override // com.fasterxml.jackson.databind.e.p
        public boolean a(Annotation r3) {
            if (((Annotation) ZeusTransformUtils.wrapperContextForParams(r3, Annotation.class, "com.obric.aiagent.plugin")).annotationType() != this.f12652c) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.fasterxml.jackson.databind.e.p
        public p b(Annotation r7) {
            Annotation r5 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r7, Annotation.class, "com.obric.aiagent.plugin");
            Class<? extends Annotation> r4 = r5.annotationType();
            if (this.f12652c != r4) goto L7;
            this.f12653d = r5;
            return this;
        L7:
            return new b(this.f12647b, this.f12652c, this.f12653d, r4, r5);
        }
    }

    /* JADX INFO: compiled from: AnnotationCollector.java */
    public static class f implements com.fasterxml.jackson.databind.l.b, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<?> f12654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<?> f12655b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Annotation f12656c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Annotation f12657d;

        @Override // com.fasterxml.jackson.databind.l.b
        public int a() {
            return 2;
        }

        public f(Class<?> r3, Annotation r4, Class<?> r5, Annotation r6) {
            Annotation r7 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r4, Annotation.class, "com.obric.aiagent.plugin");
            Annotation r8 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r6, Annotation.class, "com.obric.aiagent.plugin");
            this.f12654a = r3;
            this.f12656c = r7;
            this.f12655b = r5;
            this.f12657d = r8;
        }

        @Override // com.fasterxml.jackson.databind.l.b
        public <A extends Annotation> A a(Class<A> r2) {
            if (this.f12654a != r2) goto L7;
            return (A) this.f12656c;
        L7:
            if (this.f12655b == r2) goto L9;
            return null;
        L9:
            return (A) this.f12657d;
        }

        @Override // com.fasterxml.jackson.databind.l.b
        public boolean b(Class<?> r2) {
            if (this.f12654a != r2) goto L5;
        L8:
            return true;
        L5:
            if (this.f12655b == r2) goto L8;
            return false;
        }

        @Override // com.fasterxml.jackson.databind.l.b
        public boolean a(Class<? extends Annotation>[] r6) {
            int r0 = r6.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L12;
            Class<? extends Annotation> r3 = r6[r2];
            if (r3 == this.f12654a) goto L10;
            if (r3 == this.f12655b) goto L16;
            r2 = r2 + 1;
            goto L3
        L16:
            return true;
        L10:
            return true;
        L12:
            return false;
        }
    }

    public abstract boolean a(Annotation r1);

    public abstract p b(Annotation r1);

    public abstract com.fasterxml.jackson.databind.l.b c();

    public abstract q d();

    static {
        f12646a = new c();
    }

    public p(Object r1) {
        this.f12647b = r1;
    }

    public static com.fasterxml.jackson.databind.l.b a() {
        return f12646a;
    }

    public static p b() {
        return a.f12648c;
    }
}
