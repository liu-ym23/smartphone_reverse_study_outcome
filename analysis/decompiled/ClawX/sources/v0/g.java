package v0;

import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g extends y {

    /* renamed from: g, reason: collision with root package name */
    public boolean f5815g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f5816h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f5817i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f5818j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f5819k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f5820l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f5821m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f5822n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f5823o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f5824p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f5825q;

    /* renamed from: r, reason: collision with root package name */
    public ArrayList f5826r;

    public static void e(ArrayList arrayList) {
        int size = arrayList.size() - 1;
        if (size < 0) {
            return;
        }
        ((n0) arrayList.get(size)).getClass();
        throw null;
    }

    @Override // v0.y
    public final void b(n0 n0Var) {
        n0Var.getClass();
        throw null;
    }

    @Override // v0.y
    public final void c() {
        ArrayList arrayList = this.f5822n;
        ArrayList arrayList2 = this.f5820l;
        ArrayList arrayList3 = this.f5821m;
        ArrayList arrayList4 = this.f5819k;
        ArrayList arrayList5 = this.f5817i;
        ArrayList arrayList6 = this.f5816h;
        ArrayList arrayList7 = this.f5818j;
        int size = arrayList7.size() - 1;
        if (size >= 0) {
            ((f) arrayList7.get(size)).getClass();
            throw null;
        }
        for (int size2 = arrayList6.size() - 1; size2 >= 0; size2--) {
            a((n0) arrayList6.get(size2));
            arrayList6.remove(size2);
        }
        int size3 = arrayList5.size() - 1;
        if (size3 >= 0) {
            ((n0) arrayList5.get(size3)).getClass();
            throw null;
        }
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            ((e) arrayList4.get(size4)).getClass();
        }
        arrayList4.clear();
        if (d()) {
            for (int size5 = arrayList3.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList8 = (ArrayList) arrayList3.get(size5);
                int size6 = arrayList8.size() - 1;
                if (size6 >= 0) {
                    ((f) arrayList8.get(size6)).getClass();
                    throw null;
                }
            }
            for (int size7 = arrayList2.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList9 = (ArrayList) arrayList2.get(size7);
                int size8 = arrayList9.size() - 1;
                if (size8 >= 0) {
                    ((n0) arrayList9.get(size8)).getClass();
                    throw null;
                }
            }
            for (int size9 = arrayList.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList10 = (ArrayList) arrayList.get(size9);
                for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                    ((e) arrayList10.get(size10)).getClass();
                    if (arrayList10.isEmpty()) {
                        arrayList.remove(arrayList10);
                    }
                }
            }
            e(this.f5825q);
            e(this.f5824p);
            e(this.f5823o);
            e(this.f5826r);
            ArrayList arrayList11 = this.f5944b;
            if (arrayList11.size() > 0) {
                arrayList11.get(0).getClass();
                throw new ClassCastException();
            }
            arrayList11.clear();
        }
    }

    @Override // v0.y
    public final boolean d() {
        return (this.f5817i.isEmpty() && this.f5819k.isEmpty() && this.f5818j.isEmpty() && this.f5816h.isEmpty() && this.f5824p.isEmpty() && this.f5825q.isEmpty() && this.f5823o.isEmpty() && this.f5826r.isEmpty() && this.f5821m.isEmpty() && this.f5820l.isEmpty() && this.f5822n.isEmpty()) ? false : true;
    }

    public final void f() {
        if (d()) {
            return;
        }
        ArrayList arrayList = this.f5944b;
        if (arrayList.size() <= 0) {
            arrayList.clear();
        } else {
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final void g(ArrayList arrayList, n0 n0Var) {
        int size = arrayList.size() - 1;
        if (size < 0) {
            return;
        }
        ((e) arrayList.get(size)).getClass();
        n0Var.getClass();
        throw null;
    }
}
