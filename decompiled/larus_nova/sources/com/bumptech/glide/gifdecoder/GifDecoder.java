package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes39.dex */
public interface GifDecoder {
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARTIAL_DECODE = 3;
    public static final int TOTAL_ITERATION_COUNT_FOREVER = 0;

    public interface BitmapProvider {
        Bitmap obtain(int r100, int r101, Bitmap.Config r102);

        byte[] obtainByteArray(int r100);

        int[] obtainIntArray(int r100);

        void release(Bitmap r100);

        void release(byte[] r100);

        void release(int[] r100);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GifDecodeStatus {
    }

    void advance();

    void clear();

    int getByteSize();

    int getCurrentFrameIndex();

    ByteBuffer getData();

    int getDelay(int r100);

    int getFrameCount();

    int getHeight();

    int getLoopCount();

    int getNetscapeLoopCount();

    int getNextDelay();

    Bitmap getNextFrame();

    int getStatus();

    int getTotalIterationCount();

    int getWidth();

    int read(InputStream r100, int r101);

    int read(byte[] r100);

    void resetFrameIndex();

    void setData(GifHeader r100, ByteBuffer r101);

    void setData(GifHeader r100, ByteBuffer r101, int r102);

    void setData(GifHeader r100, byte[] r101);

    void setDefaultBitmapConfig(Bitmap.Config r100);
}
