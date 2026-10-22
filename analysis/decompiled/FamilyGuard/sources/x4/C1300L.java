package x4;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import x4.M;

/* renamed from: x4.L, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1300L<T extends M & Comparable<? super T>> {

    /* renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f23842b = AtomicIntegerFieldUpdater.newUpdater(C1300L.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* renamed from: a, reason: collision with root package name */
    private T[] f23843a;

    private final T[] g() {
        T[] tArr = this.f23843a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new M[4];
            this.f23843a = tArr2;
            return tArr2;
        }
        if (c() < tArr.length) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, c() * 2);
        j4.k.f(objArrCopyOf, "copyOf(...)");
        T[] tArr3 = (T[]) ((M[]) objArrCopyOf);
        this.f23843a = tArr3;
        return tArr3;
    }

    private final void k(int i5) {
        f23842b.set(this, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void l(int r6) {
        /*
            r5 = this;
        L0:
            int r0 = r6 * 2
            int r1 = r0 + 1
            int r2 = r5.c()
            if (r1 < r2) goto Lb
            goto L3e
        Lb:
            T extends x4.M & java.lang.Comparable<? super T>[] r2 = r5.f23843a
            j4.k.d(r2)
            int r0 = r0 + 2
            int r3 = r5.c()
            if (r0 >= r3) goto L2b
            r3 = r2[r0]
            j4.k.d(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r2[r1]
            j4.k.d(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L2b
            goto L2c
        L2b:
            r0 = r1
        L2c:
            r1 = r2[r6]
            j4.k.d(r1)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            r2 = r2[r0]
            j4.k.d(r2)
            int r1 = r1.compareTo(r2)
            if (r1 > 0) goto L3f
        L3e:
            return
        L3f:
            r5.n(r6, r0)
            r6 = r0
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.C1300L.l(int):void");
    }

    private final void m(int i5) {
        while (i5 > 0) {
            T[] tArr = this.f23843a;
            j4.k.d(tArr);
            int i6 = (i5 - 1) / 2;
            T t5 = tArr[i6];
            j4.k.d(t5);
            T t6 = tArr[i5];
            j4.k.d(t6);
            if (((Comparable) t5).compareTo(t6) <= 0) {
                return;
            }
            n(i5, i6);
            i5 = i6;
        }
    }

    private final void n(int i5, int i6) {
        T[] tArr = this.f23843a;
        j4.k.d(tArr);
        T t5 = tArr[i6];
        j4.k.d(t5);
        T t6 = tArr[i5];
        j4.k.d(t6);
        tArr[i5] = t5;
        tArr[i6] = t6;
        t5.setIndex(i5);
        t6.setIndex(i6);
    }

    public final void a(T t5) {
        t5.e(this);
        M[] mArrG = g();
        int iC = c();
        k(iC + 1);
        mArrG[iC] = t5;
        t5.setIndex(iC);
        m(iC);
    }

    public final T b() {
        T[] tArr = this.f23843a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int c() {
        return f23842b.get(this);
    }

    public final boolean e() {
        return c() == 0;
    }

    public final T f() {
        T t5;
        synchronized (this) {
            t5 = (T) b();
        }
        return t5;
    }

    public final boolean h(T t5) {
        boolean z5;
        synchronized (this) {
            if (t5.d() == null) {
                z5 = false;
            } else {
                i(t5.getIndex());
                z5 = true;
            }
        }
        return z5;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final T i(int r6) {
        /*
            r5 = this;
            T extends x4.M & java.lang.Comparable<? super T>[] r0 = r5.f23843a
            j4.k.d(r0)
            int r1 = r5.c()
            r2 = -1
            int r1 = r1 + r2
            r5.k(r1)
            int r1 = r5.c()
            if (r6 >= r1) goto L3d
            int r1 = r5.c()
            r5.n(r6, r1)
            int r1 = r6 + (-1)
            int r1 = r1 / 2
            if (r6 <= 0) goto L3a
            r3 = r0[r6]
            j4.k.d(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r0[r1]
            j4.k.d(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L3a
            r5.n(r6, r1)
            r5.m(r1)
            goto L3d
        L3a:
            r5.l(r6)
        L3d:
            int r6 = r5.c()
            r6 = r0[r6]
            j4.k.d(r6)
            r1 = 0
            r6.e(r1)
            r6.setIndex(r2)
            int r5 = r5.c()
            r0[r5] = r1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.C1300L.i(int):x4.M");
    }

    public final T j() {
        T t5;
        synchronized (this) {
            t5 = c() > 0 ? (T) i(0) : null;
        }
        return t5;
    }
}
