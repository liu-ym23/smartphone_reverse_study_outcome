package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0004\b\u000f\u0010\u0010RT\u0010\u0013\u001aB\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\n0\n \u0012* \u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\n0\n\u0018\u00010\u00110\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/O;", "", "<init>", "()V", "", "sessionId", "LY8/t;", "c", "(Ljava/lang/String;)V", Const.INTENT_KEY_UMID, "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Z", "", "ids", Const.INTENT_KEY_APIKEY, "(Ljava/util/Collection;)Z", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "hiddenIds", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class O {
    public static final O INSTANCE = new O();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> hiddenIds = ConcurrentHashMap.newKeySet();

    public final boolean a(Collection<String> ids) {
        kotlin.jvm.internal.p.i(ids, "ids");
        Collection<String> collection = ids;
        if (collection.isEmpty()) {
            return false;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (b((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        String string = La.H.D1(sessionId).toString();
        return string.length() > 0 && hiddenIds.contains(string);
    }

    public final void c(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        String string = La.H.D1(sessionId).toString();
        if (string.length() > 0) {
            hiddenIds.add(string);
        }
    }

    public final void d(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        String string = La.H.D1(sessionId).toString();
        if (string.length() > 0) {
            hiddenIds.remove(string);
        }
    }
}
