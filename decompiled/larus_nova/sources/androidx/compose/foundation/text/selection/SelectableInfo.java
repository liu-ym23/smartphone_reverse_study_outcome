package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0000J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0005J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005J\b\u00100\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0010R\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#¨\u00061"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectableInfo;", "", "selectableId", "", "slot", "", "rawStartHandleOffset", "rawEndHandleOffset", "rawPreviousHandleOffset", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "<init>", "(JIIIILandroidx/compose/ui/text/TextLayoutResult;)V", "getSelectableId", "()J", "getSlot", "()I", "getRawStartHandleOffset", "getRawEndHandleOffset", "getRawPreviousHandleOffset", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "inputText", "", "getInputText", "()Ljava/lang/String;", "textLength", "getTextLength", "rawCrossStatus", "Landroidx/compose/foundation/text/selection/CrossStatus;", "getRawCrossStatus", "()Landroidx/compose/foundation/text/selection/CrossStatus;", "startRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getStartRunDirection", "()Landroidx/compose/ui/text/style/ResolvedTextDirection;", "endRunDirection", "getEndRunDirection", "shouldRecomputeSelection", "", "other", "anchorForOffset", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "offset", "makeSingleLayoutSelection", "Landroidx/compose/foundation/text/selection/Selection;", "start", "end", "toString", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SelectableInfo {
    public static final int $stable = 0;
    private final int rawEndHandleOffset;
    private final int rawPreviousHandleOffset;
    private final int rawStartHandleOffset;
    private final long selectableId;
    private final int slot;
    private final TextLayoutResult textLayoutResult;

    static {
        $stable = TextLayoutResult.$stable;
    }

    private final ResolvedTextDirection getEndRunDirection() {
        return SelectionHelpersKt.getTextDirectionForOffset(this.textLayoutResult, this.rawEndHandleOffset);
    }

    private final ResolvedTextDirection getStartRunDirection() {
        return SelectionHelpersKt.getTextDirectionForOffset(this.textLayoutResult, this.rawStartHandleOffset);
    }

    public final String getInputText() {
        return this.textLayoutResult.getLayoutInput().getText().getText();
    }

    public final CrossStatus getRawCrossStatus() {
        int r100 = this.rawStartHandleOffset;
        int r101 = this.rawEndHandleOffset;
        if (r100 < r101) goto L9;
        if (r100 <= r101) goto L8;
        return CrossStatus.CROSSED;
    L8:
        return CrossStatus.COLLAPSED;
    L9:
        return CrossStatus.NOT_CROSSED;
    }

    public String toString() {
        return "SelectionInfo(id=" + this.selectableId + ", range=(" + this.rawStartHandleOffset + '-' + getStartRunDirection() + ',' + this.rawEndHandleOffset + '-' + getEndRunDirection() + "), prevOffset=" + this.rawPreviousHandleOffset + ')';
    }

    public final int getTextLength() {
        return getInputText().length();
    }

    public final int getRawEndHandleOffset() {
        return this.rawEndHandleOffset;
    }

    public final int getRawPreviousHandleOffset() {
        return this.rawPreviousHandleOffset;
    }

    public final int getRawStartHandleOffset() {
        return this.rawStartHandleOffset;
    }

    public final long getSelectableId() {
        return this.selectableId;
    }

    public final int getSlot() {
        return this.slot;
    }

    public final TextLayoutResult getTextLayoutResult() {
        return this.textLayoutResult;
    }

    public final Selection.AnchorInfo anchorForOffset(int r100) {
        return new Selection.AnchorInfo(SelectionHelpersKt.getTextDirectionForOffset(this.textLayoutResult, r100), r100, this.selectableId);
    }

    public final boolean shouldRecomputeSelection(SelectableInfo r100) {
        if (this.selectableId == r100.selectableId) goto L5;
    L10:
        return true;
    L5:
        if (this.rawStartHandleOffset != r100.rawStartHandleOffset) goto L10;
        if (this.rawEndHandleOffset != r100.rawEndHandleOffset) goto L10;
        return false;
    }

    public final Selection makeSingleLayoutSelection(int r100, int r101) {
        Selection.AnchorInfo r102 = anchorForOffset(r100);
        Selection.AnchorInfo r103 = anchorForOffset(r101);
        if (r100 <= r101) goto L5;
        boolean r104 = true;
    L7:
        return new Selection(r102, r103, r104);
    L5:
        r104 = false;
        goto L7
    }

    public SelectableInfo(long r100, int r101, int r102, int r103, int r104, TextLayoutResult r105) {
        this.selectableId = r100;
        this.slot = r101;
        this.rawStartHandleOffset = r102;
        this.rawEndHandleOffset = r103;
        this.rawPreviousHandleOffset = r104;
        this.textLayoutResult = r105;
    }
}
