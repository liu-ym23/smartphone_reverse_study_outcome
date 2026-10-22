package b8b;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f18221d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f18218a == r101.f18218a) goto L12;
        return false;
    L12:
        if (this.f18219b == r101.f18219b) goto L15;
        return false;
    L15:
        if (this.f18220c == r101.f18220c) goto L18;
        return false;
    L18:
        if (this.f18221d == r101.f18221d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f18218a * 31) + this.f18219b) * 31) + this.f18220c) * 31) + this.f18221d;
    }

    public final String toString() {
        return "AppIdInfo(id=" + this.f18218a + ", idExcludeInternalTestPackage=" + this.f18219b + ", idExcludeDebug=" + this.f18220c + ", idByPackage=" + this.f18221d + ')';
    }

    public a(int r100, int r101, int r102, int r103) {
        this.f18218a = r100;
        this.f18219b = r101;
        this.f18220c = r102;
        this.f18221d = r103;
    }
}
