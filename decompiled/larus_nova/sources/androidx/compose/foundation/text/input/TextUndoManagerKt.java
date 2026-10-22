package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.UndoManagerKt;
import androidx.compose.foundation.text.input.internal.undo.TextDeleteType;
import androidx.compose.foundation.text.input.internal.undo.TextEditType;
import androidx.compose.foundation.text.input.internal.undo.TextUndoOperation;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a.\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0000\"\u0018\u0010\r\u001a\u00020\f*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"merge", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", TeaEventTrack.ACTION_DRAMA_NEXT, "recordChanges", "", "Landroidx/compose/foundation/text/input/TextUndoManager;", TeaEventTrack.ACTION_DRAMA_PRE, "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", UGCMonitor.TYPE_POST, "changes", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "allowMerge", "", "isNewLineInsert", "(Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;)Z", "TEXT_UNDO_CAPACITY", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextUndoManagerKt {
    private static final int TEXT_UNDO_CAPACITY = 100;

    private static final boolean isNewLineInsert(TextUndoOperation r100) {
        if (Intrinsics.areEqual(r100.getPostText(), "\n") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100.getPostText(), "\r\n") == true) goto L8;
        return false;
    }

    public static final TextUndoOperation merge(TextUndoOperation r110, TextUndoOperation r111) {
        if (r110.getCanMerge() == true) goto L5;
    L42:
        return null;
    L5:
        if (r111.getCanMerge() == false) goto L42;
        if (r111.getTimeInMillis() < r110.getTimeInMillis()) goto L42;
        if ((r111.getTimeInMillis() - r110.getTimeInMillis()) >= UndoManagerKt.getSNAPSHOTS_INTERVAL_MILLIS()) goto L42;
        if (isNewLineInsert(r110) == true) goto L42;
        if (isNewLineInsert(r111) == true) goto L42;
        if (r110.getTextEditType() == r111.getTextEditType()) goto L21;
        return null;
    L21:
        if (r110.getTextEditType() != TextEditType.Insert) goto L27;
        if ((r110.getIndex() + r110.getPostText().length()) != r111.getIndex()) goto L27;
        return new TextUndoOperation(r110.getIndex(), "", r110.getPostText() + r111.getPostText(), r110.m1379getPreSelectiond9O1mEE(), r111.m1378getPostSelectiond9O1mEE(), r110.getTimeInMillis(), false, 64, null);
    L27:
        if (r110.getTextEditType() != TextEditType.Delete) goto L42;
        if (r110.getDeletionType() != r111.getDeletionType()) goto L42;
        if (r110.getDeletionType() == TextDeleteType.Start) goto L35;
        if (r110.getDeletionType() != TextDeleteType.End) goto L42;
    L35:
        if (r110.getIndex() != (r111.getIndex() + r111.getPreText().length())) goto L39;
        return new TextUndoOperation(r111.getIndex(), r111.getPreText() + r110.getPreText(), "", r110.m1379getPreSelectiond9O1mEE(), r111.m1378getPostSelectiond9O1mEE(), r110.getTimeInMillis(), false, 64, null);
    L39:
        if (r110.getIndex() != r111.getIndex()) goto L42;
        return new TextUndoOperation(r110.getIndex(), r110.getPreText() + r111.getPreText(), "", r110.m1379getPreSelectiond9O1mEE(), r111.m1378getPostSelectiond9O1mEE(), r110.getTimeInMillis(), false, 64, null);
    }

    public static final void recordChanges(TextUndoManager r110, TextFieldCharSequence r210, TextFieldCharSequence r211, TextFieldBuffer.ChangeList r212, boolean r213) {
        if (r212.getChangeCount() <= 1) goto L6;
        r110.record(new TextUndoOperation(0, r210.toString(), r211.toString(), r210.m1197getSelectiond9O1mEE(), r211.m1197getSelectiond9O1mEE(), 0, false, 32, null));
        return;
    L6:
        if (r212.getChangeCount() != 1) goto L14;
        long r100 = r212.mo1193getOriginalRangejx7JFs(0);
        long r101 = r212.mo1194getRangejx7JFs(0);
        if (TextRange.m6992getCollapsedimpl(r100) == true) goto L10;
    L11:
        r110.record(new TextUndoOperation(TextRange.m6996getMinimpl(r100), TextRangeKt.m7005substringFDrldGo(r210, r100), TextRangeKt.m7005substringFDrldGo(r211, r101), r210.m1197getSelectiond9O1mEE(), r211.m1197getSelectiond9O1mEE(), 0, r213, 32, null));
        return;
    L10:
        if (TextRange.m6992getCollapsedimpl(r101) == false) goto L11;
        return;
    }

    public static /* synthetic */ void recordChanges$default(TextUndoManager r100, TextFieldCharSequence r101, TextFieldCharSequence r102, TextFieldBuffer.ChangeList r103, boolean r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = true;
    L5:
        recordChanges(r100, r101, r102, r103, r104);
    }
}
