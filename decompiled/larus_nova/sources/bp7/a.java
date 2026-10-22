package bp7;

import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xo7.b f19978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xo7.e f19979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public xo7.d f19980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public xo7.c f19981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public xo7.a f19982e;

    /* JADX INFO: renamed from: bp7.a$a, reason: collision with other inner class name */
    public static class C0335a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f19983a = null;

        static {
            f19983a = new a();
        }
    }

    public static String e() {
        String r100 = "";
        Class r101 = a("android.os.SystemProperties");     // Catch: Throwable -> L22
        String r102 = (String) r101.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r101, new Object[]{"ro.preinstall.path"});     // Catch: Throwable -> L22
        xo7.d r103 = C0335a.f19983a.f19980c;     // Catch: Throwable -> L20
        if (r103 == null) goto L8;
        r103.k();     // Catch: Throwable -> L20
        String r104 = "doubao_oppo_yz.config";
    L9:
        if (r102 != null) goto L11;
    L17:
        r100 = r102;
    L18:
        zo7.b.d("getOppoChannelPath", "oppo channel path is " + r100);     // Catch: Throwable -> L22
        return r100;
    L11:
        if (TextUtils.isEmpty(r102) == true) goto L17;
        String r105 = File.separator;     // Catch: Throwable -> L20
        if (r102.endsWith(r105) == false) goto L15;
        r100 = r102.concat(r104);     // Catch: Throwable -> L20
        goto L18
    L15:
        r100 = r102.concat(r105).concat(r104);     // Catch: Throwable -> L20
        goto L18
    L8:
        r104 = null;
    L20:
        th = th;
    L24:
        zo7.b.b("getOppoChannelPath", "getOppoChannelPath meet err, err is " + th);
        return r102;
    L22:
        th = th;
        r102 = r100;
        goto L24
    }

    public static String f() {
        String r100 = "";
        Class r101 = a("android.os.SystemProperties");     // Catch: Throwable -> L22
        String r102 = (String) r101.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r101, new Object[]{"ro.preinstall.path"});     // Catch: Throwable -> L22
        xo7.d r103 = C0335a.f19983a.f19980c;     // Catch: Throwable -> L20
        if (r103 == null) goto L8;
        r103.e();     // Catch: Throwable -> L20
        String r104 = "doubao_vivo_yz.config";
    L9:
        if (r102 != null) goto L11;
    L17:
        r100 = r102;
    L18:
        zo7.b.d("getVivoChannelPath", "vivo channel path is " + r100);     // Catch: Throwable -> L22
        return r100;
    L11:
        if (TextUtils.isEmpty(r102) == true) goto L17;
        String r105 = File.separator;     // Catch: Throwable -> L20
        if (r102.endsWith(r105) == false) goto L15;
        r100 = r102.concat(r104);     // Catch: Throwable -> L20
        goto L18
    L15:
        r100 = r102.concat(r105).concat(r104);     // Catch: Throwable -> L20
        goto L18
    L8:
        r104 = null;
    L20:
        th = th;
    L24:
        zo7.b.b("getVivoChannelPath", "getVivoChannelPath meet err, err is " + th);
        return r102;
    L22:
        th = th;
        r102 = r100;
        goto L24
    }

    public a() {
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

    public static String c(String r100) {
        Class r101 = a("android.os.SystemProperties");     // Catch: Exception -> L5
        String r102 = (String) r101.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r101, new Object[]{r100});     // Catch: Exception -> L5
        zo7.b.d("YZConfigManager", "sPath is " + r102);     // Catch: Exception -> L5
        return r102;
    L5:
        e = move-exception;
        zo7.b.b("YZConfigManager", "getChannelPath meet err, " + e);
        return "";
    }

    public static String d(String r100) {
        String r101 = (String) a("miui.os.MiuiInit").getMethod("getMiuiChannelPath", new Class[]{String.class}).invoke(null, new Object[]{r100});     // Catch: Exception -> L5
        zo7.b.d("YZConfigManager", "result is " + r101);     // Catch: Exception -> L5
        return r101;
    L5:
        e = move-exception;
        zo7.b.b("YZConfigManager", "getMiuiChannelPath meet err, " + e);
        return "";
    }

    public final void b(Runnable r100) {
        xo7.c r101 = this.f19981d;
        if (r101 == null) goto L5;
        r101.execute(r100);
        zo7.b.d("YZConfigManager", "executeRunnable is called, use executor provided by host");
        return;
    L5:
        zo7.b.d("YZConfigManager", "executeRunnable is called, but use sdk inner executor");
        yo7.c.f568676a.submit(r100);
    }
}
