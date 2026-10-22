package stepai.aios.guiagent.pipeline;

import C7.r;
import J7.c;
import S7.k;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import stepai.aios.guiagent.model.TakeoverReasonType;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline$takeoverTask$success$1", f = "ExecutionPipeline.kt", l = {1577, 1604}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$takeoverTask$success$1 extends SuspendLambda implements k {

    /* renamed from: a, reason: collision with root package name */
    public int f6107a;
    public final /* synthetic */ b b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ TakeoverReasonType e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$takeoverTask$success$1(b bVar, String str, String str2, TakeoverReasonType takeoverReasonType, H7.c cVar) {
        super(1, cVar);
        this.b = bVar;
        this.c = str;
        this.d = str2;
        this.e = takeoverReasonType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(H7.c cVar) {
        return new ExecutionPipeline$takeoverTask$success$1(this.b, this.c, this.d, this.e, cVar);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        return ((ExecutionPipeline$takeoverTask$success$1) create((H7.c) obj)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
    
        if (r9 == r0) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r8.f6107a
            r2 = 0
            java.lang.String r3 = r8.d
            r4 = 2
            r5 = 1
            java.lang.String r6 = r8.c
            if (r1 == 0) goto L21
            if (r1 == r5) goto L1d
            if (r1 != r4) goto L15
            kotlin.b.b(r9)
            goto L6d
        L15:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L1d:
            kotlin.b.b(r9)
            goto L2f
        L21:
            kotlin.b.b(r9)
            r8.f6107a = r5
            stepai.aios.guiagent.pipeline.b r9 = r8.b
            java.io.Serializable r9 = r9.B(r6, r8)
            if (r9 != r0) goto L2f
            goto L6c
        L2f:
            kotlin.Pair r9 = (kotlin.Pair) r9
            if (r9 == 0) goto Lbd
            java.lang.Object r1 = r9.f4886a
            Aa.d r1 = (Aa.d) r1
            java.lang.Object r9 = r9.b
            za.e r9 = (za.e) r9
            java.util.concurrent.atomic.AtomicBoolean r5 = r1.d
            boolean r5 = r5.get()
            if (r5 != 0) goto Laf
            stepai.aios.guiagent.model.SessionState r5 = r9.e
            stepai.aios.guiagent.model.SessionState r7 = stepai.aios.guiagent.model.SessionState.f
            if (r5 == r7) goto La1
            boolean r9 = r9.f7008s
            if (r9 != 0) goto La1
            java.util.concurrent.atomic.AtomicReference r9 = r1.e
            Aa.c r5 = new Aa.c
            stepai.aios.guiagent.model.TakeoverReasonType r7 = r8.e
            r5.<init>(r3, r7)
            r9.set(r5)
            o9.e r9 = r1.f
            stepai.aios.guiagent.pipeline.ExecutionPipeline$ControlEvent r5 = stepai.aios.guiagent.pipeline.ExecutionPipeline$ControlEvent.b
            r9.a(r5)
            Aa.e r9 = r1.f167a
            stepai.aios.guiagent.pipeline.util.a r9 = r9.c
            r8.f6107a = r4
            java.lang.Object r9 = r9.b(r6, r8)
            if (r9 != r0) goto L6d
        L6c:
            return r0
        L6d:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r8 = r9.booleanValue()
            if (r8 == 0) goto L93
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Takeover initiated for session: "
            r8.<init>(r9)
            r8.append(r6)
            java.lang.String r9 = ", reason: "
            r8.append(r9)
            r8.append(r3)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "GuiExecutionPipeline"
            N9.j.H(r8, r9)
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            return r8
        L93:
            stepai.aios.guiagent.takeover.TakeoverException r8 = new stepai.aios.guiagent.takeover.TakeoverException
            stepai.aios.guiagent.takeover.TakeoverErrorType r9 = stepai.aios.guiagent.takeover.TakeoverErrorType.c
            java.lang.String r0 = "Failed to interrupt current action for session: "
            java.lang.String r0 = B7.a.k(r0, r6)
            r8.<init>(r9, r0, r2)
            throw r8
        La1:
            stepai.aios.guiagent.takeover.TakeoverException r8 = new stepai.aios.guiagent.takeover.TakeoverException
            stepai.aios.guiagent.takeover.TakeoverErrorType r9 = stepai.aios.guiagent.takeover.TakeoverErrorType.b
            java.lang.String r0 = "Session already in takeover flow: "
            java.lang.String r0 = B7.a.k(r0, r6)
            r8.<init>(r9, r0, r2)
            throw r8
        Laf:
            stepai.aios.guiagent.takeover.TakeoverException r8 = new stepai.aios.guiagent.takeover.TakeoverException
            stepai.aios.guiagent.takeover.TakeoverErrorType r9 = stepai.aios.guiagent.takeover.TakeoverErrorType.b
            java.lang.String r0 = "Session is stopping, takeover rejected: "
            java.lang.String r0 = B7.a.k(r0, r6)
            r8.<init>(r9, r0, r2)
            throw r8
        Lbd:
            stepai.aios.guiagent.takeover.TakeoverException r8 = new stepai.aios.guiagent.takeover.TakeoverException
            stepai.aios.guiagent.takeover.TakeoverErrorType r9 = stepai.aios.guiagent.takeover.TakeoverErrorType.f6156a
            java.lang.String r0 = "Session not found: "
            java.lang.String r0 = B7.a.k(r0, r6)
            r8.<init>(r9, r0, r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.ExecutionPipeline$takeoverTask$success$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
