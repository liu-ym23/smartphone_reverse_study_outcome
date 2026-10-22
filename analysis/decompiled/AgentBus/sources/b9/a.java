package b9;

import d7.n;
import d7.o;
import d7.r;
import d7.z;
import java.util.ArrayList;
import java.util.List;
import m.x;
import q7.k;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f1549a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1550b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1551c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1552d;

    /* renamed from: e, reason: collision with root package name */
    public final List f1553e;

    public a(int... iArr) {
        List listM1;
        k.e(iArr, "numbers");
        this.f1549a = iArr;
        Integer numJ0 = n.j0(0, iArr);
        this.f1550b = numJ0 != null ? numJ0.intValue() : -1;
        Integer numJ02 = n.j0(1, iArr);
        this.f1551c = numJ02 != null ? numJ02.intValue() : -1;
        Integer numJ03 = n.j0(2, iArr);
        this.f1552d = numJ03 != null ? numJ03.intValue() : -1;
        if (iArr.length <= 3) {
            listM1 = z.f2978f;
        } else {
            if (iArr.length > 1024) {
                throw new IllegalArgumentException(x.m(new StringBuilder("BinaryVersion with length more than 1024 are not supported. Provided length "), iArr.length, '.'));
            }
            listM1 = r.m1(new d7.e(new o(iArr), 3, iArr.length));
        }
        this.f1553e = listM1;
    }

    public final boolean a(int i2, int i10, int i11) {
        int i12 = this.f1550b;
        if (i12 > i2) {
            return true;
        }
        if (i12 < i2) {
            return false;
        }
        int i13 = this.f1551c;
        if (i13 > i10) {
            return true;
        }
        return i13 >= i10 && this.f1552d >= i11;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        a aVar = (a) obj;
        return this.f1550b == aVar.f1550b && this.f1551c == aVar.f1551c && this.f1552d == aVar.f1552d && k.a(this.f1553e, aVar.f1553e);
    }

    public final int hashCode() {
        int i2 = this.f1550b;
        int i10 = (i2 * 31) + this.f1551c + i2;
        int i11 = (i10 * 31) + this.f1552d + i10;
        return this.f1553e.hashCode() + (i11 * 31) + i11;
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        for (int i2 : this.f1549a) {
            if (i2 == -1) {
                break;
            }
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList.isEmpty() ? "unknown" : r.U0(arrayList, ".", null, null, null, 62);
    }
}
