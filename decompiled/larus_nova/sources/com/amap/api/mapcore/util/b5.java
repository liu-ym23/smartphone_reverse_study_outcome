package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdlocation.service.SystemBaseLocationImpl;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class b5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AssetManager f27059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Resources f27060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Context f27061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f27062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f27063e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f27064f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f27065g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f27066h;

    public static class a implements FilenameFilter {
        public a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r100, String r101) {
            int r102 = b5.f27066h;
            if (r101.startsWith("amap_resource") == true) goto L5;
        L7:
            return false;
        L5:
            if (r101.endsWith("1_0_0.jar") == true) goto L7;
            return true;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        f27062d = "amap_resource1_0_0.jar";
        f27063e = "amap_resource1_0_0.png";
        f27064f = "";
        f27065g = f27064f + f27062d;
        f27066h = -1;
    }

    public static Resources a() {
        Resources r100 = f27060b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return f27061c.getResources();
    }

    public b5() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_amap_api_mapcore_util_b5_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
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

    private static boolean a(Context r110) {
        f27064f = r110.getFilesDir().getAbsolutePath();
        f27065g = f27064f + HTTP.URL_DEFAULT + f27062d;
        InputStream r100 = null;
        r100 = p3.d(r110, f27063e);     // Catch: Throwable -> L33
        PolarisFileWrapper r111 = new PolarisFileWrapper(f27065g);     // Catch: Throwable -> L33
        long r101 = r111.length();     // Catch: Throwable -> L33
        int r102 = r100.available();     // Catch: Throwable -> L33
        if (r111.exists() == true) goto L6;
    L9:
        boolean r112 = false;
    L10:
        if (r112 == true) goto L52;
        File[] r113 = new PolarisFileWrapper(f27064f).listFiles(new a());     // Catch: Throwable -> L33
        if (r113 != null) goto L19;
    L23:
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(f27064f, f27062d));     // Catch: Throwable -> L33
        byte[] r114 = new byte[1024];     // Catch: Throwable -> L33
    L24:
        int r104 = r100.read(r114);     // Catch: Throwable -> L33
        if (r104 <= 0) goto L56;
        r103.write(r114, 0, r104);     // Catch: Throwable -> L33
        goto L24
    L56:
        r100.close();     // Catch: IOException -> L30
        r103.close();     // Catch: IOException -> L30
    L32:
        return true;
    L30:
        e = move-exception;
        e.printStackTrace();
        t6.a(e, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
        goto L32
    L19:
        if (r113.length <= 0) goto L23;
        int r105 = r113.length;     // Catch: Throwable -> L33
        int r106 = 0;
    L21:
        if (r106 >= r105) goto L23;
        r113[r106].delete();     // Catch: Throwable -> L33
        r106 = r106 + 1;     // Catch: Throwable -> L33
        goto L21
    L52:
        r100.close();     // Catch: IOException -> L13
    L15:
        return true;
    L13:
        e = move-exception;
        e.printStackTrace();
        t6.a(e, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
        goto L15
    L6:
        if (r101 != r102) goto L9;
        r100.close();     // Catch: Throwable -> L33
        r112 = true;
    L33:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L41
        t6.a(th, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");     // Catch: Throwable -> L41
        if (r100 != null) goto L54;
    L40:
        return false;
    L54:
        r100.close();     // Catch: IOException -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
        t6.a(e, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
    L41:
        th = move-exception;
        if (r100 != null) goto L50;
    L47:
        throw th;
    L50:
        r100.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
        t6.a(e, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
        goto L47
    }

    public static boolean b(Context r100) {
        f27061c = r100;     // Catch: Throwable -> L50
        if (r100 != null) goto L62;
        File r101 = null;
        if (r100 != null) goto L21;
    L30:
        if (r101 == null) goto L32;
        f27064f = r101.getAbsolutePath() + HTTP.URL_DEFAULT;     // Catch: Throwable -> L50
    L32:
        f27065g = f27064f + f27062d;     // Catch: Throwable -> L50
        if (a(r100) == true) goto L35;
        return false;
    L35:
        String r102 = f27065g;     // Catch: Throwable -> L50
        Class r103 = INVOKESTATIC_com_amap_api_mapcore_util_b5_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.content.res.AssetManager");     // Catch: Throwable -> L42
        AssetManager r104 = (AssetManager) r103.getConstructor(null).newInstance(null);     // Catch: Throwable -> L42
        r103.getDeclaredMethod("addAssetPath", new Class[]{String.class}).invoke(r104, new Object[]{r102});     // Catch: Throwable -> L40
    L45:
        f27059a = r104;     // Catch: Throwable -> L50
        DisplayMetrics r105 = new DisplayMetrics();     // Catch: Throwable -> L50
        r105.setToDefaults();     // Catch: Throwable -> L50
        f27060b = new Resources(r104, r105, r100.getResources().getConfiguration());     // Catch: Throwable -> L50
    L52:
        return true;
    L40:
        Throwable th10 = th;
    L44:
        t6.a(th10, "ResourcesUtil", "getAssetManager(String apkPath)");     // Catch: Throwable -> L50
    L42:
        th = move-exception;
        r104 = null;
        th10 = th;
    L21:
        r100.getFilesDir();     // Catch: Throwable -> L50
        goto L30
    L62:
    L25:
        e = e;
        r101 = null;
    L27:
        e.printStackTrace();     // Catch: Throwable -> L46
        if (r101 != null) goto L30;
        r101 = r100.getFilesDir();     // Catch: Throwable -> L50
    L46:
        Throwable th11 = th;
    L47:
        if (r101 != null) goto L49;
        r100.getFilesDir();     // Catch: Throwable -> L50
    L49:
        throw th11;     // Catch: Throwable -> L50
    L23:
        th = move-exception;
        r101 = null;
        th11 = th;
        goto L47
    L10:
        if (Environment.getExternalStorageState().equals("mounted") == false) goto L19;
        r101 = Environment.getExternalStorageDirectory();     // Catch: Throwable -> L23 Exception -> L25
    L17:
        e = e;
        goto L27
    L13:
        if (r101.canWrite() == true) goto L15;
        r101 = r100.getFilesDir();     // Catch: Exception -> L17 Throwable -> L46
    L54:
    L20:
        if (r101 != null) goto L30;
    L15:
        r101 = r100.getExternalFilesDir(SystemBaseLocationImpl.LBS_GEOCODE_NAME);     // Catch: Exception -> L17 Throwable -> L46
        goto L54
    L19:
        r101 = r100.getFilesDir();     // Catch: Throwable -> L23 Exception -> L25
    L50:
        th = move-exception;
        th.printStackTrace();
        goto L52
    }

    public static View a(Context r100, int r101, ViewGroup r102) {
        XmlResourceParser r103 = a().getXml(r101);
        View r104 = null;
        int r105 = f27066h;     // Catch: Throwable -> L8
        if (r105 != (-1)) goto L6;
        r105 = 0;
    L6:
        r104 = LayoutInflater.from(new a5(r100, r105, b5.class.getClassLoader())).inflate(r103, null);     // Catch: Throwable -> L8
    L10:
        r103.close();
        return r104;
    L8:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L12
        t6.a(th, "ResourcesUtil", "selfInflate(Activity activity, int resource, ViewGroup root)");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r103.close();
        throw th;
    }
}
