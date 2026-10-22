package com.stepos.ailauncher.chat.controller;

import Ua.C1060i;
import Z8.C1174w;
import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.ailauncher.chat.adapter.SessionItem;
import com.stepos.ailauncher.chat.view.ChatView;
import h8.C4148a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0007*\u0002\u001e!\u0018\u0000 $2\u00020\u0001:\u0002%&B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\fJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\fJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/ActiveConversationManager;", "", "Lcom/stepos/ailauncher/chat/view/ChatView;", "chatView", "<init>", "(Lcom/stepos/ailauncher/chat/view/ChatView;)V", "Lcom/stepos/ailauncher/chat/controller/ActiveConversationManager$b;", "listener", "LY8/t;", "n", "(Lcom/stepos/ailauncher/chat/controller/ActiveConversationManager$b;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()V", "m", "l", "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "o", "p", "Lcom/stepos/ailauncher/chat/view/ChatView;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "debouncedFetch", "Ljava/lang/Runnable;", "LUa/M;", "scope", "LUa/M;", "Lcom/stepos/ailauncher/chat/controller/ActiveConversationManager$b;", "com/stepos/ailauncher/chat/controller/ActiveConversationManager$d", "conversationListCallback", "Lcom/stepos/ailauncher/chat/controller/ActiveConversationManager$d;", "com/stepos/ailauncher/chat/controller/ActiveConversationManager$c", "activeConversationCallback", "Lcom/stepos/ailauncher/chat/controller/ActiveConversationManager$c;", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ActiveConversationManager {
    private static final long REFRESH_DEBOUNCE_MS = 200;
    private static final long REFRESH_INTERVAL = 1800000;
    private static final String TAG = "AILauncher-ActiveConversationManager";
    private final c activeConversationCallback;
    private final ChatView chatView;
    private final d conversationListCallback;
    private final Runnable debouncedFetch;
    private b listener;
    private final Handler mainHandler;
    private Ua.M scope;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/ActiveConversationManager$b;", "", "", "Lcom/stepos/ailauncher/chat/adapter/U;", "sessions", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface b {
        void a(List<SessionItem> sessions);
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/controller/ActiveConversationManager$c", "Lcom/stepos/agentframework/chatcore/session/AgentSession$b;", "", "Lw4/e;", "titles", "LY8/t;", "onResult", "(Ljava/util/List;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements AgentSession.b {
        public c() {
        }

        @Override // com.stepos.agentframework.chatcore.session.AgentSession.b
        public void onResult(List<w4.e> titles) {
            kotlin.jvm.internal.p.i(titles, "titles");
            C4148a.d(ActiveConversationManager.TAG, "fetchActiveConversations onResult: " + titles.size() + " 条", false, 4, null);
            List<w4.e> list = titles;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            for (w4.e eVar : list) {
                arrayList.add(new SessionItem(eVar.getSessionId(), eVar.getTitle()));
            }
            b bVar = ActiveConversationManager.this.listener;
            if (bVar != null) {
                bVar.a(arrayList);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/controller/ActiveConversationManager$d", "Lcom/stepos/agentframework/chatcore/session/Z;", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements com.stepos.agentframework.chatcore.session.Z {
        public d() {
        }

        @Override // com.stepos.agentframework.chatcore.session.Z
        public void a() {
            C4148a.d(ActiveConversationManager.TAG, "onChanged: 活跃会话列表变更，触发刷新", false, 4, null);
            ActiveConversationManager.this.mainHandler.removeCallbacks(ActiveConversationManager.this.debouncedFetch);
            ActiveConversationManager.this.mainHandler.postDelayed(ActiveConversationManager.this.debouncedFetch, 200L);
        }
    }

    public ActiveConversationManager(ChatView chatView) {
        kotlin.jvm.internal.p.i(chatView, "chatView");
        this.chatView = chatView;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.debouncedFetch = new Runnable() { // from class: com.stepos.ailauncher.chat.controller.b
            @Override // java.lang.Runnable
            public final void run() {
                ActiveConversationManager.g(this.f25050a);
            }
        };
        this.conversationListCallback = new d();
        this.activeConversationCallback = new c();
    }

    public static final void g(ActiveConversationManager activeConversationManager) {
        activeConversationManager.h();
    }

    public static final Y8.t j(ActiveConversationManager activeConversationManager) {
        C4148a.d(TAG, "init, onSessionSuccess", false, 4, null);
        activeConversationManager.chatView.setActiveConversationsChangedListener(activeConversationManager.conversationListCallback);
        activeConversationManager.m();
        return Y8.t.f7040a;
    }

    public final void h() {
        C4148a.d(TAG, "fetchActiveConversations, chatView:" + this.chatView, false, 4, null);
        this.chatView.f2(this.activeConversationCallback);
    }

    public final void i() {
        C4148a.d(TAG, "init", false, 4, null);
        this.chatView.setOnSessionSuccess(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ActiveConversationManager.j(this.f25047a);
            }
        });
    }

    public final void k() {
        C4148a.d(TAG, "onDestroy", false, 4, null);
        p();
        this.mainHandler.removeCallbacks(this.debouncedFetch);
        this.listener = null;
    }

    public final void l() {
        C4148a.d(TAG, "onPause", false, 4, null);
        p();
    }

    public final void m() {
        C4148a.d(TAG, "onResume", false, 4, null);
        h();
        o();
    }

    public final void n(b listener) {
        this.listener = listener;
    }

    public final void o() {
        p();
        Ua.M mA = kotlinx.coroutines.d.a(Ua.Y.c().plus(Ua.L0.b(null, 1, null)));
        C1060i.d(mA, null, null, new ActiveConversationManager$startPeriodicRefresh$1$1(this, null), 3, null);
        this.scope = mA;
    }

    public final void p() {
        Ua.M m10 = this.scope;
        if (m10 != null) {
            kotlinx.coroutines.d.e(m10, null, 1, null);
        }
        this.scope = null;
    }
}
