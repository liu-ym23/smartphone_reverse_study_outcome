package com.stepos.ability.task.executor;

import C7.r;
import S7.n;
import com.stepos.ability.api.task.listener.ITaskListener;
import com.stepos.taskrobot.common.bean.ExplainSnapshot;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.ability.task.executor.GuiTaskExecutor$execute$2$progressCallback$1$onExplainUpdated$1", f = "GuiTaskExecutor.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class GuiTaskExecutor$execute$2$progressCallback$1$onExplainUpdated$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f3269a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ExplainSnapshot c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuiTaskExecutor$execute$2$progressCallback$1$onExplainUpdated$1(d dVar, String str, ExplainSnapshot explainSnapshot, H7.c cVar) {
        super(2, cVar);
        this.f3269a = dVar;
        this.b = str;
        this.c = explainSnapshot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new GuiTaskExecutor$execute$2$progressCallback$1$onExplainUpdated$1(this.f3269a, this.b, this.c, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        GuiTaskExecutor$execute$2$progressCallback$1$onExplainUpdated$1 guiTaskExecutor$execute$2$progressCallback$1$onExplainUpdated$1 = (GuiTaskExecutor$execute$2$progressCallback$1$onExplainUpdated$1) create((InterfaceC1733z) obj, (H7.c) obj2);
        r rVar = r.f317a;
        guiTaskExecutor$execute$2$progressCallback$1$onExplainUpdated$1.invokeSuspend(rVar);
        return rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        d dVar = this.f3269a;
        ITaskListener iTaskListener = dVar.f3309a;
        dVar.getClass();
        ExplainSnapshot explainSnapshot = this.c;
        iTaskListener.onExplainUpdated(this.b, new com.stepos.ability.bean.ExplainSnapshot(explainSnapshot.getStepIndex(), explainSnapshot.getTotalStepsHint(), explainSnapshot.getCurrent(), explainSnapshot.getHistory()));
        return r.f317a;
    }
}
