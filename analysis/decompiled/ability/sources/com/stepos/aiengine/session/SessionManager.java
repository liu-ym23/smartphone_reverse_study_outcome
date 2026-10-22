package com.stepos.aiengine.session;

import D7.v;
import android.os.Bundle;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.dsl.a;
import com.stepos.aiengine.algorithm.chat.IChatSession;
import com.stepos.core.c;
import com.stepos.core.data.SessionCommandContent;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/aiengine/session/SessionManager;", "", "", HintConstants.AUTOFILL_HINT_NAME, "Lcom/stepos/core/c;", "handle", "Lcom/stepos/aiengine/algorithm/chat/IChatSession;", "getOrCreate", "(Ljava/lang/String;Lcom/stepos/core/c;)Lcom/stepos/aiengine/algorithm/chat/IChatSession;", "", "close", "(Ljava/lang/String;)Z", "", "listNames", "()Ljava/util/List;", "", "clearAll", "()I", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SessionManager {
    public static final SessionManager INSTANCE = new SessionManager();

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f3534a = new ConcurrentHashMap();

    public final int clearAll() {
        ConcurrentHashMap concurrentHashMap = f3534a;
        int size = concurrentHashMap.size();
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            String str = (String) entry.getKey();
            ChatSessionAdapter chatSessionAdapter = (ChatSessionAdapter) entry.getValue();
            try {
                Bundle bundle = new Bundle();
                bundle.putString(SessionCommandContent.KEY_NAME, str);
                chatSessionAdapter.getB().c("session.close", new SessionCommandContent(bundle));
            } catch (Exception unused) {
            }
        }
        concurrentHashMap.clear();
        return size;
    }

    public final boolean close(String name) {
        k.f(name, "name");
        ChatSessionAdapter chatSessionAdapter = (ChatSessionAdapter) f3534a.remove(name);
        if (chatSessionAdapter == null) {
            return false;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString(SessionCommandContent.KEY_NAME, name);
            chatSessionAdapter.getB().c("session.close", new SessionCommandContent(bundle));
            return true;
        } catch (Exception e) {
            a.w("Failed to notify server close: ", e.getMessage(), "SessionManager");
            return true;
        }
    }

    public final IChatSession getOrCreate(String name, c handle) {
        k.f(name, "name");
        k.f(handle, "handle");
        ConcurrentHashMap concurrentHashMap = f3534a;
        ChatSessionAdapter chatSessionAdapter = (ChatSessionAdapter) concurrentHashMap.get(name);
        if (chatSessionAdapter != null && chatSessionAdapter.getB() == handle) {
            return chatSessionAdapter;
        }
        ChatSessionAdapter chatSessionAdapter2 = new ChatSessionAdapter(name, handle);
        concurrentHashMap.put(name, chatSessionAdapter2);
        return chatSessionAdapter2;
    }

    public final List<String> listNames() {
        Set setKeySet = f3534a.keySet();
        k.e(setKeySet, "<get-keys>(...)");
        return v.f1(setKeySet);
    }
}
