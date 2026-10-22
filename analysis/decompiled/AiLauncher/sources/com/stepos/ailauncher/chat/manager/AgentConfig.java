package com.stepos.ailauncher.chat.manager;

import Ua.C1062j;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.Configuration;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.C1963x;
import com.stepos.ailauncher.chat.input.ChatStopActions;
import com.stepos.ailauncher.chat.wake.WakeDialogImpl;
import e9.InterfaceC4014c;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 22\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\tJ\u0010\u0010\f\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\f\u0010\u0006J\r\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u0003J\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\tJ\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0012\u0010\tJ\r\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\tJ\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0017\u0010\u0010J\u001d\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u001f\u0010\u0006J\u0010\u0010 \u001a\u00020\u0007H\u0082@¢\u0006\u0004\b \u0010\u0006J\u0017\u0010!\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010\u0010R$\u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010.\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00070/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/AgentConfig;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/Configuration;", "l", "(Le9/c;)Ljava/lang/Object;", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "n", "()Lcom/stepos/agentframework/chatcore/SessionHandler;", "t", "LY8/t;", "u", "v", "handler", "x", "(Lcom/stepos/agentframework/chatcore/SessionHandler;)V", "q", "s", "m", "", "p", "(Lcom/stepos/agentframework/chatcore/SessionHandler;)Z", "w", "", "sessionId", "y", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/SessionHandler;)V", "allowInterrupted", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(ZLjava/lang/String;)Lcom/stepos/agentframework/chatcore/SessionHandler;", "k", "r", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/agentframework/chatcore/SessionHandler;)Lcom/stepos/agentframework/chatcore/SessionHandler;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "agentConfig", "Lcom/stepos/agentframework/chatcore/Configuration;", "getAgentConfig", "()Lcom/stepos/agentframework/chatcore/Configuration;", "setAgentConfig", "(Lcom/stepos/agentframework/chatcore/Configuration;)V", "handlerLock", "Ljava/lang/Object;", "sessionHandler", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "agentSpaceHandler", "Lcom/stepos/ailauncher/chat/manager/M0;", "pendingChatSessions", "Lcom/stepos/ailauncher/chat/manager/M0;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<AgentConfig> instance$delegate = C4848b.a(LazyThreadSafetyMode.SYNCHRONIZED, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.manager.c
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return AgentConfig.o();
        }
    });
    private Configuration agentConfig;
    private volatile SessionHandler agentSpaceHandler;
    private final Object handlerLock = new Object();
    private final M0<SessionHandler> pendingChatSessions = new M0<>();
    private volatile SessionHandler sessionHandler;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/AgentConfig$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/manager/AgentConfig;", "instance$delegate", "LY8/h;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/manager/AgentConfig;", "instance", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.manager.AgentConfig$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final AgentConfig a() {
            return (AgentConfig) AgentConfig.instance$delegate.getValue();
        }

        public Companion() {
        }
    }

    public static /* synthetic */ SessionHandler j(AgentConfig agentConfig, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        return agentConfig.i(z10, str);
    }

    public static final AgentConfig o() {
        return new AgentConfig();
    }

    public final SessionHandler g(SessionHandler handler) {
        ChatStopActions.INSTANCE.c(handler);
        return handler;
    }

    public final void h(SessionHandler handler) {
        C2706l.INSTANCE.a().i(handler);
    }

    public final SessionHandler i(boolean allowInterrupted, String sessionId) {
        return this.pendingChatSessions.a(allowInterrupted, sessionId);
    }

    public final Object k(InterfaceC4014c<? super SessionHandler> interfaceC4014c) {
        return r(interfaceC4014c);
    }

    public final Object l(InterfaceC4014c<? super Configuration> interfaceC4014c) {
        Configuration configuration = this.agentConfig;
        if (configuration != null) {
            return configuration;
        }
        Configuration configurationB = Configuration.INSTANCE.a("agent_bus").a(C1963x.AGENT_TYPE_AGENTBUS).c(true).b();
        this.agentConfig = configurationB;
        return configurationB;
    }

    public final SessionHandler m() {
        SessionHandler sessionHandler;
        SessionHandler sessionHandler2 = this.agentSpaceHandler;
        if (sessionHandler2 != null) {
            return sessionHandler2;
        }
        synchronized (this.handlerLock) {
            sessionHandler = this.agentSpaceHandler;
            if (sessionHandler == null) {
                Object objB = C1062j.b(null, new AgentConfig$getOrCreateAgentSpaceSessionHandler$2$1(this, null), 1, null);
                this.agentSpaceHandler = (SessionHandler) objB;
                sessionHandler = (SessionHandler) objB;
            }
        }
        return sessionHandler;
    }

    public final SessionHandler n() {
        SessionHandler sessionHandler;
        SessionHandler sessionHandler2 = this.sessionHandler;
        if (sessionHandler2 != null) {
            return sessionHandler2;
        }
        synchronized (this.handlerLock) {
            sessionHandler = this.sessionHandler;
            if (sessionHandler == null) {
                Object objB = C1062j.b(null, new AgentConfig$getSessionHandler$2$1(this, null), 1, null);
                this.sessionHandler = (SessionHandler) objB;
                sessionHandler = (SessionHandler) objB;
            }
        }
        return sessionHandler;
    }

    public final boolean p(SessionHandler handler) {
        kotlin.jvm.internal.p.i(handler, "handler");
        return handler == this.sessionHandler || handler == this.agentSpaceHandler;
    }

    public final SessionHandler q() {
        return (SessionHandler) C1062j.b(null, new AgentConfig$newFloatSessionHandler$1(this, null), 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(e9.InterfaceC4014c<? super com.stepos.agentframework.chatcore.SessionHandler> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.ailauncher.chat.manager.AgentConfig$newSessionHandler$1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.ailauncher.chat.manager.AgentConfig$newSessionHandler$1 r0 = (com.stepos.ailauncher.chat.manager.AgentConfig$newSessionHandler$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.manager.AgentConfig$newSessionHandler$1 r0 = new com.stepos.ailauncher.chat.manager.AgentConfig$newSessionHandler$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            com.stepos.ailauncher.chat.manager.AgentConfig r4 = (com.stepos.ailauncher.chat.manager.AgentConfig) r4
            kotlin.C4849c.b(r5)
            goto L43
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.l(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            com.stepos.agentframework.chatcore.Configuration r5 = (com.stepos.agentframework.chatcore.Configuration) r5
            com.stepos.agentframework.chatcore.SessionHandler r0 = new com.stepos.agentframework.chatcore.SessionHandler
            r0.<init>(r5)
            com.stepos.agentframework.chatcore.SessionHandler r4 = r4.g(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.manager.AgentConfig.r(e9.c):java.lang.Object");
    }

    /* renamed from: s, reason: from getter */
    public final SessionHandler getAgentSpaceHandler() {
        return this.agentSpaceHandler;
    }

    /* renamed from: t, reason: from getter */
    public final SessionHandler getSessionHandler() {
        return this.sessionHandler;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(e9.InterfaceC4014c<? super Y8.t> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.ailauncher.chat.manager.AgentConfig$prefetchSessionHandler$1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.ailauncher.chat.manager.AgentConfig$prefetchSessionHandler$1 r0 = (com.stepos.ailauncher.chat.manager.AgentConfig$prefetchSessionHandler$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.manager.AgentConfig$prefetchSessionHandler$1 r0 = new com.stepos.ailauncher.chat.manager.AgentConfig$prefetchSessionHandler$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L44
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            com.stepos.agentframework.chatcore.SessionHandler r5 = r4.sessionHandler
            if (r5 == 0) goto L3b
            Y8.t r4 = Y8.t.f7040a
            return r4
        L3b:
            r0.label = r3
            java.lang.Object r5 = r4.r(r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            com.stepos.agentframework.chatcore.SessionHandler r5 = (com.stepos.agentframework.chatcore.SessionHandler) r5
            java.lang.Object r0 = r4.handlerLock
            monitor-enter(r0)
            com.stepos.agentframework.chatcore.SessionHandler r1 = r4.sessionHandler     // Catch: java.lang.Throwable -> L50
            if (r1 != 0) goto L52
            r4.sessionHandler = r5     // Catch: java.lang.Throwable -> L50
            goto L53
        L50:
            r4 = move-exception
            goto L6e
        L52:
            r3 = 0
        L53:
            monitor-exit(r0)
            if (r3 != 0) goto L6b
            kotlin.Result$a r4 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L61
            r5.d3()     // Catch: java.lang.Throwable -> L61
            Y8.t r4 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L61
            kotlin.Result.b(r4)     // Catch: java.lang.Throwable -> L61
            goto L6b
        L61:
            r4 = move-exception
            kotlin.Result$a r5 = kotlin.Result.INSTANCE
            java.lang.Object r4 = kotlin.C4849c.a(r4)
            kotlin.Result.b(r4)
        L6b:
            Y8.t r4 = Y8.t.f7040a
            return r4
        L6e:
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.manager.AgentConfig.u(e9.c):java.lang.Object");
    }

    public final void v() {
        SessionHandler sessionHandler;
        Object objB;
        if (WakeDialogImpl.Companion.e() || com.stepos.ailauncher.chat.lockscreen.B.INSTANCE.f()) {
            return;
        }
        synchronized (this.handlerLock) {
            sessionHandler = this.sessionHandler;
            this.sessionHandler = null;
        }
        if (sessionHandler != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                sessionHandler.m1();
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Result.a(objB);
        }
    }

    public final void w(SessionHandler handler) {
        this.pendingChatSessions.b(handler);
    }

    public final void x(SessionHandler handler) {
        kotlin.jvm.internal.p.i(handler, "handler");
        synchronized (this.handlerLock) {
            this.sessionHandler = handler;
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    public final void y(String sessionId, SessionHandler handler) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(handler, "handler");
        this.pendingChatSessions.c(sessionId, handler);
    }
}
