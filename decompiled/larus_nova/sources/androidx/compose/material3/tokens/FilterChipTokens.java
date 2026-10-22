package androidx.compose.material3.tokens;

import androidx.camera.video.AudioStats;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\bI\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0013\u0010\u0014\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0015\u0010\u0007R\u0013\u0010\u0016\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0013\u0010\u001a\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001b\u0010\u0007R\u0014\u0010\u001c\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0013\u0010\u001e\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001f\u0010\u0007R\u0013\u0010 \u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b!\u0010\u0007R\u0013\u0010\"\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b#\u0010\u0007R\u0011\u0010$\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0010R\u0011\u0010&\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0010R\u0013\u0010(\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b)\u0010\u0007R\u0011\u0010*\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0010R\u0014\u0010,\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u0011\u0010.\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0010R\u0014\u00100\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u0011\u00102\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0010R\u0013\u00104\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b5\u0010\u0007R\u0013\u00106\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b7\u0010\u0007R\u0013\u00108\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b9\u0010\u0007R\u0013\u0010:\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b;\u0010\u0007R\u0013\u0010<\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b=\u0010\u0007R\u0011\u0010>\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0010R\u0013\u0010@\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bA\u0010\u0007R\u0011\u0010B\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0010R\u0013\u0010D\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bE\u0010\u0007R\u0013\u0010F\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bG\u0010\u0007R\u0011\u0010H\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0010R\u0011\u0010J\u001a\u00020K¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010N\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0010R\u0011\u0010P\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0010R\u0011\u0010R\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0010R\u0011\u0010T\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0010R\u0011\u0010V\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0010R\u0011\u0010X\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0010R\u0011\u0010Z\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u0010R\u0011\u0010\\\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u0010R\u0011\u0010^\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b_\u0010\u0010R\u0011\u0010`\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u0010R\u0013\u0010b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\bc\u0010\u0007R\u0011\u0010d\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\be\u0010\u0010R\u0014\u0010f\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\u0007R\u0011\u0010h\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\u0010R\u0011\u0010j\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bk\u0010\u0010R\u0011\u0010l\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\u0010R\u0011\u0010n\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u0010R\u0011\u0010p\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\u0010R\u0011\u0010r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\u0010R\u0011\u0010t\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bu\u0010\u0010R\u0011\u0010v\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bw\u0010\u0010R\u0011\u0010x\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\by\u0010\u0010R\u0011\u0010z\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b{\u0010\u0010R\u0011\u0010|\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b}\u0010\u0010R\u0014\u0010~\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010\u0007R\u0013\u0010\u0080\u0001\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0010R\u0013\u0010\u0082\u0001\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u0010R\u0013\u0010\u0084\u0001\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010\u0010R\u0013\u0010\u0086\u0001\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010\u0010R\u0013\u0010\u0088\u0001\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010\u0010R\u0013\u0010\u008a\u0001\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010\u0010R\u0013\u0010\u008c\u0001\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010\u0010R\u0013\u0010\u008e\u0001\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010\u0010R\u0013\u0010\u0090\u0001\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0091\u0001\u0010\u0010R\u0013\u0010\u0092\u0001\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0093\u0001\u0010\u0010¨\u0006\u0094\u0001"}, d2 = {"Landroidx/compose/material3/tokens/FilterChipTokens;", "", "<init>", "()V", "ContainerHeight", "Landroidx/compose/ui/unit/Dp;", "getContainerHeight-D9Ej5fM", "()F", FaceService.girlLabel, "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "DisabledLabelTextColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getDisabledLabelTextColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "DisabledLabelTextOpacity", "", "getDisabledLabelTextOpacity", "DraggedContainerElevation", "getDraggedContainerElevation-D9Ej5fM", "ElevatedContainerElevation", "getElevatedContainerElevation-D9Ej5fM", "ElevatedDisabledContainerColor", "getElevatedDisabledContainerColor", "ElevatedDisabledContainerElevation", "getElevatedDisabledContainerElevation-D9Ej5fM", "ElevatedDisabledContainerOpacity", "getElevatedDisabledContainerOpacity", "ElevatedFocusContainerElevation", "getElevatedFocusContainerElevation-D9Ej5fM", "ElevatedHoverContainerElevation", "getElevatedHoverContainerElevation-D9Ej5fM", "ElevatedPressedContainerElevation", "getElevatedPressedContainerElevation-D9Ej5fM", "ElevatedSelectedContainerColor", "getElevatedSelectedContainerColor", "ElevatedUnselectedContainerColor", "getElevatedUnselectedContainerColor", "FlatContainerElevation", "getFlatContainerElevation-D9Ej5fM", "FlatDisabledSelectedContainerColor", "getFlatDisabledSelectedContainerColor", "FlatDisabledSelectedContainerOpacity", "getFlatDisabledSelectedContainerOpacity", "FlatDisabledUnselectedOutlineColor", "getFlatDisabledUnselectedOutlineColor", "FlatDisabledUnselectedOutlineOpacity", "getFlatDisabledUnselectedOutlineOpacity", "FlatSelectedContainerColor", "getFlatSelectedContainerColor", "FlatSelectedFocusContainerElevation", "getFlatSelectedFocusContainerElevation-D9Ej5fM", "FlatSelectedHoverContainerElevation", "getFlatSelectedHoverContainerElevation-D9Ej5fM", "FlatSelectedOutlineWidth", "getFlatSelectedOutlineWidth-D9Ej5fM", "FlatSelectedPressedContainerElevation", "getFlatSelectedPressedContainerElevation-D9Ej5fM", "FlatUnselectedFocusContainerElevation", "getFlatUnselectedFocusContainerElevation-D9Ej5fM", "FlatUnselectedFocusOutlineColor", "getFlatUnselectedFocusOutlineColor", "FlatUnselectedHoverContainerElevation", "getFlatUnselectedHoverContainerElevation-D9Ej5fM", "FlatUnselectedOutlineColor", "getFlatUnselectedOutlineColor", "FlatUnselectedOutlineWidth", "getFlatUnselectedOutlineWidth-D9Ej5fM", "FlatUnselectedPressedContainerElevation", "getFlatUnselectedPressedContainerElevation-D9Ej5fM", "FocusIndicatorColor", "getFocusIndicatorColor", "LabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "SelectedDraggedLabelTextColor", "getSelectedDraggedLabelTextColor", "SelectedFocusLabelTextColor", "getSelectedFocusLabelTextColor", "SelectedHoverLabelTextColor", "getSelectedHoverLabelTextColor", "SelectedLabelTextColor", "getSelectedLabelTextColor", "SelectedPressedLabelTextColor", "getSelectedPressedLabelTextColor", "UnselectedDraggedLabelTextColor", "getUnselectedDraggedLabelTextColor", "UnselectedFocusLabelTextColor", "getUnselectedFocusLabelTextColor", "UnselectedHoverLabelTextColor", "getUnselectedHoverLabelTextColor", "UnselectedLabelTextColor", "getUnselectedLabelTextColor", "UnselectedPressedLabelTextColor", "getUnselectedPressedLabelTextColor", "IconSize", "getIconSize-D9Ej5fM", "DisabledLeadingIconColor", "getDisabledLeadingIconColor", "DisabledLeadingIconOpacity", "getDisabledLeadingIconOpacity", "SelectedDraggedLeadingIconColor", "getSelectedDraggedLeadingIconColor", "SelectedFocusLeadingIconColor", "getSelectedFocusLeadingIconColor", "SelectedHoverLeadingIconColor", "getSelectedHoverLeadingIconColor", "SelectedLeadingIconColor", "getSelectedLeadingIconColor", "SelectedPressedLeadingIconColor", "getSelectedPressedLeadingIconColor", "UnselectedDraggedLeadingIconColor", "getUnselectedDraggedLeadingIconColor", "UnselectedFocusLeadingIconColor", "getUnselectedFocusLeadingIconColor", "UnselectedHoverLeadingIconColor", "getUnselectedHoverLeadingIconColor", "UnselectedLeadingIconColor", "getUnselectedLeadingIconColor", "UnselectedPressedLeadingIconColor", "getUnselectedPressedLeadingIconColor", "DisabledTrailingIconColor", "getDisabledTrailingIconColor", "DisabledTrailingIconOpacity", "getDisabledTrailingIconOpacity", "SelectedDraggedTrailingIconColor", "getSelectedDraggedTrailingIconColor", "SelectedFocusTrailingIconColor", "getSelectedFocusTrailingIconColor", "SelectedHoverTrailingIconColor", "getSelectedHoverTrailingIconColor", "SelectedPressedTrailingIconColor", "getSelectedPressedTrailingIconColor", "SelectedTrailingIconColor", "getSelectedTrailingIconColor", "UnselectedDraggedTrailingIconColor", "getUnselectedDraggedTrailingIconColor", "UnselectedFocusTrailingIconColor", "getUnselectedFocusTrailingIconColor", "UnselectedHoverTrailingIconColor", "getUnselectedHoverTrailingIconColor", "UnselectedPressedTrailingIconColor", "getUnselectedPressedTrailingIconColor", "UnselectedTrailingIconColor", "getUnselectedTrailingIconColor", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FilterChipTokens {
    public static final int $stable = 0;
    private static final float ContainerHeight = 0.0f;
    private static final ShapeKeyTokens ContainerShape = null;
    private static final ColorSchemeKeyTokens DisabledLabelTextColor = null;
    private static final float DisabledLabelTextOpacity = 0.0f;
    private static final ColorSchemeKeyTokens DisabledLeadingIconColor = null;
    private static final float DisabledLeadingIconOpacity = 0.0f;
    private static final ColorSchemeKeyTokens DisabledTrailingIconColor = null;
    private static final float DisabledTrailingIconOpacity = 0.0f;
    private static final float DraggedContainerElevation = 0.0f;
    private static final float ElevatedContainerElevation = 0.0f;
    private static final ColorSchemeKeyTokens ElevatedDisabledContainerColor = null;
    private static final float ElevatedDisabledContainerElevation = 0.0f;
    private static final float ElevatedDisabledContainerOpacity = 0.0f;
    private static final float ElevatedFocusContainerElevation = 0.0f;
    private static final float ElevatedHoverContainerElevation = 0.0f;
    private static final float ElevatedPressedContainerElevation = 0.0f;
    private static final ColorSchemeKeyTokens ElevatedSelectedContainerColor = null;
    private static final ColorSchemeKeyTokens ElevatedUnselectedContainerColor = null;
    private static final float FlatContainerElevation = 0.0f;
    private static final ColorSchemeKeyTokens FlatDisabledSelectedContainerColor = null;
    private static final float FlatDisabledSelectedContainerOpacity = 0.0f;
    private static final ColorSchemeKeyTokens FlatDisabledUnselectedOutlineColor = null;
    private static final float FlatDisabledUnselectedOutlineOpacity = 0.0f;
    private static final ColorSchemeKeyTokens FlatSelectedContainerColor = null;
    private static final float FlatSelectedFocusContainerElevation = 0.0f;
    private static final float FlatSelectedHoverContainerElevation = 0.0f;
    private static final float FlatSelectedOutlineWidth = 0.0f;
    private static final float FlatSelectedPressedContainerElevation = 0.0f;
    private static final float FlatUnselectedFocusContainerElevation = 0.0f;
    private static final ColorSchemeKeyTokens FlatUnselectedFocusOutlineColor = null;
    private static final float FlatUnselectedHoverContainerElevation = 0.0f;
    private static final ColorSchemeKeyTokens FlatUnselectedOutlineColor = null;
    private static final float FlatUnselectedOutlineWidth = 0.0f;
    private static final float FlatUnselectedPressedContainerElevation = 0.0f;
    private static final ColorSchemeKeyTokens FocusIndicatorColor = null;
    public static final FilterChipTokens INSTANCE = null;
    private static final float IconSize = 0.0f;
    private static final TypographyKeyTokens LabelTextFont = null;
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
    private static final ColorSchemeKeyTokens SelectedPressedLabelTextColor = null;
    private static final ColorSchemeKeyTokens SelectedPressedLeadingIconColor = null;
    private static final ColorSchemeKeyTokens SelectedPressedTrailingIconColor = null;
    private static final ColorSchemeKeyTokens SelectedTrailingIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedDraggedLabelTextColor = null;
    private static final ColorSchemeKeyTokens UnselectedDraggedLeadingIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedDraggedTrailingIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedFocusLabelTextColor = null;
    private static final ColorSchemeKeyTokens UnselectedFocusLeadingIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedFocusTrailingIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedHoverLabelTextColor = null;
    private static final ColorSchemeKeyTokens UnselectedHoverLeadingIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedHoverTrailingIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedLabelTextColor = null;
    private static final ColorSchemeKeyTokens UnselectedLeadingIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedPressedLabelTextColor = null;
    private static final ColorSchemeKeyTokens UnselectedPressedLeadingIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedPressedTrailingIconColor = null;
    private static final ColorSchemeKeyTokens UnselectedTrailingIconColor = null;

    private FilterChipTokens() {
    }

    static {
        INSTANCE = new FilterChipTokens();
        ContainerHeight = Dp.m7544constructorimpl((float) 32.0d);
        ContainerShape = ShapeKeyTokens.CornerSmall;
        ColorSchemeKeyTokens r100 = ColorSchemeKeyTokens.OnSurface;
        DisabledLabelTextColor = r100;
        DisabledLabelTextOpacity = 0.38f;
        ElevationTokens r101 = ElevationTokens.INSTANCE;
        DraggedContainerElevation = r101.m3502getLevel4D9Ej5fM();
        ElevatedContainerElevation = r101.m3499getLevel1D9Ej5fM();
        ElevatedDisabledContainerColor = r100;
        ElevatedDisabledContainerElevation = r101.m3498getLevel0D9Ej5fM();
        ElevatedDisabledContainerOpacity = 0.12f;
        ElevatedFocusContainerElevation = r101.m3499getLevel1D9Ej5fM();
        ElevatedHoverContainerElevation = r101.m3500getLevel2D9Ej5fM();
        ElevatedPressedContainerElevation = r101.m3499getLevel1D9Ej5fM();
        ColorSchemeKeyTokens r102 = ColorSchemeKeyTokens.SecondaryContainer;
        ElevatedSelectedContainerColor = r102;
        ElevatedUnselectedContainerColor = ColorSchemeKeyTokens.SurfaceContainerLow;
        FlatContainerElevation = r101.m3498getLevel0D9Ej5fM();
        FlatDisabledSelectedContainerColor = r100;
        FlatDisabledSelectedContainerOpacity = 0.12f;
        FlatDisabledUnselectedOutlineColor = r100;
        FlatDisabledUnselectedOutlineOpacity = 0.12f;
        FlatSelectedContainerColor = r102;
        FlatSelectedFocusContainerElevation = r101.m3498getLevel0D9Ej5fM();
        FlatSelectedHoverContainerElevation = r101.m3499getLevel1D9Ej5fM();
        FlatSelectedOutlineWidth = Dp.m7544constructorimpl((float) AudioStats.AUDIO_AMPLITUDE_NONE);
        FlatSelectedPressedContainerElevation = r101.m3498getLevel0D9Ej5fM();
        FlatUnselectedFocusContainerElevation = r101.m3498getLevel0D9Ej5fM();
        ColorSchemeKeyTokens r103 = ColorSchemeKeyTokens.OnSurfaceVariant;
        FlatUnselectedFocusOutlineColor = r103;
        FlatUnselectedHoverContainerElevation = r101.m3498getLevel0D9Ej5fM();
        FlatUnselectedOutlineColor = ColorSchemeKeyTokens.OutlineVariant;
        FlatUnselectedOutlineWidth = Dp.m7544constructorimpl((float) 1.0d);
        FlatUnselectedPressedContainerElevation = r101.m3498getLevel0D9Ej5fM();
        FocusIndicatorColor = ColorSchemeKeyTokens.Secondary;
        LabelTextFont = TypographyKeyTokens.LabelLarge;
        ColorSchemeKeyTokens r104 = ColorSchemeKeyTokens.OnSecondaryContainer;
        SelectedDraggedLabelTextColor = r104;
        SelectedFocusLabelTextColor = r104;
        SelectedHoverLabelTextColor = r104;
        SelectedLabelTextColor = r104;
        SelectedPressedLabelTextColor = r104;
        UnselectedDraggedLabelTextColor = r103;
        UnselectedFocusLabelTextColor = r103;
        UnselectedHoverLabelTextColor = r103;
        UnselectedLabelTextColor = r103;
        UnselectedPressedLabelTextColor = r103;
        IconSize = Dp.m7544constructorimpl((float) 18.0d);
        DisabledLeadingIconColor = r100;
        DisabledLeadingIconOpacity = 0.38f;
        SelectedDraggedLeadingIconColor = r104;
        SelectedFocusLeadingIconColor = r104;
        SelectedHoverLeadingIconColor = r104;
        SelectedLeadingIconColor = r104;
        SelectedPressedLeadingIconColor = r104;
        ColorSchemeKeyTokens r105 = ColorSchemeKeyTokens.Primary;
        UnselectedDraggedLeadingIconColor = r105;
        UnselectedFocusLeadingIconColor = r105;
        UnselectedHoverLeadingIconColor = r105;
        UnselectedLeadingIconColor = r105;
        UnselectedPressedLeadingIconColor = r105;
        DisabledTrailingIconColor = r100;
        DisabledTrailingIconOpacity = 0.38f;
        SelectedDraggedTrailingIconColor = r104;
        SelectedFocusTrailingIconColor = r104;
        SelectedHoverTrailingIconColor = r104;
        SelectedPressedTrailingIconColor = r104;
        SelectedTrailingIconColor = r104;
        UnselectedDraggedTrailingIconColor = r103;
        UnselectedFocusTrailingIconColor = r103;
        UnselectedHoverTrailingIconColor = r103;
        UnselectedPressedTrailingIconColor = r103;
        UnselectedTrailingIconColor = r103;
    }

    /* JADX INFO: renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3593getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
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

    public final ColorSchemeKeyTokens getDisabledTrailingIconColor() {
        return DisabledTrailingIconColor;
    }

    public final float getDisabledTrailingIconOpacity() {
        return DisabledTrailingIconOpacity;
    }

    /* JADX INFO: renamed from: getDraggedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3594getDraggedContainerElevationD9Ej5fM() {
        return DraggedContainerElevation;
    }

    /* JADX INFO: renamed from: getElevatedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3595getElevatedContainerElevationD9Ej5fM() {
        return ElevatedContainerElevation;
    }

    public final ColorSchemeKeyTokens getElevatedDisabledContainerColor() {
        return ElevatedDisabledContainerColor;
    }

    /* JADX INFO: renamed from: getElevatedDisabledContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3596getElevatedDisabledContainerElevationD9Ej5fM() {
        return ElevatedDisabledContainerElevation;
    }

    public final float getElevatedDisabledContainerOpacity() {
        return ElevatedDisabledContainerOpacity;
    }

    /* JADX INFO: renamed from: getElevatedFocusContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3597getElevatedFocusContainerElevationD9Ej5fM() {
        return ElevatedFocusContainerElevation;
    }

    /* JADX INFO: renamed from: getElevatedHoverContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3598getElevatedHoverContainerElevationD9Ej5fM() {
        return ElevatedHoverContainerElevation;
    }

    /* JADX INFO: renamed from: getElevatedPressedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3599getElevatedPressedContainerElevationD9Ej5fM() {
        return ElevatedPressedContainerElevation;
    }

    public final ColorSchemeKeyTokens getElevatedSelectedContainerColor() {
        return ElevatedSelectedContainerColor;
    }

    public final ColorSchemeKeyTokens getElevatedUnselectedContainerColor() {
        return ElevatedUnselectedContainerColor;
    }

    /* JADX INFO: renamed from: getFlatContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3600getFlatContainerElevationD9Ej5fM() {
        return FlatContainerElevation;
    }

    public final ColorSchemeKeyTokens getFlatDisabledSelectedContainerColor() {
        return FlatDisabledSelectedContainerColor;
    }

    public final float getFlatDisabledSelectedContainerOpacity() {
        return FlatDisabledSelectedContainerOpacity;
    }

    public final ColorSchemeKeyTokens getFlatDisabledUnselectedOutlineColor() {
        return FlatDisabledUnselectedOutlineColor;
    }

    public final float getFlatDisabledUnselectedOutlineOpacity() {
        return FlatDisabledUnselectedOutlineOpacity;
    }

    public final ColorSchemeKeyTokens getFlatSelectedContainerColor() {
        return FlatSelectedContainerColor;
    }

    /* JADX INFO: renamed from: getFlatSelectedFocusContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3601getFlatSelectedFocusContainerElevationD9Ej5fM() {
        return FlatSelectedFocusContainerElevation;
    }

    /* JADX INFO: renamed from: getFlatSelectedHoverContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3602getFlatSelectedHoverContainerElevationD9Ej5fM() {
        return FlatSelectedHoverContainerElevation;
    }

    /* JADX INFO: renamed from: getFlatSelectedOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m3603getFlatSelectedOutlineWidthD9Ej5fM() {
        return FlatSelectedOutlineWidth;
    }

    /* JADX INFO: renamed from: getFlatSelectedPressedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3604getFlatSelectedPressedContainerElevationD9Ej5fM() {
        return FlatSelectedPressedContainerElevation;
    }

    /* JADX INFO: renamed from: getFlatUnselectedFocusContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3605getFlatUnselectedFocusContainerElevationD9Ej5fM() {
        return FlatUnselectedFocusContainerElevation;
    }

    public final ColorSchemeKeyTokens getFlatUnselectedFocusOutlineColor() {
        return FlatUnselectedFocusOutlineColor;
    }

    /* JADX INFO: renamed from: getFlatUnselectedHoverContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3606getFlatUnselectedHoverContainerElevationD9Ej5fM() {
        return FlatUnselectedHoverContainerElevation;
    }

    public final ColorSchemeKeyTokens getFlatUnselectedOutlineColor() {
        return FlatUnselectedOutlineColor;
    }

    /* JADX INFO: renamed from: getFlatUnselectedOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m3607getFlatUnselectedOutlineWidthD9Ej5fM() {
        return FlatUnselectedOutlineWidth;
    }

    /* JADX INFO: renamed from: getFlatUnselectedPressedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3608getFlatUnselectedPressedContainerElevationD9Ej5fM() {
        return FlatUnselectedPressedContainerElevation;
    }

    public final ColorSchemeKeyTokens getFocusIndicatorColor() {
        return FocusIndicatorColor;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3609getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final TypographyKeyTokens getLabelTextFont() {
        return LabelTextFont;
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
