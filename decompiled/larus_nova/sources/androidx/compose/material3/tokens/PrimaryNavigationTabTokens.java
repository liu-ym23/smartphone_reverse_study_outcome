package androidx.compose.material3.tokens;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0014\u0010\u000bR\u0013\u0010\u0015\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0016\u0010\u000bR\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0007R\u0011\u0010\u001d\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0007R\u0011\u0010\u001f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0007R\u0011\u0010!\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0007R\u0013\u0010#\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b$\u0010\u000bR\u0013\u0010%\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b&\u0010\u000bR\u0011\u0010'\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0007R\u0011\u0010)\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0007R\u0011\u0010+\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0007R\u0011\u0010-\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0007R\u0011\u0010/\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0007R\u0011\u00101\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0007R\u0011\u00103\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0007R\u0011\u00105\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0007R\u0011\u00107\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0007R\u0011\u00109\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0007R\u0011\u0010;\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0007R\u0011\u0010=\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0007R\u0011\u0010?\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bA\u0010B¨\u0006C"}, d2 = {"Landroidx/compose/material3/tokens/PrimaryNavigationTabTokens;", "", "<init>", "()V", "ActiveIndicatorColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getActiveIndicatorColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActiveIndicatorHeight", "Landroidx/compose/ui/unit/Dp;", "getActiveIndicatorHeight-D9Ej5fM", "()F", FaceService.girlLabel, "ActiveIndicatorShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "getActiveIndicatorShape", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "ContainerColor", "getContainerColor", "ContainerElevation", "getContainerElevation-D9Ej5fM", "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ActiveFocusIconColor", "getActiveFocusIconColor", "ActiveHoverIconColor", "getActiveHoverIconColor", "ActiveIconColor", "getActiveIconColor", "ActivePressedIconColor", "getActivePressedIconColor", "IconAndLabelTextContainerHeight", "getIconAndLabelTextContainerHeight-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "InactiveFocusIconColor", "getInactiveFocusIconColor", "InactiveHoverIconColor", "getInactiveHoverIconColor", "InactiveIconColor", "getInactiveIconColor", "InactivePressedIconColor", "getInactivePressedIconColor", "ActiveFocusLabelTextColor", "getActiveFocusLabelTextColor", "ActiveHoverLabelTextColor", "getActiveHoverLabelTextColor", "ActiveLabelTextColor", "getActiveLabelTextColor", "ActivePressedLabelTextColor", "getActivePressedLabelTextColor", "InactiveFocusLabelTextColor", "getInactiveFocusLabelTextColor", "InactiveHoverLabelTextColor", "getInactiveHoverLabelTextColor", "InactiveLabelTextColor", "getInactiveLabelTextColor", "InactivePressedLabelTextColor", "getInactivePressedLabelTextColor", "LabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PrimaryNavigationTabTokens {
    public static final int $stable = 0;
    private static final ColorSchemeKeyTokens ActiveFocusIconColor = null;
    private static final ColorSchemeKeyTokens ActiveFocusLabelTextColor = null;
    private static final ColorSchemeKeyTokens ActiveHoverIconColor = null;
    private static final ColorSchemeKeyTokens ActiveHoverLabelTextColor = null;
    private static final ColorSchemeKeyTokens ActiveIconColor = null;
    private static final ColorSchemeKeyTokens ActiveIndicatorColor = null;
    private static final float ActiveIndicatorHeight = 0.0f;
    private static final RoundedCornerShape ActiveIndicatorShape = null;
    private static final ColorSchemeKeyTokens ActiveLabelTextColor = null;
    private static final ColorSchemeKeyTokens ActivePressedIconColor = null;
    private static final ColorSchemeKeyTokens ActivePressedLabelTextColor = null;
    private static final ColorSchemeKeyTokens ContainerColor = null;
    private static final float ContainerElevation = 0.0f;
    private static final float ContainerHeight = 0.0f;
    private static final ShapeKeyTokens ContainerShape = null;
    public static final PrimaryNavigationTabTokens INSTANCE = null;
    private static final float IconAndLabelTextContainerHeight = 0.0f;
    private static final float IconSize = 0.0f;
    private static final ColorSchemeKeyTokens InactiveFocusIconColor = null;
    private static final ColorSchemeKeyTokens InactiveFocusLabelTextColor = null;
    private static final ColorSchemeKeyTokens InactiveHoverIconColor = null;
    private static final ColorSchemeKeyTokens InactiveHoverLabelTextColor = null;
    private static final ColorSchemeKeyTokens InactiveIconColor = null;
    private static final ColorSchemeKeyTokens InactiveLabelTextColor = null;
    private static final ColorSchemeKeyTokens InactivePressedIconColor = null;
    private static final ColorSchemeKeyTokens InactivePressedLabelTextColor = null;
    private static final TypographyKeyTokens LabelTextFont = null;

    private PrimaryNavigationTabTokens() {
    }

    static {
        INSTANCE = new PrimaryNavigationTabTokens();
        ColorSchemeKeyTokens r100 = ColorSchemeKeyTokens.Primary;
        ActiveIndicatorColor = r100;
        float r101 = (float) 3.0d;
        ActiveIndicatorHeight = Dp.m7544constructorimpl(r101);
        ActiveIndicatorShape = RoundedCornerShapeKt.m1026RoundedCornerShape0680j_4(Dp.m7544constructorimpl(r101));
        ContainerColor = ColorSchemeKeyTokens.Surface;
        ContainerElevation = ElevationTokens.INSTANCE.m3498getLevel0D9Ej5fM();
        ContainerHeight = Dp.m7544constructorimpl((float) 48.0d);
        ContainerShape = ShapeKeyTokens.CornerNone;
        ActiveFocusIconColor = r100;
        ActiveHoverIconColor = r100;
        ActiveIconColor = r100;
        ActivePressedIconColor = r100;
        IconAndLabelTextContainerHeight = Dp.m7544constructorimpl((float) 64.0d);
        IconSize = Dp.m7544constructorimpl((float) 24.0d);
        ColorSchemeKeyTokens r102 = ColorSchemeKeyTokens.OnSurface;
        InactiveFocusIconColor = r102;
        InactiveHoverIconColor = r102;
        ColorSchemeKeyTokens r103 = ColorSchemeKeyTokens.OnSurfaceVariant;
        InactiveIconColor = r103;
        InactivePressedIconColor = r102;
        ActiveFocusLabelTextColor = r100;
        ActiveHoverLabelTextColor = r100;
        ActiveLabelTextColor = r100;
        ActivePressedLabelTextColor = r100;
        InactiveFocusLabelTextColor = r102;
        InactiveHoverLabelTextColor = r102;
        InactiveLabelTextColor = r103;
        InactivePressedLabelTextColor = r102;
        LabelTextFont = TypographyKeyTokens.TitleSmall;
    }

    public final ColorSchemeKeyTokens getActiveFocusIconColor() {
        return ActiveFocusIconColor;
    }

    public final ColorSchemeKeyTokens getActiveFocusLabelTextColor() {
        return ActiveFocusLabelTextColor;
    }

    public final ColorSchemeKeyTokens getActiveHoverIconColor() {
        return ActiveHoverIconColor;
    }

    public final ColorSchemeKeyTokens getActiveHoverLabelTextColor() {
        return ActiveHoverLabelTextColor;
    }

    public final ColorSchemeKeyTokens getActiveIconColor() {
        return ActiveIconColor;
    }

    public final ColorSchemeKeyTokens getActiveIndicatorColor() {
        return ActiveIndicatorColor;
    }

    /* JADX INFO: renamed from: getActiveIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m3834getActiveIndicatorHeightD9Ej5fM() {
        return ActiveIndicatorHeight;
    }

    public final RoundedCornerShape getActiveIndicatorShape() {
        return ActiveIndicatorShape;
    }

    public final ColorSchemeKeyTokens getActiveLabelTextColor() {
        return ActiveLabelTextColor;
    }

    public final ColorSchemeKeyTokens getActivePressedIconColor() {
        return ActivePressedIconColor;
    }

    public final ColorSchemeKeyTokens getActivePressedLabelTextColor() {
        return ActivePressedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    /* JADX INFO: renamed from: getContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3835getContainerElevationD9Ej5fM() {
        return ContainerElevation;
    }

    /* JADX INFO: renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3836getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    /* JADX INFO: renamed from: getIconAndLabelTextContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3837getIconAndLabelTextContainerHeightD9Ej5fM() {
        return IconAndLabelTextContainerHeight;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3838getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final ColorSchemeKeyTokens getInactiveFocusIconColor() {
        return InactiveFocusIconColor;
    }

    public final ColorSchemeKeyTokens getInactiveFocusLabelTextColor() {
        return InactiveFocusLabelTextColor;
    }

    public final ColorSchemeKeyTokens getInactiveHoverIconColor() {
        return InactiveHoverIconColor;
    }

    public final ColorSchemeKeyTokens getInactiveHoverLabelTextColor() {
        return InactiveHoverLabelTextColor;
    }

    public final ColorSchemeKeyTokens getInactiveIconColor() {
        return InactiveIconColor;
    }

    public final ColorSchemeKeyTokens getInactiveLabelTextColor() {
        return InactiveLabelTextColor;
    }

    public final ColorSchemeKeyTokens getInactivePressedIconColor() {
        return InactivePressedIconColor;
    }

    public final ColorSchemeKeyTokens getInactivePressedLabelTextColor() {
        return InactivePressedLabelTextColor;
    }

    public final TypographyKeyTokens getLabelTextFont() {
        return LabelTextFont;
    }
}
