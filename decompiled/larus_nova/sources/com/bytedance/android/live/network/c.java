package com.bytedance.android.live.network;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.network.ILiveRetrofitWrapper;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.retrofit2.Retrofit;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile com.bytedance.android.live.a f83800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile c f83801f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Class, Object> f83802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Class, Object> f83803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Retrofit f83804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile ILiveRetrofitWrapper f83805d;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.android.live.network.impl.utils.RetrofitProvider");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.live.network.impl.utils.RetrofitProvider");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.live.network.impl.utils.RetrofitProvider");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.android.live.network.impl.utils.RetrofitProvider");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.live.network.impl.utils.RetrofitProvider");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.live.network.impl.utils.RetrofitProvider");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.live.network.impl.utils.RetrofitProvider");
    }

    public static c b() {
        if (f83801f != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f83801f != null) goto L9;
        f83801f = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f83801f;
    }

    public static com.bytedance.android.live.a d() {
        if (f83800e != null) goto L9;
        int r100 = jc1.e.f498076a;     // Catch: Throwable -> L6
        f83800e = (com.bytedance.android.live.a) a().newInstance();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        ALogger.i("NetWorkService_", "LiveClient getRetrofitProvider   sRetrofitProvider = null  " + th.getMessage());
        ALogger.e("NetWorkService_", th);
        th.printStackTrace();
    L9:
        return f83800e;
    }

    public final Retrofit c() {
        if (this.f83804c != null) goto L13;
        com.bytedance.android.live.a r100 = d();
        if (r100 == null) goto L13;
        this.f83804c = r100.getRetrofitInstance();     // Catch: Throwable -> L10
        if (this.f83804c != null) goto L13;
        ALogger.i("NetWorkService_", "LiveClient getRetrofit   retrofit = null  ");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        ALogger.i("NetWorkService_", "LiveClient getRetrofit   retrofit = null  err " + th.getMessage());
    L13:
        return this.f83804c;
    }

    public c() {
        this.f83802a = new ConcurrentHashMap();
        this.f83803b = new ConcurrentHashMap();
    }

    public final <T> T e(Class<T> r100) {
        if (this.f83802a.contains(r100) == true) goto L9;
        Retrofit r101 = c();
        if (r101 == null) goto L7;
        this.f83802a.putIfAbsent(r100, r101.create(r100));
        goto L9
    L7:
        ALogger.i("NetWorkService_", "LiveClient getService   getRetrofit = null  ".concat(r100.getName()));
    L9:
        return (T) this.f83802a.get(r100);
    }
}
