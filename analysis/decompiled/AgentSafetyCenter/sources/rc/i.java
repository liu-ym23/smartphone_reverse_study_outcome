package rc;

import kc.w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends h {

    /* renamed from: g, reason: collision with root package name */
    public Runnable f10559g;

    @Override // java.lang.Runnable
    public final void run() {
        this.f10559g.run();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Task[");
        Runnable runnable = this.f10559g;
        sb2.append(runnable.getClass().getSimpleName());
        sb2.append('@');
        sb2.append(w.m(runnable));
        sb2.append(", ");
        sb2.append(this.f10557c);
        sb2.append(", ");
        return k0.a.s(sb2, this.f10558f ? "Blocking" : "Non-blocking", ']');
    }
}
