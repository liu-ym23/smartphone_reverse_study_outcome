package Zb;

import Tb.h;
import Tb.m;
import Tb.n;
import Yb.AbstractC1128b;
import Yb.u;
import ac.InterfaceC1284e;
import bc.InterfaceC1477a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final List<InterfaceC1284e> f7766a;

    /* renamed from: b, reason: collision with root package name */
    public final List<InterfaceC1477a> f7767b;

    /* renamed from: c, reason: collision with root package name */
    public final Zb.c f7768c;

    /* renamed from: d, reason: collision with root package name */
    public final List<e> f7769d;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final List<InterfaceC1284e> f7770a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final List<InterfaceC1477a> f7771b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public final List<e> f7772c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public Set<Class<? extends AbstractC1128b>> f7773d = h.s();

        /* renamed from: e, reason: collision with root package name */
        public Zb.c f7774e;

        public class a implements Zb.c {
            public a() {
            }

            @Override // Zb.c
            public Zb.a a(Zb.b bVar) {
                return new n(bVar);
            }
        }

        public d f() {
            return new d(this);
        }

        public b g(InterfaceC1284e interfaceC1284e) {
            if (interfaceC1284e == null) {
                throw new NullPointerException("blockParserFactory must not be null");
            }
            this.f7770a.add(interfaceC1284e);
            return this;
        }

        public b h(InterfaceC1477a interfaceC1477a) {
            if (interfaceC1477a == null) {
                throw new NullPointerException("delimiterProcessor must not be null");
            }
            this.f7771b.add(interfaceC1477a);
            return this;
        }

        public b i(Iterable<? extends Ob.a> iterable) {
            if (iterable == null) {
                throw new NullPointerException("extensions must not be null");
            }
            for (Ob.a aVar : iterable) {
                if (aVar instanceof c) {
                    ((c) aVar).b(this);
                }
            }
            return this;
        }

        public final Zb.c j() {
            Zb.c cVar = this.f7774e;
            return cVar != null ? cVar : new a();
        }

        public b k(Zb.c cVar) {
            this.f7774e = cVar;
            return this;
        }

        public b l(e eVar) {
            if (eVar == null) {
                throw new NullPointerException("postProcessor must not be null");
            }
            this.f7772c.add(eVar);
            return this;
        }
    }

    public interface c extends Ob.a {
        void b(b bVar);
    }

    public static b a() {
        return new b();
    }

    public final h b() {
        return new h(this.f7766a, this.f7768c, this.f7767b);
    }

    public u c(String str) {
        if (str != null) {
            return d(b().u(str));
        }
        throw new NullPointerException("input must not be null");
    }

    public final u d(u uVar) {
        Iterator<e> it = this.f7769d.iterator();
        while (it.hasNext()) {
            uVar = it.next().a(uVar);
        }
        return uVar;
    }

    public d(b bVar) {
        this.f7766a = h.l(bVar.f7770a, bVar.f7773d);
        Zb.c cVarJ = bVar.j();
        this.f7768c = cVarJ;
        this.f7769d = bVar.f7772c;
        List<InterfaceC1477a> list = bVar.f7771b;
        this.f7767b = list;
        cVarJ.a(new m(list, Collections.EMPTY_MAP));
    }
}
