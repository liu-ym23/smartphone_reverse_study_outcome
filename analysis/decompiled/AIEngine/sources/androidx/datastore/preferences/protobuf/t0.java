package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class t0<E> extends c<E> implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final t0<Object> f1885d;

    /* renamed from: b, reason: collision with root package name */
    public E[] f1886b;

    /* renamed from: c, reason: collision with root package name */
    public int f1887c;

    static {
        t0<Object> t0Var = new t0<>(new Object[0], 0);
        f1885d = t0Var;
        t0Var.f1793a = false;
    }

    public t0(E[] eArr, int i10) {
        this.f1886b = eArr;
        this.f1887c = i10;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e10) {
        a();
        int i10 = this.f1887c;
        E[] eArr = this.f1886b;
        if (i10 == eArr.length) {
            this.f1886b = (E[]) Arrays.copyOf(eArr, ((i10 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f1886b;
        int i11 = this.f1887c;
        this.f1887c = i11 + 1;
        eArr2[i11] = e10;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void b(int i10) {
        if (i10 < 0 || i10 >= this.f1887c) {
            StringBuilder sbK = com.stepos.core.ota.d.k(i10, "Index:", ", Size:");
            sbK.append(this.f1887c);
            throw new IndexOutOfBoundsException(sbK.toString());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.u.c
    public final u.c c0(int i10) {
        if (i10 >= this.f1887c) {
            return new t0(Arrays.copyOf(this.f1886b, i10), this.f1887c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i10) {
        b(i10);
        return this.f1886b[i10];
    }

    @Override // java.util.AbstractList, java.util.List
    public final E remove(int i10) {
        a();
        b(i10);
        E[] eArr = this.f1886b;
        E e10 = eArr[i10];
        if (i10 < this.f1887c - 1) {
            System.arraycopy(eArr, i10 + 1, eArr, i10, (r2 - i10) - 1);
        }
        this.f1887c--;
        ((AbstractList) this).modCount++;
        return e10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i10, E e10) {
        a();
        b(i10);
        E[] eArr = this.f1886b;
        E e11 = eArr[i10];
        eArr[i10] = e10;
        ((AbstractList) this).modCount++;
        return e11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1887c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, E e10) {
        int i11;
        a();
        if (i10 >= 0 && i10 <= (i11 = this.f1887c)) {
            E[] eArr = this.f1886b;
            if (i11 < eArr.length) {
                System.arraycopy(eArr, i10, eArr, i10 + 1, i11 - i10);
            } else {
                E[] eArr2 = (E[]) new Object[((i11 * 3) / 2) + 1];
                System.arraycopy(eArr, 0, eArr2, 0, i10);
                System.arraycopy(this.f1886b, i10, eArr2, i10 + 1, this.f1887c - i10);
                this.f1886b = eArr2;
            }
            this.f1886b[i10] = e10;
            this.f1887c++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbK = com.stepos.core.ota.d.k(i10, "Index:", ", Size:");
        sbK.append(this.f1887c);
        throw new IndexOutOfBoundsException(sbK.toString());
    }
}
