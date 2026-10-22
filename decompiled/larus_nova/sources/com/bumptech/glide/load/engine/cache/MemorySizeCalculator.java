package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import com.bumptech.glide.util.GlideLogUtil;
import com.bumptech.glide.util.Preconditions;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes39.dex */
public final class MemorySizeCalculator {
    static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    private static final int LOW_MEMORY_BYTE_ARRAY_POOL_DIVISOR = 2;
    private static final String TAG = "MemorySizeCalculator";
    private final int arrayPoolSize;
    private final int bitmapPoolSize;
    private final Context context;
    private final int memoryCacheSize;

    public static final class Builder {
        static final int ARRAY_POOL_SIZE_BYTES = 4194304;
        static final int BITMAP_POOL_TARGET_SCREENS = 0;
        static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
        static final float MAX_SIZE_MULTIPLIER = 0.4f;
        static final int MEMORY_CACHE_TARGET_SCREENS = 2;
        ActivityManager activityManager;
        int arrayPoolSizeBytes;
        float bitmapPoolScreens;
        final Context context;
        float lowMemoryMaxSizeMultiplier;
        float maxSizeMultiplier;
        float memoryCacheScreens;
        ScreenDimensions screenDimensions;

        static {
            if (Build.VERSION.SDK_INT >= 26) goto L5;
            int r100 = 4;
        L6:
            BITMAP_POOL_TARGET_SCREENS = r100;
            return;
        L5:
            r100 = 1;
            goto L6
        }

        public MemorySizeCalculator build() {
            return new MemorySizeCalculator(this);
        }

        public Builder(Context r100) {
            this.memoryCacheScreens = 2.0f;
            this.bitmapPoolScreens = BITMAP_POOL_TARGET_SCREENS;
            this.maxSizeMultiplier = 0.4f;
            this.lowMemoryMaxSizeMultiplier = LOW_MEMORY_MAX_SIZE_MULTIPLIER;
            this.arrayPoolSizeBytes = 4194304;
            this.context = r100;
            this.activityManager = (ActivityManager) r100.getSystemService("activity");
            this.screenDimensions = new DisplayMetricsScreenDimensions(INVOKEVIRTUAL_com_bumptech_glide_load_engine_cache_MemorySizeCalculator$Builder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()));
            if (Build.VERSION.SDK_INT >= 26) goto L5;
            return;
        L5:
            if (MemorySizeCalculator.isLowMemoryDevice(this.activityManager) == false) goto L9;
            this.bitmapPoolScreens = 0.0f;
            return;
        }

        public static DisplayMetrics INVOKEVIRTUAL_com_bumptech_glide_load_engine_cache_MemorySizeCalculator$Builder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
            return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        }

        public Builder setActivityManager(ActivityManager r100) {
            this.activityManager = r100;
            return this;
        }

        public Builder setArrayPoolSize(int r100) {
            this.arrayPoolSizeBytes = r100;
            return this;
        }

        public Builder setBitmapPoolScreens(float r100) {
            if (r100 < 0.0f) goto L5;
            boolean r101 = true;
        L6:
            Preconditions.checkArgument(r101, "Bitmap pool screens must be greater than or equal to 0");
            this.bitmapPoolScreens = r100;
            return this;
        L5:
            r101 = false;
            goto L6
        }

        public Builder setLowMemoryMaxSizeMultiplier(float r100) {
            if (r100 >= 0.0f) goto L5;
        L7:
            boolean r101 = false;
        L8:
            Preconditions.checkArgument(r101, "Low memory max size multiplier must be between 0 and 1");
            this.lowMemoryMaxSizeMultiplier = r100;
            return this;
        L5:
            if (r100 > 1.0f) goto L7;
            r101 = true;
            goto L8
        }

        public Builder setMaxSizeMultiplier(float r100) {
            if (r100 >= 0.0f) goto L5;
        L7:
            boolean r101 = false;
        L8:
            Preconditions.checkArgument(r101, "Size multiplier must be between 0 and 1");
            this.maxSizeMultiplier = r100;
            return this;
        L5:
            if (r100 > 1.0f) goto L7;
            r101 = true;
            goto L8
        }

        public Builder setMemoryCacheScreens(float r100) {
            if (r100 < 0.0f) goto L5;
            boolean r101 = true;
        L6:
            Preconditions.checkArgument(r101, "Memory cache screens must be greater than or equal to 0");
            this.memoryCacheScreens = r100;
            return this;
        L5:
            r101 = false;
            goto L6
        }

        public Builder setScreenDimensions(ScreenDimensions r100) {
            this.screenDimensions = r100;
            return this;
        }
    }

    public static final class DisplayMetricsScreenDimensions implements ScreenDimensions {
        private final DisplayMetrics displayMetrics;

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getHeightPixels() {
            return this.displayMetrics.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getWidthPixels() {
            return this.displayMetrics.widthPixels;
        }

        public DisplayMetricsScreenDimensions(DisplayMetrics r100) {
            this.displayMetrics = r100;
        }
    }

    public interface ScreenDimensions {
        int getHeightPixels();

        int getWidthPixels();
    }

    public int getArrayPoolSizeInBytes() {
        return this.arrayPoolSize;
    }

    public int getBitmapPoolSize() {
        return this.bitmapPoolSize;
    }

    public int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }

    public MemorySizeCalculator(Builder r100) {
        this.context = r100.context;
        if (isLowMemoryDevice(r100.activityManager) == false) goto L5;
        int r101 = r100.arrayPoolSizeBytes / 2;
    L6:
        this.arrayPoolSize = r101;
        int r102 = getMaxSize(r100.activityManager, r100.maxSizeMultiplier, r100.lowMemoryMaxSizeMultiplier);
        float r103 = (r100.screenDimensions.getWidthPixels() * r100.screenDimensions.getHeightPixels()) * 4;
        int r104 = Math.round(r100.bitmapPoolScreens * r103);
        int r105 = Math.round(r103 * r100.memoryCacheScreens);
        int r106 = r102 - r101;
        int r107 = r105 + r104;
        if (r107 > r106) goto L9;
        this.memoryCacheSize = r105;
        this.bitmapPoolSize = r104;
    L10:
        StringBuilder r108 = new StringBuilder("Calculation complete, Calculated memory cache size: ");
        r108.append(toMb(this.memoryCacheSize));
        r108.append(", pool size: ");
        r108.append(toMb(this.bitmapPoolSize));
        r108.append(", byte array size: ");
        r108.append(toMb(r101));
        r108.append(", memory class limited? ");
        if (r107 <= r102) goto L13;
        boolean r109 = true;
    L14:
        r108.append(r109);
        r108.append(", max size: ");
        r108.append(toMb(r102));
        r108.append(", memoryClass: ");
        r108.append(r100.activityManager.getMemoryClass());
        r108.append(", isLowMemoryDevice: ");
        r108.append(isLowMemoryDevice(r100.activityManager));
        GlideLogUtil.d(TAG, r108.toString());
        return;
    L13:
        r109 = false;
        goto L14
    L9:
        float r110 = r106;
        float r111 = r100.bitmapPoolScreens;
        float r112 = r100.memoryCacheScreens;
        float r113 = r110 / (r111 + r112);
        this.memoryCacheSize = Math.round(r112 * r113);
        this.bitmapPoolSize = Math.round(r113 * r100.bitmapPoolScreens);
        goto L10
    L5:
        r101 = r100.arrayPoolSizeBytes;
        goto L6
    }

    public static boolean isLowMemoryDevice(ActivityManager r100) {
        return r100.isLowRamDevice();
    }

    private String toMb(int r100) {
        return Formatter.formatFileSize(this.context, r100);
    }

    private static int getMaxSize(ActivityManager r100, float r101, float r102) {
        float r103 = (r100.getMemoryClass() * 1024) * 1024;
        if (isLowMemoryDevice(r100) == false) goto L6;
        r101 = r102;
    L6:
        return Math.round(r103 * r101);
    }
}
