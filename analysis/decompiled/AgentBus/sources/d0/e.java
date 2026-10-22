package d0;

import d7.s;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import q7.k;

/* loaded from: classes.dex */
public final class e implements RandomAccess {

    /* renamed from: f, reason: collision with root package name */
    public Object[] f2749f;

    /* renamed from: g, reason: collision with root package name */
    public b f2750g;

    /* renamed from: h, reason: collision with root package name */
    public int f2751h = 0;

    public e(Object[] objArr) {
        this.f2749f = objArr;
    }

    public final void a(int i2, Object obj) {
        int i10 = this.f2751h + 1;
        if (this.f2749f.length < i10) {
            l(i10);
        }
        Object[] objArr = this.f2749f;
        int i11 = this.f2751h;
        if (i2 != i11) {
            System.arraycopy(objArr, i2, objArr, i2 + 1, i11 - i2);
        }
        objArr[i2] = obj;
        this.f2751h++;
    }

    public final void b(Object obj) {
        int i2 = this.f2751h + 1;
        if (this.f2749f.length < i2) {
            l(i2);
        }
        Object[] objArr = this.f2749f;
        int i10 = this.f2751h;
        objArr[i10] = obj;
        this.f2751h = i10 + 1;
    }

    public final void c(int i2, e eVar) {
        int i10 = eVar.f2751h;
        if (i10 == 0) {
            return;
        }
        int i11 = this.f2751h + i10;
        if (this.f2749f.length < i11) {
            l(i11);
        }
        Object[] objArr = this.f2749f;
        int i12 = this.f2751h;
        if (i2 != i12) {
            System.arraycopy(objArr, i2, objArr, i2 + i10, i12 - i2);
        }
        System.arraycopy(eVar.f2749f, 0, objArr, i2, i10);
        this.f2751h += i10;
    }

    public final void d(int i2, List list) {
        if (list.isEmpty()) {
            return;
        }
        int size = list.size();
        int i10 = this.f2751h + size;
        if (this.f2749f.length < i10) {
            l(i10);
        }
        Object[] objArr = this.f2749f;
        int i11 = this.f2751h;
        if (i2 != i11) {
            System.arraycopy(objArr, i2, objArr, i2 + size, i11 - i2);
        }
        int size2 = list.size();
        for (int i12 = 0; i12 < size2; i12++) {
            objArr[i2 + i12] = list.get(i12);
        }
        this.f2751h += size;
    }

    public final boolean e(int i2, Collection collection) {
        int i10 = 0;
        if (collection.isEmpty()) {
            return false;
        }
        int size = collection.size();
        int i11 = this.f2751h + size;
        if (this.f2749f.length < i11) {
            l(i11);
        }
        Object[] objArr = this.f2749f;
        int i12 = this.f2751h;
        if (i2 != i12) {
            System.arraycopy(objArr, i2, objArr, i2 + size, i12 - i2);
        }
        for (Object obj : collection) {
            int i13 = i10 + 1;
            if (i10 < 0) {
                s.z0();
                throw null;
            }
            objArr[i10 + i2] = obj;
            i10 = i13;
        }
        this.f2751h += size;
        return true;
    }

    public final List f() {
        b bVar = this.f2750g;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(this);
        this.f2750g = bVar2;
        return bVar2;
    }

    public final void g() {
        Object[] objArr = this.f2749f;
        int i2 = this.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            objArr[i10] = null;
        }
        this.f2751h = 0;
    }

    public final boolean h(Object obj) {
        int i2 = this.f2751h - 1;
        if (i2 >= 0) {
            for (int i10 = 0; !k.a(this.f2749f[i10], obj); i10++) {
                if (i10 != i2) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean i(Object obj) {
        Object[] objArr = this.f2749f;
        int i2 = this.f2751h;
        int i10 = 0;
        while (true) {
            if (i10 >= i2) {
                i10 = -1;
                break;
            }
            if (k.a(obj, objArr[i10])) {
                break;
            }
            i10++;
        }
        if (i10 < 0) {
            return false;
        }
        j(i10);
        return true;
    }

    public final Object j(int i2) {
        Object[] objArr = this.f2749f;
        Object obj = objArr[i2];
        int i10 = this.f2751h;
        if (i2 != i10 - 1) {
            int i11 = i2 + 1;
            System.arraycopy(objArr, i11, objArr, i2, i10 - i11);
        }
        int i12 = this.f2751h - 1;
        this.f2751h = i12;
        objArr[i12] = null;
        return obj;
    }

    public final void k(int i2, int i10) {
        if (i10 > i2) {
            int i11 = this.f2751h;
            if (i10 < i11) {
                Object[] objArr = this.f2749f;
                System.arraycopy(objArr, i10, objArr, i2, i11 - i10);
            }
            int i12 = this.f2751h;
            int i13 = i12 - (i10 - i2);
            int i14 = i12 - 1;
            if (i13 <= i14) {
                int i15 = i13;
                while (true) {
                    this.f2749f[i15] = null;
                    if (i15 == i14) {
                        break;
                    } else {
                        i15++;
                    }
                }
            }
            this.f2751h = i13;
        }
    }

    public final void l(int i2) {
        Object[] objArr = this.f2749f;
        int length = objArr.length;
        Object[] objArr2 = new Object[Math.max(i2, length * 2)];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        this.f2749f = objArr2;
    }
}
