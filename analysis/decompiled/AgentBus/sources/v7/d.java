package v7;

/* loaded from: classes.dex */
public final class d extends b {

    /* renamed from: i, reason: collision with root package name */
    public static final d f10530i = new d(1, 0, 1);

    @Override // v7.b
    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        if (isEmpty() && ((d) obj).isEmpty()) {
            return true;
        }
        d dVar = (d) obj;
        return this.f10523f == dVar.f10523f && this.f10524g == dVar.f10524g;
    }

    @Override // v7.b
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f10523f * 31) + this.f10524g;
    }

    @Override // v7.b
    public final boolean isEmpty() {
        return this.f10523f > this.f10524g;
    }

    @Override // v7.b
    public final String toString() {
        return this.f10523f + ".." + this.f10524g;
    }
}
