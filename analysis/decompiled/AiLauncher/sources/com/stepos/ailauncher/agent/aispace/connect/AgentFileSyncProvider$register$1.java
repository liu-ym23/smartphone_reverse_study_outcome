package com.stepos.ailauncher.agent.aispace.connect;

import com.stepos.agentframework.chatui.AgentFileSyncBridge;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "fileId", "Lcom/stepos/agentframework/chatui/AgentFileSyncBridge$a;", "<anonymous>", "(Ljava/lang/String;)Lcom/stepos/agentframework/chatui/AgentFileSyncBridge$a;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.AgentFileSyncProvider$register$1", f = "AgentFileSyncProvider.kt", l = {38}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentFileSyncProvider$register$1 extends SuspendLambda implements p9.p<String, InterfaceC4014c<? super AgentFileSyncBridge.Result>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public AgentFileSyncProvider$register$1(InterfaceC4014c<? super AgentFileSyncProvider$register$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentFileSyncProvider$register$1 agentFileSyncProvider$register$1 = new AgentFileSyncProvider$register$1(interfaceC4014c);
        agentFileSyncProvider$register$1.L$0 = obj;
        return agentFileSyncProvider$register$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String str = (String) this.L$0;
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
        AgentFileSyncProvider agentFileSyncProvider = AgentFileSyncProvider.INSTANCE;
        this.L$0 = g9.h.a(str);
        this.label = 1;
        Object objH = agentFileSyncProvider.h(str, this);
        return objH == objG ? objG : objH;
    }

    @Override // p9.p
    public final Object invoke(String str, InterfaceC4014c<? super AgentFileSyncBridge.Result> interfaceC4014c) {
        return ((AgentFileSyncProvider$register$1) create(str, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }
}
