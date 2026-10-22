package J;

import D.C0761b0;
import D.C0787y;
import J.B;
import J.C0855j;
import J.C0869y;
import J.F;
import J.W;
import K.w0;
import U.C1038t;
import U.C1042x;
import android.graphics.Bitmap;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureResult;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import androidx.camera.core.internal.compat.quirk.LowMemoryQuirk;
import androidx.camera.core.internal.utils.ImageUtil;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class W {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f3554a;

    /* renamed from: b, reason: collision with root package name */
    public final C1042x f3555b;

    /* renamed from: c, reason: collision with root package name */
    public final CameraCharacteristics f3556c;

    /* renamed from: d, reason: collision with root package name */
    public C0869y f3557d;

    /* renamed from: e, reason: collision with root package name */
    public a f3558e;

    /* renamed from: f, reason: collision with root package name */
    public U.z<b, U.A<androidx.camera.core.i>> f3559f;

    /* renamed from: g, reason: collision with root package name */
    public U.z<B.a, U.A<byte[]>> f3560g;

    /* renamed from: h, reason: collision with root package name */
    public U.z<C0855j.b, U.A<byte[]>> f3561h;

    /* renamed from: i, reason: collision with root package name */
    public U.z<F.a, ImageCapture.g> f3562i;

    /* renamed from: j, reason: collision with root package name */
    public U.z<U.A<byte[]>, U.A<Bitmap>> f3563j;

    /* renamed from: k, reason: collision with root package name */
    public U.z<U.A<androidx.camera.core.i>, androidx.camera.core.i> f3564k;

    /* renamed from: l, reason: collision with root package name */
    public U.z<U.A<byte[]>, U.A<androidx.camera.core.i>> f3565l;

    /* renamed from: m, reason: collision with root package name */
    public U.z<U.A<androidx.camera.core.i>, Bitmap> f3566m;

    /* renamed from: n, reason: collision with root package name */
    public U.z<U.A<Bitmap>, U.A<Bitmap>> f3567n;

    /* renamed from: o, reason: collision with root package name */
    public final w0 f3568o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f3569p;

    public static abstract class a {
        public static a e(int i10, List<Integer> list) {
            return new C0852g(new C1038t(), new C1038t(), i10, list);
        }

        public abstract C1038t<b> a();

        public abstract int b();

        public abstract List<Integer> c();

        public abstract C1038t<b> d();
    }

    public static abstract class b {
        public static b c(X x10, androidx.camera.core.i iVar) {
            return new C0853h(x10, iVar);
        }

        public abstract androidx.camera.core.i a();

        public abstract X b();
    }

    public W(Executor executor, CameraCharacteristics cameraCharacteristics, C1042x c1042x) {
        this(executor, cameraCharacteristics, c1042x, R.c.c());
    }

    public static /* synthetic */ void c(final W w10, final b bVar) {
        w10.getClass();
        if (bVar.b().l()) {
            bVar.a().close();
        } else {
            w10.f3554a.execute(new Runnable() { // from class: J.N
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3540a.l(bVar);
                }
            });
        }
    }

    public static /* synthetic */ void e(final W w10, final b bVar) {
        w10.getClass();
        if (!bVar.b().l()) {
            w10.f3554a.execute(new Runnable() { // from class: J.M
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3538a.n(bVar);
                }
            });
        } else {
            C0761b0.o("ProcessingNode", "The postview image is closed due to request aborted");
            bVar.a().close();
        }
    }

    public static /* synthetic */ void h(W w10, b bVar) {
        w10.getClass();
        final X xB = bVar.b();
        try {
            boolean z10 = true;
            if (w10.f3558e.c().size() <= 1) {
                z10 = false;
            }
            if (bVar.b().m()) {
                final androidx.camera.core.i iVarK = w10.k(bVar);
                N.a.d().execute(new Runnable() { // from class: J.Q
                    @Override // java.lang.Runnable
                    public final void run() {
                        xB.r(iVarK);
                    }
                });
                return;
            }
            final ImageCapture.g gVarM = w10.m(bVar);
            if (!z10 || xB.k().r()) {
                N.a.d().execute(new Runnable() { // from class: J.S
                    @Override // java.lang.Runnable
                    public final void run() {
                        xB.q(gVarM);
                    }
                });
            }
        } catch (ImageCaptureException e10) {
            w10.r(xB, e10);
        } catch (OutOfMemoryError e11) {
            w10.r(xB, new ImageCaptureException(0, "Processing failed due to low memory.", e11));
        } catch (RuntimeException e12) {
            w10.r(xB, new ImageCaptureException(0, "Processing failed.", e12));
        }
    }

    public final U.A<byte[]> j(U.A<byte[]> a10, int i10) throws ImageCaptureException {
        B0.h.h(ImageUtil.h(a10.e()));
        U.A<Bitmap> aApply = this.f3563j.apply(a10);
        U.z<U.A<Bitmap>, U.A<Bitmap>> zVar = this.f3567n;
        if (zVar != null) {
            aApply = zVar.apply(aApply);
        }
        return this.f3561h.apply(C0855j.b.c(aApply, i10));
    }

    public androidx.camera.core.i k(b bVar) throws ImageCaptureException {
        C0761b0.a("ProcessingNode", "processInMemoryCapture: request ID = " + bVar.b().e());
        X xB = bVar.b();
        U.A<androidx.camera.core.i> aApply = this.f3559f.apply(bVar);
        List<Integer> listC = this.f3558e.c();
        B0.h.a(!listC.isEmpty());
        int iIntValue = listC.get(0).intValue();
        if ((aApply.e() == 35 || this.f3567n != null || this.f3569p) && iIntValue == 256) {
            U.A<byte[]> aApply2 = this.f3560g.apply(B.a.c(aApply, xB.c()));
            if (this.f3567n != null) {
                aApply2 = j(aApply2, xB.c());
            }
            aApply = this.f3565l.apply(aApply2);
        }
        androidx.camera.core.i iVarApply = this.f3564k.apply(aApply);
        if (listC.size() > 1) {
            xB.k().t(iVarApply.getFormat(), true);
        }
        return iVarApply;
    }

    public void l(final b bVar) {
        C0787y.a("processInputPacket", new Runnable() { // from class: J.O
            @Override // java.lang.Runnable
            public final void run() {
                W.h(this.f3542a, bVar);
            }
        });
    }

    public ImageCapture.g m(b bVar) throws ImageCaptureException {
        C0761b0.a("ProcessingNode", "processOnDiskCapture: request ID = " + bVar.b().e());
        List<Integer> listC = this.f3558e.c();
        B0.h.a(listC.isEmpty() ^ true);
        boolean z10 = false;
        Integer num = listC.get(0);
        int iIntValue = num.intValue();
        B0.h.b(ImageUtil.h(iIntValue) || ImageUtil.i(iIntValue), String.format("On-disk capture only support JPEG and JPEG/R and RAW output formats. Output format: %s", num));
        X xB = bVar.b();
        B0.h.b(xB.d() != null, "OutputFileOptions cannot be empty");
        U.A<androidx.camera.core.i> aApply = this.f3559f.apply(bVar);
        if (listC.size() <= 1) {
            if (iIntValue != 32) {
                ImageCapture.OutputFileOptions outputFileOptionsD = xB.d();
                Objects.requireNonNull(outputFileOptionsD);
                return p(aApply, outputFileOptionsD, xB.c());
            }
            ImageCapture.OutputFileOptions outputFileOptionsD2 = xB.d();
            Objects.requireNonNull(outputFileOptionsD2);
            return q(aApply, outputFileOptionsD2);
        }
        if (xB.d() != null && xB.g() != null) {
            z10 = true;
        }
        B0.h.b(z10, "The number of OutputFileOptions for simultaneous capture should be at least two");
        if (aApply.e() != 32) {
            ImageCapture.OutputFileOptions outputFileOptionsG = xB.g();
            Objects.requireNonNull(outputFileOptionsG);
            ImageCapture.g gVarP = p(aApply, outputFileOptionsG, xB.c());
            xB.k().t(256, true);
            return gVarP;
        }
        ImageCapture.OutputFileOptions outputFileOptionsD3 = xB.d();
        Objects.requireNonNull(outputFileOptionsD3);
        ImageCapture.g gVarQ = q(aApply, outputFileOptionsD3);
        xB.k().t(32, true);
        return gVarQ;
    }

    public void n(b bVar) {
        final X xB = bVar.b();
        try {
            U.A<androidx.camera.core.i> aApply = this.f3559f.apply(bVar);
            int iE = aApply.e();
            B0.h.b(iE == 35 || iE == 256 || iE == 4101, String.format("Postview only supports to convert YUV, JPEG and JPEG_R format image to the postview output bitmap. Image format: %s", Integer.valueOf(iE)));
            final Bitmap bitmapApply = this.f3566m.apply(aApply);
            N.a.d().execute(new Runnable() { // from class: J.P
                @Override // java.lang.Runnable
                public final void run() {
                    xB.t(bitmapApply);
                }
            });
        } catch (Exception e10) {
            bVar.a().close();
            C0761b0.d("ProcessingNode", "process postview input packet failed.", e10);
        }
    }

    public void o() {
    }

    public final ImageCapture.g p(U.A<androidx.camera.core.i> a10, ImageCapture.OutputFileOptions outputFileOptions, int i10) throws ImageCaptureException {
        U.A<byte[]> aApply = this.f3560g.apply(B.a.c(a10, i10));
        if (aApply.i() || this.f3567n != null) {
            aApply = j(aApply, i10);
        }
        U.z<F.a, ImageCapture.g> zVar = this.f3562i;
        Objects.requireNonNull(outputFileOptions);
        return zVar.apply(F.a.c(aApply, outputFileOptions));
    }

    public final ImageCapture.g q(U.A<androidx.camera.core.i> a10, ImageCapture.OutputFileOptions outputFileOptions) throws ImageCaptureException {
        if (this.f3557d == null) {
            if (this.f3556c == null) {
                throw new ImageCaptureException(0, "CameraCharacteristics is null, DngCreator cannot be created", null);
            }
            if (a10.a().j() == null) {
                throw new ImageCaptureException(0, "CameraCaptureResult is null, DngCreator cannot be created", null);
            }
            CameraCharacteristics cameraCharacteristics = this.f3556c;
            Objects.requireNonNull(cameraCharacteristics);
            CaptureResult captureResultJ = a10.a().j();
            Objects.requireNonNull(captureResultJ);
            this.f3557d = new C0869y(cameraCharacteristics, captureResultJ);
        }
        C0869y c0869y = this.f3557d;
        androidx.camera.core.i iVarC = a10.c();
        int iF = a10.f();
        Objects.requireNonNull(outputFileOptions);
        return c0869y.apply(C0869y.a.d(iVarC, iF, outputFileOptions));
    }

    public final void r(final X x10, final ImageCaptureException imageCaptureException) {
        N.a.d().execute(new Runnable() { // from class: J.T
            @Override // java.lang.Runnable
            public final void run() {
                x10.u(imageCaptureException);
            }
        });
    }

    public Void s(a aVar) {
        this.f3558e = aVar;
        aVar.a().a(new B0.a() { // from class: J.U
            @Override // B0.a
            public final void accept(Object obj) {
                W.c(this.f3552a, (W.b) obj);
            }
        });
        aVar.d().a(new B0.a() { // from class: J.V
            @Override // B0.a
            public final void accept(Object obj) {
                W.e(this.f3553a, (W.b) obj);
            }
        });
        this.f3559f = new L();
        this.f3560g = new B(this.f3568o);
        this.f3563j = new E();
        this.f3561h = new C0855j();
        this.f3562i = new F();
        this.f3564k = new H();
        this.f3566m = new A();
        if (aVar.b() == 35 || this.f3555b != null || this.f3569p) {
            this.f3565l = new G();
        }
        C1042x c1042x = this.f3555b;
        if (c1042x == null) {
            return null;
        }
        this.f3567n = new C0856k(c1042x);
        return null;
    }

    public W(Executor executor, CameraCharacteristics cameraCharacteristics, C1042x c1042x, w0 w0Var) {
        if (R.c.b(LowMemoryQuirk.class) != null) {
            this.f3554a = N.a.f(executor);
        } else {
            this.f3554a = executor;
        }
        this.f3555b = c1042x;
        this.f3556c = cameraCharacteristics;
        this.f3568o = w0Var;
        this.f3569p = w0Var.a(IncorrectJpegMetadataQuirk.class);
    }
}
