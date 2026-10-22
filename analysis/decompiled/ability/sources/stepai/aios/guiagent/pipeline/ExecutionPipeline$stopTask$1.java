package stepai.aios.guiagent.pipeline;

import Aa.d;
import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline", f = "ExecutionPipeline.kt", l = {1543, 1546, 1550, 1551, 1552}, m = "stopTask$suspendImpl", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$stopTask$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public b f6103a;
    public String b;
    public String c;
    public d d;
    public /* synthetic */ Object e;
    public final /* synthetic */ b f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$stopTask$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return b.K(this.f, null, null, this);
    }
}
