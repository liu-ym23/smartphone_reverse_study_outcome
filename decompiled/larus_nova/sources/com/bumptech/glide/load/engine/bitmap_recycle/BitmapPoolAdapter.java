package com.bumptech.glide.load.engine.bitmap_recycle;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.larksuite.framework.utils.autoscale.a;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes39.dex */
public class BitmapPoolAdapter implements BitmapPool {
    public BitmapPoolAdapter() {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public long getMaxSize() {
        return 0;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void setSizeMultiplier(float r100) {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void trimMemory(int r100) {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void trimToRetainRatio(float r100) {
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bumptech_glide_load_engine_bitmap_recycle_BitmapPoolAdapter_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void put(Bitmap r100) {
        r100.recycle();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap get(int r100, int r101, Bitmap.Config r102) {
        int r103 = a.f285947a;
        return Bitmap.createBitmap(r100, r101, r102);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap getDirty(int r100, int r101, Bitmap.Config r102) {
        return get(r100, r101, r102);
    }
}
