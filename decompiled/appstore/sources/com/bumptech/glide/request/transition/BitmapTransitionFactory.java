package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class BitmapTransitionFactory extends BitmapContainerTransitionFactory<Bitmap> {
    public BitmapTransitionFactory(@NonNull TransitionFactory<Drawable> r10) {
        super(r10);
    }

    @NonNull
    /* JADX INFO: renamed from: getBitmap, reason: avoid collision after fix types in other method */
    public Bitmap getBitmap2(@NonNull Bitmap r10) {
        return r10;
    }

    @Override // com.bumptech.glide.request.transition.BitmapContainerTransitionFactory
    @NonNull
    public /* bridge */ /* synthetic */ Bitmap getBitmap(@NonNull Bitmap r10) {
        return getBitmap2(r10);
    }
}
