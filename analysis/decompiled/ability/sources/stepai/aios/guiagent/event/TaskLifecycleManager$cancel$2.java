package stepai.aios.guiagent.event;

import C7.r;
import J7.c;
import S7.k;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import za.i;

@c(c = "stepai.aios.guiagent.event.TaskLifecycleManager$cancel$2", f = "TaskLifecycleManager.kt", l = {99, 100}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class TaskLifecycleManager$cancel$2 extends SuspendLambda implements k {

    /* renamed from: a, reason: collision with root package name */
    public i f6019a;
    public int b;
    public final /* synthetic */ M0.k c;
    public final /* synthetic */ String d;
    public final /* synthetic */ a e;
    public final /* synthetic */ String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLifecycleManager$cancel$2(M0.k kVar, String str, a aVar, String str2, H7.c cVar) {
        super(1, cVar);
        this.c = kVar;
        this.d = str;
        this.e = aVar;
        this.f = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(H7.c cVar) {
        return new TaskLifecycleManager$cancel$2(this.c, this.d, this.e, this.f, cVar);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        return ((TaskLifecycleManager$cancel$2) create((H7.c) obj)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b1 A[Catch: Exception -> 0x00bb, LOOP:0: B:22:0x00ab->B:24:0x00b1, LOOP_END, TRY_LEAVE, TryCatch #0 {Exception -> 0x00bb, blocks: (B:21:0x00a5, B:22:0x00ab, B:24:0x00b1), top: B:30:0x00a5 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.event.TaskLifecycleManager$cancel$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
