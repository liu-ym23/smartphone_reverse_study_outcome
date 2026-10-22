package stepai.aios.guiagent.pipeline;

import Aa.d;
import Aa.e;
import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import stepai.aios.guiagent.config.Action;
import za.g;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline", f = "ExecutionPipeline.kt", l = {742, 750, 752, 757, 766, 768, 771, 772, 775, 776, 780, 793, 798, 802}, m = "handleRegularAction", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$handleRegularAction$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public e f6067a;
    public za.e b;
    public Action c;
    public g d;
    public Object e;
    public d f;
    public za.d g;
    public za.d h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ b f6068j;
    public int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$handleRegularAction$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f6068j = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.i = obj;
        this.k |= Integer.MIN_VALUE;
        return this.f6068j.t(null, null, null, null, null, this);
    }
}
