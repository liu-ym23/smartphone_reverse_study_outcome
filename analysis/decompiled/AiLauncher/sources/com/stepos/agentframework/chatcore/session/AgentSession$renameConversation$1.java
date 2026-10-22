package com.stepos.agentframework.chatcore.session;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$renameConversation$1", f = "AgentSession.kt", l = {2969}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$renameConversation$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ p9.p<Boolean, w4.e, Y8.t> $callback;
    final /* synthetic */ String $newTitle;
    final /* synthetic */ String $sessionId;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AgentSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AgentSession$renameConversation$1(AgentSession agentSession, String str, String str2, p9.p<? super Boolean, ? super w4.e, Y8.t> pVar, InterfaceC4014c<? super AgentSession$renameConversation$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentSession;
        this.$sessionId = str;
        this.$newTitle = str2;
        this.$callback = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentSession$renameConversation$1 agentSession$renameConversation$1 = new AgentSession$renameConversation$1(this.this$0, this.$sessionId, this.$newTitle, this.$callback, interfaceC4014c);
        agentSession$renameConversation$1.L$0 = obj;
        return agentSession$renameConversation$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$renameConversation$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00bd A[Catch: Exception -> 0x00c5, TryCatch #3 {Exception -> 0x00c5, blocks: (B:31:0x0092, B:33:0x00bd, B:30:0x0089, B:38:0x00cb, B:40:0x00d0), top: B:53:0x000d }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession$renameConversation$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
