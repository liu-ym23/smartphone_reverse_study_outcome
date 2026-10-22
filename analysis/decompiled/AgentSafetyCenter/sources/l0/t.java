package l0;

import java.lang.invoke.VarHandle;
import k0.f2;
import k0.i2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t extends i0 {

    /* renamed from: c, reason: collision with root package name */
    public static final t f7706c = new t(0, 3, 1);

    @Override // l0.i0
    public final void a(androidx.datastore.preferences.protobuf.j jVar, k0.d dVar, i2 i2Var, s0.i iVar, j0 j0Var) {
        p5.l lVar;
        f2 f2Var = (f2) jVar.e(1);
        k0.b bVar = (k0.b) jVar.e(0);
        c cVar = (c) jVar.e(2);
        i2 i2VarD = f2Var.d();
        if (j0Var != null) {
            try {
                lVar = new p5.l();
                lVar.f9738c = j0Var;
                lVar.f9739f = i2Var;
                VarHandle.storeStoreFence();
            } catch (Throwable th) {
                i2VarD.e(false);
                throw th;
            }
        } else {
            lVar = null;
        }
        if (!cVar.f7671d.R()) {
            k0.t.c("FixupList has pending fixup operations that were not realized. Were there mismatched insertNode() and endNodeInsert() calls?");
        }
        cVar.f7670c.Q(dVar, i2VarD, iVar, lVar);
        i2VarD.e(true);
        i2Var.d();
        bVar.getClass();
        i2Var.z(f2Var, f2Var.a(bVar));
        i2Var.k();
    }
}
