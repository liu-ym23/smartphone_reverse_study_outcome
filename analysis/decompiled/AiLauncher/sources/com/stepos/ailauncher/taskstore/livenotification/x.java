package com.stepos.ailauncher.taskstore.livenotification;

import Z8.C1173v;
import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\f2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u000f\"\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0013\u001a\u00020\f2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u000f\"\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0015\u001a\u00020\f2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u000f\"\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0015\u0010\u0014J#\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\u00182\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u0003J\u0015\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010!\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010 \u001a\u00020\f¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b#\u0010\u001fJ\u000f\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010\u0003R \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R \u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0)0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R#\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0)0,8\u0006¢\u0006\f\n\u0004\b\u0010\u0010-\u001a\u0004\b.\u0010/RT\u00102\u001aB\u0012\f\u0012\n 1*\u0004\u0018\u00010\t0\t\u0012\f\u0012\n 1*\u0004\u0018\u00010\f0\f 1* \u0012\f\u0012\n 1*\u0004\u0018\u00010\t0\t\u0012\f\u0012\n 1*\u0004\u0018\u00010\f0\f\u0018\u000100008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103RT\u00104\u001aB\u0012\f\u0012\n 1*\u0004\u0018\u00010\t0\t\u0012\f\u0012\n 1*\u0004\u0018\u00010\f0\f 1* \u0012\f\u0012\n 1*\u0004\u0018\u00010\t0\t\u0012\f\u0012\n 1*\u0004\u0018\u00010\f0\f\u0018\u000100008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00103¨\u00065"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/x;", "", "<init>", "()V", "Lcom/stepos/ailauncher/taskstore/livenotification/m;", com.stepos.ailauncher.mcpservice.risk.o.SELECTION_ID, "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/taskstore/livenotification/m;)V", "", "sessionId", "requestId", "", "k", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "sessionIds", Const.INTENT_KEY_BACKGROUND_COMMAND, "([Ljava/lang/String;)Z", "m", "([Ljava/lang/String;Ljava/lang/String;)Z", Const.INTENT_KEY_PKGNAME, "", "now", "", "p", "(J)Ljava/util/Map;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)V", "e", "(Ljava/lang/String;)Z", "fallback", "o", "(Ljava/lang/String;Z)V", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/util/concurrent/ConcurrentHashMap;", AuthSessionDto.STATUS_PENDING, "Ljava/util/concurrent/ConcurrentHashMap;", "LXa/k;", "", "_sessionIds", "LXa/k;", "LXa/t;", "LXa/t;", Const.INTENT_KEY_UMID, "()LXa/t;", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "exposedIds", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "islandFallbackIds", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class x {
    private static final Xa.k<Set<String>> _sessionIds;
    private static final ConcurrentHashMap.KeySetView<String, Boolean> exposedIds;
    private static final ConcurrentHashMap.KeySetView<String, Boolean> islandFallbackIds;
    private static final Xa.t<Set<String>> sessionIds;
    public static final x INSTANCE = new x();
    private static final ConcurrentHashMap<String, PendingRisk> pending = new ConcurrentHashMap<>();

    static {
        Xa.k<Set<String>> kVarA = Xa.u.a(Y.e());
        _sessionIds = kVarA;
        sessionIds = Xa.d.c(kVarA);
        exposedIds = ConcurrentHashMap.newKeySet();
        islandFallbackIds = ConcurrentHashMap.newKeySet();
    }

    public static /* synthetic */ boolean c(x xVar, String[] strArr, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        return xVar.b(strArr, str);
    }

    public static /* synthetic */ boolean l(x xVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return xVar.k(str, str2);
    }

    public static /* synthetic */ boolean n(x xVar, String[] strArr, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        return xVar.m(strArr, str);
    }

    public static /* synthetic */ Map q(x xVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = System.currentTimeMillis();
        }
        return xVar.p(j10);
    }

    public final void a() {
        pending.clear();
        exposedIds.clear();
        islandFallbackIds.clear();
        i();
    }

    public final boolean b(String[] sessionIds2, String requestId) {
        kotlin.jvm.internal.p.i(sessionIds2, "sessionIds");
        for (String str : sessionIds2) {
            PendingRisk pendingRisk = pending.get(str);
            if (pendingRisk != null && (requestId == null || kotlin.jvm.internal.p.d(pendingRisk.getRequestId(), requestId))) {
                return true;
            }
        }
        return false;
    }

    public final Xa.t<Set<String>> d() {
        return sessionIds;
    }

    public final boolean e(String requestId) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        return !La.H.x0(requestId) && exposedIds.contains(requestId);
    }

    public final boolean f(String requestId) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        return !La.H.x0(requestId) && islandFallbackIds.contains(requestId);
    }

    public final boolean g(String... sessionIds2) {
        int i10;
        kotlin.jvm.internal.p.i(sessionIds2, "sessionIds");
        List<String> listT = Z8.r.T(sessionIds2);
        if ((listT instanceof Collection) && listT.isEmpty()) {
            i10 = 0;
        } else {
            i10 = 0;
            for (String str : listT) {
                ConcurrentHashMap<String, PendingRisk> concurrentHashMap = pending;
                PendingRisk pendingRisk = concurrentHashMap.get(str);
                if (((pendingRisk == null || pendingRisk.getAnswered()) ? false : concurrentHashMap.replace(str, pendingRisk, PendingRisk.b(pendingRisk, null, null, null, null, null, null, 0L, 0L, true, 255, null))) && (i10 = i10 + 1) < 0) {
                    C1173v.v();
                }
            }
        }
        return i10 > 0;
    }

    public final void h(String requestId) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        if (La.H.x0(requestId)) {
            return;
        }
        exposedIds.add(requestId);
    }

    public final void i() {
        Xa.k<Set<String>> kVar = _sessionIds;
        Set<String> setKeySet = pending.keySet();
        kotlin.jvm.internal.p.h(setKeySet, "<get-keys>(...)");
        kVar.setValue(Z8.F.r1(setKeySet));
    }

    public final void j(PendingRisk risk) {
        kotlin.jvm.internal.p.i(risk, "risk");
        pending.put(risk.getSessionId(), risk);
        i();
    }

    public final boolean k(String sessionId, String requestId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        boolean zRemove = false;
        if (requestId != null) {
            ConcurrentHashMap<String, PendingRisk> concurrentHashMap = pending;
            PendingRisk pendingRisk = concurrentHashMap.get(sessionId);
            if (pendingRisk == null || !kotlin.jvm.internal.p.d(pendingRisk.getRequestId(), requestId)) {
                return false;
            }
            zRemove = concurrentHashMap.remove(sessionId, pendingRisk);
        } else if (pending.remove(sessionId) != null) {
            zRemove = true;
        }
        if (zRemove) {
            i();
        }
        return zRemove;
    }

    public final boolean m(String[] sessionIds2, String requestId) {
        int i10;
        kotlin.jvm.internal.p.i(sessionIds2, "sessionIds");
        List listT = Z8.r.T(sessionIds2);
        if ((listT instanceof Collection) && listT.isEmpty()) {
            i10 = 0;
        } else {
            Iterator it = listT.iterator();
            i10 = 0;
            while (it.hasNext()) {
                if (INSTANCE.k((String) it.next(), requestId) && (i10 = i10 + 1) < 0) {
                    C1173v.v();
                }
            }
        }
        return i10 > 0;
    }

    public final void o(String requestId, boolean fallback) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        if (La.H.x0(requestId)) {
            return;
        }
        ConcurrentHashMap.KeySetView<String, Boolean> keySetView = islandFallbackIds;
        if (fallback) {
            keySetView.add(requestId);
        } else {
            keySetView.remove(requestId);
        }
    }

    public final Map<String, PendingRisk> p(long now) {
        ConcurrentHashMap<String, PendingRisk> concurrentHashMap = pending;
        if (concurrentHashMap.isEmpty()) {
            return kotlin.collections.a.i();
        }
        Collection<PendingRisk> collectionValues = concurrentHashMap.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((PendingRisk) obj).k(now)) {
                arrayList.add(obj);
            }
        }
        for (Object obj2 : arrayList) {
            kotlin.jvm.internal.p.h(obj2, "next(...)");
            PendingRisk pendingRisk = (PendingRisk) obj2;
            pending.remove(pendingRisk.getSessionId(), pendingRisk);
        }
        if (!arrayList.isEmpty()) {
            i();
        }
        return kotlin.collections.a.A(pending);
    }
}
