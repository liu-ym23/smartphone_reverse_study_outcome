package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class VideoBitmapDecoder extends VideoDecoder<ParcelFileDescriptor> {
    public VideoBitmapDecoder(Context r10) {
        this(Glide.get(r10).getBitmapPool());
    }

    public VideoBitmapDecoder(BitmapPool r10) {
        super(r10, new VideoDecoder.ParcelFileDescriptorInitializer());
    }
}
