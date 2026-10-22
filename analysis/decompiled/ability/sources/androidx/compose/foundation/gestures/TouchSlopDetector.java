package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u000e\u001a\u00020\u0006*\u00020\bø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0010\u001a\u00020\u0006*\u00020\bø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\rJ%\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u00020\b8\u0002@\u0002X\u0082\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/gestures/TouchSlopDetector;", "", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/gestures/Orientation;)V", "", "touchSlop", "Landroidx/compose/ui/geometry/Offset;", "calculatePostSlopOffset-tuRUvjQ", "(F)J", "calculatePostSlopOffset", "mainAxis-k-4lQ0M", "(J)F", "mainAxis", "crossAxis-k-4lQ0M", "crossAxis", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "dragEvent", "addPointerInputChange-GcwITfU", "(Landroidx/compose/ui/input/pointer/PointerInputChange;F)Landroidx/compose/ui/geometry/Offset;", "addPointerInputChange", "LC7/r;", "reset", "()V", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "totalPositionChange", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class TouchSlopDetector {
    private final Orientation orientation;
    private long totalPositionChange;

    /* JADX WARN: Multi-variable type inference failed */
    public TouchSlopDetector() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* renamed from: calculatePostSlopOffset-tuRUvjQ, reason: not valid java name */
    private final long m522calculatePostSlopOffsettuRUvjQ(float touchSlop) {
        if (this.orientation == null) {
            long j5 = this.totalPositionChange;
            return Offset.m3899minusMKHz9U(this.totalPositionChange, Offset.m3902timestuRUvjQ(Offset.m3890divtuRUvjQ(j5, Offset.m3893getDistanceimpl(j5)), touchSlop));
        }
        float fM525mainAxisk4lQ0M = m525mainAxisk4lQ0M(this.totalPositionChange) - (Math.signum(m525mainAxisk4lQ0M(this.totalPositionChange)) * touchSlop);
        float fM524crossAxisk4lQ0M = m524crossAxisk4lQ0M(this.totalPositionChange);
        return this.orientation == Orientation.Horizontal ? OffsetKt.Offset(fM525mainAxisk4lQ0M, fM524crossAxisk4lQ0M) : OffsetKt.Offset(fM524crossAxisk4lQ0M, fM525mainAxisk4lQ0M);
    }

    /* renamed from: addPointerInputChange-GcwITfU, reason: not valid java name */
    public final Offset m523addPointerInputChangeGcwITfU(PointerInputChange dragEvent, float touchSlop) {
        long jM3900plusMKHz9U = Offset.m3900plusMKHz9U(this.totalPositionChange, Offset.m3899minusMKHz9U(dragEvent.getPosition(), dragEvent.getPreviousPosition()));
        this.totalPositionChange = jM3900plusMKHz9U;
        if ((this.orientation == null ? Offset.m3893getDistanceimpl(jM3900plusMKHz9U) : Math.abs(m525mainAxisk4lQ0M(jM3900plusMKHz9U))) >= touchSlop) {
            return Offset.m3884boximpl(m522calculatePostSlopOffsettuRUvjQ(touchSlop));
        }
        return null;
    }

    /* renamed from: crossAxis-k-4lQ0M, reason: not valid java name */
    public final float m524crossAxisk4lQ0M(long j5) {
        return this.orientation == Orientation.Horizontal ? Offset.m3896getYimpl(j5) : Offset.m3895getXimpl(j5);
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    /* renamed from: mainAxis-k-4lQ0M, reason: not valid java name */
    public final float m525mainAxisk4lQ0M(long j5) {
        return this.orientation == Orientation.Horizontal ? Offset.m3895getXimpl(j5) : Offset.m3896getYimpl(j5);
    }

    public final void reset() {
        this.totalPositionChange = Offset.INSTANCE.m3911getZeroF1C5BW0();
    }

    public TouchSlopDetector(Orientation orientation) {
        this.orientation = orientation;
        this.totalPositionChange = Offset.INSTANCE.m3911getZeroF1C5BW0();
    }

    public /* synthetic */ TouchSlopDetector(Orientation orientation, int i, e eVar) {
        this((i & 1) != 0 ? null : orientation);
    }
}
