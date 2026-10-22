package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class RetrySchedulerImpl implements Handler.Callback, AppStatusManager.AppStatusChangeListener {
    private static final int MIN_INTERVAL_MS = 3000;
    private static final int MIN_INTERVAL_MS_ACCELERATION = 5000;
    public static final int RETRY_SCHEDULE_NORMAL = 1;
    public static final int RETRY_SCHEDULE_WHEN_APP_BACKGROUND = 3;
    public static final int RETRY_SCHEDULE_WHEN_APP_FOREGROUND = 4;
    public static final int RETRY_SCHEDULE_WHEN_OTHER_CONNECTED = 5;
    public static final int RETRY_SCHEDULE_WHEN_OTHER_SUCCEED = 2;
    private static final int SCHEDULE_ALL_TASK_RETRY_DELAY = 2000;
    private static final int SCHEDULE_ALL_TASK_RETRY_MIN_INTERVAL = 10000;
    private static final String TAG = "RetryScheduler";
    private static volatile RetrySchedulerImpl sInstance;
    private static RetryScheduler.RetryScheduleHandler sRetryScheduleHandler;
    private ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private final Handler mHandler;
    private final boolean mIsDownloaderProcess;
    private long mLastHandleAllTaskTime;
    private final SparseArray<RetryInfo> mRetryInfoList;
    private int mWaitingRetryTasksCount;

    private static class RetryInfo {
        final int[] allowErrorCode;
        final int id;
        final int intervalMs;
        final int intervalMsAcceleration;
        final int level;
        private AtomicInteger mCurrentIntervalMs;
        private boolean mIsWaitingRetry;
        private AtomicLong mLastRetryTime;
        private boolean mNeedWifi;
        private AtomicInteger mRetryCount;
        final int maxCount;
        final boolean useJobScheduler;

        static /* synthetic */ AtomicInteger access$300(RetryInfo r0) {
            return r0.mRetryCount;
        }

        static /* synthetic */ boolean access$402(RetryInfo r0, boolean r1) {
            r0.mNeedWifi = r1;
            return r1;
        }

        static /* synthetic */ boolean access$500(RetryInfo r0) {
            return r0.mIsWaitingRetry;
        }

        static /* synthetic */ boolean access$502(RetryInfo r0, boolean r1) {
            r0.mIsWaitingRetry = r1;
            return r1;
        }

        RetryInfo(int r2, int r3, int r4, int r5, int r6, boolean r7, int[] r8) {
            if (r5 >= 3000) goto L6;
            r5 = 3000;
        L6:
            if (r6 >= 5000) goto L8;
            r6 = 5000;
        L8:
            this.id = r2;
            this.level = r3;
            this.maxCount = r4;
            this.intervalMs = r5;
            this.intervalMsAcceleration = r6;
            this.useJobScheduler = r7;
            this.allowErrorCode = r8;
            this.mCurrentIntervalMs = new AtomicInteger(r5);
            this.mLastRetryTime = new AtomicLong(0);
            this.mRetryCount = new AtomicInteger(0);
        }

        boolean canRetry(long r3, int r5, int r6, boolean r7) {
            if (this.mIsWaitingRetry == true) goto L9;
            if (Logger.debug() == false) goto L7;
            Logger.taskDebug(RetrySchedulerImpl.TAG, this.id, "canRetry", "IsWaitingRetry is false, return false");
        L7:
            return false;
        L9:
            if (this.level >= r5) goto L12;
            return false;
        L12:
            if (this.mRetryCount.get() < this.maxCount) goto L15;
            return false;
        L15:
            if (this.mNeedWifi == true) goto L17;
        L19:
            if (r7 == false) goto L21;
            return true;
        L21:
            if ((r3 - this.mLastRetryTime.get()) >= this.intervalMs) goto L25;
            return false;
        L25:
            return true;
        L17:
            if (r6 == 2) goto L19;
            return false;
        }

        void increaseRetryInterval() {
            this.mCurrentIntervalMs.addAndGet(this.intervalMsAcceleration);
        }

        void updateRetryTimeStamp(long r1) {
            this.mLastRetryTime.set(r1);
        }

        void increaseRetryCount() {
            this.mRetryCount.incrementAndGet();
        }

        void resetRetryInterval() {
            this.mCurrentIntervalMs.set(this.intervalMs);
        }

        int getCurrentRetryIntervalMs() {
            return this.mCurrentIntervalMs.get();
        }
    }

    static /* synthetic */ Context access$000(RetrySchedulerImpl r0) {
        return r0.mContext;
    }

    static /* synthetic */ ConnectivityManager access$100(RetrySchedulerImpl r0) {
        return r0.mConnectivityManager;
    }

    static /* synthetic */ ConnectivityManager access$102(RetrySchedulerImpl r0, ConnectivityManager r1) {
        r0.mConnectivityManager = r1;
        return r1;
    }

    static /* synthetic */ void access$200(RetrySchedulerImpl r0, int r1, boolean r2) {
        r0.scheduleAllTaskRetry(r1, r2);
    }

    static /* synthetic */ int access$600(RetrySchedulerImpl r0) {
        return r0.mWaitingRetryTasksCount;
    }

    static /* synthetic */ int access$700(RetrySchedulerImpl r0) {
        return r0.getNetWorkType();
    }

    static /* synthetic */ SparseArray access$800(RetrySchedulerImpl r0) {
        return r0.mRetryInfoList;
    }

    static /* synthetic */ void access$900(RetrySchedulerImpl r0, int r1, int r2, boolean r3) {
        r0.doSchedulerRetryInSubThread(r1, r2, r3);
    }

    private RetrySchedulerImpl() {
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        this.mRetryInfoList = new SparseArray();
        this.mWaitingRetryTasksCount = 0;
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        registerNetworkCallback();
        this.mIsDownloaderProcess = DownloadHelper.isDownloaderProcess();
        AppStatusManager.getInstance().registerAppSwitchListener(this);
    }

    public static RetrySchedulerImpl getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(RetrySchedulerImpl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new RetrySchedulerImpl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(RetrySchedulerImpl.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public static void setRetryScheduleHandler(RetryScheduler.RetryScheduleHandler r2) {
        sRetryScheduleHandler = (RetryScheduler.RetryScheduleHandler) ZeusTransformUtils.wrapperContextForParams(r2, RetryScheduler.RetryScheduleHandler.class, "com.obric.aiagent.plugin");
    }

    private void registerNetworkCallback() {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.USE_NETWORK_CALLBACK, 0) == 1) goto L5;
        return;
    L5:
        DownloadComponentManager.getCPUThreadExecutor().execute(new AnonymousClass1(this));
    }

    public void tryStartScheduleRetry(DownloadInfo r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(DownloadConstants.MIME_APK) == false) goto L6;
        return;
    L6:
        if (DownloadConstants.MIME_APK.equals(r3.getMimeType()) == true) goto L9;
        return;
    L9:
        if (r3.isOnlyWifi() == false) goto L11;
    L14:
        boolean r0 = true;
    L15:
        tryStartScheduleRetry(r3, r0, getNetWorkType());
        return;
    L11:
        if (r3.isPauseReserveOnWifi() == true) goto L14;
        r0 = false;
        goto L15
    }

    private void tryStartScheduleRetry(DownloadInfo r10, boolean r11, int r12) {
        BaseException r0 = r10.getFailedException();
        if (r0 != null) goto L5;
        return;
    L5:
        RetryInfo r1 = obtainRetryInfo(r10.getId());
        if (RetryInfo.access$300(r1).get() > r1.maxCount) goto L8;
        int r2 = r0.getErrorCode();
        if (DownloadUtils.isInsufficientSpaceError(r0) == false) goto L14;
    L25:
        RetryInfo.access$402(r1, r11);
        SparseArray<RetryInfo> r3 = this.mRetryInfoList;
        monitor-enter(r3);
    L48:
        th = move-exception;
        throw th;
    L28:
        if (RetryInfo.access$500(r1) == true) goto L30;
        RetryInfo.access$502(r1, true);     // Catch: Throwable -> L48
        this.mWaitingRetryTasksCount++;     // Catch: Throwable -> L48
    L30:
        monitor-exit(r3);     // Catch: Throwable -> L48
        int r4 = r1.getCurrentRetryIntervalMs();
        if (Logger.debugScene(r10) == false) goto L35;
        Logger.taskDebug(TAG, r10, "tryStartScheduleRetry", "Id = " + r1.id + ", delayTimeMills = " + r4 + ", mWaitingRetryTasks = " + this.mWaitingRetryTasksCount);
    L35:
        if (r1.useJobScheduler == false) goto L44;
        if (r12 != 0) goto L38;
        r1.resetRetryInterval();
    L38:
        RetryScheduler.RetryScheduleHandler r5 = sRetryScheduleHandler;
        if (r5 == null) goto L42;
        r5.scheduleRetry(r10, r4, r11, r12);
    L42:
        if (this.mIsDownloaderProcess == false) goto L54;
        r1.updateRetryTimeStamp(System.currentTimeMillis());
        r1.increaseRetryCount();
        r1.increaseRetryInterval();
        return;
    L54:
        return;
    L44:
        if (r11 == false) goto L46;
        return;
    L46:
        this.mHandler.removeMessages(r10.getId());
        this.mHandler.sendEmptyMessageDelayed(r10.getId(), r4);
        return;
    L14:
        if (DownloadUtils.isNetworkError(r0) == true) goto L25;
        if (r10.statusInPause() == false) goto L20;
        if (r10.isPauseReserveOnWifi() == true) goto L25;
    L20:
        if (canRetryForAllowErrorCode(r1, r2) == true) goto L23;
        return;
    L23:
        if (Logger.debugScene(r10) == false) goto L25;
        Logger.taskDebug(TAG, r10, "tryStartScheduleRetry", "Allow error code, id = " + r1.id + ", error code = " + r2);
        goto L25
    L8:
        if (Logger.debugScene(r10) == false) goto L53;
        Logger.taskDebug(TAG, r10, "tryStartScheduleRetry", "Id = " + r1.id + ", mRetryCount = " + RetryInfo.access$300(r1) + ", maxCount = " + r1.maxCount);
        return;
    }

    public void tryCancelScheduleRetry(int r5) {
        SparseArray<RetryInfo> r0 = this.mRetryInfoList;
        monitor-enter(r0);
        RetryInfo r1 = (RetryInfo) ZeusTransformUtils.preCheckCast(this.mRetryInfoList.get(r5), RetryInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r1 != null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L9:
        if (RetryInfo.access$500(r1) == false) goto L13;
        RetryInfo.access$502(r1, false);     // Catch: Throwable -> L21
        int r3 = this.mWaitingRetryTasksCount - 1;     // Catch: Throwable -> L21
        this.mWaitingRetryTasksCount = r3;     // Catch: Throwable -> L21
        if (r3 >= 0) goto L13;
        this.mWaitingRetryTasksCount = 0;     // Catch: Throwable -> L21
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L21
        if (r1.useJobScheduler == false) goto L19;
        RetryScheduler.RetryScheduleHandler r4 = sRetryScheduleHandler;
        if (r4 == null) goto L25;
        r4.cancelRetry(r5);
        return;
    L25:
        return;
    L19:
        this.mHandler.removeMessages(r5);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r6) {
        if (r6.what != 0) goto L10;
        int r0 = r6.arg1;
        if (r6.arg2 != 1) goto L7;
        boolean r7 = true;
    L8:
        doScheduleAllTaskRetry(r0, r7);
    L13:
        return true;
    L7:
        r7 = false;
        goto L8
    L10:
        if (Logger.debug() == false) goto L12;
        Logger.taskDebug(TAG, r6.what, "handleMessage", "DoSchedulerRetry");
    L12:
        doSchedulerRetry(r6.what);
        goto L13
    }

    private void scheduleAllTaskRetry(int r7, boolean r8) {
        if (this.mWaitingRetryTasksCount > 0) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        monitor-enter(this);
        if (r8 == false) goto L25;
    L12:
        this.mLastHandleAllTaskTime = r0;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        if (Logger.debug() == false) goto L18;
        Logger.globalDebug(TAG, "scheduleAllTaskRetry", "level = [" + r7 + "], force = [" + r8 + "]");
    L18:
        if (r8 == false) goto L20;
        this.mHandler.removeMessages(0);
    L20:
        Message r1 = Message.obtain();
        r1.what = 0;
        r1.arg1 = r7;
        r1.arg2 = r8 ? 1 : 0;
        this.mHandler.sendMessageDelayed(r1, 2000);
        return;
    L25:
    L22:
        th = move-exception;
        throw th;
    L9:
        if ((r0 - this.mLastHandleAllTaskTime) >= 10000) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L22
    }

    private void doScheduleAllTaskRetry(final int r3, final boolean r4) {
        DownloadComponentManager.getCPUThreadExecutor().execute(new AnonymousClass2(this, r3, r4));
    }

    public void doSchedulerRetry(final int r3) {
        DownloadComponentManager.getCPUThreadExecutor().execute(new AnonymousClass3(this, r3));
    }

    private void doSchedulerRetryInSubThread(int r10, int r11, boolean r12) {
        Context r0 = this.mContext;
        if (r0 != null) goto L5;
        return;
    L5:
        SparseArray<RetryInfo> r1 = this.mRetryInfoList;
        monitor-enter(r1);
        RetryInfo r2 = (RetryInfo) ZeusTransformUtils.preCheckCast(this.mRetryInfoList.get(r10), RetryInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L82
        if (r2 != null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L82
        return;
    L11:
        boolean r4 = true;
        if (RetryInfo.access$500(r2) == false) goto L16;
        RetryInfo.access$502(r2, false);     // Catch: Throwable -> L82
        int r3 = this.mWaitingRetryTasksCount - 1;     // Catch: Throwable -> L82
        this.mWaitingRetryTasksCount = r3;     // Catch: Throwable -> L82
        if (r3 >= 0) goto L16;
        this.mWaitingRetryTasksCount = 0;     // Catch: Throwable -> L82
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L82
        if (Logger.debug() == false) goto L20;
        Logger.taskDebug(TAG, r10, "doSchedulerRetryInSubThread", "RetryCount = " + RetryInfo.access$300(r2) + ", mWaitingRetryTasksCount = " + this.mWaitingRetryTasksCount);
    L20:
        DownloadInfo r5 = Downloader.getInstance(r0).getDownloadInfo(r10);
        if (r5 != null) goto L24;
        removeRetryInfo(r10);
        return;
    L24:
        int r6 = r5.getRealStatus();
        if (r6 != (-3)) goto L27;
    L80:
        removeRetryInfo(r10);
        return;
    L27:
        if (r6 == (-4)) goto L80;
        if (r6 == (-5)) goto L71;
        if (r6 != (-2)) goto L36;
        if (r5.isPauseReserveOnWifi() == true) goto L71;
    L36:
        if (r6 == (-1)) goto L38;
        return;
    L38:
        if (r11 == 0) goto L40;
        boolean r7 = true;
    L44:
        BaseException r8 = r5.getFailedException();
        if (r7 == true) goto L47;
    L49:
        r2.increaseRetryCount();
        if (r7 == true) goto L52;
        if (r12 == false) goto L63;
        r2.increaseRetryInterval();
    L63:
        if (r5.isOnlyWifi() == false) goto L65;
    L68:
        tryStartScheduleRetry(r5, r4, r11);
        return;
    L65:
        if (r5.isPauseReserveOnWifi() == true) goto L68;
        r4 = false;
        goto L68
    L52:
        if (Logger.debug() == false) goto L54;
        Logger.taskDebug(TAG, r10, "doSchedulerRetryInSubThread", "doSchedulerRetry: restart task, ****** id = " + r2.id);
    L54:
        r2.updateRetryTimeStamp(System.currentTimeMillis());
        if (r12 == false) goto L57;
        r2.increaseRetryInterval();
    L57:
        r5.setRetryScheduleCount(RetryInfo.access$300(r2).get());
        if (r5.getStatus() != (-1)) goto L86;
        Downloader.getInstance(r0).restart(r5.getId());
        return;
    L86:
        return;
    L47:
        if (DownloadUtils.isInsufficientSpaceError(r8) == false) goto L49;
        r7 = canRetryWhenInsufficientSpace(r5, r8);
        goto L49
    L40:
        if (r2.useJobScheduler == false) goto L42;
        r7 = false;
        goto L44
    L42:
        return;
    L71:
        if (r6 != (-2)) goto L75;
        IReserveWifiStatusListener r13 = Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getReserveWifiStatusListener();
        if (r13 == null) goto L75;
        r13.onStatusChanged(r5, 4, 3);
    L75:
        IDownloadLaunchHandler r14 = DownloadComponentManager.getDownloadLaunchHandler();
        if (r14 == null) goto L78;
        r14.onLaunchResume(Collections.singletonList(r5), 3);
    L78:
        removeRetryInfo(r10);
        return;
    L82:
        th = move-exception;
        throw th;
    }

    private boolean canRetryForAllowErrorCode(RetryInfo r4, int r5) {
        int[] r3 = r4.allowErrorCode;
        if (r3 != null) goto L5;
    L14:
        return false;
    L5:
        if (r3.length == 0) goto L14;
        int r0 = r3.length;
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L14;
        if (r3[r1] == r5) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        return true;
    }

    private RetryInfo obtainRetryInfo(int r5) {
        RetryInfo r0 = (RetryInfo) ZeusTransformUtils.preCheckCast(this.mRetryInfoList.get(r5), RetryInfo.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L15;
        SparseArray<RetryInfo> r1 = this.mRetryInfoList;
        monitor-enter(r1);
        r0 = (RetryInfo) ZeusTransformUtils.preCheckCast(this.mRetryInfoList.get(r5), RetryInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        if (r0 != null) goto L9;
        r0 = createRetryInfo(r5);     // Catch: Throwable -> L12
    L9:
        this.mRetryInfoList.put(r5, r0);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        return r0;
    }

    private void removeRetryInfo(int r2) {
        SparseArray<RetryInfo> r0 = this.mRetryInfoList;
        monitor-enter(r0);
        this.mRetryInfoList.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private RetryInfo createRetryInfo(int r12) {
        DownloadSetting r0 = DownloadSetting.obtain(r12);
        boolean r2 = false;
        int r5 = r0.optInt(DownloadSettingKeys.RETRY_SCHEDULE, 0);
        JSONObject r1 = r0.optJSONObject(DownloadSettingKeys.RETRY_SCHEDULE_CONFIG);
        int r3 = 60;
        if (r1 == null) goto L12;
        int r4 = r1.optInt(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT, 60);
        int r6 = r1.optInt(DownloadSettingKeys.RetryScheduleConfig.INTERVAL_SEC, 60);
        int r7 = r1.optInt(DownloadSettingKeys.RetryScheduleConfig.INTERVAL_SEC_ACCELERATION, 60);
        if (Build.VERSION.SDK_INT >= 21) goto L7;
    L11:
        int[] r10 = parserAllowErrorCode(r1.optString(DownloadSettingKeys.RetryScheduleConfig.ALLOW_ERROR_CODE));
        int r11 = r7;
        boolean r9 = r2;
        int r8 = r4;
        r3 = r6;
    L14:
        return new RetryInfo(r12, r5, r8, r3 * 1000, r11 * 1000, r9, r10);
    L7:
        if (sRetryScheduleHandler == null) goto L11;
        if (r1.optInt(DownloadSettingKeys.RetryScheduleConfig.USE_JOB_SCHEDULER, 0) != 1) goto L11;
        r2 = true;
        goto L11
    L12:
        r10 = null;
        r11 = 60;
        r8 = 60;
        r9 = false;
        goto L14
    }

    private int[] parserAllowErrorCode(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L15;
        return null;
    L15:
        String[] r3 = r4.split(",");     // Catch: Throwable -> L14
        if (r3.length > 0) goto L8;
        return null;
    L8:
        int[] r5 = new int[r3.length];     // Catch: Throwable -> L14
        int r1 = 0;
    L10:
        if (r1 >= r3.length) goto L13;
        r5[r1] = Integer.parseInt(r3[r1]);     // Catch: Throwable -> L14
        r1 = r1 + 1;
        goto L10
    L13:
        return r5;
    L14:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        scheduleAllTaskRetry(4, false);
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
        scheduleAllTaskRetry(3, false);
    }

    public void scheduleRetryWhenHasTaskSucceed() {
        scheduleAllTaskRetry(2, true);
    }

    public void scheduleRetryWhenHasTaskConnected() {
        scheduleAllTaskRetry(5, false);
    }

    private int getNetWorkType() {
        if (this.mConnectivityManager != null) goto L6;
        this.mConnectivityManager = (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mContext.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
    L6:
        NetworkInfo r4 = this.mConnectivityManager.getActiveNetworkInfo();     // Catch: Exception -> L18
        if (r4 == null) goto L17;
        if (r4.isConnected() == false) goto L17;
        if (r4.getType() != 1) goto L16;
        return 2;
    L16:
        return 1;
    L17:
        return 0;
    }

    private boolean canRetryWhenInsufficientSpace(DownloadInfo r11, BaseException r12) {
        long r2 = DownloadUtils.getAvailableSpaceBytes(r11.getTempPath());     // Catch: BaseException -> L5
    L8:
        if (ZeusTransformUtils.instanceOf(r12, DownloadOutOfSpaceException.class) == false) goto L10;
        long r4 = ((DownloadOutOfSpaceException) ZeusTransformUtils.preCheckCast(r12, DownloadOutOfSpaceException.class, "com.obric.aiagent.plugin")).getRequiredSpaceBytes();
    L12:
        if (r2 >= r4) goto L39;
        DownloadSetting r10 = DownloadSetting.obtain(r11.getId());
        if (r10.optInt(DownloadSettingKeys.SPACE_FILL_PART_DOWNLOAD, 0) == 1) goto L16;
    L38:
        return false;
    L16:
        if (r2 <= 0) goto L37;
        int r13 = r10.optInt(DownloadSettingKeys.SPACE_FILL_MIN_KEEP_MB, 100);
        if (r13 <= 0) goto L39;
        long r3 = r2 - (((long) r13) * 1048576);
        if (Logger.debugScene(r11) == false) goto L31;
        StringBuilder r6 = new StringBuilder().append("Retry schedule: available = ");
        if (r2 <= 0) goto L24;
        boolean r5 = true;
    L25:
        StringBuilder r14 = r6.append(r5).append(", minKeep = ").append(r13).append("MB, canDownload = ");
        if (r3 <= 0) goto L28;
        boolean r7 = true;
    L29:
        Logger.taskDebug(TAG, r11, "canRetryWhenInsufficientSpace", r14.append(r7).toString());
        goto L31
    L28:
        r7 = false;
        goto L29
    L24:
        r5 = false;
    L31:
        if (r3 > 0) goto L39;
        if (Logger.debugScene(r11) == false) goto L35;
        Logger.taskDebug(TAG, r11, "canRetryWhenInsufficientSpace", "CanDownload <= 0 , canRetry = false");
    L35:
        return false;
    L37:
        if (r10.optInt(DownloadSettingKeys.DOWNLOAD_WHEN_SPACE_NEGATIVE, 0) != 1) goto L38;
    L39:
        return true;
    L10:
        r4 = r11.getTotalBytes() - r11.getCurBytes();
    L5:
        e = move-exception;
        e.printStackTrace();
        r2 = 0;
        goto L8
    }
}
