package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\bR\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0018\u0010\u000bR\u0014\u0010\u0019\u001a\u00020\u001aX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0014\u0010\u001e\u001a\u00020\u001aX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000bR\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0014\u0010\"\u001a\u00020\u001aX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000bR\u0013\u0010$\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b%\u0010\u000bR\u0011\u0010&\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0011\u0010(\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0013\u0010*\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b+\u0010\u000bR\u0011\u0010,\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u0011\u0010.\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u0011\u00100\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u0013\u00102\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b3\u0010\u000bR\u0013\u00104\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b5\u0010\u000bR\u0011\u00106\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0007R\u0011\u00108\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0007R\u0011\u0010:\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0007R\u0013\u0010<\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b=\u0010\u000bR\u0013\u0010>\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b?\u0010\u000bR\u0011\u0010@\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0012R\u0011\u0010B\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0007R\u0011\u0010D\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0007R\u0011\u0010F\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0007R\u0011\u0010H\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0012R\u0011\u0010J\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u0012R\u0011\u0010L\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0007R\u0011\u0010N\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0007R\u0011\u0010P\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0007R\u0011\u0010R\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0007R\u0011\u0010T\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0007R\u0011\u0010V\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0007R\u0011\u0010X\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0007R\u0013\u0010Z\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b[\u0010\u000bR\u0011\u0010\\\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u0007R\u0011\u0010^\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b_\u0010\u0007R\u0011\u0010`\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u0007R\u0011\u0010b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\u0007R\u0011\u0010d\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\be\u0010\u0007R\u0011\u0010f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\u0007R\u0011\u0010h\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\u0007R\u0011\u0010j\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bk\u0010\u0007¨\u0006l"}, d2 = {"Landroidx/compose/material3/tokens/BaselineButtonTokens;", "", "<init>", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", FaceService.girlLabel, "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerShapeRound", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShapeRound", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ContainerShapeSquare", "getContainerShapeSquare", "DisabledContainerColor", "getDisabledContainerColor", "DisabledContainerElevation", "getDisabledContainerElevation-D9Ej5fM", "DisabledContainerOpacity", "", "getDisabledContainerOpacity", "DisabledIconColor", "getDisabledIconColor", "DisabledIconOpacity", "getDisabledIconOpacity", "DisabledLabelTextColor", "getDisabledLabelTextColor", "DisabledLabelTextOpacity", "getDisabledLabelTextOpacity", "FocusedContainerElevation", "getFocusedContainerElevation-D9Ej5fM", "FocusedIconColor", "getFocusedIconColor", "FocusedLabelTextColor", "getFocusedLabelTextColor", "HoveredContainerElevation", "getHoveredContainerElevation-D9Ej5fM", "HoveredIconColor", "getHoveredIconColor", "HoveredLabelTextColor", "getHoveredLabelTextColor", "IconColor", "getIconColor", "IconLabelSpace", "getIconLabelSpace-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "LabelTextColor", "getLabelTextColor", "LabelTextSelectedColor", "getLabelTextSelectedColor", "LabelTextUnselectedColor", "getLabelTextUnselectedColor", "LeadingSpace", "getLeadingSpace-D9Ej5fM", "PressedContainerElevation", "getPressedContainerElevation-D9Ej5fM", "PressedContainerShape", "getPressedContainerShape", "PressedIconColor", "getPressedIconColor", "PressedLabelTextColor", "getPressedLabelTextColor", "SelectedContainerColor", "getSelectedContainerColor", "SelectedContainerShapeRound", "getSelectedContainerShapeRound", "SelectedContainerShapeSquare", "getSelectedContainerShapeSquare", "SelectedFocusedIconColor", "getSelectedFocusedIconColor", "SelectedFocusedLabelTextColor", "getSelectedFocusedLabelTextColor", "SelectedHoveredIconColor", "getSelectedHoveredIconColor", "SelectedHoveredLabelTextColor", "getSelectedHoveredLabelTextColor", "SelectedIconColor", "getSelectedIconColor", "SelectedPressedIconColor", "getSelectedPressedIconColor", "SelectedPressedLabelTextColor", "getSelectedPressedLabelTextColor", "TrailingSpace", "getTrailingSpace-D9Ej5fM", "UnselectedContainerColor", "getUnselectedContainerColor", "UnselectedFocusedIconColor", "getUnselectedFocusedIconColor", "UnselectedFocusedLabelTextColor", "getUnselectedFocusedLabelTextColor", "UnselectedHoveredIconColor", "getUnselectedHoveredIconColor", "UnselectedHoveredLabelTextColor", "getUnselectedHoveredLabelTextColor", "UnselectedIconColor", "getUnselectedIconColor", "UnselectedPressedIconColor", "getUnselectedPressedIconColor", "UnselectedPressedLabelTextColor", "getUnselectedPressedLabelTextColor", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BaselineButtonTokens {
    public static final int $stable = 0;
    private static final ColorSchemeKeyTokens ContainerColor = null;
    private static final float ContainerElevation = 0.0f;
    private static final float ContainerHeight = 0.0f;
    private static final ShapeKeyTokens ContainerShapeRound = null;
    private static final ShapeKeyTokens ContainerShapeSquare = null;
    private static final ColorSchemeKeyTokens DisabledContainerColor = null;
    private static final float DisabledContainerElevation = 0.0f;
    private static final float DisabledContainerOpacity = 0.0f;
    private static final ColorSchemeKeyTokens DisabledIconColor = null;
    private static final float DisabledIconOpacity = 0.0f;
    private static final ColorSchemeKeyTokens DisabledLabelTextColor = null;
    private static final float DisabledLabelTextOpacity = 0.0f;
    private static final float FocusedContainerElevation = 0.0f;
    private static final ColorSchemeKeyTokens FocusedIconColor = null;
    private static final ColorSchemeKeyTokens FocusedLabelTextColor = null;
    private static final float HoveredContainerElevation = 0.0f;
    private static final ColorSchemeKeyTokens HoveredIconColor = null;
    private static final ColorSchemeKeyTokens HoveredLabelTextColor = null;
    public static final BaselineButtonTokens INSTANCE = null;
    private static final ColorSchemeKeyTokens IconColor = null;
    private static final float IconLabelSpace = 0.0f;
    private static final float IconSize = 0.0f;
    private static final ColorSchemeKeyTokens LabelTextColor = null;
    private static final ColorSchemeKeyTokens LabelTextSelectedColor = null;
    private static final ColorSchemeKeyTokens LabelTextUnselectedColor = null;
    private static final float LeadingSpace = 0.0f;
    private static final float PressedContainerElevation = 0.0f;
    private static final ShapeKeyTokens PressedContainerShape = null;
    private static final ColorSchemeKeyTokens PressedIconColor = null;
    private static final ColorSchemeKeyTokens PressedLabelTextColor = null;
    private static final ColorSchemeKeyTokens SelectedContainerColor = null;
    private static final ShapeKeyTokens SelectedContainerShapeRound = null;
    private static final ShapeKeyTokens SelectedContainerShapeSquare = null;
    private static final ColorSchemeKeyTokens SelectedFocusedIconColor = null;
    private static final ColorSchemeKeyTokens SelectedFocusedLabelTextColor = null;
    private static final ColorSchemeKeyTokens SelectedHoveredIconColor = null;
    private static final ColorSchemeKeyTokens SelectedHoveredLabelTextColor = null;
    private static final ColorSchemeKeyTokens SelectedIconColor = null;
    private static final ColorSchemeKeyTokens SelectedPressedIconColor = null;
    private static final ColorSchemeKeyTokens SelectedPressedLabelTextColor = null;
    private static final float TrailingSpace = 0.0f;
    private static final ColorSchemeKeyTokens UnselectedContainerColor = null;
    private static final ColorSchemeKeyTokens UnselectedFocusedIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedFocusedLabelTextColor = null;
    private static final ColorSchemeKeyTokens UnselectedHoveredIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedHoveredLabelTextColor = null;
    private static final ColorSchemeKeyTokens UnselectedIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedPressedIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedPressedLabelTextColor = null;

    private BaselineButtonTokens() {
    }

    static {
        INSTANCE = new BaselineButtonTokens();
        ColorSchemeKeyTokens r100 = ColorSchemeKeyTokens.Primary;
        ContainerColor = r100;
        ElevationTokens r101 = ElevationTokens.INSTANCE;
        ContainerElevation = r101.m3498getLevel0D9Ej5fM();
        ContainerHeight = Dp.m7544constructorimpl((float) 40.0d);
        ShapeKeyTokens r102 = ShapeKeyTokens.CornerFull;
        ContainerShapeRound = r102;
        ShapeKeyTokens r103 = ShapeKeyTokens.CornerMedium;
        ContainerShapeSquare = r103;
        DisabledContainerColor = ColorSchemeKeyTokens.OnSurface;
        DisabledContainerElevation = r101.m3498getLevel0D9Ej5fM();
        DisabledContainerOpacity = 0.1f;
        ColorSchemeKeyTokens r104 = ColorSchemeKeyTokens.OnSurfaceVariant;
        DisabledIconColor = r104;
        DisabledIconOpacity = 0.38f;
        DisabledLabelTextColor = r104;
        DisabledLabelTextOpacity = 0.38f;
        FocusedContainerElevation = r101.m3498getLevel0D9Ej5fM();
        ColorSchemeKeyTokens r105 = ColorSchemeKeyTokens.OnPrimary;
        FocusedIconColor = r105;
        FocusedLabelTextColor = r105;
        HoveredContainerElevation = r101.m3499getLevel1D9Ej5fM();
        HoveredIconColor = r105;
        HoveredLabelTextColor = r105;
        IconColor = r105;
        IconLabelSpace = Dp.m7544constructorimpl((float) 8.0d);
        IconSize = Dp.m7544constructorimpl((float) 20.0d);
        LabelTextColor = r105;
        LabelTextSelectedColor = r105;
        LabelTextUnselectedColor = r104;
        float r106 = (float) 24.0d;
        LeadingSpace = Dp.m7544constructorimpl(r106);
        PressedContainerElevation = r101.m3498getLevel0D9Ej5fM();
        PressedContainerShape = ShapeKeyTokens.CornerSmall;
        PressedIconColor = r105;
        PressedLabelTextColor = r105;
        SelectedContainerColor = r100;
        SelectedContainerShapeRound = r102;
        SelectedContainerShapeSquare = r103;
        SelectedFocusedIconColor = r105;
        SelectedFocusedLabelTextColor = r105;
        SelectedHoveredIconColor = r105;
        SelectedHoveredLabelTextColor = r105;
        SelectedIconColor = r105;
        SelectedPressedIconColor = r105;
        SelectedPressedLabelTextColor = r105;
        TrailingSpace = Dp.m7544constructorimpl(r106);
        UnselectedContainerColor = ColorSchemeKeyTokens.SurfaceContainer;
        UnselectedFocusedIconColor = r104;
        UnselectedFocusedLabelTextColor = r104;
        UnselectedHoveredIconColor = r104;
        UnselectedHoveredLabelTextColor = r104;
        UnselectedIconColor = r104;
        UnselectedPressedIconColor = r104;
        UnselectedPressedLabelTextColor = r104;
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    /* JADX INFO: renamed from: getContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3277getContainerElevationD9Ej5fM() {
        return ContainerElevation;
    }

    /* JADX INFO: renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3278getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    public final ShapeKeyTokens getContainerShapeRound() {
        return ContainerShapeRound;
    }

    public final ShapeKeyTokens getContainerShapeSquare() {
        return ContainerShapeSquare;
    }

    public final ColorSchemeKeyTokens getDisabledContainerColor() {
        return DisabledContainerColor;
    }

    /* JADX INFO: renamed from: getDisabledContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3279getDisabledContainerElevationD9Ej5fM() {
        return DisabledContainerElevation;
    }

    public final float getDisabledContainerOpacity() {
        return DisabledContainerOpacity;
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

    /* JADX INFO: renamed from: getFocusedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3280getFocusedContainerElevationD9Ej5fM() {
        return FocusedContainerElevation;
    }

    public final ColorSchemeKeyTokens getFocusedIconColor() {
        return FocusedIconColor;
    }

    public final ColorSchemeKeyTokens getFocusedLabelTextColor() {
        return FocusedLabelTextColor;
    }

    /* JADX INFO: renamed from: getHoveredContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3281getHoveredContainerElevationD9Ej5fM() {
        return HoveredContainerElevation;
    }

    public final ColorSchemeKeyTokens getHoveredIconColor() {
        return HoveredIconColor;
    }

    public final ColorSchemeKeyTokens getHoveredLabelTextColor() {
        return HoveredLabelTextColor;
    }

    public final ColorSchemeKeyTokens getIconColor() {
        return IconColor;
    }

    /* JADX INFO: renamed from: getIconLabelSpace-D9Ej5fM, reason: not valid java name */
    public final float m3282getIconLabelSpaceD9Ej5fM() {
        return IconLabelSpace;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3283getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final ColorSchemeKeyTokens getLabelTextColor() {
        return LabelTextColor;
    }

    public final ColorSchemeKeyTokens getLabelTextSelectedColor() {
        return LabelTextSelectedColor;
    }

    public final ColorSchemeKeyTokens getLabelTextUnselectedColor() {
        return LabelTextUnselectedColor;
    }

    /* JADX INFO: renamed from: getLeadingSpace-D9Ej5fM, reason: not valid java name */
    public final float m3284getLeadingSpaceD9Ej5fM() {
        return LeadingSpace;
    }

    /* JADX INFO: renamed from: getPressedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3285getPressedContainerElevationD9Ej5fM() {
        return PressedContainerElevation;
    }

    public final ShapeKeyTokens getPressedContainerShape() {
        return PressedContainerShape;
    }

    public final ColorSchemeKeyTokens getPressedIconColor() {
        return PressedIconColor;
    }

    public final ColorSchemeKeyTokens getPressedLabelTextColor() {
        return PressedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getSelectedContainerColor() {
        return SelectedContainerColor;
    }

    public final ShapeKeyTokens getSelectedContainerShapeRound() {
        return SelectedContainerShapeRound;
    }

    public final ShapeKeyTokens getSelectedContainerShapeSquare() {
        return SelectedContainerShapeSquare;
    }

    public final ColorSchemeKeyTokens getSelectedFocusedIconColor() {
        return SelectedFocusedIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedFocusedLabelTextColor() {
        return SelectedFocusedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getSelectedHoveredIconColor() {
        return SelectedHoveredIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedHoveredLabelTextColor() {
        return SelectedHoveredLabelTextColor;
    }

    public final ColorSchemeKeyTokens getSelectedIconColor() {
        return SelectedIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedPressedIconColor() {
        return SelectedPressedIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedPressedLabelTextColor() {
        return SelectedPressedLabelTextColor;
    }

    /* JADX INFO: renamed from: getTrailingSpace-D9Ej5fM, reason: not valid java name */
    public final float m3286getTrailingSpaceD9Ej5fM() {
        return TrailingSpace;
    }

    public final ColorSchemeKeyTokens getUnselectedContainerColor() {
        return UnselectedContainerColor;
    }

    public final ColorSchemeKeyTokens getUnselectedFocusedIconColor() {
        return UnselectedFocusedIconColor;
    }

    public final ColorSchemeKeyTokens getUnselectedFocusedLabelTextColor() {
        return UnselectedFocusedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getUnselectedHoveredIconColor() {
        return UnselectedHoveredIconColor;
    }

    public final ColorSchemeKeyTokens getUnselectedHoveredLabelTextColor() {
        return UnselectedHoveredLabelTextColor;
    }

    public final ColorSchemeKeyTokens getUnselectedIconColor() {
        return UnselectedIconColor;
    }

    public final ColorSchemeKeyTokens getUnselectedPressedIconColor() {
        return UnselectedPressedIconColor;
    }

    public final ColorSchemeKeyTokens getUnselectedPressedLabelTextColor() {
        return UnselectedPressedLabelTextColor;
    }
}
