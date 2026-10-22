package rc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes5.dex */
public class Q extends AbstractC5284h {

    /* renamed from: n, reason: collision with root package name */
    public float f39146n;

    /* renamed from: o, reason: collision with root package name */
    public List<Integer> f39147o;

    public Q(AbstractC5284h abstractC5284h, float f10, int i10) {
        this.f39146n = 0.0f;
        if (f10 == Float.POSITIVE_INFINITY) {
            b(abstractC5284h);
            return;
        }
        float fK = f10 - abstractC5284h.k();
        if (fK <= 0.0f) {
            b(abstractC5284h);
            return;
        }
        if (i10 == 2 || i10 == 5) {
            U0 u02 = new U0(fK / 2.0f, 0.0f, 0.0f, 0.0f);
            b(u02);
            b(abstractC5284h);
            b(u02);
            return;
        }
        if (i10 == 0) {
            b(abstractC5284h);
            b(new U0(fK, 0.0f, 0.0f, 0.0f));
        } else if (i10 != 1) {
            b(abstractC5284h);
        } else {
            b(new U0(fK, 0.0f, 0.0f, 0.0f));
            b(abstractC5284h);
        }
    }

    @Override // rc.AbstractC5284h
    public final void a(int i10, AbstractC5284h abstractC5284h) {
        t(abstractC5284h);
        super.a(i10, abstractC5284h);
    }

    @Override // rc.AbstractC5284h
    public final void b(AbstractC5284h abstractC5284h) {
        t(abstractC5284h);
        super.b(abstractC5284h);
    }

    @Override // rc.AbstractC5284h
    public void c(Cc.f fVar, float f10, float f11) {
        q(fVar, f10, f11);
        Iterator<AbstractC5284h> it = this.f39310i.iterator();
        while (it.hasNext()) {
            AbstractC5284h next = it.next();
            next.c(fVar, f10, next.f39308g + f11);
            f10 += next.k();
        }
        f(fVar);
    }

    @Override // rc.AbstractC5284h
    public int i() {
        LinkedList<AbstractC5284h> linkedList = this.f39310i;
        ListIterator<AbstractC5284h> listIterator = linkedList.listIterator(linkedList.size());
        int i10 = -1;
        while (i10 == -1 && listIterator.hasPrevious()) {
            i10 = listIterator.previous().i();
        }
        return i10;
    }

    public void r(int i10) {
        if (this.f39147o == null) {
            this.f39147o = new ArrayList();
        }
        this.f39147o.add(Integer.valueOf(i10));
    }

    public Q s() {
        Q q10 = new Q(this.f39302a, this.f39303b);
        q10.f39308g = this.f39308g;
        return q10;
    }

    public final void t(AbstractC5284h abstractC5284h) {
        this.f39305d += abstractC5284h.k();
        this.f39306e = Math.max(this.f39310i.size() == 0 ? Float.NEGATIVE_INFINITY : this.f39306e, abstractC5284h.f39306e - abstractC5284h.f39308g);
        this.f39307f = Math.max(this.f39310i.size() != 0 ? this.f39307f : Float.NEGATIVE_INFINITY, abstractC5284h.f39307f + abstractC5284h.f39308g);
    }

    public Q[] u(int i10) {
        return v(i10, 1);
    }

    public final Q[] v(int i10, int i11) {
        Q qS = s();
        Q qS2 = s();
        for (int i12 = 0; i12 <= i10; i12++) {
            qS.b(this.f39310i.get(i12));
        }
        for (int i13 = i11 + i10; i13 < this.f39310i.size(); i13++) {
            qS2.b(this.f39310i.get(i13));
        }
        if (this.f39147o != null) {
            for (int i14 = 0; i14 < this.f39147o.size(); i14++) {
                if (this.f39147o.get(i14).intValue() > i10 + 1) {
                    qS2.r((this.f39147o.get(i14).intValue() - i10) - 1);
                }
            }
        }
        return new Q[]{qS, qS2};
    }

    public Q[] w(int i10) {
        return v(i10, 2);
    }

    public Q(AbstractC5284h abstractC5284h) {
        this.f39146n = 0.0f;
        b(abstractC5284h);
    }

    public Q() {
        this.f39146n = 0.0f;
    }

    public Q(Cc.c cVar, Cc.c cVar2) {
        super(cVar, cVar2);
        this.f39146n = 0.0f;
    }
}
