package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: compiled from: DrawableTransformation.java */
/* JADX INFO: loaded from: classes.dex */
public class o implements com.bumptech.glide.load.m<Drawable> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.m<Bitmap> f3821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f3822c;

    public com.bumptech.glide.load.m<BitmapDrawable> a() {
        return this;
    }

    public o(com.bumptech.glide.load.m<Bitmap> r3, boolean r4) {
        this.f3821b = (com.bumptech.glide.load.m) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.m.class, "com.obric.aiagent.plugin");
        this.f3822c = r4;
    }

    @Override // com.bumptech.glide.load.m
    public com.bumptech.glide.load.engine.v<Drawable> a(Context r5, com.bumptech.glide.load.engine.v<Drawable> r6, int r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.engine.v<Drawable> r10 = (com.bumptech.glide.load.engine.v) ZeusTransformUtils.wrapperContextForParams(r6, com.bumptech.glide.load.engine.v.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.engine.a.e r0 = Glide.get(r9).getBitmapPool();
        Drawable r1 = (Drawable) ZeusTransformUtils.preCheckCast(r10.d(), Drawable.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.engine.v<Bitmap> r2 = n.a(r0, r1, r7, r8);
        if (r2 == null) goto L5;
        com.bumptech.glide.load.engine.v<Bitmap> r11 = this.f3821b.a(r9, r2, r7, r8);
        if (r11.equals(r2) == false) goto L14;
        r11.f();
        return r10;
    L14:
        return a(r9, r11);
    L5:
        if (this.f3822c == true) goto L8;
        return r10;
    L8:
        throw new IllegalArgumentException("Unable to convert " + r1 + " to a Bitmap");
    }

    private com.bumptech.glide.load.engine.v<Drawable> a(Context r2, com.bumptech.glide.load.engine.v<Bitmap> r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.engine.v r4 = (com.bumptech.glide.load.engine.v) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.v.class, "com.obric.aiagent.plugin");
        return u.a(ZeusTransformUtils.getResources(r1, "com.obric.aiagent.plugin"), r4);
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, o.class) == false) goto L6;
        o r4 = (o) ZeusTransformUtils.preCheckCast(r3, o.class, "com.obric.aiagent.plugin");
        return this.f3821b.equals(r4.f3821b);
    L6:
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return this.f3821b.hashCode();
    }

    @Override // com.bumptech.glide.load.g
    public void a(MessageDigest r1) {
        this.f3821b.a(r1);
    }
}
