package D2;

import com.google.android.gms.tasks.RuntimeExecutionException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f2242a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ A f2243b;

    public z(A a10, i iVar) {
        this.f2243b = a10;
        this.f2242a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i iVarA = this.f2243b.f2203b.a(this.f2242a.i());
            if (iVarA == null) {
                this.f2243b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            A a10 = this.f2243b;
            Executor executor = k.f2219b;
            iVarA.g(executor, a10);
            iVarA.e(executor, this.f2243b);
            iVarA.a(executor, this.f2243b);
        } catch (RuntimeExecutionException e10) {
            if (e10.getCause() instanceof Exception) {
                this.f2243b.onFailure((Exception) e10.getCause());
            } else {
                this.f2243b.onFailure(e10);
            }
        } catch (CancellationException unused) {
            this.f2243b.b();
        } catch (Exception e11) {
            this.f2243b.onFailure(e11);
        }
    }
}
