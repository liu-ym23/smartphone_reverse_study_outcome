package com.byted.cast.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.byted.cast.common.config.ConfigManager;
import com.byted.cast.common.sink.CastInfo;
import com.byted.cast.common.sink.ClientInfo;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import el9.a;
import java.io.BufferedReader;
import java.io.FileFilter;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class Utils {
    private static final FileFilter CPU_FILTER = null;
    private static final int DEVICEINFO_UNKNOWN = -1;
    public static final Pattern IPV4_PATTERN = null;
    private static final int LOCAL_LOW_MEMORY_THRESHOLD = 1024;
    private static final int LOCAL_LOW_SPEC_CPU_CORES_THRESHOLD = 2;
    private static final String PHONE_OPPO = "OPPO";
    private static final String TAG = null;
    private static String chromeCastId;
    public static final List<String> filterActionList = null;
    private static final boolean isAndroid6 = false;
    private static Method newStringFromBytesProxyByteCast;
    private static int sCPUCores;
    private static int sTotalMemory;

    public Utils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        TAG = "Utils";
        IPV4_PATTERN = PatternProtector.compile("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
        sTotalMemory = 0;
        sCPUCores = 0;
        if (Build.VERSION.SDK_INT != 23) goto L5;
        boolean r100 = true;
    L6:
        isAndroid6 = r100;
        if (r100 == true) goto L12;
    L9:
        filterActionList = Arrays.asList(new String[]{"GetPositionInfo", "GetTransportInfo", "GetMediaInfo"});
        CPU_FILTER = new AnonymousClass1();
        return;
    L12:
        Class r101 = INVOKESTATIC_com_byted_cast_common_Utils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("java.lang.StringFactory");     // Catch: Throwable -> L11
        Class<?> r102 = Integer.TYPE;     // Catch: Throwable -> L11
        Method r103 = r101.getDeclaredMethod("newStringFromBytes", new Class[]{byte[].class, r102, r102, Charset.class});     // Catch: Throwable -> L11
        newStringFromBytesProxyByteCast = r103;     // Catch: Throwable -> L11
        r103.setAccessible(true);     // Catch: Throwable -> L11
        goto L9
    L5:
        r100 = false;
        goto L6
    }

    public static int getNumberOfCPUCores() {
        int r100 = sCPUCores;
        if (r100 == 0) goto L5;
        return r100;
    L5:
        int r101 = -1;
        r101 = new PolarisFileWrapper("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;     // Catch: Throwable -> L8
    L9:
        if (r101 <= 0) goto L11;
        sCPUCores = r101;
    L11:
        return r101;
    }

    public static int getTotalMemory() {
        int r100 = sTotalMemory;
        if (r100 == 0) goto L5;
        return r100;
    L5:
        int r101 = 0;
        BufferedReader r102 = null;
        BufferedReader r103 = new BufferedReader(new PolarisFileReaderWrapper("/proc/meminfo"), 8);     // Catch: Throwable -> L17
        String r104 = r103.readLine();     // Catch: Throwable -> L15
        if (r104 == null) goto L11;
        int r105 = r104.indexOf(58);     // Catch: Throwable -> L15
        int r106 = r105 + 1;     // Catch: Throwable -> L15
        r101 = (int) (((long) Integer.parseInt(r104.substring(r106, r104.indexOf(107)).trim())) / 1024);
    L11:
        r103.close();     // Catch: Throwable -> L13
    L38:
    L21:
        sTotalMemory = r101;
        return r101;
    L15:
        th = th;
        r102 = r103;
    L30:
        th.printStackTrace();     // Catch: Throwable -> L23
        if (r102 == null) goto L21;
        r102.close();     // Catch: Throwable -> L13
    L23:
        th = move-exception;
        if (r102 != null) goto L36;
    L29:
        throw th;
    L36:
        r102.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
    L17:
        th = th;
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L21
    }

    public static boolean isOppo6() {
        if (Build.VERSION.SDK_INT == 23) goto L11;
        return false;
    L11:
        String r100 = Build.BRAND;     // Catch: Exception -> L10
        boolean r101 = r100.equals("OPPO");     // Catch: Exception -> L10
        String r102 = TAG;     // Catch: Exception -> L10
        Logger.i(r102, "is oppo 6:" + r101 + ",brand:" + r100);     // Catch: Exception -> L10
        if (r101 == false) goto L8;
        return r101;
    L8:
        String r103 = Build.MANUFACTURER;     // Catch: Exception -> L10
        boolean r104 = "OPPO".equals(r103);     // Catch: Exception -> L10
        Logger.i(r102, "is oppo 6:" + r104 + ",manufacture:" + r103);     // Catch: Exception -> L10
        return r104;
    L10:
        return false;
    }

    public static String generateCastDid() {
        String r100 = new DecimalFormat("0000000000000000").format(ThreadLocalRandom.current().nextLong(1000000000000000L, 10000000000000000L));
        if (r100.startsWith("0") == true) goto L5;
        return r100;
    L5:
        return (new Random().nextInt(9) + 1) + r100.substring(1);
    }

    public static boolean isLowSpecDevice() {
        if (getTotalMemory() > 1024) goto L5;
        boolean r100 = true;
    L7:
        if (getNumberOfCPUCores() > 2) goto L9;
        boolean r101 = true;
    L11:
        if (Build.VERSION.SDK_INT >= 23) goto L13;
        boolean r102 = true;
    L15:
        if (r100 == true) goto L21;
        if (r101 == true) goto L22;
        if (r102 == true) goto L23;
        return false;
    L23:
        return true;
    L22:
        return true;
    L21:
        return true;
    L13:
        r102 = false;
        goto L15
    L9:
        r101 = false;
        goto L11
    L5:
        r100 = false;
        goto L7
    }

    public static String getChromeCastId() {
        return chromeCastId;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_byted_cast_common_Utils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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

    public static int changeToSeconds(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L32;
        return 0;
    L32:
    L29:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return 0;
    L8:
        String[] r101 = r100.split(":");     // Catch: NumberFormatException -> L29
        int r102 = r101.length;     // Catch: NumberFormatException -> L29
        String r103 = CustomAlbumViewModel.DEFAULT_TAB_ID;
        if (r102 <= 0) goto L12;
        String r104 = r101[0];     // Catch: NumberFormatException -> L29
    L13:
        int r105 = CastIntegerProtector.valueOf(r104).intValue();     // Catch: NumberFormatException -> L29
        if (r101.length <= 1) goto L16;
        String r106 = r101[1];     // Catch: NumberFormatException -> L29
    L18:
        if (r106.startsWith("0") == false) goto L20;
        int r107 = CastIntegerProtector.valueOf(r106.substring(1)).intValue();     // Catch: NumberFormatException -> L29
    L22:
        if (r101.length <= 2) goto L25;
        r103 = r101[2];     // Catch: NumberFormatException -> L29
    L25:
        if (r103.startsWith("0") == false) goto L27;
        int r108 = CastIntegerProtector.valueOf(r103.substring(1)).intValue();     // Catch: NumberFormatException -> L29
    L33:
        return ((r105 * AnnouncementViewModel.HOUR_DURATION) + (r107 * 60)) + r108;
    L27:
        r108 = CastIntegerProtector.valueOf(r103).intValue();     // Catch: NumberFormatException -> L29
        goto L33
    L20:
        r107 = CastIntegerProtector.valueOf(r106).intValue();     // Catch: NumberFormatException -> L29
        goto L22
    L16:
        r106 = CustomAlbumViewModel.DEFAULT_TAB_ID;
        goto L18
    L12:
        r104 = CustomAlbumViewModel.DEFAULT_TAB_ID;
        goto L13
    }

    public static String changeToTime(long r110) {
        long r111 = r110 / 1000;
        long r100 = r111 / com.ttnet.org.chromium.base.TimeUtils.SECONDS_PER_HOUR;     // Catch: Exception -> L15
        String r101 = r100 + ":";     // Catch: Exception -> L15
        Long.signum(r100);
        long r112 = r111 - (r100 * com.ttnet.org.chromium.base.TimeUtils.SECONDS_PER_HOUR);
        long r102 = r112 / 60;     // Catch: Exception -> L15
        if (r102 >= 10) goto L9;
        String r103 = r101 + "0" + r102 + ":";     // Catch: Exception -> L15
    L10:
        String r104 = r103;
        long r113 = r112 - (r102 * 60);     // Catch: Exception -> L15
        if (r113 >= 10) goto L20;
        return r104 + "0" + r113;
    L20:
        return r104 + r113;
    L9:
        r103 = r101 + r102 + ":";     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static long changeToTimestamp(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L33;
        return 0;
    L33:
        String[] r111 = r110.split(":");     // Catch: NumberFormatException -> L30
        int r100 = r111.length;     // Catch: NumberFormatException -> L30
        String r101 = CustomAlbumViewModel.DEFAULT_TAB_ID;
        if (r100 <= 0) goto L9;
        String r102 = r111[0];     // Catch: NumberFormatException -> L30
    L10:
        int r103 = CastIntegerProtector.valueOf(r102).intValue();     // Catch: NumberFormatException -> L30
        if (r111.length <= 1) goto L13;
        String r104 = r111[1];     // Catch: NumberFormatException -> L30
    L15:
        if (r104.startsWith("0") == false) goto L17;
        int r105 = CastIntegerProtector.valueOf(r104.substring(1)).intValue();     // Catch: NumberFormatException -> L30
    L19:
        if (r111.length <= 2) goto L26;
        String r106 = r111[2];     // Catch: NumberFormatException -> L30
        if (r106 == null) goto L26;
        if (r106.length() < 2) goto L26;
        r101 = r111[2].substring(0, 2);     // Catch: NumberFormatException -> L30
    L26:
        if (r101.startsWith("0") == false) goto L28;
        int r112 = CastIntegerProtector.valueOf(r101.substring(1)).intValue();     // Catch: NumberFormatException -> L30
    L34:
        return (((r103 * AnnouncementViewModel.HOUR_DURATION) + (r105 * 60)) + r112) * 1000;
    L28:
        r112 = CastIntegerProtector.valueOf(r101).intValue();     // Catch: NumberFormatException -> L30
        goto L34
    L17:
        r105 = CastIntegerProtector.valueOf(r104).intValue();     // Catch: NumberFormatException -> L30
        goto L19
    L13:
        r104 = CustomAlbumViewModel.DEFAULT_TAB_ID;
        goto L15
    L9:
        r102 = CustomAlbumViewModel.DEFAULT_TAB_ID;
    L30:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static CastInfo conversionCastInfo(CastInfo r100) {
        CastInfo r101 = new CastInfo();
        if (r100 == null) goto L16;
        r101.sourceDeviceType = r100.sourceDeviceType;
        r101.protocol = r100.protocol;
        r101.mediaArtist = r100.mediaArtist;
        r101.mediaAlbumUrl = r100.mediaAlbumUrl;
        r101.mediaAlbum = r100.mediaAlbum;
        r101.key = r100.key;
        r101.handleInside = r100.handleInside;
        r101.clientID = r100.clientID;
        r101.connectID = r100.connectID;
        r101.castType = r100.castType;
        r101.infoType = r100.infoType;
        r101.aesKey = r100.aesKey;
        r101.aesIV = r100.aesIV;
        r101.url = r100.url;
        r101.mediaTitle = r100.mediaTitle;
        r101.mimeType = r100.mimeType;
        if (r100.startInfo == null) goto L8;
        CastInfo.StartInfo r102 = new CastInfo.StartInfo();
        CastInfo.StartInfo r103 = r100.startInfo;
        r102.width = r103.width;
        r102.type = r103.type;
        r102.height = r103.height;
        r102.frameRate = r103.frameRate;
        r102.bitRate = r103.bitRate;
        r101.startInfo = r102;
    L8:
        if (r100.stopInfo == null) goto L11;
        CastInfo.StopInfo r104 = new CastInfo.StopInfo();
        CastInfo.StopInfo r105 = r100.stopInfo;
        r104.stopReason = r105.stopReason;
        r104.stopDetail = r105.stopDetail;
        r101.stopInfo = r104;
    L11:
        if (r100.sizeInfo == null) goto L13;
        CastInfo.SizeInfo r106 = new CastInfo.SizeInfo();
        CastInfo.SizeInfo r107 = r100.sizeInfo;
        r106.width = r107.width;
        r106.height = r107.height;
        r101.sizeInfo = r106;
    L13:
        ClientInfo r108 = r100.clientInfo;
        if (r108 == null) goto L16;
        r101.clientInfo = r108;
    L16:
        return r101;
    }

    public static int conversionIpToInt(String r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
        return 0;
    L5:
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r102.length == 4) goto L18;
        return 0;
    L18:
        int r103 = r102.length;     // Catch: NumberFormatException -> L15
        int r104 = 0;
    L10:
        if (r101 >= r103) goto L23;
        r104 = r104 << 8;     // Catch: NumberFormatException -> L13
        r104 = r104 ^ CastIntegerProtector.parseInt(r102[r101]);
        r101 = r101 + 1;
    L13:
        e = e;
        r101 = r104;
    L16:
        Logger.e(TAG, e.getMessage());
        return r101;
    L23:
        return r104;
    L15:
        e = e;
        goto L16
    }

    public static Boolean enableCallBackDIAL(ContextManager.CastContext r100) {
        String r101 = ContextManager.getConfigManager(r100).getInitConfig().getLocalProtocols();
        if (TextUtils.isEmpty(r101) == true) goto L6;
        r101.contains("DIAL");
    L6:
        return Boolean.FALSE;
    }

    public static String getAppName(Context r100) {
        PackageManager r101 = r100.getPackageManager();
        return r101.getApplicationLabel(r101.getApplicationInfo(r100.getPackageName(), 0)).toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        return "Unknown";
    }

    public static String getAppVersionName(Context r100) {
        PackageManager r101 = r100.getPackageManager();
        return r101.getPackageInfo(r100.getPackageName(), 0).versionName;
    L5:
        e = move-exception;
        e.printStackTrace();
        return "Unknown";
    }

    public static boolean isSupportPlayList(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        String[] r101 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
    L37:
        return false;
    L7:
        if (r101.length <= 0) goto L12;
        if (CastIntegerProtector.parseInt(r101[0]) <= 2) goto L12;
        return true;
    L12:
        if (r101.length <= 0) goto L17;
        if (CastIntegerProtector.parseInt(r101[0]) >= 2) goto L17;
        return false;
    L17:
        if (r101.length <= 1) goto L22;
        if (CastIntegerProtector.parseInt(r101[1]) <= 1) goto L22;
        return true;
    L22:
        if (r101.length <= 1) goto L27;
        if (CastIntegerProtector.parseInt(r101[1]) >= 1) goto L27;
        return false;
    L27:
        if (r101.length <= 2) goto L32;
        if (CastIntegerProtector.parseInt(r101[2]) <= 9) goto L32;
        return true;
    L32:
        if (r101.length <= 2) goto L36;
        if (CastIntegerProtector.parseInt(r101[2]) >= 9) goto L36;
        return false;
    L36:
        return true;
    }

    public static void setChromeCastId(String r100) {
        chromeCastId = r100;
    }

    public static boolean shouldTrackAction(String r100) {
        return !filterActionList.contains(r100);
    }

    public static String tryGetDidFromAppLog(ContextManager.CastContext r100) {
        return ContextManager.getAppLogWrapper(r100).getDid();
    }

    public static int compareVersion(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L11;
        if (ConfigManager.getInstance().getInitConfig().isEnableDebug() == true) goto L9;
        Logger.e(TAG, "current version empty");
        return -1;
    L9:
        throw new IllegalArgumentException("current version empty");
    L11:
        if (TextUtils.isEmpty(r101) == false) goto L19;
        if (ConfigManager.getInstance().getInitConfig().isEnableDebug() == true) goto L17;
        Logger.e(TAG, "target version empty");
        return 1;
    L17:
        throw new IllegalArgumentException("target version empty");
    L19:
        if (TextUtils.equals(r100, r101) == false) goto L21;
    L47:
        return 0;
    L21:
        if (TextUtils.equals(r100.replaceAll("[^0-9.]", ""), r101.replaceAll("[^0-9.]", "")) == true) goto L47;
        String[] r102 = r100.replaceAll("[^0-9.]", "").split("[.]");     // Catch: Exception -> L45
        String[] r103 = r101.replaceAll("[^0-9.]", "").split("[.]");     // Catch: Exception -> L45
        int r104 = Math.min(r102.length, r103.length);     // Catch: Exception -> L45
        int r105 = 0;
    L24:
        if (r105 >= r104) goto L33;
        if (CastIntegerProtector.parseInt(r102[r105]) < CastIntegerProtector.parseInt(r103[r105])) goto L27;
        if (CastIntegerProtector.parseInt(r102[r105]) > CastIntegerProtector.parseInt(r103[r105])) goto L30;
        r105 = r105 + 1;     // Catch: Exception -> L45
        goto L24
    L30:
        return 1;
    L27:
        return -1;
    L33:
        if (r102.length >= r103.length) goto L40;
        if (CastIntegerProtector.parseInt(r103[r103.length - 1]) > 0) goto L52;
        return 1;
    L52:
        return -1;
    L40:
        if (r102.length <= r103.length) goto L47;
        if (CastIntegerProtector.parseInt(r102[r102.length - 1]) <= 0) goto L53;
        return 1;
    L53:
        return -1;
    L45:
        e = move-exception;
        Logger.e(e.toString());
        goto L47
    }

    public static String getConnectionIP(String r100, ContextManager.CastContext r101) {
        List<String> r102 = NetworkUtil.getLocalIpAddr(r101);
        String r103 = "";
        if (r102 != null) goto L5;
    L13:
        return r103;
    L5:
        if (r102.size() == 0) goto L13;
        int r104 = conversionIpToInt(r100);
        Iterator<String> r105 = r102.iterator();
        int r106 = Integer.MAX_VALUE;
    L9:
        if (r105.hasNext() == false) goto L13;
        String r107 = r105.next();
        int r108 = Math.abs(conversionIpToInt(r107) ^ r104);
        if (r108 >= r106) goto L9;
        r103 = r107;
        r106 = r108;
        goto L9
    }

    public static String getProperty(String r100, String r101) {
        String r102 = (String) ReflectMethods.invokeStaticMethod("android.os.SystemProperties", MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}, new Object[]{r100, r101});
        Logger.i(TAG, "getProp, version is: " + Build.VERSION.SDK_INT + " platform: " + r102);
        return r102;
    }

    public static String newString(byte[] r100, int r101, int r102) {
        if (isAndroid6 == false) goto L7;
        return newString(r100, r101, r102, Charset.defaultCharset());
    L7:
        return new String(r100, r101, r102);
    }

    public static String newString(byte[] r100, int r101, int r102, Charset r103) {
        if (isAndroid6 == false) goto L10;
        Method r104 = newStringFromBytesProxyByteCast;
        if (r104 == null) goto L10;
        return (String) r104.invoke(null, new Object[]{r100, Integer.valueOf(r101), Integer.valueOf(r102), r103});
    L10:
        return new String(r100, r101, r102, r103);
    }
}
