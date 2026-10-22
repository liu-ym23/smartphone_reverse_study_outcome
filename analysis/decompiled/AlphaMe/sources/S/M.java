package S;

import Z2.C0122e;
import Z2.C0137l0;
import Z2.C0141o;
import Z2.InterfaceC0131i0;
import Z2.n0;
import Z2.o0;
import Z2.t0;
import Z2.x0;
import b3.C0369C;
import b3.InterfaceC0379h;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class M implements InterfaceC0103i {

    /* renamed from: j, reason: collision with root package name */
    public static final LinkedHashSet f1724j = new LinkedHashSet();

    /* renamed from: k, reason: collision with root package name */
    public static final Object f1725k = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Function0 f1726a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0106l f1727b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0096b f1728c;

    /* renamed from: d, reason: collision with root package name */
    public final x0.h f1729d;

    /* renamed from: e, reason: collision with root package name */
    public final String f1730e;

    /* renamed from: f, reason: collision with root package name */
    public final Lazy f1731f;

    /* renamed from: g, reason: collision with root package name */
    public final C0369C f1732g;

    /* renamed from: h, reason: collision with root package name */
    public List f1733h;

    /* renamed from: i, reason: collision with root package name */
    public final t.d f1734i;

    public M(V.e produceFile, List initTasksList, com.google.android.gms.common.internal.f corruptionHandler, Z2.F scope) {
        V.k serializer = V.k.f1927a;
        Intrinsics.checkNotNullParameter(produceFile, "produceFile");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(initTasksList, "initTasksList");
        Intrinsics.checkNotNullParameter(corruptionHandler, "corruptionHandler");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f1726a = produceFile;
        this.f1727b = serializer;
        this.f1728c = corruptionHandler;
        this.f1729d = new x0.h(new z(this, null));
        this.f1730e = ".tmp";
        int i4 = 0;
        this.f1731f = LazyKt.lazy(new A(i4, this));
        this.f1732g = new C0369C(O.f1735a);
        this.f1733h = CollectionsKt.toList(initTasksList);
        s onComplete = new s(i4, this);
        u consumeMessage = new u(this, null);
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        t onUndeliveredElement = t.f1772a;
        Intrinsics.checkNotNullParameter(onUndeliveredElement, "onUndeliveredElement");
        Intrinsics.checkNotNullParameter(consumeMessage, "consumeMessage");
        t.d dVar = new t.d();
        dVar.f15273a = scope;
        dVar.f15274b = consumeMessage;
        dVar.f15275c = com.stepos.statsrpk.c.a(Integer.MAX_VALUE, 0, 6);
        dVar.f15276d = new AtomicInteger(0);
        o0 o0Var = (o0) ((Z2.F) dVar.f15273a).e().get(n0.f2230a);
        if (o0Var != null) {
            ((x0) o0Var).K(false, true, new C0107m(0, onComplete, dVar, onUndeliveredElement));
        }
        this.f1734i = dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Type inference failed for: r8v0, types: [S.M, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(S.M r8, S.p r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S.M.c(S.M, S.p, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // S.InterfaceC0103i
    public final Object a(Function2 function2, Continuation continuation) throws Throwable {
        Object objG;
        C0141o c0141o = new C0141o(true);
        c0141o.J(null);
        this.f1734i.d(new p(function2, c0141o, (N) this.f1732g.a(), continuation.get$context()));
        while (true) {
            Object objG2 = c0141o.G();
            if (objG2 instanceof InterfaceC0131i0) {
                if (c0141o.U(objG2) >= 0) {
                    t0 t0Var = new t0(IntrinsicsKt.intercepted(continuation), c0141o);
                    t0Var.u();
                    t0Var.o(new C0122e(1, c0141o.K(false, true, new C0137l0(1, t0Var))));
                    objG = t0Var.t();
                    if (objG == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation);
                    }
                }
            } else {
                if (objG2 instanceof Z2.r) {
                    throw ((Z2.r) objG2).f2238a;
                }
                objG = Z2.I.G(objG2);
            }
        }
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return objG;
    }

    @Override // S.InterfaceC0103i
    public final InterfaceC0379h b() {
        return this.f1729d;
    }

    public final File d() {
        return (File) this.f1731f.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0115 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(kotlin.coroutines.Continuation r14) throws S.C0095a, java.io.FileNotFoundException {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S.M.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, kotlin.Unit] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof S.F
            if (r0 == 0) goto L13
            r0 = r5
            S.F r0 = (S.F) r0
            int r1 = r0.f1693d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1693d = r1
            goto L18
        L13:
            S.F r0 = new S.F
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f1691b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f1693d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            S.M r4 = r0.f1690a
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L2b
            goto L43
        L2b:
            r5 = move-exception
            goto L46
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.f1690a = r4     // Catch: java.lang.Throwable -> L2b
            r0.f1693d = r3     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r4 = r4.e(r0)     // Catch: java.lang.Throwable -> L2b
            if (r4 != r1) goto L43
            return r1
        L43:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L46:
            b3.C r4 = r4.f1732g
            S.k r0 = new S.k
            r0.<init>(r5)
            r4.b(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: S.M.f(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof S.G
            if (r0 == 0) goto L13
            r0 = r5
            S.G r0 = (S.G) r0
            int r1 = r0.f1697d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1697d = r1
            goto L18
        L13:
            S.G r0 = new S.G
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f1695b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f1697d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            S.M r4 = r0.f1694a
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L2b
            goto L4d
        L2b:
            r5 = move-exception
            goto L43
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.f1694a = r4     // Catch: java.lang.Throwable -> L2b
            r0.f1697d = r3     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r4 = r4.e(r0)     // Catch: java.lang.Throwable -> L2b
            if (r4 != r1) goto L4d
            return r1
        L43:
            b3.C r4 = r4.f1732g
            S.k r0 = new S.k
            r0.<init>(r5)
            r4.b(r0)
        L4d:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: S.M.g(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11, types: [S.M] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2, types: [S.H] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [S.M] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(kotlin.coroutines.Continuation r6) throws java.io.FileNotFoundException {
        /*
            r5 = this;
            boolean r0 = r6 instanceof S.H
            if (r0 == 0) goto L13
            r0 = r6
            S.H r0 = (S.H) r0
            int r1 = r0.f1702e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1702e = r1
            goto L18
        L13:
            S.H r0 = new S.H
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f1700c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f1702e
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.io.FileInputStream r5 = r0.f1699b
            S.M r0 = r0.f1698a
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L2d
            goto L58
        L2d:
            r6 = move-exception
            goto L66
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L6c
            java.io.File r2 = r5.d()     // Catch: java.io.FileNotFoundException -> L6c
            r6.<init>(r2)     // Catch: java.io.FileNotFoundException -> L6c
            S.l r2 = r5.f1727b     // Catch: java.lang.Throwable -> L64
            r0.f1698a = r5     // Catch: java.lang.Throwable -> L64
            r0.f1699b = r6     // Catch: java.lang.Throwable -> L64
            r0.f1702e = r3     // Catch: java.lang.Throwable -> L64
            V.k r2 = (V.k) r2     // Catch: java.lang.Throwable -> L64
            V.b r0 = r2.a(r6)     // Catch: java.lang.Throwable -> L64
            if (r0 != r1) goto L54
            return r1
        L54:
            r4 = r0
            r0 = r5
            r5 = r6
            r6 = r4
        L58:
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r5, r1)     // Catch: java.io.FileNotFoundException -> L5d
            return r6
        L5d:
            r5 = move-exception
            goto L6f
        L5f:
            r4 = r0
            r0 = r5
            r5 = r6
            r6 = r4
            goto L66
        L64:
            r0 = move-exception
            goto L5f
        L66:
            throw r6     // Catch: java.lang.Throwable -> L67
        L67:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r6)     // Catch: java.io.FileNotFoundException -> L5d
            throw r1     // Catch: java.io.FileNotFoundException -> L5d
        L6c:
            r6 = move-exception
            r0 = r5
            r5 = r6
        L6f:
            java.io.File r6 = r0.d()
            boolean r6 = r6.exists()
            if (r6 != 0) goto L86
            S.l r5 = r0.f1727b
            V.k r5 = (V.k) r5
            r5.getClass()
            V.b r5 = new V.b
            r5.<init>(r3)
            return r5
        L86:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: S.M.h(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(kotlin.coroutines.Continuation r6) throws S.C0095a, java.io.FileNotFoundException {
        /*
            r5 = this;
            boolean r0 = r6 instanceof S.I
            if (r0 == 0) goto L13
            r0 = r6
            S.I r0 = (S.I) r0
            int r1 = r0.f1707e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1707e = r1
            goto L18
        L13:
            S.I r0 = new S.I
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f1705c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f1707e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L69
            if (r2 == r4) goto L5f
            r5 = 3
            if (r2 == r3) goto L40
            if (r2 != r5) goto L38
            java.lang.Object r5 = r0.f1704b
            java.lang.Object r0 = r0.f1703a
            S.a r0 = (S.C0095a) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.io.IOException -> L36
            r6 = r5
            goto L58
        L36:
            r5 = move-exception
            goto L5b
        L38:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L40:
            java.lang.Object r2 = r0.f1704b
            S.a r2 = (S.C0095a) r2
            java.lang.Object r3 = r0.f1703a
            S.M r3 = (S.M) r3
            kotlin.ResultKt.throwOnFailure(r6)
            r0.f1703a = r2     // Catch: java.io.IOException -> L59
            r0.f1704b = r6     // Catch: java.io.IOException -> L59
            r0.f1707e = r5     // Catch: java.io.IOException -> L59
            java.lang.Object r5 = r3.k(r6, r0)     // Catch: java.io.IOException -> L59
            if (r5 != r1) goto L58
            return r1
        L58:
            return r6
        L59:
            r5 = move-exception
            r0 = r2
        L5b:
            kotlin.ExceptionsKt.addSuppressed(r0, r5)
            throw r0
        L5f:
            java.lang.Object r5 = r0.f1703a
            S.M r5 = (S.M) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: S.C0095a -> L67
            goto L77
        L67:
            r6 = move-exception
            goto L78
        L69:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.f1703a = r5     // Catch: S.C0095a -> L67
            r0.f1707e = r4     // Catch: S.C0095a -> L67
            java.lang.Object r6 = r5.h(r0)     // Catch: S.C0095a -> L67
            if (r6 != r1) goto L77
            return r1
        L77:
            return r6
        L78:
            S.b r1 = r5.f1728c
            r0.f1703a = r5
            r0.f1704b = r6
            r0.f1707e = r3
            com.google.android.gms.common.internal.f r1 = (com.google.android.gms.common.internal.f) r1
            r1.getClass()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: S.M.i(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(kotlin.coroutines.Continuation r9, kotlin.coroutines.CoroutineContext r10, kotlin.jvm.functions.Function2 r11) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof S.J
            if (r0 == 0) goto L13
            r0 = r9
            S.J r0 = (S.J) r0
            int r1 = r0.f1713f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1713f = r1
            goto L18
        L13:
            S.J r0 = new S.J
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f1711d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f1713f
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L45
            if (r2 == r5) goto L39
            if (r2 != r4) goto L31
            java.lang.Object r8 = r0.f1709b
            S.M r10 = r0.f1708a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L89
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            java.lang.Object r8 = r0.f1710c
            java.lang.Object r10 = r0.f1709b
            S.c r10 = (S.C0097c) r10
            S.M r11 = r0.f1708a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L6e
        L45:
            kotlin.ResultKt.throwOnFailure(r9)
            b3.C r9 = r8.f1732g
            java.lang.Object r9 = r9.a()
            S.c r9 = (S.C0097c) r9
            r9.a()
            S.K r2 = new S.K
            java.lang.Object r6 = r9.f1736a
            r2.<init>(r11, r6, r3)
            r0.f1708a = r8
            r0.f1709b = r9
            r0.f1710c = r6
            r0.f1713f = r5
            java.lang.Object r10 = t0.J.O(r0, r10, r2)
            if (r10 != r1) goto L69
            return r1
        L69:
            r11 = r8
            r8 = r6
            r7 = r10
            r10 = r9
            r9 = r7
        L6e:
            r10.a()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r9)
            if (r10 == 0) goto L78
            goto L9b
        L78:
            r0.f1708a = r11
            r0.f1709b = r9
            r0.f1710c = r3
            r0.f1713f = r4
            java.lang.Object r8 = r11.k(r9, r0)
            if (r8 != r1) goto L87
            return r1
        L87:
            r8 = r9
            r10 = r11
        L89:
            b3.C r9 = r10.f1732g
            S.c r10 = new S.c
            if (r8 == 0) goto L94
            int r11 = r8.hashCode()
            goto L95
        L94:
            r11 = 0
        L95:
            r10.<init>(r11, r8)
            r9.b(r10)
        L9b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: S.M.j(kotlin.coroutines.Continuation, kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.Object r8, kotlin.coroutines.Continuation r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S.M.k(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
