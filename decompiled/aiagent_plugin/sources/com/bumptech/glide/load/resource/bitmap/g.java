package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteBufferBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements com.bumptech.glide.load.k<ByteBuffer, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f3798a;

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ com.bumptech.glide.load.engine.v<Bitmap> a(ByteBuffer r3, int r4, int r5, com.bumptech.glide.load.i r6) {
        return a2((ByteBuffer) ZeusTransformUtils.preCheckCast(r3, ByteBuffer.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ boolean a(ByteBuffer r3, com.bumptech.glide.load.i r4) {
        return a2((ByteBuffer) ZeusTransformUtils.preCheckCast(r3, ByteBuffer.class, "com.obric.aiagent.plugin"), r4);
    }

    public g(m r1) {
        this.f3798a = r1;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(ByteBuffer r1, com.bumptech.glide.load.i r2) {
        return this.f3798a.a(r1);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public com.bumptech.glide.load.engine.v<Bitmap> a2(ByteBuffer r1, int r2, int r3, com.bumptech.glide.load.i r4) {
        InputStream r5 = com.bumptech.glide.f.a.b(r1);
        return this.f3798a.a(r5, r2, r3, r4);
    }
}
