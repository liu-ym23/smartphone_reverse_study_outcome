package b27;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static MessageQueue f17046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f17047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f17048c;

    public static MessageQueue b() {
        if (f17046a != null) goto L17;
        if (Looper.getMainLooper() == null) goto L17;
        Looper r100 = Looper.getMainLooper();
        if (r100 != Looper.myLooper()) goto L10;
        f17046a = Looper.myQueue();
        goto L17
    L10:
        if (Build.VERSION.SDK_INT < 23) goto L18;
        f17046a = r100.getQueue();
        goto L17
    L18:
        Field r101 = r100.getClass().getDeclaredField("mQueue");     // Catch: Throwable -> L14
        r101.setAccessible(true);     // Catch: Throwable -> L14
        f17046a = (MessageQueue) r101.get(r100);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.printStackTrace();
    L17:
        return f17046a;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    public static Message c(MessageQueue r100) {
        Field r101 = f17047b;
        if (r101 != null) goto L12;
        Field r102 = a("android.os.MessageQueue").getDeclaredField("mMessages");     // Catch: Exception -> L6
        f17047b = r102;     // Catch: Exception -> L6
        r102.setAccessible(true);     // Catch: Exception -> L6
        return (Message) f17047b.get(r100);
    L6:
        return null;
    L12:
        return (Message) r101.get(r100);
    L9:
        return null;
    }
}
