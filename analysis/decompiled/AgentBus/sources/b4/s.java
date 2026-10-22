package b4;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class s implements t3.m {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f1529a = Logger.getLogger(s.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f1530b = {0};

    /* renamed from: c, reason: collision with root package name */
    public static final s f1531c = new s();

    @Override // t3.m
    public final Class a() {
        return t3.j.class;
    }

    @Override // t3.m
    public final Object b(i5.l lVar) throws GeneralSecurityException {
        Iterator it = ((ConcurrentMap) lVar.f4687g).values().iterator();
        while (it.hasNext()) {
            for (t3.k kVar : (List) it.next()) {
                t3.b bVar = kVar.f9724h;
                if (bVar instanceof p) {
                    p pVar = (p) bVar;
                    byte[] bArr = kVar.f9719c;
                    i4.a aVarA = i4.a.a(bArr == null ? null : Arrays.copyOf(bArr, bArr.length));
                    if (!aVarA.equals(pVar.b())) {
                        throw new GeneralSecurityException("Mac Key with parameters " + pVar.c() + " has wrong output prefix (" + pVar.b() + ") instead of (" + aVarA + ")");
                    }
                }
            }
        }
        return new r(lVar);
    }

    @Override // t3.m
    public final Class c() {
        return t3.j.class;
    }
}
