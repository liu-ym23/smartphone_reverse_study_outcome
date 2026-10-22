package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0010\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\u0016X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0013\u0010\u0018\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0019\u0010\u000bR\u0013\u0010\u001a\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001b\u0010\u000bR\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0013\u0010\u001e\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001f\u0010\u000bR\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0013\u0010\"\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b#\u0010\u000bR\u0013\u0010$\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b%\u0010\u000b¨\u0006&"}, d2 = {"Landroidx/compose/material3/tokens/FilledCardTokens;", "", "<init>", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", FaceService.girlLabel, "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "DisabledContainerColor", "getDisabledContainerColor", "DisabledContainerElevation", "getDisabledContainerElevation-D9Ej5fM", "DisabledContainerOpacity", "", "getDisabledContainerOpacity", "DraggedContainerElevation", "getDraggedContainerElevation-D9Ej5fM", "FocusContainerElevation", "getFocusContainerElevation-D9Ej5fM", "FocusIndicatorColor", "getFocusIndicatorColor", "HoverContainerElevation", "getHoverContainerElevation-D9Ej5fM", "IconColor", "getIconColor", "IconSize", "getIconSize-D9Ej5fM", "PressedContainerElevation", "getPressedContainerElevation-D9Ej5fM", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FilledCardTokens {
    public static final int $stable = 0;
    private static final ColorSchemeKeyTokens ContainerColor = null;
    private static final float ContainerElevation = 0.0f;
    private static final ShapeKeyTokens ContainerShape = null;
    private static final ColorSchemeKeyTokens DisabledContainerColor = null;
    private static final float DisabledContainerElevation = 0.0f;
    private static final float DisabledContainerOpacity = 0.0f;
    private static final float DraggedContainerElevation = 0.0f;
    private static final float FocusContainerElevation = 0.0f;
    private static final ColorSchemeKeyTokens FocusIndicatorColor = null;
    private static final float HoverContainerElevation = 0.0f;
    public static final FilledCardTokens INSTANCE = null;
    private static final ColorSchemeKeyTokens IconColor = null;
    private static final float IconSize = 0.0f;
    private static final float PressedContainerElevation = 0.0f;

    private FilledCardTokens() {
    }

    static {
        INSTANCE = new FilledCardTokens();
        ContainerColor = ColorSchemeKeyTokens.SurfaceContainerHighest;
        ElevationTokens r100 = ElevationTokens.INSTANCE;
        ContainerElevation = r100.m3498getLevel0D9Ej5fM();
        ContainerShape = ShapeKeyTokens.CornerMedium;
        DisabledContainerColor = ColorSchemeKeyTokens.SurfaceVariant;
        DisabledContainerElevation = r100.m3498getLevel0D9Ej5fM();
        DisabledContainerOpacity = 0.38f;
        DraggedContainerElevation = r100.m3501getLevel3D9Ej5fM();
        FocusContainerElevation = r100.m3498getLevel0D9Ej5fM();
        FocusIndicatorColor = ColorSchemeKeyTokens.Secondary;
        HoverContainerElevation = r100.m3499getLevel1D9Ej5fM();
        IconColor = ColorSchemeKeyTokens.Primary;
        IconSize = Dp.m7544constructorimpl((float) 24.0d);
        PressedContainerElevation = r100.m3498getLevel0D9Ej5fM();
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    /* JADX INFO: renamed from: getContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3573getContainerElevationD9Ej5fM() {
        return ContainerElevation;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    public final ColorSchemeKeyTokens getDisabledContainerColor() {
        return DisabledContainerColor;
    }

    /* JADX INFO: renamed from: getDisabledContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3574getDisabledContainerElevationD9Ej5fM() {
        return DisabledContainerElevation;
    }

    public final float getDisabledContainerOpacity() {
        return DisabledContainerOpacity;
    }

    /* JADX INFO: renamed from: getDraggedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3575getDraggedContainerElevationD9Ej5fM() {
        return DraggedContainerElevation;
    }

    /* JADX INFO: renamed from: getFocusContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3576getFocusContainerElevationD9Ej5fM() {
        return FocusContainerElevation;
    }

    public final ColorSchemeKeyTokens getFocusIndicatorColor() {
        return FocusIndicatorColor;
    }

    /* JADX INFO: renamed from: getHoverContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3577getHoverContainerElevationD9Ej5fM() {
        return HoverContainerElevation;
    }

    public final ColorSchemeKeyTokens getIconColor() {
        return IconColor;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3578getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* JADX INFO: renamed from: getPressedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3579getPressedContainerElevationD9Ej5fM() {
        return PressedContainerElevation;
    }
}
