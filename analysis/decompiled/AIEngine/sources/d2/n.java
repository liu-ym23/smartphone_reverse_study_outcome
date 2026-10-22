package d2;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import d2.i;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class n extends i {
    public int G;
    public ArrayList<i> E = new ArrayList<>();
    public boolean F = true;
    public boolean H = false;
    public int I = 0;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f8323a;

        public a(i iVar) {
            this.f8323a = iVar;
        }

        @Override // d2.i.d
        public final void c(i iVar) {
            this.f8323a.A();
            iVar.x(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b extends l {

        /* renamed from: a, reason: collision with root package name */
        public n f8324a;

        @Override // d2.l, d2.i.d
        public final void a(i iVar) {
            n nVar = this.f8324a;
            if (nVar.H) {
                return;
            }
            nVar.H();
            nVar.H = true;
        }

        @Override // d2.i.d
        public final void c(i iVar) {
            n nVar = this.f8324a;
            int i10 = nVar.G - 1;
            nVar.G = i10;
            if (i10 == 0) {
                nVar.H = false;
                nVar.n();
            }
            iVar.x(this);
        }
    }

    @Override // d2.i
    public final void A() {
        if (this.E.isEmpty()) {
            H();
            n();
            return;
        }
        b bVar = new b();
        bVar.f8324a = this;
        ArrayList<i> arrayList = this.E;
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            i iVar = arrayList.get(i11);
            i11++;
            iVar.b(bVar);
        }
        this.G = this.E.size();
        if (this.F) {
            ArrayList<i> arrayList2 = this.E;
            int size2 = arrayList2.size();
            while (i10 < size2) {
                i iVar2 = arrayList2.get(i10);
                i10++;
                iVar2.A();
            }
            return;
        }
        for (int i12 = 1; i12 < this.E.size(); i12++) {
            this.E.get(i12 - 1).b(new a(this.E.get(i12)));
        }
        i iVar3 = this.E.get(0);
        if (iVar3 != null) {
            iVar3.A();
        }
    }

    @Override // d2.i
    public final void B(long j10) {
        ArrayList<i> arrayList;
        this.f8284c = j10;
        if (j10 < 0 || (arrayList = this.E) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.E.get(i10).B(j10);
        }
    }

    @Override // d2.i
    public final void C(i.c cVar) {
        this.f8301y = cVar;
        this.I |= 8;
        int size = this.E.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.E.get(i10).C(cVar);
        }
    }

    @Override // d2.i
    public final void D(TimeInterpolator timeInterpolator) {
        this.I |= 1;
        ArrayList<i> arrayList = this.E;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.E.get(i10).D(timeInterpolator);
            }
        }
        this.f8285d = timeInterpolator;
    }

    @Override // d2.i
    public final void E(androidx.datastore.preferences.protobuf.f fVar) {
        super.E(fVar);
        this.I |= 4;
        if (this.E != null) {
            for (int i10 = 0; i10 < this.E.size(); i10++) {
                this.E.get(i10).E(fVar);
            }
        }
    }

    @Override // d2.i
    public final void F() {
        this.I |= 2;
        int size = this.E.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.E.get(i10).F();
        }
    }

    @Override // d2.i
    public final void G(long j10) {
        this.f8283b = j10;
    }

    @Override // d2.i
    public final String I(String str) {
        String strI = super.I(str);
        for (int i10 = 0; i10 < this.E.size(); i10++) {
            StringBuilder sbP = a0.a.p(strI, "\n");
            sbP.append(this.E.get(i10).I(str + "  "));
            strI = sbP.toString();
        }
        return strI;
    }

    public final void J(i iVar) {
        this.E.add(iVar);
        iVar.f8289l = this;
        long j10 = this.f8284c;
        if (j10 >= 0) {
            iVar.B(j10);
        }
        if ((this.I & 1) != 0) {
            iVar.D(this.f8285d);
        }
        if ((this.I & 2) != 0) {
            iVar.F();
        }
        if ((this.I & 4) != 0) {
            iVar.E(this.z);
        }
        if ((this.I & 8) != 0) {
            iVar.C(this.f8301y);
        }
    }

    @Override // d2.i
    public final void c(View view) {
        for (int i10 = 0; i10 < this.E.size(); i10++) {
            this.E.get(i10).c(view);
        }
        this.h.add(view);
    }

    @Override // d2.i
    public final void cancel() {
        super.cancel();
        int size = this.E.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.E.get(i10).cancel();
        }
    }

    @Override // d2.i
    public final void e(p pVar) {
        View view = pVar.f8326b;
        if (u(view)) {
            ArrayList<i> arrayList = this.E;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                i iVar = arrayList.get(i10);
                i10++;
                i iVar2 = iVar;
                if (iVar2.u(view)) {
                    iVar2.e(pVar);
                    pVar.f8327c.add(iVar2);
                }
            }
        }
    }

    @Override // d2.i
    public final void g(p pVar) {
        int size = this.E.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.E.get(i10).g(pVar);
        }
    }

    @Override // d2.i
    public final void h(p pVar) {
        View view = pVar.f8326b;
        if (u(view)) {
            ArrayList<i> arrayList = this.E;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                i iVar = arrayList.get(i10);
                i10++;
                i iVar2 = iVar;
                if (iVar2.u(view)) {
                    iVar2.h(pVar);
                    pVar.f8327c.add(iVar2);
                }
            }
        }
    }

    @Override // d2.i
    /* renamed from: k */
    public final i clone() {
        n nVar = (n) super.clone();
        nVar.E = new ArrayList<>();
        int size = this.E.size();
        for (int i10 = 0; i10 < size; i10++) {
            i iVarClone = this.E.get(i10).clone();
            nVar.E.add(iVarClone);
            iVarClone.f8289l = nVar;
        }
        return nVar;
    }

    @Override // d2.i
    public final void m(ViewGroup viewGroup, com.stepos.statsrpk.g gVar, com.stepos.statsrpk.g gVar2, ArrayList<p> arrayList, ArrayList<p> arrayList2) {
        long j10 = this.f8283b;
        int size = this.E.size();
        for (int i10 = 0; i10 < size; i10++) {
            i iVar = this.E.get(i10);
            if (j10 > 0 && (this.F || i10 == 0)) {
                long j11 = iVar.f8283b;
                if (j11 > 0) {
                    iVar.G(j11 + j10);
                } else {
                    iVar.G(j10);
                }
            }
            iVar.m(viewGroup, gVar, gVar2, arrayList, arrayList2);
        }
    }

    @Override // d2.i
    public final void w(View view) {
        super.w(view);
        int size = this.E.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.E.get(i10).w(view);
        }
    }

    @Override // d2.i
    public final i x(i.d dVar) {
        super.x(dVar);
        return this;
    }

    @Override // d2.i
    public final void y(View view) {
        for (int i10 = 0; i10 < this.E.size(); i10++) {
            this.E.get(i10).y(view);
        }
        this.h.remove(view);
    }

    @Override // d2.i
    public final void z(View view) {
        super.z(view);
        int size = this.E.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.E.get(i10).z(view);
        }
    }
}
