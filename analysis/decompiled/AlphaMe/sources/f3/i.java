package f3;

import Z2.I;

/* loaded from: classes2.dex */
public final class i extends h {

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f12572c;

    public i(Runnable runnable, long j4, E3.b bVar) {
        super(j4, bVar);
        this.f12572c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f12572c.run();
        } finally {
            this.f12571b.getClass();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.f12572c;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(I.p(runnable));
        sb.append(", ");
        sb.append(this.f12570a);
        sb.append(", ");
        sb.append(this.f12571b);
        sb.append(']');
        return sb.toString();
    }
}
