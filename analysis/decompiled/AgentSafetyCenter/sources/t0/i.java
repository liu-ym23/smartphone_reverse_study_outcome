package t0;

import java.lang.invoke.VarHandle;
import java.util.Map;
import k0.s2;
import p.f0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final s2 f13120a = new s2(new androidx.room.c(19));

    public static final h a(Map map, xb.l lVar) {
        f0 f0Var;
        h hVar = new h();
        hVar.f13117c = lVar;
        if (map == null || map.isEmpty()) {
            f0Var = null;
        } else {
            f0Var = new f0(map.size());
            for (Map.Entry entry : map.entrySet()) {
                f0Var.m(entry.getKey(), entry.getValue());
            }
        }
        hVar.f13118f = f0Var;
        VarHandle.storeStoreFence();
        return hVar;
    }
}
