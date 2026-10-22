package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.f.j;
import com.bumptech.glide.load.engine.v;
import com.bumptech.glide.load.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: compiled from: GifDrawableTransformation.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements m<GifDrawable> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m<Bitmap> f3884b;

    public e(m<Bitmap> r3) {
        this.f3884b = (m) ZeusTransformUtils.preCheckCast(j.a((m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.load.m
    public v<GifDrawable> a(Context r6, v<GifDrawable> r7, int r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        v<GifDrawable> r11 = (v) ZeusTransformUtils.wrapperContextForParams(r7, v.class, "com.obric.aiagent.plugin");
        GifDrawable r0 = (GifDrawable) ZeusTransformUtils.preCheckCast(r11.d(), GifDrawable.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.engine.a.e r2 = Glide.get(r10).getBitmapPool();
        v<Bitmap> r4 = new com.bumptech.glide.load.resource.bitmap.e(r0.getFirstFrame(), r2);
        v<Bitmap> r12 = this.f3884b.a(r10, r4, r8, r9);
        if (r4.equals(r12) == true) goto L5;
        r4.f();
    L5:
        Bitmap r13 = (Bitmap) ZeusTransformUtils.preCheckCast(r12.d(), Bitmap.class, "com.obric.aiagent.plugin");
        r0.setFrameTransformation(this.f3884b, r13);
        return r11;
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, e.class) == false) goto L6;
        e r4 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
        return this.f3884b.equals(r4.f3884b);
    L6:
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return this.f3884b.hashCode();
    }

    @Override // com.bumptech.glide.load.g
    public void a(MessageDigest r1) {
        this.f3884b.a(r1);
    }
}
