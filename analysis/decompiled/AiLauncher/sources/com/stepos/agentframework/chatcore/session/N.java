package com.stepos.agentframework.chatcore.session;

import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/N;", "", "<init>", "()V", "key", "Lcom/stepos/agentframework/chatcore/session/N$a;", "listener", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;Lcom/stepos/agentframework/chatcore/session/N$a;)V", "", "", "sessionIds", Const.INTENT_KEY_APIKEY, "(Ljava/util/Collection;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "listeners", "Ljava/util/concurrent/ConcurrentHashMap;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class N {
    public static final N INSTANCE = new N();
    private static final ConcurrentHashMap<Object, a> listeners = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/N$a;", "", "", "", "sessionIds", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/util/Collection;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        void a(Collection<String> sessionIds);
    }

    public final void a(Collection<String> sessionIds) {
        kotlin.jvm.internal.p.i(sessionIds, "sessionIds");
        Collection<String> collection = sessionIds;
        ArrayList arrayList = new ArrayList(C1174w.x(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(La.H.D1((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        List listG0 = Z8.F.g0(arrayList2);
        if (listG0.isEmpty()) {
            return;
        }
        for (a aVar : listeners.values()) {
            kotlin.jvm.internal.p.h(aVar, "next(...)");
            aVar.a(listG0);
        }
    }

    public final void b(Object key, a listener) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(listener, "listener");
        listeners.put(key, listener);
    }
}
