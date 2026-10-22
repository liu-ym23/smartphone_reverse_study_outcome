package com.android.server.location;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.Settings;
import com.obric.cae.libs.cldReport.ICldReportCallback;
import com.obric.cae.libs.cldReport.ICldReportManager;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class LocationCldReport {
    private static final int GET_SERVER_INTERVAL_MS = 1000;
    private static final int GET_SERVER_MAX_RETRY = 500;
    private static final String GNSS_ERR_CODE = "gnss_err_code";
    private static final String SERVICE_NAME_CLD_REPORT = "cae_cld_report";
    private static final String TAG = null;
    private static LocationCldReport sInstance;
    private final ICldReportCallback.Stub mCallback;
    private ICldReportManager mCldReportManager;
    private Context mContext;
    private final AtomicBoolean mIsCollecting;
    private final AtomicBoolean mNfwChecking;
    private final AtomicInteger mNfwReqNum;

    public static /* synthetic */ void $r8$lambda$MOYK7R5jV6mrhld3mK0rOpdHKUk(LocationCldReport r0) {
        r0.lambda$addNfwRequestNum$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCldReportManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ICldReportManager m5133$$Nest$fgetmCldReportManager(LocationCldReport r0) {
        return r0.mCldReportManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m5134$$Nest$fgetmContext(LocationCldReport r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCldReportManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5135$$Nest$fputmCldReportManager(LocationCldReport r0, ICldReportManager r1) {
        r0.mCldReportManager = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleGnssErrorEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5136$$Nest$mhandleGnssErrorEvent(LocationCldReport r0, int r1, int r2, int r3, String r4) {
        r0.handleGnssErrorEvent(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mretryGetServiceThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5137$$Nest$mretryGetServiceThread(LocationCldReport r0) {
        r0.retryGetServiceThread();
    }

    /* JADX INFO: renamed from: -$$Nest$msetBinderDeath, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5138$$Nest$msetBinderDeath(LocationCldReport r0) {
        r0.setBinderDeath();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5139$$Nest$sfgetTAG() {
        return TAG;
    }

    public LocationCldReport() {
        this.mNfwReqNum = new AtomicInteger(0);
        this.mNfwChecking = new AtomicBoolean(false);
        this.mIsCollecting = new AtomicBoolean(false);
        this.mCallback = new AnonymousClass4(this);
    }

    static {
        TAG = LocationCldReport.class.getSimpleName();
    }

    public static synchronized LocationCldReport getInstance() {
        monitor-enter(LocationCldReport.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        sInstance = new LocationCldReport();     // Catch: Throwable -> L7
    L9:
        LocationCldReport r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(LocationCldReport.class);
        return r1;
    }

    public void initCldReport(Context context) {
        this.mContext = context;
        retryGetServiceThread();
        Settings.Global.putInt(this.mContext.getContentResolver(), GNSS_ERR_CODE, 0);
        final Handler r4 = null;
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor(GNSS_ERR_CODE), false, new AnonymousClass1(this, r4));
    }

    public void addNfwRequestNum() {
        StarLocation.getInstance().logi(TAG, "addNfwRequestNum: " + this.mNfwReqNum.incrementAndGet());
        if (this.mNfwChecking.get() == true) goto L6;
        this.mNfwChecking.set(true);
        new Thread(new LocationCldReport$$ExternalSyntheticLambda0(this)).start();
        return;
    }

    private /* synthetic */ void lambda$addNfwRequestNum$0() {
        int initialNum = this.mNfwReqNum.get();
        Thread.sleep(60000);     // Catch: InterruptedException -> L5
    L7:
        this.mNfwChecking.set(false);
        if (StarLocation.getInstance().isNetworkValid() == true) goto L11;
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "Network invalid, skip NFW check");
        return;
    L11:
        StarLocation.getInstance().logi(TAG, "NFW request check completed: " + this.mNfwReqNum.get() + ", initialNum: " + initialNum);
        if ((this.mNfwReqNum.get() - initialNum) < 5) goto L17;
        handleGnssErrorEvent(4, 0, 0, "Continuous Gnss NFW Request");
        return;
    L17:
        return;
    L5:
        e = move-exception;
        StarLocation.getInstance().loge(TAG, "NFW request sleep interrupted: " + e);
        goto L7
    }

    private void handleGnssErrorEvent(int errCode, int reason, int subReason, String info) {
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "handle Gnss Error Event: " + errCode + " reason: " + reason + " subReason: " + subReason + " info: " + info);
        switch(errCode) {
            case 4: goto L5;
            default: goto L7;
        };
    L5:
        reportErrorEvent(3, 4, reason, subReason, info);
        return;
    }

    private void retryGetServiceThread() {
        new AnonymousClass2(this).start();
    }

    private void setBinderDeath() {
        this.mCldReportManager.asBinder().linkToDeath(new AnonymousClass3(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        StarLocation.getInstance().loge(TAG, "mCldReportManager linkToDeath! :" + e);
    }

    public void reportErrorEvent(int moduleType, int errCode, int reason, int subReason, String info) {
        if (this.mCldReportManager != null) goto L17;
        return;
    L17:
        this.mCldReportManager.reportErrorEvent(moduleType, errCode, reason, subReason, info);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        RemoteException e = e;
    L13:
        StarLocation.getInstance().loge(TAG, "reportErrorEvent error: " + e);
        return;
    L11:
        e = move-exception;
        e = e;
        goto L13
    }

    public void startCollect(int moduleType, int errCode, int reason, int subReason, String info, boolean isNeedUpload) {
        if (this.mCldReportManager != null) goto L10;
        return;
    L10:
        StarLocation.getInstance().logi(TAG, "startCollect mCallback = " + this.mCallback);     // Catch: RemoteException -> L7
        this.mCldReportManager.startCollect(this.mCallback, moduleType, errCode, reason, subReason, info, isNeedUpload);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        StarLocation.getInstance().loge(TAG, "startCollect error: " + e);
    }

    public void stopCollect(int moduleType, int errCode) {
        if (this.mCldReportManager != null) goto L10;
        return;
    L10:
        StarLocation.getInstance().logi(TAG, "stopCollect mCallback = " + this.mCallback);     // Catch: RemoteException -> L7
        this.mCldReportManager.stopCollect(this.mCallback, moduleType, errCode);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        StarLocation.getInstance().loge(TAG, "stopCollect error: " + e);
    }
}
