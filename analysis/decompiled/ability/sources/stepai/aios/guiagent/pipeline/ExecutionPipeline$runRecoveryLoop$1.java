package stepai.aios.guiagent.pipeline;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import m9.InterfaceC1723p;
import za.e;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline", f = "ExecutionPipeline.kt", l = {1737, 1748, 1754, 1764, 1768, 1770, 1771, 1772, 1777, 1782, 1789, 1799, 1801}, m = "runRecoveryLoop", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$runRecoveryLoop$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f6091a;
    public Ea.a b;
    public InterfaceC1723p c;
    public Object d;
    public e e;
    public /* synthetic */ Object f;
    public final /* synthetic */ b g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$runRecoveryLoop$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.g = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f = obj;
        this.h |= Integer.MIN_VALUE;
        return b.c(this.g, null, null, null, this);
    }
}
