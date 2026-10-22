package n5;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.bytedance.news.common.service.manager.ServiceCreator;
import com.bytedance.news.common.service.manager.ServiceLoadListener;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f22417a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f22418b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f22419c = null;

    static {
        f22417a = new ConcurrentHashMap();
        f22418b = new ConcurrentHashMap();
        f22419c = new ConcurrentHashMap();
    }

    public static Object a(Class r10) {
        Object r11 = f22417a.get(r10);
        if (r11 == null) goto L5;
    L29:
        return r11;
    L5:
        monitor-enter(b.class);
        ConcurrentHashMap r12 = f22418b;     // Catch: Throwable -> L13
        ServiceCreator r13 = (ServiceCreator) r12.get(r10);     // Catch: Throwable -> L13
        if (r13 == null) goto L15;
        Object r14 = r13.create();     // Catch: Throwable -> L13
        r12.remove(r10);     // Catch: Throwable -> L13
        if (r14 == null) goto L15;
        b(r10, r14);     // Catch: Throwable -> L13
        monitor-exit(b.class);     // Catch: Throwable -> L13
        return r14;
    L15:
        Object r15 = a.a(r10);     // Catch: Throwable -> L13
        if (r15 == null) goto L20;
        b(r10, r15);     // Catch: Throwable -> L13
        monitor-exit(b.class);     // Catch: Throwable -> L13
        return r15;
    L20:
        r11 = e(r10);     // Catch: Throwable -> L13
        if (r11 == null) goto L25;
        b(r10, r11);     // Catch: Throwable -> L13
        monitor-exit(b.class);     // Catch: Throwable -> L13
        return r11;
    L25:
        monitor-exit(b.class);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public static void b(Class r10, Object r11) {
        f22417a.put(r10, r11);
        ConcurrentHashMap r12 = f22419c;
        ServiceLoadListener r13 = (ServiceLoadListener) r12.get(r10);
        if (r13 == null) goto L6;
        r13.onServiceLoaded(r11);
        r12.remove(r10);
        return;
    }

    public static void c(Class r10, ServiceCreator r11) {
        f22418b.put(r10, r11);
    }

    public static void d(Class r10, Object r11) {
        f22417a.put(r10, r11);
    }

    public static Object e(Class r10) {
        Object r11 = Class.forName(String.format("%s__ServiceProxy", new Object[]{r10.getName()})).newInstance();     // Catch: InstantiationException -> L7 IllegalAccessException -> L9 ClassNotFoundException -> L11
        if ((r11 instanceof IServiceProxy) == false) goto L20;
        return ((IServiceProxy) r11).newInstance();
    L20:
        return null;
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
