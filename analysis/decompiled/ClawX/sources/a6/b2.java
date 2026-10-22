package a6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b2 extends f6.p implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final long f137e;

    public b2(long j4, h5.c cVar) {
        super(cVar, cVar.getContext());
        this.f137e = j4;
    }

    @Override // a6.p1
    public final String U() {
        return super.U() + "(timeMillis=" + this.f137e + ')';
    }

    @Override // java.lang.Runnable
    public final void run() {
        i0.j(this.f128c);
        x(new a2("Timed out waiting for " + this.f137e + " ms", this));
    }
}
