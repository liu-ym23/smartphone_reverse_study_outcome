package com.ss.android.socialbase.downloader.cleaner;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class Cleaner {
    private static volatile Cleaner INSTANCE = null;
    private static final String TAG = "Cleaner";
    private static AtomicBoolean mIsRunCleaner;
    private volatile CleanerConfig mCleanerConfig;

    public Cleaner() {
        this.mCleanerConfig = new CleanerConfig();
    }

    static /* synthetic */ CleanerConfig access$000(Cleaner r0) {
        return r0.mCleanerConfig;
    }

    static {
        mIsRunCleaner = new AtomicBoolean();
        INSTANCE = null;
    }

    public static Cleaner getInstance() {
        if (INSTANCE != null) goto L15;
        monitor-enter(Cleaner.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (INSTANCE != null) goto L9;
        INSTANCE = new Cleaner();     // Catch: Throwable -> L11
    L9:
        monitor-exit(Cleaner.class);     // Catch: Throwable -> L11
    L15:
        return INSTANCE;
    }

    public void init() {
        if (Logger.debug() == false) goto L5;
        long r0 = System.currentTimeMillis();
    L6:
        this.mCleanerConfig.init();
        if (Logger.debug() == false) goto L10;
        Logger.globalDebug(TAG, "init", "Cleaner init cost time=" + (System.currentTimeMillis() - r0));
        return;
    L10:
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public boolean isExistInCleanSet(int r1) {
        if (r1 != 0) goto L6;
        return false;
    L6:
        return this.mCleanerConfig.isExistInCleanSet(r1);
    }

    public void removeFromCleanSet(int r1) {
        this.mCleanerConfig.removeFromCleanDownloadIdSet(r1);
    }

    public void start() {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "start", "enter Cleaner start");
    L6:
        if (mIsRunCleaner.compareAndSet(true, true) == false) goto L9;
        return;
    L9:
        if (DownloadHelper.isMainProcess() == true) goto L12;
        this.mCleanerConfig.finish();
        return;
    L12:
        FastDownloadCleaner.start();
        int r0 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.CacheCleaner.START_CLEAN_DELAY_TIME_S);
        if (Logger.debug() == false) goto L15;
        Logger.globalDebug(TAG, "run", "Run cleaner startCleanDelayTime: " + r0 + " isNoCacheNeedClean:" + this.mCleanerConfig.isNoCacheNeedClean());
    L15:
        if (r0 > 0) goto L17;
    L21:
        this.mCleanerConfig.finish();
        return;
    L17:
        if (this.mCleanerConfig.isNoCacheNeedClean() == true) goto L21;
        DownloadComponentManager.submitScheduleTask(new AnonymousClass1(this), r0, TimeUnit.SECONDS);
    }

    public boolean updateCleanDownloadId(DownloadInfo r1) {
        return this.mCleanerConfig.updateCleanDownloadId(r1);
    }

    public boolean forceUpdateCleanDownloadId(DownloadInfo r1, boolean r2) {
        return this.mCleanerConfig.forceUpdateCleanDownloadId(r1, r2);
    }
}
