package com.stepos.ailauncher.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.view.ChatView;
import kotlin.C4848b;
import kotlin.Metadata;
import net.sqlcipher.database.SQLiteDatabase;
import p9.InterfaceC5063a;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/chat/AgentChatActivity;", "Lz5/a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/stepos/ailauncher/chat/view/ChatView;", "agentChatView$delegate", "LY8/h;", "u", "()Lcom/stepos/ailauncher/chat/view/ChatView;", "agentChatView", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentChatActivity extends ActivityC6361a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: agentChatView$delegate, reason: from kotlin metadata */
    private final Y8.h agentChatView = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return AgentChatActivity.t(this.f24696a);
        }
    });

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/chat/AgentChatActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.AgentChatActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) AgentChatActivity.class);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
        }

        public Companion() {
        }
    }

    public static final ChatView t(AgentChatActivity agentChatActivity) {
        return (ChatView) agentChatActivity.findViewById(R$id.agentChatView);
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R$layout.activity_agent_chat);
        u().setFullScreenModel(true);
        InputViewManager.INSTANCE.D0();
    }

    public final ChatView u() {
        Object value = this.agentChatView.getValue();
        kotlin.jvm.internal.p.h(value, "getValue(...)");
        return (ChatView) value;
    }
}
