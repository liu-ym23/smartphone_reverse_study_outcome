package rc;

import gc.q;
import rc.j;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {
    public static final f a(String str, i kind, e[] eVarArr, l lVar) {
        kotlin.jvm.internal.g.f(kind, "kind");
        if (q.t0(str)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (kind.equals(j.a.f11801a)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        a aVar = new a(str);
        lVar.invoke(aVar);
        return new f(str, kind, aVar.f11771c.size(), mb.l.q0(eVarArr), aVar);
    }
}
