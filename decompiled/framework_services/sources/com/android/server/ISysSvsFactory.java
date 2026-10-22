package com.android.server;

import android.content.Context;
import android.os.DebugSmtEx;
import android.os.PowerAdvisorInternal;
import android.view.WindowManagerPolicyConstants;
import bytedanceos.util.IThermalInfo;
import com.android.server.am.ActivityManagerService;
import com.android.server.am.IActiveUidsOptEx;
import com.android.server.am.IActivityManagerServiceSysEx;
import com.android.server.am.IAddVrPrevious;
import com.android.server.am.IAnrMonitor;
import com.android.server.am.IAppRecordManagerService;
import com.android.server.am.IAppStartStatistics;
import com.android.server.am.IAppStartTrim;
import com.android.server.am.IApplicationFreezer;
import com.android.server.am.IBinderStat;
import com.android.server.am.IBootEventStat;
import com.android.server.am.IBroadcastChecker;
import com.android.server.am.IBroadcastProxy;
import com.android.server.am.IBytedanceBrainBridge;
import com.android.server.am.ICachedAppOptimizerOptEx;
import com.android.server.am.IColdStartTrim;
import com.android.server.am.ICollaborationManagerService;
import com.android.server.am.ICollect3rdInfo;
import com.android.server.am.IDefragManager;
import com.android.server.am.IFindSvpThreadHandler;
import com.android.server.am.IFreezeController;
import com.android.server.am.IFreezeStats;
import com.android.server.am.IGuardianManager;
import com.android.server.am.IHandleMemoryLeak;
import com.android.server.am.IIntelliScene;
import com.android.server.am.IIoLimiter;
import com.android.server.am.IKernelCachedKill;
import com.android.server.am.IKernelTrigger;
import com.android.server.am.IKillingStats;
import com.android.server.am.ILowMemDetectorOptEx;
import com.android.server.am.IMemInfoReaderOptEx;
import com.android.server.am.IMemoryProcessController;
import com.android.server.am.IMemoryReclaimer;
import com.android.server.am.IMpamHelper;
import com.android.server.am.IOAutoHelper;
import com.android.server.am.IOomAdjChecker;
import com.android.server.am.IOomAdjusterOptEx;
import com.android.server.am.IPauseTimeoutDataUpload;
import com.android.server.am.IPrimaryProfCollecter;
import com.android.server.am.IProcExtraInfoOpt;
import com.android.server.am.IProcLifeStats;
import com.android.server.am.IProcStatsSmt;
import com.android.server.am.IProcessGuard;
import com.android.server.am.IProcessGuardService;
import com.android.server.am.IProcessIntercept;
import com.android.server.am.IProcessListOptEx;
import com.android.server.am.IProcessStatusChecker;
import com.android.server.am.IResMngService;
import com.android.server.am.ISchedExtService;
import com.android.server.am.IServiceHolder;
import com.android.server.am.ISingle3DApp;
import com.android.server.am.ISkipDoFrameController;
import com.android.server.am.ISvpSenarioHandler;
import com.android.server.am.ISysPrefetchService;
import com.android.server.am.ITaskDeepClean;
import com.android.server.am.ITntProcessController;
import com.android.server.am.IUidCpuRunner;
import com.android.server.am.IUidMonitorSmt;
import com.android.server.am.IWarmStartPidCache;
import com.android.server.am.IXBTest;
import com.android.server.am.OomAdjuster;
import com.android.server.appop.IAppOpsServiceSysEx;
import com.android.server.art.IArtManagerLocalEx;
import com.android.server.audio.ISmtMediaMonitorService;
import com.android.server.display.IDynamicRefreshRateOpt;
import com.android.server.display.IDynamicRefreshRateService;
import com.android.server.freq.IFreqOptimize;
import com.android.server.input.IInputInfoTransService;
import com.android.server.inputmethod.IInputMethodManagerServiceOpt;
import com.android.server.location.IAppForegroundHelperOptEx;
import com.android.server.location.provider.ILocationProviderManagerOptEx;
import com.android.server.net.INetworkManagementServiceOptEx;
import com.android.server.net.INetworkPolicyManagerServiceOptEx;
import com.android.server.notification.INotificationManagerOptEx;
import com.android.server.notification.NotificationManagerService;
import com.android.server.perf.IPerfThermalMonitor;
import com.android.server.pm.IProfileDrivenDexoptManager;
import com.android.server.pm.ISparkDexoptManager;
import com.android.server.pm.PackageManagerService;
import com.android.server.power.IBytedancePowerAdvisor;
import com.android.server.power.IPowerManagerOptEx;
import com.android.server.power.ISmartPowerData;
import com.android.server.power.stats.BatteryStatsImpl;
import com.android.server.power.stats.IBatteryStatsImplSmtEx;
import com.android.server.resmng.IBoostFrameworkService;
import com.android.server.resmng.IBoostTouchUpController;
import com.android.server.resmng.IBoostTouchUpPolicy;
import com.android.server.resmng.IDecisionMaker;
import com.android.server.resmng.IIOFeatureConfig;
import com.android.server.resmng.IPerformanceSchedUtils;
import com.android.server.resmng.IResMngConfig;
import com.android.server.resmng.IReverseDropCacheFeatureConfig;
import com.android.server.svpcgroup.ISvpCgroupManager;
import com.android.server.wm.ActivityRecord;
import com.android.server.wm.IActivityRecordOptEx;
import com.android.server.wm.IActivityTaskManagerOptEx;
import com.android.server.wm.IWindowAnimatorOpt;
import com.android.server.wm.WindowAnimator;

/* JADX INFO: loaded from: classes.dex */
public interface ISysSvsFactory extends ISysMonitorSvcFactory {
    default IUidCpuRunner getUidCpuRunnerInstance() {
        return new AnonymousClass1(this);
    }

    default IUidMonitorSmt getUidMonitorSmt() {
        return new AnonymousClass2(this);
    }

    default void startBytedancePowerAdvisor(SystemServiceManager systemServiceManager) {
        LocalServices.addService(PowerAdvisorInternal.class, new AnonymousClass3(this));     // Catch: Throwable -> L4 Exception -> L6
    L4:
        th = move-exception;
        DebugSmtEx.printDefaultFunInfo(getClass());
        throw th;
    L3:
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default IProcessIntercept getProcessIntercept() {
        return new AnonymousClass4(this);
    }

    default IMemInfoReaderOptEx getMemInfoReaderOptEx() {
        return new AnonymousClass5(this);
    }

    default IBoostFrameworkService getBoostFrameworkService() {
        return new AnonymousClass6(this);
    }

    default IBoostTouchUpPolicy getBoostTouchUpPolicy() {
        return new AnonymousClass7(this);
    }

    default IBoostTouchUpController getBoostTouchUpController() {
        return new AnonymousClass8(this);
    }

    default IPerformanceSchedUtils getPerformanceSchedUtils() {
        return new AnonymousClass9(this);
    }

    default ISingle3DApp getSingle3DApp() {
        return new AnonymousClass10(this);
    }

    default IColdStartTrim getColdStartTrim() {
        return new AnonymousClass11(this);
    }

    default IAppStartTrim getAppStartTrim() {
        return new AnonymousClass12(this);
    }

    default IServiceHolder getServiceHolder() {
        return new AnonymousClass13(this);
    }

    default IKernelCachedKill getKernelCachedKill() {
        return new AnonymousClass14(this);
    }

    default IMpamHelper getMpamHelper() {
        return new AnonymousClass15(this);
    }

    default ITaskDeepClean getTaskDeepClean() {
        return new AnonymousClass16(this);
    }

    default IProcessGuard getProcessGuard() {
        return new AnonymousClass17(this);
    }

    default IProcessGuardService getProcessGuardService() {
        return new AnonymousClass18(this);
    }

    default IKernelTrigger getKernelTrigger() {
        return new AnonymousClass19(this);
    }

    default ICollaborationManagerService getCollaborationManagerService() {
        return new AnonymousClass20(this);
    }

    default IOAutoHelper getOAutoHelper() {
        return new AnonymousClass21(this);
    }

    default IAddVrPrevious getAddVrPrevious() {
        return new AnonymousClass22(this);
    }

    default IXBTest getXBTest() {
        return new AnonymousClass23(this);
    }

    default IIntelliScene getIntelliScene() {
        return new AnonymousClass24(this);
    }

    default IAppStartStatistics getAppStartStatistics() {
        return new AnonymousClass25(this);
    }

    default IProcStatsSmt getProcStatsSmt() {
        return new AnonymousClass26(this);
    }

    default IProcLifeStats getProcLifeStats() {
        return new AnonymousClass27(this);
    }

    default IAppRecordManagerService getAppRecordManagerService() {
        return new AnonymousClass28(this);
    }

    default void setActivityManagerService(ActivityManagerService activityManagerService) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    @Override // com.android.server.ISysMonitorSvcFactory
    default IActivityManagerOptEx getActivityManager(ActivityManagerService service) {
        return new AnonymousClass29(this);
    }

    @Override // com.android.server.ISysMonitorSvcFactory
    default ISmartPowerData getSmartPowerDataInstance() {
        return new AnonymousClass30(this);
    }

    default IBytedancePowerAdvisor getBytedancePowerAdvisorInstance() {
        return new AnonymousClass31(this);
    }

    default IMemoryReclaimer getMemoryReclaimer() {
        return new AnonymousClass32(this);
    }

    default ITntProcessController getTntProcessControllerInstance() {
        return new AnonymousClass33(this);
    }

    default ICollect3rdInfo getCollect3rdInfo() {
        return new AnonymousClass34(this);
    }

    default IBinderStat getBinderStat() {
        return new AnonymousClass35(this);
    }

    default IBootEventStat getBootEventStat() {
        return new AnonymousClass36(this);
    }

    @Override // com.android.server.ISysMonitorSvcFactory
    default ISmartMonitorController getSmartMonitorController() {
        return new AnonymousClass37(this);
    }

    @Override // com.android.server.ISysMonitorSvcFactory
    default ISmartService getSmartService() {
        return new AnonymousClass38(this);
    }

    default ISmtMediaMonitorService getSmtMediaMonitorService(Context context) {
        return new AnonymousClass39(this);
    }

    default IPauseTimeoutDataUpload getPauseTimeoutDataUpload() {
        return new AnonymousClass40(this);
    }

    default IApplicationFreezer getApplicationFreezer() {
        return new AnonymousClass41(this);
    }

    default IMemoryProcessController getMemoryProcessController() {
        return new AnonymousClass42(this);
    }

    default ILowMemDetectorOptEx getLowMemDetectorOptEx() {
        return new AnonymousClass43(this);
    }

    default IFreezeController getFreezeController() {
        return new AnonymousClass44(this);
    }

    default IPrimaryProfCollecter getPrimaryProfCollecter(PackageManagerService pm) {
        return new AnonymousClass45(this);
    }

    default IBytedanceBrainBridge getBytedanceBrainBridge(Context context) {
        return new AnonymousClass46(this);
    }

    default IFreezeStats createFreezeStats() {
        return new AnonymousClass47(this);
    }

    default IOomAdjChecker getOomAdjChecker() {
        return new AnonymousClass48(this);
    }

    default ISmartScenes getSmartScenes() {
        return new AnonymousClass49(this);
    }

    default IKillingStats getKillingStats() {
        return new AnonymousClass50(this);
    }

    default ISmtResourceControl getSmtResourceControl() {
        return new AnonymousClass51(this);
    }

    @Override // com.android.server.ISysMonitorSvcFactory
    default ISmartAnaly getSmtAnalysis() {
        return new AnonymousClass52(this);
    }

    default IPowerManagerOptEx getPowerManager() {
        return new AnonymousClass53(this);
    }

    default IBatteryStatsImplSmtEx.IUidSmtEx getBatteryStatsUidSmtEx(BatteryStatsImpl.Uid uid) {
        return new AnonymousClass54(this);
    }

    default IBatteryStatsImplSmtEx getBatteryStatsImplSmtEx(BatteryStatsImpl batteryStats) {
        return new AnonymousClass55(this);
    }

    default ILocationManagerOptEx getLocationManager() {
        return new AnonymousClass56(this);
    }

    default ILocationProviderManagerOptEx getLocationProvider() {
        return new AnonymousClass57(this);
    }

    default INotificationManagerOptEx getNotificationManager(NotificationManagerService service) {
        return new AnonymousClass58(this);
    }

    default IOomAdjusterOptEx getOomAdjusterOptEx(OomAdjuster oomAdjuster, ActivityManagerService ams) {
        return new AnonymousClass59(this);
    }

    default void notifyActivityPausedForTopSvp(int pid) {
    }

    default INetworkPolicyManagerServiceOptEx getPolicyServiceOptEx() {
        return new AnonymousClass60(this);
    }

    default INetworkManagementServiceOptEx getNetworkManagementServiceOptEx() {
        return new AnonymousClass61(this);
    }

    @Override // com.android.server.ISysMonitorSvcFactory
    default IBatteryServiceOptEx getBatteryServiceOptEx() {
        return new AnonymousClass62(this);
    }

    default WindowManagerPolicyConstants.PointerEventListener getScenesPointerEventListener() {
        return new AnonymousClass63(this);
    }

    default IAppForegroundHelperOptEx getAppForegroundHelperOptEx() {
        return new AnonymousClass64(this);
    }

    @Override // com.android.server.ISysMonitorSvcFactory
    default IAnrMonitor getAnrMonitor() {
        return new AnonymousClass65(this);
    }

    @Override // com.android.server.ISysMonitorSvcFactory
    default ISysMonitorService getSysMonitorService() {
        return new AnonymousClass66(this);
    }

    default IProcessListOptEx getProcessListOptEx() {
        return null;
    }

    default IActiveUidsOptEx getActiveUidsOptEx() {
        return null;
    }

    default IGameBalanceService getGameBalanceService() {
        return new AnonymousClass67(this);
    }

    default ISysPrefetchService getSysPrefetchService() {
        return new AnonymousClass68(this);
    }

    default IMemoryUtils getMemoryUtils() {
        return new AnonymousClass69(this);
    }

    default IProfileDrivenDexoptManager getProfileDrivenDexoptManager() {
        return new AnonymousClass70(this);
    }

    default ISparkDexoptManager getSparkDexoptManager() {
        return new AnonymousClass71(this);
    }

    default IActivityTaskManagerOptEx getAtmOptEx() {
        return new AnonymousClass72(this);
    }

    default IActivityRecordOptEx createActivityRecordOptEx(ActivityRecord record) {
        return null;
    }

    @Override // com.android.server.ISysMonitorSvcFactory
    default IHandleMemoryLeak getHandleMemoryLeak() {
        return new AnonymousClass73(this);
    }

    default IPrefetchManagerService getPrefetchManager() {
        return new AnonymousClass74(this);
    }

    default IDynamicRefreshRateService getDynamicRefreshRateService() {
        return new AnonymousClass75(this);
    }

    default IInputInfoTransService getInputInfoTransService() {
        return new AnonymousClass76(this);
    }

    default IReverseDropCacheFeatureConfig getReverseDropCacheFeatureConfig() {
        return new AnonymousClass77(this);
    }

    default IDefragManager getDefragManager() {
        return new AnonymousClass78(this);
    }

    default IGuardianManager getGuardianManager() {
        return new AnonymousClass79(this);
    }

    default ISkipDoFrameController getSkipDoFrameController() {
        return new AnonymousClass80(this);
    }

    default IActivityManagerServiceSysEx getAmsOpt() {
        return new AnonymousClass81(this);
    }

    default IProcExtraInfoOpt getProcExtraInfoOpt() {
        return new AnonymousClass82(this);
    }

    default IFindSvpThreadHandler getFindSvpThreadHandler() {
        return new AnonymousClass83(this);
    }

    default ISvpSenarioHandler getSvpSenarioHandler() {
        return new AnonymousClass84(this);
    }

    default IDynamicRefreshRateOpt getDynamicRefreshRateOpt() {
        return new AnonymousClass85(this);
    }

    default IWindowAnimatorOpt getWindowAnimatorOpt(WindowAnimator windowAnimator) {
        return new AnonymousClass86(this);
    }

    default IWindowAnimatorOpt getWindowAnimatorOpt(WindowAnimator windowAnimator, int type) {
        return new AnonymousClass87(this);
    }

    default IThermalInfo getThermalInfo() {
        return new AnonymousClass88(this);
    }

    default IInputMethodManagerServiceOpt getIMMSOpt() {
        return new AnonymousClass89(this);
    }

    default IProcessStatusChecker getProcessStatusChecker() {
        return new AnonymousClass90(this);
    }

    default IDecisionMaker getDecisionMaker() {
        return new AnonymousClass91(this);
    }

    default IResMngConfig getResMngConfig() {
        return new AnonymousClass92(this);
    }

    default IResMngService getResMngService() {
        return new AnonymousClass93(this);
    }

    default IIOFeatureConfig getIOFeatureConfig() {
        return new AnonymousClass94(this);
    }

    default ICachedAppOptimizerOptEx getCachedAppOptimizerOptEx() {
        return new AnonymousClass95(this);
    }

    default IBroadcastChecker getBroadcastChecker() {
        return new AnonymousClass96(this);
    }

    default IIoLimiter getIoLimiter() {
        return new AnonymousClass97(this);
    }

    default IAppOpsServiceSysEx getAppOpsServiceSysEx() {
        return new AnonymousClass98(this);
    }

    default IBroadcastProxy getBroadcastProxy() {
        return new AnonymousClass99(this);
    }

    default ISchedExtService getSchedExtService() {
        return new AnonymousClass100(this);
    }

    default ISvpCgroupManager getSvpCgroupManager() {
        return new AnonymousClass101(this);
    }

    default IPerfThermalMonitor getPerfThermalMonitorInstance() {
        return new AnonymousClass102(this);
    }

    default IFreqOptimize getFreqOptimize() {
        return new AnonymousClass103(this);
    }

    default IWarmStartPidCache getWarmStartPidCache() {
        return new AnonymousClass104(this);
    }

    default IArtManagerLocalEx getArtManagerLocalEx() {
        return new AnonymousClass105(this);
    }
}
