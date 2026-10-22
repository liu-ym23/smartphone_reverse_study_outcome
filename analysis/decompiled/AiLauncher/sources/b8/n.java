package b8;

/* loaded from: classes4.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f15291a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f15292b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f15293c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f15294d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f15295e;

    public n(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        this.f15291a = z10;
        this.f15292b = z11;
        this.f15293c = z12;
        this.f15294d = z13;
        this.f15295e = z14;
    }

    public static n a() {
        return new n(false, false, false, true, true);
    }

    public boolean b() {
        return this.f15292b;
    }

    public boolean c() {
        return this.f15293c;
    }

    public boolean d() {
        return this.f15294d;
    }

    public boolean e() {
        return this.f15291a;
    }

    public boolean f() {
        return this.f15295e;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ConfigRenderOptions(");
        if (this.f15291a) {
            sb2.append("originComments,");
        }
        if (this.f15292b) {
            sb2.append("comments,");
        }
        if (this.f15293c) {
            sb2.append("formatted,");
        }
        if (this.f15294d) {
            sb2.append("json,");
        }
        if (this.f15295e) {
            sb2.append("showEnvVariableValues,");
        }
        if (sb2.charAt(sb2.length() - 1) == ',') {
            sb2.setLength(sb2.length() - 1);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
