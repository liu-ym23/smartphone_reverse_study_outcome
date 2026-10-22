package bm8;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f19631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f19632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f19633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f19634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f19635h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f19628a == r101.f19628a) goto L12;
        return false;
    L12:
        if (this.f19629b == r101.f19629b) goto L15;
        return false;
    L15:
        if (this.f19630c == r101.f19630c) goto L18;
        return false;
    L18:
        if (this.f19631d == r101.f19631d) goto L21;
        return false;
    L21:
        if (this.f19632e == r101.f19632e) goto L24;
        return false;
    L24:
        if (this.f19633f == r101.f19633f) goto L27;
        return false;
    L27:
        if (this.f19634g == r101.f19634g) goto L30;
        return false;
    L30:
        if (this.f19635h == r101.f19635h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f19628a * 31) + this.f19629b) * 31) + this.f19630c) * 31) + this.f19631d) * 31;
        int r101 = 1231;
        if (this.f19632e == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f19633f == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f19634g == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f19635h == true) goto L19;
        r101 = 1237;
    L19:
        return r107 + r101;
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppletUIConfig(lynxMaxWidth=" + this.f19628a + ", defaultWidth=" + this.f19629b + ", currentHeight=" + this.f19630c + ", padding=" + this.f19631d + ", isFullBlock=" + this.f19632e + ", isInStart=" + this.f19633f + ", isInEnd=" + this.f19634g + ", isFullWidth=" + this.f19635h + ')';
    }

    public b(int r100, int r101, int r102, int r103, boolean r104, boolean r105, boolean r106, boolean r107) {
        this.f19628a = r100;
        this.f19629b = r101;
        this.f19630c = r102;
        this.f19631d = r103;
        this.f19632e = r104;
        this.f19633f = r105;
        this.f19634g = r106;
        this.f19635h = r107;
    }
}
