package stepai.aios.guiagent.event;

import Aa.d;
import C7.r;
import J7.c;
import S7.k;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import stepai.aios.guiagent.model.SessionState;
import za.i;

@c(c = "stepai.aios.guiagent.event.TaskLifecycleManager$updateState$2", f = "TaskLifecycleManager.kt", l = {34}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class TaskLifecycleManager$updateState$2 extends SuspendLambda implements k {

    /* renamed from: a, reason: collision with root package name */
    public int f6025a;
    public final /* synthetic */ M0.k b;
    public final /* synthetic */ i c;
    public final /* synthetic */ a d;
    public final /* synthetic */ String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLifecycleManager$updateState$2(M0.k kVar, i iVar, a aVar, String str, H7.c cVar) {
        super(1, cVar);
        this.b = kVar;
        this.c = iVar;
        this.d = aVar;
        this.e = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(H7.c cVar) {
        return new TaskLifecycleManager$updateState$2(this.b, this.c, this.d, this.e, cVar);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        return ((TaskLifecycleManager$updateState$2) create((H7.c) obj)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        r rVar = r.f317a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f6025a;
        if (i == 0) {
            b.b(obj);
            SessionState sessionState = ((d) this.b.c).b.c;
            if (sessionState.a() && this.c.c != sessionState) {
                return rVar;
            }
            stepai.aios.guiagent.session.a aVar = this.d.f6028a;
            String str = this.e;
            SessionState sessionState2 = this.c.c;
            this.f6025a = 1;
            if (aVar.q(str, sessionState2, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
        }
        this.b.q(this.c);
        return rVar;
    }
}
