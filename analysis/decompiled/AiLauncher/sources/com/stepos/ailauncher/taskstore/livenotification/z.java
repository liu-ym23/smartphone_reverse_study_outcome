package com.stepos.ailauncher.taskstore.livenotification;

import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\bJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0003J%\u0010\u0012\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0015\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0017\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0013RT\u0010\u001a\u001aB\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\n0\n \u0019* \u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\n0\n\u0018\u00010\u00180\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bRT\u0010\u001c\u001aB\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\n0\n \u0019* \u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\n0\n\u0018\u00010\u00180\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/z;", "", "<init>", "()V", "", "sessionId", "LY8/t;", "f", "(Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "", "e", "(Ljava/lang/String;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "c", Const.INTENT_KEY_PKGNAME, "", "ids", Const.INTENT_KEY_APIKEY, "(Ljava/util/Set;Ljava/lang/String;)V", "", Const.INTENT_KEY_UMID, "(Ljava/util/Set;Ljava/lang/String;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "exposedIds", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "islandPinnedIds", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class z {
    public static final z INSTANCE = new z();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> exposedIds = ConcurrentHashMap.newKeySet();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> islandPinnedIds = ConcurrentHashMap.newKeySet();

    public final void a(Set<String> ids, String sessionId) {
        Set setD = C3723k.d(C3723k.INSTANCE, sessionId, null, null, 6, null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : setD) {
            if (!La.H.x0((String) obj)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ids.add((String) it.next());
        }
    }

    public final void b() {
        exposedIds.clear();
        islandPinnedIds.clear();
    }

    public final void c(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        ConcurrentHashMap.KeySetView<String, Boolean> exposedIds2 = exposedIds;
        kotlin.jvm.internal.p.h(exposedIds2, "exposedIds");
        h(exposedIds2, sessionId);
        ConcurrentHashMap.KeySetView<String, Boolean> islandPinnedIds2 = islandPinnedIds;
        kotlin.jvm.internal.p.h(islandPinnedIds2, "islandPinnedIds");
        h(islandPinnedIds2, sessionId);
    }

    public final boolean d(Set<String> ids, String sessionId) {
        if (!La.H.x0(sessionId) && !ids.isEmpty()) {
            if (ids.contains(sessionId)) {
                return true;
            }
            Set<String> set = ids;
            if ((set instanceof Collection) && set.isEmpty()) {
                return false;
            }
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                if (C3723k.INSTANCE.f((String) it.next(), sessionId)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean e(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        ConcurrentHashMap.KeySetView<String, Boolean> exposedIds2 = exposedIds;
        kotlin.jvm.internal.p.h(exposedIds2, "exposedIds");
        return d(exposedIds2, sessionId);
    }

    public final void f(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        ConcurrentHashMap.KeySetView<String, Boolean> exposedIds2 = exposedIds;
        kotlin.jvm.internal.p.h(exposedIds2, "exposedIds");
        a(exposedIds2, sessionId);
    }

    public final void g(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        ConcurrentHashMap.KeySetView<String, Boolean> islandPinnedIds2 = islandPinnedIds;
        kotlin.jvm.internal.p.h(islandPinnedIds2, "islandPinnedIds");
        a(islandPinnedIds2, sessionId);
    }

    public final void h(Set<String> ids, String sessionId) {
        if (La.H.x0(sessionId) || ids.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : ids) {
            if (C3723k.INSTANCE.f((String) obj, sessionId)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        ids.removeAll(Z8.F.r1(arrayList));
    }

    public final boolean i(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        ConcurrentHashMap.KeySetView<String, Boolean> islandPinnedIds2 = islandPinnedIds;
        kotlin.jvm.internal.p.h(islandPinnedIds2, "islandPinnedIds");
        return d(islandPinnedIds2, sessionId);
    }
}
