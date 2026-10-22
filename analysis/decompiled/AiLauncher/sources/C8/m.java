package C8;

import C8.f;
import java.util.Collection;

/* loaded from: classes4.dex */
public abstract class m {
    public static void c(u8.m mVar, j jVar, f.a aVar) {
        for (f.a aVar2 : aVar.b()) {
            if (aVar2.isClosed()) {
                m mVarB = jVar.b(aVar2.name());
                if (mVarB != null) {
                    mVarB.a(mVar, jVar, aVar2);
                } else {
                    c(mVar, jVar, aVar2);
                }
            }
        }
    }

    public abstract void a(u8.m mVar, j jVar, f fVar);

    public abstract Collection<String> b();
}
