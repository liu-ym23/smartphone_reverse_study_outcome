package stepai.aios.guiagent.event;

import Aa.d;
import C7.r;
import J7.c;
import S7.k;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@c(c = "stepai.aios.guiagent.event.TaskLifecycleManager$updateProgress$2", f = "TaskLifecycleManager.kt", l = {54}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class TaskLifecycleManager$updateProgress$2 extends SuspendLambda implements k {

    /* renamed from: a, reason: collision with root package name */
    public int f6024a;
    public final /* synthetic */ a b;
    public final /* synthetic */ String c;
    public final /* synthetic */ za.c d;
    public final /* synthetic */ M0.k e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLifecycleManager$updateProgress$2(a aVar, String str, za.c cVar, M0.k kVar, H7.c cVar2) {
        super(1, cVar2);
        this.b = aVar;
        this.c = str;
        this.d = cVar;
        this.e = kVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(H7.c cVar) {
        return new TaskLifecycleManager$updateProgress$2(this.b, this.c, this.d, this.e, cVar);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        return ((TaskLifecycleManager$updateProgress$2) create((H7.c) obj)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f6024a;
        if (i == 0) {
            b.b(obj);
            stepai.aios.guiagent.session.a aVar = this.b.f6028a;
            String str = this.c;
            za.c cVar = this.d;
            this.f6024a = 1;
            if (aVar.p(str, cVar, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
        }
        this.e.q(((d) this.e.c).b.e(this.d));
        return r.f317a;
    }
}
