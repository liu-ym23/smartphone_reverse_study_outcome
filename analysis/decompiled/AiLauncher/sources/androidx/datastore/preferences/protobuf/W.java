package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class W<E> extends AbstractC1340c<E> implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final W<Object> f13492d;

    /* renamed from: b, reason: collision with root package name */
    public E[] f13493b;

    /* renamed from: c, reason: collision with root package name */
    public int f13494c;

    static {
        W<Object> w10 = new W<>(new Object[0], 0);
        f13492d = w10;
        w10.makeImmutable();
    }

    public W(E[] eArr, int i10) {
        this.f13493b = eArr;
        this.f13494c = i10;
    }

    public static <E> E[] c(int i10) {
        return (E[]) new Object[i10];
    }

    public static <E> W<E> e() {
        return (W<E>) f13492d;
    }

    private void f(int i10) {
        if (i10 < 0 || i10 >= this.f13494c) {
            throw new IndexOutOfBoundsException(i(i10));
        }
    }

    private String i(int i10) {
        return "Index:" + i10 + ", Size:" + this.f13494c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e10) {
        b();
        int i10 = this.f13494c;
        E[] eArr = this.f13493b;
        if (i10 == eArr.length) {
            this.f13493b = (E[]) Arrays.copyOf(eArr, ((i10 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f13493b;
        int i11 = this.f13494c;
        this.f13494c = i11 + 1;
        eArr2[i11] = e10;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        f(i10);
        return this.f13493b[i10];
    }

    @Override // androidx.datastore.preferences.protobuf.C1359w.i
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public W<E> mutableCopyWithCapacity(int i10) {
        if (i10 >= this.f13494c) {
            return new W<>(Arrays.copyOf(this.f13493b, i10), this.f13494c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i10) {
        b();
        f(i10);
        E[] eArr = this.f13493b;
        E e10 = eArr[i10];
        if (i10 < this.f13494c - 1) {
            System.arraycopy(eArr, i10 + 1, eArr, i10, (r2 - i10) - 1);
        }
        this.f13494c--;
        ((AbstractList) this).modCount++;
        return e10;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i10, E e10) {
        b();
        f(i10);
        E[] eArr = this.f13493b;
        E e11 = eArr[i10];
        eArr[i10] = e10;
        ((AbstractList) this).modCount++;
        return e11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f13494c;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, E e10) {
        int i11;
        b();
        if (i10 >= 0 && i10 <= (i11 = this.f13494c)) {
            E[] eArr = this.f13493b;
            if (i11 < eArr.length) {
                System.arraycopy(eArr, i10, eArr, i10 + 1, i11 - i10);
            } else {
                E[] eArr2 = (E[]) c(((i11 * 3) / 2) + 1);
                System.arraycopy(this.f13493b, 0, eArr2, 0, i10);
                System.arraycopy(this.f13493b, i10, eArr2, i10 + 1, this.f13494c - i10);
                this.f13493b = eArr2;
            }
            this.f13493b[i10] = e10;
            this.f13494c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(i(i10));
    }
}
