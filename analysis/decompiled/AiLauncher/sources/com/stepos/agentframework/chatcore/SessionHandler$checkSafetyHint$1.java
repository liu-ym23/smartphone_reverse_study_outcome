package com.stepos.agentframework.chatcore;

import Ua.M;
import android.os.Handler;
import com.stepos.agentframework.chatcore.safehint.SafeHintClient;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.session.ChatHintType;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;
import u4.AgentMessage;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.SessionHandler$checkSafetyHint$1", f = "SessionHandler.kt", l = {1626}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionHandler$checkSafetyHint$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentSession $currentSession;
    final /* synthetic */ ChatMessage $message;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $modelOutput;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SessionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionHandler$checkSafetyHint$1(AgentSession agentSession, ChatMessage chatMessage, String str, SessionHandler sessionHandler, String str2, InterfaceC4014c<? super SessionHandler$checkSafetyHint$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$currentSession = agentSession;
        this.$message = chatMessage;
        this.$modelOutput = str;
        this.this$0 = sessionHandler;
        this.$messageId = str2;
    }

    public static final CharSequence A(AgentMessage agentMessage) {
        return agentMessage.getContent().h();
    }

    public static final void C(SessionHandler sessionHandler, ChatMessage chatMessage) {
        InterfaceC1848c chatView;
        if (sessionHandler.c1(chatMessage)) {
            return;
        }
        chatMessage.J(ChatHintType.RISK);
        for (AgentMessage agentMessage : chatMessage.i()) {
            String strC = agentMessage.getContent().c();
            if (strC != null && strC.length() > 0) {
                agentMessage.getContent().i("");
            }
        }
        if (!sessionHandler.T3(chatMessage) || (chatView = sessionHandler.getChatView()) == null) {
            return;
        }
        chatView.n(chatMessage, false);
    }

    public static final Ka.j y(ChatMessage chatMessage) {
        return Z8.F.d0(chatMessage.i());
    }

    public static final boolean z(AgentMessage agentMessage) {
        return agentMessage.getType() == AgentMessageType.TEXT;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionHandler$checkSafetyHint$1(this.$currentSession, this.$message, this.$modelOutput, this.this$0, this.$messageId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionHandler$checkSafetyHint$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        x4.f fVar;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            x4.f messageRepository = this.$currentSession.getMessageRepository();
            String string = La.H.D1(SequencesKt___SequencesKt.O(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.L(Z8.F.d0(messageRepository.m(this.$message.getPairId())), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.E
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return SessionHandler$checkSafetyHint$1.y((ChatMessage) obj2);
                }
            }), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.F
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(SessionHandler$checkSafetyHint$1.z((AgentMessage) obj2));
                }
            }), "", null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.G
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return SessionHandler$checkSafetyHint$1.A((AgentMessage) obj2);
                }
            }, 30, null)).toString();
            SafeHintClient safeHintClient = SafeHintClient.INSTANCE;
            String str = this.$modelOutput;
            this.L$0 = messageRepository;
            this.L$1 = g9.h.a(string);
            this.label = 1;
            Object objA = safeHintClient.a(string, str, this);
            if (objA == objG) {
                return objG;
            }
            fVar = messageRepository;
            obj = objA;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fVar = (x4.f) this.L$0;
            C4849c.b(obj);
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        C4148a.k(this.this$0.TAG, "checkSafetyHint messageId:" + this.$messageId + " risky:" + zBooleanValue, false, 4, null);
        if (zBooleanValue) {
            fVar.f(this.$messageId, ChatHintType.RISK);
            Handler handler = this.this$0.mainHandler;
            final SessionHandler sessionHandler = this.this$0;
            final ChatMessage chatMessage = this.$message;
            handler.post(new Runnable() { // from class: com.stepos.agentframework.chatcore.H
                @Override // java.lang.Runnable
                public final void run() {
                    SessionHandler$checkSafetyHint$1.C(sessionHandler, chatMessage);
                }
            });
        }
        return Y8.t.f7040a;
    }
}
