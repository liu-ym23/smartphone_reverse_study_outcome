package com.android.server.cpu;

import com.android.internal.util.Preconditions;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class CpuAvailabilityInfo {
    public static final int MISSING_CPU_AVAILABILITY_PERCENT = -1;
    public final int cpuset;
    public final long dataTimestampUptimeMillis;
    public final int latestAvgAvailabilityPercent;
    public final int pastNMillisAvgAvailabilityPercent;
    public final long pastNMillisDuration;

    public String toString() {
        return "CpuAvailabilityInfo{cpuset = " + this.cpuset + ", dataTimestampUptimeMillis = " + this.dataTimestampUptimeMillis + ", latestAvgAvailabilityPercent = " + this.latestAvgAvailabilityPercent + ", pastNMillisAvgAvailabilityPercent = " + this.pastNMillisAvgAvailabilityPercent + ", pastNMillisDuration = " + this.pastNMillisDuration + '}';
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if ((obj instanceof CpuAvailabilityInfo) == true) goto L8;
        return false;
    L8:
        CpuAvailabilityInfo info = (CpuAvailabilityInfo) obj;
        if (this.cpuset != info.cpuset) goto L20;
        if (this.dataTimestampUptimeMillis != info.dataTimestampUptimeMillis) goto L20;
        if (this.latestAvgAvailabilityPercent != info.latestAvgAvailabilityPercent) goto L20;
        if (this.pastNMillisAvgAvailabilityPercent != info.pastNMillisAvgAvailabilityPercent) goto L20;
        if (this.pastNMillisDuration != info.pastNMillisDuration) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.cpuset), Long.valueOf(this.dataTimestampUptimeMillis), Integer.valueOf(this.latestAvgAvailabilityPercent), Integer.valueOf(this.pastNMillisAvgAvailabilityPercent), Long.valueOf(this.pastNMillisDuration)});
    }

    CpuAvailabilityInfo(int cpuset, long dataTimestampUptimeMillis, int latestAvgAvailabilityPercent, int pastNMillisAvgAvailabilityPercent, long pastNMillisDuration) {
        this.cpuset = Preconditions.checkArgumentInRange(cpuset, 1, 2, "cpuset");
        this.dataTimestampUptimeMillis = Preconditions.checkArgumentNonnegative(dataTimestampUptimeMillis);
        this.latestAvgAvailabilityPercent = Preconditions.checkArgumentNonnegative(latestAvgAvailabilityPercent);
        this.pastNMillisAvgAvailabilityPercent = pastNMillisAvgAvailabilityPercent;
        this.pastNMillisDuration = Preconditions.checkArgumentNonnegative(pastNMillisDuration);
    }
}
