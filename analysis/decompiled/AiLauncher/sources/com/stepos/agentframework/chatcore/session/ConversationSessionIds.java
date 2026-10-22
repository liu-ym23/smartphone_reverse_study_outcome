package com.stepos.agentframework.chatcore.session;

import Ua.C1060i;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import w4.TaskSessionLink;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\bJ\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\bJ\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u000bR\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0014\u0010 \u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u001bR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001bR\u0014\u0010\"\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u001bR\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u001bR \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&RT\u0010)\u001aB\u0012\f\u0012\n (*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n (*\u0004\u0018\u00010\u00060\u0006 (* \u0012\f\u0012\n (*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n (*\u0004\u0018\u00010\u00060\u0006\u0018\u00010'0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/stepos/agentframework/chatcore/session/ConversationSessionIds;", "", "<init>", "()V", "", "sessionId", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)Z", "e", "m", "(Ljava/lang/String;)Ljava/lang/String;", "k", "mapped", "l", "(Ljava/lang/String;Z)Z", Const.INTENT_KEY_UMID, "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "LY8/t;", "c", "(Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "MAIN_SESSION_ID", "Ljava/lang/String;", "MAIN_SESSION_DISPLAY_NAME", "CHANNEL_WECHAT_PREFIX", "CHANNEL_FEISHU_PREFIX", "TASK_AGENT_PREFIX", "CRON_SESSION_PREFIX", "AGENT_PREFIX", "PRIMARY_PREFIX", "WORKSPACE_SUFFIX", "Ljava/util/concurrent/ConcurrentHashMap;", "visibleSessionCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "resolvingIds", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "LUa/M;", "resolveScope", "LUa/M;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConversationSessionIds {
    private static final String AGENT_PREFIX = "agent:";
    public static final String CHANNEL_FEISHU_PREFIX = "agent:main:feishu";
    public static final String CHANNEL_WECHAT_PREFIX = "agent:main:wechat";
    public static final String CRON_SESSION_PREFIX = "cron:";
    public static final String MAIN_SESSION_DISPLAY_NAME = "主会话";
    public static final String MAIN_SESSION_ID = "agent:main:main";
    private static final String PRIMARY_PREFIX = "agent:main:";
    public static final String TASK_AGENT_PREFIX = "agent:task-";
    private static final String WORKSPACE_SUFFIX = ":main";
    public static final ConversationSessionIds INSTANCE = new ConversationSessionIds();
    private static final ConcurrentHashMap<String, String> visibleSessionCache = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> resolvingIds = ConcurrentHashMap.newKeySet();
    private static final Ua.M resolveScope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.b()));

    public final void c(String sessionId) {
        if (resolvingIds.add(sessionId)) {
            C1060i.d(resolveScope, null, null, new ConversationSessionIds$enqueueResolve$1(sessionId, null), 3, null);
        }
    }

    public final boolean d(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        String string = La.H.D1(sessionId).toString();
        return La.D.X(string, AGENT_PREFIX, false, 2, null) && !La.D.X(string, PRIMARY_PREFIX, false, 2, null) && La.D.K(string, WORKSPACE_SUFFIX, false, 2, null);
    }

    public final boolean e(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        return La.D.X(La.H.D1(sessionId).toString(), CRON_SESSION_PREFIX, false, 2, null);
    }

    public final boolean f(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        return h(sessionId) || d(sessionId) || e(sessionId);
    }

    public final boolean g() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Looper.getMainLooper());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Looper looper = (Looper) objB;
        if (looper == null) {
            return false;
        }
        return kotlin.jvm.internal.p.d(Looper.myLooper(), looper);
    }

    public final boolean h(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        return La.D.X(La.H.D1(sessionId).toString(), TASK_AGENT_PREFIX, false, 2, null);
    }

    public final String i() {
        return PRIMARY_PREFIX + O6.m.INSTANCE.c("temp_session_" + System.currentTimeMillis());
    }

    public final String j(String sessionId) {
        Object objB;
        String requestSessionKey;
        String str = visibleSessionCache.get(sessionId);
        if (str != null) {
            return str;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            TaskSessionLink taskSessionLinkB = new x4.x().b(sessionId);
            if (taskSessionLinkB == null || (requestSessionKey = taskSessionLinkB.getRequestSessionKey()) == null || La.H.x0(requestSessionKey)) {
                requestSessionKey = null;
            }
            objB = Result.b(requestSessionKey);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        String str2 = (String) (Result.g(objB) ? null : objB);
        if (str2 == null || La.H.x0(str2)) {
            if (l(sessionId, false)) {
                visibleSessionCache.put(sessionId, sessionId);
            }
            return sessionId;
        }
        if (l(sessionId, true)) {
            visibleSessionCache.put(sessionId, str2);
        }
        return str2;
    }

    public final String k(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (La.H.x0(sessionId)) {
            return sessionId;
        }
        String strF = M0.INSTANCE.f(sessionId);
        if (strF != null) {
            sessionId = strF;
        }
        return (h(sessionId) || e(sessionId)) ? m(sessionId) : sessionId;
    }

    public final boolean l(String sessionId, boolean mapped) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (La.H.x0(sessionId) || e(sessionId)) {
            return false;
        }
        return mapped || !h(sessionId);
    }

    public final String m(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (La.H.x0(sessionId)) {
            return sessionId;
        }
        String str = visibleSessionCache.get(sessionId);
        if (str != null) {
            return str;
        }
        if (!g()) {
            return j(sessionId);
        }
        c(sessionId);
        return sessionId;
    }
}
