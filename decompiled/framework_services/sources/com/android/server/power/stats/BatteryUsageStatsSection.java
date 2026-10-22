package com.android.server.power.stats;

import android.os.BatteryUsageStats;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
class BatteryUsageStatsSection extends PowerStatsSpan.Section {
    private static final String TAG = "BatteryUsageStatsSection";
    public static final String TYPE = "battery-usage-stats";
    private final BatteryUsageStats mBatteryUsageStats;

    static class Reader implements PowerStatsSpan.SectionReader {
        Reader() {
        }

        @Override // com.android.server.power.stats.PowerStatsSpan.SectionReader
        public String getType() {
            return BatteryUsageStatsSection.TYPE;
        }

        @Override // com.android.server.power.stats.PowerStatsSpan.SectionReader
        public PowerStatsSpan.Section read(String sectionType, TypedXmlPullParser parser) throws IOException, XmlPullParserException {
            return new BatteryUsageStatsSection(BatteryUsageStats.createFromXml(parser));
        }
    }

    BatteryUsageStatsSection(BatteryUsageStats batteryUsageStats) {
        super(TYPE);
        this.mBatteryUsageStats = batteryUsageStats;
    }

    public BatteryUsageStats getBatteryUsageStats() {
        return this.mBatteryUsageStats;
    }

    @Override // com.android.server.power.stats.PowerStatsSpan.Section
    public void write(TypedXmlSerializer serializer) throws IOException {
        this.mBatteryUsageStats.writeXml(serializer);
    }

    @Override // com.android.server.power.stats.PowerStatsSpan.Section
    public void dump(IndentingPrintWriter ipw) {
        this.mBatteryUsageStats.dump(ipw, "");
    }

    @Override // com.android.server.power.stats.PowerStatsSpan.Section
    public void close() {
        this.mBatteryUsageStats.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Closing BatteryUsageStats", e);
    }
}
