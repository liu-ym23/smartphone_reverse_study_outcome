package l0;

import java.lang.invoke.VarHandle;
import k0.i2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends i0 {

    /* renamed from: c, reason: collision with root package name */
    public static final i f7683c = new i(0, 0, 3);

    @Override // l0.i0
    public final void a(androidx.datastore.preferences.protobuf.j jVar, k0.d dVar, i2 i2Var, s0.i iVar, j0 j0Var) {
        int i = i2Var.f6956t;
        j9.i iVar2 = new j9.i(1);
        iVar2.f6671f = iVar;
        iVar2.f6672g = i2Var;
        VarHandle.storeStoreFence();
        i2Var.n(i, iVar2);
    }
}
