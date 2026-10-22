package androidx.camera.core;

import android.graphics.Bitmap;
import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;
import com.larus.utils.logger.FLogger;
import java.nio.ByteBuffer;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ImageProcessingUtil {
    private static final String TAG = "ImageProcessingUtil";
    private static int sImageCount;

    public static final enum Result extends Enum<Result> {
        private static final /* synthetic */ Result[] $VALUES = null;
        public static final Result ERROR_CONVERSION = null;
        public static final Result SUCCESS = null;
        public static final Result UNKNOWN = null;

        private static /* synthetic */ Result[] $values() {
            return new Result[]{UNKNOWN, SUCCESS, ERROR_CONVERSION};
        }

        static {
            UNKNOWN = new Result("UNKNOWN", 0);
            SUCCESS = new Result("SUCCESS", 1);
            ERROR_CONVERSION = new Result("ERROR_CONVERSION", 2);
            $VALUES = $values();
        }

        public static Result[] values() {
            return (Result[]) $VALUES.clone();
        }

        public static Result valueOf(String r100) {
            return (Result) r27.a.a(Result.class, r100);
        }

        private Result(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ void a(ImageProxy r100, ImageProxy r101, ImageProxy r102) {
        lambda$rotateYUV$1(r100, r101, r102);
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static /* synthetic */ void b(ImageProxy r100, ImageProxy r101, ImageProxy r102) {
        lambda$convertYUVToRGB$0(r100, r101, r102);
    }

    private static boolean isSupportedRotationDegrees(int r100) {
        if (r100 != 0) goto L4;
    L11:
        return true;
    L4:
        if (r100 == 90) goto L11;
        if (r100 == 180) goto L11;
        if (r100 == 270) goto L11;
        return false;
    }

    private static native int nativeConvertAndroid420ToABGR(ByteBuffer r100, int r101, ByteBuffer r102, int r103, ByteBuffer r104, int r105, int r106, int r107, Surface r108, ByteBuffer r109, int r110, int r111, int r112, int r113, int r114, int r115);

    private static native int nativeConvertAndroid420ToBitmap(ByteBuffer r100, int r101, ByteBuffer r102, int r103, ByteBuffer r104, int r105, int r106, int r107, Bitmap r108, int r109, int r110, int r111);

    private static native int nativeCopyBetweenByteBufferAndBitmap(Bitmap r100, ByteBuffer r101, int r102, int r103, int r104, int r105, boolean r106);

    private static native int nativeRotateYUV(ByteBuffer r100, int r101, ByteBuffer r102, int r103, ByteBuffer r104, int r105, int r106, ByteBuffer r107, int r108, int r109, ByteBuffer r110, int r111, int r112, ByteBuffer r113, int r114, int r115, ByteBuffer r116, ByteBuffer r117, ByteBuffer r118, int r119, int r210, int r211);

    private static native int nativeShiftPixel(ByteBuffer r100, int r101, ByteBuffer r102, int r103, ByteBuffer r104, int r105, int r106, int r107, int r108, int r109, int r110, int r111, int r112);

    private static native int nativeWriteJpegToSurface(byte[] r100, Surface r101);

    static {
        INVOKESTATIC_androidx_camera_core_ImageProcessingUtil_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("image_processing_util_jni");
    }

    private ImageProcessingUtil() {
    }

    @JvmStatic
    public static void INVOKESTATIC_androidx_camera_core_ImageProcessingUtil_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static boolean applyPixelShiftForYUV(ImageProxy r100) {
        if (isSupportedYUVFormat(r100) == true) goto L7;
        Logger.e(TAG, "Unsupported format for YUV to RGB");
        return false;
    L7:
        if (applyPixelShiftInternal(r100) != Result.ERROR_CONVERSION) goto L10;
        Logger.e(TAG, "One pixel shift for YUV failure");
        return false;
    L10:
        return true;
    }

    private static Result applyPixelShiftInternal(ImageProxy r110) {
        int r100 = r110.getWidth();
        int r101 = r110.getHeight();
        int r102 = r110.getPlanes()[0].getRowStride();
        int r103 = r110.getPlanes()[1].getRowStride();
        int r104 = r110.getPlanes()[2].getRowStride();
        int r111 = r110.getPlanes()[0].getPixelStride();
        int r112 = r110.getPlanes()[1].getPixelStride();
        if (nativeShiftPixel(r110.getPlanes()[0].getBuffer(), r102, r110.getPlanes()[1].getBuffer(), r103, r110.getPlanes()[2].getBuffer(), r104, r111, r112, r100, r101, r111, r112, r112) == 0) goto L7;
        return Result.ERROR_CONVERSION;
    L7:
        return Result.SUCCESS;
    }

    public static Bitmap convertYUVToBitmap(ImageProxy r110) {
        if (r110.getFormat() != 35) goto L10;
        int r111 = r110.getWidth();
        int r112 = r110.getHeight();
        int r100 = r110.getPlanes()[0].getRowStride();
        int r101 = r110.getPlanes()[1].getRowStride();
        int r102 = r110.getPlanes()[2].getRowStride();
        int r103 = r110.getPlanes()[0].getPixelStride();
        int r104 = r110.getPlanes()[1].getPixelStride();
        Bitmap r105 = Bitmap.createBitmap(r110.getWidth(), r110.getHeight(), Bitmap.Config.ARGB_8888);
        int r113 = r105.getRowBytes();
        if (nativeConvertAndroid420ToBitmap(r110.getPlanes()[0].getBuffer(), r100, r110.getPlanes()[1].getBuffer(), r101, r110.getPlanes()[2].getBuffer(), r102, r103, r104, r105, r113, r111, r112) != 0) goto L8;
        return r105;
    L8:
        throw new UnsupportedOperationException("YUV to RGB conversion failed");
    L10:
        throw new IllegalArgumentException("Input image format must be YUV_420_888");
    }

    private static boolean isSupportedYUVFormat(ImageProxy r100) {
        if (r100.getFormat() == 35) goto L5;
    L7:
        return false;
    L5:
        if (r100.getPlanes().length != 3) goto L7;
        return true;
    }

    public static ImageProxy convertJpegBytesToImage(ImageReaderProxy r100, byte[] r101) {
        if (r100.getImageFormat() != 256) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkArgument(r102);
        Preconditions.checkNotNull(r101);
        Surface r103 = r100.getSurface();
        Preconditions.checkNotNull(r103);
        if (nativeWriteJpegToSurface(r101, r103) == 0) goto L10;
        Logger.e(TAG, "Failed to enqueue JPEG image.");
        return null;
    L10:
        ImageProxy r104 = r100.acquireLatestImage();
        if (r104 != null) goto L13;
        Logger.e(TAG, "Failed to get acquire JPEG image.");
    L13:
        return r104;
    L5:
        r102 = false;
        goto L6
    }

    public static boolean writeJpegBytesToSurface(Surface r100, byte[] r101) {
        Preconditions.checkNotNull(r101);
        Preconditions.checkNotNull(r100);
        if (nativeWriteJpegToSurface(r101, r100) == 0) goto L6;
        Logger.e(TAG, "Failed to enqueue JPEG image.");
        return false;
    L6:
        return true;
    }

    public static void copyBitmapToByteBuffer(Bitmap r100, ByteBuffer r101, int r102) {
        nativeCopyBetweenByteBufferAndBitmap(r100, r101, r100.getRowBytes(), r102, r100.getWidth(), r100.getHeight(), false);
    }

    public static void copyByteBufferToBitmap(Bitmap r100, ByteBuffer r101, int r102) {
        nativeCopyBetweenByteBufferAndBitmap(r100, r101, r102, r100.getRowBytes(), r100.getWidth(), r100.getHeight(), true);
    }

    private static /* synthetic */ void lambda$convertYUVToRGB$0(ImageProxy r100, ImageProxy r101, ImageProxy r102) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        r101.close();
        return;
    L7:
        return;
    }

    private static /* synthetic */ void lambda$rotateYUV$1(ImageProxy r100, ImageProxy r101, ImageProxy r102) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        r101.close();
        return;
    L7:
        return;
    }

    public static boolean convertYuvToJpegBytesIntoSurface(ImageProxy r100, int r101, int r102, Surface r103) {
        return writeJpegBytesToSurface(r103, ImageUtil.yuvImageToJpegByteArray(r100, null, r101, r102));
    L5:
        e = move-exception;
        Logger.e(TAG, "Failed to encode YUV to JPEG", e);
        return false;
    }

    public static boolean convertYuvToJpegBytesIntoSurface(Image r100, int r101, int r102, Surface r103) {
        return convertYuvToJpegBytesIntoSurface(new AndroidImageProxy(r100), r101, r102, r103);
    }

    public static ImageProxy convertYUVToRGB(final ImageProxy r100, ImageReaderProxy r101, ByteBuffer r102, int r110, boolean r111) {
        if (isSupportedYUVFormat(r100) == true) goto L6;
        Logger.e(TAG, "Unsupported format for YUV to RGB");
        return null;
    L6:
        long r103 = System.currentTimeMillis();
        if (isSupportedRotationDegrees(r110) == true) goto L11;
        Logger.e(TAG, "Unsupported rotation degrees for rotate RGB");
        return null;
    L11:
        if (convertYUVToRGBInternal(r100, r101.getSurface(), r102, r110, r111) != Result.ERROR_CONVERSION) goto L15;
        Logger.e(TAG, "YUV to RGB conversion failure");
        return null;
    L15:
        if (Log.isLoggable("MH", 3) == false) goto L17;
        Logger.d(TAG, String.format(Locale.US, "Image processing performance profiling, duration: [%d], image count: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - r103), Integer.valueOf(sImageCount)}));
        sImageCount++;
    L17:
        final ImageProxy r104 = r101.acquireLatestImage();
        if (r104 != null) goto L21;
        Logger.e(TAG, "YUV to RGB acquireLatestImage failure");
        return null;
    L21:
        SingleCloseImageProxy r105 = new SingleCloseImageProxy(r104);
        r105.addOnImageCloseListener(new v(r104, r100));
        return r105;
    }

    private static Result convertYUVToRGBInternal(ImageProxy r110, Surface r111, ByteBuffer r112, int r113, boolean r210) {
        int r114 = r110.getWidth();
        int r115 = r110.getHeight();
        int r100 = r110.getPlanes()[0].getRowStride();
        int r101 = r110.getPlanes()[1].getRowStride();
        int r102 = r110.getPlanes()[2].getRowStride();
        int r103 = r110.getPlanes()[0].getPixelStride();
        int r104 = r110.getPlanes()[1].getPixelStride();
        if (r210 == false) goto L5;
        int r116 = r103;
    L6:
        if (r210 == false) goto L8;
        int r117 = r104;
    L9:
        if (r210 == false) goto L11;
        int r118 = r104;
    L13:
        if (nativeConvertAndroid420ToABGR(r110.getPlanes()[0].getBuffer(), r100, r110.getPlanes()[1].getBuffer(), r101, r110.getPlanes()[2].getBuffer(), r102, r103, r104, r111, r112, r114, r115, r116, r117, r118, r113) == 0) goto L17;
        return Result.ERROR_CONVERSION;
    L17:
        return Result.SUCCESS;
    L11:
        r118 = 0;
        goto L13
    L8:
        r117 = 0;
        goto L9
    L5:
        r116 = 0;
        goto L6
    }

    private static Result rotateYUVInternal(ImageProxy r210, ImageWriter r211, ByteBuffer r212, ByteBuffer r213, ByteBuffer r214, int r215) {
        int r110 = r210.getWidth();
        int r216 = r210.getHeight();
        int r100 = r210.getPlanes()[0].getRowStride();
        int r101 = r210.getPlanes()[1].getRowStride();
        int r111 = r210.getPlanes()[2].getRowStride();
        int r112 = r210.getPlanes()[1].getPixelStride();
        Image r113 = ImageWriterCompat.dequeueInputImage(r211);
        if (r113 != null) goto L7;
        return Result.ERROR_CONVERSION;
    L7:
        if (nativeRotateYUV(r210.getPlanes()[0].getBuffer(), r100, r210.getPlanes()[1].getBuffer(), r101, r210.getPlanes()[2].getBuffer(), r111, r112, r113.getPlanes()[0].getBuffer(), r113.getPlanes()[0].getRowStride(), r113.getPlanes()[0].getPixelStride(), r113.getPlanes()[1].getBuffer(), r113.getPlanes()[1].getRowStride(), r113.getPlanes()[1].getPixelStride(), r113.getPlanes()[2].getBuffer(), r113.getPlanes()[2].getRowStride(), r113.getPlanes()[2].getPixelStride(), r212, r213, r214, r110, r216, r215) != 0) goto L9;
        ImageWriterCompat.queueInputImage(r211, r113);
        return Result.SUCCESS;
    L9:
        return Result.ERROR_CONVERSION;
    }

    public static ImageProxy rotateYUV(final ImageProxy r100, ImageReaderProxy r110, ImageWriter r111, ByteBuffer r112, ByteBuffer r113, ByteBuffer r114, int r115) {
        if (isSupportedYUVFormat(r100) == true) goto L7;
        Logger.e(TAG, "Unsupported format for rotate YUV");
        return null;
    L7:
        if (isSupportedRotationDegrees(r115) == true) goto L10;
        Logger.e(TAG, "Unsupported rotation degrees for rotate YUV");
        return null;
    L10:
        Result r101 = Result.ERROR_CONVERSION;
        if (Build.VERSION.SDK_INT < 23) goto L14;
        if (r115 <= 0) goto L14;
        Result r116 = rotateYUVInternal(r100, r111, r112, r113, r114, r115);
    L15:
        if (r116 != r101) goto L18;
        Logger.e(TAG, "rotate YUV failure");
        return null;
    L18:
        final ImageProxy r117 = r110.acquireLatestImage();
        if (r117 != null) goto L22;
        Logger.e(TAG, "YUV rotation acquireLatestImage failure");
        return null;
    L22:
        SingleCloseImageProxy r118 = new SingleCloseImageProxy(r117);
        r118.addOnImageCloseListener(new w(r117, r100));
        return r118;
    L14:
        r116 = r101;
        goto L15
    }
}
