package g2;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class p implements y1.m {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f2947a = Logger.getLogger(p.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f2948b = {0};

    /* renamed from: c, reason: collision with root package name */
    public static final p f2949c = new p();

    @Override // y1.m
    public final Class a() {
        return y1.j.class;
    }

    @Override // y1.m
    public final Object b(a4.d dVar) throws GeneralSecurityException {
        Iterator it = ((ConcurrentMap) dVar.f96b).values().iterator();
        while (it.hasNext()) {
            for (y1.k kVar : (List) it.next()) {
                y1.b bVar = kVar.f6328h;
                if (bVar instanceof m) {
                    m mVar = (m) bVar;
                    byte[] bArr = kVar.f6324c;
                    m2.a aVarA = m2.a.a(bArr == null ? null : Arrays.copyOf(bArr, bArr.length));
                    if (!aVarA.equals(mVar.b())) {
                        throw new GeneralSecurityException("Mac Key with parameters " + mVar.c() + " has wrong output prefix (" + mVar.b() + ") instead of (" + aVarA + ")");
                    }
                }
            }
        }
        return new o(dVar);
    }

    @Override // y1.m
    public final Class c() {
        return y1.j.class;
    }
}
