package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class x0 extends b implements RandomAccess {

    /* renamed from: i, reason: collision with root package name */
    public static final x0 f965i;

    /* renamed from: g, reason: collision with root package name */
    public Object[] f966g;

    /* renamed from: h, reason: collision with root package name */
    public int f967h;

    static {
        x0 x0Var = new x0(0, new Object[0]);
        f965i = x0Var;
        x0Var.f805f = false;
    }

    public x0(int i2, Object[] objArr) {
        this.f966g = objArr;
        this.f967h = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.b, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        a();
        int i2 = this.f967h;
        Object[] objArr = this.f966g;
        if (i2 == objArr.length) {
            this.f966g = Arrays.copyOf(objArr, ((i2 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f966g;
        int i10 = this.f967h;
        this.f967h = i10 + 1;
        objArr2[i10] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f967h) {
            StringBuilder sbN = a1.a.n(i2, "Index:", ", Size:");
            sbN.append(this.f967h);
            throw new IndexOutOfBoundsException(sbN.toString());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        f(i2);
        return this.f966g[i2];
    }

    @Override // androidx.datastore.preferences.protobuf.x
    public final x mutableCopyWithCapacity(int i2) {
        if (i2 < this.f967h) {
            throw new IllegalArgumentException();
        }
        return new x0(this.f967h, Arrays.copyOf(this.f966g, i2));
    }

    @Override // androidx.datastore.preferences.protobuf.b, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        a();
        f(i2);
        Object[] objArr = this.f966g;
        Object obj = objArr[i2];
        if (i2 < this.f967h - 1) {
            System.arraycopy(objArr, i2 + 1, objArr, i2, (r2 - i2) - 1);
        }
        this.f967h--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        a();
        f(i2);
        Object[] objArr = this.f966g;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f967h;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i10;
        a();
        if (i2 >= 0 && i2 <= (i10 = this.f967h)) {
            Object[] objArr = this.f966g;
            if (i10 < objArr.length) {
                System.arraycopy(objArr, i2, objArr, i2 + 1, i10 - i2);
            } else {
                Object[] objArr2 = new Object[((i10 * 3) / 2) + 1];
                System.arraycopy(objArr, 0, objArr2, 0, i2);
                System.arraycopy(this.f966g, i2, objArr2, i2 + 1, this.f967h - i2);
                this.f966g = objArr2;
            }
            this.f966g[i2] = obj;
            this.f967h++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbN = a1.a.n(i2, "Index:", ", Size:");
        sbN.append(this.f967h);
        throw new IndexOutOfBoundsException(sbN.toString());
    }
}
