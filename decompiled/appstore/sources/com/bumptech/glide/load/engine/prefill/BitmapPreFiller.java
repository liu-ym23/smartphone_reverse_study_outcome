package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.util.Util;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapPreFiller {
    private final BitmapPool bitmapPool;
    private BitmapPreFillRunner current;
    private final DecodeFormat defaultFormat;
    private final Handler handler;
    private final MemoryCache memoryCache;

    public BitmapPreFiller(MemoryCache r10, BitmapPool r11, DecodeFormat r12) {
        this.handler = new Handler(Looper.getMainLooper());
        this.memoryCache = r10;
        this.bitmapPool = r11;
        this.defaultFormat = r12;
    }

    private static int getSizeInBytes(PreFillType r10) {
        return Util.getBitmapByteSize(r10.getWidth(), r10.getHeight(), r10.getConfig());
    }

    @VisibleForTesting
    public PreFillQueue generateAllocationOrder(PreFillType... r10) {
        long r11 = (this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize()) + this.bitmapPool.getMaxSize();
        int r12 = r10.length;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r15 = r15 + r10[r14].getWeight();
        r14 = r14 + 1;
        goto L3
    L5:
        float r16 = r11 / r15;
        HashMap r17 = new HashMap();
        int r18 = r10.length;
    L6:
        if (r13 >= r18) goto L9;
        PreFillType r19 = r10[r13];
        r17.put(r19, Integer.valueOf(Math.round(r19.getWeight() * r16) / getSizeInBytes(r19)));
        r13 = r13 + 1;
        goto L6
    L9:
        return new PreFillQueue(r17);
    }

    public void preFill(PreFillType.Builder... r10) {
        BitmapPreFillRunner r11 = this.current;
        if (r11 == null) goto L5;
        r11.cancel();
    L5:
        PreFillType[] r12 = new PreFillType[r10.length];
        int r13 = 0;
    L7:
        if (r13 >= r10.length) goto L16;
        PreFillType.Builder r14 = r10[r13];
        if (r14.getConfig() != null) goto L15;
        if (this.defaultFormat != DecodeFormat.PREFER_ARGB_8888) goto L13;
        Bitmap.Config r15 = Bitmap.Config.ARGB_8888;
    L14:
        r14.setConfig(r15);
        goto L15
    L13:
        r15 = Bitmap.Config.RGB_565;
    L15:
        r12[r13] = r14.build();
        r13 = r13 + 1;
        goto L7
    L16:
        PreFillQueue r16 = generateAllocationOrder(r12);
        BitmapPreFillRunner r17 = new BitmapPreFillRunner(this.bitmapPool, this.memoryCache, r16);
        this.current = r17;
        this.handler.post(r17);
    }
}
