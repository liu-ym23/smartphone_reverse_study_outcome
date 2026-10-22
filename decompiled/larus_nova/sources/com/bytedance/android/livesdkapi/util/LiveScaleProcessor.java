package com.bytedance.android.livesdkapi.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.Postprocessor;

/* JADX INFO: loaded from: classes12.dex */
public class LiveScaleProcessor implements Postprocessor {
    private static final int HUNDRED = 100;
    private static final float SIX_SCALE = 0.6f;
    private static final float SMALL_SCALE = 0.1f;
    private static final float THIRD_SCALE = 0.3f;
    private static final int TWO_HUNDRED = 200;

    public LiveScaleProcessor() {
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public String getName() {
        return "scale_processor";
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public CacheKey getPostprocessorCacheKey() {
        return new SimpleCacheKey("scale_bitmap_processor");
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101) {
        int r102 = r100.getWidth();
        int r103 = r100.getHeight();
        if (r102 < 100) goto L12;
        if (r103 < 100) goto L12;
        if (r102 < 200) goto L11;
        if (r103 < 200) goto L11;
        float r104 = 0.1f;
    L13:
        int r105 = Math.round(r102 * r104);
        int r106 = Math.round(r103 * r104);
        Bitmap r107 = Bitmap.createScaledBitmap(r100, r105, r106, false);
        CloseableReference<Bitmap> r108 = r101.createBitmap(r105, r106);
        new Canvas(r108.get()).drawBitmap(r107, 0.0f, 0.0f, null);
        r107.recycle();
        return r108;
    L11:
        r104 = 0.3f;
    L12:
        r104 = 0.6f;
        goto L13
    }
}
