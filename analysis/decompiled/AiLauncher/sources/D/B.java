package D;

/* loaded from: classes.dex */
public final class B {

    /* renamed from: c, reason: collision with root package name */
    public static final B f1997c = new B(0, 0);

    /* renamed from: d, reason: collision with root package name */
    public static final B f1998d = new B(1, 8);

    /* renamed from: e, reason: collision with root package name */
    public static final B f1999e = new B(2, 10);

    /* renamed from: f, reason: collision with root package name */
    public static final B f2000f = new B(3, 10);

    /* renamed from: g, reason: collision with root package name */
    public static final B f2001g = new B(4, 10);

    /* renamed from: h, reason: collision with root package name */
    public static final B f2002h = new B(5, 10);

    /* renamed from: i, reason: collision with root package name */
    public static final B f2003i = new B(6, 10);

    /* renamed from: j, reason: collision with root package name */
    public static final B f2004j = new B(6, 8);

    /* renamed from: a, reason: collision with root package name */
    public final int f2005a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2006b;

    public B(int i10, int i11) {
        this.f2005a = i10;
        this.f2006b = i11;
    }

    public static String c(int i10) {
        switch (i10) {
            case 0:
                return "UNSPECIFIED";
            case 1:
                return "SDR";
            case 2:
                return "HDR_UNSPECIFIED";
            case 3:
                return "HLG";
            case 4:
                return "HDR10";
            case 5:
                return "HDR10_PLUS";
            case 6:
                return "DOLBY_VISION";
            default:
                return "<Unknown>";
        }
    }

    public int a() {
        return this.f2006b;
    }

    public int b() {
        return this.f2005a;
    }

    public boolean d() {
        return e() && b() != 1 && a() == 10;
    }

    public boolean e() {
        return (b() == 0 || b() == 2 || a() == 0) ? false : true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof B) {
            B b10 = (B) obj;
            if (this.f2005a == b10.b() && this.f2006b == b10.a()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f2006b ^ ((this.f2005a ^ 1000003) * 1000003);
    }

    public String toString() {
        return "DynamicRange@" + Integer.toHexString(System.identityHashCode(this)) + "{encoding=" + c(this.f2005a) + ", bitDepth=" + this.f2006b + "}";
    }
}
