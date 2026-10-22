package com.stepos.ability.manager.reporter;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.manager.reporter.AbilityReportProcessor$observerLoop$1", f = "AbilityReportProcessor.kt", l = {153}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class AbilityReportProcessor$observerLoop$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3147a;
    public /* synthetic */ Object b;
    public final /* synthetic */ a c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityReportProcessor$observerLoop$1(a aVar, H7.c cVar) {
        super(2, cVar);
        this.c = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        AbilityReportProcessor$observerLoop$1 abilityReportProcessor$observerLoop$1 = new AbilityReportProcessor$observerLoop$1(this.c, cVar);
        abilityReportProcessor$observerLoop$1.b = obj;
        return abilityReportProcessor$observerLoop$1;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((AbilityReportProcessor$observerLoop$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002f -> B:14:0x0032). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.b
            m9.z r0 = (m9.InterfaceC1733z) r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r7.f3147a
            C7.r r3 = C7.r.f317a
            r4 = 1
            if (r2 == 0) goto L1b
            if (r2 != r4) goto L13
            kotlin.b.b(r8)
            goto L32
        L13:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1b:
            kotlin.b.b(r8)
        L1e:
            boolean r8 = m9.AbstractC1683A.l(r0)
            if (r8 == 0) goto L41
            r7.b = r0
            r7.f3147a = r4
            r5 = 300000(0x493e0, double:1.482197E-318)
            java.lang.Object r8 = kotlinx.coroutines.a.f(r5, r7)
            if (r8 != r1) goto L32
            return r1
        L32:
            java.lang.String r8 = "AbilityReportProcessor"
            java.lang.String r2 = "Periodic check triggered."
            android.util.Log.i(r8, r2)
            com.stepos.ability.manager.reporter.a r8 = r7.c
            kotlinx.coroutines.flow.h r8 = r8.f
            r8.a(r3)
            goto L1e
        L41:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.manager.reporter.AbilityReportProcessor$observerLoop$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
