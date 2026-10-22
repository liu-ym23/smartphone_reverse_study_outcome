package G;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public boolean f459a;

    /* renamed from: b, reason: collision with root package name */
    public b f460b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f461c;

    public final void a() {
        synchronized (this) {
            try {
                if (this.f459a) {
                    return;
                }
                this.f459a = true;
                this.f461c = true;
                b bVar = this.f460b;
                if (bVar != null) {
                    try {
                        bVar.onCancel();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f461c = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                synchronized (this) {
                    this.f461c = false;
                    notifyAll();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void b(b bVar) {
        synchronized (this) {
            while (this.f461c) {
                try {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.f460b == bVar) {
                return;
            }
            this.f460b = bVar;
            if (this.f459a) {
                bVar.onCancel();
            }
        }
    }
}
