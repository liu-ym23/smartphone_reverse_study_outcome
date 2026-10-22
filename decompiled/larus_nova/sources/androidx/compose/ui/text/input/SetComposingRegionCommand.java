package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/text/input/SetComposingRegionCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "start", "", "end", "<init>", "(II)V", "getStart", "()I", "getEnd", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SetComposingRegionCommand implements EditCommand {
    public static final int $stable = 0;
    private final int end;
    private final int start;

    public int hashCode() {
        return (this.start * 31) + this.end;
    }

    public String toString() {
        return "SetComposingRegionCommand(start=" + this.start + ", end=" + this.end + ')';
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getStart() {
        return this.start;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(EditingBuffer r100) {
        if (r100.hasComposition$ui_text() == false) goto L5;
        r100.commitComposition$ui_text();
    L5:
        int r101 = RangesKt.coerceIn(this.start, 0, r100.getLength$ui_text());
        int r102 = RangesKt.coerceIn(this.end, 0, r100.getLength$ui_text());
        if (r101 == r102) goto L11;
        if (r101 >= r102) goto L9;
        r100.setComposition$ui_text(r101, r102);
        return;
    L9:
        r100.setComposition$ui_text(r102, r101);
        return;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SetComposingRegionCommand) == true) goto L8;
        return false;
    L8:
        SetComposingRegionCommand r101 = (SetComposingRegionCommand) r100;
        if (this.start == r101.start) goto L12;
        return false;
    L12:
        if (this.end == r101.end) goto L14;
        return false;
    L14:
        return true;
    }

    public SetComposingRegionCommand(int r100, int r101) {
        this.start = r100;
        this.end = r101;
    }
}
