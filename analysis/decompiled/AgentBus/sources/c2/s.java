package c2;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: c, reason: collision with root package name */
    public static final s f1887c = new s(2, false);

    /* renamed from: d, reason: collision with root package name */
    public static final s f1888d = new s(1, true);

    /* renamed from: a, reason: collision with root package name */
    public final int f1889a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1890b;

    public s(int i2, boolean z4) {
        this.f1889a = i2;
        this.f1890b = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f1889a == sVar.f1889a && this.f1890b == sVar.f1890b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f1890b) + (Integer.hashCode(this.f1889a) * 31);
    }

    public final String toString() {
        return equals(f1887c) ? "TextMotion.Static" : equals(f1888d) ? "TextMotion.Animated" : "Invalid";
    }
}
