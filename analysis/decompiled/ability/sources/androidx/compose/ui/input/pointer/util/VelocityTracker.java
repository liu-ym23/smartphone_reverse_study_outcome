package androidx.compose.ui.input.pointer.util;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0003R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\"\u0010\u001b\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u001f¨\u0006#"}, d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "", AppAgent.CONSTRUCT, "()V", "", "timeMillis", "Landroidx/compose/ui/geometry/Offset;", "position", "LC7/r;", "addPosition-Uv8p0NA", "(JJ)V", "addPosition", "Landroidx/compose/ui/unit/Velocity;", "calculateVelocity-9UxMQ8M", "()J", "calculateVelocity", "maximumVelocity", "calculateVelocity-AH228Gc", "(J)J", "resetTracking", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;", "strategy", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D;", "xVelocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D;", "yVelocityTracker", "currentPointerPositionAccumulator", "J", "getCurrentPointerPositionAccumulator-F1C5BW0$ui_release", "setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release", "(J)V", "lastMoveEventTimeStamp", "getLastMoveEventTimeStamp$ui_release", "setLastMoveEventTimeStamp$ui_release", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VelocityTracker {
    public static final int $stable = 8;
    private long currentPointerPositionAccumulator;
    private long lastMoveEventTimeStamp;
    private final VelocityTracker1D.Strategy strategy;
    private final VelocityTracker1D xVelocityTracker;
    private final VelocityTracker1D yVelocityTracker;

    public VelocityTracker() {
        VelocityTracker1D.Strategy strategy = VelocityTrackerKt.getVelocityTrackerStrategyUseImpulse() ? VelocityTracker1D.Strategy.Impulse : VelocityTracker1D.Strategy.Lsq2;
        this.strategy = strategy;
        boolean z10 = false;
        int i = 1;
        e eVar = null;
        this.xVelocityTracker = new VelocityTracker1D(z10, strategy, i, eVar);
        this.yVelocityTracker = new VelocityTracker1D(z10, strategy, i, eVar);
        this.currentPointerPositionAccumulator = Offset.INSTANCE.m3911getZeroF1C5BW0();
    }

    /* renamed from: addPosition-Uv8p0NA, reason: not valid java name */
    public final void m5518addPositionUv8p0NA(long timeMillis, long position) {
        this.xVelocityTracker.addDataPoint(timeMillis, Float.intBitsToFloat((int) (position >> 32)));
        this.yVelocityTracker.addDataPoint(timeMillis, Float.intBitsToFloat((int) (position & 4294967295L)));
    }

    /* renamed from: calculateVelocity-9UxMQ8M, reason: not valid java name */
    public final long m5519calculateVelocity9UxMQ8M() {
        return m5520calculateVelocityAH228Gc(VelocityKt.Velocity(Float.MAX_VALUE, Float.MAX_VALUE));
    }

    /* renamed from: calculateVelocity-AH228Gc, reason: not valid java name */
    public final long m5520calculateVelocityAH228Gc(long maximumVelocity) {
        if (!(Velocity.m7082getXimpl(maximumVelocity) > 0.0f && Velocity.m7083getYimpl(maximumVelocity) > 0.0f)) {
            InlineClassHelperKt.throwIllegalStateException("maximumVelocity should be a positive value. You specified=" + ((Object) Velocity.m7089toStringimpl(maximumVelocity)));
        }
        return VelocityKt.Velocity(this.xVelocityTracker.calculateVelocity(Velocity.m7082getXimpl(maximumVelocity)), this.yVelocityTracker.calculateVelocity(Velocity.m7083getYimpl(maximumVelocity)));
    }

    /* renamed from: getCurrentPointerPositionAccumulator-F1C5BW0$ui_release, reason: not valid java name and from getter */
    public final long getCurrentPointerPositionAccumulator() {
        return this.currentPointerPositionAccumulator;
    }

    /* renamed from: getLastMoveEventTimeStamp$ui_release, reason: from getter */
    public final long getLastMoveEventTimeStamp() {
        return this.lastMoveEventTimeStamp;
    }

    public final void resetTracking() {
        this.xVelocityTracker.resetTracking();
        this.yVelocityTracker.resetTracking();
        this.lastMoveEventTimeStamp = 0L;
    }

    /* renamed from: setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release, reason: not valid java name */
    public final void m5522setCurrentPointerPositionAccumulatork4lQ0M$ui_release(long j5) {
        this.currentPointerPositionAccumulator = j5;
    }

    public final void setLastMoveEventTimeStamp$ui_release(long j5) {
        this.lastMoveEventTimeStamp = j5;
    }
}
