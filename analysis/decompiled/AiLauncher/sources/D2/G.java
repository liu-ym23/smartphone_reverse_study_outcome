package D2;

import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.tasks.DuplicateTaskCompletionException;
import com.google.android.gms.tasks.RuntimeExecutionException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class G<TResult> extends i<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2210a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final C f2211b = new C();

    /* renamed from: c, reason: collision with root package name */
    public boolean f2212c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f2213d;

    /* renamed from: e, reason: collision with root package name */
    public Object f2214e;

    /* renamed from: f, reason: collision with root package name */
    public Exception f2215f;

    @Override // D2.i
    public final i<TResult> a(Executor executor, InterfaceC0791c interfaceC0791c) {
        this.f2211b.a(new s(executor, interfaceC0791c));
        v();
        return this;
    }

    @Override // D2.i
    public final i<TResult> b(InterfaceC0792d<TResult> interfaceC0792d) {
        this.f2211b.a(new u(k.f2218a, interfaceC0792d));
        v();
        return this;
    }

    @Override // D2.i
    public final i<TResult> c(Executor executor, InterfaceC0792d<TResult> interfaceC0792d) {
        this.f2211b.a(new u(executor, interfaceC0792d));
        v();
        return this;
    }

    @Override // D2.i
    public final i<TResult> d(InterfaceC0793e interfaceC0793e) {
        e(k.f2218a, interfaceC0793e);
        return this;
    }

    @Override // D2.i
    public final i<TResult> e(Executor executor, InterfaceC0793e interfaceC0793e) {
        this.f2211b.a(new w(executor, interfaceC0793e));
        v();
        return this;
    }

    @Override // D2.i
    public final i<TResult> f(InterfaceC0794f<? super TResult> interfaceC0794f) {
        g(k.f2218a, interfaceC0794f);
        return this;
    }

    @Override // D2.i
    public final i<TResult> g(Executor executor, InterfaceC0794f<? super TResult> interfaceC0794f) {
        this.f2211b.a(new y(executor, interfaceC0794f));
        v();
        return this;
    }

    @Override // D2.i
    public final Exception h() {
        Exception exc;
        synchronized (this.f2210a) {
            exc = this.f2215f;
        }
        return exc;
    }

    @Override // D2.i
    public final TResult i() {
        TResult tresult;
        synchronized (this.f2210a) {
            try {
                s();
                t();
                Exception exc = this.f2215f;
                if (exc != null) {
                    throw new RuntimeExecutionException(exc);
                }
                tresult = (TResult) this.f2214e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tresult;
    }

    @Override // D2.i
    public final boolean j() {
        return this.f2213d;
    }

    @Override // D2.i
    public final boolean k() {
        boolean z10;
        synchronized (this.f2210a) {
            z10 = this.f2212c;
        }
        return z10;
    }

    @Override // D2.i
    public final boolean l() {
        boolean z10;
        synchronized (this.f2210a) {
            try {
                z10 = false;
                if (this.f2212c && !this.f2213d && this.f2215f == null) {
                    z10 = true;
                }
            } finally {
            }
        }
        return z10;
    }

    @Override // D2.i
    public final <TContinuationResult> i<TContinuationResult> m(h<TResult, TContinuationResult> hVar) {
        Executor executor = k.f2218a;
        G g10 = new G();
        this.f2211b.a(new A(executor, hVar, g10));
        v();
        return g10;
    }

    public final void n(Exception exc) {
        C1669j.l(exc, "Exception must not be null");
        synchronized (this.f2210a) {
            u();
            this.f2212c = true;
            this.f2215f = exc;
        }
        this.f2211b.b(this);
    }

    public final void o(Object obj) {
        synchronized (this.f2210a) {
            u();
            this.f2212c = true;
            this.f2214e = obj;
        }
        this.f2211b.b(this);
    }

    public final boolean p() {
        synchronized (this.f2210a) {
            try {
                if (this.f2212c) {
                    return false;
                }
                this.f2212c = true;
                this.f2213d = true;
                this.f2211b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean q(Exception exc) {
        C1669j.l(exc, "Exception must not be null");
        synchronized (this.f2210a) {
            try {
                if (this.f2212c) {
                    return false;
                }
                this.f2212c = true;
                this.f2215f = exc;
                this.f2211b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean r(Object obj) {
        synchronized (this.f2210a) {
            try {
                if (this.f2212c) {
                    return false;
                }
                this.f2212c = true;
                this.f2214e = obj;
                this.f2211b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void s() {
        C1669j.o(this.f2212c, "Task is not yet complete");
    }

    public final void t() {
        if (this.f2213d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    public final void u() {
        if (this.f2212c) {
            throw DuplicateTaskCompletionException.a(this);
        }
    }

    public final void v() {
        synchronized (this.f2210a) {
            try {
                if (this.f2212c) {
                    this.f2211b.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
