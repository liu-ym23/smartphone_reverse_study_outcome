package com.android.server.power.stats.processor;

import android.os.BatteryStats;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.format.DateFormat;
import android.util.IndentingPrintWriter;
import android.util.IntArray;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.TimeUtils;
import com.android.internal.os.PowerStats;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
class AggregatedPowerStats {
    private static final int MAX_CLOCK_UPDATES = 100;
    private static final String TAG = "AggregatedPowerStats";
    private static final String XML_TAG_AGGREGATED_POWER_STATS = "agg-power-stats";
    private final List<ClockUpdate> mClockUpdates;
    private final AggregatedPowerStatsConfig mConfig;
    private long mDurationMs;
    private final PowerComponentAggregatedPowerStats mGenericPowerComponent;
    private final SparseArray<PowerComponentAggregatedPowerStats> mPowerComponentStats;

    static class ClockUpdate {
        public long currentTime;
        public long monotonicTime;

        ClockUpdate() {
        }
    }

    AggregatedPowerStats(AggregatedPowerStatsConfig aggregatedPowerStatsConfig) {
        this(aggregatedPowerStatsConfig, new SparseBooleanArray());
    }

    AggregatedPowerStats(AggregatedPowerStatsConfig aggregatedPowerStatsConfig, SparseBooleanArray enabledComponents) {
        this.mClockUpdates = new ArrayList();
        this.mConfig = aggregatedPowerStatsConfig;
        List<AggregatedPowerStatsConfig.PowerComponent> configs = aggregatedPowerStatsConfig.getPowerComponentsAggregatedStatsConfigs();
        this.mPowerComponentStats = new SparseArray(configs.size());
        int i = 0;
    L4:
        if (i >= configs.size()) goto L9;
        AggregatedPowerStatsConfig.PowerComponent powerComponent = configs.get(i);
        if (enabledComponents.get(powerComponent.getPowerComponentId(), true) == false) goto L8;
        this.mPowerComponentStats.put(powerComponent.getPowerComponentId(), new PowerComponentAggregatedPowerStats(this, powerComponent));
    L8:
        i = i + 1;
        goto L4
    L9:
        this.mGenericPowerComponent = createGenericPowerComponent();
        this.mPowerComponentStats.put(-1, this.mGenericPowerComponent);
    }

    private PowerComponentAggregatedPowerStats createGenericPowerComponent() {
        AggregatedPowerStatsConfig.PowerComponent config = new AggregatedPowerStatsConfig.PowerComponent(-1);
        config.trackDeviceStates(new int[]{0, 1}).trackUidStates(new int[]{0, 1, 2});
        PowerComponentAggregatedPowerStats stats = new PowerComponentAggregatedPowerStats(this, config);
        stats.setPowerStatsDescriptor(new PowerStats.Descriptor(-1, 0, null, 0, 0, new PersistableBundle()));
        return stats;
    }

    boolean addClockUpdate(long monotonicTime, long currentTime) {
        ClockUpdate clockUpdate = new ClockUpdate();
        clockUpdate.monotonicTime = monotonicTime;
        clockUpdate.currentTime = currentTime;
        if (this.mClockUpdates.size() >= 100) goto L6;
        this.mClockUpdates.add(clockUpdate);
        return true;
    L6:
        Slog.i(TAG, "Too many clock updates. Replacing the previous update with " + DateFormat.format("yyyy-MM-dd-HH-mm-ss", currentTime));
        this.mClockUpdates.set(this.mClockUpdates.size() - 1, clockUpdate);
        return false;
    }

    long getStartTime() {
        if (this.mClockUpdates.isEmpty() == false) goto L7;
        return 0;
    L7:
        return this.mClockUpdates.get(0).monotonicTime;
    }

    public List<ClockUpdate> getClockUpdates() {
        return this.mClockUpdates;
    }

    void setDuration(long durationMs) {
        this.mDurationMs = durationMs;
    }

    public long getDuration() {
        return this.mDurationMs;
    }

    List<PowerComponentAggregatedPowerStats> getPowerComponentStats() {
        List<PowerComponentAggregatedPowerStats> list = new ArrayList(this.mPowerComponentStats.size());
        int i = 0;
    L4:
        if (i >= this.mPowerComponentStats.size()) goto L10;
        PowerComponentAggregatedPowerStats stats = this.mPowerComponentStats.valueAt(i);
        if (stats == this.mGenericPowerComponent) goto L8;
        list.add(stats);
    L8:
        i = i + 1;
        goto L4
    L10:
        return list;
    }

    PowerComponentAggregatedPowerStats getPowerComponentStats(int powerComponentId) {
        return this.mPowerComponentStats.get(powerComponentId);
    }

    void start(long timestampMs) {
        int i = 0;
    L4:
        if (i >= this.mPowerComponentStats.size()) goto L7;
        this.mPowerComponentStats.valueAt(i).start(timestampMs);
        i = i + 1;
        goto L4
    }

    void setDeviceState(int stateId, int state, long time) {
        int i = 0;
    L4:
        if (i >= this.mPowerComponentStats.size()) goto L7;
        this.mPowerComponentStats.valueAt(i).setState(stateId, state, time);
        i = i + 1;
        goto L4
    }

    void setUidState(int uid, int stateId, int state, long time) {
        int i = 0;
    L4:
        if (i >= this.mPowerComponentStats.size()) goto L7;
        this.mPowerComponentStats.valueAt(i).setUidState(uid, stateId, state, time);
        i = i + 1;
        goto L4
    }

    boolean isCompatible(PowerStats powerStats) {
        int powerComponentId = powerStats.descriptor.powerComponentId;
        PowerComponentAggregatedPowerStats stats = this.mPowerComponentStats.get(powerComponentId);
        if (stats != null) goto L5;
    L7:
        return false;
    L5:
        if (stats.isCompatible(powerStats) == false) goto L7;
        return true;
    }

    void addPowerStats(PowerStats powerStats, long time) {
        int powerComponentId = powerStats.descriptor.powerComponentId;
        PowerComponentAggregatedPowerStats stats = this.mPowerComponentStats.get(powerComponentId);
        if (stats != null) goto L8;
        AggregatedPowerStatsConfig.PowerComponent powerComponent = this.mConfig.createPowerComponent(powerComponentId);
        if (powerComponent != null) goto L7;
        return;
    L7:
        stats = new PowerComponentAggregatedPowerStats(this, powerComponent);
        stats.setPowerStatsDescriptor(powerStats.descriptor);
        stats.copyStatesFrom(this.mGenericPowerComponent);
        stats.start(time);
        this.mPowerComponentStats.put(powerComponentId, stats);
    L8:
        stats.addPowerStats(powerStats, time);
    }

    public void noteStateChange(BatteryStats.HistoryItem item) {
        int i = 0;
    L4:
        if (i >= this.mPowerComponentStats.size()) goto L7;
        this.mPowerComponentStats.valueAt(i).noteStateChange(item);
        i = i + 1;
        goto L4
    }

    public void noteBatteryLevel(int batteryLevel, int batteryChargeUah, long timestampMs) {
        int i = 0;
    L4:
        if (i >= this.mPowerComponentStats.size()) goto L7;
        this.mPowerComponentStats.valueAt(i).noteBatteryLevel(batteryLevel, batteryChargeUah, timestampMs);
        i = i + 1;
        goto L4
    }

    void finish(long timestampMs) {
        int i = 0;
    L4:
        if (i >= this.mPowerComponentStats.size()) goto L7;
        PowerComponentAggregatedPowerStats component = this.mPowerComponentStats.valueAt(i);
        component.finish(timestampMs);
        i = i + 1;
        goto L4
    }

    void reset() {
        this.mClockUpdates.clear();
        this.mDurationMs = 0;
        int i = 0;
    L4:
        if (i >= this.mPowerComponentStats.size()) goto L7;
        this.mPowerComponentStats.valueAt(i).reset();
        i = i + 1;
        goto L4
    }

    public void writeXml(TypedXmlSerializer serializer) throws IOException {
        serializer.startTag(null, XML_TAG_AGGREGATED_POWER_STATS);
        int i = 0;
    L4:
        if (i >= this.mPowerComponentStats.size()) goto L9;
        PowerComponentAggregatedPowerStats stats = this.mPowerComponentStats.valueAt(i);
        if (stats == this.mGenericPowerComponent) goto L8;
        stats.writeXml(serializer);
    L8:
        i = i + 1;
        goto L4
    L9:
        serializer.endTag(null, XML_TAG_AGGREGATED_POWER_STATS);
        serializer.flush();
    }

    public static AggregatedPowerStats createFromXml(TypedXmlPullParser parser, AggregatedPowerStatsConfig aggregatedPowerStatsConfig) throws XmlPullParserException, IOException {
        AggregatedPowerStats stats = new AggregatedPowerStats(aggregatedPowerStatsConfig);
        boolean inElement = false;
        boolean skipToEnd = false;
        int eventType = parser.getEventType();
    L3:
        byte r4 = 1;
        if (eventType == 1) goto L37;
        if (eventType == 3) goto L8;
    L9:
        if (skipToEnd == true) goto L36;
        if (eventType != 2) goto L36;
        String r5 = parser.getName();
        switch(r5.hashCode()) {
            case -925966781: goto L19;
            case 381213451: goto L16;
            default: goto L21;
        };
    L21:
        r4 = -1;
    L22:
        switch(r4) {
            case 0: goto L35;
            case 1: goto L24;
            default: goto L36;
        };
    L24:
        if (inElement == false) goto L36;
        int powerComponentId = parser.getAttributeInt(null, "id");
        PowerComponentAggregatedPowerStats powerComponentStats = stats.getPowerComponentStats(powerComponentId);
        if (powerComponentStats != null) goto L31;
        AggregatedPowerStatsConfig.PowerComponent powerComponent = aggregatedPowerStatsConfig.createPowerComponent(powerComponentId);
        if (powerComponent == null) goto L31;
        powerComponentStats = new PowerComponentAggregatedPowerStats(stats, powerComponent);
        stats.mPowerComponentStats.put(powerComponentId, powerComponentStats);
    L31:
        if (powerComponentStats == null) goto L36;
        if (powerComponentStats.readFromXml(parser) == true) goto L36;
        skipToEnd = true;
        goto L36
    L35:
        inElement = true;
        goto L36
    L16:
        if (r5.equals(XML_TAG_AGGREGATED_POWER_STATS) == false) goto L21;
        r4 = 0;
        goto L22
    L19:
        if (r5.equals("power_component") == false) goto L21;
    L36:
        eventType = parser.next();
        goto L3
    L8:
        if (parser.getName().equals(XML_TAG_AGGREGATED_POWER_STATS) == false) goto L9;
    L37:
        return stats;
    }

    void dump(IndentingPrintWriter ipw) {
        StringBuilder sb = new StringBuilder();
        long baseTime = 0;
        int i = 0;
    L3:
        int r5 = 0;
        if (i >= this.mClockUpdates.size()) goto L10;
        ClockUpdate clockUpdate = this.mClockUpdates.get(i);
        sb.setLength(0);
        if (i != 0) goto L8;
        baseTime = clockUpdate.monotonicTime;
        sb.append("Start time: ");
        sb.append(formatDateTime(clockUpdate.currentTime));
        sb.append(" (");
        sb.append(baseTime);
        sb.append(") duration: ");
        sb.append(this.mDurationMs);
        ipw.println(sb);
    L9:
        i = i + 1;
        goto L3
    L8:
        sb.setLength(0);
        sb.append("Clock update:  ");
        TimeUtils.formatDuration(clockUpdate.monotonicTime - baseTime, sb, 22);
        sb.append(" ");
        sb.append(formatDateTime(clockUpdate.currentTime));
        ipw.increaseIndent();
        ipw.println(sb);
        ipw.decreaseIndent();
        goto L9
    L10:
        ipw.println("Device");
        ipw.increaseIndent();
        int i2 = 0;
    L12:
        if (i2 >= this.mPowerComponentStats.size()) goto L14;
        this.mPowerComponentStats.valueAt(i2).dumpDevice(ipw);
        i2 = i2 + 1;
        goto L12
    L14:
        ipw.decreaseIndent();
        Set<Integer> uids = new HashSet();
        int i3 = 0;
    L16:
        if (i3 >= this.mPowerComponentStats.size()) goto L21;
        IntArray activeUids = this.mPowerComponentStats.valueAt(i3).getActiveUids();
        int j = activeUids.size() - 1;
    L18:
        if (j < 0) goto L20;
        uids.add(Integer.valueOf(activeUids.get(j)));
        j = j - 1;
        goto L18
    L20:
        i3 = i3 + 1;
        goto L16
    L21:
        int i4 = uids.size();
        Integer[] allUids = (Integer[]) uids.toArray(new Integer[i4]);
        Arrays.sort(allUids);
        int r6 = allUids.length;
    L22:
        if (r5 >= r6) goto L28;
        int uid = allUids[r5].intValue();
        ipw.println(UserHandle.formatUid(uid));
        ipw.increaseIndent();
        int i5 = 0;
    L25:
        if (i5 >= this.mPowerComponentStats.size()) goto L27;
        this.mPowerComponentStats.valueAt(i5).dumpUid(ipw, uid);
        i5 = i5 + 1;
        goto L25
    L27:
        ipw.decreaseIndent();
        r5 = r5 + 1;
        goto L22
    }

    private static String formatDateTime(long timeInMillis) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        format.getCalendar().setTimeZone(TimeZone.getTimeZone("GMT"));
        return format.format(new Date(timeInMillis));
    }

    public String toString() {
        StringWriter sw = new StringWriter();
        dump(new IndentingPrintWriter(sw));
        return sw.toString();
    }
}
