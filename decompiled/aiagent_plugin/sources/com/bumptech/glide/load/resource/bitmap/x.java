package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ResourceBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class x implements com.bumptech.glide.load.k<Uri, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.resource.b.d f3844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f3845b;

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ com.bumptech.glide.load.engine.v<Bitmap> a(Uri r3, int r4, int r5, com.bumptech.glide.load.i r6) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ boolean a(Uri r3, com.bumptech.glide.load.i r4) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.aiagent.plugin"), r4);
    }

    public x(com.bumptech.glide.load.resource.b.d r3, com.bumptech.glide.load.engine.a.e r4) {
        com.bumptech.glide.load.engine.a.e r5 = (com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin");
        this.f3844a = r3;
        this.f3845b = r5;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Uri r1, com.bumptech.glide.load.i r2) {
        return "android.resource".equals(r1.getScheme());
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public com.bumptech.glide.load.engine.v<Bitmap> a2(Uri r2, int r3, int r4, com.bumptech.glide.load.i r5) {
        com.bumptech.glide.load.engine.v<Drawable> r6 = this.f3844a.a2(r2, r3, r4, r5);
        if (r6 != null) goto L6;
        return null;
    L6:
        Drawable r7 = (Drawable) ZeusTransformUtils.preCheckCast(r6.d(), Drawable.class, "com.obric.aiagent.plugin");
        return n.a(this.f3845b, r7, r3, r4);
    }
}
