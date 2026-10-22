package stepai.aios.guiagent.pipeline;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import stepai.aios.guiagent.model.TakeoverReasonType;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline", f = "ExecutionPipeline.kt", l = {1570, 1576, 1617, 1621, 1622, 1626, 1627}, m = "takeoverTask$suspendImpl", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$takeoverTask$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public b f6106a;
    public String b;
    public String c;
    public TakeoverReasonType d;
    public Exception e;
    public boolean f;
    public /* synthetic */ Object g;
    public final /* synthetic */ b h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$takeoverTask$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.h = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.i |= Integer.MIN_VALUE;
        return b.M(this.h, null, null, null, this);
    }
}
