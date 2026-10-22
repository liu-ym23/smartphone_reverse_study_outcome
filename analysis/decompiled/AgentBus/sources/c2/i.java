package c2;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: c, reason: collision with root package name */
    public static final i f1868c = new i(17, f.f1864c);

    /* renamed from: a, reason: collision with root package name */
    public final float f1869a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1870b;

    public i(int i2, float f10) {
        this.f1869a = f10;
        this.f1870b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        float f10 = iVar.f1869a;
        float f11 = f.f1863b;
        return Float.compare(this.f1869a, f10) == 0 && this.f1870b == iVar.f1870b;
    }

    public final int hashCode() {
        float f10 = f.f1863b;
        return Integer.hashCode(0) + n.f.b(this.f1870b, Float.hashCode(this.f1869a) * 31, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("LineHeightStyle(alignment=");
        sb2.append((Object) f.b(this.f1869a));
        sb2.append(", trim=");
        int i2 = this.f1870b;
        sb2.append((Object) (i2 == 1 ? "LineHeightStyle.Trim.FirstLineTop" : i2 == 16 ? "LineHeightStyle.Trim.LastLineBottom" : i2 == 17 ? "LineHeightStyle.Trim.Both" : i2 == 0 ? "LineHeightStyle.Trim.None" : "Invalid"));
        sb2.append(",mode=Mode(value=0))");
        return sb2.toString();
    }
}
