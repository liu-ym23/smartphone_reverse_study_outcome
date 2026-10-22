package rx.internal.util.unsafe;

/* loaded from: classes2.dex */
public final class p extends t {
    public p(int i4) {
        super(i4);
        Math.min(i4 / 4, r.f14121f.intValue());
    }

    public final long g() {
        return v.f14123a.getLongVolatile(this, q.f14120h);
    }

    public final long h() {
        return v.f14123a.getLongVolatile(this, u.f14122g);
    }

    public final void i(long j4) {
        v.f14123a.putOrderedLong(this, q.f14120h, j4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return h() == g();
    }

    public final void j(long j4) {
        v.f14123a.putOrderedLong(this, u.f14122g, j4);
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("null elements not allowed");
        }
        long j4 = this.producerIndex;
        long jA = a(j4);
        Object[] objArr = this.f14111b;
        if (a.d(objArr, jA) != null) {
            return false;
        }
        a.e(objArr, jA, obj);
        j(j4 + 1);
        return true;
    }

    @Override // java.util.Queue
    public final Object peek() {
        return a.d(this.f14111b, a(this.consumerIndex));
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.d
    public final Object poll() {
        long j4 = this.consumerIndex;
        long jA = a(j4);
        Object[] objArr = this.f14111b;
        Object objD = a.d(objArr, jA);
        if (objD == null) {
            return null;
        }
        a.e(objArr, jA, null);
        i(j4 + 1);
        return objD;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long jG = g();
        while (true) {
            long jH = h();
            long jG2 = g();
            if (jG == jG2) {
                return (int) (jH - jG2);
            }
            jG = jG2;
        }
    }
}
