package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.GlideLogUtil;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
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

/* JADX INFO: loaded from: classes39.dex */
public final class Downsampler {
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG = null;
    public static final Option<DecodeFormat> DECODE_FORMAT = null;
    public static final Option<DownsampleStrategy> DOWNSAMPLE_STRATEGY = null;
    private static final DecodeCallbacks EMPTY_CALLBACKS = null;
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = null;
    private static final String ICO_MIME_TYPE = "image/x-ico";
    private static final Set<String> NO_DOWNSAMPLE_PRE_N_MIME_TYPES = null;
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE = null;
    public static final Option<PreferredColorSpace> PREFERRED_COLOR_SPACE = null;
    static final String TAG = "Downsampler";
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL_PRE_KITKAT = null;
    private static final String WBMP_MIME_TYPE = "image/vnd.wap.wbmp";
    private final BitmapPool bitmapPool;
    private final ArrayPool byteArrayPool;
    private final DisplayMetrics displayMetrics;
    private final HardwareConfigState hardwareConfigState;
    private final List<ImageHeaderParser> parsers;

    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool r100, Bitmap r101) throws IOException;

        void onObtainBounds();
    }

    private static boolean isRotationRequired(int r100) {
        if (r100 != 90) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 270) goto L8;
        return false;
    }

    private static int round(double r100) {
        return (int) (r100 + 0.5d);
    }

    private boolean shouldUsePool(ImageHeaderParser.ImageType r100) {
        return true;
    }

    public boolean handles(InputStream r100) {
        return true;
    }

    public boolean handles(ByteBuffer r100) {
        return true;
    }

    static {
        DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
        PREFERRED_COLOR_SPACE = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);
        DOWNSAMPLE_STRATEGY = DownsampleStrategy.OPTION;
        Boolean r100 = Boolean.FALSE;
        FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", r100);
        ALLOW_HARDWARE_CONFIG = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", r100);
        NO_DOWNSAMPLE_PRE_N_MIME_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{WBMP_MIME_TYPE, ICO_MIME_TYPE})));
        EMPTY_CALLBACKS = new AnonymousClass1();
        TYPES_THAT_USE_POOL_PRE_KITKAT = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        OPTIONS_QUEUE = Util.createQueue(0);
    }

    private static synchronized BitmapFactory.Options getDefaultOptions() {
        monitor-enter(Downsampler.class);
        Queue<BitmapFactory.Options> r100 = OPTIONS_QUEUE;     // Catch: Throwable -> L15
        monitor-enter(r100);     // Catch: Throwable -> L15
        BitmapFactory.Options r101 = r100.poll();     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        if (r101 != null) goto L10;
        r101 = new BitmapFactory.Options();     // Catch: Throwable -> L15
        resetOptions(r101);     // Catch: Throwable -> L15
    L10:
        monitor-exit(Downsampler.class);
        return r101;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private static int adjustTargetDensityForError(double r100) {
        int r101 = getDensityMultiplier(r100);
        int r102 = round(((double) r101) * r100);
        return round((r100 / ((double) (r102 / r101))) * ((double) r102));
    }

    private static String getBitmapString(Bitmap r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return "[" + r100.getWidth() + "x" + r100.getHeight() + "] " + r100.getConfig() + (" (" + r100.getAllocationByteCount() + ")");
    }

    private static int getDensityMultiplier(double r100) {
        if (r100 <= 1.0d) goto L7;
        r100 = 1.0d / r100;
    L7:
        return (int) Math.round(r100 * 2.147483647E9d);
    }

    private static String getInBitmapString(BitmapFactory.Options r100) {
        return getBitmapString(r100.inBitmap);
    }

    private static boolean isScaling(BitmapFactory.Options r100) {
        int r101 = r100.inTargetDensity;
        if (r101 <= 0) goto L8;
        int r102 = r100.inDensity;
        if (r102 <= 0) goto L8;
        if (r101 == r102) goto L8;
        return true;
    L8:
        return false;
    }

    private static void releaseOptions(BitmapFactory.Options r100) {
        resetOptions(r100);
        Queue<BitmapFactory.Options> r101 = OPTIONS_QUEUE;
        monitor-enter(r101);
        r101.offer(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void resetOptions(BitmapFactory.Options r100) {
        r100.inTempStorage = null;
        r100.inDither = false;
        r100.inScaled = false;
        r100.inSampleSize = 1;
        r100.inPreferredConfig = null;
        r100.inJustDecodeBounds = false;
        r100.inDensity = 0;
        r100.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT < 26) goto L5;
        r100.inPreferredColorSpace = null;
        r100.outColorSpace = null;
        r100.outConfig = null;
    L5:
        r100.outWidth = 0;
        r100.outHeight = 0;
        r100.outMimeType = null;
        r100.inBitmap = null;
        r100.inMutable = true;
    }

    public boolean handles(ParcelFileDescriptor r100) {
        return ParcelFileDescriptorRewinder.isSupported();
    }

    public Downsampler(List<ImageHeaderParser> r100, DisplayMetrics r101, BitmapPool r102, ArrayPool r103) {
        this.hardwareConfigState = HardwareConfigState.getInstance();
        this.parsers = r100;
        this.displayMetrics = (DisplayMetrics) Preconditions.checkNotNull(r101);
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(r102);
        this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(r103);
    }

    private static Bitmap decodeStream(ImageReader r100, BitmapFactory.Options r101, DecodeCallbacks r102, BitmapPool r103) throws IOException {
        if (r101.inJustDecodeBounds == true) goto L5;
        r102.onObtainBounds();
        r100.stopGrowingBuffers();
    L5:
        int r104 = r101.outWidth;
        int r105 = r101.outHeight;
        String r106 = r101.outMimeType;
        TransformationUtils.getBitmapDrawableLock().lock();
        Bitmap r107 = r100.decodeBitmap(r101);     // Catch: Throwable -> L9 IllegalArgumentException -> L11
        TransformationUtils.getBitmapDrawableLock().unlock();
        return r107;
    L11:
        e = move-exception;
        IOException r108 = newIoExceptionForInBitmapAssertion(e, r104, r105, r106, r101);     // Catch: Throwable -> L9
        GlideLogUtil.e(TAG, "Failed to decode with inBitmap, trying again without Bitmap re-use", r108);     // Catch: Throwable -> L9
        if (r101.inBitmap != null) goto L21;
        throw r108;     // Catch: Throwable -> L9
    L21:
        r103.put(r101.inBitmap);     // Catch: Throwable -> L9 IOException -> L17
        r101.inBitmap = null;     // Catch: Throwable -> L9 IOException -> L17
        Bitmap r109 = decodeStream(r100, r101, r102, r103);     // Catch: Throwable -> L9 IOException -> L17
        TransformationUtils.getBitmapDrawableLock().unlock();
        return r109;
    L25:
        throw r108;     // Catch: Throwable -> L9
    L17:
        throw r108;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        TransformationUtils.getBitmapDrawableLock().unlock();
        throw th;
    }

    private static int[] getDimensions(ImageReader r100, BitmapFactory.Options r101, DecodeCallbacks r102, BitmapPool r103) throws IOException {
        r101.inJustDecodeBounds = true;
        decodeStream(r100, r101, r102, r103);
        r101.inJustDecodeBounds = false;
        return new int[]{r101.outWidth, r101.outHeight};
    }

    private static void setInBitmap(BitmapFactory.Options r100, BitmapPool r101, int r102, int r103) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        Bitmap.Config r104 = null;
    L9:
        if (r104 != null) goto L11;
        r104 = r100.inPreferredConfig;
    L11:
        r100.inBitmap = r101.getDirty(r102, r103, r104);
        return;
    L5:
        if (r100.inPreferredConfig != Bitmap.Config.HARDWARE) goto L7;
        return;
    L7:
        r104 = r100.outConfig;
        goto L9
    }

    public Resource<Bitmap> decode(ParcelFileDescriptor r100, int r101, int r102, Options r110) throws IOException {
        return decode(new ImageReader.ParcelFileDescriptorImageReader(r100, this.parsers, this.byteArrayPool), r101, r102, r110, EMPTY_CALLBACKS);
    }

    public Resource<Bitmap> decode(InputStream r100, int r101, int r102, Options r110) throws IOException {
        return decode(r100, r101, r102, r110, EMPTY_CALLBACKS);
    }

    private Resource<Bitmap> decode(ImageReader r110, int r111, int r112, Options r113, DecodeCallbacks r210) throws IOException {
        byte[] r114 = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        BitmapFactory.Options r115 = getDefaultOptions();
        r115.inTempStorage = r114;
        DecodeFormat r100 = (DecodeFormat) r113.get(DECODE_FORMAT);
        PreferredColorSpace r101 = (PreferredColorSpace) r113.get(PREFERRED_COLOR_SPACE);
        DownsampleStrategy r102 = (DownsampleStrategy) r113.get(DownsampleStrategy.OPTION);
        boolean r116 = ((Boolean) r113.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        Option<Boolean> r103 = ALLOW_HARDWARE_CONFIG;
        if (r113.get(r103) != null) goto L5;
    L7:
        boolean r104 = false;
    L15:
        BitmapResource r105 = BitmapResource.obtain(decodeFromWrappedStreams(r110, r115, r102, r100, r101, r104, r111, r112, r116, r210), this.bitmapPool);     // Catch: Throwable -> L12
        releaseOptions(r115);
        this.byteArrayPool.put(r114);
        return r105;
    L12:
        th = move-exception;
        releaseOptions(r115);
        this.byteArrayPool.put(r114);
        throw th;
    L5:
        if (((Boolean) r113.get(r103)).booleanValue() == false) goto L7;
        r104 = true;
        goto L15
    }

    private static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException r100, int r101, int r102, String r103, BitmapFactory.Options r104) {
        return new IOException("Exception decoding bitmap, outWidth: " + r101 + ", outHeight: " + r102 + ", outMimeType: " + r103 + ", inBitmap: " + getInBitmapString(r104), r100);
    }

    public Resource<Bitmap> decode(InputStream r100, int r101, int r102, Options r110, DecodeCallbacks r111) throws IOException {
        return decode(new ImageReader.InputStreamImageReader(r100, this.parsers, this.byteArrayPool), r101, r102, r110, r111);
    }

    private void calculateConfig(ImageReader r100, DecodeFormat r101, boolean r102, boolean r110, BitmapFactory.Options r111, int r112, int r113) {
        if (this.hardwareConfigState.setHardwareConfigIfAllowed(r112, r113, r111, r102, r110) == false) goto L6;
        return;
    L6:
        if (r101 != DecodeFormat.PREFER_ARGB_8888) goto L20;
        r111.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return;
    L20:
        boolean r103 = r100.getImageType().hasAlpha();     // Catch: IOException -> L9
    L11:
        if (r103 == false) goto L13;
        Bitmap.Config r104 = Bitmap.Config.ARGB_8888;
    L14:
        r111.inPreferredConfig = r104;
        if (r104 != Bitmap.Config.RGB_565) goto L22;
        r111.inDither = true;
        return;
    L22:
        return;
    L13:
        r104 = Bitmap.Config.RGB_565;
    L9:
        e = move-exception;
        GlideLogUtil.e(TAG, "Cannot determine whether the image has alpha or not from header, format " + r101, e);
        r103 = false;
        goto L11
    }

    private static void logDecode(int r100, int r101, String r102, BitmapFactory.Options r103, Bitmap r104, int r105, int r106, long r107) {
        GlideLogUtil.v(TAG, "Decoded " + getBitmapString(r104) + " from [" + r100 + "x" + r101 + "] " + r102 + " with inBitmap " + getInBitmapString(r103) + " for [" + r105 + "x" + r106 + "], sample size: " + r103.inSampleSize + ", density: " + r103.inDensity + ", target density: " + r103.inTargetDensity + ", thread: " + ThreadMethodProxy.currentThread().getName() + ", duration: " + LogTime.getElapsedMillis(r107));
    }

    private Bitmap decodeFromWrappedStreams(ImageReader r210, BitmapFactory.Options r310, DownsampleStrategy r311, DecodeFormat r312, PreferredColorSpace r313, boolean r314, int r315, int r316, boolean r317, DecodeCallbacks r318) throws IOException {
        long r211 = LogTime.getLogTime();
        int[] r100 = getDimensions(r210, r310, r318, this.bitmapPool);
        boolean r212 = false;
        int r101 = r100[0];
        int r102 = r100[1];
        String r103 = r310.outMimeType;
        if (r101 == (-1)) goto L7;
        if (r102 == (-1)) goto L7;
        boolean r213 = r314;
    L8:
        int r104 = r210.getImageOrientation();
        int r110 = TransformationUtils.getExifOrientationDegrees(r104);
        boolean r214 = TransformationUtils.isExifOrientationRequired(r104);
        if (r315 != Integer.MIN_VALUE) goto L14;
        int r111 = r316;
        if (isRotationRequired(r110) == false) goto L13;
        int r215 = r102;
    L15:
        if (r111 == Integer.MIN_VALUE) goto L17;
        int r216 = r111;
    L21:
        ImageHeaderParser.ImageType r112 = r210.getImageType();
        calculateScaling(r112, r210, r318, this.bitmapPool, r311, r110, r101, r102, r215, r216, r310);
        calculateConfig(r210, r312, r213, r214, r310, r215, r216);
        int r105 = Build.VERSION.SDK_INT;
        int r106 = r310.inSampleSize;
        if (shouldUsePool(r112) == false) goto L36;
        if (r101 < 0) goto L28;
        if (r102 < 0) goto L28;
        if (r317 == false) goto L28;
        int r107 = r215;
        int r108 = r216;
    L32:
        if (r107 <= 0) goto L36;
        if (r108 <= 0) goto L36;
        setInBitmap(r310, this.bitmapPool, r107, r108);
    L28:
        if (isScaling(r310) == false) goto L30;
        float r109 = r310.inTargetDensity / r310.inDensity;
    L31:
        int r113 = r310.inSampleSize;
        float r114 = r101;
        float r115 = r113;
        int r116 = (int) Math.ceil(r114 / r115);
        int r117 = (int) Math.ceil(r102 / r115);
        r107 = Math.round(r116 * r109);
        r108 = Math.round(r117 * r109);
        GlideLogUtil.v(TAG, "Calculated target [" + r107 + "x" + r108 + "] for source [" + r101 + "x" + r102 + "], sampleSize: " + r113 + ", targetDensity: " + r310.inTargetDensity + ", density: " + r310.inDensity + ", density multiplier: " + r109);
        goto L32
    L30:
        r109 = 1.0f;
    L36:
        if (r105 < 28) goto L49;
        if (r313 != PreferredColorSpace.DISPLAY_P3) goto L44;
        ColorSpace r118 = r310.outColorSpace;
        if (r118 == null) goto L44;
        if (r118.isWideGamut() == false) goto L44;
        r212 = true;
    L44:
        if (r212 == false) goto L46;
        ColorSpace.Named r119 = ColorSpace.Named.DISPLAY_P3;
    L47:
        r310.inPreferredColorSpace = ColorSpace.get(r119);
    L51:
        Bitmap r120 = decodeStream(r210, r310, r318, this.bitmapPool);
        r318.onDecodeComplete(this.bitmapPool, r120);
        logDecode(r101, r102, r103, r310, r120, r315, r316, r211);
        if (r120 == null) goto L56;
        r120.setDensity(this.displayMetrics.densityDpi);
        Bitmap r121 = TransformationUtils.rotateImageExif(this.bitmapPool, r120, r104);
        if (r120.equals(r121) == true) goto L58;
        this.bitmapPool.put(r120);
        return r121;
    L58:
        return r121;
    L56:
        return null;
    L46:
        r119 = ColorSpace.Named.SRGB;
        goto L47
    L49:
        if (r105 < 26) goto L51;
        r310.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        goto L51
    L17:
        if (isRotationRequired(r110) == false) goto L19;
        r216 = r101;
        goto L21
    L19:
        r216 = r102;
        goto L21
    L13:
        r215 = r101;
        goto L15
    L14:
        r111 = r316;
        r215 = r315;
    L7:
        r213 = false;
        goto L8
    }

    private static void calculateScaling(ImageHeaderParser.ImageType r110, ImageReader r111, DecodeCallbacks r210, BitmapPool r211, DownsampleStrategy r212, int r213, int r214, int r215, int r216, int r217, BitmapFactory.Options r218) throws IOException {
        if (r214 <= 0) goto L67;
        if (r215 <= 0) goto L67;
        if (isRotationRequired(r213) == false) goto L9;
        int r112 = r214;
        int r113 = r215;
    L10:
        float r114 = r212.getScaleFactor(r113, r112, r216, r217);
        if (r114 <= 0.0f) goto L66;
        DownsampleStrategy.SampleSizeRounding r100 = r212.getSampleSizeRounding(r113, r112, r216, r217);
        if (r100 == null) goto L64;
        float r115 = r113;
        float r116 = r112;
        int r101 = r113 / round(r114 * r115);
        int r102 = r112 / round(r114 * r116);
        DownsampleStrategy.SampleSizeRounding r117 = DownsampleStrategy.SampleSizeRounding.MEMORY;
        if (r100 != r117) goto L17;
        int r103 = Math.max(r101, r102);
    L18:
        int r104 = Build.VERSION.SDK_INT;
        if (r104 <= 23) goto L21;
    L23:
        int r105 = Math.max(1, Integer.highestOneBit(r103));
        if (r100 == r117) goto L26;
    L28:
        int r106 = r105;
    L29:
        r218.inSampleSize = r106;
        if (r110 != ImageHeaderParser.ImageType.JPEG) goto L35;
        float r107 = Math.min(r106, 8);
        int r108 = (int) Math.ceil(r115 / r107);
        int r109 = (int) Math.ceil(r116 / r107);
        int r118 = r106 / 8;
        if (r118 <= 0) goto L57;
        r108 = r108 / r118;
        r109 = r109 / r118;
    L57:
        double r119 = r212.getScaleFactor(r108, r109, r216, r217);
        r218.inTargetDensity = adjustTargetDensityForError(r119);
        r218.inDensity = getDensityMultiplier(r119);
        if (isScaling(r218) == false) goto L60;
        r218.inScaled = true;
    L61:
        GlideLogUtil.v(TAG, "Calculate scaling, source: [" + r214 + "x" + r215 + "], degreesToRotate: " + r213 + ", target: [" + r216 + "x" + r217 + "], power of two scaled: [" + r108 + "x" + r109 + "], exact scale factor: " + r114 + ", power of 2 sample size: " + r106 + ", adjusted scale factor: " + r119 + ", target density: " + r218.inTargetDensity + ", density: " + r218.inDensity);
        return;
    L60:
        r218.inTargetDensity = 0;
        r218.inDensity = 0;
        goto L61
    L35:
        if (r110 != ImageHeaderParser.ImageType.PNG) goto L37;
    L55:
        float r120 = r106;
        r108 = (int) Math.floor(r115 / r120);
        double r121 = Math.floor(r116 / r120);
    L56:
        r109 = (int) r121;
        goto L57
    L37:
        if (r110 == ImageHeaderParser.ImageType.PNG_A) goto L55;
        if (r110 == ImageHeaderParser.ImageType.WEBP) goto L52;
        if (r110 == ImageHeaderParser.ImageType.WEBP_A) goto L52;
        if ((r113 % r106) == 0) goto L47;
    L50:
        int[] r122 = getDimensions(r111, r218, r210, r211);
        r108 = r122[0];
        r109 = r122[1];
        goto L57
    L47:
        if ((r112 % r106) != 0) goto L50;
        r108 = r113 / r106;
        r109 = r112 / r106;
    L52:
        if (r104 < 24) goto L54;
        float r123 = r106;
        r108 = Math.round(r115 / r123);
        r109 = Math.round(r116 / r123);
        goto L57
    L54:
        float r124 = r106;
        r108 = (int) Math.floor(r115 / r124);
        r121 = Math.floor(r116 / r124);
        goto L56
    L26:
        if (r105 >= (1.0f / r114)) goto L28;
        r105 = r105 << 1;
        goto L28
    L21:
        if (NO_DOWNSAMPLE_PRE_N_MIME_TYPES.contains(r218.outMimeType) == false) goto L23;
        r106 = 1;
        goto L29
    L17:
        r103 = Math.min(r101, r102);
        goto L18
    L64:
        throw new IllegalArgumentException("Cannot round with null rounding");
    L66:
        throw new IllegalArgumentException("Cannot scale with factor: " + r114 + " from: " + r212 + ", source: [" + r214 + "x" + r215 + "], target: [" + r216 + "x" + r217 + "]");
    L9:
        r113 = r214;
        r112 = r215;
    L67:
        GlideLogUtil.d(TAG, "Unable to determine dimensions for: " + r110 + " with target [" + r216 + "x" + r217 + "]");
    }
}
