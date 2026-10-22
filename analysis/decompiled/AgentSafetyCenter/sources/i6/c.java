package i6;

import android.graphics.Bitmap;
import e6.i;
import java.lang.invoke.VarHandle;
import kc.e0;
import pc.n;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final e6.c f5803a;

    static {
        rc.e eVar = e0.f7430a;
        lc.d dVar = n.f9978a.i;
        rc.d dVar2 = rc.d.f10552f;
        f6.d dVar3 = f6.d.f3921g;
        Bitmap.Config config = d.f5804a;
        e6.b bVar = e6.b.f3508g;
        e6.c cVar = new e6.c();
        cVar.f3512a = dVar;
        cVar.f3513b = dVar2;
        cVar.f3514c = dVar2;
        cVar.f3515d = dVar2;
        cVar.f3516e = h6.e.f5396a;
        cVar.f3517f = dVar3;
        cVar.f3518g = config;
        cVar.f3519h = bVar;
        cVar.i = bVar;
        cVar.f3520j = bVar;
        VarHandle.storeStoreFence();
        f5803a = cVar;
    }

    public static final boolean a(i iVar) {
        int iOrdinal = iVar.f3551e.ordinal();
        if (iOrdinal == 0) {
            return false;
        }
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                g5.f.a();
                return false;
            }
            if (iVar.f3571z.f3521a != null || !(iVar.f3568w instanceof f6.c)) {
                return false;
            }
        }
        return true;
    }
}
