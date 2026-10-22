package a3;

import S.C0107m;
import Z2.C;
import Z2.C0128h;
import Z2.I;
import Z2.InterfaceC0126g;
import Z2.K0;
import androidx.fragment.app.A;
import d3.AbstractC0542d;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.time.DurationKt;
import l1.C0756a;
import org.jetbrains.annotations.Nullable;

/* renamed from: a3.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0160e implements InterfaceC0164i {

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f2278c = AtomicLongFieldUpdater.newUpdater(C0160e.class, "sendersAndCloseStatus");

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f2279d = AtomicLongFieldUpdater.newUpdater(C0160e.class, "receivers");

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f2280e = AtomicLongFieldUpdater.newUpdater(C0160e.class, "bufferEnd");

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f2281f = AtomicLongFieldUpdater.newUpdater(C0160e.class, "completedExpandBuffersAndPauseFlag");

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2282g = AtomicReferenceFieldUpdater.newUpdater(C0160e.class, Object.class, "sendSegment");

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2283h = AtomicReferenceFieldUpdater.newUpdater(C0160e.class, Object.class, "receiveSegment");

    /* renamed from: i, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2284i = AtomicReferenceFieldUpdater.newUpdater(C0160e.class, Object.class, "bufferEndSegment");

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2285j = AtomicReferenceFieldUpdater.newUpdater(C0160e.class, Object.class, "_closeCause");

    /* renamed from: k, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2286k = AtomicReferenceFieldUpdater.newUpdater(C0160e.class, Object.class, "closeHandler");

    @Volatile
    @Nullable
    private volatile Object _closeCause;

    /* renamed from: a, reason: collision with root package name */
    public final int f2287a;

    /* renamed from: b, reason: collision with root package name */
    public final Function1 f2288b;

    @Volatile
    private volatile long bufferEnd;

    @Volatile
    @Nullable
    private volatile Object bufferEndSegment;

    @Volatile
    @Nullable
    private volatile Object closeHandler;

    @Volatile
    private volatile long completedExpandBuffersAndPauseFlag;

    @Volatile
    @Nullable
    private volatile Object receiveSegment;

    @Volatile
    private volatile long receivers;

    @Volatile
    @Nullable
    private volatile Object sendSegment;

    @Volatile
    private volatile long sendersAndCloseStatus;

    public C0160e(int i4, Function1 function1) {
        this.f2287a = i4;
        this.f2288b = function1;
        if (i4 < 0) {
            throw new IllegalArgumentException(B0.g.j("Invalid channel capacity: ", i4, ", should be >=0").toString());
        }
        C0169n c0169n = AbstractC0162g.f2290a;
        this.bufferEnd = i4 != 0 ? i4 != Integer.MAX_VALUE ? i4 : LongCompanionObject.MAX_VALUE : 0L;
        this.completedExpandBuffersAndPauseFlag = f2280e.get(this);
        C0169n c0169n2 = new C0169n(0L, null, this, 3);
        this.sendSegment = c0169n2;
        this.receiveSegment = c0169n2;
        if (A()) {
            c0169n2 = AbstractC0162g.f2290a;
            Intrinsics.checkNotNull(c0169n2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment = c0169n2;
        if (function1 != null) {
            new C0157b(0, this);
        }
        this._closeCause = AbstractC0162g.f2308s;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object D(a3.C0160e r13, kotlin.coroutines.Continuation r14) {
        /*
            boolean r0 = r14 instanceof a3.C0158c
            if (r0 == 0) goto L14
            r0 = r14
            a3.c r0 = (a3.C0158c) r0
            int r1 = r0.f2274c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f2274c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            a3.c r0 = new a3.c
            r0.<init>(r13, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.f2272a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.f2274c
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            kotlin.ResultKt.throwOnFailure(r14)
            a3.m r14 = (a3.C0168m) r14
            java.lang.Object r13 = r14.f2315a
            goto L9b
        L30:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L38:
            kotlin.ResultKt.throwOnFailure(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = a3.C0160e.f2283h
            java.lang.Object r14 = r14.get(r13)
            a3.n r14 = (a3.C0169n) r14
        L43:
            boolean r1 = r13.y()
            if (r1 == 0) goto L53
            java.lang.Throwable r13 = r13.s()
            a3.k r14 = new a3.k
            r14.<init>(r13)
            goto La1
        L53:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = a3.C0160e.f2279d
            long r4 = r1.getAndIncrement(r13)
            int r1 = a3.AbstractC0162g.f2291b
            long r7 = (long) r1
            long r9 = r4 / r7
            long r7 = r4 % r7
            int r3 = (int) r7
            long r7 = r14.f12481c
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 == 0) goto L6f
            a3.n r1 = r13.r(r9, r14)
            if (r1 != 0) goto L6e
            goto L43
        L6e:
            r14 = r1
        L6f:
            r12 = 0
            r7 = r13
            r8 = r14
            r9 = r3
            r10 = r4
            java.lang.Object r1 = r7.I(r8, r9, r10, r12)
            X.r r7 = a3.AbstractC0162g.f2302m
            if (r1 == r7) goto La2
            X.r r7 = a3.AbstractC0162g.f2304o
            if (r1 != r7) goto L8c
            long r7 = r13.v()
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 >= 0) goto L43
            r14.a()
            goto L43
        L8c:
            X.r r7 = a3.AbstractC0162g.f2303n
            if (r1 != r7) goto L9d
            r6.f2274c = r2
            r1 = r13
            r2 = r14
            java.lang.Object r13 = r1.E(r2, r3, r4, r6)
            if (r13 != r0) goto L9b
            return r0
        L9b:
            r14 = r13
            goto La1
        L9d:
            r14.a()
            r14 = r1
        La1:
            return r14
        La2:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.C0160e.D(a3.e, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static boolean H(Object obj) {
        if (obj instanceof InterfaceC0126g) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return AbstractC0162g.a((InterfaceC0126g) obj, Unit.INSTANCE, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    public static final C0169n a(C0160e c0160e, long j4, C0169n c0169n) {
        Object objA;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j5;
        long j6;
        c0160e.getClass();
        C0169n c0169n2 = AbstractC0162g.f2290a;
        C0161f c0161f = C0161f.f2289a;
        loop0: while (true) {
            objA = AbstractC0542d.a(c0169n, j4, c0161f);
            if (!I.w(objA)) {
                d3.v vVarR = I.r(objA);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2282g;
                    d3.v vVar = (d3.v) atomicReferenceFieldUpdater.get(c0160e);
                    if (vVar.f12481c >= vVarR.f12481c) {
                        break loop0;
                    }
                    if (!vVarR.i()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(c0160e, vVar, vVarR)) {
                        if (vVar.e()) {
                            vVar.d();
                        }
                    } else if (vVarR.e()) {
                        vVarR.d();
                    }
                }
            } else {
                break;
            }
        }
        boolean zW = I.w(objA);
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f2279d;
        if (zW) {
            c0160e.n();
            if (c0169n.f12481c * AbstractC0162g.f2291b >= atomicLongFieldUpdater2.get(c0160e)) {
                return null;
            }
            c0169n.a();
            return null;
        }
        C0169n c0169n3 = (C0169n) I.r(objA);
        long j7 = c0169n3.f12481c;
        if (j7 <= j4) {
            return c0169n3;
        }
        long j8 = AbstractC0162g.f2291b * j7;
        do {
            atomicLongFieldUpdater = f2278c;
            j5 = atomicLongFieldUpdater.get(c0160e);
            j6 = 1152921504606846975L & j5;
            if (j6 >= j8) {
                break;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(c0160e, j5, j6 + (((int) (j5 >> 60)) << 60)));
        if (j7 * AbstractC0162g.f2291b >= atomicLongFieldUpdater2.get(c0160e)) {
            return null;
        }
        c0169n3.a();
        return null;
    }

    public static final void e(C0160e c0160e, IndexedValue indexedValue, C0128h c0128h) {
        A aI;
        Function1 function1 = c0160e.f2288b;
        if (function1 != null && (aI = com.stepos.statsrpk.c.i(function1, indexedValue, null)) != null) {
            C.a(c0128h.f2220e, aI);
        }
        Throwable thU = c0160e.u();
        Result.Companion companion = Result.INSTANCE;
        c0128h.resumeWith(Result.m22constructorimpl(ResultKt.createFailure(thU)));
    }

    public static final int g(C0160e c0160e, C0169n c0169n, int i4, Object obj, long j4, Object obj2, boolean z4) {
        c0160e.getClass();
        c0169n.m(i4, obj);
        if (z4) {
            return c0160e.J(c0169n, i4, obj, j4, obj2, z4);
        }
        Object objK = c0169n.k(i4);
        if (objK == null) {
            if (c0160e.h(j4)) {
                if (c0169n.j(i4, null, AbstractC0162g.f2293d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (c0169n.j(i4, null, obj2)) {
                    return 2;
                }
            }
        } else if (objK instanceof K0) {
            c0169n.m(i4, null);
            if (c0160e.G(objK, obj)) {
                c0169n.n(i4, AbstractC0162g.f2298i);
                return 0;
            }
            X.r rVar = AbstractC0162g.f2300k;
            if (c0169n.f2317f.getAndSet((i4 * 2) + 1, rVar) != rVar) {
                c0169n.l(i4, true);
            }
            return 5;
        }
        return c0160e.J(c0169n, i4, obj, j4, obj2, z4);
    }

    public static void w(C0160e c0160e) {
        c0160e.getClass();
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2281f;
        if ((atomicLongFieldUpdater.addAndGet(c0160e, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(c0160e) & 4611686018427387904L) != 0) {
            }
        }
    }

    public final boolean A() {
        long j4 = f2280e.get(this);
        return j4 == 0 || j4 == LongCompanionObject.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B(long r5, a3.C0169n r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f12481c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            d3.e r0 = r7.b()
            a3.n r0 = (a3.C0169n) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.c()
            if (r5 == 0) goto L22
            d3.e r5 = r7.b()
            a3.n r5 = (a3.C0169n) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = a3.C0160e.f2284i
            java.lang.Object r6 = r5.get(r4)
            d3.v r6 = (d3.v) r6
            long r0 = r6.f12481c
            long r2 = r7.f12481c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r7.i()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r5 = r5.compareAndSet(r4, r6, r7)
            if (r5 == 0) goto L4a
            boolean r4 = r6.e()
            if (r4 == 0) goto L49
            r6.d()
        L49:
            return
        L4a:
            boolean r5 = r7.e()
            if (r5 == 0) goto L22
            r7.d()
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.C0160e.B(long, a3.n):void");
    }

    public final Object C(IndexedValue indexedValue, c3.f fVar) {
        A aI;
        C0128h c0128h = new C0128h(1, IntrinsicsKt.intercepted(fVar));
        c0128h.u();
        Function1 function1 = this.f2288b;
        if (function1 == null || (aI = com.stepos.statsrpk.c.i(function1, indexedValue, null)) == null) {
            Throwable thU = u();
            Result.Companion companion = Result.INSTANCE;
            c0128h.resumeWith(Result.m22constructorimpl(ResultKt.createFailure(thU)));
        } else {
            ExceptionsKt.addSuppressed(aI, u());
            Result.Companion companion2 = Result.INSTANCE;
            c0128h.resumeWith(Result.m22constructorimpl(ResultKt.createFailure(aI)));
        }
        Object objT = c0128h.t();
        if (objT == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(fVar);
        }
        return objT == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objT : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object E(a3.C0169n r17, int r18, long r19, kotlin.coroutines.Continuation r21) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.C0160e.E(a3.n, int, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void F(K0 k02, boolean z4) {
        if (k02 instanceof InterfaceC0126g) {
            Continuation continuation = (Continuation) k02;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m22constructorimpl(ResultKt.createFailure(z4 ? t() : u())));
            return;
        }
        if (k02 instanceof u) {
            C0128h c0128h = ((u) k02).f2322a;
            Result.Companion companion2 = Result.INSTANCE;
            c0128h.resumeWith(Result.m22constructorimpl(new C0168m(new C0166k(s()))));
            return;
        }
        if (!(k02 instanceof C0156a)) {
            throw new IllegalStateException(("Unexpected waiter: " + k02).toString());
        }
        C0156a c0156a = (C0156a) k02;
        C0128h c0128h2 = c0156a.f2268b;
        Intrinsics.checkNotNull(c0128h2);
        c0156a.f2268b = null;
        c0156a.f2267a = AbstractC0162g.f2301l;
        Throwable thS = c0156a.f2269c.s();
        if (thS == null) {
            Result.Companion companion3 = Result.INSTANCE;
            c0128h2.resumeWith(Result.m22constructorimpl(Boolean.FALSE));
        } else {
            Result.Companion companion4 = Result.INSTANCE;
            c0128h2.resumeWith(Result.m22constructorimpl(ResultKt.createFailure(thS)));
        }
    }

    public final boolean G(Object obj, Object obj2) {
        boolean z4 = obj instanceof u;
        Function1 function1 = this.f2288b;
        if (z4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            C0128h c0128h = ((u) obj).f2322a;
            return AbstractC0162g.a(c0128h, new C0168m(obj2), function1 != null ? com.stepos.statsrpk.c.h(function1, obj2, c0128h.f2220e) : null);
        }
        if (!(obj instanceof C0156a)) {
            if (obj instanceof InterfaceC0126g) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
                InterfaceC0126g interfaceC0126g = (InterfaceC0126g) obj;
                return AbstractC0162g.a(interfaceC0126g, obj2, function1 != null ? com.stepos.statsrpk.c.h(function1, obj2, interfaceC0126g.get$context()) : null);
            }
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
        C0156a c0156a = (C0156a) obj;
        C0128h c0128h2 = c0156a.f2268b;
        Intrinsics.checkNotNull(c0128h2);
        c0156a.f2268b = null;
        c0156a.f2267a = obj2;
        Boolean bool = Boolean.TRUE;
        Function1 function12 = c0156a.f2269c.f2288b;
        return AbstractC0162g.a(c0128h2, bool, function12 != null ? com.stepos.statsrpk.c.h(function12, obj2, c0128h2.f2220e) : null);
    }

    public final Object I(C0169n c0169n, int i4, long j4, Object obj) {
        Object objK = c0169n.k(i4);
        AtomicReferenceArray atomicReferenceArray = c0169n.f2317f;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2278c;
        if (objK == null) {
            if (j4 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return AbstractC0162g.f2303n;
                }
                if (c0169n.j(i4, objK, obj)) {
                    q();
                    return AbstractC0162g.f2302m;
                }
            }
        } else if (objK == AbstractC0162g.f2293d && c0169n.j(i4, objK, AbstractC0162g.f2298i)) {
            q();
            Object obj2 = atomicReferenceArray.get(i4 * 2);
            c0169n.m(i4, null);
            return obj2;
        }
        while (true) {
            Object objK2 = c0169n.k(i4);
            if (objK2 == null || objK2 == AbstractC0162g.f2294e) {
                if (j4 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (c0169n.j(i4, objK2, AbstractC0162g.f2297h)) {
                        q();
                        return AbstractC0162g.f2304o;
                    }
                } else {
                    if (obj == null) {
                        return AbstractC0162g.f2303n;
                    }
                    if (c0169n.j(i4, objK2, obj)) {
                        q();
                        return AbstractC0162g.f2302m;
                    }
                }
            } else {
                if (objK2 != AbstractC0162g.f2293d) {
                    X.r rVar = AbstractC0162g.f2299j;
                    if (objK2 != rVar && objK2 != AbstractC0162g.f2297h) {
                        if (objK2 == AbstractC0162g.f2301l) {
                            q();
                            return AbstractC0162g.f2304o;
                        }
                        if (objK2 != AbstractC0162g.f2296g && c0169n.j(i4, objK2, AbstractC0162g.f2295f)) {
                            boolean z4 = objK2 instanceof x;
                            if (z4) {
                                objK2 = ((x) objK2).f2323a;
                            }
                            if (H(objK2)) {
                                c0169n.n(i4, AbstractC0162g.f2298i);
                                q();
                                Object obj3 = atomicReferenceArray.get(i4 * 2);
                                c0169n.m(i4, null);
                                return obj3;
                            }
                            c0169n.n(i4, rVar);
                            c0169n.l(i4, false);
                            if (z4) {
                                q();
                            }
                            return AbstractC0162g.f2304o;
                        }
                    }
                    return AbstractC0162g.f2304o;
                }
                if (c0169n.j(i4, objK2, AbstractC0162g.f2298i)) {
                    q();
                    Object obj4 = atomicReferenceArray.get(i4 * 2);
                    c0169n.m(i4, null);
                    return obj4;
                }
            }
        }
    }

    public final int J(C0169n c0169n, int i4, Object obj, long j4, Object obj2, boolean z4) {
        while (true) {
            Object objK = c0169n.k(i4);
            if (objK == null) {
                if (!h(j4) || z4) {
                    if (z4) {
                        if (c0169n.j(i4, null, AbstractC0162g.f2299j)) {
                            c0169n.l(i4, false);
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (c0169n.j(i4, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (c0169n.j(i4, null, AbstractC0162g.f2293d)) {
                    return 1;
                }
            } else {
                if (objK != AbstractC0162g.f2294e) {
                    X.r rVar = AbstractC0162g.f2300k;
                    if (objK == rVar) {
                        c0169n.m(i4, null);
                        return 5;
                    }
                    if (objK == AbstractC0162g.f2297h) {
                        c0169n.m(i4, null);
                        return 5;
                    }
                    if (objK == AbstractC0162g.f2301l) {
                        c0169n.m(i4, null);
                        n();
                        return 4;
                    }
                    c0169n.m(i4, null);
                    if (objK instanceof x) {
                        objK = ((x) objK).f2323a;
                    }
                    if (G(objK, obj)) {
                        c0169n.n(i4, AbstractC0162g.f2298i);
                        return 0;
                    }
                    if (c0169n.f2317f.getAndSet((i4 * 2) + 1, rVar) != rVar) {
                        c0169n.l(i4, true);
                    }
                    return 5;
                }
                if (c0169n.j(i4, objK, AbstractC0162g.f2293d)) {
                    return 1;
                }
            }
        }
    }

    public final void K(long j4) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j5;
        long j6;
        if (A()) {
            return;
        }
        do {
            atomicLongFieldUpdater = f2280e;
        } while (atomicLongFieldUpdater.get(this) <= j4);
        int i4 = AbstractC0162g.f2292c;
        int i5 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f2281f;
            if (i5 >= i4) {
                do {
                    j5 = atomicLongFieldUpdater2.get(this);
                } while (!atomicLongFieldUpdater2.compareAndSet(this, j5, 4611686018427387904L + (j5 & DurationKt.MAX_MILLIS)));
                while (true) {
                    long j7 = atomicLongFieldUpdater.get(this);
                    long j8 = atomicLongFieldUpdater2.get(this);
                    long j9 = j8 & DurationKt.MAX_MILLIS;
                    boolean z4 = (j8 & 4611686018427387904L) != 0;
                    if (j7 == j9 && j7 == atomicLongFieldUpdater.get(this)) {
                        break;
                    } else if (!z4) {
                        atomicLongFieldUpdater2.compareAndSet(this, j8, j9 + 4611686018427387904L);
                    }
                }
                do {
                    j6 = atomicLongFieldUpdater2.get(this);
                } while (!atomicLongFieldUpdater2.compareAndSet(this, j6, j6 & DurationKt.MAX_MILLIS));
                return;
            }
            long j10 = atomicLongFieldUpdater.get(this);
            if (j10 == (atomicLongFieldUpdater2.get(this) & DurationKt.MAX_MILLIS) && j10 == atomicLongFieldUpdater.get(this)) {
                return;
            } else {
                i5++;
            }
        }
    }

    @Override // a3.v
    public final void b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        i(cancellationException, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [Z2.h] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r17v0, types: [a3.e, java.lang.Object] */
    @Override // a3.v
    public final Object c(Continuation continuation) throws Throwable {
        C0169n c0169n;
        ?? r13;
        Object objI;
        C0128h c0128h;
        C0107m c0107mH;
        C0169n c0169n2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2283h;
        C0169n c0169n3 = (C0169n) atomicReferenceFieldUpdater.get(this);
        while (!y()) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f2279d;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j4 = AbstractC0162g.f2291b;
            long j5 = andIncrement / j4;
            int i4 = (int) (andIncrement % j4);
            if (c0169n3.f12481c != j5) {
                C0169n c0169nR = r(j5, c0169n3);
                if (c0169nR == null) {
                    continue;
                } else {
                    c0169n = c0169nR;
                }
            } else {
                c0169n = c0169n3;
            }
            Object objI2 = I(c0169n, i4, andIncrement, null);
            X.r rVar = AbstractC0162g.f2302m;
            if (objI2 == rVar) {
                throw new IllegalStateException("unexpected".toString());
            }
            X.r rVar2 = AbstractC0162g.f2304o;
            if (objI2 != rVar2) {
                if (objI2 == AbstractC0162g.f2303n) {
                    C0128h c0128hQ = com.airbnb.lottie.h.q(IntrinsicsKt.intercepted(continuation));
                    try {
                        objI = I(c0169n, i4, andIncrement, c0128hQ);
                    } catch (Throwable th) {
                        th = th;
                        r13 = c0128hQ;
                    }
                    try {
                        if (objI == rVar) {
                            c0128h = c0128hQ;
                            c0128h.a(c0169n, i4);
                        } else {
                            c0128h = c0128hQ;
                            Function1 function1 = this.f2288b;
                            CoroutineContext coroutineContext = c0128h.f2220e;
                            if (objI == rVar2) {
                                if (andIncrement < v()) {
                                    c0169n.a();
                                }
                                C0169n c0169n4 = (C0169n) atomicReferenceFieldUpdater.get(this);
                                while (true) {
                                    if (y()) {
                                        Result.Companion companion = Result.INSTANCE;
                                        c0128h.resumeWith(Result.m22constructorimpl(ResultKt.createFailure(t())));
                                        break;
                                    }
                                    long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(this);
                                    long j6 = AbstractC0162g.f2291b;
                                    long j7 = andIncrement2 / j6;
                                    int i5 = (int) (andIncrement2 % j6);
                                    if (c0169n4.f12481c != j7) {
                                        C0169n c0169nR2 = r(j7, c0169n4);
                                        if (c0169nR2 != null) {
                                            c0169n2 = c0169nR2;
                                        }
                                    } else {
                                        c0169n2 = c0169n4;
                                    }
                                    CoroutineContext coroutineContext2 = coroutineContext;
                                    Function1 function12 = function1;
                                    objI = I(c0169n2, i5, andIncrement2, c0128h);
                                    if (objI == AbstractC0162g.f2302m) {
                                        c0128h.a(c0169n2, i5);
                                        break;
                                    }
                                    if (objI == AbstractC0162g.f2304o) {
                                        if (andIncrement2 < v()) {
                                            c0169n2.a();
                                        }
                                        function1 = function12;
                                        c0169n4 = c0169n2;
                                        coroutineContext = coroutineContext2;
                                    } else {
                                        if (objI == AbstractC0162g.f2303n) {
                                            throw new IllegalStateException("unexpected".toString());
                                        }
                                        c0169n2.a();
                                        c0107mH = function12 != null ? com.stepos.statsrpk.c.h(function12, objI, coroutineContext2) : null;
                                    }
                                }
                            } else {
                                c0169n.a();
                                c0107mH = function1 != null ? com.stepos.statsrpk.c.h(function1, objI, coroutineContext) : null;
                            }
                            c0128h.g(objI, c0107mH);
                        }
                        objI2 = c0128h.t();
                        if (objI2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(continuation);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r13 = rVar;
                        r13.A();
                        throw th;
                    }
                } else {
                    c0169n.a();
                }
                return objI2;
            }
            if (andIncrement < v()) {
                c0169n.a();
            }
            c0169n3 = c0169n;
        }
        Throwable thT = t();
        int i6 = d3.w.f12482a;
        throw thT;
    }

    @Override // a3.w
    public final boolean d(Throwable th) {
        return i(th, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x01df, code lost:
    
        r1.A();
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01e2, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01fc, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ea, code lost:
    
        r5 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ec, code lost:
    
        e(r25, r26, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ef, code lost:
    
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f2, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f3, code lost:
    
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x013a, code lost:
    
        if (r22 >= r5.get(r25)) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x013c, code lost:
    
        r20.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x013f, code lost:
    
        r1 = r17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    @Override // a3.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(kotlin.collections.IndexedValue r26, c3.f r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 509
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.C0160e.f(kotlin.collections.IndexedValue, c3.f):java.lang.Object");
    }

    public final boolean h(long j4) {
        return j4 < f2280e.get(this) || j4 < f2279d.get(this) + ((long) this.f2287a);
    }

    public final boolean i(Throwable th, boolean z4) {
        long j4;
        long j5;
        long j6;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        long j7;
        long j8;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2278c;
        if (z4) {
            do {
                j8 = atomicLongFieldUpdater.get(this);
                if (((int) (j8 >> 60)) != 0) {
                    break;
                }
                C0169n c0169n = AbstractC0162g.f2290a;
            } while (!atomicLongFieldUpdater.compareAndSet(this, j8, (1 << 60) + (j8 & 1152921504606846975L)));
        }
        boolean zCompareAndSet = f2285j.compareAndSet(this, AbstractC0162g.f2308s, th);
        if (z4) {
            do {
                j7 = atomicLongFieldUpdater.get(this);
            } while (!atomicLongFieldUpdater.compareAndSet(this, j7, (3 << 60) + (j7 & 1152921504606846975L)));
        } else {
            do {
                j4 = atomicLongFieldUpdater.get(this);
                int i4 = (int) (j4 >> 60);
                if (i4 == 0) {
                    j5 = j4 & 1152921504606846975L;
                    j6 = 2;
                } else {
                    if (i4 != 1) {
                        break;
                    }
                    j5 = j4 & 1152921504606846975L;
                    j6 = 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(this, j4, (j6 << 60) + j5));
        }
        n();
        if (zCompareAndSet) {
            do {
                atomicReferenceFieldUpdater = f2286k;
                obj = atomicReferenceFieldUpdater.get(this);
            } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, obj == null ? AbstractC0162g.f2306q : AbstractC0162g.f2307r));
            if (obj != null) {
                ((Function1) obj).invoke(s());
            }
        }
        return zCompareAndSet;
    }

    @Override // a3.v
    public final C0156a iterator() {
        return new C0156a(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x008d, code lost:
    
        r1 = (a3.C0169n) ((d3.e) d3.e.f12450b.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final a3.C0169n j(long r13) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.C0160e.j(long):a3.n");
    }

    @Override // a3.v
    public final Object k() {
        C0169n c0169n;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2279d;
        long j4 = atomicLongFieldUpdater.get(this);
        long j5 = f2278c.get(this);
        if (x(j5, true)) {
            return new C0166k(s());
        }
        long j6 = j5 & 1152921504606846975L;
        Object obj = C0168m.f2314b;
        if (j4 >= j6) {
            return obj;
        }
        Object obj2 = AbstractC0162g.f2300k;
        C0169n c0169n2 = (C0169n) f2283h.get(this);
        while (!y()) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j7 = AbstractC0162g.f2291b;
            long j8 = andIncrement / j7;
            int i4 = (int) (andIncrement % j7);
            if (c0169n2.f12481c != j8) {
                C0169n c0169nR = r(j8, c0169n2);
                if (c0169nR == null) {
                    continue;
                } else {
                    c0169n = c0169nR;
                }
            } else {
                c0169n = c0169n2;
            }
            Object objI = I(c0169n, i4, andIncrement, obj2);
            if (objI == AbstractC0162g.f2302m) {
                K0 k02 = obj2 instanceof K0 ? (K0) obj2 : null;
                if (k02 != null) {
                    k02.a(c0169n, i4);
                }
                K(andIncrement);
                c0169n.h();
            } else if (objI == AbstractC0162g.f2304o) {
                if (andIncrement < v()) {
                    c0169n.a();
                }
                c0169n2 = c0169n;
            } else {
                if (objI == AbstractC0162g.f2303n) {
                    throw new IllegalStateException("unexpected".toString());
                }
                c0169n.a();
                obj = objI;
            }
            return obj;
        }
        return new C0166k(s());
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    @Override // a3.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object l(java.lang.Object r23) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.C0160e.l(java.lang.Object):java.lang.Object");
    }

    @Override // a3.v
    public final Object m(Continuation continuation) {
        return D(this, continuation);
    }

    @Override // a3.w
    public final boolean n() {
        return x(f2278c.get(this), false);
    }

    public final void o(long j4) {
        A aI;
        C0169n c0169n = (C0169n) f2283h.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f2279d;
            long j5 = atomicLongFieldUpdater.get(this);
            if (j4 < Math.max(this.f2287a + j5, f2280e.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j5, j5 + 1)) {
                long j6 = AbstractC0162g.f2291b;
                long j7 = j5 / j6;
                int i4 = (int) (j5 % j6);
                if (c0169n.f12481c != j7) {
                    C0169n c0169nR = r(j7, c0169n);
                    if (c0169nR == null) {
                        continue;
                    } else {
                        c0169n = c0169nR;
                    }
                }
                Object objI = I(c0169n, i4, j5, null);
                if (objI != AbstractC0162g.f2304o) {
                    c0169n.a();
                    Function1 function1 = this.f2288b;
                    if (function1 != null && (aI = com.stepos.statsrpk.c.i(function1, objI, null)) != null) {
                        throw aI;
                    }
                } else if (j5 < v()) {
                    c0169n.a();
                }
            }
        }
    }

    @Override // a3.w
    public final void p(S.s sVar) {
        X.r rVar;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2286k;
        if (atomicReferenceFieldUpdater.compareAndSet(this, null, sVar)) {
            return;
        }
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            rVar = AbstractC0162g.f2306q;
            if (obj != rVar) {
                if (obj == AbstractC0162g.f2307r) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, rVar, AbstractC0162g.f2307r));
        sVar.invoke((Object) s());
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x018f, code lost:
    
        w(r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0192, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q() {
        /*
            Method dump skipped, instructions count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.C0160e.q():void");
    }

    public final C0169n r(long j4, C0169n c0169n) {
        Object objA;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j5;
        C0169n c0169n2 = AbstractC0162g.f2290a;
        C0161f c0161f = C0161f.f2289a;
        loop0: while (true) {
            objA = AbstractC0542d.a(c0169n, j4, c0161f);
            if (!I.w(objA)) {
                d3.v vVarR = I.r(objA);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2283h;
                    d3.v vVar = (d3.v) atomicReferenceFieldUpdater.get(this);
                    if (vVar.f12481c >= vVarR.f12481c) {
                        break loop0;
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
            } else {
                break;
            }
        }
        if (I.w(objA)) {
            n();
            if (c0169n.f12481c * AbstractC0162g.f2291b >= v()) {
                return null;
            }
            c0169n.a();
            return null;
        }
        C0169n c0169n3 = (C0169n) I.r(objA);
        boolean zA = A();
        long j6 = c0169n3.f12481c;
        if (!zA && j4 <= f2280e.get(this) / AbstractC0162g.f2291b) {
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f2284i;
                d3.v vVar2 = (d3.v) atomicReferenceFieldUpdater2.get(this);
                if (vVar2.f12481c >= j6 || !c0169n3.i()) {
                    break;
                }
                if (atomicReferenceFieldUpdater2.compareAndSet(this, vVar2, c0169n3)) {
                    if (vVar2.e()) {
                        vVar2.d();
                    }
                } else if (c0169n3.e()) {
                    c0169n3.d();
                }
            }
        }
        if (j6 <= j4) {
            return c0169n3;
        }
        long j7 = AbstractC0162g.f2291b * j6;
        do {
            atomicLongFieldUpdater = f2279d;
            j5 = atomicLongFieldUpdater.get(this);
            if (j5 >= j7) {
                break;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j5, j7));
        if (j6 * AbstractC0162g.f2291b >= v()) {
            return null;
        }
        c0169n3.a();
        return null;
    }

    public final Throwable s() {
        return (Throwable) f2285j.get(this);
    }

    public final Throwable t() {
        Throwable thS = s();
        return thS == null ? new C0170o("Channel was closed") : thS;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x019d, code lost:
    
        r3 = (a3.C0169n) r3.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01a4, code lost:
    
        if (r3 != null) goto L85;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 461
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.C0160e.toString():java.lang.String");
    }

    public final Throwable u() {
        Throwable thS = s();
        return thS == null ? new C0756a("Channel was closed") : thS;
    }

    public final long v() {
        return f2278c.get(this) & 1152921504606846975L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c6, code lost:
    
        r0 = (a3.C0169n) ((d3.e) d3.e.f12450b.get(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean x(long r19, boolean r21) {
        /*
            Method dump skipped, instructions count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.C0160e.x(long, boolean):boolean");
    }

    public final boolean y() {
        return x(f2278c.get(this), true);
    }

    public boolean z() {
        return false;
    }
}
