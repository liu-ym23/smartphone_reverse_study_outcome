package com.stepos.agentframework.chatui;

import android.app.UiModeManager;
import android.os.Bundle;
import android.view.C1398p;
import android.view.View;
import android.view.WindowInsetsController;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.chatcore.session.AgentError;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.session.ESessionStatus;
import com.stepos.agentframework.chatui.AbstractActivityC2019j;
import com.stepos.agentframework.chatui.history.DefaultDrawerContent;
import h8.C4148a;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import w4.ChatMessage;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentframework/chatui/AgentChatActivity;", "Lcom/stepos/agentframework/chatui/j;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "J", "e0", "", "TAG", "Ljava/lang/String;", "Lcom/stepos/agentframework/chatui/history/i;", "drawerContent", "Lcom/stepos/agentframework/chatui/history/i;", "Lcom/stepos/agentframework/chatui/j$a;", "_agentChatConfig", "Lcom/stepos/agentframework/chatui/j$a;", "x", "()Lcom/stepos/agentframework/chatui/j$a;", "agentChatConfig", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentChatActivity extends AbstractActivityC2019j {
    private final String TAG = "AgentChatActivity";
    private final AbstractActivityC2019j.AgentChatConfig _agentChatConfig = new AbstractActivityC2019j.AgentChatConfig(R$layout.activity_agent_chat_drawer, true, Integer.valueOf(R$layout.drawer_navigation_content), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.b
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return AgentChatActivity.b0(this.f22860a, (View) obj);
        }
    }, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.c
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return AgentChatActivity.d0(this.f22866a);
        }
    }, null, 32, null);
    private com.stepos.agentframework.chatui.history.i drawerContent;

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"com/stepos/agentframework/chatui/AgentChatActivity$b", "Lcom/stepos/agentframework/chatcore/session/AgentSession$f;", "Lcom/stepos/agentframework/chatcore/session/ESessionStatus;", "status", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/session/ESessionStatus;)V", "", "sessionId", "", "Lw4/c;", "messages", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/util/List;)V", "Lcom/stepos/agentframework/chatcore/session/AgentError;", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/agentframework/chatcore/session/AgentError;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements AgentSession.f {
        @Override // com.stepos.agentframework.chatcore.session.AgentSession.f
        public void a(ESessionStatus status) {
            kotlin.jvm.internal.p.i(status, "status");
        }

        @Override // com.stepos.agentframework.chatcore.session.AgentSession.f
        public void b(String sessionId, List<ChatMessage> messages) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            kotlin.jvm.internal.p.i(messages, "messages");
            C4148a.d("TAG", "onLoadMessages: " + sessionId, false, 4, null);
        }

        @Override // com.stepos.agentframework.chatcore.session.AgentSession.f
        public void i(AgentError e10) {
            kotlin.jvm.internal.p.i(e10, "e");
        }
    }

    public static final Y8.t b0(final AgentChatActivity agentChatActivity, View it) {
        kotlin.jvm.internal.p.i(it, "it");
        DefaultDrawerContent defaultDrawerContent = new DefaultDrawerContent(C1398p.a(agentChatActivity));
        defaultDrawerContent.u(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentChatActivity.c0(this.f22871a);
            }
        });
        defaultDrawerContent.r(it, agentChatActivity.D());
        agentChatActivity.drawerContent = defaultDrawerContent;
        return Y8.t.f7040a;
    }

    public static final Y8.t c0(AgentChatActivity agentChatActivity) {
        AbstractActivityC2019j.c drawerHelper = agentChatActivity.getDrawerHelper();
        if (drawerHelper != null) {
            drawerHelper.c();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t d0(AgentChatActivity agentChatActivity) {
        com.stepos.agentframework.chatui.history.i iVar = agentChatActivity.drawerContent;
        if (iVar != null) {
            iVar.a("");
        }
        return Y8.t.f7040a;
    }

    @Override // com.stepos.agentframework.chatui.AbstractActivityC2019j
    public void J() {
        D().J3(new b());
    }

    public final void e0() {
        androidx.core.view.Y.b(getWindow(), false);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        getWindow().setNavigationBarContrastEnforced(false);
        UiModeManager uiModeManager = (UiModeManager) androidx.core.content.a.i(this, UiModeManager.class);
        if (uiModeManager != null) {
            boolean z10 = uiModeManager.getNightMode() == 2;
            WindowInsetsController insetsController = getWindow().getInsetsController();
            kotlin.jvm.internal.p.f(insetsController);
            insetsController.setSystemBarsAppearance(z10 ? 0 : 8, 8);
            insetsController.setSystemBarsAppearance(z10 ? 0 : 16, 16);
        }
    }

    @Override // com.stepos.agentframework.chatui.AbstractActivityC2019j, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        e0();
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.k();
        }
    }

    @Override // com.stepos.agentframework.chatui.AbstractActivityC2019j
    /* renamed from: x, reason: from getter */
    public AbstractActivityC2019j.AgentChatConfig get_agentChatConfig() {
        return this._agentChatConfig;
    }
}
