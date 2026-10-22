package n2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: c, reason: collision with root package name */
    public static final i f8656c = new i(f.f8652c, 17);

    /* renamed from: a, reason: collision with root package name */
    public final float f8657a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8658b;

    public i(float f5, int i) {
        this.f8657a = f5;
        this.f8658b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        float f5 = iVar.f8657a;
        float f10 = f.f8651b;
        return Float.compare(this.f8657a, f5) == 0 && this.f8658b == iVar.f8658b;
    }

    public final int hashCode() {
        float f5 = f.f8651b;
        return Integer.hashCode(0) + s.f.b(this.f8658b, Float.hashCode(this.f8657a) * 31, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("LineHeightStyle(alignment=");
        sb2.append((Object) f.b(this.f8657a));
        sb2.append(", trim=");
        int i = this.f8658b;
        sb2.append((Object) (i == 1 ? "LineHeightStyle.Trim.FirstLineTop" : i == 16 ? "LineHeightStyle.Trim.LastLineBottom" : i == 17 ? "LineHeightStyle.Trim.Both" : i == 0 ? "LineHeightStyle.Trim.None" : "Invalid"));
        sb2.append(",mode=Mode(value=0))");
        return sb2.toString();
    }
}
