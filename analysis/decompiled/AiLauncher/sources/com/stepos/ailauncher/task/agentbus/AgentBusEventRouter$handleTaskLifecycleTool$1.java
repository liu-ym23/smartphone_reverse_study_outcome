package com.stepos.ailauncher.task.agentbus;

import Ua.M;
import Y8.t;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$handleTaskLifecycleTool$1", f = "AgentBusEventRouter.kt", l = {1730, 439, 465, 473}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentBusEventRouter$handleTaskLifecycleTool$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ String $sessionId;
    final /* synthetic */ AgentTool $tool;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusEventRouter$handleTaskLifecycleTool$1(String str, AgentTool agentTool, InterfaceC4014c<? super AgentBusEventRouter$handleTaskLifecycleTool$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$sessionId = str;
        this.$tool = agentTool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentBusEventRouter$handleTaskLifecycleTool$1 agentBusEventRouter$handleTaskLifecycleTool$1 = new AgentBusEventRouter$handleTaskLifecycleTool$1(this.$sessionId, this.$tool, interfaceC4014c);
        agentBusEventRouter$handleTaskLifecycleTool$1.L$0 = obj;
        return agentBusEventRouter$handleTaskLifecycleTool$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AgentBusEventRouter$handleTaskLifecycleTool$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x01ca, code lost:
    
        if (r4.S(r5, r17) == r3) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bc A[Catch: all -> 0x0191, TRY_LEAVE, TryCatch #1 {all -> 0x0191, blocks: (B:47:0x016a, B:49:0x0170, B:52:0x0194, B:55:0x019b, B:30:0x00b5, B:33:0x00bc, B:36:0x00db), top: B:76:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0170 A[Catch: all -> 0x0191, TryCatch #1 {all -> 0x0191, blocks: (B:47:0x016a, B:49:0x0170, B:52:0x0194, B:55:0x019b, B:30:0x00b5, B:33:0x00bc, B:36:0x00db), top: B:76:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a6  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$handleTaskLifecycleTool$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
