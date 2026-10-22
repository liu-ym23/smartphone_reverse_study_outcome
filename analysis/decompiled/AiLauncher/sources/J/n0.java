package J;

import D.C0761b0;
import K.AbstractC0889l;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class n0 {

    /* renamed from: a, reason: collision with root package name */
    public int f3659a = new S.a().a();

    /* renamed from: b, reason: collision with root package name */
    public final Map<Integer, Boolean> f3660b = new HashMap();

    public interface a {
        void d(n0 n0Var);
    }

    public static /* synthetic */ void a(n0 n0Var, ImageCaptureException imageCaptureException) {
        n0Var.j();
        if (!(n0Var.l() != null)) {
            throw new IllegalStateException("One and only one callback is allowed.");
        }
        ImageCapture.OnImageSavedCallback onImageSavedCallbackL = n0Var.l();
        Objects.requireNonNull(onImageSavedCallbackL);
        onImageSavedCallbackL.onError(imageCaptureException);
    }

    public static /* synthetic */ void b(n0 n0Var, ImageCapture.g gVar) {
        ImageCapture.OnImageSavedCallback onImageSavedCallbackL = n0Var.l();
        Objects.requireNonNull(onImageSavedCallbackL);
        Objects.requireNonNull(gVar);
        onImageSavedCallbackL.onImageSaved(gVar);
    }

    public static /* synthetic */ void c(n0 n0Var, androidx.camera.core.i iVar) {
        ImageCapture.f fVarJ = n0Var.j();
        Objects.requireNonNull(fVarJ);
        Objects.requireNonNull(iVar);
        fVarJ.c(iVar);
    }

    public static /* synthetic */ void d(n0 n0Var, Bitmap bitmap) {
        if (n0Var.l() != null) {
            n0Var.l().onPostviewBitmapAvailable(bitmap);
        } else {
            n0Var.j();
        }
    }

    public static /* synthetic */ void e(n0 n0Var, int i10) {
        if (n0Var.l() != null) {
            n0Var.l().onCaptureProcessProgressed(i10);
        } else {
            n0Var.j();
        }
    }

    public boolean f() {
        M.n.b();
        int i10 = this.f3659a;
        if (i10 <= 0) {
            return false;
        }
        this.f3659a = i10 - 1;
        return true;
    }

    public abstract Executor g();

    public abstract int h();

    public abstract Rect i();

    public abstract ImageCapture.f j();

    public abstract int k();

    public abstract ImageCapture.OnImageSavedCallback l();

    public abstract ImageCapture.OutputFileOptions m();

    public abstract int n();

    public abstract ImageCapture.OutputFileOptions o();

    public abstract Matrix p();

    public abstract List<AbstractC0889l> q();

    public boolean r() {
        Iterator<Map.Entry<Integer, Boolean>> it = this.f3660b.entrySet().iterator();
        while (it.hasNext()) {
            if (!it.next().getValue().booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean s();

    public void t(int i10, boolean z10) {
        if (this.f3660b.containsKey(Integer.valueOf(i10))) {
            this.f3660b.put(Integer.valueOf(i10), Boolean.valueOf(z10));
        } else {
            C0761b0.c("TakePictureRequest", "The format is not supported in simultaneous capture");
        }
    }

    public void u(final int i10) {
        g().execute(new Runnable() { // from class: J.j0
            @Override // java.lang.Runnable
            public final void run() {
                n0.e(this.f3647a, i10);
            }
        });
    }

    public void v(final ImageCaptureException imageCaptureException) {
        g().execute(new Runnable() { // from class: J.m0
            @Override // java.lang.Runnable
            public final void run() {
                n0.a(this.f3656a, imageCaptureException);
            }
        });
    }

    public void w(final Bitmap bitmap) {
        g().execute(new Runnable() { // from class: J.i0
            @Override // java.lang.Runnable
            public final void run() {
                n0.d(this.f3645a, bitmap);
            }
        });
    }

    public void x(final ImageCapture.g gVar) {
        g().execute(new Runnable() { // from class: J.l0
            @Override // java.lang.Runnable
            public final void run() {
                n0.b(this.f3652a, gVar);
            }
        });
    }

    public void y(final androidx.camera.core.i iVar) {
        g().execute(new Runnable() { // from class: J.k0
            @Override // java.lang.Runnable
            public final void run() {
                n0.c(this.f3650a, iVar);
            }
        });
    }
}
