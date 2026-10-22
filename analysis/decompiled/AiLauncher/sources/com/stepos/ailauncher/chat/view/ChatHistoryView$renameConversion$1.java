package com.stepos.ailauncher.chat.view;

import android.widget.Toast;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.audit.ContentAuditClient;
import com.stepos.agentframework.chatcore.audit.g;
import com.stepos.ailauncher.chat.R$string;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.ChatHistoryView$renameConversion$1", f = "ChatHistoryView.kt", l = {621}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ChatHistoryView$renameConversion$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $newTitle;
    final /* synthetic */ String $sessionId;
    int label;
    final /* synthetic */ ChatHistoryView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryView$renameConversion$1(ChatHistoryView chatHistoryView, String str, String str2, InterfaceC4014c<? super ChatHistoryView$renameConversion$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = chatHistoryView;
        this.$newTitle = str;
        this.$sessionId = str2;
    }

    public static final Y8.t i(final ChatHistoryView chatHistoryView, boolean z10) {
        ChatHistoryView.k1(chatHistoryView, "", false, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.U3
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatHistoryView$renameConversion$1.n(chatHistoryView);
            }
        }, 2, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t n(ChatHistoryView chatHistoryView) {
        chatHistoryView.i1();
        return Y8.t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ChatHistoryView$renameConversion$1(this.this$0, this.$newTitle, this.$sessionId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ChatHistoryView$renameConversion$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            ContentAuditClient contentAuditClient = ContentAuditClient.INSTANCE;
            String agentId = this.this$0.sessionHandler.getConfiguration().getSessionConfig().getAgentId();
            String str = this.$newTitle;
            this.label = 1;
            obj = contentAuditClient.g(agentId, str, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        if (kotlin.jvm.internal.p.d(((com.stepos.agentframework.chatcore.audit.g) obj).a(), g.a.INSTANCE)) {
            this.this$0.i1();
            Toast.makeText(this.this$0.getContext(), R$string.chat_history_rename_save_failed, 0).show();
            return Y8.t.f7040a;
        }
        SessionHandler sessionHandler = this.this$0.sessionHandler;
        String str2 = this.$sessionId;
        String str3 = this.$newTitle;
        final ChatHistoryView chatHistoryView = this.this$0;
        sessionHandler.l3(str2, str3, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.T3
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return ChatHistoryView$renameConversion$1.i(chatHistoryView, ((Boolean) obj2).booleanValue());
            }
        });
        return Y8.t.f7040a;
    }
}
