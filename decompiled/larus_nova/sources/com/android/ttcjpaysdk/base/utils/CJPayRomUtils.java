package com.android.ttcjpaysdk.base.utils;

import android.text.TextUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import el9.a;
import f06.b;
import f06.c;
import f06.d;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J%\u0010\u0015\u001a\u00020\u00162\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00190\u0018\"\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJPayRomUtils;", "", "()V", "KEY_VERSION_EMUI", "", "KEY_VERSION_GIONEE", "KEY_VERSION_LENOVO", "KEY_VERSION_MIUI", "KEY_VERSION_ONEPLUS", "KEY_VERSION_SMARTISAN", "KEY_VERSION_VIVO", "getProp", "name", "getPropByCmd", "getPropByReflect", "getSystemProperty", "key", "defaultValue", "isEMUI", "", "isMIUI", "safeClose", "", "params", "", "Ljava/io/Closeable;", "([Ljava/io/Closeable;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayRomUtils {
    public static final CJPayRomUtils INSTANCE = null;
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_GIONEE = "ro.gn.sv.version";
    private static final String KEY_VERSION_LENOVO = "ro.lenovo.lvp.version";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_ONEPLUS = "ro.rom.version";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";

    static {
        INSTANCE = new CJPayRomUtils();
    }

    private CJPayRomUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public final boolean isEMUI() {
        return !TextUtils.isEmpty(getSystemProperty("ro.build.version.emui", ""));
    }

    public final boolean isMIUI() {
        String r100 = getProp(KEY_VERSION_MIUI);
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        return !r101;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_android_ttcjpaysdk_base_utils_CJPayRomUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private final String getProp(String r100) {
        return getPropByReflect(r100);
    L4:
        th = move-exception;
        CJLogger.d("CJPayRomUtils-getProp", th.getMessage());
        return getPropByCmd(r100);
    }

    private final String getPropByCmd(String r100) {
        BufferedReader r101 = new BufferedReader(new InputStreamReader(com_android_ttcjpaysdk_base_utils_CJPayRomUtils_java_lang_Runtime_exec(Runtime.getRuntime(), "getprop " + r100).getInputStream()), 1024);     // Catch: Throwable -> L9
        String r102 = r101.readLine();     // Catch: Throwable -> L7
        r101.close();     // Catch: Throwable -> L7
        safeClose(new Closeable[]{r101});
        return r102;
    L7:
        th = th;
    L21:
        CJLogger.d("CJPayRomUtils-getPropByCmd", th.getMessage());     // Catch: Throwable -> L14
        safeClose(new Closeable[]{r101});
        return null;
    L14:
        th = move-exception;
        safeClose(new Closeable[]{r101});
        throw th;
    L9:
        th = th;
        r101 = null;
        goto L21
    }

    private final String getPropByReflect(String r100) {
        Method r101 = INVOKESTATIC_com_android_ttcjpaysdk_base_utils_CJPayRomUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class});
        Object r102 = null;
        if (r101 == null) goto L5;
        r102 = r101.invoke(null, new Object[]{r100});
    L5:
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.String");
        return (String) r102;
    }

    private final void safeClose(Closeable... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        Closeable r103 = r100[r102];
        if (r103 == null) goto L10;
        r103.close();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CJLogger.d("CJPayRomUtils-safeClose", th.getMessage());
    L10:
        r102 = r102 + 1;
        goto L3
    }

    private static Process com_android_ttcjpaysdk_base_utils_CJPayRomUtils_java_lang_Runtime_exec(Runtime r110, String r111) {
        c r100 = new c();
        Object[] r101 = {r111};
        b r112 = new b();
        d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }

    private final String getSystemProperty(String r100, String r101) {
        Class r102 = INVOKESTATIC_com_android_ttcjpaysdk_base_utils_CJPayRomUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L4
        Object r103 = r102.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r102, new Object[]{r100, r101});     // Catch: Exception -> L4
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L4
        return (String) r103;
    L4:
        e = move-exception;
        e.printStackTrace();
        return r101;
    }
}
