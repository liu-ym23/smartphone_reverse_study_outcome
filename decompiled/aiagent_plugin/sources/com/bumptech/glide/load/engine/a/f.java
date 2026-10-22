package com.bumptech.glide.load.engine.a;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: BitmapPoolAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements e {
    @Override // com.bumptech.glide.load.engine.a.e
    public long a() {
        return 0;
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public void a(float r1) {
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public void a(int r1) {
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public void b() {
    }

    public f() {
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public void a(Bitmap r1) {
        r1.recycle();
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public Bitmap a(int r1, int r2, Bitmap.Config r3) {
        return Bitmap.createBitmap(r1, r2, r3);
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public Bitmap b(int r1, int r2, Bitmap.Config r3) {
        return a(r1, r2, r3);
    }
}
