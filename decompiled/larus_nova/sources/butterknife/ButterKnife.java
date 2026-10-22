package butterknife;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.home.impl.utils.c;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public final class ButterKnife {
    static final Map<Class<?>, Constructor<? extends Unbinder>> BINDINGS = null;
    private static final String TAG = "ButterKnife";
    private static boolean debug;

    static {
        BINDINGS = new LinkedHashMap();
    }

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    public static View INVOKEVIRTUAL_butterknife_ButterKnife_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static Unbinder bind(Activity r100) {
        return bind(r100, INVOKEVIRTUAL_butterknife_ButterKnife_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()));
    }

    private static Constructor<? extends Unbinder> findBindingConstructorForClass(Class<?> r100) {
        Map<Class<?>, Constructor<? extends Unbinder>> r101 = BINDINGS;
        Constructor<? extends Unbinder> r102 = r101.get(r100);
        if (r102 == null) goto L5;
    L27:
        return r102;
    L5:
        if (r101.containsKey(r100) == true) goto L27;
        String r103 = r100.getName();
        if (r103.startsWith("android.") == false) goto L10;
        return null;
    L10:
        if (r103.startsWith("java.") == false) goto L12;
        return null;
    L12:
        if (r103.startsWith("androidx.") == true) goto L31;
        Constructor<? extends Unbinder> r104 = INVOKEVIRTUAL_butterknife_ButterKnife_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r100.getClassLoader(), r103.concat("_ViewBinding")).getConstructor(new Class[]{r100, View.class});     // Catch: NoSuchMethodException -> L16 ClassNotFoundException -> L19
        boolean r105 = debug;     // Catch: NoSuchMethodException -> L16 ClassNotFoundException -> L19
    L23:
        BINDINGS.put(r100, r104);
        return r104;
    L16:
        e = move-exception;
        throw new RuntimeException("Unable to find binding constructor for ".concat(r103), e);
    L20:
        if (debug == false) goto L22;
        r100.getSuperclass().getName();
    L22:
        r104 = findBindingConstructorForClass(r100.getSuperclass());
        goto L23
    L31:
        return null;
    }

    public static void setDebug(boolean r100) {
        debug = r100;
    }

    public static Unbinder bind(Dialog r100) {
        return bind(r100, INVOKEVIRTUAL_butterknife_ButterKnife_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()));
    }

    public static Unbinder bind(View r100) {
        return bind(r100, r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_butterknife_ButterKnife_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    public static Unbinder bind(Object r100, View r101) {
        Class<?> r102 = r100.getClass();
        if (debug == true) goto L5;
    L5:
        Constructor<? extends Unbinder> r103 = findBindingConstructorForClass(r102);
        if (r103 != null) goto L29;
        return Unbinder.EMPTY;
    L29:
        return r103.newInstance(new Object[]{r100, r101});
    L26:
        e = move-exception;
        throw new RuntimeException("Unable to invoke " + r103, e);
    L23:
        e = move-exception;
        throw new RuntimeException("Unable to invoke " + r103, e);
    L12:
        e = move-exception;
        Throwable r104 = e.getCause();
        if ((r104 instanceof RuntimeException) == true) goto L22;
        if ((r104 instanceof Error) == false) goto L20;
        throw ((Error) r104);
    L20:
        throw new RuntimeException("Unable to create binding instance.", r104);
    L22:
        throw ((RuntimeException) r104);
    }

    public static Unbinder bind(Object r100, Activity r101) {
        return bind(r100, INVOKEVIRTUAL_butterknife_ButterKnife_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101.getWindow()));
    }

    public static Unbinder bind(Object r100, Dialog r101) {
        return bind(r100, INVOKEVIRTUAL_butterknife_ButterKnife_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101.getWindow()));
    }
}
