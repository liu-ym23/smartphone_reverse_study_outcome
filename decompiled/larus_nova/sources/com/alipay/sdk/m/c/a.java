package com.alipay.sdk.m.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25238a = "ro.build.version.emui";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f25239b = "hw_sc.build.platform.version";

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static boolean a() {
        String r100 = a(f25238a);
        String r101 = a("hw_sc.build.platform.version");
        if (TextUtils.isEmpty(r100) == true) goto L5;
        return true;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return false;
    L11:
        return true;
    }

    public a() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_alipay_sdk_m_c_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static com.alipay.sdk.m.b.b a(Context r100) {
        String r101 = Build.BRAND;
        com.alipay.sdk.m.d.a.b("Device", new Object[]{"Brand", r101});
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return null;
    L6:
        if (r101.equalsIgnoreCase(RomUtils.BRAND_HUAWEI) == true) goto L66;
        if (r101.equalsIgnoreCase(RomUtils.BRAND_HONOR) == true) goto L66;
        if (r101.equalsIgnoreCase("华为") == true) goto L66;
        if (r101.equalsIgnoreCase(DimLocationCheckUtil.XIAOMI) == true) goto L64;
        if (r101.equalsIgnoreCase("redmi") == true) goto L64;
        if (r101.equalsIgnoreCase("meitu") == true) goto L64;
        if (r101.equalsIgnoreCase("小米") == true) goto L64;
        if (r101.equalsIgnoreCase("blackshark") == true) goto L64;
        if (r101.equalsIgnoreCase(DimLocationCheckUtil.VIVO) == false) goto L28;
        return new h();
    L28:
        if (r101.equalsIgnoreCase(AppConstants.CHANNEL_OPPO) == true) goto L62;
        if (r101.equalsIgnoreCase("oneplus") == true) goto L62;
        if (r101.equalsIgnoreCase("realme") == true) goto L62;
        if (r101.equalsIgnoreCase("lenovo") == true) goto L60;
        if (r101.equalsIgnoreCase("zuk") == true) goto L60;
        if (r101.equalsIgnoreCase("nubia") == false) goto L44;
        return new e();
    L44:
        if (r101.equalsIgnoreCase(SmEditTextLeakOpt.SAMSUNG) == false) goto L48;
        return new g();
    L48:
        if (a() == false) goto L52;
        return new b();
    L52:
        if (r101.equalsIgnoreCase("meizu") == true) goto L58;
        if (r101.equalsIgnoreCase("mblu") == true) goto L58;
        return null;
    L58:
        return new d();
    L60:
        return new c();
    L62:
        return new f();
    L64:
        return new i();
    L66:
        return new b();
    }

    public static String a(String r100) {
    L6:
        return "";
    L4:
        return (String) INVOKESTATIC_com_alipay_sdk_m_c_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties").getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(null, new Object[]{r100});
    }
}
