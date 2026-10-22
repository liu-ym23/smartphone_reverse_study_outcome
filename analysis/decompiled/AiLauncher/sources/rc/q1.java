package rc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/* loaded from: classes5.dex */
public class q1 extends AbstractC5284h {

    /* renamed from: n, reason: collision with root package name */
    public float f39380n;

    /* renamed from: o, reason: collision with root package name */
    public float f39381o;

    public q1() {
        this.f39380n = Float.MAX_VALUE;
        this.f39381o = -3.4028235E38f;
    }

    @Override // rc.AbstractC5284h
    public void a(int i10, AbstractC5284h abstractC5284h) {
        super.a(i10, abstractC5284h);
        if (i10 == 0) {
            this.f39307f += abstractC5284h.f39307f + this.f39306e;
            this.f39306e = abstractC5284h.f39306e;
        } else {
            this.f39307f += abstractC5284h.f39306e + abstractC5284h.f39307f;
        }
        t(abstractC5284h);
    }

    @Override // rc.AbstractC5284h
    public final void b(AbstractC5284h abstractC5284h) {
        super.b(abstractC5284h);
        if (this.f39310i.size() == 1) {
            this.f39306e = abstractC5284h.f39306e;
            this.f39307f = abstractC5284h.f39307f;
        } else {
            this.f39307f += abstractC5284h.f39306e + abstractC5284h.f39307f;
        }
        t(abstractC5284h);
    }

    @Override // rc.AbstractC5284h
    public void c(Cc.f fVar, float f10, float f11) {
        float fG = f11 - this.f39306e;
        Iterator<AbstractC5284h> it = this.f39310i.iterator();
        while (it.hasNext()) {
            AbstractC5284h next = it.next();
            float fH = fG + next.h();
            next.c(fVar, (next.j() + f10) - this.f39380n, fH);
            fG = fH + next.g();
        }
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

    public final void r(AbstractC5284h abstractC5284h, float f10) {
        if (this.f39310i.size() >= 1) {
            b(new U0(0.0f, f10, 0.0f, 0.0f));
        }
        b(abstractC5284h);
    }

    public int s() {
        return this.f39310i.size();
    }

    public final void t(AbstractC5284h abstractC5284h) {
        this.f39380n = Math.min(this.f39380n, abstractC5284h.f39308g);
        float f10 = this.f39381o;
        float f11 = abstractC5284h.f39308g;
        float f12 = abstractC5284h.f39305d;
        if (f12 <= 0.0f) {
            f12 = 0.0f;
        }
        float fMax = Math.max(f10, f11 + f12);
        this.f39381o = fMax;
        this.f39305d = fMax - this.f39380n;
    }

    public q1(AbstractC5284h abstractC5284h, float f10, int i10) {
        this();
        b(abstractC5284h);
        if (i10 == 2) {
            float f11 = f10 / 2.0f;
            U0 u02 = new U0(0.0f, f11, 0.0f, 0.0f);
            super.a(0, u02);
            this.f39306e += f11;
            this.f39307f += f11;
            super.b(u02);
            return;
        }
        if (i10 == 3) {
            this.f39307f += f10;
            super.b(new U0(0.0f, f10, 0.0f, 0.0f));
        } else if (i10 == 4) {
            this.f39306e += f10;
            super.a(0, new U0(0.0f, f10, 0.0f, 0.0f));
        }
    }
}
