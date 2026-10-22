package Y7;

/* loaded from: classes3.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final float f1568a;
    public final float b;

    public a(float f, float f7) {
        this.f1568a = f;
        this.b = f7;
    }

    public final boolean a() {
        return this.f1568a > this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b(Comparable comparable, Comparable comparable2) {
        return ((Number) comparable).floatValue() <= ((Number) comparable2).floatValue();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        if (a() && ((a) obj).a()) {
            return true;
        }
        a aVar = (a) obj;
        return this.f1568a == aVar.f1568a && this.b == aVar.b;
    }

    @Override // Y7.c
    public final Comparable getEndInclusive() {
        return Float.valueOf(this.b);
    }

    @Override // Y7.c
    public final Comparable getStart() {
        return Float.valueOf(this.f1568a);
    }

    public final int hashCode() {
        if (a()) {
            return -1;
        }
        return Float.hashCode(this.b) + (Float.hashCode(this.f1568a) * 31);
    }

    public final String toString() {
        return this.f1568a + ".." + this.b;
    }
}
