package l0;

import java.lang.invoke.VarHandle;
import k0.i2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends i0 {

    /* renamed from: c, reason: collision with root package name */
    public static final f f7677c = new f(0, 2, 1);

    @Override // l0.i0
    public final void a(androidx.datastore.preferences.protobuf.j jVar, k0.d dVar, i2 i2Var, s0.i iVar, j0 j0Var) {
        p5.l lVar;
        s0.d dVar2 = (s0.d) jVar.e(1);
        int i = dVar2 != null ? dVar2.f11175a : 0;
        a aVar = (a) jVar.e(0);
        if (i > 0) {
            b0.z zVar = new b0.z();
            zVar.f1803g = dVar;
            zVar.f1801c = i;
            VarHandle.storeStoreFence();
            dVar = zVar;
        }
        if (j0Var != null) {
            lVar = new p5.l();
            lVar.f9738c = j0Var;
            lVar.f9739f = i2Var;
            VarHandle.storeStoreFence();
        } else {
            lVar = null;
        }
        aVar.P(dVar, i2Var, iVar, lVar);
    }
}
