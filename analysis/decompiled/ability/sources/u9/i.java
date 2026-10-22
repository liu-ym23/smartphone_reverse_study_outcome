package u9;

import m9.AbstractC1683A;

/* loaded from: classes4.dex */
public final class i extends h {
    public final Runnable c;

    public i(Runnable runnable, long j5, boolean z10) {
        super(j5, z10);
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.run();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.c;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(AbstractC1683A.i(runnable));
        sb.append(", ");
        sb.append(this.f6746a);
        sb.append(", ");
        return B7.a.g(']', this.b ? "Blocking" : "Non-blocking", sb);
    }
}
