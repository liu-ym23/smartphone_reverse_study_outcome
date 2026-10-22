package G8;

import u8.r;
import u8.v;

/* loaded from: classes4.dex */
public abstract class h extends C8.m {
    @Override // C8.m
    public void a(u8.m mVar, C8.j jVar, C8.f fVar) {
        if (fVar.c()) {
            C8.m.c(mVar, jVar, fVar.a());
        }
        Object objD = d(mVar.z(), mVar.r(), fVar);
        if (objD != null) {
            v.k(mVar.builder(), objD, fVar.start(), fVar.end());
        }
    }

    public abstract Object d(u8.g gVar, r rVar, C8.f fVar);
}
