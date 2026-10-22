package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import g1.AbstractC1451a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a2\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"finalConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxIntrinsicWidth", "", "finalConstraints-tfFHcEY", "(JZIF)J", "finalMaxLines", "", "maxLinesIn", "finalMaxLines-xdlQI24", "(ZII)I", "finalMaxWidth", "finalMaxWidth-tfFHcEY", "(JZIF)I", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutUtilsKt {
    /* renamed from: finalConstraints-tfFHcEY, reason: not valid java name */
    public static final long m1348finalConstraintstfFHcEY(long j5, boolean z10, int i, float f) {
        return Constraints.INSTANCE.m6806fitPrioritizingWidthZbe2FdA(0, m1350finalMaxWidthtfFHcEY(j5, z10, i, f), 0, Constraints.m6796getMaxHeightimpl(j5));
    }

    /* renamed from: finalMaxLines-xdlQI24, reason: not valid java name */
    public static final int m1349finalMaxLinesxdlQI24(boolean z10, int i, int i6) {
        if ((z10 || !TextOverflow.m6770equalsimpl0(i, TextOverflow.INSTANCE.m6780getEllipsisgIe3tQ8())) && i6 >= 1) {
            return i6;
        }
        return 1;
    }

    /* renamed from: finalMaxWidth-tfFHcEY, reason: not valid java name */
    public static final int m1350finalMaxWidthtfFHcEY(long j5, boolean z10, int i, float f) {
        int iM6797getMaxWidthimpl = ((z10 || TextOverflow.m6770equalsimpl0(i, TextOverflow.INSTANCE.m6780getEllipsisgIe3tQ8())) && Constraints.m6793getHasBoundedWidthimpl(j5)) ? Constraints.m6797getMaxWidthimpl(j5) : Integer.MAX_VALUE;
        return Constraints.m6799getMinWidthimpl(j5) == iM6797getMaxWidthimpl ? iM6797getMaxWidthimpl : AbstractC1451a.u(TextDelegateKt.ceilToIntPx(f), Constraints.m6799getMinWidthimpl(j5), iM6797getMaxWidthimpl);
    }
}
