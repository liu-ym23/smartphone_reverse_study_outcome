package rc;

import java.util.LinkedList;
import java.util.ListIterator;

/* loaded from: classes5.dex */
public class o1 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public LinkedList<AbstractC5276d> f39370d = new LinkedList<>();

    /* renamed from: e, reason: collision with root package name */
    public R0 f39371e = new R0(1, 0.0f, 0.0f, 0.0f);

    /* renamed from: f, reason: collision with root package name */
    public boolean f39372f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f39373g = false;

    /* renamed from: h, reason: collision with root package name */
    public int f39374h = 5;

    public o1() {
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        float fG;
        q1 q1Var = new q1();
        if (this.f39374h != 5) {
            LinkedList linkedList = new LinkedList();
            ListIterator<AbstractC5276d> listIterator = this.f39370d.listIterator();
            float fK = Float.NEGATIVE_INFINITY;
            while (listIterator.hasNext()) {
                AbstractC5284h abstractC5284hF = listIterator.next().f(y02);
                linkedList.add(abstractC5284hF);
                if (fK < abstractC5284hF.k()) {
                    fK = abstractC5284hF.k();
                }
            }
            U0 u02 = new U0(0.0f, y02.g(), 0.0f, 0.0f);
            ListIterator listIterator2 = linkedList.listIterator();
            while (listIterator2.hasNext()) {
                q1Var.b(new Q((AbstractC5284h) listIterator2.next(), fK, this.f39374h));
                if (this.f39372f && listIterator2.hasNext()) {
                    q1Var.b(u02);
                }
            }
        } else {
            U0 u03 = new U0(0.0f, y02.g(), 0.0f, 0.0f);
            ListIterator<AbstractC5276d> listIterator3 = this.f39370d.listIterator();
            while (listIterator3.hasNext()) {
                q1Var.b(listIterator3.next().f(y02));
                if (this.f39372f && listIterator3.hasNext()) {
                    q1Var.b(u03);
                }
            }
        }
        q1Var.o(-this.f39371e.f(y02).k());
        if (this.f39373g) {
            fG = q1Var.s() != 0 ? q1Var.f39310i.getFirst().h() : 0.0f;
            q1Var.n(fG);
            q1Var.m((q1Var.g() + q1Var.h()) - fG);
            return q1Var;
        }
        fG = q1Var.s() != 0 ? q1Var.f39310i.getLast().g() : 0.0f;
        q1Var.n((q1Var.g() + q1Var.h()) - fG);
        q1Var.m(fG);
        return q1Var;
    }

    public final void i(AbstractC5276d abstractC5276d) {
        if (abstractC5276d != null) {
            this.f39370d.add(0, abstractC5276d);
        }
    }

    public final void j(AbstractC5276d abstractC5276d) {
        if (abstractC5276d != null) {
            this.f39370d.add(abstractC5276d);
        }
    }

    public void k(boolean z10) {
        this.f39372f = z10;
    }

    public void n(int i10) {
        this.f39374h = i10;
    }

    public void o(int i10, float f10) {
        this.f39371e = new R0(i10, f10, 0.0f, 0.0f);
    }

    public void p(boolean z10) {
        this.f39373g = z10;
    }

    public o1(AbstractC5276d abstractC5276d) {
        if (abstractC5276d != null) {
            if (abstractC5276d instanceof o1) {
                this.f39370d.addAll(((o1) abstractC5276d).f39370d);
            } else {
                this.f39370d.add(abstractC5276d);
            }
        }
    }
}
