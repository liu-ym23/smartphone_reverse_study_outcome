package com.stepos.aiengine.session;

import Z8.F;
import android.os.Bundle;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.chat.IChatSession;
import com.stepos.core.AbilityHandle;
import com.stepos.core.data.SessionCommandContent;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/aiengine/session/SessionManager;", "", "<init>", "()V", "", "name", "Lcom/stepos/core/AbilityHandle;", "handle", "Lcom/stepos/aiengine/algorithm/chat/IChatSession;", "getOrCreate", "(Ljava/lang/String;Lcom/stepos/core/AbilityHandle;)Lcom/stepos/aiengine/algorithm/chat/IChatSession;", "", "close", "(Ljava/lang/String;)Z", "", "listNames", "()Ljava/util/List;", "", "clearAll", "()I", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/aiengine/session/ChatSessionAdapter;", Const.INTENT_KEY_APIKEY, "Ljava/util/concurrent/ConcurrentHashMap;", "sessions", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SessionManager {
    public static final SessionManager INSTANCE = new SessionManager();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final ConcurrentHashMap<String, ChatSessionAdapter> sessions = new ConcurrentHashMap<>();

    public final int clearAll() {
        ConcurrentHashMap<String, ChatSessionAdapter> concurrentHashMap = sessions;
        int size = concurrentHashMap.size();
        for (Map.Entry<String, ChatSessionAdapter> entry : concurrentHashMap.entrySet()) {
            String key = entry.getKey();
            ChatSessionAdapter value = entry.getValue();
            try {
                Bundle bundle = new Bundle();
                bundle.putString(SessionCommandContent.KEY_NAME, key);
                value.getHandle().execute("session.close", new SessionCommandContent(bundle));
            } catch (Exception unused) {
            }
        }
        sessions.clear();
        return size;
    }

    public final boolean close(String name) {
        p.i(name, "name");
        ChatSessionAdapter chatSessionAdapterRemove = sessions.remove(name);
        if (chatSessionAdapterRemove == null) {
            return false;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString(SessionCommandContent.KEY_NAME, name);
            chatSessionAdapterRemove.getHandle().execute("session.close", new SessionCommandContent(bundle));
            return true;
        } catch (Exception e10) {
            Log.w("SessionManager", "Failed to notify server close: " + e10.getMessage());
            return true;
        }
    }

    public final IChatSession getOrCreate(String name, AbilityHandle handle) {
        p.i(name, "name");
        p.i(handle, "handle");
        ConcurrentHashMap<String, ChatSessionAdapter> concurrentHashMap = sessions;
        ChatSessionAdapter chatSessionAdapter = concurrentHashMap.get(name);
        if (chatSessionAdapter != null && chatSessionAdapter.getHandle() == handle) {
            return chatSessionAdapter;
        }
        ChatSessionAdapter chatSessionAdapter2 = new ChatSessionAdapter(name, handle);
        concurrentHashMap.put(name, chatSessionAdapter2);
        return chatSessionAdapter2;
    }

    public final List<String> listNames() {
        Set<String> setKeySet = sessions.keySet();
        p.h(setKeySet, "<get-keys>(...)");
        return F.m1(setKeySet);
    }
}
