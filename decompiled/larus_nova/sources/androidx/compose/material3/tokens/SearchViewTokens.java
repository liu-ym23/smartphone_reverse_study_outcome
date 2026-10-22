package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0014\u0010\u000bR\u0011\u0010\u0015\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\u0017\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0018\u0010\u000bR\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0007R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0007R\u0011\u0010!\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0007R\u0011\u0010#\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010%\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0007¨\u0006'"}, d2 = {"Landroidx/compose/material3/tokens/SearchViewTokens;", "", "<init>", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", FaceService.girlLabel, "DividerColor", "getDividerColor", "DockedContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getDockedContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "DockedHeaderContainerHeight", "getDockedHeaderContainerHeight-D9Ej5fM", "FullScreenContainerShape", "getFullScreenContainerShape", "FullScreenHeaderContainerHeight", "getFullScreenHeaderContainerHeight-D9Ej5fM", "HeaderInputTextColor", "getHeaderInputTextColor", "HeaderInputTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getHeaderInputTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "HeaderLeadingIconColor", "getHeaderLeadingIconColor", "HeaderSupportingTextColor", "getHeaderSupportingTextColor", "HeaderSupportingTextFont", "getHeaderSupportingTextFont", "HeaderTrailingIconColor", "getHeaderTrailingIconColor", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SearchViewTokens {
    public static final int $stable = 0;
    private static final ColorSchemeKeyTokens ContainerColor = null;
    private static final float ContainerElevation = 0.0f;
    private static final ColorSchemeKeyTokens DividerColor = null;
    private static final ShapeKeyTokens DockedContainerShape = null;
    private static final float DockedHeaderContainerHeight = 0.0f;
    private static final ShapeKeyTokens FullScreenContainerShape = null;
    private static final float FullScreenHeaderContainerHeight = 0.0f;
    private static final ColorSchemeKeyTokens HeaderInputTextColor = null;
    private static final TypographyKeyTokens HeaderInputTextFont = null;
    private static final ColorSchemeKeyTokens HeaderLeadingIconColor = null;
    private static final ColorSchemeKeyTokens HeaderSupportingTextColor = null;
    private static final TypographyKeyTokens HeaderSupportingTextFont = null;
    private static final ColorSchemeKeyTokens HeaderTrailingIconColor = null;
    public static final SearchViewTokens INSTANCE = null;

    private SearchViewTokens() {
    }

    static {
        INSTANCE = new SearchViewTokens();
        ContainerColor = ColorSchemeKeyTokens.SurfaceContainerHigh;
        ContainerElevation = ElevationTokens.INSTANCE.m3501getLevel3D9Ej5fM();
        DividerColor = ColorSchemeKeyTokens.Outline;
        DockedContainerShape = ShapeKeyTokens.CornerExtraLarge;
        DockedHeaderContainerHeight = Dp.m7544constructorimpl((float) 56.0d);
        FullScreenContainerShape = ShapeKeyTokens.CornerNone;
        FullScreenHeaderContainerHeight = Dp.m7544constructorimpl((float) 72.0d);
        ColorSchemeKeyTokens r100 = ColorSchemeKeyTokens.OnSurface;
        HeaderInputTextColor = r100;
        TypographyKeyTokens r101 = TypographyKeyTokens.BodyLarge;
        HeaderInputTextFont = r101;
        HeaderLeadingIconColor = r100;
        ColorSchemeKeyTokens r102 = ColorSchemeKeyTokens.OnSurfaceVariant;
        HeaderSupportingTextColor = r102;
        HeaderSupportingTextFont = r101;
        HeaderTrailingIconColor = r102;
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    /* JADX INFO: renamed from: getContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3845getContainerElevationD9Ej5fM() {
        return ContainerElevation;
    }

    public final ColorSchemeKeyTokens getDividerColor() {
        return DividerColor;
    }

    public final ShapeKeyTokens getDockedContainerShape() {
        return DockedContainerShape;
    }

    /* JADX INFO: renamed from: getDockedHeaderContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3846getDockedHeaderContainerHeightD9Ej5fM() {
        return DockedHeaderContainerHeight;
    }

    public final ShapeKeyTokens getFullScreenContainerShape() {
        return FullScreenContainerShape;
    }

    /* JADX INFO: renamed from: getFullScreenHeaderContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3847getFullScreenHeaderContainerHeightD9Ej5fM() {
        return FullScreenHeaderContainerHeight;
    }

    public final ColorSchemeKeyTokens getHeaderInputTextColor() {
        return HeaderInputTextColor;
    }

    public final TypographyKeyTokens getHeaderInputTextFont() {
        return HeaderInputTextFont;
    }

    public final ColorSchemeKeyTokens getHeaderLeadingIconColor() {
        return HeaderLeadingIconColor;
    }

    public final ColorSchemeKeyTokens getHeaderSupportingTextColor() {
        return HeaderSupportingTextColor;
    }

    public final TypographyKeyTokens getHeaderSupportingTextFont() {
        return HeaderSupportingTextFont;
    }

    public final ColorSchemeKeyTokens getHeaderTrailingIconColor() {
        return HeaderTrailingIconColor;
    }
}
