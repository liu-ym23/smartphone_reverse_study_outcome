package com.android.server.cpu;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class CpuMonitorInternal {

    public interface CpuAvailabilityCallback {
        void onAvailabilityChanged(CpuAvailabilityInfo r1);

        void onMonitoringIntervalChanged(long r1);
    }

    public abstract void addCpuAvailabilityCallback(Executor r1, CpuAvailabilityMonitoringConfig r2, CpuAvailabilityCallback r3);

    public abstract void removeCpuAvailabilityCallback(CpuAvailabilityCallback r1);

    public CpuMonitorInternal() {
    }
}
