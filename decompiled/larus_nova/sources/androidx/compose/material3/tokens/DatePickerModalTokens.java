package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\bK\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0014\u0010\u000bR\u0013\u0010\u0015\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0016\u0010\u000bR\u0011\u0010\u0017\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\u0019\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001a\u0010\u000bR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0007R\u0011\u0010!\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0007R\u0013\u0010#\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b$\u0010\u000bR\u0011\u0010%\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0012R\u0013\u0010'\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b(\u0010\u000bR\u0011\u0010)\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0007R\u0013\u0010+\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b,\u0010\u000bR\u0011\u0010-\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0007R\u0011\u0010/\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0007R\u0013\u00101\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b2\u0010\u000bR\u0013\u00103\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b4\u0010\u000bR\u0011\u00105\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0007R\u0011\u00107\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001eR\u0011\u00109\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0007R\u0011\u0010;\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u001eR\u0011\u0010=\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0007R\u0013\u0010?\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b@\u0010\u000bR\u0011\u0010A\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0012R\u0013\u0010C\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\bD\u0010\u000bR\u0011\u0010E\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0012R\u0011\u0010G\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0007R\u0013\u0010I\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\bJ\u0010\u000bR\u0011\u0010K\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u001eR\u0011\u0010M\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\u0007R\u0011\u0010O\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u001eR\u0011\u0010Q\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u0007R\u0011\u0010S\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\u001eR\u0013\u0010U\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\bV\u0010\u000bR\u0013\u0010W\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\bX\u0010\u000bR\u0011\u0010Y\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010\u001eR\u0011\u0010[\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010\u0007R\u0011\u0010]\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b^\u0010\u0007R\u0013\u0010_\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b`\u0010\u000bR\u0011\u0010a\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bb\u0010\u0012R\u0013\u0010c\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\bd\u0010\u000bR\u0011\u0010e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bf\u0010\u0007¨\u0006g"}, d2 = {"Landroidx/compose/material3/tokens/DatePickerModalTokens;", "", "<init>", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", FaceService.girlLabel, "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ContainerWidth", "getContainerWidth-D9Ej5fM", "DateContainerHeight", "getDateContainerHeight-D9Ej5fM", "DateContainerShape", "getDateContainerShape", "DateContainerWidth", "getDateContainerWidth-D9Ej5fM", "DateLabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getDateLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "DateSelectedContainerColor", "getDateSelectedContainerColor", "DateSelectedLabelTextColor", "getDateSelectedLabelTextColor", "DateStateLayerHeight", "getDateStateLayerHeight-D9Ej5fM", "DateStateLayerShape", "getDateStateLayerShape", "DateStateLayerWidth", "getDateStateLayerWidth-D9Ej5fM", "DateTodayContainerOutlineColor", "getDateTodayContainerOutlineColor", "DateTodayContainerOutlineWidth", "getDateTodayContainerOutlineWidth-D9Ej5fM", "DateTodayLabelTextColor", "getDateTodayLabelTextColor", "DateUnselectedLabelTextColor", "getDateUnselectedLabelTextColor", "HeaderContainerHeight", "getHeaderContainerHeight-D9Ej5fM", "HeaderContainerWidth", "getHeaderContainerWidth-D9Ej5fM", "HeaderHeadlineColor", "getHeaderHeadlineColor", "HeaderHeadlineFont", "getHeaderHeadlineFont", "HeaderSupportingTextColor", "getHeaderSupportingTextColor", "HeaderSupportingTextFont", "getHeaderSupportingTextFont", "RangeSelectionActiveIndicatorContainerColor", "getRangeSelectionActiveIndicatorContainerColor", "RangeSelectionActiveIndicatorContainerHeight", "getRangeSelectionActiveIndicatorContainerHeight-D9Ej5fM", "RangeSelectionActiveIndicatorContainerShape", "getRangeSelectionActiveIndicatorContainerShape", "RangeSelectionContainerElevation", "getRangeSelectionContainerElevation-D9Ej5fM", "RangeSelectionContainerShape", "getRangeSelectionContainerShape", "SelectionDateInRangeLabelTextColor", "getSelectionDateInRangeLabelTextColor", "RangeSelectionHeaderContainerHeight", "getRangeSelectionHeaderContainerHeight-D9Ej5fM", "RangeSelectionHeaderHeadlineFont", "getRangeSelectionHeaderHeadlineFont", "RangeSelectionMonthSubheadColor", "getRangeSelectionMonthSubheadColor", "RangeSelectionMonthSubheadFont", "getRangeSelectionMonthSubheadFont", "WeekdaysLabelTextColor", "getWeekdaysLabelTextColor", "WeekdaysLabelTextFont", "getWeekdaysLabelTextFont", "SelectionYearContainerHeight", "getSelectionYearContainerHeight-D9Ej5fM", "SelectionYearContainerWidth", "getSelectionYearContainerWidth-D9Ej5fM", "SelectionYearLabelTextFont", "getSelectionYearLabelTextFont", "SelectionYearSelectedContainerColor", "getSelectionYearSelectedContainerColor", "SelectionYearSelectedLabelTextColor", "getSelectionYearSelectedLabelTextColor", "SelectionYearStateLayerHeight", "getSelectionYearStateLayerHeight-D9Ej5fM", "SelectionYearStateLayerShape", "getSelectionYearStateLayerShape", "SelectionYearStateLayerWidth", "getSelectionYearStateLayerWidth-D9Ej5fM", "SelectionYearUnselectedLabelTextColor", "getSelectionYearUnselectedLabelTextColor", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DatePickerModalTokens {
    public static final int $stable = 0;
    private static final ColorSchemeKeyTokens ContainerColor = null;
    private static final float ContainerElevation = 0.0f;
    private static final float ContainerHeight = 0.0f;
    private static final ShapeKeyTokens ContainerShape = null;
    private static final float ContainerWidth = 0.0f;
    private static final float DateContainerHeight = 0.0f;
    private static final ShapeKeyTokens DateContainerShape = null;
    private static final float DateContainerWidth = 0.0f;
    private static final TypographyKeyTokens DateLabelTextFont = null;
    private static final ColorSchemeKeyTokens DateSelectedContainerColor = null;
    private static final ColorSchemeKeyTokens DateSelectedLabelTextColor = null;
    private static final float DateStateLayerHeight = 0.0f;
    private static final ShapeKeyTokens DateStateLayerShape = null;
    private static final float DateStateLayerWidth = 0.0f;
    private static final ColorSchemeKeyTokens DateTodayContainerOutlineColor = null;
    private static final float DateTodayContainerOutlineWidth = 0.0f;
    private static final ColorSchemeKeyTokens DateTodayLabelTextColor = null;
    private static final ColorSchemeKeyTokens DateUnselectedLabelTextColor = null;
    private static final float HeaderContainerHeight = 0.0f;
    private static final float HeaderContainerWidth = 0.0f;
    private static final ColorSchemeKeyTokens HeaderHeadlineColor = null;
    private static final TypographyKeyTokens HeaderHeadlineFont = null;
    private static final ColorSchemeKeyTokens HeaderSupportingTextColor = null;
    private static final TypographyKeyTokens HeaderSupportingTextFont = null;
    public static final DatePickerModalTokens INSTANCE = null;
    private static final ColorSchemeKeyTokens RangeSelectionActiveIndicatorContainerColor = null;
    private static final float RangeSelectionActiveIndicatorContainerHeight = 0.0f;
    private static final ShapeKeyTokens RangeSelectionActiveIndicatorContainerShape = null;
    private static final float RangeSelectionContainerElevation = 0.0f;
    private static final ShapeKeyTokens RangeSelectionContainerShape = null;
    private static final float RangeSelectionHeaderContainerHeight = 0.0f;
    private static final TypographyKeyTokens RangeSelectionHeaderHeadlineFont = null;
    private static final ColorSchemeKeyTokens RangeSelectionMonthSubheadColor = null;
    private static final TypographyKeyTokens RangeSelectionMonthSubheadFont = null;
    private static final ColorSchemeKeyTokens SelectionDateInRangeLabelTextColor = null;
    private static final float SelectionYearContainerHeight = 0.0f;
    private static final float SelectionYearContainerWidth = 0.0f;
    private static final TypographyKeyTokens SelectionYearLabelTextFont = null;
    private static final ColorSchemeKeyTokens SelectionYearSelectedContainerColor = null;
    private static final ColorSchemeKeyTokens SelectionYearSelectedLabelTextColor = null;
    private static final float SelectionYearStateLayerHeight = 0.0f;
    private static final ShapeKeyTokens SelectionYearStateLayerShape = null;
    private static final float SelectionYearStateLayerWidth = 0.0f;
    private static final ColorSchemeKeyTokens SelectionYearUnselectedLabelTextColor = null;
    private static final ColorSchemeKeyTokens WeekdaysLabelTextColor = null;
    private static final TypographyKeyTokens WeekdaysLabelTextFont = null;

    private DatePickerModalTokens() {
    }

    static {
        INSTANCE = new DatePickerModalTokens();
        ContainerColor = ColorSchemeKeyTokens.SurfaceContainerHigh;
        ElevationTokens r100 = ElevationTokens.INSTANCE;
        ContainerElevation = r100.m3501getLevel3D9Ej5fM();
        ContainerHeight = Dp.m7544constructorimpl((float) 568.0d);
        ContainerShape = ShapeKeyTokens.CornerExtraLarge;
        float r101 = (float) 360.0d;
        ContainerWidth = Dp.m7544constructorimpl(r101);
        float r102 = (float) 40.0d;
        DateContainerHeight = Dp.m7544constructorimpl(r102);
        ShapeKeyTokens r103 = ShapeKeyTokens.CornerFull;
        DateContainerShape = r103;
        DateContainerWidth = Dp.m7544constructorimpl(r102);
        TypographyKeyTokens r104 = TypographyKeyTokens.BodyLarge;
        DateLabelTextFont = r104;
        ColorSchemeKeyTokens r105 = ColorSchemeKeyTokens.Primary;
        DateSelectedContainerColor = r105;
        ColorSchemeKeyTokens r106 = ColorSchemeKeyTokens.OnPrimary;
        DateSelectedLabelTextColor = r106;
        DateStateLayerHeight = Dp.m7544constructorimpl(r102);
        DateStateLayerShape = r103;
        DateStateLayerWidth = Dp.m7544constructorimpl(r102);
        DateTodayContainerOutlineColor = r105;
        DateTodayContainerOutlineWidth = Dp.m7544constructorimpl((float) 1.0d);
        DateTodayLabelTextColor = r105;
        ColorSchemeKeyTokens r107 = ColorSchemeKeyTokens.OnSurface;
        DateUnselectedLabelTextColor = r107;
        HeaderContainerHeight = Dp.m7544constructorimpl((float) 120.0d);
        HeaderContainerWidth = Dp.m7544constructorimpl(r101);
        ColorSchemeKeyTokens r108 = ColorSchemeKeyTokens.OnSurfaceVariant;
        HeaderHeadlineColor = r108;
        HeaderHeadlineFont = TypographyKeyTokens.HeadlineLarge;
        HeaderSupportingTextColor = r108;
        HeaderSupportingTextFont = TypographyKeyTokens.LabelLarge;
        RangeSelectionActiveIndicatorContainerColor = ColorSchemeKeyTokens.SecondaryContainer;
        RangeSelectionActiveIndicatorContainerHeight = Dp.m7544constructorimpl(r102);
        RangeSelectionActiveIndicatorContainerShape = r103;
        RangeSelectionContainerElevation = r100.m3498getLevel0D9Ej5fM();
        RangeSelectionContainerShape = ShapeKeyTokens.CornerNone;
        SelectionDateInRangeLabelTextColor = ColorSchemeKeyTokens.OnSecondaryContainer;
        RangeSelectionHeaderContainerHeight = Dp.m7544constructorimpl((float) 128.0d);
        RangeSelectionHeaderHeadlineFont = TypographyKeyTokens.TitleLarge;
        RangeSelectionMonthSubheadColor = r108;
        RangeSelectionMonthSubheadFont = TypographyKeyTokens.TitleSmall;
        WeekdaysLabelTextColor = r107;
        WeekdaysLabelTextFont = r104;
        float r109 = (float) 36.0d;
        SelectionYearContainerHeight = Dp.m7544constructorimpl(r109);
        float r110 = (float) 72.0d;
        SelectionYearContainerWidth = Dp.m7544constructorimpl(r110);
        SelectionYearLabelTextFont = r104;
        SelectionYearSelectedContainerColor = r105;
        SelectionYearSelectedLabelTextColor = r106;
        SelectionYearStateLayerHeight = Dp.m7544constructorimpl(r109);
        SelectionYearStateLayerShape = r103;
        SelectionYearStateLayerWidth = Dp.m7544constructorimpl(r110);
        SelectionYearUnselectedLabelTextColor = r108;
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    /* JADX INFO: renamed from: getContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3451getContainerElevationD9Ej5fM() {
        return ContainerElevation;
    }

    /* JADX INFO: renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3452getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    /* JADX INFO: renamed from: getContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m3453getContainerWidthD9Ej5fM() {
        return ContainerWidth;
    }

    /* JADX INFO: renamed from: getDateContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3454getDateContainerHeightD9Ej5fM() {
        return DateContainerHeight;
    }

    public final ShapeKeyTokens getDateContainerShape() {
        return DateContainerShape;
    }

    /* JADX INFO: renamed from: getDateContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m3455getDateContainerWidthD9Ej5fM() {
        return DateContainerWidth;
    }

    public final TypographyKeyTokens getDateLabelTextFont() {
        return DateLabelTextFont;
    }

    public final ColorSchemeKeyTokens getDateSelectedContainerColor() {
        return DateSelectedContainerColor;
    }

    public final ColorSchemeKeyTokens getDateSelectedLabelTextColor() {
        return DateSelectedLabelTextColor;
    }

    /* JADX INFO: renamed from: getDateStateLayerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3456getDateStateLayerHeightD9Ej5fM() {
        return DateStateLayerHeight;
    }

    public final ShapeKeyTokens getDateStateLayerShape() {
        return DateStateLayerShape;
    }

    /* JADX INFO: renamed from: getDateStateLayerWidth-D9Ej5fM, reason: not valid java name */
    public final float m3457getDateStateLayerWidthD9Ej5fM() {
        return DateStateLayerWidth;
    }

    public final ColorSchemeKeyTokens getDateTodayContainerOutlineColor() {
        return DateTodayContainerOutlineColor;
    }

    /* JADX INFO: renamed from: getDateTodayContainerOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m3458getDateTodayContainerOutlineWidthD9Ej5fM() {
        return DateTodayContainerOutlineWidth;
    }

    public final ColorSchemeKeyTokens getDateTodayLabelTextColor() {
        return DateTodayLabelTextColor;
    }

    public final ColorSchemeKeyTokens getDateUnselectedLabelTextColor() {
        return DateUnselectedLabelTextColor;
    }

    /* JADX INFO: renamed from: getHeaderContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3459getHeaderContainerHeightD9Ej5fM() {
        return HeaderContainerHeight;
    }

    /* JADX INFO: renamed from: getHeaderContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m3460getHeaderContainerWidthD9Ej5fM() {
        return HeaderContainerWidth;
    }

    public final ColorSchemeKeyTokens getHeaderHeadlineColor() {
        return HeaderHeadlineColor;
    }

    public final TypographyKeyTokens getHeaderHeadlineFont() {
        return HeaderHeadlineFont;
    }

    public final ColorSchemeKeyTokens getHeaderSupportingTextColor() {
        return HeaderSupportingTextColor;
    }

    public final TypographyKeyTokens getHeaderSupportingTextFont() {
        return HeaderSupportingTextFont;
    }

    public final ColorSchemeKeyTokens getRangeSelectionActiveIndicatorContainerColor() {
        return RangeSelectionActiveIndicatorContainerColor;
    }

    /* JADX INFO: renamed from: getRangeSelectionActiveIndicatorContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3461getRangeSelectionActiveIndicatorContainerHeightD9Ej5fM() {
        return RangeSelectionActiveIndicatorContainerHeight;
    }

    public final ShapeKeyTokens getRangeSelectionActiveIndicatorContainerShape() {
        return RangeSelectionActiveIndicatorContainerShape;
    }

    /* JADX INFO: renamed from: getRangeSelectionContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3462getRangeSelectionContainerElevationD9Ej5fM() {
        return RangeSelectionContainerElevation;
    }

    public final ShapeKeyTokens getRangeSelectionContainerShape() {
        return RangeSelectionContainerShape;
    }

    /* JADX INFO: renamed from: getRangeSelectionHeaderContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3463getRangeSelectionHeaderContainerHeightD9Ej5fM() {
        return RangeSelectionHeaderContainerHeight;
    }

    public final TypographyKeyTokens getRangeSelectionHeaderHeadlineFont() {
        return RangeSelectionHeaderHeadlineFont;
    }

    public final ColorSchemeKeyTokens getRangeSelectionMonthSubheadColor() {
        return RangeSelectionMonthSubheadColor;
    }

    public final TypographyKeyTokens getRangeSelectionMonthSubheadFont() {
        return RangeSelectionMonthSubheadFont;
    }

    public final ColorSchemeKeyTokens getSelectionDateInRangeLabelTextColor() {
        return SelectionDateInRangeLabelTextColor;
    }

    /* JADX INFO: renamed from: getSelectionYearContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3464getSelectionYearContainerHeightD9Ej5fM() {
        return SelectionYearContainerHeight;
    }

    /* JADX INFO: renamed from: getSelectionYearContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m3465getSelectionYearContainerWidthD9Ej5fM() {
        return SelectionYearContainerWidth;
    }

    public final TypographyKeyTokens getSelectionYearLabelTextFont() {
        return SelectionYearLabelTextFont;
    }

    public final ColorSchemeKeyTokens getSelectionYearSelectedContainerColor() {
        return SelectionYearSelectedContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectionYearSelectedLabelTextColor() {
        return SelectionYearSelectedLabelTextColor;
    }

    /* JADX INFO: renamed from: getSelectionYearStateLayerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3466getSelectionYearStateLayerHeightD9Ej5fM() {
        return SelectionYearStateLayerHeight;
    }

    public final ShapeKeyTokens getSelectionYearStateLayerShape() {
        return SelectionYearStateLayerShape;
    }

    /* JADX INFO: renamed from: getSelectionYearStateLayerWidth-D9Ej5fM, reason: not valid java name */
    public final float m3467getSelectionYearStateLayerWidthD9Ej5fM() {
        return SelectionYearStateLayerWidth;
    }

    public final ColorSchemeKeyTokens getSelectionYearUnselectedLabelTextColor() {
        return SelectionYearUnselectedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getWeekdaysLabelTextColor() {
        return WeekdaysLabelTextColor;
    }

    public final TypographyKeyTokens getWeekdaysLabelTextFont() {
        return WeekdaysLabelTextFont;
    }
}
