package stepai.aios.guiagent.pipeline;

import J7.c;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import za.e;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline$takeoverStateUpdater$1", f = "ExecutionPipeline.kt", l = {ComposerKt.reuseKey, 210, 213, 214, 215}, m = "resetToRunning", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$takeoverStateUpdater$1$resetToRunning$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f6105a;
    public e b;
    public /* synthetic */ Object c;
    public final /* synthetic */ a d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$takeoverStateUpdater$1$resetToRunning$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.d = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.b(null, this);
    }
}
