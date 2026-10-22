package a4;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    public static final i f180b = new i();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f181a = new AtomicReference(new o(new q6.b(1)));

    public final Class a(Class cls) {
        HashMap map = ((o) this.f181a.get()).f191b;
        if (map.containsKey(cls)) {
            return ((t3.m) map.get(cls)).a();
        }
        throw new GeneralSecurityException("No input primitive class for " + cls + " available");
    }

    public final synchronized void b(m mVar) {
        q6.b bVar = new q6.b((o) this.f181a.get());
        bVar.K0(mVar);
        this.f181a.set(new o(bVar));
    }
}
