package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public abstract class DrawableResource<T extends Drawable> implements Resource<T>, Initializable {
    protected final T drawable;

    public DrawableResource(T r10) {
        this.drawable = (T) Preconditions.checkNotNull(r10);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public void initialize() {
        T r10 = this.drawable;
        if ((r10 instanceof BitmapDrawable) == false) goto L6;
        ((BitmapDrawable) r10).getBitmap().prepareToDraw();
        return;
    L6:
        if ((r10 instanceof GifDrawable) == false) goto L10;
        ((GifDrawable) r10).getFirstFrame().prepareToDraw();
        return;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public final T get() {
        Drawable.ConstantState r10 = this.drawable.getConstantState();
        if (r10 != null) goto L7;
        return this.drawable;
    L7:
        return (T) r10.newDrawable();
    }
}
