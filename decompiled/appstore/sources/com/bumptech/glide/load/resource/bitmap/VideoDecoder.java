package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {
    private static final MediaMetadataRetrieverFactory DEFAULT_FACTORY = null;
    public static final long DEFAULT_FRAME = -1;

    @VisibleForTesting
    static final int DEFAULT_FRAME_OPTION = 2;
    public static final Option<Integer> FRAME_OPTION = null;
    private static final String TAG = "VideoDecoder";
    public static final Option<Long> TARGET_FRAME = null;
    private final BitmapPool bitmapPool;
    private final MediaMetadataRetrieverFactory factory;
    private final MediaMetadataRetrieverInitializer<T> initializer;

    public static final class AssetFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<AssetFileDescriptor> {
        private AssetFileDescriptorInitializer() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer
        public /* bridge */ /* synthetic */ void initialize(MediaMetadataRetriever r10, AssetFileDescriptor r11) {
            initialize2(r10, r11);
        }

        public /* synthetic */ AssetFileDescriptorInitializer(AnonymousClass1 r10) {
            this();
        }

        /* JADX INFO: renamed from: initialize, reason: avoid collision after fix types in other method */
        public void initialize2(MediaMetadataRetriever r10, AssetFileDescriptor r11) {
            r10.setDataSource(r11.getFileDescriptor(), r11.getStartOffset(), r11.getLength());
        }
    }

    @VisibleForTesting
    public static class MediaMetadataRetrieverFactory {
        public MediaMetadataRetrieverFactory() {
        }

        public MediaMetadataRetriever build() {
            return new MediaMetadataRetriever();
        }
    }

    @VisibleForTesting
    public interface MediaMetadataRetrieverInitializer<T> {
        void initialize(MediaMetadataRetriever r10, T r11);
    }

    public static final class ParcelFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<ParcelFileDescriptor> {
        public ParcelFileDescriptorInitializer() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer
        public /* bridge */ /* synthetic */ void initialize(MediaMetadataRetriever r10, ParcelFileDescriptor r11) {
            initialize2(r10, r11);
        }

        /* JADX INFO: renamed from: initialize, reason: avoid collision after fix types in other method */
        public void initialize2(MediaMetadataRetriever r10, ParcelFileDescriptor r11) {
            r10.setDataSource(r11.getFileDescriptor());
        }
    }

    static {
        TARGET_FRAME = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new AnonymousClass1());
        FRAME_OPTION = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new AnonymousClass2());
        DEFAULT_FACTORY = new MediaMetadataRetrieverFactory();
    }

    public VideoDecoder(BitmapPool r10, MediaMetadataRetrieverInitializer<T> r11) {
        this(r10, r11, DEFAULT_FACTORY);
    }

    public static ResourceDecoder<AssetFileDescriptor, Bitmap> asset(BitmapPool r10) {
        return new VideoDecoder(r10, new AssetFileDescriptorInitializer(null));
    }

    @Nullable
    private static Bitmap decodeFrame(MediaMetadataRetriever r10, long r11, int r12, int r13, int r14, DownsampleStrategy r15) {
        if (r13 == Integer.MIN_VALUE) goto L8;
        if (r14 == Integer.MIN_VALUE) goto L8;
        if (r15 == DownsampleStrategy.NONE) goto L8;
        Bitmap r16 = decodeScaledFrame(r10, r11, r12, r13, r14, r15);
    L9:
        if (r16 == null) goto L11;
        return r16;
    L11:
        return decodeOriginalFrame(r10, r11, r12);
    L8:
        r16 = null;
        goto L9
    }

    private static Bitmap decodeOriginalFrame(MediaMetadataRetriever r10, long r11, int r12) {
        return r10.getFrameAtTime(r11, r12);
    }

    @TargetApi(27)
    private static Bitmap decodeScaledFrame(MediaMetadataRetriever r10, long r11, int r12, int r13, int r14, DownsampleStrategy r15) {
        int r16 = Integer.parseInt(r10.extractMetadata(18));     // Catch: Throwable -> L10
        int r17 = Integer.parseInt(r10.extractMetadata(19));     // Catch: Throwable -> L10
        int r18 = Integer.parseInt(r10.extractMetadata(24));     // Catch: Throwable -> L10
        if (r18 != 90) goto L6;
    L7:
        r17 = r16;
        r16 = r17;
    L8:
        float r19 = r15.getScaleFactor(r16, r17, r13, r14);     // Catch: Throwable -> L10
        return r10.getScaledFrameAtTime(r11, r12, Math.round(r16 * r19), Math.round(r19 * r17));
    L6:
        if (r18 != 270) goto L8;
    L10:
        th = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L18;
        Log.d(TAG, "Exception trying to decode frame on oreo+", th);
        return null;
    L18:
        return null;
    }

    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> parcel(BitmapPool r10) {
        return new VideoDecoder(r10, new ParcelFileDescriptorInitializer());
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(@NonNull T r10, int r11, int r12, @NonNull Options r13) throws IOException {
        long r14 = ((Long) r13.get(TARGET_FRAME)).longValue();
        if (r14 < 0) goto L5;
    L9:
        Integer r15 = (Integer) r13.get(FRAME_OPTION);
        if (r15 != null) goto L12;
        r15 = 2;
    L12:
        DownsampleStrategy r16 = (DownsampleStrategy) r13.get(DownsampleStrategy.OPTION);
        if (r16 != null) goto L15;
        r16 = DownsampleStrategy.DEFAULT;
    L15:
        DownsampleStrategy r17 = r16;
        MediaMetadataRetriever r18 = this.factory.build();
        this.initializer.initialize(r18, r10);     // Catch: Throwable -> L19 RuntimeException -> L21
        Bitmap r19 = decodeFrame(r18, r14, r15.intValue(), r11, r12, r17);     // Catch: Throwable -> L19 RuntimeException -> L21
        r18.release();
        return BitmapResource.obtain(r19, this.bitmapPool);
    L21:
        e = move-exception;
        throw new IOException(e);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r18.release();
        throw th;
    L5:
        if (r14 == (-1)) goto L9;
        throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + r14);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@NonNull T r10, @NonNull Options r11) {
        return true;
    }

    @VisibleForTesting
    public VideoDecoder(BitmapPool r10, MediaMetadataRetrieverInitializer<T> r11, MediaMetadataRetrieverFactory r12) {
        this.bitmapPool = r10;
        this.initializer = r11;
        this.factory = r12;
    }
}
