package g3;

import S.s;
import X.r;
import Z2.I;
import Z2.InterfaceC0126g;
import d3.AbstractC0542d;
import d3.v;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12671c = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "head");

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f12672d = AtomicLongFieldUpdater.newUpdater(h.class, "deqIdx");

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12673e = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "tail");

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f12674f = AtomicLongFieldUpdater.newUpdater(h.class, "enqIdx");

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f12675g = AtomicIntegerFieldUpdater.newUpdater(h.class, "_availablePermits");

    @Volatile
    private volatile int _availablePermits;

    /* renamed from: a, reason: collision with root package name */
    public final int f12676a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final s f12677b;

    @Volatile
    private volatile long deqIdx;

    @Volatile
    private volatile long enqIdx;

    @Volatile
    @Nullable
    private volatile Object head;

    @Volatile
    @Nullable
    private volatile Object tail;

    public h(int i4) {
        if (i4 < 0 || i4 > 1) {
            throw new IllegalArgumentException("The number of acquired permits should be in 0..1".toString());
        }
        j jVar = new j(0L, null, 2);
        this.head = jVar;
        this.tail = jVar;
        this._availablePermits = 1 - i4;
        this.f12677b = new s(7, this);
    }

    public final void a(C0579c c0579c) {
        Object objA;
        C0582f c0582f;
        long j4;
        while (true) {
            int andDecrement = f12675g.getAndDecrement(this);
            if (andDecrement <= this.f12676a) {
                Function1 function1 = this.f12677b;
                if (andDecrement > 0) {
                    c0579c.g(Unit.INSTANCE, function1);
                    return;
                }
                Intrinsics.checkNotNull(c0579c, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12673e;
                j jVar = (j) atomicReferenceFieldUpdater.get(this);
                long andIncrement = f12674f.getAndIncrement(this);
                C0582f c0582f2 = C0582f.f12669a;
                long j5 = andIncrement / i.f12683f;
                while (true) {
                    objA = AbstractC0542d.a(jVar, j5, c0582f2);
                    if (!I.w(objA)) {
                        v vVarR = I.r(objA);
                        while (true) {
                            v vVar = (v) atomicReferenceFieldUpdater.get(this);
                            c0582f = c0582f2;
                            j4 = j5;
                            if (vVar.f12481c >= vVarR.f12481c) {
                                break;
                            }
                            if (!vVarR.i()) {
                                break;
                            }
                            if (!atomicReferenceFieldUpdater.compareAndSet(this, vVar, vVarR)) {
                                if (vVarR.e()) {
                                    vVarR.d();
                                }
                                c0582f2 = c0582f;
                                j5 = j4;
                            } else if (vVar.e()) {
                                vVar.d();
                            }
                        }
                    } else {
                        break;
                    }
                    c0582f2 = c0582f;
                    j5 = j4;
                }
                j jVar2 = (j) I.r(objA);
                int i4 = (int) (andIncrement % i.f12683f);
                AtomicReferenceArray atomicReferenceArray = jVar2.f12684e;
                if (atomicReferenceArray.compareAndSet(i4, null, c0579c)) {
                    c0579c.a(jVar2, i4);
                    return;
                } else if (atomicReferenceArray.compareAndSet(i4, i.f12679b, i.f12680c)) {
                    Intrinsics.checkNotNull(c0579c, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
                    c0579c.g(Unit.INSTANCE, function1);
                    return;
                }
            }
        }
    }

    public final void b() {
        int i4;
        Object objA;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f12675g;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            int i5 = this.f12676a;
            if (andIncrement >= i5) {
                do {
                    i4 = atomicIntegerFieldUpdater.get(this);
                    if (i4 <= i5) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i4, i5));
                throw new IllegalStateException(("The number of released permits cannot be greater than " + i5).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12671c;
            j jVar = (j) atomicReferenceFieldUpdater.get(this);
            long andIncrement2 = f12672d.getAndIncrement(this);
            long j4 = andIncrement2 / i.f12683f;
            g gVar = g.f12670a;
            while (true) {
                objA = AbstractC0542d.a(jVar, j4, gVar);
                if (I.w(objA)) {
                    break;
                }
                v vVarR = I.r(objA);
                while (true) {
                    v vVar = (v) atomicReferenceFieldUpdater.get(this);
                    if (vVar.f12481c >= vVarR.f12481c) {
                        break;
                    }
                    if (!vVarR.i()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, vVar, vVarR)) {
                        if (vVar.e()) {
                            vVar.d();
                        }
                    } else if (vVarR.e()) {
                        vVarR.d();
                    }
                }
            }
            j jVar2 = (j) I.r(objA);
            jVar2.a();
            if (jVar2.f12481c <= j4) {
                int i6 = (int) (andIncrement2 % i.f12683f);
                r rVar = i.f12679b;
                AtomicReferenceArray atomicReferenceArray = jVar2.f12684e;
                Object andSet = atomicReferenceArray.getAndSet(i6, rVar);
                if (andSet == null) {
                    int i7 = i.f12678a;
                    for (int i8 = 0; i8 < i7; i8++) {
                        if (atomicReferenceArray.get(i6) == i.f12680c) {
                            return;
                        }
                    }
                    if (!atomicReferenceArray.compareAndSet(i6, i.f12679b, i.f12681d)) {
                        return;
                    }
                } else if (andSet == i.f12682e) {
                    continue;
                } else {
                    if (!(andSet instanceof InterfaceC0126g)) {
                        throw new IllegalStateException(("unexpected: " + andSet).toString());
                    }
                    Intrinsics.checkNotNull(andSet, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
                    InterfaceC0126g interfaceC0126g = (InterfaceC0126g) andSet;
                    r rVarH = interfaceC0126g.h(Unit.INSTANCE, this.f12677b);
                    if (rVarH != null) {
                        interfaceC0126g.q(rVarH);
                        return;
                    }
                }
            }
        }
    }
}
