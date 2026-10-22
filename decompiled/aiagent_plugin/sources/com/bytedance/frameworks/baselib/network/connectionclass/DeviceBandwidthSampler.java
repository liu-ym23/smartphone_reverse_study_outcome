package com.bytedance.frameworks.baselib.network.connectionclass;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.thread.PlatformHandlerThread;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class DeviceBandwidthSampler {
    private static long g = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.frameworks.baselib.network.connectionclass.a f8040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicInteger f8041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SamplingHandler f8042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HandlerThread f8043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8044e;
    private long f;

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
        L7:
            th = move-exception;
            th.printStackTrace();
            return;
        L3:
            if (r4.what != 1) goto L12;
            this.this$0.d();     // Catch: Throwable -> L7
            sendEmptyMessageDelayed(1, 1000);     // Catch: Throwable -> L7
            return;
        }

        public void startSamplingThread() {
            sendEmptyMessage(1);
        }

        public void stopSamplingThread() {
            removeMessages(1);
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DeviceBandwidthSampler f8045a = null;

        static {
            f8045a = new DeviceBandwidthSampler(com.bytedance.frameworks.baselib.network.connectionclass.a.a());
        }
    }

    static {
    }

    public static DeviceBandwidthSampler a() {
        return a.f8045a;
    }

    public DeviceBandwidthSampler(com.bytedance.frameworks.baselib.network.connectionclass.a r2) {
        this.f8044e = false;
        this.f8040a = r2;
        this.f8041b = new AtomicInteger();     // Catch: Throwable -> L5
        HandlerThread r3 = PlatformHandlerThread.a("ParseThread");     // Catch: Throwable -> L5
        this.f8043d = r3;     // Catch: Throwable -> L5
        r3.start();     // Catch: Throwable -> L5
        this.f8042c = new SamplingHandler(this, this.f8043d.getLooper());     // Catch: Throwable -> L5
        return;
    L5:
        this.f8044e = true;
    }

    public void b() {
        if (this.f8044e == false) goto L6;
        return;
    L6:
        if (this.f8041b.getAndIncrement() == 0) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("ConnectionClassManager", "startSampling");     // Catch: Throwable -> L12
    L10:
        this.f8042c.startSamplingThread();     // Catch: Throwable -> L12
        this.f = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        return;
    }

    public void c() {
        if (this.f8044e == false) goto L6;
        return;
    L6:
        if (this.f8041b.decrementAndGet() == 0) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("ConnectionClassManager", "stopSampling");     // Catch: Throwable -> L12
    L10:
        this.f8042c.stopSamplingThread();     // Catch: Throwable -> L12
        e();     // Catch: Throwable -> L12
        return;
    }

    public void d() {
        long r0 = TrafficStats.getTotalRxBytes();     // Catch: Throwable -> L13
        long r2 = g;     // Catch: Throwable -> L13
        long r4 = r0 - r2;     // Catch: Throwable -> L13
        if (r2 < 0) goto L11;
        monitor-enter(this);     // Catch: Throwable -> L13
        long r3 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
        this.f8040a.a(r4, r3 - this.f);     // Catch: Throwable -> L8
        this.f = r3;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L11:
        g = r0;     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
    }

    public void e() {
        d();
        g = -1;
    }
}
