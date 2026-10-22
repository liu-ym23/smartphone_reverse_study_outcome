package com.stepos.ailauncher.chat.view.sla;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentSession;
import h8.C4148a;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0006\u001a\b\u0018\u00010\u0004R\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u000e\u0012\b\u0012\u00060\u0004R\u00020\u0005\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/chat/view/sla/q;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;", "Lcom/stepos/agentframework/chatcore/session/AgentSession;", "conversation", "", "sessionId", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/SessionHandler;)Ljava/lang/Integer;", "", "persisted", "LY8/t;", "c", "(ZLjava/lang/String;Lcom/stepos/agentframework/chatcore/SessionHandler;)V", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "lock", "Ljava/lang/Object;", "Ljava/lang/ref/WeakReference;", "convRef", "Ljava/lang/ref/WeakReference;", "currentKey", "knownRounds", "I", "pendingRound", "Ljava/lang/Integer;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class q {
    private static final String TAG = "SlaRoundCounter";
    private static WeakReference<AgentSession.AgentConversation> convRef;
    private static int knownRounds;
    private static Integer pendingRound;
    public static final q INSTANCE = new q();
    private static final Object lock = new Object();
    private static String currentKey = "";

    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Integer a(com.stepos.agentframework.chatcore.session.AgentSession.AgentConversation r8, java.lang.String r9, com.stepos.agentframework.chatcore.SessionHandler r10) {
        /*
            r7 = this;
            java.lang.String r7 = "sessionId"
            kotlin.jvm.internal.p.i(r9, r7)
            java.lang.String r7 = "handler"
            kotlin.jvm.internal.p.i(r10, r7)
            int r7 = r9.length()
            r10 = 0
            if (r7 != 0) goto L13
            return r10
        L13:
            java.lang.Object r7 = com.stepos.ailauncher.chat.view.sla.q.lock
            monitor-enter(r7)
            r0 = 0
            if (r8 == 0) goto L2c
            java.lang.ref.WeakReference<com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation> r1 = com.stepos.ailauncher.chat.view.sla.q.convRef     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L27
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Throwable -> L24
            com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation r1 = (com.stepos.agentframework.chatcore.session.AgentSession.AgentConversation) r1     // Catch: java.lang.Throwable -> L24
            goto L28
        L24:
            r8 = move-exception
            goto Lb7
        L27:
            r1 = r10
        L28:
            if (r1 != r8) goto L2c
            r1 = 1
            goto L2d
        L2c:
            r1 = r0
        L2d:
            java.lang.String r2 = com.stepos.ailauncher.chat.view.sla.q.currentKey     // Catch: java.lang.Throwable -> L24
            boolean r2 = kotlin.jvm.internal.p.d(r2, r9)     // Catch: java.lang.Throwable -> L24
            if (r2 != 0) goto L88
            r2 = 4
            if (r1 == 0) goto L66
            java.lang.String r1 = "SlaRoundCounter"
            java.lang.String r3 = com.stepos.ailauncher.chat.view.sla.q.currentKey     // Catch: java.lang.Throwable -> L24
            int r4 = com.stepos.ailauncher.chat.view.sla.q.knownRounds     // Catch: java.lang.Throwable -> L24
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L24
            r5.<init>()     // Catch: java.lang.Throwable -> L24
            java.lang.String r6 = "session key 迁移 "
            r5.append(r6)     // Catch: java.lang.Throwable -> L24
            r5.append(r3)     // Catch: java.lang.Throwable -> L24
            java.lang.String r3 = " -> "
            r5.append(r3)     // Catch: java.lang.Throwable -> L24
            r5.append(r9)     // Catch: java.lang.Throwable -> L24
            java.lang.String r3 = ", 沿用轮次基线 known="
            r5.append(r3)     // Catch: java.lang.Throwable -> L24
            r5.append(r4)     // Catch: java.lang.Throwable -> L24
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L24
            h8.C4148a.k(r1, r3, r0, r2, r10)     // Catch: java.lang.Throwable -> L24
            com.stepos.ailauncher.chat.view.sla.q.currentKey = r9     // Catch: java.lang.Throwable -> L24
            goto L88
        L66:
            com.stepos.ailauncher.chat.view.sla.q.currentKey = r9     // Catch: java.lang.Throwable -> L24
            com.stepos.ailauncher.chat.view.sla.q.knownRounds = r0     // Catch: java.lang.Throwable -> L24
            com.stepos.ailauncher.chat.view.sla.q.pendingRound = r10     // Catch: java.lang.Throwable -> L24
            java.lang.String r1 = "SlaRoundCounter"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L24
            r3.<init>()     // Catch: java.lang.Throwable -> L24
            java.lang.String r4 = "切到会话 "
            r3.append(r4)     // Catch: java.lang.Throwable -> L24
            r3.append(r9)     // Catch: java.lang.Throwable -> L24
            java.lang.String r9 = ", 轮次从 1 起算"
            r3.append(r9)     // Catch: java.lang.Throwable -> L24
            java.lang.String r9 = r3.toString()     // Catch: java.lang.Throwable -> L24
            h8.C4148a.k(r1, r9, r0, r2, r10)     // Catch: java.lang.Throwable -> L24
        L88:
            if (r8 == 0) goto L9e
            java.lang.ref.WeakReference<com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation> r9 = com.stepos.ailauncher.chat.view.sla.q.convRef     // Catch: java.lang.Throwable -> L24
            if (r9 == 0) goto L95
            java.lang.Object r9 = r9.get()     // Catch: java.lang.Throwable -> L24
            r10 = r9
            com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation r10 = (com.stepos.agentframework.chatcore.session.AgentSession.AgentConversation) r10     // Catch: java.lang.Throwable -> L24
        L95:
            if (r10 == r8) goto L9e
            java.lang.ref.WeakReference r9 = new java.lang.ref.WeakReference     // Catch: java.lang.Throwable -> L24
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L24
            com.stepos.ailauncher.chat.view.sla.q.convRef = r9     // Catch: java.lang.Throwable -> L24
        L9e:
            java.lang.Integer r8 = com.stepos.ailauncher.chat.view.sla.q.pendingRound     // Catch: java.lang.Throwable -> L24
            if (r8 == 0) goto La7
            int r8 = r8.intValue()     // Catch: java.lang.Throwable -> L24
            goto La9
        La7:
            int r8 = com.stepos.ailauncher.chat.view.sla.q.knownRounds     // Catch: java.lang.Throwable -> L24
        La9:
            int r9 = r8 + 1
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L24
            com.stepos.ailauncher.chat.view.sla.q.pendingRound = r9     // Catch: java.lang.Throwable -> L24
            monitor-exit(r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            return r7
        Lb7:
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.sla.q.a(com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation, java.lang.String, com.stepos.agentframework.chatcore.SessionHandler):java.lang.Integer");
    }

    public final void b(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (sessionId.length() == 0) {
            return;
        }
        synchronized (lock) {
            if (kotlin.jvm.internal.p.d(currentKey, sessionId)) {
                return;
            }
            C4148a.k(TAG, "切到会话 " + sessionId + ", 轮次从 1 起算 (原 " + currentKey + "/" + knownRounds + ")", false, 4, null);
            currentKey = sessionId;
            convRef = null;
            knownRounds = 0;
            pendingRound = null;
            t tVar = t.f7040a;
        }
    }

    public final void c(boolean persisted, String sessionId, SessionHandler handler) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(handler, "handler");
        synchronized (lock) {
            try {
                if (kotlin.jvm.internal.p.d(currentKey, sessionId)) {
                    Integer num = pendingRound;
                    pendingRound = null;
                    if (persisted && num != null && num.intValue() > knownRounds) {
                        knownRounds = num.intValue();
                    }
                    t tVar = t.f7040a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
