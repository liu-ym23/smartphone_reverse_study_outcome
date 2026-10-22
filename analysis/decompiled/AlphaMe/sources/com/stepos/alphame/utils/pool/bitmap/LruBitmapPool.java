package com.stepos.alphame.utils.pool.bitmap;

import B0.g;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.util.Log;
import com.stepos.alphame.BuildConfig;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class LruBitmapPool implements BitmapPool {
    private static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int PLACE_HOLDER = 0;
    private static final String TAG = "LruBitmapPool";
    private final Set<Bitmap.Config> allowedConfigs;
    private int currentSize;
    private int evictions;
    private int hits;
    private final int initialMaxSize;
    private ArrayList<Bitmap> mRemoveList;
    private int maxSize;
    private int misses;
    private int puts;
    private final LruPoolStrategy strategy;
    private final BitmapTracker tracker;

    public interface BitmapTracker {
        void add(Bitmap bitmap);

        void remove(Bitmap bitmap);
    }

    public static class NullBitmapTracker implements BitmapTracker {
        private NullBitmapTracker() {
        }

        public /* synthetic */ NullBitmapTracker(int i4) {
            this();
        }

        @Override // com.stepos.alphame.utils.pool.bitmap.LruBitmapPool.BitmapTracker
        public void add(Bitmap bitmap) {
        }

        @Override // com.stepos.alphame.utils.pool.bitmap.LruBitmapPool.BitmapTracker
        public void remove(Bitmap bitmap) {
        }
    }

    public static class ThrowingBitmapTracker implements BitmapTracker {
        private final Set<Bitmap> bitmaps = Collections.synchronizedSet(new HashSet());

        private ThrowingBitmapTracker() {
        }

        @Override // com.stepos.alphame.utils.pool.bitmap.LruBitmapPool.BitmapTracker
        public void add(Bitmap bitmap) {
            if (!this.bitmaps.contains(bitmap)) {
                this.bitmaps.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }

        @Override // com.stepos.alphame.utils.pool.bitmap.LruBitmapPool.BitmapTracker
        public void remove(Bitmap bitmap) {
            if (!this.bitmaps.contains(bitmap)) {
                throw new IllegalStateException("Cannot remove bitmap not in tracker");
            }
            this.bitmaps.remove(bitmap);
        }
    }

    private LruBitmapPool(int i4, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        this.mRemoveList = new ArrayList<>();
        this.initialMaxSize = i4;
        this.maxSize = i4;
        this.strategy = lruPoolStrategy;
        this.allowedConfigs = set;
        this.tracker = new NullBitmapTracker(0);
    }

    private void dump() {
        if (BuildConfig.DEBUG && Log.isLoggable(TAG, 2)) {
            dumpUnchecked();
        }
    }

    private void dumpUnchecked() {
        Log.v(TAG, "Hits=" + this.hits + ", misses=" + this.misses + ", puts=" + this.puts + ", evictions=" + this.evictions + ", currentSize=" + this.currentSize + ", maxSize=" + this.maxSize + "\nStrategy=" + this.strategy);
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    private static Set<Bitmap.Config> getDefaultAllowedConfigs() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        return Collections.unmodifiableSet(hashSet);
    }

    private static LruPoolStrategy getDefaultStrategy() {
        return new SizeConfigStrategy();
    }

    private synchronized Bitmap getDirtyOrNull(int i4, int i5, Bitmap.Config config) {
        Bitmap bitmap;
        try {
            bitmap = this.strategy.get(i4, i5, config != null ? config : DEFAULT_CONFIG);
            if (bitmap == null) {
                if (BuildConfig.DEBUG && Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Missing bitmap=" + this.strategy.logBitmap(i4, i5, config));
                }
                this.misses++;
            } else {
                this.hits++;
                this.currentSize -= this.strategy.getSize(bitmap);
                this.tracker.remove(bitmap);
                normalize(bitmap);
            }
            if (BuildConfig.DEBUG && Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Get bitmap=" + this.strategy.logBitmap(i4, i5, config) + AwarenessDataItem.PERMISSION_SPLITTER + bitmap + "\n" + Log.getStackTraceString(new Exception()));
            }
            dump();
        } catch (Throwable th) {
            throw th;
        }
        return bitmap;
    }

    private static void maybeSetAlpha(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
    }

    private static void maybeSetPreMultiplied(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    private static void normalize(Bitmap bitmap) {
        maybeSetAlpha(bitmap);
        maybeSetPreMultiplied(bitmap);
    }

    private synchronized void trimToSize(int i4) {
        while (this.currentSize > i4) {
            try {
                Bitmap bitmapRemoveLast = this.strategy.removeLast();
                if (bitmapRemoveLast == null) {
                    if (Log.isLoggable(TAG, 5)) {
                        Log.w(TAG, "Size mismatch, resetting");
                        dumpUnchecked();
                    }
                    this.currentSize = 0;
                    return;
                }
                this.tracker.remove(bitmapRemoveLast);
                this.currentSize -= this.strategy.getSize(bitmapRemoveLast);
                this.evictions++;
                if (BuildConfig.DEBUG && Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Evicting bitmap=" + this.strategy.logBitmap(bitmapRemoveLast) + bitmapRemoveLast);
                }
                dump();
                if (this.mRemoveList.contains(bitmapRemoveLast)) {
                    Log.w(TAG, "trimToSize:bitmap has been repeated:" + bitmapRemoveLast);
                } else {
                    this.mRemoveList.add(bitmapRemoveLast);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator<Bitmap> it = this.mRemoveList.iterator();
        while (it.hasNext()) {
            it.next().recycle();
        }
        this.mRemoveList.clear();
    }

    @Override // com.stepos.alphame.utils.pool.bitmap.BitmapPool
    public void clearMemory() {
        if (BuildConfig.DEBUG && Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "clearMemory");
        }
        trimToSize(0);
    }

    @Override // com.stepos.alphame.utils.pool.bitmap.BitmapPool
    public Bitmap get(int i4, int i5, Bitmap.Config config) {
        Bitmap dirtyOrNull = getDirtyOrNull(i4, i5, config);
        if (dirtyOrNull != null) {
            dirtyOrNull.eraseColor(0);
            return dirtyOrNull;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i4, i5, config);
        bitmapCreateBitmap.eraseColor(0);
        return bitmapCreateBitmap;
    }

    @Override // com.stepos.alphame.utils.pool.bitmap.BitmapPool
    public Bitmap getDirty(int i4, int i5, Bitmap.Config config) {
        Bitmap dirtyOrNull = getDirtyOrNull(i4, i5, config);
        return dirtyOrNull == null ? Bitmap.createBitmap(i4, i5, config) : dirtyOrNull;
    }

    @Override // com.stepos.alphame.utils.pool.bitmap.BitmapPool
    public int getMaxSize() {
        return this.maxSize;
    }

    @Override // com.stepos.alphame.utils.pool.bitmap.BitmapPool
    public synchronized void put(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new IllegalStateException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.strategy.getSize(bitmap) <= this.maxSize && this.allowedConfigs.contains(bitmap.getConfig())) {
                int size = this.strategy.getSize(bitmap);
                this.strategy.put(bitmap);
                this.tracker.add(bitmap);
                this.puts++;
                this.currentSize += size;
                if (BuildConfig.DEBUG && Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Put bitmap in pool=" + this.strategy.logBitmap(bitmap) + AwarenessDataItem.PERMISSION_SPLITTER + bitmap + "\n" + Log.getStackTraceString(new Exception()));
                }
                dump();
                evict();
                return;
            }
            if (BuildConfig.DEBUG && Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Reject bitmap from pool, bitmap: " + this.strategy.logBitmap(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.allowedConfigs.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.stepos.alphame.utils.pool.bitmap.BitmapPool
    public synchronized void setSizeMultiplier(float f4) {
        this.maxSize = Math.round(this.initialMaxSize * f4);
        evict();
    }

    @Override // com.stepos.alphame.utils.pool.bitmap.BitmapPool
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i4) {
        if (BuildConfig.DEBUG && Log.isLoggable(TAG, 3)) {
            g.z("trimMemory, level=", i4, TAG);
        }
        if (i4 >= 40) {
            clearMemory();
        } else if (i4 >= 20) {
            trimToSize(0);
        }
    }

    public LruBitmapPool(int i4) {
        this(i4, getDefaultStrategy(), getDefaultAllowedConfigs());
    }

    public LruBitmapPool(int i4, Set<Bitmap.Config> set) {
        this(i4, getDefaultStrategy(), set);
    }
}
