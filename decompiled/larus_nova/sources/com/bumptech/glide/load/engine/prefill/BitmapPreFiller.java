package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.util.Util;
import java.util.HashMap;

/* JADX INFO: loaded from: classes39.dex */
public final class BitmapPreFiller {
    private final BitmapPool bitmapPool;
    private BitmapPreFillRunner current;
    private final DecodeFormat defaultFormat;
    private final Handler handler;
    private final MemoryCache memoryCache;

    private static int getSizeInBytes(PreFillType r100) {
        return Util.getBitmapByteSize(r100.getWidth(), r100.getHeight(), r100.getConfig());
    }

    public PreFillQueue generateAllocationOrder(PreFillType... r100) {
        long r101 = (this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize()) + this.bitmapPool.getMaxSize();
        int r102 = r100.length;
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r105 = r105 + r100[r104].getWeight();
        r104 = r104 + 1;
        goto L3
    L5:
        float r106 = r101 / r105;
        HashMap r107 = new HashMap();
        int r108 = r100.length;
    L6:
        if (r103 >= r108) goto L9;
        PreFillType r109 = r100[r103];
        r107.put(r109, Integer.valueOf(Math.round(r109.getWeight() * r106) / getSizeInBytes(r109)));
        r103 = r103 + 1;
        goto L6
    L9:
        return new PreFillQueue(r107);
    }

    public void preFill(PreFillType.Builder... r100) {
        BitmapPreFillRunner r101 = this.current;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        PreFillType[] r102 = new PreFillType[r100.length];
        int r103 = 0;
    L7:
        if (r103 >= r100.length) goto L16;
        PreFillType.Builder r104 = r100[r103];
        if (r104.getConfig() != null) goto L15;
        if (this.defaultFormat != DecodeFormat.PREFER_ARGB_8888) goto L13;
        Bitmap.Config r105 = Bitmap.Config.ARGB_8888;
    L14:
        r104.setConfig(r105);
        goto L15
    L13:
        r105 = Bitmap.Config.RGB_565;
    L15:
        r102[r103] = r104.build();
        r103 = r103 + 1;
        goto L7
    L16:
        PreFillQueue r106 = generateAllocationOrder(r102);
        BitmapPreFillRunner r107 = new BitmapPreFillRunner(this.bitmapPool, this.memoryCache, r106);
        this.current = r107;
        this.handler.post(r107);
    }

    public BitmapPreFiller(MemoryCache r100, BitmapPool r101, DecodeFormat r102) {
        this.handler = new Handler(Looper.getMainLooper());
        this.memoryCache = r100;
        this.bitmapPool = r101;
        this.defaultFormat = r102;
    }
}
