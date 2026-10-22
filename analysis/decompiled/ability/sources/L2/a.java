package L2;

import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.impl.ApmAgentServiceImpl;
import com.bytedance.apm.impl.MonitorLogManagerImpl;
import com.bytedance.news.common.service.manager.IServiceProxy;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f930a = new ConcurrentHashMap();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();
    public static final ConcurrentHashMap c = new ConcurrentHashMap();

    public static Object a(Class cls) {
        Object monitorLogManagerImpl;
        ConcurrentHashMap concurrentHashMap = f930a;
        Object obj = concurrentHashMap.get(cls);
        if (obj != null) {
            return obj;
        }
        synchronized (a.class) {
            try {
                ConcurrentHashMap concurrentHashMap2 = b;
                J2.a aVar = (J2.a) concurrentHashMap2.get(cls);
                if (aVar != null) {
                    switch (aVar.f864a) {
                        case 0:
                            monitorLogManagerImpl = new MonitorLogManagerImpl();
                            break;
                        case 1:
                            monitorLogManagerImpl = ActivityLifeObserver.getInstance();
                            break;
                        default:
                            monitorLogManagerImpl = new ApmAgentServiceImpl();
                            break;
                    }
                    concurrentHashMap2.remove(cls);
                    if (monitorLogManagerImpl != null) {
                        concurrentHashMap.put(cls, monitorLogManagerImpl);
                        if (c.get(cls) == null) {
                            return monitorLogManagerImpl;
                        }
                        throw new ClassCastException();
                    }
                }
                synchronized (cls) {
                    try {
                        Object objB = b(cls);
                        if (objB == null) {
                            return objB;
                        }
                        concurrentHashMap.put(cls, objB);
                        if (c.get(cls) == null) {
                            return objB;
                        }
                        throw new ClassCastException();
                    } finally {
                    }
                }
            } finally {
            }
        }
    }

    public static Object b(Class cls) throws IllegalAccessException, InstantiationException {
        synchronized (cls) {
        }
        try {
            Object objNewInstance = Class.forName(cls.getName().concat("__ServiceProxy")).newInstance();
            if (objNewInstance instanceof IServiceProxy) {
                return ((IServiceProxy) objNewInstance).newInstance();
            }
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
            return null;
        } catch (InstantiationException e9) {
            e9.printStackTrace();
            return null;
        }
    }
}
