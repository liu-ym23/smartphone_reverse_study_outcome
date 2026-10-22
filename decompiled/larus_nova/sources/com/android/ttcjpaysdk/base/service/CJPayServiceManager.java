package com.android.ttcjpaysdk.base.service;

import com.android.ttcjpaysdk.base.service.api.CJPayServiceAPI;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class CJPayServiceManager {
    private static CJPayServiceManager instance;
    private Map<Class, ICJPayService> mServices;
    private Map<Class, Class> mSpiMap;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static CJPayServiceManager getInstance() {
        if (instance != null) goto L15;
        monitor-enter(CJPayServiceManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new CJPayServiceManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CJPayServiceManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private CJPayServiceManager() {
        this.mServices = new HashMap();
        this.mSpiMap = new HashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_android_ttcjpaysdk_base_service_CJPayServiceManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private ICJPayService createService(String r100) {
        return (ICJPayService) INVOKESTATIC_com_android_ttcjpaysdk_base_service_CJPayServiceManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100).newInstance();
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayServiceManager#createService", e);
        return null;
    }

    public <T extends ICJPayService> T getIService(Class r100) {
        return (T) CJPayServiceAPI.getCJPayService(this.mServices, r100);
    }

    public <T extends ICJPayService> T getIServiceV2(Class r100) {
        Class r101 = this.mSpiMap.get(r100);
        if (r101 == null) goto L10;
        return (T) r101.newInstance();
    L6:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayServiceManager#registerService", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayServiceManager#registerService", e);
        return null;
    L10:
        return (T) CJPayServiceAPI.getCJPayService(this.mServices, r100);
    }

    public void registerService(Class r100, Class r101) {
        this.mSpiMap.put(r100, r101);
    }
}
