package O8;

import O8.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class c {

    public static class b extends c {

        public interface a {
            void a(h.f fVar, h.f fVar2);

            void b(h.c cVar, h.c cVar2);

            h.a c(h.a aVar);

            h.c d(h.c cVar);

            h.f e(h.f fVar);

            void f(h.a aVar, h.a aVar2);
        }

        /* renamed from: O8.c$b$b, reason: collision with other inner class name */
        public static class C0090b implements a {

            /* renamed from: a, reason: collision with root package name */
            public final Map<Integer, Object> f5263a;

            public C0090b() {
                this.f5263a = new HashMap(3);
            }

            public static int g(Object obj) {
                return System.identityHashCode(obj);
            }

            @Override // O8.c.b.a
            public void a(h.f fVar, h.f fVar2) {
                this.f5263a.put(Integer.valueOf(g(fVar)), fVar2);
            }

            @Override // O8.c.b.a
            public void b(h.c cVar, h.c cVar2) {
                this.f5263a.put(Integer.valueOf(g(cVar)), cVar2);
            }

            @Override // O8.c.b.a
            public h.a c(h.a aVar) {
                return (h.a) this.f5263a.get(Integer.valueOf(g(aVar)));
            }

            @Override // O8.c.b.a
            public h.c d(h.c cVar) {
                return (h.c) this.f5263a.get(Integer.valueOf(g(cVar)));
            }

            @Override // O8.c.b.a
            public h.f e(h.f fVar) {
                return (h.f) this.f5263a.get(Integer.valueOf(g(fVar)));
            }

            @Override // O8.c.b.a
            public void f(h.a aVar, h.a aVar2) {
                this.f5263a.put(Integer.valueOf(g(aVar)), aVar2);
            }
        }

        @Override // O8.c
        public h.a a(h.a aVar) {
            return d(new C0090b(), aVar);
        }

        @Override // O8.c
        public h.f b(h.f fVar) {
            return f(new C0090b(), fVar);
        }

        public final h.a d(a aVar, h.a aVar2) {
            h.a aVarC = aVar.c(aVar2);
            if (aVarC != null) {
                return aVarC;
            }
            List<h.f> listA = aVar2.a();
            ArrayList arrayList = new ArrayList(listA.size());
            d dVar = new d(aVar2.name(), arrayList);
            aVar.f(aVar2, dVar);
            Iterator<h.f> it = listA.iterator();
            while (it.hasNext()) {
                arrayList.add(f(aVar, it.next()));
            }
            return dVar;
        }

        public final h.c e(a aVar, h.c cVar) {
            h.c cVarD = aVar.d(cVar);
            if (cVarD != null) {
                return cVarD;
            }
            h.a aVarD = cVar.d();
            g gVar = new g(cVar.e(), cVar.f(), cVar.c(), cVar.a(), aVarD != null ? d(aVar, aVarD) : null);
            aVar.b(cVar, gVar);
            return gVar;
        }

        public final h.f f(a aVar, h.f fVar) {
            h.f fVarE = aVar.e(fVar);
            if (fVarE != null) {
                return fVarE;
            }
            List<h.c> listA = fVar.a();
            ArrayList arrayList = new ArrayList(listA.size());
            l lVar = new l(fVar.name(), arrayList);
            aVar.a(fVar, lVar);
            Iterator<h.c> it = listA.iterator();
            while (it.hasNext()) {
                arrayList.add(e(aVar, it.next()));
            }
            return lVar;
        }
    }

    public static c c() {
        return new b();
    }

    public abstract h.a a(h.a aVar);

    public abstract h.f b(h.f fVar);
}
