package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import m9.c0;
import p9.p;

@J7.c(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", l = {387, 394, 397}, m = "collect$suspendImpl")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
final class SharedFlowImpl$collect$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public h f5219a;
    public p9.d b;
    public p c;
    public c0 d;
    public /* synthetic */ Object e;
    public final /* synthetic */ h f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedFlowImpl$collect$1(h hVar, H7.c cVar) {
        super(cVar);
        this.f = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        h.k(this.f, null, this);
        return CoroutineSingletons.f4909a;
    }
}
