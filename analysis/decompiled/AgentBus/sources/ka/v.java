package ka;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public abstract class v {
    public static /* synthetic */ void cancel$default(x xVar, CancellationException cancellationException, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        xVar.d(cancellationException);
    }

    public static <E> qa.a getOnReceiveOrNull(x xVar) {
        q7.k.c(xVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel<E of kotlinx.coroutines.channels.ReceiveChannel>");
        q7.z.c(3, c.f5669n);
        q7.z.c(3, d.f5670n);
        return new h4.n(18, false);
    }

    @c7.a
    public static /* synthetic */ void getOnReceiveOrNull$annotations() {
    }

    public static /* synthetic */ void isClosedForReceive$annotations() {
    }

    public static /* synthetic */ void isEmpty$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c7.a
    public static <E> E poll(x xVar) throws Throwable {
        E e10 = (E) xVar.p();
        boolean z4 = e10 instanceof m;
        if (z4) {
            Throwable thA = n.a(e10);
            if (thA == null) {
                return null;
            }
            int i2 = na.t.f6928a;
            throw thA;
        }
        if (!z4) {
            return e10;
        }
        if (!(e10 instanceof l)) {
            throw new IllegalStateException("Trying to call 'getOrThrow' on a failed result of a non-closed channel");
        }
        Throwable th = ((l) e10).f5710a;
        if (th != null) {
            throw th;
        }
        throw new IllegalStateException("Trying to call 'getOrThrow' on a channel closed without a cause");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @c7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <E> java.lang.Object receiveOrNull(ka.x r4, g7.d r5) {
        /*
            boolean r0 = r5 instanceof ka.w
            if (r0 == 0) goto L13
            r0 = r5
            ka.w r0 = (ka.w) r0
            int r1 = r0.f5722g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5722g = r1
            goto L18
        L13:
            ka.w r0 = new ka.w
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f5721f
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f5722g
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            w7.e0.N(r5)
            ka.n r5 = (ka.n) r5
            java.lang.Object r4 = r5.f5712a
            goto L3f
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            w7.e0.N(r5)
            r0.f5722g = r3
            java.lang.Object r4 = r4.v(r0)
            if (r4 != r1) goto L3f
            return r1
        L3f:
            boolean r5 = r4 instanceof ka.m
            if (r5 != 0) goto L44
            return r4
        L44:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ka.v.receiveOrNull(ka.x, g7.d):java.lang.Object");
    }

    public static /* synthetic */ boolean cancel$default(x xVar, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
        if ((i2 & 1) != 0) {
            th = null;
        }
        return xVar.a(th);
    }
}
