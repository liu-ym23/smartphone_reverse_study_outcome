package G8;

import java.util.Collection;
import java.util.Collections;
import u8.u;
import u8.v;

/* loaded from: classes4.dex */
public class a extends C8.m {
    @Override // C8.m
    public void a(u8.m mVar, C8.j jVar, C8.f fVar) {
        if (fVar.c()) {
            C8.m.c(mVar, jVar, fVar.a());
        }
        u8.g gVarZ = mVar.z();
        u uVar = gVarZ.e().get(Yb.c.class);
        if (uVar != null) {
            v.k(mVar.builder(), uVar.a(gVarZ, mVar.r()), fVar.start(), fVar.end());
        }
    }

    @Override // C8.m
    public Collection<String> b() {
        return Collections.singleton("blockquote");
    }
}
