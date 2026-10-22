package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes39.dex */
public abstract class DrawableResource<T extends Drawable> implements Resource<T>, Initializable {
    protected final T drawable;

    @Override // com.bumptech.glide.load.engine.Resource
    public T get() {
        Drawable.ConstantState r100 = this.drawable.getConstantState();
        if (r100 != null) goto L7;
        return this.drawable;
    L7:
        return (T) r100.newDrawable();
    }

    public void initialize() {
        T r100 = this.drawable;
        if ((r100 instanceof BitmapDrawable) == false) goto L6;
        ((BitmapDrawable) r100).getBitmap().prepareToDraw();
        return;
    L6:
        if ((r100 instanceof GifDrawable) == false) goto L10;
        ((GifDrawable) r100).getFirstFrame().prepareToDraw();
        return;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DrawableResource(T r100) {
        this.drawable = (T) Preconditions.checkNotNull(r100);
    }
}
