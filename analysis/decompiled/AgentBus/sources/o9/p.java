package o9;

import java.util.Collection;

/* loaded from: classes.dex */
public abstract class p {
    public static /* synthetic */ Collection getContributedDescriptors$default(q qVar, f fVar, p7.k kVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
        }
        if ((i2 & 1) != 0) {
            fVar = f.f7910m;
        }
        if ((i2 & 2) != 0) {
            n.f7934a.getClass();
            kVar = k.f7927h;
        }
        return qVar.e(fVar, kVar);
    }

    public static void recordLookup(q qVar, e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        q7.k.e(aVar, "location");
        qVar.f(fVar, aVar);
    }
}
