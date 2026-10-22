package com.stepos.ailauncher.task.agentbus;

import Ua.M;
import Y8.t;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LUa/M;", "Lkotlin/Pair;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "", "<anonymous>", "(LUa/M;)Lkotlin/Pair;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$handleTaskLifecycleTool$1$save$1$1", f = "AgentBusEventRouter.kt", l = {441}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentBusEventRouter$handleTaskLifecycleTool$1$save$1$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Pair<? extends TaskInfoCard, ? extends Boolean>>, Object> {
    final /* synthetic */ String $sessionId;
    final /* synthetic */ AgentTool $tool;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusEventRouter$handleTaskLifecycleTool$1$save$1$1(AgentTool agentTool, String str, InterfaceC4014c<? super AgentBusEventRouter$handleTaskLifecycleTool$1$save$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$tool = agentTool;
        this.$sessionId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentBusEventRouter$handleTaskLifecycleTool$1$save$1$1 agentBusEventRouter$handleTaskLifecycleTool$1$save$1$1 = new AgentBusEventRouter$handleTaskLifecycleTool$1$save$1$1(this.$tool, this.$sessionId, interfaceC4014c);
        agentBusEventRouter$handleTaskLifecycleTool$1$save$1$1.L$0 = obj;
        return agentBusEventRouter$handleTaskLifecycleTool$1$save$1$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super Pair<TaskInfoCard, Boolean>> interfaceC4014c) {
        return ((AgentBusEventRouter$handleTaskLifecycleTool$1$save$1$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$handleTaskLifecycleTool$1$save$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super Pair<? extends TaskInfoCard, ? extends Boolean>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super Pair<TaskInfoCard, Boolean>>) interfaceC4014c);
    }
}
