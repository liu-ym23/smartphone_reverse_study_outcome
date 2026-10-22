package d1;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public long f2764a;

    /* renamed from: b, reason: collision with root package name */
    public float f2765b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f2764a == aVar.f2764a && Float.compare(this.f2765b, aVar.f2765b) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f2765b) + (Long.hashCode(this.f2764a) * 31);
    }

    public final String toString() {
        return "DataPointAtTime(time=" + this.f2764a + ", dataPoint=" + this.f2765b + ')';
    }
}
