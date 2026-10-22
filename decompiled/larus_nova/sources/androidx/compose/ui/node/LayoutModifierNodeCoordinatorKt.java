package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"calculateAlignmentAndPlaceChildAsNeeded", "", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LayoutModifierNodeCoordinatorKt {
    public static final /* synthetic */ int access$calculateAlignmentAndPlaceChildAsNeeded(LookaheadCapablePlaceable r100, AlignmentLine r101) {
        return calculateAlignmentAndPlaceChildAsNeeded(r100, r101);
    }

    private static final int calculateAlignmentAndPlaceChildAsNeeded(LookaheadCapablePlaceable r100, AlignmentLine r101) {
        LookaheadCapablePlaceable r102 = r100.getChild();
        if (r102 == null) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L9;
        InlineClassHelperKt.throwIllegalStateException("Child of " + r100 + " cannot be null when calculating alignment line");
    L9:
        if (r100.getMeasureResult$ui_release().getAlignmentLines().containsKey(r101) == false) goto L14;
        Integer r104 = r100.getMeasureResult$ui_release().getAlignmentLines().get(r101);
        if (r104 != null) goto L13;
        return Integer.MIN_VALUE;
    L13:
        return r104.intValue();
    L14:
        int r105 = r102.get(r101);
        if (r105 != Integer.MIN_VALUE) goto L17;
        return Integer.MIN_VALUE;
    L17:
        r102.setShallowPlacing$ui_release(true);
        r100.setPlacingForAlignment$ui_release(true);
        r100.replace$ui_release();
        r102.setShallowPlacing$ui_release(false);
        r100.setPlacingForAlignment$ui_release(false);
        if ((r101 instanceof HorizontalAlignmentLine) == false) goto L20;
        int r106 = IntOffset.m7677getYimpl(r102.mo6485getPositionnOccac());
    L22:
        return r105 + r106;
    L20:
        r106 = IntOffset.m7676getXimpl(r102.mo6485getPositionnOccac());
        goto L22
    L5:
        r103 = false;
        goto L6
    }
}
