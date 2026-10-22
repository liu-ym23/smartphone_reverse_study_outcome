package com.android.ttcjpaysdk.base.service.api;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayPerformanceService;
import com.android.ttcjpaysdk.base.service.ICJPayService;
import com.android.ttcjpaysdk.base.service.annotation.CJPayModuleEntryReport;
import com.android.ttcjpaysdk.base.service.annotation.constants.Constants;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class CJPayServiceAPI {

    public static class ProxyService implements InvocationHandler, ICJPayService {
        protected Object service;

        @Override // com.android.ttcjpaysdk.base.service.ICJPayService
        public String getPackageName() {
            return null;
        }

        public ProxyService(Object r100) {
            this.service = r100;
        }

        private boolean isNeedReportMethod(Object r100, Method r101) {
            if (r100 == null) goto L11;
            if (r101 == null) goto L11;
            Method r102 = r100.getClass().getDeclaredMethod(r101.getName(), r101.getParameterTypes());     // Catch: Exception -> L9
            r102.setAccessible(true);     // Catch: Exception -> L9
            if (((CJPayModuleEntryReport) r102.getAnnotation(CJPayModuleEntryReport.class)) == null) goto L11;
            return true;
        L9:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayServiceAPI#isNeedReportMethod", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayServiceAPI#isNeedReportMethod", e);
        L11:
            return false;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
            ICJPayPerformanceService r103 = (ICJPayPerformanceService) CJPayServiceManager.getInstance().getIService(ICJPayPerformanceService.class);
            if (r103 == null) goto L14;
            Object r104 = this.service;
            if (r104 == null) goto L14;
            if ((r104 instanceof ICJPayService) == false) goto L14;
            String r105 = ((ICJPayService) r104).getPackageName();
            if (TextUtils.isEmpty(r105) == true) goto L14;
            if (isNeedReportMethod(this.service, r101) == false) goto L14;
            r103.initModule(r105);
        L14:
            return r101.invoke(this.service, r102);
        }
    }

    public CJPayServiceAPI() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_android_ttcjpaysdk_base_service_api_CJPayServiceAPI_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static void init(Object r100) {
        Class r101 = INVOKESTATIC_com_android_ttcjpaysdk_base_service_api_CJPayServiceAPI_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.ttcjpaysdk.base.service.CJPayService$$Index");     // Catch: Exception -> L4
        r101.getDeclaredMethod("initService", new Class[]{Map.class}).invoke(r101, new Object[]{r100});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayServiceAPI#init", e);
        CJLogger.b("CJPayServiceAPI", e.getMessage());
    }

    public static Object getCJPayService(Map r100, Class r101) {
        Object r102 = r100.get(r101);
        if (r102 == null) goto L20;
        return r102;
    L20:
        Class r103 = INVOKESTATIC_com_android_ttcjpaysdk_base_service_api_CJPayServiceAPI_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.ttcjpaysdk.base.service." + r101.getSimpleName() + Constants.CJPAY_SERVICE_SUFFIX);     // Catch: Exception -> L17
        r103.getDeclaredMethod("initService", new Class[]{Map.class}).invoke(r103, new Object[]{r100});     // Catch: Exception -> L17
        Object r104 = r100.get(r101);
        if (r104 != null) goto L11;
        return null;
    L11:
        if (((ICJPayPerformanceService) CJPayServiceManager.getInstance().getIService(ICJPayPerformanceService.class)) != null) goto L13;
        return r104;
    L13:
        if ((r104 instanceof ICJPayPerformanceService) == true) goto L23;
        ICJPayService r105 = (ICJPayService) Proxy.newProxyInstance(r104.getClass().getClassLoader(), r104.getClass().getInterfaces(), new ProxyService(r104));
        r100.put(r101, r105);
        return r105;
    L23:
        return r104;
    L17:
        e = move-exception;
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayServiceAPI#getCJPayService", e);
        return null;
    }
}
