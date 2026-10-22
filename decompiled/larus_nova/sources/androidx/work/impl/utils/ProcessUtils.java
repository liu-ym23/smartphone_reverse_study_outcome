package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Logger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class ProcessUtils {
    private static final String TAG = null;

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    static {
        TAG = Logger.tagWithPrefix("ProcessUtils");
    }

    private ProcessUtils() {
    }

    public static String getProcessName(Context r100) {
        if (Build.VERSION.SDK_INT < 28) goto L27;
        return Application.getProcessName();
    L27:
        Method r101 = INVOKESTATIC_androidx_work_impl_utils_ProcessUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread", false, ProcessUtils.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L11
        r101.setAccessible(true);     // Catch: Throwable -> L11
        Object r102 = r101.invoke(null, new Object[0]);     // Catch: Throwable -> L11
        if ((r102 instanceof String) == false) goto L13;
        return (String) r102;
    L13:
        int r103 = Process.myPid();
        ActivityManager r104 = (ActivityManager) r100.getSystemService("activity");
        if (r104 == null) goto L26;
        List<ActivityManager.RunningAppProcessInfo> r105 = r104.getRunningAppProcesses();
        if (r105 == null) goto L26;
        if (r105.isEmpty() == true) goto L26;
        Iterator<ActivityManager.RunningAppProcessInfo> r106 = r105.iterator();
    L21:
        if (r106.hasNext() == false) goto L26;
        ActivityManager.RunningAppProcessInfo r107 = r106.next();
        if (r107.pid != r103) goto L21;
        return r107.processName;
    L26:
        return null;
    L11:
        th = move-exception;
        Logger.get().debug(TAG, "Unable to check ActivityThread for processName", new Throwable[]{th});
        goto L13
    }

    public static boolean isDefaultProcess(Context r100, Configuration r101) {
        String r102 = getProcessName(r100);
        if (TextUtils.isEmpty(r101.getDefaultProcessName()) == true) goto L7;
        return TextUtils.equals(r102, r101.getDefaultProcessName());
    L7:
        return TextUtils.equals(r102, r100.getApplicationInfo().processName);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_work_impl_utils_ProcessUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }
}
