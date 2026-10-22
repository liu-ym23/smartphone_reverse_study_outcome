package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.text.TextPointerIcon_androidKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.node.DpTouchBoundsExpansion;
import androidx.compose.ui.node.TouchBoundsExpansionKt;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0000\"\u0016\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b\"\u0016\u0010\r\u001a\u00020\tX\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000b\"\u0014\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"stylusHandwriting", "Landroidx/compose/ui/Modifier;", "enabled", "", "showHoverIcon", "onHandwritingSlopExceeded", "Lkotlin/Function0;", "", "HandwritingBoundsVerticalOffset", "Landroidx/compose/ui/unit/Dp;", "getHandwritingBoundsVerticalOffset", "()F", FaceService.girlLabel, "HandwritingBoundsHorizontalOffset", "getHandwritingBoundsHorizontalOffset", "HandwritingBoundsExpansion", "Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "getHandwritingBoundsExpansion", "()Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class StylusHandwritingKt {
    private static final DpTouchBoundsExpansion HandwritingBoundsExpansion = null;
    private static final float HandwritingBoundsHorizontalOffset = 0.0f;
    private static final float HandwritingBoundsVerticalOffset = 0.0f;

    static {
        float r100 = Dp.m7544constructorimpl(40);
        HandwritingBoundsVerticalOffset = r100;
        float r101 = Dp.m7544constructorimpl(10);
        HandwritingBoundsHorizontalOffset = r101;
        HandwritingBoundsExpansion = TouchBoundsExpansionKt.m6656DpTouchBoundsExpansiona9UjIt4(r101, r100, r101, r100);
    }

    public static final DpTouchBoundsExpansion getHandwritingBoundsExpansion() {
        return HandwritingBoundsExpansion;
    }

    public static final float getHandwritingBoundsHorizontalOffset() {
        return HandwritingBoundsHorizontalOffset;
    }

    public static final float getHandwritingBoundsVerticalOffset() {
        return HandwritingBoundsVerticalOffset;
    }

    public static final Modifier stylusHandwriting(Modifier r100, boolean r101, boolean r102, Function0<Unit> r103) {
        if (r101 == true) goto L4;
        return r100;
    L4:
        if (StylusHandwriting_androidKt.isStylusHandwritingSupported() == false) goto L10;
        if (r102 == false) goto L8;
        r100 = PointerIconKt.stylusHoverIcon(r100, TextPointerIcon_androidKt.getHandwritingPointerIcon(), false, HandwritingBoundsExpansion);
    L8:
        return r100.then(new StylusHandwritingElement(r103));
    L10:
        return r100;
    }
}
