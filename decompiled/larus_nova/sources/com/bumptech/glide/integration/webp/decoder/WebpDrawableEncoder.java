package com.bumptech.glide.integration.webp.decoder;

import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.CacheSink;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes39.dex */
public class WebpDrawableEncoder implements ResourceEncoder<WebpDrawable> {
    private static final String TAG = "WebpDrawableEncoder";

    public WebpDrawableEncoder() {
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public EncodeStrategy getEncodeStrategy(Options r100) {
        Log.i(TAG, "original data");
        return EncodeStrategy.SOURCE;
    }

    public boolean encode(Resource<WebpDrawable> r100, CacheSink r101, Options r102) {
        Log.i(TAG, "no encode");
        return false;
    }

    @Override // com.bumptech.glide.load.Encoder
    public /* bridge */ /* synthetic */ boolean encode(Object r100, CacheSink r101, Options r102) {
        return encode((Resource) r100, r101, r102);
    }
}
