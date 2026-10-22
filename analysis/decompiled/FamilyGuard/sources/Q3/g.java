package Q3;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public enum g implements Q4.c {
    CANCELLED;

    public static boolean b(AtomicReference<Q4.c> atomicReference) {
        Q4.c andSet;
        Q4.c cVar = atomicReference.get();
        g gVar = CANCELLED;
        if (cVar == gVar || (andSet = atomicReference.getAndSet(gVar)) == gVar) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static void d(AtomicReference<Q4.c> atomicReference, AtomicLong atomicLong, long j5) {
        Q4.c cVar = atomicReference.get();
        if (cVar != null) {
            cVar.h(j5);
            return;
        }
        if (k(j5)) {
            R3.c.a(atomicLong, j5);
            Q4.c cVar2 = atomicReference.get();
            if (cVar2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    cVar2.h(andSet);
                }
            }
        }
    }

    public static boolean e(AtomicReference<Q4.c> atomicReference, AtomicLong atomicLong, Q4.c cVar) {
        if (!j(atomicReference, cVar)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0L);
        if (andSet == 0) {
            return true;
        }
        cVar.h(andSet);
        return true;
    }

    public static void g(long j5) {
        S3.a.r(new B3.e("More produced than requested: " + j5));
    }

    public static void i() {
        S3.a.r(new B3.e("Subscription already set!"));
    }

    public static boolean j(AtomicReference<Q4.c> atomicReference, Q4.c cVar) {
        F3.b.d(cVar, "s is null");
        if (atomicReference.compareAndSet(null, cVar)) {
            return true;
        }
        cVar.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        i();
        return false;
    }

    public static boolean k(long j5) {
        if (j5 > 0) {
            return true;
        }
        S3.a.r(new IllegalArgumentException("n > 0 required but it was " + j5));
        return false;
    }

    public static boolean l(Q4.c cVar, Q4.c cVar2) {
        if (cVar2 == null) {
            S3.a.r(new NullPointerException("next is null"));
            return false;
        }
        if (cVar == null) {
            return true;
        }
        cVar2.cancel();
        i();
        return false;
    }

    @Override // Q4.c
    public void cancel() {
    }

    @Override // Q4.c
    public void h(long j5) {
    }
}
