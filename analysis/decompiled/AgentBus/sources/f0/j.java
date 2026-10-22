package f0;

import d7.n;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class j extends c {

    /* renamed from: g, reason: collision with root package name */
    public static final j f3351g = new j(new Object[0]);

    /* renamed from: f, reason: collision with root package name */
    public final Object[] f3352f;

    public j(Object[] objArr) {
        this.f3352f = objArr;
    }

    @Override // d7.a
    public final int a() {
        return this.f3352f.length;
    }

    @Override // f0.c
    public final c f(int i2, Object obj) {
        Object[] objArr = this.f3352f;
        a.a.h(i2, objArr.length);
        if (i2 == objArr.length) {
            return h(obj);
        }
        if (objArr.length < 32) {
            Object[] objArr2 = new Object[objArr.length + 1];
            n.a0(objArr, objArr2, 0, i2, 6);
            n.Y(objArr, objArr2, i2 + 1, i2, objArr.length);
            objArr2[i2] = obj;
            return new j(objArr2);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        q7.k.d(objArrCopyOf, "copyOf(...)");
        n.Y(objArr, objArrCopyOf, i2 + 1, i2, objArr.length - 1);
        objArrCopyOf[i2] = obj;
        Object[] objArr3 = new Object[32];
        objArr3[0] = objArr[31];
        return new f(objArrCopyOf, objArr3, objArr.length + 1, 0);
    }

    @Override // java.util.List
    public final Object get(int i2) {
        a.a.g(i2, a());
        return this.f3352f[i2];
    }

    @Override // f0.c
    public final c h(Object obj) {
        Object[] objArr = this.f3352f;
        if (objArr.length >= 32) {
            Object[] objArr2 = new Object[32];
            objArr2[0] = obj;
            return new f(objArr, objArr2, objArr.length + 1, 0);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + 1);
        q7.k.d(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[objArr.length] = obj;
        return new j(objArrCopyOf);
    }

    @Override // f0.c
    public final c i(Collection collection) {
        Object[] objArr = this.f3352f;
        if (collection.size() + objArr.length > 32) {
            g gVarJ = j();
            gVarJ.addAll(collection);
            return gVarJ.h();
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, collection.size() + objArr.length);
        q7.k.d(objArrCopyOf, "copyOf(...)");
        int length = objArr.length;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            objArrCopyOf[length] = it.next();
            length++;
        }
        return new j(objArrCopyOf);
    }

    @Override // d7.f, java.util.List
    public final int indexOf(Object obj) {
        return n.l0(this.f3352f, obj);
    }

    @Override // f0.c
    public final g j() {
        return new g(this, null, this.f3352f, 0);
    }

    @Override // f0.c
    public final c k(b bVar) {
        Object[] objArr = this.f3352f;
        int length = objArr.length;
        int length2 = objArr.length;
        Object[] objArrCopyOf = objArr;
        boolean z4 = false;
        for (int i2 = 0; i2 < length2; i2++) {
            Object obj = objArr[i2];
            if (((Boolean) bVar.invoke(obj)).booleanValue()) {
                if (!z4) {
                    objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
                    q7.k.d(objArrCopyOf, "copyOf(...)");
                    z4 = true;
                    length = i2;
                }
            } else if (z4) {
                objArrCopyOf[length] = obj;
                length++;
            }
        }
        return length == objArr.length ? this : length == 0 ? f3351g : new j(n.c0(objArrCopyOf, 0, length));
    }

    @Override // f0.c
    public final c l(int i2) {
        Object[] objArr = this.f3352f;
        a.a.g(i2, objArr.length);
        if (objArr.length == 1) {
            return f3351g;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length - 1);
        q7.k.d(objArrCopyOf, "copyOf(...)");
        n.Y(objArr, objArrCopyOf, i2, i2 + 1, objArr.length);
        return new j(objArrCopyOf);
    }

    @Override // d7.f, java.util.List
    public final int lastIndexOf(Object obj) {
        Object[] objArr = this.f3352f;
        q7.k.e(objArr, "<this>");
        if (obj == null) {
            int length = objArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i2 = length - 1;
                    if (objArr[length] == null) {
                        return length;
                    }
                    if (i2 < 0) {
                        break;
                    }
                    length = i2;
                }
            }
        } else {
            int length2 = objArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i10 = length2 - 1;
                    if (obj.equals(objArr[length2])) {
                        return length2;
                    }
                    if (i10 < 0) {
                        break;
                    }
                    length2 = i10;
                }
            }
        }
        return -1;
    }

    @Override // d7.f, java.util.List
    public final ListIterator listIterator(int i2) {
        Object[] objArr = this.f3352f;
        a.a.h(i2, objArr.length);
        return new d(objArr, i2, objArr.length);
    }

    @Override // f0.c
    public final c m(int i2, Object obj) {
        Object[] objArr = this.f3352f;
        a.a.g(i2, objArr.length);
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        q7.k.d(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i2] = obj;
        return new j(objArrCopyOf);
    }
}
