package com.stepos.core.common.telemetry;

import com.stepos.core.common.utils.SysfsReader;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CpuFreqSampler {
    public static final CpuFreqSampler INSTANCE = new CpuFreqSampler();
    private static final String PATH = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";

    private CpuFreqSampler() {
    }

    public final int readKhz() {
        Integer num = SysfsReader.INSTANCE.readInt(PATH);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }
}
