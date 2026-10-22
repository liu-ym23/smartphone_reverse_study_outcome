package com.ss.android.socialbase.downloader.network.throttle;

import android.net.TrafficStats;
import com.ss.android.socialbase.downloader.network.ExponentialGeometricAverage;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class SmartThrottleInputStream extends ThrottleInputStream {
    private static final double DEFAULT_DECAY_CONSTANT = 0.1d;
    public static final float DEFAULT_THROTTLE_FACTOR_MAX = 0.7f;
    public static final float DEFAULT_THROTTLE_FACTOR_MIN = 0.1f;
    private static final int LEFT_MOVE = -1;
    private static final int RIGHT_MOVE = 1;
    private static final String TAG = "SmartThrottle";
    private long curReadBytes;
    private long curTotalBytes;
    private double lastOtherAvgSpeed;
    private double lastReadAvgSpeed;
    private long lastReadBytes;
    private long lastStatsSpeedTime;
    private double lastTotalAvgSpeed;
    private long lastTotalBytes;
    private long lastUpdateThrottleFactorTime;
    private int otherSpeedDeltaThreshold;
    private long overSleepTime;
    private double pendingOtherAvgSpeedDelta;
    private final ExponentialGeometricAverage readSpeedAverage;
    private long statsSpeedPeriod;
    private float throttleFactor;
    private float throttleFactorMax;
    private final float throttleFactorMiddle;
    private float throttleFactorMin;
    private int throttleFactorMoveTrend;
    private float throttleFactorStep;
    private final ExponentialGeometricAverage totalSpeedAverage;
    private long updateThrottleFactorPeriod;

    public SmartThrottleInputStream(InputStream r4, float r5, float r6) {
        super(r4);
        this.throttleFactorMin = 0.1f;
        this.throttleFactorMax = 0.7f;
        this.throttleFactor = 0.1f;
        this.throttleFactorStep = 0.1f;
        this.statsSpeedPeriod = 1000;
        this.updateThrottleFactorPeriod = 2000;
        this.readSpeedAverage = new ExponentialGeometricAverage(DEFAULT_DECAY_CONSTANT);
        this.totalSpeedAverage = new ExponentialGeometricAverage(DEFAULT_DECAY_CONSTANT);
        this.throttleFactorMoveTrend = 1;
        this.otherSpeedDeltaThreshold = 60;
        if (r5 < r6) goto L5;
    L9:
        if (r5 < r6) goto L11;
    L15:
        this.throttleFactorMiddle = (this.throttleFactorMin + this.throttleFactorMax) / 2.0f;
        return;
    L11:
        if (r6 <= 0.0f) goto L15;
        if (r6 > 1.0f) goto L15;
        this.throttleFactorMax = r6;
        goto L15
    L5:
        if (r5 < 0.0f) goto L9;
        if (r5 >= 1.0f) goto L9;
        this.throttleFactorMin = r5;
        goto L9
    }

    @Override // com.ss.android.socialbase.downloader.network.throttle.ThrottleInputStream, java.io.InputStream
    public int read(byte[] r9, int r10, int r11) {
        if (this.throttleNetSpeed != (-1)) goto L27;
        long r0 = System.currentTimeMillis();
        if ((r0 - this.periodStartTime) <= this.throttlePeriod) goto L22;
        this.periodStartTime = r0;
        statsSpeed(r0);
        updateThrottleFactor(r0);
        long r1 = (long) (this.throttlePeriod * ((double) (1.0f - this.throttleFactor)));
        long r2 = this.overSleepTime;
        if (r2 < r1) goto L10;
        this.overSleepTime = r2 - r1;
        goto L22
    L10:
        if (r2 <= 0) goto L13;
        r1 = r1 - r2;
        this.overSleepTime = 0;
    L13:
        if (r1 <= 0) goto L22;
        long r3 = System.currentTimeMillis();
        Thread.sleep(r1);     // Catch: InterruptedException -> L19
        long r6 = (System.currentTimeMillis() - r3) - r1;
        if (r6 <= 0) goto L22;
        this.overSleepTime = r6;
    L19:
        e = move-exception;
        throw new IOException(e);
    L22:
        int r12 = superRead(r9, r10, r11);
        if (r12 == (-1)) goto L25;
        this.curReadBytes += (long) r12;
    L25:
        return r12;
    L27:
        return super.read(r9, r10, r11);
    }

    private void statsSpeed(long r9) {
        long r0 = this.lastStatsSpeedTime;
        if ((r9 - r0) < this.statsSpeedPeriod) goto L12;
        double r2 = r9 - r0;
        if (r0 > 0) goto L7;
    L10:
        this.lastStatsSpeedTime = r9;
        this.lastTotalBytes = TrafficStats.getTotalRxBytes();
        this.lastReadBytes = this.curReadBytes;
        return;
    L7:
        if (r2 <= 0.0d) goto L10;
        this.lastStatsSpeedTime = r9;
        long r10 = TrafficStats.getTotalRxBytes();
        this.curTotalBytes = r10;
        long r1 = this.curReadBytes;
        long r4 = r1 - this.lastReadBytes;
        long r6 = r10 - this.lastTotalBytes;
        this.lastReadBytes = r1;
        this.lastTotalBytes = r10;
        this.readSpeedAverage.addMeasurement(r4 / r2);
        this.totalSpeedAverage.addMeasurement(r6 / r2);
        return;
    }

    private void updateThrottleFactor(long r14) {
        long r0 = this.lastUpdateThrottleFactorTime;
        if ((r14 - r0) >= this.updateThrottleFactorPeriod) goto L5;
        return;
    L5:
        if (r0 != 0) goto L8;
        this.lastUpdateThrottleFactorTime = r14;
        return;
    L8:
        this.lastUpdateThrottleFactorTime = r14;
        double r15 = this.readSpeedAverage.getAverage();
        double r1 = this.totalSpeedAverage.getAverage();
        double r2 = r1 - r15;
        double r7 = r15 - this.lastReadAvgSpeed;
        double r9 = r1 - this.lastTotalAvgSpeed;
        double r11 = r2 - this.lastOtherAvgSpeed;
        this.lastReadAvgSpeed = r15;
        this.lastTotalAvgSpeed = r1;
        this.lastOtherAvgSpeed = r2;
        int r16 = calculatorThrottleFactorTrend(r7, r9, r11);
        if (r16 <= 0) goto L11;
        rightMoveThrottleFactor();
        return;
    L11:
        if (r16 >= 0) goto L14;
        leftMoveThrottleFactor();
        return;
    L14:
        if (this.throttleFactor >= this.throttleFactorMiddle) goto L16;
        addThrottleFactor(this.throttleFactorStep);
        return;
    L16:
        addThrottleFactor(-this.throttleFactorStep);
    }

    private int calculatorThrottleFactorTrend(double r3, double r5, double r7) {
        double r8 = r7 + this.pendingOtherAvgSpeedDelta;
        this.pendingOtherAvgSpeedDelta = 0.0d;
        int r4 = this.otherSpeedDeltaThreshold;
        if (r8 < r4) goto L6;
        return -1;
    L6:
        if (r8 >= (-r4)) goto L8;
        return -1;
    L8:
        this.pendingOtherAvgSpeedDelta = r8;
        if (r8 <= ((-r4) / 2.0f)) goto L12;
        return 1;
    L12:
        return 0;
    }

    private void leftMoveThrottleFactor() {
        if (this.throttleFactor <= this.throttleFactorMiddle) goto L5;
        float r0 = (-this.throttleFactorStep) * 2.0f;
    L6:
        addThrottleFactor(r0);
        return;
    L5:
        r0 = -this.throttleFactorStep;
        goto L6
    }

    private void rightMoveThrottleFactor() {
        if (this.throttleFactor >= this.throttleFactorMiddle) goto L5;
        float r0 = this.throttleFactorStep * 2.0f;
    L6:
        addThrottleFactor(r0);
        return;
    L5:
        r0 = this.throttleFactorStep;
        goto L6
    }

    private void addThrottleFactor(float r4) {
        if (r4 <= 0.0f) goto L8;
        if (this.throttleFactor < this.throttleFactorMax) goto L12;
        r4 = -this.throttleFactorStep;
    L12:
        float r1 = this.throttleFactor + r4;
        this.throttleFactor = r1;
        if (r4 <= 0.0f) goto L15;
        this.throttleFactorMoveTrend = 1;
        float r5 = Math.min(r1, this.throttleFactorMax);
    L16:
        this.throttleFactor = r5;
        return;
    L15:
        this.throttleFactorMoveTrend = -1;
        r5 = Math.max(this.throttleFactorMin, r1);
        goto L16
    L8:
        if (r4 >= 0.0f) goto L12;
        if (this.throttleFactor > this.throttleFactorMin) goto L12;
        r4 = this.throttleFactorStep;
        goto L12
    }
}
