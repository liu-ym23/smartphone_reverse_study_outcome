package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LazyBitmapDrawableResource.java */
/* JADX INFO: loaded from: classes.dex */
public final class u implements com.bumptech.glide.load.engine.r, com.bumptech.glide.load.engine.v<BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f3836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.v<Bitmap> f3837b;

    @Override // com.bumptech.glide.load.engine.v
    public /* synthetic */ BitmapDrawable d() {
        return b();
    }

    public static com.bumptech.glide.load.engine.v<BitmapDrawable> a(Resources r2, com.bumptech.glide.load.engine.v<Bitmap> r3) {
        com.bumptech.glide.load.engine.v r4 = (com.bumptech.glide.load.engine.v) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.v.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return new u(r2, r4);
    }

    private u(Resources r3, com.bumptech.glide.load.engine.v<Bitmap> r4) {
        com.bumptech.glide.load.engine.v r5 = (com.bumptech.glide.load.engine.v) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.v.class, "com.obric.aiagent.plugin");
        this.f3836a = (Resources) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r3), Resources.class, "com.obric.aiagent.plugin");
        this.f3837b = (com.bumptech.glide.load.engine.v) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r5), com.bumptech.glide.load.engine.v.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.load.engine.v
    public Class<BitmapDrawable> c() {
        return BitmapDrawable.class;
    }

    public BitmapDrawable b() {
        return new BitmapDrawable(this.f3836a, (Bitmap) ZeusTransformUtils.preCheckCast(this.f3837b.d(), Bitmap.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bumptech.glide.load.engine.v
    public int e() {
        return this.f3837b.e();
    }

    @Override // com.bumptech.glide.load.engine.v
    public void f() {
        this.f3837b.f();
    }

    @Override // com.bumptech.glide.load.engine.r
    public void a() {
        if (ZeusTransformUtils.instanceOf(this.f3837b, com.bumptech.glide.load.engine.r.class) == false) goto L6;
        ((com.bumptech.glide.load.engine.r) ZeusTransformUtils.preCheckCast(this.f3837b, com.bumptech.glide.load.engine.r.class, "com.obric.aiagent.plugin")).a();
        return;
    }
}
