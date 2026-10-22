package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", PickerReporterConstants.KEY.TARGET, "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class EditingBufferKt {
    /* JADX INFO: renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m7163updateRangeAfterDeletepWDy79M(long r100, long r101) {
        int r102 = TextRange.m6996getMinimpl(r100);
        int r103 = TextRange.m6995getMaximpl(r100);
        if (TextRange.m7000intersects5zctL8(r101, r100) == false) goto L15;
        if (TextRange.m6988contains5zctL8(r101, r100) == false) goto L8;
        r102 = TextRange.m6996getMinimpl(r101);
        r103 = r102;
    L19:
        return TextRangeKt.TextRange(r102, r103);
    L8:
        if (TextRange.m6988contains5zctL8(r100, r101) == false) goto L11;
        int r104 = TextRange.m6994getLengthimpl(r101);
    L17:
        r103 = r103 - r104;
        goto L19
    L11:
        if (TextRange.m6989containsimpl(r101, r102) == false) goto L13;
        r102 = TextRange.m6996getMinimpl(r101);
        r104 = TextRange.m6994getLengthimpl(r101);
        goto L17
    L13:
        r103 = TextRange.m6996getMinimpl(r101);
        goto L19
    L15:
        if (r103 <= TextRange.m6996getMinimpl(r101)) goto L19;
        r102 = r102 - TextRange.m6994getLengthimpl(r101);
        r104 = TextRange.m6994getLengthimpl(r101);
        goto L17
    }
}
