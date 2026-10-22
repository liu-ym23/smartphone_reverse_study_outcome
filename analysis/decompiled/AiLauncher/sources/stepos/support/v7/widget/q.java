package stepos.support.v7.widget;

/* loaded from: classes5.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public int f41681a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f41682b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f41683c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public int f41684d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    public int f41685e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f41686f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f41687g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f41688h = false;

    public int a() {
        return this.f41687g ? this.f41681a : this.f41682b;
    }

    public int b() {
        return this.f41681a;
    }

    public int c() {
        return this.f41682b;
    }

    public int d() {
        return this.f41687g ? this.f41682b : this.f41681a;
    }

    public void e(int i10, int i11) {
        this.f41688h = false;
        if (i10 != Integer.MIN_VALUE) {
            this.f41685e = i10;
            this.f41681a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f41686f = i11;
            this.f41682b = i11;
        }
    }

    public void f(boolean z10) {
        if (z10 == this.f41687g) {
            return;
        }
        this.f41687g = z10;
        if (!this.f41688h) {
            this.f41681a = this.f41685e;
            this.f41682b = this.f41686f;
            return;
        }
        if (z10) {
            int i10 = this.f41684d;
            if (i10 == Integer.MIN_VALUE) {
                i10 = this.f41685e;
            }
            this.f41681a = i10;
            int i11 = this.f41683c;
            if (i11 == Integer.MIN_VALUE) {
                i11 = this.f41686f;
            }
            this.f41682b = i11;
            return;
        }
        int i12 = this.f41683c;
        if (i12 == Integer.MIN_VALUE) {
            i12 = this.f41685e;
        }
        this.f41681a = i12;
        int i13 = this.f41684d;
        if (i13 == Integer.MIN_VALUE) {
            i13 = this.f41686f;
        }
        this.f41682b = i13;
    }

    public void g(int i10, int i11) {
        this.f41683c = i10;
        this.f41684d = i11;
        this.f41688h = true;
        if (this.f41687g) {
            if (i11 != Integer.MIN_VALUE) {
                this.f41681a = i11;
            }
            if (i10 != Integer.MIN_VALUE) {
                this.f41682b = i10;
                return;
            }
            return;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f41681a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f41682b = i11;
        }
    }
}
