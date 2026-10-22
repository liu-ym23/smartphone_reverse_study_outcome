package androidx.compose.ui.input.pointer.util;

import D7.q;
import K7.a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.internal.InlineClassHelperKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001+B\u001d\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u0003\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0014\u0010 \u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010!R\u0014\u0010'\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010*\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010(¨\u0006,"}, d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityTracker1D;", "", "", "isDataDifferential", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;", "strategy", AppAgent.CONSTRUCT, "(ZLandroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;)V", "(Z)V", "", "dataPoints", "time", "", "sampleCount", "", "calculateLeastSquaresVelocity", "([F[FI)F", "", "timeMillis", "dataPoint", "LC7/r;", "addDataPoint", "(JF)V", "calculateVelocity", "()F", "maximumVelocity", "(F)F", "resetTracking", "()V", "Z", "()Z", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;", "minSampleSize", "I", "", "Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", "samples", "[Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", "index", "reusableDataPointsArray", "[F", "reusableTimeArray", "reusableVelocityCoefficients", "Strategy", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "Lsq2", "Impulse", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Strategy {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ Strategy[] $VALUES;
        public static final Strategy Lsq2 = new Strategy("Lsq2", 0);
        public static final Strategy Impulse = new Strategy("Impulse", 1);

        private static final /* synthetic */ Strategy[] $values() {
            return new Strategy[]{Lsq2, Impulse};
        }

        static {
            Strategy[] strategyArr$values = $values();
            $VALUES = strategyArr$values;
            $ENTRIES = kotlin.enums.a.a(strategyArr$values);
        }

        private Strategy(String str, int i) {
        }

        public static a getEntries() {
            return $ENTRIES;
        }

        public static Strategy valueOf(String str) {
            return (Strategy) Enum.valueOf(Strategy.class, str);
        }

        public static Strategy[] values() {
            return (Strategy[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Strategy.values().length];
            try {
                iArr[Strategy.Impulse.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Strategy.Lsq2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VelocityTracker1D() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    private final float calculateLeastSquaresVelocity(float[] dataPoints, float[] time, int sampleCount) {
        try {
            return VelocityTrackerKt.polyFitLeastSquares(time, dataPoints, sampleCount, 2, this.reusableVelocityCoefficients)[1];
        } catch (IllegalArgumentException unused) {
            return 0.0f;
        }
    }

    public final void addDataPoint(long timeMillis, float dataPoint) {
        int i = (this.index + 1) % 20;
        this.index = i;
        VelocityTrackerKt.set(this.samples, i, timeMillis, dataPoint);
    }

    public final float calculateVelocity() {
        float fCalculateImpulseVelocity;
        float[] fArr = this.reusableDataPointsArray;
        float[] fArr2 = this.reusableTimeArray;
        int i = this.index;
        DataPointAtTime dataPointAtTime = this.samples[i];
        if (dataPointAtTime == null) {
            return 0.0f;
        }
        int i6 = 0;
        DataPointAtTime dataPointAtTime2 = dataPointAtTime;
        while (true) {
            DataPointAtTime dataPointAtTime3 = this.samples[i];
            if (dataPointAtTime3 == null) {
                break;
            }
            float time = dataPointAtTime.getTime() - dataPointAtTime3.getTime();
            float fAbs = Math.abs(dataPointAtTime3.getTime() - dataPointAtTime2.getTime());
            DataPointAtTime dataPointAtTime4 = (this.strategy == Strategy.Lsq2 || this.isDataDifferential) ? dataPointAtTime3 : dataPointAtTime;
            if (time > 100.0f || fAbs > 40.0f) {
                break;
            }
            fArr[i6] = dataPointAtTime3.getDataPoint();
            fArr2[i6] = -time;
            if (i == 0) {
                i = 20;
            }
            i--;
            i6++;
            if (i6 >= 20) {
                break;
            }
            dataPointAtTime2 = dataPointAtTime4;
        }
        if (i6 < this.minSampleSize) {
            return 0.0f;
        }
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.strategy.ordinal()];
        if (i10 == 1) {
            fCalculateImpulseVelocity = VelocityTrackerKt.calculateImpulseVelocity(fArr, fArr2, i6, this.isDataDifferential);
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            fCalculateImpulseVelocity = calculateLeastSquaresVelocity(fArr, fArr2, i6);
        }
        return fCalculateImpulseVelocity * 1000;
    }

    /* renamed from: isDataDifferential, reason: from getter */
    public final boolean getIsDataDifferential() {
        return this.isDataDifferential;
    }

    public final void resetTracking() {
        DataPointAtTime[] dataPointAtTimeArr = this.samples;
        q.f0(null, 0, dataPointAtTimeArr, dataPointAtTimeArr.length);
        this.index = 0;
    }

    public VelocityTracker1D(boolean z10, Strategy strategy) {
        this.isDataDifferential = z10;
        this.strategy = strategy;
        if (z10 && strategy.equals(Strategy.Lsq2)) {
            throw new IllegalStateException("Lsq2 not (yet) supported for differential axes");
        }
        int i = WhenMappings.$EnumSwitchMapping$0[strategy.ordinal()];
        int i6 = 2;
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i6 = 3;
        }
        this.minSampleSize = i6;
        this.samples = new DataPointAtTime[20];
        this.reusableDataPointsArray = new float[20];
        this.reusableTimeArray = new float[20];
        this.reusableVelocityCoefficients = new float[3];
    }

    public /* synthetic */ VelocityTracker1D(boolean z10, Strategy strategy, int i, e eVar) {
        this((i & 1) != 0 ? false : z10, (i & 2) != 0 ? Strategy.Lsq2 : strategy);
    }

    public VelocityTracker1D(boolean z10) {
        this(z10, Strategy.Impulse);
    }

    public final float calculateVelocity(float maximumVelocity) {
        if (!(maximumVelocity > 0.0f)) {
            InlineClassHelperKt.throwIllegalStateException("maximumVelocity should be a positive value. You specified=" + maximumVelocity);
        }
        float fCalculateVelocity = calculateVelocity();
        if (fCalculateVelocity == 0.0f || Float.isNaN(fCalculateVelocity)) {
            return 0.0f;
        }
        if (fCalculateVelocity <= 0.0f) {
            float f = -maximumVelocity;
            if (fCalculateVelocity < f) {
                return f;
            }
        } else if (fCalculateVelocity > maximumVelocity) {
            return maximumVelocity;
        }
        return fCalculateVelocity;
    }
}
