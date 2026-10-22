package com.amap.api.col.jmsl;

import java.util.HashMap;

/* loaded from: classes.dex */
public class O2 {

    /* renamed from: b, reason: collision with root package name */
    public static volatile O2 f16246b;

    /* renamed from: a, reason: collision with root package name */
    public HashMap<String, U2> f16247a = new HashMap<>();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f16248a = true;

        /* renamed from: b, reason: collision with root package name */
        public long f16249b = 86400;

        /* renamed from: c, reason: collision with root package name */
        public int f16250c = 10;

        /* renamed from: d, reason: collision with root package name */
        public double f16251d = 0.0d;

        public double a() {
            return this.f16251d;
        }

        public void b(double d10) {
            this.f16251d = d10;
        }

        public void c(int i10) {
            this.f16250c = i10;
        }

        public void d(long j10) {
            this.f16249b = j10;
        }

        public void e(boolean z10) {
            this.f16248a = z10;
        }

        public int f() {
            return this.f16250c;
        }

        public long g() {
            return this.f16249b;
        }

        public boolean h() {
            return this.f16248a;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f16252a;

        /* renamed from: b, reason: collision with root package name */
        public Object f16253b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                String str = this.f16252a;
                if (str == null) {
                    return bVar.f16252a == null && this.f16253b == bVar.f16253b;
                }
                if (str.equals(bVar.f16252a) && this.f16253b == bVar.f16253b) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            String str = this.f16252a;
            int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            Object obj = this.f16253b;
            return iHashCode + (obj != null ? obj.hashCode() : 0);
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public Object f16254a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f16255b;

        public c(Object obj, boolean z10) {
            this.f16254a = obj;
            this.f16255b = z10;
        }
    }

    public static O2 b() {
        if (f16246b == null) {
            synchronized (O2.class) {
                try {
                    if (f16246b == null) {
                        f16246b = new O2();
                    }
                } finally {
                }
            }
        }
        return f16246b;
    }

    public c a(b bVar) {
        c cVarA;
        if (bVar == null) {
            return null;
        }
        for (U2 u22 : this.f16247a.values()) {
            if (u22 != null && (cVarA = u22.a(bVar)) != null) {
                return cVarA;
            }
        }
        return null;
    }

    public synchronized U2 c(String str) {
        return this.f16247a.get(str);
    }

    public void d(a aVar) {
        if (aVar == null) {
            return;
        }
        for (U2 u22 : this.f16247a.values()) {
            if (u22 != null) {
                u22.c(aVar);
            }
        }
    }

    public void e(b bVar, Object obj) {
        for (U2 u22 : this.f16247a.values()) {
            if (u22 != null) {
                u22.d(bVar, obj);
            }
        }
    }

    public void f(String str, a aVar) {
        U2 u22;
        if (aVar == null || (u22 = this.f16247a.get(str)) == null) {
            return;
        }
        u22.c(aVar);
    }

    public synchronized void g(String str, U2 u22) {
        this.f16247a.put(str, u22);
    }

    public boolean h(b bVar) {
        if (bVar == null) {
            return false;
        }
        for (U2 u22 : this.f16247a.values()) {
            if (u22 != null && u22.h(bVar)) {
                return true;
            }
        }
        return false;
    }
}
