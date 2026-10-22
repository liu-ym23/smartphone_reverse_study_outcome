package com.bytedance.android.livesdk.utils;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.Postprocessor;

/* JADX INFO: loaded from: classes11.dex */
public final class l3 implements Postprocessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f159048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f159049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f159050c;

    public interface a {
        void processorFinish(Object r100);
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final String getName() {
        return "blurProcessor";
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final CacheKey getPostprocessorCacheKey() {
        return new SimpleCacheKey("blur_bitmap_processor");
    }

    public l3(int r100) {
        this.f159048a = r100;
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101) {
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
        if (this.f159049b == 0.0f) goto L22;
        float r108 = r105;
        float r109 = r106;
        if (Math.abs((r108 / r109) - this.f159048a) <= 0.2f) goto L22;
        float r110 = this.f159049b;
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
        e0.a(r107, r116, this.f159048a);
        r107.recycle();
        a r117 = this.f159050c;
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

    public l3(int r100, float r101, a r102) {
        this.f159049b = r101;
        this.f159048a = r100;
        this.f159050c = r102;
    }
}
