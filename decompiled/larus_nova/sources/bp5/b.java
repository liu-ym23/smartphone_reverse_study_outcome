package bp5;

import android.os.Build;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f19974a = null;

    public class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f19975a;

        public a() {
            this.f19975a = new d();
        }

        @Override // bp5.b.e, bp5.b.c
        public final void a(Window r100, boolean r101) {
            super.a(r100, r101);
            this.f19975a.a(r100, r101);
        }
    }

    /* JADX INFO: renamed from: bp5.b$b, reason: collision with other inner class name */
    public class C0334b implements c {
        public C0334b() {
        }

        @Override // bp5.b.c
        public final void a(Window r100, boolean r101) {
        }
    }

    public interface c {
        void a(Window r100, boolean r101);
    }

    public static class d implements c {
        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class b() throws ClassNotFoundException {
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

        public d() {
        }

        @Override // bp5.b.c
        public final void a(Window r100, boolean r110) {
            Class<?> r101 = r100.getClass();
            Class r102 = b();     // Catch: Exception -> L9
            int r103 = r102.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(r102);     // Catch: Exception -> L9
            Class<?> r104 = Integer.TYPE;     // Catch: Exception -> L9
            Method r105 = r101.getMethod("setExtraFlags", new Class[]{r104, r104});     // Catch: Exception -> L9
            Object[] r106 = new Object[2];     // Catch: Exception -> L9
            if (r110 == false) goto L6;
            int r111 = r103;
        L7:
            r106[0] = Integer.valueOf(r111);     // Catch: Exception -> L9
            r106[1] = Integer.valueOf(r103);     // Catch: Exception -> L9
            r105.invoke(r100, r106);     // Catch: Exception -> L9
            return;
        L6:
            r111 = 0;
        L9:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public static class e implements c {
        public e() {
        }

        @Override // bp5.b.c
        public void a(Window r100, boolean r101) {
            View r102 = r100.getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r103 = ThreadMethodProxy.currentThread();
            if (r103 == com.larus.home.impl.utils.c.f346341a) goto L7;
            com.larus.home.impl.utils.c.a(r103, "getDecorView");
        L7:
            int r104 = r102.getSystemUiVisibility();
            if (r101 == false) goto L10;
            int r105 = r104 | 8192;
        L11:
            r102.setSystemUiVisibility(r105);
            return;
        L10:
            r105 = r104 & (-8193);
            goto L11
        }
    }

    public static class f implements c {
        public f() {
        }

        @Override // bp5.b.c
        public final void a(Window r100, boolean r101) {
            WindowManager.LayoutParams r102 = r100.getAttributes();
            Field r103 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");     // Catch: Exception -> L9
            Field r104 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");     // Catch: Exception -> L9
            r103.setAccessible(true);     // Catch: Exception -> L9
            r104.setAccessible(true);     // Catch: Exception -> L9
            int r105 = r103.getInt(null);     // Catch: Exception -> L9
            int r106 = r104.getInt(r102);     // Catch: Exception -> L9
            if (r101 == false) goto L6;
            int r107 = r106 | r105;     // Catch: Exception -> L9
        L7:
            r104.setInt(r102, r107);     // Catch: Exception -> L9
            r100.setAttributes(r102);     // Catch: Exception -> L9
            r103.setAccessible(false);     // Catch: Exception -> L9
            r104.setAccessible(false);     // Catch: Exception -> L9
            return;
        L6:
            r107 = (~r105) & r106;     // Catch: Exception -> L9
        L9:
            e = move-exception;
            e.printStackTrace();
        }
    }

    static {
        PolarisFileInputStreamWrapper r100 = null;
        boolean r101 = false;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(Environment.getRootDirectory(), "build.prop"));     // Catch: Throwable -> L14 IOException -> L18
        Properties r103 = new Properties();     // Catch: Throwable -> L11 IOException -> L13
        r103.load(r102);     // Catch: Throwable -> L11 IOException -> L13
        if (r103.getProperty("ro.miui.ui.version.code") == null) goto L7;
    L10:
        r101 = true;
    L41:
        r102.close();     // Catch: IOException -> L23
    L25:
        if (r101 == false) goto L31;
        if (Build.VERSION.SDK_INT < 23) goto L29;
        f19974a = new a();
        return;
    L29:
        f19974a = new d();
        return;
    L31:
        if (Build.VERSION.SDK_INT < 23) goto L34;
        f19974a = new e();
        return;
    L34:
        if (Build.DISPLAY.startsWith("Flyme") == false) goto L36;
        f19974a = new f();
        return;
    L36:
        f19974a = new C0334b();
        return;
    L7:
        if (r103.getProperty("ro.miui.ui.version.name") != null) goto L10;
        if (r103.getProperty("ro.miui.internal.storage") == null) goto L41;
    L13:
        r100 = r102;
    L11:
        th = move-exception;
        th = th;
        r100 = r102;
    L15:
        if (r100 != null) goto L39;
    L17:
        throw th;
    L39:
        r100.close();     // Catch: IOException -> L38
        goto L17
    L14:
        th = th;
    L19:
        if (r100 == null) goto L25;
        r102 = r100;
        goto L41
    }

    public static void a(Window r100, boolean r101) {
        f19974a.a(r100, r101);
    }
}
