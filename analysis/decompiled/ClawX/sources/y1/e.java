package y1;

import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f6313b = Logger.getLogger(e.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f6314a;

    public e(e eVar) {
        this.f6314a = new ConcurrentHashMap(eVar.f6314a);
    }

    public final synchronized d a(String str) {
        if (!this.f6314a.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type " + str);
        }
        return (d) this.f6314a.get(str);
    }

    public final synchronized void b(f2.e eVar) {
        int iA = eVar.a();
        if (!(iA != 1 ? a8.b.b(iA) : a8.b.a(iA))) {
            throw new GeneralSecurityException("failed to register key manager " + eVar.getClass() + " as it is not FIPS compatible.");
        }
        c(new d(eVar));
    }

    public final synchronized void c(d dVar) {
        try {
            f2.e eVar = dVar.f6312a;
            Class cls = eVar.f2557c;
            if (!eVar.f2556b.keySet().contains(cls) && !Void.class.equals(cls)) {
                throw new IllegalArgumentException("Given internalKeyMananger " + eVar.toString() + " does not support primitive class " + cls.getName());
            }
            String strB = eVar.b();
            d dVar2 = (d) this.f6314a.get(strB);
            if (dVar2 != null && !dVar2.f6312a.getClass().equals(dVar.f6312a.getClass())) {
                f6313b.warning("Attempted overwrite of a registered key manager for key type ".concat(strB));
                throw new GeneralSecurityException("typeUrl (" + strB + ") is already registered with " + dVar2.f6312a.getClass().getName() + ", cannot be re-registered with " + dVar.f6312a.getClass().getName());
            }
            this.f6314a.putIfAbsent(strB, dVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public e() {
        this.f6314a = new ConcurrentHashMap();
    }
}
