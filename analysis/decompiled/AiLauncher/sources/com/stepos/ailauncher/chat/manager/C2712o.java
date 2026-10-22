package com.stepos.ailauncher.chat.manager;

import Z8.C1173v;
import Z8.C1174w;
import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.AgentSession;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001 \bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/o;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", "", "", "sessionIds", "", "e", "(Lcom/stepos/agentframework/chatcore/SessionHandler;Ljava/util/Collection;)Z", "reason", "LY8/t;", "f", "(Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "", "IDLE_POLL_MS", "J", "HOLD_TIMEOUT_MS", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "held", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "", "aliases", "Ljava/util/List;", "finishing", "Z", "com/stepos/ailauncher/chat/manager/o$b", "idlePoll", "Lcom/stepos/ailauncher/chat/manager/o$b;", "Ljava/lang/Runnable;", "timeout", "Ljava/lang/Runnable;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.manager.o, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2712o {
    private static final long HOLD_TIMEOUT_MS = 180000;
    private static final long IDLE_POLL_MS = 1000;
    private static final String TAG = "ArtifactOutgoingRoundKeeper";
    private static boolean finishing;
    private static volatile SessionHandler held;
    public static final C2712o INSTANCE = new C2712o();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static List<String> aliases = C1173v.m();
    private static final b idlePoll = new b();
    private static final Runnable timeout = new Runnable() { // from class: com.stepos.ailauncher.chat.manager.n
        @Override // java.lang.Runnable
        public final void run() {
            C2712o.g();
        }
    };

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/manager/o$a", "Lcom/stepos/agentframework/chatcore/session/AgentSession$g;", "Lw4/c;", "message", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lw4/c;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.manager.o$a */
    public static final class a implements AgentSession.g {
        @Override // com.stepos.agentframework.chatcore.session.AgentSession.g
        public void a(ChatMessage message) {
            kotlin.jvm.internal.p.i(message, "message");
            if (message.getRole() == AgentRole.ASSISTANT && message.getStatus().isTerminal()) {
                C2712o.INSTANCE.f("assistant-terminal");
            }
        }

        @Override // com.stepos.agentframework.chatcore.session.AgentSession.g
        public /* bridge */ void b(boolean z10, Integer num, String str) {
            super.b(z10, num, str);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/manager/o$b", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.manager.o$b */
    public static final class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            SessionHandler sessionHandler = C2712o.held;
            if (sessionHandler == null) {
                return;
            }
            if (sessionHandler.Y1()) {
                C2712o.mainHandler.postDelayed(this, 1000L);
            } else {
                C2712o.INSTANCE.f("idle");
            }
        }
    }

    public static final boolean e(SessionHandler handler, Collection<String> sessionIds) {
        kotlin.jvm.internal.p.i(handler, "handler");
        kotlin.jvm.internal.p.i(sessionIds, "sessionIds");
        Collection<String> collection = sessionIds;
        ArrayList arrayList = new ArrayList(C1174w.x(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(La.H.D1((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        List<String> listG0 = Z8.F.g0(arrayList2);
        if (listG0.isEmpty() || !handler.Y1()) {
            return false;
        }
        if (held != null) {
            INSTANCE.f("replace");
        }
        held = handler;
        aliases = listG0;
        finishing = false;
        handler.L3(new a());
        Q0.l(listG0);
        Handler handler2 = mainHandler;
        handler2.postDelayed(idlePoll, 1000L);
        handler2.postDelayed(timeout, 180000L);
        C4148a.k(TAG, "adopt aliases=" + listG0, false, 4, null);
        return true;
    }

    public static final void g() {
        INSTANCE.f("timeout");
    }

    public final void f(String reason) {
        Object objB;
        if (finishing) {
            return;
        }
        finishing = true;
        C4148a.k(TAG, "finish reason=" + reason + " aliases=" + aliases, false, 4, null);
        if (!aliases.isEmpty()) {
            Q0.n(aliases);
        }
        Handler handler = mainHandler;
        handler.removeCallbacks(idlePoll);
        handler.removeCallbacks(timeout);
        SessionHandler sessionHandler = held;
        held = null;
        aliases = C1173v.m();
        if (sessionHandler != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                sessionHandler.d3();
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t(TAG, "release held handler failed", thE, false, 8, null);
            }
        }
    }
}
