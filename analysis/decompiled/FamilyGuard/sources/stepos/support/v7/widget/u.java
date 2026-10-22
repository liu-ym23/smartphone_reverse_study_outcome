package stepos.support.v7.widget;

/* loaded from: classes.dex */
class u {

    /* renamed from: a, reason: collision with root package name */
    private int f22179a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f22180b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f22181c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    private int f22182d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    private int f22183e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f22184f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f22185g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f22186h = false;

    u() {
    }

    public int a() {
        return this.f22185g ? this.f22179a : this.f22180b;
    }

    public int b() {
        return this.f22179a;
    }

    public int c() {
        return this.f22180b;
    }

    public int d() {
        return this.f22185g ? this.f22180b : this.f22179a;
    }

    public void e(int i5, int i6) {
        this.f22186h = false;
        if (i5 != Integer.MIN_VALUE) {
            this.f22183e = i5;
            this.f22179a = i5;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.f22184f = i6;
            this.f22180b = i6;
        }
    }

    public void f(boolean z5) {
        if (z5 == this.f22185g) {
            return;
        }
        this.f22185g = z5;
        if (!this.f22186h) {
            this.f22179a = this.f22183e;
            this.f22180b = this.f22184f;
            return;
        }
        if (z5) {
            int i5 = this.f22182d;
            if (i5 == Integer.MIN_VALUE) {
                i5 = this.f22183e;
            }
            this.f22179a = i5;
            int i6 = this.f22181c;
            if (i6 == Integer.MIN_VALUE) {
                i6 = this.f22184f;
            }
            this.f22180b = i6;
            return;
        }
        int i7 = this.f22181c;
        if (i7 == Integer.MIN_VALUE) {
            i7 = this.f22183e;
        }
        this.f22179a = i7;
        int i8 = this.f22182d;
        if (i8 == Integer.MIN_VALUE) {
            i8 = this.f22184f;
        }
        this.f22180b = i8;
    }

    public void g(int i5, int i6) {
        this.f22181c = i5;
        this.f22182d = i6;
        this.f22186h = true;
        if (this.f22185g) {
            if (i6 != Integer.MIN_VALUE) {
                this.f22179a = i6;
            }
            if (i5 != Integer.MIN_VALUE) {
                this.f22180b = i5;
                return;
            }
            return;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.f22179a = i5;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.f22180b = i6;
        }
    }
}
