package com.android.server.power.stats;

import android.os.BatteryUsageStats;
import android.util.IndentingPrintWriter;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
class AccumulatedBatteryUsageStatsSection extends PowerStatsSpan.Section {
    public static final long ID = Long.MAX_VALUE;
    public static final String TYPE = "accumulated-battery-usage-stats";
    private final BatteryUsageStats.Builder mBatteryUsageStats;

    static class Reader implements PowerStatsSpan.SectionReader {
        Reader() {
        }

        @Override // com.android.server.power.stats.PowerStatsSpan.SectionReader
        public String getType() {
            return AccumulatedBatteryUsageStatsSection.TYPE;
        }

        @Override // com.android.server.power.stats.PowerStatsSpan.SectionReader
        public PowerStatsSpan.Section read(String sectionType, TypedXmlPullParser parser) throws IOException, XmlPullParserException {
            return new AccumulatedBatteryUsageStatsSection(BatteryUsageStats.createBuilderFromXml(parser));
        }
    }

    AccumulatedBatteryUsageStatsSection(BatteryUsageStats.Builder batteryUsageStats) {
        super(TYPE);
        this.mBatteryUsageStats = batteryUsageStats;
    }

    public BatteryUsageStats.Builder getBatteryUsageStatsBuilder() {
        return this.mBatteryUsageStats;
    }

    @Override // com.android.server.power.stats.PowerStatsSpan.Section
    public void write(TypedXmlSerializer serializer) throws IOException {
        this.mBatteryUsageStats.build().writeXml(serializer);
    }

    @Override // com.android.server.power.stats.PowerStatsSpan.Section
    public void dump(IndentingPrintWriter ipw) {
        this.mBatteryUsageStats.build().dump(ipw, "");
    }

    @Override // com.android.server.power.stats.PowerStatsSpan.Section
    public void close() {
        this.mBatteryUsageStats.discard();
    }
}
