package com.android.server.power.stats.processor;

import android.os.PersistableBundle;
import com.android.internal.os.PowerStats;
import com.android.server.power.stats.format.AmbientDisplayPowerStatsLayout;
import com.android.server.power.stats.format.ScreenPowerStatsLayout;

/* JADX INFO: loaded from: classes3.dex */
class AmbientDisplayPowerStatsProcessor extends PowerStatsProcessor {
    private final PowerStats.Descriptor mDescriptor;
    private PowerStats.Descriptor mScreenPowerStatsDescriptor;
    private ScreenPowerStatsLayout mScreenPowerStatsLayout;
    private final AmbientDisplayPowerStatsLayout mStatsLayout;
    private final long[] mTmpDeviceStats;
    private long[] mTmpScreenStats;

    public static /* synthetic */ void $r8$lambda$__RZ2zU9M1rjNylkdjITQyRqVSs(AmbientDisplayPowerStatsProcessor r0, PowerComponentAggregatedPowerStats r1, PowerComponentAggregatedPowerStats r2, int[] r3) {
        r0.lambda$finish$0(r1, r2, r3);
    }

    AmbientDisplayPowerStatsProcessor() {
        this.mStatsLayout = new AmbientDisplayPowerStatsLayout();
        PersistableBundle extras = new PersistableBundle();
        this.mStatsLayout.toExtras(extras);
        this.mDescriptor = new PowerStats.Descriptor(15, this.mStatsLayout.getDeviceStatsArrayLength(), null, 0, 0, extras);
        this.mTmpDeviceStats = new long[this.mDescriptor.statsArrayLength];
    }

    @Override // com.android.server.power.stats.processor.PowerStatsProcessor
    void finish(final PowerComponentAggregatedPowerStats stats, long timestampMs) {
        stats.setPowerStatsDescriptor(this.mDescriptor);
        final PowerComponentAggregatedPowerStats screenStats = stats.getAggregatedPowerStats().getPowerComponentStats(0);
        if (screenStats != null) goto L5;
        return;
    L5:
        PowerStats.Descriptor screenDescriptor = screenStats.getPowerStatsDescriptor();
        if (screenDescriptor != null) goto L9;
        return;
    L9:
        if (this.mScreenPowerStatsDescriptor != null) goto L11;
    L12:
        this.mScreenPowerStatsDescriptor = screenDescriptor;
        this.mScreenPowerStatsLayout = new ScreenPowerStatsLayout(this.mScreenPowerStatsDescriptor);
        this.mTmpScreenStats = new long[this.mScreenPowerStatsDescriptor.statsArrayLength];
    L13:
        MultiStateStats.States[] deviceStateConfig = screenStats.getConfig().getDeviceStateConfig();
        MultiStateStats.States.forEachTrackedStateCombination(deviceStateConfig, new AmbientDisplayPowerStatsProcessor$$ExternalSyntheticLambda0(this, screenStats, stats));
        return;
    L11:
        if (this.mScreenPowerStatsDescriptor.equals(screenDescriptor) == true) goto L13;
        goto L12
    }

    private /* synthetic */ void lambda$finish$0(PowerComponentAggregatedPowerStats screenStats, PowerComponentAggregatedPowerStats stats, int[] states) {
        if (screenStats.getDeviceStats(this.mTmpScreenStats, states) == true) goto L5;
        return;
    L5:
        double power = this.mScreenPowerStatsLayout.getScreenDozePowerEstimate(this.mTmpScreenStats);
        if (power == 0.0d) goto L9;
        this.mStatsLayout.setDevicePowerEstimate(this.mTmpDeviceStats, power);
        stats.setDeviceStats(states, this.mTmpDeviceStats);
        return;
    }
}
