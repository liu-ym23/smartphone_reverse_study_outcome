package androidx.compose.foundation.shape;

import androidx.compose.ui.platform.InspectableValue;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u0004HÂ\u0003¢\u0006\u0004\b\u0016\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Landroidx/compose/foundation/shape/DpCornerSize;", "Landroidx/compose/foundation/shape/CornerSize;", "Landroidx/compose/ui/platform/InspectableValue;", "size", "Landroidx/compose/ui/unit/Dp;", "<init>", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", FaceService.girlLabel, "toPx", "", "shapeSize", "Landroidx/compose/ui/geometry/Size;", "density", "Landroidx/compose/ui/unit/Density;", "toPx-TmRCtEA", "(JLandroidx/compose/ui/unit/Density;)F", "toString", "", "valueOverride", "getValueOverride-D9Ej5fM", "()F", "component1", "component1-D9Ej5fM", "copy", "copy-0680j_4", "(F)Landroidx/compose/foundation/shape/DpCornerSize;", "equals", "", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DpCornerSize implements CornerSize, InspectableValue {
    private final float size;

    public /* synthetic */ DpCornerSize(float r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
    private final float m1022component1D9Ej5fM() {
        return this.size;
    }

    /* JADX INFO: renamed from: copy-0680j_4$default, reason: not valid java name */
    public static /* synthetic */ DpCornerSize m1023copy0680j_4$default(DpCornerSize r100, float r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.size;
    L6:
        return r100.m1024copy0680j_4(r101);
    }

    /* JADX INFO: renamed from: copy-0680j_4, reason: not valid java name */
    public final DpCornerSize m1024copy0680j_4(float r100) {
        return new DpCornerSize(r100, null);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DpCornerSize) == true) goto L9;
        return false;
    L9:
        if (Dp.m7549equalsimpl0(this.size, ((DpCornerSize) r100).size) == true) goto L11;
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
        return Dp.m7550hashCodeimpl(this.size);
    }

    public String toString() {
        return "CornerSize(size = " + this.size + ".dp)";
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public /* bridge */ /* synthetic */ Object getValueOverride() {
        return Dp.m7542boximpl(m1025getValueOverrideD9Ej5fM());
    }

    /* JADX INFO: renamed from: getValueOverride-D9Ej5fM, reason: not valid java name */
    public float m1025getValueOverrideD9Ej5fM() {
        return this.size;
    }

    private DpCornerSize(float r100) {
        this.size = r100;
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    /* JADX INFO: renamed from: toPx-TmRCtEA */
    public float mo1017toPxTmRCtEA(long r100, Density r101) {
        return r101.mo371toPx0680j_4(this.size);
    }
}
