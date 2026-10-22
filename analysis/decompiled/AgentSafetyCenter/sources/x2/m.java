package x2;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: f, reason: collision with root package name */
    public static int f15552f;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f15553a;

    /* renamed from: b, reason: collision with root package name */
    public int f15554b;

    /* renamed from: c, reason: collision with root package name */
    public int f15555c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f15556d;

    /* renamed from: e, reason: collision with root package name */
    public int f15557e;

    public final void a(ArrayList arrayList) {
        int size = this.f15553a.size();
        if (this.f15557e != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                m mVar = (m) arrayList.get(i);
                if (this.f15557e == mVar.f15554b) {
                    c(this.f15555c, mVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int b(u2.c cVar, int i) {
        int iN;
        int iN2;
        ArrayList arrayList = this.f15553a;
        if (arrayList.size() == 0) {
            return 0;
        }
        w2.f fVar = (w2.f) ((w2.e) arrayList.get(0)).S;
        cVar.t();
        fVar.b(cVar, false);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            ((w2.e) arrayList.get(i3)).b(cVar, false);
        }
        if (i == 0 && fVar.f15205y0 > 0) {
            w2.h.a(fVar, cVar, arrayList, 0);
        }
        if (i == 1 && fVar.f15206z0 > 0) {
            w2.h.a(fVar, cVar, arrayList, 1);
        }
        try {
            cVar.p();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f15556d = new ArrayList();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            w2.e eVar = (w2.e) arrayList.get(i10);
            r2.i iVar = new r2.i(26);
            new WeakReference(eVar);
            u2.c.n(eVar.H);
            u2.c.n(eVar.I);
            u2.c.n(eVar.J);
            u2.c.n(eVar.K);
            u2.c.n(eVar.L);
            this.f15556d.add(iVar);
        }
        if (i == 0) {
            iN = u2.c.n(fVar.H);
            iN2 = u2.c.n(fVar.J);
            cVar.t();
        } else {
            iN = u2.c.n(fVar.I);
            iN2 = u2.c.n(fVar.K);
            cVar.t();
        }
        return iN2 - iN;
    }

    public final void c(int i, m mVar) {
        int i3 = mVar.f15554b;
        ArrayList arrayList = this.f15553a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            w2.e eVar = (w2.e) obj;
            ArrayList arrayList2 = mVar.f15553a;
            if (!arrayList2.contains(eVar)) {
                arrayList2.add(eVar);
            }
            if (i == 0) {
                eVar.f15180m0 = i3;
            } else {
                eVar.f15182n0 = i3;
            }
        }
        this.f15557e = i3;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        int i = this.f15555c;
        sb2.append(i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : "Unknown");
        sb2.append(" [");
        String strR = k0.a.r(sb2, this.f15554b, "] <");
        ArrayList arrayList = this.f15553a;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            StringBuilder sbV = k0.a.v(strR, " ");
            sbV.append(((w2.e) obj).f15169g0);
            strR = sbV.toString();
        }
        return strR.concat(" >");
    }
}
