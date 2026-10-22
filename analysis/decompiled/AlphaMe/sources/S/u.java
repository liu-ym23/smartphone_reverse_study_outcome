package S;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final class u extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f1773a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1774b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ M f1775c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(M m4, Continuation continuation) {
        super(2, continuation);
        this.f1775c = m4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        u uVar = new u(this.f1775c, continuation);
        uVar.f1774b = obj;
        return uVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((u) create((q) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006e A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.f1773a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1c
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L17:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L8a
        L1c:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.Object r6 = r5.f1774b
            S.q r6 = (S.q) r6
            boolean r1 = r6 instanceof S.C0109o
            S.M r4 = r5.f1775c
            if (r1 == 0) goto L7b
            S.o r6 = (S.C0109o) r6
            r5.f1773a = r3
            b3.C r1 = r4.f1732g
            java.lang.Object r1 = r1.a()
            S.N r1 = (S.N) r1
            boolean r2 = r1 instanceof S.C0097c
            if (r2 == 0) goto L3a
            goto L6a
        L3a:
            boolean r2 = r1 instanceof S.C0105k
            if (r2 == 0) goto L50
            S.N r6 = r6.f1763a
            if (r1 != r6) goto L6a
            java.lang.Object r5 = r4.g(r5)
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r5 != r6) goto L4d
            goto L6c
        L4d:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            goto L6c
        L50:
            S.O r6 = S.O.f1735a
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r6)
            if (r6 == 0) goto L66
            java.lang.Object r5 = r4.g(r5)
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r5 != r6) goto L63
            goto L6c
        L63:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            goto L6c
        L66:
            boolean r5 = r1 instanceof S.C0104j
            if (r5 != 0) goto L6f
        L6a:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
        L6c:
            if (r5 != r0) goto L8a
            return r0
        L6f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Can't read in final state."
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L7b:
            boolean r1 = r6 instanceof S.p
            if (r1 == 0) goto L8a
            S.p r6 = (S.p) r6
            r5.f1773a = r2
            java.lang.Object r5 = S.M.c(r4, r6, r5)
            if (r5 != r0) goto L8a
            return r0
        L8a:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: S.u.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
