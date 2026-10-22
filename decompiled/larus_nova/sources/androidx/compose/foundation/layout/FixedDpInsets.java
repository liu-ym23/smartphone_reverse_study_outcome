package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/layout/FixedDpInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "leftDp", "Landroidx/compose/ui/unit/Dp;", "topDp", "rightDp", "bottomDp", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", FaceService.girlLabel, "getLeft", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getTop", "getRight", "getBottom", "toString", "", "equals", "", "other", "", "hashCode", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class FixedDpInsets implements WindowInsets {
    private final float bottomDp;
    private final float leftDp;
    private final float rightDp;
    private final float topDp;

    public /* synthetic */ FixedDpInsets(float r100, float r101, float r102, float r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    public int hashCode() {
        return (((((Dp.m7550hashCodeimpl(this.leftDp) * 31) + Dp.m7550hashCodeimpl(this.topDp)) * 31) + Dp.m7550hashCodeimpl(this.rightDp)) * 31) + Dp.m7550hashCodeimpl(this.bottomDp);
    }

    public String toString() {
        return "Insets(left=" + Dp.m7555toStringimpl(this.leftDp) + ", top=" + Dp.m7555toStringimpl(this.topDp) + ", right=" + Dp.m7555toStringimpl(this.rightDp) + ", bottom=" + Dp.m7555toStringimpl(this.bottomDp) + ')';
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FixedDpInsets) == true) goto L8;
        return false;
    L8:
        FixedDpInsets r101 = (FixedDpInsets) r100;
        if (Dp.m7549equalsimpl0(this.leftDp, r101.leftDp) == true) goto L11;
    L17:
        return false;
    L11:
        if (Dp.m7549equalsimpl0(this.topDp, r101.topDp) == false) goto L17;
        if (Dp.m7549equalsimpl0(this.rightDp, r101.rightDp) == false) goto L17;
        if (Dp.m7549equalsimpl0(this.bottomDp, r101.bottomDp) == false) goto L17;
        return true;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(Density r100) {
        return r100.mo365roundToPx0680j_4(this.bottomDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(Density r100) {
        return r100.mo365roundToPx0680j_4(this.topDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(Density r100, LayoutDirection r101) {
        return r100.mo365roundToPx0680j_4(this.leftDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(Density r100, LayoutDirection r101) {
        return r100.mo365roundToPx0680j_4(this.rightDp);
    }

    private FixedDpInsets(float r100, float r101, float r102, float r103) {
        this.leftDp = r100;
        this.topDp = r101;
        this.rightDp = r102;
        this.bottomDp = r103;
    }
}
