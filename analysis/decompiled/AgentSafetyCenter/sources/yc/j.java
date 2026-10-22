package yc;

import xc.f0;
import xc.g0;
import yb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j implements tc.a {

    /* renamed from: a, reason: collision with root package name */
    public static final f0 f16110a;

    static {
        vc.c cVar = vc.c.f14882j;
        if (hc.h.g0("kotlinx.serialization.json.JsonLiteral")) {
            g5.f.s("Blank serial names are prohibited");
            return;
        }
        Object it = ((lb.h) g0.f15629a.values()).iterator();
        while (((b4.c) it).hasNext()) {
            tc.a aVar = (tc.a) ((lb.d) it).next();
            if ("kotlinx.serialization.json.JsonLiteral".equals(aVar.getDescriptor().a())) {
                g5.f.s(hc.i.N("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name kotlinx.serialization.json.JsonLiteral there already exists " + v.a(aVar.getClass()).c() + ".\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
                return;
            }
        }
        f16110a = new f0("kotlinx.serialization.json.JsonLiteral", cVar);
    }

    @Override // tc.a
    public final vc.e getDescriptor() {
        return f16110a;
    }
}
