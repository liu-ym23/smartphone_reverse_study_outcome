package f2;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    public static final i f2561b = new i();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f2562a = new AtomicReference(new o(new androidx.emoji2.text.p(5)));

    public final Class a(Class cls) {
        HashMap map = ((o) this.f2562a.get()).f2572b;
        if (map.containsKey(cls)) {
            return ((y1.m) map.get(cls)).a();
        }
        throw new GeneralSecurityException("No input primitive class for " + cls + " available");
    }

    public final synchronized void b(m mVar) {
        androidx.emoji2.text.p pVar = new androidx.emoji2.text.p((o) this.f2562a.get());
        pVar.t(mVar);
        this.f2562a.set(new o(pVar));
    }
}
