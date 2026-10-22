package stepai.aios.guiagent.pipeline;

import Aa.e;
import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import m9.q0;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline", f = "ExecutionPipeline.kt", l = {1639, 1647, 1655, 1665, 1668, 1671, 1673, 1676, 1689, 1694, 1700, 1707, 1716, 1718}, m = "recoverFromTakeover$suspendImpl", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$recoverFromTakeover$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public b f6077a;
    public String b;
    public Object c;
    public e d;
    public Ea.a e;
    public q0 f;
    public /* synthetic */ Object g;
    public final /* synthetic */ b h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$recoverFromTakeover$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.h = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.i |= Integer.MIN_VALUE;
        return b.z(this.h, null, this);
    }
}
