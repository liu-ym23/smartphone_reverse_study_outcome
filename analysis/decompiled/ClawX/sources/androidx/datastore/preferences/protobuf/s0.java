package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s0 extends b implements RandomAccess {
    public static final s0 d = new s0(new Object[0], 0, false);

    /* renamed from: b, reason: collision with root package name */
    public Object[] f564b;

    /* renamed from: c, reason: collision with root package name */
    public int f565c;

    public s0(Object[] objArr, int i8, boolean z) {
        this.f450a = z;
        this.f564b = objArr;
        this.f565c = i8;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        f();
        int i8 = this.f565c;
        Object[] objArr = this.f564b;
        if (i8 == objArr.length) {
            this.f564b = Arrays.copyOf(objArr, ((i8 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f564b;
        int i9 = this.f565c;
        this.f565c = i9 + 1;
        objArr2[i9] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void g(int i8) {
        if (i8 < 0 || i8 >= this.f565c) {
            StringBuilder sbS = a8.b.s(i8, "Index:", ", Size:");
            sbS.append(this.f565c);
            throw new IndexOutOfBoundsException(sbS.toString());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i8) {
        g(i8);
        return this.f564b[i8];
    }

    public final s0 h(int i8) {
        if (i8 >= this.f565c) {
            return new s0(Arrays.copyOf(this.f564b, i8), this.f565c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.b, java.util.AbstractList, java.util.List
    public final Object remove(int i8) {
        f();
        g(i8);
        Object[] objArr = this.f564b;
        Object obj = objArr[i8];
        if (i8 < this.f565c - 1) {
            System.arraycopy(objArr, i8 + 1, objArr, i8, (r2 - i8) - 1);
        }
        this.f565c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i8, Object obj) {
        f();
        g(i8);
        Object[] objArr = this.f564b;
        Object obj2 = objArr[i8];
        objArr[i8] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f565c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i8, Object obj) {
        int i9;
        f();
        if (i8 >= 0 && i8 <= (i9 = this.f565c)) {
            Object[] objArr = this.f564b;
            if (i9 < objArr.length) {
                System.arraycopy(objArr, i8, objArr, i8 + 1, i9 - i8);
            } else {
                Object[] objArr2 = new Object[((i9 * 3) / 2) + 1];
                System.arraycopy(objArr, 0, objArr2, 0, i8);
                System.arraycopy(this.f564b, i8, objArr2, i8 + 1, this.f565c - i8);
                this.f564b = objArr2;
            }
            this.f564b[i8] = obj;
            this.f565c++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbS = a8.b.s(i8, "Index:", ", Size:");
        sbS.append(this.f565c);
        throw new IndexOutOfBoundsException(sbS.toString());
    }
}
