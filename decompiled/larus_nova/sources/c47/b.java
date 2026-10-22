package c47;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f22393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f22394b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f22395a = null;

        static {
            f22395a = new b();
        }
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.pia.core.ServiceProvider");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.pia.core.ServiceProvider");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.pia.core.ServiceProvider");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.pia.core.ServiceProvider");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.pia.core.ServiceProvider");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.pia.core.ServiceProvider");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.pia.core.ServiceProvider");
    }

    public b() {
        this.f22393a = null;
        this.f22394b = null;
        Class r100 = a();     // Catch: Throwable -> L5
        this.f22393a = r100.newInstance();     // Catch: Throwable -> L5
        this.f22394b = r100.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{Class.class});     // Catch: Throwable -> L5
        return;
    }

    public static <T> T b(Class<T> r100) {
        b r101 = a.f22395a;
        Object r102 = r101.f22393a;
        if (r102 == null) goto L10;
        Method r103 = r101.f22394b;
        if (r103 == null) goto L10;
        return (T) r103.invoke(r102, new Object[]{r100});
    L10:
        return null;
    }
}
