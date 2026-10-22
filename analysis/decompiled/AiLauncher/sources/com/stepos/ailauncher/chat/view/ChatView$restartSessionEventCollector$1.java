package com.stepos.ailauncher.chat.view;

import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatui.ChatMessageAdapter;
import com.stepos.ailauncher.chat.manager.R0;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.ChatView$restartSessionEventCollector$1", f = "ChatView.kt", l = {1170}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ChatView$restartSessionEventCollector$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ ChatView this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        final /* synthetic */ ChatView this$0;

        public a(ChatView chatView) {
            this.this$0 = chatView;
        }

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(R0.a aVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            InterfaceC5074l<Boolean, Y8.t> onMessageListChanged;
            List<com.stepos.agentframework.chatui.S1> listG;
            AgentSession.AgentConversation agentConversationR1;
            if (aVar instanceof R0.a.Cleared) {
                String sessionId = ((R0.a.Cleared) aVar).getSessionId();
                SessionHandler sessionHandler = this.this$0.sessionHandler;
                if (kotlin.jvm.internal.p.d(sessionId, (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) ? null : agentConversationR1.B()) && (onMessageListChanged = this.this$0.getOnMessageListChanged()) != null) {
                    ChatMessageAdapter chatMessageAdapter = this.this$0.chatMessageAdapter;
                    boolean z10 = false;
                    if (chatMessageAdapter != null && (listG = chatMessageAdapter.G()) != null && listG.isEmpty()) {
                        z10 = true;
                    }
                    onMessageListChanged.invoke(C4109a.a(z10));
                }
            }
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatView$restartSessionEventCollector$1(ChatView chatView, InterfaceC4014c<? super ChatView$restartSessionEventCollector$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = chatView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ChatView$restartSessionEventCollector$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ChatView$restartSessionEventCollector$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.o<R0.a> oVarA = com.stepos.ailauncher.chat.manager.R0.INSTANCE.a();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (oVarA.collect(aVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
