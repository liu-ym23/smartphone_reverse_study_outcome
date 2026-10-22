package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: BitmapDrawableEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements com.bumptech.glide.load.l<BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f3790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.l<Bitmap> f3791b;

    @Override // com.bumptech.glide.load.d
    public /* synthetic */ boolean a(Object r3, File r4, com.bumptech.glide.load.i r5) {
        return a((com.bumptech.glide.load.engine.v) ZeusTransformUtils.preCheckCast(r3, com.bumptech.glide.load.engine.v.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public b(com.bumptech.glide.load.engine.a.e r3, com.bumptech.glide.load.l<Bitmap> r4) {
        com.bumptech.glide.load.engine.a.e r5 = (com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.l<Bitmap> r6 = (com.bumptech.glide.load.l) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.l.class, "com.obric.aiagent.plugin");
        this.f3790a = r5;
        this.f3791b = r6;
    }

    public boolean a(com.bumptech.glide.load.engine.v<BitmapDrawable> r5, File r6, com.bumptech.glide.load.i r7) {
        com.bumptech.glide.load.engine.v r8 = (com.bumptech.glide.load.engine.v) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.engine.v.class, "com.obric.aiagent.plugin");
        return this.f3791b.a((Bitmap) new e(((BitmapDrawable) ZeusTransformUtils.preCheckCast(r8.d(), BitmapDrawable.class, "com.obric.aiagent.plugin")).getBitmap(), this.f3790a), r6, r7);
    }

    @Override // com.bumptech.glide.load.l
    public com.bumptech.glide.load.c a(com.bumptech.glide.load.i r1) {
        return this.f3791b.a(r1);
    }
}
