package pa;

import ia.d0;

/* loaded from: classes.dex */
public final class j extends i {

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f8563h;

    public j(Runnable runnable, long j2, boolean z4) {
        super(j2, z4);
        this.f8563h = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8563h.run();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Task[");
        Runnable runnable = this.f8563h;
        sb2.append(runnable.getClass().getSimpleName());
        sb2.append('@');
        sb2.append(d0.k(runnable));
        sb2.append(", ");
        sb2.append(this.f8561f);
        sb2.append(", ");
        return a1.a.l(sb2, this.f8562g ? "Blocking" : "Non-blocking", ']');
    }
}
