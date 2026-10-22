package v0;

import android.util.SparseArray;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public SparseArray f5827a;

    /* renamed from: b, reason: collision with root package name */
    public int f5828b;

    public final f0 a(int i8) {
        SparseArray sparseArray = this.f5827a;
        f0 f0Var = (f0) sparseArray.get(i8);
        if (f0Var != null) {
            return f0Var;
        }
        f0 f0Var2 = new f0();
        sparseArray.put(i8, f0Var2);
        return f0Var2;
    }
}
