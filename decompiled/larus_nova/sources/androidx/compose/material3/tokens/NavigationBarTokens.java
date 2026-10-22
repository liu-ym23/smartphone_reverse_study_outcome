package androidx.compose.material3.tokens;

import androidx.camera.video.AudioStats;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0014\u0010\u000bR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0007R\u0013\u0010\u001b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001c\u0010\u000bR\u0011\u0010\u001d\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0007R\u0011\u0010\u001f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0007R\u0011\u0010!\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0013\u0010#\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b$\u0010\u000bR\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Landroidx/compose/material3/tokens/NavigationBarTokens;", "", "<init>", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", FaceService.girlLabel, "ContainerHeight", "getContainerHeight-D9Ej5fM", "ItemActiveIconColor", "getItemActiveIconColor", "ItemActiveIndicatorColor", "getItemActiveIndicatorColor", "ItemActiveIndicatorIconLabelSpace", "getItemActiveIndicatorIconLabelSpace-D9Ej5fM", "ItemActiveIndicatorShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getItemActiveIndicatorShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ItemActiveLabelTextColor", "getItemActiveLabelTextColor", "ItemBetweenSpace", "getItemBetweenSpace-D9Ej5fM", "ItemInactiveIconColor", "getItemInactiveIconColor", "ItemInactiveLabelTextColor", "getItemInactiveLabelTextColor", "NavShape", "getNavShape", "TallContainerHeight", "getTallContainerHeight-D9Ej5fM", "LabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NavigationBarTokens {
    public static final int $stable = 0;
    private static final ColorSchemeKeyTokens ContainerColor = null;
    private static final float ContainerElevation = 0.0f;
    private static final float ContainerHeight = 0.0f;
    public static final NavigationBarTokens INSTANCE = null;
    private static final ColorSchemeKeyTokens ItemActiveIconColor = null;
    private static final ColorSchemeKeyTokens ItemActiveIndicatorColor = null;
    private static final float ItemActiveIndicatorIconLabelSpace = 0.0f;
    private static final ShapeKeyTokens ItemActiveIndicatorShape = null;
    private static final ColorSchemeKeyTokens ItemActiveLabelTextColor = null;
    private static final float ItemBetweenSpace = 0.0f;
    private static final ColorSchemeKeyTokens ItemInactiveIconColor = null;
    private static final ColorSchemeKeyTokens ItemInactiveLabelTextColor = null;
    private static final TypographyKeyTokens LabelTextFont = null;
    private static final ShapeKeyTokens NavShape = null;
    private static final float TallContainerHeight = 0.0f;

    private NavigationBarTokens() {
    }

    static {
        INSTANCE = new NavigationBarTokens();
        ContainerColor = ColorSchemeKeyTokens.SurfaceContainer;
        ContainerElevation = ElevationTokens.INSTANCE.m3500getLevel2D9Ej5fM();
        ContainerHeight = Dp.m7544constructorimpl((float) 64.0d);
        ItemActiveIconColor = ColorSchemeKeyTokens.OnSecondaryContainer;
        ItemActiveIndicatorColor = ColorSchemeKeyTokens.SecondaryContainer;
        ItemActiveIndicatorIconLabelSpace = Dp.m7544constructorimpl((float) 4.0d);
        ItemActiveIndicatorShape = ShapeKeyTokens.CornerFull;
        ItemActiveLabelTextColor = ColorSchemeKeyTokens.Secondary;
        ItemBetweenSpace = Dp.m7544constructorimpl((float) AudioStats.AUDIO_AMPLITUDE_NONE);
        ColorSchemeKeyTokens r100 = ColorSchemeKeyTokens.OnSurfaceVariant;
        ItemInactiveIconColor = r100;
        ItemInactiveLabelTextColor = r100;
        NavShape = ShapeKeyTokens.CornerNone;
        TallContainerHeight = Dp.m7544constructorimpl((float) 80.0d);
        LabelTextFont = TypographyKeyTokens.LabelMedium;
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    /* JADX INFO: renamed from: getContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3676getContainerElevationD9Ej5fM() {
        return ContainerElevation;
    }

    /* JADX INFO: renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3677getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    public final ColorSchemeKeyTokens getItemActiveIconColor() {
        return ItemActiveIconColor;
    }

    public final ColorSchemeKeyTokens getItemActiveIndicatorColor() {
        return ItemActiveIndicatorColor;
    }

    /* JADX INFO: renamed from: getItemActiveIndicatorIconLabelSpace-D9Ej5fM, reason: not valid java name */
    public final float m3678getItemActiveIndicatorIconLabelSpaceD9Ej5fM() {
        return ItemActiveIndicatorIconLabelSpace;
    }

    public final ShapeKeyTokens getItemActiveIndicatorShape() {
        return ItemActiveIndicatorShape;
    }

    public final ColorSchemeKeyTokens getItemActiveLabelTextColor() {
        return ItemActiveLabelTextColor;
    }

    /* JADX INFO: renamed from: getItemBetweenSpace-D9Ej5fM, reason: not valid java name */
    public final float m3679getItemBetweenSpaceD9Ej5fM() {
        return ItemBetweenSpace;
    }

    public final ColorSchemeKeyTokens getItemInactiveIconColor() {
        return ItemInactiveIconColor;
    }

    public final ColorSchemeKeyTokens getItemInactiveLabelTextColor() {
        return ItemInactiveLabelTextColor;
    }

    public final TypographyKeyTokens getLabelTextFont() {
        return LabelTextFont;
    }

    public final ShapeKeyTokens getNavShape() {
        return NavShape;
    }

    /* JADX INFO: renamed from: getTallContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3680getTallContainerHeightD9Ej5fM() {
        return TallContainerHeight;
    }
}
