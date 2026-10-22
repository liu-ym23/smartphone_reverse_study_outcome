package p8;

import f8.z;
import i8.r0;
import p7.k;
import q7.m;
import v9.v;

/* loaded from: classes.dex */
public final class d extends m implements k {

    /* renamed from: g, reason: collision with root package name */
    public static final d f8512g = new d(1);

    @Override // p7.k
    public final Object invoke(Object obj) {
        z zVar = (z) obj;
        q7.k.e(zVar, "module");
        r0 r0VarQ = nb.i.q(c.f8509b, zVar.n().i(c8.m.f2049t));
        v type = r0VarQ != null ? r0VarQ.getType() : null;
        if (type == null) {
            return x9.i.c(x9.h.H, new String[0]);
        }
        return type;
    }
}
