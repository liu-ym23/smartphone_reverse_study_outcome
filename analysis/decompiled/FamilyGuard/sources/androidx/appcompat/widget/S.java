package androidx.appcompat.widget;

/* loaded from: classes.dex */
class S {

    /* renamed from: a, reason: collision with root package name */
    private int f8244a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f8245b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f8246c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    private int f8247d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    private int f8248e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f8249f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f8250g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f8251h = false;

    S() {
    }

    public int a() {
        return this.f8250g ? this.f8244a : this.f8245b;
    }

    public int b() {
        return this.f8244a;
    }

    public int c() {
        return this.f8245b;
    }

    public int d() {
        return this.f8250g ? this.f8245b : this.f8244a;
    }

    public void e(int i5, int i6) {
        this.f8251h = false;
        if (i5 != Integer.MIN_VALUE) {
            this.f8248e = i5;
            this.f8244a = i5;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.f8249f = i6;
            this.f8245b = i6;
        }
    }

    public void f(boolean z5) {
        if (z5 == this.f8250g) {
            return;
        }
        this.f8250g = z5;
        if (!this.f8251h) {
            this.f8244a = this.f8248e;
            this.f8245b = this.f8249f;
            return;
        }
        if (z5) {
            int i5 = this.f8247d;
            if (i5 == Integer.MIN_VALUE) {
                i5 = this.f8248e;
            }
            this.f8244a = i5;
            int i6 = this.f8246c;
            if (i6 == Integer.MIN_VALUE) {
                i6 = this.f8249f;
            }
            this.f8245b = i6;
            return;
        }
        int i7 = this.f8246c;
        if (i7 == Integer.MIN_VALUE) {
            i7 = this.f8248e;
        }
        this.f8244a = i7;
        int i8 = this.f8247d;
        if (i8 == Integer.MIN_VALUE) {
            i8 = this.f8249f;
        }
        this.f8245b = i8;
    }

    public void g(int i5, int i6) {
        this.f8246c = i5;
        this.f8247d = i6;
        this.f8251h = true;
        if (this.f8250g) {
            if (i6 != Integer.MIN_VALUE) {
                this.f8244a = i6;
            }
            if (i5 != Integer.MIN_VALUE) {
                this.f8245b = i5;
                return;
            }
            return;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.f8244a = i5;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.f8245b = i6;
        }
    }
}
