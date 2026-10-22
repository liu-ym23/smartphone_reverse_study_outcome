package X;

import android.util.SparseArray;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f2103a;

    /* renamed from: b, reason: collision with root package name */
    public B f2104b;

    public y(int i4) {
        this.f2103a = new SparseArray(i4);
    }

    public final void a(B b4, int i4, int i5) {
        int iA = b4.a(i4);
        SparseArray sparseArray = this.f2103a;
        y yVar = sparseArray == null ? null : (y) sparseArray.get(iA);
        if (yVar == null) {
            yVar = new y(1);
            sparseArray.put(b4.a(i4), yVar);
        }
        if (i5 > i4) {
            yVar.a(b4, i4 + 1, i5);
        } else {
            yVar.f2104b = b4;
        }
    }
}
