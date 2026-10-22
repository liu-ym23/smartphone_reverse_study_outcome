package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class e0<E> extends AbstractC0483c<E> implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    private static final e0<Object> f9999d;

    /* renamed from: b, reason: collision with root package name */
    private E[] f10000b;

    /* renamed from: c, reason: collision with root package name */
    private int f10001c;

    static {
        e0<Object> e0Var = new e0<>(new Object[0], 0);
        f9999d = e0Var;
        e0Var.b();
    }

    private e0(E[] eArr, int i5) {
        this.f10000b = eArr;
        this.f10001c = i5;
    }

    private static <E> E[] c(int i5) {
        return (E[]) new Object[i5];
    }

    public static <E> e0<E> f() {
        return (e0<E>) f9999d;
    }

    private void h(int i5) {
        if (i5 < 0 || i5 >= this.f10001c) {
            throw new IndexOutOfBoundsException(i(i5));
        }
    }

    private String i(int i5) {
        return "Index:" + i5 + ", Size:" + this.f10001c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e6) {
        a();
        int i5 = this.f10001c;
        E[] eArr = this.f10000b;
        if (i5 == eArr.length) {
            this.f10000b = (E[]) Arrays.copyOf(eArr, ((i5 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f10000b;
        int i6 = this.f10001c;
        this.f10001c = i6 + 1;
        eArr2[i6] = e6;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i5) {
        h(i5);
        return this.f10000b[i5];
    }

    @Override // androidx.datastore.preferences.protobuf.A.i
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public e0<E> d(int i5) {
        if (i5 >= this.f10001c) {
            return new e0<>(Arrays.copyOf(this.f10000b, i5), this.f10001c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i5) {
        a();
        h(i5);
        E[] eArr = this.f10000b;
        E e6 = eArr[i5];
        if (i5 < this.f10001c - 1) {
            System.arraycopy(eArr, i5 + 1, eArr, i5, (r2 - i5) - 1);
        }
        this.f10001c--;
        ((AbstractList) this).modCount++;
        return e6;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i5, E e6) {
        a();
        h(i5);
        E[] eArr = this.f10000b;
        E e7 = eArr[i5];
        eArr[i5] = e6;
        ((AbstractList) this).modCount++;
        return e7;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f10001c;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i5, E e6) {
        int i6;
        a();
        if (i5 >= 0 && i5 <= (i6 = this.f10001c)) {
            E[] eArr = this.f10000b;
            if (i6 < eArr.length) {
                System.arraycopy(eArr, i5, eArr, i5 + 1, i6 - i5);
            } else {
                E[] eArr2 = (E[]) c(((i6 * 3) / 2) + 1);
                System.arraycopy(this.f10000b, 0, eArr2, 0, i5);
                System.arraycopy(this.f10000b, i5, eArr2, i5 + 1, this.f10001c - i5);
                this.f10000b = eArr2;
            }
            this.f10000b[i5] = e6;
            this.f10001c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(i(i5));
    }
}
