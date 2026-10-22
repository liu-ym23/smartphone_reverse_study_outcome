package kotlin.ranges;

/* loaded from: classes.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    private final float f17959a;

    /* renamed from: b, reason: collision with root package name */
    private final float f17960b;

    public boolean a() {
        return this.f17959a > this.f17960b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        if (a() && ((e) obj).a()) {
            return true;
        }
        e eVar = (e) obj;
        return this.f17959a == eVar.f17959a && this.f17960b == eVar.f17960b;
    }

    public int hashCode() {
        if (a()) {
            return -1;
        }
        return (Float.hashCode(this.f17959a) * 31) + Float.hashCode(this.f17960b);
    }

    public String toString() {
        return this.f17959a + ".." + this.f17960b;
    }
}
