package com.bumptech.glide.load.engine.bitmap_recycle;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.DisplayMetrics;
import com.bumptech.glide.util.GlideLogUtil;
import com.larksuite.framework.utils.autoscale.a;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes39.dex */
public class LruBitmapPool implements BitmapPool {
    private static final Bitmap.Config DEFAULT_CONFIG = null;
    private static final String TAG = "LruBitmapPool";
    private final Set<Bitmap.Config> allowedConfigs;
    private long currentSize;
    private int evictions;
    private int hits;
    private final long initialMaxSize;
    private long maxSize;
    private int misses;
    private int puts;
    private final LruPoolStrategy strategy;
    private final BitmapTracker tracker;

    public interface BitmapTracker {
        void add(Bitmap r100);

        void remove(Bitmap r100);
    }

    public static final class NullBitmapTracker implements BitmapTracker {
        public NullBitmapTracker() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap r100) {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap r100) {
        }
    }

    public static class ThrowingBitmapTracker implements BitmapTracker {
        private final Set<Bitmap> bitmaps;

        private ThrowingBitmapTracker() {
            this.bitmaps = Collections.synchronizedSet(new HashSet());
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap r100) {
            if (this.bitmaps.contains(r100) == true) goto L7;
            this.bitmaps.add(r100);
            return;
        L7:
            throw new IllegalStateException("Can't add already added bitmap: " + r100 + " [" + r100.getWidth() + "x" + r100.getHeight() + "]");
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap r100) {
            if (this.bitmaps.contains(r100) == false) goto L7;
            this.bitmaps.remove(r100);
            return;
        L7:
            throw new IllegalStateException("Cannot remove bitmap not in tracker");
        }
    }

    static {
        DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    }

    private void dumpUnchecked() {
        GlideLogUtil.v(TAG, "Hits=" + this.hits + ", misses=" + this.misses + ", puts=" + this.puts + ", evictions=" + this.evictions + ", currentSize=" + this.currentSize + ", maxSize=" + this.maxSize + "\nStrategy=" + this.strategy);
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    private static Set<Bitmap.Config> getDefaultAllowedConfigs() {
        HashSet r100 = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int r101 = Build.VERSION.SDK_INT;
        r100.add(null);
        if (r101 < 26) goto L6;
        r100.remove(Bitmap.Config.HARDWARE);
    L6:
        return Collections.unmodifiableSet(r100);
    }

    private static LruPoolStrategy getDefaultStrategy() {
        return new SizeConfigStrategy();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
        GlideLogUtil.d(TAG, "clearMemory");
        trimToSize(0);
    }

    public long evictionCount() {
        return this.evictions;
    }

    public long hitCount() {
        return this.hits;
    }

    public long missCount() {
        return this.misses;
    }

    private void dump() {
        dumpUnchecked();
    }

    public long getCurrentSize() {
        return this.currentSize;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public long getMaxSize() {
        return this.maxSize;
    }

    public LruBitmapPool(long r100) {
        this(r100, getDefaultStrategy(), getDefaultAllowedConfigs());
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bumptech_glide_load_engine_bitmap_recycle_LruBitmapPool_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private static void assertNotHardwareConfig(Bitmap.Config r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        return;
    L6:
        if (r100 == Bitmap.Config.HARDWARE) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + r100 + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
    }

    private static void maybeSetPreMultiplied(Bitmap r100) {
        r100.setPremultiplied(true);
    }

    private static void normalize(Bitmap r100) {
        r100.setHasAlpha(true);
        maybeSetPreMultiplied(r100);
    }

    private synchronized void trimToSize(long r100) {
        monitor-enter(this);
    L17:
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.currentSize <= r100) goto L12;
        Bitmap r101 = this.strategy.removeLast();     // Catch: Throwable -> L14
        if (r101 == null) goto L7;
        this.tracker.remove(r101);     // Catch: Throwable -> L14
        this.currentSize -= (long) this.strategy.getSize(r101);     // Catch: Throwable -> L14
        this.evictions++;     // Catch: Throwable -> L14
        GlideLogUtil.d(TAG, "Evicting bitmap=" + this.strategy.logBitmap(r101));     // Catch: Throwable -> L14
        dump();     // Catch: Throwable -> L14
        r101.recycle();     // Catch: Throwable -> L14
        goto L17
    L7:
        GlideLogUtil.w(TAG, "Size mismatch, resetting");     // Catch: Throwable -> L14
        dumpUnchecked();     // Catch: Throwable -> L14
        this.currentSize = 0;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L12:
        monitor-exit(this);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void put(Bitmap r100) {
        monitor-enter(this);
        if (r100 == null) goto L25;
        if (r100.isRecycled() == true) goto L21;
        if (r100.isMutable() == true) goto L10;
    L17:
        GlideLogUtil.i(TAG, "Reject bitmap from pool, bitmap: " + this.strategy.logBitmap(r100) + ", is mutable: " + r100.isMutable() + ", is allowed config: " + this.allowedConfigs.contains(r100.getConfig()));     // Catch: Throwable -> L22
        r100.recycle();     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L10:
        if (this.strategy.getSize(r100) > this.maxSize) goto L17;
        if (this.allowedConfigs.contains(r100.getConfig()) == false) goto L17;
        int r101 = this.strategy.getSize(r100);     // Catch: Throwable -> L22
        this.strategy.put(r100);     // Catch: Throwable -> L22
        this.tracker.add(r100);     // Catch: Throwable -> L22
        this.puts++;     // Catch: Throwable -> L22
        this.currentSize += (long) r101;     // Catch: Throwable -> L22
        GlideLogUtil.v(TAG, "Put bitmap in pool=" + this.strategy.logBitmap(r100));     // Catch: Throwable -> L22
        dump();     // Catch: Throwable -> L22
        evict();     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L21:
        throw new IllegalStateException("Cannot pool recycled bitmap");     // Catch: Throwable -> L22
    L25:
        throw new NullPointerException("Bitmap must not be null");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void setSizeMultiplier(float r100) {
        monitor-enter(this);
        this.maxSize = Math.round(this.initialMaxSize * r100);     // Catch: Throwable -> L6
        evict();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void trimMemory(int r100) {
        GlideLogUtil.d(TAG, "trimMemory, level=" + r100);
        if (r100 < 40) goto L5;
    L12:
        clearMemory();
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L8;
        if (r100 >= 20) goto L12;
    L8:
        if (r100 < 20) goto L10;
    L11:
        trimToSize(getMaxSize() / 2);
        return;
    L10:
        if (r100 == 15) goto L11;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void trimToRetainRatio(float r100) {
        trimToSize((long) Math.floor(getMaxSize() * r100));
    }

    public LruBitmapPool(long r100, Set<Bitmap.Config> r101) {
        this(r100, getDefaultStrategy(), r101);
    }

    public LruBitmapPool(long r100, LruPoolStrategy r101, Set<Bitmap.Config> r102) {
        this.initialMaxSize = r100;
        this.maxSize = r100;
        this.strategy = r101;
        this.allowedConfigs = r102;
        this.tracker = new NullBitmapTracker();
    }

    private static Bitmap createBitmap(int r100, int r101, Bitmap.Config r102) {
        int r103 = a.f285947a;
        if (r102 != null) goto L7;
        r102 = DEFAULT_CONFIG;
    L7:
        return Bitmap.createBitmap(r100, r101, r102);
    }

    private synchronized Bitmap getDirtyOrNull(int r100, int r101, Bitmap.Config r110) {
        monitor-enter(this);
        assertNotHardwareConfig(r110);     // Catch: Throwable -> L15
        LruPoolStrategy r102 = this.strategy;     // Catch: Throwable -> L15
        if (r110 == null) goto L7;
        Bitmap.Config r103 = r110;
    L8:
        Bitmap r104 = r102.get(r100, r101, r103);     // Catch: Throwable -> L15
        if (r104 != null) goto L11;
        GlideLogUtil.d(TAG, "Missing bitmap=" + this.strategy.logBitmap(r100, r101, r110));     // Catch: Throwable -> L15
        this.misses = this.misses + 1;     // Catch: Throwable -> L15
    L12:
        GlideLogUtil.v(TAG, "Get bitmap=" + this.strategy.logBitmap(r100, r101, r110));     // Catch: Throwable -> L15
        dump();     // Catch: Throwable -> L15
        monitor-exit(this);
        return r104;
    L11:
        this.hits++;     // Catch: Throwable -> L15
        this.currentSize -= (long) this.strategy.getSize(r104);     // Catch: Throwable -> L15
        this.tracker.remove(r104);     // Catch: Throwable -> L15
        normalize(r104);     // Catch: Throwable -> L15
        goto L12
    L7:
        r103 = DEFAULT_CONFIG;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap get(int r100, int r101, Bitmap.Config r102) {
        Bitmap r103 = getDirtyOrNull(r100, r101, r102);
        if (r103 == null) goto L6;
        r103.eraseColor(0);
        return r103;
    L6:
        return createBitmap(r100, r101, r102);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap getDirty(int r100, int r101, Bitmap.Config r102) {
        Bitmap r103 = getDirtyOrNull(r100, r101, r102);
        if (r103 == null) goto L5;
        return r103;
    L5:
        return createBitmap(r100, r101, r102);
    }
}
