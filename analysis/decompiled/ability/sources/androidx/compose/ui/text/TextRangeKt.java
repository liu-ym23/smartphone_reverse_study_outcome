package androidx.compose.ui.text;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0000\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000b\u001a\u0013\u0010\u0007\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\r\u001a!\u0010\u000e\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¨\u0006\u0015"}, d2 = {"substring", "", "", "range", "Landroidx/compose/ui/text/TextRange;", "substring-FDrldGo", "(Ljava/lang/CharSequence;J)Ljava/lang/String;", "TextRange", "start", "", "end", "(II)J", "index", "(I)J", "coerceIn", "minimumValue", "maximumValue", "coerceIn-8ffj60Q", "(JII)J", "packWithCheck", "", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextRangeKt {
    public static final long TextRange(int i, int i6) {
        return TextRange.m6300constructorimpl(packWithCheck(i, i6));
    }

    /* renamed from: coerceIn-8ffj60Q, reason: not valid java name */
    public static final long m6317coerceIn8ffj60Q(long j5, int i, int i6) {
        int iM6311getStartimpl = TextRange.m6311getStartimpl(j5);
        if (iM6311getStartimpl < i) {
            iM6311getStartimpl = i;
        }
        if (iM6311getStartimpl > i6) {
            iM6311getStartimpl = i6;
        }
        int iM6306getEndimpl = TextRange.m6306getEndimpl(j5);
        if (iM6306getEndimpl >= i) {
            i = iM6306getEndimpl;
        }
        if (i <= i6) {
            i6 = i;
        }
        return (iM6311getStartimpl == TextRange.m6311getStartimpl(j5) && i6 == TextRange.m6306getEndimpl(j5)) ? j5 : TextRange(iM6311getStartimpl, i6);
    }

    private static final long packWithCheck(int i, int i6) {
        if (!(i >= 0 && i6 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("start and end cannot be negative. [start: " + i + ", end: " + i6 + ']');
        }
        return (i6 & 4294967295L) | (i << 32);
    }

    /* renamed from: substring-FDrldGo, reason: not valid java name */
    public static final String m6318substringFDrldGo(CharSequence charSequence, long j5) {
        return charSequence.subSequence(TextRange.m6309getMinimpl(j5), TextRange.m6308getMaximpl(j5)).toString();
    }

    public static final long TextRange(int i) {
        return TextRange(i, i);
    }
}
