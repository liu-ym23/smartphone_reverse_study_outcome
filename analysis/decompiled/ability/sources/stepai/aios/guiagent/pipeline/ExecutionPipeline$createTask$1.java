package stepai.aios.guiagent.pipeline;

import Aa.d;
import J7.c;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import stepai.aios.guiagent.config.ResolvedTaskConfig;
import za.e;
import za.f;
import za.i;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline", f = "ExecutionPipeline.kt", l = {266, 304, 305}, m = "createTask$suspendImpl", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$createTask$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public b f6056a;
    public f b;
    public ResolvedTaskConfig c;
    public LinkedHashMap d;
    public e e;
    public i f;
    public d g;
    public long h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f6057j;
    public final /* synthetic */ b k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$createTask$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.k = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f6057j = obj;
        this.l |= Integer.MIN_VALUE;
        return b.n(this.k, null, this);
    }
}
