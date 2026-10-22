package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes39.dex */
public class BitmapTransitionFactory extends BitmapContainerTransitionFactory<Bitmap> {
    /* JADX INFO: renamed from: getBitmap, reason: avoid collision after fix types in other method */
    public Bitmap getBitmap2(Bitmap r100) {
        return r100;
    }

    public BitmapTransitionFactory(TransitionFactory<Drawable> r100) {
        super(r100);
    }

    @Override // com.bumptech.glide.request.transition.BitmapContainerTransitionFactory
    public /* bridge */ /* synthetic */ Bitmap getBitmap(Bitmap r100) {
        return getBitmap2(r100);
    }
}
