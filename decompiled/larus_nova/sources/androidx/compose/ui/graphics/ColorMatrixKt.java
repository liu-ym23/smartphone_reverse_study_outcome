package androidx.compose.ui.graphics;

import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0082\b¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"dot", "", Keys.API_PARAM_KEY_M1, "Landroidx/compose/ui/graphics/ColorMatrix;", SlcFlexDirection.FLEX_ROW, "", Keys.API_PARAM_KEY_M2, "column", "dot-Me4OoYI", "([FI[FI)F", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ColorMatrixKt {
    /* JADX INFO: renamed from: dot-Me4OoYI, reason: not valid java name */
    private static final float m4907dotMe4OoYI(float[] r100, int r101, float[] r102, int r103) {
        int r104 = r101 * 5;
        return (((r100[r104 + 0] * r102[0 + r103]) + (r100[r104 + 1] * r102[5 + r103])) + (r100[r104 + 2] * r102[10 + r103])) + (r100[r104 + 3] * r102[15 + r103]);
    }
}
