package com.bumptech.glide.integration.webp.decoder;

import com.bumptech.glide.load.resource.drawable.DrawableResource;

/* JADX INFO: loaded from: classes39.dex */
public class WebpDrawableResource extends DrawableResource<WebpDrawable> {
    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return ((WebpDrawable) this.drawable).getSize();
    }

    @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        ((WebpDrawable) this.drawable).getFirstFrame().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        ((WebpDrawable) this.drawable).stop();
        ((WebpDrawable) this.drawable).recycle();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<WebpDrawable> getResourceClass() {
        return WebpDrawable.class;
    }

    public WebpDrawableResource(WebpDrawable r100) {
        super(r100);
    }
}
