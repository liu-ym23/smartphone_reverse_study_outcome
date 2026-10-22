package b4;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public final class k implements t3.m {

    /* renamed from: a, reason: collision with root package name */
    public static final k f1515a = new k();

    @Override // t3.m
    public final Class a() {
        return i.class;
    }

    @Override // t3.m
    public final Object b(i5.l lVar) throws GeneralSecurityException {
        if (((t3.k) lVar.f4688h) == null) {
            throw new GeneralSecurityException("no primary in primitive set");
        }
        Iterator it = ((ConcurrentMap) lVar.f4687g).values().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
            }
        }
        return new j();
    }

    @Override // t3.m
    public final Class c() {
        return i.class;
    }
}
