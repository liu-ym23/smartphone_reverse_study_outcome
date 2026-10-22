package com.bytedance.android.livesdkapi.util;

import android.graphics.Bitmap;
import com.bytedance.android.livesdk.utils.e0;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.Postprocessor;

/* JADX INFO: loaded from: classes12.dex */
public final class LiveBlurProcessorV2 implements Postprocessor {
    private static final int HUNDRED = 100;
    private static final float SECOND_SCALE = 0.2f;
    private static final float SIX_SCALE = 0.6f;
    private static final float SMALL_SCALE = 0.1f;
    private static final float THIRD_SCALE = 0.3f;
    private static final int TWO_HUNDRED = 200;
    private float mEqualScale;
    private ProcessorListener mListener;
    private int mRadius;

    public interface ProcessorListener {
        void processorFinish(Object r100);
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public String getName() {
        return "blurProcessor";
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public CacheKey getPostprocessorCacheKey() {
        return new SimpleCacheKey("blur_bitmap_processor");
    }

    public LiveBlurProcessorV2(int r100) {
        this.mRadius = r100;
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
        if (this.mEqualScale == 0.0f) goto L22;
        float r108 = r105;
        float r109 = r106;
        if (Math.abs((r108 / r109) - this.mRadius) <= 0.2f) goto L22;
        float r110 = this.mEqualScale;
        int r111 = (int) (r108 / r110);
        if (r111 <= r106) goto L20;
        int r112 = (int) (r109 * r110);
        int r113 = r106;
    L21:
        Bitmap r114 = Bitmap.createBitmap(r107, (r105 - r112) >> 1, (r106 - r113) >> 1, r112, r113);
        r107.recycle();
        r107 = r114;
        r105 = r112;
        r106 = r113;
        goto L22
    L20:
        r113 = r111;
        r112 = r105;
    L22:
        CloseableReference<Bitmap> r115 = r101.createBitmap(r105, r106);
        Bitmap r116 = r115.get();
        e0.a(r107, r116, this.mRadius);
        r107.recycle();
        ProcessorListener r117 = this.mListener;
        if (r117 == null) goto L25;
        r117.processorFinish(r116);
    L25:
        return r115;
    L11:
        r104 = 0.3f;
    L12:
        r104 = 0.6f;
        goto L13
    }

    public LiveBlurProcessorV2(int r100, float r101, ProcessorListener r102) {
        this.mEqualScale = r101;
        this.mRadius = r100;
        this.mListener = r102;
    }
}
