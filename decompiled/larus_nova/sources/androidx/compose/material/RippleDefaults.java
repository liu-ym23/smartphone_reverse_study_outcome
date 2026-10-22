package androidx.compose.material;

import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/material/RippleDefaults;", "", "<init>", "()V", "rippleColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "lightTheme", "", "rippleColor-5vOe2sY", "(JZ)J", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rippleAlpha-DxMtmZc", "(JZ)Landroidx/compose/material/ripple/RippleAlpha;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RippleDefaults {
    public static final int $stable = 0;
    public static final RippleDefaults INSTANCE = null;

    static {
        INSTANCE = new RippleDefaults();
    }

    private RippleDefaults() {
    }

    /* JADX INFO: renamed from: rippleAlpha-DxMtmZc, reason: not valid java name */
    public final RippleAlpha m1711rippleAlphaDxMtmZc(long r100, boolean r101) {
        if (r101 == false) goto L8;
        if (ColorKt.m4879luminance8_81llA(r100) <= 0.5d) goto L10;
        return RippleKt.access$getLightThemeHighContrastRippleAlpha$p();
    L10:
        return RippleKt.access$getLightThemeLowContrastRippleAlpha$p();
    L8:
        return RippleKt.access$getDarkThemeRippleAlpha$p();
    }

    /* JADX INFO: renamed from: rippleColor-5vOe2sY, reason: not valid java name */
    public final long m1712rippleColor5vOe2sY(long r100, boolean r101) {
        float r102 = ColorKt.m4879luminance8_81llA(r100);
        if (r101 == false) goto L5;
        return r100;
    L5:
        if (r102 < 0.5d) goto L7;
        return r100;
    L7:
        return Color.Companion.m4864getWhite0d7_KjU();
    }
}
