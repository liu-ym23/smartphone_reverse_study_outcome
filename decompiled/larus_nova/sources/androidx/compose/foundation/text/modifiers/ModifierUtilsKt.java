package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"maxWidthForTextLayout", "", "Landroidx/compose/ui/unit/Constraints;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxWidthForTextLayout-R2G3SPE", "(JZI)I", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ModifierUtilsKt {
    /* JADX INFO: renamed from: maxWidthForTextLayout-R2G3SPE, reason: not valid java name */
    public static final int m1408maxWidthForTextLayoutR2G3SPE(long r100, boolean r101, int r102) {
        if (r101 == false) goto L4;
    L7:
        boolean r103 = true;
    L8:
        if (r103 == true) goto L10;
    L12:
        return Integer.MAX_VALUE;
    L10:
        if (Constraints.m7483getHasBoundedWidthimpl(r100) == false) goto L12;
        return Constraints.m7487getMaxWidthimpl(r100);
    L4:
        if (TextOverflow.m7460equalsimpl0(r102, TextOverflow.Companion.m7470getEllipsisgIe3tQ8()) == true) goto L7;
        r103 = false;
        goto L8
    }
}
