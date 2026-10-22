package android.app;

import android.accounts.StepOSAccountManager;
import android.app.SystemServiceRegistry;
import android.content.Context;
import android.content.ContextExt;
import android.content.res.stepostheme.StepOSThemeManager;
import android.hardware.display.IStepOSDeviceControlService;
import android.hardware.display.IStepOSDisplayManager;
import android.hardware.display.StepOSDeviceControlManager;
import android.hardware.display.StepOSDisplayManager;
import android.media.StepOSAudioManager;
import android.media.alwayson.AlwaysOnVoiceManager;
import android.net.StepOSNetworkBoostManager;
import android.net.StepOSSocketInfoManager;
import android.os.IBinder;
import android.os.IStepOSInstall;
import android.os.StepOSInstallManager;
import android.os.collector.IStepOSDataCollectManager;
import android.os.collector.StepOSDataCollectManager;
import android.util.Log;
import com.stepos.account.IStepOSAccountService;
import com.stepos.apptag.IStepOSAppTagManager;
import com.stepos.apptag.StepOSAppTagManager;
import com.stepos.exserviceui.IStepOSExServiceUiManager;
import com.stepos.exserviceui.StepOSExServiceUiManager;
import com.stepos.net.IStepOSNetworkBoostService;
import com.stepos.net.IStepOSSocketInfoService;
import com.stepos.powermonitor.IStepOSPowerMonitorManager;
import com.stepos.powermonitor.StepOSPowerMonitorManager;
import com.stepos.preload.IPreloadService;
import com.stepos.scene.ISceneManager;
import com.stepos.scene.SceneManager;
import com.stepos.theme.IStepOSThemeService;
import stepos.app.IStepOSGestureManager;
import stepos.app.StepOSGestureManager;
import stepos.net.IStepOSNetd;
import stepos.net.StepOSNetdManager;
import stepos.statusbar.IStepOSStatusBarService;
import stepos.statusbar.StepOSStatusBarManager;

/* loaded from: classes.dex */
public class StepOSSystemServiceRegistryImpl implements IStepOSSystemServiceRegistry {
    private static final String TAG = "StepOSSystemServiceRegistry";

    public void registerStepOSServices() {
        Log.i(TAG, "Starting to register StepOS services...");
        try {
            SystemServiceRegistry.registerContextAwareService("stepos_account", StepOSAccountManager.class, new SystemServiceRegistry.ContextAwareServiceProducerWithBinder<StepOSAccountManager>(this) { // from class: android.app.StepOSSystemServiceRegistryImpl.1
                /* renamed from: createService, reason: merged with bridge method [inline-methods] */
                public StepOSAccountManager m3createService(Context ctx, IBinder binder) {
                    return new StepOSAccountManager(ctx, IStepOSAccountService.Stub.asInterface(binder));
                }
            });
            Log.i(TAG, "Registered service: stepos_account");
            SystemServiceRegistry.registerContextAwareService("stepos_socket_info", StepOSSocketInfoManager.class, new SystemServiceRegistry.ContextAwareServiceProducerWithBinder<StepOSSocketInfoManager>(this) { // from class: android.app.StepOSSystemServiceRegistryImpl.2
                /* renamed from: createService, reason: merged with bridge method [inline-methods] */
                public StepOSSocketInfoManager m11createService(Context ctx, IBinder binder) {
                    return new StepOSSocketInfoManager(ctx, IStepOSSocketInfoService.Stub.asInterface(binder));
                }
            });
            Log.i(TAG, "Registered service: stepos_socket_info");
            SystemServiceRegistry.registerContextAwareService(StepOSNetworkBoostManager.SERVICE_NAME, StepOSNetworkBoostManager.class, new SystemServiceRegistry.ContextAwareServiceProducerWithBinder<StepOSNetworkBoostManager>(this) { // from class: android.app.StepOSSystemServiceRegistryImpl.3
                /* renamed from: createService, reason: merged with bridge method [inline-methods] */
                public StepOSNetworkBoostManager m12createService(Context ctx, IBinder binder) {
                    return new StepOSNetworkBoostManager(ctx, IStepOSNetworkBoostService.Stub.asInterface(binder));
                }
            });
            Log.i(TAG, "Registered service: " + StepOSNetworkBoostManager.SERVICE_NAME);
            SystemServiceRegistry.registerContextAwareService(ContextExt.COLLECTD_DATA_SERVICE, StepOSDataCollectManager.class, new SystemServiceRegistry.ContextAwareServiceProducerWithBinder<StepOSDataCollectManager>(this) { // from class: android.app.StepOSSystemServiceRegistryImpl.4
                /* renamed from: createService, reason: merged with bridge method [inline-methods] */
                public StepOSDataCollectManager m13createService(Context ctx, IBinder binder) {
                    return new StepOSDataCollectManager(ctx, IStepOSDataCollectManager.Stub.asInterface(binder));
                }
            });
            SystemServiceRegistry.registerContextAwareService(StepOSDisplayManager.DISPLAY_EXT_SERVICE, StepOSDisplayManager.class, new SystemServiceRegistry.ContextAwareServiceProducerWithBinder<StepOSDisplayManager>(this) { // from class: android.app.StepOSSystemServiceRegistryImpl.5
                /* renamed from: createService, reason: merged with bridge method [inline-methods] */
                public StepOSDisplayManager m14createService(Context ctx, IBinder binder) {
                    return new StepOSDisplayManager(ctx, IStepOSDisplayManager.Stub.asInterface(binder));
                }
            });
            Log.i(TAG, "Registered service: " + StepOSDisplayManager.DISPLAY_EXT_SERVICE);
            SystemServiceRegistry.registerContextAwareService(ContextExt.STEP_SCENE, SceneManager.class, new SystemServiceRegistry.ContextAwareServiceProducerWithBinder<SceneManager>(this) { // from class: android.app.StepOSSystemServiceRegistryImpl.6
                /* renamed from: createService, reason: merged with bridge method [inline-methods] */
                public SceneManager m15createService(Context ctx, IBinder binder) {
                    return new SceneManager(ctx, ISceneManager.Stub.asInterface(binder));
                }
            });
            Log.i(TAG, "Registered service: stepscene");
            SystemServiceRegistry.registerContextAwareService("always_on_voice", AlwaysOnVoiceManager.class, new SystemServiceRegistry.ContextAwareServiceProducerWithoutBinder() { // from class: android.app.StepOSSystemServiceRegistryImpl$$ExternalSyntheticLambda0
                public final Object createService(Context context) {
                    return new AlwaysOnVoiceManager(context);
                }
            });
            Log.i(TAG, "Registered service: always_on_voice");
            SystemServiceRegistry.registerContextAwareService("stepos_audio", StepOSAudioManager.class, new SystemServiceRegistry.ContextAwareServiceProducerWithoutBinder() { // from class: android.app.StepOSSystemServiceRegistryImpl$$ExternalSyntheticLambda1
                public final Object createService(Context context) {
                    return new StepOSAudioManager(context);
                }
            });
            Log.i(TAG, "Registered service: stepos_audio");
            SystemServiceRegistry.registerContextAwareService(StepOSInstallManager.SERVICES_NAME, StepOSInstallManager.class, new SystemServiceRegistry.ContextAwareServiceProducerWithBinder<StepOSInstallManager>(this) { // from class: android.app.StepOSSystemServiceRegistryImpl.7
                /* renamed from: createService, reason: merged with bridge method [inline-methods] */
                public StepOSInstallManager m16createService(Context ctx, IBinder binder) {
                    return new StepOSInstallManager(ctx, IStepOSInstall.Stub.asInterface(binder));
                }
            });
            SystemServiceRegistry.registerContextAwareService(StepOSThemeManager.STEPOS_THEME_SERVICE, StepOSThemeManager.class, new SystemServiceRegistry.ContextAwareServiceProducerWithBinder<StepOSThemeManager>(this) { // from class: android.app.StepOSSystemServiceRegistryImpl.8
                /* renamed from: createService, reason: merged with bridge method [inline-methods] */
                public StepOSThemeManager m17createService(Context ctx, IBinder binder) {
                    return new StepOSThemeManager(ctx, IStepOSThemeService.Stub.asInterface(binder));
                }
            });
            Log.i(TAG, "Registered service: stepos_theme");
            SystemServiceRegistry.registerContextAwareService(PreloadManager.SERVICE_NAME, PreloadManager.class, new SystemServiceRegistry.ContextAwareServiceProducerWithBinder<PreloadManager>(this) { // from class: android.app.StepOSSystemServiceRegistryImpl.9
                /* renamed from: createService, reason: merged with bridge method [inline-methods] */
                public PreloadManager m18createService(Context ctx, IBinder binder) {
                    return new PreloadManager(ctx, IPreloadService.Stub.asInterface(binder));
                }
            });
            Log.i(TAG, "Registered service: preload");
            SystemServiceRegistry.registerContextAwareService("stepos_exserviceui", StepOSExServiceUiManager.class, new SystemServiceRegistry.ContextAwareServiceProducerWithBinder<StepOSExServiceUiManager>(this) { // from class: android.app.StepOSSystemServiceRegistryImpl.10
                /* renamed from: createService, reason: merged with bridge method [inline-methods] */
                public StepOSExServiceUiManager m4createService(Context ctx, IBinder binder) {
                    return new StepOSExServiceUiManager(ctx, IStepOSExServiceUiManager.Stub.asInterface(binder));
                }
            });
            Log.i(TAG, "Registered service: stepos_exserviceui");
            SystemServiceRegistry.registerContextAwareService("stepos_device_control", StepOSDeviceControlManager.class, new SystemServiceRegistry.ContextAwareServiceProducerWithBinder<StepOSDeviceControlManager>(this) { // from class: android.app.StepOSSystemServiceRegistryImpl.11
                /* renamed from: createService, reason: merged with bridge method [inline-methods] */
                public StepOSDeviceControlManager m5createService(Context ctx, IBinder binder) {
                    return new StepOSDeviceControlManager(ctx, IStepOSDeviceControlService.Stub.asInterface(binder));
                }
            });
            Log.i(TAG, "Registered service: stepos_device_control");
            SystemServiceRegistry.registerContextAwareService(StepOSGestureManager.SERVICE_NAME, StepOSGestureManager.class, new SystemServiceRegistry.ContextAwareServiceProducerWithBinder<StepOSGestureManager>(this) { // from class: android.app.StepOSSystemServiceRegistryImpl.12
                public StepOSGestureManager createService(Context ctx, IBinder binder) {
                    return new StepOSGestureManager(ctx, IStepOSGestureManager.Stub.asInterface(binder));
                }
            });
            Log.i(TAG, "Registered service: stepos_gesture");
            SystemServiceRegistry.registerContextAwareService("stepos_statusbar", StepOSStatusBarManager.class, new SystemServiceRegistry.ContextAwareServiceProducerWithBinder<StepOSStatusBarManager>(this) { // from class: android.app.StepOSSystemServiceRegistryImpl.13
                public StepOSStatusBarManager createService(Context ctx, IBinder binder) {
                    return new StepOSStatusBarManager(ctx, IStepOSStatusBarService.Stub.asInterface(binder));
                }
            });
            Log.i(TAG, "Registered service: stepos_statusbar");
            SystemServiceRegistry.registerContextAwareService(StepOSNetdManager.SERVICE_NAME, StepOSNetdManager.class, new SystemServiceRegistry.ContextAwareServiceProducerWithBinder<StepOSNetdManager>(this) { // from class: android.app.StepOSSystemServiceRegistryImpl.14
                public StepOSNetdManager createService(Context ctx, IBinder binder) {
                    return new StepOSNetdManager(ctx, IStepOSNetd.Stub.asInterface(binder));
                }
            });
            Log.i(TAG, "Registered service: stepos_netd");
            SystemServiceRegistry.registerContextAwareService(StepOSAppTagManager.SERVICE_NAME, StepOSAppTagManager.class, new SystemServiceRegistry.ContextAwareServiceProducerWithBinder<StepOSAppTagManager>(this) { // from class: android.app.StepOSSystemServiceRegistryImpl.15
                /* renamed from: createService, reason: merged with bridge method [inline-methods] */
                public StepOSAppTagManager m9createService(Context ctx, IBinder binder) {
                    return new StepOSAppTagManager(ctx, IStepOSAppTagManager.Stub.asInterface(binder));
                }
            });
            SystemServiceRegistry.registerContextAwareService(StepOSPowerMonitorManager.POWER_MONITOR_SERVICE, StepOSPowerMonitorManager.class, new SystemServiceRegistry.ContextAwareServiceProducerWithBinder<StepOSPowerMonitorManager>(this) { // from class: android.app.StepOSSystemServiceRegistryImpl.16
                /* renamed from: createService, reason: merged with bridge method [inline-methods] */
                public StepOSPowerMonitorManager m10createService(Context ctx, IBinder binder) {
                    return new StepOSPowerMonitorManager(ctx, IStepOSPowerMonitorManager.Stub.asInterface(binder));
                }
            });
            Log.i(TAG, "Registered service: stepos_apptag");
        } catch (Throwable e) {
            Log.e(TAG, "Failed to register StepOS services", e);
        }
    }
}
