package cn.com.chinatelecom.account;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f24401a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f24402b;

    static {
        f24401a = PatternProtector.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        f24402b = "";
    }

    private static String a(Context r100) {
        String r101 = a(UUID.randomUUID().toString() + "default");
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return "default";
    L6:
        return r101;
    }

    private static String a(Context r110, String r111) {
        Class r112 = INVOKEVIRTUAL_cn_com_chinatelecom_account_i_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r110.getClassLoader(), g0.a(new byte[]{HTTP.CR, 2, 8, 30, 3, 5, 8, 66, 3, 31, 66, 28, 30, 3, 28, 9, 30, 24, 5, 9, 31}));     // Catch: Exception -> L5
        return (String) r112.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r112, new Object[]{r111});
    L5:
        return "";
    }

    private static String a(String r100) {
        char[] r101 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        byte[] r102 = r100.getBytes();     // Catch: Exception -> L8
        MessageDigest r103 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L8
        r103.update(r102);     // Catch: Exception -> L8
        byte[] r104 = r103.digest();     // Catch: Exception -> L8
        int r105 = r104.length;     // Catch: Exception -> L8
        char[] r106 = new char[r105 * 2];     // Catch: Exception -> L8
        int r107 = 0;
        int r108 = 0;
    L4:
        if (r107 >= r105) goto L6;
        byte r109 = r104[r107];     // Catch: Exception -> L8
        int r110 = r108 + 1;     // Catch: Exception -> L8
        r106[r108] = r101[(r109 >>> 4) & 15];     // Catch: Exception -> L8
        r108 = r110 + 1;     // Catch: Exception -> L8
        r106[r110] = r101[r109 & 15];     // Catch: Exception -> L8
        r107 = r107 + 1;     // Catch: Exception -> L8
        goto L4
    L6:
        return new String(r106);
    L8:
        return null;
    }

    public static StringBuffer a() {
        StringBuffer r100 = new StringBuffer();
        Enumeration<NetworkInterface> r101 = NetworkInterface.getNetworkInterfaces();
    L4:
        if (r101.hasMoreElements() == false) goto L25;
        NetworkInterface r102 = r101.nextElement();
        String r103 = r102.getName();
        if (r103 == null) goto L12;
        if (r103.contains("wlan") == true) goto L4;
        if (r103.equals("eth0") == true) goto L4;
    L12:
        Enumeration<InetAddress> r104 = r102.getInetAddresses();
    L14:
        if (r104.hasMoreElements() == false) goto L4;
        InetAddress r105 = r104.nextElement();
        if (r105.isLoopbackAddress() == true) goto L14;
        if (r105.isLinkLocalAddress() == true) goto L14;
        String r106 = r105.getHostAddress();
        if (TextUtils.isEmpty(r106) == true) goto L14;
        if (r100.length() <= 0) goto L24;
        r100.append(",");
    L24:
        r100.append(r106);
        goto L14
    L25:
        return r100;
    }

    public static boolean a(Object r100, String r101) {
        Method r102 = r100.getClass().getDeclaredMethod(r101, new Class[0]);
        r102.setAccessible(true);
        return ((Boolean) r102.invoke(r100, new Object[0])).booleanValue();
    }

    public static String b() {
        String r100 = UUID.randomUUID().toString();
        r100 = UUID.nameUUIDFromBytes((r100 + System.currentTimeMillis() + Math.random()).getBytes("utf8")).toString();     // Catch: Throwable -> L5
    L8:
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return r100;
    L10:
        return r100.replace("-", "");
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }

    private static void b(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L8;
        if (r100 == null) goto L9;
        h.b(r100, "key_d_i_u", r101);
        return;
    L9:
        return;
    }

    private static boolean b(Context r210) {
        String r100 = g0.a(new byte[]{67, 28, 30, 3, 15, 67});     // Catch: Throwable -> L50
        String r110 = g0.a(new byte[]{67, 1, HTTP.CR, 28, 31});     // Catch: Throwable -> L50
        String r111 = g0.a(new byte[]{15, 3, 1, 66, 31, HTTP.CR, 25, 30, 5, 7, 66, 31, 25, 14, 31, 24, 30, HTTP.CR, 24, 9});     // Catch: Throwable -> L50
        String r101 = g0.a(new byte[]{52, 28, 3, 31, 9, 8, 46, 30, 5, 8, 11, 9, 66, 6, HTTP.CR, 30});     // Catch: Throwable -> L50
        HashSet r102 = new HashSet();     // Catch: Throwable -> L50
        PolarisFileReaderWrapper r103 = new PolarisFileReaderWrapper(r100 + Process.myPid() + r110);     // Catch: Throwable -> L50
        BufferedReader r104 = new BufferedReader(r103);     // Catch: Throwable -> L48
    L63:
        String r105 = r104.readLine();     // Catch: Throwable -> L46
        if (r105 == null) goto L12;
        if (r105.endsWith(".so") == true) goto L11;
        if (r105.endsWith(".jar") == false) goto L63;
    L11:
        r102.add(r105.substring(r105.lastIndexOf(" ") + 1));     // Catch: Throwable -> L46
        goto L63
    L12:
        Iterator r106 = r102.iterator();     // Catch: Throwable -> L46
    L13:
        if (r106.hasNext() == false) goto L83;
        String r107 = (String) r106.next();     // Catch: Throwable -> L46
        if (r107.contains(r111) == false) goto L27;
        r104.close();     // Catch: Exception -> L19
    L67:
        r103.close();     // Catch: Exception -> L23
    L25:
        return true;
    L23:
        e = move-exception;
        e.printStackTrace();
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L67
    L27:
        if (r107.contains(r101) == false) goto L13;
        r104.close();     // Catch: Exception -> L30
    L77:
        r103.close();     // Catch: Exception -> L34
    L36:
        return true;
    L34:
        e = move-exception;
        e.printStackTrace();
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L77
    L83:
        r104.close();     // Catch: Exception -> L39
    L73:
        r103.close();     // Catch: Exception -> L43
    L45:
        return false;
    L43:
        e = move-exception;
        e.printStackTrace();
    L39:
        e = move-exception;
        e.printStackTrace();
    L46:
        th = move-exception;
        Throwable r108 = th;
    L52:
        if (r104 != null) goto L81;
    L57:
        if (r103 == null) goto L92;
        r103.close();     // Catch: Exception -> L60
        throw r108;
    L60:
        e = move-exception;
        e.printStackTrace();
        throw r108;
    L92:
        throw r108;
    L81:
        r104.close();     // Catch: Exception -> L55
    L55:
        e = move-exception;
        e.printStackTrace();
    L48:
        th = move-exception;
        r108 = th;
        r104 = null;
    L50:
        th = move-exception;
        r108 = th;
        r104 = null;
        r103 = null;
        goto L52
    }

    private static boolean b(String r100) {
        Process r101 = null;
        r101 = cn_com_chinatelecom_account_i_java_lang_Runtime_exec(Runtime.getRuntime(), "ls -l " + r100);     // Catch: Throwable -> L16
        String r102 = new BufferedReader(new InputStreamReader(r101.getInputStream())).readLine();     // Catch: Throwable -> L16
        if (r102 != null) goto L6;
    L14:
        r101.destroy();
        return false;
    L6:
        if (r102.length() < 4) goto L14;
        char r103 = r102.charAt(3);     // Catch: Throwable -> L16
        if (r103 != 's') goto L11;
    L12:
        r101.destroy();
        return true;
    L11:
        if (r103 != 'x') goto L14;
    L16:
        th = move-exception;
        if (r101 == null) goto L19;
        r101.destroy();
    L19:
        throw th;
    }

    public static boolean c() {
        String r100 = g0.a(new byte[]{67, 31, 21, 31, 24, 9, 1, 67, 14, 5, 2, 67, 31, 25});
        String r101 = g0.a(new byte[]{67, 31, 21, 31, 24, 9, 1, 67, 20, 14, 5, 2, 67, 31, 25});
        if (new PolarisFileWrapper(r100).exists() == false) goto L8;
        if (b(r100) == false) goto L8;
        return true;
    L8:
        if (new PolarisFileWrapper(r101).exists() == true) goto L10;
        return false;
    L10:
        if (b(r101) == false) goto L14;
        return true;
    L14:
        return false;
    }

    private static boolean c(Context r100) {
        String r101 = g0.a(new byte[]{8, 9, 66, 30, 3, 14, 26, 66, HTTP.CR, 2, 8, 30, 3, 5, 8, 66, 20, 28, 3, 31, 9, 8, 66, 5, 2, 31, 24, HTTP.CR, 0, 0, 9, 30});
        String r102 = g0.a(new byte[]{15, 3, 1, 66, 31, HTTP.CR, 25, 30, 5, 7, 66, 31, 25, 14, 31, 24, 30, HTTP.CR, 24, 9});
        if (r100.createPackageContext(r101, 2) == null) goto L6;
        boolean r103 = true;
    L18:
        if (r100.createPackageContext(r102, 2) == null) goto L11;
        boolean r104 = true;
    L12:
        if (r103 == true) goto L16;
        if (r104 == true) goto L16;
        return false;
    L16:
        return true;
    L11:
        r104 = false;
    L6:
        r103 = false;
        goto L18
    }

    public static boolean c(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (f24401a.matcher(r100).matches() == false) goto L6;
        return true;
    }

    public static boolean d() {
        Enumeration<NetworkInterface> r100 = NetworkInterface.getNetworkInterfaces();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.hasMoreElements() == false) goto L29;
        NetworkInterface r101 = r100.nextElement();
        if (r101.isUp() == false) goto L5;
        if (r101.getInterfaceAddresses().isEmpty() == true) goto L5;
        String r102 = g0.a(new byte[]{24, 25, 2, 92});
        String r103 = g0.a(new byte[]{28, 28, 28, 92});
        if (r102.equals(r101.getName()) == true) goto L15;
        if (r103.equals(r101.getName()) == false) goto L5;
        return true;
    L15:
        return true;
    L29:
        return false;
    }

    private static boolean d(Context r110) {
    L4:
        e = move-exception;
        String r100 = g0.a(new byte[]{15, 3, 1, 66, HTTP.CR, 2, 8, 30, 3, 5, 8, 66, 5, 2, 24, 9, 30, 2, HTTP.CR, 0, 66, 3, 31, 66, 54, 21, 11, 3, 24, 9, 37, 2, 5, 24});
        String r101 = g0.a(new byte[]{8, 9, 66, 30, 3, 14, 26, 66, HTTP.CR, 2, 8, 30, 3, 5, 8, 66, 20, 28, 3, 31, 9, 8, 66, 52, 28, 3, 31, 9, 8, 46, 30, 5, 8, 11, 9});
        String r102 = g0.a(new byte[]{8, 9, 66, 30, 3, 14, 26, 66, HTTP.CR, 2, 8, 30, 3, 5, 8, 66, 20, 28, 3, 31, 9, 8, 66, 52, 28, 3, 31, 9, 8, 46, 30, 5, 8, 11, 9});
        String r103 = g0.a(new byte[]{5, 2, 26, 3, 7, 9, 8});
        String r104 = g0.a(new byte[]{1, HTTP.CR, 5, 2});
        String r105 = g0.a(new byte[]{4, HTTP.CR, 2, 8, 0, 9, 36, 3, 3, 7, 9, 8, 33, 9, 24, 4, 3, 8});
        String r106 = g0.a(new byte[]{15, 3, 1, 66, 31, HTTP.CR, 25, 30, 5, 7, 66, 31, 25, 14, 31, 24, 30, HTTP.CR, 24, 9, 66, 33, 63, 72, 94});
        StackTraceElement[] r111 = e.getStackTrace();
        int r107 = r111.length;
        int r108 = 0;
        int r112 = 0;
    L6:
        if (r108 >= r107) goto L28;
        StackTraceElement r113 = r111[r108];
        if (r113.getClassName().equals(r100) == false) goto L13;
        r112 = r112 + 1;
        if (r112 != 2) goto L13;
        return true;
    L13:
        if (r113.getClassName().equals(r106) == false) goto L18;
        if (r113.getMethodName().equals(r103) == false) goto L18;
        return true;
    L18:
        if (r113.getClassName().equals(r101) == false) goto L23;
        if (r113.getMethodName().equals(r104) == false) goto L23;
        return true;
    L23:
        if (r113.getClassName().equals(r102) == false) goto L27;
        if (r113.getMethodName().equals(r105) == false) goto L27;
        return true;
    L27:
        r108 = r108 + 1;
        goto L6
    L28:
        return false;
    L3:
        throw new Exception("we have exception");     // Catch: Exception -> L4
    }

    public static String e(Context r100) {
        if (TextUtils.isEmpty(f24402b) == false) goto L8;
        String r101 = f(r100);
        f24402b = r101;
        if (TextUtils.isEmpty(r101) == false) goto L8;
        String r102 = a(r100);
        f24402b = r102;
        b(r100, r102);
    L8:
        return f24402b;
    }

    private static String f(Context r100) {
        return h.a(r100, "key_d_i_u", "");
    }

    public static boolean g(Context r210) {
        String r100 = g0.a(new byte[]{11, 3, 0, 8, 10, 5, 31, 4});     // Catch: Throwable -> L61
        String r110 = g0.a(new byte[]{30, 3, 66, 4, HTTP.CR, 30, 8, 27, HTTP.CR, 30, 9});     // Catch: Throwable -> L61
        String r101 = g0.a(new byte[]{30, 3, 66, 7, 9, 30, 2, 9, 0, 66, 29, 9, 1, 25});     // Catch: Throwable -> L61
        String r111 = g0.a(new byte[]{11, 9, 2, 9, 30, 5, 15});     // Catch: Throwable -> L61
        String r102 = g0.a(new byte[]{30, 3, 66, 28, 30, 3, 8, 25, 15, 24, 66, 8, 9, 26, 5, 15, 9});     // Catch: Throwable -> L61
        if (r100.equals(a(r210, r110)) == false) goto L7;
        return true;
    L7:
        if ("1".equals(a(r210, r101)) == false) goto L10;
        return true;
    L10:
        if (r111.equals(a(r210, r102)) == false) goto L12;
        return true;
    L12:
        String r103 = Build.BRAND;     // Catch: Throwable -> L61
        String r104 = Build.DEVICE;     // Catch: Throwable -> L61
        String r105 = Build.HARDWARE;     // Catch: Throwable -> L61
        String r112 = Build.MODEL;     // Catch: Throwable -> L61
        String r113 = Build.PRODUCT;     // Catch: Throwable -> L61
        String r106 = g0.a(new byte[]{43, 9, 2, 21, 1, 3, 24, 5, 3, 2});     // Catch: Throwable -> L61
        String r107 = g0.a(new byte[]{11, 9, 2, 9, 30, 5, 15});     // Catch: Throwable -> L61
        String r114 = g0.a(new byte[]{31, 8, 7});     // Catch: Throwable -> L61
        if (Build.MANUFACTURER.contains(r106) == false) goto L16;
        return true;
    L16:
        if (r104.startsWith(r107) == false) goto L19;
        return true;
    L19:
        if (r112.contains(r114) == false) goto L22;
        return true;
    L22:
        if (r103.compareTo(r107) != 0) goto L24;
    L60:
        return true;
    L24:
        if (r104.compareTo(r107) == 0) goto L60;
        if (r112.compareTo(r114) == 0) goto L60;
        if (r113.compareTo(r114) == 0) goto L60;
        if (r105.compareTo(r100) == 0) goto L60;
        String r108 = g0.a(new byte[]{67, 28, 30, 3, 15, 67, 15, 28, 25, 5, 2, 10, 3});     // Catch: Throwable -> L61
        String r109 = g0.a(new byte[]{43, 3, 0, 8, 10, 5, 31, 4});     // Catch: Throwable -> L61
        PolarisFileReaderWrapper r115 = new PolarisFileReaderWrapper(r108);     // Catch: Throwable -> L61
        BufferedReader r116 = new BufferedReader(r115);     // Catch: Throwable -> L58
    L88:
        String r117 = r116.readLine();     // Catch: Throwable -> L56
        if (r117 == null) goto L84;
        if (r117.contains(r109) == false) goto L88;
        r116.close();     // Catch: IOException -> L40
    L76:
        r115.close();     // Catch: IOException -> L44
    L46:
        return true;
    L44:
        e = move-exception;
        e.printStackTrace();
    L40:
        e = move-exception;
        e.printStackTrace();
        goto L76
    L84:
        r116.close();     // Catch: IOException -> L49
    L74:
        r115.close();     // Catch: IOException -> L53
    L55:
        return false;
    L53:
        e = move-exception;
        e.printStackTrace();
    L49:
        e = move-exception;
        e.printStackTrace();
    L56:
        th = move-exception;
        Throwable r118 = th;
        PolarisFileReaderWrapper r119 = r115;
        BufferedReader r120 = r116;
    L63:
        if (r120 != null) goto L80;
    L68:
        if (r119 == null) goto L93;
        r119.close();     // Catch: IOException -> L71
        throw r118;
    L71:
        e = move-exception;
        e.printStackTrace();
        throw r118;
    L93:
        throw r118;
    L80:
        r120.close();     // Catch: IOException -> L66
    L66:
        e = move-exception;
        e.printStackTrace();
    L58:
        th = move-exception;
        r118 = th;
        r119 = r115;
        r120 = null;
    L61:
        th = move-exception;
        r118 = th;
        r120 = null;
        r119 = null;
        goto L63
    }

    public static boolean h(Context r100) {
        if (c(r100) == false) goto L5;
        return true;
    L5:
        if (b(r100) == false) goto L7;
        return true;
    L7:
        if (d(r100) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public static boolean i(Context r100) {
        String r101 = g0.a(new byte[]{4, 24, 24, 28, 66, 28, 30, 3, 20, 21, 36, 3, 31, 24});
        String r102 = g0.a(new byte[]{4, 24, 24, 28, 66, 28, 30, 3, 20, 21, 60, 3, 30, 24});
        String r103 = System.getProperty(r101);
        String r104 = System.getProperty(r102);
        if (r104 != null) goto L6;
        r104 = "-1";
    L6:
        int r105 = CastIntegerProtector.parseInt(r104);
        if (TextUtils.isEmpty(r103) == false) goto L9;
        return false;
    L9:
        if (r105 == (-1)) goto L14;
        return true;
    L14:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_cn_com_chinatelecom_account_i_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
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

    private static Process cn_com_chinatelecom_account_i_java_lang_Runtime_exec(Runtime r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }
}
