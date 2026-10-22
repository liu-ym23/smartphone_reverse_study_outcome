package com.stepos.agentframework.adapter.netcore;

import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/A;", "", "<init>", "()V", "key", "Lcom/stepos/agentframework/adapter/netcore/A$a;", "listener", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;Lcom/stepos/agentframework/adapter/netcore/A$a;)V", "Lcom/stepos/agentframework/adapter/netcore/z;", "event", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/adapter/netcore/z;)V", "", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "listeners", "Ljava/util/concurrent/ConcurrentHashMap;", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class A {
    private static final String TAG = "TaskDismissEventBus";
    public static final A INSTANCE = new A();
    private static final ConcurrentHashMap<Object, a> listeners = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/A$a;", "", "Lcom/stepos/agentframework/adapter/netcore/z;", "event", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/adapter/netcore/z;)V", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        void a(TaskDismiss event);
    }

    public static final void a(TaskDismiss event) {
        Object objB;
        kotlin.jvm.internal.p.i(event, "event");
        String taskId = event.getTaskId();
        String surface = event.getSurface();
        ConcurrentHashMap<Object, a> concurrentHashMap = listeners;
        C4148a.k(TAG, "emit dismiss taskId=" + taskId + " surface=" + surface + " listeners=" + concurrentHashMap.size(), false, 4, null);
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
                C4148a.u(TAG, "dismiss listener failed: " + thE.getMessage(), false, 4, null);
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
}
