package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.internal.InlineClassHelperKt;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import r27.a;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u001d\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u0016J \u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityTracker1D;", "", "isDataDifferential", "", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;", "<init>", "(ZLandroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;)V", "(Z)V", "()Z", "minSampleSize", "", "samples", "", "Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", "[Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", "index", "reusableDataPointsArray", "", "reusableTimeArray", "reusableVelocityCoefficients", "addDataPoint", "", "timeMillis", "", "dataPoint", "", "calculateVelocity", "maximumVelocity", "resetTracking", "calculateLeastSquaresVelocity", "dataPoints", "time", "sampleCount", "Strategy", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VelocityTracker1D {
    public static final int $stable = 8;
    private int index;
    private final boolean isDataDifferential;
    private final int minSampleSize;
    private final float[] reusableDataPointsArray;
    private final float[] reusableTimeArray;
    private final float[] reusableVelocityCoefficients;
    private final DataPointAtTime[] samples;
    private final Strategy strategy;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;", "", "<init>", "(Ljava/lang/String;I)V", "Lsq2", "Impulse", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Strategy extends Enum<Strategy> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Strategy[] $VALUES = null;
        public static final Strategy Impulse = null;
        public static final Strategy Lsq2 = null;

        private static final /* synthetic */ Strategy[] $values() {
            return new Strategy[]{Lsq2, Impulse};
        }

        public static EnumEntries<Strategy> getEntries() {
            return $ENTRIES;
        }

        static {
            Lsq2 = new Strategy("Lsq2", 0);
            Impulse = new Strategy("Impulse", 1);
            Strategy[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static Strategy[] values() {
            return (Strategy[]) $VALUES.clone();
        }

        public static Strategy valueOf(String r100) {
            return (Strategy) a.a(Strategy.class, r100);
        }

        private Strategy(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[Strategy.values().length];
            r100[Strategy.Impulse.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Strategy.Lsq2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r100;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VelocityTracker1D() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public final float calculateVelocity() {
        float[] r100 = this.reusableDataPointsArray;
        float[] r101 = this.reusableTimeArray;
        int r102 = this.index;
        DataPointAtTime r103 = this.samples[r102];
        if (r103 != null) goto L5;
        return 0.0f;
    L5:
        int r104 = 0;
        DataPointAtTime r105 = r103;
    L6:
        DataPointAtTime r106 = this.samples[r102];
        if (r106 == null) goto L29;
        float r107 = r103.getTime() - r106.getTime();
        float r108 = Math.abs(r106.getTime() - r105.getTime());
        if (this.strategy != Strategy.Lsq2) goto L12;
    L15:
        DataPointAtTime r110 = r106;
    L17:
        if (r107 > 100.0f) goto L29;
        if (r108 > 40.0f) goto L29;
        r100[r104] = r106.getDataPoint();
        r101[r104] = -r107;
        if (r102 != 0) goto L24;
        r102 = 20;
    L24:
        r102 = r102 - 1;
        r104 = r104 + 1;
        if (r104 >= 20) goto L29;
        r105 = r110;
        goto L6
    L12:
        if (this.isDataDifferential == true) goto L15;
        r110 = r103;
    L29:
        if (r104 < this.minSampleSize) goto L40;
        int r109 = WhenMappings.$EnumSwitchMapping$0[this.strategy.ordinal()];
        if (r109 != 1) goto L33;
        float r111 = VelocityTrackerKt.access$calculateImpulseVelocity(r100, r101, r104, this.isDataDifferential);
    L39:
        return r111 * 1000;
    L33:
        if (r109 != 2) goto L36;
        r111 = calculateLeastSquaresVelocity(r100, r101, r104);
        goto L39
    L36:
        throw new NoWhenBranchMatchedException();
    L40:
        return 0.0f;
    }

    public final void resetTracking() {
        ArraysKt.fill$default(this.samples, null, 0, 0, 6, null);
        this.index = 0;
    }

    public final boolean isDataDifferential() {
        return this.isDataDifferential;
    }

    public VelocityTracker1D(boolean r100) {
        this(r100, Strategy.Impulse);
    }

    public final float calculateVelocity(float r100) {
        boolean r101 = true;
        if (r100 <= 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        InlineClassHelperKt.throwIllegalStateException("maximumVelocity should be a positive value. You specified=" + r100);
    L8:
        float r103 = calculateVelocity();
        if (r103 == 0.0f) goto L12;
        r101 = false;
    L12:
        if (r101 == false) goto L14;
        return 0.0f;
    L14:
        if (Float.isNaN(r103) == false) goto L17;
        return 0.0f;
    L17:
        if (r103 <= 0.0f) goto L20;
        return RangesKt.coerceAtMost(r103, r100);
    L20:
        return RangesKt.coerceAtLeast(r103, -r100);
    L5:
        r102 = false;
        goto L6
    }

    public VelocityTracker1D(boolean r100, Strategy r101) {
        this.isDataDifferential = r100;
        this.strategy = r101;
        if (r100 == true) goto L5;
    L9:
        int r102 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
        int r103 = 2;
        if (r102 == 1) goto L15;
        if (r102 != 2) goto L14;
        r103 = 3;
        goto L15
    L14:
        throw new NoWhenBranchMatchedException();
    L15:
        this.minSampleSize = r103;
        this.samples = new DataPointAtTime[20];
        this.reusableDataPointsArray = new float[20];
        this.reusableTimeArray = new float[20];
        this.reusableVelocityCoefficients = new float[3];
        return;
    L5:
        if (r101.equals(Strategy.Lsq2) == false) goto L9;
        throw new IllegalStateException("Lsq2 not (yet) supported for differential axes");
    }

    public final void addDataPoint(long r100, float r101) {
        int r102 = (this.index + 1) % 20;
        this.index = r102;
        VelocityTrackerKt.access$set(this.samples, r102, r100, r101);
    }

    private final float calculateLeastSquaresVelocity(float[] r100, float[] r101, int r102) {
        return VelocityTrackerKt.polyFitLeastSquares(r101, r100, r102, 2, this.reusableVelocityCoefficients)[1];
    L4:
        return 0.0f;
    }

    public /* synthetic */ VelocityTracker1D(boolean r100, Strategy r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = Strategy.Lsq2;
    L8:
        this(r100, r101);
    }
}
