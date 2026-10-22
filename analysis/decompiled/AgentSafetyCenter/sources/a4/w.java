package a4;

import android.util.SparseArray;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f210a;

    /* renamed from: b, reason: collision with root package name */
    public z f211b;

    public w(int i) {
        this.f210a = new SparseArray(i);
    }

    public final void a(z zVar, int i, int i3) {
        int iA = zVar.a(i);
        SparseArray sparseArray = this.f210a;
        w wVar = sparseArray == null ? null : (w) sparseArray.get(iA);
        if (wVar == null) {
            wVar = new w(1);
            sparseArray.put(zVar.a(i), wVar);
        }
        if (i3 > i) {
            wVar.a(zVar, i + 1, i3);
        } else {
            wVar.f211b = zVar;
        }
    }
}
