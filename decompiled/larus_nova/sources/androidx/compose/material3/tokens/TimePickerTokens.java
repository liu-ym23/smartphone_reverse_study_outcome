package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\ba\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001a\u0010\u000bR\u0011\u0010\u001b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0007R\u0011\u0010\u001d\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0013\u0010\u001f\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b \u0010\u000bR\u0011\u0010!\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0007R\u0013\u0010#\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b$\u0010\u000bR\u0011\u0010%\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0011\u0010'\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0007R\u0011\u0010)\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0007R\u0013\u0010+\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b,\u0010\u000bR\u0011\u0010-\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0018R\u0011\u0010/\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0007R\u0011\u00101\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0010R\u0011\u00103\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0018R\u0013\u00105\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b6\u0010\u000bR\u0013\u00107\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b8\u0010\u000bR\u0011\u00109\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0010R\u0011\u0010;\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0007R\u0013\u0010=\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b>\u0010\u000bR\u0011\u0010?\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0007R\u0011\u0010A\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0007R\u0011\u0010C\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0007R\u0011\u0010E\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0007R\u0011\u0010G\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0007R\u0011\u0010I\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u0007R\u0011\u0010K\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u0007R\u0011\u0010M\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\u0007R\u0011\u0010O\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u0007R\u0013\u0010Q\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\bR\u0010\u000bR\u0013\u0010S\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\bT\u0010\u000bR\u0013\u0010U\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\bV\u0010\u000bR\u0013\u0010W\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\bX\u0010\u000bR\u0011\u0010Y\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010\u0018R\u0013\u0010[\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\\\u0010\u000bR\u0011\u0010]\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b^\u0010\u0010R\u0011\u0010_\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b`\u0010\u0007R\u0011\u0010a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bb\u0010\u0007R\u0011\u0010c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bd\u0010\u0007R\u0011\u0010e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bf\u0010\u0007R\u0011\u0010g\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bh\u0010\u0007R\u0011\u0010i\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bj\u0010\u0007R\u0011\u0010k\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bl\u0010\u0010R\u0011\u0010m\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bn\u0010\u0007R\u0011\u0010o\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bp\u0010\u0007R\u0011\u0010q\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\br\u0010\u0007R\u0011\u0010s\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bt\u0010\u0007R\u0011\u0010u\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bv\u0010\u0007¨\u0006w"}, d2 = {"Landroidx/compose/material3/tokens/TimePickerTokens;", "", "<init>", "()V", "ClockDialColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getClockDialColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ClockDialContainerSize", "Landroidx/compose/ui/unit/Dp;", "getClockDialContainerSize-D9Ej5fM", "()F", FaceService.girlLabel, "ClockDialLabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getClockDialLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "ClockDialSelectedLabelTextColor", "getClockDialSelectedLabelTextColor", "ClockDialSelectorCenterContainerColor", "getClockDialSelectorCenterContainerColor", "ClockDialSelectorCenterContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getClockDialSelectorCenterContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ClockDialSelectorCenterContainerSize", "getClockDialSelectorCenterContainerSize-D9Ej5fM", "ClockDialSelectorHandleContainerColor", "getClockDialSelectorHandleContainerColor", "ClockDialSelectorHandleContainerShape", "getClockDialSelectorHandleContainerShape", "ClockDialSelectorHandleContainerSize", "getClockDialSelectorHandleContainerSize-D9Ej5fM", "ClockDialSelectorTrackContainerColor", "getClockDialSelectorTrackContainerColor", "ClockDialSelectorTrackContainerWidth", "getClockDialSelectorTrackContainerWidth-D9Ej5fM", "ClockDialShape", "getClockDialShape", "ClockDialUnselectedLabelTextColor", "getClockDialUnselectedLabelTextColor", "ContainerColor", "getContainerColor", "ContainerElevation", "getContainerElevation-D9Ej5fM", "ContainerShape", "getContainerShape", "HeadlineColor", "getHeadlineColor", "HeadlineFont", "getHeadlineFont", "PeriodSelectorContainerShape", "getPeriodSelectorContainerShape", "PeriodSelectorHorizontalContainerHeight", "getPeriodSelectorHorizontalContainerHeight-D9Ej5fM", "PeriodSelectorHorizontalContainerWidth", "getPeriodSelectorHorizontalContainerWidth-D9Ej5fM", "PeriodSelectorLabelTextFont", "getPeriodSelectorLabelTextFont", "PeriodSelectorOutlineColor", "getPeriodSelectorOutlineColor", "PeriodSelectorOutlineWidth", "getPeriodSelectorOutlineWidth-D9Ej5fM", "PeriodSelectorSelectedContainerColor", "getPeriodSelectorSelectedContainerColor", "PeriodSelectorSelectedFocusLabelTextColor", "getPeriodSelectorSelectedFocusLabelTextColor", "PeriodSelectorSelectedHoverLabelTextColor", "getPeriodSelectorSelectedHoverLabelTextColor", "PeriodSelectorSelectedLabelTextColor", "getPeriodSelectorSelectedLabelTextColor", "PeriodSelectorSelectedPressedLabelTextColor", "getPeriodSelectorSelectedPressedLabelTextColor", "PeriodSelectorUnselectedFocusLabelTextColor", "getPeriodSelectorUnselectedFocusLabelTextColor", "PeriodSelectorUnselectedHoverLabelTextColor", "getPeriodSelectorUnselectedHoverLabelTextColor", "PeriodSelectorUnselectedLabelTextColor", "getPeriodSelectorUnselectedLabelTextColor", "PeriodSelectorUnselectedPressedLabelTextColor", "getPeriodSelectorUnselectedPressedLabelTextColor", "PeriodSelectorVerticalContainerHeight", "getPeriodSelectorVerticalContainerHeight-D9Ej5fM", "PeriodSelectorVerticalContainerWidth", "getPeriodSelectorVerticalContainerWidth-D9Ej5fM", "TimeSelector24HVerticalContainerWidth", "getTimeSelector24HVerticalContainerWidth-D9Ej5fM", "TimeSelectorContainerHeight", "getTimeSelectorContainerHeight-D9Ej5fM", "TimeSelectorContainerShape", "getTimeSelectorContainerShape", "TimeSelectorContainerWidth", "getTimeSelectorContainerWidth-D9Ej5fM", "TimeSelectorLabelTextFont", "getTimeSelectorLabelTextFont", "TimeSelectorSelectedContainerColor", "getTimeSelectorSelectedContainerColor", "TimeSelectorSelectedFocusLabelTextColor", "getTimeSelectorSelectedFocusLabelTextColor", "TimeSelectorSelectedHoverLabelTextColor", "getTimeSelectorSelectedHoverLabelTextColor", "TimeSelectorSelectedLabelTextColor", "getTimeSelectorSelectedLabelTextColor", "TimeSelectorSelectedPressedLabelTextColor", "getTimeSelectorSelectedPressedLabelTextColor", "TimeSelectorSeparatorColor", "getTimeSelectorSeparatorColor", "TimeSelectorSeparatorFont", "getTimeSelectorSeparatorFont", "TimeSelectorUnselectedContainerColor", "getTimeSelectorUnselectedContainerColor", "TimeSelectorUnselectedFocusLabelTextColor", "getTimeSelectorUnselectedFocusLabelTextColor", "TimeSelectorUnselectedHoverLabelTextColor", "getTimeSelectorUnselectedHoverLabelTextColor", "TimeSelectorUnselectedLabelTextColor", "getTimeSelectorUnselectedLabelTextColor", "TimeSelectorUnselectedPressedLabelTextColor", "getTimeSelectorUnselectedPressedLabelTextColor", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TimePickerTokens {
    public static final int $stable = 0;
    private static final ColorSchemeKeyTokens ClockDialColor = null;
    private static final float ClockDialContainerSize = 0.0f;
    private static final TypographyKeyTokens ClockDialLabelTextFont = null;
    private static final ColorSchemeKeyTokens ClockDialSelectedLabelTextColor = null;
    private static final ColorSchemeKeyTokens ClockDialSelectorCenterContainerColor = null;
    private static final ShapeKeyTokens ClockDialSelectorCenterContainerShape = null;
    private static final float ClockDialSelectorCenterContainerSize = 0.0f;
    private static final ColorSchemeKeyTokens ClockDialSelectorHandleContainerColor = null;
    private static final ShapeKeyTokens ClockDialSelectorHandleContainerShape = null;
    private static final float ClockDialSelectorHandleContainerSize = 0.0f;
    private static final ColorSchemeKeyTokens ClockDialSelectorTrackContainerColor = null;
    private static final float ClockDialSelectorTrackContainerWidth = 0.0f;
    private static final ShapeKeyTokens ClockDialShape = null;
    private static final ColorSchemeKeyTokens ClockDialUnselectedLabelTextColor = null;
    private static final ColorSchemeKeyTokens ContainerColor = null;
    private static final float ContainerElevation = 0.0f;
    private static final ShapeKeyTokens ContainerShape = null;
    private static final ColorSchemeKeyTokens HeadlineColor = null;
    private static final TypographyKeyTokens HeadlineFont = null;
    public static final TimePickerTokens INSTANCE = null;
    private static final ShapeKeyTokens PeriodSelectorContainerShape = null;
    private static final float PeriodSelectorHorizontalContainerHeight = 0.0f;
    private static final float PeriodSelectorHorizontalContainerWidth = 0.0f;
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
    private static final float PeriodSelectorVerticalContainerHeight = 0.0f;
    private static final float PeriodSelectorVerticalContainerWidth = 0.0f;
    private static final float TimeSelector24HVerticalContainerWidth = 0.0f;
    private static final float TimeSelectorContainerHeight = 0.0f;
    private static final ShapeKeyTokens TimeSelectorContainerShape = null;
    private static final float TimeSelectorContainerWidth = 0.0f;
    private static final TypographyKeyTokens TimeSelectorLabelTextFont = null;
    private static final ColorSchemeKeyTokens TimeSelectorSelectedContainerColor = null;
    private static final ColorSchemeKeyTokens TimeSelectorSelectedFocusLabelTextColor = null;
    private static final ColorSchemeKeyTokens TimeSelectorSelectedHoverLabelTextColor = null;
    private static final ColorSchemeKeyTokens TimeSelectorSelectedLabelTextColor = null;
    private static final ColorSchemeKeyTokens TimeSelectorSelectedPressedLabelTextColor = null;
    private static final ColorSchemeKeyTokens TimeSelectorSeparatorColor = null;
    private static final TypographyKeyTokens TimeSelectorSeparatorFont = null;
    private static final ColorSchemeKeyTokens TimeSelectorUnselectedContainerColor = null;
    private static final ColorSchemeKeyTokens TimeSelectorUnselectedFocusLabelTextColor = null;
    private static final ColorSchemeKeyTokens TimeSelectorUnselectedHoverLabelTextColor = null;
    private static final ColorSchemeKeyTokens TimeSelectorUnselectedLabelTextColor = null;
    private static final ColorSchemeKeyTokens TimeSelectorUnselectedPressedLabelTextColor = null;

    private TimePickerTokens() {
    }

    static {
        INSTANCE = new TimePickerTokens();
        ColorSchemeKeyTokens r100 = ColorSchemeKeyTokens.SurfaceContainerHighest;
        ClockDialColor = r100;
        ClockDialContainerSize = Dp.m7544constructorimpl((float) 256.0d);
        ClockDialLabelTextFont = TypographyKeyTokens.BodyLarge;
        ClockDialSelectedLabelTextColor = ColorSchemeKeyTokens.OnPrimary;
        ColorSchemeKeyTokens r101 = ColorSchemeKeyTokens.Primary;
        ClockDialSelectorCenterContainerColor = r101;
        ShapeKeyTokens r102 = ShapeKeyTokens.CornerFull;
        ClockDialSelectorCenterContainerShape = r102;
        ClockDialSelectorCenterContainerSize = Dp.m7544constructorimpl((float) 8.0d);
        ClockDialSelectorHandleContainerColor = r101;
        ClockDialSelectorHandleContainerShape = r102;
        ClockDialSelectorHandleContainerSize = Dp.m7544constructorimpl((float) 48.0d);
        ClockDialSelectorTrackContainerColor = r101;
        ClockDialSelectorTrackContainerWidth = Dp.m7544constructorimpl((float) 2.0d);
        ClockDialShape = r102;
        ColorSchemeKeyTokens r103 = ColorSchemeKeyTokens.OnSurface;
        ClockDialUnselectedLabelTextColor = r103;
        ContainerColor = ColorSchemeKeyTokens.SurfaceContainerHigh;
        ContainerElevation = ElevationTokens.INSTANCE.m3501getLevel3D9Ej5fM();
        ContainerShape = ShapeKeyTokens.CornerExtraLarge;
        ColorSchemeKeyTokens r104 = ColorSchemeKeyTokens.OnSurfaceVariant;
        HeadlineColor = r104;
        HeadlineFont = TypographyKeyTokens.LabelMedium;
        ShapeKeyTokens r105 = ShapeKeyTokens.CornerSmall;
        PeriodSelectorContainerShape = r105;
        PeriodSelectorHorizontalContainerHeight = Dp.m7544constructorimpl((float) 38.0d);
        PeriodSelectorHorizontalContainerWidth = Dp.m7544constructorimpl((float) 216.0d);
        PeriodSelectorLabelTextFont = TypographyKeyTokens.TitleMedium;
        PeriodSelectorOutlineColor = ColorSchemeKeyTokens.Outline;
        PeriodSelectorOutlineWidth = Dp.m7544constructorimpl((float) 1.0d);
        PeriodSelectorSelectedContainerColor = ColorSchemeKeyTokens.TertiaryContainer;
        ColorSchemeKeyTokens r106 = ColorSchemeKeyTokens.OnTertiaryContainer;
        PeriodSelectorSelectedFocusLabelTextColor = r106;
        PeriodSelectorSelectedHoverLabelTextColor = r106;
        PeriodSelectorSelectedLabelTextColor = r106;
        PeriodSelectorSelectedPressedLabelTextColor = r106;
        PeriodSelectorUnselectedFocusLabelTextColor = r104;
        PeriodSelectorUnselectedHoverLabelTextColor = r104;
        PeriodSelectorUnselectedLabelTextColor = r104;
        PeriodSelectorUnselectedPressedLabelTextColor = r104;
        float r107 = (float) 80.0d;
        PeriodSelectorVerticalContainerHeight = Dp.m7544constructorimpl(r107);
        PeriodSelectorVerticalContainerWidth = Dp.m7544constructorimpl((float) 52.0d);
        TimeSelector24HVerticalContainerWidth = Dp.m7544constructorimpl((float) 114.0d);
        TimeSelectorContainerHeight = Dp.m7544constructorimpl(r107);
        TimeSelectorContainerShape = r105;
        TimeSelectorContainerWidth = Dp.m7544constructorimpl((float) 96.0d);
        TypographyKeyTokens r108 = TypographyKeyTokens.DisplayLarge;
        TimeSelectorLabelTextFont = r108;
        TimeSelectorSelectedContainerColor = ColorSchemeKeyTokens.PrimaryContainer;
        ColorSchemeKeyTokens r109 = ColorSchemeKeyTokens.OnPrimaryContainer;
        TimeSelectorSelectedFocusLabelTextColor = r109;
        TimeSelectorSelectedHoverLabelTextColor = r109;
        TimeSelectorSelectedLabelTextColor = r109;
        TimeSelectorSelectedPressedLabelTextColor = r109;
        TimeSelectorSeparatorColor = r103;
        TimeSelectorSeparatorFont = r108;
        TimeSelectorUnselectedContainerColor = r100;
        TimeSelectorUnselectedFocusLabelTextColor = r103;
        TimeSelectorUnselectedHoverLabelTextColor = r103;
        TimeSelectorUnselectedLabelTextColor = r103;
        TimeSelectorUnselectedPressedLabelTextColor = r103;
    }

    public final ColorSchemeKeyTokens getClockDialColor() {
        return ClockDialColor;
    }

    /* JADX INFO: renamed from: getClockDialContainerSize-D9Ej5fM, reason: not valid java name */
    public final float m3951getClockDialContainerSizeD9Ej5fM() {
        return ClockDialContainerSize;
    }

    public final TypographyKeyTokens getClockDialLabelTextFont() {
        return ClockDialLabelTextFont;
    }

    public final ColorSchemeKeyTokens getClockDialSelectedLabelTextColor() {
        return ClockDialSelectedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getClockDialSelectorCenterContainerColor() {
        return ClockDialSelectorCenterContainerColor;
    }

    public final ShapeKeyTokens getClockDialSelectorCenterContainerShape() {
        return ClockDialSelectorCenterContainerShape;
    }

    /* JADX INFO: renamed from: getClockDialSelectorCenterContainerSize-D9Ej5fM, reason: not valid java name */
    public final float m3952getClockDialSelectorCenterContainerSizeD9Ej5fM() {
        return ClockDialSelectorCenterContainerSize;
    }

    public final ColorSchemeKeyTokens getClockDialSelectorHandleContainerColor() {
        return ClockDialSelectorHandleContainerColor;
    }

    public final ShapeKeyTokens getClockDialSelectorHandleContainerShape() {
        return ClockDialSelectorHandleContainerShape;
    }

    /* JADX INFO: renamed from: getClockDialSelectorHandleContainerSize-D9Ej5fM, reason: not valid java name */
    public final float m3953getClockDialSelectorHandleContainerSizeD9Ej5fM() {
        return ClockDialSelectorHandleContainerSize;
    }

    public final ColorSchemeKeyTokens getClockDialSelectorTrackContainerColor() {
        return ClockDialSelectorTrackContainerColor;
    }

    /* JADX INFO: renamed from: getClockDialSelectorTrackContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m3954getClockDialSelectorTrackContainerWidthD9Ej5fM() {
        return ClockDialSelectorTrackContainerWidth;
    }

    public final ShapeKeyTokens getClockDialShape() {
        return ClockDialShape;
    }

    public final ColorSchemeKeyTokens getClockDialUnselectedLabelTextColor() {
        return ClockDialUnselectedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    /* JADX INFO: renamed from: getContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3955getContainerElevationD9Ej5fM() {
        return ContainerElevation;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    public final ColorSchemeKeyTokens getHeadlineColor() {
        return HeadlineColor;
    }

    public final TypographyKeyTokens getHeadlineFont() {
        return HeadlineFont;
    }

    public final ShapeKeyTokens getPeriodSelectorContainerShape() {
        return PeriodSelectorContainerShape;
    }

    /* JADX INFO: renamed from: getPeriodSelectorHorizontalContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3956getPeriodSelectorHorizontalContainerHeightD9Ej5fM() {
        return PeriodSelectorHorizontalContainerHeight;
    }

    /* JADX INFO: renamed from: getPeriodSelectorHorizontalContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m3957getPeriodSelectorHorizontalContainerWidthD9Ej5fM() {
        return PeriodSelectorHorizontalContainerWidth;
    }

    public final TypographyKeyTokens getPeriodSelectorLabelTextFont() {
        return PeriodSelectorLabelTextFont;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorOutlineColor() {
        return PeriodSelectorOutlineColor;
    }

    /* JADX INFO: renamed from: getPeriodSelectorOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m3958getPeriodSelectorOutlineWidthD9Ej5fM() {
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

    /* JADX INFO: renamed from: getPeriodSelectorVerticalContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3959getPeriodSelectorVerticalContainerHeightD9Ej5fM() {
        return PeriodSelectorVerticalContainerHeight;
    }

    /* JADX INFO: renamed from: getPeriodSelectorVerticalContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m3960getPeriodSelectorVerticalContainerWidthD9Ej5fM() {
        return PeriodSelectorVerticalContainerWidth;
    }

    /* JADX INFO: renamed from: getTimeSelector24HVerticalContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m3961getTimeSelector24HVerticalContainerWidthD9Ej5fM() {
        return TimeSelector24HVerticalContainerWidth;
    }

    /* JADX INFO: renamed from: getTimeSelectorContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3962getTimeSelectorContainerHeightD9Ej5fM() {
        return TimeSelectorContainerHeight;
    }

    public final ShapeKeyTokens getTimeSelectorContainerShape() {
        return TimeSelectorContainerShape;
    }

    /* JADX INFO: renamed from: getTimeSelectorContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m3963getTimeSelectorContainerWidthD9Ej5fM() {
        return TimeSelectorContainerWidth;
    }

    public final TypographyKeyTokens getTimeSelectorLabelTextFont() {
        return TimeSelectorLabelTextFont;
    }

    public final ColorSchemeKeyTokens getTimeSelectorSelectedContainerColor() {
        return TimeSelectorSelectedContainerColor;
    }

    public final ColorSchemeKeyTokens getTimeSelectorSelectedFocusLabelTextColor() {
        return TimeSelectorSelectedFocusLabelTextColor;
    }

    public final ColorSchemeKeyTokens getTimeSelectorSelectedHoverLabelTextColor() {
        return TimeSelectorSelectedHoverLabelTextColor;
    }

    public final ColorSchemeKeyTokens getTimeSelectorSelectedLabelTextColor() {
        return TimeSelectorSelectedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getTimeSelectorSelectedPressedLabelTextColor() {
        return TimeSelectorSelectedPressedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getTimeSelectorSeparatorColor() {
        return TimeSelectorSeparatorColor;
    }

    public final TypographyKeyTokens getTimeSelectorSeparatorFont() {
        return TimeSelectorSeparatorFont;
    }

    public final ColorSchemeKeyTokens getTimeSelectorUnselectedContainerColor() {
        return TimeSelectorUnselectedContainerColor;
    }

    public final ColorSchemeKeyTokens getTimeSelectorUnselectedFocusLabelTextColor() {
        return TimeSelectorUnselectedFocusLabelTextColor;
    }

    public final ColorSchemeKeyTokens getTimeSelectorUnselectedHoverLabelTextColor() {
        return TimeSelectorUnselectedHoverLabelTextColor;
    }

    public final ColorSchemeKeyTokens getTimeSelectorUnselectedLabelTextColor() {
        return TimeSelectorUnselectedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getTimeSelectorUnselectedPressedLabelTextColor() {
        return TimeSelectorUnselectedPressedLabelTextColor;
    }
}
