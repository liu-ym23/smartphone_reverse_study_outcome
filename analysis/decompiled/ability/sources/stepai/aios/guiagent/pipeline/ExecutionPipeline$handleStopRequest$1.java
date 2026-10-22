package stepai.aios.guiagent.pipeline;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline", f = "ExecutionPipeline.kt", l = {2226, 2230, 2234}, m = "handleStopRequest$suspendImpl", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$handleStopRequest$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public b f6069a;
    public String b;
    public /* synthetic */ Object c;
    public final /* synthetic */ b d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$handleStopRequest$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.d = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return b.u(this.d, null, null, this);
    }
}
