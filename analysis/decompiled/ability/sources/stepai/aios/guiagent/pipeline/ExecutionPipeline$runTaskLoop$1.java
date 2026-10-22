package stepai.aios.guiagent.pipeline;

import Aa.d;
import J7.c;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import stepai.aios.guiagent.config.Action;
import za.e;
import za.g;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline", f = "ExecutionPipeline.kt", l = {483, 495, 498, TypedValues.PositionType.TYPE_DRAWPATH, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, 516, 526, 535, 538, 545, 546, 550, 551, 567, 569, 580, 583, 586, 588, 598, 601}, m = "runTaskLoop", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$runTaskLoop$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public e f6094a;
    public Aa.e b;
    public d c;
    public Object d;
    public g e;
    public Object f;
    public za.d g;
    public Action h;
    public Object i;

    /* renamed from: j, reason: collision with root package name */
    public int f6095j;
    public int k;
    public /* synthetic */ Object l;
    public final /* synthetic */ b m;
    public int n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$runTaskLoop$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.m = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.l = obj;
        this.n |= Integer.MIN_VALUE;
        return this.m.H(null, null, null, 0, null, this);
    }
}
