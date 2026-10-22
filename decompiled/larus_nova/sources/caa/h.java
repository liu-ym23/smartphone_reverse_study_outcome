package caa;

import android.os.Vibrator;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.aiagent.platform.depend.ISysLogDepend;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f22975a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f22976b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f22977c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f22978d = null;

    static {
        f22975a = LazyKt.lazy(new d());
        f22976b = LazyKt.lazy(new e());
        f22977c = LazyKt.lazy(new f());
        f22978d = LazyKt.lazy(new g());
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

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "effect");
        ISysLogDepend.f384998c.d("SystemHiddenApiHelper", "performVibratorSmtFeedback " + r100);
        Class r101 = (Class) f22977c.getValue();     // Catch: Throwable -> L8
        if (r101 == null) goto L10;
        Field r102 = r101.getField(r100);     // Catch: Throwable -> L8
        if (r102 == null) goto L10;
        Integer r103 = Integer.valueOf(r102.getInt(null));     // Catch: Throwable -> L8
    L11:
        if (r103 == null) goto L20;
        int r104 = r103.intValue();     // Catch: Throwable -> L8
        Method r105 = (Method) f22978d.getValue();     // Catch: Throwable -> L8
        if (r105 == null) goto L21;
        r105.invoke(null, new Object[]{(Vibrator) f22976b.getValue(), Integer.valueOf(r104)});     // Catch: Throwable -> L8
        return;
    L21:
        return;
    L20:
        return;
    L10:
        r103 = null;
    L8:
        th = move-exception;
        ISysLogDepend.f384998c.e("SystemHiddenApiHelper", "vibrator invoke failed", th);
    }
}
