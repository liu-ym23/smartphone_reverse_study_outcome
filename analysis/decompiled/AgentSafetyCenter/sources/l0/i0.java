package l0;

import k0.i2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class i0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f7684a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7685b;

    public /* synthetic */ i0(int i, int i3, int i10) {
        this((i10 & 1) != 0 ? 0 : i, (i10 & 2) != 0 ? 0 : i3);
    }

    public abstract void a(androidx.datastore.preferences.protobuf.j jVar, k0.d dVar, i2 i2Var, s0.i iVar, j0 j0Var);

    public k0.b b(androidx.datastore.preferences.protobuf.j jVar) {
        return null;
    }

    public final String toString() {
        String strC = yb.v.a(getClass()).c();
        return strC == null ? "" : strC;
    }

    public i0(int i, int i3) {
        this.f7684a = i;
        this.f7685b = i3;
    }
}
