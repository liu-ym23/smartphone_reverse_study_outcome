package stepai.aios.guiagent.event;

import C7.r;
import J7.c;
import S7.k;
import androidx.compose.material3.MenuKt;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import stepai.aios.guiagent.model.TakeoverReasonType;
import za.i;

@c(c = "stepai.aios.guiagent.event.TaskLifecycleManager$takeover$2", f = "TaskLifecycleManager.kt", l = {119, MenuKt.InTransitionDuration}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class TaskLifecycleManager$takeover$2 extends SuspendLambda implements k {

    /* renamed from: a, reason: collision with root package name */
    public i f6022a;
    public int b;
    public final /* synthetic */ M0.k c;
    public final /* synthetic */ String d;
    public final /* synthetic */ TakeoverReasonType e;
    public final /* synthetic */ a f;
    public final /* synthetic */ String g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLifecycleManager$takeover$2(M0.k kVar, String str, TakeoverReasonType takeoverReasonType, a aVar, String str2, H7.c cVar) {
        super(1, cVar);
        this.c = kVar;
        this.d = str;
        this.e = takeoverReasonType;
        this.f = aVar;
        this.g = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(H7.c cVar) {
        return new TaskLifecycleManager$takeover$2(this.c, this.d, this.e, this.f, this.g, cVar);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        return ((TaskLifecycleManager$takeover$2) create((H7.c) obj)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x008f, code lost:
    
        if (r1.q(r2, r3, r22) == r7) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            r22 = this;
            r4 = r22
            C7.r r6 = C7.r.f317a
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r0 = r4.b
            r8 = 2
            r1 = 1
            if (r0 == 0) goto L25
            if (r0 == r1) goto L1f
            if (r0 != r8) goto L17
            za.i r0 = r4.f6022a
            kotlin.b.b(r23)
            goto L92
        L17:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L1f:
            za.i r0 = r4.f6022a
            kotlin.b.b(r23)
            goto L7f
        L25:
            kotlin.b.b(r23)
            M0.k r0 = r4.c
            java.lang.Object r0 = r0.c
            Aa.d r0 = (Aa.d) r0
            za.i r0 = r0.b
            stepai.aios.guiagent.model.SessionState r0 = r0.c
            boolean r2 = r0.a()
            if (r2 == 0) goto L39
            goto L3d
        L39:
            stepai.aios.guiagent.model.SessionState r2 = stepai.aios.guiagent.model.SessionState.f
            if (r0 != r2) goto L3e
        L3d:
            return r6
        L3e:
            M0.k r0 = r4.c
            java.lang.Object r0 = r0.c
            Aa.d r0 = (Aa.d) r0
            za.i r0 = r0.b
            za.i r9 = r0.b(r2)
            java.lang.String r0 = r4.d
            stepai.aios.guiagent.model.TakeoverReasonType r2 = r4.e
            r20 = 0
            r21 = 58367(0xe3ff, float:8.179E-41)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r18 = r0
            r19 = r2
            za.i r9 = za.i.a(r9, r10, r11, r12, r13, r14, r15, r17, r18, r19, r20, r21)
            stepai.aios.guiagent.event.a r0 = r4.f
            stepai.aios.guiagent.session.a r0 = r0.f6028a
            java.lang.String r2 = r4.g
            r3 = r2
            java.lang.String r2 = r4.d
            r5 = r3
            stepai.aios.guiagent.model.TakeoverReasonType r3 = r4.e
            r4.f6022a = r9
            r4.b = r1
            r1 = r5
            r5 = 8
            java.lang.Object r0 = stepai.aios.guiagent.session.a.s(r0, r1, r2, r3, r4, r5)
            if (r0 != r7) goto L7e
            goto L91
        L7e:
            r0 = r9
        L7f:
            stepai.aios.guiagent.event.a r1 = r4.f
            stepai.aios.guiagent.session.a r1 = r1.f6028a
            java.lang.String r2 = r4.g
            stepai.aios.guiagent.model.SessionState r3 = r0.c
            r4.f6022a = r0
            r4.b = r8
            java.lang.Object r1 = r1.q(r2, r3, r4)
            if (r1 != r7) goto L92
        L91:
            return r7
        L92:
            M0.k r1 = r4.c
            r1.q(r0)
            stepai.aios.guiagent.event.a r1 = r4.f
            wa.a r1 = r1.b
            java.lang.String r2 = r4.d
            r1.b(r0, r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.event.TaskLifecycleManager$takeover$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
