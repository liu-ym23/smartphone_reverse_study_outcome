package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;
import com.obric.capabilitykit.common.UiType;

/* JADX INFO: loaded from: classes.dex */
public final class MemorySizeCalculator {

    @VisibleForTesting
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

        @VisibleForTesting
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
            BITMAP_POOL_TARGET_SCREENS = 1;
        }

        public Builder(Context r10) {
            this.memoryCacheScreens = 2.0f;
            this.bitmapPoolScreens = BITMAP_POOL_TARGET_SCREENS;
            this.maxSizeMultiplier = MAX_SIZE_MULTIPLIER;
            this.lowMemoryMaxSizeMultiplier = LOW_MEMORY_MAX_SIZE_MULTIPLIER;
            this.arrayPoolSizeBytes = 4194304;
            this.context = r10;
            this.activityManager = (ActivityManager) r10.getSystemService("activity");
            this.screenDimensions = new DisplayMetricsScreenDimensions(r10.getResources().getDisplayMetrics());
            if (MemorySizeCalculator.isLowMemoryDevice(this.activityManager) == false) goto L6;
            this.bitmapPoolScreens = 0.0f;
            return;
        }

        public MemorySizeCalculator build() {
            return new MemorySizeCalculator(this);
        }

        @VisibleForTesting
        public Builder setActivityManager(ActivityManager r10) {
            this.activityManager = r10;
            return this;
        }

        public Builder setArrayPoolSize(int r10) {
            this.arrayPoolSizeBytes = r10;
            return this;
        }

        public Builder setBitmapPoolScreens(float r10) {
            if (r10 < 0.0f) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkArgument(r11, "Bitmap pool screens must be greater than or equal to 0");
            this.bitmapPoolScreens = r10;
            return this;
        L5:
            r11 = false;
            goto L6
        }

        public Builder setLowMemoryMaxSizeMultiplier(float r10) {
            if (r10 >= 0.0f) goto L5;
        L7:
            boolean r11 = false;
        L8:
            Preconditions.checkArgument(r11, "Low memory max size multiplier must be between 0 and 1");
            this.lowMemoryMaxSizeMultiplier = r10;
            return this;
        L5:
            if (r10 > 1.0f) goto L7;
            r11 = true;
            goto L8
        }

        public Builder setMaxSizeMultiplier(float r10) {
            if (r10 >= 0.0f) goto L5;
        L7:
            boolean r11 = false;
        L8:
            Preconditions.checkArgument(r11, "Size multiplier must be between 0 and 1");
            this.maxSizeMultiplier = r10;
            return this;
        L5:
            if (r10 > 1.0f) goto L7;
            r11 = true;
            goto L8
        }

        public Builder setMemoryCacheScreens(float r10) {
            if (r10 < 0.0f) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkArgument(r11, "Memory cache screens must be greater than or equal to 0");
            this.memoryCacheScreens = r10;
            return this;
        L5:
            r11 = false;
            goto L6
        }

        @VisibleForTesting
        public Builder setScreenDimensions(ScreenDimensions r10) {
            this.screenDimensions = r10;
            return this;
        }
    }

    public static final class DisplayMetricsScreenDimensions implements ScreenDimensions {
        private final DisplayMetrics displayMetrics;

        public DisplayMetricsScreenDimensions(DisplayMetrics r10) {
            this.displayMetrics = r10;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getHeightPixels() {
            return this.displayMetrics.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getWidthPixels() {
            return this.displayMetrics.widthPixels;
        }
    }

    public interface ScreenDimensions {
        int getHeightPixels();

        int getWidthPixels();
    }

    public MemorySizeCalculator(Builder r10) {
        this.context = r10.context;
        if (isLowMemoryDevice(r10.activityManager) == false) goto L5;
        int r11 = r10.arrayPoolSizeBytes / 2;
    L6:
        this.arrayPoolSize = r11;
        int r12 = getMaxSize(r10.activityManager, r10.maxSizeMultiplier, r10.lowMemoryMaxSizeMultiplier);
        float r13 = (r10.screenDimensions.getWidthPixels() * r10.screenDimensions.getHeightPixels()) * 4;
        int r14 = Math.round(r10.bitmapPoolScreens * r13);
        int r15 = Math.round(r13 * r10.memoryCacheScreens);
        int r16 = r12 - r11;
        int r17 = r15 + r14;
        if (r17 > r16) goto L9;
        this.memoryCacheSize = r15;
        this.bitmapPoolSize = r14;
    L11:
        if (Log.isLoggable(TAG, 3) == false) goto L18;
        StringBuilder r18 = new StringBuilder();
        r18.append("Calculation complete, Calculated memory cache size: ");
        r18.append(toMb(this.memoryCacheSize));
        r18.append(", pool size: ");
        r18.append(toMb(this.bitmapPoolSize));
        r18.append(", byte array size: ");
        r18.append(toMb(r11));
        r18.append(", memory class limited? ");
        if (r17 <= r12) goto L15;
        boolean r19 = true;
    L16:
        r18.append(r19);
        r18.append(", max size: ");
        r18.append(toMb(r12));
        r18.append(", memoryClass: ");
        r18.append(r10.activityManager.getMemoryClass());
        r18.append(", isLowMemoryDevice: ");
        r18.append(isLowMemoryDevice(r10.activityManager));
        Log.d(TAG, r18.toString());
        return;
    L15:
        r19 = false;
        goto L16
    L18:
        return;
    L9:
        float r20 = r16;
        float r21 = r10.bitmapPoolScreens;
        float r22 = r10.memoryCacheScreens;
        float r23 = r20 / (r21 + r22);
        this.memoryCacheSize = Math.round(r22 * r23);
        this.bitmapPoolSize = Math.round(r23 * r10.bitmapPoolScreens);
        goto L11
    L5:
        r11 = r10.arrayPoolSizeBytes;
        goto L6
    }

    private static int getMaxSize(ActivityManager r10, float r11, float r12) {
        float r13 = r10.getMemoryClass() * UiType.FLAG_APP_CHOOSER_CARD;
        if (isLowMemoryDevice(r10) == false) goto L6;
        r11 = r12;
    L6:
        return Math.round(r13 * r11);
    }

    @TargetApi(19)
    public static boolean isLowMemoryDevice(ActivityManager r10) {
        return r10.isLowRamDevice();
    }

    private String toMb(int r10) {
        return Formatter.formatFileSize(this.context, r10);
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
}
