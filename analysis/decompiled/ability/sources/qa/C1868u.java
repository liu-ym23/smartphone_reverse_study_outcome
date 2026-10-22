package qa;

/* renamed from: qa.u, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1868u extends F9.P {
    public final F9.B b;
    public final long c;

    public C1868u(F9.B b, long j5) {
        this.b = b;
        this.c = j5;
    }

    @Override // F9.P
    public final long b() {
        return this.c;
    }

    @Override // F9.P
    public final F9.B c() {
        return this.b;
    }

    @Override // F9.P
    public final V9.i f() {
        throw new IllegalStateException("Cannot read raw response body of a converted body.");
    }
}
