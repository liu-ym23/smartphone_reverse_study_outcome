package com.android.server.power.stats.processor;

import android.os.PersistableBundle;
import com.android.internal.os.PowerStats;
import com.android.server.power.stats.format.MobileRadioPowerStatsLayout;
import com.android.server.power.stats.format.PhoneCallPowerStatsLayout;

/* JADX INFO: loaded from: classes3.dex */
class PhoneCallPowerStatsProcessor extends PowerStatsProcessor {
    private final PowerStats.Descriptor mDescriptor;
    private PowerStats.Descriptor mMobileRadioStatsDescriptor;
    private MobileRadioPowerStatsLayout mMobileRadioStatsLayout;
    private final PhoneCallPowerStatsLayout mStatsLayout;
    private final long[] mTmpDeviceStats;
    private long[] mTmpMobileRadioDeviceStats;

    public static /* synthetic */ void $r8$lambda$ud8eQ1V0t_QmX6ROLeagntpmWa8(PhoneCallPowerStatsProcessor r0, PowerComponentAggregatedPowerStats r1, PowerComponentAggregatedPowerStats r2, int[] r3) {
        r0.lambda$finish$0(r1, r2, r3);
    }

    PhoneCallPowerStatsProcessor() {
        this.mStatsLayout = new PhoneCallPowerStatsLayout();
        PersistableBundle extras = new PersistableBundle();
        this.mStatsLayout.toExtras(extras);
        this.mDescriptor = new PowerStats.Descriptor(14, this.mStatsLayout.getDeviceStatsArrayLength(), null, 0, 0, extras);
        this.mTmpDeviceStats = new long[this.mDescriptor.statsArrayLength];
    }

    private boolean unpackMobileRadioStatsDescriptor(PowerStats.Descriptor descriptor) {
        if (descriptor != null) goto L6;
        return false;
    L6:
        if (descriptor.equals(this.mMobileRadioStatsDescriptor) == false) goto L8;
        return true;
    L8:
        this.mMobileRadioStatsDescriptor = descriptor;
        this.mMobileRadioStatsLayout = new MobileRadioPowerStatsLayout(this.mMobileRadioStatsDescriptor);
        this.mTmpMobileRadioDeviceStats = new long[this.mMobileRadioStatsDescriptor.statsArrayLength];
        return true;
    }

    @Override // com.android.server.power.stats.processor.PowerStatsProcessor
    void finish(final PowerComponentAggregatedPowerStats stats, long timestampMs) {
        stats.setPowerStatsDescriptor(this.mDescriptor);
        final PowerComponentAggregatedPowerStats mobileRadioStats = stats.getAggregatedPowerStats().getPowerComponentStats(8);
        if (mobileRadioStats != null) goto L6;
        return;
    L6:
        if (unpackMobileRadioStatsDescriptor(mobileRadioStats.getPowerStatsDescriptor()) == true) goto L8;
        return;
    L8:
        MultiStateStats.States[] deviceStateConfig = mobileRadioStats.getConfig().getDeviceStateConfig();
        MultiStateStats.States.forEachTrackedStateCombination(deviceStateConfig, new PhoneCallPowerStatsProcessor$$ExternalSyntheticLambda0(this, mobileRadioStats, stats));
    }

    private /* synthetic */ void lambda$finish$0(PowerComponentAggregatedPowerStats mobileRadioStats, PowerComponentAggregatedPowerStats stats, int[] states) {
        if (mobileRadioStats.getDeviceStats(this.mTmpMobileRadioDeviceStats, states) == true) goto L5;
        return;
    L5:
        double callPowerEstimate = this.mMobileRadioStatsLayout.getDeviceCallPowerEstimate(this.mTmpMobileRadioDeviceStats);
        if (callPowerEstimate == 0.0d) goto L9;
        this.mStatsLayout.setDevicePowerEstimate(this.mTmpDeviceStats, callPowerEstimate);
        stats.setDeviceStats(states, this.mTmpDeviceStats);
        return;
    }
}
