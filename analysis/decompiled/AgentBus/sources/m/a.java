package m;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final float f6036a;

    /* renamed from: b, reason: collision with root package name */
    public final float f6037b;

    public a(float f10, float f11) {
        this.f6036a = f10;
        this.f6037b = f11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(this.f6036a, aVar.f6036a) == 0 && Float.compare(this.f6037b, aVar.f6037b) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f6037b) + (Float.hashCode(this.f6036a) * 31);
    }

    public final String toString() {
        return "FlingResult(distanceCoefficient=" + this.f6036a + ", velocityCoefficient=" + this.f6037b + ')';
    }
}
