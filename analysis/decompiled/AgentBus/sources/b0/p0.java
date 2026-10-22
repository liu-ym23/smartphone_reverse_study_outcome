package b0;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class p0 implements Iterator, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1297f = 0;

    /* renamed from: g, reason: collision with root package name */
    public final p2 f1298g;

    /* renamed from: h, reason: collision with root package name */
    public final int f1299h;

    /* renamed from: i, reason: collision with root package name */
    public int f1300i;

    /* renamed from: j, reason: collision with root package name */
    public int f1301j;

    public p0(p2 p2Var, int i2, int i10) {
        this.f1298g = p2Var;
        this.f1299h = i10;
        this.f1300i = i2;
        this.f1301j = p2Var.f1313m;
        if (p2Var.f1312l) {
            r2.f();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f1297f) {
            case 0:
                return this.f1300i < this.f1299h;
            default:
                throw null;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f1297f) {
            case 0:
                p2 p2Var = this.f1298g;
                int i2 = p2Var.f1313m;
                int i10 = this.f1301j;
                if (i2 != i10) {
                    r2.f();
                }
                int i11 = this.f1300i;
                this.f1300i = r2.a(i11, p2Var.f1306f) + i11;
                return new q2(p2Var, i11, i10);
            default:
                throw null;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f1297f) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public p0(p2 p2Var, int i2, q0 q0Var, b bVar) {
        this.f1298g = p2Var;
        this.f1299h = i2;
        this.f1300i = p2Var.f1313m;
    }
}
