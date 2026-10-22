package com.bytedance.applog.priority.a;

import com.bytedance.keva.Keva;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: Database.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5848a = null;
    private static final ConcurrentHashMap<String, c> f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Keva f5849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f5851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f5852e;

    /* JADX INFO: compiled from: Database.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        public final c a(String r3, b r4) {
            o.d(r3, "dbName");
            o.d(r4, "config");
            ConcurrentMap r2 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(c.d(), ConcurrentMap.class, "com.obric.aiagent.plugin");
            Object r0 = r2.get(r3);
            if (r0 != null) goto L8;
            r0 = new c(r3, r4);
            Object r5 = r2.putIfAbsent(r3, r0);
            if (r5 == null) goto L8;
            r0 = r5;
        L8:
            o.b(r0, "DB_MAP.getOrPut(dbName) …atabase(dbName, config) }");
            return (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin");
        }
    }

    public c(String r2, b r3) {
        o.d(r2, "dbName");
        o.d(r3, "config");
        this.f5851d = r2;
        this.f5852e = r3;
        Keva r4 = Keva.getRepo(r2, 0);
        o.b(r4, "Keva.getRepo(dbName, Kev…ants.MODE_SINGLE_PROCESS)");
        this.f5849b = r4;
        this.f5850c = r4.count();
    }

    public static final /* synthetic */ ConcurrentHashMap d() {
        return f;
    }

    public final String c() {
        return this.f5851d;
    }

    static {
        f5848a = new a(null);
        f = new ConcurrentHashMap();
    }

    public final synchronized void insert(h.a r2, String r3) {
        monitor-enter(this);
        o.d(r2, "key");     // Catch: Throwable -> L6
        o.d(r3, "value");     // Catch: Throwable -> L6
        this.f5849b.storeString(r2.toString(), r3);     // Catch: Throwable -> L6
        e();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final HashMap<h.a, JSONObject> a(long r14, int r16, long r17) {
        HashMap<h.a, JSONObject> r1 = new HashMap();
        Map<String, ?> r2 = this.f5849b.getAll();
        o.b(r2, "keva.all");
        Iterator<Map.Entry<String, ?>> r3 = r2.entrySet().iterator();
        long r4 = 0;
        int r5 = 0;
    L4:
        if (r3.hasNext() == false) goto L20;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        h.a.C0138a r7 = h.a.f5871a;
        Object r9 = r6.getKey();
        o.b(r9, "i.key");
        h.a r8 = r7.a((String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin"));
        if (r8 == null) goto L4;
        if (r8.a() >= (System.currentTimeMillis() - r17)) goto L11;
        this.f5849b.erase((String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.aiagent.plugin"));
        goto L4
    L11:
        r4 = r4 + ((long) r8.c());
        r5 = r5 + 1;
        if (r5 <= 1) goto L19;
        if (r4 > r14) goto L17;
        if (r5 <= r16) goto L19;
    L17:
        return r1;
    L19:
        ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin")).put(r8, new JSONObject(String.valueOf(r6.getValue())));
        goto L4
    L20:
        return r1;
    }

    public final synchronized void delete(h.a r2) {
        monitor-enter(this);
        o.d(r2, "key");     // Catch: Throwable -> L6
        this.f5849b.erase(r2.toString());     // Catch: Throwable -> L6
        e();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(List<h.a> r4) {
        monitor-enter(this);
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        o.d(r5, "keys");     // Catch: Throwable -> L10
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L10
    L5:
        if (r6.hasNext() == false) goto L7;
        h.a r0 = (h.a) ZeusTransformUtils.preCheckCast(r6.next(), h.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        this.f5849b.erase(r0.toString());     // Catch: Throwable -> L10
        goto L5
    L7:
        e();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final int a() {
        return this.f5849b.count();
    }

    public final boolean b() {
        if (this.f5850c > 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final synchronized void e() {
        monitor-enter(this);
        int r0 = a();     // Catch: Throwable -> L6
        this.f5850c = r0;     // Catch: Throwable -> L6
        this.f5852e.a(this.f5851d, r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public String toString() {
        return "DB[" + this.f5851d + ']';
    }
}
