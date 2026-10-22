package n2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    public static final float f8651b;

    /* renamed from: c, reason: collision with root package name */
    public static final float f8652c;

    /* renamed from: d, reason: collision with root package name */
    public static final float f8653d;

    /* renamed from: a, reason: collision with root package name */
    public float f8654a;

    static {
        a(0.0f);
        a(0.5f);
        f8651b = 0.5f;
        a(-1.0f);
        f8652c = -1.0f;
        a(1.0f);
        f8653d = 1.0f;
    }

    public static void a(float f5) {
        if ((0.0f > f5 || f5 > 1.0f) && f5 != -1.0f) {
            i2.a.b("topRatio should be in [0..1] range or -1");
        }
    }

    public static String b(float f5) {
        if (f5 == 0.0f) {
            return "LineHeightStyle.Alignment.Top";
        }
        if (f5 == f8651b) {
            return "LineHeightStyle.Alignment.Center";
        }
        if (f5 == f8652c) {
            return "LineHeightStyle.Alignment.Proportional";
        }
        if (f5 == f8653d) {
            return "LineHeightStyle.Alignment.Bottom";
        }
        return "LineHeightStyle.Alignment(topPercentage = " + f5 + ')';
    }

    public final boolean equals(Object obj) {
        return (obj instanceof f) && Float.compare(this.f8654a, ((f) obj).f8654a) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f8654a);
    }

    public final String toString() {
        return b(this.f8654a);
    }
}
