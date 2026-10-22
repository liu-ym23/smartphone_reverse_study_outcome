package E3;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public enum b implements A3.c {
    DISPOSED;

    public static boolean b(AtomicReference<A3.c> atomicReference) {
        A3.c andSet;
        A3.c cVar = atomicReference.get();
        b bVar = DISPOSED;
        if (cVar == bVar || (andSet = atomicReference.getAndSet(bVar)) == bVar) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean d(A3.c cVar) {
        return cVar == DISPOSED;
    }

    public static boolean e(AtomicReference<A3.c> atomicReference, A3.c cVar) {
        A3.c cVar2;
        do {
            cVar2 = atomicReference.get();
            if (cVar2 == DISPOSED) {
                if (cVar == null) {
                    return false;
                }
                cVar.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(cVar2, cVar));
        return true;
    }

    public static void h() {
        S3.a.r(new B3.e("Disposable already set!"));
    }

    public static boolean i(AtomicReference<A3.c> atomicReference, A3.c cVar) {
        A3.c cVar2;
        do {
            cVar2 = atomicReference.get();
            if (cVar2 == DISPOSED) {
                if (cVar == null) {
                    return false;
                }
                cVar.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(cVar2, cVar));
        if (cVar2 == null) {
            return true;
        }
        cVar2.dispose();
        return true;
    }

    public static boolean j(AtomicReference<A3.c> atomicReference, A3.c cVar) {
        F3.b.d(cVar, "d is null");
        if (atomicReference.compareAndSet(null, cVar)) {
            return true;
        }
        cVar.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        h();
        return false;
    }

    public static boolean k(AtomicReference<A3.c> atomicReference, A3.c cVar) {
        if (atomicReference.compareAndSet(null, cVar)) {
            return true;
        }
        if (atomicReference.get() != DISPOSED) {
            return false;
        }
        cVar.dispose();
        return false;
    }

    public static boolean l(A3.c cVar, A3.c cVar2) {
        if (cVar2 == null) {
            S3.a.r(new NullPointerException("next is null"));
            return false;
        }
        if (cVar == null) {
            return true;
        }
        cVar2.dispose();
        h();
        return false;
    }

    @Override // A3.c
    public void dispose() {
    }

    @Override // A3.c
    public boolean g() {
        return true;
    }
}
