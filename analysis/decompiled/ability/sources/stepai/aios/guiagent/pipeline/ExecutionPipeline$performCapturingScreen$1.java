package stepai.aios.guiagent.pipeline;

import Aa.d;
import Aa.e;
import J7.c;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import za.g;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline", f = "ExecutionPipeline.kt", l = {893, TypedValues.Custom.TYPE_COLOR}, m = "performCapturingScreen", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$performCapturingScreen$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public e f6074a;
    public za.e b;
    public g c;
    public d d;
    public long e;
    public /* synthetic */ Object f;
    public final /* synthetic */ b g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$performCapturingScreen$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.g = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f = obj;
        this.h |= Integer.MIN_VALUE;
        return this.g.y(null, null, null, null, this);
    }
}
