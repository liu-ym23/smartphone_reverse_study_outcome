package com.bumptech.glide.load.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: DataUrlLoader.java */
/* JADX INFO: loaded from: classes.dex */
public final class e<Model, Data> implements n<Model, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a<Data> f3430a;

    /* JADX INFO: compiled from: DataUrlLoader.java */
    public interface a<Data> {
        Class<Data> a();

        Data a(String r1);

        void a(Data r1);
    }

    /* JADX INFO: compiled from: DataUrlLoader.java */
    private static final class b<Data> implements com.bumptech.glide.load.a.d<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f3431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a<Data> f3432b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Data f3433c;

        @Override // com.bumptech.glide.load.a.d
        public void c() {
        }

        b(String r3, a<Data> r4) {
            a<Data> r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
            this.f3431a = r3;
            this.f3432b = r5;
        }

        @Override // com.bumptech.glide.load.a.d
        public void a(com.bumptech.glide.e r2, com.bumptech.glide.load.a.d.a<? super Data> r3) {
            com.bumptech.glide.load.a.d.a r4 = (com.bumptech.glide.load.a.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.a.d.a.class, "com.obric.aiagent.plugin");
            Data r5 = this.f3432b.a(this.f3431a);     // Catch: IllegalArgumentException -> L5
            this.f3433c = r5;     // Catch: IllegalArgumentException -> L5
            r4.a(r5);     // Catch: IllegalArgumentException -> L5
            return;
        L5:
            e = move-exception;
            r4.a(e);
        }

        @Override // com.bumptech.glide.load.a.d
        public void b() {
            this.f3432b.a(this.f3433c);     // Catch: IOException -> L4
            return;
        }

        @Override // com.bumptech.glide.load.a.d
        public Class<Data> a() {
            return this.f3432b.a();
        }

        @Override // com.bumptech.glide.load.a.d
        public com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.f3349a;
        }
    }

    /* JADX INFO: compiled from: DataUrlLoader.java */
    public static final class c<Model> implements o<Model, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a<InputStream> f3434a;

        public c() {
            this.f3434a = new AnonymousClass1(this);
        }

        @Override // com.bumptech.glide.load.b.o
        public n<Model, InputStream> a(r r1) {
            return new e(this.f3434a);
        }
    }

    public e(a<Data> r3) {
        this.f3430a = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.load.b.n
    public n.a<Data> a(Model r1, int r2, int r3, com.bumptech.glide.load.i r4) {
        return new n.a(new com.bumptech.glide.e.d(r1), new b(r1.toString(), this.f3430a));
    }

    @Override // com.bumptech.glide.load.b.n
    public boolean a(Model r1) {
        return r1.toString().startsWith("data:image");
    }
}
