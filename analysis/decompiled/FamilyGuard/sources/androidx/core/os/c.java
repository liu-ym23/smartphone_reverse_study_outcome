package androidx.core.os;

import android.os.CancellationSignal;

@Deprecated
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private boolean f9667a;

    /* renamed from: b, reason: collision with root package name */
    private a f9668b;

    /* renamed from: c, reason: collision with root package name */
    private Object f9669c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f9670d;

    public interface a {
        void onCancel();
    }

    private void c() throws InterruptedException {
        while (this.f9670d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f9667a) {
                    return;
                }
                this.f9667a = true;
                this.f9670d = true;
                a aVar = this.f9668b;
                Object obj = this.f9669c;
                if (aVar != null) {
                    try {
                        aVar.onCancel();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f9670d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    ((CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f9670d = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    public void b(a aVar) {
        synchronized (this) {
            try {
                c();
                if (this.f9668b == aVar) {
                    return;
                }
                this.f9668b = aVar;
                if (this.f9667a && aVar != null) {
                    aVar.onCancel();
                }
            } finally {
            }
        }
    }
}
