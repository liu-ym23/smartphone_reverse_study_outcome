package com.stepos.core.ability.text;

import android.os.Bundle;
import cb.r;
import com.stepos.core.ability.h;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.data.LlmChatMessage;
import com.stepos.core.data.SessionCommandContent;
import com.stepos.core.data.SessionResultContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.g;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SessionStore {
    private static final int MAX_SESSIONS_PER_UID = 8;
    private static final long PURGE_DELAY_MS = 60000;
    private static final String TAG = "SessionStore";
    public static final SessionStore INSTANCE = new SessionStore();
    private static final ConcurrentHashMap<SessionKey, ServerSession> sessions = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<SessionKey, ScheduledFuture<?>> pendingClose = new ConcurrentHashMap<>();
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2, new f());
    private static final ConcurrentHashMap<SessionKey, Long> lastAccessTime = new ConcurrentHashMap<>();

    private SessionStore() {
    }

    private final void enforceUidSessionLimit(int i10) {
        Object obj;
        Set<SessionKey> setKeySet = sessions.keySet();
        g.e(setKeySet, "<get-keys>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : setKeySet) {
            if (((SessionKey) obj2).getCallerUid() == i10) {
                arrayList.add(obj2);
            }
        }
        if (arrayList.size() >= 8) {
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                if (it.hasNext()) {
                    Long l10 = lastAccessTime.get((SessionKey) next);
                    long jLongValue = l10 != null ? l10.longValue() : 0L;
                    do {
                        Object next2 = it.next();
                        Long l11 = lastAccessTime.get((SessionKey) next2);
                        long jLongValue2 = l11 != null ? l11.longValue() : 0L;
                        if (jLongValue > jLongValue2) {
                            next = next2;
                            jLongValue = jLongValue2;
                        }
                    } while (it.hasNext());
                }
                obj = next;
            } else {
                obj = null;
            }
            SessionKey sessionKey = (SessionKey) obj;
            if (sessionKey != null) {
                AIEngineLogger.w(LogModule.ABILITY, TAG, a0.a.g("UID ", i10, " session limit reached, purging oldest: ", sessionKey.getName()));
                purge(sessionKey.getCallerUid(), sessionKey.getName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ServerSession getOrCreate$lambda$2(int i10, String str, SessionKey it) {
        g.f(it, "it");
        INSTANCE.enforceUidSessionLimit(i10);
        AIEngineLogger.d(LogModule.ABILITY, TAG, a0.a.g("Creating new session: uid=", i10, ", name=", str));
        return new ServerSession(i10, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ServerSession getOrCreate$lambda$3(l lVar, Object obj) {
        return (ServerSession) lVar.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void markPendingClose$lambda$4(SessionKey sessionKey, Ref$ObjectRef ref$ObjectRef, int i10, String str) {
        if (pendingClose.get(sessionKey) == ref$ObjectRef.f10076a) {
            AIEngineLogger.d(LogModule.ABILITY, TAG, "Purging session after 60000ms: " + sessionKey);
            INSTANCE.purge(i10, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread scheduler$lambda$1(Runnable runnable) {
        return com.stepos.core.ota.d.n(runnable, "SessionStore-Purge", true);
    }

    public final void cancelPendingClose(int i10, String name) {
        g.f(name, "name");
        SessionKey sessionKey = new SessionKey(i10, name);
        ScheduledFuture<?> scheduledFutureRemove = pendingClose.remove(sessionKey);
        if (scheduledFutureRemove != null) {
            scheduledFutureRemove.cancel(false);
            AIEngineLogger.d(LogModule.ABILITY, TAG, "Session revived (pending close cancelled): " + sessionKey);
        }
    }

    public final void close(int i10, String name) {
        g.f(name, "name");
        ScheduledFuture<?> scheduledFutureRemove = pendingClose.remove(new SessionKey(i10, name));
        if (scheduledFutureRemove != null) {
            scheduledFutureRemove.cancel(false);
        }
        purge(i10, name);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final Object dispatch(int i10, String action, Object obj) {
        String string;
        ArrayList<String> stringArrayList;
        String string2;
        LlmChatMessage llmChatMessage;
        ArrayList parcelableArrayList;
        String string3;
        g.f(action, "action");
        SessionCommandContent sessionCommandContent = obj instanceof SessionCommandContent ? (SessionCommandContent) obj : null;
        if (sessionCommandContent != null && (string = sessionCommandContent.getPayload().getString(SessionCommandContent.KEY_NAME)) != null) {
            cancelPendingClose(i10, string);
            ServerSession orCreate = getOrCreate(i10, string);
            switch (action.hashCode()) {
                case -2133288201:
                    if (action.equals("session.getAndRemoveHistory")) {
                        LlmChatMessage andRemoveHistory = orCreate.getAndRemoveHistory(sessionCommandContent.getPayload().getInt(SessionCommandContent.KEY_INDEX, -1));
                        Bundle bundle = new Bundle();
                        if (andRemoveHistory != null) {
                            bundle.putParcelable(SessionResultContent.KEY_MESSAGE, andRemoveHistory);
                        }
                        return new SessionResultContent(bundle);
                    }
                    break;
                case -2130119008:
                    if (action.equals("session.embeddedList") && (stringArrayList = sessionCommandContent.getPayload().getStringArrayList(SessionCommandContent.KEY_EMBED_IDS)) != null) {
                        ArrayList arrayListR0 = kotlin.collections.a.r0(orCreate.getEmbeddingList(stringArrayList));
                        Bundle bundle2 = new Bundle();
                        bundle2.putSerializable(SessionResultContent.KEY_FLOAT_ARRAYS, new ArrayList(arrayListR0));
                        return new SessionResultContent(bundle2);
                    }
                    break;
                case -1418803415:
                    if (action.equals("session.calcTokenLen")) {
                        int iCalculateHistoryTokenLength = orCreate.calculateHistoryTokenLength();
                        Bundle bundle3 = new Bundle();
                        bundle3.putInt(SessionResultContent.KEY_INT, iCalculateHistoryTokenLength);
                        return new SessionResultContent(bundle3);
                    }
                    break;
                case -1217231712:
                    if (action.equals("session.close")) {
                        close(i10, string);
                        return new SessionResultContent(new Bundle());
                    }
                    break;
                case -900792668:
                    if (action.equals("session.removeHistoryAfter")) {
                        int iRemoveHistoryAfter = orCreate.removeHistoryAfter(sessionCommandContent.getPayload().getInt(SessionCommandContent.KEY_INDEX, -1));
                        Bundle bundle4 = new Bundle();
                        bundle4.putInt(SessionResultContent.KEY_INT, iRemoveHistoryAfter);
                        return new SessionResultContent(bundle4);
                    }
                    break;
                case -447933726:
                    if (action.equals("session.embedded") && (string2 = sessionCommandContent.getPayload().getString(SessionCommandContent.KEY_EMBED_ID)) != null) {
                        float[] embedding = orCreate.getEmbedding(string2);
                        Bundle bundle5 = new Bundle();
                        if (embedding != null) {
                            bundle5.putFloatArray(SessionResultContent.KEY_FLOAT_ARRAY, embedding);
                        }
                        return new SessionResultContent(bundle5);
                    }
                    break;
                case 1086475485:
                    if (action.equals("session.putHistory") && (llmChatMessage = (LlmChatMessage) sessionCommandContent.getPayload().getParcelable(SessionCommandContent.KEY_MESSAGE)) != null) {
                        int iPutHistory = orCreate.putHistory(llmChatMessage);
                        Bundle bundle6 = new Bundle();
                        bundle6.putInt(SessionResultContent.KEY_INT, iPutHistory);
                        return new SessionResultContent(bundle6);
                    }
                    break;
                case 1258994459:
                    if (action.equals("session.putHistoryList") && (parcelableArrayList = sessionCommandContent.getPayload().getParcelableArrayList(SessionCommandContent.KEY_MESSAGES)) != null) {
                        int iPutHistoryList = orCreate.putHistoryList(parcelableArrayList);
                        Bundle bundle7 = new Bundle();
                        bundle7.putInt(SessionResultContent.KEY_INT, iPutHistoryList);
                        return new SessionResultContent(bundle7);
                    }
                    break;
                case 1362175512:
                    if (action.equals("session.removeHistory")) {
                        boolean zRemoveHistory = orCreate.removeHistory(sessionCommandContent.getPayload().getInt(SessionCommandContent.KEY_INDEX, -1));
                        Bundle bundle8 = new Bundle();
                        bundle8.putBoolean(SessionResultContent.KEY_BOOL, zRemoveHistory);
                        return new SessionResultContent(bundle8);
                    }
                    break;
                case 1393428870:
                    if (action.equals("session.removeEmbedded") && (string3 = sessionCommandContent.getPayload().getString(SessionCommandContent.KEY_EMBED_ID)) != null) {
                        boolean zRemoveEmbedding = orCreate.removeEmbedding(string3);
                        Bundle bundle9 = new Bundle();
                        bundle9.putBoolean(SessionResultContent.KEY_BOOL, zRemoveEmbedding);
                        return new SessionResultContent(bundle9);
                    }
                    break;
                case 1432785375:
                    if (action.equals("session.clearHistory")) {
                        int iClearHistory = orCreate.clearHistory();
                        Bundle bundle10 = new Bundle();
                        bundle10.putInt(SessionResultContent.KEY_INT, iClearHistory);
                        return new SessionResultContent(bundle10);
                    }
                    break;
                case 1709597366:
                    if (action.equals("session.getHistory")) {
                        LlmChatMessage history = orCreate.getHistory(sessionCommandContent.getPayload().getInt(SessionCommandContent.KEY_INDEX, -1));
                        Bundle bundle11 = new Bundle();
                        if (history != null) {
                            bundle11.putParcelable(SessionResultContent.KEY_MESSAGE, history);
                        }
                        return new SessionResultContent(bundle11);
                    }
                    break;
                case 1913535604:
                    if (action.equals("session.getHistoryList")) {
                        List<LlmChatMessage> historyList = orCreate.getHistoryList();
                        Bundle bundle12 = new Bundle();
                        bundle12.putParcelableArrayList(SessionResultContent.KEY_MESSAGES, new ArrayList<>(historyList));
                        return new SessionResultContent(bundle12);
                    }
                    break;
                case 1913744343:
                    if (action.equals("session.getHistorySize")) {
                        int historySize = orCreate.getHistorySize();
                        Bundle bundle13 = new Bundle();
                        bundle13.putInt(SessionResultContent.KEY_INT, historySize);
                        return new SessionResultContent(bundle13);
                    }
                    break;
            }
        }
        return null;
    }

    public final ServerSession getOrCreate(int i10, String name) {
        g.f(name, "name");
        SessionKey sessionKey = new SessionKey(i10, name);
        cancelPendingClose(i10, name);
        lastAccessTime.put(sessionKey, Long.valueOf(System.currentTimeMillis()));
        ServerSession serverSessionComputeIfAbsent = sessions.computeIfAbsent(sessionKey, new h(new e(i10, name), 1));
        g.e(serverSessionComputeIfAbsent, "computeIfAbsent(...)");
        return serverSessionComputeIfAbsent;
    }

    public final int getSessionCount() {
        return sessions.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [T, java.lang.Object, java.util.concurrent.ScheduledFuture] */
    public final void markPendingClose(int i10, String name) {
        g.f(name, "name");
        SessionKey sessionKey = new SessionKey(i10, name);
        ConcurrentHashMap<SessionKey, ScheduledFuture<?>> concurrentHashMap = pendingClose;
        if (concurrentHashMap.containsKey(sessionKey)) {
            AIEngineLogger.d(LogModule.ABILITY, TAG, "Session already pending close: " + sessionKey);
            return;
        }
        AIEngineLogger.d(LogModule.ABILITY, TAG, "Marking session for delayed purge: " + sessionKey);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? Schedule = scheduler.schedule(new r(sessionKey, ref$ObjectRef, i10, name), 60000L, TimeUnit.MILLISECONDS);
        ref$ObjectRef.f10076a = Schedule;
        concurrentHashMap.put(sessionKey, Schedule);
    }

    public final void purge(int i10, String name) {
        g.f(name, "name");
        SessionKey sessionKey = new SessionKey(i10, name);
        if (sessions.remove(sessionKey) != null) {
            lastAccessTime.remove(sessionKey);
            pendingClose.remove(sessionKey);
            AIEngineLogger.d(LogModule.ABILITY, TAG, "Session purged: " + sessionKey);
            ChatAbility.Companion.onSessionPurged(i10, name);
        }
    }
}
