package com.stepos.ailauncher.task.agentbus;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$handleArtifactTool$1$existingCard$1", f = "AgentBusEventRouter.kt", l = {624}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentBusEventRouter$handleArtifactTool$1$existingCard$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super TaskInfoCard>, Object> {
    final /* synthetic */ String $taskId;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusEventRouter$handleArtifactTool$1$existingCard$1(String str, InterfaceC4014c<? super AgentBusEventRouter$handleArtifactTool$1$existingCard$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$taskId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentBusEventRouter$handleArtifactTool$1$existingCard$1 agentBusEventRouter$handleArtifactTool$1$existingCard$1 = new AgentBusEventRouter$handleArtifactTool$1$existingCard$1(this.$taskId, interfaceC4014c);
        agentBusEventRouter$handleArtifactTool$1$existingCard$1.L$0 = obj;
        return agentBusEventRouter$handleArtifactTool$1$existingCard$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super TaskInfoCard> interfaceC4014c) {
        return ((AgentBusEventRouter$handleArtifactTool$1$existingCard$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        M m10 = (M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                String str = this.$taskId;
                Result.Companion companion = Result.INSTANCE;
                com.stepos.ailauncher.taskstore.repository.a aVarN = TaskStoreModule.INSTANCE.n();
                this.L$0 = g9.h.a(m10);
                this.L$1 = g9.h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                obj = aVarN.q(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            objB = Result.b((TaskInfoCard) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        String str2 = this.$taskId;
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("AILauncher-AgentBus", "getByTaskId for image artifact failed taskId=" + str2, thE, false, 8, null);
        }
        if (Result.g(objB)) {
            return null;
        }
        return objB;
    }
}
