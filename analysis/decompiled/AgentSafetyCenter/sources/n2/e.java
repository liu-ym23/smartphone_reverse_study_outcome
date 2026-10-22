package n2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final int f8649b = 66305;

    /* renamed from: a, reason: collision with root package name */
    public int f8650a;

    public static String a(int i) {
        StringBuilder sb2 = new StringBuilder("LineBreak(strategy=");
        int i3 = i & 255;
        String str = "Invalid";
        sb2.append((Object) (i3 == 1 ? "Strategy.Simple" : i3 == 2 ? "Strategy.HighQuality" : i3 == 3 ? "Strategy.Balanced" : i3 == 0 ? "Strategy.Unspecified" : "Invalid"));
        sb2.append(", strictness=");
        int i10 = (i >> 8) & 255;
        sb2.append((Object) (i10 == 1 ? "Strictness.None" : i10 == 2 ? "Strictness.Loose" : i10 == 3 ? "Strictness.Normal" : i10 == 4 ? "Strictness.Strict" : i10 == 0 ? "Strictness.Unspecified" : "Invalid"));
        sb2.append(", wordBreak=");
        int i11 = (i >> 16) & 255;
        if (i11 == 1) {
            str = "WordBreak.None";
        } else if (i11 == 2) {
            str = "WordBreak.Phrase";
        } else if (i11 == 0) {
            str = "WordBreak.Unspecified";
        }
        sb2.append((Object) str);
        sb2.append(')');
        return sb2.toString();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof e) && this.f8650a == ((e) obj).f8650a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f8650a);
    }

    public final String toString() {
        return a(this.f8650a);
    }
}
