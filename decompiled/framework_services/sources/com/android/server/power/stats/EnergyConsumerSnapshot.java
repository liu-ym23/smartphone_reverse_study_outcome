package com.android.server.power.stats;

import android.hardware.power.stats.EnergyConsumer;
import android.hardware.power.stats.EnergyConsumerAttribution;
import android.hardware.power.stats.EnergyConsumerResult;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public class EnergyConsumerSnapshot {
    private static final int MILLIVOLTS_PER_VOLT = 1000;
    private static final String TAG = "EnergyConsumerSnapshot";
    public static final long UNAVAILABLE = -1;
    private final SparseArray<SparseLongArray> mAttributionSnapshots;
    private final SparseLongArray mEnergyConsumerSnapshots;
    private final SparseArray<EnergyConsumer> mEnergyConsumers;
    private final int mNumCpuClusterOrdinals;
    private final int mNumDisplayOrdinals;
    private final int mNumOtherOrdinals;
    private final SparseIntArray mVoltageSnapshots;

    static class EnergyConsumerDeltaData {
        public long bluetoothChargeUC;
        public long cameraChargeUC;
        public long[] cpuClusterChargeUC;
        public long[] displayChargeUC;
        public long gnssChargeUC;
        public long mobileRadioChargeUC;
        public long[] otherTotalChargeUC;
        public SparseLongArray[] otherUidChargesUC;
        public long wifiChargeUC;

        EnergyConsumerDeltaData() {
            this.bluetoothChargeUC = -1;
            this.cpuClusterChargeUC = null;
            this.displayChargeUC = null;
            this.gnssChargeUC = -1;
            this.mobileRadioChargeUC = -1;
            this.wifiChargeUC = -1;
            this.cameraChargeUC = -1;
            this.otherTotalChargeUC = null;
            this.otherUidChargesUC = null;
        }

        boolean isEmpty() {
            if (this.bluetoothChargeUC <= 0) goto L5;
        L17:
            return false;
        L5:
            if (isEmpty(this.cpuClusterChargeUC) == false) goto L17;
            if (isEmpty(this.displayChargeUC) == false) goto L17;
            if (this.gnssChargeUC > 0) goto L17;
            if (this.mobileRadioChargeUC > 0) goto L17;
            if (this.wifiChargeUC > 0) goto L17;
            if (isEmpty(this.otherTotalChargeUC) == false) goto L17;
            return true;
        }

        private boolean isEmpty(long[] values) {
            if (values != null) goto L5;
            return true;
        L5:
            int r1 = values.length;
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L11;
            long value = values[r3];
            if (value > 0) goto L9;
            r3 = r3 + 1;
            goto L6
        L9:
            return false;
        L11:
            return true;
        }
    }

    EnergyConsumerSnapshot(SparseArray<EnergyConsumer> idToConsumerMap) {
        this.mEnergyConsumers = idToConsumerMap;
        this.mEnergyConsumerSnapshots = new SparseLongArray(this.mEnergyConsumers.size());
        this.mVoltageSnapshots = new SparseIntArray(this.mEnergyConsumers.size());
        this.mNumCpuClusterOrdinals = calculateNumOrdinals(2, idToConsumerMap);
        this.mNumDisplayOrdinals = calculateNumOrdinals(3, idToConsumerMap);
        this.mNumOtherOrdinals = calculateNumOrdinals(0, idToConsumerMap);
        this.mAttributionSnapshots = new SparseArray(this.mNumOtherOrdinals);
    }

    public EnergyConsumerDeltaData updateAndGetDelta(EnergyConsumerResult[] ecrs, int voltageMV) {
        EnergyConsumerResult[] r1 = ecrs;
        int r2 = voltageMV;
        EnergyConsumer r3 = null;
        if (r1 == null) goto L51;
        if (r1.length != 0) goto L8;
        return null;
    L8:
        if (r2 > 0) goto L11;
        Slog.wtf(TAG, "Unexpected battery voltage (" + r2 + " mV) when taking energy consumer snapshot");
        return null;
    L11:
        EnergyConsumerDeltaData output = new EnergyConsumerDeltaData();
        int r6 = r1.length;
        int r7 = 0;
    L12:
        if (r7 >= r6) goto L49;
        EnergyConsumerResult ecr = r1[r7];
        int consumerId = ecr.id;
        long newEnergyUJ = ecr.energyUWs;
        EnergyConsumerAttribution[] newAttributions = ecr.attribution;
        EnergyConsumer consumer = this.mEnergyConsumers.get(consumerId, r3);
        if (consumer != null) goto L16;
        Slog.e(TAG, "updateAndGetDelta given invalid consumerId " + consumerId);
        EnergyConsumer r16 = r3;
        int r17 = r6;
        int r18 = r7;
    L48:
        r7 = r18 + 1;
        r1 = ecrs;
        r3 = r16;
        r6 = r17;
        goto L12
    L16:
        int type = consumer.type;
        int ordinal = consumer.ordinal;
        r16 = r3;
        r17 = r6;
        r18 = r7;
        long oldEnergyUJ = this.mEnergyConsumerSnapshots.get(consumerId, -1);
        int oldVoltageMV = this.mVoltageSnapshots.get(consumerId);
        this.mEnergyConsumerSnapshots.put(consumerId, newEnergyUJ);
        this.mVoltageSnapshots.put(consumerId, r2);
        int avgVoltageMV = ((oldVoltageMV + r2) + 1) / 2;
        SparseLongArray otherUidCharges = updateAndGetDeltaForTypeOther(consumer, newAttributions, avgVoltageMV);
        if (oldEnergyUJ < 0) goto L48;
        if (newEnergyUJ == oldEnergyUJ) goto L48;
        long deltaUJ = newEnergyUJ - oldEnergyUJ;
        if (deltaUJ < 0) goto L47;
        if (oldVoltageMV <= 0) goto L47;
        long deltaChargeUC = calculateChargeConsumedUC(deltaUJ, avgVoltageMV);
        switch(type) {
            case 0: goto L43;
            case 1: goto L41;
            case 2: goto L38;
            case 3: goto L34;
            case 4: goto L32;
            case 5: goto L31;
            case 6: goto L30;
            case 7: goto L29;
            default: goto L28;
        };
    L28:
        Slog.w(TAG, "Ignoring consumer " + consumer.name + " of unknown type " + type);
        r2 = voltageMV;
        goto L48
    L29:
        output.cameraChargeUC = deltaChargeUC;
        r2 = voltageMV;
        goto L48
    L30:
        output.wifiChargeUC = deltaChargeUC;
        r2 = voltageMV;
        goto L48
    L31:
        output.mobileRadioChargeUC = deltaChargeUC;
        r2 = voltageMV;
        goto L48
    L32:
        output.gnssChargeUC = deltaChargeUC;
        r2 = voltageMV;
        goto L48
    L41:
        output.bluetoothChargeUC = deltaChargeUC;
        r2 = voltageMV;
        goto L48
    L34:
        if (output.displayChargeUC != null) goto L36;
        output.displayChargeUC = new long[this.mNumDisplayOrdinals];
    L36:
        output.displayChargeUC[ordinal] = deltaChargeUC;
        r2 = voltageMV;
        goto L48
    L38:
        if (output.cpuClusterChargeUC != null) goto L40;
        output.cpuClusterChargeUC = new long[this.mNumCpuClusterOrdinals];
    L40:
        output.cpuClusterChargeUC[ordinal] = deltaChargeUC;
        r2 = voltageMV;
        goto L48
    L43:
        if (output.otherTotalChargeUC != null) goto L45;
        output.otherTotalChargeUC = new long[this.mNumOtherOrdinals];
        output.otherUidChargesUC = new SparseLongArray[this.mNumOtherOrdinals];
    L45:
        output.otherTotalChargeUC[ordinal] = deltaChargeUC;
        output.otherUidChargesUC[ordinal] = otherUidCharges;
        r2 = voltageMV;
    L47:
        StringBuilder r4 = new StringBuilder();
        r4.append("Bad data! EnergyConsumer ");
        r4.append(consumer.name);
        r4.append(": new energy (");
        r4.append(newEnergyUJ);
        r4.append(") < old energy (");
        r4.append(oldEnergyUJ);
        r4.append("), new voltage (");
        r2 = voltageMV;
        r4.append(r2);
        r4.append("), old voltage (");
        r4.append(oldVoltageMV);
        r4.append("). Skipping. ");
        Slog.e(TAG, r4.toString());
        goto L48
    L49:
        return output;
    L51:
        return null;
    }

    private SparseLongArray updateAndGetDeltaForTypeOther(EnergyConsumer consumerInfo, EnergyConsumerAttribution[] newAttributions, int avgVoltageMV) {
        if (consumerInfo.type == 0) goto L5;
        return null;
    L5:
        int r3 = 0;
        if (newAttributions != null) goto L8;
        EnergyConsumerAttribution[] newAttributions2 = new EnergyConsumerAttribution[0];
    L9:
        SparseLongArray uidOldEnergyMap = this.mAttributionSnapshots.get(consumerInfo.id, null);
        if (uidOldEnergyMap != null) goto L15;
        SparseLongArray uidOldEnergyMap2 = new SparseLongArray(newAttributions2.length);
        this.mAttributionSnapshots.put(consumerInfo.id, uidOldEnergyMap2);
        int r6 = newAttributions2.length;
    L12:
        if (r3 >= r6) goto L14;
        EnergyConsumerAttribution newAttribution = newAttributions2[r3];
        uidOldEnergyMap2.put(newAttribution.uid, newAttribution.energyUWs);
        r3 = r3 + 1;
        goto L12
    L14:
        return null;
    L15:
        SparseLongArray uidChargeDeltas = new SparseLongArray();
        int r7 = newAttributions2.length;
    L16:
        if (r3 >= r7) goto L31;
        EnergyConsumerAttribution newAttribution2 = newAttributions2[r3];
        int uid = newAttribution2.uid;
        long newEnergyUJ = newAttribution2.energyUWs;
        long oldEnergyUJ = uidOldEnergyMap.get(uid, 0);
        uidOldEnergyMap.put(uid, newEnergyUJ);
        if (oldEnergyUJ >= 0) goto L21;
        newAttributions2 = newAttributions2;
        uidOldEnergyMap = uidOldEnergyMap;
    L30:
        r3 = r3 + 1;
        uidOldEnergyMap = uidOldEnergyMap;
        newAttributions2 = newAttributions2;
        goto L16
    L21:
        if (newEnergyUJ != oldEnergyUJ) goto L23;
        newAttributions2 = newAttributions2;
        uidOldEnergyMap = uidOldEnergyMap;
        goto L30
    L23:
        long deltaUJ = newEnergyUJ - oldEnergyUJ;
        if (deltaUJ < 0) goto L29;
        if (avgVoltageMV <= 0) goto L29;
        newAttributions2 = newAttributions2;
        uidOldEnergyMap = uidOldEnergyMap;
        long deltaChargeUC = calculateChargeConsumedUC(deltaUJ, avgVoltageMV);
        uidChargeDeltas.put(uid, deltaChargeUC);
    L29:
        Slog.e(TAG, "EnergyConsumer " + consumerInfo.name + ": new energy (" + newEnergyUJ + ") but old energy (" + oldEnergyUJ + "). Average voltage (" + avgVoltageMV + ")Skipping. ");
        goto L30
    L31:
        return uidChargeDeltas;
    L8:
        newAttributions2 = newAttributions;
        goto L9
    }

    public void dump(PrintWriter pw) {
        pw.println("Energy consumer snapshot");
        pw.println("List of EnergyConsumers:");
        int i = 0;
    L4:
        if (i >= this.mEnergyConsumers.size()) goto L6;
        int id = this.mEnergyConsumers.keyAt(i);
        EnergyConsumer consumer = this.mEnergyConsumers.valueAt(i);
        pw.println(String.format("    Consumer %d is {id=%d, ordinal=%d, type=%d, name=%s}", new Object[]{Integer.valueOf(id), Integer.valueOf(consumer.id), Integer.valueOf(consumer.ordinal), Byte.valueOf(consumer.type), consumer.name}));
        i = i + 1;
        goto L4
    L6:
        pw.println("Map of consumerIds to energy (in microjoules):");
        int i2 = 0;
    L8:
        if (i2 >= this.mEnergyConsumerSnapshots.size()) goto L10;
        int id2 = this.mEnergyConsumerSnapshots.keyAt(i2);
        long energyUJ = this.mEnergyConsumerSnapshots.valueAt(i2);
        long voltageMV = this.mVoltageSnapshots.valueAt(i2);
        pw.println(String.format("    Consumer %d has energy %d uJ at %d mV", new Object[]{Integer.valueOf(id2), Long.valueOf(energyUJ), Long.valueOf(voltageMV)}));
        i2 = i2 + 1;
        goto L8
    L10:
        pw.println("List of the " + this.mNumOtherOrdinals + " OTHER EnergyConsumers:");
        StringBuilder r0 = new StringBuilder();
        r0.append("    ");
        r0.append(this.mAttributionSnapshots);
        pw.println(r0.toString());
        pw.println();
    }

    public String[] getOtherOrdinalNames() {
        String[] names = new String[this.mNumOtherOrdinals];
        int consumerIndex = 0;
        int size = this.mEnergyConsumers.size();
        int idx = 0;
    L3:
        if (idx >= size) goto L9;
        EnergyConsumer consumer = this.mEnergyConsumers.valueAt(idx);
        if (consumer.type != 0) goto L7;
        names[consumerIndex] = sanitizeCustomBucketName(consumer.name);
        consumerIndex = consumerIndex + 1;
    L7:
        idx = idx + 1;
        goto L3
    L9:
        return names;
    }

    private String sanitizeCustomBucketName(String bucketName) {
        if (bucketName != null) goto L5;
        return "";
    L5:
        StringBuilder sb = new StringBuilder(bucketName.length());
        char[] r1 = bucketName.toCharArray();
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L16;
        char c = r1[r3];
        if (Character.isWhitespace(c) == false) goto L11;
        sb.append(' ');
    L14:
        r3 = r3 + 1;
        goto L6
    L11:
        if (Character.isISOControl(c) == false) goto L13;
        sb.append('_');
        goto L14
    L13:
        sb.append(c);
        goto L14
    L16:
        return sb.toString();
    }

    private static int calculateNumOrdinals(int type, SparseArray<EnergyConsumer> idToConsumer) {
        if (idToConsumer != null) goto L5;
        return 0;
    L5:
        int numOrdinals = 0;
        int size = idToConsumer.size();
        int idx = 0;
    L6:
        if (idx >= size) goto L12;
        EnergyConsumer consumer = idToConsumer.valueAt(idx);
        if (consumer.type != type) goto L10;
        numOrdinals = numOrdinals + 1;
    L10:
        idx = idx + 1;
        goto L6
    L12:
        return numOrdinals;
    }

    private long calculateChargeConsumedUC(long deltaEnergyUJ, int avgVoltageMV) {
        return ((1000 * deltaEnergyUJ) + ((long) (avgVoltageMV / 2))) / ((long) avgVoltageMV);
    }
}
