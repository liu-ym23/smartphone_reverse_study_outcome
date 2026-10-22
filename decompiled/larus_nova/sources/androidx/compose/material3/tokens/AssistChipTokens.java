package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0015\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0013\u0010\u0014\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0018\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0013\u0010\u001a\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0010R\u0013\u0010\u001e\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001f\u0010\u0007R\u0014\u0010 \u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0013\u0010\"\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b#\u0010\u0007R\u0013\u0010$\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b%\u0010\u0007R\u0013\u0010&\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b'\u0010\u0007R\u0013\u0010(\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b)\u0010\u0007R\u0011\u0010*\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0010R\u0014\u0010,\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u0011\u0010.\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0010R\u0011\u00100\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0010R\u0013\u00102\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b3\u0010\u0007R\u0011\u00104\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0010R\u0011\u00106\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0010R\u0011\u00108\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0010R\u0011\u0010:\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0010R\u0011\u0010<\u001a\u00020=¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010@\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0010R\u0011\u0010B\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0010R\u0014\u0010D\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0007R\u0011\u0010F\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0010R\u0011\u0010H\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0010R\u0011\u0010J\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u0010R\u0011\u0010L\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0010R\u0013\u0010N\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bO\u0010\u0007R\u0011\u0010P\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0010¨\u0006R"}, d2 = {"Landroidx/compose/material3/tokens/AssistChipTokens;", "", "<init>", "()V", "ContainerHeight", "Landroidx/compose/ui/unit/Dp;", "getContainerHeight-D9Ej5fM", "()F", FaceService.girlLabel, "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "DisabledLabelTextColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getDisabledLabelTextColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "DisabledLabelTextOpacity", "", "getDisabledLabelTextOpacity", "DraggedContainerElevation", "getDraggedContainerElevation-D9Ej5fM", "DraggedLabelTextColor", "getDraggedLabelTextColor", "ElevatedContainerColor", "getElevatedContainerColor", "ElevatedContainerElevation", "getElevatedContainerElevation-D9Ej5fM", "ElevatedDisabledContainerColor", "getElevatedDisabledContainerColor", "ElevatedDisabledContainerElevation", "getElevatedDisabledContainerElevation-D9Ej5fM", "ElevatedDisabledContainerOpacity", "getElevatedDisabledContainerOpacity", "ElevatedFocusContainerElevation", "getElevatedFocusContainerElevation-D9Ej5fM", "ElevatedHoverContainerElevation", "getElevatedHoverContainerElevation-D9Ej5fM", "ElevatedPressedContainerElevation", "getElevatedPressedContainerElevation-D9Ej5fM", "FlatContainerElevation", "getFlatContainerElevation-D9Ej5fM", "FlatDisabledOutlineColor", "getFlatDisabledOutlineColor", "FlatDisabledOutlineOpacity", "getFlatDisabledOutlineOpacity", "FlatFocusOutlineColor", "getFlatFocusOutlineColor", "FlatOutlineColor", "getFlatOutlineColor", "FlatOutlineWidth", "getFlatOutlineWidth-D9Ej5fM", "FocusIndicatorColor", "getFocusIndicatorColor", "FocusLabelTextColor", "getFocusLabelTextColor", "HoverLabelTextColor", "getHoverLabelTextColor", "LabelTextColor", "getLabelTextColor", "LabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "PressedLabelTextColor", "getPressedLabelTextColor", "DisabledIconColor", "getDisabledIconColor", "DisabledIconOpacity", "getDisabledIconOpacity", "DraggedIconColor", "getDraggedIconColor", "FocusIconColor", "getFocusIconColor", "HoverIconColor", "getHoverIconColor", "IconColor", "getIconColor", "IconSize", "getIconSize-D9Ej5fM", "PressedIconColor", "getPressedIconColor", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AssistChipTokens {
    public static final int $stable = 0;
    private static final float ContainerHeight = 0.0f;
    private static final ShapeKeyTokens ContainerShape = null;
    private static final ColorSchemeKeyTokens DisabledIconColor = null;
    private static final float DisabledIconOpacity = 0.0f;
    private static final ColorSchemeKeyTokens DisabledLabelTextColor = null;
    private static final float DisabledLabelTextOpacity = 0.0f;
    private static final float DraggedContainerElevation = 0.0f;
    private static final ColorSchemeKeyTokens DraggedIconColor = null;
    private static final ColorSchemeKeyTokens DraggedLabelTextColor = null;
    private static final ColorSchemeKeyTokens ElevatedContainerColor = null;
    private static final float ElevatedContainerElevation = 0.0f;
    private static final ColorSchemeKeyTokens ElevatedDisabledContainerColor = null;
    private static final float ElevatedDisabledContainerElevation = 0.0f;
    private static final float ElevatedDisabledContainerOpacity = 0.0f;
    private static final float ElevatedFocusContainerElevation = 0.0f;
    private static final float ElevatedHoverContainerElevation = 0.0f;
    private static final float ElevatedPressedContainerElevation = 0.0f;
    private static final float FlatContainerElevation = 0.0f;
    private static final ColorSchemeKeyTokens FlatDisabledOutlineColor = null;
    private static final float FlatDisabledOutlineOpacity = 0.0f;
    private static final ColorSchemeKeyTokens FlatFocusOutlineColor = null;
    private static final ColorSchemeKeyTokens FlatOutlineColor = null;
    private static final float FlatOutlineWidth = 0.0f;
    private static final ColorSchemeKeyTokens FocusIconColor = null;
    private static final ColorSchemeKeyTokens FocusIndicatorColor = null;
    private static final ColorSchemeKeyTokens FocusLabelTextColor = null;
    private static final ColorSchemeKeyTokens HoverIconColor = null;
    private static final ColorSchemeKeyTokens HoverLabelTextColor = null;
    public static final AssistChipTokens INSTANCE = null;
    private static final ColorSchemeKeyTokens IconColor = null;
    private static final float IconSize = 0.0f;
    private static final ColorSchemeKeyTokens LabelTextColor = null;
    private static final TypographyKeyTokens LabelTextFont = null;
    private static final ColorSchemeKeyTokens PressedIconColor = null;
    private static final ColorSchemeKeyTokens PressedLabelTextColor = null;

    private AssistChipTokens() {
    }

    static {
        INSTANCE = new AssistChipTokens();
        ContainerHeight = Dp.m7544constructorimpl((float) 32.0d);
        ContainerShape = ShapeKeyTokens.CornerSmall;
        ColorSchemeKeyTokens r100 = ColorSchemeKeyTokens.OnSurface;
        DisabledLabelTextColor = r100;
        DisabledLabelTextOpacity = 0.38f;
        ElevationTokens r101 = ElevationTokens.INSTANCE;
        DraggedContainerElevation = r101.m3502getLevel4D9Ej5fM();
        DraggedLabelTextColor = r100;
        ElevatedContainerColor = ColorSchemeKeyTokens.SurfaceContainerLow;
        ElevatedContainerElevation = r101.m3499getLevel1D9Ej5fM();
        ElevatedDisabledContainerColor = r100;
        ElevatedDisabledContainerElevation = r101.m3498getLevel0D9Ej5fM();
        ElevatedDisabledContainerOpacity = 0.12f;
        ElevatedFocusContainerElevation = r101.m3499getLevel1D9Ej5fM();
        ElevatedHoverContainerElevation = r101.m3500getLevel2D9Ej5fM();
        ElevatedPressedContainerElevation = r101.m3499getLevel1D9Ej5fM();
        FlatContainerElevation = r101.m3498getLevel0D9Ej5fM();
        FlatDisabledOutlineColor = r100;
        FlatDisabledOutlineOpacity = 0.12f;
        FlatFocusOutlineColor = r100;
        FlatOutlineColor = ColorSchemeKeyTokens.OutlineVariant;
        FlatOutlineWidth = Dp.m7544constructorimpl((float) 1.0d);
        FocusIndicatorColor = ColorSchemeKeyTokens.Secondary;
        FocusLabelTextColor = r100;
        HoverLabelTextColor = r100;
        LabelTextColor = r100;
        LabelTextFont = TypographyKeyTokens.LabelLarge;
        PressedLabelTextColor = r100;
        DisabledIconColor = r100;
        DisabledIconOpacity = 0.38f;
        ColorSchemeKeyTokens r102 = ColorSchemeKeyTokens.Primary;
        DraggedIconColor = r102;
        FocusIconColor = r102;
        HoverIconColor = r102;
        IconColor = r102;
        IconSize = Dp.m7544constructorimpl((float) 18.0d);
        PressedIconColor = r102;
    }

    /* JADX INFO: renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3265getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    public final ColorSchemeKeyTokens getDisabledIconColor() {
        return DisabledIconColor;
    }

    public final float getDisabledIconOpacity() {
        return DisabledIconOpacity;
    }

    public final ColorSchemeKeyTokens getDisabledLabelTextColor() {
        return DisabledLabelTextColor;
    }

    public final float getDisabledLabelTextOpacity() {
        return DisabledLabelTextOpacity;
    }

    /* JADX INFO: renamed from: getDraggedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3266getDraggedContainerElevationD9Ej5fM() {
        return DraggedContainerElevation;
    }

    public final ColorSchemeKeyTokens getDraggedIconColor() {
        return DraggedIconColor;
    }

    public final ColorSchemeKeyTokens getDraggedLabelTextColor() {
        return DraggedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getElevatedContainerColor() {
        return ElevatedContainerColor;
    }

    /* JADX INFO: renamed from: getElevatedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3267getElevatedContainerElevationD9Ej5fM() {
        return ElevatedContainerElevation;
    }

    public final ColorSchemeKeyTokens getElevatedDisabledContainerColor() {
        return ElevatedDisabledContainerColor;
    }

    /* JADX INFO: renamed from: getElevatedDisabledContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3268getElevatedDisabledContainerElevationD9Ej5fM() {
        return ElevatedDisabledContainerElevation;
    }

    public final float getElevatedDisabledContainerOpacity() {
        return ElevatedDisabledContainerOpacity;
    }

    /* JADX INFO: renamed from: getElevatedFocusContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3269getElevatedFocusContainerElevationD9Ej5fM() {
        return ElevatedFocusContainerElevation;
    }

    /* JADX INFO: renamed from: getElevatedHoverContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3270getElevatedHoverContainerElevationD9Ej5fM() {
        return ElevatedHoverContainerElevation;
    }

    /* JADX INFO: renamed from: getElevatedPressedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3271getElevatedPressedContainerElevationD9Ej5fM() {
        return ElevatedPressedContainerElevation;
    }

    /* JADX INFO: renamed from: getFlatContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3272getFlatContainerElevationD9Ej5fM() {
        return FlatContainerElevation;
    }

    public final ColorSchemeKeyTokens getFlatDisabledOutlineColor() {
        return FlatDisabledOutlineColor;
    }

    public final float getFlatDisabledOutlineOpacity() {
        return FlatDisabledOutlineOpacity;
    }

    public final ColorSchemeKeyTokens getFlatFocusOutlineColor() {
        return FlatFocusOutlineColor;
    }

    public final ColorSchemeKeyTokens getFlatOutlineColor() {
        return FlatOutlineColor;
    }

    /* JADX INFO: renamed from: getFlatOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m3273getFlatOutlineWidthD9Ej5fM() {
        return FlatOutlineWidth;
    }

    public final ColorSchemeKeyTokens getFocusIconColor() {
        return FocusIconColor;
    }

    public final ColorSchemeKeyTokens getFocusIndicatorColor() {
        return FocusIndicatorColor;
    }

    public final ColorSchemeKeyTokens getFocusLabelTextColor() {
        return FocusLabelTextColor;
    }

    public final ColorSchemeKeyTokens getHoverIconColor() {
        return HoverIconColor;
    }

    public final ColorSchemeKeyTokens getHoverLabelTextColor() {
        return HoverLabelTextColor;
    }

    public final ColorSchemeKeyTokens getIconColor() {
        return IconColor;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3274getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final ColorSchemeKeyTokens getLabelTextColor() {
        return LabelTextColor;
    }

    public final TypographyKeyTokens getLabelTextFont() {
        return LabelTextFont;
    }

    public final ColorSchemeKeyTokens getPressedIconColor() {
        return PressedIconColor;
    }

    public final ColorSchemeKeyTokens getPressedLabelTextColor() {
        return PressedLabelTextColor;
    }
}
