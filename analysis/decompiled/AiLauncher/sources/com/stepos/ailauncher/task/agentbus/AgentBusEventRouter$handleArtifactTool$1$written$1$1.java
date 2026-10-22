package com.stepos.ailauncher.task.agentbus;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.taskstore.artifact.TaskArtifactPartMerger;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPart;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ailauncher/taskstore/artifact/TaskArtifactPartMerger$a;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/taskstore/artifact/TaskArtifactPartMerger$a;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$handleArtifactTool$1$written$1$1", f = "AgentBusEventRouter.kt", l = {675}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentBusEventRouter$handleArtifactTool$1$written$1$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super TaskArtifactPartMerger.a>, Object> {
    final /* synthetic */ TaskArtifactPartMerger.Parsed $parsed;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ String $taskId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusEventRouter$handleArtifactTool$1$written$1$1(String str, TaskArtifactPartMerger.Parsed parsed, String str2, InterfaceC4014c<? super AgentBusEventRouter$handleArtifactTool$1$written$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$taskId = str;
        this.$parsed = parsed;
        this.$sessionId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusEventRouter$handleArtifactTool$1$written$1$1(this.$taskId, this.$parsed, this.$sessionId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super TaskArtifactPartMerger.a> interfaceC4014c) {
        return ((AgentBusEventRouter$handleArtifactTool$1$written$1$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        TaskArtifactPartMerger taskArtifactPartMerger = TaskArtifactPartMerger.INSTANCE;
        String str = this.$taskId;
        List<TaskInfoPart> listA = this.$parsed.a();
        String str2 = this.$sessionId;
        String versionId = this.$parsed.getVersionId();
        this.label = 1;
        Object objE = TaskArtifactPartMerger.e(taskArtifactPartMerger, str, listA, str2, null, null, versionId, this, 8, null);
        return objE == objG ? objG : objE;
    }
}
