package b31;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f17174g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f17180f;

    public static final class a {
        public a() {
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L18;
        e r101 = (e) r100;
        if (this.f17175a == r101.f17175a) goto L8;
        return false;
    L8:
        if (this.f17176b == r101.f17176b) goto L10;
        return false;
    L10:
        if (this.f17177c == r101.f17177c) goto L12;
        return false;
    L12:
        if (this.f17178d == r101.f17178d) goto L14;
        return false;
    L14:
        if (this.f17179e == r101.f17179e) goto L16;
        return false;
    L16:
        if (this.f17180f == r101.f17180f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        return (((((((((this.f17175a * 31) + this.f17176b) * 31) + this.f17177c) * 31) + this.f17178d) * 31) + this.f17179e) * 31) + this.f17180f;
    }

    public final String toString() {
        return "MultiSeiLayout(width=" + this.f17175a + ", height=" + this.f17176b + ", topMargin=" + this.f17177c + ", leftMargin=" + this.f17178d + ", contentW=" + this.f17179e + ", containerW=" + this.f17180f + ")";
    }

    static {
        f17174g = new a();
    }

    public e(int r100, int r101, int r102, int r103, int r104, int r105) {
        this.f17175a = r100;
        this.f17176b = r101;
        this.f17177c = r102;
        this.f17178d = r103;
        this.f17179e = r104;
        this.f17180f = r105;
    }
}
