package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class NetworkRetryStrategy {
    private static final String TAG = "NetworkRetryStrategy";
    private List<Long> delayIntervalMs;
    private int mCurrentPeriodRetryCount;
    private int mCurrentRetryCount;
    private int mCurrentRetryResetCount;
    private long mCurrentRetryTime;
    private int mDownloadId;
    private boolean mEnabled;
    private int mPeriodRetryCountLimit;
    private int mRetryCountLimit;
    private long mRetryPeriodTime;
    private int mRetryResetCountLimit;
    private int mTotalRetryCount;

    public NetworkRetryStrategy(DownloadInfo r11) {
        this.mCurrentRetryCount = 0;
        this.mCurrentPeriodRetryCount = 0;
        this.mCurrentRetryTime = 0;
        this.mCurrentRetryResetCount = 0;
        this.mRetryCountLimit = 0;
        this.mPeriodRetryCountLimit = 0;
        this.mRetryPeriodTime = 0;
        this.mRetryResetCountLimit = 0;
        this.mTotalRetryCount = 0;
        this.mEnabled = false;
        this.delayIntervalMs = new ArrayList();
        this.mDownloadId = 0;
        initInternal(r11);     // Catch: Throwable -> L8
        if (Logger.debugScene(r11) == false) goto L13;
        StringBuilder r6 = new StringBuilder();
    L7:
        Logger.taskDebug(TAG, r11, TAG, r6.append("Init retryCountLimit:").append(this.mRetryCountLimit).append(" delayIntervalMs:").append(this.delayIntervalMs.toString()).append(" retryPeriodTime:").append(this.mRetryPeriodTime).append(" periodRetryCountLimit:").append(this.mPeriodRetryCountLimit).append(" retryResetCountLimit:").append(this.mRetryResetCountLimit).toString());
        return;
    L13:
        return;
    L8:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        Logger.taskError(TAG, this.mDownloadId, TAG, "Init Error" + th.toString());     // Catch: Throwable -> L14
        if (Logger.debugScene(r11) == false) goto L24;
        r6 = new StringBuilder();
        goto L7
    L24:
        return;
    L14:
        th = move-exception;
        if (Logger.debugScene(r11) == false) goto L18;
        Logger.taskDebug(TAG, r11, TAG, "Init retryCountLimit:" + this.mRetryCountLimit + " delayIntervalMs:" + this.delayIntervalMs.toString() + " retryPeriodTime:" + this.mRetryPeriodTime + " periodRetryCountLimit:" + this.mPeriodRetryCountLimit + " retryResetCountLimit:" + this.mRetryResetCountLimit);
    L18:
        throw th;
    }

    private void initInternal(DownloadInfo r8) {
        if (r8 == null) goto L5;
        int r9 = r8.getId();
        this.mDownloadId = r9;
        JSONObject r10 = DownloadSetting.obtain(r9).optJSONObject(DownloadSettingKeys.RETRY_STRATEGY);
    L6:
        if (r10 != null) goto L8;
        return;
    L8:
        int r0 = r10.optInt("retry_count");
        if (r0 <= 0) goto L11;
        this.mRetryCountLimit = r0;
    L11:
        JSONArray r1 = r10.optJSONArray(DownloadSettingKeys.RetryStrategy.KEY_DELAY_INTERVAL_MS);
        if (r1 != null) goto L14;
    L22:
        long r3 = r10.optLong(DownloadSettingKeys.RetryStrategy.KEY_RETRY_PERIOD_MS);
        if (r3 <= 0) goto L25;
        this.mRetryPeriodTime = r3;
    L25:
        int r2 = r10.optInt(DownloadSettingKeys.RetryStrategy.KEY_RETRY_COUNT_LIMIT_PERIOD);
        if (r2 <= 0) goto L28;
        this.mPeriodRetryCountLimit = r2;
    L28:
        int r11 = r10.optInt(DownloadSettingKeys.RetryStrategy.KEY_RETRY_RESET_COUNT_LIMIT);
        if (r11 <= 0) goto L32;
        this.mRetryResetCountLimit = r11;
    L32:
        if (this.mRetryCountLimit > 0) goto L34;
        return;
    L34:
        if (this.mRetryResetCountLimit <= 0) goto L41;
        this.mEnabled = true;
        return;
    L41:
        return;
    L14:
        if (r1.length() <= 0) goto L22;
        int r4 = 0;
    L17:
        if (r4 >= r1.length()) goto L22;
        long r5 = r1.optLong(r4);
        if (r5 <= 0) goto L21;
        this.delayIntervalMs.add(Long.valueOf(r5));
    L21:
        r4 = r4 + 1;
        goto L17
    L5:
        r10 = DownloadSetting.obtainGlobal().optJSONObject(DownloadSettingKeys.RETRY_STRATEGY);
        goto L6
    }

    public void reset() {
        if (resetLimit() == false) goto L7;
        this.mEnabled = false;
        return;
    L7:
        if (Logger.debug() == false) goto L9;
        Logger.taskDebug(TAG, this.mDownloadId, "reset", "Reset currentRetryResetCount");
    L9:
        this.mCurrentRetryResetCount++;
        this.mCurrentRetryCount = 0;
    }

    public boolean canRetry(BaseException r7) {
        if (r7 == null) goto L22;
        if (this.mEnabled == false) goto L22;
        if (Logger.debug() == false) goto L11;
        Logger.taskDebug(TAG, this.mDownloadId, "canRetry", "CurrentRetryCount:" + this.mCurrentRetryCount + " retryCountLimit:" + this.mRetryCountLimit + " error:" + r7.getErrorCode());
    L11:
        if (retryLimit() == false) goto L15;
        this.mEnabled = false;
        return false;
    L15:
        if (this.mCurrentRetryCount < this.mRetryCountLimit) goto L17;
    L20:
        return false;
    L17:
        if (DownloadUtils.isNetworkError(r7) == false) goto L20;
        return true;
    L22:
        if (Logger.debug() == false) goto L24;
        Logger.taskDebug(TAG, this.mDownloadId, "canRetry", "Enabled: " + this.mEnabled);
    L24:
        return false;
    }

    public void doRetry() {
        if (this.mEnabled == true) goto L5;
        return;
    L5:
        delay();
        this.mCurrentRetryCount++;
        this.mCurrentPeriodRetryCount++;
        this.mTotalRetryCount++;
        if (Logger.debug() == false) goto L9;
        Logger.taskDebug(TAG, this.mDownloadId, "doRetry", "CurrentRetryCount:" + this.mCurrentRetryCount + " currentPeriodRetryCount:" + this.mCurrentPeriodRetryCount + " totalRetryCount:" + this.mTotalRetryCount);
        return;
    }

    private void delay() {
        if (this.delayIntervalMs.isEmpty() == false) goto L18;
        return;
    L18:
    L15:
        th = move-exception;
        Logger.taskError(TAG, this.mDownloadId, "delay", "Error:" + th.toString());
        th.printStackTrace();
        return;
    L7:
        if (this.mCurrentRetryCount < this.delayIntervalMs.size()) goto L9;
        List<Long> r2 = this.delayIntervalMs;     // Catch: Throwable -> L15
        long r3 = ((Long) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), Long.class, "com.obric.aiagent.plugin")).longValue();     // Catch: Throwable -> L15
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.taskDebug(TAG, this.mDownloadId, "delay", "Sleep:" + r3);     // Catch: Throwable -> L15
    L13:
        Thread.sleep(r3);     // Catch: Throwable -> L15
        return;
    L9:
        r3 = ((Long) ZeusTransformUtils.preCheckCast(this.delayIntervalMs.get(this.mCurrentRetryCount), Long.class, "com.obric.aiagent.plugin")).longValue();     // Catch: Throwable -> L15
        goto L11
    }

    private boolean retryLimit() {
        if (this.mRetryPeriodTime > 0) goto L5;
    L22:
        return false;
    L5:
        if (this.mPeriodRetryCountLimit <= 0) goto L22;
        if (this.mCurrentRetryTime != 0) goto L11;
        this.mCurrentRetryTime = System.currentTimeMillis();
        return false;
    L11:
        long r2 = System.currentTimeMillis();
        if ((r2 - this.mCurrentRetryTime) < this.mRetryPeriodTime) goto L14;
        this.mCurrentRetryTime = System.currentTimeMillis();
        this.mCurrentPeriodRetryCount = 0;
        goto L22
    L14:
        if (this.mCurrentPeriodRetryCount > this.mPeriodRetryCountLimit) goto L16;
        return false;
    L16:
        if (Logger.debug() == false) goto L23;
        Logger.taskDebug(TAG, this.mDownloadId, "retryLimit", "CurrentPeriodRetryCount:" + this.mCurrentPeriodRetryCount + " periodRetryCountLimit:" + this.mPeriodRetryCountLimit + " currentRetryPeriodTime:" + (r2 - this.mCurrentRetryTime) + " retryPeriodTime:" + this.mRetryPeriodTime);
        return true;
    L23:
        return true;
    }

    private boolean resetLimit() {
        int r0 = this.mRetryResetCountLimit;
        if (r0 > 0) goto L6;
        return false;
    L6:
        if (this.mCurrentRetryResetCount >= r0) goto L8;
        return false;
    L8:
        if (Logger.debug() == false) goto L13;
        Logger.taskDebug(TAG, this.mDownloadId, "resetLimit", "CurrentRetryResetCount:" + this.mCurrentRetryResetCount + " retryResetCountLimit:" + this.mRetryResetCountLimit);
        return true;
    L13:
        return true;
    }

    public int getTotalRetryCount() {
        return this.mTotalRetryCount;
    }
}
