package S;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* renamed from: S.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0108n extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public Function2 f1760a;

    /* renamed from: b, reason: collision with root package name */
    public int f1761b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t.d f1762c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0108n(t.d dVar, Continuation continuation) {
        super(2, continuation);
        this.f1762c = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C0108n(this.f1762c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0108n) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0057 -> B:18:0x005a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.f1761b
            r2 = 2
            r3 = 1
            t.d r4 = r6.f1762c
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1c
            if (r1 != r2) goto L14
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5a
        L14:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1c:
            kotlin.jvm.functions.Function2 r1 = r6.f1760a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4e
        L22:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r4.f15276d
            java.util.concurrent.atomic.AtomicInteger r7 = (java.util.concurrent.atomic.AtomicInteger) r7
            int r7 = r7.get()
            if (r7 <= 0) goto L67
        L2f:
            java.lang.Object r7 = r4.f15273a
            Z2.F r7 = (Z2.F) r7
            kotlin.coroutines.CoroutineContext r7 = r7.e()
            Z2.I.j(r7)
            java.lang.Object r7 = r4.f15274b
            r1 = r7
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            java.lang.Object r7 = r4.f15275c
            a3.i r7 = (a3.InterfaceC0164i) r7
            r6.f1760a = r1
            r6.f1761b = r3
            java.lang.Object r7 = r7.c(r6)
            if (r7 != r0) goto L4e
            return r0
        L4e:
            r5 = 0
            r6.f1760a = r5
            r6.f1761b = r2
            java.lang.Object r7 = r1.invoke(r7, r6)
            if (r7 != r0) goto L5a
            return r0
        L5a:
            java.lang.Object r7 = r4.f15276d
            java.util.concurrent.atomic.AtomicInteger r7 = (java.util.concurrent.atomic.AtomicInteger) r7
            int r7 = r7.decrementAndGet()
            if (r7 != 0) goto L2f
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L67:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Check failed."
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: S.C0108n.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
