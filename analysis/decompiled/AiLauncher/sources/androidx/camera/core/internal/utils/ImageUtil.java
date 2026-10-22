package androidx.camera.core.internal.utils;

import B0.h;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.Rational;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.i;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.a;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class ImageUtil {

    public static final class CodecFailedException extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public final FailureType f11602a;

        public enum FailureType {
            ENCODE_FAILED,
            DECODE_FAILED,
            UNKNOWN
        }

        public CodecFailedException(String str, FailureType failureType) {
            super(str);
            this.f11602a = failureType;
        }
    }

    public static Bitmap a(i iVar) {
        int format = iVar.getFormat();
        if (format == 1) {
            return d(iVar);
        }
        if (format == 35) {
            return ImageProcessingUtil.f(iVar);
        }
        if (format == 256 || format == 4101) {
            return b(iVar);
        }
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + iVar.getFormat() + ", only ImageFormat.YUV_420_888 and PixelFormat.RGBA_8888 are supported");
    }

    public static Bitmap b(i iVar) {
        byte[] bArrJ = j(iVar);
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrJ, 0, bArrJ.length, null);
        if (bitmapDecodeByteArray != null) {
            return bitmapDecodeByteArray;
        }
        throw new UnsupportedOperationException("Decode jpeg byte array failed");
    }

    public static Bitmap c(i.a[] aVarArr, int i10, int i11) {
        h.b(aVarArr.length == 1, "Expect a single plane");
        h.b(aVarArr[0].c() == 4, "Expect pixelStride=4");
        h.b(aVarArr[0].b() == i10 * 4, "Expect rowStride=width*4");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        aVarArr[0].a().rewind();
        ImageProcessingUtil.j(bitmapCreateBitmap, aVarArr[0].a(), aVarArr[0].b());
        return bitmapCreateBitmap;
    }

    public static Bitmap d(i iVar) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iVar.getWidth(), iVar.getHeight(), Bitmap.Config.ARGB_8888);
        iVar.w0()[0].a().rewind();
        ImageProcessingUtil.j(bitmapCreateBitmap, iVar.w0()[0].a(), iVar.w0()[0].b());
        return bitmapCreateBitmap;
    }

    public static ByteBuffer e(Bitmap bitmap) {
        h.b(bitmap.getConfig() == Bitmap.Config.ARGB_8888, "Only accept Bitmap with ARGB_8888 format for now.");
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bitmap.getAllocationByteCount());
        ImageProcessingUtil.i(bitmap, byteBufferAllocateDirect, bitmap.getRowBytes());
        byteBufferAllocateDirect.rewind();
        return byteBufferAllocateDirect;
    }

    public static Rational f(int i10, Rational rational) {
        return (i10 == 90 || i10 == 270) ? g(rational) : new Rational(rational.getNumerator(), rational.getDenominator());
    }

    public static Rational g(Rational rational) {
        return rational == null ? rational : new Rational(rational.getDenominator(), rational.getNumerator());
    }

    public static boolean h(int i10) {
        return i10 == 256 || i10 == 4101;
    }

    public static boolean i(int i10) {
        return i10 == 32;
    }

    public static byte[] j(i iVar) {
        if (!h(iVar.getFormat())) {
            throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + iVar.getFormat());
        }
        ByteBuffer byteBufferA = iVar.w0()[0].a();
        byte[] bArr = new byte[byteBufferA.capacity()];
        byteBufferA.rewind();
        byteBufferA.get(bArr);
        return bArr;
    }

    public static Bitmap k(Bitmap bitmap, int i10) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i10);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static byte[] l(i iVar, Rect rect, int i10, int i11) throws CodecFailedException {
        if (iVar.getFormat() != 35) {
            throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + iVar.getFormat());
        }
        YuvImage yuvImage = new YuvImage(m(iVar), 17, iVar.getWidth(), iVar.getHeight(), null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a aVar = new a(byteArrayOutputStream, ExifData.c(iVar, i11));
        if (rect == null) {
            rect = new Rect(0, 0, iVar.getWidth(), iVar.getHeight());
        }
        if (yuvImage.compressToJpeg(rect, i10, aVar)) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new CodecFailedException("YuvImage failed to encode jpeg.", CodecFailedException.FailureType.ENCODE_FAILED);
    }

    public static byte[] m(i iVar) {
        i.a aVar = iVar.w0()[0];
        i.a aVar2 = iVar.w0()[1];
        i.a aVar3 = iVar.w0()[2];
        ByteBuffer byteBufferA = aVar.a();
        ByteBuffer byteBufferA2 = aVar2.a();
        ByteBuffer byteBufferA3 = aVar3.a();
        byteBufferA.rewind();
        byteBufferA2.rewind();
        byteBufferA3.rewind();
        int iRemaining = byteBufferA.remaining();
        byte[] bArr = new byte[((iVar.getWidth() * iVar.getHeight()) / 2) + iRemaining];
        int width = 0;
        for (int i10 = 0; i10 < iVar.getHeight(); i10++) {
            byteBufferA.get(bArr, width, iVar.getWidth());
            width += iVar.getWidth();
            byteBufferA.position(Math.min(iRemaining, (byteBufferA.position() - iVar.getWidth()) + aVar.b()));
        }
        int height = iVar.getHeight() / 2;
        int width2 = iVar.getWidth() / 2;
        int iB = aVar3.b();
        int iB2 = aVar2.b();
        int iC = aVar3.c();
        int iC2 = aVar2.c();
        byte[] bArr2 = new byte[iB];
        byte[] bArr3 = new byte[iB2];
        for (int i11 = 0; i11 < height; i11++) {
            byteBufferA3.get(bArr2, 0, Math.min(iB, byteBufferA3.remaining()));
            byteBufferA2.get(bArr3, 0, Math.min(iB2, byteBufferA2.remaining()));
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < width2; i14++) {
                int i15 = width + 1;
                bArr[width] = bArr2[i12];
                width += 2;
                bArr[i15] = bArr3[i13];
                i12 += iC;
                i13 += iC2;
            }
        }
        return bArr;
    }
}
