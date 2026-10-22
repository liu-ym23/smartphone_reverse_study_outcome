package c2;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final int f1867a;

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.f1867a == ((h) obj).f1867a;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f1867a);
    }

    public final String toString() {
        int i2 = this.f1867a;
        return i2 == 1 ? "LineHeightStyle.Trim.FirstLineTop" : i2 == 16 ? "LineHeightStyle.Trim.LastLineBottom" : i2 == 17 ? "LineHeightStyle.Trim.Both" : i2 == 0 ? "LineHeightStyle.Trim.None" : "Invalid";
    }
}
