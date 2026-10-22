package z4;

import s4.M;

/* loaded from: classes.dex */
public final class k extends h {

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f24118c;

    public k(Runnable runnable, long j5, i iVar) {
        super(j5, iVar);
        this.f24118c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f24118c.run();
        } finally {
            this.f24116b.a();
        }
    }

    public String toString() {
        return "Task[" + M.a(this.f24118c) + '@' + M.b(this.f24118c) + ", " + this.f24115a + ", " + this.f24116b + ']';
    }
}
