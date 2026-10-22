package stepai.aios.guiagent.pipeline;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline$recoverFromTakeover$5", f = "ExecutionPipeline.kt", l = {1708, 1709, 1711}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class ExecutionPipeline$recoverFromTakeover$5 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f6081a;
    public final /* synthetic */ b b;
    public final /* synthetic */ String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$recoverFromTakeover$5(b bVar, String str, H7.c cVar) {
        super(2, cVar);
        this.b = bVar;
        this.c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new ExecutionPipeline$recoverFromTakeover$5(this.b, this.c, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((ExecutionPipeline$recoverFromTakeover$5) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
    
        if (r6.G(r5, "恢复已取消", r7) != r0) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r7.f6081a
            r2 = 3
            r3 = 2
            r4 = 1
            java.lang.String r5 = r7.c
            stepai.aios.guiagent.pipeline.b r6 = r7.b
            if (r1 == 0) goto L27
            if (r1 == r4) goto L23
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            kotlin.b.b(r8)
            goto L62
        L17:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1f:
            kotlin.b.b(r8)
            goto L41
        L23:
            kotlin.b.b(r8)
            goto L36
        L27:
            kotlin.b.b(r8)
            stepai.aios.guiagent.takeover.b r8 = r6.p
            r7.f6081a = r4
            r1 = 0
            java.lang.Object r8 = r8.c(r5, r1, r7)
            if (r8 != r0) goto L36
            goto L61
        L36:
            stepai.aios.guiagent.session.a r8 = r6.g
            r7.f6081a = r3
            java.lang.Object r8 = r8.j(r5, r7)
            if (r8 != r0) goto L41
            goto L61
        L41:
            za.e r8 = (za.e) r8
            if (r8 == 0) goto L48
            stepai.aios.guiagent.model.SessionState r8 = r8.e
            goto L49
        L48:
            r8 = 0
        L49:
            boolean r1 = r6.x(r5)
            if (r1 != 0) goto L62
            if (r8 == 0) goto L62
            boolean r8 = r8.a()
            if (r8 != 0) goto L62
            r7.f6081a = r2
            java.lang.String r8 = "恢复已取消"
            java.lang.Object r7 = r6.G(r5, r8, r7)
            if (r7 != r0) goto L62
        L61:
            return r0
        L62:
            C7.r r7 = C7.r.f317a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.ExecutionPipeline$recoverFromTakeover$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
