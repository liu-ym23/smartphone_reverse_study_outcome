package o3;

import com.bytedance.apm6.service.ServiceCreator;
import com.bytedance.apm6.service.ServiceLoadListener;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f22475a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f22476b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f22477c = null;

    static {
        f22475a = new ConcurrentHashMap();
        f22476b = new ConcurrentHashMap();
        f22477c = new ConcurrentHashMap();
    }

    public static Object a(Class r10) {
        Object r11 = f22475a.get(r10);
        if (r11 == null) goto L5;
    L19:
        return r11;
    L5:
        monitor-enter(a.class);
        ConcurrentHashMap r12 = f22476b;     // Catch: Throwable -> L13
        ServiceCreator r13 = (ServiceCreator) r12.get(r10);     // Catch: Throwable -> L13
        if (r13 == null) goto L15;
        r11 = r13.create();     // Catch: Throwable -> L13
        r12.remove(r10);     // Catch: Throwable -> L13
        if (r11 == null) goto L15;
        b(r10, r11);     // Catch: Throwable -> L13
        monitor-exit(a.class);     // Catch: Throwable -> L13
        return r11;
    L15:
        monitor-exit(a.class);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public static void b(Class r10, Object r11) {
        f22475a.put(r10, r11);
        ConcurrentHashMap r12 = f22477c;
        ServiceLoadListener r13 = (ServiceLoadListener) r12.get(r10);
        if (r13 == null) goto L6;
        r13.onServiceLoaded(r11);
        r12.remove(r10);
        return;
    }

    public static void c(Class r10, ServiceCreator r11) {
        f22476b.put(r10, r11);
    }

    public static void d(Class r10, Object r11) {
        f22475a.put(r10, r11);
    }
}
