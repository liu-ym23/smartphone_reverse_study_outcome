package com.android.server.power.stats.processor;

import android.os.BatteryStats;
import android.os.UserHandle;
import android.util.IndentingPrintWriter;
import android.util.IntArray;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.os.PowerStats;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.function.IntConsumer;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
class PowerComponentAggregatedPowerStats {
    private static final String TAG = "AggregatePowerStats";
    private static final long UNKNOWN = -1;
    static final String XML_ATTR_ID = "id";
    private static final String XML_ATTR_KEY = "key";
    private static final String XML_ATTR_UID = "uid";
    private static final String XML_TAG_DEVICE_STATS = "device-stats";
    static final String XML_TAG_POWER_COMPONENT = "power_component";
    private static final String XML_TAG_STATE_STATS = "state-stats";
    private static final String XML_TAG_UID_STATS = "uid-stats";
    private final AggregatedPowerStats mAggregatedPowerStats;
    private final AggregatedPowerStatsConfig.PowerComponent mConfig;
    private final MultiStateStats.States[] mDeviceStateConfig;
    private final int[] mDeviceStates;
    private MultiStateStats mDeviceStats;
    private PowerStats.Descriptor mPowerStatsDescriptor;
    private long mPowerStatsTimestamp;
    private PowerStatsProcessor mProcessor;
    private final SparseArray<MultiStateStats> mStateStats;
    private MultiStateStats.Factory mStateStatsFactory;
    private MultiStateStats.Factory mStatsFactory;
    private final MultiStateStats.States[] mUidStateConfig;
    private final SparseArray<UidStats> mUidStats;
    private MultiStateStats.Factory mUidStatsFactory;
    public final int powerComponentId;

    private static class UidStats {
        public boolean hasPowerStats;
        public int[] states;
        public MultiStateStats stats;
        public boolean updated;

        /* synthetic */ UidStats(PowerComponentAggregatedPowerStatsIA r1) {
            this();
        }

        private UidStats() {
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$7vmA-6OlmvfK7cBqd4VhMaSVnDY, reason: not valid java name */
    public static /* synthetic */ void m7864$r8$lambda$7vmA6OlmvfK7cBqd4VhMaSVnDY(MultiStateStats r0, long[] r1, boolean[] r2, IndentingPrintWriter r3, String r4, MultiStateStats.States[] r5, String r6, PowerStats.PowerStatsFormatter r7, int[] r8) {
        lambda$dumpMultiStateStats$0(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    PowerComponentAggregatedPowerStats(AggregatedPowerStats aggregatedPowerStats, AggregatedPowerStatsConfig.PowerComponent config) {
        this.mStateStats = new SparseArray();
        this.mUidStats = new SparseArray();
        this.mAggregatedPowerStats = aggregatedPowerStats;
        this.mConfig = config;
        this.powerComponentId = config.getPowerComponentId();
        this.mDeviceStateConfig = config.getDeviceStateConfig();
        this.mUidStateConfig = config.getUidStateConfig();
        this.mDeviceStates = new int[this.mDeviceStateConfig.length];
        this.mPowerStatsTimestamp = -1;
    }

    AggregatedPowerStats getAggregatedPowerStats() {
        return this.mAggregatedPowerStats;
    }

    public AggregatedPowerStatsConfig.PowerComponent getConfig() {
        return this.mConfig;
    }

    public PowerStats.Descriptor getPowerStatsDescriptor() {
        return this.mPowerStatsDescriptor;
    }

    public void setPowerStatsDescriptor(PowerStats.Descriptor powerStatsDescriptor) {
        this.mPowerStatsDescriptor = powerStatsDescriptor;
    }

    void start(long timestampMs) {
        if (this.mProcessor != null) goto L5;
        this.mProcessor = this.mConfig.createProcessor();
    L5:
        this.mProcessor.start(this, timestampMs);
    }

    void finish(long timestampMs) {
        this.mProcessor.finish(this, timestampMs);
    }

    void noteStateChange(BatteryStats.HistoryItem item) {
        this.mProcessor.noteStateChange(this, item);
    }

    public void noteBatteryLevel(int batteryLevel, int batteryChargeUah, long timestampMs) {
        this.mProcessor.noteBatteryLevel(batteryLevel, batteryChargeUah, timestampMs);
    }

    void setState(int stateId, int state, long timestampMs) {
        if (this.mDeviceStats != null) goto L5;
        createDeviceStats(timestampMs);
    L5:
        this.mDeviceStates[stateId] = state;
        if (this.mDeviceStateConfig[stateId].isTracked() == true) goto L8;
    L13:
        int uidStateId = MultiStateStats.States.findTrackedStateByName(this.mUidStateConfig, this.mDeviceStateConfig[stateId].getName());
        if (uidStateId != (-1)) goto L16;
        return;
    L16:
        if (this.mUidStateConfig[uidStateId].isTracked() == false) goto L31;
        int i = this.mUidStats.size() - 1;
    L18:
        if (i < 0) goto L32;
        UidStats uidStats = this.mUidStats.valueAt(i);
        if (uidStats.stats != null) goto L22;
        createUidStats(uidStats, timestampMs);
    L22:
        uidStats.states[uidStateId] = state;
        if (uidStats.stats == null) goto L25;
        uidStats.stats.setState(uidStateId, state, timestampMs);
    L25:
        i = i - 1;
        goto L18
    L32:
        return;
    L31:
        return;
    L8:
        if (this.mDeviceStats == null) goto L10;
        this.mDeviceStats.setState(stateId, state, timestampMs);
    L10:
        int i2 = this.mStateStats.size() - 1;
    L11:
        if (i2 < 0) goto L13;
        MultiStateStats stateStats = this.mStateStats.valueAt(i2);
        stateStats.setState(stateId, state, timestampMs);
        i2 = i2 - 1;
        goto L11
    }

    void setUidState(int uid, int stateId, int state, long timestampMs) {
        this.mProcessor.setUidState(this, uid, stateId, state, timestampMs);
    }

    void setProcessedUidState(int uid, int stateId, int state, long timestampMs) {
        if (this.mUidStateConfig[stateId].isTracked() == true) goto L5;
        return;
    L5:
        UidStats uidStats = getUidStats(uid);
        if (uidStats.stats != null) goto L8;
        createUidStats(uidStats, timestampMs);
    L8:
        uidStats.states[stateId] = state;
        if (uidStats.stats == null) goto L12;
        uidStats.stats.setState(stateId, state, timestampMs);
        return;
    }

    void setDeviceStats(int[] states, long[] values) {
        if (this.mDeviceStats != null) goto L5;
        createDeviceStats(0);
    L5:
        this.mDeviceStats.setStats(states, values);
    }

    void setUidStats(int uid, int[] states, long[] values) {
        UidStats uidStats = getUidStats(uid);
        if (uidStats.stats != null) goto L5;
        createUidStats(uidStats, this.mPowerStatsTimestamp);
    L5:
        uidStats.hasPowerStats = true;
        uidStats.stats.setStats(states, values);
    }

    boolean isCompatible(PowerStats powerStats) {
        if (this.mPowerStatsDescriptor != null) goto L5;
    L8:
        return true;
    L5:
        if (this.mPowerStatsDescriptor.equals(powerStats.descriptor) == true) goto L8;
        return false;
    }

    void addPowerStats(PowerStats powerStats, long timestampMs) {
        this.mProcessor.addPowerStats(this, powerStats, timestampMs);
    }

    void addProcessedPowerStats(PowerStats powerStats, long timestampMs) {
        this.mPowerStatsDescriptor = powerStats.descriptor;
        if (this.mDeviceStats != null) goto L5;
        createDeviceStats(timestampMs);
    L5:
        int i = powerStats.stateStats.size() - 1;
    L6:
        if (i < 0) goto L11;
        int key = powerStats.stateStats.keyAt(i);
        MultiStateStats stateStats = this.mStateStats.get(key);
        if (stateStats != null) goto L10;
        stateStats = createStateStats(key, timestampMs);
    L10:
        stateStats.increment((long[]) powerStats.stateStats.valueAt(i), timestampMs);
        i = i - 1;
        goto L6
    L11:
        this.mDeviceStats.increment(powerStats.stats, timestampMs);
        int i2 = powerStats.uidStats.size() - 1;
    L12:
        if (i2 < 0) goto L17;
        int uid = powerStats.uidStats.keyAt(i2);
        UidStats uidStats = getUidStats(uid);
        if (uidStats.stats != null) goto L16;
        createUidStats(uidStats, timestampMs);
    L16:
        uidStats.stats.increment((long[]) powerStats.uidStats.valueAt(i2), timestampMs);
        uidStats.updated = true;
        uidStats.hasPowerStats = true;
        i2 = i2 - 1;
        goto L12
    L17:
        int i3 = this.mUidStats.size() - 1;
    L18:
        if (i3 < 0) goto L25;
        UidStats uidStats2 = this.mUidStats.valueAt(i3);
        if (uidStats2.updated == true) goto L24;
        if (uidStats2.stats == null) goto L24;
        uidStats2.stats.increment(null, timestampMs);
    L24:
        uidStats2.updated = false;
        i3 = i3 - 1;
        goto L18
    L25:
        this.mPowerStatsTimestamp = timestampMs;
    }

    void reset() {
        this.mStatsFactory = null;
        this.mUidStatsFactory = null;
        this.mDeviceStats = null;
        this.mStateStats.clear();
        int i = this.mUidStats.size() - 1;
    L3:
        if (i < 0) goto L6;
        this.mUidStats.valueAt(i).stats = null;
        this.mUidStats.valueAt(i).hasPowerStats = false;
        i = i - 1;
        goto L3
    }

    private UidStats getUidStats(int uid) {
        UidStats uidStats = this.mUidStats.get(uid);
        if (uidStats != null) goto L16;
        uidStats = new UidStats(null);
        uidStats.states = new int[this.mUidStateConfig.length];
        int stateId = 0;
    L6:
        if (stateId >= this.mUidStateConfig.length) goto L15;
        if (this.mUidStateConfig[stateId].isTracked() == false) goto L14;
        int deviceStateId = MultiStateStats.States.findTrackedStateByName(this.mDeviceStateConfig, this.mUidStateConfig[stateId].getName());
        if (deviceStateId == (-1)) goto L14;
        if (this.mDeviceStateConfig[deviceStateId].isTracked() == false) goto L14;
        uidStats.states[stateId] = this.mDeviceStates[deviceStateId];
    L14:
        stateId = stateId + 1;
        goto L6
    L15:
        this.mUidStats.put(uid, uidStats);
    L16:
        return uidStats;
    }

    IntArray getUids() {
        IntArray uids = new IntArray(this.mUidStats.size());
        int i = this.mUidStats.size() - 1;
    L3:
        if (i < 0) goto L9;
        UidStats uidStats = this.mUidStats.valueAt(i);
        if (uidStats.stats == null) goto L7;
        uids.add(this.mUidStats.keyAt(i));
    L7:
        i = i - 1;
        goto L3
    L9:
        return uids;
    }

    IntArray getActiveUids() {
        IntArray uids = new IntArray(this.mUidStats.size());
        int i = this.mUidStats.size() - 1;
    L3:
        if (i < 0) goto L9;
        UidStats uidStats = this.mUidStats.valueAt(i);
        if (uidStats.hasPowerStats == false) goto L7;
        uids.add(this.mUidStats.keyAt(i));
    L7:
        i = i - 1;
        goto L3
    L9:
        return uids;
    }

    boolean getDeviceStats(long[] outValues, int[] deviceStates) {
        if (deviceStates.length != this.mDeviceStateConfig.length) goto L11;
        if (this.mDeviceStats != null) goto L7;
        return false;
    L7:
        return this.mDeviceStats.getStats(outValues, deviceStates);
    L11:
        throw new IllegalArgumentException("Invalid number of tracked states: " + deviceStates.length + " expected: " + this.mDeviceStateConfig.length);
    }

    boolean getStateStats(long[] outValues, int key, int[] deviceStates) {
        if (deviceStates.length != this.mDeviceStateConfig.length) goto L11;
        MultiStateStats stateStats = this.mStateStats.get(key);
        if (stateStats != null) goto L7;
        return false;
    L7:
        return stateStats.getStats(outValues, deviceStates);
    L11:
        throw new IllegalArgumentException("Invalid number of tracked states: " + deviceStates.length + " expected: " + this.mDeviceStateConfig.length);
    }

    void forEachStateStatsKey(IntConsumer consumer) {
        int i = this.mStateStats.size() - 1;
    L3:
        if (i < 0) goto L6;
        consumer.accept(this.mStateStats.keyAt(i));
        i = i - 1;
        goto L3
    }

    boolean getUidStats(long[] outValues, int uid, int[] uidStates) {
        if (uidStates.length != this.mUidStateConfig.length) goto L13;
        UidStats uidStats = this.mUidStats.get(uid);
        if (uidStats != null) goto L7;
        return false;
    L7:
        if (uidStats.stats != null) goto L9;
        return false;
    L9:
        return uidStats.stats.getStats(outValues, uidStates);
    L13:
        throw new IllegalArgumentException("Invalid number of tracked states: " + uidStates.length + " expected: " + this.mUidStateConfig.length);
    }

    private void createDeviceStats(long timestampMs) {
        if (this.mStatsFactory == null) goto L5;
    L8:
        this.mDeviceStats = this.mStatsFactory.create();
        if (this.mPowerStatsTimestamp == (-1)) goto L12;
        timestampMs = this.mPowerStatsTimestamp;
    L12:
        if (timestampMs == (-1)) goto L20;
        int stateId = 0;
    L15:
        if (stateId >= this.mDeviceStateConfig.length) goto L23;
        int state = this.mDeviceStates[stateId];
        this.mDeviceStats.setState(stateId, state, timestampMs);
        int i = this.mStateStats.size() - 1;
    L17:
        if (i < 0) goto L19;
        MultiStateStats stateStats = this.mStateStats.valueAt(i);
        stateStats.setState(stateId, state, timestampMs);
        i = i - 1;
        goto L17
    L19:
        stateId = stateId + 1;
        goto L15
    L23:
        return;
    L20:
        return;
    L5:
        if (this.mPowerStatsDescriptor != null) goto L7;
        return;
    L7:
        this.mStatsFactory = new MultiStateStats.Factory(this.mPowerStatsDescriptor.statsArrayLength, this.mDeviceStateConfig);
        goto L8
    }

    private MultiStateStats createStateStats(int key, long timestampMs) {
        if (this.mStateStatsFactory == null) goto L5;
    L9:
        MultiStateStats stateStats = this.mStateStatsFactory.create();
        this.mStateStats.put(key, stateStats);
        if (this.mDeviceStats == null) goto L12;
        stateStats.copyStatesFrom(this.mDeviceStats);
    L12:
        return stateStats;
    L5:
        if (this.mPowerStatsDescriptor != null) goto L8;
        return null;
    L8:
        this.mStateStatsFactory = new MultiStateStats.Factory(this.mPowerStatsDescriptor.stateStatsArrayLength, this.mDeviceStateConfig);
        goto L9
    }

    private void createUidStats(UidStats uidStats, long timestampMs) {
        if (this.mUidStatsFactory == null) goto L5;
    L8:
        uidStats.stats = this.mUidStatsFactory.create();
        if (this.mPowerStatsTimestamp == (-1)) goto L12;
        timestampMs = this.mPowerStatsTimestamp;
    L12:
        if (timestampMs == (-1)) goto L17;
        int stateId = 0;
    L15:
        if (stateId >= this.mUidStateConfig.length) goto L19;
        uidStats.stats.setState(stateId, uidStats.states[stateId], timestampMs);
        stateId = stateId + 1;
        goto L15
    L19:
        return;
    L17:
        return;
    L5:
        if (this.mPowerStatsDescriptor != null) goto L7;
        return;
    L7:
        this.mUidStatsFactory = new MultiStateStats.Factory(this.mPowerStatsDescriptor.uidStatsArrayLength, this.mUidStateConfig);
        goto L8
    }

    void copyStatesFrom(PowerComponentAggregatedPowerStats source) {
        if (source.mDeviceStates.length != this.mDeviceStates.length) goto L9;
        System.arraycopy(source.mDeviceStates, 0, this.mDeviceStates, 0, this.mDeviceStates.length);
        if (source.mDeviceStats == null) goto L10;
        createDeviceStats(0);
        if (this.mDeviceStats == null) goto L10;
        this.mDeviceStats.copyStatesFrom(source.mDeviceStats);
    L10:
        int i = source.mUidStats.size() - 1;
    L11:
        if (i < 0) goto L23;
        int uid = source.mUidStats.keyAt(i);
        UidStats sourceUidStats = source.mUidStats.valueAt(i);
        if (sourceUidStats.states == null) goto L21;
        UidStats uidStats = new UidStats(null);
        uidStats.states = Arrays.copyOf(sourceUidStats.states, sourceUidStats.states.length);
        if (sourceUidStats.stats == null) goto L20;
        createUidStats(uidStats, 0);
        if (uidStats.stats == null) goto L20;
        uidStats.stats.copyStatesFrom(sourceUidStats.stats);
    L20:
        this.mUidStats.put(uid, uidStats);
    L21:
        i = i - 1;
        goto L11
    L23:
        return;
    L9:
        Slog.wtf(TAG, "State configurations have different lengths: " + source.mDeviceStates.length + " vs " + this.mDeviceStates.length);
        goto L10
    }

    public void writeXml(TypedXmlSerializer serializer) throws IOException {
        if (this.mPowerStatsDescriptor != null) goto L5;
        return;
    L5:
        serializer.startTag(null, XML_TAG_POWER_COMPONENT);
        serializer.attributeInt(null, XML_ATTR_ID, this.powerComponentId);
        this.mPowerStatsDescriptor.writeXml(serializer);
        if (this.mDeviceStats == null) goto L8;
        serializer.startTag(null, XML_TAG_DEVICE_STATS);
        this.mDeviceStats.writeXml(serializer);
        serializer.endTag(null, XML_TAG_DEVICE_STATS);
    L8:
        int i = 0;
    L10:
        if (i >= this.mStateStats.size()) goto L12;
        serializer.startTag(null, XML_TAG_STATE_STATS);
        serializer.attributeInt(null, XML_ATTR_KEY, this.mStateStats.keyAt(i));
        this.mStateStats.valueAt(i).writeXml(serializer);
        serializer.endTag(null, XML_TAG_STATE_STATS);
        i = i + 1;
        goto L10
    L12:
        int i2 = this.mUidStats.size() - 1;
    L13:
        if (i2 < 0) goto L18;
        int uid = this.mUidStats.keyAt(i2);
        UidStats uidStats = this.mUidStats.valueAt(i2);
        if (uidStats.stats == null) goto L17;
        serializer.startTag(null, XML_TAG_UID_STATS);
        serializer.attributeInt(null, "uid", uid);
        uidStats.stats.writeXml(serializer);
        serializer.endTag(null, XML_TAG_UID_STATS);
    L17:
        i2 = i2 - 1;
        goto L13
    L18:
        serializer.endTag(null, XML_TAG_POWER_COMPONENT);
        serializer.flush();
    }

    public boolean readFromXml(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        String outerTag = parser.getName();
        int eventType = parser.getEventType();
    L4:
        if (eventType == 1) goto L52;
        byte r3 = 3;
        if (eventType != 3) goto L10;
        if (parser.getName().equals(outerTag) == true) goto L52;
    L10:
        if (eventType != 2) goto L51;
        String r5 = parser.getName();
        switch(r5.hashCode()) {
            case -2016846232: goto L24;
            case -748366993: goto L21;
            case 103033955: goto L18;
            case 1541808354: goto L15;
            default: goto L26;
        };
    L26:
        r3 = -1;
    L28:
        switch(r3) {
            case 0: goto L48;
            case 1: goto L43;
            case 2: goto L36;
            case 3: goto L30;
            default: goto L51;
        };
    L30:
        int uid = parser.getAttributeInt(null, "uid");
        UidStats uidStats = getUidStats(uid);
        if (uidStats.stats != null) goto L33;
        createUidStats(uidStats, -1);
    L33:
        uidStats.hasPowerStats = true;
        if (uidStats.stats.readFromXml(parser) == true) goto L51;
        return false;
    L36:
        int key = parser.getAttributeInt(null, XML_ATTR_KEY);
        MultiStateStats stats = this.mStateStats.get(key);
        if (stats != null) goto L40;
        stats = createStateStats(key, -1);
    L40:
        if (stats.readFromXml(parser) == true) goto L51;
        return false;
    L48:
        this.mPowerStatsDescriptor = PowerStats.Descriptor.createFromXml(parser);
        if (this.mPowerStatsDescriptor != null) goto L51;
        return false;
    L43:
        if (this.mDeviceStats != null) goto L46;
        createDeviceStats(-1);
    L46:
        if (this.mDeviceStats.readFromXml(parser) == true) goto L51;
        return false;
    L15:
        if (r5.equals(XML_TAG_UID_STATS) == false) goto L26;
    L18:
        if (r5.equals(XML_TAG_STATE_STATS) == false) goto L26;
        r3 = 2;
        goto L28
    L21:
        if (r5.equals("descriptor") == false) goto L26;
        r3 = 0;
        goto L28
    L24:
        if (r5.equals(XML_TAG_DEVICE_STATS) == false) goto L26;
        r3 = 1;
    L51:
        eventType = parser.next();
    L52:
        return true;
    }

    void dumpDevice(IndentingPrintWriter ipw) {
        if (this.mDeviceStats == null) goto L5;
        PowerComponentAggregatedPowerStats r1 = this;
        IndentingPrintWriter ipw2 = ipw;
        r1.dumpMultiStateStats(ipw2, this.mDeviceStats, this.mPowerStatsDescriptor.name, null, this.mPowerStatsDescriptor.getDeviceStatsFormatter());
    L7:
        if (r1.mStateStats.size() == 0) goto L15;
        ipw2.increaseIndent();
        String header = r1.mPowerStatsDescriptor.name + " states";
        PowerStats.PowerStatsFormatter formatter = r1.mPowerStatsDescriptor.getStateStatsFormatter();
        int i = 0;
    L10:
        if (i >= r1.mStateStats.size()) goto L12;
        int key = r1.mStateStats.keyAt(i);
        String stateLabel = r1.mPowerStatsDescriptor.getStateLabel(key);
        MultiStateStats stateStats = r1.mStateStats.valueAt(i);
        r1.dumpMultiStateStats(ipw2, stateStats, header, stateLabel, formatter);
        i = i + 1;
        r1 = this;
        goto L10
    L12:
        ipw2.decreaseIndent();
        return;
    L15:
        return;
    L5:
        r1 = this;
        ipw2 = ipw;
        goto L7
    }

    void dumpUid(IndentingPrintWriter ipw, int uid) {
        UidStats uidStats = this.mUidStats.get(uid);
        if (uidStats == null) goto L8;
        if (uidStats.stats == null) goto L8;
        dumpMultiStateStats(ipw, uidStats.stats, this.mPowerStatsDescriptor.name, null, this.mPowerStatsDescriptor.getUidStatsFormatter());
        return;
    }

    private void dumpMultiStateStats(final IndentingPrintWriter ipw, final MultiStateStats stats, final String header, final String additionalLabel, final PowerStats.PowerStatsFormatter statsFormatter) {
        final boolean[] firstLine = {true};
        final long[] values = new long[stats.getDimensionCount()];
        final MultiStateStats.States[] stateInfo = stats.getStates();
        MultiStateStats.States.forEachTrackedStateCombination(stateInfo, new PowerComponentAggregatedPowerStats$$ExternalSyntheticLambda0(stats, values, firstLine, ipw, header, stateInfo, additionalLabel, statsFormatter));
        if (firstLine[0] == true) goto L6;
        ipw.decreaseIndent();
        return;
    }

    private static /* synthetic */ void lambda$dumpMultiStateStats$0(MultiStateStats stats, long[] values, boolean[] firstLine, IndentingPrintWriter ipw, String header, MultiStateStats.States[] stateInfo, String additionalLabel, PowerStats.PowerStatsFormatter statsFormatter, int[] states) {
        if (stats.getStats(values, states) == true) goto L6;
        return;
    L6:
        if (firstLine[0] == false) goto L8;
        ipw.println(header);
        ipw.increaseIndent();
    L8:
        firstLine[0] = false;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        boolean first = true;
        int i = 0;
    L10:
        if (i >= states.length) goto L18;
        if (stateInfo[i].isTracked() == false) goto L16;
        if (first == true) goto L15;
        sb.append(" ");
    L15:
        first = false;
        sb.append(stateInfo[i].getLabels()[states[i]]);
    L16:
        i = i + 1;
        goto L10
    L18:
        if (additionalLabel == null) goto L20;
        sb.append(" ");
        sb.append(additionalLabel);
    L20:
        sb.append(") ");
        sb.append(statsFormatter.format(values));
        ipw.println(sb);
    }

    public String toString() {
        StringWriter sw = new StringWriter();
        IndentingPrintWriter ipw = new IndentingPrintWriter(sw);
        ipw.increaseIndent();
        dumpDevice(ipw);
        ipw.decreaseIndent();
        int[] uids = new int[this.mUidStats.size()];
        int i = uids.length - 1;
    L3:
        if (i < 0) goto L5;
        uids[i] = this.mUidStats.keyAt(i);
        i = i - 1;
        goto L3
    L5:
        Arrays.sort(uids);
        int r3 = uids.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L8;
        int uid = uids[r4];
        ipw.println(UserHandle.formatUid(uid));
        ipw.increaseIndent();
        dumpUid(ipw, uid);
        ipw.decreaseIndent();
        r4 = r4 + 1;
        goto L6
    L8:
        ipw.flush();
        return sw.toString();
    }
}
