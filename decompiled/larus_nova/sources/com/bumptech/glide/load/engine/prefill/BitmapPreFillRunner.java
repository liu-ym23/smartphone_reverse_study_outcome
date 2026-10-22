package com.bumptech.glide.load.engine.prefill;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.GlideLogUtil;
import com.bumptech.glide.util.Util;
import com.larksuite.framework.utils.autoscale.a;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
final class BitmapPreFillRunner implements Runnable {
    static final int BACKOFF_RATIO = 4;
    private static final Clock DEFAULT_CLOCK = null;
    static final long INITIAL_BACKOFF_MS = 40;
    static final long MAX_BACKOFF_MS = 0;
    static final long MAX_DURATION_MS = 32;
    static final String TAG = "PreFillRunner";
    private final BitmapPool bitmapPool;
    private final Clock clock;
    private long currentDelay;
    private final Handler handler;
    private boolean isCancelled;
    private final MemoryCache memoryCache;
    private final Set<PreFillType> seenTypes;
    private final PreFillQueue toPrefill;

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
        public void updateDiskCacheKey(MessageDigest r100) {
            throw new UnsupportedOperationException();
        }
    }

    public void cancel() {
        this.isCancelled = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        com_bumptech_glide_load_engine_prefill_BitmapPreFillRunner_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    static {
        DEFAULT_CLOCK = new Clock();
        MAX_BACKOFF_MS = TimeUnit.SECONDS.toMillis(1);
    }

    private long getFreeMemoryCacheBytes() {
        return this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize();
    }

    private long getNextDelay() {
        long r100 = this.currentDelay;
        this.currentDelay = Math.min(4 * r100, MAX_BACKOFF_MS);
        return r100;
    }

    public boolean allocate() {
        long r100 = this.clock.now();
    L4:
        if (this.toPrefill.isEmpty() == true) goto L17;
        if (isGcDetected(r100) == true) goto L17;
        PreFillType r101 = this.toPrefill.remove();
        if (this.seenTypes.contains(r101) == true) goto L10;
        this.seenTypes.add(r101);
        Bitmap r102 = this.bitmapPool.getDirty(r101.getWidth(), r101.getHeight(), r101.getConfig());
    L11:
        int r103 = Util.getBitmapByteSize(r102);
        if (getFreeMemoryCacheBytes() < r103) goto L14;
        this.memoryCache.put(new UniqueKey(), BitmapResource.obtain(r102, this.bitmapPool));
    L15:
        GlideLogUtil.d(TAG, "allocated [" + r101.getWidth() + "x" + r101.getHeight() + "] " + r101.getConfig() + " size: " + r103);
        goto L4
    L14:
        this.bitmapPool.put(r102);
        goto L15
    L10:
        int r104 = a.f285947a;
        r102 = Bitmap.createBitmap(r101.getWidth(), r101.getHeight(), r101.getConfig());
    L17:
        if (this.isCancelled == false) goto L19;
    L21:
        return false;
    L19:
        if (this.toPrefill.isEmpty() == true) goto L21;
        return true;
    }

    public void com_bumptech_glide_load_engine_prefill_BitmapPreFillRunner__run$___twin___() {
        if (allocate() == false) goto L6;
        this.handler.postDelayed(this, getNextDelay());
        return;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bumptech_glide_load_engine_prefill_BitmapPreFillRunner_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bumptech_glide_load_engine_prefill_BitmapPreFillRunner_com_larus_apm_impl_protector_RunnableLancet_run(BitmapPreFillRunner r100) {
        r100.com_bumptech_glide_load_engine_prefill_BitmapPreFillRunner__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    private boolean isGcDetected(long r100) {
        if ((this.clock.now() - r100) < 32) goto L5;
        return true;
    L5:
        return false;
    }

    public BitmapPreFillRunner(BitmapPool r100, MemoryCache r101, PreFillQueue r102) {
        this(r100, r101, r102, DEFAULT_CLOCK, new Handler(Looper.getMainLooper()));
    }

    public BitmapPreFillRunner(BitmapPool r100, MemoryCache r101, PreFillQueue r102, Clock r103, Handler r104) {
        this.seenTypes = new HashSet();
        this.currentDelay = INITIAL_BACKOFF_MS;
        this.bitmapPool = r100;
        this.memoryCache = r101;
        this.toPrefill = r102;
        this.clock = r103;
        this.handler = r104;
    }
}
