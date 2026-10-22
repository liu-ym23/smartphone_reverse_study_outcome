package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ParcelFileDescriptorBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class v implements com.bumptech.glide.load.k<ParcelFileDescriptor, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f3838a;

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ com.bumptech.glide.load.engine.v<Bitmap> a(ParcelFileDescriptor r3, int r4, int r5, com.bumptech.glide.load.i r6) {
        return a2((ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(r3, ParcelFileDescriptor.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ boolean a(ParcelFileDescriptor r3, com.bumptech.glide.load.i r4) {
        return a2((ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(r3, ParcelFileDescriptor.class, "com.obric.aiagent.plugin"), r4);
    }

    public v(m r1) {
        this.f3838a = r1;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(ParcelFileDescriptor r1, com.bumptech.glide.load.i r2) {
        return this.f3838a.a(r1);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public com.bumptech.glide.load.engine.v<Bitmap> a2(ParcelFileDescriptor r1, int r2, int r3, com.bumptech.glide.load.i r4) {
        return this.f3838a.a(r1, r2, r3, r4);
    }
}
