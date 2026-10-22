package p1;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final e f8274b = new e(new v7.a());

    /* renamed from: a, reason: collision with root package name */
    public final v7.a f8275a;

    public e(v7.a aVar) {
        this.f8275a = aVar;
        if (Float.isNaN(0.0f)) {
            throw new IllegalArgumentException("current must not be NaN");
        }
    }

    public final v7.a a() {
        return this.f8275a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && this.f8275a.equals(((e) obj).f8275a);
    }

    public final int hashCode() {
        return (this.f8275a.hashCode() + (Float.hashCode(0.0f) * 31)) * 31;
    }

    public final String toString() {
        return "ProgressBarRangeInfo(current=0.0, range=" + this.f8275a + ", steps=0)";
    }
}
