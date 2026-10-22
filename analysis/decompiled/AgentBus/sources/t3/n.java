package t3;

import com.google.crypto.tink.shaded.protobuf.b0;
import f4.c2;
import f4.j1;
import f4.l1;
import f4.m1;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import m.x;

/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference f9726a;

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f9727b;

    /* renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f9728c;

    /* renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap f9729d;

    static {
        Logger.getLogger(n.class.getName());
        f9726a = new AtomicReference(new e());
        f9727b = new ConcurrentHashMap();
        f9728c = new ConcurrentHashMap();
        new ConcurrentHashMap();
        f9729d = new ConcurrentHashMap();
    }

    public static synchronized void a(String str, Map map, boolean z4) {
        if (z4) {
            try {
                ConcurrentHashMap concurrentHashMap = f9728c;
                if (concurrentHashMap.containsKey(str) && !((Boolean) concurrentHashMap.get(str)).booleanValue()) {
                    throw new GeneralSecurityException("New keys are already disallowed for key type " + str);
                }
            } finally {
            }
        }
        if (z4) {
            if (((e) f9726a.get()).f9708a.containsKey(str)) {
                for (Map.Entry entry : map.entrySet()) {
                    if (!f9729d.containsKey(entry.getKey())) {
                        throw new GeneralSecurityException("Attempted to register a new key template " + ((String) entry.getKey()) + " from an existing key manager of type " + str);
                    }
                }
            } else {
                for (Map.Entry entry2 : map.entrySet()) {
                    if (f9729d.containsKey(entry2.getKey())) {
                        throw new GeneralSecurityException("Attempted overwrite of a registered key template " + ((String) entry2.getKey()));
                    }
                }
            }
        }
    }

    public static Object b(b bVar, Class cls) throws GeneralSecurityException {
        c4.a aVar;
        a4.o oVar = (a4.o) a4.i.f180b.f181a.get();
        oVar.getClass();
        a4.n nVar = new a4.n(bVar.getClass(), cls);
        HashMap map = oVar.f190a;
        if (!map.containsKey(nVar)) {
            throw new GeneralSecurityException("No PrimitiveConstructor for " + nVar + " available");
        }
        switch (((a4.m) map.get(nVar)).f187b.f1486a) {
            case 0:
                aVar = new c4.a();
                if (!x.a(1)) {
                    throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
                }
                return aVar;
            default:
                aVar = new c4.a();
                if (!x.b(2)) {
                    throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
                }
                return aVar;
        }
    }

    public static Object c(String str, com.google.crypto.tink.shaded.protobuf.h hVar, Class cls) throws GeneralSecurityException {
        e eVar = (e) f9726a.get();
        eVar.getClass();
        d dVarA = eVar.a(str);
        Set setKeySet = ((Map) dVarA.f9706a.f176d).keySet();
        a4.e eVar2 = dVarA.f9706a;
        if (!setKeySet.contains(cls)) {
            StringBuilder sb2 = new StringBuilder("Primitive type ");
            sb2.append(cls.getName());
            sb2.append(" not supported by key manager of type ");
            sb2.append(eVar2.getClass());
            sb2.append(", supported primitives: ");
            Set<Class> setKeySet2 = ((Map) eVar2.f176d).keySet();
            StringBuilder sb3 = new StringBuilder();
            boolean z4 = true;
            for (Class cls2 : setKeySet2) {
                if (!z4) {
                    sb3.append(", ");
                }
                sb3.append(cls2.getCanonicalName());
                z4 = false;
            }
            sb2.append(sb3.toString());
            throw new GeneralSecurityException(sb2.toString());
        }
        try {
            if (!((Map) eVar2.f176d).keySet().contains(cls) && !Void.class.equals(cls)) {
                throw new IllegalArgumentException("Given internalKeyMananger " + eVar2.toString() + " does not support primitive class " + cls.getName());
            }
            try {
                com.google.crypto.tink.shaded.protobuf.a aVarI = eVar2.i(hVar);
                if (Void.class.equals(cls)) {
                    throw new GeneralSecurityException("Cannot create a primitive for Void");
                }
                eVar2.k(aVarI);
                return eVar2.f(aVarI, cls);
            } catch (b0 e10) {
                throw new GeneralSecurityException("Failures parsing proto of type ".concat(((Class) eVar2.f174b).getName()), e10);
            }
        } catch (IllegalArgumentException e11) {
            throw new GeneralSecurityException("Primitive type not supported", e11);
        }
    }

    public static synchronized j1 d(m1 m1Var) {
        f fVar;
        a4.e eVar = ((e) f9726a.get()).a(m1Var.A()).f9706a;
        fVar = new f(eVar, (Class) eVar.f175c);
        if (!((Boolean) f9728c.get(m1Var.A())).booleanValue()) {
            throw new GeneralSecurityException("newKey-operation not permitted for key type " + m1Var.A());
        }
        return fVar.e(m1Var.B());
    }

    public static synchronized void e(a4.e eVar, boolean z4) {
        try {
            AtomicReference atomicReference = f9726a;
            e eVar2 = new e((e) atomicReference.get());
            eVar2.b(eVar);
            String strE = eVar.e();
            a(strE, z4 ? eVar.g().u0() : Collections.EMPTY_MAP, z4);
            if (!((e) atomicReference.get()).f9708a.containsKey(strE)) {
                f9727b.put(strE, new h4.n(23, false));
                if (z4) {
                    f(strE, eVar.g().u0());
                }
            }
            f9728c.put(strE, Boolean.valueOf(z4));
            atomicReference.set(eVar2);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void f(String str, Map map) {
        c2 c2Var;
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            byte[] bArrD = ((com.google.crypto.tink.shaded.protobuf.a) ((a4.c) entry.getValue()).f170a).d();
            int i2 = ((a4.c) entry.getValue()).f171b;
            l1 l1VarC = m1.C();
            l1VarC.d();
            m1.v((m1) l1VarC.f2287g, str);
            com.google.crypto.tink.shaded.protobuf.g gVarH = com.google.crypto.tink.shaded.protobuf.h.h(bArrD, 0, bArrD.length);
            l1VarC.d();
            m1.w((m1) l1VarC.f2287g, gVarH);
            int iD = n.f.d(i2);
            if (iD == 0) {
                c2Var = c2.TINK;
            } else if (iD == 1) {
                c2Var = c2.LEGACY;
            } else if (iD == 2) {
                c2Var = c2.RAW;
            } else {
                if (iD != 3) {
                    throw new IllegalArgumentException("Unknown output prefix type");
                }
                c2Var = c2.CRUNCHY;
            }
            l1VarC.d();
            m1.x((m1) l1VarC.f2287g, c2Var);
            f9729d.put(str2, new g((m1) l1VarC.a()));
        }
    }

    public static synchronized void g(m mVar) {
        a4.i iVar = a4.i.f180b;
        synchronized (iVar) {
            q6.b bVar = new q6.b((a4.o) iVar.f181a.get());
            bVar.L0(mVar);
            iVar.f181a.set(new a4.o(bVar));
        }
    }
}
