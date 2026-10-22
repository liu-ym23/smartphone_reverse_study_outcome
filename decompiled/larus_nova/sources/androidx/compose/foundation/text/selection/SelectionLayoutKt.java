package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aG\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0000\u001a\u0018\u0010\u0014\u001a\u00020\u000b*\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0000\"\u000e\u0010\u000f\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"getTextFieldSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "rawStartHandleOffset", "", "rawEndHandleOffset", "rawPreviousHandleOffset", "previousSelectionRange", "Landroidx/compose/ui/text/TextRange;", "isStartOfSelection", "", "isStartHandle", "getTextFieldSelectionLayout-RcvT-LA", "(Landroidx/compose/ui/text/TextLayoutResult;IIIJZZ)Landroidx/compose/foundation/text/selection/SelectionLayout;", "UNASSIGNED_SLOT", "resolve2dDirection", "Landroidx/compose/foundation/text/selection/Direction;", "x", "y", "isCollapsed", "Landroidx/compose/foundation/text/selection/Selection;", "layout", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SelectionLayoutKt {
    public static final int UNASSIGNED_SLOT = -1;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[Direction.values().length];
            r100[Direction.BEFORE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Direction.ON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Direction.AFTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public static /* synthetic */ Unit a(Ref.BooleanRef r100, SelectableInfo r101) {
        return isCollapsed$lambda$0(r100, r101);
    }

    public static final boolean isCollapsed(Selection r100, SelectionLayout r101) {
        if (r100 != null) goto L5;
        return true;
    L5:
        if (r101 != null) goto L8;
        return true;
    L8:
        if (r100.getStart().getSelectableId() != r100.getEnd().getSelectableId()) goto L15;
        if (r100.getStart().getOffset() == r100.getEnd().getOffset()) goto L30;
        return false;
    L30:
        return true;
    L15:
        if (r100.getHandlesCrossed() == false) goto L17;
        Selection.AnchorInfo r102 = r100.getStart();
    L19:
        if (r102.getOffset() == 0) goto L22;
        return false;
    L22:
        if (r100.getHandlesCrossed() == false) goto L24;
        Selection.AnchorInfo r103 = r100.getEnd();
    L26:
        if (r101.getFirstInfo().getTextLength() == r103.getOffset()) goto L28;
        return false;
    L28:
        final Ref.BooleanRef r104 = new Ref.BooleanRef();
        r104.element = true;
        r101.forEachMiddleInfo(new j0(r104));
        return r104.element;
    L24:
        r103 = r100.getStart();
        goto L26
    L17:
        r102 = r100.getEnd();
        goto L19
    }

    private static final Unit isCollapsed$lambda$0(Ref.BooleanRef r100, SelectableInfo r101) {
        if (r101.getInputText().length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        r100.element = false;
    L9:
        return Unit.INSTANCE;
    L5:
        r102 = false;
        goto L6
    }

    public static final Direction resolve2dDirection(Direction r100, Direction r101) {
        int[] r102 = WhenMappings.$EnumSwitchMapping$0;
        int r103 = r102[r101.ordinal()];
        if (r103 == 1) goto L20;
        if (r103 == 2) goto L10;
        if (r103 != 3) goto L9;
        return Direction.AFTER;
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        int r104 = r102[r100.ordinal()];
        if (r104 == 1) goto L24;
        if (r104 == 2) goto L23;
        if (r104 != 3) goto L16;
        return Direction.AFTER;
    L16:
        throw new NoWhenBranchMatchedException();
    L23:
        return Direction.ON;
    L24:
        return Direction.BEFORE;
    L20:
        return Direction.BEFORE;
    }

    /* JADX INFO: renamed from: getTextFieldSelectionLayout-RcvT-LA, reason: not valid java name */
    public static final SelectionLayout m1463getTextFieldSelectionLayoutRcvTLA(TextLayoutResult r110, int r111, int r112, int r113, long r114, boolean r115, boolean r210) {
        if (r115 == false) goto L5;
        Selection r100 = null;
    L7:
        return new SingleSelectionLayout(r210, 1, 1, r100, new SelectableInfo(1, 1, r111, r112, r113, r110));
    L5:
        r100 = new Selection(new Selection.AnchorInfo(SelectionHelpersKt.getTextDirectionForOffset(r110, TextRange.m6998getStartimpl(r114)), TextRange.m6998getStartimpl(r114), 1), new Selection.AnchorInfo(SelectionHelpersKt.getTextDirectionForOffset(r110, TextRange.m6993getEndimpl(r114)), TextRange.m6993getEndimpl(r114), 1), TextRange.m6997getReversedimpl(r114));
        goto L7
    }
}
