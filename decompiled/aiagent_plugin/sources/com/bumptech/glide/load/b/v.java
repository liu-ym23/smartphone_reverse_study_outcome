package com.bumptech.glide.load.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: UnitModelLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class v<Model> implements n<Model, Model> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final v<?> f3496a = null;

    /* JADX INFO: compiled from: UnitModelLoader.java */
    public static class a<Model> implements o<Model, Model> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a<?> f3497a = null;

        static {
            f3497a = new a();
        }

        public static <T> a<T> a() {
            return (a<T>) f3497a;
        }

        @Deprecated
        public a() {
        }

        @Override // com.bumptech.glide.load.b.o
        public n<Model, Model> a(r r1) {
            return v.a();
        }
    }

    /* JADX INFO: compiled from: UnitModelLoader.java */
    private static class b<Model> implements com.bumptech.glide.load.a.d<Model> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Model f3498a;

        @Override // com.bumptech.glide.load.a.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.a.d
        public void c() {
        }

        b(Model r1) {
            this.f3498a = r1;
        }

        @Override // com.bumptech.glide.load.a.d
        public void a(com.bumptech.glide.e r2, com.bumptech.glide.load.a.d.a<? super Model> r3) {
            ((com.bumptech.glide.load.a.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.a.d.a.class, "com.obric.aiagent.plugin")).a(this.f3498a);
        }

        @Override // com.bumptech.glide.load.a.d
        public Class<Model> a() {
            return (Class<Model>) this.f3498a.getClass();
        }

        @Override // com.bumptech.glide.load.a.d
        public com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.f3349a;
        }
    }

    @Override // com.bumptech.glide.load.b.n
    public boolean a(Model r1) {
        return true;
    }

    static {
        f3496a = new v();
    }

    public static <T> v<T> a() {
        return (v<T>) f3496a;
    }

    @Deprecated
    public v() {
    }

    @Override // com.bumptech.glide.load.b.n
    public n.a<Model> a(Model r1, int r2, int r3, com.bumptech.glide.load.i r4) {
        return new n.a(new com.bumptech.glide.e.d(r1), new b(r1));
    }
}
