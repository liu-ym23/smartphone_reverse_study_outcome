package g5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends e0 {
    @Override // g5.e0
    public final f0 b() {
        if (this.f4308a && this.f4310c.f9772j.f4290d) {
            f.s("Cannot set backoff criteria on an idle mode job");
            return null;
        }
        p5.p pVar = this.f4310c;
        if (!pVar.f9779q) {
            return new b0(this.f4309b, pVar, this.f4311d);
        }
        f.s("PeriodicWorkRequests cannot be expedited");
        return null;
    }

    @Override // g5.e0
    public final e0 c() {
        return this;
    }
}
