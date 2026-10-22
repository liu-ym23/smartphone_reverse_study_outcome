package g4;

import i5.l;
import java.security.GeneralSecurityException;
import t3.k;
import t3.m;
import t3.o;

/* loaded from: classes.dex */
public final class e implements m {

    /* renamed from: a, reason: collision with root package name */
    public static final e f3845a = new e();

    @Override // t3.m
    public final Class a() {
        return o.class;
    }

    @Override // t3.m
    public final Object b(l lVar) throws GeneralSecurityException {
        d dVar = new d();
        if (((k) lVar.f4688h) == null) {
            throw new GeneralSecurityException("Missing primary primitive.");
        }
        dVar.f3844a = lVar;
        return dVar;
    }

    @Override // t3.m
    public final Class c() {
        return o.class;
    }
}
