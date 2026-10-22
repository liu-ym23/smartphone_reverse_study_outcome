package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {
    private static final GifDecoderFactory GIF_DECODER_FACTORY = null;
    private static final GifHeaderParserPool PARSER_POOL = null;
    private static final String TAG = "BufferGifDecoder";
    private final Context context;
    private final GifDecoderFactory gifDecoderFactory;
    private final GifHeaderParserPool parserPool;
    private final List<ImageHeaderParser> parsers;
    private final GifBitmapProvider provider;

    @VisibleForTesting
    public static class GifDecoderFactory {
        public GifDecoderFactory() {
        }

        public GifDecoder build(GifDecoder.BitmapProvider r10, GifHeader r11, ByteBuffer r12, int r13) {
            return new StandardGifDecoder(r10, r11, r12, r13);
        }
    }

    @VisibleForTesting
    public static class GifHeaderParserPool {
        private final Queue<GifHeaderParser> pool;

        public GifHeaderParserPool() {
            this.pool = Util.createQueue(0);
        }

        public synchronized GifHeaderParser obtain(ByteBuffer r10) {
            monitor-enter(this);
            GifHeaderParser r11 = this.pool.poll();     // Catch: Throwable -> L6
            if (r11 != null) goto L8;
            r11 = new GifHeaderParser();     // Catch: Throwable -> L6
        L8:
            GifHeaderParser r12 = r11.setData(r10);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r12;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void release(GifHeaderParser r10) {
            monitor-enter(this);
            r10.clear();     // Catch: Throwable -> L6
            this.pool.offer(r10);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    static {
        GIF_DECODER_FACTORY = new GifDecoderFactory();
        PARSER_POOL = new GifHeaderParserPool();
    }

    public ByteBufferGifDecoder(Context r10) {
        this(r10, Glide.get(r10).getRegistry().getImageHeaderParsers(), Glide.get(r10).getBitmapPool(), Glide.get(r10).getArrayPool());
    }

    private static int getSampleSize(GifHeader r10, int r11, int r12) {
        int r13 = Math.min(r10.getHeight() / r12, r10.getWidth() / r11);
        if (r13 != 0) goto L5;
        int r14 = 0;
    L6:
        int r15 = Math.max(1, r14);
        if (Log.isLoggable(TAG, 2) == false) goto L10;
        if (r15 <= 1) goto L10;
        Log.v(TAG, "Downsampling GIF, sampleSize: " + r15 + ", target dimens: [" + r11 + FixCard.FixStyle.KEY_X + r12 + "], actual dimens: [" + r10.getWidth() + FixCard.FixStyle.KEY_X + r10.getHeight() + "]");
    L10:
        return r15;
    L5:
        r14 = Integer.highestOneBit(r13);
        goto L6
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource<GifDrawable> decode(@NonNull ByteBuffer r10, int r11, int r12, @NonNull Options r13) throws IOException {
        return decode2(r10, r11, r12, r13);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(@NonNull ByteBuffer r10, @NonNull Options r11) throws IOException {
        return handles2(r10, r11);
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public GifDrawableResource decode2(@NonNull ByteBuffer r10, int r11, int r12, @NonNull Options r13) {
        GifHeaderParser r14 = this.parserPool.obtain(r10);
        GifDrawableResource r15 = decode(r10, r11, r12, r14, r13);     // Catch: Throwable -> L6
        this.parserPool.release(r14);
        return r15;
    L6:
        th = move-exception;
        this.parserPool.release(r14);
        throw th;
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(@NonNull ByteBuffer r10, @NonNull Options r11) throws IOException {
        if (((Boolean) r11.get(GifOptions.DISABLE_ANIMATION)).booleanValue() == false) goto L5;
    L7:
        return false;
    L5:
        if (ImageHeaderParserUtils.getType(this.parsers, r10) != ImageHeaderParser.ImageType.GIF) goto L7;
        return true;
    }

    public ByteBufferGifDecoder(Context r10, List<ImageHeaderParser> r11, BitmapPool r12, ArrayPool r13) {
        this(r10, r11, r12, r13, PARSER_POOL, GIF_DECODER_FACTORY);
    }

    @VisibleForTesting
    public ByteBufferGifDecoder(Context r10, List<ImageHeaderParser> r11, BitmapPool r12, ArrayPool r13, GifHeaderParserPool r14, GifDecoderFactory r15) {
        this.context = r10.getApplicationContext();
        this.parsers = r11;
        this.gifDecoderFactory = r15;
        this.provider = new GifBitmapProvider(r12, r13);
        this.parserPool = r14;
    }

    @Nullable
    private GifDrawableResource decode(ByteBuffer r17, int r18, int r19, GifHeaderParser r20, Options r21) {
        long r10 = LogTime.getLogTime();
        GifHeader r11 = r20.parseHeader();     // Catch: Throwable -> L12
        if (r11.getNumFrames() <= 0) goto L27;
        if (r11.getStatus() != 0) goto L27;
        if (r21.get(GifOptions.DECODE_FORMAT) != DecodeFormat.PREFER_RGB_565) goto L14;
        Bitmap.Config r12 = Bitmap.Config.RGB_565;     // Catch: Throwable -> L12
    L15:
        GifDecoder r13 = this.gifDecoderFactory.build(this.provider, r11, r17, getSampleSize(r11, r18, r19));     // Catch: Throwable -> L12
        r13.setDefaultBitmapConfig(r12);     // Catch: Throwable -> L12
        r13.advance();     // Catch: Throwable -> L12
        Bitmap r15 = r13.getNextFrame();     // Catch: Throwable -> L12
        if (r15 == null) goto L18;
        GifDrawableResource r14 = new GifDrawableResource(new GifDrawable(this.context, r13, UnitTransformation.get(), r18, r19, r15));     // Catch: Throwable -> L12
        if (Log.isLoggable(TAG, 2) == false) goto L25;
        Log.v(TAG, "Decoded GIF from stream in " + LogTime.getElapsedMillis(r10));
    L25:
        return r14;
    L18:
        if (Log.isLoggable(TAG, 2) == false) goto L20;
        Log.v(TAG, "Decoded GIF from stream in " + LogTime.getElapsedMillis(r10));
    L20:
        return null;
    L14:
        r12 = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L12
    L27:
        if (Log.isLoggable(TAG, 2) == false) goto L29;
        Log.v(TAG, "Decoded GIF from stream in " + LogTime.getElapsedMillis(r10));
    L29:
        return null;
    L12:
        th = move-exception;
        if (Log.isLoggable(TAG, 2) == false) goto L33;
        Log.v(TAG, "Decoded GIF from stream in " + LogTime.getElapsedMillis(r10));
    L33:
        throw th;
    }
}
