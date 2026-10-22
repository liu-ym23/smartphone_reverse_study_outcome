package com.android.server.power.stats;

import android.os.BatteryConsumer;
import android.os.Handler;
import android.os.PersistableBundle;
import android.os.Process;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.os.Clock;
import com.android.internal.os.CpuScalingPolicies;
import com.android.internal.os.PowerProfile;
import com.android.internal.os.PowerStats;
import com.android.server.power.stats.format.CpuPowerStatsLayout;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class CpuPowerStatsCollector extends PowerStatsCollector {
    private static final int DEFAULT_CPU_POWER_BRACKETS = 3;
    private static final int DEFAULT_CPU_POWER_BRACKETS_PER_ENERGY_CONSUMER = 2;
    private static final long NANOS_PER_MILLIS = 1000000;
    private static final String TAG = "CpuPowerStatsCollector";
    private PowerStatsCollector.ConsumedEnergyHelper mConsumedEnergyHelper;
    private PowerStats mCpuPowerStats;
    private CpuScalingPolicies mCpuScalingPolicies;
    private long[] mCpuTimeByScalingStep;
    private int mDefaultCpuPowerBrackets;
    private int mDefaultCpuPowerBracketsPerEnergyConsumer;
    private final Injector mInjector;
    private boolean mIsInitialized;
    private boolean mIsPerUidTimeInStateSupported;
    private KernelCpuStatsReader mKernelCpuStatsReader;
    private long mLastUpdateTimestampNanos;
    private long mLastUpdateUptimeMillis;
    private CpuPowerStatsLayout mLayout;
    private PowerProfile mPowerProfile;
    private PowerStats.Descriptor mPowerStatsDescriptor;
    private long[] mTempCpuTimeByScalingStep;
    private long[] mTempUidStats;
    private final SparseArray<UidStats> mUidStats;

    interface Injector {
        Clock getClock();

        PowerStatsCollector.ConsumedEnergyRetriever getConsumedEnergyRetriever();

        CpuScalingPolicies getCpuScalingPolicies();

        Handler getHandler();

        KernelCpuStatsReader getKernelCpuStatsReader();

        PowerProfile getPowerProfile();

        long getPowerStatsCollectionThrottlePeriod(String r1);

        PowerStatsUidResolver getUidResolver();

        default int getDefaultCpuPowerBrackets() {
            return 3;
        }

        default int getDefaultCpuPowerBracketsPerEnergyConsumer() {
            return 2;
        }
    }

    interface KernelCpuStatsCallback {
        void processUidStats(int r1, long[] r2);
    }

    public static class KernelCpuStatsReader {
        protected native boolean nativeIsSupportedFeature();

        protected native long nativeReadCpuStats(KernelCpuStatsCallback r1, int[] r2, long r3, long[] r5, long[] r6);

        public KernelCpuStatsReader() {
        }

        protected boolean isSupportedFeature() {
            return nativeIsSupportedFeature();
        }

        protected long readCpuStats(KernelCpuStatsCallback callback, int[] scalingStepToPowerBracketMap, long lastUpdateTimestampNanos, long[] outCpuTimeByScalingStep, long[] tempForUidStats) {
            return nativeReadCpuStats(callback, scalingStepToPowerBracketMap, lastUpdateTimestampNanos, outCpuTimeByScalingStep, tempForUidStats);
        }
    }

    private static class UidStats {
        public long[] stats;
        public long[] timeByPowerBracket;

        /* synthetic */ UidStats(CpuPowerStatsCollectorIA r1) {
            this();
        }

        private UidStats() {
        }
    }

    public static /* synthetic */ void $r8$lambda$l7KbxBakyCEoVp9gpEIBpVgzupw(CpuPowerStatsCollector r0, int r1, long[] r2) {
        r0.processUidStats(r1, r2);
    }

    CpuPowerStatsCollector(Injector injector) {
        super(injector.getHandler(), injector.getPowerStatsCollectionThrottlePeriod(BatteryConsumer.powerComponentIdToString(1)), injector.getUidResolver(), injector.getClock());
        this.mUidStats = new SparseArray();
        this.mInjector = injector;
    }

    private boolean ensureInitialized() {
        if (this.mIsInitialized == false) goto L6;
        return true;
    L6:
        if (isEnabled() == true) goto L9;
        return false;
    L9:
        this.mCpuScalingPolicies = this.mInjector.getCpuScalingPolicies();
        this.mPowerProfile = this.mInjector.getPowerProfile();
        this.mKernelCpuStatsReader = this.mInjector.getKernelCpuStatsReader();
        this.mDefaultCpuPowerBrackets = this.mInjector.getDefaultCpuPowerBrackets();
        this.mDefaultCpuPowerBracketsPerEnergyConsumer = this.mInjector.getDefaultCpuPowerBracketsPerEnergyConsumer();
        this.mIsPerUidTimeInStateSupported = this.mKernelCpuStatsReader.isSupportedFeature();
        this.mConsumedEnergyHelper = new PowerStatsCollector.ConsumedEnergyHelper(this, this.mInjector.getConsumedEnergyRetriever(), 2);
        int cpuScalingStepCount = this.mCpuScalingPolicies.getScalingStepCount();
        this.mCpuTimeByScalingStep = new long[cpuScalingStepCount];
        this.mTempCpuTimeByScalingStep = new long[cpuScalingStepCount];
        int[] scalingStepToPowerBracketMap = initPowerBrackets();
        this.mLayout = new CpuPowerStatsLayout(this.mConsumedEnergyHelper.getEnergyConsumerCount(), this.mCpuScalingPolicies.getPolicies().length, scalingStepToPowerBracketMap);
        PersistableBundle extras = new PersistableBundle();
        this.mLayout.toExtras(extras);
        this.mPowerStatsDescriptor = new PowerStats.Descriptor(1, this.mLayout.getDeviceStatsArrayLength(), null, 0, this.mLayout.getUidStatsArrayLength(), extras);
        this.mCpuPowerStats = new PowerStats(this.mPowerStatsDescriptor);
        this.mTempUidStats = new long[this.mLayout.getCpuPowerBracketCount()];
        this.mIsInitialized = true;
        return true;
    }

    private int[] initPowerBrackets() {
        if (this.mPowerProfile.getCpuPowerBracketCount() == (-1)) goto L7;
        return initPowerBracketsFromPowerProfile();
    L7:
        if (this.mConsumedEnergyHelper.getEnergyConsumerCount() == 0) goto L18;
        if (this.mConsumedEnergyHelper.getEnergyConsumerCount() == 1) goto L18;
        if (this.mCpuScalingPolicies.getPolicies().length == this.mConsumedEnergyHelper.getEnergyConsumerCount()) goto L14;
        Slog.i(TAG, "Assigning a single power brackets to each CPU_CLUSTER energy consumer. Number of CPU clusters (" + this.mCpuScalingPolicies.getPolicies().length + ") does not match the number of energy consumers (" + this.mConsumedEnergyHelper.getEnergyConsumerCount() + ").  Using default power bucket assignment.");
        return initDefaultPowerBrackets(this.mDefaultCpuPowerBrackets);
    L14:
        return initPowerBracketsByCluster(this.mDefaultCpuPowerBracketsPerEnergyConsumer);
    L18:
        return initDefaultPowerBrackets(this.mDefaultCpuPowerBrackets);
    }

    private int[] initPowerBracketsFromPowerProfile() {
        int[] stepToBracketMap = new int[this.mCpuScalingPolicies.getScalingStepCount()];
        int index = 0;
        int[] r2 = this.mCpuScalingPolicies.getPolicies();
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L9;
        int policy = r2[r4];
        int[] frequencies = this.mCpuScalingPolicies.getFrequencies(policy);
        int step = 0;
    L6:
        if (step >= frequencies.length) goto L8;
        int bracket = this.mPowerProfile.getCpuPowerBracketForScalingStep(policy, step);
        stepToBracketMap[index] = bracket;
        step = step + 1;
        index = index + 1;
        goto L6
    L8:
        r4 = r4 + 1;
        goto L3
    L9:
        return stepToBracketMap;
    }

    private int[] initPowerBracketsByCluster(int defaultBracketCountPerCluster) {
        int[] stepToBracketMap = new int[this.mCpuScalingPolicies.getScalingStepCount()];
        int index = 0;
        int bracketBase = 0;
        int[] policies = this.mCpuScalingPolicies.getPolicies();
        int r4 = policies.length;
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L16;
        int policy = policies[r5];
        int[] frequencies = this.mCpuScalingPolicies.getFrequencies(policy);
        double[] powerByStep = new double[frequencies.length];
        int step = 0;
    L6:
        if (step >= frequencies.length) goto L8;
        powerByStep[step] = this.mPowerProfile.getAveragePowerForCpuScalingStep(policy, step);
        step = step + 1;
        goto L6
    L8:
        int step2 = frequencies.length;
        int[] policyStepToBracketMap = new int[step2];
        mapScalingStepsToDefaultBrackets(policyStepToBracketMap, powerByStep, defaultBracketCountPerCluster);
        int maxBracket = 0;
        int step3 = 0;
    L10:
        if (step3 >= frequencies.length) goto L15;
        int bracket = policyStepToBracketMap[step3] + bracketBase;
        int index2 = index + 1;
        stepToBracketMap[index] = bracket;
        if (bracket <= maxBracket) goto L14;
        maxBracket = bracket;
    L14:
        step3 = step3 + 1;
        index = index2;
        goto L10
    L15:
        bracketBase = maxBracket + 1;
        r5 = r5 + 1;
        goto L3
    L16:
        return stepToBracketMap;
    }

    private int[] initDefaultPowerBrackets(int defaultCpuPowerBracketCount) {
        int[] stepToBracketMap = new int[this.mCpuScalingPolicies.getScalingStepCount()];
        double[] powerByStep = new double[this.mCpuScalingPolicies.getScalingStepCount()];
        int index = 0;
        int[] policies = this.mCpuScalingPolicies.getPolicies();
        int r4 = policies.length;
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L9;
        int policy = policies[r5];
        int[] frequencies = this.mCpuScalingPolicies.getFrequencies(policy);
        int step = 0;
    L6:
        if (step >= frequencies.length) goto L8;
        powerByStep[index] = this.mPowerProfile.getAveragePowerForCpuScalingStep(policy, step);
        step = step + 1;
        index = index + 1;
        goto L6
    L8:
        r5 = r5 + 1;
        goto L3
    L9:
        mapScalingStepsToDefaultBrackets(stepToBracketMap, powerByStep, defaultCpuPowerBracketCount);
        return stepToBracketMap;
    }

    private static void mapScalingStepsToDefaultBrackets(int[] stepToBracketMap, double[] powerByStep, int defaultCpuPowerBracketCount) {
        double minPower = Double.MAX_VALUE;
        double maxPower = Double.MIN_VALUE;
        int r4 = powerByStep.length;
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L12;
        double power = powerByStep[r5];
        if (power >= minPower) goto L8;
        minPower = power;
    L8:
        if (power <= maxPower) goto L10;
        maxPower = power;
    L10:
        r5 = r5 + 1;
        goto L3
    L12:
        if (powerByStep.length > defaultCpuPowerBracketCount) goto L18;
        int index = 0;
    L15:
        if (index >= stepToBracketMap.length) goto L25;
        stepToBracketMap[index] = index;
        index = index + 1;
        goto L15
    L25:
        return;
    L18:
        double minLogPower = Math.log(minPower);
        double logBracket = (Math.log(maxPower) - minLogPower) / ((double) defaultCpuPowerBracketCount);
        int step = 0;
    L20:
        if (step >= powerByStep.length) goto L33;
        int bracket = (int) ((Math.log(powerByStep[step]) - minLogPower) / logBracket);
        if (bracket < defaultCpuPowerBracketCount) goto L24;
        bracket = defaultCpuPowerBracketCount - 1;
    L24:
        stepToBracketMap[step] = bracket;
        step = step + 1;
        goto L20
    }

    public void dumpCpuPowerBracketsLocked(PrintWriter pw) {
        if (ensureInitialized() == true) goto L6;
        return;
    L6:
        if (this.mLayout != null) goto L8;
        return;
    L8:
        pw.println("CPU power brackets; cluster/freq in MHz(avg current in mA):");
        int bracket = 0;
    L10:
        if (bracket >= this.mLayout.getCpuPowerBracketCount()) goto L13;
        pw.print("    ");
        pw.print(bracket);
        pw.print(": ");
        pw.println(getCpuPowerBracketDescription(bracket));
        bracket = bracket + 1;
        goto L10
    }

    public String getCpuPowerBracketDescription(int powerBracket) {
        if (ensureInitialized() == true) goto L6;
        return "";
    L6:
        int[] stepToPowerBracketMap = this.mLayout.getScalingStepToPowerBracketMap();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int[] policies = this.mCpuScalingPolicies.getPolicies();
        int r4 = policies.length;
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L24;
        int policy = policies[r5];
        int[] freqs = this.mCpuScalingPolicies.getFrequencies(policy);
        int step = 0;
    L10:
        if (step >= freqs.length) goto L22;
        if (stepToPowerBracketMap[index] != powerBracket) goto L21;
        if (sb.length() == 0) goto L18;
        sb.append(", ");
    L18:
        if (policies.length <= 1) goto L20;
        sb.append(policy);
        sb.append('/');
    L20:
        sb.append(freqs[step] / 1000);
        sb.append('(');
        sb.append(String.format(Locale.US, "%.1f", new Object[]{Double.valueOf(this.mPowerProfile.getAveragePowerForCpuScalingStep(policy, step))}));
        sb.append(')');
    L21:
        index = index + 1;
        step = step + 1;
        goto L10
    L22:
        r5 = r5 + 1;
        goto L7
    L24:
        return sb.toString();
    }

    public PowerStats.Descriptor getPowerStatsDescriptor() {
        if (ensureInitialized() == true) goto L7;
        return null;
    L7:
        return this.mPowerStatsDescriptor;
    }

    @Override // com.android.server.power.stats.PowerStatsCollector
    protected PowerStats collectStats() {
        if (ensureInitialized() == true) goto L6;
        return null;
    L6:
        if (this.mIsPerUidTimeInStateSupported == true) goto L8;
        return null;
    L8:
        Arrays.fill(this.mCpuPowerStats.stats, 0);
        this.mCpuPowerStats.uidStats.clear();
        long newTimestampNanos = this.mKernelCpuStatsReader.readCpuStats(new CpuPowerStatsCollector$$ExternalSyntheticLambda0(this), this.mLayout.getScalingStepToPowerBracketMap(), this.mLastUpdateTimestampNanos, this.mTempCpuTimeByScalingStep, this.mTempUidStats);
        int step = this.mLayout.getCpuScalingStepCount() - 1;
    L9:
        if (step < 0) goto L11;
        this.mLayout.setTimeByScalingStep(this.mCpuPowerStats.stats, step, this.mTempCpuTimeByScalingStep[step] - this.mCpuTimeByScalingStep[step]);
        this.mCpuTimeByScalingStep[step] = this.mTempCpuTimeByScalingStep[step];
        step = step - 1;
        goto L9
    L11:
        this.mCpuPowerStats.durationMs = (newTimestampNanos - this.mLastUpdateTimestampNanos) / NANOS_PER_MILLIS;
        this.mLastUpdateTimestampNanos = newTimestampNanos;
        long uptimeMillis = this.mClock.uptimeMillis();
        long uptimeDelta = uptimeMillis - this.mLastUpdateUptimeMillis;
        this.mLastUpdateUptimeMillis = uptimeMillis;
        if (uptimeDelta <= this.mCpuPowerStats.durationMs) goto L14;
        uptimeDelta = this.mCpuPowerStats.durationMs;
    L14:
        this.mLayout.setUsageDuration(this.mCpuPowerStats.stats, uptimeDelta);
        this.mConsumedEnergyHelper.collectConsumedEnergy(this.mCpuPowerStats, this.mLayout);
        return this.mCpuPowerStats;
    }

    private void processUidStats(int uid, long[] timeByPowerBracket) {
        int powerBracketCount = this.mLayout.getCpuPowerBracketCount();
        UidStats uidStats = this.mUidStats.get(uid);
        if (uidStats != null) goto L5;
        uidStats = new UidStats(null);
        uidStats.timeByPowerBracket = new long[powerBracketCount];
        uidStats.stats = new long[this.mLayout.getUidStatsArrayLength()];
        this.mUidStats.put(uid, uidStats);
    L5:
        boolean nonzero = false;
        int bracket = powerBracketCount - 1;
    L6:
        if (bracket < 0) goto L12;
        long delta = Math.max(0, timeByPowerBracket[bracket] - uidStats.timeByPowerBracket[bracket]);
        if (delta == 0) goto L10;
        nonzero = true;
    L10:
        this.mLayout.setUidTimeByPowerBracket(uidStats.stats, bracket, delta);
        uidStats.timeByPowerBracket[bracket] = timeByPowerBracket[bracket];
        bracket = bracket - 1;
        goto L6
    L12:
        if (nonzero == true) goto L14;
        return;
    L14:
        if (Process.isSdkSandboxUid(uid) == false) goto L16;
        int ownerUid = Process.getAppUidForSdkSandboxUid(uid);
    L17:
        long[] ownerStats = (long[]) this.mCpuPowerStats.uidStats.get(ownerUid);
        if (ownerStats != null) goto L20;
        this.mCpuPowerStats.uidStats.put(ownerUid, uidStats.stats);
        return;
    L20:
        int i = 0;
    L22:
        if (i >= ownerStats.length) goto L30;
        ownerStats[i] = ownerStats[i] + uidStats.stats[i];
        i = i + 1;
        goto L22
    L30:
        return;
    L16:
        ownerUid = this.mUidResolver.mapUid(uid);
        goto L17
    }

    @Override // com.android.server.power.stats.PowerStatsCollector
    protected void onUidRemoved(int uid) {
        super.onUidRemoved(uid);
        this.mUidStats.remove(uid);
    }
}
