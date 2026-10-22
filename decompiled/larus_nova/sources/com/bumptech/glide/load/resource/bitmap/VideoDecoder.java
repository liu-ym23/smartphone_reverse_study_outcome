package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.GlideLogUtil;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import f06.b;
import f06.d;
import g06.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {
    private static final MediaMetadataRetrieverFactory DEFAULT_FACTORY = null;
    public static final long DEFAULT_FRAME = -1;
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

        public /* synthetic */ AssetFileDescriptorInitializer(AnonymousClass1 r100) {
            this();
        }

        /* JADX INFO: renamed from: initialize, reason: avoid collision after fix types in other method */
        public void initialize2(MediaMetadataRetriever r100, AssetFileDescriptor r101) {
            r100.setDataSource(r101.getFileDescriptor(), r101.getStartOffset(), r101.getLength());
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer
        public /* bridge */ /* synthetic */ void initialize(MediaMetadataRetriever r100, AssetFileDescriptor r101) {
            initialize2(r100, r101);
        }
    }

    public static final class ByteBufferInitializer implements MediaMetadataRetrieverInitializer<ByteBuffer> {
        public ByteBufferInitializer() {
        }

        /* JADX INFO: renamed from: initialize, reason: avoid collision after fix types in other method */
        public void initialize2(MediaMetadataRetriever r100, final ByteBuffer r101) {
            r100.setDataSource(new AnonymousClass1(this, r101));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer
        public /* bridge */ /* synthetic */ void initialize(MediaMetadataRetriever r100, ByteBuffer r101) {
            initialize2(r100, r101);
        }
    }

    public static class MediaMetadataRetrieverFactory {
        public MediaMetadataRetrieverFactory() {
        }

        public MediaMetadataRetriever build() {
            return new MediaMetadataRetriever();
        }
    }

    public interface MediaMetadataRetrieverInitializer<T> {
        void initialize(MediaMetadataRetriever r100, T r101);
    }

    public static final class ParcelFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<ParcelFileDescriptor> {
        public ParcelFileDescriptorInitializer() {
        }

        /* JADX INFO: renamed from: initialize, reason: avoid collision after fix types in other method */
        public void initialize2(MediaMetadataRetriever r100, ParcelFileDescriptor r101) {
            r100.setDataSource(r101.getFileDescriptor());
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer
        public /* bridge */ /* synthetic */ void initialize(MediaMetadataRetriever r100, ParcelFileDescriptor r101) {
            initialize2(r100, r101);
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(T r100, Options r101) {
        return true;
    }

    static {
        TARGET_FRAME = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new AnonymousClass1());
        FRAME_OPTION = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new AnonymousClass2());
        DEFAULT_FACTORY = new MediaMetadataRetrieverFactory();
    }

    public static ResourceDecoder<AssetFileDescriptor, Bitmap> asset(BitmapPool r100) {
        return new VideoDecoder(r100, new AssetFileDescriptorInitializer(null));
    }

    public static ResourceDecoder<ByteBuffer, Bitmap> byteBuffer(BitmapPool r100) {
        return new VideoDecoder(r100, new ByteBufferInitializer());
    }

    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> parcel(BitmapPool r100) {
        return new VideoDecoder(r100, new ParcelFileDescriptorInitializer());
    }

    public VideoDecoder(BitmapPool r100, MediaMetadataRetrieverInitializer<T> r101) {
        this(r100, r101, DEFAULT_FACTORY);
    }

    private static String com_bumptech_glide_load_resource_bitmap_VideoDecoder_android_media_MediaMetadataRetriever_extractMetadata(MediaMetadataRetriever r110, int r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111)};
        b r112 = new b();
        a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return r110.extractMetadata(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public VideoDecoder(BitmapPool r100, MediaMetadataRetrieverInitializer<T> r101, MediaMetadataRetrieverFactory r102) {
        this.bitmapPool = r100;
        this.initializer = r101;
        this.factory = r102;
    }

    private static Bitmap decodeOriginalFrame(MediaMetadataRetriever r100, long r101, int r102) {
        return r100.getFrameAtTime(r101, r102);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(T r100, int r110, int r111, Options r112) throws IOException {
        long r101 = ((Long) r112.get(TARGET_FRAME)).longValue();
        if (r101 < 0) goto L5;
    L9:
        Integer r102 = (Integer) r112.get(FRAME_OPTION);
        if (r102 != null) goto L12;
        r102 = 2;
    L12:
        DownsampleStrategy r113 = (DownsampleStrategy) r112.get(DownsampleStrategy.OPTION);
        if (r113 != null) goto L15;
        r113 = DownsampleStrategy.DEFAULT;
    L15:
        DownsampleStrategy r103 = r113;
        MediaMetadataRetriever r114 = this.factory.build();
        this.initializer.initialize(r114, r100);     // Catch: Throwable -> L19 RuntimeException -> L21
        Bitmap r104 = decodeFrame(r114, r101, r102.intValue(), r110, r111, r103);     // Catch: Throwable -> L19 RuntimeException -> L21
        r114.release();
        return BitmapResource.obtain(r104, this.bitmapPool);
    L19:
        th = move-exception;
        r114.release();
        throw th;
    L21:
        e = move-exception;
        throw new IOException(e);     // Catch: Throwable -> L19
    L5:
        if (r101 == (-1)) goto L9;
        throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + r101);
    }

    private static Bitmap decodeFrame(MediaMetadataRetriever r100, long r101, int r102, int r103, int r104, DownsampleStrategy r105) {
        if (Build.VERSION.SDK_INT >= 27) goto L5;
    L10:
        Bitmap r106 = null;
    L11:
        if (r106 == null) goto L13;
        return r106;
    L13:
        return decodeOriginalFrame(r100, r101, r102);
    L5:
        if (r103 == Integer.MIN_VALUE) goto L10;
        if (r104 == Integer.MIN_VALUE) goto L10;
        if (r105 == DownsampleStrategy.NONE) goto L10;
        r106 = decodeScaledFrame(r100, r101, r102, r103, r104, r105);
        goto L11
    }

    private static Bitmap decodeScaledFrame(MediaMetadataRetriever r100, long r110, int r111, int r112, int r113, DownsampleStrategy r114) {
        int r101 = CastIntegerProtector.parseInt(com_bumptech_glide_load_resource_bitmap_VideoDecoder_android_media_MediaMetadataRetriever_extractMetadata(r100, 18));     // Catch: Throwable -> L10
        int r102 = CastIntegerProtector.parseInt(com_bumptech_glide_load_resource_bitmap_VideoDecoder_android_media_MediaMetadataRetriever_extractMetadata(r100, 19));     // Catch: Throwable -> L10
        int r103 = CastIntegerProtector.parseInt(com_bumptech_glide_load_resource_bitmap_VideoDecoder_android_media_MediaMetadataRetriever_extractMetadata(r100, 24));     // Catch: Throwable -> L10
        if (r103 != 90) goto L6;
    L7:
        r102 = r101;
        r101 = r102;
    L8:
        float r115 = r114.getScaleFactor(r101, r102, r112, r113);     // Catch: Throwable -> L10
        return r100.getScaledFrameAtTime(r110, r111, Math.round(r101 * r115), Math.round(r115 * r102));
    L6:
        if (r103 != 270) goto L8;
    L10:
        th = move-exception;
        GlideLogUtil.e(TAG, "Exception trying to decode frame on oreo+", th);
        return null;
    }
}
