package com.bytedance.android.live.core.utils.fresco;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends BasePostprocessor {
    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public final String getName() {
        return "com.bytedance.android.live.core.utils.fresco.FrescoDrawProcessor";
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public final CacheKey getPostprocessorCacheKey() {
        return new SimpleCacheKey("fresco_drawable_draw_processor");
    }

    public b() {
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public final CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        r100.prepareToDraw();
        return super.process(r100, r101);
    }
}
