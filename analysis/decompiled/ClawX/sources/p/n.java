package p;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: f, reason: collision with root package name */
    public static int f4628f;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f4629a;

    /* renamed from: b, reason: collision with root package name */
    public int f4630b;

    /* renamed from: c, reason: collision with root package name */
    public int f4631c;
    public ArrayList d;

    /* renamed from: e, reason: collision with root package name */
    public int f4632e;

    public final void a(ArrayList arrayList) {
        int size = this.f4629a.size();
        if (this.f4632e != -1 && size > 0) {
            for (int i8 = 0; i8 < arrayList.size(); i8++) {
                n nVar = (n) arrayList.get(i8);
                if (this.f4632e == nVar.f4630b) {
                    c(this.f4631c, nVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int b(m.c cVar, int i8) {
        int iN;
        int iN2;
        ArrayList arrayList = this.f4629a;
        if (arrayList.size() == 0) {
            return 0;
        }
        o.e eVar = (o.e) ((o.d) arrayList.get(0)).S;
        cVar.t();
        eVar.b(cVar, false);
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            ((o.d) arrayList.get(i9)).b(cVar, false);
        }
        if (i8 == 0 && eVar.f4258y0 > 0) {
            o.j.a(eVar, cVar, arrayList, 0);
        }
        if (i8 == 1 && eVar.f4259z0 > 0) {
            o.j.a(eVar, cVar, arrayList, 1);
        }
        try {
            cVar.p();
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        this.d = new ArrayList();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            o.d dVar = (o.d) arrayList.get(i10);
            t1.f fVar = new t1.f(29);
            new WeakReference(dVar);
            m.c.n(dVar.H);
            m.c.n(dVar.I);
            m.c.n(dVar.J);
            m.c.n(dVar.K);
            m.c.n(dVar.L);
            this.d.add(fVar);
        }
        if (i8 == 0) {
            iN = m.c.n(eVar.H);
            iN2 = m.c.n(eVar.J);
            cVar.t();
        } else {
            iN = m.c.n(eVar.I);
            iN2 = m.c.n(eVar.K);
            cVar.t();
        }
        return iN2 - iN;
    }

    public final void c(int i8, n nVar) {
        int i9 = nVar.f4630b;
        ArrayList arrayList = this.f4629a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            o.d dVar = (o.d) obj;
            ArrayList arrayList2 = nVar.f4629a;
            if (!arrayList2.contains(dVar)) {
                arrayList2.add(dVar);
            }
            if (i8 == 0) {
                dVar.f4235m0 = i9;
            } else {
                dVar.f4237n0 = i9;
            }
        }
        this.f4632e = i9;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int i8 = this.f4631c;
        sb.append(i8 == 0 ? "Horizontal" : i8 == 1 ? "Vertical" : i8 == 2 ? "Both" : "Unknown");
        sb.append(" [");
        String strE = m0.f.e(sb, this.f4630b, "] <");
        ArrayList arrayList = this.f4629a;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            strE = strE + " " + ((o.d) obj).f4224g0;
        }
        return a8.b.n(strE, " >");
    }
}
