package com.android.server.power.stats;

import android.os.Handler;
import android.os.PersistableBundle;
import com.android.internal.os.Clock;
import com.android.internal.os.PowerStats;
import com.android.server.power.stats.format.EnergyConsumerPowerStatsLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class EnergyConsumerPowerStatsCollector extends PowerStatsCollector {
    private static final int UNSPECIFIED = -1;
    private PowerStatsCollector.ConsumedEnergyHelper mConsumedEnergyHelper;
    private final int mEnergyConsumerId;
    private final int mEnergyConsumerType;
    private final Injector mInjector;
    private boolean mIsInitialized;
    private long mLastUpdateTimestamp;
    private final EnergyConsumerPowerStatsLayout mLayout;
    private final int mPowerComponentId;
    private final String mPowerComponentName;
    private PowerStats mPowerStats;

    public interface Injector {
        Clock getClock();

        PowerStatsCollector.ConsumedEnergyRetriever getConsumedEnergyRetriever();

        Handler getHandler();

        long getPowerStatsCollectionThrottlePeriod(String r1);

        PowerStatsUidResolver getUidResolver();
    }

    EnergyConsumerPowerStatsCollector(Injector injector, int powerComponentId, String powerComponentName, int energyConsumerType, EnergyConsumerPowerStatsLayout statsLayout) {
        this(injector, powerComponentId, powerComponentName, energyConsumerType, -1, statsLayout);
    }

    EnergyConsumerPowerStatsCollector(Injector injector, int powerComponentId, String powerComponentName, int energyConsumerType, int energyConsumerId, EnergyConsumerPowerStatsLayout statsLayout) {
        super(injector.getHandler(), injector.getPowerStatsCollectionThrottlePeriod(powerComponentName), injector.getUidResolver(), injector.getClock());
        this.mInjector = injector;
        this.mPowerComponentId = powerComponentId;
        this.mPowerComponentName = powerComponentName;
        this.mEnergyConsumerId = energyConsumerId;
        this.mEnergyConsumerType = energyConsumerType;
        this.mLayout = statsLayout;
    }

    private boolean ensureInitialized() {
        if (this.mIsInitialized == false) goto L6;
        return true;
    L6:
        if (isEnabled() == true) goto L10;
        return false;
    L10:
        if (this.mEnergyConsumerId == (-1)) goto L12;
        this.mConsumedEnergyHelper = new PowerStatsCollector.ConsumedEnergyHelper(this, this.mInjector.getConsumedEnergyRetriever(), this.mEnergyConsumerId, true);
    L13:
        PersistableBundle extras = new PersistableBundle();
        this.mLayout.toExtras(extras);
        PowerStats.Descriptor powerStatsDescriptor = new PowerStats.Descriptor(this.mPowerComponentId, this.mPowerComponentName, this.mLayout.getDeviceStatsArrayLength(), null, 0, this.mLayout.getUidStatsArrayLength(), extras);
        this.mPowerStats = new PowerStats(powerStatsDescriptor);
        this.mIsInitialized = true;
        return true;
    L12:
        this.mConsumedEnergyHelper = new PowerStatsCollector.ConsumedEnergyHelper(this, this.mInjector.getConsumedEnergyRetriever(), this.mEnergyConsumerType);
        goto L13
    }

    @Override // com.android.server.power.stats.PowerStatsCollector
    protected PowerStats collectStats() {
        if (ensureInitialized() == true) goto L5;
        return null;
    L5:
        Arrays.fill(this.mPowerStats.stats, 0);
        this.mPowerStats.uidStats.clear();
        if (this.mConsumedEnergyHelper.collectConsumedEnergy(this.mPowerStats, this.mLayout) == true) goto L8;
        return null;
    L8:
        long timestamp = this.mClock.elapsedRealtime();
        PowerStats r2 = this.mPowerStats;
        r2.durationMs = timestamp - this.mLastUpdateTimestamp;
        this.mLastUpdateTimestamp = timestamp;
        return this.mPowerStats;
    }
}
