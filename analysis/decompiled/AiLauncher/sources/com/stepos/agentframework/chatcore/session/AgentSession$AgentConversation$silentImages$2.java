package com.stepos.agentframework.chatcore.session;

import com.stepos.agentframework.chatcore.file.FileInfo;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "", "", "list", "", "Lcom/stepos/agentframework/chatcore/file/FileInfo;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation$silentImages$2", f = "AgentSession.kt", l = {3470}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$AgentConversation$silentImages$2 extends SuspendLambda implements p9.p<List<? extends FileInfo>, InterfaceC4014c<? super Map<String, ? extends String>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AgentSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSession$AgentConversation$silentImages$2(AgentSession agentSession, InterfaceC4014c<? super AgentSession$AgentConversation$silentImages$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentSession$AgentConversation$silentImages$2 agentSession$AgentConversation$silentImages$2 = new AgentSession$AgentConversation$silentImages$2(this.this$0, interfaceC4014c);
        agentSession$AgentConversation$silentImages$2.L$0 = obj;
        return agentSession$AgentConversation$silentImages$2;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(List<FileInfo> list, InterfaceC4014c<? super Map<String, String>> interfaceC4014c) {
        return ((AgentSession$AgentConversation$silentImages$2) create(list, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List<FileInfo> list = (List) this.L$0;
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
        AgentSession agentSession = this.this$0;
        this.L$0 = g9.h.a(list);
        this.label = 1;
        Object objL1 = agentSession.L1(list, this);
        return objL1 == objG ? objG : objL1;
    }
}
