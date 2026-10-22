package J;

import D.C0761b0;
import J.d0;
import J.n0;
import android.util.Log;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.g;
import g3.InterfaceFutureC4095a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class h0 implements d0, g.a, n0.a {

    /* renamed from: b, reason: collision with root package name */
    public final C f3636b;

    /* renamed from: c, reason: collision with root package name */
    public D f3637c;

    /* renamed from: d, reason: collision with root package name */
    public a0 f3638d;

    /* renamed from: e, reason: collision with root package name */
    public final List<a0> f3639e;

    /* renamed from: a, reason: collision with root package name */
    public final Deque<n0> f3635a = new ArrayDeque();

    /* renamed from: f, reason: collision with root package name */
    public boolean f3640f = false;

    public class a implements O.c<Void> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C0858m f3641a;

        public a(C0858m c0858m) {
            this.f3641a = c0858m;
        }

        @Override // O.c
        public void b(Throwable th) {
            if (this.f3641a.b()) {
                return;
            }
            int iE = this.f3641a.a().get(0).e();
            if (th instanceof ImageCaptureException) {
                h0.this.f3637c.j(d0.a.c(iE, (ImageCaptureException) th));
            } else {
                h0.this.f3637c.j(d0.a.c(iE, new ImageCaptureException(2, "Failed to submit capture request", th)));
            }
            h0.this.f3636b.c();
        }

        @Override // O.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Void r12) {
            h0.this.f3636b.c();
        }
    }

    public h0(C c10) {
        M.n.b();
        this.f3636b = c10;
        this.f3639e = new ArrayList();
    }

    public static /* synthetic */ void f(h0 h0Var) {
        h0Var.f3638d = null;
        h0Var.h();
    }

    @Override // J.d0
    public void a(D d10) {
        M.n.b();
        this.f3637c = d10;
        d10.k(this);
    }

    @Override // J.d0
    public void b() {
        M.n.b();
        ImageCaptureException imageCaptureException = new ImageCaptureException(3, "Camera is closed.", null);
        Iterator<n0> it = this.f3635a.iterator();
        while (it.hasNext()) {
            it.next().v(imageCaptureException);
        }
        this.f3635a.clear();
        Iterator it2 = new ArrayList(this.f3639e).iterator();
        while (it2.hasNext()) {
            ((a0) it2.next()).j(imageCaptureException);
        }
    }

    @Override // androidx.camera.core.g.a
    public void c(androidx.camera.core.i iVar) {
        N.a.d().execute(new Runnable() { // from class: J.e0
            @Override // java.lang.Runnable
            public final void run() {
                this.f3623a.h();
            }
        });
    }

    @Override // J.n0.a
    public void d(n0 n0Var) {
        M.n.b();
        C0761b0.a("TakePictureManagerImpl", "Add a new request for retrying.");
        this.f3635a.addFirst(n0Var);
        h();
    }

    public boolean g() {
        return this.f3638d != null;
    }

    public void h() {
        M.n.b();
        Log.d("TakePictureManagerImpl", "Issue the next TakePictureRequest.");
        if (g()) {
            Log.d("TakePictureManagerImpl", "There is already a request in-flight.");
            return;
        }
        if (this.f3640f) {
            Log.d("TakePictureManagerImpl", "The class is paused.");
            return;
        }
        if (this.f3637c.h() == 0) {
            Log.d("TakePictureManagerImpl", "Too many acquire images. Close image to be able to process next.");
            return;
        }
        n0 n0VarPoll = this.f3635a.poll();
        if (n0VarPoll == null) {
            Log.d("TakePictureManagerImpl", "No new request.");
            return;
        }
        a0 a0Var = new a0(n0VarPoll, this);
        j(a0Var);
        B0.d<C0858m, X> dVarE = this.f3637c.e(n0VarPoll, a0Var, a0Var.m());
        C0858m c0858m = dVarE.f1411a;
        Objects.requireNonNull(c0858m);
        X x10 = dVarE.f1412b;
        Objects.requireNonNull(x10);
        this.f3637c.m(x10);
        a0Var.q(i(c0858m));
    }

    public final InterfaceFutureC4095a<Void> i(C0858m c0858m) {
        M.n.b();
        this.f3636b.b();
        InterfaceFutureC4095a<Void> interfaceFutureC4095aA = this.f3636b.a(c0858m.a());
        O.f.b(interfaceFutureC4095aA, new a(c0858m), N.a.d());
        return interfaceFutureC4095aA;
    }

    public final void j(final a0 a0Var) {
        B0.h.h(!g());
        this.f3638d = a0Var;
        a0Var.m().a(new Runnable() { // from class: J.f0
            @Override // java.lang.Runnable
            public final void run() {
                h0.f(this.f3626a);
            }
        }, N.a.a());
        this.f3639e.add(a0Var);
        a0Var.n().a(new Runnable() { // from class: J.g0
            @Override // java.lang.Runnable
            public final void run() {
                this.f3631a.f3639e.remove(a0Var);
            }
        }, N.a.a());
    }

    @Override // J.d0
    public void pause() {
        M.n.b();
        this.f3640f = true;
        a0 a0Var = this.f3638d;
        if (a0Var != null) {
            a0Var.k();
        }
    }

    @Override // J.d0
    public void resume() {
        M.n.b();
        this.f3640f = false;
        h();
    }
}
