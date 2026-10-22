package androidx.compose.foundation.text.handwriting;

import S7.a;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a)\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\"\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u001a\u0010\f\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/Modifier;", "", "enabled", "Lkotlin/Function0;", "onHandwritingSlopExceeded", "stylusHandwriting", "(Landroidx/compose/ui/Modifier;ZLS7/a;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/Dp;", "HandwritingBoundsVerticalOffset", "F", "getHandwritingBoundsVerticalOffset", "()F", "HandwritingBoundsHorizontalOffset", "getHandwritingBoundsHorizontalOffset", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StylusHandwritingKt {
    private static final float HandwritingBoundsVerticalOffset = Dp.m6844constructorimpl(40);
    private static final float HandwritingBoundsHorizontalOffset = Dp.m6844constructorimpl(10);

    public static final float getHandwritingBoundsHorizontalOffset() {
        return HandwritingBoundsHorizontalOffset;
    }

    public static final float getHandwritingBoundsVerticalOffset() {
        return HandwritingBoundsVerticalOffset;
    }

    public static final Modifier stylusHandwriting(Modifier modifier, boolean z10, a aVar) {
        return (z10 && StylusHandwriting_androidKt.isStylusHandwritingSupported()) ? PaddingKt.m701paddingVpY3zN4(modifier.then(new StylusHandwritingElementWithNegativePadding(aVar)), HandwritingBoundsHorizontalOffset, HandwritingBoundsVerticalOffset) : modifier;
    }
}
