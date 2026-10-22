package w;

import androidx.room.AbstractC0351g;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.util.ArrayList;
import java.util.Iterator;
import s.AbstractC0831a;
import t0.J;
import v.C0944d;
import v.C0945e;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: f, reason: collision with root package name */
    public static int f15779f;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f15780a;

    /* renamed from: b, reason: collision with root package name */
    public int f15781b;

    /* renamed from: c, reason: collision with root package name */
    public int f15782c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f15783d;

    /* renamed from: e, reason: collision with root package name */
    public int f15784e;

    public final void a(ArrayList arrayList) {
        int size = this.f15780a.size();
        if (this.f15784e != -1 && size > 0) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                o oVar = (o) arrayList.get(i4);
                if (this.f15784e == oVar.f15781b) {
                    c(this.f15782c, oVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int b(t.e eVar, int i4) {
        int iN;
        int iN2;
        ArrayList arrayList = this.f15780a;
        if (arrayList.size() == 0) {
            return 0;
        }
        C0945e c0945e = (C0945e) ((C0944d) arrayList.get(0)).T;
        eVar.t();
        c0945e.c(eVar, false);
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            ((C0944d) arrayList.get(i5)).c(eVar, false);
        }
        if (i4 == 0 && c0945e.f15611z0 > 0) {
            J.c(c0945e, eVar, arrayList, 0);
        }
        if (i4 == 1 && c0945e.f15591A0 > 0) {
            J.c(c0945e, eVar, arrayList, 1);
        }
        try {
            eVar.p();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        this.f15783d = new ArrayList();
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            this.f15783d.add(new C0968n(this, (C0944d) arrayList.get(i6), eVar, i4));
        }
        if (i4 == 0) {
            iN = t.e.n(c0945e.f15532I);
            iN2 = t.e.n(c0945e.f15534K);
            eVar.t();
        } else {
            iN = t.e.n(c0945e.f15533J);
            iN2 = t.e.n(c0945e.f15535L);
            eVar.t();
        }
        return iN2 - iN;
    }

    public final void c(int i4, o oVar) {
        Iterator it = this.f15780a.iterator();
        while (it.hasNext()) {
            C0944d c0944d = (C0944d) it.next();
            ArrayList arrayList = oVar.f15780a;
            if (!arrayList.contains(c0944d)) {
                arrayList.add(c0944d);
            }
            int i5 = oVar.f15781b;
            if (i4 == 0) {
                c0944d.f15576n0 = i5;
            } else {
                c0944d.f15578o0 = i5;
            }
        }
        this.f15784e = oVar.f15781b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int i4 = this.f15782c;
        sb.append(i4 == 0 ? "Horizontal" : i4 == 1 ? "Vertical" : i4 == 2 ? "Both" : "Unknown");
        sb.append(" [");
        String strD = AbstractC0831a.d(sb, this.f15781b, "] <");
        Iterator it = this.f15780a.iterator();
        while (it.hasNext()) {
            C0944d c0944d = (C0944d) it.next();
            StringBuilder sbV = B0.g.v(strD, AwarenessDataItem.PERMISSION_SPLITTER);
            sbV.append(c0944d.f15564h0);
            strD = sbV.toString();
        }
        return AbstractC0351g.p(strD, " >");
    }
}
