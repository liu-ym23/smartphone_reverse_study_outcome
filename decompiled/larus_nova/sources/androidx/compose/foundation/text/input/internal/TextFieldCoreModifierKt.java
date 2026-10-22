package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a$\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u000fH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0010"}, d2 = {"DefaultCursorThickness", "Landroidx/compose/ui/unit/Dp;", FaceService.girlLabel, "isSpecified", "", "Landroidx/compose/ui/graphics/Brush;", "(Landroidx/compose/ui/graphics/Brush;)Z", "getCursorRectInScroller", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/Density;", "cursorRect", "rtl", "textLayoutSize", "", "roundToNext", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldCoreModifierKt {
    private static final float DefaultCursorThickness = 0.0f;

    static {
        DefaultCursorThickness = Dp.m7544constructorimpl(2);
    }

    public static final /* synthetic */ boolean access$isSpecified(Brush r100) {
        return isSpecified(r100);
    }

    public static final /* synthetic */ float access$roundToNext(float r100) {
        return roundToNext(r100);
    }

    private static final boolean isSpecified(Brush r100) {
        if ((r100 instanceof SolidColor) == true) goto L5;
        return true;
    L5:
        if (((SolidColor) r100).m5188getValue0d7_KjU() != 16) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L13;
        return false;
    L13:
        return true;
    L7:
        r101 = false;
        goto L8
    }

    private static final float roundToNext(float r100) {
        if (Float.isNaN(r100) == false) goto L5;
        return r100;
    L5:
        if (Float.isInfinite(r100) == false) goto L8;
        return r100;
    L8:
        if (r100 <= 0.0f) goto L10;
        double r101 = Math.ceil(r100);
    L12:
        return (float) r101;
    L10:
        r101 = Math.floor(r100);
        goto L12
    }

    public static final /* synthetic */ Rect access$getCursorRectInScroller(Density r100, Rect r101, boolean r102, int r103) {
        return getCursorRectInScroller(r100, r101, r102, r103);
    }

    private static final Rect getCursorRectInScroller(Density r100, Rect r101, boolean r110, int r111) {
        int r102 = r100.mo365roundToPx0680j_4(DefaultCursorThickness);
        if (r110 == false) goto L5;
        float r103 = r111 - r101.getRight();
    L6:
        float r104 = r103;
        if (r110 == false) goto L9;
        float r112 = r111 - r101.getRight();
    L11:
        return Rect.copy$default(r101, r104, 0.0f, r112 + r102, 0.0f, 10, null);
    L9:
        r112 = r101.getLeft();
        goto L11
    L5:
        r103 = r101.getLeft();
        goto L6
    }
}
