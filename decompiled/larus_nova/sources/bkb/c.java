package bkb;

import android.content.Context;
import com.bytedance.geckox.GeckoBuildInManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes36.dex */
public final class c {
    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.iesgurd.core.e");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.iesgurd.core.GeckoBuildInManager");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.iesgurd.core.GeckoBuildInManager");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.iesgurd.core.e");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.iesgurd.core.GeckoBuildInManager");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.iesgurd.core.GeckoBuildInManager");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.iesgurd.core.GeckoBuildInManager");
    }

    public static d b(Context r110, String r111, String r112, String r113) {
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == false) goto L27;
        Class r100 = a();     // Catch: LinkageError -> L10 ReflectiveOperationException -> L12 ClassNotFoundException -> L19
        Object r114 = r100.getMethod("getBuildInPath", new Class[]{Context.class, String.class, String.class, String.class}).invoke(r100.getField("INSTANCE").get(null), new Object[]{r110, r111, r112, r113});     // Catch: LinkageError -> L10 ReflectiveOperationException -> L12 ClassNotFoundException -> L19
        if (r114 != null) goto L8;
        d r115 = new d(null, null, "IESGurd returns null IESGurdBuildInPath");     // Catch: LinkageError -> L10 ReflectiveOperationException -> L12 ClassNotFoundException -> L19
    L24:
        return r115;
    L8:
        Class<?> r116 = r114.getClass();     // Catch: LinkageError -> L10 ReflectiveOperationException -> L12 ClassNotFoundException -> L19
        r115 = new d((String) r116.getMethod("getPath", new Class[0]).invoke(r114, new Object[0]), (Long) r116.getMethod("getVersion", new Class[0]).invoke(r114, new Object[0]), (String) r116.getMethod("getFailMsg", new Class[0]).invoke(r114, new Object[0]));     // Catch: LinkageError -> L10 ReflectiveOperationException -> L12 ClassNotFoundException -> L19
    L19:
        e = move-exception;
        d r117 = new d(null, null, "IESGurd API is unavailable in OfficeSDK host: " + e);
    L28:
        return r117;
    L10:
        e = e;
    L14:
        if ((e instanceof InvocationTargetException) == false) goto L18;
        InvocationTargetException r118 = (InvocationTargetException) e;
        if (r118.getTargetException() == null) goto L18;
        e = r118.getTargetException();
    L18:
        r117 = new d(null, null, "IESGurd getBuildInPath failed: " + e);
    L12:
        e = e;
        goto L14
    L27:
        return c(r110, r111, r112, r113);
    }

    public static d c(Context r100, String r101, String r102, String r103) {
        GeckoBuildInManager.GeckoBuildInPath r104 = GeckoBuildInManager.INSTANCE.getBuildInPath(r100, r101, r102, r103);
        if (r104 != null) goto L7;
        return new d(null, null, "geckox returns null GeckoBuildInPath");
    L7:
        return new d(r104.getPath(), r104.getVersion(), r104.getFailMsg());
    }
}
