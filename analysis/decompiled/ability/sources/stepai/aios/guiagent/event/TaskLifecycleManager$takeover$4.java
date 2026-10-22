package stepai.aios.guiagent.event;

import C7.r;
import J7.c;
import S7.k;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import stepai.aios.guiagent.model.TakeoverReasonType;
import za.i;

@c(c = "stepai.aios.guiagent.event.TaskLifecycleManager$takeover$4", f = "TaskLifecycleManager.kt", l = {138, 139, 140}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class TaskLifecycleManager$takeover$4 extends SuspendLambda implements k {

    /* renamed from: a, reason: collision with root package name */
    public i f6023a;
    public int b;
    public final /* synthetic */ i c;
    public final /* synthetic */ String d;
    public final /* synthetic */ a e;
    public final /* synthetic */ String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLifecycleManager$takeover$4(H7.c cVar, String str, String str2, a aVar, i iVar) {
        super(1, cVar);
        TakeoverReasonType takeoverReasonType = TakeoverReasonType.f6034a;
        this.c = iVar;
        this.d = str;
        this.e = aVar;
        this.f = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(H7.c cVar) {
        TakeoverReasonType takeoverReasonType = TakeoverReasonType.f6034a;
        a aVar = this.e;
        return new TaskLifecycleManager$takeover$4(cVar, this.d, this.f, aVar, this.c);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        return ((TaskLifecycleManager$takeover$4) create((H7.c) obj)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0094, code lost:
    
        if (r1 != r6) goto L28;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            r25 = this;
            r4 = r25
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r0 = r4.b
            java.lang.String r7 = r4.f
            r8 = 3
            r9 = 2
            r1 = 1
            C7.r r10 = C7.r.f317a
            stepai.aios.guiagent.event.a r11 = r4.e
            if (r0 == 0) goto L34
            if (r0 == r1) goto L2e
            if (r0 == r9) goto L28
            if (r0 != r8) goto L20
            za.i r0 = r4.f6023a
            kotlin.b.b(r26)
            r1 = r26
            goto L97
        L20:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L28:
            za.i r0 = r4.f6023a
            kotlin.b.b(r26)
            goto L8a
        L2e:
            za.i r0 = r4.f6023a
            kotlin.b.b(r26)
            goto L7b
        L34:
            kotlin.b.b(r26)
            za.i r0 = r4.c
            stepai.aios.guiagent.model.SessionState r2 = r0.c
            boolean r3 = r2.a()
            if (r3 == 0) goto L42
            goto L46
        L42:
            stepai.aios.guiagent.model.SessionState r3 = stepai.aios.guiagent.model.SessionState.f
            if (r2 != r3) goto L47
        L46:
            return r10
        L47:
            za.i r12 = r0.b(r3)
            stepai.aios.guiagent.model.TakeoverReasonType r3 = stepai.aios.guiagent.model.TakeoverReasonType.b
            r23 = 0
            r24 = 58367(0xe3ff, float:8.179E-41)
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            java.lang.String r0 = r4.d
            r21 = r0
            r22 = r3
            za.i r12 = za.i.a(r12, r13, r14, r15, r16, r17, r18, r20, r21, r22, r23, r24)
            stepai.aios.guiagent.session.a r0 = r11.f6028a
            r4.f6023a = r12
            r4.b = r1
            java.lang.String r1 = r4.f
            java.lang.String r2 = r4.d
            r5 = 8
            java.lang.Object r0 = stepai.aios.guiagent.session.a.s(r0, r1, r2, r3, r4, r5)
            if (r0 != r6) goto L7a
            goto L96
        L7a:
            r0 = r12
        L7b:
            stepai.aios.guiagent.session.a r1 = r11.f6028a
            stepai.aios.guiagent.model.SessionState r2 = r0.c
            r4.f6023a = r0
            r4.b = r9
            java.lang.Object r1 = r1.q(r7, r2, r4)
            if (r1 != r6) goto L8a
            goto L96
        L8a:
            stepai.aios.guiagent.session.a r1 = r11.f6028a
            r4.f6023a = r0
            r4.b = r8
            java.lang.Object r1 = r1.j(r7, r4)
            if (r1 != r6) goto L97
        L96:
            return r6
        L97:
            za.e r1 = (za.e) r1
            if (r1 == 0) goto L9f
            za.i r0 = r1.e()
        L9f:
            wa.a r1 = r11.b
            r1.c(r0)
            wa.a r1 = r11.b
            java.lang.String r2 = r4.d
            r1.b(r0, r2)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.event.TaskLifecycleManager$takeover$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
