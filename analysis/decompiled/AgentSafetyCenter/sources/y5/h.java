package y5;

import android.webkit.MimeTypeMap;
import java.io.File;
import java.lang.invoke.VarHandle;
import od.o;
import od.v;
import od.z;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h implements g {

    /* renamed from: a, reason: collision with root package name */
    public File f15908a;

    @Override // y5.g
    public final Object a(nb.c cVar) {
        String str = z.f9497f;
        File file = this.f15908a;
        z zVarO = f8.b.o(file);
        v vVar = o.f9478a;
        v5.o oVar = new v5.o();
        oVar.f14799c = zVarO;
        oVar.f14800f = vVar;
        oVar.f14801g = null;
        oVar.f14802h = null;
        VarHandle.storeStoreFence();
        return new m(oVar, MimeTypeMap.getSingleton().getMimeTypeFromExtension(ub.h.m(file)), v5.f.f14786g);
    }
}
