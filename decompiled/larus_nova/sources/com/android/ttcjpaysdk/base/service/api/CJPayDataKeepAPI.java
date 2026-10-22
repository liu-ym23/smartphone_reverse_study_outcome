package com.android.ttcjpaysdk.base.service.api;

import com.android.ttcjpaysdk.base.service.annotation.constants.Constants;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayDataKeepAPI {
    public CJPayDataKeepAPI() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_android_ttcjpaysdk_base_service_api_CJPayDataKeepAPI_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static void autoWiredData(Object r110, Object r111) {
        Class r100 = INVOKESTATIC_com_android_ttcjpaysdk_base_service_api_CJPayDataKeepAPI_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.ttcjpaysdk.base.service." + r111.getClass().getSimpleName() + Constants.CJPAY_DATA_SUFFIX);     // Catch: Exception -> L5
        r100.getDeclaredMethod("autoWiredData", new Class[]{Object.class, Object.class}).invoke(r100, new Object[]{r110, r111});     // Catch: Exception -> L5
    L14:
        Class r101 = INVOKESTATIC_com_android_ttcjpaysdk_base_service_api_CJPayDataKeepAPI_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.ttcjpaysdk.base.service." + r111.getClass().getSuperclass().getSimpleName() + Constants.CJPAY_DATA_SUFFIX);     // Catch: Exception -> L9
        r101.getDeclaredMethod("autoWiredData", new Class[]{Object.class, Object.class}).invoke(r101, new Object[]{r110, r111});     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayDataKeepAPI#autoWiredData", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayDataKeepAPI#autoWiredData", e);
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayDataKeepAPI#autoWiredData", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayDataKeepAPI#autoWiredData", e);
        goto L14
    }

    public static void restoreData(Object r110, Object r111) {
        Class r100 = INVOKESTATIC_com_android_ttcjpaysdk_base_service_api_CJPayDataKeepAPI_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.ttcjpaysdk.base.service." + r111.getClass().getSimpleName() + Constants.CJPAY_DATA_SUFFIX);     // Catch: Exception -> L5
        r100.getDeclaredMethod("restoreData", new Class[]{Object.class, Object.class}).invoke(r100, new Object[]{r110, r111});     // Catch: Exception -> L5
    L14:
        Class r101 = INVOKESTATIC_com_android_ttcjpaysdk_base_service_api_CJPayDataKeepAPI_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.ttcjpaysdk.base.service." + r111.getClass().getSuperclass().getSimpleName() + Constants.CJPAY_DATA_SUFFIX);     // Catch: Exception -> L9
        r101.getDeclaredMethod("restoreData", new Class[]{Object.class, Object.class}).invoke(r101, new Object[]{r110, r111});     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayDataKeepAPI#restoreData", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayDataKeepAPI#restoreData", e);
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayDataKeepAPI#restoreData", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayDataKeepAPI#restoreData", e);
        goto L14
    }

    public static void saveData(Object r100, Object r110) {
        Class r101 = INVOKESTATIC_com_android_ttcjpaysdk_base_service_api_CJPayDataKeepAPI_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.ttcjpaysdk.base.service." + r110.getClass().getSimpleName() + Constants.CJPAY_DATA_SUFFIX);     // Catch: Exception -> L6
        r101.getDeclaredMethod("saveData", new Class[]{Object.class, Object.class}).invoke(r101, new Object[]{r100, r110});     // Catch: Exception -> L6
    L10:
        Class r102 = INVOKESTATIC_com_android_ttcjpaysdk_base_service_api_CJPayDataKeepAPI_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.ttcjpaysdk.base.service." + r110.getClass().getSuperclass().getSimpleName() + Constants.CJPAY_DATA_SUFFIX);     // Catch: Exception -> L7
        r102.getDeclaredMethod("saveData", new Class[]{Object.class, Object.class}).invoke(r102, new Object[]{r100, r110});     // Catch: Exception -> L7
        return;
    }
}
