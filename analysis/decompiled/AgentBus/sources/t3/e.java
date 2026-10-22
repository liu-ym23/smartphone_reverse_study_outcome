package t3;

import java.security.GeneralSecurityException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import m.x;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f9707b = Logger.getLogger(e.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f9708a;

    public e(e eVar) {
        this.f9708a = new ConcurrentHashMap(eVar.f9708a);
    }

    public final synchronized d a(String str) {
        if (!this.f9708a.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type " + str);
        }
        return (d) this.f9708a.get(str);
    }

    public final synchronized void b(a4.e eVar) {
        int iD = eVar.d();
        if (!(iD != 1 ? x.b(iD) : x.a(iD))) {
            throw new GeneralSecurityException("failed to register key manager " + eVar.getClass() + " as it is not FIPS compatible.");
        }
        c(new d(eVar));
    }

    public final synchronized void c(d dVar) {
        try {
            a4.e eVar = dVar.f9706a;
            Class cls = (Class) eVar.f175c;
            if (!((Map) eVar.f176d).keySet().contains(cls) && !Void.class.equals(cls)) {
                throw new IllegalArgumentException("Given internalKeyMananger " + eVar.toString() + " does not support primitive class " + cls.getName());
            }
            String strE = eVar.e();
            d dVar2 = (d) this.f9708a.get(strE);
            if (dVar2 != null && !dVar2.f9706a.getClass().equals(dVar.f9706a.getClass())) {
                f9707b.warning("Attempted overwrite of a registered key manager for key type ".concat(strE));
                throw new GeneralSecurityException("typeUrl (" + strE + ") is already registered with " + dVar2.f9706a.getClass().getName() + ", cannot be re-registered with " + dVar.f9706a.getClass().getName());
            }
            this.f9708a.putIfAbsent(strE, dVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public e() {
        this.f9708a = new ConcurrentHashMap();
    }
}
