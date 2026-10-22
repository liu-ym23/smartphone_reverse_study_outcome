package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.")
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u0003HÂ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u001a"}, d2 = {"Landroidx/compose/material/FixedThreshold;", "Landroidx/compose/material/ThresholdConfig;", "offset", "Landroidx/compose/ui/unit/Dp;", "<init>", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", FaceService.girlLabel, "computeThreshold", "", "Landroidx/compose/ui/unit/Density;", "fromValue", "toValue", "component1", "component1-D9Ej5fM", "()F", "copy", "copy-0680j_4", "(F)Landroidx/compose/material/FixedThreshold;", "equals", "", "other", "", "hashCode", "", "toString", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FixedThreshold implements ThresholdConfig {
    public static final int $stable = 0;
    private final float offset;

    public /* synthetic */ FixedThreshold(float r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
    private final float m1657component1D9Ej5fM() {
        return this.offset;
    }

    /* JADX INFO: renamed from: copy-0680j_4$default, reason: not valid java name */
    public static /* synthetic */ FixedThreshold m1658copy0680j_4$default(FixedThreshold r100, float r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.offset;
    L6:
        return r100.m1659copy0680j_4(r101);
    }

    /* JADX INFO: renamed from: copy-0680j_4, reason: not valid java name */
    public final FixedThreshold m1659copy0680j_4(float r100) {
        return new FixedThreshold(r100, null);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FixedThreshold) == true) goto L9;
        return false;
    L9:
        if (Dp.m7549equalsimpl0(this.offset, ((FixedThreshold) r100).offset) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return Dp.m7550hashCodeimpl(this.offset);
    }

    public String toString() {
        return "FixedThreshold(offset=" + Dp.m7555toStringimpl(this.offset) + ')';
    }

    private FixedThreshold(float r100) {
        this.offset = r100;
    }

    @Override // androidx.compose.material.ThresholdConfig
    public float computeThreshold(Density r100, float r101, float r102) {
        return r101 + (r100.mo371toPx0680j_4(this.offset) * Math.signum(r102 - r101));
    }
}
