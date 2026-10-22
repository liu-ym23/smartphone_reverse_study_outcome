package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/graphics/ColorSpaceVerificationHelperV34;", "", "<init>", "()V", "obtainAndroidColorSpace", "Landroid/graphics/ColorSpace;", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "obtainComposeColorSpaceFromId", "id", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ColorSpaceVerificationHelperV34 {
    public static final ColorSpaceVerificationHelperV34 INSTANCE = null;

    static {
        INSTANCE = new ColorSpaceVerificationHelperV34();
    }

    private ColorSpaceVerificationHelperV34() {
    }

    @JvmStatic
    public static final ColorSpace obtainAndroidColorSpace(androidx.compose.ui.graphics.colorspace.ColorSpace r100) {
        ColorSpaces r101 = ColorSpaces.INSTANCE;
        if (Intrinsics.areEqual(r100, r101.getBt2020Hlg()) == false) goto L6;
        return ColorSpace.get(ColorSpace.Named.BT2020_HLG);
    L6:
        if (Intrinsics.areEqual(r100, r101.getBt2020Pq()) == true) goto L11;
        return null;
    L11:
        return ColorSpace.get(ColorSpace.Named.BT2020_PQ);
    }

    @JvmStatic
    public static final androidx.compose.ui.graphics.colorspace.ColorSpace obtainComposeColorSpaceFromId(int r100) {
        if (r100 != ColorSpace.Named.BT2020_HLG.ordinal()) goto L6;
        return ColorSpaces.INSTANCE.getBt2020Hlg();
    L6:
        if (r100 != ColorSpace.Named.BT2020_PQ.ordinal()) goto L9;
        return ColorSpaces.INSTANCE.getBt2020Pq();
    L9:
        return ColorSpaces.INSTANCE.getUnspecified$ui_graphics_release();
    }
}
