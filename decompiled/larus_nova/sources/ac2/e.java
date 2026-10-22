package ac2;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile e f2571c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Class<?>, Object> f2572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Method, r<?>> f2573b;

    public static e b() {
        if (f2571c != null) goto L15;
        monitor-enter(com.bytedance.android.live.network.c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2571c != null) goto L9;
        f2571c = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.bytedance.android.live.network.c.class);     // Catch: Throwable -> L11
    L15:
        return f2571c;
    }

    public e() {
        this.f2572a = new ConcurrentHashMap();
        this.f2573b = new LinkedHashMap();
        lmc.a r100 = c.f2569b;
        com.ss.ugc.live.sdk.msg.utils.a.c(r100.f509921l, "uplink client start");
        r100.f509918i.h(r100);
        lmc.c r101 = new lmc.c(r100);
        ThreadMethodProxy.start(r101);
        Unit r102 = Unit.INSTANCE;
        r100.f509911b = r101;
    }

    public final <T> T a(Class<T> r100) {
        if (this.f2572a.contains(r100) == true) goto L6;
        ConcurrentHashMap<Class<?>, Object> r101 = this.f2572a;
        y.i(r100);
        r101.putIfAbsent(r100, Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, new d(this)));
    L6:
        return (T) this.f2572a.get(r100);
    }
}
