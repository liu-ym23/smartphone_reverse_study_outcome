package com.uxsense.ruleTrigger;

import I4.l;
import android.app.ActivityManager;
import android.app.IActivityManager;
import android.app.IProcessObserver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import com.uxsense.constants.ApexRequestConstants;
import com.uxsense.ruleTrigger.ApexTriggerManager;
import com.uxsense.ruleTrigger.IRuleCallback;
import com.uxsense.ruleTrigger.framework.ApexFrameworkBridgeFactory;
import com.uxsense.ruleTrigger.model.TriggerEvent;
import com.uxsense.ruleTrigger.thirdparty.TriggerMain;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

/* loaded from: classes3.dex */
public class ApexTriggerManager {
    private static final boolean DEBUG_PROCESS = false;
    private static final String TAG = "ApexTriggerManager";
    private static volatile ApexTriggerManager sInstance;
    private static volatile OnTriggerEventListener sOnTriggerEventListener;
    private IActivityManager mAMS;
    private Context mContext;
    private final List<PkgCallbackData> mPkgCallbackList = new ArrayList();
    private boolean isProcessObserverInit = false;
    private final IProcessObserver mProcessObserver = new AnonymousClass1();
    private final ScheduledExecutorService mBackgroundExecutor = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: com.uxsense.ruleTrigger.ApexTriggerManager$1, reason: invalid class name */
    public class AnonymousClass1 extends IProcessObserver.Stub {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onForegroundActivitiesChanged$0(int i, int i6, boolean z10) {
            ApexTriggerManager.this.onForegroundActivitiesChanged(i, i6, z10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onProcessDied$1(int i, int i6) {
            ApexTriggerManager.this.onProcessDied(i, i6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onProcessStarted$2(int i, int i6, int i10, String str, String str2) {
            ApexTriggerManager.this.onProcessStarted(i, i6, i10, str, str2);
        }

        public void onForegroundActivitiesChanged(final int i, final int i6, final boolean z10) {
            ApexTriggerManager.this.mBackgroundExecutor.execute(new Runnable() { // from class: com.uxsense.ruleTrigger.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4211a.lambda$onForegroundActivitiesChanged$0(i, i6, z10);
                }
            });
        }

        public void onForegroundServicesChanged(int i, int i6, int i10) {
        }

        public void onProcessDied(final int i, final int i6) {
            ApexTriggerManager.this.mBackgroundExecutor.execute(new Runnable() { // from class: com.uxsense.ruleTrigger.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4212a.lambda$onProcessDied$1(i, i6);
                }
            });
        }

        public void onProcessStarted(final int i, final int i6, final int i10, final String str, final String str2) {
            ApexTriggerManager.this.mBackgroundExecutor.execute(new Runnable() { // from class: com.uxsense.ruleTrigger.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4213a.lambda$onProcessStarted$2(i, i6, i10, str, str2);
                }
            });
        }
    }

    public interface OnTriggerEventListener {
        void onTriggerEvent(int i, @Nullable Intent intent);
    }

    public static class PkgCallbackData {
        IRuleCallback callback;
        String packageName;
        int pid;

        public PkgCallbackData(int i, String str, IRuleCallback iRuleCallback) {
            this.pid = i;
            this.packageName = str;
            this.callback = iRuleCallback;
        }
    }

    public static class RuleCallback extends IRuleCallback.Stub {
        @Override // com.uxsense.ruleTrigger.IRuleCallback
        public void onTriggerEvent(int i, Intent intent) {
            if (intent == null || intent.getExtras() == null) {
                Log.i(ApexTriggerManager.TAG, "onTriggerEvent: resultCode=" + i + ", resultIntent=" + intent);
            } else {
                Bundle extras = intent.getExtras();
                int intExtra = intent.getIntExtra("apex.event", -1);
                StringBuilder sbU = B7.a.u(i, "onTriggerEvent: resultCode=", ", event=");
                sbU.append(TriggerEvent.name(intExtra));
                Bundle bundle = extras.getBundle("apex.extras");
                if (bundle != null) {
                    sbU.append(", {");
                    for (String str : bundle.keySet()) {
                        sbU.append(str);
                        sbU.append('=');
                        sbU.append(bundle.get(str));
                        sbU.append(", ");
                    }
                    sbU.append('}');
                }
                String stringExtra = intent.getStringExtra("targetWindowTitle");
                if (stringExtra != null) {
                    sbU.append(", windowTitle=");
                    sbU.append(stringExtra);
                }
                Log.i(ApexTriggerManager.TAG, sbU.toString());
            }
            OnTriggerEventListener onTriggerEventListener = ApexTriggerManager.sOnTriggerEventListener;
            if (onTriggerEventListener != null) {
                onTriggerEventListener.onTriggerEvent(i, intent);
            }
        }

        @Override // com.uxsense.ruleTrigger.IRuleCallback
        public List<TriggerRule> requestRules(String str, String str2) {
            Log.d(ApexTriggerManager.TAG, "requestRules, pkgName=" + str + ", appVersion=" + str2);
            List<TriggerRule> rulesByPackage = TriggerRuleParse.getRulesByPackage(str, str2);
            Log.d(ApexTriggerManager.TAG, "requestRules, found " + rulesByPackage.size() + " rules for " + str);
            return rulesByPackage;
        }
    }

    private ApexTriggerManager() {
    }

    private void dispatchProcessDied(PkgCallbackData pkgCallbackData, int i, int i6) {
        OnTriggerEventListener onTriggerEventListener = sOnTriggerEventListener;
        if (onTriggerEventListener == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("apex.event", 300);
        intent.putExtra("apex.package", pkgCallbackData.packageName);
        intent.putExtra(ApexRequestConstants.TRIGGER_PROCESS_PID_KEY, i);
        intent.putExtra(ApexRequestConstants.TRIGGER_PROCESS_UID_KEY, i6);
        intent.putExtra("apex.timestamp", System.currentTimeMillis());
        String str = TAG;
        StringBuilder sb = new StringBuilder("dispatchProcessDied: pkg=");
        androidx.compose.foundation.b.B(sb, pkgCallbackData.packageName, ", pid=", i, ", uid=");
        sb.append(i6);
        Log.i(str, sb.toString());
        try {
            onTriggerEventListener.onTriggerEvent(0, intent);
        } catch (Exception e) {
            Log.e(TAG, "dispatchProcessDied failed: pkg=" + pkgCallbackData.packageName + ", pid=" + i, e);
        }
    }

    private Bundle generateBasicBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("targetDexPackage", this.mContext.getPackageName());
        bundle.putString("targetDexClass", TriggerMain.class.getName());
        bundle.putString("targetDexMethod", "handleRequestRules");
        bundle.putString("targetDexTriggerEventMethod", "handleTriggerEvent");
        return bundle;
    }

    private IActivityManager getAMS() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.mAMS == null) {
            try {
                this.mAMS = (IActivityManager) Class.forName("android.app.ActivityManager").getMethod("getService", null).invoke(null, null);
            } catch (Exception e) {
                Log.e(TAG, "getAMS: failed to get IActivityManager", e);
            }
        }
        return this.mAMS;
    }

    public static ApexTriggerManager getInstance() {
        if (sInstance == null) {
            synchronized (ApexTriggerManager.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new ApexTriggerManager();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    private static boolean isWatchedProcess(String str) {
        return WatchProcessConfig.INSTANCE.isWatchedProcess(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$onProcessDied$1(int i, PkgCallbackData pkgCallbackData) {
        return pkgCallbackData.pid == i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onProcessStarted$2(int i, String str) {
        performSetApexService(i, str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$performSetApexService$3(int i, PkgCallbackData pkgCallbackData) {
        return pkgCallbackData.pid == i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$pushRulesToApp$4(String str, PkgCallbackData pkgCallbackData) {
        return !str.equals(pkgCallbackData.packageName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pushRulesToApp$5(final String str) {
        ArrayList arrayList = new ArrayList(this.mPkgCallbackList);
        if (str != null) {
            arrayList.removeIf(new Predicate() { // from class: com.uxsense.ruleTrigger.d
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ApexTriggerManager.lambda$pushRulesToApp$4(str, (ApexTriggerManager.PkgCallbackData) obj);
                }
            });
        }
        if (arrayList.isEmpty()) {
            Log.d(TAG, "pushRulesToApp: no tracked process for pkg=" + str);
            return;
        }
        Log.d(TAG, "pushRulesToApp: re-injecting rules to " + arrayList.size() + " process(es) for pkg=" + str);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            PkgCallbackData pkgCallbackData = (PkgCallbackData) it.next();
            performSetApexService(pkgCallbackData.pid, pkgCallbackData.packageName, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$restoreExistingProcesses$0(int i, String str) {
        performSetApexService(i, str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onForegroundActivitiesChanged(int i, int i6, boolean z10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProcessDied(int i, int i6) {
        PkgCallbackData next;
        Iterator<PkgCallbackData> it = this.mPkgCallbackList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (next.pid == i) {
                    break;
                }
            }
        }
        if (this.mPkgCallbackList.removeIf(new c(i, 1))) {
            androidx.constraintlayout.core.dsl.a.p(i, "onProcessDied: Removed callback for pid=", TAG);
        }
        if (next != null) {
            dispatchProcessDied(next, i, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProcessStarted(int i, int i6, int i10, String str, String str2) {
        if (isWatchedProcess(str2)) {
            Log.d(TAG, "onProcessStarted: scheduling performSetApexService for pkg=" + str + " pid=" + i);
            this.mBackgroundExecutor.schedule(new a(this, i, str, 0), 500L, TimeUnit.MILLISECONDS);
        }
    }

    private void performSetApexService(int i, String str, String str2) {
        this.mPkgCallbackList.removeIf(new c(i, 0));
        RuleCallback ruleCallback = new RuleCallback();
        this.mPkgCallbackList.add(new PkgCallbackData(i, str, ruleCallback));
        Intent intent = new Intent();
        Bundle bundleGenerateBasicBundle = generateBasicBundle();
        bundleGenerateBasicBundle.putString("targetFindPackage", str);
        bundleGenerateBasicBundle.putInt("performReflectPackagePid", i);
        bundleGenerateBasicBundle.putString("targetAppVersion", str2);
        bundleGenerateBasicBundle.putBinder("targetDexBinder", ruleCallback.asBinder());
        int[] iArrUnionAllEvents = TriggerRuleParse.unionAllEvents(str);
        bundleGenerateBasicBundle.putIntArray("apex.subscribedEvents", iArrUnionAllEvents);
        intent.putExtras(bundleGenerateBasicBundle);
        try {
            ApexFrameworkBridgeFactory.get().setApexService(intent);
            Log.d(TAG, "performSetApexService: pkg=" + str + " pid=" + i + ", bridge=" + ApexFrameworkBridgeFactory.get().getClass().getSimpleName() + ", subscribedEvents=" + Arrays.toString(iArrUnionAllEvents) + ", callbacksTotal=" + this.mPkgCallbackList.size());
        } catch (Exception e) {
            String str3 = TAG;
            StringBuilder sbT = androidx.appfunctions.metadata.a.t(i, "performSetApexService failed: pkg=", str, " pid=", ", bridge=");
            sbT.append(ApexFrameworkBridgeFactory.get().getClass().getSimpleName());
            sbT.append(", extras keys=");
            sbT.append(bundleGenerateBasicBundle.keySet());
            sbT.append(", subscribedEvents=");
            sbT.append(Arrays.toString(iArrUnionAllEvents));
            Log.e(str3, sbT.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreExistingProcesses() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        IActivityManager ams = getAMS();
        if (ams == null) {
            Log.w(TAG, "restoreExistingProcesses: AMS unavailable, skip");
            return;
        }
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ams.getRunningAppProcesses();
            if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
                return;
            }
            int i = 0;
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (isWatchedProcess(runningAppProcessInfo.processName)) {
                    int i6 = runningAppProcessInfo.pid;
                    String str = runningAppProcessInfo.processName;
                    Log.d(TAG, "restoreExistingProcesses: re-inject " + str + " pid=" + i6);
                    this.mBackgroundExecutor.schedule(new a(this, i6, str, 1), 500L, TimeUnit.MILLISECONDS);
                    i++;
                }
            }
            androidx.constraintlayout.core.dsl.a.p(i, "restoreExistingProcesses: total re-injected=", TAG);
        } catch (RemoteException e) {
            Log.w(TAG, "restoreExistingProcesses: getRunningAppProcesses failed", e);
        }
    }

    public static void setOnTriggerEventListener(@Nullable OnTriggerEventListener onTriggerEventListener) {
        sOnTriggerEventListener = onTriggerEventListener;
    }

    public void init(Context context) {
        String str = TAG;
        Log.d(str, "init...");
        this.mContext = context;
        WatchProcessConfig.INSTANCE.init(context.getApplicationContext());
        TriggerRuleParse.init(context.getApplicationContext());
        if (!this.isProcessObserverInit) {
            Log.d(str, "init, registerProcessObserver");
            this.isProcessObserverInit = true;
            try {
                getAMS().registerProcessObserver(this.mProcessObserver);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to register process observer", e);
            }
        }
        this.mBackgroundExecutor.execute(new b(this));
    }

    public void onWatchProcessesUpdated() {
        this.mBackgroundExecutor.execute(new b(this));
    }

    public void pushRulesToApp(@Nullable String str) {
        this.mBackgroundExecutor.execute(new l(15, this, str));
    }

    public void release() {
        String str = TAG;
        Log.d(str, "release...");
        this.mPkgCallbackList.clear();
        if (this.isProcessObserverInit) {
            Log.d(str, "release, unregisterProcessObserver");
            try {
                getAMS().unregisterProcessObserver(this.mProcessObserver);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to unregister process observer", e);
            }
        }
    }
}
