package com.stepos.agentframework.chatcore.session;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Function2;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import u4.AgentMessage;
import w4.ChatMessage;
import w4.TaskSessionLink;

@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004*\u00015\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u001d\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\u001e\u001a\u00020\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ/\u0010 \u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0017J\u001f\u0010#\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010&R\u0014\u0010)\u001a\u00020(8\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010*R(\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u00068"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/CronSessionBinder;", "", "<init>", "()V", "LY8/t;", "f", "", "sessionId", "Lw4/c;", "message", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Lw4/c;)V", "agentId", "", "Lcom/stepos/agentframework/chatcore/intent/e;", "tools", "k", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "cronSessionId", "m", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;", "jobId", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Ljava/lang/String;", "", "e", "(Ljava/lang/String;)Z", "", "jobIds", "parentSessionId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/Collection;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_UMID, "c", "(Ljava/lang/String;Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "JOB_KEY_PREFIX", "", "PARENT_CACHE_CAP", "I", "Lkotlin/Function0;", "Lx4/g;", "repositoryProvider", "Lp9/a;", "getRepositoryProvider", "()Lp9/a;", "setRepositoryProvider", "(Lp9/a;)V", "parentCacheLock", "Ljava/lang/Object;", "com/stepos/agentframework/chatcore/session/CronSessionBinder$parentCache$1", "parentCache", "Lcom/stepos/agentframework/chatcore/session/CronSessionBinder$parentCache$1;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CronSessionBinder {
    private static final String JOB_KEY_PREFIX = "cron-job:";
    private static final int PARENT_CACHE_CAP = 32;
    private static final String TAG = "CronSessionBinder";
    public static final CronSessionBinder INSTANCE = new CronSessionBinder();
    private static volatile InterfaceC5063a<? extends x4.g> repositoryProvider = new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.T
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return CronSessionBinder.l();
        }
    };
    private static final Object parentCacheLock = new Object();
    private static final CronSessionBinder$parentCache$1 parentCache = new CronSessionBinder$parentCache$1();

    public static final x4.x l() {
        return new x4.x();
    }

    public final void c(String cronSessionId, String parentSessionId) {
        synchronized (parentCacheLock) {
            parentCache.put(cronSessionId, parentSessionId);
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    public final String d(String cronSessionId) {
        String str;
        synchronized (parentCacheLock) {
            str = (String) parentCache.get(cronSessionId);
        }
        return str;
    }

    public final boolean e(String sessionId) {
        if (La.H.x0(sessionId)) {
            return false;
        }
        ConversationSessionIds conversationSessionIds = ConversationSessionIds.INSTANCE;
        return (conversationSessionIds.e(sessionId) || conversationSessionIds.f(sessionId)) ? false : true;
    }

    public final void f() {
        synchronized (parentCacheLock) {
            parentCache.clear();
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    public final String g(String jobId) {
        kotlin.jvm.internal.p.i(jobId, "jobId");
        return JOB_KEY_PREFIX + jobId;
    }

    public final void h(String cronSessionId, String parentSessionId, String jobId, String agentId) {
        c(cronSessionId, parentSessionId);
        C4148a.k(TAG, "bind cron session=" + cronSessionId + " parent=" + parentSessionId + " job=" + jobId + " agentId=" + agentId, false, 4, null);
    }

    public final void i(Collection<String> jobIds, String parentSessionId, String agentId) {
        x4.g gVarInvoke = repositoryProvider.invoke();
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (String str : jobIds) {
            String str2 = parentSessionId;
            String str3 = agentId;
            gVarInvoke.c(new TaskSessionLink(g(str), str2, str, str3, jCurrentTimeMillis, jCurrentTimeMillis));
            C4148a.k(TAG, "remember cron job=" + str + " parent=" + str2, false, 4, null);
            parentSessionId = str2;
            agentId = str3;
        }
    }

    public final void j(String sessionId, ChatMessage message) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(message, "message");
        if (e(sessionId)) {
            S s10 = S.INSTANCE;
            List<AgentMessage> listI = message.i();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listI.iterator();
            while (it.hasNext()) {
                List<AgentTool> listG = ((AgentMessage) it.next()).g();
                if (listG == null) {
                    listG = C1173v.m();
                }
                Z8.A.E(arrayList, listG);
            }
            List<String> listD = s10.d(arrayList);
            if (listD.isEmpty()) {
                return;
            }
            Function2.c(new CronSessionBinder$rememberFromMessageAsync$1(listD, sessionId, message.getAgentId(), null));
        }
    }

    public final void k(String sessionId, String agentId, List<AgentTool> tools) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(tools, "tools");
        if (e(sessionId)) {
            List<String> listD = S.INSTANCE.d(tools);
            if (listD.isEmpty()) {
                return;
            }
            i(listD, sessionId, agentId);
        }
    }

    public final String m(String cronSessionId, String agentId, List<AgentTool> tools) {
        String requestSessionKey;
        String requestSessionKey2;
        String requestSessionKey3;
        kotlin.jvm.internal.p.i(cronSessionId, "cronSessionId");
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(tools, "tools");
        if (!ConversationSessionIds.INSTANCE.e(cronSessionId)) {
            return null;
        }
        String strD = d(cronSessionId);
        if (strD != null) {
            return strD;
        }
        x4.g gVarInvoke = repositoryProvider.invoke();
        TaskSessionLink taskSessionLinkB = gVarInvoke.b(cronSessionId);
        if (taskSessionLinkB != null && (requestSessionKey3 = taskSessionLinkB.getRequestSessionKey()) != null) {
            if (La.H.x0(requestSessionKey3)) {
                requestSessionKey3 = null;
            }
            if (requestSessionKey3 != null) {
                INSTANCE.c(cronSessionId, requestSessionKey3);
                return requestSessionKey3;
            }
        }
        List<String> listD = S.INSTANCE.d(tools);
        for (String str : listD) {
            TaskSessionLink taskSessionLinkB2 = gVarInvoke.b(g(str));
            if (taskSessionLinkB2 == null || (requestSessionKey2 = taskSessionLinkB2.getRequestSessionKey()) == null || La.H.x0(requestSessionKey2)) {
                requestSessionKey2 = null;
            }
            if (requestSessionKey2 != null && !La.H.x0(requestSessionKey2)) {
                h(cronSessionId, requestSessionKey2, str, agentId);
                return requestSessionKey2;
            }
        }
        TaskSessionLink taskSessionLinkD = gVarInvoke.d();
        if (taskSessionLinkD != null && (requestSessionKey = taskSessionLinkD.getRequestSessionKey()) != null) {
            if (La.H.x0(requestSessionKey)) {
                requestSessionKey = null;
            }
            if (requestSessionKey != null) {
                if (listD.isEmpty()) {
                    C4148a.u(TAG, "cron session has no jobId, fallback to latest job cronSid=" + cronSessionId + " parent=" + requestSessionKey + " taskId=" + taskSessionLinkD.getTaskId(), false, 4, null);
                }
                h(cronSessionId, requestSessionKey, taskSessionLinkD.getTaskId(), agentId);
                return requestSessionKey;
            }
        }
        return null;
    }
}
