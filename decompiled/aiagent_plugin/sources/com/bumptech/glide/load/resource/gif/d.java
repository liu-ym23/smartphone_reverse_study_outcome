package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.engine.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: GifDrawableResource.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends com.bumptech.glide.load.resource.b.b<GifDrawable> implements r {
    public d(GifDrawable r1) {
        super(r1);
    }

    @Override // com.bumptech.glide.load.engine.v
    public Class<GifDrawable> c() {
        return GifDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.v
    public int e() {
        return ((GifDrawable) ZeusTransformUtils.preCheckCast(this.f3778a, GifDrawable.class, "com.obric.aiagent.plugin")).getSize();
    }

    @Override // com.bumptech.glide.load.engine.v
    public void f() {
        ((GifDrawable) ZeusTransformUtils.preCheckCast(this.f3778a, GifDrawable.class, "com.obric.aiagent.plugin")).stop();
        ((GifDrawable) ZeusTransformUtils.preCheckCast(this.f3778a, GifDrawable.class, "com.obric.aiagent.plugin")).recycle();
    }

    @Override // com.bumptech.glide.load.resource.b.b, com.bumptech.glide.load.engine.r
    public void a() {
        ((GifDrawable) ZeusTransformUtils.preCheckCast(this.f3778a, GifDrawable.class, "com.obric.aiagent.plugin")).getFirstFrame().prepareToDraw();
    }
}
