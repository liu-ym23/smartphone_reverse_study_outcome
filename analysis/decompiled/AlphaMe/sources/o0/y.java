package o0;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import f1.AbstractC0557a;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class y extends s {

    /* renamed from: D, reason: collision with root package name */
    public int f13778D;

    /* renamed from: B, reason: collision with root package name */
    public ArrayList f13776B = new ArrayList();

    /* renamed from: C, reason: collision with root package name */
    public boolean f13777C = true;

    /* renamed from: E, reason: collision with root package name */
    public boolean f13779E = false;

    /* renamed from: F, reason: collision with root package name */
    public int f13780F = 0;

    @Override // o0.s
    public final void A(ViewGroup viewGroup) {
        super.A(viewGroup);
        int size = this.f13776B.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((s) this.f13776B.get(i4)).A(viewGroup);
        }
    }

    @Override // o0.s
    public final void B() {
        if (this.f13776B.isEmpty()) {
            I();
            m();
            return;
        }
        x xVar = new x(this, 1);
        Iterator it = this.f13776B.iterator();
        while (it.hasNext()) {
            ((s) it.next()).a(xVar);
        }
        this.f13778D = this.f13776B.size();
        if (this.f13777C) {
            Iterator it2 = this.f13776B.iterator();
            while (it2.hasNext()) {
                ((s) it2.next()).B();
            }
            return;
        }
        for (int i4 = 1; i4 < this.f13776B.size(); i4++) {
            ((s) this.f13776B.get(i4 - 1)).a(new u(1, this, (s) this.f13776B.get(i4)));
        }
        s sVar = (s) this.f13776B.get(0);
        if (sVar != null) {
            sVar.B();
        }
    }

    @Override // o0.s
    public final void C(long j4) {
        ArrayList arrayList;
        this.f13745c = j4;
        if (j4 < 0 || (arrayList = this.f13776B) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((s) this.f13776B.get(i4)).C(j4);
        }
    }

    @Override // o0.s
    public final void D(AbstractC0557a abstractC0557a) {
        this.f13764v = abstractC0557a;
        this.f13780F |= 8;
        int size = this.f13776B.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((s) this.f13776B.get(i4)).D(abstractC0557a);
        }
    }

    @Override // o0.s
    public final void E(TimeInterpolator timeInterpolator) {
        this.f13780F |= 1;
        ArrayList arrayList = this.f13776B;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((s) this.f13776B.get(i4)).E(timeInterpolator);
            }
        }
        this.f13746d = timeInterpolator;
    }

    @Override // o0.s
    public final void F(E3.b bVar) {
        super.F(bVar);
        this.f13780F |= 4;
        if (this.f13776B != null) {
            for (int i4 = 0; i4 < this.f13776B.size(); i4++) {
                ((s) this.f13776B.get(i4)).F(bVar);
            }
        }
    }

    @Override // o0.s
    public final void G() {
        this.f13780F |= 2;
        int size = this.f13776B.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((s) this.f13776B.get(i4)).G();
        }
    }

    @Override // o0.s
    public final void H(long j4) {
        this.f13744b = j4;
    }

    @Override // o0.s
    public final String J(String str) {
        String strJ = super.J(str);
        for (int i4 = 0; i4 < this.f13776B.size(); i4++) {
            StringBuilder sbV = B0.g.v(strJ, "\n");
            sbV.append(((s) this.f13776B.get(i4)).J(str + "  "));
            strJ = sbV.toString();
        }
        return strJ;
    }

    public final void K(s sVar) {
        this.f13776B.add(sVar);
        sVar.f13751i = this;
        long j4 = this.f13745c;
        if (j4 >= 0) {
            sVar.C(j4);
        }
        if ((this.f13780F & 1) != 0) {
            sVar.E(this.f13746d);
        }
        if ((this.f13780F & 2) != 0) {
            sVar.G();
        }
        if ((this.f13780F & 4) != 0) {
            sVar.F(this.f13765w);
        }
        if ((this.f13780F & 8) != 0) {
            sVar.D(this.f13764v);
        }
    }

    @Override // o0.s
    public final void a(q qVar) {
        super.a(qVar);
    }

    @Override // o0.s
    public final void b(View view) {
        for (int i4 = 0; i4 < this.f13776B.size(); i4++) {
            ((s) this.f13776B.get(i4)).b(view);
        }
        this.f13748f.add(view);
    }

    @Override // o0.s
    public final void cancel() {
        super.cancel();
        int size = this.f13776B.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((s) this.f13776B.get(i4)).cancel();
        }
    }

    @Override // o0.s
    public final void d(C0785A c0785a) {
        if (u(c0785a.f13674b)) {
            Iterator it = this.f13776B.iterator();
            while (it.hasNext()) {
                s sVar = (s) it.next();
                if (sVar.u(c0785a.f13674b)) {
                    sVar.d(c0785a);
                    c0785a.f13675c.add(sVar);
                }
            }
        }
    }

    @Override // o0.s
    public final void f(C0785A c0785a) {
        int size = this.f13776B.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((s) this.f13776B.get(i4)).f(c0785a);
        }
    }

    @Override // o0.s
    public final void g(C0785A c0785a) {
        if (u(c0785a.f13674b)) {
            Iterator it = this.f13776B.iterator();
            while (it.hasNext()) {
                s sVar = (s) it.next();
                if (sVar.u(c0785a.f13674b)) {
                    sVar.g(c0785a);
                    c0785a.f13675c.add(sVar);
                }
            }
        }
    }

    @Override // o0.s
    /* renamed from: j */
    public final s clone() {
        y yVar = (y) super.clone();
        yVar.f13776B = new ArrayList();
        int size = this.f13776B.size();
        for (int i4 = 0; i4 < size; i4++) {
            s sVarClone = ((s) this.f13776B.get(i4)).clone();
            yVar.f13776B.add(sVarClone);
            sVarClone.f13751i = yVar;
        }
        return yVar;
    }

    @Override // o0.s
    public final void l(ViewGroup viewGroup, t.d dVar, t.d dVar2, ArrayList arrayList, ArrayList arrayList2) {
        long j4 = this.f13744b;
        int size = this.f13776B.size();
        for (int i4 = 0; i4 < size; i4++) {
            s sVar = (s) this.f13776B.get(i4);
            if (j4 > 0 && (this.f13777C || i4 == 0)) {
                long j5 = sVar.f13744b;
                if (j5 > 0) {
                    sVar.H(j5 + j4);
                } else {
                    sVar.H(j4);
                }
            }
            sVar.l(viewGroup, dVar, dVar2, arrayList, arrayList2);
        }
    }

    @Override // o0.s
    public final boolean s() {
        for (int i4 = 0; i4 < this.f13776B.size(); i4++) {
            if (((s) this.f13776B.get(i4)).s()) {
                return true;
            }
        }
        return false;
    }

    @Override // o0.s
    public final void x(View view) {
        super.x(view);
        int size = this.f13776B.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((s) this.f13776B.get(i4)).x(view);
        }
    }

    @Override // o0.s
    public final s y(q qVar) {
        super.y(qVar);
        return this;
    }

    @Override // o0.s
    public final void z(View view) {
        for (int i4 = 0; i4 < this.f13776B.size(); i4++) {
            ((s) this.f13776B.get(i4)).z(view);
        }
        this.f13748f.remove(view);
    }
}
