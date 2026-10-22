package D2;

/* loaded from: classes2.dex */
public final class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f2227a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f2228b;

    public t(u uVar, i iVar) {
        this.f2228b = uVar;
        this.f2227a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f2228b.f2230b) {
            try {
                u uVar = this.f2228b;
                if (uVar.f2231c != null) {
                    uVar.f2231c.a(this.f2227a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
