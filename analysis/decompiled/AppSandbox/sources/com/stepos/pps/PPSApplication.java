package com.stepos.pps;

import android.app.Application;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import com.stepos.pps.common.ThreadPool;
import com.stepos.pps.common.Utils;
import com.stepos.pps.data.ouc.ErrorManager;
import com.stepos.pps.data.ouc.cloud.CloudUserConfigManager;
import com.stepos.pps.data.stats.helper.exceptioncode.ExCodeStatsCollector;
import com.stepos.pps.data.systemusage.SystemUsageManager;
import com.stepos.pps.data.util.DataFinderHelper;
import com.stepos.pps.data.util.DeviceUtils;
import com.stepos.pps.logpull.LogCollectionGate;
import com.stepos.pps.logpull.LogPullPoller;
import com.stepos.pps.push.DataSyncManager;
import com.stepos.stability.ExceptionManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class PPSApplication extends Application {
    private static PPSApplication INSTANCE;
    private CloudUserConfigManager mCloudUserConfigManager;
    private ExCodeStatsCollector mExCodeStatsCollector;
    private ExceptionManager mExceptionManager;
    private LogPullPoller mLogPullPoller;
    private ErrorManager mOucErrorManager;
    private ContentObserver mProvisionObserver;
    private SystemUsageManager mSystemUsageManager;
    private String TAG = "PPSApplication";
    private final AtomicBoolean mInited = new AtomicBoolean(false);

    public static synchronized PPSApplication getInstance() {
        return INSTANCE;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        if (!isMainProcess()) {
            Log.d(this.TAG, "onCreate in non-main process, skip sandbox init");
        } else if (Utils.isSetupWizardPrivacyConfirmed(this)) {
            initAfterConsent();
        } else {
            Log.d(this.TAG, "setup wizard not completed, defer all collection/report init");
            registerConsentObserver();
        }
    }

    private boolean isMainProcess() throws IOException {
        String strCurrentProcessName = currentProcessName();
        return strCurrentProcessName == null || strCurrentProcessName.equals(getPackageName());
    }

    private static String currentProcessName() throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/self/cmdline"));
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return null;
                }
                int iIndexOf = line.indexOf(0);
                if (iIndexOf >= 0) {
                    line = line.substring(0, iIndexOf);
                }
                String strTrim = line.trim();
                bufferedReader.close();
                return strTrim;
            } finally {
            }
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAfterConsent() {
        if (this.mInited.compareAndSet(false, true)) {
            Log.d(this.TAG, "initAfterConsent: setup wizard completed, start collection & report");
            LogCollectionGate.init(new AnonymousClass1());
            DataSyncManager.getInstance();
            this.mExceptionManager = new ExceptionManager(this);
            this.mExCodeStatsCollector = new ExCodeStatsCollector(this);
            this.mOucErrorManager = new ErrorManager(this);
            ThreadPool.getInstance().execute(new Runnable() { // from class: com.stepos.pps.PPSApplication$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws IllegalAccessException, IllegalArgumentException {
                    Utils.checkAndSendUninstallNotification(PPSApplication.INSTANCE);
                }
            });
            DataFinderHelper.init(this);
            startSystemEventService();
            this.mSystemUsageManager = new SystemUsageManager(this);
            CloudUserConfigManager cloudUserConfigManager = new CloudUserConfigManager(this);
            this.mCloudUserConfigManager = cloudUserConfigManager;
            cloudUserConfigManager.init();
            LogCollectionGate.sync(this, false);
            ThreadPool.getInstance().execute(new Runnable() { // from class: com.stepos.pps.PPSApplication$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$initAfterConsent$1();
                }
            });
        }
    }

    /* renamed from: com.stepos.pps.PPSApplication$1, reason: invalid class name */
    class AnonymousClass1 implements LogCollectionGate.Controller {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLogPullEnabled$0() {
            PPSApplication.this.ensureLogPullPollerStarted();
        }

        @Override // com.stepos.pps.logpull.LogCollectionGate.Controller
        public void onLogPullEnabled() {
            ThreadPool.getInstance().execute(new Runnable() { // from class: com.stepos.pps.PPSApplication$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onLogPullEnabled$0();
                }
            });
        }

        @Override // com.stepos.pps.logpull.LogCollectionGate.Controller
        public void onLogPullDisabled(String str) {
            PPSApplication.this.stopLogPullPoller(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initAfterConsent$1() {
        if (!LogCollectionGate.isLogPullAllowed(this)) {
            Log.d(this.TAG, "LogPull gated: OUC off or mp ceiling");
        } else {
            ensureLogPullPollerStarted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureLogPullPollerStarted() {
        if (LogCollectionGate.isLogPullAllowed(this)) {
            String deviceId = DeviceUtils.getDeviceId();
            if (deviceId == null || deviceId.isEmpty()) {
                Log.w(this.TAG, "LogPull skip: empty oaid");
                return;
            }
            LogPullPoller logPullPoller = this.mLogPullPoller;
            if (logPullPoller != null) {
                logPullPoller.forceCheck();
                return;
            }
            LogPullPoller logPullPoller2 = new LogPullPoller(this);
            this.mLogPullPoller = logPullPoller2;
            logPullPoller2.start(deviceId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLogPullPoller(String str) {
        LogPullPoller logPullPoller = this.mLogPullPoller;
        if (logPullPoller == null) {
            return;
        }
        logPullPoller.abortAllForGateClosed(str);
        this.mLogPullPoller.stop();
        this.mLogPullPoller = null;
    }

    private void registerConsentObserver() {
        this.mProvisionObserver = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.stepos.pps.PPSApplication.2
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                if (Utils.isSetupWizardPrivacyConfirmed(PPSApplication.this)) {
                    if (PPSApplication.this.mProvisionObserver != null) {
                        PPSApplication.this.getContentResolver().unregisterContentObserver(PPSApplication.this.mProvisionObserver);
                        PPSApplication.this.mProvisionObserver = null;
                    }
                    PPSApplication.this.initAfterConsent();
                }
            }
        };
        getContentResolver().registerContentObserver(Settings.Global.getUriFor("device_provisioned"), false, this.mProvisionObserver);
    }

    public LogPullPoller getLogPullPoller() {
        return this.mLogPullPoller;
    }

    public ExCodeStatsCollector getExCodeStatsCollector() {
        ExCodeStatsCollector exCodeStatsCollector = this.mExCodeStatsCollector;
        return exCodeStatsCollector != null ? exCodeStatsCollector : new ExCodeStatsCollector(this);
    }

    public void onUserTypeChanged() {
        ErrorManager errorManager = this.mOucErrorManager;
        if (errorManager != null) {
            errorManager.onUserTypeChanged();
        }
        ExCodeStatsCollector exCodeStatsCollector = this.mExCodeStatsCollector;
        if (exCodeStatsCollector != null) {
            exCodeStatsCollector.onUserTypeChanged();
        }
    }

    private void startSystemEventService() {
        try {
            Intent intent = new Intent(this, (Class<?>) SystemEventService.class);
            intent.setAction("com.stepos.pps.action.KEEP_ALIVE_SERVICE");
            startService(intent);
            Log.d(this.TAG, "SystemEventService started successfully");
        } catch (Exception e) {
            Log.e(this.TAG, "Failed to start SystemEventService: " + e.getMessage());
        }
    }
}
