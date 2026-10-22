package com.baidu.mshield.x6.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.collection.SieveCacheKt;
import com.alipay.sdk.m.u.i;
import com.baidu.mshield.x6.f.f;
import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class a {
    public static String a(Context r100) {
        return "";
    }

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static String b(Context r100) {
        return "";
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_baidu_mshield_x6_c_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
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

    public static List<String> a(String r110) {
    L110:
        th = move-exception;
        f.b(th);
        return null;
    L4:
        if (TextUtils.isEmpty(r110) == false) goto L6;
        return null;
    L6:
        JSONArray r100 = new JSONArray(r110);     // Catch: Throwable -> L110
        if (r100.length() != 0) goto L9;
        return null;
    L9:
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L110
        int r101 = 0;
    L11:
        if (r101 >= r100.length()) goto L109;
        JSONObject r102 = r100.getJSONObject(r101);     // Catch: Throwable -> L110
        String r103 = String.valueOf(r102.getInt("eid"));     // Catch: Throwable -> L15
    L18:
        int r104 = -1;
        int r105 = r102.getInt("pattern");     // Catch: Throwable -> L21
    L119:
        String r106 = r102.getString(MapController.ITEM_LAYER_TAG);     // Catch: Throwable -> L26
    L115:
        r104 = r102.getInt("type");     // Catch: Throwable -> L31
    L113:
        String r107 = r102.getString("value");     // Catch: Throwable -> L35
    L37:
        if (r104 != 0) goto L42;
        if (TextUtils.isEmpty(r106) == true) goto L42;
        a(r105, r106, r103, r107, r111);     // Catch: Throwable -> L110
    L108:
        r101 = r101 + 1;
    L42:
        if (r104 != 1) goto L47;
        if (TextUtils.isEmpty(r106) == true) goto L47;
        b(r105, r106, r103, r107, r111);     // Catch: Throwable -> L110
    L47:
        if (r104 != 2) goto L52;
        if (TextUtils.isEmpty(r106) == true) goto L52;
        e(r105, r106, r103, r107, r111);     // Catch: Throwable -> L110
    L52:
        if (r104 != 3) goto L57;
        if (TextUtils.isEmpty(r106) == true) goto L57;
        f(r105, r106, r103, r107, r111);     // Catch: Throwable -> L110
    L57:
        if (r104 != 4) goto L95;
        if (TextUtils.isEmpty(r107) == true) goto L95;
        if (TextUtils.isEmpty(r106) == true) goto L95;
        PolarisFileReaderWrapper r108 = new PolarisFileReaderWrapper(new PolarisFileWrapper("/proc/cpuinfo"));     // Catch: Throwable -> L81
        BufferedReader r109 = new BufferedReader(r108);     // Catch: Throwable -> L79
    L121:
        String r112 = r109.readLine();     // Catch: Throwable -> L77
        if (r112 == null) goto L75;
        if (r112.contains(r106) == false) goto L121;
        String r113 = a(r112, r106);     // Catch: Throwable -> L77
        if (TextUtils.isEmpty(r113) == true) goto L121;
        if (r113.startsWith(r107) == false) goto L121;
        if (r111.contains(r103) == true) goto L75;
        r111.add(r103);     // Catch: Throwable -> L77
    L75:
        r108.close();     // Catch: Throwable -> L110
        r109.close();     // Catch: Throwable -> L110
    L77:
        th = th;
    L129:
        f.b(th);     // Catch: Throwable -> L88
        if (r108 == null) goto L86;
        r108.close();     // Catch: Throwable -> L110
    L86:
        if (r109 == null) goto L108;
        r109.close();     // Catch: Throwable -> L110
        goto L108
    L88:
        th = move-exception;
        if (r108 == null) goto L91;
        r108.close();     // Catch: Throwable -> L110
    L91:
        if (r109 == null) goto L93;
        r109.close();     // Catch: Throwable -> L110
    L93:
        throw th;     // Catch: Throwable -> L110
    L79:
        th = th;
        r109 = null;
    L81:
        th = th;
        r108 = null;
        r109 = null;
    L95:
        if (r104 != 13) goto L102;
        if (TextUtils.isEmpty(r107) == true) goto L102;
        if (TextUtils.isEmpty(r106) == true) goto L102;
        c(r105, r106, r103, r107, r111);     // Catch: Throwable -> L110
    L102:
        if (r104 != 14) goto L108;
        if (TextUtils.isEmpty(r107) == true) goto L108;
        if (TextUtils.isEmpty(r106) == true) goto L108;
        d(r105, r106, r103, r107, r111);     // Catch: Throwable -> L110
        goto L108
    L35:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L110
        r107 = null;
        goto L37
    L31:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L110
        goto L113
    L26:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L110
        r106 = null;
        goto L115
    L21:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L110
        r105 = -1;
        goto L119
    L15:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L110
        r103 = null;
        goto L18
    L109:
        return r111;
    }

    public static JSONObject b(String r100) {
    L59:
        th = move-exception;
        f.b(th);
        return null;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L59
        JSONArray r102 = new JSONArray(r100);     // Catch: Throwable -> L59
        if (r102.length() != 0) goto L9;
        return null;
    L9:
        int r103 = 0;
    L10:
        if (r103 >= r102.length()) goto L58;
        JSONObject r104 = r102.getJSONObject(r103);     // Catch: Throwable -> L59
        String r105 = String.valueOf(r104.getInt("eid"));     // Catch: Throwable -> L15
    L18:
        int r106 = -1;
        int r107 = r104.getInt("pattern");     // Catch: Throwable -> L21
    L68:
        String r108 = r104.getString(MapController.ITEM_LAYER_TAG);     // Catch: Throwable -> L26
    L66:
        r106 = r104.getInt("type");     // Catch: Throwable -> L31
    L62:
        String r109 = r104.getString("value");     // Catch: Throwable -> L35
    L38:
        if (r106 != 9) goto L43;
        if (TextUtils.isEmpty(r108) == true) goto L43;
        d(r107, r108, r105, r109, r101);     // Catch: Throwable -> L59
    L57:
        r103 = r103 + 1;
    L43:
        if (r106 != 11) goto L48;
        if (TextUtils.isEmpty(r108) == true) goto L48;
        a(r107, r108, r105, r109, r101);     // Catch: Throwable -> L59
    L48:
        if (r106 != 12) goto L53;
        if (TextUtils.isEmpty(r108) == true) goto L53;
        b(r107, r108, r105, r109, r101);     // Catch: Throwable -> L59
    L53:
        if (r106 != 20) goto L57;
        if (TextUtils.isEmpty(r108) == true) goto L57;
        c(r107, r108, r105, r109, r101);     // Catch: Throwable -> L59
    L35:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L59
        r109 = null;
        goto L38
    L31:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L59
        goto L62
    L26:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L59
        r108 = null;
        goto L66
    L21:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L59
        r107 = -1;
        goto L68
    L15:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L59
        r105 = null;
        goto L18
    L58:
        return r101;
    }

    public static long c(String r100) {
        RandomAccessFile r101 = new RandomAccessFile("proc/self/maps", "r");     // Catch: Throwable -> L14
    L3:
        String r102 = r101.readLine();     // Catch: Throwable -> L14
        if (r102 == null) goto L9;
        r102 = r102.trim();     // Catch: Throwable -> L14
        if (r102.endsWith(r100) == false) goto L3;
    L9:
        if (TextUtils.isEmpty(r102) == true) goto L11;
        long r103 = e(r102.split("-")[0]);     // Catch: Throwable -> L14
    L12:
        r101.close();     // Catch: Throwable -> L14
        return r103;
    L11:
        r103 = 0;
    L14:
        return -1;
    }

    public static String d(String r100) {
        Class r101 = INVOKESTATIC_com_baidu_mshield_x6_c_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Throwable -> L6
        return (String) r101.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r101, new Object[]{r100});
    L6:
        th = move-exception;
        f.b(th);
        return null;
    }

    public static long e(String r100) {
        return CastLongProtector.valueOf(r100, 16).longValue();
    L5:
        e = move-exception;
        f.b(e);
        return SieveCacheKt.NodeMetaAndPreviousMask;
    }

    public static boolean f(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L13;
        return false;
    L13:
        String r101 = com.baidu.xclient.gdid.a.a(r100);     // Catch: Throwable -> L10
        com.baidu.mshield.b.c.a.b("GH getFileInode===" + r101);     // Catch: Throwable -> L10
        if ("-1".equals(new JSONObject(r101).optString("0")) == false) goto L8;
        return false;
    L8:
        return true;
    L10:
        th = move-exception;
        f.b(th);
        return false;
    }

    public static String a(String r100, String r101) {
        Matcher r102 = Pattern.compile("(?i)" + r101 + "\t*: (.*)").matcher(r100);     // Catch: Throwable -> L7
        if (r102.matches() == false) goto L13;
        return r102.group(1);
    L13:
        return null;
    L7:
        th = move-exception;
        f.b(th);
        return null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_baidu_mshield_x6_c_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public static int a(String r100, String r101, String r102) {
        com.baidu.mshield.b.c.a.b("getAPH===" + r100 + i.f25853b + r101 + i.f25853b + r102);
        Class r103 = INVOKESTATIC_com_baidu_mshield_x6_c_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r102) == true) goto L15;
        String[] r104 = r102.split("#");     // Catch: Throwable -> L20
        if (r104 != null) goto L8;
    L14:
        Method r105 = r103.getDeclaredMethod(r101, new Class[0]);     // Catch: Throwable -> L20
    L16:
        if (r105 == null) goto L32;
        if (Modifier.isNative(r105.getModifiers()) == false) goto L32;
        return 1;
    L32:
        Field r106 = INVOKESTATIC_com_baidu_mshield_x6_c_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("de.robv.android.xposed.XposedHelpers", true, ClassLoader.getSystemClassLoader()).getDeclaredField("methodCache");     // Catch: Throwable -> L29
        r106.setAccessible(true);     // Catch: Throwable -> L29
        HashMap r107 = (HashMap) r106.get(null);     // Catch: Throwable -> L29
        StringBuffer r108 = new StringBuffer();     // Catch: Throwable -> L29
        r108.append(r100);     // Catch: Throwable -> L29
        r108.append("#");     // Catch: Throwable -> L29
        r108.append(r101);     // Catch: Throwable -> L29
        Iterator r109 = r107.keySet().iterator();     // Catch: Throwable -> L29
    L25:
        if (r109.hasNext() == false) goto L31;
        if (((String) r109.next()).contains(r108.toString()) == false) goto L25;
        return 1;
    L31:
        return 0;
    L29:
        th = move-exception;
        f.b(th);
        com.baidu.mshield.b.c.a.b("getAPH exe===" + th);
        goto L31
    L8:
        if (r104.length <= 0) goto L14;
        Class<?>[] r110 = new Class[r104.length];     // Catch: Throwable -> L20
        int r111 = 0;
    L11:
        if (r111 >= r104.length) goto L13;
        r110[r111] = INVOKESTATIC_com_baidu_mshield_x6_c_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r104[r111]);     // Catch: Throwable -> L20
        r111 = r111 + 1;     // Catch: Throwable -> L20
        goto L11
    L13:
        r105 = r103.getDeclaredMethod(r101, r110);     // Catch: Throwable -> L20
        goto L16
    L15:
        r105 = r103.getDeclaredMethod(r101, new Class[0]);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        f.b(th);
        goto L32
    }

    public static boolean a(String r100, String r101, int r110) {
        int r102 = r110 - 1;
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L35:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L35;
        String r103 = r100.replaceAll("\\?", "");     // Catch: Throwable -> L33
        File[] r104 = new PolarisFileWrapper(r103).listFiles();     // Catch: Throwable -> L33
        if (r104 == null) goto L35;
        if (r104.length <= 0) goto L35;
        int r105 = r104.length;     // Catch: Throwable -> L33
        int r106 = 0;
    L12:
        if (r106 >= r105) goto L35;
        File r107 = r104[r106];     // Catch: Throwable -> L33
        String r108 = r107.getName();     // Catch: Throwable -> L33
        if (r108 != null) goto L16;
    L19:
        if (r108 != null) goto L21;
    L23:
        if (r108 != null) goto L25;
    L27:
        if (r110 <= 0) goto L32;
        PolarisFileWrapper r109 = new PolarisFileWrapper(r103, r107.getName());     // Catch: Throwable -> L33
        if (r109.isDirectory() == false) goto L32;
        return a(r109.getAbsolutePath(), r101, r102);
    L32:
        r106 = r106 + 1;
        goto L12
    L25:
        if (r108.equals(DownloadConstants.VULNERABILITY_PATH) == false) goto L27;
    L21:
        if (r108.equals(".") == false) goto L23;
    L16:
        if (r108.contains(r101) == false) goto L19;
        return true;
    L33:
        th = move-exception;
        f.b(th);
        goto L35
    }

    public static void a(int r100, String r101, String r102, String r103, JSONObject r104) {
        com.baidu.mshield.b.c.a.b("hanldeEmulatorData11 item=" + r101);     // Catch: Throwable -> L10
        if (r100 != 0) goto L7;
        String r105 = (String) com.baidu.xclient.gdid.a.a(21, r101, r103, null);     // Catch: Throwable -> L10
        r104.put(r102, r105);     // Catch: Throwable -> L10
        com.baidu.mshield.b.c.a.b("hanldeEmulatorData11 pat=0, jniRet=" + r105);     // Catch: Throwable -> L10
    L13:
        return;
    L7:
        if (r100 != 1) goto L13;
        String r106 = (String) com.baidu.xclient.gdid.a.a(22, r101, r103, null);     // Catch: Throwable -> L10
        r104.put(r102, r106);     // Catch: Throwable -> L10
        com.baidu.mshield.b.c.a.b("hanldeEmulatorData11 pat=1, jniRet=" + r106);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        f.b(th);
    }

    public static void b(int r100, String r101, String r102, String r103, List<String> r104) {
        if (r100 != 1) goto L12;
        if (f(r101) == true) goto L7;
        return;
    L7:
        if (r104.contains(r102) == true) goto L67;
        r104.add(r102);     // Catch: Throwable -> L9
        return;
    L67:
        return;
    L12:
        if (r100 != 2) goto L19;
        if (f(r101) == false) goto L16;
        return;
    L16:
        if (r104.contains(r102) == true) goto L70;
        r104.add(r102);     // Catch: Throwable -> L9
        return;
    L70:
        return;
    L19:
        if (r100 == 3) goto L21;
        return;
    L21:
        if (TextUtils.isEmpty(r103) == true) goto L73;
        PolarisFileReaderWrapper r105 = null;
        PolarisFileReaderWrapper r106 = new PolarisFileReaderWrapper(new PolarisFileWrapper(r101));     // Catch: Throwable -> L39
        BufferedReader r107 = new BufferedReader(r106);     // Catch: Throwable -> L36
    L61:
        String r108 = r107.readLine();     // Catch: Throwable -> L34
        if (r108 == null) goto L32;
        if (r108.contains(r103) == false) goto L61;
        if (r104.contains(r102) == true) goto L32;
        r104.add(r102);     // Catch: Throwable -> L34
    L32:
        r106.close();     // Catch: Throwable -> L9
        r107.close();     // Catch: Throwable -> L9
        return;
    L34:
        th = move-exception;
        BufferedReader r109 = r107;
        th = th;
    L38:
        r105 = r106;
    L57:
        f.b(th);     // Catch: Throwable -> L46
        if (r105 == null) goto L44;
        r105.close();     // Catch: Throwable -> L9
    L44:
        if (r109 == null) goto L74;
        r109.close();     // Catch: Throwable -> L9
        return;
    L74:
        return;
    L46:
        th = move-exception;
        if (r105 == null) goto L49;
        r105.close();     // Catch: Throwable -> L9
    L49:
        if (r109 == null) goto L51;
        r109.close();     // Catch: Throwable -> L9
    L51:
        throw th;     // Catch: Throwable -> L9
    L36:
        th = th;
        r109 = null;
    L39:
        th = th;
        r109 = null;
        goto L57
    L73:
        return;
    L9:
        th = move-exception;
        f.b(th);
    }

    public static void c(int r100, String r101, String r102, String r103, JSONObject r104) {
        com.baidu.mshield.b.c.a.b("hanldeEmulatorData20 item=" + r101);     // Catch: Throwable -> L13
        if (r100 != 0) goto L7;
        String r105 = (String) com.baidu.xclient.gdid.a.a(24, r101, r103, null);     // Catch: Throwable -> L13
        r104.put(r102, r105);     // Catch: Throwable -> L13
        com.baidu.mshield.b.c.a.b("hanldeEmulatorData20 pat=0, jniRet=" + r105);     // Catch: Throwable -> L13
    L16:
        return;
    L7:
        if (r100 != 2) goto L10;
        String r106 = (String) com.baidu.xclient.gdid.a.a(25, r101, r103, null);     // Catch: Throwable -> L13
        r104.put(r102, r106);     // Catch: Throwable -> L13
        com.baidu.mshield.b.c.a.b("hanldeEmulatorData20 pat=2, jniRet=" + r106);     // Catch: Throwable -> L13
        goto L16
    L10:
        if (r100 != 3) goto L16;
        String r107 = (String) com.baidu.xclient.gdid.a.a(26, r101, r103, null);     // Catch: Throwable -> L13
        r104.put(r102, r107);     // Catch: Throwable -> L13
        com.baidu.mshield.b.c.a.b("hanldeEmulatorData20 pat=3, jniRet=" + r107);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        f.b(th);
    }

    public static void d(int r100, String r101, String r110, String r111, List<String> r112) {
        com.baidu.mshield.b.c.a.b("hanldeEmulatorData14===" + r100 + i.f25853b + r101 + i.f25853b + r110 + i.f25853b + r111);     // Catch: Throwable -> L12
        if (r100 != 0) goto L17;
        String[] r102 = r111.split("\\|");     // Catch: Throwable -> L12
        if (r102.length == 2) goto L8;
        return;
    L8:
        String r103 = (String) com.baidu.xclient.gdid.a.a(16, r101, r102[0], new long[]{Long.valueOf(r102[1]).longValue(), c(r101)});     // Catch: Throwable -> L12
        com.baidu.mshield.b.c.a.b("GH jniCtl ===" + r103);     // Catch: Throwable -> L12
        if ("1".equals(r103) == false) goto L18;
        r112.add(r110);     // Catch: Throwable -> L12
        return;
    L18:
        return;
    L17:
        return;
    L12:
        th = move-exception;
        f.b(th);
    }

    public static void e(int r100, String r101, String r102, String r103, List<String> r104) {
        if (r100 != 1) goto L12;
        if (f(r101) == true) goto L7;
        return;
    L7:
        if (r104.contains(r102) == true) goto L52;
        r104.add(r102);     // Catch: Throwable -> L9
        return;
    L52:
        return;
    L12:
        if (r100 != 2) goto L19;
        if (f(r101) == false) goto L16;
        return;
    L16:
        if (r104.contains(r102) == true) goto L55;
        r104.add(r102);     // Catch: Throwable -> L9
        return;
    L55:
        return;
    L19:
        if (r100 == 6) goto L21;
        return;
    L21:
        if (TextUtils.isEmpty(r103) == false) goto L23;
        return;
    L23:
        if (r101.contains("?") == true) goto L39;
        File[] r105 = new PolarisFileWrapper(r101).listFiles();     // Catch: Throwable -> L9
        if (r105 != null) goto L27;
        return;
    L27:
        if (r105.length <= 0) goto L60;
        int r106 = r105.length;     // Catch: Throwable -> L9
        int r107 = 0;
    L29:
        if (r107 >= r106) goto L66;
        String r108 = r105[r107].getName();     // Catch: Throwable -> L9
        if (r108 == null) goto L37;
        if (r108.contains(r103) == false) goto L37;
        if (r104.contains(r102) == true) goto L61;
        r104.add(r102);     // Catch: Throwable -> L9
        return;
    L61:
        return;
    L37:
        r107 = r107 + 1;     // Catch: Throwable -> L9
        goto L29
    L66:
        return;
    L60:
        return;
    L39:
        if (a(r101, r103, 2) == true) goto L41;
        return;
    L41:
        if (r104.contains(r102) == true) goto L64;
        r104.add(r102);     // Catch: Throwable -> L9
        return;
    L64:
        return;
    L9:
        th = move-exception;
        f.b(th);
    }

    public static void f(int r100, String r101, String r102, String r103, List<String> r104) {
        if (r100 != 1) goto L12;
        if (TextUtils.isEmpty(d(r101)) == false) goto L7;
    L45:
        return;
    L7:
        if (r104.contains(r102) == true) goto L45;
        r104.add(r102);     // Catch: Throwable -> L9
        goto L45
    L12:
        if (r100 != 2) goto L19;
        if (TextUtils.isEmpty(d(r101)) == false) goto L45;
        if (r104.contains(r102) == true) goto L45;
        r104.add(r102);     // Catch: Throwable -> L9
        goto L45
    L19:
        if (r100 != 3) goto L30;
        String r105 = d(r101);     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r105) == true) goto L45;
        if (TextUtils.isEmpty(r103) == true) goto L45;
        if (r105.contains(r103) == false) goto L45;
        if (r104.contains(r102) == true) goto L45;
        r104.add(r102);     // Catch: Throwable -> L9
        goto L45
    L30:
        if (r100 == 4) goto L32;
        return;
    L32:
        if (TextUtils.isEmpty(r101) == true) goto L45;
        String r106 = d(r101);     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r106) == true) goto L45;
        if (TextUtils.isEmpty(r103) == true) goto L45;
        if (r106.startsWith(r103) == false) goto L45;
        if (r104.contains(r102) == true) goto L45;
        r104.add(r102);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        f.b(th);
    }

    public static void a(int r100, String r101, String r102, String r103, List<String> r104) {
        if (r100 != 1) goto L14;
        if (r101.contains(HTTP.URL_DEFAULT) == false) goto L23;
        String r105 = r101.replace(HTTP.URL_DEFAULT, ".");     // Catch: Throwable -> L11
        INVOKESTATIC_com_baidu_mshield_x6_c_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r105, false, ClassLoader.getSystemClassLoader());     // Catch: ClassNotFoundException -> L9 Throwable -> L11
        r104.add(r102);     // Catch: ClassNotFoundException -> L9 Throwable -> L11
    L9:
        e = move-exception;
        f.b(e);     // Catch: Throwable -> L11
    L23:
        return;
    L14:
        if (r100 != 2) goto L31;
        String r106 = r101.replace(HTTP.URL_DEFAULT, ".");     // Catch: Throwable -> L11
        INVOKESTATIC_com_baidu_mshield_x6_c_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r106, false, ClassLoader.getSystemClassLoader());     // Catch: Throwable -> L11 ClassNotFoundException -> L18
    L18:
        e = move-exception;
        f.b(e);     // Catch: Throwable -> L11
        r104.add(r102);     // Catch: Throwable -> L11
        goto L23
    L31:
        return;
    L11:
        th = move-exception;
        f.b(th);
    }

    public static void b(int r100, String r101, String r102, String r103, JSONObject r104) {
        com.baidu.mshield.b.c.a.b("hanldeEmulatorData12 item=" + r101);     // Catch: Throwable -> L7
        com.baidu.mshield.b.c.a.b("hanldeEmulatorData12 value=" + r103);     // Catch: Throwable -> L7
        if (r100 != 0) goto L12;
        String r105 = (String) com.baidu.xclient.gdid.a.a(23, r101, Integer.valueOf(Integer.parseInt(r103)), null);     // Catch: Throwable -> L7
        r104.put(r102, r105);     // Catch: Throwable -> L7
        com.baidu.mshield.b.c.a.b("hanldeEmulatorData12 pat=0, jniRet=" + r105);     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        f.b(th);
    }

    public static void c(int r100, String r101, String r102, String r103, List<String> r104) {
        com.baidu.mshield.b.c.a.b("hanldeEmulatorData13===" + r100 + i.f25853b + r101 + i.f25853b + r102 + i.f25853b + r103);     // Catch: Throwable -> L13
        if (r100 != 0) goto L18;
        String[] r105 = r103.split("\\|");     // Catch: Throwable -> L13
        String r106 = r105[0];     // Catch: Throwable -> L13
        if (r105.length != 2) goto L8;
        String r107 = r105[1].replace("$", "#");     // Catch: Throwable -> L13
    L10:
        if (1 != a(r101, r106, r107)) goto L19;
        r104.add(r102);     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L8:
        r107 = null;
        goto L10
    L18:
        return;
    L13:
        th = move-exception;
        f.b(th);
    }

    public static void d(int r100, String r101, String r102, String r103, JSONObject r104) {
        com.baidu.mshield.b.c.a.b("hanldeEmulatorData9 item=" + r101);     // Catch: Throwable -> L8
        String r105 = (String) com.baidu.xclient.gdid.a.a(10, r101, r103, null);     // Catch: Throwable -> L8
        com.baidu.mshield.b.c.a.b("hanldeEmulatorData9 prop=" + r105);     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r105) == true) goto L6;
        r104.put(r102, r105);     // Catch: Throwable -> L8
    L11:
        return;
    L6:
        r104.put(r102, "");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        f.b(th);
    }
}
