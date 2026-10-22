package ia;

/* loaded from: classes.dex */
public final class b2 extends na.r implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final long f4921j;

    public b2(long j2, i7.c cVar) {
        super(cVar, cVar.getContext());
        this.f4921j = j2;
    }

    @Override // ia.o1
    public final String Z() {
        return super.Z() + "(timeMillis=" + this.f4921j + ')';
    }

    @Override // java.lang.Runnable
    public final void run() {
        d0.j(this.f4915h);
        B(new a2("Timed out waiting for " + this.f4921j + " ms", this));
    }
}
