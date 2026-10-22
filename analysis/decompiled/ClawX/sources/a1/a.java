package a1;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends o {
    public ArrayList B;
    public boolean C;
    public int D;
    public boolean E;
    public int F;

    @Override // a1.o
    public final void A(long j4) {
        ArrayList arrayList;
        this.f43c = j4;
        if (j4 < 0 || (arrayList = this.B) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((o) this.B.get(i8)).A(j4);
        }
    }

    @Override // a1.o
    public final void B(a.a aVar) {
        this.F |= 8;
        int size = this.B.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((o) this.B.get(i8)).B(aVar);
        }
    }

    @Override // a1.o
    public final void C(TimeInterpolator timeInterpolator) {
        this.F |= 1;
        ArrayList arrayList = this.B;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i8 = 0; i8 < size; i8++) {
                ((o) this.B.get(i8)).C(timeInterpolator);
            }
        }
        this.d = timeInterpolator;
    }

    @Override // a1.o
    public final void D(t1.f fVar) {
        super.D(fVar);
        this.F |= 4;
        if (this.B != null) {
            for (int i8 = 0; i8 < this.B.size(); i8++) {
                ((o) this.B.get(i8)).D(fVar);
            }
        }
    }

    @Override // a1.o
    public final void E() {
        this.F |= 2;
        int size = this.B.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((o) this.B.get(i8)).E();
        }
    }

    @Override // a1.o
    public final void F(long j4) {
        this.f42b = j4;
    }

    @Override // a1.o
    public final String H(String str) {
        String strH = super.H(str);
        for (int i8 = 0; i8 < this.B.size(); i8++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strH);
            sb.append("\n");
            sb.append(((o) this.B.get(i8)).H(str + "  "));
            strH = sb.toString();
        }
        return strH;
    }

    public final void I(o oVar) {
        this.B.add(oVar);
        oVar.f48j = this;
        long j4 = this.f43c;
        if (j4 >= 0) {
            oVar.A(j4);
        }
        if ((this.F & 1) != 0) {
            oVar.C(this.d);
        }
        if ((this.F & 2) != 0) {
            oVar.E();
        }
        if ((this.F & 4) != 0) {
            oVar.D(this.f61w);
        }
        if ((this.F & 8) != 0) {
            oVar.B(null);
        }
    }

    @Override // a1.o
    public final void c() {
        super.c();
        int size = this.B.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((o) this.B.get(i8)).c();
        }
    }

    @Override // a1.o
    public final void d(v vVar) {
        View view = vVar.f72b;
        if (t(view)) {
            ArrayList arrayList = this.B;
            int size = arrayList.size();
            int i8 = 0;
            while (i8 < size) {
                Object obj = arrayList.get(i8);
                i8++;
                o oVar = (o) obj;
                if (oVar.t(view)) {
                    oVar.d(vVar);
                    vVar.f73c.add(oVar);
                }
            }
        }
    }

    @Override // a1.o
    public final void f(v vVar) {
        int size = this.B.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((o) this.B.get(i8)).f(vVar);
        }
    }

    @Override // a1.o
    public final void g(v vVar) {
        View view = vVar.f72b;
        if (t(view)) {
            ArrayList arrayList = this.B;
            int size = arrayList.size();
            int i8 = 0;
            while (i8 < size) {
                Object obj = arrayList.get(i8);
                i8++;
                o oVar = (o) obj;
                if (oVar.t(view)) {
                    oVar.g(vVar);
                    vVar.f73c.add(oVar);
                }
            }
        }
    }

    @Override // a1.o
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final o clone() {
        a aVar = (a) super.clone();
        aVar.B = new ArrayList();
        int size = this.B.size();
        for (int i8 = 0; i8 < size; i8++) {
            o oVarClone = ((o) this.B.get(i8)).clone();
            aVar.B.add(oVarClone);
            oVarClone.f48j = aVar;
        }
        return aVar;
    }

    @Override // a1.o
    public final void l(ViewGroup viewGroup, w wVar, w wVar2, ArrayList arrayList, ArrayList arrayList2) {
        long j4 = this.f42b;
        int size = this.B.size();
        for (int i8 = 0; i8 < size; i8++) {
            o oVar = (o) this.B.get(i8);
            if (j4 > 0 && (this.C || i8 == 0)) {
                long j8 = oVar.f42b;
                if (j8 > 0) {
                    oVar.F(j8 + j4);
                } else {
                    oVar.F(j4);
                }
            }
            oVar.l(viewGroup, wVar, wVar2, arrayList, arrayList2);
        }
    }

    @Override // a1.o
    public final void w(View view) {
        super.w(view);
        int size = this.B.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((o) this.B.get(i8)).w(view);
        }
    }

    @Override // a1.o
    public final o x(m mVar) {
        super.x(mVar);
        return this;
    }

    @Override // a1.o
    public final void y(View view) {
        super.y(view);
        int size = this.B.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((o) this.B.get(i8)).y(view);
        }
    }

    @Override // a1.o
    public final void z() {
        if (this.B.isEmpty()) {
            G();
            m();
            return;
        }
        t tVar = new t();
        tVar.f70b = this;
        ArrayList arrayList = this.B;
        int size = arrayList.size();
        int i8 = 0;
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            ((o) obj).a(tVar);
        }
        this.D = this.B.size();
        if (this.C) {
            ArrayList arrayList2 = this.B;
            int size2 = arrayList2.size();
            while (i8 < size2) {
                Object obj2 = arrayList2.get(i8);
                i8++;
                ((o) obj2).z();
            }
            return;
        }
        for (int i10 = 1; i10 < this.B.size(); i10++) {
            ((o) this.B.get(i10 - 1)).a(new t((o) this.B.get(i10)));
        }
        o oVar = (o) this.B.get(0);
        if (oVar != null) {
            oVar.z();
        }
    }
}
