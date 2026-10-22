package K8;

import K8.a;
import Yb.u;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;
import u8.e;
import u8.j;

/* loaded from: classes4.dex */
public class b extends K8.a {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray<a.b<u, a.c>> f4128a;

    /* renamed from: b, reason: collision with root package name */
    public final a.b<u, a.c> f4129b;

    /* renamed from: c, reason: collision with root package name */
    public final j f4130c;

    /* renamed from: d, reason: collision with root package name */
    public LayoutInflater f4131d;

    /* renamed from: e, reason: collision with root package name */
    public e f4132e;

    /* renamed from: f, reason: collision with root package name */
    public List<u> f4133f;

    public static class a implements a.InterfaceC0066a {

        /* renamed from: a, reason: collision with root package name */
        public final SparseArray<a.b<u, a.c>> f4134a = new SparseArray<>(3);

        /* renamed from: b, reason: collision with root package name */
        public final a.b<u, a.c> f4135b;

        /* renamed from: c, reason: collision with root package name */
        public j f4136c;

        public a(a.b<u, a.c> bVar) {
            this.f4135b = bVar;
        }

        @Override // K8.a.InterfaceC0066a
        public <N extends u> a.InterfaceC0066a a(Class<N> cls, a.b<? super N, ? extends a.c> bVar) {
            this.f4134a.append(cls.hashCode(), bVar);
            return this;
        }

        @Override // K8.a.InterfaceC0066a
        public K8.a build() {
            if (this.f4136c == null) {
                this.f4136c = j.a();
            }
            return new b(this.f4134a, this.f4135b, this.f4136c);
        }
    }

    public b(SparseArray<a.b<u, a.c>> sparseArray, a.b<u, a.c> bVar, j jVar) {
        this.f4128a = sparseArray;
        this.f4129b = bVar;
        this.f4130c = jVar;
        setHasStableIds(true);
    }

    @Override // K8.a
    public void e(e eVar, String str) {
        k(eVar, eVar.d(str));
    }

    public final a.b<u, a.c> f(int i10) {
        return i10 == 0 ? this.f4129b : this.f4128a.get(i10);
    }

    public int g(Class<? extends u> cls) {
        int iHashCode = cls.hashCode();
        if (this.f4128a.indexOfKey(iHashCode) > -1) {
            return iHashCode;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<u> list = this.f4133f;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        u uVar = this.f4133f.get(i10);
        return f(g(uVar.getClass())).d(uVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        return g(this.f4133f.get(i10).getClass());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a.c cVar, int i10) {
        u uVar = this.f4133f.get(i10);
        f(g(uVar.getClass())).a(this.f4132e, cVar, uVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public a.c onCreateViewHolder(ViewGroup viewGroup, int i10) {
        if (this.f4131d == null) {
            this.f4131d = LayoutInflater.from(viewGroup.getContext());
        }
        return f(i10).c(this.f4131d, viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(a.c cVar) {
        super.onViewRecycled(cVar);
        f(cVar.getItemViewType()).e(cVar);
    }

    public void k(e eVar, u uVar) {
        l(eVar, this.f4130c.b(uVar));
    }

    public void l(e eVar, List<u> list) {
        this.f4129b.b();
        int size = this.f4128a.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f4128a.valueAt(i10).b();
        }
        this.f4132e = eVar;
        this.f4133f = list;
    }
}
