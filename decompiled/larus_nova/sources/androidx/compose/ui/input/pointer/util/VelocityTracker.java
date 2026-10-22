package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\fJ\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010 \u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000e¨\u0006!"}, d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "", "<init>", "()V", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;", "xVelocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D;", "yVelocityTracker", "currentPointerPositionAccumulator", "Landroidx/compose/ui/geometry/Offset;", "getCurrentPointerPositionAccumulator-F1C5BW0$ui_release", "()J", "setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release", "(J)V", "J", "lastMoveEventTimeStamp", "", "getLastMoveEventTimeStamp$ui_release", "setLastMoveEventTimeStamp$ui_release", "addPosition", "", "timeMillis", "position", "addPosition-Uv8p0NA", "(JJ)V", "calculateVelocity", "Landroidx/compose/ui/unit/Velocity;", "calculateVelocity-9UxMQ8M", "maximumVelocity", "calculateVelocity-AH228Gc", "(J)J", "resetTracking", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VelocityTracker {
    public static final int $stable = 8;
    private long currentPointerPositionAccumulator;
    private long lastMoveEventTimeStamp;
    private final VelocityTracker1D.Strategy strategy;
    private final VelocityTracker1D xVelocityTracker;
    private final VelocityTracker1D yVelocityTracker;

    public final void resetTracking() {
        this.xVelocityTracker.resetTracking();
        this.yVelocityTracker.resetTracking();
        this.lastMoveEventTimeStamp = 0;
    }

    public VelocityTracker() {
        if (VelocityTrackerKt.getVelocityTrackerStrategyUseImpulse() == false) goto L5;
        VelocityTracker1D.Strategy r100 = VelocityTracker1D.Strategy.Impulse;
    L6:
        this.strategy = r100;
        this.xVelocityTracker = new VelocityTracker1D(false, r100, 1, null);
        this.yVelocityTracker = new VelocityTracker1D(false, r100, 1, null);
        this.currentPointerPositionAccumulator = Offset.Companion.m4598getZeroF1C5BW0();
        return;
    L5:
        r100 = VelocityTracker1D.Strategy.Lsq2;
        goto L6
    }

    /* JADX INFO: renamed from: calculateVelocity-9UxMQ8M, reason: not valid java name */
    public final long m6225calculateVelocity9UxMQ8M() {
        return m6226calculateVelocityAH228Gc(VelocityKt.Velocity(Float.MAX_VALUE, Float.MAX_VALUE));
    }

    /* JADX INFO: renamed from: getCurrentPointerPositionAccumulator-F1C5BW0$ui_release, reason: not valid java name */
    public final long m6227getCurrentPointerPositionAccumulatorF1C5BW0$ui_release() {
        return this.currentPointerPositionAccumulator;
    }

    public final long getLastMoveEventTimeStamp$ui_release() {
        return this.lastMoveEventTimeStamp;
    }

    /* JADX INFO: renamed from: calculateVelocity-AH228Gc, reason: not valid java name */
    public final long m6226calculateVelocityAH228Gc(long r100) {
        if (Velocity.m7786getXimpl(r100) > 0.0f) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L11;
        InlineClassHelperKt.throwIllegalStateException("maximumVelocity should be a positive value. You specified=" + Velocity.m7793toStringimpl(r100));
    L11:
        return VelocityKt.Velocity(this.xVelocityTracker.calculateVelocity(Velocity.m7786getXimpl(r100)), this.yVelocityTracker.calculateVelocity(Velocity.m7787getYimpl(r100)));
    L5:
        if (Velocity.m7787getYimpl(r100) <= 0.0f) goto L7;
        r101 = true;
        goto L8
    }

    /* JADX INFO: renamed from: setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release, reason: not valid java name */
    public final void m6228setCurrentPointerPositionAccumulatork4lQ0M$ui_release(long r100) {
        this.currentPointerPositionAccumulator = r100;
    }

    public final void setLastMoveEventTimeStamp$ui_release(long r100) {
        this.lastMoveEventTimeStamp = r100;
    }

    /* JADX INFO: renamed from: addPosition-Uv8p0NA, reason: not valid java name */
    public final void m6224addPositionUv8p0NA(long r100, long r101) {
        this.xVelocityTracker.addDataPoint(r100, Float.intBitsToFloat((int) (r101 >> 32)));
        this.yVelocityTracker.addDataPoint(r100, Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax)));
    }
}
