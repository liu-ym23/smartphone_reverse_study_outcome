package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a4\u0010\u000b\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a,\u0010\u0015\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0014\u0010\u0017\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0000\u001a\u0014\u0010\u0018\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0002\u001a\u001c\u0010\u0019\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\tH\u0002¨\u0006\u001b²\u0006\n\u0010\u001c\u001a\u00020\tX\u008a\u0084\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0001X\u008a\u0084\u0002"}, d2 = {"updateSelectionBoundary", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "info", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "previousSelectionAnchor", "isExpanding", "", "currentRawOffset", "", "isStart", "snapToWordBoundary", "currentLine", "currentOffset", "otherOffset", "crossed", "adjustToBoundaries", "Landroidx/compose/foundation/text/selection/Selection;", "layout", "boundaryFunction", "Landroidx/compose/foundation/text/selection/BoundaryFunction;", "anchorOnBoundary", "slot", "ensureAtLeastOneChar", "expandOneChar", "changeOffset", "newOffset", "foundation_release", "currentRawLine", "anchorSnappedToWordBoundary"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SelectionAdjustmentKt {
    public static /* synthetic */ int a(SelectableInfo r100, int r101) {
        return updateSelectionBoundary$lambda$0(r100, r101);
    }

    public static /* synthetic */ Selection.AnchorInfo b(SelectableInfo r100, int r101, int r102, SelectionLayout r103, Lazy r104) {
        return updateSelectionBoundary$lambda$2(r100, r101, r102, r103, r104);
    }

    private static final int updateSelectionBoundary$lambda$1(Lazy<Integer> r100) {
        return r100.getValue().intValue();
    }

    private static final Selection.AnchorInfo updateSelectionBoundary$lambda$3(Lazy<Selection.AnchorInfo> r100) {
        return r100.getValue();
    }

    public static final /* synthetic */ Selection access$adjustToBoundaries(SelectionLayout r100, BoundaryFunction r101) {
        return adjustToBoundaries(r100, r101);
    }

    private static final Selection adjustToBoundaries(SelectionLayout r100, BoundaryFunction r101) {
        if (r100.getCrossStatus() != CrossStatus.CROSSED) goto L5;
        boolean r102 = true;
    L7:
        return new Selection(anchorOnBoundary(r100.getStartInfo(), r102, true, r100.getStartSlot(), r101), anchorOnBoundary(r100.getEndInfo(), r102, false, r100.getEndSlot(), r101), r102);
    L5:
        r102 = false;
        goto L7
    }

    public static final Selection ensureAtLeastOneChar(Selection r100, SelectionLayout r101) {
        if (SelectionLayoutKt.isCollapsed(r100, r101) == true) goto L5;
        return r100;
    L5:
        String r102 = r101.getCurrentInfo().getInputText();
        boolean r103 = true;
        if (r101.getSize() <= 1) goto L8;
        return r100;
    L8:
        if (r101.getPreviousSelection() != null) goto L10;
        return r100;
    L10:
        if (r102.length() == 0) goto L13;
        r103 = false;
    L13:
        if (r103 == false) goto L16;
        return r100;
    L16:
        return expandOneChar(r100, r101);
    }

    private static final Selection expandOneChar(Selection r110, SelectionLayout r111) {
        SelectableInfo r100 = r111.getCurrentInfo();
        String r101 = r100.getInputText();
        int r102 = r100.getRawStartHandleOffset();
        int r103 = r101.length();
        if (r102 != 0) goto L8;
        int r104 = StringHelpers_androidKt.findFollowingBreak(r101, 0);
        if (r111.isStartHandle() == false) goto L29;
        return Selection.copy$default(r110, changeOffset(r110.getStart(), r100, r104), null, true, 2, null);
    L29:
        return Selection.copy$default(r110, null, changeOffset(r110.getEnd(), r100, r104), false, 1, null);
    L8:
        if (r102 != r103) goto L13;
        int r105 = StringHelpers_androidKt.findPrecedingBreak(r101, r103);
        if (r111.isStartHandle() == false) goto L31;
        return Selection.copy$default(r110, changeOffset(r110.getStart(), r100, r105), null, false, 2, null);
    L31:
        return Selection.copy$default(r110, null, changeOffset(r110.getEnd(), r100, r105), true, 1, null);
    L13:
        Selection r106 = r111.getPreviousSelection();
        if (r106 != null) goto L16;
    L18:
        boolean r107 = false;
    L20:
        if ((r111.isStartHandle() ^ r107) == false) goto L22;
        int r108 = StringHelpers_androidKt.findPrecedingBreak(r101, r102);
    L24:
        if (r111.isStartHandle() == false) goto L27;
        return Selection.copy$default(r110, changeOffset(r110.getStart(), r100, r108), null, r107, 2, null);
    L27:
        return Selection.copy$default(r110, null, changeOffset(r110.getEnd(), r100, r108), r107, 1, null);
    L22:
        r108 = StringHelpers_androidKt.findFollowingBreak(r101, r102);
        goto L24
    L16:
        if (r106.getHandlesCrossed() != true) goto L18;
        r107 = true;
        goto L20
    }

    private static final int updateSelectionBoundary$lambda$0(SelectableInfo r100, int r101) {
        return r100.getTextLayoutResult().getLineForOffset(r101);
    }

    public static final /* synthetic */ Selection.AnchorInfo access$updateSelectionBoundary(SelectionLayout r100, SelectableInfo r101, Selection.AnchorInfo r102) {
        return updateSelectionBoundary(r100, r101, r102);
    }

    private static final Selection.AnchorInfo changeOffset(Selection.AnchorInfo r100, SelectableInfo r101, int r102) {
        return Selection.AnchorInfo.copy$default(r100, r101.getTextLayoutResult().getBidiRunDirection(r102), r102, 0, 4, null);
    }

    private static final boolean isExpanding(SelectableInfo r100, int r101, boolean r102) {
        if (r100.getRawPreviousHandleOffset() != (-1)) goto L6;
        return true;
    L6:
        if (r101 != r100.getRawPreviousHandleOffset()) goto L9;
        return false;
    L9:
        if (r100.getRawCrossStatus() != CrossStatus.CROSSED) goto L11;
        boolean r103 = true;
    L13:
        if ((r102 ^ r103) == false) goto L18;
        if (r101 < r100.getRawPreviousHandleOffset()) goto L22;
    L20:
        return false;
    L22:
        return true;
    L18:
        if (r101 <= r100.getRawPreviousHandleOffset()) goto L20;
        return true;
    L11:
        r103 = false;
        goto L13
    }

    private static final Selection.AnchorInfo updateSelectionBoundary(final SelectionLayout r110, final SelectableInfo r111, Selection.AnchorInfo r112) {
        if (r110.isStartHandle() == false) goto L5;
        final int r100 = r111.getRawStartHandleOffset();
    L7:
        if (r110.isStartHandle() == false) goto L9;
        int r101 = r110.getStartSlot();
    L11:
        if (r101 != r111.getSlot()) goto L13;
        LazyThreadSafetyMode r102 = LazyThreadSafetyMode.NONE;
        final Lazy r103 = LazyKt.lazy(r102, new q(r111, r100));
        if (r110.isStartHandle() == false) goto L17;
        int r104 = r111.getRawEndHandleOffset();
    L18:
        final int r105 = r104;
        final int r106 = r100;
        Lazy r107 = LazyKt.lazy(r102, new r(r111, r106, r105, r110, r103));
        if (r111.getSelectableId() != r112.getSelectableId()) goto L21;
        int r108 = r111.getRawPreviousHandleOffset();
        if (r100 != r108) goto L25;
        return r112;
    L25:
        int r109 = r111.getTextLayoutResult().getLineForOffset(r108);
        if (updateSelectionBoundary$lambda$1(r103) != r109) goto L28;
        int r113 = r112.getOffset();
        long r114 = r111.getTextLayoutResult().m6970getWordBoundaryjx7JFs(r113);
        if (isExpanding(r111, r100, r110.isStartHandle()) == true) goto L34;
        return r111.anchorForOffset(r100);
    L34:
        if (r113 == TextRange.m6998getStartimpl(r114)) goto L41;
        if (r113 == TextRange.m6993getEndimpl(r114)) goto L41;
        return r111.anchorForOffset(r100);
    L41:
        return updateSelectionBoundary$lambda$3(r107);
    L28:
        return updateSelectionBoundary$lambda$3(r107);
    L21:
        return updateSelectionBoundary$lambda$3(r107);
    L17:
        r104 = r111.getRawStartHandleOffset();
        goto L18
    L13:
        return r111.anchorForOffset(r100);
    L9:
        r101 = r110.getEndSlot();
        goto L11
    L5:
        r100 = r111.getRawEndHandleOffset();
        goto L7
    }

    private static final Selection.AnchorInfo anchorOnBoundary(SelectableInfo r100, boolean r101, boolean r102, int r103, BoundaryFunction r104) {
        if (r102 == false) goto L4;
        int r105 = r100.getRawStartHandleOffset();
    L6:
        if (r103 != r100.getSlot()) goto L8;
        long r106 = r104.mo1439getBoundaryfzxv0v0(r100, r105);
        if ((r101 ^ r102) == false) goto L12;
        int r107 = TextRange.m6998getStartimpl(r106);
    L14:
        return r100.anchorForOffset(r107);
    L12:
        r107 = TextRange.m6993getEndimpl(r106);
        goto L14
    L8:
        return r100.anchorForOffset(r105);
    L4:
        r105 = r100.getRawEndHandleOffset();
        goto L6
    }

    private static final Selection.AnchorInfo updateSelectionBoundary$lambda$2(SelectableInfo r100, int r101, int r102, SelectionLayout r103, Lazy r110) {
        int r104 = updateSelectionBoundary$lambda$1(r110);
        boolean r105 = r103.isStartHandle();
        if (r103.getCrossStatus() != CrossStatus.CROSSED) goto L5;
        boolean r106 = true;
    L7:
        return snapToWordBoundary(r100, r104, r101, r102, r105, r106);
    L5:
        r106 = false;
        goto L7
    }

    private static final Selection.AnchorInfo snapToWordBoundary(SelectableInfo r100, int r101, int r102, int r103, boolean r104, boolean r110) {
        long r105 = r100.getTextLayoutResult().m6970getWordBoundaryjx7JFs(r102);
        if (r100.getTextLayoutResult().getLineForOffset(TextRange.m6998getStartimpl(r105)) != r101) goto L6;
        int r106 = TextRange.m6998getStartimpl(r105);
    L10:
        if (r100.getTextLayoutResult().getLineForOffset(TextRange.m6993getEndimpl(r105)) != r101) goto L13;
        int r107 = TextRange.m6993getEndimpl(r105);
    L16:
        if (r106 == r103) goto L18;
        if (r107 != r103) goto L23;
        return r100.anchorForOffset(r106);
    L23:
        if ((r104 ^ r110) == false) goto L26;
        if (r102 <= r107) goto L29;
    L27:
        r106 = r107;
    L29:
        return r100.anchorForOffset(r106);
    L26:
        if (r102 < r106) goto L29;
    L18:
        return r100.anchorForOffset(r107);
    L13:
        if (r101 < r100.getTextLayoutResult().getLineCount()) goto L15;
        r107 = TextLayoutResult.getLineEnd$default(r100.getTextLayoutResult(), r100.getTextLayoutResult().getLineCount() - 1, false, 2, null);
        goto L16
    L15:
        r107 = TextLayoutResult.getLineEnd$default(r100.getTextLayoutResult(), r101, false, 2, null);
        goto L16
    L6:
        if (r101 < r100.getTextLayoutResult().getLineCount()) goto L8;
        r106 = r100.getTextLayoutResult().getLineStart(r100.getTextLayoutResult().getLineCount() - 1);
        goto L10
    L8:
        r106 = r100.getTextLayoutResult().getLineStart(r101);
        goto L10
    }
}
