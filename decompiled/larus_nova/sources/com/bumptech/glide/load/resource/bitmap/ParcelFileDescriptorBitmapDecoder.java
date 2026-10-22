package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class ParcelFileDescriptorBitmapDecoder implements ResourceDecoder<ParcelFileDescriptor, Bitmap> {
    private final Downsampler downsampler;

    public ParcelFileDescriptorBitmapDecoder(Downsampler r100) {
        this.downsampler = r100;
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(ParcelFileDescriptor r100, Options r101) {
        return this.downsampler.handles(r100);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(ParcelFileDescriptor r100, Options r101) throws IOException {
        return handles2(r100, r101);
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<Bitmap> decode2(ParcelFileDescriptor r100, int r101, int r102, Options r103) throws IOException {
        return this.downsampler.decode(r100, r101, r102, r103);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource<Bitmap> decode(ParcelFileDescriptor r100, int r101, int r102, Options r103) throws IOException {
        return decode2(r100, r101, r102, r103);
    }
}
