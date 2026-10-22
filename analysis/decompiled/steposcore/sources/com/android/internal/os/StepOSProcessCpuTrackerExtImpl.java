package com.android.internal.os;

/* loaded from: classes.dex */
public class StepOSProcessCpuTrackerExtImpl implements IStepOSProcessCpuTrackerExt {
    private ProcessCpuTracker mHost;

    public void onAttach(ProcessCpuTracker host) {
        this.mHost = host;
    }

    public float getLoad1() {
        if (this.mHost != null) {
            return this.mHost.mProcessCpuTrackerInner.getLoad1();
        }
        return 0.0f;
    }

    public float getLoad5() {
        if (this.mHost != null) {
            return this.mHost.mProcessCpuTrackerInner.getLoad5();
        }
        return 0.0f;
    }
}
