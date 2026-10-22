package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\n\u001a\u00020\u000b*\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000e\u001a\u00020\u000b*\u00020\u0005¢\u0006\u0004\b\u000f\u0010\rJ\u001d\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/gestures/TouchSlopDetector;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "initialPositionChange", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(Landroidx/compose/foundation/gestures/Orientation;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "mainAxis", "", "mainAxis-k-4lQ0M", "(J)F", "crossAxis", "crossAxis-k-4lQ0M", "totalPositionChange", "J", "addPointerInputChange", "dragEvent", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "touchSlop", "addPointerInputChange-dBAh8RU", "(Landroidx/compose/ui/input/pointer/PointerInputChange;F)J", BasicTestActionHandler.TEST_ACTION_RESET, "", "calculatePostSlopOffset", "calculatePostSlopOffset-tuRUvjQ", "(F)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TouchSlopDetector {
    public static final int $stable = 8;
    private final Orientation orientation;
    private long totalPositionChange;

    public /* synthetic */ TouchSlopDetector(Orientation r100, long r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    public final void reset() {
        this.totalPositionChange = Offset.Companion.m4598getZeroF1C5BW0();
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    /* JADX INFO: renamed from: calculatePostSlopOffset-tuRUvjQ, reason: not valid java name */
    private final long m528calculatePostSlopOffsettuRUvjQ(float r100) {
        if (this.orientation != null) goto L5;
        long r101 = this.totalPositionChange;
        return Offset.m4586minusMKHz9U(this.totalPositionChange, Offset.m4589timestuRUvjQ(Offset.m4577divtuRUvjQ(r101, Offset.m4580getDistanceimpl(r101)), r100));
    L5:
        float r102 = m531mainAxisk4lQ0M(this.totalPositionChange) - (Math.signum(m531mainAxisk4lQ0M(this.totalPositionChange)) * r100);
        float r103 = m530crossAxisk4lQ0M(this.totalPositionChange);
        if (this.orientation != Orientation.Horizontal) goto L9;
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(r102) << 32) | (((long) Float.floatToRawIntBits(r103)) & BodyPartID.bodyIdMax));
    L9:
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(r103) << 32) | (Float.floatToRawIntBits(r102) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: crossAxis-k-4lQ0M, reason: not valid java name */
    public final float m530crossAxisk4lQ0M(long r100) {
        if (this.orientation != Orientation.Horizontal) goto L5;
        long r101 = r100 & BodyPartID.bodyIdMax;
    L7:
        return Float.intBitsToFloat((int) r101);
    L5:
        r101 = r100 >> 32;
        goto L7
    }

    /* JADX INFO: renamed from: mainAxis-k-4lQ0M, reason: not valid java name */
    public final float m531mainAxisk4lQ0M(long r100) {
        if (this.orientation != Orientation.Horizontal) goto L5;
        long r101 = r100 >> 32;
    L7:
        return Float.intBitsToFloat((int) r101);
    L5:
        r101 = r100 & BodyPartID.bodyIdMax;
        goto L7
    }

    private TouchSlopDetector(Orientation r100, long r101) {
        this.orientation = r100;
        this.totalPositionChange = r101;
    }

    /* JADX INFO: renamed from: addPointerInputChange-dBAh8RU, reason: not valid java name */
    public final long m529addPointerInputChangedBAh8RU(PointerInputChange r100, float r101) {
        long r102 = Offset.m4586minusMKHz9U(r100.m6126getPositionF1C5BW0(), r100.m6127getPreviousPositionF1C5BW0());
        long r103 = Offset.m4587plusMKHz9U(this.totalPositionChange, r102);
        this.totalPositionChange = r103;
        if (this.orientation != null) goto L5;
        float r104 = Offset.m4580getDistanceimpl(r103);
    L7:
        if (r104 < r101) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L13;
        return m528calculatePostSlopOffsettuRUvjQ(r101);
    L13:
        return Offset.Companion.m4597getUnspecifiedF1C5BW0();
    L9:
        r105 = false;
        goto L10
    L5:
        r104 = Math.abs(m531mainAxisk4lQ0M(r103));
        goto L7
    }

    public /* synthetic */ TouchSlopDetector(Orientation r100, long r101, int r102, DefaultConstructorMarker r103) {
        DefaultConstructorMarker r104 = null;
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = Offset.Companion.m4598getZeroF1C5BW0();
    L8:
        this(r100, r101, r104);
    }
}
