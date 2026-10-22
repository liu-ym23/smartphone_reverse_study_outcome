package c0;

import b0.r0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final b0.p f1715a;

    /* renamed from: b, reason: collision with root package name */
    public a f1716b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1717c;

    /* renamed from: f, reason: collision with root package name */
    public int f1720f;

    /* renamed from: g, reason: collision with root package name */
    public int f1721g;

    /* renamed from: l, reason: collision with root package name */
    public int f1726l;

    /* renamed from: d, reason: collision with root package name */
    public final r0 f1718d = new r0();

    /* renamed from: e, reason: collision with root package name */
    public boolean f1719e = true;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f1722h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public int f1723i = -1;

    /* renamed from: j, reason: collision with root package name */
    public int f1724j = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f1725k = -1;

    public b(b0.p pVar, a aVar) {
        this.f1715a = pVar;
        this.f1716b = aVar;
    }

    public final void a() {
        c();
        ArrayList arrayList = this.f1722h;
        if (arrayList.isEmpty()) {
            this.f1721g++;
        } else {
            arrayList.remove(arrayList.size() - 1);
        }
    }

    public final void b() {
        int i2 = this.f1721g;
        if (i2 > 0) {
            i0 i0Var = this.f1716b.f1713a;
            i0Var.U(f0.f1736d);
            i0Var.f1743c[i0Var.f1744d - i0Var.f1741a[i0Var.f1742b - 1].f1556b] = i2;
            this.f1721g = 0;
        }
        ArrayList arrayList = this.f1722h;
        if (arrayList.isEmpty()) {
            return;
        }
        a aVar = this.f1716b;
        int size = arrayList.size();
        Object[] objArr = new Object[size];
        for (int i10 = 0; i10 < size; i10++) {
            objArr[i10] = arrayList.get(i10);
        }
        aVar.getClass();
        if (size != 0) {
            i0 i0Var2 = aVar.f1713a;
            i0Var2.U(j.f1747d);
            a.a.j0(i0Var2, 0, objArr);
        }
        arrayList.clear();
    }

    public final void c() {
        int i2 = this.f1726l;
        if (i2 > 0) {
            int i10 = this.f1723i;
            if (i10 >= 0) {
                b();
                i0 i0Var = this.f1716b.f1713a;
                i0Var.U(x.f1765d);
                int i11 = i0Var.f1744d - i0Var.f1741a[i0Var.f1742b - 1].f1556b;
                int[] iArr = i0Var.f1743c;
                iArr[i11] = i10;
                iArr[i11 + 1] = i2;
                this.f1723i = -1;
            } else {
                int i12 = this.f1725k;
                int i13 = this.f1724j;
                b();
                i0 i0Var2 = this.f1716b.f1713a;
                i0Var2.U(u.f1762d);
                int i14 = i0Var2.f1744d - i0Var2.f1741a[i0Var2.f1742b - 1].f1556b;
                int[] iArr2 = i0Var2.f1743c;
                iArr2[i14 + 1] = i12;
                iArr2[i14] = i13;
                iArr2[i14 + 2] = i2;
                this.f1724j = -1;
                this.f1725k = -1;
            }
            this.f1726l = 0;
        }
    }

    public final void d(boolean z4) {
        b0.p pVar = this.f1715a;
        int i2 = z4 ? pVar.F.f1265i : pVar.F.f1263g;
        int i10 = i2 - this.f1720f;
        if (i10 < 0) {
            b0.s.c("Tried to seek backward");
        }
        if (i10 > 0) {
            i0 i0Var = this.f1716b.f1713a;
            i0Var.U(d.f1731d);
            i0Var.f1743c[i0Var.f1744d - i0Var.f1741a[i0Var.f1742b - 1].f1556b] = i10;
            this.f1720f = i2;
        }
    }

    public final void e(int i2, int i10) {
        if (i10 > 0) {
            if (!(i2 >= 0)) {
                b0.s.c("Invalid remove index " + i2);
            }
            if (this.f1723i == i2) {
                this.f1726l += i10;
                return;
            }
            c();
            this.f1723i = i2;
            this.f1726l = i10;
        }
    }
}
