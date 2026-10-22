package J;

import D.C0761b0;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import g3.InterfaceFutureC4095a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class X {

    /* renamed from: a, reason: collision with root package name */
    public final int f3570a;

    /* renamed from: b, reason: collision with root package name */
    public n0 f3571b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageCapture.OutputFileOptions f3572c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageCapture.OutputFileOptions f3573d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f3574e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3575f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3576g;

    /* renamed from: h, reason: collision with root package name */
    public final Matrix f3577h;

    /* renamed from: i, reason: collision with root package name */
    public final c0 f3578i;

    /* renamed from: j, reason: collision with root package name */
    public final String f3579j;

    /* renamed from: l, reason: collision with root package name */
    public final InterfaceFutureC4095a<Void> f3581l;

    /* renamed from: m, reason: collision with root package name */
    public int f3582m = -1;

    /* renamed from: k, reason: collision with root package name */
    public final List<Integer> f3580k = new ArrayList();

    public X(K.P p10, n0 n0Var, c0 c0Var, InterfaceFutureC4095a<Void> interfaceFutureC4095a, int i10) {
        this.f3570a = i10;
        this.f3571b = n0Var;
        this.f3572c = n0Var.m();
        this.f3573d = n0Var.o();
        this.f3576g = n0Var.k();
        this.f3575f = n0Var.n();
        this.f3574e = n0Var.i();
        this.f3577h = n0Var.p();
        this.f3578i = c0Var;
        this.f3579j = String.valueOf(p10.hashCode());
        List<androidx.camera.core.impl.m> listA = p10.a();
        Objects.requireNonNull(listA);
        Iterator<androidx.camera.core.impl.m> it = listA.iterator();
        while (it.hasNext()) {
            this.f3580k.add(Integer.valueOf(it.next().getId()));
        }
        this.f3581l = interfaceFutureC4095a;
        C0761b0.a("ProcessingRequest", "ProcessingRequest: mRequestId = " + this.f3570a + ", mTagBundleKey = " + this.f3579j);
    }

    public InterfaceFutureC4095a<Void> a() {
        return this.f3581l;
    }

    public Rect b() {
        return this.f3574e;
    }

    public int c() {
        return this.f3576g;
    }

    public ImageCapture.OutputFileOptions d() {
        return this.f3572c;
    }

    public int e() {
        return this.f3570a;
    }

    public int f() {
        return this.f3575f;
    }

    public ImageCapture.OutputFileOptions g() {
        return this.f3573d;
    }

    public Matrix h() {
        return this.f3577h;
    }

    public List<Integer> i() {
        return this.f3580k;
    }

    public String j() {
        return this.f3579j;
    }

    public n0 k() {
        return this.f3571b;
    }

    public boolean l() {
        return this.f3578i.d();
    }

    public boolean m() {
        return d() == null && g() == null;
    }

    public void n(ImageCaptureException imageCaptureException) {
        C0761b0.p("ProcessingRequest", "onCaptureFailure: request ID = " + this.f3570a, imageCaptureException);
        this.f3578i.e(imageCaptureException);
    }

    public void o(int i10) {
        if (this.f3582m != i10) {
            this.f3582m = i10;
            this.f3578i.onCaptureProcessProgressed(i10);
        }
    }

    public void p() {
        C0761b0.a("ProcessingRequest", "onCaptureStarted: request ID = " + this.f3570a);
        this.f3578i.onCaptureStarted();
    }

    public void q(ImageCapture.g gVar) {
        C0761b0.e("ProcessingRequest", "onFinalResult(OutputFileResults): request ID = " + this.f3570a);
        this.f3578i.a(gVar);
    }

    public void r(androidx.camera.core.i iVar) {
        C0761b0.e("ProcessingRequest", "onFinalResult(ImageProxy): request ID = " + this.f3570a);
        this.f3578i.c(iVar);
    }

    public void s() {
        C0761b0.e("ProcessingRequest", "onImageCaptured: request ID = " + this.f3570a);
        if (this.f3582m != -1) {
            o(100);
        }
        this.f3578i.f();
    }

    public void t(Bitmap bitmap) {
        C0761b0.e("ProcessingRequest", "onPostviewBitmapAvailable: request ID = " + this.f3570a);
        this.f3578i.onPostviewBitmapAvailable(bitmap);
    }

    public void u(ImageCaptureException imageCaptureException) {
        C0761b0.p("ProcessingRequest", "onProcessFailure: request ID = " + this.f3570a, imageCaptureException);
        this.f3578i.b(imageCaptureException);
    }
}
