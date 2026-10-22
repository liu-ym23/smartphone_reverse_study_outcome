package stepai.aios.guiagent.takeover;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "stepai.aios.guiagent.takeover.TakeoverSafetyManager$startTimeoutMonitoring$job$1", f = "TakeoverSafetyManager.kt", l = {153, 154}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class TakeoverSafetyManager$startTimeoutMonitoring$job$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f6166a;
    public final /* synthetic */ long b;
    public final /* synthetic */ b c;
    public final /* synthetic */ String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TakeoverSafetyManager$startTimeoutMonitoring$job$1(long j5, b bVar, String str, H7.c cVar) {
        super(2, cVar);
        this.b = j5;
        this.c = bVar;
        this.d = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new TakeoverSafetyManager$startTimeoutMonitoring$job$1(this.b, this.c, this.d, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((TakeoverSafetyManager$startTimeoutMonitoring$job$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
    
        if (stepai.aios.guiagent.takeover.b.a(r5.c, r5.d, r5) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r5.f6166a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1c
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            kotlin.b.b(r6)
            goto L37
        L10:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L18:
            kotlin.b.b(r6)
            goto L2a
        L1c:
            kotlin.b.b(r6)
            r5.f6166a = r3
            long r3 = r5.b
            java.lang.Object r6 = kotlinx.coroutines.a.f(r3, r5)
            if (r6 != r0) goto L2a
            goto L36
        L2a:
            r5.f6166a = r2
            stepai.aios.guiagent.takeover.b r6 = r5.c
            java.lang.String r1 = r5.d
            java.lang.Object r5 = stepai.aios.guiagent.takeover.b.a(r6, r1, r5)
            if (r5 != r0) goto L37
        L36:
            return r0
        L37:
            C7.r r5 = C7.r.f317a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.takeover.TakeoverSafetyManager$startTimeoutMonitoring$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
