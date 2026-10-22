package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\bW\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\f\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\u0007R\u0013\u0010\u000e\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0015\u0010\u0007R\u0013\u0010\u0016\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010 \u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013R\u0011\u0010\"\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0014\u0010$\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0011\u0010&\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0014\u0010(\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0013\u0010*\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b+\u0010\u0007R\u0011\u0010,\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR\u0014\u0010.\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u0011\u00100\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001bR\u0011\u00102\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001bR\u0013\u00104\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b5\u0010\u0007R\u0011\u00106\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001bR\u0011\u00108\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001bR\u0011\u0010:\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u001bR\u0013\u0010<\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b=\u0010\u0007R\u0011\u0010>\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0013R\u0013\u0010@\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bA\u0010\u0007R\u0011\u0010B\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u001bR\u0013\u0010D\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bE\u0010\u0007R\u0011\u0010F\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u001bR\u0014\u0010H\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0007R\u0011\u0010J\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u001bR\u0013\u0010L\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bM\u0010\u0007R\u0011\u0010N\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0013R\u0011\u0010P\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u001bR\u0011\u0010R\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u001bR\u0011\u0010T\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u001bR\u0011\u0010V\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u001bR\u0013\u0010X\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bY\u0010\u0007R\u0011\u0010Z\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u001bR\u0011\u0010\\\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u001bR\u0011\u0010^\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b_\u0010\u001bR\u0011\u0010`\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u001bR\u0011\u0010b\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\u001bR\u0011\u0010d\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\be\u0010\u0013R\u0013\u0010f\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bg\u0010\u0007R\u0013\u0010h\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bi\u0010\u0007R\u0013\u0010j\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\bk\u0010\u0007R\u0011\u0010l\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\u001bR\u0011\u0010n\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u001bR\u0011\u0010p\u001a\u00020q¢\u0006\b\n\u0000\u001a\u0004\br\u0010s¨\u0006t"}, d2 = {"Landroidx/compose/material3/tokens/SliderTokens;", "", "<init>", "()V", "ActiveContainerOpacity", "", "getActiveContainerOpacity", "()F", "ActiveHandleHeight", "Landroidx/compose/ui/unit/Dp;", "getActiveHandleHeight-D9Ej5fM", FaceService.girlLabel, "ActiveHandleLeadingSpace", "getActiveHandleLeadingSpace-D9Ej5fM", "ActiveHandlePadding", "getActiveHandlePadding-D9Ej5fM", "ActiveHandleShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getActiveHandleShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ActiveHandleTrailingSpace", "getActiveHandleTrailingSpace-D9Ej5fM", "ActiveHandleWidth", "getActiveHandleWidth-D9Ej5fM", "ActiveTrackColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getActiveTrackColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActiveTrackHeight", "getActiveTrackHeight-D9Ej5fM", "ActiveTrackShape", "getActiveTrackShape", "ActiveTrackShapeLeading", "getActiveTrackShapeLeading", "DisabledActiveTrackColor", "getDisabledActiveTrackColor", "DisabledActiveTrackOpacity", "getDisabledActiveTrackOpacity", "DisabledHandleColor", "getDisabledHandleColor", "DisabledHandleOpacity", "getDisabledHandleOpacity", "DisabledHandleWidth", "getDisabledHandleWidth-D9Ej5fM", "DisabledInactiveTrackColor", "getDisabledInactiveTrackColor", "DisabledInactiveTrackOpacity", "getDisabledInactiveTrackOpacity", "DisabledStopColor", "getDisabledStopColor", "FocusActiveTrackColor", "getFocusActiveTrackColor", "FocusHandleWidth", "getFocusHandleWidth-D9Ej5fM", "FocusInactiveTrackColor", "getFocusInactiveTrackColor", "FocusStopColor", "getFocusStopColor", "HandleColor", "getHandleColor", "HandleHeight", "getHandleHeight-D9Ej5fM", "HandleShape", "getHandleShape", "HandleWidth", "getHandleWidth-D9Ej5fM", "HoverHandleColor", "getHoverHandleColor", "HoverHandleWidth", "getHoverHandleWidth-D9Ej5fM", "HoverStopColor", "getHoverStopColor", "InactiveContainerOpacity", "getInactiveContainerOpacity", "InactiveTrackColor", "getInactiveTrackColor", "InactiveTrackHeight", "getInactiveTrackHeight-D9Ej5fM", "InactiveTrackShape", "getInactiveTrackShape", "LabelContainerColor", "getLabelContainerColor", "LabelTextColor", "getLabelTextColor", "PressedActiveTrackColor", "getPressedActiveTrackColor", "PressedHandleColor", "getPressedHandleColor", "PressedHandleWidth", "getPressedHandleWidth-D9Ej5fM", "PressedInactiveTrackColor", "getPressedInactiveTrackColor", "PressedStopColor", "getPressedStopColor", "SliderActiveHandleColor", "getSliderActiveHandleColor", "StopIndicatorColor", "getStopIndicatorColor", "StopIndicatorColorSelected", "getStopIndicatorColorSelected", "StopIndicatorShape", "getStopIndicatorShape", "StopIndicatorSize", "getStopIndicatorSize-D9Ej5fM", "StopIndicatorTrailingSpace", "getStopIndicatorTrailingSpace-D9Ej5fM", "ValueIndicatorActiveBottomSpace", "getValueIndicatorActiveBottomSpace-D9Ej5fM", "ValueIndicatorContainerColor", "getValueIndicatorContainerColor", "ValueIndicatorLabelTextColor", "getValueIndicatorLabelTextColor", "ValueIndicatorLabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getValueIndicatorLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SliderTokens {
    public static final int $stable = 0;
    private static final float ActiveContainerOpacity = 0.0f;
    private static final float ActiveHandleHeight = 0.0f;
    private static final float ActiveHandleLeadingSpace = 0.0f;
    private static final float ActiveHandlePadding = 0.0f;
    private static final ShapeKeyTokens ActiveHandleShape = null;
    private static final float ActiveHandleTrailingSpace = 0.0f;
    private static final float ActiveHandleWidth = 0.0f;
    private static final ColorSchemeKeyTokens ActiveTrackColor = null;
    private static final float ActiveTrackHeight = 0.0f;
    private static final ShapeKeyTokens ActiveTrackShape = null;
    private static final ShapeKeyTokens ActiveTrackShapeLeading = null;
    private static final ColorSchemeKeyTokens DisabledActiveTrackColor = null;
    private static final float DisabledActiveTrackOpacity = 0.0f;
    private static final ColorSchemeKeyTokens DisabledHandleColor = null;
    private static final float DisabledHandleOpacity = 0.0f;
    private static final float DisabledHandleWidth = 0.0f;
    private static final ColorSchemeKeyTokens DisabledInactiveTrackColor = null;
    private static final float DisabledInactiveTrackOpacity = 0.0f;
    private static final ColorSchemeKeyTokens DisabledStopColor = null;
    private static final ColorSchemeKeyTokens FocusActiveTrackColor = null;
    private static final float FocusHandleWidth = 0.0f;
    private static final ColorSchemeKeyTokens FocusInactiveTrackColor = null;
    private static final ColorSchemeKeyTokens FocusStopColor = null;
    private static final ColorSchemeKeyTokens HandleColor = null;
    private static final float HandleHeight = 0.0f;
    private static final ShapeKeyTokens HandleShape = null;
    private static final float HandleWidth = 0.0f;
    private static final ColorSchemeKeyTokens HoverHandleColor = null;
    private static final float HoverHandleWidth = 0.0f;
    private static final ColorSchemeKeyTokens HoverStopColor = null;
    public static final SliderTokens INSTANCE = null;
    private static final float InactiveContainerOpacity = 0.0f;
    private static final ColorSchemeKeyTokens InactiveTrackColor = null;
    private static final float InactiveTrackHeight = 0.0f;
    private static final ShapeKeyTokens InactiveTrackShape = null;
    private static final ColorSchemeKeyTokens LabelContainerColor = null;
    private static final ColorSchemeKeyTokens LabelTextColor = null;
    private static final ColorSchemeKeyTokens PressedActiveTrackColor = null;
    private static final ColorSchemeKeyTokens PressedHandleColor = null;
    private static final float PressedHandleWidth = 0.0f;
    private static final ColorSchemeKeyTokens PressedInactiveTrackColor = null;
    private static final ColorSchemeKeyTokens PressedStopColor = null;
    private static final ColorSchemeKeyTokens SliderActiveHandleColor = null;
    private static final ColorSchemeKeyTokens StopIndicatorColor = null;
    private static final ColorSchemeKeyTokens StopIndicatorColorSelected = null;
    private static final ShapeKeyTokens StopIndicatorShape = null;
    private static final float StopIndicatorSize = 0.0f;
    private static final float StopIndicatorTrailingSpace = 0.0f;
    private static final float ValueIndicatorActiveBottomSpace = 0.0f;
    private static final ColorSchemeKeyTokens ValueIndicatorContainerColor = null;
    private static final ColorSchemeKeyTokens ValueIndicatorLabelTextColor = null;
    private static final TypographyKeyTokens ValueIndicatorLabelTextFont = null;

    private SliderTokens() {
    }

    static {
        INSTANCE = new SliderTokens();
        ActiveContainerOpacity = 1.0f;
        float r100 = (float) 44.0d;
        ActiveHandleHeight = Dp.m7544constructorimpl(r100);
        float r101 = (float) 6.0d;
        ActiveHandleLeadingSpace = Dp.m7544constructorimpl(r101);
        ActiveHandlePadding = Dp.m7544constructorimpl(r101);
        ShapeKeyTokens r102 = ShapeKeyTokens.CornerFull;
        ActiveHandleShape = r102;
        ActiveHandleTrailingSpace = Dp.m7544constructorimpl(r101);
        float r103 = (float) 4.0d;
        ActiveHandleWidth = Dp.m7544constructorimpl(r103);
        ColorSchemeKeyTokens r104 = ColorSchemeKeyTokens.Primary;
        ActiveTrackColor = r104;
        float r105 = (float) 16.0d;
        ActiveTrackHeight = Dp.m7544constructorimpl(r105);
        ActiveTrackShape = r102;
        ActiveTrackShapeLeading = r102;
        ColorSchemeKeyTokens r106 = ColorSchemeKeyTokens.OnSurface;
        DisabledActiveTrackColor = r106;
        DisabledActiveTrackOpacity = 0.38f;
        DisabledHandleColor = r106;
        DisabledHandleOpacity = 0.38f;
        DisabledHandleWidth = Dp.m7544constructorimpl(r103);
        DisabledInactiveTrackColor = r106;
        DisabledInactiveTrackOpacity = 0.12f;
        DisabledStopColor = r106;
        FocusActiveTrackColor = r104;
        float r107 = (float) 2.0d;
        FocusHandleWidth = Dp.m7544constructorimpl(r107);
        ColorSchemeKeyTokens r108 = ColorSchemeKeyTokens.SecondaryContainer;
        FocusInactiveTrackColor = r108;
        FocusStopColor = r104;
        HandleColor = r104;
        HandleHeight = Dp.m7544constructorimpl(r100);
        HandleShape = r102;
        HandleWidth = Dp.m7544constructorimpl(r103);
        HoverHandleColor = r104;
        HoverHandleWidth = Dp.m7544constructorimpl(r103);
        HoverStopColor = r104;
        InactiveContainerOpacity = 1.0f;
        InactiveTrackColor = r108;
        InactiveTrackHeight = Dp.m7544constructorimpl(r105);
        InactiveTrackShape = r102;
        LabelContainerColor = r104;
        ColorSchemeKeyTokens r109 = ColorSchemeKeyTokens.InverseOnSurface;
        LabelTextColor = r109;
        PressedActiveTrackColor = r104;
        PressedHandleColor = r104;
        PressedHandleWidth = Dp.m7544constructorimpl(r107);
        PressedInactiveTrackColor = r108;
        PressedStopColor = r104;
        SliderActiveHandleColor = r104;
        StopIndicatorColor = r108;
        StopIndicatorColorSelected = r108;
        StopIndicatorShape = r102;
        StopIndicatorSize = Dp.m7544constructorimpl(r103);
        StopIndicatorTrailingSpace = Dp.m7544constructorimpl(r101);
        ValueIndicatorActiveBottomSpace = Dp.m7544constructorimpl((float) 12.0d);
        ValueIndicatorContainerColor = ColorSchemeKeyTokens.InverseSurface;
        ValueIndicatorLabelTextColor = r109;
        ValueIndicatorLabelTextFont = TypographyKeyTokens.LabelLarge;
    }

    public final float getActiveContainerOpacity() {
        return ActiveContainerOpacity;
    }

    /* JADX INFO: renamed from: getActiveHandleHeight-D9Ej5fM, reason: not valid java name */
    public final float m3856getActiveHandleHeightD9Ej5fM() {
        return ActiveHandleHeight;
    }

    /* JADX INFO: renamed from: getActiveHandleLeadingSpace-D9Ej5fM, reason: not valid java name */
    public final float m3857getActiveHandleLeadingSpaceD9Ej5fM() {
        return ActiveHandleLeadingSpace;
    }

    /* JADX INFO: renamed from: getActiveHandlePadding-D9Ej5fM, reason: not valid java name */
    public final float m3858getActiveHandlePaddingD9Ej5fM() {
        return ActiveHandlePadding;
    }

    public final ShapeKeyTokens getActiveHandleShape() {
        return ActiveHandleShape;
    }

    /* JADX INFO: renamed from: getActiveHandleTrailingSpace-D9Ej5fM, reason: not valid java name */
    public final float m3859getActiveHandleTrailingSpaceD9Ej5fM() {
        return ActiveHandleTrailingSpace;
    }

    /* JADX INFO: renamed from: getActiveHandleWidth-D9Ej5fM, reason: not valid java name */
    public final float m3860getActiveHandleWidthD9Ej5fM() {
        return ActiveHandleWidth;
    }

    public final ColorSchemeKeyTokens getActiveTrackColor() {
        return ActiveTrackColor;
    }

    /* JADX INFO: renamed from: getActiveTrackHeight-D9Ej5fM, reason: not valid java name */
    public final float m3861getActiveTrackHeightD9Ej5fM() {
        return ActiveTrackHeight;
    }

    public final ShapeKeyTokens getActiveTrackShape() {
        return ActiveTrackShape;
    }

    public final ShapeKeyTokens getActiveTrackShapeLeading() {
        return ActiveTrackShapeLeading;
    }

    public final ColorSchemeKeyTokens getDisabledActiveTrackColor() {
        return DisabledActiveTrackColor;
    }

    public final float getDisabledActiveTrackOpacity() {
        return DisabledActiveTrackOpacity;
    }

    public final ColorSchemeKeyTokens getDisabledHandleColor() {
        return DisabledHandleColor;
    }

    public final float getDisabledHandleOpacity() {
        return DisabledHandleOpacity;
    }

    /* JADX INFO: renamed from: getDisabledHandleWidth-D9Ej5fM, reason: not valid java name */
    public final float m3862getDisabledHandleWidthD9Ej5fM() {
        return DisabledHandleWidth;
    }

    public final ColorSchemeKeyTokens getDisabledInactiveTrackColor() {
        return DisabledInactiveTrackColor;
    }

    public final float getDisabledInactiveTrackOpacity() {
        return DisabledInactiveTrackOpacity;
    }

    public final ColorSchemeKeyTokens getDisabledStopColor() {
        return DisabledStopColor;
    }

    public final ColorSchemeKeyTokens getFocusActiveTrackColor() {
        return FocusActiveTrackColor;
    }

    /* JADX INFO: renamed from: getFocusHandleWidth-D9Ej5fM, reason: not valid java name */
    public final float m3863getFocusHandleWidthD9Ej5fM() {
        return FocusHandleWidth;
    }

    public final ColorSchemeKeyTokens getFocusInactiveTrackColor() {
        return FocusInactiveTrackColor;
    }

    public final ColorSchemeKeyTokens getFocusStopColor() {
        return FocusStopColor;
    }

    public final ColorSchemeKeyTokens getHandleColor() {
        return HandleColor;
    }

    /* JADX INFO: renamed from: getHandleHeight-D9Ej5fM, reason: not valid java name */
    public final float m3864getHandleHeightD9Ej5fM() {
        return HandleHeight;
    }

    public final ShapeKeyTokens getHandleShape() {
        return HandleShape;
    }

    /* JADX INFO: renamed from: getHandleWidth-D9Ej5fM, reason: not valid java name */
    public final float m3865getHandleWidthD9Ej5fM() {
        return HandleWidth;
    }

    public final ColorSchemeKeyTokens getHoverHandleColor() {
        return HoverHandleColor;
    }

    /* JADX INFO: renamed from: getHoverHandleWidth-D9Ej5fM, reason: not valid java name */
    public final float m3866getHoverHandleWidthD9Ej5fM() {
        return HoverHandleWidth;
    }

    public final ColorSchemeKeyTokens getHoverStopColor() {
        return HoverStopColor;
    }

    public final float getInactiveContainerOpacity() {
        return InactiveContainerOpacity;
    }

    public final ColorSchemeKeyTokens getInactiveTrackColor() {
        return InactiveTrackColor;
    }

    /* JADX INFO: renamed from: getInactiveTrackHeight-D9Ej5fM, reason: not valid java name */
    public final float m3867getInactiveTrackHeightD9Ej5fM() {
        return InactiveTrackHeight;
    }

    public final ShapeKeyTokens getInactiveTrackShape() {
        return InactiveTrackShape;
    }

    public final ColorSchemeKeyTokens getLabelContainerColor() {
        return LabelContainerColor;
    }

    public final ColorSchemeKeyTokens getLabelTextColor() {
        return LabelTextColor;
    }

    public final ColorSchemeKeyTokens getPressedActiveTrackColor() {
        return PressedActiveTrackColor;
    }

    public final ColorSchemeKeyTokens getPressedHandleColor() {
        return PressedHandleColor;
    }

    /* JADX INFO: renamed from: getPressedHandleWidth-D9Ej5fM, reason: not valid java name */
    public final float m3868getPressedHandleWidthD9Ej5fM() {
        return PressedHandleWidth;
    }

    public final ColorSchemeKeyTokens getPressedInactiveTrackColor() {
        return PressedInactiveTrackColor;
    }

    public final ColorSchemeKeyTokens getPressedStopColor() {
        return PressedStopColor;
    }

    public final ColorSchemeKeyTokens getSliderActiveHandleColor() {
        return SliderActiveHandleColor;
    }

    public final ColorSchemeKeyTokens getStopIndicatorColor() {
        return StopIndicatorColor;
    }

    public final ColorSchemeKeyTokens getStopIndicatorColorSelected() {
        return StopIndicatorColorSelected;
    }

    public final ShapeKeyTokens getStopIndicatorShape() {
        return StopIndicatorShape;
    }

    /* JADX INFO: renamed from: getStopIndicatorSize-D9Ej5fM, reason: not valid java name */
    public final float m3869getStopIndicatorSizeD9Ej5fM() {
        return StopIndicatorSize;
    }

    /* JADX INFO: renamed from: getStopIndicatorTrailingSpace-D9Ej5fM, reason: not valid java name */
    public final float m3870getStopIndicatorTrailingSpaceD9Ej5fM() {
        return StopIndicatorTrailingSpace;
    }

    /* JADX INFO: renamed from: getValueIndicatorActiveBottomSpace-D9Ej5fM, reason: not valid java name */
    public final float m3871getValueIndicatorActiveBottomSpaceD9Ej5fM() {
        return ValueIndicatorActiveBottomSpace;
    }

    public final ColorSchemeKeyTokens getValueIndicatorContainerColor() {
        return ValueIndicatorContainerColor;
    }

    public final ColorSchemeKeyTokens getValueIndicatorLabelTextColor() {
        return ValueIndicatorLabelTextColor;
    }

    public final TypographyKeyTokens getValueIndicatorLabelTextFont() {
        return ValueIndicatorLabelTextFont;
    }
}
