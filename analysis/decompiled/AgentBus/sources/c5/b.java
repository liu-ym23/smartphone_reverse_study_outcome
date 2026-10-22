package c5;

import java.util.Map;
import q7.k;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final s9.d f1895c = new s9.d(11);

    /* renamed from: a, reason: collision with root package name */
    public final String f1896a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f1897b;

    public b(String str, Map map) {
        this.f1896a = str;
        this.f1897b = map;
    }

    public final String a() {
        Object obj = this.f1897b.get("event");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final String b() {
        Object obj = this.f1897b.get("id");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final Map c() {
        Map mapG = g();
        Object obj = mapG != null ? mapG.get("_meta") : null;
        Map map = obj instanceof Map ? (Map) obj : null;
        if (map != null) {
            return map;
        }
        Map mapH = h();
        Object obj2 = mapH != null ? mapH.get("_meta") : null;
        if (obj2 instanceof Map) {
            return (Map) obj2;
        }
        return null;
    }

    public final String d() {
        Object obj = this.f1897b.get("method");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final String e() {
        if (k.a(d(), "node.event")) {
            Map mapG = g();
            Object obj = mapG != null ? mapG.get("event") : null;
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return k.a(this.f1896a, bVar.f1896a) && k.a(this.f1897b, bVar.f1897b);
    }

    public final Boolean f() {
        Object obj = this.f1897b.get("ok");
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        return null;
    }

    public final Map g() {
        Object obj = this.f1897b.get("params");
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final Map h() {
        Object obj = this.f1897b.get("payload");
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final int hashCode() {
        return this.f1897b.hashCode() + (this.f1896a.hashCode() * 31);
    }

    public final String i() {
        return this.f1896a;
    }

    public final String toString() {
        return "Frame(type=" + this.f1896a + ", raw=" + this.f1897b + ")";
    }
}
