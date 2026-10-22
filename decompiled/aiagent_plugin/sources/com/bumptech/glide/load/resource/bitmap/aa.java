package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: UnitBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class aa implements com.bumptech.glide.load.k<Bitmap, Bitmap> {

    /* JADX INFO: compiled from: UnitBitmapDecoder.java */
    private static final class a implements com.bumptech.glide.load.engine.v<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Bitmap f3782a;

        @Override // com.bumptech.glide.load.engine.v
        public void f() {
        }

        @Override // com.bumptech.glide.load.engine.v
        public /* synthetic */ Bitmap d() {
            return a();
        }

        a(Bitmap r1) {
            this.f3782a = r1;
        }

        @Override // com.bumptech.glide.load.engine.v
        public Class<Bitmap> c() {
            return Bitmap.class;
        }

        public Bitmap a() {
            return this.f3782a;
        }

        @Override // com.bumptech.glide.load.engine.v
        public int e() {
            return com.bumptech.glide.f.k.a(this.f3782a);
        }
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Bitmap r1, com.bumptech.glide.load.i r2) {
        return true;
    }

    public aa() {
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ com.bumptech.glide.load.engine.v<Bitmap> a(Bitmap r3, int r4, int r5, com.bumptech.glide.load.i r6) {
        return a2((Bitmap) ZeusTransformUtils.preCheckCast(r3, Bitmap.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ boolean a(Bitmap r3, com.bumptech.glide.load.i r4) {
        return a2((Bitmap) ZeusTransformUtils.preCheckCast(r3, Bitmap.class, "com.obric.aiagent.plugin"), r4);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public com.bumptech.glide.load.engine.v<Bitmap> a2(Bitmap r1, int r2, int r3, com.bumptech.glide.load.i r4) {
        return new a(r1);
    }
}
