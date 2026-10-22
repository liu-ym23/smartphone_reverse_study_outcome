package k1;

import java.util.concurrent.ConcurrentHashMap;

/* renamed from: k1.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1620b {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f4792a = new ConcurrentHashMap();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();
    public static final ConcurrentHashMap c = new ConcurrentHashMap();

    public static Object a(Class cls) {
        ConcurrentHashMap concurrentHashMap = f4792a;
        Object objCreate = concurrentHashMap.get(cls);
        if (objCreate != null) {
            return objCreate;
        }
        synchronized (AbstractC1620b.class) {
            try {
                ConcurrentHashMap concurrentHashMap2 = b;
                InterfaceC1619a interfaceC1619a = (InterfaceC1619a) concurrentHashMap2.get(cls);
                if (interfaceC1619a != null) {
                    objCreate = interfaceC1619a.create();
                    concurrentHashMap2.remove(cls);
                    if (objCreate != null) {
                        concurrentHashMap.put(cls, objCreate);
                        if (c.get(cls) == null) {
                            return objCreate;
                        }
                        throw new ClassCastException();
                    }
                }
                return objCreate;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
