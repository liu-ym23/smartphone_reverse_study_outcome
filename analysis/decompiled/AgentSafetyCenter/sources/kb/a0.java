package kb;

import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends e implements RandomAccess {

    /* renamed from: f, reason: collision with root package name */
    public final Object[] f7381f;

    /* renamed from: g, reason: collision with root package name */
    public final int f7382g;

    /* renamed from: h, reason: collision with root package name */
    public int f7383h;
    public int i;

    public a0(Object[] objArr, int i) {
        this.f7381f = objArr;
        if (i < 0) {
            od.f.c(k0.a.j(i, "ring buffer filled size should not be negative but it is "));
            throw null;
        }
        if (i <= objArr.length) {
            this.f7382g = objArr.length;
            this.i = i;
        } else {
            StringBuilder sbT = k0.a.t(i, "ring buffer filled size: ", " cannot be larger than the buffer size: ");
            sbT.append(objArr.length);
            throw new IllegalArgumentException(sbT.toString().toString());
        }
    }

    @Override // jb.n
    public final int a() {
        return this.i;
    }

    public final void b() {
        if (14 > this.i) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = 14, size = " + this.i).toString());
        }
        int i = this.f7383h;
        int i3 = this.f7382g;
        int i10 = (i + 14) % i3;
        Object[] objArr = this.f7381f;
        if (i > i10) {
            Arrays.fill(objArr, i, i3, (Object) null);
            Arrays.fill(objArr, 0, i10, (Object) null);
        } else {
            Arrays.fill(objArr, i, i10, (Object) null);
        }
        this.f7383h = i10;
        this.i -= 14;
    }

    @Override // java.util.List
    public final Object get(int i) {
        int i3 = this.i;
        if (i < 0 || i >= i3) {
            g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", i3));
            return null;
        }
        return this.f7381f[(this.f7383h + i) % this.f7382g];
    }

    @Override // kb.e, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        z zVar = new z();
        zVar.i = this;
        zVar.f7412g = a();
        zVar.f7413h = this.f7383h;
        VarHandle.storeStoreFence();
        return zVar;
    }

    @Override // jb.n, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        Object[] objArr2;
        objArr.getClass();
        int length = objArr.length;
        int i = this.i;
        if (length < i) {
            objArr = Arrays.copyOf(objArr, i);
        }
        int i3 = this.i;
        int i10 = this.f7383h;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            objArr2 = this.f7381f;
            if (i12 >= i3 || i10 >= this.f7382g) {
                break;
            }
            objArr[i12] = objArr2[i10];
            i12++;
            i10++;
        }
        while (i12 < i3) {
            objArr[i12] = objArr2[i11];
            i12++;
            i11++;
        }
        if (i3 < objArr.length) {
            objArr[i3] = null;
        }
        return objArr;
    }

    @Override // jb.n, java.util.Collection
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }
}
