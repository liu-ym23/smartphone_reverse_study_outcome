package androidx.emoji2.text;

import android.util.SparseArray;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f644a;

    /* renamed from: b, reason: collision with root package name */
    public z f645b;

    public w(int i8) {
        this.f644a = new SparseArray(i8);
    }

    public final void a(z zVar, int i8, int i9) {
        int iA = zVar.a(i8);
        SparseArray sparseArray = this.f644a;
        w wVar = sparseArray == null ? null : (w) sparseArray.get(iA);
        if (wVar == null) {
            wVar = new w(1);
            sparseArray.put(zVar.a(i8), wVar);
        }
        if (i9 > i8) {
            wVar.a(zVar, i8 + 1, i9);
        } else {
            wVar.f645b = zVar;
        }
    }
}
