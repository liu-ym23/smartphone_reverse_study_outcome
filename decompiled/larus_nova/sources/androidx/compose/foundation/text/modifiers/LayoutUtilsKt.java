package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\n\u001a/\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u0018\u0010\u0013\u001a\u00020\u0004*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"finalConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxIntrinsicWidth", "", "finalConstraints-tfFHcEY", "(JZIF)J", "finalMaxWidth", "", "finalMaxWidth-tfFHcEY", "(JZIF)I", "finalMaxLines", "maxLinesIn", "finalMaxLines-xdlQI24", "(ZII)I", "isEllipsis", "isEllipsis-MW5-ApA", "(I)Z", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LayoutUtilsKt {
    /* JADX INFO: renamed from: isEllipsis-MW5-ApA, reason: not valid java name */
    public static final boolean m1406isEllipsisMW5ApA(int r100) {
        TextOverflow.Companion r101 = TextOverflow.Companion;
        if (TextOverflow.m7460equalsimpl0(r100, r101.m7470getEllipsisgIe3tQ8()) == false) goto L5;
    L10:
        return true;
    L5:
        if (TextOverflow.m7460equalsimpl0(r100, r101.m7472getStartEllipsisgIe3tQ8()) == true) goto L10;
        if (TextOverflow.m7460equalsimpl0(r100, r101.m7471getMiddleEllipsisgIe3tQ8()) == true) goto L10;
        return false;
    }

    /* JADX INFO: renamed from: finalMaxLines-xdlQI24, reason: not valid java name */
    public static final int m1404finalMaxLinesxdlQI24(boolean r100, int r101, int r102) {
        if (r100 == false) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L11;
        return 1;
    L11:
        return RangesKt.coerceAtLeast(r102, 1);
    L5:
        if (m1406isEllipsisMW5ApA(r101) == false) goto L7;
        r103 = true;
        goto L8
    }

    /* JADX INFO: renamed from: finalConstraints-tfFHcEY, reason: not valid java name */
    public static final long m1403finalConstraintstfFHcEY(long r100, boolean r101, int r102, float r103) {
        return Constraints.Companion.m7496fitPrioritizingWidthZbe2FdA(0, m1405finalMaxWidthtfFHcEY(r100, r101, r102, r103), 0, Constraints.m7486getMaxHeightimpl(r100));
    }

    /* JADX INFO: renamed from: finalMaxWidth-tfFHcEY, reason: not valid java name */
    public static final int m1405finalMaxWidthtfFHcEY(long r100, boolean r101, int r102, float r103) {
        if (r101 == false) goto L4;
    L7:
        boolean r104 = true;
    L8:
        if (r104 == true) goto L10;
    L12:
        int r105 = Integer.MAX_VALUE;
    L14:
        if (Constraints.m7489getMinWidthimpl(r100) != r105) goto L17;
        return r105;
    L17:
        return RangesKt.coerceIn(TextDelegateKt.ceilToIntPx(r103), Constraints.m7489getMinWidthimpl(r100), r105);
    L10:
        if (Constraints.m7483getHasBoundedWidthimpl(r100) == false) goto L12;
        r105 = Constraints.m7487getMaxWidthimpl(r100);
        goto L14
    L4:
        if (m1406isEllipsisMW5ApA(r102) == true) goto L7;
        r104 = false;
        goto L8
    }
}
