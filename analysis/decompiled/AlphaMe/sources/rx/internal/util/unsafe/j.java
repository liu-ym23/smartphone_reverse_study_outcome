package rx.internal.util.unsafe;

/* loaded from: classes2.dex */
public final class j extends o {
    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return j() == g();
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        long jG = g();
        long jA = a(jG);
        Object[] objArr = this.f14111b;
        if (a.d(objArr, jA) != null) {
            if (jG - j() > this.f14110a) {
                return false;
            }
            while (a.d(objArr, jA) != null) {
            }
        }
        a.f(objArr, jA, obj);
        h(jG + 1);
        return true;
    }

    @Override // java.util.Queue
    public final Object peek() {
        Object objD;
        long j4 = this.f14119h;
        do {
            long j5 = j();
            if (j5 >= j4) {
                long jG = g();
                if (j5 >= jG) {
                    return null;
                }
                this.f14119h = jG;
            }
            objD = a.d(this.f14111b, a(j5));
        } while (objD == null);
        return objD;
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.d
    public final Object poll() {
        long j4;
        long j5 = this.f14119h;
        do {
            j4 = j();
            if (j4 >= j5) {
                long jG = g();
                if (j4 >= jG) {
                    return null;
                }
                this.f14119h = jG;
            }
        } while (!i(j4, 1 + j4));
        long jA = a(j4);
        Object[] objArr = this.f14111b;
        Object objC = a.c(objArr, jA);
        a.e(objArr, jA, null);
        return objC;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long j4 = j();
        while (true) {
            long jG = g();
            long j5 = j();
            if (j4 == j5) {
                return (int) (jG - j5);
            }
            j4 = j5;
        }
    }
}
