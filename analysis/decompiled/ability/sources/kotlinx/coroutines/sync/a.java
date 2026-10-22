package kotlinx.coroutines.sync;

import A5.c;
import Ca.C0203b;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.p;
import m9.AbstractC1683A;
import v9.InterfaceC2073b;
import w9.InterfaceC2108a;
import w9.d;

/* loaded from: classes4.dex */
public final class a extends b implements InterfaceC2108a {
    public static final /* synthetic */ AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "owner$volatile");
    public final C0203b h;
    private volatile /* synthetic */ Object owner$volatile;

    public a() {
        super(1);
        this.owner$volatile = d.f6855a;
        this.h = new C0203b(this, 3);
    }

    @Override // w9.InterfaceC2108a
    public final InterfaceC2073b getOnLock() {
        MutexImpl$onLock$1 mutexImpl$onLock$1 = MutexImpl$onLock$1.f5257a;
        k.d(mutexImpl$onLock$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        p.e(3, mutexImpl$onLock$1);
        MutexImpl$onLock$2 mutexImpl$onLock$2 = MutexImpl$onLock$2.f5258a;
        k.d(mutexImpl$onLock$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        p.e(3, mutexImpl$onLock$2);
        return new c(this, mutexImpl$onLock$1, mutexImpl$onLock$2, this.h);
    }

    @Override // w9.InterfaceC2108a
    public final boolean holdsLock(Object obj) {
        char c;
        while (true) {
            if (!isLocked()) {
                c = 0;
                break;
            }
            Object obj2 = i.get(this);
            if (obj2 != d.f6855a) {
                c = obj2 == obj ? (char) 1 : (char) 2;
            }
        }
        return c == 1;
    }

    @Override // w9.InterfaceC2108a
    public final boolean isLocked() {
        return Math.max(b.g.get(this), 0) == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        r4 = r0.c;
        kotlinx.coroutines.sync.a.i.set(r4, r0.b);
        r0.f6853a.e(new R3.b(28, r4, r0), r1);
     */
    @Override // w9.InterfaceC2108a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object lock(java.lang.Object r5, H7.c r6) {
        /*
            r4 = this;
            boolean r0 = r4.tryLock(r5)
            C7.r r1 = C7.r.f317a
            if (r0 == 0) goto L9
            goto L4b
        L9:
            H7.c r6 = U7.a.I(r6)
            m9.k r6 = m9.AbstractC1683A.j(r6)
            w9.b r0 = new w9.b     // Catch: java.lang.Throwable -> L4c
            r0.<init>(r4, r6, r5)     // Catch: java.lang.Throwable -> L4c
        L16:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r5 = kotlinx.coroutines.sync.b.g     // Catch: java.lang.Throwable -> L4c
            int r5 = r5.getAndDecrement(r4)     // Catch: java.lang.Throwable -> L4c
            int r2 = r4.f5261a     // Catch: java.lang.Throwable -> L4c
            if (r5 > r2) goto L16
            if (r5 <= 0) goto L38
            kotlinx.coroutines.sync.a r4 = r0.c     // Catch: java.lang.Throwable -> L4c
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.sync.a.i     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r2 = r0.b     // Catch: java.lang.Throwable -> L4c
            r5.set(r4, r2)     // Catch: java.lang.Throwable -> L4c
            m9.k r5 = r0.f6853a     // Catch: java.lang.Throwable -> L4c
            R3.b r2 = new R3.b     // Catch: java.lang.Throwable -> L4c
            r3 = 28
            r2.<init>(r3, r4, r0)     // Catch: java.lang.Throwable -> L4c
            r5.e(r2, r1)     // Catch: java.lang.Throwable -> L4c
            goto L3e
        L38:
            boolean r5 = r4.b(r0)     // Catch: java.lang.Throwable -> L4c
            if (r5 == 0) goto L16
        L3e:
            java.lang.Object r4 = r6.x()
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            if (r4 != r5) goto L47
            goto L48
        L47:
            r4 = r1
        L48:
            if (r4 != r5) goto L4b
            return r4
        L4b:
            return r1
        L4c:
            r4 = move-exception
            r6.E()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.a.lock(java.lang.Object, H7.c):java.lang.Object");
    }

    public final String toString() {
        return "Mutex@" + AbstractC1683A.i(this) + "[isLocked=" + isLocked() + ",owner=" + i.get(this) + ']';
    }

    @Override // w9.InterfaceC2108a
    public final boolean tryLock(Object obj) {
        char c;
        char c2;
        do {
            boolean zD = d();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
            if (!zD) {
                if (obj != null) {
                    while (true) {
                        if (!isLocked()) {
                            c2 = 0;
                            break;
                        }
                        Object obj2 = atomicReferenceFieldUpdater.get(this);
                        if (obj2 != d.f6855a) {
                            c2 = obj2 == obj ? (char) 1 : (char) 2;
                        }
                    }
                    if (c2 == 1) {
                        c = 2;
                        break;
                    }
                } else {
                    break;
                }
            } else {
                atomicReferenceFieldUpdater.set(this, obj);
                c = 0;
                break;
            }
        } while (c2 != 2);
        c = 1;
        if (c == 0) {
            return true;
        }
        if (c == 1) {
            return false;
        }
        if (c != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException(androidx.compose.foundation.b.r(obj, "This mutex is already locked by the specified owner: "));
    }

    @Override // w9.InterfaceC2108a
    public final void unlock(Object obj) {
        while (isLocked()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            a5.d dVar = d.f6855a;
            if (obj2 != dVar) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, dVar)) {
                    c();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }
}
