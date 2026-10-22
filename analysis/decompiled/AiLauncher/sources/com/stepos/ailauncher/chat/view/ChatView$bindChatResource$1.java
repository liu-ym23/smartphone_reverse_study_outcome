package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.AgentUIConfig;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentError;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.session.ESessionStatus;
import com.stepos.agentframework.chatui.AgentChatLayout;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.manager.C2689c0;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.ChatView$bindChatResource$1", f = "ChatView.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ChatView$bindChatResource$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentUIConfig $uiConfig;
    int label;
    final /* synthetic */ ChatView this$0;

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"com/stepos/ailauncher/chat/view/ChatView$bindChatResource$1$a", "Lcom/stepos/agentframework/chatcore/session/AgentSession$f;", "Lcom/stepos/agentframework/chatcore/session/ESessionStatus;", "status", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/session/ESessionStatus;)V", "", "sessionId", "", "Lw4/c;", "messages", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/util/List;)V", "Lcom/stepos/agentframework/chatcore/session/AgentError;", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/agentframework/chatcore/session/AgentError;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements AgentSession.f {
        final /* synthetic */ ChatView this$0;

        public a(ChatView chatView) {
            this.this$0 = chatView;
        }

        @Override // com.stepos.agentframework.chatcore.session.AgentSession.f
        public void a(ESessionStatus status) {
            kotlin.jvm.internal.p.i(status, "status");
            InterfaceC5063a<Y8.t> onSessionSuccess = this.this$0.getOnSessionSuccess();
            if (onSessionSuccess != null) {
                onSessionSuccess.invoke();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
        @Override // com.stepos.agentframework.chatcore.session.AgentSession.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b(java.lang.String r2, java.util.List<w4.ChatMessage> r3) {
            /*
                r1 = this;
                java.lang.String r0 = "sessionId"
                kotlin.jvm.internal.p.i(r2, r0)
                java.lang.String r2 = "messages"
                kotlin.jvm.internal.p.i(r3, r2)
                com.stepos.ailauncher.chat.view.ChatView r2 = r1.this$0
                com.stepos.ailauncher.chat.view.ChatView.V0(r2, r3)
                com.stepos.ailauncher.chat.view.ChatView r2 = r1.this$0
                p9.l r2 = r2.getOnMessageListChanged()
                if (r2 == 0) goto L3c
                boolean r3 = r3.isEmpty()
                if (r3 == 0) goto L34
                com.stepos.ailauncher.chat.view.ChatView r1 = r1.this$0
                com.stepos.agentframework.chatui.ChatMessageAdapter r1 = com.stepos.ailauncher.chat.view.ChatView.H0(r1)
                if (r1 == 0) goto L34
                java.util.List r1 = r1.G()
                if (r1 == 0) goto L34
                boolean r1 = r1.isEmpty()
                r3 = 1
                if (r1 != r3) goto L34
                goto L35
            L34:
                r3 = 0
            L35:
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r3)
                r2.invoke(r1)
            L3c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.ChatView$bindChatResource$1.a.b(java.lang.String, java.util.List):void");
        }

        @Override // com.stepos.agentframework.chatcore.session.AgentSession.f
        public void i(AgentError e10) {
            kotlin.jvm.internal.p.i(e10, "e");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatView$bindChatResource$1(ChatView chatView, AgentUIConfig agentUIConfig, InterfaceC4014c<? super ChatView$bindChatResource$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = chatView;
        this.$uiConfig = agentUIConfig;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ChatView$bindChatResource$1(this.this$0, this.$uiConfig, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ChatView$bindChatResource$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        this.this$0.sessionHandler = AgentConfig.INSTANCE.a().n();
        AgentChatLayout chatLayout = this.this$0.getChatLayout();
        if (chatLayout != null) {
            chatLayout.setAgentUiConfig(this.$uiConfig);
        }
        AgentChatLayout chatLayout2 = this.this$0.getChatLayout();
        if (chatLayout2 != null) {
            chatLayout2.m3(this.this$0.getInputView());
        }
        C2689c0.INSTANCE.a(this.this$0.getInputView());
        AgentChatLayout chatLayout3 = this.this$0.getChatLayout();
        if (chatLayout3 != null) {
            chatLayout3.setEmptyShowEnable(false);
        }
        ChatView chatView = this.this$0;
        SessionHandler sessionHandler = chatView.sessionHandler;
        kotlin.jvm.internal.p.f(sessionHandler);
        chatView.k1(sessionHandler);
        SessionHandler sessionHandler2 = this.this$0.sessionHandler;
        if (sessionHandler2 != null) {
            sessionHandler2.J3(new a(this.this$0));
        }
        AgentChatLayout chatLayout4 = this.this$0.getChatLayout();
        if (chatLayout4 != null) {
            chatLayout4.Y5(false);
        }
        this.this$0.h3();
        return Y8.t.f7040a;
    }
}
