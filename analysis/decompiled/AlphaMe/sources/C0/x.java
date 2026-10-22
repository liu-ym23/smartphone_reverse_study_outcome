package C0;

/* loaded from: classes.dex */
public final class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final y f328a;

    /* renamed from: b, reason: collision with root package name */
    public final B0.k f329b;

    public x(y yVar, B0.k kVar) {
        this.f328a = yVar;
        this.f329b = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f328a.f334d) {
            try {
                if (((x) this.f328a.f332b.remove(this.f329b)) != null) {
                    w wVar = (w) this.f328a.f333c.remove(this.f329b);
                    if (wVar != null) {
                        B0.k kVar = this.f329b;
                        v0.g gVar = (v0.g) wVar;
                        s0.t.d().a(v0.g.f15690o, "Exceeded time limits on execution for " + kVar);
                        gVar.f15698h.execute(new v0.f(gVar, 4));
                    }
                } else {
                    s0.t.d().a("WrkTimerRunnable", "Timer with " + this.f329b + " is already marked as complete.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
