package android.ss.com.vboost.utils;

import android.os.Build;
import android.ss.com.vboost.e;
import android.ss.com.vboost.f;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public class RomUtils {
    private static final String TAG = "RomUtils";

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4774a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f4775b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f4776c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f4777d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f4778e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f4779f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f4780g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ a[] f4781h = null;

        static {
            a r100 = new a("UNKNOWN", 0, "unknown", 0);
            f4774a = r100;
            a r101 = new a("SS", 1, "ss", 1);
            f4775b = r101;
            a r102 = new a("CHRY", 2, "chry", 2);
            f4776c = r102;
            a r103 = new a("XM", 3, "xm", 3);
            f4777d = r103;
            a r104 = new a("OP", 4, "op", 4);
            f4778e = r104;
            a r105 = new a("VO", 5, "vo", 5);
            f4779f = r105;
            a r110 = new a("MZ", 6, "mz", 6);
            f4780g = r110;
            f4781h = new a[]{r100, r101, r102, r103, r104, r105, r110};
        }

        private a(String r100, int r101, String r102, int r103) {
            super(r100, r101);
        }

        public static a valueOf(String r100) {
            return (a) r27.a.a(a.class, r100);
        }

        public static a[] values() {
            return (a[]) f4781h.clone();
        }
    }

    public RomUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static a getRomType() {
        if (isSsRom() == false) goto L7;
        return a.f4775b;
    L7:
        if (isCHRYRom() == false) goto L11;
        return a.f4776c;
    L11:
        if (isXmRom() == false) goto L15;
        return a.f4777d;
    L15:
        if (isOpRom() == false) goto L19;
        return a.f4778e;
    L19:
        if (isVoRom() == false) goto L23;
        return a.f4779f;
    L23:
        return a.f4774a;
    }

    public static String getSystemProperty(String r100) {
        Class r101 = INVOKESTATIC_android_ss_com_vboost_utils_RomUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L6
        return (String) r101.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r101, new Object[]{r100});
    L6:
        LogUtil.error(TAG, "Failed to read system property " + r100);
        return null;
    }

    public static boolean isCHRYRom() {
        return android.ss.com.vboost.a.a();
    }

    public static boolean isOpRom() {
        return android.ss.com.vboost.c.a();
    }

    public static boolean isSsRom() {
        String r100 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (r100.contains(SmEditTextLeakOpt.SAMSUNG) == false) goto L7;
        return true;
    }

    public static boolean isVoRom() {
        return e.a();
    }

    public static boolean isXmRom() {
        return f.a();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_android_ss_com_vboost_utils_RomUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
}
