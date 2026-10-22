package h3;

import com.google.firebase.components.DependencyCycleException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: h3.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C4138n {

    /* renamed from: h3.n$b */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final C4127c<?> f32927a;

        /* renamed from: b, reason: collision with root package name */
        public final Set<b> f32928b = new HashSet();

        /* renamed from: c, reason: collision with root package name */
        public final Set<b> f32929c = new HashSet();

        public b(C4127c<?> c4127c) {
            this.f32927a = c4127c;
        }

        public void a(b bVar) {
            this.f32928b.add(bVar);
        }

        public void b(b bVar) {
            this.f32929c.add(bVar);
        }

        public C4127c<?> c() {
            return this.f32927a;
        }

        public Set<b> d() {
            return this.f32928b;
        }

        public boolean e() {
            return this.f32928b.isEmpty();
        }

        public boolean f() {
            return this.f32929c.isEmpty();
        }

        public void g(b bVar) {
            this.f32929c.remove(bVar);
        }
    }

    /* renamed from: h3.n$c */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final Class<?> f32930a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f32931b;

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.f32930a.equals(this.f32930a) && cVar.f32931b == this.f32931b) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Boolean.valueOf(this.f32931b).hashCode() ^ ((this.f32930a.hashCode() ^ 1000003) * 1000003);
        }

        public c(Class<?> cls, boolean z10) {
            this.f32930a = cls;
            this.f32931b = z10;
        }
    }

    public static void a(List<C4127c<?>> list) {
        Set<b> setC = c(list);
        Set<b> setB = b(setC);
        int i10 = 0;
        while (!setB.isEmpty()) {
            b next = setB.iterator().next();
            setB.remove(next);
            i10++;
            for (b bVar : next.d()) {
                bVar.g(next);
                if (bVar.f()) {
                    setB.add(bVar);
                }
            }
        }
        if (i10 == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar2 : setC) {
            if (!bVar2.f() && !bVar2.e()) {
                arrayList.add(bVar2.c());
            }
        }
        throw new DependencyCycleException(arrayList);
    }

    public static Set<b> b(Set<b> set) {
        HashSet hashSet = new HashSet();
        for (b bVar : set) {
            if (bVar.f()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    public static Set<b> c(List<C4127c<?>> list) {
        Set<b> set;
        HashMap map = new HashMap(list.size());
        Iterator<C4127c<?>> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                Iterator it2 = map.values().iterator();
                while (it2.hasNext()) {
                    for (b bVar : (Set) it2.next()) {
                        for (C4139o c4139o : bVar.c().c()) {
                            if (c4139o.d() && (set = (Set) map.get(new c(c4139o.b(), c4139o.f()))) != null) {
                                for (b bVar2 : set) {
                                    bVar.a(bVar2);
                                    bVar2.b(bVar);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = map.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                return hashSet;
            }
            C4127c<?> next = it.next();
            b bVar3 = new b(next);
            for (Class<? super Object> cls : next.e()) {
                c cVar = new c(cls, !next.j());
                if (!map.containsKey(cVar)) {
                    map.put(cVar, new HashSet());
                }
                Set set2 = (Set) map.get(cVar);
                if (!set2.isEmpty() && !cVar.f32931b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                }
                set2.add(bVar3);
            }
        }
    }
}
