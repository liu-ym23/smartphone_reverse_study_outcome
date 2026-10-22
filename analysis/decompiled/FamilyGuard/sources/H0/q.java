package H0;

import A0.d;
import H0.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import z0.C1342h;
import z0.EnumC1335a;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
class q<Model, Data> implements n<Model, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final List<n<Model, Data>> f2010a;

    /* renamed from: b, reason: collision with root package name */
    private final D.e<List<Throwable>> f2011b;

    static class a<Data> implements A0.d<Data>, d.a<Data> {

        /* renamed from: a, reason: collision with root package name */
        private final List<A0.d<Data>> f2012a;

        /* renamed from: b, reason: collision with root package name */
        private final D.e<List<Throwable>> f2013b;

        /* renamed from: c, reason: collision with root package name */
        private int f2014c;

        /* renamed from: d, reason: collision with root package name */
        private v0.g f2015d;

        /* renamed from: e, reason: collision with root package name */
        private d.a<? super Data> f2016e;

        /* renamed from: f, reason: collision with root package name */
        private List<Throwable> f2017f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f2018g;

        a(List<A0.d<Data>> list, D.e<List<Throwable>> eVar) {
            this.f2013b = eVar;
            X0.j.c(list);
            this.f2012a = list;
            this.f2014c = 0;
        }

        private void g() {
            if (this.f2018g) {
                return;
            }
            if (this.f2014c < this.f2012a.size() - 1) {
                this.f2014c++;
                e(this.f2015d, this.f2016e);
            } else {
                X0.j.d(this.f2017f);
                this.f2016e.c(new C0.q("Fetch failed", new ArrayList(this.f2017f)));
            }
        }

        @Override // A0.d
        public Class<Data> a() {
            return this.f2012a.get(0).a();
        }

        @Override // A0.d
        public void b() {
            List<Throwable> list = this.f2017f;
            if (list != null) {
                this.f2013b.a(list);
            }
            this.f2017f = null;
            Iterator<A0.d<Data>> it = this.f2012a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }

        @Override // A0.d.a
        public void c(Exception exc) {
            ((List) X0.j.d(this.f2017f)).add(exc);
            g();
        }

        @Override // A0.d
        public void cancel() {
            this.f2018g = true;
            Iterator<A0.d<Data>> it = this.f2012a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        @Override // A0.d
        public EnumC1335a d() {
            return this.f2012a.get(0).d();
        }

        @Override // A0.d
        public void e(v0.g gVar, d.a<? super Data> aVar) {
            this.f2015d = gVar;
            this.f2016e = aVar;
            this.f2017f = this.f2013b.b();
            this.f2012a.get(this.f2014c).e(gVar, this);
            if (this.f2018g) {
                cancel();
            }
        }

        @Override // A0.d.a
        public void f(Data data) {
            if (data != null) {
                this.f2016e.f(data);
            } else {
                g();
            }
        }
    }

    q(List<n<Model, Data>> list, D.e<List<Throwable>> eVar) {
        this.f2010a = list;
        this.f2011b = eVar;
    }

    @Override // H0.n
    public boolean a(Model model) {
        Iterator<n<Model, Data>> it = this.f2010a.iterator();
        while (it.hasNext()) {
            if (it.next().a(model)) {
                return true;
            }
        }
        return false;
    }

    @Override // H0.n
    public n.a<Data> b(Model model, int i5, int i6, C1342h c1342h) {
        n.a<Data> aVarB;
        int size = this.f2010a.size();
        ArrayList arrayList = new ArrayList(size);
        InterfaceC1340f interfaceC1340f = null;
        for (int i7 = 0; i7 < size; i7++) {
            n<Model, Data> nVar = this.f2010a.get(i7);
            if (nVar.a(model) && (aVarB = nVar.b(model, i5, i6, c1342h)) != null) {
                interfaceC1340f = aVarB.f2003a;
                arrayList.add(aVarB.f2005c);
            }
        }
        if (arrayList.isEmpty() || interfaceC1340f == null) {
            return null;
        }
        return new n.a<>(interfaceC1340f, new a(arrayList, this.f2011b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f2010a.toArray()) + '}';
    }
}
