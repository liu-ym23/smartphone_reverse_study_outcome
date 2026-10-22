package com.stepos.ailauncher.chat.view;

import Z8.C1173v;
import android.view.View;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.SessionArtifactSource;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.UnifiedChatHostView$openMoreMenu$1", f = "UnifiedChatHostView.kt", l = {1301}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class UnifiedChatHostView$openMoreMenu$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ View $anchor;
    Object L$0;
    int label;
    final /* synthetic */ UnifiedChatHostView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnifiedChatHostView$openMoreMenu$1(UnifiedChatHostView unifiedChatHostView, View view, InterfaceC4014c<? super UnifiedChatHostView$openMoreMenu$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = unifiedChatHostView;
        this.$anchor = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new UnifiedChatHostView$openMoreMenu$1(this.this$0, this.$anchor, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((UnifiedChatHostView$openMoreMenu$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List listM;
        AgentSession.AgentConversation agentConversationR1;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            SessionHandler sessionHandler = this.this$0.sessionHandler;
            if (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) {
                listM = null;
            } else {
                List listR = C1173v.r(agentConversationR1.getSessionId(), agentConversationR1.getTempSessionId());
                listM = new ArrayList();
                for (Object obj2 : listR) {
                    if (((String) obj2).length() > 0) {
                        listM.add(obj2);
                    }
                }
            }
            if (listM == null) {
                listM = C1173v.m();
            }
            SessionArtifactSource sessionArtifactSource = SessionArtifactSource.INSTANCE;
            this.L$0 = g9.h.a(listM);
            this.label = 1;
            obj = sessionArtifactSource.c(listM, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        SessionArtifactSource.Result result = (SessionArtifactSource.Result) obj;
        if (!this.this$0.isAttachedToWindow()) {
            return Y8.t.f7040a;
        }
        if (!result.b().isEmpty()) {
            ChatTracker.INSTANCE.d(this.this$0.G0());
        }
        this.this$0.moreMenuPopup.g(this.$anchor, result.b(), result.getFileTree());
        return Y8.t.f7040a;
    }
}
