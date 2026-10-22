package b0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class o2 {

    /* renamed from: a, reason: collision with root package name */
    public final p2 f1257a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f1258b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1259c;

    /* renamed from: d, reason: collision with root package name */
    public Object[] f1260d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1261e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1262f;

    /* renamed from: g, reason: collision with root package name */
    public int f1263g;

    /* renamed from: h, reason: collision with root package name */
    public int f1264h;

    /* renamed from: i, reason: collision with root package name */
    public int f1265i;

    /* renamed from: j, reason: collision with root package name */
    public final r0 f1266j;

    /* renamed from: k, reason: collision with root package name */
    public int f1267k;

    /* renamed from: l, reason: collision with root package name */
    public int f1268l;

    /* renamed from: m, reason: collision with root package name */
    public int f1269m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1270n;

    public o2(p2 p2Var) {
        this.f1257a = p2Var;
        this.f1258b = p2Var.f1306f;
        int i2 = p2Var.f1307g;
        this.f1259c = i2;
        this.f1260d = p2Var.f1308h;
        this.f1261e = p2Var.f1309i;
        this.f1264h = i2;
        this.f1265i = -1;
        this.f1266j = new r0();
    }

    public final a a(int i2) {
        ArrayList arrayList = this.f1257a.f1314n;
        int iE = r2.e(arrayList, i2, this.f1259c);
        if (iE >= 0) {
            return (a) arrayList.get(iE);
        }
        a aVar = new a(i2);
        arrayList.add(-(iE + 1), aVar);
        return aVar;
    }

    public final Object b(int i2, int[] iArr) {
        int i10 = i2 * 5;
        int i11 = iArr[i10 + 1];
        if ((268435456 & i11) != 0) {
            return this.f1260d[i10 >= iArr.length ? iArr.length : iArr[i10 + 4] + Integer.bitCount(i11 >> 29)];
        }
        return k.f1229a;
    }

    public final void c() {
        this.f1262f = true;
        p2 p2Var = this.f1257a;
        p2Var.getClass();
        if (this.f1257a != p2Var || p2Var.f1310j <= 0) {
            s.c("Unexpected reader close()");
        }
        p2Var.f1310j--;
        this.f1260d = new Object[0];
    }

    public final void d() {
        if (this.f1267k == 0) {
            if (!(this.f1263g == this.f1264h)) {
                s.c("endGroup() not called at the end of a group");
            }
            int i2 = (this.f1265i * 5) + 2;
            int[] iArr = this.f1258b;
            int i10 = iArr[i2];
            this.f1265i = i10;
            int i11 = this.f1259c;
            this.f1264h = i10 < 0 ? i11 : r2.a(i10, iArr) + i10;
            int iB = this.f1266j.b();
            if (iB < 0) {
                this.f1268l = 0;
                this.f1269m = 0;
            } else {
                this.f1268l = iB;
                this.f1269m = i10 >= i11 - 1 ? this.f1261e : iArr[((i10 + 1) * 5) + 4];
            }
        }
    }

    public final Object e() {
        int i2 = this.f1263g;
        if (i2 < this.f1264h) {
            return b(i2, this.f1258b);
        }
        return 0;
    }

    public final int f() {
        int i2 = this.f1263g;
        if (i2 >= this.f1264h) {
            return 0;
        }
        return this.f1258b[i2 * 5];
    }

    public final Object g(int i2, int i10) {
        int[] iArr = this.f1258b;
        int iC = r2.c(i2, iArr);
        int i11 = i2 + 1;
        int i12 = iC + i10;
        return i12 < (i11 < this.f1259c ? iArr[(i11 * 5) + 4] : this.f1261e) ? this.f1260d[i12] : k.f1229a;
    }

    public final int h(int i2) {
        return this.f1258b[i2 * 5];
    }

    public final boolean i(int i2) {
        return (this.f1258b[(i2 * 5) + 1] & 536870912) != 0;
    }

    public final boolean j(int i2) {
        return (this.f1258b[(i2 * 5) + 1] & 1073741824) != 0;
    }

    public final Object k() {
        int i2;
        if (this.f1267k > 0 || (i2 = this.f1268l) >= this.f1269m) {
            this.f1270n = false;
            return k.f1229a;
        }
        this.f1270n = true;
        Object[] objArr = this.f1260d;
        this.f1268l = i2 + 1;
        return objArr[i2];
    }

    public final Object l(int i2) {
        int i10 = i2 * 5;
        int[] iArr = this.f1258b;
        int i11 = iArr[i10 + 1] & 1073741824;
        if (i11 != 0) {
            return i11 != 0 ? this.f1260d[iArr[i10 + 4]] : k.f1229a;
        }
        return null;
    }

    public final int m(int i2) {
        return this.f1258b[(i2 * 5) + 1] & 67108863;
    }

    public final Object n(int i2, int[] iArr) {
        int i10 = i2 * 5;
        int i11 = iArr[i10 + 1];
        if ((536870912 & i11) == 0) {
            return null;
        }
        return this.f1260d[Integer.bitCount(i11 >> 30) + iArr[i10 + 4]];
    }

    public final int o(int i2) {
        return this.f1258b[(i2 * 5) + 2];
    }

    public final void p(int i2) {
        if (!(this.f1267k == 0)) {
            s.c("Cannot reposition while in an empty region");
        }
        this.f1263g = i2;
        int[] iArr = this.f1258b;
        int i10 = this.f1259c;
        int i11 = i2 < i10 ? iArr[(i2 * 5) + 2] : -1;
        if (i11 != this.f1265i) {
            this.f1265i = i11;
            if (i11 < 0) {
                this.f1264h = i10;
            } else {
                this.f1264h = r2.a(i11, iArr) + i11;
            }
            this.f1268l = 0;
            this.f1269m = 0;
        }
    }

    public final int q() {
        if (!(this.f1267k == 0)) {
            s.c("Cannot skip while in an empty region");
        }
        int i2 = this.f1263g;
        int[] iArr = this.f1258b;
        int i10 = (iArr[(i2 * 5) + 1] & 1073741824) == 0 ? iArr[(i2 * 5) + 1] & 67108863 : 1;
        this.f1263g = r2.a(i2, iArr) + i2;
        return i10;
    }

    public final void r() {
        if (!(this.f1267k == 0)) {
            s.c("Cannot skip the enclosing group while in an empty region");
        }
        this.f1263g = this.f1264h;
        this.f1268l = 0;
        this.f1269m = 0;
    }

    public final void s() {
        if (this.f1267k <= 0) {
            int i2 = this.f1265i;
            int i10 = this.f1263g;
            int[] iArr = this.f1258b;
            if (!(iArr[(i10 * 5) + 2] == i2)) {
                u1.a("Invalid slot table detected");
            }
            int i11 = this.f1268l;
            int i12 = this.f1269m;
            r0 r0Var = this.f1266j;
            if (i11 == 0 && i12 == 0) {
                r0Var.c(-1);
            } else {
                r0Var.c(i11);
            }
            this.f1265i = i10;
            this.f1264h = r2.a(i10, iArr) + i10;
            int i13 = i10 + 1;
            this.f1263g = i13;
            this.f1268l = r2.c(i10, iArr);
            this.f1269m = i10 >= this.f1259c - 1 ? this.f1261e : iArr[(i13 * 5) + 4];
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("SlotReader(current=");
        sb2.append(this.f1263g);
        sb2.append(", key=");
        sb2.append(f());
        sb2.append(", parent=");
        sb2.append(this.f1265i);
        sb2.append(", end=");
        return m.x.m(sb2, this.f1264h, ')');
    }
}
