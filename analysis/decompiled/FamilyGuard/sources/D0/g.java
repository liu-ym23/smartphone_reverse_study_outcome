package D0;

import D0.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class g<K extends l, V> {

    /* renamed from: a, reason: collision with root package name */
    private final a<K, V> f1005a = new a<>();

    /* renamed from: b, reason: collision with root package name */
    private final Map<K, a<K, V>> f1006b = new HashMap();

    private static class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final K f1007a;

        /* renamed from: b, reason: collision with root package name */
        private List<V> f1008b;

        /* renamed from: c, reason: collision with root package name */
        a<K, V> f1009c;

        /* renamed from: d, reason: collision with root package name */
        a<K, V> f1010d;

        a() {
            this(null);
        }

        public void a(V v5) {
            if (this.f1008b == null) {
                this.f1008b = new ArrayList();
            }
            this.f1008b.add(v5);
        }

        public V b() {
            int iC = c();
            if (iC > 0) {
                return this.f1008b.remove(iC - 1);
            }
            return null;
        }

        public int c() {
            List<V> list = this.f1008b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(K k5) {
            this.f1010d = this;
            this.f1009c = this;
            this.f1007a = k5;
        }
    }

    g() {
    }

    private void b(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f1005a;
        aVar.f1010d = aVar2;
        aVar.f1009c = aVar2.f1009c;
        g(aVar);
    }

    private void c(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f1005a;
        aVar.f1010d = aVar2.f1010d;
        aVar.f1009c = aVar2;
        g(aVar);
    }

    private static <K, V> void e(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f1010d;
        aVar2.f1009c = aVar.f1009c;
        aVar.f1009c.f1010d = aVar2;
    }

    private static <K, V> void g(a<K, V> aVar) {
        aVar.f1009c.f1010d = aVar;
        aVar.f1010d.f1009c = aVar;
    }

    public V a(K k5) {
        a<K, V> aVar = this.f1006b.get(k5);
        if (aVar == null) {
            aVar = new a<>(k5);
            this.f1006b.put(k5, aVar);
        } else {
            k5.a();
        }
        b(aVar);
        return aVar.b();
    }

    public void d(K k5, V v5) {
        a<K, V> aVar = this.f1006b.get(k5);
        if (aVar == null) {
            aVar = new a<>(k5);
            c(aVar);
            this.f1006b.put(k5, aVar);
        } else {
            k5.a();
        }
        aVar.a(v5);
    }

    public V f() {
        for (a aVar = this.f1005a.f1010d; !aVar.equals(this.f1005a); aVar = aVar.f1010d) {
            V v5 = (V) aVar.b();
            if (v5 != null) {
                return v5;
            }
            e(aVar);
            this.f1006b.remove(aVar.f1007a);
            ((l) aVar.f1007a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        a aVar = this.f1005a.f1009c;
        boolean z5 = false;
        while (!aVar.equals(this.f1005a)) {
            sb.append('{');
            sb.append(aVar.f1007a);
            sb.append(':');
            sb.append(aVar.c());
            sb.append("}, ");
            aVar = aVar.f1009c;
            z5 = true;
        }
        if (z5) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
