package com.ss.android.socialbase.downloader.core.module.pcdn;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public class PCDNBandwidthSampler implements DeviceBandwidthSampler.ISampleListener {
    private static final String TAG = "PCDNBandwidthSampler";
    private int mDownloadId;
    private volatile boolean mEnabled;
    private long mLastTimeReading;
    private List<LowSpeedListener> mLowSpeedListeners;
    private int mLowSpeedSampleCount;
    private long mPcdnDegradeBandWidthLimit;
    private int mPcdnDegradeSampleCount;
    private AtomicLong mPcdnTotalBytes;
    private long mPreviousBytes;

    public interface LowSpeedListener {
        void onLowSpeed();
    }

    public PCDNBandwidthSampler(int r4, long r5, int r7) {
        this.mEnabled = false;
        this.mPcdnTotalBytes = new AtomicLong(0);
        this.mLowSpeedListeners = new CopyOnWriteArrayList();
        this.mDownloadId = r4;
        this.mPcdnDegradeBandWidthLimit = r5;
        this.mPcdnDegradeSampleCount = r7;
        if (r5 <= 0) goto L7;
        if (r7 <= 0) goto L8;
        DeviceBandwidthSampler.getInstance().registerSampleListener(this);
        return;
    L8:
        return;
    }

    public void startSampling() {
        this.mEnabled = true;
    }

    public void stopSampling() {
        this.mEnabled = false;
        DeviceBandwidthSampler.getInstance().removeSampleListener(this);
    }

    public void register(LowSpeedListener r3) {
        LowSpeedListener r4 = (LowSpeedListener) ZeusTransformUtils.wrapperContextForParams(r3, LowSpeedListener.class, "com.obric.aiagent.plugin");
        this.mLowSpeedListeners.add(r4);
    }

    public void addPcdnSample(long r1) {
        this.mPcdnTotalBytes.addAndGet(r1);
    }

    @Override // com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler.ISampleListener
    public void addSample() {
        if (this.mEnabled == true) goto L5;
        return;
    L5:
        long r0 = SystemClock.uptimeMillis();
        long r2 = this.mPcdnTotalBytes.get();
        long r4 = this.mLastTimeReading;
        if (r4 > 0) goto L9;
        this.mLastTimeReading = r0;
        this.mPreviousBytes = r2;
        return;
    L9:
        addSampleImpl(r2 - this.mPreviousBytes, r0 - r4);
        this.mLastTimeReading = r0;
        this.mPreviousBytes = r2;
    }

    private void addSampleImpl(long r6, long r8) {
        if (r8 != 0) goto L5;
        return;
    L5:
        long r0 = r6 / r8;
        if (Logger.debug() == false) goto L9;
        Logger.taskDebug(TAG, this.mDownloadId, "addSampleImpl", "Speed:" + r0 + " byteDiff:" + r6 + " timeDiff:" + r8);
    L9:
        if (r0 >= this.mPcdnDegradeBandWidthLimit) goto L17;
        int r7 = this.mLowSpeedSampleCount + 1;
        this.mLowSpeedSampleCount = r7;
        if (r7 <= this.mPcdnDegradeSampleCount) goto L20;
        Iterator<LowSpeedListener> r9 = this.mLowSpeedListeners.iterator();
    L14:
        if (r9.hasNext() == false) goto L16;
        ((LowSpeedListener) ZeusTransformUtils.preCheckCast(r9.next(), LowSpeedListener.class, "com.obric.aiagent.plugin")).onLowSpeed();
        goto L14
    L16:
        this.mLowSpeedSampleCount = 0;
        return;
    L20:
        return;
    L17:
        this.mLowSpeedSampleCount = 0;
    }
}
