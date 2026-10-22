package androidx.compose.material3.tokens;

import androidx.camera.video.AudioStats;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b[\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u0014X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0014\u0010\u001c\u001a\u00020\u0014X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0013\u0010\u001e\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0012R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0012R\u0011\u0010(\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0012R\u0011\u0010*\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0012R\u0011\u0010,\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0012R\u0011\u0010.\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0012R\u0013\u00100\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b1\u0010\u0007R\u0011\u00102\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0012R\u0011\u00104\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0012R\u0011\u00106\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0012R\u0011\u00108\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0012R\u0011\u0010:\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0012R\u0011\u0010<\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0012R\u0011\u0010>\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0012R\u0013\u0010@\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bA\u0010\u0007R\u0011\u0010B\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0012R\u0011\u0010D\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u000eR\u0013\u0010F\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bG\u0010\u0007R\u0014\u0010H\u001a\u00020\u0014X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0007R\u0011\u0010J\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u0012R\u0014\u0010L\u001a\u00020\u0014X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0007R\u0013\u0010N\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bO\u0010\u0007R\u0011\u0010P\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0012R\u0011\u0010R\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0012R\u0011\u0010T\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0012R\u0011\u0010V\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0012R\u0011\u0010X\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0012R\u0011\u0010Z\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u0012R\u0011\u0010\\\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u0012R\u0011\u0010^\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b_\u0010\u0012R\u0011\u0010`\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u0012R\u0011\u0010b\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\u0012R\u0011\u0010d\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\be\u0010\u0012R\u0014\u0010f\u001a\u00020\u0014X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\u0007R\u0011\u0010h\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\u0012R\u0011\u0010j\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bk\u0010\u0012R\u0011\u0010l\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\u0012R\u0011\u0010n\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u0012R\u0011\u0010p\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\u0012R\u0013\u0010r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bs\u0010\u0007R\u0011\u0010t\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bu\u0010\u0012R\u0011\u0010v\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bw\u0010\u0012R\u0011\u0010x\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\by\u0010\u0012R\u0011\u0010z\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b{\u0010\u0012R\u0011\u0010|\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b}\u0010\u0012¨\u0006~"}, d2 = {"Landroidx/compose/material3/tokens/InputChipTokens;", "", "<init>", "()V", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", FaceService.girlLabel, "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "DisabledLabelTextColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getDisabledLabelTextColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "DisabledLabelTextOpacity", "", "getDisabledLabelTextOpacity", "DisabledSelectedContainerColor", "getDisabledSelectedContainerColor", "DisabledSelectedContainerOpacity", "getDisabledSelectedContainerOpacity", "DisabledUnselectedOutlineColor", "getDisabledUnselectedOutlineColor", "DisabledUnselectedOutlineOpacity", "getDisabledUnselectedOutlineOpacity", "DraggedContainerElevation", "getDraggedContainerElevation-D9Ej5fM", "FocusIndicatorColor", "getFocusIndicatorColor", "LabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "SelectedContainerColor", "getSelectedContainerColor", "SelectedDraggedLabelTextColor", "getSelectedDraggedLabelTextColor", "SelectedFocusLabelTextColor", "getSelectedFocusLabelTextColor", "SelectedHoverLabelTextColor", "getSelectedHoverLabelTextColor", "SelectedLabelTextColor", "getSelectedLabelTextColor", "SelectedOutlineWidth", "getSelectedOutlineWidth-D9Ej5fM", "SelectedPressedLabelTextColor", "getSelectedPressedLabelTextColor", "UnselectedDraggedLabelTextColor", "getUnselectedDraggedLabelTextColor", "UnselectedFocusLabelTextColor", "getUnselectedFocusLabelTextColor", "UnselectedFocusOutlineColor", "getUnselectedFocusOutlineColor", "UnselectedHoverLabelTextColor", "getUnselectedHoverLabelTextColor", "UnselectedLabelTextColor", "getUnselectedLabelTextColor", "UnselectedOutlineColor", "getUnselectedOutlineColor", "UnselectedOutlineWidth", "getUnselectedOutlineWidth-D9Ej5fM", "UnselectedPressedLabelTextColor", "getUnselectedPressedLabelTextColor", "AvatarShape", "getAvatarShape", "AvatarSize", "getAvatarSize-D9Ej5fM", "DisabledAvatarOpacity", "getDisabledAvatarOpacity", "DisabledLeadingIconColor", "getDisabledLeadingIconColor", "DisabledLeadingIconOpacity", "getDisabledLeadingIconOpacity", "LeadingIconSize", "getLeadingIconSize-D9Ej5fM", "SelectedDraggedLeadingIconColor", "getSelectedDraggedLeadingIconColor", "SelectedFocusLeadingIconColor", "getSelectedFocusLeadingIconColor", "SelectedHoverLeadingIconColor", "getSelectedHoverLeadingIconColor", "SelectedLeadingIconColor", "getSelectedLeadingIconColor", "SelectedPressedLeadingIconColor", "getSelectedPressedLeadingIconColor", "UnselectedDraggedLeadingIconColor", "getUnselectedDraggedLeadingIconColor", "UnselectedFocusLeadingIconColor", "getUnselectedFocusLeadingIconColor", "UnselectedHoverLeadingIconColor", "getUnselectedHoverLeadingIconColor", "UnselectedLeadingIconColor", "getUnselectedLeadingIconColor", "UnselectedPressedLeadingIconColor", "getUnselectedPressedLeadingIconColor", "DisabledTrailingIconColor", "getDisabledTrailingIconColor", "DisabledTrailingIconOpacity", "getDisabledTrailingIconOpacity", "SelectedDraggedTrailingIconColor", "getSelectedDraggedTrailingIconColor", "SelectedFocusTrailingIconColor", "getSelectedFocusTrailingIconColor", "SelectedHoverTrailingIconColor", "getSelectedHoverTrailingIconColor", "SelectedPressedTrailingIconColor", "getSelectedPressedTrailingIconColor", "SelectedTrailingIconColor", "getSelectedTrailingIconColor", "TrailingIconSize", "getTrailingIconSize-D9Ej5fM", "UnselectedDraggedTrailingIconColor", "getUnselectedDraggedTrailingIconColor", "UnselectedFocusTrailingIconColor", "getUnselectedFocusTrailingIconColor", "UnselectedHoverTrailingIconColor", "getUnselectedHoverTrailingIconColor", "UnselectedPressedTrailingIconColor", "getUnselectedPressedTrailingIconColor", "UnselectedTrailingIconColor", "getUnselectedTrailingIconColor", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InputChipTokens {
    public static final int $stable = 0;
    private static final ShapeKeyTokens AvatarShape = null;
    private static final float AvatarSize = 0.0f;
    private static final float ContainerElevation = 0.0f;
    private static final float ContainerHeight = 0.0f;
    private static final ShapeKeyTokens ContainerShape = null;
    private static final float DisabledAvatarOpacity = 0.0f;
    private static final ColorSchemeKeyTokens DisabledLabelTextColor = null;
    private static final float DisabledLabelTextOpacity = 0.0f;
    private static final ColorSchemeKeyTokens DisabledLeadingIconColor = null;
    private static final float DisabledLeadingIconOpacity = 0.0f;
    private static final ColorSchemeKeyTokens DisabledSelectedContainerColor = null;
    private static final float DisabledSelectedContainerOpacity = 0.0f;
    private static final ColorSchemeKeyTokens DisabledTrailingIconColor = null;
    private static final float DisabledTrailingIconOpacity = 0.0f;
    private static final ColorSchemeKeyTokens DisabledUnselectedOutlineColor = null;
    private static final float DisabledUnselectedOutlineOpacity = 0.0f;
    private static final float DraggedContainerElevation = 0.0f;
    private static final ColorSchemeKeyTokens FocusIndicatorColor = null;
    public static final InputChipTokens INSTANCE = null;
    private static final TypographyKeyTokens LabelTextFont = null;
    private static final float LeadingIconSize = 0.0f;
    private static final ColorSchemeKeyTokens SelectedContainerColor = null;
    private static final ColorSchemeKeyTokens SelectedDraggedLabelTextColor = null;
    private static final ColorSchemeKeyTokens SelectedDraggedLeadingIconColor = null;
    private static final ColorSchemeKeyTokens SelectedDraggedTrailingIconColor = null;
    private static final ColorSchemeKeyTokens SelectedFocusLabelTextColor = null;
    private static final ColorSchemeKeyTokens SelectedFocusLeadingIconColor = null;
    private static final ColorSchemeKeyTokens SelectedFocusTrailingIconColor = null;
    private static final ColorSchemeKeyTokens SelectedHoverLabelTextColor = null;
    private static final ColorSchemeKeyTokens SelectedHoverLeadingIconColor = null;
    private static final ColorSchemeKeyTokens SelectedHoverTrailingIconColor = null;
    private static final ColorSchemeKeyTokens SelectedLabelTextColor = null;
    private static final ColorSchemeKeyTokens SelectedLeadingIconColor = null;
    private static final float SelectedOutlineWidth = 0.0f;
    private static final ColorSchemeKeyTokens SelectedPressedLabelTextColor = null;
    private static final ColorSchemeKeyTokens SelectedPressedLeadingIconColor = null;
    private static final ColorSchemeKeyTokens SelectedPressedTrailingIconColor = null;
    private static final ColorSchemeKeyTokens SelectedTrailingIconColor = null;
    private static final float TrailingIconSize = 0.0f;
    private static final ColorSchemeKeyTokens UnselectedDraggedLabelTextColor = null;
    private static final ColorSchemeKeyTokens UnselectedDraggedLeadingIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedDraggedTrailingIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedFocusLabelTextColor = null;
    private static final ColorSchemeKeyTokens UnselectedFocusLeadingIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedFocusOutlineColor = null;
    private static final ColorSchemeKeyTokens UnselectedFocusTrailingIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedHoverLabelTextColor = null;
    private static final ColorSchemeKeyTokens UnselectedHoverLeadingIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedHoverTrailingIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedLabelTextColor = null;
    private static final ColorSchemeKeyTokens UnselectedLeadingIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedOutlineColor = null;
    private static final float UnselectedOutlineWidth = 0.0f;
    private static final ColorSchemeKeyTokens UnselectedPressedLabelTextColor = null;
    private static final ColorSchemeKeyTokens UnselectedPressedLeadingIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedPressedTrailingIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedTrailingIconColor = null;

    private InputChipTokens() {
    }

    static {
        INSTANCE = new InputChipTokens();
        ElevationTokens r100 = ElevationTokens.INSTANCE;
        ContainerElevation = r100.m3498getLevel0D9Ej5fM();
        ContainerHeight = Dp.m7544constructorimpl((float) 32.0d);
        ContainerShape = ShapeKeyTokens.CornerSmall;
        ColorSchemeKeyTokens r101 = ColorSchemeKeyTokens.OnSurface;
        DisabledLabelTextColor = r101;
        DisabledLabelTextOpacity = 0.38f;
        DisabledSelectedContainerColor = r101;
        DisabledSelectedContainerOpacity = 0.12f;
        DisabledUnselectedOutlineColor = r101;
        DisabledUnselectedOutlineOpacity = 0.12f;
        DraggedContainerElevation = r100.m3502getLevel4D9Ej5fM();
        FocusIndicatorColor = ColorSchemeKeyTokens.Secondary;
        LabelTextFont = TypographyKeyTokens.LabelLarge;
        SelectedContainerColor = ColorSchemeKeyTokens.SecondaryContainer;
        ColorSchemeKeyTokens r102 = ColorSchemeKeyTokens.OnSecondaryContainer;
        SelectedDraggedLabelTextColor = r102;
        SelectedFocusLabelTextColor = r102;
        SelectedHoverLabelTextColor = r102;
        SelectedLabelTextColor = r102;
        SelectedOutlineWidth = Dp.m7544constructorimpl((float) AudioStats.AUDIO_AMPLITUDE_NONE);
        SelectedPressedLabelTextColor = r102;
        ColorSchemeKeyTokens r103 = ColorSchemeKeyTokens.OnSurfaceVariant;
        UnselectedDraggedLabelTextColor = r103;
        UnselectedFocusLabelTextColor = r103;
        UnselectedFocusOutlineColor = r103;
        UnselectedHoverLabelTextColor = r103;
        UnselectedLabelTextColor = r103;
        UnselectedOutlineColor = ColorSchemeKeyTokens.OutlineVariant;
        UnselectedOutlineWidth = Dp.m7544constructorimpl((float) 1.0d);
        UnselectedPressedLabelTextColor = r103;
        AvatarShape = ShapeKeyTokens.CornerFull;
        AvatarSize = Dp.m7544constructorimpl((float) 24.0d);
        DisabledAvatarOpacity = 0.38f;
        DisabledLeadingIconColor = r101;
        DisabledLeadingIconOpacity = 0.38f;
        float r104 = (float) 18.0d;
        LeadingIconSize = Dp.m7544constructorimpl(r104);
        SelectedDraggedLeadingIconColor = r102;
        ColorSchemeKeyTokens r105 = ColorSchemeKeyTokens.Primary;
        SelectedFocusLeadingIconColor = r105;
        SelectedHoverLeadingIconColor = r105;
        SelectedLeadingIconColor = r105;
        SelectedPressedLeadingIconColor = r105;
        UnselectedDraggedLeadingIconColor = r103;
        UnselectedFocusLeadingIconColor = r105;
        UnselectedHoverLeadingIconColor = r105;
        UnselectedLeadingIconColor = r103;
        UnselectedPressedLeadingIconColor = r105;
        DisabledTrailingIconColor = r101;
        DisabledTrailingIconOpacity = 0.38f;
        SelectedDraggedTrailingIconColor = r105;
        SelectedFocusTrailingIconColor = r102;
        SelectedHoverTrailingIconColor = r102;
        SelectedPressedTrailingIconColor = r102;
        SelectedTrailingIconColor = r102;
        TrailingIconSize = Dp.m7544constructorimpl(r104);
        UnselectedDraggedTrailingIconColor = r105;
        UnselectedFocusTrailingIconColor = r103;
        UnselectedHoverTrailingIconColor = r103;
        UnselectedPressedTrailingIconColor = r103;
        UnselectedTrailingIconColor = r103;
    }

    public final ShapeKeyTokens getAvatarShape() {
        return AvatarShape;
    }

    /* JADX INFO: renamed from: getAvatarSize-D9Ej5fM, reason: not valid java name */
    public final float m3615getAvatarSizeD9Ej5fM() {
        return AvatarSize;
    }

    /* JADX INFO: renamed from: getContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3616getContainerElevationD9Ej5fM() {
        return ContainerElevation;
    }

    /* JADX INFO: renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3617getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    public final float getDisabledAvatarOpacity() {
        return DisabledAvatarOpacity;
    }

    public final ColorSchemeKeyTokens getDisabledLabelTextColor() {
        return DisabledLabelTextColor;
    }

    public final float getDisabledLabelTextOpacity() {
        return DisabledLabelTextOpacity;
    }

    public final ColorSchemeKeyTokens getDisabledLeadingIconColor() {
        return DisabledLeadingIconColor;
    }

    public final float getDisabledLeadingIconOpacity() {
        return DisabledLeadingIconOpacity;
    }

    public final ColorSchemeKeyTokens getDisabledSelectedContainerColor() {
        return DisabledSelectedContainerColor;
    }

    public final float getDisabledSelectedContainerOpacity() {
        return DisabledSelectedContainerOpacity;
    }

    public final ColorSchemeKeyTokens getDisabledTrailingIconColor() {
        return DisabledTrailingIconColor;
    }

    public final float getDisabledTrailingIconOpacity() {
        return DisabledTrailingIconOpacity;
    }

    public final ColorSchemeKeyTokens getDisabledUnselectedOutlineColor() {
        return DisabledUnselectedOutlineColor;
    }

    public final float getDisabledUnselectedOutlineOpacity() {
        return DisabledUnselectedOutlineOpacity;
    }

    /* JADX INFO: renamed from: getDraggedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3618getDraggedContainerElevationD9Ej5fM() {
        return DraggedContainerElevation;
    }

    public final ColorSchemeKeyTokens getFocusIndicatorColor() {
        return FocusIndicatorColor;
    }

    public final TypographyKeyTokens getLabelTextFont() {
        return LabelTextFont;
    }

    /* JADX INFO: renamed from: getLeadingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3619getLeadingIconSizeD9Ej5fM() {
        return LeadingIconSize;
    }

    public final ColorSchemeKeyTokens getSelectedContainerColor() {
        return SelectedContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectedDraggedLabelTextColor() {
        return SelectedDraggedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getSelectedDraggedLeadingIconColor() {
        return SelectedDraggedLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedDraggedTrailingIconColor() {
        return SelectedDraggedTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedFocusLabelTextColor() {
        return SelectedFocusLabelTextColor;
    }

    public final ColorSchemeKeyTokens getSelectedFocusLeadingIconColor() {
        return SelectedFocusLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedFocusTrailingIconColor() {
        return SelectedFocusTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedHoverLabelTextColor() {
        return SelectedHoverLabelTextColor;
    }

    public final ColorSchemeKeyTokens getSelectedHoverLeadingIconColor() {
        return SelectedHoverLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedHoverTrailingIconColor() {
        return SelectedHoverTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedLabelTextColor() {
        return SelectedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getSelectedLeadingIconColor() {
        return SelectedLeadingIconColor;
    }

    /* JADX INFO: renamed from: getSelectedOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m3620getSelectedOutlineWidthD9Ej5fM() {
        return SelectedOutlineWidth;
    }

    public final ColorSchemeKeyTokens getSelectedPressedLabelTextColor() {
        return SelectedPressedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getSelectedPressedLeadingIconColor() {
        return SelectedPressedLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedPressedTrailingIconColor() {
        return SelectedPressedTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedTrailingIconColor() {
        return SelectedTrailingIconColor;
    }

    /* JADX INFO: renamed from: getTrailingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3621getTrailingIconSizeD9Ej5fM() {
        return TrailingIconSize;
    }

    public final ColorSchemeKeyTokens getUnselectedDraggedLabelTextColor() {
        return UnselectedDraggedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getUnselectedDraggedLeadingIconColor() {
        return UnselectedDraggedLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getUnselectedDraggedTrailingIconColor() {
        return UnselectedDraggedTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getUnselectedFocusLabelTextColor() {
        return UnselectedFocusLabelTextColor;
    }

    public final ColorSchemeKeyTokens getUnselectedFocusLeadingIconColor() {
        return UnselectedFocusLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getUnselectedFocusOutlineColor() {
        return UnselectedFocusOutlineColor;
    }

    public final ColorSchemeKeyTokens getUnselectedFocusTrailingIconColor() {
        return UnselectedFocusTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getUnselectedHoverLabelTextColor() {
        return UnselectedHoverLabelTextColor;
    }

    public final ColorSchemeKeyTokens getUnselectedHoverLeadingIconColor() {
        return UnselectedHoverLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getUnselectedHoverTrailingIconColor() {
        return UnselectedHoverTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getUnselectedLabelTextColor() {
        return UnselectedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getUnselectedLeadingIconColor() {
        return UnselectedLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getUnselectedOutlineColor() {
        return UnselectedOutlineColor;
    }

    /* JADX INFO: renamed from: getUnselectedOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m3622getUnselectedOutlineWidthD9Ej5fM() {
        return UnselectedOutlineWidth;
    }

    public final ColorSchemeKeyTokens getUnselectedPressedLabelTextColor() {
        return UnselectedPressedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getUnselectedPressedLeadingIconColor() {
        return UnselectedPressedLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getUnselectedPressedTrailingIconColor() {
        return UnselectedPressedTrailingIconColor;
    }

    public final ColorSchemeKeyTokens getUnselectedTrailingIconColor() {
        return UnselectedTrailingIconColor;
    }
}
