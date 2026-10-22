package com.bumptech.glide.load.resource.d;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DrawableBytesTranscoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements e<Drawable, byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f3859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e<Bitmap, byte[]> f3860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e<GifDrawable, byte[]> f3861c;

    private static v<GifDrawable> a(v<Drawable> r2) {
        return (v) ZeusTransformUtils.wrapperContextForParams(r2, v.class, "com.obric.aiagent.plugin");
    }

    public c(com.bumptech.glide.load.engine.a.e r3, e<Bitmap, byte[]> r4, e<GifDrawable, byte[]> r5) {
        com.bumptech.glide.load.engine.a.e r6 = (com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin");
        e<Bitmap, byte[]> r7 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.aiagent.plugin");
        e<GifDrawable, byte[]> r8 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.aiagent.plugin");
        this.f3859a = r6;
        this.f3860b = r7;
        this.f3861c = r8;
    }

    @Override // com.bumptech.glide.load.resource.d.e
    public v<byte[]> a(v<Drawable> r4, i r5) {
        v r6 = (v) ZeusTransformUtils.wrapperContextForParams(r4, v.class, "com.obric.aiagent.plugin");
        Drawable r0 = (Drawable) ZeusTransformUtils.preCheckCast(r6.d(), Drawable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, BitmapDrawable.class) == false) goto L7;
        return this.f3860b.a(com.bumptech.glide.load.resource.bitmap.e.a(((BitmapDrawable) ZeusTransformUtils.preCheckCast(r0, BitmapDrawable.class, "com.obric.aiagent.plugin")).getBitmap(), this.f3859a), r5);
    L7:
        if (ZeusTransformUtils.instanceOf(r0, GifDrawable.class) == true) goto L9;
        return null;
    L9:
        return this.f3861c.a(a(r6), r5);
    }
}
