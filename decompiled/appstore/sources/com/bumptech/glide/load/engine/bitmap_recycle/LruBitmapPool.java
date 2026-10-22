package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
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
        void add(Bitmap r10);

        void remove(Bitmap r10);
    }

    public static final class NullBitmapTracker implements BitmapTracker {
        public NullBitmapTracker() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap r10) {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap r10) {
        }
    }

    public static class ThrowingBitmapTracker implements BitmapTracker {
        private final Set<Bitmap> bitmaps;

        private ThrowingBitmapTracker() {
            this.bitmaps = Collections.synchronizedSet(new HashSet());
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap r10) {
            if (this.bitmaps.contains(r10) == true) goto L7;
            this.bitmaps.add(r10);
            return;
        L7:
            throw new IllegalStateException("Can't add already added bitmap: " + r10 + " [" + r10.getWidth() + FixCard.FixStyle.KEY_X + r10.getHeight() + "]");
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap r10) {
            if (this.bitmaps.contains(r10) == false) goto L7;
            this.bitmaps.remove(r10);
            return;
        L7:
            throw new IllegalStateException("Cannot remove bitmap not in tracker");
        }
    }

    static {
        DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    }

    public LruBitmapPool(long r10, LruPoolStrategy r11, Set<Bitmap.Config> r12) {
        this.initialMaxSize = r10;
        this.maxSize = r10;
        this.strategy = r11;
        this.allowedConfigs = r12;
        this.tracker = new NullBitmapTracker();
    }

    @TargetApi(26)
    private static void assertNotHardwareConfig(Bitmap.Config r10) {
        if (r10 == Bitmap.Config.HARDWARE) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + r10 + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
    }

    @NonNull
    private static Bitmap createBitmap(int r10, int r11, @Nullable Bitmap.Config r12) {
        if (r12 != null) goto L6;
        r12 = DEFAULT_CONFIG;
    L6:
        return Bitmap.createBitmap(r10, r11, r12);
    }

    private void dump() {
        if (Log.isLoggable(TAG, 2) == false) goto L6;
        dumpUnchecked();
        return;
    }

    private void dumpUnchecked() {
        Log.v(TAG, "Hits=" + this.hits + ", misses=" + this.misses + ", puts=" + this.puts + ", evictions=" + this.evictions + ", currentSize=" + this.currentSize + ", maxSize=" + this.maxSize + "\nStrategy=" + this.strategy);
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> getDefaultAllowedConfigs() {
        HashSet r10 = new HashSet(Arrays.asList(Bitmap.Config.values()));
        r10.add(null);
        r10.remove(Bitmap.Config.HARDWARE);
        return Collections.unmodifiableSet(r10);
    }

    private static LruPoolStrategy getDefaultStrategy() {
        return new SizeConfigStrategy();
    }

    @Nullable
    private synchronized Bitmap getDirtyOrNull(int r10, int r11, @Nullable Bitmap.Config r12) {
        monitor-enter(this);
        assertNotHardwareConfig(r12);     // Catch: Throwable -> L12
        LruPoolStrategy r13 = this.strategy;     // Catch: Throwable -> L12
        if (r12 == null) goto L6;
        Bitmap.Config r14 = r12;
    L7:
        Bitmap r15 = r13.get(r10, r11, r14);     // Catch: Throwable -> L12
        if (r15 == null) goto L10;
        this.hits++;     // Catch: Throwable -> L12
        this.currentSize -= (long) this.strategy.getSize(r15);     // Catch: Throwable -> L12
        this.tracker.remove(r15);     // Catch: Throwable -> L12
        normalize(r15);     // Catch: Throwable -> L12
    L17:
        if (Log.isLoggable(TAG, 2) == false) goto L19;
        Log.v(TAG, "Get bitmap=" + this.strategy.logBitmap(r10, r11, r12));     // Catch: Throwable -> L12
    L19:
        dump();     // Catch: Throwable -> L12
        monitor-exit(this);
        return r15;
    L10:
        if (Log.isLoggable(TAG, 3) == false) goto L14;
        Log.d(TAG, "Missing bitmap=" + this.strategy.logBitmap(r10, r11, r12));     // Catch: Throwable -> L12
    L14:
        this.misses++;     // Catch: Throwable -> L12
        goto L17
    L6:
        r14 = DEFAULT_CONFIG;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @TargetApi(19)
    private static void maybeSetPreMultiplied(Bitmap r10) {
        r10.setPremultiplied(true);
    }

    private static void normalize(Bitmap r10) {
        r10.setHasAlpha(true);
        maybeSetPreMultiplied(r10);
    }

    private synchronized void trimToSize(long r10) {
        monitor-enter(this);
    L24:
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.currentSize <= r10) goto L20;
        Bitmap r11 = this.strategy.removeLast();     // Catch: Throwable -> L10
        if (r11 == null) goto L8;
        this.tracker.remove(r11);     // Catch: Throwable -> L10
        this.currentSize -= (long) this.strategy.getSize(r11);     // Catch: Throwable -> L10
        this.evictions++;     // Catch: Throwable -> L10
        if (Log.isLoggable(TAG, 3) == false) goto L18;
        Log.d(TAG, "Evicting bitmap=" + this.strategy.logBitmap(r11));     // Catch: Throwable -> L10
    L18:
        dump();     // Catch: Throwable -> L10
        r11.recycle();     // Catch: Throwable -> L10
        goto L24
    L8:
        if (Log.isLoggable(TAG, 5) == false) goto L12;
        Log.w(TAG, "Size mismatch, resetting");     // Catch: Throwable -> L10
        dumpUnchecked();     // Catch: Throwable -> L10
    L12:
        this.currentSize = 0;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L20:
        monitor-exit(this);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
        if (Log.isLoggable(TAG, 3) == false) goto L5;
        Log.d(TAG, "clearMemory");
    L5:
        trimToSize(0);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    public Bitmap get(int r10, int r11, Bitmap.Config r12) {
        Bitmap r13 = getDirtyOrNull(r10, r11, r12);
        if (r13 == null) goto L6;
        r13.eraseColor(0);
        return r13;
    L6:
        return createBitmap(r10, r11, r12);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    public Bitmap getDirty(int r10, int r11, Bitmap.Config r12) {
        Bitmap r13 = getDirtyOrNull(r10, r11, r12);
        if (r13 == null) goto L5;
        return r13;
    L5:
        return createBitmap(r10, r11, r12);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public long getMaxSize() {
        return this.maxSize;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void put(Bitmap r10) {
        monitor-enter(this);
        if (r10 == null) goto L30;
        if (r10.isRecycled() == true) goto L28;
        if (r10.isMutable() == false) goto L22;
        if (this.strategy.getSize(r10) > this.maxSize) goto L22;
        if (this.allowedConfigs.contains(r10.getConfig()) == false) goto L22;
        int r11 = this.strategy.getSize(r10);     // Catch: Throwable -> L16
        this.strategy.put(r10);     // Catch: Throwable -> L16
        this.tracker.add(r10);     // Catch: Throwable -> L16
        this.puts++;     // Catch: Throwable -> L16
        this.currentSize += (long) r11;     // Catch: Throwable -> L16
        if (Log.isLoggable(TAG, 2) == false) goto L18;
        Log.v(TAG, "Put bitmap in pool=" + this.strategy.logBitmap(r10));     // Catch: Throwable -> L16
    L18:
        dump();     // Catch: Throwable -> L16
        evict();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L22:
        if (Log.isLoggable(TAG, 2) == false) goto L24;
        Log.v(TAG, "Reject bitmap from pool, bitmap: " + this.strategy.logBitmap(r10) + ", is mutable: " + r10.isMutable() + ", is allowed config: " + this.allowedConfigs.contains(r10.getConfig()));     // Catch: Throwable -> L16
    L24:
        r10.recycle();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L28:
        throw new IllegalStateException("Cannot pool recycled bitmap");     // Catch: Throwable -> L16
    L30:
        throw new NullPointerException("Bitmap must not be null");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void setSizeMultiplier(float r10) {
        monitor-enter(this);
        this.maxSize = Math.round(this.initialMaxSize * r10);     // Catch: Throwable -> L6
        evict();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int r10) {
        if (Log.isLoggable(TAG, 3) == false) goto L6;
        Log.d(TAG, "trimMemory, level=" + r10);
    L6:
        if (r10 < 40) goto L9;
        clearMemory();
        return;
    L9:
        if (r10 < 20) goto L11;
    L12:
        trimToSize(getMaxSize() / 2);
        return;
    L11:
        if (r10 == 15) goto L12;
    }

    public LruBitmapPool(long r10) {
        this(r10, getDefaultStrategy(), getDefaultAllowedConfigs());
    }

    public LruBitmapPool(long r10, Set<Bitmap.Config> r11) {
        this(r10, getDefaultStrategy(), r11);
    }
}
