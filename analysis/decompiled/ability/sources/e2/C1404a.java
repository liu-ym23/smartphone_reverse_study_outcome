package e2;

import android.app.Application;
import android.content.Context;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import q.C1794a;
import r.C1871c;
import s.g;
import s.h;
import v.j;

/* renamed from: e2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1404a {
    public static int e = 1;
    public static volatile C1794a f;
    public static Application g;

    /* renamed from: j, reason: collision with root package name */
    public static f2.a f4333j;

    /* renamed from: a, reason: collision with root package name */
    public volatile g f4334a;
    public volatile h b;
    public C1871c c;
    public Map d;
    public static final ConcurrentHashMap h = new ConcurrentHashMap();
    public static final F1.a i = new F1.a();
    public static final boolean k = true;
    public static final boolean l = true;
    public static final boolean m = true;

    public static C1404a c(String str) {
        return (C1404a) h.get(str);
    }

    public static C1404a d(Context context, C1406c c1406c, Map map) {
        C1404a c1404a = (C1404a) h.get(c1406c.f4335a);
        if (c1404a != null) {
            Map map2 = c1404a.d;
            if (map2 == null) {
                c1404a.d = map;
                return c1404a;
            }
            if (map != null) {
                map2.putAll(map);
            }
            return c1404a;
        }
        C1404a c1404a2 = new C1404a();
        c1404a2.d = map;
        A0.b bVar = c1406c.d;
        if (bVar != null) {
            A0.b bVar2 = w.h.f6804a;
            try {
                w.h.b = (context.getApplicationInfo().flags & 2) != 0;
            } catch (Throwable unused) {
                w.h.b = true;
            }
            w.h.f6804a = bVar;
        }
        w.h.a("Inited Begin", null);
        if (g == null) {
            g = (Application) context.getApplicationContext();
        }
        h.put(c1406c.f4335a, c1404a2);
        c1404a2.f4334a = new g(g, c1406c);
        c1404a2.b = new h(g, c1404a2.f4334a);
        c1404a2.c = new C1871c(g, c1404a2.f4334a, c1404a2.b);
        f = new C1794a();
        g.registerActivityLifecycleCallbacks(f);
        StringBuilder sbF = M.a.f("Inited Config Did:");
        sbF.append(c1406c.l);
        sbF.append(" aid:");
        sbF.append(c1406c.f4335a);
        w.h.a(sbF.toString(), null);
        return c1404a2;
    }

    public static void e(j jVar) {
        ConcurrentHashMap concurrentHashMap = h;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0) {
            return;
        }
        Iterator it = concurrentHashMap.values().iterator();
        while (it.hasNext()) {
            C1871c c1871c = ((C1404a) it.next()).c;
            if (c1871c != null) {
                c1871c.b(jVar);
            }
        }
    }

    public final String a() {
        if (this.b == null) {
            return null;
        }
        h hVar = this.b;
        if (hVar.f5975a) {
            return hVar.d.optString("ab_sdk_version", "");
        }
        g gVar = hVar.c;
        return gVar != null ? gVar.c.getString("ab_sdk_version", "") : "";
    }

    public final String b() {
        return this.b != null ? this.b.d.optString("bd_did", "") : "";
    }
}
