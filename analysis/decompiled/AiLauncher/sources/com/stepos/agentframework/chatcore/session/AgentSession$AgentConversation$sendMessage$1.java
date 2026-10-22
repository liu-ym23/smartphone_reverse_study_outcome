package com.stepos.agentframework.chatcore.session;

import Ua.InterfaceC1083u;
import com.stepos.agentframework.chatcore.session.AgentSession;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import u4.AgentMessage;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation$sendMessage$1", f = "AgentSession.kt", l = {4317}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$AgentConversation$sendMessage$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentSession.c $bizCallback;
    final /* synthetic */ boolean $deepThinking;
    final /* synthetic */ List<AgentMessage> $messages;
    final /* synthetic */ Map<String, String> $meta;
    final /* synthetic */ InterfaceC1083u<Y8.t> $pending;
    final /* synthetic */ String $regenerateRunId;
    final /* synthetic */ ChatMessage $resendMessage;
    final /* synthetic */ AgentSession.d $sessionCreateCallback;
    final /* synthetic */ VariantGroupTag $variantGroup;
    int label;
    final /* synthetic */ AgentSession.AgentConversation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSession$AgentConversation$sendMessage$1(InterfaceC1083u<Y8.t> interfaceC1083u, AgentSession.AgentConversation agentConversation, List<AgentMessage> list, ChatMessage chatMessage, AgentSession.d dVar, boolean z10, Map<String, String> map, AgentSession.c cVar, VariantGroupTag variantGroupTag, String str, InterfaceC4014c<? super AgentSession$AgentConversation$sendMessage$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$pending = interfaceC1083u;
        this.this$0 = agentConversation;
        this.$messages = list;
        this.$resendMessage = chatMessage;
        this.$deepThinking = z10;
        this.$meta = map;
        this.$bizCallback = cVar;
        this.$variantGroup = variantGroupTag;
        this.$regenerateRunId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSession$AgentConversation$sendMessage$1(this.$pending, this.this$0, this.$messages, this.$resendMessage, null, this.$deepThinking, this.$meta, this.$bizCallback, this.$variantGroup, this.$regenerateRunId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$AgentConversation$sendMessage$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            InterfaceC1083u<Y8.t> interfaceC1083u = this.$pending;
            this.label = 1;
            if (interfaceC1083u.a1(this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        this.this$0.j0(this.$messages, this.$resendMessage, null, this.$deepThinking, this.$meta, this.$bizCallback, this.$variantGroup, this.$regenerateRunId);
        return Y8.t.f7040a;
    }
}
