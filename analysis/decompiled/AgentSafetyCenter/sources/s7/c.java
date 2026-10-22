package s7;

import java.lang.invoke.VarHandle;
import java.sql.Timestamp;
import java.util.Date;
import m7.n;
import m7.o;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class c implements o {
    @Override // m7.o
    public final n a(m7.e eVar, t7.a aVar) {
        if (aVar.getRawType() != Timestamp.class) {
            return null;
        }
        eVar.getClass();
        n nVarC = eVar.c(t7.a.get(Date.class));
        d dVar = new d();
        dVar.f11413a = nVarC;
        VarHandle.storeStoreFence();
        return dVar;
    }
}
