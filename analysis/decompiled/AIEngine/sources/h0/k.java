package h0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: f, reason: collision with root package name */
    public static int f9199f;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<ConstraintWidget> f9200a;

    /* renamed from: b, reason: collision with root package name */
    public int f9201b;

    /* renamed from: c, reason: collision with root package name */
    public int f9202c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<a> f9203d;

    /* renamed from: e, reason: collision with root package name */
    public int f9204e;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {
    }

    public final void a(ArrayList<k> arrayList) {
        int size = this.f9200a.size();
        if (this.f9204e != -1 && size > 0) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                k kVar = arrayList.get(i10);
                if (this.f9204e == kVar.f9201b) {
                    c(this.f9202c, kVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int b(androidx.constraintlayout.core.c cVar, int i10) {
        int iN;
        int iN2;
        ArrayList<ConstraintWidget> arrayList = this.f9200a;
        if (arrayList.size() == 0) {
            return 0;
        }
        androidx.constraintlayout.core.widgets.d dVar = (androidx.constraintlayout.core.widgets.d) arrayList.get(0).V;
        cVar.t();
        dVar.b(cVar, false);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            arrayList.get(i11).b(cVar, false);
        }
        if (i10 == 0 && dVar.A0 > 0) {
            androidx.constraintlayout.core.widgets.b.a(dVar, cVar, arrayList, 0);
        }
        if (i10 == 1 && dVar.B0 > 0) {
            androidx.constraintlayout.core.widgets.b.a(dVar, cVar, arrayList, 1);
        }
        try {
            cVar.p();
        } catch (Exception e10) {
            System.err.println(e10.toString() + "\n" + Arrays.toString(e10.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        }
        this.f9203d = new ArrayList<>();
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            ConstraintWidget constraintWidget = arrayList.get(i12);
            a aVar = new a();
            new WeakReference(constraintWidget);
            androidx.constraintlayout.core.c.n(constraintWidget.J);
            androidx.constraintlayout.core.c.n(constraintWidget.K);
            androidx.constraintlayout.core.c.n(constraintWidget.L);
            androidx.constraintlayout.core.c.n(constraintWidget.M);
            androidx.constraintlayout.core.c.n(constraintWidget.N);
            this.f9203d.add(aVar);
        }
        if (i10 == 0) {
            iN = androidx.constraintlayout.core.c.n(dVar.J);
            iN2 = androidx.constraintlayout.core.c.n(dVar.L);
            cVar.t();
        } else {
            iN = androidx.constraintlayout.core.c.n(dVar.K);
            iN2 = androidx.constraintlayout.core.c.n(dVar.M);
            cVar.t();
        }
        return iN2 - iN;
    }

    public final void c(int i10, k kVar) {
        int i11 = kVar.f9201b;
        ArrayList<ConstraintWidget> arrayList = this.f9200a;
        int size = arrayList.size();
        int i12 = 0;
        while (i12 < size) {
            ConstraintWidget constraintWidget = arrayList.get(i12);
            i12++;
            ConstraintWidget constraintWidget2 = constraintWidget;
            ArrayList<ConstraintWidget> arrayList2 = kVar.f9200a;
            if (!arrayList2.contains(constraintWidget2)) {
                arrayList2.add(constraintWidget2);
            }
            if (i10 == 0) {
                constraintWidget2.f1127p0 = i11;
            } else {
                constraintWidget2.q0 = i11;
            }
        }
        this.f9204e = i11;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        int i10 = this.f9202c;
        sb2.append(i10 == 0 ? "Horizontal" : i10 == 1 ? "Vertical" : i10 == 2 ? "Both" : "Unknown");
        sb2.append(" [");
        String strJ = ai.onnxruntime.a.j("] <", this.f9201b, sb2);
        ArrayList<ConstraintWidget> arrayList = this.f9200a;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            ConstraintWidget constraintWidget = arrayList.get(i11);
            i11++;
            StringBuilder sbP = a0.a.p(strJ, " ");
            sbP.append(constraintWidget.f1115j0);
            strJ = sbP.toString();
        }
        return a0.a.j(strJ, " >");
    }
}
