package stepai.aios.guiagent.pipeline;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline$recoverFromTakeover$3", f = "ExecutionPipeline.kt", l = {1695, 1696}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class ExecutionPipeline$recoverFromTakeover$3 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f6079a;
    public final /* synthetic */ b b;
    public final /* synthetic */ String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$recoverFromTakeover$3(b bVar, String str, H7.c cVar) {
        super(2, cVar);
        this.b = bVar;
        this.c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new ExecutionPipeline$recoverFromTakeover$3(this.b, this.c, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((ExecutionPipeline$recoverFromTakeover$3) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
    
        if (r7.c(r2, false, r6) == r0) goto L15;
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
            int r1 = r6.f6079a
            java.lang.String r2 = r6.c
            stepai.aios.guiagent.pipeline.b r3 = r6.b
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L20
            if (r1 == r5) goto L1c
            if (r1 != r4) goto L14
            kotlin.b.b(r7)
            goto L3a
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
            r6.f6079a = r5
            java.lang.String r7 = "恢复启动失败"
            java.lang.Object r7 = r3.G(r2, r7, r6)
            if (r7 != r0) goto L2e
            goto L39
        L2e:
            stepai.aios.guiagent.takeover.b r7 = r3.p
            r6.f6079a = r4
            r1 = 0
            java.lang.Object r6 = r7.c(r2, r1, r6)
            if (r6 != r0) goto L3a
        L39:
            return r0
        L3a:
            C7.r r6 = C7.r.f317a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.ExecutionPipeline$recoverFromTakeover$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
