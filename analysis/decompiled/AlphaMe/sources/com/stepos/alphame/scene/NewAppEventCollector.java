package com.stepos.alphame.scene;

import B0.g;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.android.material.datepicker.RunnableC0428g;
import com.stepos.alphame.dailyusage.utils.AppEventMonitor;
import com.stepos.alphame.manager.ActionManager;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import com.stepos.alphame.predict.PredictManager;
import com.stepos.alphame.userbehavior.UserBehaviorDataSource;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.LocalConsts;

/* loaded from: classes.dex */
public class NewAppEventCollector {
    private static final String TAG = "WME_AppEvent";
    private static BroadcastReceiver sReceiver;
    private static int sWindowModeFreeform;
    private static int sWindowModePinned;
    private static volatile Handler sWorkerHandler;

    private static synchronized void ensureReceiver(Context context) {
        if (sReceiver != null) {
            return;
        }
        sReceiver = new BroadcastReceiver() { // from class: com.stepos.alphame.scene.NewAppEventCollector.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (intent == null || !PerfBinderHelper.ACTION_APP_EVENTS_FORWARD.equals(intent.getAction())) {
                    return;
                }
                String stringExtra = intent.getStringExtra(PerfBinderHelper.EXTRA_EVENT_KIND);
                String stringExtra2 = intent.getStringExtra("PACKAGE_NAME");
                Bundle bundleExtra = intent.getBundleExtra(PerfBinderHelper.EXTRA_DATA_BUNDLE);
                if (PerfBinderHelper.EVENT_KIND_ACTIVITY.equals(stringExtra)) {
                    NewAppEventCollector.onActivityStateChange(stringExtra2, intent.getStringExtra(PerfBinderHelper.EXTRA_CLASS_NAME), bundleExtra);
                } else if (PerfBinderHelper.EVENT_KIND_PROCESS.equals(stringExtra)) {
                    NewAppEventCollector.onProcessStateChange(stringExtra2, intent.getStringExtra(PerfBinderHelper.EXTRA_PROCESS_NAME), bundleExtra);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter(PerfBinderHelper.ACTION_APP_EVENTS_FORWARD);
        try {
            context.getApplicationContext().registerReceiver(sReceiver, intentFilter, "com.stepos.appplatform.permission.ACCESS_IPC_SERVICE", null, 2);
        } catch (Throwable unused) {
            context.getApplicationContext().registerReceiver(sReceiver, intentFilter, "com.stepos.appplatform.permission.ACCESS_IPC_SERVICE", null);
        }
    }

    private static void ensureWorkerHandler(Looper looper) {
        Looper mainLooper = looper != null ? looper : Looper.getMainLooper();
        if (mainLooper == null) {
            throw new IllegalStateException("No Looper available for NewAppEventCollector");
        }
        synchronized (NewAppEventCollector.class) {
            try {
                Handler handler = sWorkerHandler;
                if (handler == null || handler.getLooper() != mainLooper) {
                    sWorkerHandler = new Handler(mainLooper);
                    if (looper == null) {
                        Log.w(TAG, "workerLooper is null, fallback to main Looper");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static Handler getWorkerHandler() {
        Handler handler = sWorkerHandler;
        if (handler != null) {
            return handler;
        }
        ensureWorkerHandler(null);
        return sWorkerHandler;
    }

    public static boolean init(Context context, Looper looper) {
        try {
            ensureWorkerHandler(looper);
            initWindowModes();
            ensureReceiver(context);
            boolean zEnableAppEventsMonitor = PerfBinderHelper.enableAppEventsMonitor();
            if (zEnableAppEventsMonitor) {
                Log.i(TAG, "REGISTER_OK listener=NewAppEventCollector(via AppPlatform)");
                AlphaMeLogger.iLog("NewAppEventCollector.init succeed!");
            } else {
                Log.e(TAG, "REGISTER_FAIL enableAppEventsMonitor returned false");
                AlphaMeLogger.eLog("NewAppEventCollector.init enableAppEventsMonitor failed");
            }
            return zEnableAppEventsMonitor;
        } catch (Exception e4) {
            Log.e(TAG, "REGISTER_FAIL reason=" + e4);
            AlphaMeLogger.eLog("NewAppEventCollector.init error: " + e4.toString());
            return false;
        }
    }

    private static void initWindowModes() {
        Bundle windowModeConstants = PerfBinderHelper.getWindowModeConstants();
        sWindowModeFreeform = windowModeConstants.getInt("WINDOW_MODE_FREEFORM", 11);
        sWindowModePinned = windowModeConstants.getInt("WINDOW_MODE_PINNED", 12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onActivityStateChange$0(String str, long j4) {
        try {
            UserBehaviorDataSource.getInstance().ensureInitialized();
            UserBehaviorDataSource.getInstance().onAppResumeEvent(str, j4, true, true, false);
            Log.i(TAG, "UB_RESUME pkg=" + str);
        } catch (Throwable th) {
            Log.e(TAG, "UB_RESUME failed pkg=" + str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onActivityStateChange(String str, String str2, Bundle bundle) {
        if (str == null || bundle == null) {
            return;
        }
        String str3 = str2 == null ? "" : str2;
        String string = bundle.getString("state", null);
        if (string == null) {
            return;
        }
        StringBuilder sbX = g.x("RAW_CALLBACK pkg=", str, " activity=", str3, " state=");
        sbX.append(string);
        Log.i(TAG, sbX.toString());
        AppEventMonitor.dispatchActivityStateChange(str, str3, bundle);
        int i4 = bundle.getInt(MapBundleKey.MapObjKey.OBJ_SS_ARROW_PANOID, 0);
        int i5 = bundle.getInt("uid", 0) / ComplexPt.TEN_THOUSAND;
        int iMyUid = Process.myUid() / ComplexPt.TEN_THOUSAND;
        int i6 = bundle.getInt("windowingMode", -1);
        int i7 = 1;
        boolean z4 = i6 == sWindowModeFreeform || i6 == sWindowModePinned;
        int i8 = bundle.getInt("displayId", 0);
        String str4 = (!"resume".equals(string) || z4) ? ("pause".equals(string) || z4) ? "pause" : null : "resume";
        StringBuilder sbX2 = g.x("AppSuggestReport onActivityStateChange ", str, "/", str3, " state:");
        sbX2.append(string);
        AlphaMeLogger.debugLog(sbX2.toString());
        if (i5 != iMyUid && i5 < 500) {
            AlphaMeLogger.vLog("onActivityStateChange userId not current. event.UserId=" + i5 + ", myUserId=" + iMyUid);
            return;
        }
        if (str4 != null) {
            String[] appInfo = {"-1", "-1"};
            try {
                appInfo = SceneDetectorEngine.getInstance().getAppInfo(str);
            } catch (Exception e4) {
                AlphaMeLogger.exceptionLog("collect app event error", e4);
            }
            Log.i(TAG, "NAC_BROADCAST pkg=" + str + " event=" + str4);
            ActionManager.getInstance().broadcast("APP_EVENT", new String[]{str, str4, str3, String.valueOf(i5), appInfo[0], appInfo[1], String.valueOf(false), String.valueOf(i4), String.valueOf(true), String.valueOf(i8)});
            if ("resume".equals(str4) && shouldTrackUsageResume(str)) {
                getWorkerHandler().post(new RunnableC0428g(i7, System.currentTimeMillis(), str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onProcessStateChange(String str, String str2, Bundle bundle) {
        if (str == null || str2 == null || bundle == null) {
            return;
        }
        AppEventMonitor.dispatchProcessStateChange(str, str2, bundle);
        if ("died".equals(bundle.getString("state", null))) {
            ActionManager.getInstance().broadcast(LocalConsts.ACTION_APP_DIED, Integer.valueOf(bundle.getInt(MapBundleKey.MapObjKey.OBJ_SS_ARROW_PANOID, 0)));
        }
    }

    private static boolean shouldTrackUsageResume(String str) {
        return (TextUtils.isEmpty(str) || QuickAppHelper.isQuickApp(str) || PredictManager.isPayment(str) || SceneDetectorEngine.isScreenOff(str) || SceneDetectorEngine.isScreenLocked(str)) ? false : true;
    }
}
