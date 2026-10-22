package stepai.aios.guiagent.event;

import C7.r;
import J7.c;
import S7.k;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import za.d;
import za.i;

@c(c = "stepai.aios.guiagent.event.TaskLifecycleManager$complete$2", f = "TaskLifecycleManager.kt", l = {71, 72}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class TaskLifecycleManager$complete$2 extends SuspendLambda implements k {

    /* renamed from: a, reason: collision with root package name */
    public i f6020a;
    public int b;
    public long c;
    public int d;
    public final /* synthetic */ M0.k e;
    public final /* synthetic */ a f;
    public final /* synthetic */ String g;
    public final /* synthetic */ d h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLifecycleManager$complete$2(M0.k kVar, a aVar, String str, d dVar, H7.c cVar) {
        super(1, cVar);
        this.e = kVar;
        this.f = aVar;
        this.g = str;
        this.h = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(H7.c cVar) {
        return new TaskLifecycleManager$complete$2(this.e, this.f, this.g, this.h, cVar);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        return ((TaskLifecycleManager$complete$2) create((H7.c) obj)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00de A[Catch: Exception -> 0x00e8, LOOP:0: B:27:0x00d8->B:29:0x00de, LOOP_END, TRY_LEAVE, TryCatch #0 {Exception -> 0x00e8, blocks: (B:26:0x00d2, B:27:0x00d8, B:29:0x00de), top: B:35:0x00d2 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r28) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.event.TaskLifecycleManager$complete$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
