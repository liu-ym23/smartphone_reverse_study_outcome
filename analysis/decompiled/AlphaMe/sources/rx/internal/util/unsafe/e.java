package rx.internal.util.unsafe;

import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes2.dex */
public final class e extends f {
    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return p() == j();
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        long j4;
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        long j5 = this.f14110a;
        long j6 = j5 + 1;
        long j7 = LongCompanionObject.MAX_VALUE;
        while (true) {
            long j8 = j();
            long j9 = c.f14112g + ((j8 & j5) << c.f14113h);
            long[] jArr = this.f14114f;
            long jG = c.g(jArr, j9) - j8;
            if (jG == 0) {
                j4 = j5;
                long j10 = j8 + 1;
                if (i(j8, j10)) {
                    a.f(this.f14111b, a(j8), obj);
                    c.h(jArr, j9, j10);
                    return true;
                }
            } else {
                j4 = j5;
                if (jG < 0) {
                    long j11 = j8 - j6;
                    if (j11 <= j7) {
                        long jP = p();
                        if (j11 <= jP) {
                            return false;
                        }
                        j7 = jP;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            j5 = j4;
        }
    }

    @Override // java.util.Queue
    public final Object peek() {
        long jP;
        Object objC;
        do {
            jP = p();
            objC = a.c(this.f14111b, a(jP));
            if (objC != null) {
                break;
            }
        } while (jP != j());
        return objC;
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.d
    public final Object poll() {
        long j4 = -1;
        while (true) {
            long jP = p();
            long j5 = this.f14110a;
            long j6 = c.f14112g + ((jP & j5) << c.f14113h);
            long[] jArr = this.f14114f;
            long j7 = j4;
            long j8 = jP + 1;
            long jG = c.g(jArr, j6) - j8;
            if (jG == 0) {
                if (o(jP, j8)) {
                    long jA = a(jP);
                    Object[] objArr = this.f14111b;
                    Object objC = a.c(objArr, jA);
                    a.f(objArr, jA, null);
                    c.h(jArr, j6, jP + j5 + 1);
                    return objC;
                }
            } else if (jG < 0 && jP >= j7) {
                j4 = j();
                if (jP == j4) {
                    return null;
                }
            }
            j4 = j7;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long jP = p();
        while (true) {
            long j4 = j();
            long jP2 = p();
            if (jP == jP2) {
                return (int) (j4 - jP2);
            }
            jP = jP2;
        }
    }
}
