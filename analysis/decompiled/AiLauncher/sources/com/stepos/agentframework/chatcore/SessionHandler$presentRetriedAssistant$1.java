package com.stepos.agentframework.chatcore;

import Ua.M;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.SessionHandler$presentRetriedAssistant$1", f = "SessionHandler.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionHandler$presentRetriedAssistant$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ ChatMessage $assistant;
    final /* synthetic */ AgentSession $currentSession;
    final /* synthetic */ String $logPrefix;
    final /* synthetic */ String $outboundId;
    final /* synthetic */ String $pulledText;
    final /* synthetic */ int $resumeFrom;
    final /* synthetic */ boolean $resumeInbound;
    final /* synthetic */ String $shownText;
    final /* synthetic */ String $sid;
    int label;
    final /* synthetic */ SessionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionHandler$presentRetriedAssistant$1(SessionHandler sessionHandler, ChatMessage chatMessage, boolean z10, String str, AgentSession agentSession, String str2, String str3, String str4, String str5, int i10, InterfaceC4014c<? super SessionHandler$presentRetriedAssistant$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = sessionHandler;
        this.$assistant = chatMessage;
        this.$resumeInbound = z10;
        this.$outboundId = str;
        this.$currentSession = agentSession;
        this.$sid = str2;
        this.$logPrefix = str3;
        this.$shownText = str4;
        this.$pulledText = str5;
        this.$resumeFrom = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionHandler$presentRetriedAssistant$1(this.this$0, this.$assistant, this.$resumeInbound, this.$outboundId, this.$currentSession, this.$sid, this.$logPrefix, this.$shownText, this.$pulledText, this.$resumeFrom, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionHandler$presentRetriedAssistant$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        InterfaceC1848c chatView = this.this$0.getChatView();
        if (chatView != null) {
            InterfaceC1848c.j(chatView, null, 1, null);
        }
        InterfaceC1848c chatView2 = this.this$0.getChatView();
        if (chatView2 != null) {
            chatView2.X(this.$assistant.getMessageId());
        }
        if (!this.$resumeInbound || this.$outboundId.length() <= 0) {
            this.this$0.p3(this.$assistant, this.$resumeFrom);
        } else {
            this.$assistant.U(EReplyStatus.REPLYING);
            InterfaceC1848c chatView3 = this.this$0.getChatView();
            if (chatView3 != null) {
                chatView3.r(this.$assistant);
            }
            boolean zM2 = this.$currentSession.m2(this.$sid, this.$outboundId, this.$assistant);
            C4148a.k(this.this$0.TAG, this.$logPrefix + " resume inbound outboundId=" + this.$outboundId + " resumed=" + zM2 + " shown=" + this.$shownText.length() + " pulled=" + this.$pulledText.length(), false, 4, null);
            if (!zM2) {
                if (this.$resumeFrom < this.this$0.P0(this.$assistant).length()) {
                    this.this$0.p3(this.$assistant, this.$resumeFrom);
                } else {
                    this.$assistant.U(EReplyStatus.COMPLETED);
                    InterfaceC1848c chatView4 = this.this$0.getChatView();
                    if (chatView4 != null) {
                        chatView4.r(this.$assistant);
                    }
                }
            }
        }
        return Y8.t.f7040a;
    }
}
