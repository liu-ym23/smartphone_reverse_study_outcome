package rc;

import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: rc.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5274c extends a1 {

    /* renamed from: o, reason: collision with root package name */
    public LinkedList<LinkedList<AbstractC5276d>> f39230o;

    /* renamed from: p, reason: collision with root package name */
    public int f39231p;

    /* renamed from: q, reason: collision with root package name */
    public int f39232q;

    public C5274c() {
        LinkedList<LinkedList<AbstractC5276d>> linkedList = new LinkedList<>();
        this.f39230o = linkedList;
        linkedList.add(new LinkedList<>());
        this.f39232q = 0;
    }

    public void n() {
        this.f39230o.get(this.f39232q).add(this.f39212d);
        this.f39212d = null;
    }

    public void o(int i10) {
        this.f39230o.get(this.f39232q).add(this.f39212d);
        for (int i11 = 1; i11 < i10 - 1; i11++) {
            this.f39230o.get(this.f39232q).add(null);
        }
        this.f39212d = null;
    }

    public void p() {
        n();
        this.f39230o.add(new LinkedList<>());
        this.f39232q++;
    }

    public void q() {
        if (this.f39230o.getLast().size() != 0 || this.f39212d != null) {
            p();
        }
        this.f39232q = this.f39230o.size() - 1;
        this.f39231p = this.f39230o.get(0).size();
        for (int i10 = 1; i10 < this.f39232q; i10++) {
            if (this.f39230o.get(i10).size() > this.f39231p) {
                this.f39231p = this.f39230o.get(i10).size();
            }
        }
        for (int i11 = 0; i11 < this.f39232q; i11++) {
            int size = this.f39230o.get(i11).size();
            if (size != this.f39231p && this.f39230o.get(i11).get(0) != null && this.f39230o.get(i11).get(0).f39248a != 11) {
                LinkedList<AbstractC5276d> linkedList = this.f39230o.get(i11);
                while (size < this.f39231p) {
                    linkedList.add(null);
                    size++;
                }
            }
        }
    }

    public o1 r() {
        o1 o1Var = new o1();
        o1Var.k(true);
        Iterator<LinkedList<AbstractC5276d>> it = this.f39230o.iterator();
        while (it.hasNext()) {
            Iterator<AbstractC5276d> it2 = it.next().iterator();
            while (it2.hasNext()) {
                o1Var.j(it2.next());
            }
        }
        return o1Var;
    }
}
