package rc;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.ListIterator;

/* loaded from: classes5.dex */
public class I0 extends AbstractC5276d implements H0 {

    /* renamed from: g, reason: collision with root package name */
    public static BitSet f39099g;

    /* renamed from: h, reason: collision with root package name */
    public static BitSet f39100h;

    /* renamed from: d, reason: collision with root package name */
    public LinkedList<AbstractC5276d> f39101d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f39102e;

    /* renamed from: f, reason: collision with root package name */
    public C5315x f39103f;

    static {
        BitSet bitSet = new BitSet(16);
        f39099g = bitSet;
        bitSet.set(2);
        f39099g.set(1);
        f39099g.set(3);
        f39099g.set(4);
        f39099g.set(6);
        BitSet bitSet2 = new BitSet(16);
        f39100h = bitSet2;
        bitSet2.set(0);
        f39100h.set(1);
        f39100h.set(2);
        f39100h.set(3);
        f39100h.set(4);
        f39100h.set(5);
        f39100h.set(6);
    }

    public I0() {
        this.f39101d = new LinkedList<>();
        this.f39102e = false;
        this.f39103f = null;
    }

    @Override // rc.H0
    public void a(C5315x c5315x) {
        this.f39103f = c5315x;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        float fH;
        C5315x c5315x;
        Z0 z0N = y02.n();
        Q q10 = new Q(y02.f(), y02.e());
        y02.r();
        ListIterator<AbstractC5276d> listIterator = this.f39101d.listIterator();
        int i10 = 0;
        while (true) {
            AbstractC5276d next = null;
            if (!listIterator.hasNext()) {
                this.f39103f = null;
                return q10;
            }
            AbstractC5276d next2 = listIterator.next();
            i10++;
            boolean z10 = false;
            while (next2 instanceof C5288j) {
                if (!z10) {
                    z10 = true;
                }
                if (!listIterator.hasNext()) {
                    break;
                }
                next2 = listIterator.next();
                i10++;
            }
            if (next2 instanceof tc.a) {
                tc.a aVar = (tc.a) next2;
                if (aVar.j()) {
                    next2 = aVar.i();
                    if (next2 instanceof I0) {
                        int i11 = i10 - 1;
                        this.f39101d.remove(i11);
                        this.f39101d.addAll(i11, ((I0) next2).f39101d);
                        listIterator = this.f39101d.listIterator(i11);
                        next2 = listIterator.next();
                    }
                }
            }
            C5315x c5315x2 = new C5315x(next2);
            if (listIterator.hasNext()) {
                next = listIterator.next();
                listIterator.previous();
            }
            j(c5315x2, this.f39103f, next);
            while (listIterator.hasNext() && c5315x2.e() == 0 && c5315x2.g()) {
                AbstractC5276d next3 = listIterator.next();
                int i12 = i10 + 1;
                if (!(next3 instanceof AbstractC5300p) || !f39100h.get(next3.g())) {
                    listIterator.previous();
                    break;
                }
                c5315x2.i();
                C5298o c5298oC = c5315x2.c(z0N);
                C5298o c5298oI = ((AbstractC5300p) next3).i(z0N);
                C5298o c5298oO = z0N.o(c5298oC, c5298oI);
                if (c5298oO == null) {
                    fH = z0N.h(c5298oC, c5298oI, y02.m());
                    listIterator.previous();
                    break;
                }
                c5315x2.a(new E(c5298oO));
                i10 = i12;
            }
            fH = 0.0f;
            if (listIterator.previousIndex() != 0 && (c5315x = this.f39103f) != null && !c5315x.h() && !c5315x2.h()) {
                q10.b(K.b(this.f39103f.e(), c5315x2.d(), y02));
            }
            c5315x2.j(this.f39103f);
            AbstractC5284h abstractC5284hB = c5315x2.b(y02);
            if (c5315x2.f() && (abstractC5284hB instanceof C5296n)) {
                ((C5296n) abstractC5284hB).r();
            }
            if (z10 || ((next2 instanceof C5294m) && Character.isDigit(((C5294m) next2).p()))) {
                q10.r(q10.f39310i.size());
            }
            q10.b(abstractC5284hB);
            y02.w(abstractC5284hB.i());
            if (Math.abs(fH) > 1.0E-7f) {
                q10.b(new U0(fH, 0.0f, 0.0f, 0.0f));
            }
            if (!c5315x2.h()) {
                this.f39103f = c5315x2;
            }
        }
    }

    @Override // rc.AbstractC5276d
    public int g() {
        if (this.f39101d.size() == 0) {
            return 0;
        }
        return this.f39101d.get(0).g();
    }

    @Override // rc.AbstractC5276d
    public int h() {
        if (this.f39101d.size() == 0) {
            return 0;
        }
        return this.f39101d.get(r1.size() - 1).h();
    }

    public final void i(AbstractC5276d abstractC5276d) {
        if (abstractC5276d != null) {
            this.f39101d.add(abstractC5276d);
        }
    }

    public final void j(C5315x c5315x, C5315x c5315x2, AbstractC5276d abstractC5276d) {
        if (c5315x.d() == 2 && (c5315x2 == null || f39099g.get(c5315x2.e()) || abstractC5276d == null)) {
            c5315x.k(0);
            return;
        }
        if (abstractC5276d == null || c5315x.e() != 2) {
            return;
        }
        int iG = abstractC5276d.g();
        if (iG == 3 || iG == 5 || iG == 6) {
            c5315x.k(0);
        }
    }

    public AbstractC5276d k() {
        return this.f39101d.size() != 0 ? this.f39101d.removeLast() : new R0(3, 0.0f, 0.0f, 0.0f);
    }

    public I0(AbstractC5276d abstractC5276d) {
        LinkedList<AbstractC5276d> linkedList = new LinkedList<>();
        this.f39101d = linkedList;
        this.f39102e = false;
        this.f39103f = null;
        if (abstractC5276d != null) {
            if (abstractC5276d instanceof I0) {
                linkedList.addAll(((I0) abstractC5276d).f39101d);
            } else {
                linkedList.add(abstractC5276d);
            }
        }
    }
}
