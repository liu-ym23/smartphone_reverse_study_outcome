package l0;

import java.util.List;
import k0.i2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends i0 {

    /* renamed from: c, reason: collision with root package name */
    public static final g f7679c = new g(0, 2, 1);

    @Override // l0.i0
    public final void a(androidx.datastore.preferences.protobuf.j jVar, k0.d dVar, i2 i2Var, s0.i iVar, j0 j0Var) {
        int i = ((s0.d) jVar.e(0)).f11175a;
        List list = (List) jVar.e(1);
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            int i10 = i + i3;
            dVar.c(i10, obj);
            dVar.j(i10, obj);
        }
    }
}
