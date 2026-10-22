package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", TypedValues.AttributesType.S_TARGET, "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m6473updateRangeAfterDeletepWDy79M(long j5, long j6) {
        int iM6307getLengthimpl;
        int iM6309getMinimpl = TextRange.m6309getMinimpl(j5);
        int iM6308getMaximpl = TextRange.m6308getMaximpl(j5);
        if (TextRange.m6313intersects5zctL8(j6, j5)) {
            if (TextRange.m6301contains5zctL8(j6, j5)) {
                iM6309getMinimpl = TextRange.m6309getMinimpl(j6);
                iM6308getMaximpl = iM6309getMinimpl;
            } else {
                if (TextRange.m6301contains5zctL8(j5, j6)) {
                    iM6307getLengthimpl = TextRange.m6307getLengthimpl(j6);
                } else if (TextRange.m6302containsimpl(j6, iM6309getMinimpl)) {
                    iM6309getMinimpl = TextRange.m6309getMinimpl(j6);
                    iM6307getLengthimpl = TextRange.m6307getLengthimpl(j6);
                } else {
                    iM6308getMaximpl = TextRange.m6309getMinimpl(j6);
                }
                iM6308getMaximpl -= iM6307getLengthimpl;
            }
        } else if (iM6308getMaximpl > TextRange.m6309getMinimpl(j6)) {
            iM6309getMinimpl -= TextRange.m6307getLengthimpl(j6);
            iM6307getLengthimpl = TextRange.m6307getLengthimpl(j6);
            iM6308getMaximpl -= iM6307getLengthimpl;
        }
        return TextRangeKt.TextRange(iM6309getMinimpl, iM6308getMaximpl);
    }
}
