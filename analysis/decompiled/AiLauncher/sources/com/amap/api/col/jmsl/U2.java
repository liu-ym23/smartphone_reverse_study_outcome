package com.amap.api.col.jmsl;

import com.amap.api.col.jmsl.O2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class U2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f16368a = true;

    /* renamed from: b, reason: collision with root package name */
    public long f16369b = 86400;

    /* renamed from: c, reason: collision with root package name */
    public int f16370c = 10;

    /* renamed from: d, reason: collision with root package name */
    public long f16371d = 0;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashMap<O2.b, Object> f16372e = new LinkedHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    public final Object f16373f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public final LinkedHashMap<O2.b, Object> f16374g = new LinkedHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    public final Object f16375h = new Object();

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<String> f16376i = new ArrayList<>();

    public U2(String... strArr) {
        e(strArr);
    }

    public O2.c a(O2.b bVar) {
        if (!this.f16368a || !h(bVar)) {
            return null;
        }
        b();
        synchronized (this.f16373f) {
            try {
                if (f(this.f16372e, bVar)) {
                    return new O2.c(g(this.f16372e, bVar), true);
                }
                synchronized (this.f16375h) {
                    if (f(this.f16374g, bVar)) {
                        while (!f(this.f16372e, bVar) && f(this.f16374g, bVar)) {
                            try {
                                this.f16375h.wait(1000L);
                            } catch (InterruptedException e10) {
                                e10.printStackTrace();
                            }
                        }
                    } else {
                        this.f16374g.put(bVar, null);
                    }
                }
                return new O2.c(g(this.f16372e, bVar), false);
            } finally {
            }
        }
    }

    public final void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if ((jCurrentTimeMillis - this.f16371d) / 1000 > this.f16369b) {
            this.f16372e.clear();
            this.f16371d = jCurrentTimeMillis;
        }
    }

    public void c(O2.a aVar) {
        if (aVar != null) {
            this.f16368a = aVar.h();
            this.f16369b = aVar.g();
            this.f16370c = aVar.f();
        }
    }

    public void d(O2.b bVar, Object obj) {
        O2.b next;
        if (this.f16368a && bVar != null && h(bVar)) {
            synchronized (this.f16373f) {
                try {
                    int size = this.f16372e.size();
                    if (size > 0 && size >= this.f16370c) {
                        Iterator<O2.b> it = this.f16372e.keySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            } else {
                                next = it.next();
                                if (next != null) {
                                    break;
                                }
                            }
                        }
                        i(this.f16372e, next);
                    }
                    b();
                    this.f16372e.put(bVar, obj);
                } catch (Throwable th) {
                    throw th;
                }
            }
            synchronized (this.f16375h) {
                i(this.f16374g, bVar);
                this.f16375h.notify();
            }
        }
    }

    public final void e(String... strArr) {
        this.f16371d = System.currentTimeMillis();
        this.f16372e.clear();
        this.f16376i.clear();
        for (String str : strArr) {
            if (str != null) {
                this.f16376i.add(str);
            }
        }
    }

    public boolean f(LinkedHashMap<O2.b, Object> linkedHashMap, O2.b bVar) {
        if (linkedHashMap != null) {
            return linkedHashMap.containsKey(bVar);
        }
        return false;
    }

    public Object g(LinkedHashMap<O2.b, Object> linkedHashMap, O2.b bVar) {
        if (linkedHashMap != null) {
            return linkedHashMap.get(bVar);
        }
        return null;
    }

    public boolean h(O2.b bVar) {
        if (bVar.f16252a == null) {
            return false;
        }
        Iterator<String> it = this.f16376i.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null && bVar.f16252a.contains(next)) {
                return true;
            }
        }
        return false;
    }

    public Object i(LinkedHashMap<O2.b, Object> linkedHashMap, O2.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        return linkedHashMap.remove(bVar);
    }
}
