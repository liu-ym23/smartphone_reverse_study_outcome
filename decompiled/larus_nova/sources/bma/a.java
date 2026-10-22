package bma;

import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import vma.c;
import wma.b;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class<?> f19667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f19668b;

    static {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("bytedanceos.api.VibratorSmt");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("bytedanceos.api.VibratorSmt");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("bytedanceos.api.VibratorSmt");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("bytedanceos.api.VibratorSmt");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("bytedanceos.api.VibratorSmt");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("bytedanceos.api.VibratorSmt");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("bytedanceos.api.VibratorSmt");
    }

    public static void b(View r100, int r101) {
        if (r100 == null) goto L11;
        r100.performHapticFeedback(r101);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        b.b("VibratorSmt", Intrinsics.stringPlus("performHapticFeedbackAOSP error: ", e));
        return;
    }

    @JvmStatic
    public static final void c(Context r100, int r101) {
        int r102 = c.f556351a;
        Object r103 = null;
        if (r100 != null) goto L5;
        Object r104 = null;
    L6:
        if (r104 != null) goto L9;
    L11:
        Vibrator r105 = (Vibrator) r103;
        boolean r106 = false;
        if (r105 == null) goto L30;
        Intrinsics.checkNotNullParameter(r105, PickerReporterConstants.KEY.TARGET);
    L28:
        e = move-exception;
        b.b("VibratorSmt", Intrinsics.stringPlus("vibrateEffectWithHapticPlayer error: ", e));
        return;
    L15:
        if (f19667a != null) goto L18;
        f19667a = a();     // Catch: Exception -> L28
    L18:
        if (f19668b != null) goto L23;
        Class<?> r107 = f19667a;     // Catch: Exception -> L28
        Intrinsics.checkNotNull(r107);     // Catch: Exception -> L28
        Method r108 = r107.getDeclaredMethod("vibrateEffectWithHapticPlayer", new Class[]{Vibrator.class, Integer.TYPE});     // Catch: Exception -> L28
        f19668b = r108;     // Catch: Exception -> L28
        if (r108 == null) goto L23;
        r108.setAccessible(true);     // Catch: Exception -> L28
    L23:
        Method r109 = f19668b;     // Catch: Exception -> L28
        if (r109 == null) goto L36;
        r109.invoke(f19667a, new Object[]{r105, Integer.valueOf(r101)});     // Catch: Exception -> L28
        return;
    L36:
        return;
    L30:
        if (r100 != null) goto L32;
        r106 = true;
    L32:
        b.b("VibratorSmt", Intrinsics.stringPlus("vibrateEffectWithHapticPlayer error: vibrator is null, context is null? ", Boolean.valueOf(r106)));
        return;
    L9:
        if ((r104 instanceof Vibrator) == false) goto L11;
        r103 = r104;
        goto L11
    L5:
        r104 = r100.getSystemService("vibrator");
        goto L6
    }
}
