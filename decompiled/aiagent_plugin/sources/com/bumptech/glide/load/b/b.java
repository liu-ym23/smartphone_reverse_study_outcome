package com.bumptech.glide.load.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteArrayLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class b<Data> implements n<byte[], Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC0089b<Data> f3424a;

    /* JADX INFO: compiled from: ByteArrayLoader.java */
    public static class a implements o<byte[], ByteBuffer> {
        public a() {
        }

        @Override // com.bumptech.glide.load.b.o
        public n<byte[], ByteBuffer> a(r r2) {
            return new b(new AnonymousClass1(this));
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteArrayLoader.java */
    public interface InterfaceC0089b<Data> {
        Class<Data> a();

        Data b(byte[] r1);
    }

    /* JADX INFO: compiled from: ByteArrayLoader.java */
    private static class c<Data> implements com.bumptech.glide.load.a.d<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f3426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final InterfaceC0089b<Data> f3427b;

        @Override // com.bumptech.glide.load.a.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.a.d
        public void c() {
        }

        c(byte[] r3, InterfaceC0089b<Data> r4) {
            InterfaceC0089b<Data> r5 = (InterfaceC0089b) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0089b.class, "com.obric.aiagent.plugin");
            this.f3426a = r3;
            this.f3427b = r5;
        }

        @Override // com.bumptech.glide.load.a.d
        public void a(com.bumptech.glide.e r2, com.bumptech.glide.load.a.d.a<? super Data> r3) {
            ((com.bumptech.glide.load.a.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.a.d.a.class, "com.obric.aiagent.plugin")).a(this.f3427b.b(this.f3426a));
        }

        @Override // com.bumptech.glide.load.a.d
        public Class<Data> a() {
            return this.f3427b.a();
        }

        @Override // com.bumptech.glide.load.a.d
        public com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.f3349a;
        }
    }

    /* JADX INFO: compiled from: ByteArrayLoader.java */
    public static class d implements o<byte[], InputStream> {
        public d() {
        }

        @Override // com.bumptech.glide.load.b.o
        public n<byte[], InputStream> a(r r2) {
            return new b(new AnonymousClass1(this));
        }
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(byte[] r1) {
        return true;
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ n.a a(byte[] r3, int r4, int r5, com.bumptech.glide.load.i r6) {
        return a2((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ boolean a(byte[] r3) {
        return a2((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.aiagent.plugin"));
    }

    public b(InterfaceC0089b<Data> r3) {
        this.f3424a = (InterfaceC0089b) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0089b.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public n.a<Data> a2(byte[] r1, int r2, int r3, com.bumptech.glide.load.i r4) {
        return new n.a(new com.bumptech.glide.e.d(r1), new c(r1, this.f3424a));
    }
}
