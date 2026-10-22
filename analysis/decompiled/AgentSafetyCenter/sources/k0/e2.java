package k0;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e2 {

    /* renamed from: a, reason: collision with root package name */
    public f2 f6882a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f6883b;

    /* renamed from: c, reason: collision with root package name */
    public int f6884c;

    /* renamed from: d, reason: collision with root package name */
    public Object[] f6885d;

    /* renamed from: e, reason: collision with root package name */
    public int f6886e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6887f;

    /* renamed from: g, reason: collision with root package name */
    public int f6888g;

    /* renamed from: h, reason: collision with root package name */
    public int f6889h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public r0 f6890j;

    /* renamed from: k, reason: collision with root package name */
    public int f6891k;

    /* renamed from: l, reason: collision with root package name */
    public int f6892l;

    /* renamed from: m, reason: collision with root package name */
    public int f6893m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f6894n;

    public final b a(int i) {
        ArrayList arrayList = this.f6882a.f6907m;
        int iE = h2.e(arrayList, i, this.f6884c);
        if (iE >= 0) {
            return (b) arrayList.get(iE);
        }
        b bVar = new b(i);
        arrayList.add(-(iE + 1), bVar);
        return bVar;
    }

    public final Object b(int[] iArr, int i) {
        int i3 = i * 5;
        int i10 = iArr[i3 + 1];
        if ((268435456 & i10) != 0) {
            return this.f6885d[i3 >= iArr.length ? iArr.length : iArr[i3 + 4] + Integer.bitCount(i10 >> 29)];
        }
        return m.f6974a;
    }

    public final void c() {
        this.f6887f = true;
        if (this.f6882a.i <= 0) {
            t.c("Unexpected reader close()");
        }
        r0.i--;
        this.f6885d = new Object[0];
    }

    public final boolean d(int i) {
        return (this.f6883b[(i * 5) + 1] & 67108864) != 0;
    }

    public final void e() {
        int i = this.f6884c;
        int[] iArr = this.f6883b;
        if (this.f6891k == 0) {
            if (!(this.f6888g == this.f6889h)) {
                t.c("endGroup() not called at the end of a group");
            }
            int i3 = iArr[(this.i * 5) + 2];
            this.i = i3;
            this.f6889h = i3 < 0 ? i : h2.a(iArr, i3) + i3;
            int iB = this.f6890j.b();
            if (iB < 0) {
                this.f6892l = 0;
                this.f6893m = 0;
            } else {
                this.f6892l = iB;
                this.f6893m = i3 >= i - 1 ? this.f6886e : iArr[((i3 + 1) * 5) + 4];
            }
        }
    }

    public final Object f() {
        int i = this.f6888g;
        if (i < this.f6889h) {
            return b(this.f6883b, i);
        }
        return 0;
    }

    public final int g() {
        int i = this.f6888g;
        if (i < this.f6889h) {
            return this.f6883b[i * 5];
        }
        return 0;
    }

    public final Object h(int i, int i3) {
        int[] iArr = this.f6883b;
        int iC = h2.c(iArr, i);
        int i10 = i + 1;
        int i11 = iC + i3;
        return i11 < (i10 < this.f6884c ? iArr[(i10 * 5) + 4] : this.f6886e) ? this.f6885d[i11] : m.f6974a;
    }

    public final int i(int i) {
        return this.f6883b[i * 5];
    }

    public final boolean j(int i) {
        return (this.f6883b[(i * 5) + 1] & 134217728) != 0;
    }

    public final boolean k(int i) {
        return (this.f6883b[(i * 5) + 1] & 536870912) != 0;
    }

    public final boolean l(int i) {
        return (this.f6883b[(i * 5) + 1] & 1073741824) != 0;
    }

    public final Object m() {
        int i;
        if (this.f6891k > 0 || (i = this.f6892l) >= this.f6893m) {
            this.f6894n = false;
            return m.f6974a;
        }
        this.f6894n = true;
        Object[] objArr = this.f6885d;
        this.f6892l = i + 1;
        return objArr[i];
    }

    public final Object n(int i) {
        int[] iArr = this.f6883b;
        int i3 = i * 5;
        int i10 = iArr[i3 + 1] & 1073741824;
        if (i10 != 0) {
            return i10 != 0 ? this.f6885d[iArr[i3 + 4]] : m.f6974a;
        }
        return null;
    }

    public final int o(int i) {
        return this.f6883b[(i * 5) + 1] & 67108863;
    }

    public final Object p(int[] iArr, int i) {
        int i3 = i * 5;
        int i10 = iArr[i3 + 1];
        if ((536870912 & i10) == 0) {
            return null;
        }
        return this.f6885d[Integer.bitCount(i10 >> 30) + iArr[i3 + 4]];
    }

    public final int q(int i) {
        return this.f6883b[(i * 5) + 2];
    }

    public final void r(int i) {
        int[] iArr = this.f6883b;
        if (!(this.f6891k == 0)) {
            t.c("Cannot reposition while in an empty region");
        }
        this.f6888g = i;
        int i3 = this.f6884c;
        int i10 = i < i3 ? iArr[(i * 5) + 2] : -1;
        if (i10 != this.i) {
            this.i = i10;
            if (i10 < 0) {
                this.f6889h = i3;
            } else {
                this.f6889h = h2.a(iArr, i10) + i10;
            }
            this.f6892l = 0;
            this.f6893m = 0;
        }
    }

    public final int s() {
        if (!(this.f6891k == 0)) {
            t.c("Cannot skip while in an empty region");
        }
        int[] iArr = this.f6883b;
        int i = this.f6888g;
        int i3 = (iArr[(i * 5) + 1] & 1073741824) == 0 ? iArr[(i * 5) + 1] & 67108863 : 1;
        this.f6888g = h2.a(iArr, i) + i;
        return i3;
    }

    public final void t() {
        if (!(this.f6891k == 0)) {
            t.c("Cannot skip the enclosing group while in an empty region");
        }
        this.f6888g = this.f6889h;
        this.f6892l = 0;
        this.f6893m = 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("SlotReader(current=");
        sb2.append(this.f6888g);
        sb2.append(", key=");
        sb2.append(g());
        sb2.append(", parent=");
        sb2.append(this.i);
        sb2.append(", end=");
        return androidx.activity.b.l(sb2, this.f6889h, ')');
    }

    public final void u() {
        int[] iArr = this.f6883b;
        if (this.f6891k <= 0) {
            int i = this.i;
            int i3 = this.f6888g;
            if (iArr[(i3 * 5) + 2] != i) {
                q1.a("Invalid slot table detected");
            }
            r0 r0Var = this.f6890j;
            int i10 = this.f6892l;
            int i11 = this.f6893m;
            if (i10 == 0 && i11 == 0) {
                r0Var.c(-1);
            } else {
                r0Var.c(i10);
            }
            this.i = i3;
            this.f6889h = h2.a(iArr, i3) + i3;
            int i12 = i3 + 1;
            this.f6888g = i12;
            this.f6892l = h2.c(iArr, i3);
            this.f6893m = i3 >= this.f6884c + (-1) ? this.f6886e : iArr[(i12 * 5) + 4];
        }
    }
}
