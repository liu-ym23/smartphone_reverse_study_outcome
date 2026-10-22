package g7;

/* loaded from: classes.dex */
public abstract class h {
    public static l plus(l lVar, l lVar2) {
        q7.k.e(lVar2, "context");
        return lVar2 == m.f3866f ? lVar : (l) lVar2.r(lVar, new b(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static l plus$lambda$0(l lVar, j jVar) {
        q7.k.e(lVar, "acc");
        q7.k.e(jVar, "element");
        l lVarZ = lVar.z(jVar.getKey());
        m mVar = m.f3866f;
        if (lVarZ == mVar) {
            return jVar;
        }
        f fVar = f.f3865f;
        g gVar = (g) lVarZ.o(fVar);
        if (gVar == null) {
            return new c(lVarZ, jVar);
        }
        l lVarZ2 = lVarZ.z(fVar);
        return lVarZ2 == mVar ? new c(jVar, gVar) : new c(new c(lVarZ2, jVar), gVar);
    }
}
