package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.TrajectorySpeculationLabeler$labelActions$rawContent$1$1", f = "TrajectorySpeculationLabeler.kt", l = {89}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class TrajectorySpeculationLabeler$labelActions$rawContent$1$1 extends SuspendLambda implements S7.n {
    final /* synthetic */ Context $context;
    final /* synthetic */ GuiTaskRecord $guiTaskRecord;
    final /* synthetic */ String $requestBody;
    final /* synthetic */ TrajectorySpeculationLabeler $this_runCatching;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrajectorySpeculationLabeler$labelActions$rawContent$1$1(TrajectorySpeculationLabeler trajectorySpeculationLabeler, Context context, GuiTaskRecord guiTaskRecord, String str, H7.c<? super TrajectorySpeculationLabeler$labelActions$rawContent$1$1> cVar) {
        super(2, cVar);
        this.$this_runCatching = trajectorySpeculationLabeler;
        this.$context = context;
        this.$guiTaskRecord = guiTaskRecord;
        this.$requestBody = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new TrajectorySpeculationLabeler$labelActions$rawContent$1$1(this.$this_runCatching, this.$context, this.$guiTaskRecord, this.$requestBody, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        TrajectorySpeculationLabeler trajectorySpeculationLabeler = this.$this_runCatching;
        Context context = this.$context;
        String taskId = this.$guiTaskRecord.getTaskId();
        String str = this.$requestBody;
        this.label = 1;
        Object objRequestLabels = trajectorySpeculationLabeler.requestLabels(context, taskId, str, this);
        return objRequestLabels == coroutineSingletons ? coroutineSingletons : objRequestLabels;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super String> cVar) {
        return ((TrajectorySpeculationLabeler$labelActions$rawContent$1$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
