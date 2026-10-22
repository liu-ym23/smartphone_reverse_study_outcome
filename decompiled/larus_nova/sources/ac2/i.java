package ac2;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes9.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vlc.d f2581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Class<?>, Object> f2582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Method, r<?>> f2583c;

    public i(vlc.d r100) {
        this.f2582b = new ConcurrentHashMap();
        this.f2583c = new LinkedHashMap();
        this.f2581a = r100;
    }

    public final <T> T a(Class<T> r100) {
        vlc.d r101 = this.f2581a;
        if ((r101 instanceof vlc.e) == false) goto L5;
        vlc.e r102 = (vlc.e) r101;
        if (k.c() == true) goto L11;
        return (T) com.bytedance.android.live.network.c.b().e(r100);
    L11:
        if (com.bytedance.android.livesdk.interactivity.service.settings.k.f140999a.getValue().booleanValue() == false) goto L15;
        return (T) e.b().a(r100);
    L15:
        if (r102.isRunning() == false) goto L22;
        if (this.f2582b.contains(r100) == true) goto L20;
        ConcurrentHashMap<Class<?>, Object> r103 = this.f2582b;
        y.i(r100);
        r103.putIfAbsent(r100, Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, new h(this)));
    L20:
        return (T) this.f2582b.get(r100);
    L22:
        return (T) com.bytedance.android.live.network.c.b().e(r100);
    L5:
        return (T) com.bytedance.android.live.network.c.b().e(r100);
    }
}
