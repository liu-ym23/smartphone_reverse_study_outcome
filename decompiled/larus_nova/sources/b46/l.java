package b46;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.sva.sdk.data.ISmModel;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f17550a = 0;

    static {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.MiuiWindowManager$LayoutParams");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.MiuiWindowManager$LayoutParams");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.view.MiuiWindowManager$LayoutParams");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class b(ClassLoader r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = r100.loadClass("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r104 = r100.loadClass("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass("android.os.SystemProperties");
    }

    public static void c(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        r100.getWindow().setFlags(1024, 1024);
        Class r101 = b(r100.getApplicationContext().getClassLoader());     // Catch: Exception -> L9
        Object r102 = r101.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(r101, new Object[]{"ro.miui.notch", 0});     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L9
        if (((Integer) r102).intValue() != 1) goto L11;
        if (Build.VERSION.SDK_INT >= 28) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L22;
        Class r104 = Integer.TYPE;     // Catch: Exception -> L15
        Intrinsics.checkNotNull(r104);     // Catch: Exception -> L15
        Window.class.getMethod("addExtraFlags", new Class[]{r104}).invoke(r100.getWindow(), new Object[]{Integer.valueOf(ISmModel.VERSION_0300)});     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        return;
    L22:
        return;
    L11:
        r103 = false;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static void d(boolean r100, Window r101) {
        Intrinsics.checkNotNullParameter(r101, LiveEndPageData.TAG_WINDOW);
        Class<?> r102 = r101.getClass();     // Catch: Throwable -> L9
        Class r103 = a();     // Catch: Throwable -> L9
        int r104 = r103.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(r103);     // Catch: Throwable -> L9
        Class<?> r105 = Integer.TYPE;     // Catch: Throwable -> L9
        Method r106 = r102.getMethod("setExtraFlags", new Class[]{r105, r105});     // Catch: Throwable -> L9
        Object[] r107 = new Object[2];     // Catch: Throwable -> L9
        if (r100 == false) goto L6;
        int r108 = r104;
    L7:
        r107[0] = Integer.valueOf(r108);     // Catch: Throwable -> L9
        r107[1] = Integer.valueOf(r104);     // Catch: Throwable -> L9
        r106.invoke(r101, r107);     // Catch: Throwable -> L9
        return;
    L6:
        r108 = 0;
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    public static void e(Activity r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (Build.VERSION.SDK_INT < 23) goto L6;
        r100.getWindow().clearFlags(67108864);
        r100.getWindow().addFlags(Integer.MIN_VALUE);
        r100.getWindow().setStatusBarColor(r101);
        r100.getWindow().findViewById(R.id.content).setForeground(null);
        return;
    L6:
        r100.getWindow().setStatusBarColor(r101);
    }
}
