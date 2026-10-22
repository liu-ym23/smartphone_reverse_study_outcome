package x2;

import android.util.SparseArray;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f11143a;

    /* renamed from: b, reason: collision with root package name */
    public q f11144b;

    public p(int i2) {
        this.f11143a = new SparseArray(i2);
    }

    public final void a(q qVar, int i2, int i10) {
        int iA = qVar.a(i2);
        SparseArray sparseArray = this.f11143a;
        p pVar = sparseArray == null ? null : (p) sparseArray.get(iA);
        if (pVar == null) {
            pVar = new p(1);
            sparseArray.put(qVar.a(i2), pVar);
        }
        if (i10 > i2) {
            pVar.a(qVar, i2 + 1, i10);
        } else {
            pVar.f11144b = qVar;
        }
    }
}
