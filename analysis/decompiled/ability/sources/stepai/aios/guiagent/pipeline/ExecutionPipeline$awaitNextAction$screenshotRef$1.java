package stepai.aios.guiagent.pipeline;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import stepai.aios.guiagent.tracer.TraceScreenshotStore;
import za.g;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline$awaitNextAction$screenshotRef$1", f = "ExecutionPipeline.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;", "<anonymous>", "(Lm9/z;)Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class ExecutionPipeline$awaitNextAction$screenshotRef$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f6048a;
    public final /* synthetic */ g b;
    public final /* synthetic */ String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$awaitNextAction$screenshotRef$1(String str, g gVar, String str2, H7.c cVar) {
        super(2, cVar);
        this.f6048a = str;
        this.b = gVar;
        this.c = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new ExecutionPipeline$awaitNextAction$screenshotRef$1(this.f6048a, this.b, this.c, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((ExecutionPipeline$awaitNextAction$screenshotRef$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        return TraceScreenshotStore.INSTANCE.persist(this.f6048a, this.b.f7015a, this.c);
    }
}
