package stepai.aios.guiagent.pipeline;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline$runRecoveryLoop$2", f = "ExecutionPipeline.kt", l = {1790, 1792}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class ExecutionPipeline$runRecoveryLoop$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f6092a;
    public final /* synthetic */ b b;
    public final /* synthetic */ String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$runRecoveryLoop$2(b bVar, String str, H7.c cVar) {
        super(2, cVar);
        this.b = bVar;
        this.c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new ExecutionPipeline$runRecoveryLoop$2(this.b, this.c, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((ExecutionPipeline$runRecoveryLoop$2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
    
        if (r5.G(r4, "恢复已取消", r6) == r0) goto L24;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r6.f6092a
            r2 = 2
            r3 = 1
            java.lang.String r4 = r6.c
            stepai.aios.guiagent.pipeline.b r5 = r6.b
            if (r1 == 0) goto L20
            if (r1 == r3) goto L1c
            if (r1 != r2) goto L14
            kotlin.b.b(r7)
            goto L4f
        L14:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1c:
            kotlin.b.b(r7)
            goto L2e
        L20:
            kotlin.b.b(r7)
            stepai.aios.guiagent.session.a r7 = r5.g
            r6.f6092a = r3
            java.lang.Object r7 = r7.j(r4, r6)
            if (r7 != r0) goto L2e
            goto L4e
        L2e:
            za.e r7 = (za.e) r7
            if (r7 == 0) goto L35
            stepai.aios.guiagent.model.SessionState r7 = r7.e
            goto L36
        L35:
            r7 = 0
        L36:
            boolean r1 = r5.x(r4)
            if (r1 != 0) goto L4f
            if (r7 == 0) goto L4f
            boolean r7 = r7.a()
            if (r7 != 0) goto L4f
            r6.f6092a = r2
            java.lang.String r7 = "恢复已取消"
            java.lang.Object r6 = r5.G(r4, r7, r6)
            if (r6 != r0) goto L4f
        L4e:
            return r0
        L4f:
            C7.r r6 = C7.r.f317a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.ExecutionPipeline$runRecoveryLoop$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
