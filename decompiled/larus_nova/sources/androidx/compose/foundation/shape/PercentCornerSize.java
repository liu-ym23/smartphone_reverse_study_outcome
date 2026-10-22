package androidx.compose.foundation.shape;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.platform.InspectableValue;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0013\u001a\u00020\u0004HÂ\u0003J\u0013\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/shape/PercentCornerSize;", "Landroidx/compose/foundation/shape/CornerSize;", "Landroidx/compose/ui/platform/InspectableValue;", "percent", "", "<init>", "(F)V", "toPx", "shapeSize", "Landroidx/compose/ui/geometry/Size;", "density", "Landroidx/compose/ui/unit/Density;", "toPx-TmRCtEA", "(JLandroidx/compose/ui/unit/Density;)F", "toString", "", "valueOverride", "getValueOverride", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PercentCornerSize implements CornerSize, InspectableValue {
    private final float percent;

    private final float component1() {
        return this.percent;
    }

    public static /* synthetic */ PercentCornerSize copy$default(PercentCornerSize r100, float r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.percent;
    L6:
        return r100.copy(r101);
    }

    public final PercentCornerSize copy(float r100) {
        return new PercentCornerSize(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PercentCornerSize) == true) goto L9;
        return false;
    L9:
        if (Float.compare(this.percent, ((PercentCornerSize) r100).percent) == 0) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public final /* synthetic */ Sequence getInspectableElements() {
        return InspectableValue.CC.$default$getInspectableElements(this);
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public final /* synthetic */ String getNameFallback() {
        return InspectableValue.CC.$default$getNameFallback(this);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.percent);
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public String getValueOverride() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.percent);
        r100.append('%');
        return r100.toString();
    }

    public String toString() {
        return "CornerSize(size = " + this.percent + "%)";
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public /* bridge */ /* synthetic */ Object getValueOverride() {
        return getValueOverride();
    }

    public PercentCornerSize(float r100) {
        this.percent = r100;
        if (r100 >= 0.0f) goto L5;
    L6:
        InlineClassHelperKt.throwIllegalArgumentException("The percent should be in the range of [0, 100]");
        return;
    L5:
        if (r100 > 100.0f) goto L6;
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    /* JADX INFO: renamed from: toPx-TmRCtEA */
    public float mo1017toPxTmRCtEA(long r100, Density r101) {
        return Size.m4650getMinDimensionimpl(r100) * (this.percent / 100.0f);
    }
}
