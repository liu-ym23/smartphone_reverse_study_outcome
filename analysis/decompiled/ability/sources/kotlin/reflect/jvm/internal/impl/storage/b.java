package kotlin.reflect.jvm.internal.impl.storage;

import G8.c;
import S7.k;
import W8.i;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g9.l;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class b implements k {

    /* renamed from: a, reason: collision with root package name */
    public final i f5139a;
    public final ConcurrentHashMap b;
    public final k c;

    public b(i iVar, ConcurrentHashMap concurrentHashMap, k kVar) {
        this.f5139a = iVar;
        this.b = concurrentHashMap;
        this.c = kVar;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 4) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "map";
        } else if (i == 2) {
            objArr[0] = "compute";
        } else if (i == 3 || i == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
        } else {
            objArr[0] = "storageManager";
        }
        if (i == 3) {
            objArr[1] = "recursionDetected";
        } else if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
        } else {
            objArr[1] = "raceCondition";
        }
        if (i != 3 && i != 4) {
            objArr[2] = AppAgent.CONSTRUCT;
        }
        String str2 = String.format(str, objArr);
        if (i != 3 && i != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public final AssertionError b(Object obj, Object obj2) {
        AssertionError assertionError = new AssertionError("Inconsistent key detected. " + LockBasedStorageManager$NotValue.b + " is expected, was: " + obj2 + ", most probably race condition detected on input " + obj + " under " + this.f5139a);
        i.f(assertionError);
        return assertionError;
    }

    public final boolean c(c cVar) {
        Object obj = this.b.get(cVar);
        return (obj == null || obj == LockBasedStorageManager$NotValue.b) ? false : true;
    }

    public final AssertionError d(Object obj, Object obj2) {
        AssertionError assertionError = new AssertionError("Race condition detected on input " + obj + ". Old value is " + obj2 + " under " + this.f5139a);
        i.f(assertionError);
        return assertionError;
    }

    public final AssertionError e(Object obj, Throwable th) {
        AssertionError assertionError = new AssertionError("Unable to remove " + obj + " under " + this.f5139a, th);
        i.f(assertionError);
        return assertionError;
    }

    @Override // S7.k
    public Object invoke(Object obj) throws Throwable {
        AssertionError assertionErrorE;
        i iVar = this.f5139a;
        W8.a aVar = iVar.b;
        W8.k kVar = iVar.f1495a;
        ConcurrentHashMap concurrentHashMap = this.b;
        Object obj2 = concurrentHashMap.get(obj);
        Object obj3 = l.f4509a;
        LockBasedStorageManager$NotValue lockBasedStorageManager$NotValue = LockBasedStorageManager$NotValue.b;
        if (obj2 != null && obj2 != lockBasedStorageManager$NotValue) {
            l.l(obj2);
            if (obj2 == obj3) {
                return null;
            }
            return obj2;
        }
        kVar.lock();
        try {
            Object obj4 = concurrentHashMap.get(obj);
            LockBasedStorageManager$NotValue lockBasedStorageManager$NotValue2 = LockBasedStorageManager$NotValue.c;
            if (obj4 == lockBasedStorageManager$NotValue) {
                C4.a aVarE = iVar.e(obj, "");
                if (aVarE == null) {
                    a(3);
                    throw null;
                }
                if (!aVarE.b) {
                    return aVarE.c;
                }
                obj4 = lockBasedStorageManager$NotValue2;
            }
            if (obj4 == lockBasedStorageManager$NotValue2) {
                C4.a aVarE2 = iVar.e(obj, "");
                if (aVarE2 == null) {
                    a(3);
                    throw null;
                }
                if (!aVarE2.b) {
                    return aVarE2.c;
                }
            }
            if (obj4 != null) {
                l.l(obj4);
                return obj4 != obj3 ? obj4 : null;
            }
            try {
                concurrentHashMap.put(obj, lockBasedStorageManager$NotValue);
                Object objInvoke = this.c.invoke(obj);
                if (objInvoke != null) {
                    obj3 = objInvoke;
                }
                Object objPut = concurrentHashMap.put(obj, obj3);
                if (objPut == lockBasedStorageManager$NotValue) {
                    return objInvoke;
                }
                assertionErrorD = d(obj, objPut);
                throw assertionErrorD;
            } catch (Throwable th) {
                if (l.j(th)) {
                    try {
                        Object objRemove = concurrentHashMap.remove(obj);
                        if (objRemove != lockBasedStorageManager$NotValue) {
                            throw b(obj, objRemove);
                        }
                        throw th;
                    } finally {
                    }
                }
                if (th == assertionErrorD) {
                    try {
                        concurrentHashMap.remove(obj);
                        aVar.getClass();
                        throw th;
                    } finally {
                    }
                }
                Object objPut2 = concurrentHashMap.put(obj, new g9.k(th));
                if (objPut2 != lockBasedStorageManager$NotValue) {
                    throw d(obj, objPut2);
                }
                aVar.getClass();
                throw th;
                kVar.unlock();
            }
        } finally {
            kVar.unlock();
        }
    }
}
