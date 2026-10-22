package stepai.aios.guiagent.event;

import C7.r;
import J7.c;
import S7.k;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import za.i;

@c(c = "stepai.aios.guiagent.event.TaskLifecycleManager$updateState$4", f = "TaskLifecycleManager.kt", l = {41, 44, 45}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class TaskLifecycleManager$updateState$4 extends SuspendLambda implements k {

    /* renamed from: a, reason: collision with root package name */
    public int f6026a;
    public final /* synthetic */ a b;
    public final /* synthetic */ String c;
    public final /* synthetic */ i d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLifecycleManager$updateState$4(a aVar, String str, i iVar, H7.c cVar) {
        super(1, cVar);
        this.b = aVar;
        this.c = str;
        this.d = iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(H7.c cVar) {
        return new TaskLifecycleManager$updateState$4(this.b, this.c, this.d, cVar);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        return ((TaskLifecycleManager$updateState$4) create((H7.c) obj)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
    
        if (r11 != r2) goto L29;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            za.i r0 = r10.d
            stepai.aios.guiagent.model.SessionState r1 = r0.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r10.f6026a
            r4 = 3
            r5 = 2
            r6 = 1
            C7.r r7 = C7.r.f317a
            java.lang.String r8 = r10.c
            stepai.aios.guiagent.event.a r9 = r10.b
            if (r3 == 0) goto L2d
            if (r3 == r6) goto L29
            if (r3 == r5) goto L25
            if (r3 != r4) goto L1d
            kotlin.b.b(r11)
            goto L63
        L1d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L25:
            kotlin.b.b(r11)
            goto L58
        L29:
            kotlin.b.b(r11)
            goto L3b
        L2d:
            kotlin.b.b(r11)
            stepai.aios.guiagent.session.a r11 = r9.f6028a
            r10.f6026a = r6
            java.lang.Object r11 = r11.j(r8, r10)
            if (r11 != r2) goto L3b
            goto L62
        L3b:
            za.e r11 = (za.e) r11
            if (r11 != 0) goto L40
            goto L4c
        L40:
            stepai.aios.guiagent.model.SessionState r3 = r11.e
            boolean r3 = r3.a()
            if (r3 == 0) goto L4d
            stepai.aios.guiagent.model.SessionState r11 = r11.e
            if (r1 == r11) goto L4d
        L4c:
            return r7
        L4d:
            stepai.aios.guiagent.session.a r11 = r9.f6028a
            r10.f6026a = r5
            java.lang.Object r11 = r11.q(r8, r1, r10)
            if (r11 != r2) goto L58
            goto L62
        L58:
            stepai.aios.guiagent.session.a r11 = r9.f6028a
            r10.f6026a = r4
            java.lang.Object r11 = r11.j(r8, r10)
            if (r11 != r2) goto L63
        L62:
            return r2
        L63:
            za.e r11 = (za.e) r11
            if (r11 == 0) goto L6b
            za.i r0 = r11.e()
        L6b:
            wa.a r10 = r9.b
            r10.c(r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.event.TaskLifecycleManager$updateState$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
