package l0;

import k0.b1;
import k0.i2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends i0 {

    /* renamed from: c, reason: collision with root package name */
    public static final h f7681c = new h(0, 4, 1);

    @Override // l0.i0
    public final void a(androidx.datastore.preferences.protobuf.j jVar, k0.d dVar, i2 i2Var, s0.i iVar, j0 j0Var) {
        b1 b1Var = (b1) jVar.e(2);
        k0.v vVar = (k0.v) jVar.e(1);
        vVar.k(b1Var);
        k0.t.d("Could not resolve state for movable content");
        throw new androidx.fragment.app.d();
    }
}
