package J;

import J.n0;
import android.graphics.Bitmap;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import g3.InterfaceFutureC4095a;
import java.util.Objects;

/* loaded from: classes.dex */
public class a0 implements c0 {

    /* renamed from: a, reason: collision with root package name */
    public final n0 f3587a;

    /* renamed from: b, reason: collision with root package name */
    public final n0.a f3588b;

    /* renamed from: e, reason: collision with root package name */
    public CallbackToFutureAdapter.a<Void> f3591e;

    /* renamed from: f, reason: collision with root package name */
    public CallbackToFutureAdapter.a<Void> f3592f;

    /* renamed from: i, reason: collision with root package name */
    public InterfaceFutureC4095a<Void> f3595i;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3593g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3594h = false;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceFutureC4095a<Void> f3589c = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: J.Y
        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
        public final Object a(CallbackToFutureAdapter.a aVar) {
            return a0.g(this.f3583a, aVar);
        }
    });

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceFutureC4095a<Void> f3590d = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: J.Z
        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
        public final Object a(CallbackToFutureAdapter.a aVar) {
            return a0.h(this.f3584a, aVar);
        }
    });

    public a0(n0 n0Var, n0.a aVar) {
        this.f3587a = n0Var;
        this.f3588b = aVar;
    }

    public static /* synthetic */ Object g(a0 a0Var, CallbackToFutureAdapter.a aVar) {
        a0Var.f3591e = aVar;
        return "CaptureCompleteFuture";
    }

    public static /* synthetic */ Object h(a0 a0Var, CallbackToFutureAdapter.a aVar) {
        a0Var.f3592f = aVar;
        return "RequestCompleteFuture";
    }

    @Override // J.c0
    public void a(ImageCapture.g gVar) {
        M.n.b();
        if (this.f3593g) {
            return;
        }
        l();
        o();
        this.f3587a.x(gVar);
    }

    @Override // J.c0
    public void b(ImageCaptureException imageCaptureException) {
        M.n.b();
        if (this.f3593g) {
            return;
        }
        l();
        o();
        p(imageCaptureException);
    }

    @Override // J.c0
    public void c(androidx.camera.core.i iVar) {
        M.n.b();
        if (this.f3593g) {
            iVar.close();
            return;
        }
        l();
        o();
        this.f3587a.y(iVar);
    }

    @Override // J.c0
    public boolean d() {
        return this.f3593g;
    }

    @Override // J.c0
    public void e(ImageCaptureException imageCaptureException) {
        M.n.b();
        if (this.f3593g) {
            return;
        }
        boolean zF = this.f3587a.f();
        if (!zF) {
            p(imageCaptureException);
        }
        o();
        this.f3591e.f(imageCaptureException);
        if (zF) {
            this.f3588b.d(this.f3587a);
        }
    }

    @Override // J.c0
    public void f() {
        M.n.b();
        if (this.f3593g) {
            return;
        }
        if (!this.f3594h) {
            onCaptureStarted();
        }
        this.f3591e.c(null);
    }

    public final void i(ImageCaptureException imageCaptureException) {
        M.n.b();
        this.f3593g = true;
        InterfaceFutureC4095a<Void> interfaceFutureC4095a = this.f3595i;
        Objects.requireNonNull(interfaceFutureC4095a);
        interfaceFutureC4095a.cancel(true);
        this.f3591e.f(imageCaptureException);
        this.f3592f.c(null);
    }

    public void j(ImageCaptureException imageCaptureException) {
        M.n.b();
        if (this.f3590d.isDone()) {
            return;
        }
        i(imageCaptureException);
        p(imageCaptureException);
    }

    public void k() {
        M.n.b();
        if (this.f3590d.isDone()) {
            return;
        }
        i(new ImageCaptureException(3, "The request is aborted silently and retried.", null));
        this.f3588b.d(this.f3587a);
    }

    public final void l() {
        B0.h.i(this.f3589c.isDone(), "onImageCaptured() must be called before onFinalResult()");
    }

    public InterfaceFutureC4095a<Void> m() {
        M.n.b();
        return this.f3589c;
    }

    public InterfaceFutureC4095a<Void> n() {
        M.n.b();
        return this.f3590d;
    }

    public final void o() {
        if (!this.f3587a.s() || this.f3587a.r()) {
            if (!this.f3587a.s()) {
                B0.h.i(!this.f3590d.isDone(), "The callback can only complete once.");
            }
            this.f3592f.c(null);
        }
    }

    @Override // J.c0
    public void onCaptureProcessProgressed(int i10) {
        M.n.b();
        if (this.f3593g) {
            return;
        }
        this.f3587a.u(i10);
    }

    @Override // J.c0
    public void onCaptureStarted() {
        M.n.b();
        if (this.f3593g || this.f3594h) {
            return;
        }
        this.f3594h = true;
        this.f3587a.j();
        ImageCapture.OnImageSavedCallback onImageSavedCallbackL = this.f3587a.l();
        if (onImageSavedCallbackL != null) {
            onImageSavedCallbackL.onCaptureStarted();
        }
    }

    @Override // J.c0
    public void onPostviewBitmapAvailable(Bitmap bitmap) {
        M.n.b();
        if (this.f3593g) {
            return;
        }
        this.f3587a.w(bitmap);
    }

    public final void p(ImageCaptureException imageCaptureException) {
        M.n.b();
        this.f3587a.v(imageCaptureException);
    }

    public void q(InterfaceFutureC4095a<Void> interfaceFutureC4095a) {
        M.n.b();
        B0.h.i(this.f3595i == null, "CaptureRequestFuture can only be set once.");
        this.f3595i = interfaceFutureC4095a;
    }
}
