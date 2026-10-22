package com.android.server.cpu;

import android.util.IntArray;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class CpuAvailabilityMonitoringConfig {
    public static final int CPUSET_ALL = 1;
    public static final int CPUSET_BACKGROUND = 2;
    public final int cpuset;
    private final IntArray mThresholds;

    public static final class Builder {
        private final int mCpuset;
        private final IntArray mThresholds;

        /* JADX INFO: renamed from: -$$Nest$fgetmCpuset, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m3258$$Nest$fgetmCpuset(Builder r0) {
            return r0.mCpuset;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmThresholds, reason: not valid java name */
        static /* bridge */ /* synthetic */ IntArray m3259$$Nest$fgetmThresholds(Builder r0) {
            return r0.mThresholds;
        }

        public Builder(int cpuset, int... thresholds) {
            this.mThresholds = new IntArray();
            this.mCpuset = cpuset;
            int r0 = thresholds.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            int threshold = thresholds[r1];
            addThreshold(threshold);
            r1 = r1 + 1;
            goto L3
        }

        public Builder addThreshold(int threshold) {
            if (this.mThresholds.indexOf(threshold) != (-1)) goto L5;
            this.mThresholds.add(threshold);
        L5:
            return this;
        }

        public CpuAvailabilityMonitoringConfig build() {
            return new CpuAvailabilityMonitoringConfig(this, null);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Cpuset {
    }

    /* synthetic */ CpuAvailabilityMonitoringConfig(Builder r1, CpuAvailabilityMonitoringConfigIA r2) {
        this(r1);
    }

    public IntArray getThresholds() {
        return this.mThresholds;
    }

    public String toString() {
        return "CpuAvailabilityMonitoringConfig{cpuset=" + toCpusetString(this.cpuset) + ", mThresholds=" + this.mThresholds + ')';
    }

    public static String toCpusetString(int cpuset) {
        switch(cpuset) {
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "CPUSET_BACKGROUND";
    L7:
        return "CPUSET_ALL";
    L4:
        return "Invalid cpuset: " + cpuset;
    }

    private CpuAvailabilityMonitoringConfig(Builder builder) {
        if (Builder.m3258$$Nest$fgetmCpuset(builder) == 1) goto L10;
        if (Builder.m3258$$Nest$fgetmCpuset(builder) == 2) goto L10;
        throw new IllegalStateException("Cpuset must be either CPUSET_ALL (1) or CPUSET_BACKGROUND (2). Builder contains " + Builder.m3258$$Nest$fgetmCpuset(builder));
    L10:
        if (Builder.m3259$$Nest$fgetmThresholds(builder).size() == 0) goto L14;
        this.cpuset = Builder.m3258$$Nest$fgetmCpuset(builder);
        this.mThresholds = Builder.m3259$$Nest$fgetmThresholds(builder).clone();
        return;
    L14:
        throw new IllegalStateException("Must provide at least one threshold");
    }
}
