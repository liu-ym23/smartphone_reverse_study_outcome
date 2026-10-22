package com.stepos.core.ability.session;

import ai.onnxruntime.a;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SessionRegistry {
    private static final String TAG = "SessionRegistry";
    public static final SessionRegistry INSTANCE = new SessionRegistry();
    private static final ConcurrentHashMap<String, ChatSessionImpl> sessions = new ConcurrentHashMap<>();

    private SessionRegistry() {
    }

    public final void closeAllByUid(int i10) {
        List<ChatSessionImpl> byUid = getByUid(i10);
        for (ChatSessionImpl chatSessionImpl : byUid) {
            chatSessionImpl.close();
            sessions.remove(chatSessionImpl.getSessionId());
        }
        if (byUid.isEmpty()) {
            return;
        }
        Log.i(TAG, "Closed " + byUid.size() + " sessions for uid=" + i10);
    }

    public final ChatSessionImpl get(String sessionId) {
        g.f(sessionId, "sessionId");
        return sessions.get(sessionId);
    }

    public final List<String> getAllSessionIds() {
        Enumeration<String> enumerationKeys = sessions.keys();
        g.e(enumerationKeys, "keys(...)");
        ArrayList list = Collections.list(enumerationKeys);
        g.e(list, "list(...)");
        return list;
    }

    public final List<ChatSessionImpl> getByUid(int i10) {
        Collection<ChatSessionImpl> collectionValues = sessions.values();
        g.e(collectionValues, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((ChatSessionImpl) obj).getCallerUid() == i10) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final void register(ChatSessionImpl session) {
        g.f(session, "session");
        String sessionId = session.getSessionId();
        ConcurrentHashMap<String, ChatSessionImpl> concurrentHashMap = sessions;
        concurrentHashMap.put(sessionId, session);
        Log.d(TAG, a.i("Session registered: ", concurrentHashMap.size(), sessionId, " (total=", ")"));
    }

    public final int size() {
        return sessions.size();
    }

    public final ChatSessionImpl unregister(String sessionId) {
        g.f(sessionId, "sessionId");
        ConcurrentHashMap<String, ChatSessionImpl> concurrentHashMap = sessions;
        ChatSessionImpl chatSessionImplRemove = concurrentHashMap.remove(sessionId);
        if (chatSessionImplRemove != null) {
            Log.d(TAG, a.i("Session unregistered: ", concurrentHashMap.size(), sessionId, " (total=", ")"));
        }
        return chatSessionImplRemove;
    }
}
