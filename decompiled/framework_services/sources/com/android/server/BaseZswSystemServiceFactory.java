package com.android.server;

import android.content.Context;
import android.os.Handler;
import android.os.IZswPowerManagerInternal;
import android.util.Slog;
import com.android.server.accounts.IZswAccountManagerService;
import com.android.server.am.IZswActiveServices;
import com.android.server.am.IZswActivityManagerConstants;
import com.android.server.am.IZswActivityManagerService;
import com.android.server.am.IZswAppErrors;
import com.android.server.am.IZswBatteryStatsService;
import com.android.server.am.IZswBroadcastController;
import com.android.server.am.IZswBroadcastProcessQueue;
import com.android.server.am.IZswBroadcastQueueImpl;
import com.android.server.am.IZswBroadcastRecord;
import com.android.server.am.IZswBroadcastSkipPolicy;
import com.android.server.am.IZswCachedAppOptimizer;
import com.android.server.am.IZswContentProviderHelper;
import com.android.server.am.IZswLowMemDetector;
import com.android.server.am.IZswOomAdjuster;
import com.android.server.am.IZswPendingIntentController;
import com.android.server.am.IZswPendingIntentRecord;
import com.android.server.am.IZswProcessCachedOptimizerRecord;
import com.android.server.am.IZswProcessErrorStateRecord;
import com.android.server.am.IZswProcessList;
import com.android.server.am.IZswProcessRecord;
import com.android.server.am.IZswProcessServiceRecord;
import com.android.server.am.IZswUserController;
import com.android.server.connectivity.IZswVpn;
import com.android.server.content.IZswContentService;
import com.android.server.display.IZswDisplayDeviceRepository;
import com.android.server.display.IZswDisplayManagerService;
import com.android.server.display.IZswDisplayPowerController;
import com.android.server.display.IZswDisplayPowerState;
import com.android.server.display.IZswLocalDisplayAdapter;
import com.android.server.location.provider.IZswLocationProviderManager;
import com.android.server.media.IZswMediaRoute2ProviderServiceProxy;
import com.android.server.notification.IZswNotificationManagerService;
import com.android.server.notification.IZswNotificationRecord;
import com.android.server.notification.IZswZenModeHelper;
import com.android.server.om.IZswIdmapManager;
import com.android.server.om.IZswOverlayManagerService;
import com.android.server.om.IZswOverlayManagerServiceImpl;
import com.android.server.permission.access.permission.IZswPermissionService;
import com.android.server.pinner.IZswPinnerService;
import com.android.server.pm.IZswComputerEngine;
import com.android.server.pm.IZswDeletePackageHelper;
import com.android.server.pm.IZswInstallPackageHelper;
import com.android.server.pm.IZswPackageInstallerSession;
import com.android.server.pm.IZswPackageManagerService;
import com.android.server.pm.IZswPackageManagerShellCommand;
import com.android.server.pm.permission.IZswPermissionManagerServiceImpl;
import com.android.server.pm.resolution.IZswComponentResolver;
import com.android.server.policy.IZswPhoneWindowManager;
import com.android.server.power.IZswPowerGroup;
import com.android.server.power.IZswPowerManagerService;
import com.android.server.power.IZswShutdownThread;
import com.android.server.power.IZswThermalManagerService;
import com.android.server.power.batterysaver.IZswBatterySaverPolicy;
import com.android.server.storage.IZswDeviceStorageMonitorService;
import com.android.server.uri.IZswUriGrantsManagerService;
import com.android.server.wm.ActivityTaskManagerService;
import com.android.server.wm.ActivityTaskSupervisor;
import com.android.server.wm.IZswAbsAppSnapshotController;
import com.android.server.wm.IZswActivityMetricsLogger;
import com.android.server.wm.IZswActivityRecord;
import com.android.server.wm.IZswActivityStartController;
import com.android.server.wm.IZswActivityStarter;
import com.android.server.wm.IZswActivityTaskManagerService;
import com.android.server.wm.IZswActivityTaskSupervisor;
import com.android.server.wm.IZswBackgroundActivityStartController;
import com.android.server.wm.IZswDisplayContent;
import com.android.server.wm.IZswDisplayPolicy;
import com.android.server.wm.IZswDragState;
import com.android.server.wm.IZswImeInsetsSourceProvider;
import com.android.server.wm.IZswInputMonitor;
import com.android.server.wm.IZswInsetsPolicy;
import com.android.server.wm.IZswKeyGuardController;
import com.android.server.wm.IZswPointerEventDispatcher;
import com.android.server.wm.IZswRootWindowContainer;
import com.android.server.wm.IZswTask;
import com.android.server.wm.IZswTaskDisplayArea;
import com.android.server.wm.IZswTaskFragment;
import com.android.server.wm.IZswWindowAnimator;
import com.android.server.wm.IZswWindowManagerInternal;
import com.android.server.wm.IZswWindowManagerService;
import com.android.server.wm.IZswWindowState;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseZswSystemServiceFactory {
    static final String TAG = "BaseZswSystemServiceFactory";
    static final String implClass = "com.android.server.ZswSystemServiceFactoryImpl";
    private static BaseZswSystemServiceFactory mFactoryImpl;

    public abstract IZswAbsAppSnapshotController createZswAbsAppSnapshotController();

    public abstract IZswAccountManagerService createZswAccountManagerService(Object r1);

    public abstract IZswActiveServices createZswActiveServices(Object r1);

    public abstract IZswActivityManagerConstants createZswActivityManagerConstants(Object r1);

    public abstract IZswActivityManagerService createZswActivityManagerService(Object r1);

    public abstract IZswActivityMetricsLogger createZswActivityMetricsLogger();

    public abstract IZswActivityRecord createZswActivityRecord();

    public abstract IZswActivityStartController createZswActivityStartController();

    public abstract IZswActivityStarter createZswActivityStarter(ActivityTaskManagerService r1, ActivityTaskSupervisor r2);

    public abstract IZswActivityTaskManagerService createZswActivityTaskManagerService(Object r1);

    public abstract IZswActivityTaskSupervisor createZswActivityTaskSupervisor();

    public abstract IZswAppErrors createZswAppErrors(Object r1);

    public abstract IZswBackgroundActivityStartController createZswBackgroundActivityStartController(Object r1);

    public abstract IZswBatterySaverPolicy createZswBatterySaverPolicy(Context r1);

    public abstract IZswBatteryService createZswBatteryService(Object r1);

    public abstract IZswBatteryStatsService createZswBatteryStatsService();

    public abstract IZswBroadcastController createZswBroadcastController();

    public abstract IZswBroadcastProcessQueue createZswBroadcastProcessQueue(Object r1);

    public abstract IZswBroadcastQueueImpl createZswBroadcastQueueImpl(Object r1);

    public abstract IZswBroadcastRecord createZswBroadcastRecord(Object r1);

    public abstract IZswBroadcastSkipPolicy createZswBroadcastSkipPolicy();

    public abstract IZswCachedAppOptimizer createZswCachedAppOptimizer(Object r1);

    public abstract IZswComponentResolver createZswComponentResolver();

    public abstract IZswComputerEngine createZswComputerEngine();

    public abstract IZswContentProviderHelper createZswContentProviderHelper();

    public abstract IZswContentService createZswContentService();

    public abstract IZswDeletePackageHelper createZswDeletePackageHelper();

    public abstract IZswDeviceStorageMonitorService createZswDeviceStorageMonitorService();

    public abstract IZswDisplayContent createZswDisplayContent(Object r1);

    public abstract IZswDisplayDeviceRepository createZswDisplayDeviceRepository();

    public abstract IZswDisplayManagerService createZswDisplayManagerService(Object r1);

    public abstract IZswDisplayPolicy createZswDisplayPolicy(Object r1);

    public abstract IZswDisplayPowerController createZswDisplayPowerController(Object r1);

    public abstract IZswDisplayPowerState createZswDisplayPowerState();

    public abstract IZswDragState createZswDragState(Object r1);

    public abstract IZswIdmapManager createZswIdmapManager();

    public abstract IZswImeInsetsSourceProvider createZswImeInsetsSourceProvider();

    public abstract IZswInputMonitor createZswInputMonitor();

    public abstract IZswInsetsPolicy createZswInsetsPolicy(Object r1);

    public abstract IZswInstallPackageHelper createZswInstallPackageHelper(Object r1);

    public abstract IZswKeyGuardController createZswKeyGuardController();

    public abstract IZswLocalDisplayAdapter createZswLocalDisplayAdapter();

    public abstract IZswLocationProviderManager createZswLocationProviderManager();

    public abstract IZswLowMemDetector createZswLowMemDetector();

    public abstract IZswMediaRoute2ProviderServiceProxy createZswMediaRoute2ProviderServiceProxy();

    public abstract IZswMountServiceIdler createZswMountServiceIdler();

    public abstract IZswNotificationManagerService createZswNotificationManagerService(Object r1);

    public abstract IZswNotificationRecord createZswNotificationRecord();

    public abstract IZswOomAdjuster createZswOomAdjuster();

    public abstract IZswOverlayManagerService createZswOverlayManagerService();

    public abstract IZswOverlayManagerServiceImpl createZswOverlayManagerServiceImpl();

    public abstract IZswPackageInstallerSession createZswPackageInstallerSession();

    public abstract IZswPackageManagerService createZswPackageManagerService(Object r1);

    public abstract IZswPackageManagerShellCommand createZswPackageManagerShellCommand();

    public abstract IZswPendingIntentController createZswPendingIntentController();

    public abstract IZswPendingIntentRecord createZswPendingIntentRecord(Object r1);

    public abstract IZswPermissionManagerServiceImpl createZswPermissionManagerServiceImpl();

    public abstract IZswPermissionService createZswPermissionService();

    public abstract IZswPhoneWindowManager createZswPhoneWindowManager(Object r1);

    public abstract IZswPinnerService createZswPinnerService();

    public abstract IZswPointerEventDispatcher createZswPointerEventDispatcher();

    public abstract IZswPowerGroup createZswPowerGroup(int r1);

    public abstract IZswPowerManagerInternal createZswPowerManagerInternal(Object r1);

    public abstract IZswPowerManagerService createZswPowerManagerService(Object r1, Context r2, Handler r3, Object r4, IZswPowerManagerService.PrivateMethodCaller r5);

    public abstract IZswProcessCachedOptimizerRecord createZswProcessCachedOptimizerRecord(Object r1);

    public abstract IZswProcessErrorStateRecord createZswProcessErrorStateRecord(Object r1);

    public abstract IZswProcessList createZswProcessList(Object r1);

    public abstract IZswProcessRecord createZswProcessRecord();

    public abstract IZswProcessServiceRecord createZswProcessServiceRecord();

    public abstract IZswRootWindowContainer createZswRootWindowContainer(Object r1);

    public abstract IZswShutdownThread createZswShutdownThread();

    public abstract IZswStorageManagerService createZswStorageManagerService(Object r1);

    public abstract IZswTask createZswTask();

    public abstract IZswTaskDisplayArea createZswTaskDisplayArea();

    public abstract IZswTaskFragment createZswTaskFragment();

    public abstract IZswThermalManagerService createZswThermalManagerService();

    public abstract IZswUriGrantsManagerService createZswUriGrantsManagerService();

    public abstract IZswUserController createZswUserController();

    public abstract IZswVpn createZswVpn();

    public abstract IZswWindowAnimator createZswWindowAnimator();

    public abstract IZswWindowManagerInternal createZswWindowManagerInternal(Object r1);

    public abstract IZswWindowManagerService createZswWindowManagerService(Object r1);

    public abstract IZswWindowState createZswWindowState();

    public abstract IZswZenModeHelper createZswZenModeHelper();

    public BaseZswSystemServiceFactory() {
    }

    public static synchronized BaseZswSystemServiceFactory getZswSystemServiceFactoryImpl() {
        monitor-enter(BaseZswSystemServiceFactory.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (mFactoryImpl == null) goto L12;
        BaseZswSystemServiceFactory r1 = mFactoryImpl;     // Catch: Throwable -> L9
        monitor-exit(BaseZswSystemServiceFactory.class);
        return r1;
    L12:
        monitor-enter(BaseZswSystemServiceFactory.class);     // Catch: Throwable -> L9
        mFactoryImpl = (BaseZswSystemServiceFactory) Class.forName(implClass).newInstance();     // Catch: Throwable -> L20 Exception -> L22
        if (mFactoryImpl == null) goto L24;
        Slog.i(TAG, "Instance implClass com.android.server.ZswSystemServiceFactoryImpl");     // Catch: Throwable -> L20 Exception -> L22
        BaseZswSystemServiceFactory r2 = mFactoryImpl;     // Catch: Throwable -> L20 Exception -> L22
        monitor-exit(BaseZswSystemServiceFactory.class);     // Catch: Throwable -> L20
        monitor-exit(BaseZswSystemServiceFactory.class);
        return r2;
    L24:
        Slog.i(TAG, "Instance implClass com.android.server.ZswSystemServiceFactoryImpl failed!");     // Catch: Throwable -> L20 Exception -> L22
        monitor-exit(BaseZswSystemServiceFactory.class);     // Catch: Throwable -> L20
        monitor-exit(BaseZswSystemServiceFactory.class);
        return null;
    L22:
        localException = move-exception;
        Slog.i(TAG, "Instance implClass com.android.server.ZswSystemServiceFactoryImpl failed with exception", localException);     // Catch: Throwable -> L20
        return null;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    }
}
