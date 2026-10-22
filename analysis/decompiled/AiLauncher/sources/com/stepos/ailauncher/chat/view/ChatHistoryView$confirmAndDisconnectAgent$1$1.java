package com.stepos.ailauncher.chat.view;

import Ua.C1056g;
import android.widget.Toast;
import com.stepos.ailauncher.chat.R$string;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.ChatHistoryView$confirmAndDisconnectAgent$1$1", f = "ChatHistoryView.kt", l = {1290}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ChatHistoryView$confirmAndDisconnectAgent$1$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ SidebarAgentItem $agent;
    int label;
    final /* synthetic */ ChatHistoryView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryView$confirmAndDisconnectAgent$1$1(ChatHistoryView chatHistoryView, SidebarAgentItem sidebarAgentItem, InterfaceC4014c<? super ChatHistoryView$confirmAndDisconnectAgent$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = chatHistoryView;
        this.$agent = sidebarAgentItem;
    }

    public static final Y8.t h(ChatHistoryView chatHistoryView) {
        chatHistoryView.i1();
        return Y8.t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ChatHistoryView$confirmAndDisconnectAgent$1$1(this.this$0, this.$agent, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ChatHistoryView$confirmAndDisconnectAgent$1$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Ua.I iB = Ua.Y.b();
            ChatHistoryView$confirmAndDisconnectAgent$1$1$ok$1 chatHistoryView$confirmAndDisconnectAgent$1$1$ok$1 = new ChatHistoryView$confirmAndDisconnectAgent$1$1$ok$1(this.$agent, null);
            this.label = 1;
            obj = C1056g.j(iB, chatHistoryView$confirmAndDisconnectAgent$1$1$ok$1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        Toast.makeText(this.this$0.getContext(), ((Boolean) obj).booleanValue() ? R$string.sidebar_agent_disconnect_done : R$string.sidebar_agent_disconnect_failed, 0).show();
        final ChatHistoryView chatHistoryView = this.this$0;
        chatHistoryView.p1(true, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.P3
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatHistoryView$confirmAndDisconnectAgent$1$1.h(chatHistoryView);
            }
        });
        return Y8.t.f7040a;
    }
}
