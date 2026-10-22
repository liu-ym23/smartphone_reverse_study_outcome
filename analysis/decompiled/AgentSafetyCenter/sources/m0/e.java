package m0;

import java.lang.invoke.VarHandle;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements RandomAccess {

    /* renamed from: c, reason: collision with root package name */
    public Object[] f8158c;

    /* renamed from: f, reason: collision with root package name */
    public b f8159f;

    /* renamed from: g, reason: collision with root package name */
    public int f8160g = 0;

    public e(Object[] objArr) {
        this.f8158c = objArr;
    }

    public final void a(int i, Object obj) {
        int i3 = this.f8160g + 1;
        if (this.f8158c.length < i3) {
            m(i3);
        }
        Object[] objArr = this.f8158c;
        int i10 = this.f8160g;
        if (i != i10) {
            System.arraycopy(objArr, i, objArr, i + 1, i10 - i);
        }
        objArr[i] = obj;
        this.f8160g++;
    }

    public final void b(Object obj) {
        int i = this.f8160g + 1;
        if (this.f8158c.length < i) {
            m(i);
        }
        Object[] objArr = this.f8158c;
        int i3 = this.f8160g;
        objArr[i3] = obj;
        this.f8160g = i3 + 1;
    }

    public final void c(int i, List list) {
        if (list.isEmpty()) {
            return;
        }
        int size = list.size();
        int i3 = this.f8160g + size;
        if (this.f8158c.length < i3) {
            m(i3);
        }
        Object[] objArr = this.f8158c;
        int i10 = this.f8160g;
        if (i != i10) {
            System.arraycopy(objArr, i, objArr, i + size, i10 - i);
        }
        int size2 = list.size();
        for (int i11 = 0; i11 < size2; i11++) {
            objArr[i + i11] = list.get(i11);
        }
        this.f8160g += size;
    }

    public final void d(int i, e eVar) {
        int i3 = eVar.f8160g;
        if (i3 == 0) {
            return;
        }
        int i10 = this.f8160g + i3;
        if (this.f8158c.length < i10) {
            m(i10);
        }
        Object[] objArr = this.f8158c;
        int i11 = this.f8160g;
        if (i != i11) {
            System.arraycopy(objArr, i, objArr, i + i3, i11 - i);
        }
        System.arraycopy(eVar.f8158c, 0, objArr, i, i3);
        this.f8160g += i3;
    }

    public final boolean e(int i, Collection collection) {
        int i3 = 0;
        if (collection.isEmpty()) {
            return false;
        }
        int size = collection.size();
        int i10 = this.f8160g + size;
        if (this.f8158c.length < i10) {
            m(i10);
        }
        Object[] objArr = this.f8158c;
        int i11 = this.f8160g;
        if (i != i11) {
            System.arraycopy(objArr, i, objArr, i + size, i11 - i);
        }
        for (Object obj : collection) {
            int i12 = i3 + 1;
            if (i3 < 0) {
                ac.a.a0();
                throw null;
            }
            objArr[i3 + i] = obj;
            i3 = i12;
        }
        this.f8160g += size;
        return true;
    }

    public final List f() {
        b bVar = this.f8159f;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        bVar2.f8152c = this;
        VarHandle.storeStoreFence();
        this.f8159f = bVar2;
        return bVar2;
    }

    public final void g() {
        Object[] objArr = this.f8158c;
        int i = this.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            objArr[i3] = null;
        }
        this.f8160g = 0;
    }

    public final boolean h(Object obj) {
        int i = this.f8160g - 1;
        if (i >= 0) {
            for (int i3 = 0; !k.a(this.f8158c[i3], obj); i3++) {
                if (i3 != i) {
                }
            }
            return true;
        }
        return false;
    }

    public final int i(Object obj) {
        Object[] objArr = this.f8158c;
        int i = this.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            if (k.a(obj, objArr[i3])) {
                return i3;
            }
        }
        return -1;
    }

    public final boolean j(Object obj) {
        int i = i(obj);
        if (i < 0) {
            return false;
        }
        k(i);
        return true;
    }

    public final Object k(int i) {
        Object[] objArr = this.f8158c;
        Object obj = objArr[i];
        int i3 = this.f8160g;
        if (i != i3 - 1) {
            int i10 = i + 1;
            System.arraycopy(objArr, i10, objArr, i, i3 - i10);
        }
        int i11 = this.f8160g - 1;
        this.f8160g = i11;
        objArr[i11] = null;
        return obj;
    }

    public final void l(int i, int i3) {
        if (i3 > i) {
            int i10 = this.f8160g;
            if (i3 < i10) {
                Object[] objArr = this.f8158c;
                System.arraycopy(objArr, i3, objArr, i, i10 - i3);
            }
            int i11 = this.f8160g;
            int i12 = i11 - (i3 - i);
            int i13 = i11 - 1;
            if (i12 <= i13) {
                int i14 = i12;
                while (true) {
                    this.f8158c[i14] = null;
                    if (i14 == i13) {
                        break;
                    } else {
                        i14++;
                    }
                }
            }
            this.f8160g = i12;
        }
    }

    public final void m(int i) {
        Object[] objArr = this.f8158c;
        int length = objArr.length;
        Object[] objArr2 = new Object[Math.max(i, length * 2)];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        this.f8158c = objArr2;
    }
}
