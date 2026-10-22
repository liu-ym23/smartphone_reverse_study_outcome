package androidx.compose.material3.tokens;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000bR\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0018\u0010\u000bR\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/tokens/FabPrimaryContainerTokens;", "", "<init>", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", FaceService.girlLabel, "FocusedContainerElevation", "getFocusedContainerElevation-D9Ej5fM", "FocusedIconColor", "getFocusedIconColor", "HoveredContainerElevation", "getHoveredContainerElevation-D9Ej5fM", "HoveredIconColor", "getHoveredIconColor", "IconColor", "getIconColor", "PressedContainerElevation", "getPressedContainerElevation-D9Ej5fM", "PressedIconColor", "getPressedIconColor", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FabPrimaryContainerTokens {
    public static final int $stable = 0;
    private static final ColorSchemeKeyTokens ContainerColor = null;
    private static final float ContainerElevation = 0.0f;
    private static final float FocusedContainerElevation = 0.0f;
    private static final ColorSchemeKeyTokens FocusedIconColor = null;
    private static final float HoveredContainerElevation = 0.0f;
    private static final ColorSchemeKeyTokens HoveredIconColor = null;
    public static final FabPrimaryContainerTokens INSTANCE = null;
    private static final ColorSchemeKeyTokens IconColor = null;
    private static final float PressedContainerElevation = 0.0f;
    private static final ColorSchemeKeyTokens PressedIconColor = null;

    private FabPrimaryContainerTokens() {
    }

    static {
        INSTANCE = new FabPrimaryContainerTokens();
        ContainerColor = ColorSchemeKeyTokens.PrimaryContainer;
        ElevationTokens r100 = ElevationTokens.INSTANCE;
        ContainerElevation = r100.m3501getLevel3D9Ej5fM();
        FocusedContainerElevation = r100.m3501getLevel3D9Ej5fM();
        ColorSchemeKeyTokens r101 = ColorSchemeKeyTokens.OnPrimaryContainer;
        FocusedIconColor = r101;
        HoveredContainerElevation = r100.m3502getLevel4D9Ej5fM();
        HoveredIconColor = r101;
        IconColor = r101;
        PressedContainerElevation = r100.m3501getLevel3D9Ej5fM();
        PressedIconColor = r101;
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    /* JADX INFO: renamed from: getContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3550getContainerElevationD9Ej5fM() {
        return ContainerElevation;
    }

    /* JADX INFO: renamed from: getFocusedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3551getFocusedContainerElevationD9Ej5fM() {
        return FocusedContainerElevation;
    }

    public final ColorSchemeKeyTokens getFocusedIconColor() {
        return FocusedIconColor;
    }

    /* JADX INFO: renamed from: getHoveredContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3552getHoveredContainerElevationD9Ej5fM() {
        return HoveredContainerElevation;
    }

    public final ColorSchemeKeyTokens getHoveredIconColor() {
        return HoveredIconColor;
    }

    public final ColorSchemeKeyTokens getIconColor() {
        return IconColor;
    }

    /* JADX INFO: renamed from: getPressedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3553getPressedContainerElevationD9Ej5fM() {
        return PressedContainerElevation;
    }

    public final ColorSchemeKeyTokens getPressedIconColor() {
        return PressedIconColor;
    }
}
