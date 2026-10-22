package q5;

import androidx.room.b0;
import g5.u;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public n f10094c;

    /* renamed from: f, reason: collision with root package name */
    public p5.j f10095f;

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f10094c.f10100d) {
            try {
                if (((m) this.f10094c.f10098b.remove(this.f10095f)) != null) {
                    j5.f fVar = (j5.f) this.f10094c.f10099c.remove(this.f10095f);
                    if (fVar != null) {
                        p5.j jVar = this.f10095f;
                        u.d().a(j5.f.f6571s, "Exceeded time limits on execution for " + jVar);
                        b0 b0Var = fVar.f6578l;
                        j5.e eVar = new j5.e(0);
                        eVar.f6570f = fVar;
                        VarHandle.storeStoreFence();
                        b0Var.execute(eVar);
                    }
                } else {
                    u.d().a("WrkTimerRunnable", "Timer with " + this.f10095f + " is already marked as complete.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
