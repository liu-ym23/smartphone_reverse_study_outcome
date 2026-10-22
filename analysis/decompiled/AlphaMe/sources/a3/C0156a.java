package a3;

import S.C0107m;
import Z2.C0128h;
import Z2.K0;
import b3.C0381j;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: a3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0156a implements K0 {

    /* renamed from: a, reason: collision with root package name */
    public Object f2267a = AbstractC0162g.f2305p;

    /* renamed from: b, reason: collision with root package name */
    public C0128h f2268b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0160e f2269c;

    public C0156a(C0160e c0160e) {
        this.f2269c = c0160e;
    }

    public static final void b(C0156a c0156a) {
        C0128h c0128h = c0156a.f2268b;
        Intrinsics.checkNotNull(c0128h);
        c0156a.f2268b = null;
        c0156a.f2267a = AbstractC0162g.f2301l;
        Throwable thS = c0156a.f2269c.s();
        if (thS == null) {
            Result.Companion companion = Result.INSTANCE;
            c0128h.resumeWith(Result.m22constructorimpl(Boolean.FALSE));
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            c0128h.resumeWith(Result.m22constructorimpl(ResultKt.createFailure(thS)));
        }
    }

    @Override // Z2.K0
    public final void a(d3.v vVar, int i4) {
        C0128h c0128h = this.f2268b;
        if (c0128h != null) {
            c0128h.a(vVar, i4);
        }
    }

    public final Object c(C0381j c0381j) throws Throwable {
        C0169n c0169n;
        Boolean boolBoxBoolean;
        C0169n c0169n2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C0160e.f2283h;
        C0160e c0160e = this.f2269c;
        C0169n c0169n3 = (C0169n) atomicReferenceFieldUpdater.get(c0160e);
        while (!c0160e.y()) {
            long andIncrement = C0160e.f2279d.getAndIncrement(c0160e);
            long j4 = AbstractC0162g.f2291b;
            long j5 = andIncrement / j4;
            int i4 = (int) (andIncrement % j4);
            if (c0169n3.f12481c != j5) {
                C0169n c0169nR = c0160e.r(j5, c0169n3);
                if (c0169nR == null) {
                    continue;
                } else {
                    c0169n = c0169nR;
                }
            } else {
                c0169n = c0169n3;
            }
            Object objI = c0160e.I(c0169n, i4, andIncrement, null);
            X.r rVar = AbstractC0162g.f2302m;
            if (objI == rVar) {
                throw new IllegalStateException("unreachable".toString());
            }
            X.r rVar2 = AbstractC0162g.f2304o;
            if (objI != rVar2) {
                if (objI != AbstractC0162g.f2303n) {
                    c0169n.a();
                    this.f2267a = objI;
                    return Boxing.boxBoolean(true);
                }
                C0160e c0160e2 = this.f2269c;
                C0128h c0128hQ = com.airbnb.lottie.h.q(IntrinsicsKt.intercepted(c0381j));
                try {
                    this.f2268b = c0128hQ;
                    Object objI2 = c0160e2.I(c0169n, i4, andIncrement, this);
                    if (objI2 == rVar) {
                        a(c0169n, i4);
                    } else {
                        C0107m c0107mH = null;
                        CoroutineContext coroutineContext = c0128hQ.f2220e;
                        Function1 function1 = c0160e2.f2288b;
                        if (objI2 == rVar2) {
                            if (andIncrement < c0160e2.v()) {
                                c0169n.a();
                            }
                            C0169n c0169n4 = (C0169n) C0160e.f2283h.get(c0160e2);
                            while (true) {
                                if (c0160e2.y()) {
                                    b(this);
                                    break;
                                }
                                long andIncrement2 = C0160e.f2279d.getAndIncrement(c0160e2);
                                long j6 = AbstractC0162g.f2291b;
                                long j7 = andIncrement2 / j6;
                                int i5 = (int) (andIncrement2 % j6);
                                if (c0169n4.f12481c != j7) {
                                    C0169n c0169nR2 = c0160e2.r(j7, c0169n4);
                                    if (c0169nR2 != null) {
                                        c0169n2 = c0169nR2;
                                    }
                                } else {
                                    c0169n2 = c0169n4;
                                }
                                Function1 function12 = function1;
                                Object objI3 = c0160e2.I(c0169n2, i5, andIncrement2, this);
                                if (objI3 == AbstractC0162g.f2302m) {
                                    a(c0169n2, i5);
                                    break;
                                }
                                if (objI3 == AbstractC0162g.f2304o) {
                                    if (andIncrement2 < c0160e2.v()) {
                                        c0169n2.a();
                                    }
                                    c0169n4 = c0169n2;
                                    function1 = function12;
                                } else {
                                    if (objI3 == AbstractC0162g.f2303n) {
                                        throw new IllegalStateException("unexpected".toString());
                                    }
                                    c0169n2.a();
                                    this.f2267a = objI3;
                                    this.f2268b = null;
                                    boolBoxBoolean = Boxing.boxBoolean(true);
                                    if (function12 != null) {
                                        c0107mH = com.stepos.statsrpk.c.h(function12, objI3, coroutineContext);
                                    }
                                }
                            }
                        } else {
                            c0169n.a();
                            this.f2267a = objI2;
                            this.f2268b = null;
                            boolBoxBoolean = Boxing.boxBoolean(true);
                            if (function1 != null) {
                                c0107mH = com.stepos.statsrpk.c.h(function1, objI2, coroutineContext);
                            }
                        }
                        c0128hQ.g(boolBoxBoolean, c0107mH);
                    }
                    Object objT = c0128hQ.t();
                    if (objT == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(c0381j);
                    }
                    return objT;
                } catch (Throwable th) {
                    c0128hQ.A();
                    throw th;
                }
            }
            if (andIncrement < c0160e.v()) {
                c0169n.a();
            }
            c0169n3 = c0169n;
        }
        this.f2267a = AbstractC0162g.f2301l;
        Throwable thS = c0160e.s();
        if (thS == null) {
            return Boxing.boxBoolean(false);
        }
        int i6 = d3.w.f12482a;
        throw thS;
    }
}
