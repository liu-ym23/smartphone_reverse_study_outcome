package com.stepos.core.ota.push;

import a9.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.settings.AiEngineSystemSettings;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.ota.domain.PauseReason;
import com.stepos.core.ota.process.OtaProcess;
import h0.e;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelUpdateConditionManager {
    private static final String TAG = "ModelUpdateCondition";
    private static volatile Context appContext;
    private static volatile ModelUpdateConditionListener listener;
    private static volatile ConnectivityManager.NetworkCallback networkCallback;
    private static volatile boolean receiversRegistered;
    private static volatile boolean started;
    private static volatile ContentObserver switchObserver;
    private static volatile BroadcastReceiver systemReceiver;
    public static final ModelUpdateConditionManager INSTANCE = new ModelUpdateConditionManager();
    private static volatile int lastBatteryPct = -1;
    private static final CTAPermissionManager.SwitchChangeListener switchChangeListener = new a();

    private ModelUpdateConditionManager() {
    }

    private final void diag(String str) {
        e.k("[DIAG] ", str, LogModule.OTA, TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchBattery(Intent intent) {
        int i10;
        int intExtra = intent.getIntExtra("scale", -1);
        int intExtra2 = intent.getIntExtra("level", -1);
        if (intExtra <= 0 || intExtra2 < 0 || (i10 = (intExtra2 * 100) / intExtra) == lastBatteryPct) {
            return;
        }
        lastBatteryPct = i10;
        diag(ai.onnxruntime.providers.a.a(i10, "battery broadcast pct="));
        ModelUpdateConditionListener modelUpdateConditionListener = listener;
        if (modelUpdateConditionListener != null) {
            modelUpdateConditionListener.onBatteryChanged(i10);
        }
    }

    private final void onSwitchChanged() {
        Context context;
        if (started && (context = appContext) != null) {
            CTAPermissionManager cTAPermissionManager = CTAPermissionManager.INSTANCE;
            diag("switchChanged ctaAllowed=" + cTAPermissionManager.isModelOtaAllowed() + " wifiAuto=" + cTAPermissionManager.isWlanAutoUpgradeEnabled() + " hasNewDownload=" + PendingAutoUpdateStore.INSTANCE.hasNewDownloadPending() + " enabled=" + switchesEnabled());
            if (switchesEnabled()) {
                AIEngineLogger.i(LogModule.OTA, TAG, "switch on → register listeners");
                registerReceivers(context);
                ModelAutoUpdateManager.INSTANCE.resumeSilentPaused("switch_on");
            } else {
                AIEngineLogger.i(LogModule.OTA, TAG, "switch off → unregister listeners + cancel silent");
                unregisterReceivers(context);
                ModelAutoUpdateManager.INSTANCE.cancelAllSilent("switch_off", PauseReason.SERVICE_DISABLED);
            }
        }
    }

    private final void registerReceivers(Context context) {
        if (receiversRegistered) {
            return;
        }
        receiversRegistered = true;
        registerWifiCallback(context);
        registerSystemReceiver(context);
        diag("registerReceivers");
    }

    private final void registerSystemReceiver(Context context) {
        Object objA;
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.stepos.core.ota.push.ModelUpdateConditionManager$registerSystemReceiver$receiver$1
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                ModelUpdateConditionListener modelUpdateConditionListener;
                ModelUpdateConditionListener modelUpdateConditionListener2;
                ModelUpdateConditionListener modelUpdateConditionListener3;
                ModelUpdateConditionListener modelUpdateConditionListener4;
                String action = intent != null ? intent.getAction() : null;
                if (action != null) {
                    switch (action.hashCode()) {
                        case -2128145023:
                            if (action.equals("android.intent.action.SCREEN_OFF") && (modelUpdateConditionListener = ModelUpdateConditionManager.listener) != null) {
                                modelUpdateConditionListener.onScreenChanged(true);
                                break;
                            }
                            break;
                        case -1886648615:
                            if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED") && (modelUpdateConditionListener2 = ModelUpdateConditionManager.listener) != null) {
                                modelUpdateConditionListener2.onPowerChanged(false);
                                break;
                            }
                            break;
                        case -1538406691:
                            if (action.equals("android.intent.action.BATTERY_CHANGED")) {
                                ModelUpdateConditionManager.INSTANCE.dispatchBattery(intent);
                                break;
                            }
                            break;
                        case -1454123155:
                            if (action.equals("android.intent.action.SCREEN_ON") && (modelUpdateConditionListener3 = ModelUpdateConditionManager.listener) != null) {
                                modelUpdateConditionListener3.onScreenChanged(false);
                                break;
                            }
                            break;
                        case 1019184907:
                            if (action.equals("android.intent.action.ACTION_POWER_CONNECTED") && (modelUpdateConditionListener4 = ModelUpdateConditionManager.listener) != null) {
                                modelUpdateConditionListener4.onPowerChanged(true);
                                break;
                            }
                            break;
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        try {
            objA = context.registerReceiver(broadcastReceiver, intentFilter, 4);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (!(objA instanceof Result.Failure)) {
            systemReceiver = broadcastReceiver;
            INSTANCE.diag("system receiver registered");
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.e(LogModule.OTA, TAG, "registerReceiver failed", thB);
        }
    }

    private final void registerWifiCallback(Context context) {
        Object objA;
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            return;
        }
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(1).addCapability(12).build();
        ConnectivityManager.NetworkCallback networkCallback2 = new ConnectivityManager.NetworkCallback() { // from class: com.stepos.core.ota.push.ModelUpdateConditionManager$registerWifiCallback$cb$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities caps) {
                ModelUpdateConditionListener modelUpdateConditionListener;
                g.f(network, "network");
                g.f(caps, "caps");
                if (!caps.hasCapability(16) || (modelUpdateConditionListener = ModelUpdateConditionManager.listener) == null) {
                    return;
                }
                modelUpdateConditionListener.onNetworkStatusChange(true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                g.f(network, "network");
                ModelUpdateConditionListener modelUpdateConditionListener = ModelUpdateConditionManager.listener;
                if (modelUpdateConditionListener != null) {
                    modelUpdateConditionListener.onNetworkStatusChange(false);
                }
            }
        };
        try {
            connectivityManager.registerNetworkCallback(networkRequestBuild, networkCallback2);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (!(objA instanceof Result.Failure)) {
            networkCallback = networkCallback2;
            INSTANCE.diag("wifi callback registered");
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.e(LogModule.OTA, TAG, "registerNetworkCallback failed", thB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n start$lambda$1() {
        INSTANCE.onSwitchChanged();
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void switchChangeListener$lambda$0() {
        INSTANCE.onSwitchChanged();
    }

    private final boolean switchesEnabled() {
        CTAPermissionManager cTAPermissionManager = CTAPermissionManager.INSTANCE;
        if (cTAPermissionManager.isModelOtaAllowed()) {
            return cTAPermissionManager.isWlanAutoUpgradeEnabled() || PendingAutoUpdateStore.INSTANCE.hasNewDownloadPending();
        }
        return false;
    }

    private final void unregisterReceivers(Context context) {
        if (receiversRegistered) {
            receiversRegistered = false;
            Object systemService = context.getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            ConnectivityManager.NetworkCallback networkCallback2 = networkCallback;
            if (networkCallback2 != null && connectivityManager != null) {
                try {
                    connectivityManager.unregisterNetworkCallback(networkCallback2);
                    n nVar = n.f10413a;
                } catch (Throwable th) {
                    c.a(th);
                }
            }
            networkCallback = null;
            BroadcastReceiver broadcastReceiver = systemReceiver;
            if (broadcastReceiver != null) {
                try {
                    context.unregisterReceiver(broadcastReceiver);
                    n nVar2 = n.f10413a;
                } catch (Throwable th2) {
                    c.a(th2);
                }
            }
            systemReceiver = null;
            lastBatteryPct = -1;
            diag("unregisterReceivers");
        }
    }

    public final void refresh() {
        onSwitchChanged();
    }

    public final void start(Context context, ModelUpdateConditionListener l10) {
        g.f(context, "context");
        g.f(l10, "l");
        if (OtaProcess.INSTANCE.isOtaProcess(context) || started) {
            return;
        }
        started = true;
        listener = l10;
        Context applicationContext = context.getApplicationContext();
        appContext = applicationContext;
        CTAPermissionManager.INSTANCE.addSwitchListener(switchChangeListener);
        if (switchObserver == null) {
            AiEngineSystemSettings aiEngineSystemSettings = AiEngineSystemSettings.INSTANCE;
            g.c(applicationContext);
            switchObserver = aiEngineSystemSettings.registerSwitchObserver(applicationContext, new b(24));
        }
        if (switchesEnabled()) {
            g.c(applicationContext);
            registerReceivers(applicationContext);
        }
        AIEngineLogger.i(LogModule.OTA, TAG, "started, switchesEnabled=" + switchesEnabled());
        diag("start switchesEnabled=" + switchesEnabled());
    }

    public final void stop(Context context) {
        g.f(context, "context");
        if (started) {
            started = false;
            CTAPermissionManager.INSTANCE.removeSwitchListener(switchChangeListener);
            Context applicationContext = context.getApplicationContext();
            ContentObserver contentObserver = switchObserver;
            if (contentObserver != null) {
                AiEngineSystemSettings aiEngineSystemSettings = AiEngineSystemSettings.INSTANCE;
                g.c(applicationContext);
                aiEngineSystemSettings.unregisterSwitchObserver(applicationContext, contentObserver);
            }
            switchObserver = null;
            g.c(applicationContext);
            unregisterReceivers(applicationContext);
            appContext = null;
            listener = null;
            AIEngineLogger.i(LogModule.OTA, TAG, "stopped");
            diag("stop");
        }
    }
}
