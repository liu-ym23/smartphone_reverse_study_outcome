package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BitmapDrawableDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class a<DataType> implements com.bumptech.glide.load.k<DataType, BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.k<DataType, Bitmap> f3780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f3781b;

    public a(Resources r3, com.bumptech.glide.load.k<DataType, Bitmap> r4) {
        com.bumptech.glide.load.k r5 = (com.bumptech.glide.load.k) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.k.class, "com.obric.aiagent.plugin");
        this.f3781b = (Resources) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r3), Resources.class, "com.obric.aiagent.plugin");
        this.f3780a = (com.bumptech.glide.load.k) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r5), com.bumptech.glide.load.k.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.load.k
    public boolean a(DataType r1, com.bumptech.glide.load.i r2) {
        return this.f3780a.a(r1, r2);
    }

    @Override // com.bumptech.glide.load.k
    public com.bumptech.glide.load.engine.v<BitmapDrawable> a(DataType r2, int r3, int r4, com.bumptech.glide.load.i r5) {
        com.bumptech.glide.load.engine.v<Bitmap> r6 = this.f3780a.a(r2, r3, r4, r5);
        return u.a(this.f3781b, r6);
    }
}
