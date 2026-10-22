package U;

import D.AbstractC0772i;
import D.C0761b0;
import D.r0;
import D.s0;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.SurfaceRequest;
import g3.InterfaceFutureC4095a;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public class X implements Q {

    /* renamed from: a, reason: collision with root package name */
    public final s0 f6083a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f6084b;

    /* renamed from: c, reason: collision with root package name */
    public final B0.a<Throwable> f6085c;

    public X(AbstractC0772i abstractC0772i) {
        s0 s0VarF = abstractC0772i.f();
        Objects.requireNonNull(s0VarF);
        this.f6083a = s0VarF;
        this.f6084b = abstractC0772i.c();
        this.f6085c = abstractC0772i.b();
    }

    @Override // D.s0
    public void a(final SurfaceRequest surfaceRequest) {
        try {
            this.f6084b.execute(new Runnable() { // from class: U.V
                @Override // java.lang.Runnable
                public final void run() throws ProcessingException {
                    this.f6079a.f6083a.a(surfaceRequest);
                }
            });
        } catch (RejectedExecutionException unused) {
            C0761b0.c("SurfaceProcessor", "SurfaceProcessor failed due to executor shutdown");
        }
    }

    @Override // U.Q
    public InterfaceFutureC4095a<Void> b(int i10, int i11) {
        return O.f.f(new Exception("Snapshot not supported by external SurfaceProcessor"));
    }

    @Override // D.s0
    public void c(final r0 r0Var) {
        try {
            this.f6084b.execute(new Runnable() { // from class: U.W
                @Override // java.lang.Runnable
                public final void run() throws ProcessingException {
                    this.f6081a.f6083a.c(r0Var);
                }
            });
        } catch (RejectedExecutionException unused) {
            C0761b0.c("SurfaceProcessor", "SurfaceProcessor failed due to executor shutdown");
        }
    }

    @Override // U.Q
    public void release() {
    }

    public String toString() {
        return "SurfaceProcessorWithExecutor(" + this.f6083a + ")";
    }
}
