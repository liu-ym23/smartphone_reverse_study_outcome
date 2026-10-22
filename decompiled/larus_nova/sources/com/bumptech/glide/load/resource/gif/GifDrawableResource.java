package com.bumptech.glide.load.resource.gif;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.resource.drawable.DrawableResource;

/* JADX INFO: loaded from: classes39.dex */
public class GifDrawableResource extends DrawableResource<GifDrawable> {
    @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Resource
    public GifDrawable get() {
        Drawable.ConstantState r100 = ((GifDrawable) this.drawable).getConstantState();
        if (r100 == null) goto L5;
        GifDrawable r101 = (GifDrawable) r100.newDrawable();
        r101.setOverLimit(((GifDrawable) this.drawable).isOverLimit());
        return r101;
    L5:
        return (GifDrawable) this.drawable;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return ((GifDrawable) this.drawable).getSize();
    }

    @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        ((GifDrawable) this.drawable).getFirstFrame().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        ((GifDrawable) this.drawable).stop();
        ((GifDrawable) this.drawable).recycle();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<GifDrawable> getResourceClass() {
        return GifDrawable.class;
    }

    @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Resource
    public /* bridge */ /* synthetic */ Drawable get() {
        return get();
    }

    @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Resource
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GifDrawableResource(GifDrawable r100) {
        super(r100);
    }
}
