package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.SparseArray;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.NotificationConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.ThreadWithHandler;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadNotificationServiceImpl {
    private static final long NOTIFY_TIME_WINDOW = 1000;
    private static final String TAG = "DownloadNotificationServiceImpl";
    private static volatile DownloadNotificationServiceImpl mInstance;
    private boolean mEnabledFixLeak;
    private AtomicBoolean mInited;
    private volatile long mLastImportantNotifyTimestamp;
    private volatile long mLastNotifyTimestamp;
    private volatile ThreadWithHandler mNotifyThreadHandler;
    private long mNotifyTimeWindow;
    private final SparseArray<Notification> mPendingImportantNotify;

    public DownloadNotificationServiceImpl() {
        this.mNotifyTimeWindow = 1000;
        this.mPendingImportantNotify = new SparseArray(2);
        this.mInited = new AtomicBoolean(false);
        this.mEnabledFixLeak = isEnableFixNotificationLeak();
    }

    static /* synthetic */ void access$000(DownloadNotificationServiceImpl r0, Intent r1) {
        r0.handleIntentImpl(r1);
    }

    static /* synthetic */ void access$100(DownloadNotificationServiceImpl r0, NotificationManager r1, int r2) {
        r0.performImportantNotify(r1, r2);
    }

    public static DownloadNotificationServiceImpl getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(DownloadNotificationServiceImpl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new DownloadNotificationServiceImpl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadNotificationServiceImpl.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public void init() {
        if (this.mEnabledFixLeak == false) goto L8;
        if (this.mInited.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.globalDebug(TAG, "init", "Create DownloaderNotifyThread");
    L10:
        this.mNotifyThreadHandler = new ThreadWithHandler("DownloaderNotifyThread");
        this.mNotifyThreadHandler.start();
        long r0 = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.NOTIFICATION_TIME_WINDOW, 1000);
        this.mNotifyTimeWindow = r0;
        if (r0 >= 0) goto L13;
    L14:
        this.mNotifyTimeWindow = 1000;
        return;
    L13:
        if (r0 > 1200) goto L14;
    }

    public void onDestroy() {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.ENABLE_TARGET_34) <= 0) goto L6;
        return;
    L6:
        if (this.mNotifyThreadHandler != null) goto L12;
        return;
    L12:
        this.mNotifyThreadHandler.quit();     // Catch: Throwable -> L11
    L9:
        this.mNotifyThreadHandler = null;
    }

    public void handleIntent(final Intent r4) {
        if (r4 != null) goto L5;
    L13:
        Logger.globalError(TAG, "handleIntent", "Intent Error:" + r4);
        return;
    L5:
        if (TextUtils.isEmpty(r4.getAction()) == true) goto L13;
        init();
        if (this.mNotifyThreadHandler != null) goto L11;
        Logger.globalError(TAG, "handleIntent", "NotifyThreadHandler is null");
        return;
    L11:
        this.mNotifyThreadHandler.post(new AnonymousClass1(this, r4));
    }

    private void handleIntentImpl(Intent r8) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        Logger.globalError(TAG, "handleIntentImpl", "Context is null");
        return;
    L6:
        String r2 = r8.getAction();
        NotificationManager r3 = (NotificationManager) ZeusTransformUtils.preCheckCast(r0.getSystemService(IFlowAppIntentIDL.PERMISSION_NOTIFICATION), NotificationManager.class, "com.obric.aiagent.plugin");
        int r4 = r8.getIntExtra(NotificationConstants.EXTRA_NOTIFICATION_ID, 0);
        if (NotificationConstants.ACTION_NOTIFICATION_NOTIFY.equals(r2) == false) goto L32;
        Notification r1 = (Notification) ZeusTransformUtils.preCheckCast(r8.getParcelableExtra(NotificationConstants.EXTRA_NOTIFICATION), Notification.class, "com.obric.aiagent.plugin");
        int r9 = r8.getIntExtra(NotificationConstants.EXTRA_NOTIFICATION_STATUS, 0);
        if (r4 == 0) goto L74;
        if (r1 == null) goto L75;
        if (r3 != null) goto L13;
        return;
    L13:
        if (r9 != 4) goto L25;
        if (Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).isDownloading(r4) == true) goto L17;
        return;
    L17:
        DownloadInfo r10 = Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getDownloadInfo(r4);
        if (r10 != null) goto L20;
        return;
    L20:
        if (r10.canNotifyProgress() == true) goto L22;
        return;
    L22:
        if ((System.currentTimeMillis() - this.mLastImportantNotifyTimestamp) <= this.mNotifyTimeWindow) goto L79;
        doNotify(r3, r4, r1);
        r10.setLastNotifyProgressTime();
        return;
    L79:
        return;
    L25:
        if (r9 != (-2)) goto L27;
    L30:
        doImportantNotify(r3, r4, r1);
        return;
    L27:
        if (r9 == (-3)) goto L30;
        doImportantNotify(r3, r4, r1);
        return;
    L75:
        return;
    L74:
        return;
    L32:
        if (NotificationConstants.ACTION_NOTIFICATION_CANCEL.equals(r2) == false) goto L36;
        if (r4 == 0) goto L83;
        doCancel(r3, r4);
        return;
    L83:
        return;
    L36:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r2) == false) goto L56;
    L53:
        e = move-exception;
        e.printStackTrace();
        return;
    L38:
        if (DownloadHelper.checkPermission(r0, "android.permission.ACCESS_NETWORK_STATE") == false) goto L52;
        ConnectivityManager r7 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r0.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L53
        if (r7 != null) goto L42;
        return;
    L42:
        NetworkInfo r11 = r7.getActiveNetworkInfo();     // Catch: Exception -> L53
        if (r11 != null) goto L45;
        return;
    L45:
        if (r11.isConnected() == false) goto L73;
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L53
        if (TextUtils.isEmpty(DownloadConstants.MIME_APK) == true) goto L50;
        r12.add(DownloadConstants.MIME_APK);     // Catch: Exception -> L53
    L50:
        r12.add(DownloadConstants.MIME_PLG);     // Catch: Exception -> L53
        Downloader.getInstance(r0).restartAllFailedDownloadTasks(r12);     // Catch: Exception -> L53
        Downloader.getInstance(r0).restartAllPauseReserveOnWifiDownloadTasks(r12);     // Catch: Exception -> L53
        return;
    L73:
        return;
    L52:
        return;
    L56:
        if ("android.intent.action.MEDIA_UNMOUNTED".equals(r2) == false) goto L58;
    L68:
        Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).pauseAll();     // Catch: Exception -> L65
        return;
    L65:
        e = move-exception;
        e.printStackTrace();
        return;
    L58:
        if ("android.intent.action.MEDIA_REMOVED".equals(r2) == true) goto L68;
        if ("android.intent.action.MEDIA_BAD_REMOVAL".equals(r2) == true) goto L68;
        if ("android.intent.action.MEDIA_EJECT".equals(r2) == true) goto L68;
    }

    private void doImportantNotify(final NotificationManager r8, final int r9, Notification r10) {
        SparseArray<Notification> r0 = this.mPendingImportantNotify;
        monitor-enter(r0);
        int r1 = this.mPendingImportantNotify.indexOfKey(r9);     // Catch: Throwable -> L32
        if (r1 >= 0) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L32
        long r2 = this.mNotifyTimeWindow - (System.currentTimeMillis() - this.mLastNotifyTimestamp);
        if (r2 > 0) goto L16;
        r2 = 0;
    L16:
        if (r2 <= 20000) goto L18;
        r2 = 20000;
    L18:
        long r4 = System.currentTimeMillis() + r2;
        this.mLastImportantNotifyTimestamp = r4;
        this.mLastNotifyTimestamp = r4;
        if (r2 > 0) goto L22;
        doNotify(r8, r9, r10);
        return;
    L22:
        if (this.mNotifyThreadHandler == null) goto L38;
        SparseArray<Notification> r3 = this.mPendingImportantNotify;
        monitor-enter(r3);
        this.mPendingImportantNotify.put(r9, r10);     // Catch: Throwable -> L28
        monitor-exit(r3);     // Catch: Throwable -> L28
        this.mNotifyThreadHandler.postDelayed(new AnonymousClass2(this, r8, r9), r2);
        return;
    L28:
        th = move-exception;
        throw th;
    L38:
        return;
    L7:
        if (r1 >= this.mPendingImportantNotify.size()) goto L11;
        this.mPendingImportantNotify.setValueAt(r1, r10);     // Catch: Throwable -> L32
        monitor-exit(r0);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw th;
    }

    private void performImportantNotify(NotificationManager r5, int r6) {
        SparseArray<Notification> r0 = this.mPendingImportantNotify;
        monitor-enter(r0);
        Notification r1 = (Notification) ZeusTransformUtils.preCheckCast(this.mPendingImportantNotify.get(r6), Notification.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        this.mPendingImportantNotify.remove(r6);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (r1 == null) goto L14;
        doNotify(r5, r6, r1);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void doNotify(NotificationManager r5, int r6, Notification r7) {
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L7
        if (this.mLastNotifyTimestamp >= r0) goto L5;
        this.mLastNotifyTimestamp = r0;     // Catch: Throwable -> L7
    L5:
        r5.notify(r6, r7);     // Catch: Throwable -> L7
        return;
    }

    private void doCancel(NotificationManager r1, int r2) {
        r1.cancel(r2);     // Catch: Throwable -> L4
        return;
    }

    private boolean isEnableFixNotificationLeak() {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FIX_NOTIFICATION_LEAK, 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }
}
