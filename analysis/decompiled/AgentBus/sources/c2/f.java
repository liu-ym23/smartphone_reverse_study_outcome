package c2;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    public static final float f1863b;

    /* renamed from: c, reason: collision with root package name */
    public static final float f1864c;

    /* renamed from: d, reason: collision with root package name */
    public static final float f1865d;

    /* renamed from: a, reason: collision with root package name */
    public final float f1866a;

    static {
        a(0.0f);
        a(0.5f);
        f1863b = 0.5f;
        a(-1.0f);
        f1864c = -1.0f;
        a(1.0f);
        f1865d = 1.0f;
    }

    public static void a(float f10) {
        if ((0.0f > f10 || f10 > 1.0f) && f10 != -1.0f) {
            x1.a.b("topRatio should be in [0..1] range or -1");
        }
    }

    public static String b(float f10) {
        if (f10 == 0.0f) {
            return "LineHeightStyle.Alignment.Top";
        }
        if (f10 == f1863b) {
            return "LineHeightStyle.Alignment.Center";
        }
        if (f10 == f1864c) {
            return "LineHeightStyle.Alignment.Proportional";
        }
        if (f10 == f1865d) {
            return "LineHeightStyle.Alignment.Bottom";
        }
        return "LineHeightStyle.Alignment(topPercentage = " + f10 + ')';
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            return Float.compare(this.f1866a, ((f) obj).f1866a) == 0;
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.f1866a);
    }

    public final String toString() {
        return b(this.f1866a);
    }
}
