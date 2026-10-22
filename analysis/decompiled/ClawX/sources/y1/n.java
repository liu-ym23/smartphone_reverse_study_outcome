package y1;

import androidx.emoji2.text.p;
import com.google.crypto.tink.shaded.protobuf.c0;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import k2.a1;
import k2.q1;
import k2.x0;
import k2.z0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference f6330a;

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f6331b;

    /* renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f6332c;
    public static final ConcurrentHashMap d;

    static {
        Logger.getLogger(n.class.getName());
        f6330a = new AtomicReference(new e());
        f6331b = new ConcurrentHashMap();
        f6332c = new ConcurrentHashMap();
        new ConcurrentHashMap();
        d = new ConcurrentHashMap();
    }

    public static synchronized void a(String str, Map map, boolean z) {
        if (z) {
            try {
                ConcurrentHashMap concurrentHashMap = f6332c;
                if (concurrentHashMap.containsKey(str) && !((Boolean) concurrentHashMap.get(str)).booleanValue()) {
                    throw new GeneralSecurityException("New keys are already disallowed for key type " + str);
                }
            } finally {
            }
        }
        if (z) {
            if (((e) f6330a.get()).f6314a.containsKey(str)) {
                for (Map.Entry entry : map.entrySet()) {
                    if (!d.containsKey(entry.getKey())) {
                        throw new GeneralSecurityException("Attempted to register a new key template " + ((String) entry.getKey()) + " from an existing key manager of type " + str);
                    }
                }
            } else {
                for (Map.Entry entry2 : map.entrySet()) {
                    if (d.containsKey(entry2.getKey())) {
                        throw new GeneralSecurityException("Attempted overwrite of a registered key template " + ((String) entry2.getKey()));
                    }
                }
            }
        }
    }

    public static Object b(b bVar, Class cls) throws GeneralSecurityException {
        h2.a aVar;
        f2.o oVar = (f2.o) f2.i.f2561b.f2562a.get();
        oVar.getClass();
        f2.n nVar = new f2.n(bVar.getClass(), cls);
        HashMap map = oVar.f2571a;
        if (!map.containsKey(nVar)) {
            throw new GeneralSecurityException("No PrimitiveConstructor for " + nVar + " available");
        }
        switch (((f2.m) map.get(nVar)).f2568b.f39a) {
            case 8:
                aVar = new h2.a();
                if (!a8.b.a(1)) {
                    throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
                }
                return aVar;
            default:
                aVar = new h2.a();
                if (!a8.b.b(2)) {
                    throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
                }
                return aVar;
        }
    }

    public static Object c(String str, com.google.crypto.tink.shaded.protobuf.i iVar, Class cls) throws GeneralSecurityException {
        e eVar = (e) f6330a.get();
        eVar.getClass();
        d dVarA = eVar.a(str);
        Set setKeySet = dVarA.f6312a.f2556b.keySet();
        f2.e eVar2 = dVarA.f6312a;
        if (!setKeySet.contains(cls)) {
            StringBuilder sb = new StringBuilder("Primitive type ");
            sb.append(cls.getName());
            sb.append(" not supported by key manager of type ");
            sb.append(eVar2.getClass());
            sb.append(", supported primitives: ");
            Set<Class> setKeySet2 = eVar2.f2556b.keySet();
            StringBuilder sb2 = new StringBuilder();
            boolean z = true;
            for (Class cls2 : setKeySet2) {
                if (!z) {
                    sb2.append(", ");
                }
                sb2.append(cls2.getCanonicalName());
                z = false;
            }
            sb.append(sb2.toString());
            throw new GeneralSecurityException(sb.toString());
        }
        try {
            if (!eVar2.f2556b.keySet().contains(cls) && !Void.class.equals(cls)) {
                throw new IllegalArgumentException("Given internalKeyMananger " + eVar2.toString() + " does not support primitive class " + cls.getName());
            }
            try {
                com.google.crypto.tink.shaded.protobuf.a aVarF = eVar2.f(iVar);
                if (Void.class.equals(cls)) {
                    throw new GeneralSecurityException("Cannot create a primitive for Void");
                }
                eVar2.g(aVarF);
                return eVar2.c(aVarF, cls);
            } catch (c0 e9) {
                throw new GeneralSecurityException("Failures parsing proto of type ".concat(eVar2.f2555a.getName()), e9);
            }
        } catch (IllegalArgumentException e10) {
            throw new GeneralSecurityException("Primitive type not supported", e10);
        }
    }

    public static Object d(String str, byte[] bArr) {
        com.google.crypto.tink.shaded.protobuf.h hVar = com.google.crypto.tink.shaded.protobuf.i.f1465b;
        return c(str, com.google.crypto.tink.shaded.protobuf.i.h(0, bArr.length, bArr), a.class);
    }

    public static synchronized x0 e(a1 a1Var) {
        f fVar;
        f2.e eVar = ((e) f6330a.get()).a(a1Var.B()).f6312a;
        fVar = new f(eVar, eVar.f2557c);
        if (!((Boolean) f6332c.get(a1Var.B())).booleanValue()) {
            throw new GeneralSecurityException("newKey-operation not permitted for key type " + a1Var.B());
        }
        return fVar.e(a1Var.C());
    }

    public static synchronized void f(f2.e eVar, boolean z) {
        try {
            AtomicReference atomicReference = f6330a;
            e eVar2 = new e((e) atomicReference.get());
            eVar2.b(eVar);
            String strB = eVar.b();
            a(strB, z ? eVar.d().h() : Collections.EMPTY_MAP, z);
            if (!((e) atomicReference.get()).f6314a.containsKey(strB)) {
                f6331b.put(strB, new p0.b(18));
                if (z) {
                    g(strB, eVar.d().h());
                }
            }
            f6332c.put(strB, Boolean.valueOf(z));
            atomicReference.set(eVar2);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void g(String str, Map map) {
        q1 q1Var;
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            byte[] bArrE = ((com.google.crypto.tink.shaded.protobuf.a) ((f2.c) entry.getValue()).f2552a).e();
            int i8 = ((f2.c) entry.getValue()).f2553b;
            z0 z0VarD = a1.D();
            z0VarD.e();
            a1.w((a1) z0VarD.f1537b, str);
            com.google.crypto.tink.shaded.protobuf.h hVarH = com.google.crypto.tink.shaded.protobuf.i.h(0, bArrE.length, bArrE);
            z0VarD.e();
            a1.x((a1) z0VarD.f1537b, hVarH);
            int iA = m.f.a(i8);
            if (iA == 0) {
                q1Var = q1.TINK;
            } else if (iA == 1) {
                q1Var = q1.LEGACY;
            } else if (iA == 2) {
                q1Var = q1.RAW;
            } else {
                if (iA != 3) {
                    throw new IllegalArgumentException("Unknown output prefix type");
                }
                q1Var = q1.CRUNCHY;
            }
            z0VarD.e();
            a1.y((a1) z0VarD.f1537b, q1Var);
            d.put(str2, new g((a1) z0VarD.b()));
        }
    }

    public static synchronized void h(m mVar) {
        f2.i iVar = f2.i.f2561b;
        synchronized (iVar) {
            p pVar = new p((f2.o) iVar.f2562a.get());
            pVar.u(mVar);
            iVar.f2562a.set(new f2.o(pVar));
        }
    }
}
