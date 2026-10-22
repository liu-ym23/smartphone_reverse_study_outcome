package stepai.aios.guiagent.event;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import w9.InterfaceC2108a;

@c(c = "stepai.aios.guiagent.event.TaskLifecycleManager", f = "TaskLifecycleManager.kt", l = {161, 26}, m = "withSessionLock", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class TaskLifecycleManager$withSessionLock$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public SuspendLambda f6027a;
    public InterfaceC2108a b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ a e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLifecycleManager$withSessionLock$1(a aVar, H7.c cVar) {
        super(cVar);
        this.e = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.j(null, null, this);
    }
}
