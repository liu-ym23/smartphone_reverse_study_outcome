package org.threeten.bp.zone;

import ig.d;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList f23254a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentMap f23255b = null;

    static {
        f23254a = new CopyOnWriteArrayList();
        f23255b = new ConcurrentHashMap(512, 0.75f, 2);
        b.a();
    }

    public c() {
    }

    public static Set a() {
        return Collections.unmodifiableSet(f23255b.keySet());
    }

    public static c b(String r10) {
        ConcurrentMap r11 = f23255b;
        c r12 = (c) r11.get(r10);
        if (r12 == null) goto L5;
        return r12;
    L5:
        if (r11.isEmpty() == false) goto L9;
        throw new ZoneRulesException("No time-zone data files registered");
    L9:
        throw new ZoneRulesException("Unknown time-zone ID: " + r10);
    }

    public static ZoneRules c(String r10, boolean r11) {
        d.h(r10, "zoneId");
        return b(r10).d(r10, r11);
    }

    public static void f(c r10) {
        d.h(r10, "provider");
        g(r10);
        f23254a.add(r10);
    }

    public static void g(c r10) {
        Iterator r11 = r10.e().iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        String r12 = (String) r11.next();
        d.h(r12, "zoneId");
        if (((c) f23255b.putIfAbsent(r12, r10)) == null) goto L4;
        throw new ZoneRulesException("Unable to register zone as one already registered with that ID: " + r12 + ", currently loading from provider: " + r10);
    }

    public abstract ZoneRules d(String r10, boolean r11);

    public abstract Set e();
}
