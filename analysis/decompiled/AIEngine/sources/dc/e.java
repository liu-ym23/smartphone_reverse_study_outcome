package dc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends c implements b<Integer> {

    /* renamed from: d, reason: collision with root package name */
    public static final e f8458d = new e(1, 0, 1);

    @Override // dc.b
    public final Comparable b() {
        return Integer.valueOf(this.f8451a);
    }

    @Override // dc.b
    public final Comparable c() {
        return Integer.valueOf(this.f8452b);
    }

    @Override // dc.c
    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        if (isEmpty() && ((e) obj).isEmpty()) {
            return true;
        }
        e eVar = (e) obj;
        return this.f8451a == eVar.f8451a && this.f8452b == eVar.f8452b;
    }

    @Override // dc.c
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f8451a * 31) + this.f8452b;
    }

    @Override // dc.c, dc.b
    public final boolean isEmpty() {
        return this.f8451a > this.f8452b;
    }

    @Override // dc.c
    public final String toString() {
        return this.f8451a + ".." + this.f8452b;
    }
}
