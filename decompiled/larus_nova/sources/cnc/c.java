package cnc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.common.applog.AppLog;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.videoarch.liveplayer.VeLivePlayerDef$VeLivePlayerFormat;
import com.ss.videoarch.liveplayer.VeLivePlayerDef$VeLivePlayerProtocol;
import com.ss.videoarch.liveplayer.VideoLiveManager;
import com.ss.videoarch.liveplayer.b0;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import jta.g;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24599a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f24600b = null;

        static {
            int[] r100 = new int[VeLivePlayerDef$VeLivePlayerProtocol.values().length];
            f24600b = r100;
            r100[VeLivePlayerDef$VeLivePlayerProtocol.VeLivePlayerProtocolTCP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            f24600b[VeLivePlayerDef$VeLivePlayerProtocol.VeLivePlayerProtocolQUIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L23:
            f24600b[VeLivePlayerDef$VeLivePlayerProtocol.VeLivePlayerProtocolTLS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L8:
            int[] r101 = new int[VeLivePlayerDef$VeLivePlayerFormat.values().length];
            f24599a = r101;
            r101[VeLivePlayerDef$VeLivePlayerFormat.VeLivePlayerFormatFLV.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L29:
            f24599a[VeLivePlayerDef$VeLivePlayerFormat.VeLivePlayerFormatHLS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L19:
            f24599a[VeLivePlayerDef$VeLivePlayerFormat.VeLivePlayerFormatRTM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
            return;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Boolean f24601a = null;

        private b() {
        }

        static {
            f24601a = Boolean.valueOf(c.supportedABIs().contains("arm64-v8a"));
        }
    }

    public c() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static double coerceIn(double r100, double r101, double r102) {
        if (r100 <= r102) goto L6;
        return r102;
    L6:
        if (r100 >= r101) goto L8;
        return r101;
    L8:
        return r100;
    }

    public static float convertFloatScaleType(int r100) {
        if (r100 != 0) goto L4;
    L21:
        return 2.0f;
    L4:
        if (r100 != 1) goto L6;
        return 1.5f;
    L6:
        if (r100 == 2) goto L21;
        if (r100 != 4) goto L10;
        return 1.1f;
    L10:
        if (r100 != 8) goto L12;
        return 1.2f;
    L12:
        if (r100 != 16) goto L14;
        return 1.3f;
    L14:
        if (r100 == 32) goto L16;
        return -1.0f;
    L16:
        return 1.4f;
    }

    public static int convertIntScaleType(float r100) {
        if (r100 != 1.5f) goto L7;
        return 1;
    L7:
        if (r100 != 2.0f) goto L11;
        return 2;
    L11:
        if (r100 != 1.1f) goto L15;
        return 4;
    L15:
        if (r100 != 1.2f) goto L19;
        return 8;
    L19:
        if (r100 != 1.3f) goto L23;
        return 16;
    L23:
        if (r100 != 1.4f) goto L26;
        return 32;
    L26:
        return -1;
    }

    public static boolean isSupportArm64() {
        return b.f24601a.booleanValue();
    }

    public static List<String> supportedABIs() {
        String[] r100 = Build.SUPPORTED_ABIS;
        if (r100 != null) goto L5;
    L8:
        String r101 = Build.CPU_ABI2;
        if (TextUtils.isEmpty(r101) == true) goto L13;
        return Collections.singletonList(r101);
    L13:
        return Collections.singletonList(Build.CPU_ABI);
    L5:
        if (r100.length <= 0) goto L8;
        return Arrays.asList(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_videoarch_liveplayer_utils_LiveUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static String convertFormatStr(VeLivePlayerDef$VeLivePlayerFormat r100) {
        int r101 = a.f24599a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "flv";
    L5:
        if (r101 != 2) goto L7;
        return TTVideoEngineInterface.FORMAT_TYPE_HLS;
    L7:
        if (r101 == 3) goto L10;
        return "none";
    L10:
        return "lls";
    }

    public static String convertProtocolStr(VeLivePlayerDef$VeLivePlayerProtocol r100) {
        int r101 = a.f24600b[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "tcp";
    L5:
        if (r101 != 2) goto L7;
        return "quic";
    L7:
        if (r101 == 3) goto L10;
        return "none";
    L10:
        return "tls";
    }

    public static String convertResolutionStr(b0 r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.f458807a;
    }

    public static String getActualStreamSuffix(String r100) {
        String r101 = "";
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        if (r100.contains("stream-") == false) goto L27;
        int r102 = r100.indexOf("stream-");
        if (r100.contains(".flv") == false) goto L11;
        int r103 = r100.indexOf(".flv");
    L17:
        if (r103 <= r102) goto L27;
        String r104 = r100.substring(r102 + 7, r103);
        if (TextUtils.isEmpty(r104) == true) goto L27;
        if (r104.contains("_") == false) goto L25;
        int r105 = r104.indexOf("_");
        if (r105 == (-1)) goto L27;
        r101 = r104.substring(r105 + 1);
        goto L27
    L25:
        r101 = PlayerResolution.SDKKEY.ORIGIN;
        goto L27
    L11:
        if (r100.contains("/index.m3u8") == false) goto L14;
        r103 = r100.indexOf("/index.m3u8");
        goto L17
    L14:
        if (r100.contains(".sdp") == false) goto L16;
        r103 = r100.indexOf(".sdp");
        goto L17
    L16:
        r103 = -1;
    L27:
        if (TextUtils.equals(r101, PlayerResolution.SDKKEY.ORIGIN) == true) goto L29;
        return r101;
    L29:
        if (r100.contains("only_audio=1") == false) goto L33;
        return "ao";
    L33:
        return r101;
    }

    public static int versionStringToInt(String r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
    L18:
        return 0;
    L5:
        if (r100.isEmpty() == true) goto L18;
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r102.length > 0) goto L10;
        return 0;
    L10:
        int r103 = 0;
    L12:
        if (r101 >= r102.length) goto L17;
        if (r101 != 0) goto L15;
        r103 = CastIntegerProtector.parseInt(r102[r101]);
    L16:
        r101 = r101 + 1;
        goto L12
    L15:
        int r104 = r103 * 100;
        r103 = r104 + CastIntegerProtector.parseInt(r102[r101]);
        goto L16
    L17:
        return r103;
    }

    public static boolean compareVersion(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L29;
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        String[] r103 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        int r104 = Math.min(r102.length, r103.length);
        int r105 = 0;
        int r106 = 0;
    L8:
        if (r105 >= r104) goto L15;
        r106 = r102[r105].length() - r103[r105].length();
        if (r106 != 0) goto L15;
        r106 = r102[r105].compareTo(r103[r105]);
        if (r106 != 0) goto L15;
        r105 = r105 + 1;
    L15:
        if (r106 == 0) goto L17;
        if (r106 <= 0) goto L28;
        return true;
    L28:
        return false;
    L17:
        if ((r102.length - r103.length) <= 0) goto L26;
        return true;
    L26:
        return false;
    L29:
        return false;
    }

    public static String generateSessionId(String r100, int r101) {
        if (r101 == 0) goto L20;
        if (r101 == 1) goto L20;
        String r102 = r100;
    L15:
        if (r101 != 2) goto L22;
        StringBuilder r103 = new StringBuilder();     // Catch: Exception -> L18
        r103.append(r100);     // Catch: Exception -> L18
        r103.append(".");     // Catch: Exception -> L18
        r103.append(VideoLiveManager.sAppSessionUUID);     // Catch: Exception -> L18
        r103.append(".");     // Catch: Exception -> L18
        r103.append(VideoLiveManager.sPlaySessionIndex.incrementAndGet());     // Catch: Exception -> L18
        r103.append(".");     // Catch: Exception -> L18
        boolean r104 = AppLog.L;     // Catch: Exception -> L18
        r103.append(g.c());     // Catch: Exception -> L18
        return r103.toString();
    L19:
        return r100 + "." + System.currentTimeMillis();
    L22:
        return r102;
    L20:
        if (TextUtils.isEmpty(r100) == false) goto L10;
        r100 = UUID.randomUUID().toString().replace("-", "").toLowerCase(Locale.getDefault());     // Catch: Exception -> L18
    L10:
        String r105 = r100 + "." + System.currentTimeMillis();     // Catch: Exception -> L18
        if (r101 != 1) goto L13;
        r102 = r105 + "." + UUID.randomUUID().toString().hashCode();     // Catch: Exception -> L18
        goto L15
    L13:
        r102 = r105;
        goto L15
    }

    public static void onNotReachHereStr(Context r100, String r101) {
        Class r102 = INVOKESTATIC_com_ss_videoarch_liveplayer_utils_LiveUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.android.ugc.aweme.legoImp.task.publishtest.PublishDrillUtilities");     // Catch: Throwable -> L13
        if (r102 != null) goto L7;
        com.ss.videoarch.liveplayer.log.c.w("onNotReachHereStr", "onNotReachHereStr class not found");     // Catch: Throwable -> L13
        return;
    L7:
        Method r103 = r102.getDeclaredMethod("drillForVpass", new Class[]{Context.class, String.class});     // Catch: Throwable -> L13
        if (r103 != null) goto L11;
        com.ss.videoarch.liveplayer.log.c.w("onNotReachHereStr", "onNotReachHereStr method not found");     // Catch: Throwable -> L13
        return;
    L11:
        r103.invoke(null, new Object[]{r100, r101});     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        com.ss.videoarch.liveplayer.log.c.w("onNotReachHereStr", "onNotReachHereStr ex=" + th);
    }

    public static long parseLong(String r100, long r101) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return r101;
    L10:
        return CastLongProtector.parseLong(r100);
    L7:
        e = move-exception;
        e.printStackTrace();
        return r101;
    }

    public static Object getParam(JSONObject r100, Object r101, String r102) {
        if (r100 != null) goto L4;
    L33:
        return r101;
    L4:
        if (r100.has(r102) == false) goto L33;
        if (r101 != null) goto L9;
        return r100.optString(r102, (String) r101);
    L9:
        if (r101.getClass() != String.class) goto L13;
        return r100.optString(r102, (String) r101);
    L13:
        if (r101.getClass() != Integer.class) goto L17;
        return Integer.valueOf(r100.optInt(r102, ((Integer) r101).intValue()));
    L17:
        if (r101.getClass() != Float.class) goto L21;
        return Float.valueOf(CastFloatProtector.parseFloat(r100.optString(r102)));
    L21:
        if (r101.getClass() != Long.class) goto L25;
        return Long.valueOf(r100.optLong(r102, ((Long) r101).longValue()));
    L25:
        if (r101.getClass() != Double.class) goto L29;
        return Double.valueOf(r100.optDouble(r102, ((Double) r101).doubleValue()));
    L29:
        if (r101.getClass() == Boolean.class) goto L31;
        com.ss.videoarch.liveplayer.log.c.d("LiveUtils", "Unknow type: " + r102);
        goto L33
    L31:
        return Boolean.valueOf(r100.optBoolean(r102, false));
    }
}
