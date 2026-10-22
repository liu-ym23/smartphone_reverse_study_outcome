package stepai.aios.guiagent.pipeline;

import Aa.d;
import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import za.e;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline$takeoverStateUpdater$1", f = "ExecutionPipeline.kt", l = {222, 226, 233, 235, 236}, m = "resetToManualTakeover", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$takeoverStateUpdater$1$resetToManualTakeover$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f6104a;
    public String b;
    public d c;
    public e d;
    public /* synthetic */ Object e;
    public final /* synthetic */ a f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$takeoverStateUpdater$1$resetToManualTakeover$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.a(null, null, this);
    }
}
