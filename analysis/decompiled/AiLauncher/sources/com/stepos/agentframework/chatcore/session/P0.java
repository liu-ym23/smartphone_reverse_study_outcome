package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import u4.AgentTaskEvent;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/P0;", "", "<init>", "()V", "key", "Lcom/stepos/agentframework/chatcore/session/a0;", "listener", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;Lcom/stepos/agentframework/chatcore/session/a0;)V", "c", "(Ljava/lang/Object;)V", "", "sessionId", "Lu4/h;", "event", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lu4/h;)V", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "listeners", "Ljava/util/concurrent/ConcurrentHashMap;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class P0 {
    private static final String TAG = "TaskEventBus";
    public static final P0 INSTANCE = new P0();
    private static final ConcurrentHashMap<Object, InterfaceC1859a0> listeners = new ConcurrentHashMap<>();

    public static final void a(String sessionId, AgentTaskEvent event) {
        Object objB;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(event, "event");
        ConcurrentHashMap<Object, InterfaceC1859a0> concurrentHashMap = listeners;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        for (InterfaceC1859a0 interfaceC1859a0 : concurrentHashMap.values()) {
            kotlin.jvm.internal.p.h(interfaceC1859a0, "next(...)");
            InterfaceC1859a0 interfaceC1859a02 = interfaceC1859a0;
            try {
                Result.Companion companion = Result.INSTANCE;
                interfaceC1859a02.b(sessionId, event);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.u(TAG, "task event listener failed: " + thE.getMessage(), false, 4, null);
            }
        }
    }

    public static final void b(Object key, InterfaceC1859a0 listener) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(listener, "listener");
        ConcurrentHashMap<Object, InterfaceC1859a0> concurrentHashMap = listeners;
        InterfaceC1859a0 interfaceC1859a0Put = concurrentHashMap.put(key, listener);
        if (interfaceC1859a0Put == null) {
            C4148a.k(TAG, "register key=" + key + " total=" + concurrentHashMap.size(), false, 4, null);
            return;
        }
        if (interfaceC1859a0Put != listener) {
            C4148a.k(TAG, "replace listener for key=" + key + " total=" + concurrentHashMap.size(), false, 4, null);
        }
    }

    public static final void c(Object key) {
        kotlin.jvm.internal.p.i(key, "key");
        ConcurrentHashMap<Object, InterfaceC1859a0> concurrentHashMap = listeners;
        if (concurrentHashMap.remove(key) != null) {
            C4148a.k(TAG, "unregister key=" + key + " total=" + concurrentHashMap.size(), false, 4, null);
        }
    }
}
