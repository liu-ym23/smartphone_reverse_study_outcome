package com.android.server.power.stats;

import com.android.server.power.stats.format.EnergyConsumerPowerStatsLayout;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CustomEnergyConsumerPowerStatsCollector extends PowerStatsCollector {
    private static final EnergyConsumerPowerStatsLayout sLayout = null;
    private List<EnergyConsumerPowerStatsCollector> mCollectors;
    private final EnergyConsumerPowerStatsCollector.Injector mInjector;

    static {
        sLayout = new EnergyConsumerPowerStatsLayout();
    }

    public CustomEnergyConsumerPowerStatsCollector(EnergyConsumerPowerStatsCollector.Injector injector) {
        super(injector.getHandler(), 0, injector.getUidResolver(), injector.getClock());
        this.mInjector = injector;
    }

    protected void ensureInitialized() {
        if (this.mCollectors == null) goto L5;
        return;
    L5:
        PowerStatsCollector.ConsumedEnergyRetriever retriever = this.mInjector.getConsumedEnergyRetriever();
        int[] energyConsumerIds = retriever.getEnergyConsumerIds(0);
        int powerComponentId = 1000;
        this.mCollectors = new ArrayList(energyConsumerIds.length);
        int i = 0;
    L6:
        int powerComponentId2 = powerComponentId;
        int powerComponentId3 = energyConsumerIds.length;
        if (i >= powerComponentId3) goto L10;
        String name = retriever.getEnergyConsumerName(energyConsumerIds[i]);
        powerComponentId = powerComponentId2 + 1;
        EnergyConsumerPowerStatsCollector collector = new EnergyConsumerPowerStatsCollector(this.mInjector, powerComponentId2, name, 0, energyConsumerIds[i], sLayout);
        collector.setEnabled(true);
        collector.addConsumer(new CustomEnergyConsumerPowerStatsCollector$$ExternalSyntheticLambda0(this));
        this.mCollectors.add(collector);
        i = i + 1;
        goto L6
    }

    @Override // com.android.server.power.stats.PowerStatsCollector
    public boolean schedule() {
        if (isEnabled() == true) goto L6;
        return false;
    L6:
        ensureInitialized();
        boolean success = false;
        int i = 0;
    L8:
        if (i >= this.mCollectors.size()) goto L11;
        success = success | this.mCollectors.get(i).schedule();
        i = i + 1;
        goto L8
    L11:
        return success;
    }

    @Override // com.android.server.power.stats.PowerStatsCollector
    public boolean forceSchedule() {
        ensureInitialized();
        boolean success = false;
        int i = 0;
    L4:
        if (i >= this.mCollectors.size()) goto L7;
        success = success | this.mCollectors.get(i).forceSchedule();
        i = i + 1;
        goto L4
    L7:
        return success;
    }

    @Override // com.android.server.power.stats.PowerStatsCollector
    public void collectAndDump(PrintWriter pw) {
        ensureInitialized();
        int i = 0;
    L4:
        if (i >= this.mCollectors.size()) goto L7;
        this.mCollectors.get(i).collectAndDump(pw);
        i = i + 1;
        goto L4
    }
}
