package com.stepos.agentframework.adapter.netcore;

import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/w;", "", "<init>", "()V", "key", "Lcom/stepos/agentframework/adapter/netcore/w$a;", "listener", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;Lcom/stepos/agentframework/adapter/netcore/w$a;)V", "c", "(Ljava/lang/Object;)V", "Lcom/stepos/agentframework/adapter/netcore/v;", "event", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/adapter/netcore/v;)V", "", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "listeners", "Ljava/util/concurrent/ConcurrentHashMap;", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class w {
    private static final String TAG = "SessionUpdateEventBus";
    public static final w INSTANCE = new w();
    private static final ConcurrentHashMap<Object, a> listeners = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/w$a;", "", "Lcom/stepos/agentframework/adapter/netcore/v;", "event", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/adapter/netcore/v;)V", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        void a(SessionUpdate event);
    }

    public static final void a(SessionUpdate event) {
        Object objB;
        kotlin.jvm.internal.p.i(event, "event");
        String sessionId = event.getSessionId();
        String label = event.getLabel();
        String runId = event.getRunId();
        Long seq = event.getSeq();
        ConcurrentHashMap<Object, a> concurrentHashMap = listeners;
        C4148a.k(TAG, "emit sessionId=" + sessionId + " label='" + label + "' runId=" + runId + " seq=" + seq + " listeners=" + concurrentHashMap.size(), false, 4, null);
        for (a aVar : concurrentHashMap.values()) {
            kotlin.jvm.internal.p.h(aVar, "next(...)");
            a aVar2 = aVar;
            try {
                Result.Companion companion = Result.INSTANCE;
                aVar2.a(event);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.u(TAG, "session-update listener failed: " + thE.getMessage(), false, 4, null);
            }
        }
    }

    public static final void b(Object key, a listener) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(listener, "listener");
        ConcurrentHashMap<Object, a> concurrentHashMap = listeners;
        concurrentHashMap.put(key, listener);
        C4148a.k(TAG, "register key=" + key + " total=" + concurrentHashMap.size(), false, 4, null);
    }

    public static final void c(Object key) {
        kotlin.jvm.internal.p.i(key, "key");
        ConcurrentHashMap<Object, a> concurrentHashMap = listeners;
        if (concurrentHashMap.remove(key) != null) {
            C4148a.k(TAG, "unregister key=" + key + " total=" + concurrentHashMap.size(), false, 4, null);
        }
    }
}
