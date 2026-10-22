package com.ss.android.socialbase.downloader.network;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.thread.DownloadWatchDog;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public class DeviceBandwidthSampler {
    private static final String TAG = "DeviceBandwidthSampler";
    private static volatile DeviceBandwidthSampler instance = null;
    private static volatile int sNetworkType = 0;
    private static long sPreviousBytes = -1;
    private final List<ISampleListener> listenerList;
    private volatile long mCurrRunningTime;
    private final SamplingHandler mHandler;
    private long mLastTimeReading;
    private final NetTrafficManager mNetTrafficManager;
    private final AtomicInteger mSamplingCounter;
    private long mStartTime;

    public interface ISampleListener {
        void addSample();
    }

    private class SamplingHandler extends Handler {
        private static final int MSG_START = 1;
        static final long SAMPLE_TIME = 1000;
        final /* synthetic */ DeviceBandwidthSampler this$0;

        public SamplingHandler(DeviceBandwidthSampler r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            if (r4.what != 1) goto L7;
            this.this$0.addSample();
            sendEmptyMessageDelayed(1, 1000);
            return;
        }

        public void startSamplingThread() {
            sendEmptyMessage(1);
        }

        public void stopSamplingThread() {
            removeMessages(1);
        }
    }

    static {
    }

    public static DeviceBandwidthSampler getInstance() {
        if (instance != null) goto L15;
        monitor-enter(DeviceBandwidthSampler.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new DeviceBandwidthSampler();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DeviceBandwidthSampler.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private DeviceBandwidthSampler() {
        this.listenerList = new CopyOnWriteArrayList();
        this.mCurrRunningTime = 0;
        this.mStartTime = 0;
        this.mNetTrafficManager = NetTrafficManager.getInstance();
        this.mSamplingCounter = new AtomicInteger();
        this.mHandler = new SamplingHandler(this, DownloadWatchDog.getThreadLooper());
    }

    public void startSampling() {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "startSampling", "SamplingCounter = " + this.mSamplingCounter);     // Catch: Throwable -> L9
    L6:
        if (this.mSamplingCounter.getAndIncrement() != 0) goto L12;
        this.mHandler.startSamplingThread();     // Catch: Throwable -> L9
        this.mLastTimeReading = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        this.mStartTime = System.currentTimeMillis();     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    public long getTaskRunningTime() {
        return this.mCurrRunningTime;
    }

    public void stopSampling() {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "stopSampling", "SamplingCounter = " + this.mSamplingCounter);     // Catch: Throwable -> L9
    L6:
        if (this.mSamplingCounter.decrementAndGet() != 0) goto L12;
        this.mHandler.stopSamplingThread();     // Catch: Throwable -> L9
        addFinalSample();     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    public void registerSampleListener(ISampleListener r3) {
        ISampleListener r4 = (ISampleListener) ZeusTransformUtils.wrapperContextForParams(r3, ISampleListener.class, "com.obric.aiagent.plugin");
        this.listenerList.add(r4);
    }

    public void removeSampleListener(ISampleListener r3) {
        ISampleListener r4 = (ISampleListener) ZeusTransformUtils.wrapperContextForParams(r3, ISampleListener.class, "com.obric.aiagent.plugin");
        this.listenerList.remove(r4);
    }

    public static long getAllRxBytesWifi() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void updateNetworkStatus() {
        sNetworkType = DownloadUtils.getNetworkType((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    public static boolean isWifi() {
        if (sNetworkType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isMobileNet() {
        if (sNetworkType != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void addSample() {
        this.mCurrRunningTime = System.currentTimeMillis() - this.mStartTime;     // Catch: Exception -> L20
        updateNetworkStatus();     // Catch: Exception -> L20
        if (isWifi() == false) goto L5;
        long r0 = getAllRxBytesWifi();     // Catch: Exception -> L20
    L6:
        long r2 = sPreviousBytes;     // Catch: Exception -> L20
        long r4 = r0 - r2;     // Catch: Exception -> L20
        if (r2 < 0) goto L15;
        monitor-enter(this);     // Catch: Exception -> L20
        long r3 = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        this.mNetTrafficManager.addBandwidth(r4, r3 - this.mLastTimeReading);     // Catch: Throwable -> L12
        this.mLastTimeReading = r3;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Exception -> L20
    L15:
        sPreviousBytes = r0;     // Catch: Exception -> L20
        Iterator<ISampleListener> r9 = this.listenerList.iterator();     // Catch: Exception -> L20
    L17:
        if (r9.hasNext() == false) goto L27;
        ((ISampleListener) ZeusTransformUtils.preCheckCast(r9.next(), ISampleListener.class, "com.obric.aiagent.plugin")).addSample();     // Catch: Exception -> L20
        goto L17
    L27:
        return;
    L5:
        r0 = TrafficStats.getMobileRxBytes();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
    }

    public void addFinalSample() {
        this.mCurrRunningTime = 0;
        addSample();
        sPreviousBytes = -1;
    }

    public boolean isSampling() {
        if (this.mSamplingCounter.get() == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
