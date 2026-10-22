package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import m9.c0;
import p9.u;

@J7.c(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {389, 401, 406}, m = "collect")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
final class StateFlowImpl$collect$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public i f5223a;
    public p9.d b;
    public u c;
    public c0 d;
    public Object e;
    public /* synthetic */ Object f;
    public final /* synthetic */ i g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateFlowImpl$collect$1(i iVar, H7.c cVar) {
        super(cVar);
        this.g = iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f = obj;
        this.h |= Integer.MIN_VALUE;
        this.g.collect(null, this);
        return CoroutineSingletons.f4909a;
    }
}
