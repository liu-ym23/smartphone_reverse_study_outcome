package com.bytedance.android.service.manager;

import android.text.TextUtils;
import com.bytedance.android.service.manager.alive.monitor.AliveMonitorService;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.bytedance.android.service.manager.client.ai.IClientAiExternalService;
import com.bytedance.android.service.manager.depths.i18n.IDepthsI18nExternalService;
import com.bytedance.android.service.manager.instr.IInstrKaExternalService;
import com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService;
import com.bytedance.android.service.manager.pull.PullExternalService;
import com.bytedance.android.service.manager.push.PushExternalService;
import com.bytedance.android.service.manager.push.notification.IPushNotificationService;
import com.bytedance.android.service.manager.push.trace.PushTraceExternalService;
import com.bytedance.android.service.manager.redbadge.IRedBadgeExternalService;
import com.bytedance.android.service.manager.statistics.IPushStatisticsExternalService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class PushServiceManager {
    private static volatile AliveMonitorService mAliveMonitorService;
    private static volatile IAllianceService mIAllianceService;
    private static volatile IClientAiExternalService mIClientAiExternalService;
    private static volatile IDepthsI18nExternalService mIDepthsI18nExternalService;
    private static volatile IInstrKaExternalService mIInstrKaExternalService;
    private static volatile IPermissionBootExternalService mIPermissionBootExternalService;
    private static volatile IPushNotificationService mIPushNotificationService;
    private static volatile IPushStatisticsExternalService mIPushStatisticsExternalService;
    private static volatile IRedBadgeExternalService mIRedBadgeExternalService;
    private static volatile PullExternalService mPullExternalService;
    private static volatile PushExternalService mPushExternalService;
    private static volatile PushTraceExternalService mPushTraceExternalService;
    private static volatile PushServiceManager mServiceManagerInstance;
    private Map<String, String> classNameMap;
    private Map<String, Object> instanceManager;

    private PushServiceManager() {
        this.instanceManager = new HashMap();
        HashMap r100 = new HashMap();
        this.classNameMap = r100;
        r100.put("com.bytedance.android.service.manager.alliance.IAllianceService", "com.bytedance.alliance.core.AllianceServiceImpl");
        this.classNameMap.put("com.bytedance.android.service.manager.push.notification.IPushNotificationService", "com.bytedance.notification.PushNotificationService");
        this.classNameMap.put("com.bytedance.android.service.manager.depths.i18n.IDepthsI18nExternalService", "com.bytedance.android.push.depths.i18n.DepthsI18nExternalServiceProvider");
        this.classNameMap.put("com.bytedance.android.service.manager.statistics.IPushStatisticsExternalService", "com.bytedance.push.android.statistics.PushStatisticsServiceProvider");
        this.classNameMap.put("com.bytedance.android.service.manager.client.ai.IClientAiExternalService", "com.bytedance.push.android.PushClientAiServiceProvider");
        this.classNameMap.put("com.bytedance.android.service.manager.alive.monitor.AliveMonitorService", "com.ss.alive.monitor.AliveMonitorServiceProvider");
        this.classNameMap.put("com.bytedance.android.service.manager.redbadge.IRedBadgeExternalService", "com.ss.android.newmedia.redbadge.RedBadgeServiceProvider");
        this.classNameMap.put("com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService", "com.bytedance.android.push.permission.boot.PermissionBootServiceProvider");
        this.classNameMap.put("com.bytedance.android.service.manager.push.trace.PushTraceExternalService", "com.bytedance.push.trace.PushTraceServiceImpl");
        this.classNameMap.put("com.bytedance.android.service.manager.pull.PullExternalService", "com.ss.android.pull.PullServiceProvider");
        this.classNameMap.put("com.bytedance.android.service.manager.push.PushExternalService", "com.bytedance.push.PushServiceProvider");
        this.classNameMap.put("com.bytedance.android.service.manager.instr.IInstrKaExternalService", "com.bytedance.push.instr.ka.InstrKaExternalServiceProvider");
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static PushServiceManager get() {
        if (mServiceManagerInstance != null) goto L15;
        monitor-enter(PushServiceManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mServiceManagerInstance != null) goto L9;
        mServiceManagerInstance = new PushServiceManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PushServiceManager.class);     // Catch: Throwable -> L11
    L15:
        return mServiceManagerInstance;
    }

    public AliveMonitorService getAliveMonitorService() {
        if (mAliveMonitorService != null) goto L23;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (mAliveMonitorService != null) goto L17;
        Object r100 = getObjectInstance(this.classNameMap.get("com.bytedance.android.service.manager.alive.monitor.AliveMonitorService"));     // Catch: Throwable -> L19
        if (r100 == null) goto L10;
    L16:
        mAliveMonitorService = (AliveMonitorService) r100;     // Catch: Throwable -> L19
        goto L17
    L10:
        if (TextUtils.equals(this.classNameMap.get("com.bytedance.android.service.manager.alive.monitor.AliveMonitorService"), "com.bytedance.android.service.manager.alive.monitor.AliveMonitorServiceImplOfMock") == true) goto L12;
        r100 = getObjectInstance("com.bytedance.android.service.manager.alive.monitor.AliveMonitorServiceImplOfMock");     // Catch: Throwable -> L19
    L12:
        if (r100 != null) goto L16;
        throw new RuntimeException("impl class not found for com.bytedance.android.service.manager.alive.monitor.AliveMonitorService");     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
    L23:
        return mAliveMonitorService;
    }

    public IAllianceService getIAllianceService() {
        if (mIAllianceService != null) goto L23;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (mIAllianceService != null) goto L17;
        Object r100 = getObjectInstance(this.classNameMap.get("com.bytedance.android.service.manager.alliance.IAllianceService"));     // Catch: Throwable -> L19
        if (r100 == null) goto L10;
    L16:
        mIAllianceService = (IAllianceService) r100;     // Catch: Throwable -> L19
        goto L17
    L10:
        if (TextUtils.equals(this.classNameMap.get("com.bytedance.android.service.manager.alliance.IAllianceService"), "com.bytedance.android.service.manager.alliance.IAllianceServiceImplOfMock") == true) goto L12;
        r100 = getObjectInstance("com.bytedance.android.service.manager.alliance.IAllianceServiceImplOfMock");     // Catch: Throwable -> L19
    L12:
        if (r100 != null) goto L16;
        throw new RuntimeException("impl class not found for com.bytedance.android.service.manager.alliance.IAllianceService");     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
    L23:
        return mIAllianceService;
    }

    public IClientAiExternalService getIClientAiExternalService() {
        if (mIClientAiExternalService != null) goto L23;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (mIClientAiExternalService != null) goto L17;
        Object r100 = getObjectInstance(this.classNameMap.get("com.bytedance.android.service.manager.client.ai.IClientAiExternalService"));     // Catch: Throwable -> L19
        if (r100 == null) goto L10;
    L16:
        mIClientAiExternalService = (IClientAiExternalService) r100;     // Catch: Throwable -> L19
        goto L17
    L10:
        if (TextUtils.equals(this.classNameMap.get("com.bytedance.android.service.manager.client.ai.IClientAiExternalService"), "com.bytedance.android.service.manager.client.ai.IClientAiExternalServiceImplOfMock") == true) goto L12;
        r100 = getObjectInstance("com.bytedance.android.service.manager.client.ai.IClientAiExternalServiceImplOfMock");     // Catch: Throwable -> L19
    L12:
        if (r100 != null) goto L16;
        throw new RuntimeException("impl class not found for com.bytedance.android.service.manager.client.ai.IClientAiExternalService");     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
    L23:
        return mIClientAiExternalService;
    }

    public IDepthsI18nExternalService getIDepthsI18nExternalService() {
        if (mIDepthsI18nExternalService != null) goto L23;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (mIDepthsI18nExternalService != null) goto L17;
        Object r100 = getObjectInstance(this.classNameMap.get("com.bytedance.android.service.manager.depths.i18n.IDepthsI18nExternalService"));     // Catch: Throwable -> L19
        if (r100 == null) goto L10;
    L16:
        mIDepthsI18nExternalService = (IDepthsI18nExternalService) r100;     // Catch: Throwable -> L19
        goto L17
    L10:
        if (TextUtils.equals(this.classNameMap.get("com.bytedance.android.service.manager.depths.i18n.IDepthsI18nExternalService"), "com.bytedance.android.service.manager.depths.i18n.IDepthsI18nExternalServiceImplOfMock") == true) goto L12;
        r100 = getObjectInstance("com.bytedance.android.service.manager.depths.i18n.IDepthsI18nExternalServiceImplOfMock");     // Catch: Throwable -> L19
    L12:
        if (r100 != null) goto L16;
        throw new RuntimeException("impl class not found for com.bytedance.android.service.manager.depths.i18n.IDepthsI18nExternalService");     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
    L23:
        return mIDepthsI18nExternalService;
    }

    public IInstrKaExternalService getIInstrKaExternalService() {
        if (mIInstrKaExternalService != null) goto L23;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (mIInstrKaExternalService != null) goto L17;
        Object r100 = getObjectInstance(this.classNameMap.get("com.bytedance.android.service.manager.instr.IInstrKaExternalService"));     // Catch: Throwable -> L19
        if (r100 == null) goto L10;
    L16:
        mIInstrKaExternalService = (IInstrKaExternalService) r100;     // Catch: Throwable -> L19
        goto L17
    L10:
        if (TextUtils.equals(this.classNameMap.get("com.bytedance.android.service.manager.instr.IInstrKaExternalService"), "com.bytedance.android.service.manager.instr.IInstrKaExternalServiceImplOfMock") == true) goto L12;
        r100 = getObjectInstance("com.bytedance.android.service.manager.instr.IInstrKaExternalServiceImplOfMock");     // Catch: Throwable -> L19
    L12:
        if (r100 != null) goto L16;
        throw new RuntimeException("impl class not found for com.bytedance.android.service.manager.instr.IInstrKaExternalService");     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
    L23:
        return mIInstrKaExternalService;
    }

    public IPermissionBootExternalService getIPermissionBootExternalService() {
        if (mIPermissionBootExternalService != null) goto L23;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (mIPermissionBootExternalService != null) goto L17;
        Object r100 = getObjectInstance(this.classNameMap.get("com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService"));     // Catch: Throwable -> L19
        if (r100 == null) goto L10;
    L16:
        mIPermissionBootExternalService = (IPermissionBootExternalService) r100;     // Catch: Throwable -> L19
        goto L17
    L10:
        if (TextUtils.equals(this.classNameMap.get("com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService"), "com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalServiceImplOfMock") == true) goto L12;
        r100 = getObjectInstance("com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalServiceImplOfMock");     // Catch: Throwable -> L19
    L12:
        if (r100 != null) goto L16;
        throw new RuntimeException("impl class not found for com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService");     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
    L23:
        return mIPermissionBootExternalService;
    }

    public IPushNotificationService getIPushNotificationService() {
        if (mIPushNotificationService != null) goto L23;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (mIPushNotificationService != null) goto L17;
        Object r100 = getObjectInstance(this.classNameMap.get("com.bytedance.android.service.manager.push.notification.IPushNotificationService"));     // Catch: Throwable -> L19
        if (r100 == null) goto L10;
    L16:
        mIPushNotificationService = (IPushNotificationService) r100;     // Catch: Throwable -> L19
        goto L17
    L10:
        if (TextUtils.equals(this.classNameMap.get("com.bytedance.android.service.manager.push.notification.IPushNotificationService"), "com.bytedance.android.service.manager.push.notification.IPushNotificationServiceImplOfMock") == true) goto L12;
        r100 = getObjectInstance("com.bytedance.android.service.manager.push.notification.IPushNotificationServiceImplOfMock");     // Catch: Throwable -> L19
    L12:
        if (r100 != null) goto L16;
        throw new RuntimeException("impl class not found for com.bytedance.android.service.manager.push.notification.IPushNotificationService");     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
    L23:
        return mIPushNotificationService;
    }

    public IPushStatisticsExternalService getIPushStatisticsExternalService() {
        if (mIPushStatisticsExternalService != null) goto L23;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (mIPushStatisticsExternalService != null) goto L17;
        Object r100 = getObjectInstance(this.classNameMap.get("com.bytedance.android.service.manager.statistics.IPushStatisticsExternalService"));     // Catch: Throwable -> L19
        if (r100 == null) goto L10;
    L16:
        mIPushStatisticsExternalService = (IPushStatisticsExternalService) r100;     // Catch: Throwable -> L19
        goto L17
    L10:
        if (TextUtils.equals(this.classNameMap.get("com.bytedance.android.service.manager.statistics.IPushStatisticsExternalService"), "com.bytedance.android.service.manager.statistics.IPushStatisticsExternalServiceImplOfMock") == true) goto L12;
        r100 = getObjectInstance("com.bytedance.android.service.manager.statistics.IPushStatisticsExternalServiceImplOfMock");     // Catch: Throwable -> L19
    L12:
        if (r100 != null) goto L16;
        throw new RuntimeException("impl class not found for com.bytedance.android.service.manager.statistics.IPushStatisticsExternalService");     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
    L23:
        return mIPushStatisticsExternalService;
    }

    public IRedBadgeExternalService getIRedBadgeExternalService() {
        if (mIRedBadgeExternalService != null) goto L23;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (mIRedBadgeExternalService != null) goto L17;
        Object r100 = getObjectInstance(this.classNameMap.get("com.bytedance.android.service.manager.redbadge.IRedBadgeExternalService"));     // Catch: Throwable -> L19
        if (r100 == null) goto L10;
    L16:
        mIRedBadgeExternalService = (IRedBadgeExternalService) r100;     // Catch: Throwable -> L19
        goto L17
    L10:
        if (TextUtils.equals(this.classNameMap.get("com.bytedance.android.service.manager.redbadge.IRedBadgeExternalService"), "com.bytedance.android.service.manager.redbadge.IRedBadgeExternalServiceImplOfMock") == true) goto L12;
        r100 = getObjectInstance("com.bytedance.android.service.manager.redbadge.IRedBadgeExternalServiceImplOfMock");     // Catch: Throwable -> L19
    L12:
        if (r100 != null) goto L16;
        throw new RuntimeException("impl class not found for com.bytedance.android.service.manager.redbadge.IRedBadgeExternalService");     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
    L23:
        return mIRedBadgeExternalService;
    }

    public PullExternalService getPullExternalService() {
        if (mPullExternalService != null) goto L23;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (mPullExternalService != null) goto L17;
        Object r100 = getObjectInstance(this.classNameMap.get("com.bytedance.android.service.manager.pull.PullExternalService"));     // Catch: Throwable -> L19
        if (r100 == null) goto L10;
    L16:
        mPullExternalService = (PullExternalService) r100;     // Catch: Throwable -> L19
        goto L17
    L10:
        if (TextUtils.equals(this.classNameMap.get("com.bytedance.android.service.manager.pull.PullExternalService"), "com.bytedance.android.service.manager.pull.PullExternalServiceImplOfMock") == true) goto L12;
        r100 = getObjectInstance("com.bytedance.android.service.manager.pull.PullExternalServiceImplOfMock");     // Catch: Throwable -> L19
    L12:
        if (r100 != null) goto L16;
        throw new RuntimeException("impl class not found for com.bytedance.android.service.manager.pull.PullExternalService");     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
    L23:
        return mPullExternalService;
    }

    public PushExternalService getPushExternalService() {
        if (mPushExternalService != null) goto L23;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (mPushExternalService != null) goto L17;
        Object r100 = getObjectInstance(this.classNameMap.get("com.bytedance.android.service.manager.push.PushExternalService"));     // Catch: Throwable -> L19
        if (r100 == null) goto L10;
    L16:
        mPushExternalService = (PushExternalService) r100;     // Catch: Throwable -> L19
        goto L17
    L10:
        if (TextUtils.equals(this.classNameMap.get("com.bytedance.android.service.manager.push.PushExternalService"), "com.bytedance.android.service.manager.push.PushExternalServiceImplOfMock") == true) goto L12;
        r100 = getObjectInstance("com.bytedance.android.service.manager.push.PushExternalServiceImplOfMock");     // Catch: Throwable -> L19
    L12:
        if (r100 != null) goto L16;
        throw new RuntimeException("impl class not found for com.bytedance.android.service.manager.push.PushExternalService");     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
    L23:
        return mPushExternalService;
    }

    public PushTraceExternalService getPushTraceExternalService() {
        if (mPushTraceExternalService != null) goto L23;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (mPushTraceExternalService != null) goto L17;
        Object r100 = getObjectInstance(this.classNameMap.get("com.bytedance.android.service.manager.push.trace.PushTraceExternalService"));     // Catch: Throwable -> L19
        if (r100 == null) goto L10;
    L16:
        mPushTraceExternalService = (PushTraceExternalService) r100;     // Catch: Throwable -> L19
        goto L17
    L10:
        if (TextUtils.equals(this.classNameMap.get("com.bytedance.android.service.manager.push.trace.PushTraceExternalService"), "com.bytedance.android.service.manager.push.trace.PushTraceExternalServiceImplOfMock") == true) goto L12;
        r100 = getObjectInstance("com.bytedance.android.service.manager.push.trace.PushTraceExternalServiceImplOfMock");     // Catch: Throwable -> L19
    L12:
        if (r100 != null) goto L16;
        throw new RuntimeException("impl class not found for com.bytedance.android.service.manager.push.trace.PushTraceExternalService");     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
    L23:
        return mPushTraceExternalService;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_service_manager_PushServiceManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private Object getObjectInstance(String r100) {
        if (this.instanceManager.containsKey(r100) == true) goto L5;
        Object r101 = INVOKESTATIC_com_bytedance_android_service_manager_PushServiceManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100).newInstance();     // Catch: Throwable -> L8
        this.instanceManager.put(r100, r101);     // Catch: Throwable -> L8
        return r101;
    L8:
        th = move-exception;
        th.getMessage();
        return null;
    L5:
        return this.instanceManager.get(r100);
    }
}
