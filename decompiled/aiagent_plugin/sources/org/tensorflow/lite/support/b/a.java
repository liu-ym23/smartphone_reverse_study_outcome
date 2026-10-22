package org.tensorflow.lite.support.b;

import android.graphics.Bitmap;
import android.media.Image;

/* JADX INFO: compiled from: BitmapContainer.java */
/* JADX INFO: loaded from: classes5.dex */
final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap f40597a;

    public /* synthetic */ Object clone() {
        return a();
    }

    @Override // org.tensorflow.lite.support.b.c
    public /* synthetic */ c f() {
        return a();
    }

    static a a(Bitmap r1) {
        return new a(r1);
    }

    private a(Bitmap r3) {
        org.tensorflow.lite.support.a.a.a.a(r3, "Cannot load null bitmap.");
        org.tensorflow.lite.support.a.a.a.a(r3.getConfig().equals(Bitmap.Config.ARGB_8888), "Only supports loading ARGB_8888 bitmaps.");
        this.f40597a = r3;
    }

    public a a() {
        Bitmap r0 = this.f40597a;
        return a(r0.copy(r0.getConfig(), this.f40597a.isMutable()));
    }

    @Override // org.tensorflow.lite.support.b.c
    public org.tensorflow.lite.support.c.a a(org.tensorflow.lite.a r1) {
        org.tensorflow.lite.support.c.a r2 = org.tensorflow.lite.support.c.a.a(r1);
        d.a(this.f40597a, r2);
        return r2;
    }

    @Override // org.tensorflow.lite.support.b.c
    public Image b() {
        throw new UnsupportedOperationException("Converting from Bitmap to android.media.Image is unsupported.");
    }

    @Override // org.tensorflow.lite.support.b.c
    public int c() {
        return this.f40597a.getWidth();
    }

    @Override // org.tensorflow.lite.support.b.c
    public int d() {
        return this.f40597a.getHeight();
    }

    @Override // org.tensorflow.lite.support.b.c
    public b e() {
        return b.a(this.f40597a.getConfig());
    }
}
