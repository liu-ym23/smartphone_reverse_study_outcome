package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class Downsampler {
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG = null;
    public static final Option<DecodeFormat> DECODE_FORMAT = null;

    @Deprecated
    public static final Option<DownsampleStrategy> DOWNSAMPLE_STRATEGY = null;
    private static final DecodeCallbacks EMPTY_CALLBACKS = null;
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = null;
    private static final String ICO_MIME_TYPE = "image/x-ico";
    private static final int MARK_POSITION = 10485760;
    private static final Set<String> NO_DOWNSAMPLE_PRE_N_MIME_TYPES = null;
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE = null;
    static final String TAG = "Downsampler";
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL_PRE_KITKAT = null;
    private static final String WBMP_MIME_TYPE = "image/vnd.wap.wbmp";
    private final BitmapPool bitmapPool;
    private final ArrayPool byteArrayPool;
    private final DisplayMetrics displayMetrics;
    private final HardwareConfigState hardwareConfigState;
    private final List<ImageHeaderParser> parsers;

    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool r10, Bitmap r11) throws IOException;

        void onObtainBounds();
    }

    static {
        DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
        DOWNSAMPLE_STRATEGY = DownsampleStrategy.OPTION;
        Boolean r10 = Boolean.FALSE;
        FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", r10);
        ALLOW_HARDWARE_CONFIG = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", r10);
        NO_DOWNSAMPLE_PRE_N_MIME_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{WBMP_MIME_TYPE, ICO_MIME_TYPE})));
        EMPTY_CALLBACKS = new AnonymousClass1();
        TYPES_THAT_USE_POOL_PRE_KITKAT = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        OPTIONS_QUEUE = Util.createQueue(0);
    }

    public Downsampler(List<ImageHeaderParser> r10, DisplayMetrics r11, BitmapPool r12, ArrayPool r13) {
        this.hardwareConfigState = HardwareConfigState.getInstance();
        this.parsers = r10;
        this.displayMetrics = (DisplayMetrics) Preconditions.checkNotNull(r11);
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(r12);
        this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(r13);
    }

    private static int adjustTargetDensityForError(double r10) {
        int r11 = getDensityMultiplier(r10);
        int r12 = round(((double) r11) * r10);
        return round((r10 / ((double) (r12 / r11))) * ((double) r12));
    }

    private void calculateConfig(InputStream r10, DecodeFormat r11, boolean r12, boolean r13, BitmapFactory.Options r14, int r15, int r16) {
        if (this.hardwareConfigState.setHardwareConfigIfAllowed(r15, r16, r14, r11, r12, r13) == false) goto L6;
        return;
    L6:
        if (r11 != DecodeFormat.PREFER_ARGB_8888) goto L23;
        r14.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return;
    L23:
        boolean r17 = ImageHeaderParserUtils.getType(this.parsers, r10, this.byteArrayPool).hasAlpha();     // Catch: IOException -> L9
    L14:
        if (r17 == false) goto L16;
        Bitmap.Config r18 = Bitmap.Config.ARGB_8888;
    L17:
        r14.inPreferredConfig = r18;
        if (r18 != Bitmap.Config.RGB_565) goto L25;
        r14.inDither = true;
        return;
    L25:
        return;
    L16:
        r18 = Bitmap.Config.RGB_565;
    L9:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L13;
        Log.d(TAG, "Cannot determine whether the image has alpha or not from header, format " + r11, e);
    L13:
        r17 = false;
        goto L14
    }

    private static void calculateScaling(ImageHeaderParser.ImageType r18, InputStream r19, DecodeCallbacks r20, BitmapPool r21, DownsampleStrategy r22, int r23, int r24, int r25, int r26, int r27, BitmapFactory.Options r28) throws IOException {
        if (r24 <= 0) goto L63;
        if (r25 <= 0) goto L63;
        if (r23 != 90) goto L9;
    L12:
        float r10 = r22.getScaleFactor(r25, r24, r26, r27);
    L14:
        if (r10 <= 0.0f) goto L61;
        DownsampleStrategy.SampleSizeRounding r11 = r22.getSampleSizeRounding(r24, r25, r26, r27);
        if (r11 == null) goto L59;
        float r12 = r24;
        float r14 = r25;
        int r13 = r24 / round(r10 * r12);
        int r15 = r25 / round(r10 * r14);
        DownsampleStrategy.SampleSizeRounding r16 = DownsampleStrategy.SampleSizeRounding.MEMORY;
        if (r11 != r16) goto L20;
        int r17 = Math.max(r13, r15);
    L21:
        int r29 = Math.max(1, Integer.highestOneBit(r17));
        if (r11 == r16) goto L24;
    L26:
        r28.inSampleSize = r29;
        if (r18 != ImageHeaderParser.ImageType.JPEG) goto L32;
        float r30 = Math.min(r29, 8);
        int r31 = (int) Math.ceil(r12 / r30);
        int r32 = (int) Math.ceil(r14 / r30);
        int r110 = r29 / 8;
        if (r110 <= 0) goto L50;
        r31 = r31 / r110;
        r32 = r32 / r110;
    L50:
        double r111 = r22.getScaleFactor(r31, r32, r26, r27);
        r28.inTargetDensity = adjustTargetDensityForError(r111);
        r28.inDensity = getDensityMultiplier(r111);
        if (isScaling(r28) == false) goto L53;
        r28.inScaled = true;
    L55:
        if (Log.isLoggable(TAG, 2) == false) goto L66;
        Log.v(TAG, "Calculate scaling, source: [" + r24 + FixCard.FixStyle.KEY_X + r25 + "], target: [" + r26 + FixCard.FixStyle.KEY_X + r27 + "], power of two scaled: [" + r31 + FixCard.FixStyle.KEY_X + r32 + "], exact scale factor: " + r10 + ", power of 2 sample size: " + r29 + ", adjusted scale factor: " + r111 + ", target density: " + r28.inTargetDensity + ", density: " + r28.inDensity);
        return;
    L66:
        return;
    L53:
        r28.inTargetDensity = 0;
        r28.inDensity = 0;
        goto L55
    L32:
        if (r18 != ImageHeaderParser.ImageType.PNG) goto L34;
    L49:
        float r33 = r29;
        r31 = (int) Math.floor(r12 / r33);
        r32 = (int) Math.floor(r14 / r33);
        goto L50
    L34:
        if (r18 == ImageHeaderParser.ImageType.PNG_A) goto L49;
        if (r18 != ImageHeaderParser.ImageType.WEBP) goto L39;
    L48:
        float r34 = r29;
        r31 = Math.round(r12 / r34);
        r32 = Math.round(r14 / r34);
        goto L50
    L39:
        if (r18 == ImageHeaderParser.ImageType.WEBP_A) goto L48;
        if ((r24 % r29) != 0) goto L47;
        if ((r25 % r29) != 0) goto L47;
        r31 = r24 / r29;
        r32 = r25 / r29;
    L47:
        int[] r35 = getDimensions(r19, r28, r20, r21);
        r31 = r35[0];
        r32 = r35[1];
        goto L50
    L24:
        if (r29 >= (1.0f / r10)) goto L26;
        r29 = r29 << 1;
        goto L26
    L20:
        r17 = Math.min(r13, r15);
        goto L21
    L59:
        throw new IllegalArgumentException("Cannot round with null rounding");
    L61:
        throw new IllegalArgumentException("Cannot scale with factor: " + r10 + " from: " + r22 + ", source: [" + r24 + FixCard.FixStyle.KEY_X + r25 + "], target: [" + r26 + FixCard.FixStyle.KEY_X + r27 + "]");
    L9:
        if (r23 == 270) goto L12;
        r10 = r22.getScaleFactor(r24, r25, r26, r27);
    L63:
        if (Log.isLoggable(TAG, 3) == false) goto L67;
        Log.d(TAG, "Unable to determine dimensions for: " + r18 + " with target [" + r26 + FixCard.FixStyle.KEY_X + r27 + "]");
        return;
    }

    private Bitmap decodeFromWrappedStreams(InputStream r27, BitmapFactory.Options r28, DownsampleStrategy r29, DecodeFormat r30, boolean r31, int r32, int r33, boolean r34, DecodeCallbacks r35) throws IOException {
        long r20 = LogTime.getLogTime();
        int[] r10 = getDimensions(r27, r28, r35, this.bitmapPool);
        int r11 = r10[0];
        int r12 = r10[1];
        String r13 = r28.outMimeType;
        if (r11 == (-1)) goto L7;
        if (r12 == (-1)) goto L7;
        boolean r22 = r31;
    L8:
        int r14 = ImageHeaderParserUtils.getOrientation(this.parsers, r27, this.byteArrayPool);
        int r15 = TransformationUtils.getExifOrientationDegrees(r14);
        boolean r23 = TransformationUtils.isExifOrientationRequired(r14);
        if (r32 != Integer.MIN_VALUE) goto L11;
        int r24 = r11;
    L12:
        if (r33 != Integer.MIN_VALUE) goto L14;
        int r25 = r12;
    L15:
        ImageHeaderParser.ImageType r16 = ImageHeaderParserUtils.getType(this.parsers, r27, this.byteArrayPool);
        calculateScaling(r16, r27, r35, this.bitmapPool, r29, r15, r11, r12, r24, r25, r28);
        calculateConfig(r27, r30, r22, r23, r28, r24, r25);
        if (shouldUsePool(r16) == false) goto L31;
        if (r11 < 0) goto L22;
        if (r12 < 0) goto L22;
        if (r34 == false) goto L22;
        int r17 = r24;
        int r18 = r25;
    L28:
        if (r17 <= 0) goto L31;
        if (r18 <= 0) goto L31;
        setInBitmap(r28, this.bitmapPool, r17, r18);
    L22:
        if (isScaling(r28) == false) goto L24;
        float r19 = r28.inTargetDensity / r28.inDensity;
    L25:
        int r21 = r28.inSampleSize;
        float r26 = r21;
        int r36 = (int) Math.ceil(r11 / r26);
        int r37 = (int) Math.ceil(r12 / r26);
        r17 = Math.round(r36 * r19);
        r18 = Math.round(r37 * r19);
        if (Log.isLoggable(TAG, 2) == false) goto L28;
        Log.v(TAG, "Calculated target [" + r17 + FixCard.FixStyle.KEY_X + r18 + "] for source [" + r11 + FixCard.FixStyle.KEY_X + r12 + "], sampleSize: " + r21 + ", targetDensity: " + r28.inTargetDensity + ", density: " + r28.inDensity + ", density multiplier: " + r19);
        goto L28
    L24:
        r19 = 1.0f;
    L31:
        Bitmap r38 = decodeStream(r27, r28, r35, this.bitmapPool);
        r35.onDecodeComplete(this.bitmapPool, r38);
        if (Log.isLoggable(TAG, 2) == false) goto L35;
        logDecode(r11, r12, r13, r28, r38, r32, r33, r20);
    L35:
        if (r38 == null) goto L39;
        r38.setDensity(this.displayMetrics.densityDpi);
        Bitmap r39 = TransformationUtils.rotateImageExif(this.bitmapPool, r38, r14);
        if (r38.equals(r39) == true) goto L41;
        this.bitmapPool.put(r38);
        return r39;
    L41:
        return r39;
    L39:
        return null;
    L14:
        r25 = r33;
        goto L15
    L11:
        r24 = r32;
    L7:
        r22 = false;
        goto L8
    }

    private static Bitmap decodeStream(InputStream r10, BitmapFactory.Options r11, DecodeCallbacks r12, BitmapPool r13) throws IOException {
        if (r11.inJustDecodeBounds == false) goto L5;
        r10.mark(MARK_POSITION);
    L6:
        int r14 = r11.outWidth;
        int r15 = r11.outHeight;
        String r16 = r11.outMimeType;
        TransformationUtils.getBitmapDrawableLock().lock();
        Bitmap r17 = BitmapFactory.decodeStream(r10, null, r11);     // Catch: Throwable -> L12 IllegalArgumentException -> L14
        TransformationUtils.getBitmapDrawableLock().unlock();
        if (r11.inJustDecodeBounds == false) goto L11;
        r10.reset();
    L11:
        return r17;
    L14:
        e = move-exception;
        IOException r18 = newIoExceptionForInBitmapAssertion(e, r14, r15, r16, r11);     // Catch: Throwable -> L12
        if (Log.isLoggable(TAG, 3) == false) goto L19;
        Log.d(TAG, "Failed to decode with inBitmap, trying again without Bitmap re-use", r18);     // Catch: Throwable -> L12
    L19:
        if (r11.inBitmap != null) goto L29;
        throw r18;     // Catch: Throwable -> L12
    L29:
        r10.reset();     // Catch: Throwable -> L12 IOException -> L23
        r13.put(r11.inBitmap);     // Catch: Throwable -> L12 IOException -> L23
        r11.inBitmap = null;     // Catch: Throwable -> L12 IOException -> L23
        Bitmap r19 = decodeStream(r10, r11, r12, r13);     // Catch: Throwable -> L12 IOException -> L23
        TransformationUtils.getBitmapDrawableLock().unlock();
        return r19;
    L31:
        throw r18;     // Catch: Throwable -> L12
    L23:
        throw r18;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        TransformationUtils.getBitmapDrawableLock().unlock();
        throw th;
    L5:
        r12.onObtainBounds();
        goto L6
    }

    @Nullable
    @TargetApi(19)
    private static String getBitmapString(Bitmap r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return "[" + r10.getWidth() + FixCard.FixStyle.KEY_X + r10.getHeight() + "] " + r10.getConfig() + (" (" + r10.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options getDefaultOptions() {
        monitor-enter(Downsampler.class);
        Queue<BitmapFactory.Options> r10 = OPTIONS_QUEUE;     // Catch: Throwable -> L11
        monitor-enter(r10);     // Catch: Throwable -> L11
        BitmapFactory.Options r11 = r10.poll();     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        if (r11 != null) goto L13;
        r11 = new BitmapFactory.Options();     // Catch: Throwable -> L11
        resetOptions(r11);     // Catch: Throwable -> L11
    L13:
        monitor-exit(Downsampler.class);
        return r11;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static int getDensityMultiplier(double r10) {
        if (r10 <= 1.0d) goto L7;
        r10 = 1.0d / r10;
    L7:
        return (int) Math.round(r10 * 2.147483647E9d);
    }

    private static int[] getDimensions(InputStream r10, BitmapFactory.Options r11, DecodeCallbacks r12, BitmapPool r13) throws IOException {
        r11.inJustDecodeBounds = true;
        decodeStream(r10, r11, r12, r13);
        r11.inJustDecodeBounds = false;
        return new int[]{r11.outWidth, r11.outHeight};
    }

    private static String getInBitmapString(BitmapFactory.Options r10) {
        return getBitmapString(r10.inBitmap);
    }

    private static boolean isScaling(BitmapFactory.Options r10) {
        int r11 = r10.inTargetDensity;
        if (r11 <= 0) goto L8;
        int r12 = r10.inDensity;
        if (r12 <= 0) goto L8;
        if (r11 == r12) goto L8;
        return true;
    L8:
        return false;
    }

    private static void logDecode(int r10, int r11, String r12, BitmapFactory.Options r13, Bitmap r14, int r15, int r16, long r17) {
        Log.v(TAG, "Decoded " + getBitmapString(r14) + " from [" + r10 + FixCard.FixStyle.KEY_X + r11 + "] " + r12 + " with inBitmap " + getInBitmapString(r13) + " for [" + r15 + FixCard.FixStyle.KEY_X + r16 + "], sample size: " + r13.inSampleSize + ", density: " + r13.inDensity + ", target density: " + r13.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.getElapsedMillis(r17));
    }

    private static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException r10, int r11, int r12, String r13, BitmapFactory.Options r14) {
        return new IOException("Exception decoding bitmap, outWidth: " + r11 + ", outHeight: " + r12 + ", outMimeType: " + r13 + ", inBitmap: " + getInBitmapString(r14), r10);
    }

    private static void releaseOptions(BitmapFactory.Options r10) {
        resetOptions(r10);
        Queue<BitmapFactory.Options> r11 = OPTIONS_QUEUE;
        monitor-enter(r11);
        r11.offer(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void resetOptions(BitmapFactory.Options r10) {
        r10.inTempStorage = null;
        r10.inDither = false;
        r10.inScaled = false;
        r10.inSampleSize = 1;
        r10.inPreferredConfig = null;
        r10.inJustDecodeBounds = false;
        r10.inDensity = 0;
        r10.inTargetDensity = 0;
        r10.outWidth = 0;
        r10.outHeight = 0;
        r10.outMimeType = null;
        r10.inBitmap = null;
        r10.inMutable = true;
    }

    private static int round(double r10) {
        return (int) (r10 + 0.5d);
    }

    @TargetApi(26)
    private static void setInBitmap(BitmapFactory.Options r10, BitmapPool r11, int r12, int r13) {
        Bitmap.Config r14 = r10.inPreferredConfig;
        if (r14 != Bitmap.Config.HARDWARE) goto L5;
        return;
    L5:
        Bitmap.Config r15 = r10.outConfig;
        if (r15 == null) goto L9;
        r14 = r15;
    L9:
        r10.inBitmap = r11.getDirty(r12, r13, r14);
    }

    private boolean shouldUsePool(ImageHeaderParser.ImageType r10) {
        return true;
    }

    public Resource<Bitmap> decode(InputStream r10, int r11, int r12, Options r13) throws IOException {
        return decode(r10, r11, r12, r13, EMPTY_CALLBACKS);
    }

    public boolean handles(InputStream r10) {
        return true;
    }

    public Resource<Bitmap> decode(InputStream r15, int r16, int r17, Options r18, DecodeCallbacks r19) throws IOException {
        Preconditions.checkArgument(r15.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] r12 = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        BitmapFactory.Options r13 = getDefaultOptions();
        r13.inTempStorage = r12;
        DecodeFormat r10 = (DecodeFormat) r18.get(DECODE_FORMAT);
        DownsampleStrategy r11 = (DownsampleStrategy) r18.get(DownsampleStrategy.OPTION);
        boolean r14 = ((Boolean) r18.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        Option<Boolean> r20 = ALLOW_HARDWARE_CONFIG;
        if (r18.get(r20) != null) goto L5;
    L8:
        boolean r21 = false;
    L16:
        BitmapResource r22 = BitmapResource.obtain(decodeFromWrappedStreams(r15, r13, r11, r10, r21, r16, r17, r14, r19), this.bitmapPool);     // Catch: Throwable -> L13
        releaseOptions(r13);
        this.byteArrayPool.put(r12);
        return r22;
    L13:
        th = move-exception;
        releaseOptions(r13);
        this.byteArrayPool.put(r12);
        throw th;
    L5:
        if (((Boolean) r18.get(r20)).booleanValue() == false) goto L8;
        r21 = true;
        goto L16
    }

    public boolean handles(ByteBuffer r10) {
        return true;
    }
}
