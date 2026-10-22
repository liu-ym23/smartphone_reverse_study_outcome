package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface GifDecoder {
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARTIAL_DECODE = 3;
    public static final int TOTAL_ITERATION_COUNT_FOREVER = 0;

    public interface BitmapProvider {
        @NonNull
        Bitmap obtain(int r10, int r11, @NonNull Bitmap.Config r12);

        @NonNull
        byte[] obtainByteArray(int r10);

        @NonNull
        int[] obtainIntArray(int r10);

        void release(@NonNull Bitmap r10);

        void release(@NonNull byte[] r10);

        void release(@NonNull int[] r10);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GifDecodeStatus {
    }

    void advance();

    void clear();

    int getByteSize();

    int getCurrentFrameIndex();

    @NonNull
    ByteBuffer getData();

    int getDelay(int r10);

    int getFrameCount();

    int getHeight();

    @Deprecated
    int getLoopCount();

    int getNetscapeLoopCount();

    int getNextDelay();

    @Nullable
    Bitmap getNextFrame();

    int getStatus();

    int getTotalIterationCount();

    int getWidth();

    int read(@Nullable InputStream r10, int r11);

    int read(@Nullable byte[] r10);

    void resetFrameIndex();

    void setData(@NonNull GifHeader r10, @NonNull ByteBuffer r11);

    void setData(@NonNull GifHeader r10, @NonNull ByteBuffer r11, int r12);

    void setData(@NonNull GifHeader r10, @NonNull byte[] r11);

    void setDefaultBitmapConfig(@NonNull Bitmap.Config r10);
}
