package kc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o1 extends pc.q implements Runnable {
    public long i;

    @Override // kc.e1
    public final String Q() {
        return super.Q() + "(timeMillis=" + this.i + ')';
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j10 = this.i;
        w.l(this.f7414g);
        t(new n1("Timed out waiting for " + j10 + " ms", this));
    }
}
