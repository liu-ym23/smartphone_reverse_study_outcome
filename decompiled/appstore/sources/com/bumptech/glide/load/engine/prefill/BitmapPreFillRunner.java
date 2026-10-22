package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class BitmapPreFillRunner implements Runnable {
    static final int BACKOFF_RATIO = 4;
    private static final Clock DEFAULT_CLOCK = null;
    static final long INITIAL_BACKOFF_MS = 40;
    static final long MAX_BACKOFF_MS = 0;
    static final long MAX_DURATION_MS = 32;

    @VisibleForTesting
    static final String TAG = "PreFillRunner";
    private final BitmapPool bitmapPool;
    private final Clock clock;
    private long currentDelay;
    private final Handler handler;
    private boolean isCancelled;
    private final MemoryCache memoryCache;
    private final Set<PreFillType> seenTypes;
    private final PreFillQueue toPrefill;

    @VisibleForTesting
    public static class Clock {
        public Clock() {
        }

        public long now() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    public static final class UniqueKey implements Key {
        public UniqueKey() {
        }

        @Override // com.bumptech.glide.load.Key
        public void updateDiskCacheKey(@NonNull MessageDigest r10) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        DEFAULT_CLOCK = new Clock();
        MAX_BACKOFF_MS = TimeUnit.SECONDS.toMillis(1);
    }

    public BitmapPreFillRunner(BitmapPool r10, MemoryCache r11, PreFillQueue r12) {
        this(r10, r11, r12, DEFAULT_CLOCK, new Handler(Looper.getMainLooper()));
    }

    private long getFreeMemoryCacheBytes() {
        return this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize();
    }

    private long getNextDelay() {
        long r10 = this.currentDelay;
        this.currentDelay = Math.min(4 * r10, MAX_BACKOFF_MS);
        return r10;
    }

    private boolean isGcDetected(long r10) {
        if ((this.clock.now() - r10) < 32) goto L5;
        return true;
    L5:
        return false;
    }

    @VisibleForTesting
    public boolean allocate() {
        long r10 = this.clock.now();
    L4:
        if (this.toPrefill.isEmpty() == true) goto L19;
        if (isGcDetected(r10) == true) goto L19;
        PreFillType r11 = this.toPrefill.remove();
        if (this.seenTypes.contains(r11) == true) goto L10;
        this.seenTypes.add(r11);
        Bitmap r12 = this.bitmapPool.getDirty(r11.getWidth(), r11.getHeight(), r11.getConfig());
    L11:
        int r13 = Util.getBitmapByteSize(r12);
        if (getFreeMemoryCacheBytes() < r13) goto L14;
        this.memoryCache.put(new UniqueKey(), BitmapResource.obtain(r12, this.bitmapPool));
    L16:
        if (Log.isLoggable(TAG, 3) == false) goto L4;
        Log.d(TAG, "allocated [" + r11.getWidth() + FixCard.FixStyle.KEY_X + r11.getHeight() + "] " + r11.getConfig() + " size: " + r13);
        goto L4
    L14:
        this.bitmapPool.put(r12);
        goto L16
    L10:
        r12 = Bitmap.createBitmap(r11.getWidth(), r11.getHeight(), r11.getConfig());
    L19:
        if (this.isCancelled == false) goto L21;
    L23:
        return false;
    L21:
        if (this.toPrefill.isEmpty() == true) goto L23;
        return true;
    }

    public void cancel() {
        this.isCancelled = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (allocate() == false) goto L6;
        this.handler.postDelayed(this, getNextDelay());
        return;
    }

    @VisibleForTesting
    public BitmapPreFillRunner(BitmapPool r10, MemoryCache r11, PreFillQueue r12, Clock r13, Handler r14) {
        this.seenTypes = new HashSet();
        this.currentDelay = INITIAL_BACKOFF_MS;
        this.bitmapPool = r10;
        this.memoryCache = r11;
        this.toPrefill = r12;
        this.clock = r13;
        this.handler = r14;
    }
}
