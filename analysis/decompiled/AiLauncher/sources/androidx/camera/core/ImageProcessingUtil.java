package androidx.camera.core;

import D.C0761b0;
import D.q0;
import K.InterfaceC0872a0;
import android.graphics.Bitmap;
import android.media.Image;
import android.media.ImageWriter;
import android.util.Log;
import android.view.Surface;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.g;
import androidx.camera.core.i;
import java.nio.ByteBuffer;
import java.util.Locale;

/* loaded from: classes.dex */
public final class ImageProcessingUtil {

    /* renamed from: a, reason: collision with root package name */
    public static int f11210a;

    public enum Result {
        UNKNOWN,
        SUCCESS,
        ERROR_CONVERSION
    }

    public static class a extends g {

        /* renamed from: d, reason: collision with root package name */
        public final i.a[] f11211d;

        /* renamed from: e, reason: collision with root package name */
        public final int f11212e;

        /* renamed from: f, reason: collision with root package name */
        public final int f11213f;

        /* renamed from: androidx.camera.core.ImageProcessingUtil$a$a, reason: collision with other inner class name */
        public class C0144a implements i.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f11214a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ByteBuffer f11215b;

            public C0144a(int i10, ByteBuffer byteBuffer) {
                this.f11214a = i10;
                this.f11215b = byteBuffer;
            }

            @Override // androidx.camera.core.i.a
            public ByteBuffer a() {
                return this.f11215b;
            }

            @Override // androidx.camera.core.i.a
            public int b() {
                return this.f11214a;
            }

            @Override // androidx.camera.core.i.a
            public int c() {
                return 1;
            }
        }

        public a(i iVar, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i10, int i11, int i12) {
            super(iVar);
            this.f11211d = g(byteBuffer, byteBuffer2, byteBuffer3, i10);
            this.f11212e = i10;
            this.f11213f = i11;
        }

        public final i.a[] g(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i10) {
            return new i.a[]{new C0144a(i10, byteBuffer), new b(byteBuffer2, i10), new b(byteBuffer3, i10)};
        }

        @Override // androidx.camera.core.g, androidx.camera.core.i
        public int getHeight() {
            return this.f11213f;
        }

        @Override // androidx.camera.core.g, androidx.camera.core.i
        public int getWidth() {
            return this.f11212e;
        }

        @Override // androidx.camera.core.g, androidx.camera.core.i
        public i.a[] w0() {
            return this.f11211d;
        }
    }

    public static class b implements i.a {

        /* renamed from: a, reason: collision with root package name */
        public final ByteBuffer f11217a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11218b;

        public b(ByteBuffer byteBuffer, int i10) {
            this.f11217a = byteBuffer;
            this.f11218b = i10;
        }

        @Override // androidx.camera.core.i.a
        public ByteBuffer a() {
            return this.f11217a;
        }

        @Override // androidx.camera.core.i.a
        public int b() {
            return this.f11218b;
        }

        @Override // androidx.camera.core.i.a
        public int c() {
            return 2;
        }
    }

    static {
        System.loadLibrary("image_processing_util_jni");
    }

    public static /* synthetic */ void a(i iVar, i iVar2, i iVar3) {
        if (iVar == null || iVar2 == null) {
            return;
        }
        iVar2.close();
    }

    public static /* synthetic */ void b(i iVar, i iVar2, i iVar3) {
        if (iVar == null || iVar2 == null) {
            return;
        }
        iVar2.close();
    }

    public static boolean c(i iVar) {
        if (!m(iVar)) {
            C0761b0.c("ImageProcessingUtil", "Unsupported format for YUV to RGB");
            return false;
        }
        if (d(iVar) != Result.ERROR_CONVERSION) {
            return true;
        }
        C0761b0.c("ImageProcessingUtil", "One pixel shift for YUV failure");
        return false;
    }

    public static Result d(i iVar) {
        int width = iVar.getWidth();
        int height = iVar.getHeight();
        int iB = iVar.w0()[0].b();
        int iB2 = iVar.w0()[1].b();
        int iB3 = iVar.w0()[2].b();
        int iC = iVar.w0()[0].c();
        int iC2 = iVar.w0()[1].c();
        return nativeShiftPixel(iVar.w0()[0].a(), iB, iVar.w0()[1].a(), iB2, iVar.w0()[2].a(), iB3, iC, iC2, width, height, iC, iC2, iC2) != 0 ? Result.ERROR_CONVERSION : Result.SUCCESS;
    }

    public static i e(InterfaceC0872a0 interfaceC0872a0, byte[] bArr) {
        B0.h.a(interfaceC0872a0.e() == 256);
        B0.h.f(bArr);
        Surface surface = interfaceC0872a0.getSurface();
        B0.h.f(surface);
        if (nativeWriteJpegToSurface(bArr, surface) != 0) {
            C0761b0.c("ImageProcessingUtil", "Failed to enqueue JPEG image.");
            return null;
        }
        i iVarD = interfaceC0872a0.d();
        if (iVarD == null) {
            C0761b0.c("ImageProcessingUtil", "Failed to get acquire JPEG image.");
        }
        return iVarD;
    }

    public static Bitmap f(i iVar) {
        if (iVar.getFormat() != 35) {
            throw new IllegalArgumentException("Input image format must be YUV_420_888");
        }
        int width = iVar.getWidth();
        int height = iVar.getHeight();
        int iB = iVar.w0()[0].b();
        int iB2 = iVar.w0()[1].b();
        int iB3 = iVar.w0()[2].b();
        int iC = iVar.w0()[0].c();
        int iC2 = iVar.w0()[1].c();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iVar.getWidth(), iVar.getHeight(), Bitmap.Config.ARGB_8888);
        if (nativeConvertAndroid420ToBitmap(iVar.w0()[0].a(), iB, iVar.w0()[1].a(), iB2, iVar.w0()[2].a(), iB3, iC, iC2, bitmapCreateBitmap, bitmapCreateBitmap.getRowBytes(), width, height) == 0) {
            return bitmapCreateBitmap;
        }
        throw new UnsupportedOperationException("YUV to RGB conversion failed");
    }

    public static i g(final i iVar, InterfaceC0872a0 interfaceC0872a0, ByteBuffer byteBuffer, int i10, boolean z10) {
        if (!m(iVar)) {
            C0761b0.c("ImageProcessingUtil", "Unsupported format for YUV to RGB");
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!l(i10)) {
            C0761b0.c("ImageProcessingUtil", "Unsupported rotation degrees for rotate RGB");
            return null;
        }
        if (h(iVar, interfaceC0872a0.getSurface(), byteBuffer, i10, z10) == Result.ERROR_CONVERSION) {
            C0761b0.c("ImageProcessingUtil", "YUV to RGB conversion failure");
            return null;
        }
        if (Log.isLoggable("MH", 3)) {
            C0761b0.a("ImageProcessingUtil", String.format(Locale.US, "Image processing performance profiling, duration: [%d], image count: %d", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), Integer.valueOf(f11210a)));
            f11210a++;
        }
        final i iVarD = interfaceC0872a0.d();
        if (iVarD == null) {
            C0761b0.c("ImageProcessingUtil", "YUV to RGB acquireLatestImage failure");
            return null;
        }
        q0 q0Var = new q0(iVarD);
        q0Var.b(new g.a() { // from class: D.U
            @Override // androidx.camera.core.g.a
            public final void c(androidx.camera.core.i iVar2) {
                ImageProcessingUtil.b(iVarD, iVar, iVar2);
            }
        });
        return q0Var;
    }

    public static Result h(i iVar, Surface surface, ByteBuffer byteBuffer, int i10, boolean z10) {
        int width = iVar.getWidth();
        int height = iVar.getHeight();
        int iB = iVar.w0()[0].b();
        int iB2 = iVar.w0()[1].b();
        int iB3 = iVar.w0()[2].b();
        int iC = iVar.w0()[0].c();
        int iC2 = iVar.w0()[1].c();
        return nativeConvertAndroid420ToABGR(iVar.w0()[0].a(), iB, iVar.w0()[1].a(), iB2, iVar.w0()[2].a(), iB3, iC, iC2, surface, byteBuffer, width, height, z10 ? iC : 0, z10 ? iC2 : 0, z10 ? iC2 : 0, i10) != 0 ? Result.ERROR_CONVERSION : Result.SUCCESS;
    }

    public static void i(Bitmap bitmap, ByteBuffer byteBuffer, int i10) {
        nativeCopyBetweenByteBufferAndBitmap(bitmap, byteBuffer, bitmap.getRowBytes(), i10, bitmap.getWidth(), bitmap.getHeight(), false);
    }

    public static void j(Bitmap bitmap, ByteBuffer byteBuffer, int i10) {
        nativeCopyBetweenByteBufferAndBitmap(bitmap, byteBuffer, i10, bitmap.getRowBytes(), bitmap.getWidth(), bitmap.getHeight(), true);
    }

    public static boolean k(i iVar) {
        return iVar.w0().length == 3 && iVar.w0()[1].c() == 2 && nativeGetYUVImageVUOff(iVar.w0()[2].a(), iVar.w0()[1].a()) == -1;
    }

    public static boolean l(int i10) {
        return i10 == 0 || i10 == 90 || i10 == 180 || i10 == 270;
    }

    public static boolean m(i iVar) {
        return iVar.getFormat() == 35 && iVar.w0().length == 3;
    }

    public static i n(i iVar, InterfaceC0872a0 interfaceC0872a0, ImageWriter imageWriter, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i10) {
        final i iVar2;
        Result resultP;
        if (!m(iVar)) {
            C0761b0.c("ImageProcessingUtil", "Unsupported format for rotate YUV");
            return null;
        }
        if (!l(i10)) {
            C0761b0.c("ImageProcessingUtil", "Unsupported rotation degrees for rotate YUV");
            return null;
        }
        Result result = Result.ERROR_CONVERSION;
        if (i10 > 0) {
            iVar2 = iVar;
            resultP = p(iVar2, imageWriter, byteBuffer, byteBuffer2, byteBuffer3, i10);
        } else {
            iVar2 = iVar;
            resultP = result;
        }
        if (resultP == result) {
            C0761b0.c("ImageProcessingUtil", "rotate YUV failure");
            return null;
        }
        final i iVarD = interfaceC0872a0.d();
        if (iVarD == null) {
            C0761b0.c("ImageProcessingUtil", "YUV rotation acquireLatestImage failure");
            return null;
        }
        q0 q0Var = new q0(iVarD);
        q0Var.b(new g.a() { // from class: D.V
            @Override // androidx.camera.core.g.a
            public final void c(androidx.camera.core.i iVar3) {
                ImageProcessingUtil.a(iVarD, iVar2, iVar3);
            }
        });
        return q0Var;
    }

    private static native int nativeConvertAndroid420ToABGR(ByteBuffer byteBuffer, int i10, ByteBuffer byteBuffer2, int i11, ByteBuffer byteBuffer3, int i12, int i13, int i14, Surface surface, ByteBuffer byteBuffer4, int i15, int i16, int i17, int i18, int i19, int i20);

    private static native int nativeConvertAndroid420ToBitmap(ByteBuffer byteBuffer, int i10, ByteBuffer byteBuffer2, int i11, ByteBuffer byteBuffer3, int i12, int i13, int i14, Bitmap bitmap, int i15, int i16, int i17);

    private static native int nativeCopyBetweenByteBufferAndBitmap(Bitmap bitmap, ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, boolean z10);

    public static native int nativeGetYUVImageVUOff(ByteBuffer byteBuffer, ByteBuffer byteBuffer2);

    public static native ByteBuffer nativeNewDirectByteBuffer(ByteBuffer byteBuffer, int i10, int i11);

    private static native int nativeRotateYUV(ByteBuffer byteBuffer, int i10, ByteBuffer byteBuffer2, int i11, ByteBuffer byteBuffer3, int i12, int i13, ByteBuffer byteBuffer4, int i14, int i15, ByteBuffer byteBuffer5, int i16, int i17, ByteBuffer byteBuffer6, int i18, int i19, ByteBuffer byteBuffer7, ByteBuffer byteBuffer8, ByteBuffer byteBuffer9, int i20, int i21, int i22);

    private static native int nativeShiftPixel(ByteBuffer byteBuffer, int i10, ByteBuffer byteBuffer2, int i11, ByteBuffer byteBuffer3, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19);

    private static native int nativeWriteJpegToSurface(byte[] bArr, Surface surface);

    public static i o(i iVar, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, ByteBuffer byteBuffer4, ByteBuffer byteBuffer5, int i10) {
        if (!m(iVar)) {
            C0761b0.c("ImageProcessingUtil", "Unsupported format for rotate YUV");
            return null;
        }
        if (!l(i10)) {
            C0761b0.c("ImageProcessingUtil", "Unsupported rotation degrees for rotate YUV");
            return null;
        }
        if (i10 == 0 && k(iVar)) {
            return null;
        }
        int i11 = i10 % 180;
        int width = i11 == 0 ? iVar.getWidth() : iVar.getHeight();
        int height = i11 == 0 ? iVar.getHeight() : iVar.getWidth();
        ByteBuffer byteBufferNativeNewDirectByteBuffer = nativeNewDirectByteBuffer(byteBuffer5, 1, byteBuffer5.capacity());
        int i12 = height;
        if (nativeRotateYUV(iVar.w0()[0].a(), iVar.w0()[0].b(), iVar.w0()[1].a(), iVar.w0()[1].b(), iVar.w0()[2].a(), iVar.w0()[2].b(), iVar.w0()[2].c(), byteBuffer4, width, 1, byteBufferNativeNewDirectByteBuffer, width, 2, byteBuffer5, width, 2, byteBuffer, byteBuffer2, byteBuffer3, iVar.getWidth(), iVar.getHeight(), i10) == 0) {
            return new q0(new a(iVar, byteBuffer4, byteBufferNativeNewDirectByteBuffer, byteBuffer5, width, i12, i10));
        }
        C0761b0.c("ImageProcessingUtil", "rotate YUV failure");
        return null;
    }

    public static Result p(i iVar, ImageWriter imageWriter, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i10) {
        int width = iVar.getWidth();
        int height = iVar.getHeight();
        int iB = iVar.w0()[0].b();
        int iB2 = iVar.w0()[1].b();
        int iB3 = iVar.w0()[2].b();
        int iC = iVar.w0()[1].c();
        Image imageB = Q.a.b(imageWriter);
        if (imageB != null && nativeRotateYUV(iVar.w0()[0].a(), iB, iVar.w0()[1].a(), iB2, iVar.w0()[2].a(), iB3, iC, imageB.getPlanes()[0].getBuffer(), imageB.getPlanes()[0].getRowStride(), imageB.getPlanes()[0].getPixelStride(), imageB.getPlanes()[1].getBuffer(), imageB.getPlanes()[1].getRowStride(), imageB.getPlanes()[1].getPixelStride(), imageB.getPlanes()[2].getBuffer(), imageB.getPlanes()[2].getRowStride(), imageB.getPlanes()[2].getPixelStride(), byteBuffer, byteBuffer2, byteBuffer3, width, height, i10) == 0) {
            Q.a.d(imageWriter, imageB);
            return Result.SUCCESS;
        }
        return Result.ERROR_CONVERSION;
    }

    public static boolean q(Surface surface, byte[] bArr) {
        B0.h.f(bArr);
        B0.h.f(surface);
        if (nativeWriteJpegToSurface(bArr, surface) == 0) {
            return true;
        }
        C0761b0.c("ImageProcessingUtil", "Failed to enqueue JPEG image.");
        return false;
    }
}
