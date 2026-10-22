package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u0003R\u0014\u0010\u001a\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR0\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001cj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fRP\u0010\"\u001a>\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0 j\b\u0012\u0004\u0012\u00020\n`!0\u001cj\u001e\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0 j\b\u0012\u0004\u0012\u00020\n`!`\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001fR \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/M0;", "", "<init>", "()V", "key", "Lcom/stepos/agentframework/chatcore/session/M0$a;", "listener", "LY8/t;", Const.INTENT_KEY_UMID, "(Ljava/lang/Object;Lcom/stepos/agentframework/chatcore/session/M0$a;)V", "", "from", "to", "e", "(Ljava/lang/String;Ljava/lang/String;)V", "id", "f", "(Ljava/lang/String;)Ljava/lang/String;", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/util/Set;", "previous", "incoming", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "c", "lock", "Ljava/lang/Object;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "oldToNew", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "canonicalToOlds", "Ljava/util/concurrent/ConcurrentHashMap;", "listeners", "Ljava/util/concurrent/ConcurrentHashMap;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class M0 {
    public static final M0 INSTANCE = new M0();
    private static final Object lock = new Object();
    private static final HashMap<String, String> oldToNew = new HashMap<>();
    private static final HashMap<String, HashSet<String>> canonicalToOlds = new HashMap<>();
    private static final ConcurrentHashMap<Object, a> listeners = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/M0$a;", "", "", "from", "to", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        void a(String from, String to);
    }

    public final Set<String> a(String id) {
        kotlin.jvm.internal.p.i(id, "id");
        String string = La.H.D1(id).toString();
        if (string.length() == 0) {
            return Z8.Y.e();
        }
        synchronized (lock) {
            String str = oldToNew.get(string);
            if (str == null) {
                str = string;
            }
            HashSet<String> hashSet = canonicalToOlds.get(str);
            if (hashSet != null && !hashSet.isEmpty()) {
                HashSet hashSet2 = new HashSet(hashSet.size() + 2);
                hashSet2.add(string);
                hashSet2.add(str);
                hashSet2.addAll(hashSet);
                return hashSet2;
            }
            return kotlin.jvm.internal.p.d(string, str) ? Z8.X.d(string) : Z8.Y.j(string, str);
        }
    }

    public final String b(String previous, String incoming) {
        if (previous == null || La.H.x0(previous)) {
            previous = null;
        }
        String strF = f(previous);
        if (incoming == null || La.H.x0(incoming)) {
            incoming = null;
        }
        String strF2 = f(incoming);
        return ((strF == null || strF2 == null || kotlin.jvm.internal.p.d(strF, strF2)) && strF2 != null) ? strF2 : strF;
    }

    public final void c() {
        canonicalToOlds.clear();
        for (Map.Entry<String, String> entry : oldToNew.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            HashMap<String, HashSet<String>> map = canonicalToOlds;
            HashSet<String> hashSet = map.get(value);
            if (hashSet == null) {
                map.put(value, Z8.Y.f(key));
            } else {
                hashSet.add(key);
            }
        }
    }

    public final void d(Object key, a listener) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(listener, "listener");
        listeners.put(key, listener);
    }

    public final void e(String from, String to) {
        List listM1;
        kotlin.jvm.internal.p.i(from, "from");
        kotlin.jvm.internal.p.i(to, "to");
        String string = La.H.D1(from).toString();
        String string2 = La.H.D1(to).toString();
        if (string.length() == 0 || string2.length() == 0 || kotlin.jvm.internal.p.d(string, string2)) {
            return;
        }
        synchronized (lock) {
            try {
                HashMap<String, String> map = oldToNew;
                map.put(string, string2);
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (kotlin.jvm.internal.p.d(entry.getValue(), string)) {
                        arrayList.add(key);
                    }
                }
                Iterator it = arrayList.iterator();
                kotlin.jvm.internal.p.h(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    kotlin.jvm.internal.p.h(next, "next(...)");
                    oldToNew.put((String) next, string2);
                }
                INSTANCE.c();
                Collection<a> collectionValues = listeners.values();
                kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
                listM1 = Z8.F.m1(collectionValues);
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it2 = listM1.iterator();
        while (it2.hasNext()) {
            ((a) it2.next()).a(string, string2);
        }
    }

    public final String f(String id) {
        if (id == null || La.H.x0(id)) {
            return id;
        }
        synchronized (lock) {
            String str = oldToNew.get(id);
            if (str != null) {
                id = str;
            }
        }
        return id;
    }
}
