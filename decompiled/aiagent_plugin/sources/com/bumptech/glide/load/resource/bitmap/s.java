package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: ImageReader.java */
/* JADX INFO: loaded from: classes.dex */
interface s {

    /* JADX INFO: compiled from: ImageReader.java */
    public static final class a implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.a.k f3829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.load.engine.a.b f3830b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<ImageHeaderParser> f3831c;

        a(InputStream r4, List<ImageHeaderParser> r5, com.bumptech.glide.load.engine.a.b r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            com.bumptech.glide.load.engine.a.b r8 = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r6, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
            this.f3830b = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r8), com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
            this.f3831c = (List) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r7), List.class, "com.obric.aiagent.plugin");
            this.f3829a = new com.bumptech.glide.load.a.k(r4, r8);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.s
        public Bitmap a(BitmapFactory.Options r2) {
            return BitmapFactory.decodeStream(this.f3829a.c(), null, r2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.s
        public ImageHeaderParser.ImageType a() {
            return com.bumptech.glide.load.f.getType(this.f3831c, this.f3829a.c(), this.f3830b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.s
        public int b() {
            return com.bumptech.glide.load.f.a(this.f3831c, this.f3829a.c(), this.f3830b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.s
        public void c() {
            this.f3829a.d();
        }
    }

    /* JADX INFO: compiled from: ImageReader.java */
    public static final class b implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.engine.a.b f3832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<ImageHeaderParser> f3833b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bumptech.glide.load.a.m f3834c;

        @Override // com.bumptech.glide.load.resource.bitmap.s
        public void c() {
        }

        b(ParcelFileDescriptor r3, List<ImageHeaderParser> r4, com.bumptech.glide.load.engine.a.b r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f3832a = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a((com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin")), com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
            this.f3833b = (List) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r6), List.class, "com.obric.aiagent.plugin");
            this.f3834c = new com.bumptech.glide.load.a.m(r3);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.s
        public Bitmap a(BitmapFactory.Options r2) {
            return BitmapFactory.decodeFileDescriptor(this.f3834c.d().getFileDescriptor(), null, r2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.s
        public ImageHeaderParser.ImageType a() {
            return com.bumptech.glide.load.f.getType(this.f3833b, this.f3834c, this.f3832a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.s
        public int b() {
            return com.bumptech.glide.load.f.a(this.f3833b, this.f3834c, this.f3832a);
        }
    }

    Bitmap a(BitmapFactory.Options r1);

    ImageHeaderParser.ImageType a();

    int b();

    void c();
}
