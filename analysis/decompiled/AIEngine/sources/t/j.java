package t;

import androidx.datastore.preferences.protobuf.b1;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j<E> extends c<E> implements s.a<E> {

    /* renamed from: b, reason: collision with root package name */
    public static final j f12893b = new j(new Object[0]);

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f12894a;

    public j(Object[] objArr) {
        this.f12894a = objArr;
    }

    @Override // s.b
    public final s.b P(b bVar) {
        Object[] objArr = this.f12894a;
        int length = objArr.length;
        int length2 = objArr.length;
        Object[] objArrCopyOf = objArr;
        boolean z = false;
        for (int i10 = 0; i10 < length2; i10++) {
            Object obj = objArr[i10];
            if (((Boolean) bVar.invoke(obj)).booleanValue()) {
                if (!z) {
                    objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
                    kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
                    z = true;
                    length = i10;
                }
            } else if (z) {
                objArrCopyOf[length] = obj;
                length++;
            }
        }
        return length == objArr.length ? this : length == 0 ? f12893b : new j(b1.v(objArrCopyOf, 0, length));
    }

    @Override // mb.a
    public final int a() {
        return this.f12894a.length;
    }

    @Override // java.util.List, s.b
    public final s.b<E> add(int i10, E e10) {
        Object[] objArr = this.f12894a;
        jd.b.k(i10, objArr.length);
        if (i10 == objArr.length) {
            return add((j<E>) e10);
        }
        if (objArr.length < 32) {
            Object[] objArr2 = new Object[objArr.length + 1];
            b1.t(objArr, objArr2, 0, i10, 6);
            b1.q(objArr, objArr2, i10 + 1, i10, objArr.length);
            objArr2[i10] = e10;
            return new j(objArr2);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
        b1.q(objArr, objArrCopyOf, i10 + 1, i10, objArr.length - 1);
        objArrCopyOf[i10] = e10;
        Object[] objArr3 = new Object[32];
        objArr3[0] = objArr[31];
        return new e(objArrCopyOf, objArr3, objArr.length + 1, 0);
    }

    @Override // t.c, java.util.Collection, java.util.List, s.b
    public final s.b<E> addAll(Collection<? extends E> collection) {
        Object[] objArr = this.f12894a;
        if (collection.size() + objArr.length > 32) {
            f fVarBuilder = builder();
            fVarBuilder.addAll(collection);
            return fVarBuilder.c();
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, collection.size() + objArr.length);
        kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
        int length = objArr.length;
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            objArrCopyOf[length] = it.next();
            length++;
        }
        return new j(objArrCopyOf);
    }

    @Override // s.b
    public final f builder() {
        return new f(this, null, this.f12894a, 0);
    }

    @Override // java.util.List
    public final E get(int i10) {
        jd.b.j(i10, a());
        return (E) this.f12894a[i10];
    }

    @Override // mb.c, java.util.List
    public final int indexOf(Object obj) {
        return l.h0(obj, this.f12894a);
    }

    @Override // mb.c, java.util.List
    public final int lastIndexOf(Object obj) {
        Object[] objArr = this.f12894a;
        kotlin.jvm.internal.g.f(objArr, "<this>");
        if (obj == null) {
            int length = objArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i10 = length - 1;
                    if (objArr[length] == null) {
                        return length;
                    }
                    if (i10 < 0) {
                        break;
                    }
                    length = i10;
                }
            }
        } else {
            int length2 = objArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i11 = length2 - 1;
                    if (obj.equals(objArr[length2])) {
                        return length2;
                    }
                    if (i11 < 0) {
                        break;
                    }
                    length2 = i11;
                }
            }
        }
        return -1;
    }

    @Override // mb.c, java.util.List
    public final ListIterator<E> listIterator(int i10) {
        Object[] objArr = this.f12894a;
        jd.b.k(i10, objArr.length);
        return new d(objArr, i10, objArr.length);
    }

    @Override // mb.c, java.util.List
    public final s.b<E> set(int i10, E e10) {
        Object[] objArr = this.f12894a;
        jd.b.j(i10, objArr.length);
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i10] = e10;
        return new j(objArrCopyOf);
    }

    @Override // s.b
    public final s.b<E> w(int i10) {
        Object[] objArr = this.f12894a;
        jd.b.j(i10, objArr.length);
        if (objArr.length == 1) {
            return f12893b;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length - 1);
        kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
        b1.q(objArr, objArrCopyOf, i10, i10 + 1, objArr.length);
        return new j(objArrCopyOf);
    }

    @Override // java.util.Collection, java.util.List, s.b
    public final s.b<E> add(E e10) {
        Object[] objArr = this.f12894a;
        if (objArr.length < 32) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + 1);
            kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
            objArrCopyOf[objArr.length] = e10;
            return new j(objArrCopyOf);
        }
        Object[] objArr2 = new Object[32];
        objArr2[0] = e10;
        return new e(objArr, objArr2, objArr.length + 1, 0);
    }
}
