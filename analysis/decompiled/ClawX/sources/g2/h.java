package g2;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h implements y1.m {

    /* renamed from: a, reason: collision with root package name */
    public static final h f2935a = new h();

    @Override // y1.m
    public final Class a() {
        return f.class;
    }

    @Override // y1.m
    public final Object b(a4.d dVar) throws GeneralSecurityException {
        if (((y1.k) dVar.f97c) == null) {
            throw new GeneralSecurityException("no primary in primitive set");
        }
        Iterator it = ((ConcurrentMap) dVar.f96b).values().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
            }
        }
        return new g();
    }

    @Override // y1.m
    public final Class c() {
        return f.class;
    }
}
