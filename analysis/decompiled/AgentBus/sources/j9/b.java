package j9;

import f8.z;
import java.util.List;

/* loaded from: classes.dex */
public class b extends g {

    /* renamed from: b, reason: collision with root package name */
    public final q7.m f5404b;

    /* JADX WARN: Multi-variable type inference failed */
    public b(List list, p7.k kVar) {
        super(list);
        this.f5404b = (q7.m) kVar;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [p7.k, q7.m] */
    @Override // j9.g
    public final v9.v a(z zVar) {
        f8.g gVarC;
        q7.k.e(zVar, "module");
        v9.v vVar = (v9.v) this.f5404b.invoke(zVar);
        if (!c8.h.y(vVar) && (((gVarC = vVar.E0().c()) == null || c8.h.r(gVarC) == null) && !c8.h.B(vVar, c8.m.V.i()) && !c8.h.B(vVar, c8.m.W.i()) && !c8.h.B(vVar, c8.m.X.i()))) {
            c8.h.B(vVar, c8.m.Y.i());
        }
        return vVar;
    }
}
