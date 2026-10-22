package com.stepos.agentframework.chatcore.session.list;

import La.H;
import Xa.k;
import Xa.t;
import Xa.u;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.ConversationSessionIds;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatcore.session.M0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u00018\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000b\"\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0013J\u001b\u0010\u0019\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\tJ\r\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u0003J\u0017\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010!\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010\tJ\u0017\u0010'\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b'\u0010\tJ\u0017\u0010(\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010\u001eJ\u000f\u0010)\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010\u0003R\u0014\u0010+\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010,R \u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020.0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R \u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002010-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00100R \u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00100RT\u00106\u001aB\u0012\f\u0012\n 5*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n 5*\u0004\u0018\u00010\r0\r 5* \u0012\f\u0012\n 5*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n 5*\u0004\u0018\u00010\r0\r\u0018\u000104048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R&\u0010=\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020.0<0;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u0002010;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010>RT\u0010@\u001aB\u0012\f\u0012\n 5*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n 5*\u0004\u0018\u00010\r0\r 5* \u0012\f\u0012\n 5*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n 5*\u0004\u0018\u00010\r0\r\u0018\u000104048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u00107R)\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020.0<0A8\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001d\u0010F\u001a\b\u0012\u0004\u0012\u0002010A8\u0006¢\u0006\f\n\u0004\bF\u0010C\u001a\u0004\bG\u0010E¨\u0006H"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/list/SessionActivityTracker;", "", "<init>", "()V", "LY8/t;", "k", "", "sessionId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)V", "c", "", "sessionIds", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "([Ljava/lang/String;)Z", "Lw4/c;", "message", "l", "(Lw4/c;)V", "oldMessageId", "n", "(Lw4/c;Ljava/lang/String;)V", "m", "", "p", "(Ljava/util/Collection;)V", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)Z", "left", "right", "q", "(Ljava/lang/String;Ljava/lang/String;)Z", "r", "(Ljava/lang/String;Lw4/c;)V", "messageId", "f", "s", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "o", "", "IGNORED_CAP", "I", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/agentframework/chatcore/session/list/a;", "activities", "Ljava/util/concurrent/ConcurrentHashMap;", "", "lastUserAtBySession", "lastUserMessageIdBySession", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "retainedSessionIds", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "com/stepos/agentframework/chatcore/session/list/SessionActivityTracker$ignoredMessageIds$1", "ignoredMessageIds", "Lcom/stepos/agentframework/chatcore/session/list/SessionActivityTracker$ignoredMessageIds$1;", "LXa/k;", "", "_snapshots", "LXa/k;", "_roundEpoch", "artifactReedits", "LXa/t;", "snapshots", "LXa/t;", "e", "()LXa/t;", "roundEpoch", Const.INTENT_KEY_UMID, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SessionActivityTracker {
    private static final int IGNORED_CAP = 256;
    private static final k<Long> _roundEpoch;
    private static final k<Map<String, SessionChatActivitySnapshot>> _snapshots;
    private static final ConcurrentHashMap.KeySetView<String, Boolean> artifactReedits;
    private static final t<Long> roundEpoch;
    private static final t<Map<String, SessionChatActivitySnapshot>> snapshots;
    public static final SessionActivityTracker INSTANCE = new SessionActivityTracker();
    private static final ConcurrentHashMap<String, SessionChatActivitySnapshot> activities = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Long> lastUserAtBySession = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> lastUserMessageIdBySession = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> retainedSessionIds = ConcurrentHashMap.newKeySet();
    private static final SessionActivityTracker$ignoredMessageIds$1 ignoredMessageIds = new SessionActivityTracker$ignoredMessageIds$1();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EReplyStatus.values().length];
            try {
                iArr[EReplyStatus.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EReplyStatus.TOOL_EXECUTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EReplyStatus.REPLYING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EReplyStatus.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EReplyStatus.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EReplyStatus.CANCELED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        k<Map<String, SessionChatActivitySnapshot>> kVarA = u.a(kotlin.collections.a.i());
        _snapshots = kVarA;
        k<Long> kVarA2 = u.a(0L);
        _roundEpoch = kVarA2;
        artifactReedits = ConcurrentHashMap.newKeySet();
        snapshots = Xa.d.c(kVarA);
        roundEpoch = Xa.d.c(kVarA2);
    }

    public final void a(String sessionId) {
        p.i(sessionId, "sessionId");
        String string = H.D1(sessionId).toString();
        retainedSessionIds.remove(string);
        lastUserAtBySession.remove(string);
        lastUserMessageIdBySession.remove(string);
        artifactReedits.remove(string);
        if (activities.remove(string) != null) {
            o();
        }
    }

    public final void b() {
        SessionActivityTracker$ignoredMessageIds$1 sessionActivityTracker$ignoredMessageIds$1 = ignoredMessageIds;
        synchronized (sessionActivityTracker$ignoredMessageIds$1) {
            sessionActivityTracker$ignoredMessageIds$1.clear();
            Y8.t tVar = Y8.t.f7040a;
        }
        retainedSessionIds.clear();
        lastUserAtBySession.clear();
        lastUserMessageIdBySession.clear();
        artifactReedits.clear();
        _roundEpoch.setValue(0L);
        ConcurrentHashMap<String, SessionChatActivitySnapshot> concurrentHashMap = activities;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        concurrentHashMap.clear();
        o();
    }

    public final void c(String sessionId) {
        p.i(sessionId, "sessionId");
        String string = H.D1(sessionId).toString();
        if (string.length() == 0) {
            artifactReedits.clear();
        } else {
            artifactReedits.remove(string);
        }
    }

    public final t<Long> d() {
        return roundEpoch;
    }

    public final t<Map<String, SessionChatActivitySnapshot>> e() {
        return snapshots;
    }

    public final void f(String messageId) {
        if (messageId.length() == 0) {
            return;
        }
        SessionActivityTracker$ignoredMessageIds$1 sessionActivityTracker$ignoredMessageIds$1 = ignoredMessageIds;
        synchronized (sessionActivityTracker$ignoredMessageIds$1) {
            sessionActivityTracker$ignoredMessageIds$1.put(messageId, Y8.t.f7040a);
        }
    }

    public final boolean g(String... sessionIds) {
        Object objB;
        p.i(sessionIds, "sessionIds");
        if (artifactReedits.isEmpty()) {
            return false;
        }
        for (String str : sessionIds) {
            String string = H.D1(str).toString();
            if (string.length() != 0) {
                ConcurrentHashMap.KeySetView<String, Boolean> artifactReedits2 = artifactReedits;
                if (artifactReedits2.contains(string)) {
                    return true;
                }
                p.h(artifactReedits2, "artifactReedits");
                if (artifactReedits2 == null || !artifactReedits2.isEmpty()) {
                    Iterator<T> it = artifactReedits2.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        SessionActivityTracker sessionActivityTracker = INSTANCE;
                        p.f(str2);
                        if (sessionActivityTracker.q(string, str2)) {
                            return true;
                        }
                    }
                }
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(ConversationSessionIds.INSTANCE.m(string));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                if (Result.g(objB)) {
                    objB = null;
                }
                String str3 = (String) objB;
                if (str3 != null && !H.x0(str3) && artifactReedits.contains(str3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean h(String messageId) {
        boolean zContainsKey;
        SessionActivityTracker$ignoredMessageIds$1 sessionActivityTracker$ignoredMessageIds$1 = ignoredMessageIds;
        synchronized (sessionActivityTracker$ignoredMessageIds$1) {
            zContainsKey = sessionActivityTracker$ignoredMessageIds$1.containsKey(messageId);
        }
        return zContainsKey;
    }

    public final boolean i(String sessionId) {
        ConcurrentHashMap.KeySetView<String, Boolean> retainedSessionIds2 = retainedSessionIds;
        if (retainedSessionIds2.contains(sessionId)) {
            return true;
        }
        p.h(retainedSessionIds2, "retainedSessionIds");
        if (retainedSessionIds2 != null && retainedSessionIds2.isEmpty()) {
            return false;
        }
        Iterator<T> it = retainedSessionIds2.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            SessionActivityTracker sessionActivityTracker = INSTANCE;
            p.f(str);
            if (sessionActivityTracker.q(str, sessionId)) {
                return true;
            }
        }
        return false;
    }

    public final void j(String sessionId) {
        p.i(sessionId, "sessionId");
        String string = H.D1(sessionId).toString();
        if (string.length() == 0) {
            return;
        }
        ConcurrentHashMap.KeySetView<String, Boolean> keySetView = artifactReedits;
        keySetView.clear();
        keySetView.add(string);
    }

    public final void k() {
        k<Long> kVar = _roundEpoch;
        kVar.setValue(Long.valueOf(kVar.getValue().longValue() + 1));
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(w4.ChatMessage r12) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.list.SessionActivityTracker.l(w4.c):void");
    }

    public final void m(ChatMessage message) {
        ConcurrentHashMap<String, SessionChatActivitySnapshot> concurrentHashMap;
        SessionChatActivitySnapshot sessionChatActivitySnapshot;
        p.i(message, "message");
        if (message.getRole() != AgentRole.ASSISTANT) {
            return;
        }
        String string = H.D1(message.getMessageId()).toString();
        if (string.length() > 0) {
            f(string);
        }
        String string2 = H.D1(message.getSessionId()).toString();
        if (string2.length() == 0 || i(string2) || (sessionChatActivitySnapshot = (concurrentHashMap = activities).get(string2)) == null || !p.d(sessionChatActivitySnapshot.getMessageId(), string) || concurrentHashMap.remove(string2) == null) {
            return;
        }
        o();
    }

    public final void n(ChatMessage message, String oldMessageId) {
        p.i(message, "message");
        p.i(oldMessageId, "oldMessageId");
        String string = H.D1(message.getMessageId()).toString();
        String string2 = H.D1(oldMessageId).toString();
        if (string2.length() > 0 && !p.d(string2, string)) {
            if (string.length() > 0) {
                s(string);
            }
            m(ChatMessage.b(message, string2, null, null, 0L, null, null, 0, 0, null, null, null, null, 0, null, null, null, false, null, null, null, 0, null, 4194302, null));
        }
        l(message);
    }

    public final void o() {
        _snapshots.setValue(new HashMap(activities));
    }

    public final void p(Collection<String> sessionIds) {
        p.i(sessionIds, "sessionIds");
        Collection<String> collection = sessionIds;
        ArrayList arrayList = new ArrayList(C1174w.x(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(H.D1((String) it.next()).toString());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                linkedHashSet.add(obj);
            }
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        linkedHashSet2.addAll(linkedHashSet);
        for (String str : activities.keySet()) {
            p.h(str, "next(...)");
            String str2 = str;
            if (!linkedHashSet.isEmpty()) {
                Iterator it2 = linkedHashSet.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (INSTANCE.q((String) it2.next(), str2)) {
                            linkedHashSet2.add(str2);
                            break;
                        }
                    }
                }
            }
        }
        if (linkedHashSet2.isEmpty()) {
            return;
        }
        Iterator it3 = linkedHashSet2.iterator();
        p.h(it3, "iterator(...)");
        boolean z10 = false;
        while (it3.hasNext()) {
            Object next = it3.next();
            p.h(next, "next(...)");
            String str3 = (String) next;
            retainedSessionIds.add(str3);
            ConcurrentHashMap<String, SessionChatActivitySnapshot> concurrentHashMap = activities;
            SessionChatActivitySnapshot sessionChatActivitySnapshot = concurrentHashMap.get(str3);
            if (sessionChatActivitySnapshot != null) {
                SessionChatPhase phase = sessionChatActivitySnapshot.getPhase();
                SessionChatPhase sessionChatPhase = SessionChatPhase.REPLIED;
                if (phase != sessionChatPhase && sessionChatActivitySnapshot.getPhase() != SessionChatPhase.FAILED) {
                    concurrentHashMap.put(str3, SessionChatActivitySnapshot.b(sessionChatActivitySnapshot, null, sessionChatPhase, System.currentTimeMillis(), "", null, 0L, "", 49, null));
                    z10 = true;
                }
            }
        }
        if (z10) {
            o();
        }
    }

    public final boolean q(String left, String right) {
        if (p.d(left, right)) {
            return true;
        }
        M0 m02 = M0.INSTANCE;
        String strF = m02.f(left);
        if (strF != null) {
            left = strF;
        }
        String strF2 = m02.f(right);
        if (strF2 != null) {
            right = strF2;
        }
        return p.d(left, right);
    }

    public final void r(String sessionId, ChatMessage message) {
        String string = H.D1(message.getMessageId()).toString();
        if (string.length() <= 0 || !p.d(lastUserMessageIdBySession.get(sessionId), string)) {
            Long lValueOf = Long.valueOf(message.getTime());
            if (lValueOf.longValue() <= 0) {
                lValueOf = null;
            }
            long jLongValue = lValueOf != null ? lValueOf.longValue() : System.currentTimeMillis();
            ConcurrentHashMap<String, Long> concurrentHashMap = lastUserAtBySession;
            Long l10 = concurrentHashMap.get(sessionId);
            if (string.length() > 0) {
                lastUserMessageIdBySession.put(sessionId, string);
            }
            if (l10 == null || jLongValue > l10.longValue()) {
                concurrentHashMap.put(sessionId, Long.valueOf(jLongValue));
                ConcurrentHashMap<String, SessionChatActivitySnapshot> concurrentHashMap2 = activities;
                SessionChatActivitySnapshot sessionChatActivitySnapshot = concurrentHashMap2.get(sessionId);
                if (sessionChatActivitySnapshot == null || sessionChatActivitySnapshot.getLastUserMessageAt() == jLongValue) {
                    return;
                }
                concurrentHashMap2.put(sessionId, SessionChatActivitySnapshot.b(sessionChatActivitySnapshot, null, null, 0L, null, null, jLongValue, null, 95, null));
                o();
            }
        }
    }

    public final void s(String messageId) {
        if (messageId.length() == 0) {
            return;
        }
        SessionActivityTracker$ignoredMessageIds$1 sessionActivityTracker$ignoredMessageIds$1 = ignoredMessageIds;
        synchronized (sessionActivityTracker$ignoredMessageIds$1) {
        }
    }
}
