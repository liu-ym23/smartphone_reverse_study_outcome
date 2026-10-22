package kotlinx.coroutines;

import C7.r;
import H7.d;
import H7.f;
import H7.h;
import S7.n;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import k9.C1650a;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.p;
import kotlin.time.DurationUnit;
import m9.AbstractC1683A;
import m9.AbstractC1685C;
import m9.C1694L;
import m9.C1710c;
import m9.C1711d;
import m9.C1712e;
import m9.C1718k;
import m9.C1727t;
import m9.InterfaceC1686D;
import m9.InterfaceC1688F;
import m9.InterfaceC1693K;
import m9.b0;
import m9.c0;
import m9.d0;
import m9.e0;
import m9.m0;
import m9.o0;
import m9.u0;
import z2.l;

/* loaded from: classes4.dex */
public abstract class a {
    public static d0 a() {
        return new d0(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object b(ArrayList arrayList, H7.c cVar) {
        if (arrayList.isEmpty()) {
            return EmptyList.f4893a;
        }
        InterfaceC1686D[] interfaceC1686DArr = (InterfaceC1686D[]) arrayList.toArray(new InterfaceC1686D[0]);
        C1712e c1712e = new C1712e(interfaceC1686DArr);
        C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        int length = interfaceC1686DArr.length;
        C1710c[] c1710cArr = new C1710c[length];
        for (int i = 0; i < length; i++) {
            m0 m0Var = interfaceC1686DArr[i];
            ((c) m0Var).start();
            C1710c c1710c = new C1710c(c1712e, c1718k);
            c1710c.f = j(m0Var, true, c1710c);
            c1710cArr[i] = c1710c;
        }
        C1711d c1711d = new C1711d(c1710cArr);
        for (int i6 = 0; i6 < length; i6++) {
            C1710c c1710c2 = c1710cArr[i6];
            c1710c2.getClass();
            C1710c.h.set(c1710c2, c1711d);
        }
        if (C1718k.g.get(c1718k) instanceof o0) {
            c1718k.A(c1711d);
        } else {
            c1711d.a();
        }
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(kotlin.coroutines.jvm.internal.ContinuationImpl r4) {
        /*
            boolean r0 = r4 instanceof kotlinx.coroutines.DelayKt$awaitCancellation$1
            if (r0 == 0) goto L13
            r0 = r4
            kotlinx.coroutines.DelayKt$awaitCancellation$1 r0 = (kotlinx.coroutines.DelayKt$awaitCancellation$1) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            kotlinx.coroutines.DelayKt$awaitCancellation$1 r0 = new kotlinx.coroutines.DelayKt$awaitCancellation$1
            r0.<init>(r4)
        L18:
            java.lang.Object r4 = r0.f5176a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 == r3) goto L2b
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L2b:
            kotlin.b.b(r4)
            goto L47
        L2f:
            kotlin.b.b(r4)
            r0.b = r3
            m9.k r4 = new m9.k
            H7.c r0 = U7.a.I(r0)
            r4.<init>(r3, r0)
            r4.y()
            java.lang.Object r4 = r4.x()
            if (r4 != r1) goto L47
            return
        L47:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.a.c(kotlin.coroutines.jvm.internal.ContinuationImpl):void");
    }

    public static final void d(h hVar, CancellationException cancellationException) {
        c0 c0Var = (c0) hVar.get(b0.f5325a);
        if (c0Var != null) {
            c0Var.cancel(cancellationException);
        }
    }

    public static final Object e(c0 c0Var, SuspendLambda suspendLambda) {
        c0Var.cancel(null);
        Object objG = c0Var.g(suspendLambda);
        return objG == CoroutineSingletons.f4909a ? objG : r.f317a;
    }

    public static final Object f(long j5, H7.c cVar) {
        if (j5 > 0) {
            C1718k c1718k = new C1718k(1, U7.a.I(cVar));
            c1718k.y();
            if (j5 < Long.MAX_VALUE) {
                h(c1718k.e).s(j5, c1718k);
            }
            Object objX = c1718k.x();
            if (objX == CoroutineSingletons.f4909a) {
                return objX;
            }
        }
        return r.f317a;
    }

    public static final void g(h hVar) {
        c0 c0Var = (c0) hVar.get(b0.f5325a);
        if (c0Var != null && !c0Var.isActive()) {
            throw c0Var.i();
        }
    }

    public static final InterfaceC1688F h(h hVar) {
        f fVar = hVar.get(d.f758a);
        InterfaceC1688F interfaceC1688F = fVar instanceof InterfaceC1688F ? (InterfaceC1688F) fVar : null;
        return interfaceC1688F == null ? AbstractC1685C.f5313a : interfaceC1688F;
    }

    public static final c0 i(h hVar) {
        c0 c0Var = (c0) hVar.get(b0.f5325a);
        if (c0Var != null) {
            return c0Var;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + hVar).toString());
    }

    public static final InterfaceC1693K j(c0 c0Var, boolean z10, e0 e0Var) {
        return c0Var instanceof c ? ((c) c0Var).S(z10, e0Var) : c0Var.n(e0Var.i(), z10, new JobKt__JobKt$invokeOnCompletion$1(1, e0Var, e0.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0));
    }

    public static final boolean k(h hVar) {
        c0 c0Var = (c0) hVar.get(b0.f5325a);
        if (c0Var != null) {
            return c0Var.isActive();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object l(java.util.ArrayList r4, kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.AwaitKt$joinAll$3
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.AwaitKt$joinAll$3 r0 = (kotlinx.coroutines.AwaitKt$joinAll$3) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            kotlinx.coroutines.AwaitKt$joinAll$3 r0 = new kotlinx.coroutines.AwaitKt$joinAll$3
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.util.Iterator r4 = r0.f5174a
            java.util.Iterator r4 = (java.util.Iterator) r4
            kotlin.b.b(r5)
            goto L3a
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r5)
            java.util.Iterator r4 = r4.iterator()
        L3a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L54
            java.lang.Object r5 = r4.next()
            m9.c0 r5 = (m9.c0) r5
            r2 = r4
            java.util.Iterator r2 = (java.util.Iterator) r2
            r0.f5174a = r2
            r0.c = r3
            java.lang.Object r5 = r5.g(r0)
            if (r5 != r1) goto L3a
            return r1
        L54:
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.a.l(java.util.ArrayList, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final Object m(u0 u0Var, n nVar) throws Throwable {
        Object c1727t;
        Object objV;
        j(u0Var, true, new C1694L(h(u0Var.d.getContext()).l(u0Var.e, u0Var, u0Var.c), 0));
        try {
            if (nVar instanceof BaseContinuationImpl) {
                p.e(2, nVar);
                c1727t = nVar.invoke(u0Var, u0Var);
            } else {
                c1727t = U7.a.b0(nVar, u0Var, u0Var);
            }
        } catch (Throwable th) {
            c1727t = new C1727t(th, false);
        }
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        if (c1727t == coroutineSingletons || (objV = u0Var.V(c1727t)) == AbstractC1683A.e) {
            return coroutineSingletons;
        }
        if (objV instanceof C1727t) {
            Throwable th2 = ((C1727t) objV).f5333a;
            if (!(th2 instanceof TimeoutCancellationException) || ((TimeoutCancellationException) th2).f5181a != u0Var) {
                throw th2;
            }
            if (c1727t instanceof C1727t) {
                throw ((C1727t) c1727t).f5333a;
            }
        } else {
            c1727t = AbstractC1683A.u(objV);
        }
        return c1727t;
    }

    public static final long n(long j5) {
        int i = C1650a.d;
        boolean z10 = j5 > 0;
        if (z10) {
            long jE = C1650a.e(j5, l.J(999999L, DurationUnit.b));
            return ((((int) jE) & 1) != 1 || C1650a.d(jE)) ? C1650a.f(jE, DurationUnit.c) : jE >> 1;
        }
        if (z10) {
            throw new NoWhenBranchMatchedException();
        }
        return 0L;
    }

    public static final Object o(long j5, n nVar, H7.c cVar) {
        if (j5 <= 0) {
            throw new TimeoutCancellationException("Timed out immediately", null);
        }
        Object objM = m(new u0(j5, cVar), nVar);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objM;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object p(long r6, S7.n r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = (kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = new kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.jvm.internal.Ref$ObjectRef r6 = r0.f5182a
            kotlin.b.b(r9)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L29
            return r9
        L29:
            r7 = move-exception
            goto L57
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.b.b(r9)
            r4 = 0
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 > 0) goto L3d
            goto L5d
        L3d:
            kotlin.jvm.internal.Ref$ObjectRef r9 = new kotlin.jvm.internal.Ref$ObjectRef
            r9.<init>()
            r0.f5182a = r9     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L55
            r0.c = r3     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L55
            m9.u0 r2 = new m9.u0     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L55
            r2.<init>(r6, r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L55
            r9.f4920a = r2     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L55
            java.lang.Object r6 = m(r2, r8)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L55
            if (r6 != r1) goto L54
            return r1
        L54:
            return r6
        L55:
            r7 = move-exception
            r6 = r9
        L57:
            m9.c0 r8 = r7.f5181a
            java.lang.Object r6 = r6.f4920a
            if (r8 != r6) goto L5f
        L5d:
            r6 = 0
            return r6
        L5f:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.a.p(long, S7.n, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
