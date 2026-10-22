package stepai.aios.guiagent.pipeline;

import Aa.d;
import Aa.e;
import J7.c;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import stepai.aios.guiagent.config.Action;
import stepai.aios.guiexecutor.api.GuiCommand;
import za.g;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline", f = "ExecutionPipeline.kt", l = {613, 621, 623, 629, 630, 643, 645, 657, 660, 661, 663, 692, 693, 675, 676, 692, 693, 679, 680, 692, 693, 686, 688, 692, 693, 692, 693, 692, 693, 698, 699, 703, TypedValues.TransitionType.TYPE_AUTO_TRANSITION, 709, 715, 717, 724, 727}, m = "handleInquiryAction", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutionPipeline$handleInquiryAction$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public e f6062a;
    public za.e b;
    public Action c;
    public g d;
    public Object e;
    public d f;
    public za.d g;
    public Action h;
    public GuiCommand i;

    /* renamed from: j, reason: collision with root package name */
    public g f6063j;
    public GuiCommand k;
    public Object l;
    public Object m;
    public RuntimeException n;
    public Object o;
    public /* synthetic */ Object p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ b f6064q;

    /* renamed from: r, reason: collision with root package name */
    public int f6065r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$handleInquiryAction$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f6064q = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.p = obj;
        this.f6065r |= Integer.MIN_VALUE;
        return this.f6064q.s(null, null, null, null, null, this);
    }
}
