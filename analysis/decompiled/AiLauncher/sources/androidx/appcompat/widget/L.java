package androidx.appcompat.widget;

/* loaded from: classes.dex */
public class L {

    /* renamed from: a, reason: collision with root package name */
    public int f8962a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f8963b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f8964c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public int f8965d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    public int f8966e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f8967f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8968g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8969h = false;

    public int a() {
        return this.f8968g ? this.f8962a : this.f8963b;
    }

    public int b() {
        return this.f8962a;
    }

    public int c() {
        return this.f8963b;
    }

    public int d() {
        return this.f8968g ? this.f8963b : this.f8962a;
    }

    public void e(int i10, int i11) {
        this.f8969h = false;
        if (i10 != Integer.MIN_VALUE) {
            this.f8966e = i10;
            this.f8962a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f8967f = i11;
            this.f8963b = i11;
        }
    }

    public void f(boolean z10) {
        if (z10 == this.f8968g) {
            return;
        }
        this.f8968g = z10;
        if (!this.f8969h) {
            this.f8962a = this.f8966e;
            this.f8963b = this.f8967f;
            return;
        }
        if (z10) {
            int i10 = this.f8965d;
            if (i10 == Integer.MIN_VALUE) {
                i10 = this.f8966e;
            }
            this.f8962a = i10;
            int i11 = this.f8964c;
            if (i11 == Integer.MIN_VALUE) {
                i11 = this.f8967f;
            }
            this.f8963b = i11;
            return;
        }
        int i12 = this.f8964c;
        if (i12 == Integer.MIN_VALUE) {
            i12 = this.f8966e;
        }
        this.f8962a = i12;
        int i13 = this.f8965d;
        if (i13 == Integer.MIN_VALUE) {
            i13 = this.f8967f;
        }
        this.f8963b = i13;
    }

    public void g(int i10, int i11) {
        this.f8964c = i10;
        this.f8965d = i11;
        this.f8969h = true;
        if (this.f8968g) {
            if (i11 != Integer.MIN_VALUE) {
                this.f8962a = i11;
            }
            if (i10 != Integer.MIN_VALUE) {
                this.f8963b = i10;
                return;
            }
            return;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f8962a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f8963b = i11;
        }
    }
}
