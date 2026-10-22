package x0;

import android.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;

@Deprecated
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f43461a;

    /* renamed from: b, reason: collision with root package name */
    public a f43462b;

    /* renamed from: c, reason: collision with root package name */
    public Object f43463c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f43464d;

    public interface a {
        void onCancel();
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f43461a) {
                    return;
                }
                this.f43461a = true;
                this.f43464d = true;
                a aVar = this.f43462b;
                Object obj = this.f43463c;
                if (aVar != null) {
                    try {
                        aVar.onCancel();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f43464d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    ((CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f43464d = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    public boolean b() {
        boolean z10;
        synchronized (this) {
            z10 = this.f43461a;
        }
        return z10;
    }

    public void c(a aVar) {
        synchronized (this) {
            try {
                e();
                if (this.f43462b == aVar) {
                    return;
                }
                this.f43462b = aVar;
                if (this.f43461a && aVar != null) {
                    aVar.onCancel();
                }
            } finally {
            }
        }
    }

    public void d() {
        if (b()) {
            throw new OperationCanceledException();
        }
    }

    public final void e() throws InterruptedException {
        while (this.f43464d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}
