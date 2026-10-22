package com.stepos.ailauncher.chat.manager;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentSession;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\bR \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/l;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/agentframework/chatcore/SessionHandler;)V", "", "sessionId", "e", "(Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/SessionHandler;", Const.INTENT_KEY_UMID, "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()I", "target", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "handlers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.manager.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2706l {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<C2706l> instance$delegate = C4848b.a(LazyThreadSafetyMode.SYNCHRONIZED, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.manager.j
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return C2706l.f();
        }
    });
    private final CopyOnWriteArrayList<WeakReference<SessionHandler>> handlers = new CopyOnWriteArrayList<>();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/l$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/manager/l;", "instance$delegate", "LY8/h;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/manager/l;", "instance", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.manager.l$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final C2706l a() {
            return (C2706l) C2706l.instance$delegate.getValue();
        }

        public Companion() {
        }
    }

    public static final C2706l f() {
        return new C2706l();
    }

    public static final boolean h(SessionHandler sessionHandler, WeakReference weakReference) {
        SessionHandler sessionHandler2 = (SessionHandler) weakReference.get();
        return sessionHandler2 == null || sessionHandler2 == sessionHandler;
    }

    public final SessionHandler d(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        SessionHandler sessionHandler = null;
        if (sessionId.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<WeakReference<SessionHandler>> it = this.handlers.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            WeakReference<SessionHandler> next = it.next();
            SessionHandler sessionHandler2 = next.get();
            if (sessionHandler2 == null) {
                kotlin.jvm.internal.p.f(next);
                arrayList.add(next);
            } else {
                AgentSession.AgentConversation agentConversationR1 = sessionHandler2.R1();
                if (agentConversationR1 != null && (kotlin.jvm.internal.p.d(agentConversationR1.getSessionId(), sessionId) || kotlin.jvm.internal.p.d(agentConversationR1.getTempSessionId(), sessionId))) {
                    sessionHandler = sessionHandler2;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.handlers.removeAll(arrayList);
        }
        return sessionHandler;
    }

    public final SessionHandler e(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (sessionId.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<WeakReference<SessionHandler>> it = this.handlers.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        SessionHandler sessionHandler = null;
        while (it.hasNext()) {
            WeakReference<SessionHandler> next = it.next();
            SessionHandler sessionHandler2 = next.get();
            if (sessionHandler2 == null) {
                kotlin.jvm.internal.p.f(next);
                arrayList.add(next);
            } else {
                AgentSession.AgentConversation agentConversationR1 = sessionHandler2.R1();
                if (!kotlin.jvm.internal.p.d(agentConversationR1 != null ? agentConversationR1.getSessionId() : null, sessionId)) {
                    if (!kotlin.jvm.internal.p.d(agentConversationR1 != null ? agentConversationR1.getTempSessionId() : null, sessionId) && !sessionHandler2.i2(sessionId)) {
                    }
                }
                sessionHandler = sessionHandler2;
            }
        }
        if (!arrayList.isEmpty()) {
            this.handlers.removeAll(arrayList);
        }
        return sessionHandler;
    }

    public final void g(final SessionHandler target) {
        Z8.A.L(this.handlers, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(C2706l.h(target, (WeakReference) obj));
            }
        });
    }

    public final void i(SessionHandler handler) {
        kotlin.jvm.internal.p.i(handler, "handler");
        g(handler);
        this.handlers.add(new WeakReference<>(handler));
    }

    public final int j() {
        Iterator<WeakReference<SessionHandler>> it = this.handlers.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().get() != null) {
                i10++;
            }
        }
        return i10;
    }
}
