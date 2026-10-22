package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;

/* JADX INFO: compiled from: InputStreamBitmapImageDecoderResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class t implements com.bumptech.glide.load.k<InputStream, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f3835a;

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(InputStream r1, com.bumptech.glide.load.i r2) {
        return true;
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ com.bumptech.glide.load.engine.v<Bitmap> a(InputStream r3, int r4, int r5, com.bumptech.glide.load.i r6) {
        return a2((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ boolean a(InputStream r3, com.bumptech.glide.load.i r4) {
        return a2((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.aiagent.plugin"), r4);
    }

    public t() {
        this.f3835a = new d();
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public com.bumptech.glide.load.engine.v<Bitmap> a2(InputStream r1, int r2, int r3, com.bumptech.glide.load.i r4) {
        ImageDecoder.Source r5 = ImageDecoder.createSource(com.bumptech.glide.f.a.a(r1));
        return this.f3835a.a2(r5, r2, r3, r4);
    }
}
