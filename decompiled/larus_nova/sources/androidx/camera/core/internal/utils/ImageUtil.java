package androidx.camera.core.internal.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.ExifOutputStream;
import androidx.core.util.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import r27.a;

/* JADX INFO: loaded from: classes2.dex */
public final class ImageUtil {
    public static final int DEFAULT_RGBA_PIXEL_STRIDE = 4;
    private static final String TAG = "ImageUtil";

    public static final class CodecFailedException extends Exception {
        private final FailureType mFailureType;

        public static final enum FailureType extends Enum<FailureType> {
            private static final /* synthetic */ FailureType[] $VALUES = null;
            public static final FailureType DECODE_FAILED = null;
            public static final FailureType ENCODE_FAILED = null;
            public static final FailureType UNKNOWN = null;

            private static /* synthetic */ FailureType[] $values() {
                return new FailureType[]{ENCODE_FAILED, DECODE_FAILED, UNKNOWN};
            }

            static {
                ENCODE_FAILED = new FailureType("ENCODE_FAILED", 0);
                DECODE_FAILED = new FailureType("DECODE_FAILED", 1);
                UNKNOWN = new FailureType("UNKNOWN", 2);
                $VALUES = $values();
            }

            public static FailureType[] values() {
                return (FailureType[]) $VALUES.clone();
            }

            public static FailureType valueOf(String r100) {
                return (FailureType) a.a(FailureType.class, r100);
            }

            private FailureType(String r100, int r101) {
                super(r100, r101);
            }
        }

        public FailureType getFailureType() {
            return this.mFailureType;
        }

        public CodecFailedException(String r100) {
            super(r100);
            this.mFailureType = FailureType.UNKNOWN;
        }

        public CodecFailedException(String r100, FailureType r101) {
            super(r100);
            this.mFailureType = r101;
        }
    }

    public static boolean isJpegFormats(int r100) {
        if (r100 != 256) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 4101) goto L8;
        return false;
    }

    public static boolean shouldCropImage(int r100, int r101, int r102, int r103) {
        if (r100 != r102) goto L6;
        if (r101 != r103) goto L6;
        return false;
    L6:
        return true;
    }

    private ImageUtil() {
    }

    public static Bitmap createBitmapFromImageProxy(ImageProxy r100) {
        int r101 = r100.getFormat();
        if (r101 == 1) goto L18;
        if (r101 == 35) goto L16;
        if (r101 == 256) goto L14;
        if (r101 == 4101) goto L14;
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + r100.getFormat() + ", only ImageFormat.YUV_420_888 and PixelFormat.RGBA_8888 are supported");
    L14:
        return createBitmapFromJpegImage(r100);
    L16:
        return ImageProcessingUtil.convertYUVToBitmap(r100);
    L18:
        return createBitmapFromRgbaImage(r100);
    }

    private static Bitmap createBitmapFromJpegImage(ImageProxy r100) {
        byte[] r101 = jpegImageToJpegByteArray(r100);
        Bitmap r102 = BitmapFactory.decodeByteArray(r101, 0, r101.length, null);
        if (r102 == null) goto L6;
        return r102;
    L6:
        throw new UnsupportedOperationException("Decode jpeg byte array failed");
    }

    private static Bitmap createBitmapFromRgbaImage(ImageProxy r100) {
        Bitmap r101 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);
        r100.getPlanes()[0].getBuffer().rewind();
        ImageProcessingUtil.copyByteBufferToBitmap(r101, r100.getPlanes()[0].getBuffer(), r100.getPlanes()[0].getRowStride());
        return r101;
    }

    public static ByteBuffer createDirectByteBuffer(Bitmap r100) {
        if (r100.getConfig() != Bitmap.Config.ARGB_8888) goto L5;
        boolean r101 = true;
    L6:
        Preconditions.checkArgument(r101, "Only accept Bitmap with ARGB_8888 format for now.");
        ByteBuffer r102 = ByteBuffer.allocateDirect(r100.getAllocationByteCount());
        ImageProcessingUtil.copyBitmapToByteBuffer(r100, r102, r100.getRowBytes());
        r102.rewind();
        return r102;
    L5:
        r101 = false;
        goto L6
    }

    private static Rational inverseRational(Rational r100) {
        if (r100 != null) goto L5;
        return r100;
    L5:
        return new Rational(r100.getDenominator(), r100.getNumerator());
    }

    public static boolean isAspectRatioValid(Rational r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.floatValue() <= 0.0f) goto L8;
        if (r100.isNaN() == true) goto L8;
        return true;
    }

    public static byte[] jpegImageToJpegByteArray(ImageProxy r100) {
        if (isJpegFormats(r100.getFormat()) == false) goto L7;
        ByteBuffer r101 = r100.getPlanes()[0].getBuffer();
        byte[] r102 = new byte[r101.capacity()];
        r101.rewind();
        r101.get(r102);
        return r102;
    L7:
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + r100.getFormat());
    }

    public static boolean shouldCropImage(ImageProxy r100) {
        return shouldCropImage(r100.getWidth(), r100.getHeight(), r100.getCropRect().width(), r100.getCropRect().height());
    }

    public static float[] sizeToVertexes(Size r100) {
        return new float[]{0.0f, 0.0f, r100.getWidth(), 0.0f, r100.getWidth(), r100.getHeight(), 0.0f, r100.getHeight()};
    }

    public static byte[] yuv_420_888toNv21(ImageProxy r110) {
        ImageProxy.PlaneProxy r100 = r110.getPlanes()[0];
        ImageProxy.PlaneProxy r101 = r110.getPlanes()[1];
        ImageProxy.PlaneProxy r102 = r110.getPlanes()[2];
        ByteBuffer r103 = r100.getBuffer();
        ByteBuffer r104 = r101.getBuffer();
        ByteBuffer r105 = r102.getBuffer();
        r103.rewind();
        r104.rewind();
        r105.rewind();
        int r106 = r103.remaining();
        byte[] r107 = new byte[((r110.getWidth() * r110.getHeight()) / 2) + r106];
        int r111 = 0;
        int r112 = 0;
    L4:
        if (r111 >= r110.getHeight()) goto L6;
        r103.get(r107, r112, r110.getWidth());
        r112 = r112 + r110.getWidth();
        r103.position(Math.min(r106, (r103.position() - r110.getWidth()) + r100.getRowStride()));
        r111 = r111 + 1;
        goto L4
    L6:
        int r108 = r110.getHeight() / 2;
        int r109 = r110.getWidth() / 2;
        int r113 = r102.getRowStride();
        int r114 = r101.getRowStride();
        int r115 = r102.getPixelStride();
        int r116 = r101.getPixelStride();
        byte[] r117 = new byte[r113];
        byte[] r118 = new byte[r114];
        int r119 = 0;
    L7:
        if (r119 >= r108) goto L12;
        r105.get(r117, 0, Math.min(r113, r105.remaining()));
        r104.get(r118, 0, Math.min(r114, r104.remaining()));
        int r120 = 0;
        int r121 = 0;
        int r122 = 0;
    L9:
        if (r120 >= r109) goto L11;
        int r123 = r112 + 1;
        r107[r112] = r117[r121];
        r112 = r123 + 1;
        r107[r123] = r118[r122];
        r121 = r121 + r115;
        r122 = r122 + r116;
        r120 = r120 + 1;
        goto L9
    L11:
        r119 = r119 + 1;
        goto L7
    L12:
        return r107;
    }

    public static Rect computeCropRectFromAspectRatio(Size r100, Rational r101) {
        if (isAspectRatioValid(r101) == true) goto L6;
        Logger.w(TAG, "Invalid view ratio.");
        return null;
    L6:
        int r102 = r100.getWidth();
        int r103 = r100.getHeight();
        float r104 = r102;
        float r105 = r103;
        float r106 = r104 / r105;
        int r107 = r101.getNumerator();
        int r108 = r101.getDenominator();
        int r109 = 0;
        if (r101.floatValue() <= r106) goto L9;
        int r110 = Math.round((r104 / r107) * r108);
        int r111 = (r103 - r110) / 2;
        r103 = r110;
    L11:
        return new Rect(r109, r111, r102 + r109, r103 + r111);
    L9:
        int r112 = Math.round((r105 / r108) * r107);
        r109 = (r102 - r112) / 2;
        r102 = r112;
        r111 = 0;
        goto L11
    }

    public static Rational getRotatedAspectRatio(int r100, Rational r101) {
        if (r100 == 90) goto L10;
        if (r100 == 270) goto L10;
        return new Rational(r101.getNumerator(), r101.getDenominator());
    L10:
        return inverseRational(r101);
    }

    public static boolean isAspectRatioValid(Size r100, Rational r101) {
        if (r101 != null) goto L4;
    L10:
        return false;
    L4:
        if (r101.floatValue() <= 0.0f) goto L10;
        if (isCropAspectRatioHasEffect(r100, r101) == false) goto L10;
        if (r101.isNaN() == true) goto L10;
        return true;
    }

    private static boolean isCropAspectRatioHasEffect(Size r100, Rational r101) {
        int r102 = r100.getWidth();
        int r103 = r100.getHeight();
        float r104 = r101.getNumerator();
        float r105 = r101.getDenominator();
        if (r103 == Math.round((r102 / r104) * r105)) goto L5;
    L8:
        return true;
    L5:
        if (r102 != Math.round((r103 / r105) * r104)) goto L8;
        return false;
    }

    public static Bitmap rotateBitmap(Bitmap r100, int r101) {
        Matrix r102 = new Matrix();
        r102.postRotate(r101);
        return Bitmap.createBitmap(r100, 0, 0, r100.getWidth(), r100.getHeight(), r102, true);
    }

    public static Bitmap createBitmapFromPlane(ImageProxy.PlaneProxy[] r100, int r101, int r102) {
        boolean r103 = true;
        if (r100.length != 1) goto L5;
        boolean r104 = true;
    L6:
        Preconditions.checkArgument(r104, "Expect a single plane");
        if (r100[0].getPixelStride() != 4) goto L9;
        boolean r105 = true;
    L10:
        Preconditions.checkArgument(r105, "Expect pixelStride=4");
        if (r100[0].getRowStride() == (r101 * 4)) goto L14;
        r103 = false;
    L14:
        Preconditions.checkArgument(r103, "Expect rowStride=width*4");
        Bitmap r106 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);
        r100[0].getBuffer().rewind();
        ImageProcessingUtil.copyByteBufferToBitmap(r106, r100[0].getBuffer(), r100[0].getRowStride());
        return r106;
    L9:
        r105 = false;
        goto L10
    L5:
        r104 = false;
        goto L6
    }

    private static byte[] cropJpegByteArray(byte[] r100, Rect r101, int r102) throws CodecFailedException {
        BitmapRegionDecoder r103 = BitmapRegionDecoder.newInstance(r100, 0, r100.length, false);     // Catch: IOException -> L13 IllegalArgumentException -> L15
        Bitmap r104 = r103.decodeRegion(r101, new BitmapFactory.Options());     // Catch: IOException -> L13 IllegalArgumentException -> L15
        r103.recycle();     // Catch: IOException -> L13 IllegalArgumentException -> L15
        if (r104 == null) goto L12;
        ByteArrayOutputStream r105 = new ByteArrayOutputStream();
        if (r104.compress(Bitmap.CompressFormat.JPEG, r102, r105) == false) goto L10;
        r104.recycle();
        return r105.toByteArray();
    L10:
        throw new CodecFailedException("Encode bitmap failed.", CodecFailedException.FailureType.ENCODE_FAILED);
    L12:
        throw new CodecFailedException("Decode byte array failed.", CodecFailedException.FailureType.DECODE_FAILED);
    L15:
        e = move-exception;
        throw new CodecFailedException("Decode byte array failed with illegal argument." + e, CodecFailedException.FailureType.DECODE_FAILED);
    L14:
        throw new CodecFailedException("Decode byte array failed.", CodecFailedException.FailureType.DECODE_FAILED);
    }

    public static byte[] jpegImageToJpegByteArray(ImageProxy r100, Rect r101, int r102) throws CodecFailedException {
        if (isJpegFormats(r100.getFormat()) == false) goto L7;
        return cropJpegByteArray(jpegImageToJpegByteArray(r100), r101, r102);
    L7:
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + r100.getFormat());
    }

    public static Rect computeCropRectFromDispatchInfo(Rect r100, int r101, Size r102, int r103) {
        Matrix r104 = new Matrix();
        r104.setRotate(r103 - r101);
        float[] r105 = sizeToVertexes(r102);
        r104.mapPoints(r105);
        r104.postTranslate(-min(r105[0], r105[2], r105[4], r105[6]), -min(r105[1], r105[3], r105[5], r105[7]));
        r104.invert(r104);
        RectF r106 = new RectF();
        r104.mapRect(r106, new RectF(r100));
        r106.sort();
        Rect r107 = new Rect();
        r106.round(r107);
        return r107;
    }

    public static float min(float r100, float r101, float r102, float r103) {
        return Math.min(Math.min(r100, r101), Math.min(r102, r103));
    }

    public static byte[] yuvImageToJpegByteArray(ImageProxy r100, Rect r101, int r110, int r111) throws CodecFailedException {
        if (r100.getFormat() != 35) goto L14;
        YuvImage r102 = new YuvImage(yuv_420_888toNv21(r100), 17, r100.getWidth(), r100.getHeight(), null);
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();
        ExifOutputStream r104 = new ExifOutputStream(r103, ExifData.create(r100, r111));
        if (r101 != null) goto L8;
        r101 = new Rect(0, 0, r100.getWidth(), r100.getHeight());
    L8:
        if (r102.compressToJpeg(r101, r110, r104) == false) goto L12;
        return r103.toByteArray();
    L12:
        throw new CodecFailedException("YuvImage failed to encode jpeg.", CodecFailedException.FailureType.ENCODE_FAILED);
    L14:
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + r100.getFormat());
    }
}
