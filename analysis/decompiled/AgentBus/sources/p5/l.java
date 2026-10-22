package p5;

/* loaded from: classes.dex */
public final class l extends n7.o {

    /* renamed from: b, reason: collision with root package name */
    public final d5.m f8473b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(d5.m mVar) {
        super(5);
        q7.k.e(mVar, "role");
        this.f8473b = mVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l) && this.f8473b == ((l) obj).f8473b;
    }

    @Override // n7.o
    public final int hashCode() {
        return this.f8473b.hashCode();
    }

    @Override // n7.o
    public final String toString() {
        return "ByRole(role=" + this.f8473b + ")";
    }
}
