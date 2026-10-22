package com.android.server.power.stats.processor;

import android.util.IndentingPrintWriter;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.power.stats.PowerStatsSpan;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
class AggregatedPowerStatsSection extends PowerStatsSpan.Section {
    public static final String TYPE = "aggregated-power-stats";
    private final AggregatedPowerStats mAggregatedPowerStats;

    static class Reader implements PowerStatsSpan.SectionReader {
        private final AggregatedPowerStatsConfig mAggregatedPowerStatsConfig;

        Reader(AggregatedPowerStatsConfig config) {
            this.mAggregatedPowerStatsConfig = config;
        }

        @Override // com.android.server.power.stats.PowerStatsSpan.SectionReader
        public String getType() {
            return AggregatedPowerStatsSection.TYPE;
        }

        @Override // com.android.server.power.stats.PowerStatsSpan.SectionReader
        public PowerStatsSpan.Section read(String sectionType, TypedXmlPullParser parser) throws IOException, XmlPullParserException {
            return new AggregatedPowerStatsSection(AggregatedPowerStats.createFromXml(parser, this.mAggregatedPowerStatsConfig));
        }
    }

    AggregatedPowerStatsSection(AggregatedPowerStats aggregatedPowerStats) {
        super(TYPE);
        this.mAggregatedPowerStats = aggregatedPowerStats;
    }

    public AggregatedPowerStats getAggregatedPowerStats() {
        return this.mAggregatedPowerStats;
    }

    @Override // com.android.server.power.stats.PowerStatsSpan.Section
    public void write(TypedXmlSerializer serializer) throws IOException {
        this.mAggregatedPowerStats.writeXml(serializer);
    }

    @Override // com.android.server.power.stats.PowerStatsSpan.Section
    public void dump(IndentingPrintWriter ipw) {
        this.mAggregatedPowerStats.dump(ipw);
    }
}
