package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b?\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001a\u0010\u000bR\u0011\u0010\u001b\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u0013\u0010\u001d\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001e\u0010\u000bR\u0011\u0010\u001f\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0011\u0010!\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0007R\u0013\u0010#\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b$\u0010\u000bR\u0011\u0010%\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0007R\u0011\u0010'\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0007R\u0011\u0010)\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0007R\u0011\u0010+\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0007R\u0011\u0010-\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0007R\u0011\u0010/\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0007R\u0011\u00101\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0007R\u0011\u00103\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0007R\u0011\u00105\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0007R\u0011\u00107\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0007R\u0013\u00109\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b:\u0010\u000bR\u0011\u0010;\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0010R\u0013\u0010=\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b>\u0010\u000bR\u0011\u0010?\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0007R\u0011\u0010A\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0007R\u0011\u0010C\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0007R\u0013\u0010E\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\bF\u0010\u000bR\u0011\u0010G\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0007R\u0011\u0010I\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u0007R\u0011\u0010K\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u0018R\u0011\u0010M\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\u0007R\u0011\u0010O\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u0018R\u0011\u0010Q\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u0007R\u0011\u0010S\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\u0018¨\u0006U"}, d2 = {"Landroidx/compose/material3/tokens/TimeInputTokens;", "", "<init>", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", FaceService.girlLabel, "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "FocusIndicatorColor", "getFocusIndicatorColor", "HeadlineColor", "getHeadlineColor", "HeadlineFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getHeadlineFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "PeriodSelectorContainerHeight", "getPeriodSelectorContainerHeight-D9Ej5fM", "PeriodSelectorContainerShape", "getPeriodSelectorContainerShape", "PeriodSelectorContainerWidth", "getPeriodSelectorContainerWidth-D9Ej5fM", "PeriodSelectorLabelTextFont", "getPeriodSelectorLabelTextFont", "PeriodSelectorOutlineColor", "getPeriodSelectorOutlineColor", "PeriodSelectorOutlineWidth", "getPeriodSelectorOutlineWidth-D9Ej5fM", "PeriodSelectorSelectedContainerColor", "getPeriodSelectorSelectedContainerColor", "PeriodSelectorSelectedFocusLabelTextColor", "getPeriodSelectorSelectedFocusLabelTextColor", "PeriodSelectorSelectedHoverLabelTextColor", "getPeriodSelectorSelectedHoverLabelTextColor", "PeriodSelectorSelectedLabelTextColor", "getPeriodSelectorSelectedLabelTextColor", "PeriodSelectorSelectedPressedLabelTextColor", "getPeriodSelectorSelectedPressedLabelTextColor", "PeriodSelectorUnselectedFocusLabelTextColor", "getPeriodSelectorUnselectedFocusLabelTextColor", "PeriodSelectorUnselectedHoverLabelTextColor", "getPeriodSelectorUnselectedHoverLabelTextColor", "PeriodSelectorUnselectedLabelTextColor", "getPeriodSelectorUnselectedLabelTextColor", "PeriodSelectorUnselectedPressedLabelTextColor", "getPeriodSelectorUnselectedPressedLabelTextColor", "TimeFieldContainerColor", "getTimeFieldContainerColor", "TimeFieldContainerHeight", "getTimeFieldContainerHeight-D9Ej5fM", "TimeFieldContainerShape", "getTimeFieldContainerShape", "TimeFieldContainerWidth", "getTimeFieldContainerWidth-D9Ej5fM", "TimeFieldFocusContainerColor", "getTimeFieldFocusContainerColor", "TimeFieldFocusLabelTextColor", "getTimeFieldFocusLabelTextColor", "TimeFieldFocusOutlineColor", "getTimeFieldFocusOutlineColor", "TimeFieldFocusOutlineWidth", "getTimeFieldFocusOutlineWidth-D9Ej5fM", "TimeFieldHoverLabelTextColor", "getTimeFieldHoverLabelTextColor", "TimeFieldLabelTextColor", "getTimeFieldLabelTextColor", "TimeFieldLabelTextFont", "getTimeFieldLabelTextFont", "TimeFieldSeparatorColor", "getTimeFieldSeparatorColor", "TimeFieldSeparatorFont", "getTimeFieldSeparatorFont", "TimeFieldSupportingTextColor", "getTimeFieldSupportingTextColor", "TimeFieldSupportingTextFont", "getTimeFieldSupportingTextFont", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TimeInputTokens {
    public static final int $stable = 0;
    private static final ColorSchemeKeyTokens ContainerColor = null;
    private static final float ContainerElevation = 0.0f;
    private static final ShapeKeyTokens ContainerShape = null;
    private static final ColorSchemeKeyTokens FocusIndicatorColor = null;
    private static final ColorSchemeKeyTokens HeadlineColor = null;
    private static final TypographyKeyTokens HeadlineFont = null;
    public static final TimeInputTokens INSTANCE = null;
    private static final float PeriodSelectorContainerHeight = 0.0f;
    private static final ShapeKeyTokens PeriodSelectorContainerShape = null;
    private static final float PeriodSelectorContainerWidth = 0.0f;
    private static final TypographyKeyTokens PeriodSelectorLabelTextFont = null;
    private static final ColorSchemeKeyTokens PeriodSelectorOutlineColor = null;
    private static final float PeriodSelectorOutlineWidth = 0.0f;
    private static final ColorSchemeKeyTokens PeriodSelectorSelectedContainerColor = null;
    private static final ColorSchemeKeyTokens PeriodSelectorSelectedFocusLabelTextColor = null;
    private static final ColorSchemeKeyTokens PeriodSelectorSelectedHoverLabelTextColor = null;
    private static final ColorSchemeKeyTokens PeriodSelectorSelectedLabelTextColor = null;
    private static final ColorSchemeKeyTokens PeriodSelectorSelectedPressedLabelTextColor = null;
    private static final ColorSchemeKeyTokens PeriodSelectorUnselectedFocusLabelTextColor = null;
    private static final ColorSchemeKeyTokens PeriodSelectorUnselectedHoverLabelTextColor = null;
    private static final ColorSchemeKeyTokens PeriodSelectorUnselectedLabelTextColor = null;
    private static final ColorSchemeKeyTokens PeriodSelectorUnselectedPressedLabelTextColor = null;
    private static final ColorSchemeKeyTokens TimeFieldContainerColor = null;
    private static final float TimeFieldContainerHeight = 0.0f;
    private static final ShapeKeyTokens TimeFieldContainerShape = null;
    private static final float TimeFieldContainerWidth = 0.0f;
    private static final ColorSchemeKeyTokens TimeFieldFocusContainerColor = null;
    private static final ColorSchemeKeyTokens TimeFieldFocusLabelTextColor = null;
    private static final ColorSchemeKeyTokens TimeFieldFocusOutlineColor = null;
    private static final float TimeFieldFocusOutlineWidth = 0.0f;
    private static final ColorSchemeKeyTokens TimeFieldHoverLabelTextColor = null;
    private static final ColorSchemeKeyTokens TimeFieldLabelTextColor = null;
    private static final TypographyKeyTokens TimeFieldLabelTextFont = null;
    private static final ColorSchemeKeyTokens TimeFieldSeparatorColor = null;
    private static final TypographyKeyTokens TimeFieldSeparatorFont = null;
    private static final ColorSchemeKeyTokens TimeFieldSupportingTextColor = null;
    private static final TypographyKeyTokens TimeFieldSupportingTextFont = null;

    private TimeInputTokens() {
    }

    static {
        INSTANCE = new TimeInputTokens();
        ContainerColor = ColorSchemeKeyTokens.SurfaceContainerHigh;
        ContainerElevation = ElevationTokens.INSTANCE.m3501getLevel3D9Ej5fM();
        ContainerShape = ShapeKeyTokens.CornerExtraLarge;
        FocusIndicatorColor = ColorSchemeKeyTokens.Secondary;
        ColorSchemeKeyTokens r100 = ColorSchemeKeyTokens.OnSurfaceVariant;
        HeadlineColor = r100;
        HeadlineFont = TypographyKeyTokens.LabelMedium;
        float r101 = (float) 72.0d;
        PeriodSelectorContainerHeight = Dp.m7544constructorimpl(r101);
        ShapeKeyTokens r102 = ShapeKeyTokens.CornerSmall;
        PeriodSelectorContainerShape = r102;
        PeriodSelectorContainerWidth = Dp.m7544constructorimpl((float) 52.0d);
        PeriodSelectorLabelTextFont = TypographyKeyTokens.TitleMedium;
        PeriodSelectorOutlineColor = ColorSchemeKeyTokens.Outline;
        PeriodSelectorOutlineWidth = Dp.m7544constructorimpl((float) 1.0d);
        PeriodSelectorSelectedContainerColor = ColorSchemeKeyTokens.TertiaryContainer;
        ColorSchemeKeyTokens r103 = ColorSchemeKeyTokens.OnTertiaryContainer;
        PeriodSelectorSelectedFocusLabelTextColor = r103;
        PeriodSelectorSelectedHoverLabelTextColor = r103;
        PeriodSelectorSelectedLabelTextColor = r103;
        PeriodSelectorSelectedPressedLabelTextColor = r103;
        PeriodSelectorUnselectedFocusLabelTextColor = r100;
        PeriodSelectorUnselectedHoverLabelTextColor = r100;
        PeriodSelectorUnselectedLabelTextColor = r100;
        PeriodSelectorUnselectedPressedLabelTextColor = r100;
        TimeFieldContainerColor = ColorSchemeKeyTokens.SurfaceContainerHighest;
        TimeFieldContainerHeight = Dp.m7544constructorimpl(r101);
        TimeFieldContainerShape = r102;
        TimeFieldContainerWidth = Dp.m7544constructorimpl((float) 96.0d);
        TimeFieldFocusContainerColor = ColorSchemeKeyTokens.PrimaryContainer;
        TimeFieldFocusLabelTextColor = ColorSchemeKeyTokens.OnPrimaryContainer;
        TimeFieldFocusOutlineColor = ColorSchemeKeyTokens.Primary;
        TimeFieldFocusOutlineWidth = Dp.m7544constructorimpl((float) 2.0d);
        ColorSchemeKeyTokens r104 = ColorSchemeKeyTokens.OnSurface;
        TimeFieldHoverLabelTextColor = r104;
        TimeFieldLabelTextColor = r104;
        TimeFieldLabelTextFont = TypographyKeyTokens.DisplayMedium;
        TimeFieldSeparatorColor = r104;
        TimeFieldSeparatorFont = TypographyKeyTokens.DisplayLarge;
        TimeFieldSupportingTextColor = r100;
        TimeFieldSupportingTextFont = TypographyKeyTokens.BodySmall;
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    /* JADX INFO: renamed from: getContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3944getContainerElevationD9Ej5fM() {
        return ContainerElevation;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    public final ColorSchemeKeyTokens getFocusIndicatorColor() {
        return FocusIndicatorColor;
    }

    public final ColorSchemeKeyTokens getHeadlineColor() {
        return HeadlineColor;
    }

    public final TypographyKeyTokens getHeadlineFont() {
        return HeadlineFont;
    }

    /* JADX INFO: renamed from: getPeriodSelectorContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3945getPeriodSelectorContainerHeightD9Ej5fM() {
        return PeriodSelectorContainerHeight;
    }

    public final ShapeKeyTokens getPeriodSelectorContainerShape() {
        return PeriodSelectorContainerShape;
    }

    /* JADX INFO: renamed from: getPeriodSelectorContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m3946getPeriodSelectorContainerWidthD9Ej5fM() {
        return PeriodSelectorContainerWidth;
    }

    public final TypographyKeyTokens getPeriodSelectorLabelTextFont() {
        return PeriodSelectorLabelTextFont;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorOutlineColor() {
        return PeriodSelectorOutlineColor;
    }

    /* JADX INFO: renamed from: getPeriodSelectorOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m3947getPeriodSelectorOutlineWidthD9Ej5fM() {
        return PeriodSelectorOutlineWidth;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorSelectedContainerColor() {
        return PeriodSelectorSelectedContainerColor;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorSelectedFocusLabelTextColor() {
        return PeriodSelectorSelectedFocusLabelTextColor;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorSelectedHoverLabelTextColor() {
        return PeriodSelectorSelectedHoverLabelTextColor;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorSelectedLabelTextColor() {
        return PeriodSelectorSelectedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorSelectedPressedLabelTextColor() {
        return PeriodSelectorSelectedPressedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorUnselectedFocusLabelTextColor() {
        return PeriodSelectorUnselectedFocusLabelTextColor;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorUnselectedHoverLabelTextColor() {
        return PeriodSelectorUnselectedHoverLabelTextColor;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorUnselectedLabelTextColor() {
        return PeriodSelectorUnselectedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorUnselectedPressedLabelTextColor() {
        return PeriodSelectorUnselectedPressedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getTimeFieldContainerColor() {
        return TimeFieldContainerColor;
    }

    /* JADX INFO: renamed from: getTimeFieldContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3948getTimeFieldContainerHeightD9Ej5fM() {
        return TimeFieldContainerHeight;
    }

    public final ShapeKeyTokens getTimeFieldContainerShape() {
        return TimeFieldContainerShape;
    }

    /* JADX INFO: renamed from: getTimeFieldContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m3949getTimeFieldContainerWidthD9Ej5fM() {
        return TimeFieldContainerWidth;
    }

    public final ColorSchemeKeyTokens getTimeFieldFocusContainerColor() {
        return TimeFieldFocusContainerColor;
    }

    public final ColorSchemeKeyTokens getTimeFieldFocusLabelTextColor() {
        return TimeFieldFocusLabelTextColor;
    }

    public final ColorSchemeKeyTokens getTimeFieldFocusOutlineColor() {
        return TimeFieldFocusOutlineColor;
    }

    /* JADX INFO: renamed from: getTimeFieldFocusOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m3950getTimeFieldFocusOutlineWidthD9Ej5fM() {
        return TimeFieldFocusOutlineWidth;
    }

    public final ColorSchemeKeyTokens getTimeFieldHoverLabelTextColor() {
        return TimeFieldHoverLabelTextColor;
    }

    public final ColorSchemeKeyTokens getTimeFieldLabelTextColor() {
        return TimeFieldLabelTextColor;
    }

    public final TypographyKeyTokens getTimeFieldLabelTextFont() {
        return TimeFieldLabelTextFont;
    }

    public final ColorSchemeKeyTokens getTimeFieldSeparatorColor() {
        return TimeFieldSeparatorColor;
    }

    public final TypographyKeyTokens getTimeFieldSeparatorFont() {
        return TimeFieldSeparatorFont;
    }

    public final ColorSchemeKeyTokens getTimeFieldSupportingTextColor() {
        return TimeFieldSupportingTextColor;
    }

    public final TypographyKeyTokens getTimeFieldSupportingTextFont() {
        return TimeFieldSupportingTextFont;
    }
}
