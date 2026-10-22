package com.stepos.agentframework.adapter.netcore;

import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\f\u0010\u0003R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fRT\u0010\u0013\u001aB\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00050\u0005 \u0011* \u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00120\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/u;", "", "<init>", "()V", "key", "Lcom/stepos/agentframework/adapter/netcore/u$a;", "listener", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;Lcom/stepos/agentframework/adapter/netcore/u$a;)V", "c", "(Ljava/lang/Object;)V", Const.INTENT_KEY_APIKEY, "", "TAG", "Ljava/lang/String;", "", "kotlin.jvm.PlatformType", "", "listeners", "Ljava/util/Map;", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class u {
    private static final String TAG = "ReconnectEventBus";
    public static final u INSTANCE = new u();
    private static final Map<Object, a> listeners = Collections.synchronizedMap(new WeakHashMap());

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/u$a;", "", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        void a();
    }

    public static final void a() {
        List<a> listM1;
        Object objB;
        Map<Object, a> listeners2 = listeners;
        kotlin.jvm.internal.p.h(listeners2, "listeners");
        synchronized (listeners2) {
            listM1 = Z8.F.m1(listeners2.values());
        }
        C4148a.k(TAG, "emit reconnected, listeners=" + listM1.size(), false, 4, null);
        for (a aVar : listM1) {
            try {
                Result.Companion companion = Result.INSTANCE;
                aVar.a();
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.u(TAG, "reconnect listener failed: " + thE.getMessage(), false, 4, null);
            }
        }
    }

    public static final void b(Object key, a listener) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(listener, "listener");
        Map<Object, a> listeners2 = listeners;
        kotlin.jvm.internal.p.h(listeners2, "listeners");
        listeners2.put(key, listener);
        C4148a.k(TAG, "register key=" + key + " total=" + listeners2.size(), false, 4, null);
    }

    public static final void c(Object key) {
        kotlin.jvm.internal.p.i(key, "key");
        Map<Object, a> map = listeners;
        if (map.remove(key) != null) {
            C4148a.k(TAG, "unregister key=" + key + " total=" + map.size(), false, 4, null);
        }
    }
}
