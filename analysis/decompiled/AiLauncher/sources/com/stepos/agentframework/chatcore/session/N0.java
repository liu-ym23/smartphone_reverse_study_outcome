package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/N0;", "", "<init>", "()V", "key", "Lcom/stepos/agentframework/chatcore/session/N0$a;", "listener", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;Lcom/stepos/agentframework/chatcore/session/N0$a;)V", "", "sessionId", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "listeners", "Ljava/util/concurrent/ConcurrentHashMap;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class N0 {
    public static final N0 INSTANCE = new N0();
    private static final ConcurrentHashMap<Object, a> listeners = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/N0$a;", "", "", "sessionId", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        void a(String sessionId);
    }

    public final void a(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        String string = La.H.D1(sessionId).toString();
        if (string.length() == 0) {
            return;
        }
        for (a aVar : listeners.values()) {
            kotlin.jvm.internal.p.h(aVar, "next(...)");
            aVar.a(string);
        }
    }

    public final void b(Object key, a listener) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(listener, "listener");
        listeners.put(key, listener);
    }
}
