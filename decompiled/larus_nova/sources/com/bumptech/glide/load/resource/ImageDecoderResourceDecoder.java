package com.bumptech.glide.load.resource;

import android.graphics.ImageDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public abstract class ImageDecoderResourceDecoder<T> implements ResourceDecoder<ImageDecoder.Source, T> {
    private static final String TAG = "ImageDecoder";
    final HardwareConfigState hardwareConfigState;

    public abstract Resource<T> decode(ImageDecoder.Source r100, int r101, int r102, ImageDecoder.OnHeaderDecodedListener r103) throws IOException;

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public final boolean handles2(ImageDecoder.Source r100, Options r101) {
        return true;
    }

    public ImageDecoderResourceDecoder() {
        this.hardwareConfigState = HardwareConfigState.getInstance();
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(ImageDecoder.Source r100, Options r101) throws IOException {
        return handles2(r100, r101);
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public final Resource<T> decode2(ImageDecoder.Source r110, final int r111, final int r112, Options r113) throws IOException {
        final DecodeFormat r100 = (DecodeFormat) r113.get(Downsampler.DECODE_FORMAT);
        final DownsampleStrategy r101 = (DownsampleStrategy) r113.get(DownsampleStrategy.OPTION);
        Option<Boolean> r102 = Downsampler.ALLOW_HARDWARE_CONFIG;
        if (r113.get(r102) != null) goto L5;
    L7:
        final boolean r103 = false;
    L8:
        final PreferredColorSpace r104 = (PreferredColorSpace) r113.get(Downsampler.PREFERRED_COLOR_SPACE);
        return decode(r110, r111, r112, new AnonymousClass1(this, r111, r112, r103, r100, r101, r104));
    L5:
        if (((Boolean) r113.get(r102)).booleanValue() == false) goto L7;
        r103 = true;
        goto L8
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource decode(ImageDecoder.Source r100, int r101, int r102, Options r103) throws IOException {
        return decode2(r100, r101, r102, r103);
    }
}
