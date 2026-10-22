package com.stepos.perfsched;

import android.content.Context;
import com.stepos.framework.annotations.StepOSStubHead;
import com.stepos.framework.utils.StepOSFrameworkStubUtils;

@StepOSStubHead(manifestName = "com.stepos.framework.impl.StepOSFrameworkStubImplMap_Services")
/* loaded from: classes.dex */
public interface PerfSchedServiceStub {
    public static final int HANDLE_ALL = -1;

    int acquireAiCpuSet(AiCpuSetConfig aiCpuSetConfig);

    int acquireIOLimit(IOLimitConfig iOLimitConfig);

    int acquireSpeedSched(SpeedSchedConfig speedSchedConfig);

    void onInit(Context context);

    boolean perfBoost(BoostConfig boostConfig);

    int perfRelease(int i);

    int releaseAiCpuSet(int i);

    int releaseIOLimit(int i);

    int releaseSpeedSched(int i);

    int releaseSpeedSched(int i, SpeedSchedConfig speedSchedConfig);

    static PerfSchedServiceStub get() {
        return (PerfSchedServiceStub) StepOSFrameworkStubUtils.getInstance(PerfSchedServiceStub.class);
    }

    static PerfSchedServiceStub init(Context context) {
        PerfSchedServiceStub stub = get();
        stub.onInit(context);
        return stub;
    }
}
