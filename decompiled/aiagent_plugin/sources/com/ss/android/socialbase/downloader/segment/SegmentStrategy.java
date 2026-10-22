package com.ss.android.socialbase.downloader.segment;

import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class SegmentStrategy {
    private static final int MAX_THREAD_COUNT = 16;
    private static final long MIN_CONNECT_TIMEOUT = 2000;
    private static final long MIN_READ_TIMEOUT = 4000;
    private static final long SEGMENT_MIN_INIT_SIZE = 5242880;
    private static final long SEGMENT_MIN_SIZE = 65536;
    public static final String TAG = "SegmentStrategy";
    private final JSONObject config;
    private int threadCount;

    private SegmentStrategy(JSONObject r1) {
        this.config = r1;
    }

    public void updateUrlCount(int r1) {
        this.threadCount = calculateThreadCount(r1);
    }

    public int getThreadCount() {
        return this.threadCount;
    }

    private int getUrlBalance() {
        return this.config.optInt(DownloadSettingKeys.SegmentConfig.URL_BALANCE, 2);
    }

    public boolean urlBalance() {
        if (getUrlBalance() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean urlBalanceStrictly() {
        if (getUrlBalance() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public int getBufferCount() {
        return this.config.optInt(DownloadSettingKeys.SegmentConfig.BUFFER_COUNT, 512);
    }

    public int getBufferSize() {
        return this.config.optInt(DownloadSettingKeys.SegmentConfig.BUFFER_SIZE, 8192);
    }

    public boolean segmentOneByOne() {
        if (this.config.optInt(DownloadSettingKeys.SegmentConfig.SEGMENT_MODE, 1) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public long getSegmentMinSize() {
        long r0 = ((long) this.config.optInt(DownloadSettingKeys.SegmentConfig.SEGMENT_MIN_KB, 512)) * 1024;
        if (r0 < 65536) goto L5;
        return r0;
    L5:
        return 65536;
    }

    public long getSegmentMinInitSize() {
        long r0 = ((long) this.config.optInt(DownloadSettingKeys.SegmentConfig.SEGMENT_MIN_INIT_MB, 10)) * 1048576;
        if (r0 < SEGMENT_MIN_INIT_SIZE) goto L5;
        return r0;
    L5:
        return SEGMENT_MIN_INIT_SIZE;
    }

    public long getSegmentMaxSize() {
        long r0 = ((long) this.config.optInt(DownloadSettingKeys.SegmentConfig.SEGMENT_MAX_KB, 0)) * 1048576;
        if (r0 >= getSegmentMinSize()) goto L6;
        return -1;
    L6:
        return r0;
    }

    public long getConnectTimeout() {
        long r0 = this.config.optInt("connect_timeout", -1);
        if (r0 < MIN_CONNECT_TIMEOUT) goto L5;
        return r0;
    L5:
        return -1;
    }

    public long getReadTimeout() {
        long r0 = this.config.optInt(DownloadSettingKeys.SegmentConfig.READ_TIMEOUT, -1);
        if (r0 < MIN_READ_TIMEOUT) goto L5;
        return r0;
    L5:
        return -1;
    }

    public int getIpStrategy() {
        return this.config.optInt(DownloadSettingKeys.SegmentConfig.IP_STRATEGY, 0);
    }

    private int calculateThreadCount(int r4) {
        int r0 = this.config.optInt("thread_count", 4);
        if (r0 <= 16) goto L6;
        r0 = 16;
    L6:
        if (r0 > 0) goto L12;
        if (getUrlBalance() <= 0) goto L10;
        return r4;
    L10:
        return 1;
    L12:
        if (getUrlBalance() == 1) goto L14;
        return r0;
    L14:
        return Math.min(r0, r4);
    }

    public float getMainRatio() {
        return (float) this.config.optDouble(DownloadSettingKeys.SegmentConfig.MAIN_RATIO, 0.0d);
    }

    public int getRatioSegmentStrategy() {
        return this.config.optInt(DownloadSettingKeys.SegmentConfig.RATIO_SEGMENT, 0);
    }

    public float getPoorSpeedRatio() {
        return Math.min(Math.max(0.0f, (float) this.config.optDouble(DownloadSettingKeys.SegmentConfig.POOR_SPEED_RATIO, 0.0d)), 1.0f);
    }

    public static SegmentStrategy from(JSONObject r1) {
        return new SegmentStrategy(r1);
    }
}
