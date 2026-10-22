package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BitmapResource.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements com.bumptech.glide.load.engine.r, com.bumptech.glide.load.engine.v<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap f3796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f3797b;

    @Override // com.bumptech.glide.load.engine.v
    public /* synthetic */ Bitmap d() {
        return b();
    }

    public static e a(Bitmap r2, com.bumptech.glide.load.engine.a.e r3) {
        com.bumptech.glide.load.engine.a.e r4 = (com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return new e(r2, r4);
    }

    public e(Bitmap r3, com.bumptech.glide.load.engine.a.e r4) {
        com.bumptech.glide.load.engine.a.e r5 = (com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin");
        this.f3796a = (Bitmap) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r3, "Bitmap must not be null"), Bitmap.class, "com.obric.aiagent.plugin");
        this.f3797b = (com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r5, "BitmapPool must not be null"), com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.load.engine.v
    public Class<Bitmap> c() {
        return Bitmap.class;
    }

    public Bitmap b() {
        return this.f3796a;
    }

    @Override // com.bumptech.glide.load.engine.v
    public int e() {
        return com.bumptech.glide.f.k.a(this.f3796a);
    }

    @Override // com.bumptech.glide.load.engine.v
    public void f() {
        this.f3797b.a(this.f3796a);
    }

    @Override // com.bumptech.glide.load.engine.r
    public void a() {
        this.f3796a.prepareToDraw();
    }
}
