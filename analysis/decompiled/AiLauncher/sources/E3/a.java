package E3;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: h, reason: collision with root package name */
    public static final a f2361h = new a(4201, 4096, 1);

    /* renamed from: i, reason: collision with root package name */
    public static final a f2362i = new a(1033, 1024, 1);

    /* renamed from: j, reason: collision with root package name */
    public static final a f2363j;

    /* renamed from: k, reason: collision with root package name */
    public static final a f2364k;

    /* renamed from: l, reason: collision with root package name */
    public static final a f2365l;

    /* renamed from: m, reason: collision with root package name */
    public static final a f2366m;

    /* renamed from: n, reason: collision with root package name */
    public static final a f2367n;

    /* renamed from: o, reason: collision with root package name */
    public static final a f2368o;

    /* renamed from: a, reason: collision with root package name */
    public final int[] f2369a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f2370b;

    /* renamed from: c, reason: collision with root package name */
    public final b f2371c;

    /* renamed from: d, reason: collision with root package name */
    public final b f2372d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2373e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2374f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2375g;

    static {
        a aVar = new a(67, 64, 1);
        f2363j = aVar;
        f2364k = new a(19, 16, 1);
        f2365l = new a(285, 256, 0);
        a aVar2 = new a(301, 256, 1);
        f2366m = aVar2;
        f2367n = aVar2;
        f2368o = aVar;
    }

    public a(int i10, int i11, int i12) {
        this.f2374f = i10;
        this.f2373e = i11;
        this.f2375g = i12;
        this.f2369a = new int[i11];
        this.f2370b = new int[i11];
        int i13 = 1;
        for (int i14 = 0; i14 < i11; i14++) {
            this.f2369a[i14] = i13;
            i13 *= 2;
            if (i13 >= i11) {
                i13 = (i13 ^ i10) & (i11 - 1);
            }
        }
        for (int i15 = 0; i15 < i11 - 1; i15++) {
            this.f2370b[this.f2369a[i15]] = i15;
        }
        this.f2371c = new b(this, new int[]{0});
        this.f2372d = new b(this, new int[]{1});
    }

    public static int a(int i10, int i11) {
        return i10 ^ i11;
    }

    public b b(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (i11 == 0) {
            return this.f2371c;
        }
        int[] iArr = new int[i10 + 1];
        iArr[0] = i11;
        return new b(this, iArr);
    }

    public int c(int i10) {
        return this.f2369a[i10];
    }

    public int d() {
        return this.f2375g;
    }

    public b e() {
        return this.f2371c;
    }

    public int f(int i10) {
        if (i10 != 0) {
            return this.f2369a[(this.f2373e - this.f2370b[i10]) - 1];
        }
        throw new ArithmeticException();
    }

    public int g(int i10) {
        if (i10 != 0) {
            return this.f2370b[i10];
        }
        throw new IllegalArgumentException();
    }

    public int h(int i10, int i11) {
        if (i10 == 0 || i11 == 0) {
            return 0;
        }
        int[] iArr = this.f2369a;
        int[] iArr2 = this.f2370b;
        return iArr[(iArr2[i10] + iArr2[i11]) % (this.f2373e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f2374f) + ',' + this.f2373e + ')';
    }
}
